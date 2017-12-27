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
    private ForumWriteData hFH;
    private g hSJ;
    private com.baidu.tbadk.core.dialog.a hSK;
    public b hUW = null;
    private int hUX = 0;
    private int hUY = 0;
    private int hUZ = 0;
    private WriteImagesInfo hVa = null;
    private HashMap<String, String> hVb = new HashMap<>();
    private TbPageContext<WriteMultiImgsActivity> mPageContext;

    public h(TbPageContext<WriteMultiImgsActivity> tbPageContext, g gVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hSJ = gVar;
        initData(bundle);
        initListener();
        bNO();
    }

    public void bNO() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.oI()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            StickerModel stickerModel = new StickerModel(this.mPageContext);
            stickerModel.bPi();
            stickerModel.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void ej(List<String> list) {
        if (this.hSJ != null) {
            this.hSJ.ei(list);
        }
    }

    private void initListener() {
        if (this.hSJ != null) {
            if (this.hSJ.hUN != null) {
                this.hSJ.hUN.q(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            h.this.hUW.T(Integer.parseInt(view.getTag().toString()), h.this.bNS());
                        }
                    }
                });
            }
            if (this.hSJ.hUR != null) {
                this.hSJ.hUR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        h.this.hUW.oA(false);
                        if (h.this.hSJ != null) {
                            if (h.this.hVa == null || h.this.hVa.getChosedFiles() == null || h.this.hVa.getChosedFiles().size() <= 0 || !h.this.hVa.isOriginalImg() || h.this.hUY <= 0 || !h.this.bON()) {
                                h.this.hSJ.b(true, h.this.hVa);
                            } else {
                                h.this.hSJ.bOK();
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
            this.hUX = bundle.getInt("OutState_Write_Entrance");
            this.hFH = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hUX = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hFH = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hVa = new WriteImagesInfo();
            this.hVa.parseJson(str);
            bOL();
            if (this.hSJ != null && this.hSJ.hUP != null) {
                this.hUW = new b(this.mPageContext.getOrignalPage(), this.hSJ.hUP, this.hVa.getChosedFiles(), i, this, this.hSJ, this.hVa.mIsFromIm);
                this.hSJ.hUP.setAdapter(this.hUW);
                this.hSJ.hUP.setCurrentItem(i, true);
                if (i == 0) {
                    this.hUW.onPageSelected(0);
                }
                this.hSJ.d(this.hVa);
            }
        }
    }

    private void bOL() {
        if (this.hVa != null && this.hVa.isOriginalImg() && this.hVa.getChosedFiles() != null && this.hVa.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hVa.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hVb.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bOM() {
        return this.hUX;
    }

    public ForumWriteData atr() {
        return this.hFH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bON() {
        if (this.hVa == null || !this.hVa.isOriginalImg() || this.hVa.getChosedFiles() == null || this.hVa.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hVa.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hVb.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bNP() {
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bNQ() {
        this.hUZ++;
        if (this.hUZ > 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bNR() {
        this.hUZ--;
        if (this.hUZ == 0) {
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public boolean bNS() {
        return (this.hSJ == null || this.hSJ.hUQ == null || v.G(this.hSJ.hUQ.getStickerViews())) ? false : true;
    }

    public void bOI() {
        this.hUY++;
    }

    public void bOJ() {
        this.hUY--;
    }

    public WriteImagesInfo bOO() {
        return this.hVa;
    }

    public void oI(boolean z) {
        if (bNS()) {
            this.hSJ.hUP.setmDisallowSlip(true);
        } else {
            this.hSJ.hUP.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void bNN() {
        bOJ();
        oI(false);
    }

    @Override // com.baidu.tieba.write.write.b.a
    public void U(int i, boolean z) {
        V(i, z);
    }

    private void V(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hSK == null) {
                this.hSK = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hSK.fd(d.j.orginal_tip);
                this.hSK.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hSK != null) {
                            h.this.hSK.dismiss();
                        }
                        if (h.this.hUW != null) {
                            h.this.hUW.T(i, z);
                        }
                    }
                });
                this.hSK.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (h.this.hSK != null) {
                            h.this.hSK.dismiss();
                        }
                    }
                });
                this.hSK.b(this.mPageContext);
            }
            this.hSK.AI();
        }
    }

    public boolean C(final Bitmap bitmap) {
        if (!this.hUW.bNK() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hSK == null) {
            this.hSK = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hSK.fd(d.j.orginal_tip);
            this.hSK.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.h.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hSK != null) {
                        h.this.hSK.dismiss();
                    }
                    h.this.hSJ.B(bitmap);
                }
            });
            this.hSK.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.h.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (h.this.hSK != null) {
                        h.this.hSK.dismiss();
                    }
                }
            });
            this.hSK.b(this.mPageContext);
        }
        this.hSK.AI();
        return true;
    }
}
