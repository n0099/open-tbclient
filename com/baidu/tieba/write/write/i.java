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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private com.baidu.tbadk.core.util.b.a bkZ;
    private StickerModel hAO;
    private ForumWriteData hkj;
    private h hyt;
    private com.baidu.tbadk.core.dialog.a hyu;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hAM = null;
    private int hAN = 0;
    private int hAP = 0;
    private WriteImagesInfo hAQ = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hAR = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hyt = hVar;
        initData(bundle);
        initListener();
        bHo();
    }

    public void bHo() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.jE()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), f.j.neterror);
                    return;
                }
                return;
            }
            if (this.hAO == null) {
                this.hAO = new StickerModel(this.mPageContext);
            }
            this.hAO.LoadData();
            this.hAO.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dU(List<String> list) {
        if (this.hyt != null) {
            this.hyt.dT(list);
        }
    }

    private void initListener() {
        if (this.hyt != null) {
            if (this.hyt.hAF != null) {
                this.hyt.hAF.u(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.hAM.H(Integer.parseInt(view.getTag().toString()), i.this.bHq());
                        }
                    }
                });
            }
            if (this.hyt.hAI != null) {
                this.hyt.hAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.bkZ == null) {
                                i.this.bkZ = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.bkZ.zW();
                            i.this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.bkZ.u(pageActivity)) {
                                i.this.hAM.nz(false);
                                if (i.this.hyt != null) {
                                    if (i.this.hAQ == null || i.this.hAQ.getChosedFiles() == null || i.this.hAQ.getChosedFiles().size() <= 0 || !i.this.hAQ.isOriginalImg() || i.this.hAP <= 0 || !i.this.bIs()) {
                                        i.this.hyt.b(true, i.this.hAQ);
                                    } else {
                                        i.this.hyt.bIp();
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
            this.hAN = bundle.getInt("OutState_Write_Entrance");
            this.hkj = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hAN = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hkj = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hAQ = new WriteImagesInfo();
            this.hAQ.parseJson(str);
            bIq();
            if (this.hyt != null && this.hyt.hAG != null) {
                this.hAM = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hyt.hAG, this.hAQ.getChosedFiles(), i, this, this.hyt, this.hAQ.mIsFromIm);
                this.hyt.hAG.setAdapter(this.hAM);
                this.hyt.hAG.setCurrentItem(i, true);
                if (i == 0) {
                    this.hAM.onPageSelected(0);
                }
                this.hyt.d(this.hAQ);
            }
        }
    }

    private void bIq() {
        if (this.hAQ != null && this.hAQ.isOriginalImg() && this.hAQ.getChosedFiles() != null && this.hAQ.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hAQ.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hAR.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bIr() {
        return this.hAN;
    }

    public ForumWriteData auF() {
        return this.hkj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIs() {
        if (this.hAQ == null || !this.hAQ.isOriginalImg() || this.hAQ.getChosedFiles() == null || this.hAQ.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hAQ.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hAR.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bHp() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bHq() {
        return (this.hyt == null || this.hyt.hAH == null || w.z(this.hyt.hAH.getStickerViews())) ? false : true;
    }

    public void bIo() {
        this.hAP++;
    }

    public void bIt() {
        this.hAP--;
    }

    public WriteImagesInfo bIu() {
        return this.hAQ;
    }

    public void nE(boolean z) {
        if (bHq()) {
            this.hyt.hAG.setmDisallowSlip(true);
        } else {
            this.hyt.hAG.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bHn() {
        bIt();
        nE(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void I(int i, boolean z) {
        K(i, z);
    }

    private void K(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hyu == null) {
                this.hyu = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hyu.cf(f.j.orginal_tip);
                this.hyu.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hyu != null) {
                            i.this.hyu.dismiss();
                        }
                        if (i.this.hAM != null) {
                            i.this.hAM.H(i, z);
                        }
                    }
                });
                this.hyu.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hyu != null) {
                            i.this.hyu.dismiss();
                        }
                    }
                });
                this.hyu.b(this.mPageContext);
            }
            this.hyu.xe();
        }
    }

    public boolean H(final Bitmap bitmap) {
        if (!this.hAM.bHk() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hyu == null) {
            this.hyu = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hyu.cf(f.j.orginal_tip);
            this.hyu.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hyu != null) {
                        i.this.hyu.dismiss();
                    }
                    i.this.hyt.G(bitmap);
                }
            });
            this.hyu.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hyu != null) {
                        i.this.hyu.dismiss();
                    }
                }
            });
            this.hyu.b(this.mPageContext);
        }
        this.hyu.xe();
        return true;
    }

    public void destroy() {
        if (this.hAO != null) {
            this.hAO.destroy();
        }
    }
}
