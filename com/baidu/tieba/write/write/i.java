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
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData hMA;
    private h ibp;
    private com.baidu.tbadk.core.dialog.a ibq;
    private StickerModel idN;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter idL = null;
    private int idM = 0;
    private int idO = 0;
    private WriteImagesInfo idP = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> idQ = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ibp = hVar;
        initData(bundle);
        initListener();
        bQu();
    }

    public void bQu() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), e.j.neterror);
                    return;
                }
                return;
            }
            if (this.idN == null) {
                this.idN = new StickerModel(this.mPageContext);
            }
            this.idN.LoadData();
            this.idN.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void en(List<String> list) {
        if (this.ibp != null) {
            this.ibp.em(list);
        }
    }

    private void initListener() {
        if (this.ibp != null) {
            if (this.ibp.idE != null) {
                this.ibp.idE.w(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.idL.I(Integer.parseInt(view.getTag().toString()), i.this.bQw());
                        }
                    }
                });
            }
            if (this.ibp.idH != null) {
                this.ibp.idH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.mPermissionJudgement.EG();
                            i.this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.B(pageActivity)) {
                                i.this.idL.oG(false);
                                if (i.this.ibp != null) {
                                    if (i.this.idP == null || i.this.idP.getChosedFiles() == null || i.this.idP.getChosedFiles().size() <= 0 || !i.this.idP.isOriginalImg() || i.this.idO <= 0 || !i.this.bRx()) {
                                        i.this.ibp.b(true, i.this.idP);
                                    } else {
                                        i.this.ibp.bRu();
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
            this.idM = bundle.getInt("OutState_Write_Entrance");
            this.hMA = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.idM = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hMA = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.idP = new WriteImagesInfo();
            this.idP.parseJson(str);
            bRv();
            if (this.ibp != null && this.ibp.idF != null) {
                this.idL = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.ibp.idF, this.idP.getChosedFiles(), i, this, this.ibp, this.idP.mIsFromIm);
                this.ibp.idF.setAdapter(this.idL);
                this.ibp.idF.setCurrentItem(i, true);
                if (i == 0) {
                    this.idL.onPageSelected(0);
                }
                this.ibp.d(this.idP);
            }
        }
    }

    private void bRv() {
        if (this.idP != null && this.idP.isOriginalImg() && this.idP.getChosedFiles() != null && this.idP.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.idP.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.idQ.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bRw() {
        return this.idM;
    }

    public ForumWriteData aCo() {
        return this.hMA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bRx() {
        if (this.idP == null || !this.idP.isOriginalImg() || this.idP.getChosedFiles() == null || this.idP.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.idP.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.idQ.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bQv() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bQw() {
        return (this.ibp == null || this.ibp.idG == null || v.I(this.ibp.idG.getStickerViews())) ? false : true;
    }

    public void bRt() {
        this.idO++;
    }

    public void bRy() {
        this.idO--;
    }

    public WriteImagesInfo bRz() {
        return this.idP;
    }

    public void oL(boolean z) {
        if (bQw()) {
            this.ibp.idF.setmDisallowSlip(true);
        } else {
            this.ibp.idF.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bQt() {
        bRy();
        oL(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.ibq == null) {
                this.ibq = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.ibq.db(e.j.orginal_tip);
                this.ibq.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.ibq != null) {
                            i.this.ibq.dismiss();
                        }
                        if (i.this.idL != null) {
                            i.this.idL.I(i, z);
                        }
                    }
                });
                this.ibq.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.ibq != null) {
                            i.this.ibq.dismiss();
                        }
                    }
                });
                this.ibq.b(this.mPageContext);
            }
            this.ibq.BS();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.idL.bQq() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.ibq == null) {
            this.ibq = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.ibq.db(e.j.orginal_tip);
            this.ibq.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.ibq != null) {
                        i.this.ibq.dismiss();
                    }
                    i.this.ibp.H(bitmap);
                }
            });
            this.ibq.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.ibq != null) {
                        i.this.ibq.dismiss();
                    }
                }
            });
            this.ibq.b(this.mPageContext);
        }
        this.ibq.BS();
        return true;
    }

    public void destroy() {
        if (this.idN != null) {
            this.idN.destroy();
        }
    }
}
