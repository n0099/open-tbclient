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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData jcX;
    private h jsm;
    private com.baidu.tbadk.core.dialog.a jsn;
    private StickerModel juI;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter juG = null;
    private int juH = 0;
    private int juJ = 0;
    private WriteImagesInfo juK = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> juL = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jsm = hVar;
        initData(bundle);
        initListener();
        cqr();
    }

    public void cqr() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            if (this.juI == null) {
                this.juI = new StickerModel(this.mPageContext);
            }
            this.juI.LoadData();
            this.juI.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void es(List<String> list) {
        if (this.jsm != null) {
            this.jsm.er(list);
        }
    }

    private void initListener() {
        if (this.jsm != null) {
            if (this.jsm.juz != null) {
                this.jsm.juz.x(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.juG.O(Integer.parseInt(view.getTag().toString()), i.this.cqt());
                        }
                    }
                });
            }
            if (this.jsm.juC != null) {
                this.jsm.juC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.mPermissionJudgement.adQ();
                            i.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.Y(pageActivity)) {
                                i.this.juG.rg(false);
                                if (i.this.jsm != null) {
                                    if (i.this.juK == null || i.this.juK.getChosedFiles() == null || i.this.juK.getChosedFiles().size() <= 0 || !i.this.juK.isOriginalImg() || i.this.juJ <= 0 || !i.this.crt()) {
                                        i.this.jsm.b(true, i.this.juK);
                                    } else {
                                        i.this.jsm.crq();
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
            this.juH = bundle.getInt("OutState_Write_Entrance");
            this.jcX = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.juH = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jcX = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.juK = new WriteImagesInfo();
            this.juK.parseJson(str);
            crr();
            if (this.jsm != null && this.jsm.juA != null) {
                this.juG = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jsm.juA, this.juK.getChosedFiles(), i, this, this.jsm, this.juK.mIsFromIm);
                this.jsm.juA.setAdapter(this.juG);
                int cqm = this.juG.cqm();
                this.jsm.juA.setCurrentItem(cqm, true);
                if (cqm == 0) {
                    this.juG.onPageSelected(0);
                }
                this.jsm.d(this.juK);
            }
        }
    }

    private void crr() {
        if (this.juK != null && this.juK.isOriginalImg() && this.juK.getChosedFiles() != null && this.juK.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.juK.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.juL.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int crs() {
        return this.juH;
    }

    public ForumWriteData bcU() {
        return this.jcX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crt() {
        if (this.juK == null || !this.juK.isOriginalImg() || this.juK.getChosedFiles() == null || this.juK.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.juK.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.juL.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cqs() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cqt() {
        return (this.jsm == null || this.jsm.juB == null || v.T(this.jsm.juB.getStickerViews())) ? false : true;
    }

    public void crp() {
        this.juJ++;
    }

    public void cru() {
        this.juJ--;
    }

    public WriteImagesInfo crv() {
        return this.juK;
    }

    public void rl(boolean z) {
        if (cqt()) {
            this.jsm.juA.setmDisallowSlip(true);
        } else {
            this.jsm.juA.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cqq() {
        cru();
        rl(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void P(int i, boolean z) {
        R(i, z);
    }

    private void R(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jsn == null) {
                this.jsn = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jsn.gD(d.j.orginal_tip);
                this.jsn.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jsn != null) {
                            i.this.jsn.dismiss();
                        }
                        if (i.this.juG != null) {
                            i.this.juG.O(i, z);
                        }
                    }
                });
                this.jsn.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jsn != null) {
                            i.this.jsn.dismiss();
                        }
                    }
                });
                this.jsn.b(this.mPageContext);
            }
            this.jsn.aaZ();
        }
    }

    public boolean Q(final Bitmap bitmap) {
        if (!this.juG.cqn() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jsn == null) {
            this.jsn = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jsn.gD(d.j.orginal_tip);
            this.jsn.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jsn != null) {
                        i.this.jsn.dismiss();
                    }
                    i.this.jsm.P(bitmap);
                }
            });
            this.jsn.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jsn != null) {
                        i.this.jsn.dismiss();
                    }
                }
            });
            this.jsn.b(this.mPageContext);
        }
        this.jsn.aaZ();
        return true;
    }

    public void destroy() {
        if (this.juI != null) {
            this.juI.destroy();
        }
    }
}
