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
    private h lDO;
    private com.baidu.tbadk.core.dialog.a lDP;
    private StickerModel lGk;
    private ForumWriteData lpi;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    public MultiImagePagerAdapter lGi = null;
    private int lGj = 0;
    private int lGl = 0;
    private WriteImagesInfo lGm = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> lGn = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.lDO = hVar;
        initData(bundle);
        initListener();
        dgJ();
    }

    public void dgJ() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.lGk == null) {
                this.lGk = new StickerModel(this.mPageContext);
            }
            this.lGk.LoadData();
            this.lGk.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eQ(List<String> list) {
        if (this.lDO != null) {
            this.lDO.eP(list);
        }
    }

    private void initListener() {
        if (this.lDO != null) {
            if (this.lDO.lGb != null) {
                this.lDO.lGb.E(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.lGi.aa(Integer.parseInt(view.getTag().toString()), i.this.dgL());
                        }
                    }
                });
            }
            if (this.lDO.lGe != null) {
                this.lDO.lGe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.lGi.va(false);
                                if (i.this.lDO != null) {
                                    if (i.this.lGm == null || i.this.lGm.getChosedFiles() == null || i.this.lGm.getChosedFiles().size() <= 0 || !i.this.lGm.isOriginalImg() || i.this.lGl <= 0 || !i.this.dhP()) {
                                        i.this.lDO.b(true, i.this.lGm);
                                    } else {
                                        i.this.lDO.dhM();
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
            this.lGj = bundle.getInt("OutState_Write_Entrance");
            this.lpi = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.lGj = intent.getIntExtra("FourmWriteIndex", 0);
            this.lpi = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.lGm = new WriteImagesInfo();
            this.lGm.parseJson(str);
            dhN();
            if (this.lDO != null && this.lDO.lGc != null) {
                this.lGi = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.lDO.lGc, this.lGm.getChosedFiles(), i, this, this.lDO, this.lGm.mIsFromIm);
                this.lDO.lGc.setAdapter(this.lGi);
                int dgE = this.lGi.dgE();
                this.lDO.lGc.setCurrentItem(dgE, true);
                if (dgE == 0) {
                    this.lGi.onPageSelected(0);
                }
                this.lDO.c(this.lGm);
            }
        }
    }

    private void dhN() {
        if (this.lGm != null && this.lGm.isOriginalImg() && this.lGm.getChosedFiles() != null && this.lGm.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.lGm.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.lGn.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dhO() {
        return this.lGj;
    }

    public ForumWriteData bPb() {
        return this.lpi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhP() {
        if (this.lGm == null || !this.lGm.isOriginalImg() || this.lGm.getChosedFiles() == null || this.lGm.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.lGm.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.lGn.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dgK() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dgL() {
        return (this.lDO == null || this.lDO.lGd == null || v.isEmpty(this.lDO.lGd.getStickerViews())) ? false : true;
    }

    public void dhL() {
        this.lGl++;
    }

    public void dhQ() {
        this.lGl--;
    }

    public WriteImagesInfo dhR() {
        return this.lGm;
    }

    public void vf(boolean z) {
        if (dgL()) {
            this.lDO.lGc.setmDisallowSlip(true);
        } else {
            this.lDO.lGc.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dgI() {
        dhQ();
        vf(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ab(int i, boolean z) {
        ad(i, z);
    }

    private void ad(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.lDP == null) {
                this.lDP = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.lDP.kd(R.string.orginal_tip);
                this.lDP.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.lDP != null) {
                            i.this.lDP.dismiss();
                        }
                        if (i.this.lGi != null) {
                            i.this.lGi.aa(i, z);
                        }
                    }
                });
                this.lDP.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.lDP != null) {
                            i.this.lDP.dismiss();
                        }
                    }
                });
                this.lDP.b(this.mPageContext);
            }
            this.lDP.aMS();
        }
    }

    public boolean S(final Bitmap bitmap) {
        if (!this.lGi.dgF() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.lDP == null) {
            this.lDP = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.lDP.kd(R.string.orginal_tip);
            this.lDP.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.lDP != null) {
                        i.this.lDP.dismiss();
                    }
                    i.this.lDO.R(bitmap);
                }
            });
            this.lDP.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.lDP != null) {
                        i.this.lDP.dismiss();
                    }
                }
            });
            this.lDP.b(this.mPageContext);
        }
        this.lDP.aMS();
        return true;
    }

    public void destroy() {
        if (this.lGk != null) {
            this.lGk.destroy();
        }
    }
}
