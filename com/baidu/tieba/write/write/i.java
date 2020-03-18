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
/* loaded from: classes13.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData kEC;
    private h kTK;
    private com.baidu.tbadk.core.dialog.a kTL;
    private StickerModel kWf;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    public MultiImagePagerAdapter kWd = null;
    private int kWe = 0;
    private int kWg = 0;
    private WriteImagesInfo kWh = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> kWi = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kTK = hVar;
        initData(bundle);
        initListener();
        cWd();
    }

    public void cWd() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.kWf == null) {
                this.kWf = new StickerModel(this.mPageContext);
            }
            this.kWf.LoadData();
            this.kWf.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eB(List<String> list) {
        if (this.kTK != null) {
            this.kTK.eA(list);
        }
    }

    private void initListener() {
        if (this.kTK != null) {
            if (this.kTK.kVW != null) {
                this.kTK.kVW.D(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.kWd.T(Integer.parseInt(view.getTag().toString()), i.this.cWf());
                        }
                    }
                });
            }
            if (this.kTK.kVZ != null) {
                this.kTK.kVZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.kWd.tY(false);
                                if (i.this.kTK != null) {
                                    if (i.this.kWh == null || i.this.kWh.getChosedFiles() == null || i.this.kWh.getChosedFiles().size() <= 0 || !i.this.kWh.isOriginalImg() || i.this.kWg <= 0 || !i.this.cXj()) {
                                        i.this.kTK.b(true, i.this.kWh);
                                    } else {
                                        i.this.kTK.cXg();
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
            this.kWe = bundle.getInt("OutState_Write_Entrance");
            this.kEC = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.kWe = intent.getIntExtra("FourmWriteIndex", 0);
            this.kEC = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.kWh = new WriteImagesInfo();
            this.kWh.parseJson(str);
            cXh();
            if (this.kTK != null && this.kTK.kVX != null) {
                this.kWd = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.kTK.kVX, this.kWh.getChosedFiles(), i, this, this.kTK, this.kWh.mIsFromIm);
                this.kTK.kVX.setAdapter(this.kWd);
                int cVY = this.kWd.cVY();
                this.kTK.kVX.setCurrentItem(cVY, true);
                if (cVY == 0) {
                    this.kWd.onPageSelected(0);
                }
                this.kTK.c(this.kWh);
            }
        }
    }

    private void cXh() {
        if (this.kWh != null && this.kWh.isOriginalImg() && this.kWh.getChosedFiles() != null && this.kWh.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.kWh.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.kWi.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cXi() {
        return this.kWe;
    }

    public ForumWriteData bED() {
        return this.kEC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cXj() {
        if (this.kWh == null || !this.kWh.isOriginalImg() || this.kWh.getChosedFiles() == null || this.kWh.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.kWh.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.kWi.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cWe() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cWf() {
        return (this.kTK == null || this.kTK.kVY == null || v.isEmpty(this.kTK.kVY.getStickerViews())) ? false : true;
    }

    public void cXf() {
        this.kWg++;
    }

    public void cXk() {
        this.kWg--;
    }

    public WriteImagesInfo cXl() {
        return this.kWh;
    }

    public void ud(boolean z) {
        if (cWf()) {
            this.kTK.kVX.setmDisallowSlip(true);
        } else {
            this.kTK.kVX.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cWc() {
        cXk();
        ud(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void U(int i, boolean z) {
        W(i, z);
    }

    private void W(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.kTL == null) {
                this.kTL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.kTL.jW(R.string.orginal_tip);
                this.kTL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kTL != null) {
                            i.this.kTL.dismiss();
                        }
                        if (i.this.kWd != null) {
                            i.this.kWd.T(i, z);
                        }
                    }
                });
                this.kTL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kTL != null) {
                            i.this.kTL.dismiss();
                        }
                    }
                });
                this.kTL.b(this.mPageContext);
            }
            this.kTL.aEG();
        }
    }

    public boolean P(final Bitmap bitmap) {
        if (!this.kWd.cVZ() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.kTL == null) {
            this.kTL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.kTL.jW(R.string.orginal_tip);
            this.kTL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kTL != null) {
                        i.this.kTL.dismiss();
                    }
                    i.this.kTK.O(bitmap);
                }
            });
            this.kTL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kTL != null) {
                        i.this.kTL.dismiss();
                    }
                }
            });
            this.kTL.b(this.mPageContext);
        }
        this.kTL.aEG();
        return true;
    }

    public void destroy() {
        if (this.kWf != null) {
            this.kWf.destroy();
        }
    }
}
