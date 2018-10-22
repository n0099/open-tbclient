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
    private h hOd;
    private com.baidu.tbadk.core.dialog.a hOe;
    private StickerModel hQy;
    private ForumWriteData hzm;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hQw = null;
    private int hQx = 0;
    private int hQz = 0;
    private WriteImagesInfo hQA = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hQB = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hOd = hVar;
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
            if (this.hQy == null) {
                this.hQy = new StickerModel(this.mPageContext);
            }
            this.hQy.LoadData();
            this.hQy.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void ej(List<String> list) {
        if (this.hOd != null) {
            this.hOd.ei(list);
        }
    }

    private void initListener() {
        if (this.hOd != null) {
            if (this.hOd.hQp != null) {
                this.hOd.hQp.u(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.hQw.I(Integer.parseInt(view.getTag().toString()), i.this.bNt());
                        }
                    }
                });
            }
            if (this.hOd.hQs != null) {
                this.hOd.hQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.hQw.om(false);
                                if (i.this.hOd != null) {
                                    if (i.this.hQA == null || i.this.hQA.getChosedFiles() == null || i.this.hQA.getChosedFiles().size() <= 0 || !i.this.hQA.isOriginalImg() || i.this.hQz <= 0 || !i.this.bOu()) {
                                        i.this.hOd.b(true, i.this.hQA);
                                    } else {
                                        i.this.hOd.bOr();
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
            this.hQx = bundle.getInt("OutState_Write_Entrance");
            this.hzm = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hQx = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hzm = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hQA = new WriteImagesInfo();
            this.hQA.parseJson(str);
            bOs();
            if (this.hOd != null && this.hOd.hQq != null) {
                this.hQw = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hOd.hQq, this.hQA.getChosedFiles(), i, this, this.hOd, this.hQA.mIsFromIm);
                this.hOd.hQq.setAdapter(this.hQw);
                this.hOd.hQq.setCurrentItem(i, true);
                if (i == 0) {
                    this.hQw.onPageSelected(0);
                }
                this.hOd.d(this.hQA);
            }
        }
    }

    private void bOs() {
        if (this.hQA != null && this.hQA.isOriginalImg() && this.hQA.getChosedFiles() != null && this.hQA.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hQA.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hQB.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bOt() {
        return this.hQx;
    }

    public ForumWriteData azV() {
        return this.hzm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOu() {
        if (this.hQA == null || !this.hQA.isOriginalImg() || this.hQA.getChosedFiles() == null || this.hQA.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hQA.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hQB.get(next.getFilePath()))) {
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
        return (this.hOd == null || this.hOd.hQr == null || v.J(this.hOd.hQr.getStickerViews())) ? false : true;
    }

    public void bOq() {
        this.hQz++;
    }

    public void bOv() {
        this.hQz--;
    }

    public WriteImagesInfo bOw() {
        return this.hQA;
    }

    public void or(boolean z) {
        if (bNt()) {
            this.hOd.hQq.setmDisallowSlip(true);
        } else {
            this.hOd.hQq.setmDisallowSlip(false);
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
            if (this.hOe == null) {
                this.hOe = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hOe.cz(e.j.orginal_tip);
                this.hOe.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hOe != null) {
                            i.this.hOe.dismiss();
                        }
                        if (i.this.hQw != null) {
                            i.this.hQw.I(i, z);
                        }
                    }
                });
                this.hOe.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hOe != null) {
                            i.this.hOe.dismiss();
                        }
                    }
                });
                this.hOe.b(this.mPageContext);
            }
            this.hOe.Au();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.hQw.bNn() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hOe == null) {
            this.hOe = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hOe.cz(e.j.orginal_tip);
            this.hOe.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hOe != null) {
                        i.this.hOe.dismiss();
                    }
                    i.this.hOd.H(bitmap);
                }
            });
            this.hOe.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hOe != null) {
                        i.this.hOe.dismiss();
                    }
                }
            });
            this.hOe.b(this.mPageContext);
        }
        this.hOe.Au();
        return true;
    }

    public void destroy() {
        if (this.hQy != null) {
            this.hQy.destroy();
        }
    }
}
