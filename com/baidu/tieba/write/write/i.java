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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private com.baidu.tbadk.core.util.b.a buX;
    private h hOc;
    private com.baidu.tbadk.core.dialog.a hOd;
    private StickerModel hQx;
    private ForumWriteData hzl;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hQv = null;
    private int hQw = 0;
    private int hQy = 0;
    private WriteImagesInfo hQz = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hQA = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hOc = hVar;
        initData(bundle);
        initListener();
        bNr();
    }

    public void bNr() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kX()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), e.j.neterror);
                    return;
                }
                return;
            }
            if (this.hQx == null) {
                this.hQx = new StickerModel(this.mPageContext);
            }
            this.hQx.LoadData();
            this.hQx.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void ej(List<String> list) {
        if (this.hOc != null) {
            this.hOc.ei(list);
        }
    }

    private void initListener() {
        if (this.hOc != null) {
            if (this.hOc.hQo != null) {
                this.hOc.hQo.u(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.hQv.I(Integer.parseInt(view.getTag().toString()), i.this.bNt());
                        }
                    }
                });
            }
            if (this.hOc.hQr != null) {
                this.hOc.hQr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.buX == null) {
                                i.this.buX = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.buX.Di();
                            i.this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.buX.z(pageActivity)) {
                                i.this.hQv.om(false);
                                if (i.this.hOc != null) {
                                    if (i.this.hQz == null || i.this.hQz.getChosedFiles() == null || i.this.hQz.getChosedFiles().size() <= 0 || !i.this.hQz.isOriginalImg() || i.this.hQy <= 0 || !i.this.bOu()) {
                                        i.this.hOc.b(true, i.this.hQz);
                                    } else {
                                        i.this.hOc.bOr();
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
            this.hQw = bundle.getInt("OutState_Write_Entrance");
            this.hzl = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hQw = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hzl = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hQz = new WriteImagesInfo();
            this.hQz.parseJson(str);
            bOs();
            if (this.hOc != null && this.hOc.hQp != null) {
                this.hQv = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hOc.hQp, this.hQz.getChosedFiles(), i, this, this.hOc, this.hQz.mIsFromIm);
                this.hOc.hQp.setAdapter(this.hQv);
                this.hOc.hQp.setCurrentItem(i, true);
                if (i == 0) {
                    this.hQv.onPageSelected(0);
                }
                this.hOc.d(this.hQz);
            }
        }
    }

    private void bOs() {
        if (this.hQz != null && this.hQz.isOriginalImg() && this.hQz.getChosedFiles() != null && this.hQz.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hQz.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hQA.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bOt() {
        return this.hQw;
    }

    public ForumWriteData azU() {
        return this.hzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOu() {
        if (this.hQz == null || !this.hQz.isOriginalImg() || this.hQz.getChosedFiles() == null || this.hQz.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hQz.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hQA.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bNs() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bNt() {
        return (this.hOc == null || this.hOc.hQq == null || v.J(this.hOc.hQq.getStickerViews())) ? false : true;
    }

    public void bOq() {
        this.hQy++;
    }

    public void bOv() {
        this.hQy--;
    }

    public WriteImagesInfo bOw() {
        return this.hQz;
    }

    public void or(boolean z) {
        if (bNt()) {
            this.hOc.hQp.setmDisallowSlip(true);
        } else {
            this.hOc.hQp.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bNq() {
        bOv();
        or(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hOd == null) {
                this.hOd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hOd.cz(e.j.orginal_tip);
                this.hOd.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hOd != null) {
                            i.this.hOd.dismiss();
                        }
                        if (i.this.hQv != null) {
                            i.this.hQv.I(i, z);
                        }
                    }
                });
                this.hOd.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hOd != null) {
                            i.this.hOd.dismiss();
                        }
                    }
                });
                this.hOd.b(this.mPageContext);
            }
            this.hOd.Au();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.hQv.bNn() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hOd == null) {
            this.hOd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hOd.cz(e.j.orginal_tip);
            this.hOd.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hOd != null) {
                        i.this.hOd.dismiss();
                    }
                    i.this.hOc.H(bitmap);
                }
            });
            this.hOd.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hOd != null) {
                        i.this.hOd.dismiss();
                    }
                }
            });
            this.hOd.b(this.mPageContext);
        }
        this.hOd.Au();
        return true;
    }

    public void destroy() {
        if (this.hQx != null) {
            this.hQx.destroy();
        }
    }
}
