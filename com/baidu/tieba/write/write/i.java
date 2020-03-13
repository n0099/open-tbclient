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
    private ForumWriteData kCV;
    private h kSh;
    private com.baidu.tbadk.core.dialog.a kSi;
    private StickerModel kUC;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    public MultiImagePagerAdapter kUA = null;
    private int kUB = 0;
    private int kUD = 0;
    private WriteImagesInfo kUE = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> kUF = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kSh = hVar;
        initData(bundle);
        initListener();
        cVG();
    }

    public void cVG() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.kUC == null) {
                this.kUC = new StickerModel(this.mPageContext);
            }
            this.kUC.LoadData();
            this.kUC.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eB(List<String> list) {
        if (this.kSh != null) {
            this.kSh.eA(list);
        }
    }

    private void initListener() {
        if (this.kSh != null) {
            if (this.kSh.kUt != null) {
                this.kSh.kUt.D(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.kUA.T(Integer.parseInt(view.getTag().toString()), i.this.cVI());
                        }
                    }
                });
            }
            if (this.kSh.kUw != null) {
                this.kSh.kUw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.kUA.tR(false);
                                if (i.this.kSh != null) {
                                    if (i.this.kUE == null || i.this.kUE.getChosedFiles() == null || i.this.kUE.getChosedFiles().size() <= 0 || !i.this.kUE.isOriginalImg() || i.this.kUD <= 0 || !i.this.cWL()) {
                                        i.this.kSh.b(true, i.this.kUE);
                                    } else {
                                        i.this.kSh.cWI();
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
            this.kUB = bundle.getInt("OutState_Write_Entrance");
            this.kCV = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.kUB = intent.getIntExtra("FourmWriteIndex", 0);
            this.kCV = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.kUE = new WriteImagesInfo();
            this.kUE.parseJson(str);
            cWJ();
            if (this.kSh != null && this.kSh.kUu != null) {
                this.kUA = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.kSh.kUu, this.kUE.getChosedFiles(), i, this, this.kSh, this.kUE.mIsFromIm);
                this.kSh.kUu.setAdapter(this.kUA);
                int cVB = this.kUA.cVB();
                this.kSh.kUu.setCurrentItem(cVB, true);
                if (cVB == 0) {
                    this.kUA.onPageSelected(0);
                }
                this.kSh.c(this.kUE);
            }
        }
    }

    private void cWJ() {
        if (this.kUE != null && this.kUE.isOriginalImg() && this.kUE.getChosedFiles() != null && this.kUE.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.kUE.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.kUF.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cWK() {
        return this.kUB;
    }

    public ForumWriteData bEu() {
        return this.kCV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWL() {
        if (this.kUE == null || !this.kUE.isOriginalImg() || this.kUE.getChosedFiles() == null || this.kUE.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.kUE.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.kUF.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cVH() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cVI() {
        return (this.kSh == null || this.kSh.kUv == null || v.isEmpty(this.kSh.kUv.getStickerViews())) ? false : true;
    }

    public void cWH() {
        this.kUD++;
    }

    public void cWM() {
        this.kUD--;
    }

    public WriteImagesInfo cWN() {
        return this.kUE;
    }

    public void tW(boolean z) {
        if (cVI()) {
            this.kSh.kUu.setmDisallowSlip(true);
        } else {
            this.kSh.kUu.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cVF() {
        cWM();
        tW(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void U(int i, boolean z) {
        W(i, z);
    }

    private void W(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.kSi == null) {
                this.kSi = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.kSi.jW(R.string.orginal_tip);
                this.kSi.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kSi != null) {
                            i.this.kSi.dismiss();
                        }
                        if (i.this.kUA != null) {
                            i.this.kUA.T(i, z);
                        }
                    }
                });
                this.kSi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kSi != null) {
                            i.this.kSi.dismiss();
                        }
                    }
                });
                this.kSi.b(this.mPageContext);
            }
            this.kSi.aEC();
        }
    }

    public boolean P(final Bitmap bitmap) {
        if (!this.kUA.cVC() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.kSi == null) {
            this.kSi = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.kSi.jW(R.string.orginal_tip);
            this.kSi.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kSi != null) {
                        i.this.kSi.dismiss();
                    }
                    i.this.kSh.O(bitmap);
                }
            });
            this.kSi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kSi != null) {
                        i.this.kSi.dismiss();
                    }
                }
            });
            this.kSi.b(this.mPageContext);
        }
        this.kSi.aEC();
        return true;
    }

    public void destroy() {
        if (this.kUC != null) {
            this.kUC.destroy();
        }
    }
}
