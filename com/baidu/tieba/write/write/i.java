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
/* loaded from: classes3.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData hRH;
    private h mAZ;
    private com.baidu.tbadk.core.dialog.a mBa;
    private StickerModel mDJ;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    public MultiImagePagerAdapter mDH = null;
    private int mDI = 0;
    private int mDK = 0;
    private WriteImagesInfo mDL = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> mDM = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.mAZ = hVar;
        initData(bundle);
        initListener();
        dvU();
    }

    public void dvU() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.mDJ == null) {
                this.mDJ = new StickerModel(this.mPageContext);
            }
            this.mDJ.LoadData();
            this.mDJ.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void fv(List<String> list) {
        if (this.mAZ != null) {
            this.mAZ.fu(list);
        }
    }

    private void initListener() {
        if (this.mAZ != null) {
            if (this.mAZ.mDA != null) {
                this.mAZ.mDA.E(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.mDH.ag(Integer.parseInt(view.getTag().toString()), i.this.dvW());
                        }
                    }
                });
            }
            if (this.mAZ.mDD != null) {
                this.mAZ.mDD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.mDH.wy(false);
                                if (i.this.mAZ != null) {
                                    if (i.this.mDL == null || i.this.mDL.getChosedFiles() == null || i.this.mDL.getChosedFiles().size() <= 0 || !i.this.mDL.isOriginalImg() || i.this.mDK <= 0 || !i.this.dxg()) {
                                        i.this.mAZ.b(true, i.this.mDL);
                                    } else {
                                        i.this.mAZ.dxd();
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
            this.mDI = bundle.getInt("OutState_Write_Entrance");
            this.hRH = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.mDI = intent.getIntExtra("FourmWriteIndex", 0);
            this.hRH = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.mDL = new WriteImagesInfo();
            this.mDL.parseJson(str);
            dxe();
            if (this.mAZ != null && this.mAZ.mDB != null) {
                this.mDH = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.mAZ.mDB, this.mDL.getChosedFiles(), i, this, this.mAZ, this.mDL.mIsFromIm);
                this.mAZ.mDB.setAdapter(this.mDH);
                int dvP = this.mDH.dvP();
                this.mAZ.mDB.setCurrentItem(dvP, true);
                if (dvP == 0) {
                    this.mDH.onPageSelected(0);
                }
                this.mAZ.c(this.mDL);
            }
        }
    }

    private void dxe() {
        if (this.mDL != null && this.mDL.isOriginalImg() && this.mDL.getChosedFiles() != null && this.mDL.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.mDL.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.mDM.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dxf() {
        return this.mDI;
    }

    public ForumWriteData ccd() {
        return this.hRH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dxg() {
        if (this.mDL == null || !this.mDL.isOriginalImg() || this.mDL.getChosedFiles() == null || this.mDL.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.mDL.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.mDM.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dvV() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dvW() {
        return (this.mAZ == null || this.mAZ.mDC == null || x.isEmpty(this.mAZ.mDC.getStickerViews())) ? false : true;
    }

    public void dxc() {
        this.mDK++;
    }

    public void dxh() {
        this.mDK--;
    }

    public WriteImagesInfo dxi() {
        return this.mDL;
    }

    public void wE(boolean z) {
        if (dvW()) {
            this.mAZ.mDB.setmDisallowSlip(true);
        } else {
            this.mAZ.mDB.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dvT() {
        dxh();
        wE(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ah(int i, boolean z) {
        ai(i, z);
    }

    private void ai(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.mBa == null) {
                this.mBa = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.mBa.ln(R.string.orginal_tip);
                this.mBa.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.mBa != null) {
                            i.this.mBa.dismiss();
                        }
                        if (i.this.mDH != null) {
                            i.this.mDH.ag(i, z);
                        }
                    }
                });
                this.mBa.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.mBa != null) {
                            i.this.mBa.dismiss();
                        }
                    }
                });
                this.mBa.b(this.mPageContext);
            }
            this.mBa.aYL();
        }
    }

    public boolean X(final Bitmap bitmap) {
        if (!this.mDH.dvQ() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.mBa == null) {
            this.mBa = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.mBa.ln(R.string.orginal_tip);
            this.mBa.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.mBa != null) {
                        i.this.mBa.dismiss();
                    }
                    i.this.mAZ.W(bitmap);
                }
            });
            this.mBa.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.mBa != null) {
                        i.this.mBa.dismiss();
                    }
                }
            });
            this.mBa.b(this.mPageContext);
        }
        this.mBa.aYL();
        return true;
    }

    public void destroy() {
        if (this.mDJ != null) {
            this.mDJ.destroy();
        }
    }
}
