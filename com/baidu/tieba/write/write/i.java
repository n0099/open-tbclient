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
    private ForumWriteData jBT;
    private h jSi;
    private com.baidu.tbadk.core.dialog.a jSj;
    private StickerModel jUE;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter jUC = null;
    private int jUD = 0;
    private int jUF = 0;
    private WriteImagesInfo jUG = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> jUH = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jSi = hVar;
        initData(bundle);
        initListener();
        cBt();
    }

    public void cBt() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kc()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.jUE == null) {
                this.jUE = new StickerModel(this.mPageContext);
            }
            this.jUE.LoadData();
            this.jUE.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eC(List<String> list) {
        if (this.jSi != null) {
            this.jSi.eB(list);
        }
    }

    private void initListener() {
        if (this.jSi != null) {
            if (this.jSi.jUv != null) {
                this.jSi.jUv.B(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.jUC.V(Integer.parseInt(view.getTag().toString()), i.this.cBv());
                        }
                    }
                });
            }
            if (this.jSi.jUy != null) {
                this.jSi.jUy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.mPermissionJudgement.ajQ();
                            i.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.ad(pageActivity)) {
                                i.this.jUC.sl(false);
                                if (i.this.jSi != null) {
                                    if (i.this.jUG == null || i.this.jUG.getChosedFiles() == null || i.this.jUG.getChosedFiles().size() <= 0 || !i.this.jUG.isOriginalImg() || i.this.jUF <= 0 || !i.this.cCx()) {
                                        i.this.jSi.b(true, i.this.jUG);
                                    } else {
                                        i.this.jSi.cCu();
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
            this.jUD = bundle.getInt("OutState_Write_Entrance");
            this.jBT = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.jUD = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jBT = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.jUG = new WriteImagesInfo();
            this.jUG.parseJson(str);
            cCv();
            if (this.jSi != null && this.jSi.jUw != null) {
                this.jUC = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jSi.jUw, this.jUG.getChosedFiles(), i, this, this.jSi, this.jUG.mIsFromIm);
                this.jSi.jUw.setAdapter(this.jUC);
                int cBo = this.jUC.cBo();
                this.jSi.jUw.setCurrentItem(cBo, true);
                if (cBo == 0) {
                    this.jUC.onPageSelected(0);
                }
                this.jSi.d(this.jUG);
            }
        }
    }

    private void cCv() {
        if (this.jUG != null && this.jUG.isOriginalImg() && this.jUG.getChosedFiles() != null && this.jUG.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.jUG.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.jUH.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int cCw() {
        return this.jUD;
    }

    public ForumWriteData bmr() {
        return this.jBT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cCx() {
        if (this.jUG == null || !this.jUG.isOriginalImg() || this.jUG.getChosedFiles() == null || this.jUG.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.jUG.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.jUH.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cBu() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cBv() {
        return (this.jSi == null || this.jSi.jUx == null || v.aa(this.jSi.jUx.getStickerViews())) ? false : true;
    }

    public void cCt() {
        this.jUF++;
    }

    public void cCy() {
        this.jUF--;
    }

    public WriteImagesInfo cCz() {
        return this.jUG;
    }

    public void sq(boolean z) {
        if (cBv()) {
            this.jSi.jUw.setmDisallowSlip(true);
        } else {
            this.jSi.jUw.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cBs() {
        cCy();
        sq(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void W(int i, boolean z) {
        Y(i, z);
    }

    private void Y(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jSj == null) {
                this.jSj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jSj.hu(R.string.orginal_tip);
                this.jSj.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jSj != null) {
                            i.this.jSj.dismiss();
                        }
                        if (i.this.jUC != null) {
                            i.this.jUC.V(i, z);
                        }
                    }
                });
                this.jSj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jSj != null) {
                            i.this.jSj.dismiss();
                        }
                    }
                });
                this.jSj.b(this.mPageContext);
            }
            this.jSj.agI();
        }
    }

    public boolean R(final Bitmap bitmap) {
        if (!this.jUC.cBp() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jSj == null) {
            this.jSj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jSj.hu(R.string.orginal_tip);
            this.jSj.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jSj != null) {
                        i.this.jSj.dismiss();
                    }
                    i.this.jSi.Q(bitmap);
                }
            });
            this.jSj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jSj != null) {
                        i.this.jSj.dismiss();
                    }
                }
            });
            this.jSj.b(this.mPageContext);
        }
        this.jSj.agI();
        return true;
    }

    public void destroy() {
        if (this.jUE != null) {
            this.jUE.destroy();
        }
    }
}
