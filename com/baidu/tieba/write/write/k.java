package com.baidu.tieba.write.write;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes3.dex */
public class k implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData iOm;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j nFW;
    private com.baidu.tbadk.core.dialog.a nFX;
    private StickerModel nIW;
    public MultiImagePagerAdapter nIU = null;
    private int nIV = 0;
    private int nIX = 0;
    private WriteImagesInfo nIY = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> nIZ = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.nFW = jVar;
        initData(bundle);
        initListener();
        dSv();
    }

    public void dSv() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    com.baidu.adp.lib.util.l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.nIW == null) {
                this.nIW = new StickerModel(this.mPageContext);
            }
            this.nIW.LoadData();
            this.nIW.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void fZ(List<String> list) {
        if (this.nFW != null) {
            this.nFW.fY(list);
        }
    }

    private void initListener() {
        if (this.nFW != null) {
            if (this.nFW.nIN != null) {
                this.nFW.nIN.F(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.nIU.al(Integer.parseInt(view.getTag().toString()), k.this.dSx());
                        }
                    }
                });
            }
            if (this.nFW.nIQ != null) {
                this.nFW.nIQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.nIU.yx(false);
                                if (k.this.nFW != null) {
                                    if (k.this.nIY == null || k.this.nIY.getChosedFiles() == null || k.this.nIY.getChosedFiles().size() <= 0 || !k.this.nIY.isOriginalImg() || k.this.nIX <= 0 || !k.this.dTV()) {
                                        k.this.nFW.b(true, k.this.nIY);
                                    } else {
                                        k.this.nFW.dTS();
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
            this.nIV = bundle.getInt("OutState_Write_Entrance");
            this.iOm = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.nIV = intent.getIntExtra("FourmWriteIndex", 0);
            this.iOm = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.nIY = new WriteImagesInfo();
            this.nIY.parseJson(str);
            dTT();
            if (this.nFW != null && this.nFW.nIO != null) {
                this.nIU = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.nFW.nIO, this.nIY.getChosedFiles(), i, this, this.nFW, this.nIY.mIsFromIm);
                this.nFW.nIO.setAdapter(this.nIU);
                int dSq = this.nIU.dSq();
                this.nFW.nIO.setCurrentItem(dSq, true);
                if (dSq == 0) {
                    this.nIU.onPageSelected(0);
                }
                this.nFW.c(this.nIY);
            }
        }
    }

    private void dTT() {
        if (this.nIY != null && this.nIY.isOriginalImg() && this.nIY.getChosedFiles() != null && this.nIY.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.nIY.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.nIZ.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dTU() {
        return this.nIV;
    }

    public ForumWriteData cws() {
        return this.iOm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dTV() {
        if (this.nIY == null || !this.nIY.isOriginalImg() || this.nIY.getChosedFiles() == null || this.nIY.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.nIY.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.nIZ.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dSw() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dSx() {
        return (this.nFW == null || this.nFW.nIP == null || y.isEmpty(this.nFW.nIP.getStickerViews())) ? false : true;
    }

    public void dTR() {
        this.nIX++;
    }

    public void dTW() {
        this.nIX--;
    }

    public WriteImagesInfo dTX() {
        return this.nIY;
    }

    public void yD(boolean z) {
        if (dSx()) {
            this.nFW.nIO.setmDisallowSlip(true);
        } else {
            this.nFW.nIO.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dSu() {
        dTW();
        yD(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void am(int i, boolean z) {
        an(i, z);
    }

    private void an(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.nFX == null) {
                this.nFX = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.nFX.om(R.string.orginal_tip);
                this.nFX.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nFX != null) {
                            k.this.nFX.dismiss();
                        }
                        if (k.this.nIU != null) {
                            k.this.nIU.al(i, z);
                        }
                    }
                });
                this.nFX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nFX != null) {
                            k.this.nFX.dismiss();
                        }
                    }
                });
                this.nFX.b(this.mPageContext);
            }
            this.nFX.bmC();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.nIU.dSr() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.nFX == null) {
            this.nFX = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.nFX.om(R.string.orginal_tip);
            this.nFX.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nFX != null) {
                        k.this.nFX.dismiss();
                    }
                    k.this.nFW.V(bitmap);
                }
            });
            this.nFX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nFX != null) {
                        k.this.nFX.dismiss();
                    }
                }
            });
            this.nFX.b(this.mPageContext);
        }
        this.nFX.bmC();
        return true;
    }

    public void destroy() {
        if (this.nIW != null) {
            this.nIW.destroy();
        }
    }
}
