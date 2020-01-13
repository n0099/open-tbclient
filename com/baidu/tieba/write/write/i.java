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
/* loaded from: classes11.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData kBH;
    private h kRi;
    private com.baidu.tbadk.core.dialog.a kRj;
    private StickerModel kTD;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter kTB = null;
    private int kTC = 0;
    private int kTE = 0;
    private WriteImagesInfo kTF = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> kTG = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.kRi = hVar;
        initData(bundle);
        initListener();
        cUn();
    }

    public void cUn() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.kTD == null) {
                this.kTD = new StickerModel(this.mPageContext);
            }
            this.kTD.LoadData();
            this.kTD.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eG(List<String> list) {
        if (this.kRi != null) {
            this.kRi.eF(list);
        }
    }

    private void initListener() {
        if (this.kRi != null) {
            if (this.kRi.kTu != null) {
                this.kRi.kTu.C(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.kTB.U(Integer.parseInt(view.getTag().toString()), i.this.cUp());
                        }
                    }
                });
            }
            if (this.kRi.kTx != null) {
                this.kRi.kTx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.kTB.tN(false);
                                if (i.this.kRi != null) {
                                    if (i.this.kTF == null || i.this.kTF.getChosedFiles() == null || i.this.kTF.getChosedFiles().size() <= 0 || !i.this.kTF.isOriginalImg() || i.this.kTE <= 0 || !i.this.cVs()) {
                                        i.this.kRi.b(true, i.this.kTF);
                                    } else {
                                        i.this.kRi.cVp();
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
            this.kTC = bundle.getInt("OutState_Write_Entrance");
            this.kBH = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.kTC = intent.getIntExtra("FourmWriteIndex", 0);
            this.kBH = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.kTF = new WriteImagesInfo();
            this.kTF.parseJson(str);
            cVq();
            if (this.kRi != null && this.kRi.kTv != null) {
                this.kTB = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.kRi.kTv, this.kTF.getChosedFiles(), i, this, this.kRi, this.kTF.mIsFromIm);
                this.kRi.kTv.setAdapter(this.kTB);
                int cUi = this.kTB.cUi();
                this.kRi.kTv.setCurrentItem(cUi, true);
                if (cUi == 0) {
                    this.kTB.onPageSelected(0);
                }
                this.kRi.c(this.kTF);
            }
        }
    }

    private void cVq() {
        if (this.kTF != null && this.kTF.isOriginalImg() && this.kTF.getChosedFiles() != null && this.kTF.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.kTF.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.kTG.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cVr() {
        return this.kTC;
    }

    public ForumWriteData bCO() {
        return this.kBH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVs() {
        if (this.kTF == null || !this.kTF.isOriginalImg() || this.kTF.getChosedFiles() == null || this.kTF.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.kTF.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.kTG.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cUo() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cUp() {
        return (this.kRi == null || this.kRi.kTw == null || v.isEmpty(this.kRi.kTw.getStickerViews())) ? false : true;
    }

    public void cVo() {
        this.kTE++;
    }

    public void cVt() {
        this.kTE--;
    }

    public WriteImagesInfo cVu() {
        return this.kTF;
    }

    public void tS(boolean z) {
        if (cUp()) {
            this.kRi.kTv.setmDisallowSlip(true);
        } else {
            this.kRi.kTv.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cUm() {
        cVt();
        tS(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void V(int i, boolean z) {
        X(i, z);
    }

    private void X(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.kRj == null) {
                this.kRj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.kRj.jF(R.string.orginal_tip);
                this.kRj.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kRj != null) {
                            i.this.kRj.dismiss();
                        }
                        if (i.this.kTB != null) {
                            i.this.kTB.U(i, z);
                        }
                    }
                });
                this.kRj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.kRj != null) {
                            i.this.kRj.dismiss();
                        }
                    }
                });
                this.kRj.b(this.mPageContext);
            }
            this.kRj.aCp();
        }
    }

    public boolean P(final Bitmap bitmap) {
        if (!this.kTB.cUj() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.kRj == null) {
            this.kRj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.kRj.jF(R.string.orginal_tip);
            this.kRj.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kRj != null) {
                        i.this.kRj.dismiss();
                    }
                    i.this.kRi.O(bitmap);
                }
            });
            this.kRj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.kRj != null) {
                        i.this.kRj.dismiss();
                    }
                }
            });
            this.kRj.b(this.mPageContext);
        }
        this.kRj.aCp();
        return true;
    }

    public void destroy() {
        if (this.kTD != null) {
            this.kTD.destroy();
        }
    }
}
