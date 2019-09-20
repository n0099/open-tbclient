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
    private ForumWriteData jFw;
    private h jVL;
    private com.baidu.tbadk.core.dialog.a jVM;
    private StickerModel jYh;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    public MultiImagePagerAdapter jYf = null;
    private int jYg = 0;
    private int jYi = 0;
    private WriteImagesInfo jYj = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> jYk = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jVL = hVar;
        initData(bundle);
        initListener();
        cCC();
    }

    public void cCC() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.jYh == null) {
                this.jYh = new StickerModel(this.mPageContext);
            }
            this.jYh.LoadData();
            this.jYh.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eB(List<String> list) {
        if (this.jVL != null) {
            this.jVL.eA(list);
        }
    }

    private void initListener() {
        if (this.jVL != null) {
            if (this.jVL.jXY != null) {
                this.jVL.jXY.B(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.jYf.W(Integer.parseInt(view.getTag().toString()), i.this.cCE());
                        }
                    }
                });
            }
            if (this.jVL.jYb != null) {
                this.jVL.jYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                            }
                            i.this.mPermissionJudgement.ake();
                            i.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.ad(pageActivity)) {
                                i.this.jYf.sp(false);
                                if (i.this.jVL != null) {
                                    if (i.this.jYj == null || i.this.jYj.getChosedFiles() == null || i.this.jYj.getChosedFiles().size() <= 0 || !i.this.jYj.isOriginalImg() || i.this.jYi <= 0 || !i.this.cDG()) {
                                        i.this.jVL.b(true, i.this.jYj);
                                    } else {
                                        i.this.jVL.cDD();
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
            this.jYg = bundle.getInt("OutState_Write_Entrance");
            this.jFw = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.jYg = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jFw = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.jYj = new WriteImagesInfo();
            this.jYj.parseJson(str);
            cDE();
            if (this.jVL != null && this.jVL.jXZ != null) {
                this.jYf = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jVL.jXZ, this.jYj.getChosedFiles(), i, this, this.jVL, this.jYj.mIsFromIm);
                this.jVL.jXZ.setAdapter(this.jYf);
                int cCx = this.jYf.cCx();
                this.jVL.jXZ.setCurrentItem(cCx, true);
                if (cCx == 0) {
                    this.jYf.onPageSelected(0);
                }
                this.jVL.d(this.jYj);
            }
        }
    }

    private void cDE() {
        if (this.jYj != null && this.jYj.isOriginalImg() && this.jYj.getChosedFiles() != null && this.jYj.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.jYj.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.jYk.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cDF() {
        return this.jYg;
    }

    public ForumWriteData bnm() {
        return this.jFw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDG() {
        if (this.jYj == null || !this.jYj.isOriginalImg() || this.jYj.getChosedFiles() == null || this.jYj.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.jYj.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.jYk.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cCD() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cCE() {
        return (this.jVL == null || this.jVL.jYa == null || v.aa(this.jVL.jYa.getStickerViews())) ? false : true;
    }

    public void cDC() {
        this.jYi++;
    }

    public void cDH() {
        this.jYi--;
    }

    public WriteImagesInfo cDI() {
        return this.jYj;
    }

    public void su(boolean z) {
        if (cCE()) {
            this.jVL.jXZ.setmDisallowSlip(true);
        } else {
            this.jVL.jXZ.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cCB() {
        cDH();
        su(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void X(int i, boolean z) {
        Z(i, z);
    }

    private void Z(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jVM == null) {
                this.jVM = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jVM.hv(R.string.orginal_tip);
                this.jVM.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jVM != null) {
                            i.this.jVM.dismiss();
                        }
                        if (i.this.jYf != null) {
                            i.this.jYf.W(i, z);
                        }
                    }
                });
                this.jVM.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jVM != null) {
                            i.this.jVM.dismiss();
                        }
                    }
                });
                this.jVM.b(this.mPageContext);
            }
            this.jVM.agO();
        }
    }

    public boolean R(final Bitmap bitmap) {
        if (!this.jYf.cCy() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jVM == null) {
            this.jVM = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jVM.hv(R.string.orginal_tip);
            this.jVM.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jVM != null) {
                        i.this.jVM.dismiss();
                    }
                    i.this.jVL.Q(bitmap);
                }
            });
            this.jVM.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jVM != null) {
                        i.this.jVM.dismiss();
                    }
                }
            });
            this.jVM.b(this.mPageContext);
        }
        this.jVM.agO();
        return true;
    }

    public void destroy() {
        if (this.jYh != null) {
            this.jYh.destroy();
        }
    }
}
