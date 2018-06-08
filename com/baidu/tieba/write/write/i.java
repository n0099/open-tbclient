package com.baidu.tieba.write.write;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private com.baidu.tbadk.core.util.b.a biP;
    private ForumWriteData heN;
    private h htb;
    private com.baidu.tbadk.core.dialog.a htc;
    private StickerModel hvv;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hvt = null;
    private int hvu = 0;
    private int hvw = 0;
    private WriteImagesInfo hvx = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hvy = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.htb = hVar;
        initData(bundle);
        initListener();
        bHX();
    }

    public void bHX() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.jD()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.k.neterror);
                    return;
                }
                return;
            }
            if (this.hvv == null) {
                this.hvv = new StickerModel(this.mPageContext);
            }
            this.hvv.LoadData();
            this.hvv.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dV(List<String> list) {
        if (this.htb != null) {
            this.htb.dU(list);
        }
    }

    private void initListener() {
        if (this.htb != null) {
            if (this.htb.hvm != null) {
                this.htb.hvm.t(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.hvt.I(Integer.parseInt(view.getTag().toString()), i.this.bHZ());
                        }
                    }
                });
            }
            if (this.htb.hvp != null) {
                this.htb.hvp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.biP == null) {
                                i.this.biP = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.biP.zU();
                            i.this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.biP.u(pageActivity)) {
                                i.this.hvt.nD(false);
                                if (i.this.htb != null) {
                                    if (i.this.hvx == null || i.this.hvx.getChosedFiles() == null || i.this.hvx.getChosedFiles().size() <= 0 || !i.this.hvx.isOriginalImg() || i.this.hvw <= 0 || !i.this.bJa()) {
                                        i.this.htb.b(true, i.this.hvx);
                                    } else {
                                        i.this.htb.bIX();
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private void initData(Bundle bundle) {
        int i;
        Intent intent;
        String str = null;
        if (bundle != null) {
            String string = bundle.getString("OutState_Write_Img_Info");
            i = bundle.getInt("OutState_Current_Index");
            this.hvu = bundle.getInt("OutState_Write_Entrance");
            this.heN = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hvu = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.heN = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hvx = new WriteImagesInfo();
            this.hvx.parseJson(str);
            bIY();
            if (this.htb != null && this.htb.hvn != null) {
                this.hvt = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.htb.hvn, this.hvx.getChosedFiles(), i, this, this.htb, this.hvx.mIsFromIm);
                this.htb.hvn.setAdapter(this.hvt);
                this.htb.hvn.setCurrentItem(i, true);
                if (i == 0) {
                    this.hvt.onPageSelected(0);
                }
                this.htb.d(this.hvx);
            }
        }
    }

    private void bIY() {
        if (this.hvx != null && this.hvx.isOriginalImg() && this.hvx.getChosedFiles() != null && this.hvx.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hvx.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hvy.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bIZ() {
        return this.hvu;
    }

    public ForumWriteData atL() {
        return this.heN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJa() {
        if (this.hvx == null || !this.hvx.isOriginalImg() || this.hvx.getChosedFiles() == null || this.hvx.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hvx.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hvy.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bHY() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bHZ() {
        return (this.htb == null || this.htb.hvo == null || w.z(this.htb.hvo.getStickerViews())) ? false : true;
    }

    public void bIW() {
        this.hvw++;
    }

    public void bJb() {
        this.hvw--;
    }

    public WriteImagesInfo bJc() {
        return this.hvx;
    }

    public void nJ(boolean z) {
        if (bHZ()) {
            this.htb.hvn.setmDisallowSlip(true);
        } else {
            this.htb.hvn.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bHW() {
        bJb();
        nJ(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.htc == null) {
                this.htc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.htc.cc(d.k.orginal_tip);
                this.htc.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.htc != null) {
                            i.this.htc.dismiss();
                        }
                        if (i.this.hvt != null) {
                            i.this.hvt.I(i, z);
                        }
                    }
                });
                this.htc.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.htc != null) {
                            i.this.htc.dismiss();
                        }
                    }
                });
                this.htc.b(this.mPageContext);
            }
            this.htc.xa();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.hvt.bHT() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.htc == null) {
            this.htc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.htc.cc(d.k.orginal_tip);
            this.htc.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.htc != null) {
                        i.this.htc.dismiss();
                    }
                    i.this.htb.H(bitmap);
                }
            });
            this.htc.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.htc != null) {
                        i.this.htc.dismiss();
                    }
                }
            });
            this.htc.b(this.mPageContext);
        }
        this.htc.xa();
        return true;
    }

    public void destroy() {
        if (this.hvv != null) {
            this.hvv.destroy();
        }
    }
}
