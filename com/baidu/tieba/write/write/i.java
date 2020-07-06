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
import com.baidu.tbadk.core.util.w;
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
    private ForumWriteData hLG;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private h msY;
    private com.baidu.tbadk.core.dialog.a msZ;
    private StickerModel mvD;
    public MultiImagePagerAdapter mvB = null;
    private int mvC = 0;
    private int mvE = 0;
    private WriteImagesInfo mvF = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> mvG = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.msY = hVar;
        initData(bundle);
        initListener();
        dsH();
    }

    public void dsH() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.mvD == null) {
                this.mvD = new StickerModel(this.mPageContext);
            }
            this.mvD.LoadData();
            this.mvD.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void fm(List<String> list) {
        if (this.msY != null) {
            this.msY.fl(list);
        }
    }

    private void initListener() {
        if (this.msY != null) {
            if (this.msY.mvu != null) {
                this.msY.mvu.E(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.mvB.ah(Integer.parseInt(view.getTag().toString()), i.this.dsJ());
                        }
                    }
                });
            }
            if (this.msY.mvx != null) {
                this.msY.mvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.mvB.vT(false);
                                if (i.this.msY != null) {
                                    if (i.this.mvF == null || i.this.mvF.getChosedFiles() == null || i.this.mvF.getChosedFiles().size() <= 0 || !i.this.mvF.isOriginalImg() || i.this.mvE <= 0 || !i.this.dtT()) {
                                        i.this.msY.b(true, i.this.mvF);
                                    } else {
                                        i.this.msY.dtQ();
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
            this.mvC = bundle.getInt("OutState_Write_Entrance");
            this.hLG = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.mvC = intent.getIntExtra("FourmWriteIndex", 0);
            this.hLG = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.mvF = new WriteImagesInfo();
            this.mvF.parseJson(str);
            dtR();
            if (this.msY != null && this.msY.mvv != null) {
                this.mvB = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.msY.mvv, this.mvF.getChosedFiles(), i, this, this.msY, this.mvF.mIsFromIm);
                this.msY.mvv.setAdapter(this.mvB);
                int dsC = this.mvB.dsC();
                this.msY.mvv.setCurrentItem(dsC, true);
                if (dsC == 0) {
                    this.mvB.onPageSelected(0);
                }
                this.msY.c(this.mvF);
            }
        }
    }

    private void dtR() {
        if (this.mvF != null && this.mvF.isOriginalImg() && this.mvF.getChosedFiles() != null && this.mvF.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.mvF.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.mvG.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dtS() {
        return this.mvC;
    }

    public ForumWriteData bYG() {
        return this.hLG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtT() {
        if (this.mvF == null || !this.mvF.isOriginalImg() || this.mvF.getChosedFiles() == null || this.mvF.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.mvF.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.mvG.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dsI() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dsJ() {
        return (this.msY == null || this.msY.mvw == null || w.isEmpty(this.msY.mvw.getStickerViews())) ? false : true;
    }

    public void dtP() {
        this.mvE++;
    }

    public void dtU() {
        this.mvE--;
    }

    public WriteImagesInfo dtV() {
        return this.mvF;
    }

    public void vZ(boolean z) {
        if (dsJ()) {
            this.msY.mvv.setmDisallowSlip(true);
        } else {
            this.msY.mvv.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dsG() {
        dtU();
        vZ(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ai(int i, boolean z) {
        aj(i, z);
    }

    private void aj(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.msZ == null) {
                this.msZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.msZ.kT(R.string.orginal_tip);
                this.msZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.msZ != null) {
                            i.this.msZ.dismiss();
                        }
                        if (i.this.mvB != null) {
                            i.this.mvB.ah(i, z);
                        }
                    }
                });
                this.msZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.msZ != null) {
                            i.this.msZ.dismiss();
                        }
                    }
                });
                this.msZ.b(this.mPageContext);
            }
            this.msZ.aUN();
        }
    }

    public boolean U(final Bitmap bitmap) {
        if (!this.mvB.dsD() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.msZ == null) {
            this.msZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.msZ.kT(R.string.orginal_tip);
            this.msZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.msZ != null) {
                        i.this.msZ.dismiss();
                    }
                    i.this.msY.T(bitmap);
                }
            });
            this.msZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.msZ != null) {
                        i.this.msZ.dismiss();
                    }
                }
            });
            this.msZ.b(this.mPageContext);
        }
        this.msZ.aUN();
        return true;
    }

    public void destroy() {
        if (this.mvD != null) {
            this.mvD.destroy();
        }
    }
}
