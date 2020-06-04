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
    private ForumWriteData hyK;
    private h lYn;
    private com.baidu.tbadk.core.dialog.a lYo;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private StickerModel maM;
    public MultiImagePagerAdapter maK = null;
    private int maL = 0;
    private int maN = 0;
    private WriteImagesInfo maO = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> maP = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.lYn = hVar;
        initData(bundle);
        initListener();
        dop();
    }

    public void dop() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.maM == null) {
                this.maM = new StickerModel(this.mPageContext);
            }
            this.maM.LoadData();
            this.maM.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eZ(List<String> list) {
        if (this.lYn != null) {
            this.lYn.eY(list);
        }
    }

    private void initListener() {
        if (this.lYn != null) {
            if (this.lYn.maD != null) {
                this.lYn.maD.D(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.maK.ae(Integer.parseInt(view.getTag().toString()), i.this.dor());
                        }
                    }
                });
            }
            if (this.lYn.maG != null) {
                this.lYn.maG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.maK.vA(false);
                                if (i.this.lYn != null) {
                                    if (i.this.maO == null || i.this.maO.getChosedFiles() == null || i.this.maO.getChosedFiles().size() <= 0 || !i.this.maO.isOriginalImg() || i.this.maN <= 0 || !i.this.dpu()) {
                                        i.this.lYn.b(true, i.this.maO);
                                    } else {
                                        i.this.lYn.dpr();
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
            this.maL = bundle.getInt("OutState_Write_Entrance");
            this.hyK = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.maL = intent.getIntExtra("FourmWriteIndex", 0);
            this.hyK = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.maO = new WriteImagesInfo();
            this.maO.parseJson(str);
            dps();
            if (this.lYn != null && this.lYn.maE != null) {
                this.maK = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.lYn.maE, this.maO.getChosedFiles(), i, this, this.lYn, this.maO.mIsFromIm);
                this.lYn.maE.setAdapter(this.maK);
                int dok = this.maK.dok();
                this.lYn.maE.setCurrentItem(dok, true);
                if (dok == 0) {
                    this.maK.onPageSelected(0);
                }
                this.lYn.c(this.maO);
            }
        }
    }

    private void dps() {
        if (this.maO != null && this.maO.isOriginalImg() && this.maO.getChosedFiles() != null && this.maO.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.maO.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.maP.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dpt() {
        return this.maL;
    }

    public ForumWriteData bVy() {
        return this.hyK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dpu() {
        if (this.maO == null || !this.maO.isOriginalImg() || this.maO.getChosedFiles() == null || this.maO.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.maO.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.maP.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void doq() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dor() {
        return (this.lYn == null || this.lYn.maF == null || v.isEmpty(this.lYn.maF.getStickerViews())) ? false : true;
    }

    public void dpq() {
        this.maN++;
    }

    public void dpv() {
        this.maN--;
    }

    public WriteImagesInfo dpw() {
        return this.maO;
    }

    public void vF(boolean z) {
        if (dor()) {
            this.lYn.maE.setmDisallowSlip(true);
        } else {
            this.lYn.maE.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void doo() {
        dpv();
        vF(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void af(int i, boolean z) {
        ah(i, z);
    }

    private void ah(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.lYo == null) {
                this.lYo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.lYo.kF(R.string.orginal_tip);
                this.lYo.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.lYo != null) {
                            i.this.lYo.dismiss();
                        }
                        if (i.this.maK != null) {
                            i.this.maK.ae(i, z);
                        }
                    }
                });
                this.lYo.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.lYo != null) {
                            i.this.lYo.dismiss();
                        }
                    }
                });
                this.lYo.b(this.mPageContext);
            }
            this.lYo.aST();
        }
    }

    public boolean U(final Bitmap bitmap) {
        if (!this.maK.dol() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.lYo == null) {
            this.lYo = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.lYo.kF(R.string.orginal_tip);
            this.lYo.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.lYo != null) {
                        i.this.lYo.dismiss();
                    }
                    i.this.lYn.T(bitmap);
                }
            });
            this.lYo.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.lYo != null) {
                        i.this.lYo.dismiss();
                    }
                }
            });
            this.lYo.b(this.mPageContext);
        }
        this.lYo.aST();
        return true;
    }

    public void destroy() {
        if (this.maM != null) {
            this.maM.destroy();
        }
    }
}
