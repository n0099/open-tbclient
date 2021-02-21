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
/* loaded from: classes8.dex */
public class k implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData jtH;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j ojK;
    private com.baidu.tbadk.core.dialog.a ojL;
    private StickerModel omW;
    public MultiImagePagerAdapter omU = null;
    private int omV = 0;
    private int omX = 0;
    private WriteImagesInfo omY = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> omZ = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ojK = jVar;
        initData(bundle);
        initListener();
        dYc();
    }

    public void dYc() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.omW == null) {
                this.omW = new StickerModel(this.mPageContext);
            }
            this.omW.LoadData();
            this.omW.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void gm(List<String> list) {
        if (this.ojK != null) {
            this.ojK.gl(list);
        }
    }

    private void initListener() {
        if (this.ojK != null) {
            if (this.ojK.omN != null) {
                this.ojK.omN.H(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.omU.aj(Integer.parseInt(view.getTag().toString()), k.this.dYe());
                        }
                    }
                });
            }
            if (this.ojK.omQ != null) {
                this.ojK.omQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.omU.zG(false);
                                if (k.this.ojK != null) {
                                    if (k.this.omY == null || k.this.omY.getChosedFiles() == null || k.this.omY.getChosedFiles().size() <= 0 || !k.this.omY.isOriginalImg() || k.this.omX <= 0 || !k.this.dZG()) {
                                        k.this.ojK.a(true, k.this.omY);
                                    } else {
                                        k.this.ojK.dZD();
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
            this.omV = bundle.getInt("OutState_Write_Entrance");
            this.jtH = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.omV = intent.getIntExtra("FourmWriteIndex", 0);
            this.jtH = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.omY = new WriteImagesInfo();
            this.omY.parseJson(str);
            dZE();
            if (this.ojK != null && this.ojK.omO != null) {
                this.omU = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.ojK.omO, this.omY.getChosedFiles(), i, this, this.ojK, this.omY.mIsFromIm);
                this.ojK.omO.setAdapter(this.omU);
                int dXX = this.omU.dXX();
                this.ojK.omO.setCurrentItem(dXX, true);
                if (dXX == 0) {
                    this.omU.onPageSelected(0);
                }
                this.ojK.c(this.omY);
            }
        }
    }

    private void dZE() {
        if (this.omY != null && this.omY.isOriginalImg() && this.omY.getChosedFiles() != null && this.omY.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.omY.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.omZ.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dZF() {
        return this.omV;
    }

    public ForumWriteData cDk() {
        return this.jtH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZG() {
        if (this.omY == null || !this.omY.isOriginalImg() || this.omY.getChosedFiles() == null || this.omY.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.omY.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.omZ.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dYd() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dYe() {
        return (this.ojK == null || this.ojK.omP == null || y.isEmpty(this.ojK.omP.getStickerViews())) ? false : true;
    }

    public void dZC() {
        this.omX++;
    }

    public void dZH() {
        this.omX--;
    }

    public WriteImagesInfo dZI() {
        return this.omY;
    }

    public void zM(boolean z) {
        if (dYe()) {
            this.ojK.omO.setmDisallowSlip(true);
        } else {
            this.ojK.omO.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dYb() {
        dZH();
        zM(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ak(int i, boolean z) {
        al(i, z);
    }

    private void al(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.ojL == null) {
                this.ojL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.ojL.nx(R.string.orginal_tip);
                this.ojL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.ojL != null) {
                            k.this.ojL.dismiss();
                        }
                        if (k.this.omU != null) {
                            k.this.omU.aj(i, z);
                        }
                    }
                });
                this.ojL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.ojL != null) {
                            k.this.ojL.dismiss();
                        }
                    }
                });
                this.ojL.b(this.mPageContext);
            }
            this.ojL.bqx();
        }
    }

    public boolean V(final Bitmap bitmap) {
        if (!this.omU.dXY() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.ojL == null) {
            this.ojL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.ojL.nx(R.string.orginal_tip);
            this.ojL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.ojL != null) {
                        k.this.ojL.dismiss();
                    }
                    k.this.ojK.U(bitmap);
                }
            });
            this.ojL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.ojL != null) {
                        k.this.ojL.dismiss();
                    }
                }
            });
            this.ojL.b(this.mPageContext);
        }
        this.ojL.bqx();
        return true;
    }

    public void destroy() {
        if (this.omW != null) {
            this.omW.destroy();
        }
    }
}
