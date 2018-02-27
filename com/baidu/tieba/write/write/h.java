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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.b;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class h implements b.a, com.baidu.tieba.write.write.model.a {
    private com.baidu.tbadk.core.util.b.a bQD;
    private g hJV;
    private com.baidu.tbadk.core.dialog.a hJW;
    private ForumWriteData hwF;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public b hMl = null;
    private int hMm = 0;
    private int hMn = 0;
    private int hMo = 0;
    private WriteImagesInfo hMp = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hMq = new HashMap<>();

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, g gVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hJV = gVar;
        initData(bundle);
        initListener();
        bId();
    }

    public void bId() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            StickerModel stickerModel = new StickerModel(this.mPageContext);
            stickerModel.bJz();
            stickerModel.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dY(List<String> list) {
        if (this.hJV != null) {
            this.hJV.dX(list);
        }
    }

    private void initListener() {
        if (this.hJV != null) {
            if (this.hJV.hMc != null) {
                this.hJV.hMc.r(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            h.this.hMl.Z(Integer.parseInt(view.getTag().toString()), h.this.bIh());
                        }
                    }
                });
            }
            if (this.hJV.hMg != null) {
                this.hJV.hMg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (h.this.mPageContext != null) {
                            Activity pageActivity = h.this.mPageContext.getPageActivity();
                            if (h.this.bQD == null) {
                                h.this.bQD = new com.baidu.tbadk.core.util.b.a();
                            }
                            h.this.bQD.DH();
                            h.this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!h.this.bQD.v(pageActivity)) {
                                h.this.hMl.nN(false);
                                if (h.this.hJV != null) {
                                    if (h.this.hMp == null || h.this.hMp.getChosedFiles() == null || h.this.hMp.getChosedFiles().size() <= 0 || !h.this.hMp.isOriginalImg() || h.this.hMn <= 0 || !h.this.bJf()) {
                                        h.this.hJV.b(true, h.this.hMp);
                                    } else {
                                        h.this.hJV.bJc();
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
            this.hMm = bundle.getInt("OutState_Write_Entrance");
            this.hwF = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hMm = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hwF = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hMp = new WriteImagesInfo();
            this.hMp.parseJson(str);
            bJd();
            if (this.hJV != null && this.hJV.hMe != null) {
                this.hMl = new b(this.mPageContext.getOrignalPage(), this.hJV.hMe, this.hMp.getChosedFiles(), i, this, this.hJV, this.hMp.mIsFromIm);
                this.hJV.hMe.setAdapter(this.hMl);
                this.hJV.hMe.setCurrentItem(i, true);
                if (i == 0) {
                    this.hMl.onPageSelected(0);
                }
                this.hJV.d(this.hMp);
            }
        }
    }

    private void bJd() {
        if (this.hMp != null && this.hMp.isOriginalImg() && this.hMp.getChosedFiles() != null && this.hMp.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hMp.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hMq.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bJe() {
        return this.hMm;
    }

    public ForumWriteData avn() {
        return this.hwF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJf() {
        if (this.hMp == null || !this.hMp.isOriginalImg() || this.hMp.getChosedFiles() == null || this.hMp.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hMp.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hMq.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIe() {
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIf() {
        this.hMo++;
        if (this.hMo > 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIg() {
        this.hMo--;
        if (this.hMo == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public boolean bIh() {
        return (this.hJV == null || this.hJV.hMf == null || v.E(this.hJV.hMf.getStickerViews())) ? false : true;
    }

    public void bJa() {
        this.hMn++;
    }

    public void bJb() {
        this.hMn--;
    }

    public WriteImagesInfo bJg() {
        return this.hMp;
    }

    public void nW(boolean z) {
        if (bIh()) {
            this.hJV.hMe.setmDisallowSlip(true);
        } else {
            this.hJV.hMe.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bIc() {
        bJb();
        nW(false);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void aa(int i, boolean z) {
        ab(i, z);
    }

    private void ab(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hJW == null) {
                this.hJW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hJW.fb(d.j.orginal_tip);
                this.hJW.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hJW != null) {
                            h.this.hJW.dismiss();
                        }
                        if (h.this.hMl != null) {
                            h.this.hMl.Z(i, z);
                        }
                    }
                });
                this.hJW.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hJW != null) {
                            h.this.hJW.dismiss();
                        }
                    }
                });
                this.hJW.b(this.mPageContext);
            }
            this.hJW.AU();
        }
    }

    public boolean F(final Bitmap bitmap) {
        if (!this.hMl.bHZ() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hJW == null) {
            this.hJW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hJW.fb(d.j.orginal_tip);
            this.hJW.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hJW != null) {
                        h.this.hJW.dismiss();
                    }
                    h.this.hJV.E(bitmap);
                }
            });
            this.hJW.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hJW != null) {
                        h.this.hJW.dismiss();
                    }
                }
            });
            this.hJW.b(this.mPageContext);
        }
        this.hJW.AU();
        return true;
    }
}
