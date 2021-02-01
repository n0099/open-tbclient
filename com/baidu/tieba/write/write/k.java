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
    private ForumWriteData jtt;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j ojk;
    private com.baidu.tbadk.core.dialog.a ojl;
    private StickerModel omw;
    public MultiImagePagerAdapter omu = null;
    private int omv = 0;
    private int omx = 0;
    private WriteImagesInfo omy = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> omz = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ojk = jVar;
        initData(bundle);
        initListener();
        dXU();
    }

    public void dXU() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.omw == null) {
                this.omw = new StickerModel(this.mPageContext);
            }
            this.omw.LoadData();
            this.omw.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void gm(List<String> list) {
        if (this.ojk != null) {
            this.ojk.gl(list);
        }
    }

    private void initListener() {
        if (this.ojk != null) {
            if (this.ojk.omn != null) {
                this.ojk.omn.H(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.omu.aj(Integer.parseInt(view.getTag().toString()), k.this.dXW());
                        }
                    }
                });
            }
            if (this.ojk.omq != null) {
                this.ojk.omq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.omu.zG(false);
                                if (k.this.ojk != null) {
                                    if (k.this.omy == null || k.this.omy.getChosedFiles() == null || k.this.omy.getChosedFiles().size() <= 0 || !k.this.omy.isOriginalImg() || k.this.omx <= 0 || !k.this.dZy()) {
                                        k.this.ojk.a(true, k.this.omy);
                                    } else {
                                        k.this.ojk.dZv();
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
            this.omv = bundle.getInt("OutState_Write_Entrance");
            this.jtt = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.omv = intent.getIntExtra("FourmWriteIndex", 0);
            this.jtt = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.omy = new WriteImagesInfo();
            this.omy.parseJson(str);
            dZw();
            if (this.ojk != null && this.ojk.omo != null) {
                this.omu = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.ojk.omo, this.omy.getChosedFiles(), i, this, this.ojk, this.omy.mIsFromIm);
                this.ojk.omo.setAdapter(this.omu);
                int dXP = this.omu.dXP();
                this.ojk.omo.setCurrentItem(dXP, true);
                if (dXP == 0) {
                    this.omu.onPageSelected(0);
                }
                this.ojk.c(this.omy);
            }
        }
    }

    private void dZw() {
        if (this.omy != null && this.omy.isOriginalImg() && this.omy.getChosedFiles() != null && this.omy.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.omy.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.omz.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dZx() {
        return this.omv;
    }

    public ForumWriteData cDd() {
        return this.jtt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZy() {
        if (this.omy == null || !this.omy.isOriginalImg() || this.omy.getChosedFiles() == null || this.omy.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.omy.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.omz.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dXV() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dXW() {
        return (this.ojk == null || this.ojk.omp == null || y.isEmpty(this.ojk.omp.getStickerViews())) ? false : true;
    }

    public void dZu() {
        this.omx++;
    }

    public void dZz() {
        this.omx--;
    }

    public WriteImagesInfo dZA() {
        return this.omy;
    }

    public void zM(boolean z) {
        if (dXW()) {
            this.ojk.omo.setmDisallowSlip(true);
        } else {
            this.ojk.omo.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dXT() {
        dZz();
        zM(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ak(int i, boolean z) {
        al(i, z);
    }

    private void al(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.ojl == null) {
                this.ojl = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.ojl.nx(R.string.orginal_tip);
                this.ojl.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.ojl != null) {
                            k.this.ojl.dismiss();
                        }
                        if (k.this.omu != null) {
                            k.this.omu.aj(i, z);
                        }
                    }
                });
                this.ojl.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.ojl != null) {
                            k.this.ojl.dismiss();
                        }
                    }
                });
                this.ojl.b(this.mPageContext);
            }
            this.ojl.bqx();
        }
    }

    public boolean V(final Bitmap bitmap) {
        if (!this.omu.dXQ() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.ojl == null) {
            this.ojl = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.ojl.nx(R.string.orginal_tip);
            this.ojl.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.ojl != null) {
                        k.this.ojl.dismiss();
                    }
                    k.this.ojk.U(bitmap);
                }
            });
            this.ojl.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.ojl != null) {
                        k.this.ojl.dismiss();
                    }
                }
            });
            this.ojl.b(this.mPageContext);
        }
        this.ojl.bqx();
        return true;
    }

    public void destroy() {
        if (this.omw != null) {
            this.omw.destroy();
        }
    }
}
