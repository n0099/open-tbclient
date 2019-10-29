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
/* loaded from: classes3.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData jFm;
    private h jTK;
    private com.baidu.tbadk.core.dialog.a jTL;
    private StickerModel jWg;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    public MultiImagePagerAdapter jWe = null;
    private int jWf = 0;
    private int jWh = 0;
    private WriteImagesInfo jWi = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> jWj = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jTK = hVar;
        initData(bundle);
        initListener();
        czm();
    }

    public void czm() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.jWg == null) {
                this.jWg = new StickerModel(this.mPageContext);
            }
            this.jWg.LoadData();
            this.jWg.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eO(List<String> list) {
        if (this.jTK != null) {
            this.jTK.eN(list);
        }
    }

    private void initListener() {
        if (this.jTK != null) {
            if (this.jTK.jVX != null) {
                this.jTK.jVX.C(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.jWe.T(Integer.parseInt(view.getTag().toString()), i.this.czo());
                        }
                    }
                });
            }
            if (this.jTK.jWa != null) {
                this.jTK.jWa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                            }
                            i.this.mPermissionJudgement.clearRequestPermissionList();
                            i.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                i.this.jWe.rU(false);
                                if (i.this.jTK != null) {
                                    if (i.this.jWi == null || i.this.jWi.getChosedFiles() == null || i.this.jWi.getChosedFiles().size() <= 0 || !i.this.jWi.isOriginalImg() || i.this.jWh <= 0 || !i.this.cAq()) {
                                        i.this.jTK.b(true, i.this.jWi);
                                    } else {
                                        i.this.jTK.cAn();
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
            this.jWf = bundle.getInt("OutState_Write_Entrance");
            this.jFm = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.jWf = intent.getIntExtra("FourmWriteIndex", 0);
            this.jFm = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.jWi = new WriteImagesInfo();
            this.jWi.parseJson(str);
            cAo();
            if (this.jTK != null && this.jTK.jVY != null) {
                this.jWe = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jTK.jVY, this.jWi.getChosedFiles(), i, this, this.jTK, this.jWi.mIsFromIm);
                this.jTK.jVY.setAdapter(this.jWe);
                int czh = this.jWe.czh();
                this.jTK.jVY.setCurrentItem(czh, true);
                if (czh == 0) {
                    this.jWe.onPageSelected(0);
                }
                this.jTK.c(this.jWi);
            }
        }
    }

    private void cAo() {
        if (this.jWi != null && this.jWi.isOriginalImg() && this.jWi.getChosedFiles() != null && this.jWi.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.jWi.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.jWj.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cAp() {
        return this.jWf;
    }

    public ForumWriteData bks() {
        return this.jFm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cAq() {
        if (this.jWi == null || !this.jWi.isOriginalImg() || this.jWi.getChosedFiles() == null || this.jWi.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.jWi.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.jWj.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void czn() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean czo() {
        return (this.jTK == null || this.jTK.jVZ == null || v.isEmpty(this.jTK.jVZ.getStickerViews())) ? false : true;
    }

    public void cAm() {
        this.jWh++;
    }

    public void cAr() {
        this.jWh--;
    }

    public WriteImagesInfo cAs() {
        return this.jWi;
    }

    public void rZ(boolean z) {
        if (czo()) {
            this.jTK.jVY.setmDisallowSlip(true);
        } else {
            this.jTK.jVY.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void czl() {
        cAr();
        rZ(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void U(int i, boolean z) {
        W(i, z);
    }

    private void W(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jTL == null) {
                this.jTL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jTL.hU(R.string.orginal_tip);
                this.jTL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jTL != null) {
                            i.this.jTL.dismiss();
                        }
                        if (i.this.jWe != null) {
                            i.this.jWe.T(i, z);
                        }
                    }
                });
                this.jTL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jTL != null) {
                            i.this.jTL.dismiss();
                        }
                    }
                });
                this.jTL.b(this.mPageContext);
            }
            this.jTL.akO();
        }
    }

    public boolean P(final Bitmap bitmap) {
        if (!this.jWe.czi() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jTL == null) {
            this.jTL = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jTL.hU(R.string.orginal_tip);
            this.jTL.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jTL != null) {
                        i.this.jTL.dismiss();
                    }
                    i.this.jTK.O(bitmap);
                }
            });
            this.jTL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jTL != null) {
                        i.this.jTL.dismiss();
                    }
                }
            });
            this.jTL.b(this.mPageContext);
        }
        this.jTL.akO();
        return true;
    }

    public void destroy() {
        if (this.jWg != null) {
            this.jWg.destroy();
        }
    }
}
