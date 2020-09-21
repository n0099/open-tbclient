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
    private ForumWriteData imW;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j ndY;
    private com.baidu.tbadk.core.dialog.a ndZ;
    private StickerModel ngZ;
    public MultiImagePagerAdapter ngX = null;
    private int ngY = 0;
    private int nha = 0;
    private WriteImagesInfo nhb = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> nhc = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ndY = jVar;
        initData(bundle);
        initListener();
        dLB();
    }

    public void dLB() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    com.baidu.adp.lib.util.l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.ngZ == null) {
                this.ngZ = new StickerModel(this.mPageContext);
            }
            this.ngZ.LoadData();
            this.ngZ.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void fO(List<String> list) {
        if (this.ndY != null) {
            this.ndY.fN(list);
        }
    }

    private void initListener() {
        if (this.ndY != null) {
            if (this.ndY.ngQ != null) {
                this.ndY.ngQ.F(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.ngX.aj(Integer.parseInt(view.getTag().toString()), k.this.dLD());
                        }
                    }
                });
            }
            if (this.ndY.ngT != null) {
                this.ndY.ngT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.ngX.xz(false);
                                if (k.this.ndY != null) {
                                    if (k.this.nhb == null || k.this.nhb.getChosedFiles() == null || k.this.nhb.getChosedFiles().size() <= 0 || !k.this.nhb.isOriginalImg() || k.this.nha <= 0 || !k.this.dNb()) {
                                        k.this.ndY.b(true, k.this.nhb);
                                    } else {
                                        k.this.ndY.dMY();
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
            this.ngY = bundle.getInt("OutState_Write_Entrance");
            this.imW = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.ngY = intent.getIntExtra("FourmWriteIndex", 0);
            this.imW = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.nhb = new WriteImagesInfo();
            this.nhb.parseJson(str);
            dMZ();
            if (this.ndY != null && this.ndY.ngR != null) {
                this.ngX = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.ndY.ngR, this.nhb.getChosedFiles(), i, this, this.ndY, this.nhb.mIsFromIm);
                this.ndY.ngR.setAdapter(this.ngX);
                int dLw = this.ngX.dLw();
                this.ndY.ngR.setCurrentItem(dLw, true);
                if (dLw == 0) {
                    this.ngX.onPageSelected(0);
                }
                this.ndY.c(this.nhb);
            }
        }
    }

    private void dMZ() {
        if (this.nhb != null && this.nhb.isOriginalImg() && this.nhb.getChosedFiles() != null && this.nhb.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.nhb.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.nhc.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dNa() {
        return this.ngY;
    }

    public ForumWriteData cpN() {
        return this.imW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dNb() {
        if (this.nhb == null || !this.nhb.isOriginalImg() || this.nhb.getChosedFiles() == null || this.nhb.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.nhb.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.nhc.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dLC() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dLD() {
        return (this.ndY == null || this.ndY.ngS == null || y.isEmpty(this.ndY.ngS.getStickerViews())) ? false : true;
    }

    public void dMX() {
        this.nha++;
    }

    public void dNc() {
        this.nha--;
    }

    public WriteImagesInfo dNd() {
        return this.nhb;
    }

    public void xF(boolean z) {
        if (dLD()) {
            this.ndY.ngR.setmDisallowSlip(true);
        } else {
            this.ndY.ngR.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dLA() {
        dNc();
        xF(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ak(int i, boolean z) {
        al(i, z);
    }

    private void al(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.ndZ == null) {
                this.ndZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.ndZ.nE(R.string.orginal_tip);
                this.ndZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.ndZ != null) {
                            k.this.ndZ.dismiss();
                        }
                        if (k.this.ngX != null) {
                            k.this.ngX.aj(i, z);
                        }
                    }
                });
                this.ndZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.ndZ != null) {
                            k.this.ndZ.dismiss();
                        }
                    }
                });
                this.ndZ.b(this.mPageContext);
            }
            this.ndZ.bia();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.ngX.dLx() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.ndZ == null) {
            this.ndZ = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.ndZ.nE(R.string.orginal_tip);
            this.ndZ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.ndZ != null) {
                        k.this.ndZ.dismiss();
                    }
                    k.this.ndY.V(bitmap);
                }
            });
            this.ndZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.ndZ != null) {
                        k.this.ndZ.dismiss();
                    }
                }
            });
            this.ndZ.b(this.mPageContext);
        }
        this.ndZ.bia();
        return true;
    }

    public void destroy() {
        if (this.ngZ != null) {
            this.ngZ.destroy();
        }
    }
}
