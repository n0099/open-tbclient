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
    private ForumWriteData jfT;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j obL;
    private com.baidu.tbadk.core.dialog.a obM;
    private StickerModel oeX;
    public MultiImagePagerAdapter oeV = null;
    private int oeW = 0;
    private int oeY = 0;
    private WriteImagesInfo oeZ = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> ofa = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.obL = jVar;
        initData(bundle);
        initListener();
        ear();
    }

    public void ear() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    com.baidu.adp.lib.util.l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.oeX == null) {
                this.oeX = new StickerModel(this.mPageContext);
            }
            this.oeX.LoadData();
            this.oeX.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void gv(List<String> list) {
        if (this.obL != null) {
            this.obL.gu(list);
        }
    }

    private void initListener() {
        if (this.obL != null) {
            if (this.obL.oeO != null) {
                this.obL.oeO.F(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.oeV.al(Integer.parseInt(view.getTag().toString()), k.this.eat());
                        }
                    }
                });
            }
            if (this.obL.oeR != null) {
                this.obL.oeR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.oeV.zs(false);
                                if (k.this.obL != null) {
                                    if (k.this.oeZ == null || k.this.oeZ.getChosedFiles() == null || k.this.oeZ.getChosedFiles().size() <= 0 || !k.this.oeZ.isOriginalImg() || k.this.oeY <= 0 || !k.this.ebS()) {
                                        k.this.obL.b(true, k.this.oeZ);
                                    } else {
                                        k.this.obL.ebP();
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
            this.oeW = bundle.getInt("OutState_Write_Entrance");
            this.jfT = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.oeW = intent.getIntExtra("FourmWriteIndex", 0);
            this.jfT = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.oeZ = new WriteImagesInfo();
            this.oeZ.parseJson(str);
            ebQ();
            if (this.obL != null && this.obL.oeP != null) {
                this.oeV = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.obL.oeP, this.oeZ.getChosedFiles(), i, this, this.obL, this.oeZ.mIsFromIm);
                this.obL.oeP.setAdapter(this.oeV);
                int eam = this.oeV.eam();
                this.obL.oeP.setCurrentItem(eam, true);
                if (eam == 0) {
                    this.oeV.onPageSelected(0);
                }
                this.obL.c(this.oeZ);
            }
        }
    }

    private void ebQ() {
        if (this.oeZ != null && this.oeZ.isOriginalImg() && this.oeZ.getChosedFiles() != null && this.oeZ.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.oeZ.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.ofa.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int ebR() {
        return this.oeW;
    }

    public ForumWriteData cCO() {
        return this.jfT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ebS() {
        if (this.oeZ == null || !this.oeZ.isOriginalImg() || this.oeZ.getChosedFiles() == null || this.oeZ.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.oeZ.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.ofa.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void eas() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean eat() {
        return (this.obL == null || this.obL.oeQ == null || y.isEmpty(this.obL.oeQ.getStickerViews())) ? false : true;
    }

    public void ebO() {
        this.oeY++;
    }

    public void ebT() {
        this.oeY--;
    }

    public WriteImagesInfo ebU() {
        return this.oeZ;
    }

    public void zx(boolean z) {
        if (eat()) {
            this.obL.oeP.setmDisallowSlip(true);
        } else {
            this.obL.oeP.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void eaq() {
        ebT();
        zx(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void am(int i, boolean z) {
        an(i, z);
    }

    private void an(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.obM == null) {
                this.obM = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.obM.oQ(R.string.orginal_tip);
                this.obM.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.obM != null) {
                            k.this.obM.dismiss();
                        }
                        if (k.this.oeV != null) {
                            k.this.oeV.al(i, z);
                        }
                    }
                });
                this.obM.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.obM != null) {
                            k.this.obM.dismiss();
                        }
                    }
                });
                this.obM.b(this.mPageContext);
            }
            this.obM.brv();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.oeV.ean() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.obM == null) {
            this.obM = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.obM.oQ(R.string.orginal_tip);
            this.obM.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.obM != null) {
                        k.this.obM.dismiss();
                    }
                    k.this.obL.V(bitmap);
                }
            });
            this.obM.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.obM != null) {
                        k.this.obM.dismiss();
                    }
                }
            });
            this.obM.b(this.mPageContext);
        }
        this.obM.brv();
        return true;
    }

    public void destroy() {
        if (this.oeX != null) {
            this.oeX.destroy();
        }
    }
}
