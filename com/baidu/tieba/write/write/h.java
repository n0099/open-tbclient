package com.baidu.tieba.write.write;

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
    private g hIs;
    private com.baidu.tbadk.core.dialog.a hIt;
    public b hKG = null;
    private int hKH = 0;
    private int hKI = 0;
    private int hKJ = 0;
    private WriteImagesInfo hKK = null;
    private HashMap<String, String> hKL = new HashMap<>();
    private ForumWriteData hvk;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, g gVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hIs = gVar;
        initData(bundle);
        initListener();
        bHo();
    }

    public void bHo() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.oI()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            StickerModel stickerModel = new StickerModel(this.mPageContext);
            stickerModel.bIL();
            stickerModel.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dS(List<String> list) {
        if (this.hIs != null) {
            this.hIs.dR(list);
        }
    }

    private void initListener() {
        if (this.hIs != null) {
            if (this.hIs.hKx != null) {
                this.hIs.hKx.r(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            h.this.hKG.T(Integer.parseInt(view.getTag().toString()), h.this.bHs());
                        }
                    }
                });
            }
            if (this.hIs.hKB != null) {
                this.hIs.hKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        h.this.hKG.nD(false);
                        if (h.this.hIs != null) {
                            if (h.this.hKK == null || h.this.hKK.getChosedFiles() == null || h.this.hKK.getChosedFiles().size() <= 0 || !h.this.hKK.isOriginalImg() || h.this.hKI <= 0 || !h.this.bIq()) {
                                h.this.hIs.b(true, h.this.hKK);
                            } else {
                                h.this.hIs.bIn();
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
            this.hKH = bundle.getInt("OutState_Write_Entrance");
            this.hvk = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hKH = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hvk = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hKK = new WriteImagesInfo();
            this.hKK.parseJson(str);
            bIo();
            if (this.hIs != null && this.hIs.hKz != null) {
                this.hKG = new b(this.mPageContext.getOrignalPage(), this.hIs.hKz, this.hKK.getChosedFiles(), i, this, this.hIs, this.hKK.mIsFromIm);
                this.hIs.hKz.setAdapter(this.hKG);
                this.hIs.hKz.setCurrentItem(i, true);
                if (i == 0) {
                    this.hKG.onPageSelected(0);
                }
                this.hIs.d(this.hKK);
            }
        }
    }

    private void bIo() {
        if (this.hKK != null && this.hKK.isOriginalImg() && this.hKK.getChosedFiles() != null && this.hKK.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hKK.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hKL.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bIp() {
        return this.hKH;
    }

    public ForumWriteData auu() {
        return this.hvk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIq() {
        if (this.hKK == null || !this.hKK.isOriginalImg() || this.hKK.getChosedFiles() == null || this.hKK.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hKK.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hKL.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHp() {
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHq() {
        this.hKJ++;
        if (this.hKJ > 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHr() {
        this.hKJ--;
        if (this.hKJ == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public boolean bHs() {
        return (this.hIs == null || this.hIs.hKA == null || v.E(this.hIs.hKA.getStickerViews())) ? false : true;
    }

    public void bIl() {
        this.hKI++;
    }

    public void bIm() {
        this.hKI--;
    }

    public WriteImagesInfo bIr() {
        return this.hKK;
    }

    public void nL(boolean z) {
        if (bHs()) {
            this.hIs.hKz.setmDisallowSlip(true);
        } else {
            this.hIs.hKz.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bHn() {
        bIm();
        nL(false);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void U(int i, boolean z) {
        V(i, z);
    }

    private void V(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hIt == null) {
                this.hIt = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hIt.fb(d.j.orginal_tip);
                this.hIt.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hIt != null) {
                            h.this.hIt.dismiss();
                        }
                        if (h.this.hKG != null) {
                            h.this.hKG.T(i, z);
                        }
                    }
                });
                this.hIt.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hIt != null) {
                            h.this.hIt.dismiss();
                        }
                    }
                });
                this.hIt.b(this.mPageContext);
            }
            this.hIt.AA();
        }
    }

    public boolean C(final Bitmap bitmap) {
        if (!this.hKG.bHk() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hIt == null) {
            this.hIt = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hIt.fb(d.j.orginal_tip);
            this.hIt.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hIt != null) {
                        h.this.hIt.dismiss();
                    }
                    h.this.hIs.B(bitmap);
                }
            });
            this.hIt.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hIt != null) {
                        h.this.hIt.dismiss();
                    }
                }
            });
            this.hIt.b(this.mPageContext);
        }
        this.hIt.AA();
        return true;
    }
}
