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
    private ForumWriteData jfR;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j obJ;
    private com.baidu.tbadk.core.dialog.a obK;
    private StickerModel oeV;
    public MultiImagePagerAdapter oeT = null;
    private int oeU = 0;
    private int oeW = 0;
    private WriteImagesInfo oeX = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> oeY = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.obJ = jVar;
        initData(bundle);
        initListener();
        eaq();
    }

    public void eaq() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    com.baidu.adp.lib.util.l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.oeV == null) {
                this.oeV = new StickerModel(this.mPageContext);
            }
            this.oeV.LoadData();
            this.oeV.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void gv(List<String> list) {
        if (this.obJ != null) {
            this.obJ.gu(list);
        }
    }

    private void initListener() {
        if (this.obJ != null) {
            if (this.obJ.oeM != null) {
                this.obJ.oeM.F(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.oeT.al(Integer.parseInt(view.getTag().toString()), k.this.eas());
                        }
                    }
                });
            }
            if (this.obJ.oeP != null) {
                this.obJ.oeP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.oeT.zs(false);
                                if (k.this.obJ != null) {
                                    if (k.this.oeX == null || k.this.oeX.getChosedFiles() == null || k.this.oeX.getChosedFiles().size() <= 0 || !k.this.oeX.isOriginalImg() || k.this.oeW <= 0 || !k.this.ebR()) {
                                        k.this.obJ.b(true, k.this.oeX);
                                    } else {
                                        k.this.obJ.ebO();
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
            this.oeU = bundle.getInt("OutState_Write_Entrance");
            this.jfR = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.oeU = intent.getIntExtra("FourmWriteIndex", 0);
            this.jfR = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.oeX = new WriteImagesInfo();
            this.oeX.parseJson(str);
            ebP();
            if (this.obJ != null && this.obJ.oeN != null) {
                this.oeT = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.obJ.oeN, this.oeX.getChosedFiles(), i, this, this.obJ, this.oeX.mIsFromIm);
                this.obJ.oeN.setAdapter(this.oeT);
                int eal = this.oeT.eal();
                this.obJ.oeN.setCurrentItem(eal, true);
                if (eal == 0) {
                    this.oeT.onPageSelected(0);
                }
                this.obJ.c(this.oeX);
            }
        }
    }

    private void ebP() {
        if (this.oeX != null && this.oeX.isOriginalImg() && this.oeX.getChosedFiles() != null && this.oeX.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.oeX.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.oeY.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int ebQ() {
        return this.oeU;
    }

    public ForumWriteData cCN() {
        return this.jfR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ebR() {
        if (this.oeX == null || !this.oeX.isOriginalImg() || this.oeX.getChosedFiles() == null || this.oeX.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.oeX.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.oeY.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ear() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean eas() {
        return (this.obJ == null || this.obJ.oeO == null || y.isEmpty(this.obJ.oeO.getStickerViews())) ? false : true;
    }

    public void ebN() {
        this.oeW++;
    }

    public void ebS() {
        this.oeW--;
    }

    public WriteImagesInfo ebT() {
        return this.oeX;
    }

    public void zx(boolean z) {
        if (eas()) {
            this.obJ.oeN.setmDisallowSlip(true);
        } else {
            this.obJ.oeN.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void eap() {
        ebS();
        zx(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void am(int i, boolean z) {
        an(i, z);
    }

    private void an(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.obK == null) {
                this.obK = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.obK.oQ(R.string.orginal_tip);
                this.obK.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.obK != null) {
                            k.this.obK.dismiss();
                        }
                        if (k.this.oeT != null) {
                            k.this.oeT.al(i, z);
                        }
                    }
                });
                this.obK.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.obK != null) {
                            k.this.obK.dismiss();
                        }
                    }
                });
                this.obK.b(this.mPageContext);
            }
            this.obK.brv();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.oeT.eam() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.obK == null) {
            this.obK = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.obK.oQ(R.string.orginal_tip);
            this.obK.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.obK != null) {
                        k.this.obK.dismiss();
                    }
                    k.this.obJ.V(bitmap);
                }
            });
            this.obK.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.obK != null) {
                        k.this.obK.dismiss();
                    }
                }
            });
            this.obK.b(this.mPageContext);
        }
        this.obK.brv();
        return true;
    }

    public void destroy() {
        if (this.oeV != null) {
            this.oeV.destroy();
        }
    }
}
