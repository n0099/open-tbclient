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
import com.baidu.tbadk.core.util.x;
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
    private ForumWriteData jnN;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j nZo;
    private com.baidu.tbadk.core.dialog.a nZp;
    private StickerModel ocD;
    public MultiImagePagerAdapter ocB = null;
    private int ocC = 0;
    private int ocE = 0;
    private WriteImagesInfo ocF = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> ocG = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.nZo = jVar;
        initData(bundle);
        initListener();
        dVJ();
    }

    public void dVJ() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.ocD == null) {
                this.ocD = new StickerModel(this.mPageContext);
            }
            this.ocD.LoadData();
            this.ocD.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void go(List<String> list) {
        if (this.nZo != null) {
            this.nZo.gn(list);
        }
    }

    private void initListener() {
        if (this.nZo != null) {
            if (this.nZo.ocu != null) {
                this.nZo.ocu.H(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.ocB.aj(Integer.parseInt(view.getTag().toString()), k.this.dVL());
                        }
                    }
                });
            }
            if (this.nZo.ocx != null) {
                this.nZo.ocx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.ocB.zl(false);
                                if (k.this.nZo != null) {
                                    if (k.this.ocF == null || k.this.ocF.getChosedFiles() == null || k.this.ocF.getChosedFiles().size() <= 0 || !k.this.ocF.isOriginalImg() || k.this.ocE <= 0 || !k.this.dXn()) {
                                        k.this.nZo.a(true, k.this.ocF);
                                    } else {
                                        k.this.nZo.dXk();
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
            this.ocC = bundle.getInt("OutState_Write_Entrance");
            this.jnN = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.ocC = intent.getIntExtra("FourmWriteIndex", 0);
            this.jnN = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.ocF = new WriteImagesInfo();
            this.ocF.parseJson(str);
            dXl();
            if (this.nZo != null && this.nZo.ocv != null) {
                this.ocB = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.nZo.ocv, this.ocF.getChosedFiles(), i, this, this.nZo, this.ocF.mIsFromIm);
                this.nZo.ocv.setAdapter(this.ocB);
                int dVE = this.ocB.dVE();
                this.nZo.ocv.setCurrentItem(dVE, true);
                if (dVE == 0) {
                    this.ocB.onPageSelected(0);
                }
                this.nZo.c(this.ocF);
            }
        }
    }

    private void dXl() {
        if (this.ocF != null && this.ocF.isOriginalImg() && this.ocF.getChosedFiles() != null && this.ocF.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.ocF.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.ocG.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dXm() {
        return this.ocC;
    }

    public ForumWriteData cBR() {
        return this.jnN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dXn() {
        if (this.ocF == null || !this.ocF.isOriginalImg() || this.ocF.getChosedFiles() == null || this.ocF.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.ocF.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.ocG.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dVK() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dVL() {
        return (this.nZo == null || this.nZo.ocw == null || x.isEmpty(this.nZo.ocw.getStickerViews())) ? false : true;
    }

    public void dXj() {
        this.ocE++;
    }

    public void dXo() {
        this.ocE--;
    }

    public WriteImagesInfo dXp() {
        return this.ocF;
    }

    public void zr(boolean z) {
        if (dVL()) {
            this.nZo.ocv.setmDisallowSlip(true);
        } else {
            this.nZo.ocv.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dVI() {
        dXo();
        zr(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ak(int i, boolean z) {
        al(i, z);
    }

    private void al(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.nZp == null) {
                this.nZp = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.nZp.nu(R.string.orginal_tip);
                this.nZp.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nZp != null) {
                            k.this.nZp.dismiss();
                        }
                        if (k.this.ocB != null) {
                            k.this.ocB.aj(i, z);
                        }
                    }
                });
                this.nZp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nZp != null) {
                            k.this.nZp.dismiss();
                        }
                    }
                });
                this.nZp.b(this.mPageContext);
            }
            this.nZp.bqe();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.ocB.dVF() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.nZp == null) {
            this.nZp = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.nZp.nu(R.string.orginal_tip);
            this.nZp.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nZp != null) {
                        k.this.nZp.dismiss();
                    }
                    k.this.nZo.V(bitmap);
                }
            });
            this.nZp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nZp != null) {
                        k.this.nZp.dismiss();
                    }
                }
            });
            this.nZp.b(this.mPageContext);
        }
        this.nZp.bqe();
        return true;
    }

    public void destroy() {
        if (this.ocD != null) {
            this.ocD.destroy();
        }
    }
}
