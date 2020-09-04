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
    private ForumWriteData ifV;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j mUf;
    private com.baidu.tbadk.core.dialog.a mUg;
    private StickerModel mXb;
    public MultiImagePagerAdapter mWZ = null;
    private int mXa = 0;
    private int mXc = 0;
    private WriteImagesInfo mXd = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> mXe = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.mUf = jVar;
        initData(bundle);
        initListener();
        dHG();
    }

    public void dHG() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    com.baidu.adp.lib.util.l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.mXb == null) {
                this.mXb = new StickerModel(this.mPageContext);
            }
            this.mXb.LoadData();
            this.mXb.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void fF(List<String> list) {
        if (this.mUf != null) {
            this.mUf.fE(list);
        }
    }

    private void initListener() {
        if (this.mUf != null) {
            if (this.mUf.mWS != null) {
                this.mUf.mWS.F(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.mWZ.ai(Integer.parseInt(view.getTag().toString()), k.this.dHI());
                        }
                    }
                });
            }
            if (this.mUf.mWV != null) {
                this.mUf.mWV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.mWZ.xq(false);
                                if (k.this.mUf != null) {
                                    if (k.this.mXd == null || k.this.mXd.getChosedFiles() == null || k.this.mXd.getChosedFiles().size() <= 0 || !k.this.mXd.isOriginalImg() || k.this.mXc <= 0 || !k.this.dJd()) {
                                        k.this.mUf.b(true, k.this.mXd);
                                    } else {
                                        k.this.mUf.dJa();
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
            this.mXa = bundle.getInt("OutState_Write_Entrance");
            this.ifV = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.mXa = intent.getIntExtra("FourmWriteIndex", 0);
            this.ifV = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.mXd = new WriteImagesInfo();
            this.mXd.parseJson(str);
            dJb();
            if (this.mUf != null && this.mUf.mWT != null) {
                this.mWZ = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.mUf.mWT, this.mXd.getChosedFiles(), i, this, this.mUf, this.mXd.mIsFromIm);
                this.mUf.mWT.setAdapter(this.mWZ);
                int dHB = this.mWZ.dHB();
                this.mUf.mWT.setCurrentItem(dHB, true);
                if (dHB == 0) {
                    this.mWZ.onPageSelected(0);
                }
                this.mUf.c(this.mXd);
            }
        }
    }

    private void dJb() {
        if (this.mXd != null && this.mXd.isOriginalImg() && this.mXd.getChosedFiles() != null && this.mXd.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.mXd.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.mXe.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dJc() {
        return this.mXa;
    }

    public ForumWriteData cmB() {
        return this.ifV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dJd() {
        if (this.mXd == null || !this.mXd.isOriginalImg() || this.mXd.getChosedFiles() == null || this.mXd.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.mXd.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.mXe.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dHH() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dHI() {
        return (this.mUf == null || this.mUf.mWU == null || y.isEmpty(this.mUf.mWU.getStickerViews())) ? false : true;
    }

    public void dIZ() {
        this.mXc++;
    }

    public void dJe() {
        this.mXc--;
    }

    public WriteImagesInfo dJf() {
        return this.mXd;
    }

    public void xw(boolean z) {
        if (dHI()) {
            this.mUf.mWT.setmDisallowSlip(true);
        } else {
            this.mUf.mWT.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dHF() {
        dJe();
        xw(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void aj(int i, boolean z) {
        ak(i, z);
    }

    private void ak(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.mUg == null) {
                this.mUg = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.mUg.nt(R.string.orginal_tip);
                this.mUg.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.mUg != null) {
                            k.this.mUg.dismiss();
                        }
                        if (k.this.mWZ != null) {
                            k.this.mWZ.ai(i, z);
                        }
                    }
                });
                this.mUg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.mUg != null) {
                            k.this.mUg.dismiss();
                        }
                    }
                });
                this.mUg.b(this.mPageContext);
            }
            this.mUg.bhg();
        }
    }

    public boolean X(final Bitmap bitmap) {
        if (!this.mWZ.dHC() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.mUg == null) {
            this.mUg = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.mUg.nt(R.string.orginal_tip);
            this.mUg.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.mUg != null) {
                        k.this.mUg.dismiss();
                    }
                    k.this.mUf.W(bitmap);
                }
            });
            this.mUg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.mUg != null) {
                        k.this.mUg.dismiss();
                    }
                }
            });
            this.mUg.b(this.mPageContext);
        }
        this.mUg.bhg();
        return true;
    }

    public void destroy() {
        if (this.mXb != null) {
            this.mXb.destroy();
        }
    }
}
