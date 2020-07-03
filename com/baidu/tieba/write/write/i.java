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
    private h msV;
    private com.baidu.tbadk.core.dialog.a msW;
    private StickerModel mvA;
    public MultiImagePagerAdapter mvy = null;
    private int mvz = 0;
    private int mvB = 0;
    private WriteImagesInfo mvC = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> mvD = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.msV = hVar;
        initData(bundle);
        initListener();
        dsD();
    }

    public void dsD() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.mvA == null) {
                this.mvA = new StickerModel(this.mPageContext);
            }
            this.mvA.LoadData();
            this.mvA.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void fm(List<String> list) {
        if (this.msV != null) {
            this.msV.fl(list);
        }
    }

    private void initListener() {
        if (this.msV != null) {
            if (this.msV.mvr != null) {
                this.msV.mvr.E(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.mvy.ah(Integer.parseInt(view.getTag().toString()), i.this.dsF());
                        }
                    }
                });
            }
            if (this.msV.mvu != null) {
                this.msV.mvu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.mvy.vT(false);
                                if (i.this.msV != null) {
                                    if (i.this.mvC == null || i.this.mvC.getChosedFiles() == null || i.this.mvC.getChosedFiles().size() <= 0 || !i.this.mvC.isOriginalImg() || i.this.mvB <= 0 || !i.this.dtP()) {
                                        i.this.msV.b(true, i.this.mvC);
                                    } else {
                                        i.this.msV.dtM();
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
            this.mvz = bundle.getInt("OutState_Write_Entrance");
            this.hLG = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.mvz = intent.getIntExtra("FourmWriteIndex", 0);
            this.hLG = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.mvC = new WriteImagesInfo();
            this.mvC.parseJson(str);
            dtN();
            if (this.msV != null && this.msV.mvs != null) {
                this.mvy = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.msV.mvs, this.mvC.getChosedFiles(), i, this, this.msV, this.mvC.mIsFromIm);
                this.msV.mvs.setAdapter(this.mvy);
                int dsy = this.mvy.dsy();
                this.msV.mvs.setCurrentItem(dsy, true);
                if (dsy == 0) {
                    this.mvy.onPageSelected(0);
                }
                this.msV.c(this.mvC);
            }
        }
    }

    private void dtN() {
        if (this.mvC != null && this.mvC.isOriginalImg() && this.mvC.getChosedFiles() != null && this.mvC.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.mvC.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.mvD.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dtO() {
        return this.mvz;
    }

    public ForumWriteData bYF() {
        return this.hLG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dtP() {
        if (this.mvC == null || !this.mvC.isOriginalImg() || this.mvC.getChosedFiles() == null || this.mvC.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.mvC.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.mvD.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dsE() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dsF() {
        return (this.msV == null || this.msV.mvt == null || w.isEmpty(this.msV.mvt.getStickerViews())) ? false : true;
    }

    public void dtL() {
        this.mvB++;
    }

    public void dtQ() {
        this.mvB--;
    }

    public WriteImagesInfo dtR() {
        return this.mvC;
    }

    public void vZ(boolean z) {
        if (dsF()) {
            this.msV.mvs.setmDisallowSlip(true);
        } else {
            this.msV.mvs.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dsC() {
        dtQ();
        vZ(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ai(int i, boolean z) {
        aj(i, z);
    }

    private void aj(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.msW == null) {
                this.msW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.msW.kT(R.string.orginal_tip);
                this.msW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.msW != null) {
                            i.this.msW.dismiss();
                        }
                        if (i.this.mvy != null) {
                            i.this.mvy.ah(i, z);
                        }
                    }
                });
                this.msW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.msW != null) {
                            i.this.msW.dismiss();
                        }
                    }
                });
                this.msW.b(this.mPageContext);
            }
            this.msW.aUN();
        }
    }

    public boolean U(final Bitmap bitmap) {
        if (!this.mvy.dsz() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.msW == null) {
            this.msW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.msW.kT(R.string.orginal_tip);
            this.msW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.msW != null) {
                        i.this.msW.dismiss();
                    }
                    i.this.msV.T(bitmap);
                }
            });
            this.msW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.msW != null) {
                        i.this.msW.dismiss();
                    }
                }
            });
            this.msW.b(this.mPageContext);
        }
        this.msW.aUN();
        return true;
    }

    public void destroy() {
        if (this.mvA != null) {
            this.mvA.destroy();
        }
    }
}
