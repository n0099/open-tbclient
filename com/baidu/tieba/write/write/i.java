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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private h kNH;
    private com.baidu.tbadk.core.dialog.a kNI;
    private StickerModel kQc;
    private ForumWriteData kyf;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter kQa = null;
    private int kQb = 0;
    private int kQd = 0;
    private WriteImagesInfo kQe = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> kQf = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kNH = hVar;
        initData(bundle);
        initListener();
        cTk();
    }

    public void cTk() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.kQc == null) {
                this.kQc = new StickerModel(this.mPageContext);
            }
            this.kQc.LoadData();
            this.kQc.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eG(List<String> list) {
        if (this.kNH != null) {
            this.kNH.eF(list);
        }
    }

    private void initListener() {
        if (this.kNH != null) {
            if (this.kNH.kPT != null) {
                this.kNH.kPT.D(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.kQa.U(Integer.parseInt(view.getTag().toString()), i.this.cTm());
                        }
                    }
                });
            }
            if (this.kNH.kPW != null) {
                this.kNH.kPW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.mPermissionJudgement.clearRequestPermissionList();
                            i.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                i.this.kQa.tB(false);
                                if (i.this.kNH != null) {
                                    if (i.this.kQe == null || i.this.kQe.getChosedFiles() == null || i.this.kQe.getChosedFiles().size() <= 0 || !i.this.kQe.isOriginalImg() || i.this.kQd <= 0 || !i.this.cUp()) {
                                        i.this.kNH.b(true, i.this.kQe);
                                    } else {
                                        i.this.kNH.cUm();
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
            this.kQb = bundle.getInt("OutState_Write_Entrance");
            this.kyf = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.kQb = intent.getIntExtra("FourmWriteIndex", 0);
            this.kyf = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.kQe = new WriteImagesInfo();
            this.kQe.parseJson(str);
            cUn();
            if (this.kNH != null && this.kNH.kPU != null) {
                this.kQa = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.kNH.kPU, this.kQe.getChosedFiles(), i, this, this.kNH, this.kQe.mIsFromIm);
                this.kNH.kPU.setAdapter(this.kQa);
                int cTf = this.kQa.cTf();
                this.kNH.kPU.setCurrentItem(cTf, true);
                if (cTf == 0) {
                    this.kQa.onPageSelected(0);
                }
                this.kNH.c(this.kQe);
            }
        }
    }

    private void cUn() {
        if (this.kQe != null && this.kQe.isOriginalImg() && this.kQe.getChosedFiles() != null && this.kQe.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.kQe.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.kQf.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cUo() {
        return this.kQb;
    }

    public ForumWriteData bBM() {
        return this.kyf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cUp() {
        if (this.kQe == null || !this.kQe.isOriginalImg() || this.kQe.getChosedFiles() == null || this.kQe.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.kQe.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.kQf.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cTl() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cTm() {
        return (this.kNH == null || this.kNH.kPV == null || v.isEmpty(this.kNH.kPV.getStickerViews())) ? false : true;
    }

    public void cUl() {
        this.kQd++;
    }

    public void cUq() {
        this.kQd--;
    }

    public WriteImagesInfo cUr() {
        return this.kQe;
    }

    public void tG(boolean z) {
        if (cTm()) {
            this.kNH.kPU.setmDisallowSlip(true);
        } else {
            this.kNH.kPU.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cTj() {
        cUq();
        tG(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void V(int i, boolean z) {
        X(i, z);
    }

    private void X(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.kNI == null) {
                this.kNI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.kNI.jF(R.string.orginal_tip);
                this.kNI.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kNI != null) {
                            i.this.kNI.dismiss();
                        }
                        if (i.this.kQa != null) {
                            i.this.kQa.U(i, z);
                        }
                    }
                });
                this.kNI.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kNI != null) {
                            i.this.kNI.dismiss();
                        }
                    }
                });
                this.kNI.b(this.mPageContext);
            }
            this.kNI.aBW();
        }
    }

    public boolean P(final Bitmap bitmap) {
        if (!this.kQa.cTg() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.kNI == null) {
            this.kNI = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.kNI.jF(R.string.orginal_tip);
            this.kNI.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kNI != null) {
                        i.this.kNI.dismiss();
                    }
                    i.this.kNH.O(bitmap);
                }
            });
            this.kNI.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kNI != null) {
                        i.this.kNI.dismiss();
                    }
                }
            });
            this.kNI.b(this.mPageContext);
        }
        this.kNI.aBW();
        return true;
    }

    public void destroy() {
        if (this.kQc != null) {
            this.kQc.destroy();
        }
    }
}
