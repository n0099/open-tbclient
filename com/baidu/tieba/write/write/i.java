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
    private ForumWriteData jEv;
    private h jST;
    private com.baidu.tbadk.core.dialog.a jSU;
    private StickerModel jVp;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    public MultiImagePagerAdapter jVn = null;
    private int jVo = 0;
    private int jVq = 0;
    private WriteImagesInfo jVr = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> jVs = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jST = hVar;
        initData(bundle);
        initListener();
        czk();
    }

    public void czk() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.jVp == null) {
                this.jVp = new StickerModel(this.mPageContext);
            }
            this.jVp.LoadData();
            this.jVp.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eO(List<String> list) {
        if (this.jST != null) {
            this.jST.eN(list);
        }
    }

    private void initListener() {
        if (this.jST != null) {
            if (this.jST.jVg != null) {
                this.jST.jVg.C(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.jVn.T(Integer.parseInt(view.getTag().toString()), i.this.czm());
                        }
                    }
                });
            }
            if (this.jST.jVj != null) {
                this.jST.jVj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.jVn.rU(false);
                                if (i.this.jST != null) {
                                    if (i.this.jVr == null || i.this.jVr.getChosedFiles() == null || i.this.jVr.getChosedFiles().size() <= 0 || !i.this.jVr.isOriginalImg() || i.this.jVq <= 0 || !i.this.cAo()) {
                                        i.this.jST.b(true, i.this.jVr);
                                    } else {
                                        i.this.jST.cAl();
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
            this.jVo = bundle.getInt("OutState_Write_Entrance");
            this.jEv = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.jVo = intent.getIntExtra("FourmWriteIndex", 0);
            this.jEv = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.jVr = new WriteImagesInfo();
            this.jVr.parseJson(str);
            cAm();
            if (this.jST != null && this.jST.jVh != null) {
                this.jVn = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jST.jVh, this.jVr.getChosedFiles(), i, this, this.jST, this.jVr.mIsFromIm);
                this.jST.jVh.setAdapter(this.jVn);
                int czf = this.jVn.czf();
                this.jST.jVh.setCurrentItem(czf, true);
                if (czf == 0) {
                    this.jVn.onPageSelected(0);
                }
                this.jST.c(this.jVr);
            }
        }
    }

    private void cAm() {
        if (this.jVr != null && this.jVr.isOriginalImg() && this.jVr.getChosedFiles() != null && this.jVr.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.jVr.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.jVs.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cAn() {
        return this.jVo;
    }

    public ForumWriteData bkq() {
        return this.jEv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cAo() {
        if (this.jVr == null || !this.jVr.isOriginalImg() || this.jVr.getChosedFiles() == null || this.jVr.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.jVr.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.jVs.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void czl() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean czm() {
        return (this.jST == null || this.jST.jVi == null || v.isEmpty(this.jST.jVi.getStickerViews())) ? false : true;
    }

    public void cAk() {
        this.jVq++;
    }

    public void cAp() {
        this.jVq--;
    }

    public WriteImagesInfo cAq() {
        return this.jVr;
    }

    public void rZ(boolean z) {
        if (czm()) {
            this.jST.jVh.setmDisallowSlip(true);
        } else {
            this.jST.jVh.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void czj() {
        cAp();
        rZ(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void U(int i, boolean z) {
        W(i, z);
    }

    private void W(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jSU == null) {
                this.jSU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jSU.hT(R.string.orginal_tip);
                this.jSU.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jSU != null) {
                            i.this.jSU.dismiss();
                        }
                        if (i.this.jVn != null) {
                            i.this.jVn.T(i, z);
                        }
                    }
                });
                this.jSU.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jSU != null) {
                            i.this.jSU.dismiss();
                        }
                    }
                });
                this.jSU.b(this.mPageContext);
            }
            this.jSU.akM();
        }
    }

    public boolean P(final Bitmap bitmap) {
        if (!this.jVn.czg() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jSU == null) {
            this.jSU = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jSU.hT(R.string.orginal_tip);
            this.jSU.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jSU != null) {
                        i.this.jSU.dismiss();
                    }
                    i.this.jST.O(bitmap);
                }
            });
            this.jSU.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jSU != null) {
                        i.this.jSU.dismiss();
                    }
                }
            });
            this.jSU.b(this.mPageContext);
        }
        this.jSU.akM();
        return true;
    }

    public void destroy() {
        if (this.jVp != null) {
            this.jVp.destroy();
        }
    }
}
