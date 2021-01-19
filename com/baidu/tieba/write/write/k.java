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
    private j nZp;
    private com.baidu.tbadk.core.dialog.a nZq;
    private StickerModel ocE;
    public MultiImagePagerAdapter ocC = null;
    private int ocD = 0;
    private int ocF = 0;
    private WriteImagesInfo ocG = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> ocH = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.nZp = jVar;
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
            if (this.ocE == null) {
                this.ocE = new StickerModel(this.mPageContext);
            }
            this.ocE.LoadData();
            this.ocE.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void go(List<String> list) {
        if (this.nZp != null) {
            this.nZp.gn(list);
        }
    }

    private void initListener() {
        if (this.nZp != null) {
            if (this.nZp.ocv != null) {
                this.nZp.ocv.H(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.ocC.aj(Integer.parseInt(view.getTag().toString()), k.this.dVL());
                        }
                    }
                });
            }
            if (this.nZp.ocy != null) {
                this.nZp.ocy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.ocC.zl(false);
                                if (k.this.nZp != null) {
                                    if (k.this.ocG == null || k.this.ocG.getChosedFiles() == null || k.this.ocG.getChosedFiles().size() <= 0 || !k.this.ocG.isOriginalImg() || k.this.ocF <= 0 || !k.this.dXn()) {
                                        k.this.nZp.a(true, k.this.ocG);
                                    } else {
                                        k.this.nZp.dXk();
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
            this.ocD = bundle.getInt("OutState_Write_Entrance");
            this.jnN = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.ocD = intent.getIntExtra("FourmWriteIndex", 0);
            this.jnN = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.ocG = new WriteImagesInfo();
            this.ocG.parseJson(str);
            dXl();
            if (this.nZp != null && this.nZp.ocw != null) {
                this.ocC = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.nZp.ocw, this.ocG.getChosedFiles(), i, this, this.nZp, this.ocG.mIsFromIm);
                this.nZp.ocw.setAdapter(this.ocC);
                int dVE = this.ocC.dVE();
                this.nZp.ocw.setCurrentItem(dVE, true);
                if (dVE == 0) {
                    this.ocC.onPageSelected(0);
                }
                this.nZp.c(this.ocG);
            }
        }
    }

    private void dXl() {
        if (this.ocG != null && this.ocG.isOriginalImg() && this.ocG.getChosedFiles() != null && this.ocG.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.ocG.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.ocH.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dXm() {
        return this.ocD;
    }

    public ForumWriteData cBR() {
        return this.jnN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dXn() {
        if (this.ocG == null || !this.ocG.isOriginalImg() || this.ocG.getChosedFiles() == null || this.ocG.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.ocG.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.ocH.get(next.getFilePath()))) {
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
        return (this.nZp == null || this.nZp.ocx == null || x.isEmpty(this.nZp.ocx.getStickerViews())) ? false : true;
    }

    public void dXj() {
        this.ocF++;
    }

    public void dXo() {
        this.ocF--;
    }

    public WriteImagesInfo dXp() {
        return this.ocG;
    }

    public void zr(boolean z) {
        if (dVL()) {
            this.nZp.ocw.setmDisallowSlip(true);
        } else {
            this.nZp.ocw.setmDisallowSlip(false);
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
            if (this.nZq == null) {
                this.nZq = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.nZq.nu(R.string.orginal_tip);
                this.nZq.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nZq != null) {
                            k.this.nZq.dismiss();
                        }
                        if (k.this.ocC != null) {
                            k.this.ocC.aj(i, z);
                        }
                    }
                });
                this.nZq.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nZq != null) {
                            k.this.nZq.dismiss();
                        }
                    }
                });
                this.nZq.b(this.mPageContext);
            }
            this.nZq.bqe();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.ocC.dVF() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.nZq == null) {
            this.nZq = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.nZq.nu(R.string.orginal_tip);
            this.nZq.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nZq != null) {
                        k.this.nZq.dismiss();
                    }
                    k.this.nZp.V(bitmap);
                }
            });
            this.nZq.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nZq != null) {
                        k.this.nZq.dismiss();
                    }
                }
            });
            this.nZq.b(this.mPageContext);
        }
        this.nZq.bqe();
        return true;
    }

    public void destroy() {
        if (this.ocE != null) {
            this.ocE.destroy();
        }
    }
}
