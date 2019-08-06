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
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
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
    private ForumWriteData jDa;
    private h jTo;
    private com.baidu.tbadk.core.dialog.a jTp;
    private StickerModel jVK;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter jVI = null;
    private int jVJ = 0;
    private int jVL = 0;
    private WriteImagesInfo jVM = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> jVN = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jTo = hVar;
        initData(bundle);
        initListener();
        cBO();
    }

    public void cBO() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.jVK == null) {
                this.jVK = new StickerModel(this.mPageContext);
            }
            this.jVK.LoadData();
            this.jVK.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eB(List<String> list) {
        if (this.jTo != null) {
            this.jTo.eA(list);
        }
    }

    private void initListener() {
        if (this.jTo != null) {
            if (this.jTo.jVB != null) {
                this.jTo.jVB.B(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.jVI.V(Integer.parseInt(view.getTag().toString()), i.this.cBQ());
                        }
                    }
                });
            }
            if (this.jTo.jVE != null) {
                this.jTo.jVE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.mPermissionJudgement.ajS();
                            i.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.ad(pageActivity)) {
                                i.this.jVI.sm(false);
                                if (i.this.jTo != null) {
                                    if (i.this.jVM == null || i.this.jVM.getChosedFiles() == null || i.this.jVM.getChosedFiles().size() <= 0 || !i.this.jVM.isOriginalImg() || i.this.jVL <= 0 || !i.this.cCS()) {
                                        i.this.jTo.b(true, i.this.jVM);
                                    } else {
                                        i.this.jTo.cCP();
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
            this.jVJ = bundle.getInt("OutState_Write_Entrance");
            this.jDa = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.jVJ = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jDa = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.jVM = new WriteImagesInfo();
            this.jVM.parseJson(str);
            cCQ();
            if (this.jTo != null && this.jTo.jVC != null) {
                this.jVI = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jTo.jVC, this.jVM.getChosedFiles(), i, this, this.jTo, this.jVM.mIsFromIm);
                this.jTo.jVC.setAdapter(this.jVI);
                int cBJ = this.jVI.cBJ();
                this.jTo.jVC.setCurrentItem(cBJ, true);
                if (cBJ == 0) {
                    this.jVI.onPageSelected(0);
                }
                this.jTo.d(this.jVM);
            }
        }
    }

    private void cCQ() {
        if (this.jVM != null && this.jVM.isOriginalImg() && this.jVM.getChosedFiles() != null && this.jVM.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.jVM.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.jVN.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cCR() {
        return this.jVJ;
    }

    public ForumWriteData bmB() {
        return this.jDa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cCS() {
        if (this.jVM == null || !this.jVM.isOriginalImg() || this.jVM.getChosedFiles() == null || this.jVM.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.jVM.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.jVN.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cBP() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cBQ() {
        return (this.jTo == null || this.jTo.jVD == null || v.aa(this.jTo.jVD.getStickerViews())) ? false : true;
    }

    public void cCO() {
        this.jVL++;
    }

    public void cCT() {
        this.jVL--;
    }

    public WriteImagesInfo cCU() {
        return this.jVM;
    }

    public void sr(boolean z) {
        if (cBQ()) {
            this.jTo.jVC.setmDisallowSlip(true);
        } else {
            this.jTo.jVC.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cBN() {
        cCT();
        sr(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void W(int i, boolean z) {
        Y(i, z);
    }

    private void Y(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jTp == null) {
                this.jTp = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jTp.hu(R.string.orginal_tip);
                this.jTp.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jTp != null) {
                            i.this.jTp.dismiss();
                        }
                        if (i.this.jVI != null) {
                            i.this.jVI.V(i, z);
                        }
                    }
                });
                this.jTp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jTp != null) {
                            i.this.jTp.dismiss();
                        }
                    }
                });
                this.jTp.b(this.mPageContext);
            }
            this.jTp.agK();
        }
    }

    public boolean R(final Bitmap bitmap) {
        if (!this.jVI.cBK() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jTp == null) {
            this.jTp = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jTp.hu(R.string.orginal_tip);
            this.jTp.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jTp != null) {
                        i.this.jTp.dismiss();
                    }
                    i.this.jTo.Q(bitmap);
                }
            });
            this.jTp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jTp != null) {
                        i.this.jTp.dismiss();
                    }
                }
            });
            this.jTp.b(this.mPageContext);
        }
        this.jTp.agK();
        return true;
    }

    public void destroy() {
        if (this.jVK != null) {
            this.jVK.destroy();
        }
    }
}
