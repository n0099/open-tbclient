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
    private ForumWriteData hRF;
    private h mAX;
    private com.baidu.tbadk.core.dialog.a mAY;
    private StickerModel mDH;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    public MultiImagePagerAdapter mDF = null;
    private int mDG = 0;
    private int mDI = 0;
    private WriteImagesInfo mDJ = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> mDK = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.mAX = hVar;
        initData(bundle);
        initListener();
        dvT();
    }

    public void dvT() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.mDH == null) {
                this.mDH = new StickerModel(this.mPageContext);
            }
            this.mDH.LoadData();
            this.mDH.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void fv(List<String> list) {
        if (this.mAX != null) {
            this.mAX.fu(list);
        }
    }

    private void initListener() {
        if (this.mAX != null) {
            if (this.mAX.mDw != null) {
                this.mAX.mDw.E(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.mDF.ag(Integer.parseInt(view.getTag().toString()), i.this.dvV());
                        }
                    }
                });
            }
            if (this.mAX.mDB != null) {
                this.mAX.mDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.mDF.wy(false);
                                if (i.this.mAX != null) {
                                    if (i.this.mDJ == null || i.this.mDJ.getChosedFiles() == null || i.this.mDJ.getChosedFiles().size() <= 0 || !i.this.mDJ.isOriginalImg() || i.this.mDI <= 0 || !i.this.dxf()) {
                                        i.this.mAX.b(true, i.this.mDJ);
                                    } else {
                                        i.this.mAX.dxc();
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
            this.mDG = bundle.getInt("OutState_Write_Entrance");
            this.hRF = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.mDG = intent.getIntExtra("FourmWriteIndex", 0);
            this.hRF = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.mDJ = new WriteImagesInfo();
            this.mDJ.parseJson(str);
            dxd();
            if (this.mAX != null && this.mAX.mDz != null) {
                this.mDF = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.mAX.mDz, this.mDJ.getChosedFiles(), i, this, this.mAX, this.mDJ.mIsFromIm);
                this.mAX.mDz.setAdapter(this.mDF);
                int dvO = this.mDF.dvO();
                this.mAX.mDz.setCurrentItem(dvO, true);
                if (dvO == 0) {
                    this.mDF.onPageSelected(0);
                }
                this.mAX.c(this.mDJ);
            }
        }
    }

    private void dxd() {
        if (this.mDJ != null && this.mDJ.isOriginalImg() && this.mDJ.getChosedFiles() != null && this.mDJ.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.mDJ.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.mDK.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dxe() {
        return this.mDG;
    }

    public ForumWriteData ccd() {
        return this.hRF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dxf() {
        if (this.mDJ == null || !this.mDJ.isOriginalImg() || this.mDJ.getChosedFiles() == null || this.mDJ.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.mDJ.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.mDK.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dvU() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dvV() {
        return (this.mAX == null || this.mAX.mDA == null || x.isEmpty(this.mAX.mDA.getStickerViews())) ? false : true;
    }

    public void dxb() {
        this.mDI++;
    }

    public void dxg() {
        this.mDI--;
    }

    public WriteImagesInfo dxh() {
        return this.mDJ;
    }

    public void wE(boolean z) {
        if (dvV()) {
            this.mAX.mDz.setmDisallowSlip(true);
        } else {
            this.mAX.mDz.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dvS() {
        dxg();
        wE(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ah(int i, boolean z) {
        ai(i, z);
    }

    private void ai(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.mAY == null) {
                this.mAY = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.mAY.ln(R.string.orginal_tip);
                this.mAY.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.mAY != null) {
                            i.this.mAY.dismiss();
                        }
                        if (i.this.mDF != null) {
                            i.this.mDF.ag(i, z);
                        }
                    }
                });
                this.mAY.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.mAY != null) {
                            i.this.mAY.dismiss();
                        }
                    }
                });
                this.mAY.b(this.mPageContext);
            }
            this.mAY.aYL();
        }
    }

    public boolean X(final Bitmap bitmap) {
        if (!this.mDF.dvP() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.mAY == null) {
            this.mAY = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.mAY.ln(R.string.orginal_tip);
            this.mAY.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.mAY != null) {
                        i.this.mAY.dismiss();
                    }
                    i.this.mAX.W(bitmap);
                }
            });
            this.mAY.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.mAY != null) {
                        i.this.mAY.dismiss();
                    }
                }
            });
            this.mAY.b(this.mPageContext);
        }
        this.mAY.aYL();
        return true;
    }

    public void destroy() {
        if (this.mDH != null) {
            this.mDH.destroy();
        }
    }
}
