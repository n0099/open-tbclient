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
/* loaded from: classes13.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData kCJ;
    private h kRV;
    private com.baidu.tbadk.core.dialog.a kRW;
    private StickerModel kUq;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter kUo = null;
    private int kUp = 0;
    private int kUr = 0;
    private WriteImagesInfo kUs = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> kUt = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kRV = hVar;
        initData(bundle);
        initListener();
        cVF();
    }

    public void cVF() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.kUq == null) {
                this.kUq = new StickerModel(this.mPageContext);
            }
            this.kUq.LoadData();
            this.kUq.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eB(List<String> list) {
        if (this.kRV != null) {
            this.kRV.eA(list);
        }
    }

    private void initListener() {
        if (this.kRV != null) {
            if (this.kRV.kUh != null) {
                this.kRV.kUh.D(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.kUo.T(Integer.parseInt(view.getTag().toString()), i.this.cVH());
                        }
                    }
                });
            }
            if (this.kRV.kUk != null) {
                this.kRV.kUk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.mPermissionJudgement.clearRequestPermissionList();
                            i.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                i.this.kUo.tR(false);
                                if (i.this.kRV != null) {
                                    if (i.this.kUs == null || i.this.kUs.getChosedFiles() == null || i.this.kUs.getChosedFiles().size() <= 0 || !i.this.kUs.isOriginalImg() || i.this.kUr <= 0 || !i.this.cWK()) {
                                        i.this.kRV.b(true, i.this.kUs);
                                    } else {
                                        i.this.kRV.cWH();
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
            this.kUp = bundle.getInt("OutState_Write_Entrance");
            this.kCJ = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.kUp = intent.getIntExtra("FourmWriteIndex", 0);
            this.kCJ = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.kUs = new WriteImagesInfo();
            this.kUs.parseJson(str);
            cWI();
            if (this.kRV != null && this.kRV.kUi != null) {
                this.kUo = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.kRV.kUi, this.kUs.getChosedFiles(), i, this, this.kRV, this.kUs.mIsFromIm);
                this.kRV.kUi.setAdapter(this.kUo);
                int cVA = this.kUo.cVA();
                this.kRV.kUi.setCurrentItem(cVA, true);
                if (cVA == 0) {
                    this.kUo.onPageSelected(0);
                }
                this.kRV.c(this.kUs);
            }
        }
    }

    private void cWI() {
        if (this.kUs != null && this.kUs.isOriginalImg() && this.kUs.getChosedFiles() != null && this.kUs.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.kUs.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.kUt.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cWJ() {
        return this.kUp;
    }

    public ForumWriteData bEt() {
        return this.kCJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWK() {
        if (this.kUs == null || !this.kUs.isOriginalImg() || this.kUs.getChosedFiles() == null || this.kUs.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.kUs.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.kUt.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cVG() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cVH() {
        return (this.kRV == null || this.kRV.kUj == null || v.isEmpty(this.kRV.kUj.getStickerViews())) ? false : true;
    }

    public void cWG() {
        this.kUr++;
    }

    public void cWL() {
        this.kUr--;
    }

    public WriteImagesInfo cWM() {
        return this.kUs;
    }

    public void tW(boolean z) {
        if (cVH()) {
            this.kRV.kUi.setmDisallowSlip(true);
        } else {
            this.kRV.kUi.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cVE() {
        cWL();
        tW(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void U(int i, boolean z) {
        W(i, z);
    }

    private void W(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.kRW == null) {
                this.kRW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.kRW.jW(R.string.orginal_tip);
                this.kRW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kRW != null) {
                            i.this.kRW.dismiss();
                        }
                        if (i.this.kUo != null) {
                            i.this.kUo.T(i, z);
                        }
                    }
                });
                this.kRW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kRW != null) {
                            i.this.kRW.dismiss();
                        }
                    }
                });
                this.kRW.b(this.mPageContext);
            }
            this.kRW.aEC();
        }
    }

    public boolean P(final Bitmap bitmap) {
        if (!this.kUo.cVB() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.kRW == null) {
            this.kRW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.kRW.jW(R.string.orginal_tip);
            this.kRW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kRW != null) {
                        i.this.kRW.dismiss();
                    }
                    i.this.kRV.O(bitmap);
                }
            });
            this.kRW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kRW != null) {
                        i.this.kRW.dismiss();
                    }
                }
            });
            this.kRW.b(this.mPageContext);
        }
        this.kRW.aEC();
        return true;
    }

    public void destroy() {
        if (this.kUq != null) {
            this.kUq.destroy();
        }
    }
}
