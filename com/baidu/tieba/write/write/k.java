package com.baidu.tieba.write.write;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes3.dex */
public class k implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData ifP;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j mTN;
    private com.baidu.tbadk.core.dialog.a mTO;
    private StickerModel mWI;
    public MultiImagePagerAdapter mWG = null;
    private int mWH = 0;
    private int mWJ = 0;
    private WriteImagesInfo mWK = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> mWL = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.mTN = jVar;
        initData(bundle);
        initListener();
        dHx();
    }

    public void dHx() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    com.baidu.adp.lib.util.l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.mWI == null) {
                this.mWI = new StickerModel(this.mPageContext);
            }
            this.mWI.LoadData();
            this.mWI.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void fF(List<String> list) {
        if (this.mTN != null) {
            this.mTN.fE(list);
        }
    }

    private void initListener() {
        if (this.mTN != null) {
            if (this.mTN.mWz != null) {
                this.mTN.mWz.F(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.mWG.ai(Integer.parseInt(view.getTag().toString()), k.this.dHz());
                        }
                    }
                });
            }
            if (this.mTN.mWC != null) {
                this.mTN.mWC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.mWG.xo(false);
                                if (k.this.mTN != null) {
                                    if (k.this.mWK == null || k.this.mWK.getChosedFiles() == null || k.this.mWK.getChosedFiles().size() <= 0 || !k.this.mWK.isOriginalImg() || k.this.mWJ <= 0 || !k.this.dIU()) {
                                        k.this.mTN.b(true, k.this.mWK);
                                    } else {
                                        k.this.mTN.dIR();
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
            this.mWH = bundle.getInt("OutState_Write_Entrance");
            this.ifP = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.mWH = intent.getIntExtra("FourmWriteIndex", 0);
            this.ifP = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.mWK = new WriteImagesInfo();
            this.mWK.parseJson(str);
            dIS();
            if (this.mTN != null && this.mTN.mWA != null) {
                this.mWG = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.mTN.mWA, this.mWK.getChosedFiles(), i, this, this.mTN, this.mWK.mIsFromIm);
                this.mTN.mWA.setAdapter(this.mWG);
                int dHs = this.mWG.dHs();
                this.mTN.mWA.setCurrentItem(dHs, true);
                if (dHs == 0) {
                    this.mWG.onPageSelected(0);
                }
                this.mTN.c(this.mWK);
            }
        }
    }

    private void dIS() {
        if (this.mWK != null && this.mWK.isOriginalImg() && this.mWK.getChosedFiles() != null && this.mWK.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.mWK.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.mWL.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dIT() {
        return this.mWH;
    }

    public ForumWriteData cmA() {
        return this.ifP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIU() {
        if (this.mWK == null || !this.mWK.isOriginalImg() || this.mWK.getChosedFiles() == null || this.mWK.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.mWK.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.mWL.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dHy() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dHz() {
        return (this.mTN == null || this.mTN.mWB == null || y.isEmpty(this.mTN.mWB.getStickerViews())) ? false : true;
    }

    public void dIQ() {
        this.mWJ++;
    }

    public void dIV() {
        this.mWJ--;
    }

    public WriteImagesInfo dIW() {
        return this.mWK;
    }

    public void xu(boolean z) {
        if (dHz()) {
            this.mTN.mWA.setmDisallowSlip(true);
        } else {
            this.mTN.mWA.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dHw() {
        dIV();
        xu(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void aj(int i, boolean z) {
        ak(i, z);
    }

    private void ak(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.mTO == null) {
                this.mTO = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.mTO.nt(R.string.orginal_tip);
                this.mTO.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.mTO != null) {
                            k.this.mTO.dismiss();
                        }
                        if (k.this.mWG != null) {
                            k.this.mWG.ai(i, z);
                        }
                    }
                });
                this.mTO.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.mTO != null) {
                            k.this.mTO.dismiss();
                        }
                    }
                });
                this.mTO.b(this.mPageContext);
            }
            this.mTO.bhg();
        }
    }

    public boolean X(final Bitmap bitmap) {
        if (!this.mWG.dHt() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.mTO == null) {
            this.mTO = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.mTO.nt(R.string.orginal_tip);
            this.mTO.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.mTO != null) {
                        k.this.mTO.dismiss();
                    }
                    k.this.mTN.W(bitmap);
                }
            });
            this.mTO.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.mTO != null) {
                        k.this.mTO.dismiss();
                    }
                }
            });
            this.mTO.b(this.mPageContext);
        }
        this.mTO.bhg();
        return true;
    }

    public void destroy() {
        if (this.mWI != null) {
            this.mWI.destroy();
        }
    }
}
