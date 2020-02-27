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
    private ForumWriteData kCH;
    private h kRT;
    private com.baidu.tbadk.core.dialog.a kRU;
    private StickerModel kUo;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter kUm = null;
    private int kUn = 0;
    private int kUp = 0;
    private WriteImagesInfo kUq = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> kUr = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kRT = hVar;
        initData(bundle);
        initListener();
        cVD();
    }

    public void cVD() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.kUo == null) {
                this.kUo = new StickerModel(this.mPageContext);
            }
            this.kUo.LoadData();
            this.kUo.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eB(List<String> list) {
        if (this.kRT != null) {
            this.kRT.eA(list);
        }
    }

    private void initListener() {
        if (this.kRT != null) {
            if (this.kRT.kUf != null) {
                this.kRT.kUf.D(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.kUm.T(Integer.parseInt(view.getTag().toString()), i.this.cVF());
                        }
                    }
                });
            }
            if (this.kRT.kUi != null) {
                this.kRT.kUi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.kUm.tR(false);
                                if (i.this.kRT != null) {
                                    if (i.this.kUq == null || i.this.kUq.getChosedFiles() == null || i.this.kUq.getChosedFiles().size() <= 0 || !i.this.kUq.isOriginalImg() || i.this.kUp <= 0 || !i.this.cWI()) {
                                        i.this.kRT.b(true, i.this.kUq);
                                    } else {
                                        i.this.kRT.cWF();
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
            this.kUn = bundle.getInt("OutState_Write_Entrance");
            this.kCH = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.kUn = intent.getIntExtra("FourmWriteIndex", 0);
            this.kCH = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.kUq = new WriteImagesInfo();
            this.kUq.parseJson(str);
            cWG();
            if (this.kRT != null && this.kRT.kUg != null) {
                this.kUm = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.kRT.kUg, this.kUq.getChosedFiles(), i, this, this.kRT, this.kUq.mIsFromIm);
                this.kRT.kUg.setAdapter(this.kUm);
                int cVy = this.kUm.cVy();
                this.kRT.kUg.setCurrentItem(cVy, true);
                if (cVy == 0) {
                    this.kUm.onPageSelected(0);
                }
                this.kRT.c(this.kUq);
            }
        }
    }

    private void cWG() {
        if (this.kUq != null && this.kUq.isOriginalImg() && this.kUq.getChosedFiles() != null && this.kUq.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.kUq.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.kUr.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cWH() {
        return this.kUn;
    }

    public ForumWriteData bEr() {
        return this.kCH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWI() {
        if (this.kUq == null || !this.kUq.isOriginalImg() || this.kUq.getChosedFiles() == null || this.kUq.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.kUq.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.kUr.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cVE() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cVF() {
        return (this.kRT == null || this.kRT.kUh == null || v.isEmpty(this.kRT.kUh.getStickerViews())) ? false : true;
    }

    public void cWE() {
        this.kUp++;
    }

    public void cWJ() {
        this.kUp--;
    }

    public WriteImagesInfo cWK() {
        return this.kUq;
    }

    public void tW(boolean z) {
        if (cVF()) {
            this.kRT.kUg.setmDisallowSlip(true);
        } else {
            this.kRT.kUg.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cVC() {
        cWJ();
        tW(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void U(int i, boolean z) {
        W(i, z);
    }

    private void W(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.kRU == null) {
                this.kRU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.kRU.jW(R.string.orginal_tip);
                this.kRU.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kRU != null) {
                            i.this.kRU.dismiss();
                        }
                        if (i.this.kUm != null) {
                            i.this.kUm.T(i, z);
                        }
                    }
                });
                this.kRU.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kRU != null) {
                            i.this.kRU.dismiss();
                        }
                    }
                });
                this.kRU.b(this.mPageContext);
            }
            this.kRU.aEA();
        }
    }

    public boolean P(final Bitmap bitmap) {
        if (!this.kUm.cVz() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.kRU == null) {
            this.kRU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.kRU.jW(R.string.orginal_tip);
            this.kRU.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kRU != null) {
                        i.this.kRU.dismiss();
                    }
                    i.this.kRT.O(bitmap);
                }
            });
            this.kRU.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kRU != null) {
                        i.this.kRU.dismiss();
                    }
                }
            });
            this.kRU.b(this.mPageContext);
        }
        this.kRU.aEA();
        return true;
    }

    public void destroy() {
        if (this.kUo != null) {
            this.kUo.destroy();
        }
    }
}
