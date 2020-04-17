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
/* loaded from: classes2.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private h lDK;
    private com.baidu.tbadk.core.dialog.a lDL;
    private StickerModel lGg;
    private ForumWriteData lpe;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    public MultiImagePagerAdapter lGe = null;
    private int lGf = 0;
    private int lGh = 0;
    private WriteImagesInfo lGi = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> lGj = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.lDK = hVar;
        initData(bundle);
        initListener();
        dgL();
    }

    public void dgL() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.lGg == null) {
                this.lGg = new StickerModel(this.mPageContext);
            }
            this.lGg.LoadData();
            this.lGg.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eQ(List<String> list) {
        if (this.lDK != null) {
            this.lDK.eP(list);
        }
    }

    private void initListener() {
        if (this.lDK != null) {
            if (this.lDK.lFX != null) {
                this.lDK.lFX.E(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.lGe.aa(Integer.parseInt(view.getTag().toString()), i.this.dgN());
                        }
                    }
                });
            }
            if (this.lDK.lGa != null) {
                this.lDK.lGa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new PermissionJudgePolicy();
                            }
                            i.this.mPermissionJudgement.clearRequestPermissionList();
                            i.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                i.this.lGe.va(false);
                                if (i.this.lDK != null) {
                                    if (i.this.lGi == null || i.this.lGi.getChosedFiles() == null || i.this.lGi.getChosedFiles().size() <= 0 || !i.this.lGi.isOriginalImg() || i.this.lGh <= 0 || !i.this.dhR()) {
                                        i.this.lDK.b(true, i.this.lGi);
                                    } else {
                                        i.this.lDK.dhO();
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
            this.lGf = bundle.getInt("OutState_Write_Entrance");
            this.lpe = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.lGf = intent.getIntExtra("FourmWriteIndex", 0);
            this.lpe = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.lGi = new WriteImagesInfo();
            this.lGi.parseJson(str);
            dhP();
            if (this.lDK != null && this.lDK.lFY != null) {
                this.lGe = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.lDK.lFY, this.lGi.getChosedFiles(), i, this, this.lDK, this.lGi.mIsFromIm);
                this.lDK.lFY.setAdapter(this.lGe);
                int dgG = this.lGe.dgG();
                this.lDK.lFY.setCurrentItem(dgG, true);
                if (dgG == 0) {
                    this.lGe.onPageSelected(0);
                }
                this.lDK.c(this.lGi);
            }
        }
    }

    private void dhP() {
        if (this.lGi != null && this.lGi.isOriginalImg() && this.lGi.getChosedFiles() != null && this.lGi.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.lGi.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.lGj.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dhQ() {
        return this.lGf;
    }

    public ForumWriteData bPc() {
        return this.lpe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhR() {
        if (this.lGi == null || !this.lGi.isOriginalImg() || this.lGi.getChosedFiles() == null || this.lGi.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.lGi.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.lGj.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dgM() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dgN() {
        return (this.lDK == null || this.lDK.lFZ == null || v.isEmpty(this.lDK.lFZ.getStickerViews())) ? false : true;
    }

    public void dhN() {
        this.lGh++;
    }

    public void dhS() {
        this.lGh--;
    }

    public WriteImagesInfo dhT() {
        return this.lGi;
    }

    public void vf(boolean z) {
        if (dgN()) {
            this.lDK.lFY.setmDisallowSlip(true);
        } else {
            this.lDK.lFY.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dgK() {
        dhS();
        vf(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ab(int i, boolean z) {
        ad(i, z);
    }

    private void ad(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.lDL == null) {
                this.lDL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.lDL.kd(R.string.orginal_tip);
                this.lDL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.lDL != null) {
                            i.this.lDL.dismiss();
                        }
                        if (i.this.lGe != null) {
                            i.this.lGe.aa(i, z);
                        }
                    }
                });
                this.lDL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.lDL != null) {
                            i.this.lDL.dismiss();
                        }
                    }
                });
                this.lDL.b(this.mPageContext);
            }
            this.lDL.aMU();
        }
    }

    public boolean S(final Bitmap bitmap) {
        if (!this.lGe.dgH() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.lDL == null) {
            this.lDL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.lDL.kd(R.string.orginal_tip);
            this.lDL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.lDL != null) {
                        i.this.lDL.dismiss();
                    }
                    i.this.lDK.R(bitmap);
                }
            });
            this.lDL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.lDL != null) {
                        i.this.lDL.dismiss();
                    }
                }
            });
            this.lDL.b(this.mPageContext);
        }
        this.lDL.aMU();
        return true;
    }

    public void destroy() {
        if (this.lGg != null) {
            this.lGg.destroy();
        }
    }
}
