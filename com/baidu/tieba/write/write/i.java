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
/* loaded from: classes11.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData kBM;
    private h kRn;
    private com.baidu.tbadk.core.dialog.a kRo;
    private StickerModel kTI;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter kTG = null;
    private int kTH = 0;
    private int kTJ = 0;
    private WriteImagesInfo kTK = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> kTL = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kRn = hVar;
        initData(bundle);
        initListener();
        cUp();
    }

    public void cUp() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.kTI == null) {
                this.kTI = new StickerModel(this.mPageContext);
            }
            this.kTI.LoadData();
            this.kTI.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eG(List<String> list) {
        if (this.kRn != null) {
            this.kRn.eF(list);
        }
    }

    private void initListener() {
        if (this.kRn != null) {
            if (this.kRn.kTz != null) {
                this.kRn.kTz.C(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.kTG.U(Integer.parseInt(view.getTag().toString()), i.this.cUr());
                        }
                    }
                });
            }
            if (this.kRn.kTC != null) {
                this.kRn.kTC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.kTG.tN(false);
                                if (i.this.kRn != null) {
                                    if (i.this.kTK == null || i.this.kTK.getChosedFiles() == null || i.this.kTK.getChosedFiles().size() <= 0 || !i.this.kTK.isOriginalImg() || i.this.kTJ <= 0 || !i.this.cVu()) {
                                        i.this.kRn.b(true, i.this.kTK);
                                    } else {
                                        i.this.kRn.cVr();
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
            this.kTH = bundle.getInt("OutState_Write_Entrance");
            this.kBM = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.kTH = intent.getIntExtra("FourmWriteIndex", 0);
            this.kBM = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.kTK = new WriteImagesInfo();
            this.kTK.parseJson(str);
            cVs();
            if (this.kRn != null && this.kRn.kTA != null) {
                this.kTG = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.kRn.kTA, this.kTK.getChosedFiles(), i, this, this.kRn, this.kTK.mIsFromIm);
                this.kRn.kTA.setAdapter(this.kTG);
                int cUk = this.kTG.cUk();
                this.kRn.kTA.setCurrentItem(cUk, true);
                if (cUk == 0) {
                    this.kTG.onPageSelected(0);
                }
                this.kRn.c(this.kTK);
            }
        }
    }

    private void cVs() {
        if (this.kTK != null && this.kTK.isOriginalImg() && this.kTK.getChosedFiles() != null && this.kTK.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.kTK.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.kTL.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cVt() {
        return this.kTH;
    }

    public ForumWriteData bCO() {
        return this.kBM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVu() {
        if (this.kTK == null || !this.kTK.isOriginalImg() || this.kTK.getChosedFiles() == null || this.kTK.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.kTK.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.kTL.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cUq() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cUr() {
        return (this.kRn == null || this.kRn.kTB == null || v.isEmpty(this.kRn.kTB.getStickerViews())) ? false : true;
    }

    public void cVq() {
        this.kTJ++;
    }

    public void cVv() {
        this.kTJ--;
    }

    public WriteImagesInfo cVw() {
        return this.kTK;
    }

    public void tS(boolean z) {
        if (cUr()) {
            this.kRn.kTA.setmDisallowSlip(true);
        } else {
            this.kRn.kTA.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cUo() {
        cVv();
        tS(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void V(int i, boolean z) {
        X(i, z);
    }

    private void X(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.kRo == null) {
                this.kRo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.kRo.jF(R.string.orginal_tip);
                this.kRo.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kRo != null) {
                            i.this.kRo.dismiss();
                        }
                        if (i.this.kTG != null) {
                            i.this.kTG.U(i, z);
                        }
                    }
                });
                this.kRo.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kRo != null) {
                            i.this.kRo.dismiss();
                        }
                    }
                });
                this.kRo.b(this.mPageContext);
            }
            this.kRo.aCp();
        }
    }

    public boolean P(final Bitmap bitmap) {
        if (!this.kTG.cUl() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.kRo == null) {
            this.kRo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.kRo.jF(R.string.orginal_tip);
            this.kRo.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kRo != null) {
                        i.this.kRo.dismiss();
                    }
                    i.this.kRn.O(bitmap);
                }
            });
            this.kRo.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kRo != null) {
                        i.this.kRo.dismiss();
                    }
                }
            });
            this.kRo.b(this.mPageContext);
        }
        this.kRo.aCp();
        return true;
    }

    public void destroy() {
        if (this.kTI != null) {
            this.kTI.destroy();
        }
    }
}
