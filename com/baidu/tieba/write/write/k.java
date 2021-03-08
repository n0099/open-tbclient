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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class k implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData jvq;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j olP;
    private com.baidu.tbadk.core.dialog.a olQ;
    private StickerModel opc;
    public MultiImagePagerAdapter opa = null;
    private int opb = 0;
    private int opd = 0;
    private WriteImagesInfo ope = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> opf = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.olP = jVar;
        initData(bundle);
        initListener();
        dYk();
    }

    public void dYk() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.opc == null) {
                this.opc = new StickerModel(this.mPageContext);
            }
            this.opc.LoadData();
            this.opc.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void gm(List<String> list) {
        if (this.olP != null) {
            this.olP.gl(list);
        }
    }

    private void initListener() {
        if (this.olP != null) {
            if (this.olP.ooT != null) {
                this.olP.ooT.I(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.opa.aj(Integer.parseInt(view.getTag().toString()), k.this.dYm());
                        }
                    }
                });
            }
            if (this.olP.ooW != null) {
                this.olP.ooW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (k.this.mPageContext != null) {
                            Activity pageActivity = k.this.mPageContext.getPageActivity();
                            if (k.this.mPermissionJudgement == null) {
                                k.this.mPermissionJudgement = new PermissionJudgePolicy();
                            }
                            k.this.mPermissionJudgement.clearRequestPermissionList();
                            k.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!k.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                k.this.opa.zF(false);
                                if (k.this.olP != null) {
                                    if (k.this.ope == null || k.this.ope.getChosedFiles() == null || k.this.ope.getChosedFiles().size() <= 0 || !k.this.ope.isOriginalImg() || k.this.opd <= 0 || !k.this.dZO()) {
                                        k.this.olP.a(true, k.this.ope);
                                    } else {
                                        k.this.olP.dZL();
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
            this.opb = bundle.getInt("OutState_Write_Entrance");
            this.jvq = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.opb = intent.getIntExtra("FourmWriteIndex", 0);
            this.jvq = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.ope = new WriteImagesInfo();
            this.ope.parseJson(str);
            dZM();
            if (this.olP != null && this.olP.ooU != null) {
                this.opa = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.olP.ooU, this.ope.getChosedFiles(), i, this, this.olP, this.ope.mIsFromIm);
                this.olP.ooU.setAdapter(this.opa);
                int dYf = this.opa.dYf();
                this.olP.ooU.setCurrentItem(dYf, true);
                if (dYf == 0) {
                    this.opa.onPageSelected(0);
                }
                this.olP.c(this.ope);
            }
        }
    }

    private void dZM() {
        if (this.ope != null && this.ope.isOriginalImg() && this.ope.getChosedFiles() != null && this.ope.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.ope.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.opf.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dZN() {
        return this.opb;
    }

    public ForumWriteData cDq() {
        return this.jvq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZO() {
        if (this.ope == null || !this.ope.isOriginalImg() || this.ope.getChosedFiles() == null || this.ope.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.ope.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.opf.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dYl() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dYm() {
        return (this.olP == null || this.olP.ooV == null || y.isEmpty(this.olP.ooV.getStickerViews())) ? false : true;
    }

    public void dZK() {
        this.opd++;
    }

    public void dZP() {
        this.opd--;
    }

    public WriteImagesInfo dZQ() {
        return this.ope;
    }

    public void zL(boolean z) {
        if (dYm()) {
            this.olP.ooU.setmDisallowSlip(true);
        } else {
            this.olP.ooU.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dYj() {
        dZP();
        zL(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ak(int i, boolean z) {
        al(i, z);
    }

    private void al(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.olQ == null) {
                this.olQ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.olQ.ny(R.string.orginal_tip);
                this.olQ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.olQ != null) {
                            k.this.olQ.dismiss();
                        }
                        if (k.this.opa != null) {
                            k.this.opa.aj(i, z);
                        }
                    }
                });
                this.olQ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.olQ != null) {
                            k.this.olQ.dismiss();
                        }
                    }
                });
                this.olQ.b(this.mPageContext);
            }
            this.olQ.bqz();
        }
    }

    public boolean V(final Bitmap bitmap) {
        if (!this.opa.dYg() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.olQ == null) {
            this.olQ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.olQ.ny(R.string.orginal_tip);
            this.olQ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.olQ != null) {
                        k.this.olQ.dismiss();
                    }
                    k.this.olP.U(bitmap);
                }
            });
            this.olQ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.olQ != null) {
                        k.this.olQ.dismiss();
                    }
                }
            });
            this.olQ.b(this.mPageContext);
        }
        this.olQ.bqz();
        return true;
    }

    public void destroy() {
        if (this.opc != null) {
            this.opc.destroy();
        }
    }
}
