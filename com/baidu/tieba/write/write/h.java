package com.baidu.tieba.write.write;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
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
    private com.baidu.tbadk.core.util.b.a bOI;
    private g hIM;
    private com.baidu.tbadk.core.dialog.a hIN;
    public b hLa = null;
    private int hLb = 0;
    private int hLc = 0;
    private int hLd = 0;
    private WriteImagesInfo hLe = null;
    private HashMap<String, String> hLf = new HashMap<>();
    private ForumWriteData hvE;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, g gVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hIM = gVar;
        initData(bundle);
        initListener();
        bHq();
    }

    public void bHq() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.oJ()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            StickerModel stickerModel = new StickerModel(this.mPageContext);
            stickerModel.bIN();
            stickerModel.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dS(List<String> list) {
        if (this.hIM != null) {
            this.hIM.dR(list);
        }
    }

    private void initListener() {
        if (this.hIM != null) {
            if (this.hIM.hKR != null) {
                this.hIM.hKR.r(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            h.this.hLa.T(Integer.parseInt(view.getTag().toString()), h.this.bHu());
                        }
                    }
                });
            }
            if (this.hIM.hKV != null) {
                this.hIM.hKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (h.this.mPageContext != null) {
                            Activity pageActivity = h.this.mPageContext.getPageActivity();
                            if (h.this.bOI == null) {
                                h.this.bOI = new com.baidu.tbadk.core.util.b.a();
                            }
                            h.this.bOI.Do();
                            h.this.bOI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!h.this.bOI.u(pageActivity)) {
                                h.this.hLa.nF(false);
                                if (h.this.hIM != null) {
                                    if (h.this.hLe == null || h.this.hLe.getChosedFiles() == null || h.this.hLe.getChosedFiles().size() <= 0 || !h.this.hLe.isOriginalImg() || h.this.hLc <= 0 || !h.this.bIs()) {
                                        h.this.hIM.b(true, h.this.hLe);
                                    } else {
                                        h.this.hIM.bIp();
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
            this.hLb = bundle.getInt("OutState_Write_Entrance");
            this.hvE = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hLb = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hvE = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hLe = new WriteImagesInfo();
            this.hLe.parseJson(str);
            bIq();
            if (this.hIM != null && this.hIM.hKT != null) {
                this.hLa = new b(this.mPageContext.getOrignalPage(), this.hIM.hKT, this.hLe.getChosedFiles(), i, this, this.hIM, this.hLe.mIsFromIm);
                this.hIM.hKT.setAdapter(this.hLa);
                this.hIM.hKT.setCurrentItem(i, true);
                if (i == 0) {
                    this.hLa.onPageSelected(0);
                }
                this.hIM.d(this.hLe);
            }
        }
    }

    private void bIq() {
        if (this.hLe != null && this.hLe.isOriginalImg() && this.hLe.getChosedFiles() != null && this.hLe.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hLe.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hLf.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bIr() {
        return this.hLb;
    }

    public ForumWriteData auz() {
        return this.hvE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIs() {
        if (this.hLe == null || !this.hLe.isOriginalImg() || this.hLe.getChosedFiles() == null || this.hLe.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hLe.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hLf.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHr() {
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHs() {
        this.hLd++;
        if (this.hLd > 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHt() {
        this.hLd--;
        if (this.hLd == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public boolean bHu() {
        return (this.hIM == null || this.hIM.hKU == null || v.E(this.hIM.hKU.getStickerViews())) ? false : true;
    }

    public void bIn() {
        this.hLc++;
    }

    public void bIo() {
        this.hLc--;
    }

    public WriteImagesInfo bIt() {
        return this.hLe;
    }

    public void nN(boolean z) {
        if (bHu()) {
            this.hIM.hKT.setmDisallowSlip(true);
        } else {
            this.hIM.hKT.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHp() {
        bIo();
        nN(false);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void U(int i, boolean z) {
        V(i, z);
    }

    private void V(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hIN == null) {
                this.hIN = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hIN.fb(d.j.orginal_tip);
                this.hIN.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hIN != null) {
                            h.this.hIN.dismiss();
                        }
                        if (h.this.hLa != null) {
                            h.this.hLa.T(i, z);
                        }
                    }
                });
                this.hIN.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hIN != null) {
                            h.this.hIN.dismiss();
                        }
                    }
                });
                this.hIN.b(this.mPageContext);
            }
            this.hIN.AB();
        }
    }

    public boolean C(final Bitmap bitmap) {
        if (!this.hLa.bHm() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hIN == null) {
            this.hIN = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hIN.fb(d.j.orginal_tip);
            this.hIN.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hIN != null) {
                        h.this.hIN.dismiss();
                    }
                    h.this.hIM.B(bitmap);
                }
            });
            this.hIN.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hIN != null) {
                        h.this.hIN.dismiss();
                    }
                }
            });
            this.hIN.b(this.mPageContext);
        }
        this.hIN.AB();
        return true;
    }
}
