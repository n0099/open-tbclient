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
    private h jLj;
    private com.baidu.tbadk.core.dialog.a jLk;
    private StickerModel jNF;
    private ForumWriteData jvK;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter jND = null;
    private int jNE = 0;
    private int jNG = 0;
    private WriteImagesInfo jNH = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> jNI = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jLj = hVar;
        initData(bundle);
        initListener();
        cyv();
    }

    public void cyv() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.jS()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.jNF == null) {
                this.jNF = new StickerModel(this.mPageContext);
            }
            this.jNF.LoadData();
            this.jNF.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void ez(List<String> list) {
        if (this.jLj != null) {
            this.jLj.ey(list);
        }
    }

    private void initListener() {
        if (this.jLj != null) {
            if (this.jLj.jNw != null) {
                this.jLj.jNw.z(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.jND.T(Integer.parseInt(view.getTag().toString()), i.this.cyx());
                        }
                    }
                });
            }
            if (this.jLj.jNz != null) {
                this.jLj.jNz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.mPermissionJudgement.aiM();
                            i.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.aa(pageActivity)) {
                                i.this.jND.rW(false);
                                if (i.this.jLj != null) {
                                    if (i.this.jNH == null || i.this.jNH.getChosedFiles() == null || i.this.jNH.getChosedFiles().size() <= 0 || !i.this.jNH.isOriginalImg() || i.this.jNG <= 0 || !i.this.czz()) {
                                        i.this.jLj.b(true, i.this.jNH);
                                    } else {
                                        i.this.jLj.czw();
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
            this.jNE = bundle.getInt("OutState_Write_Entrance");
            this.jvK = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.jNE = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jvK = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.jNH = new WriteImagesInfo();
            this.jNH.parseJson(str);
            czx();
            if (this.jLj != null && this.jLj.jNx != null) {
                this.jND = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jLj.jNx, this.jNH.getChosedFiles(), i, this, this.jLj, this.jNH.mIsFromIm);
                this.jLj.jNx.setAdapter(this.jND);
                int cyq = this.jND.cyq();
                this.jLj.jNx.setCurrentItem(cyq, true);
                if (cyq == 0) {
                    this.jND.onPageSelected(0);
                }
                this.jLj.d(this.jNH);
            }
        }
    }

    private void czx() {
        if (this.jNH != null && this.jNH.isOriginalImg() && this.jNH.getChosedFiles() != null && this.jNH.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.jNH.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.jNI.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int czy() {
        return this.jNE;
    }

    public ForumWriteData bkp() {
        return this.jvK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czz() {
        if (this.jNH == null || !this.jNH.isOriginalImg() || this.jNH.getChosedFiles() == null || this.jNH.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.jNH.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.jNI.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cyw() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cyx() {
        return (this.jLj == null || this.jLj.jNy == null || v.aa(this.jLj.jNy.getStickerViews())) ? false : true;
    }

    public void czv() {
        this.jNG++;
    }

    public void czA() {
        this.jNG--;
    }

    public WriteImagesInfo czB() {
        return this.jNH;
    }

    public void sb(boolean z) {
        if (cyx()) {
            this.jLj.jNx.setmDisallowSlip(true);
        } else {
            this.jLj.jNx.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cyu() {
        czA();
        sb(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void U(int i, boolean z) {
        W(i, z);
    }

    private void W(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jLk == null) {
                this.jLk = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jLk.ho(R.string.orginal_tip);
                this.jLk.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jLk != null) {
                            i.this.jLk.dismiss();
                        }
                        if (i.this.jND != null) {
                            i.this.jND.T(i, z);
                        }
                    }
                });
                this.jLk.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jLk != null) {
                            i.this.jLk.dismiss();
                        }
                    }
                });
                this.jLk.b(this.mPageContext);
            }
            this.jLk.afG();
        }
    }

    public boolean R(final Bitmap bitmap) {
        if (!this.jND.cyr() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jLk == null) {
            this.jLk = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jLk.ho(R.string.orginal_tip);
            this.jLk.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jLk != null) {
                        i.this.jLk.dismiss();
                    }
                    i.this.jLj.Q(bitmap);
                }
            });
            this.jLk.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jLk != null) {
                        i.this.jLk.dismiss();
                    }
                }
            });
            this.jLk.b(this.mPageContext);
        }
        this.jLk.afG();
        return true;
    }

    public void destroy() {
        if (this.jNF != null) {
            this.jNF.destroy();
        }
    }
}
