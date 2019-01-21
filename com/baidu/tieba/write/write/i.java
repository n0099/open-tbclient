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
    private ForumWriteData hMB;
    private h ibq;
    private com.baidu.tbadk.core.dialog.a ibr;
    private StickerModel idO;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter idM = null;
    private int idN = 0;
    private int idP = 0;
    private WriteImagesInfo idQ = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> idR = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ibq = hVar;
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
            if (this.idO == null) {
                this.idO = new StickerModel(this.mPageContext);
            }
            this.idO.LoadData();
            this.idO.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void en(List<String> list) {
        if (this.ibq != null) {
            this.ibq.em(list);
        }
    }

    private void initListener() {
        if (this.ibq != null) {
            if (this.ibq.idF != null) {
                this.ibq.idF.w(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.idM.I(Integer.parseInt(view.getTag().toString()), i.this.bQw());
                        }
                    }
                });
            }
            if (this.ibq.idI != null) {
                this.ibq.idI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.idM.oG(false);
                                if (i.this.ibq != null) {
                                    if (i.this.idQ == null || i.this.idQ.getChosedFiles() == null || i.this.idQ.getChosedFiles().size() <= 0 || !i.this.idQ.isOriginalImg() || i.this.idP <= 0 || !i.this.bRx()) {
                                        i.this.ibq.b(true, i.this.idQ);
                                    } else {
                                        i.this.ibq.bRu();
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
            this.idN = bundle.getInt("OutState_Write_Entrance");
            this.hMB = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.idN = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hMB = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.idQ = new WriteImagesInfo();
            this.idQ.parseJson(str);
            bRv();
            if (this.ibq != null && this.ibq.idG != null) {
                this.idM = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.ibq.idG, this.idQ.getChosedFiles(), i, this, this.ibq, this.idQ.mIsFromIm);
                this.ibq.idG.setAdapter(this.idM);
                this.ibq.idG.setCurrentItem(i, true);
                if (i == 0) {
                    this.idM.onPageSelected(0);
                }
                this.ibq.d(this.idQ);
            }
        }
    }

    private void bRv() {
        if (this.idQ != null && this.idQ.isOriginalImg() && this.idQ.getChosedFiles() != null && this.idQ.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.idQ.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.idR.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bRw() {
        return this.idN;
    }

    public ForumWriteData aCo() {
        return this.hMB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bRx() {
        if (this.idQ == null || !this.idQ.isOriginalImg() || this.idQ.getChosedFiles() == null || this.idQ.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.idQ.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.idR.get(next.getFilePath()))) {
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
        return (this.ibq == null || this.ibq.idH == null || v.I(this.ibq.idH.getStickerViews())) ? false : true;
    }

    public void bRt() {
        this.idP++;
    }

    public void bRy() {
        this.idP--;
    }

    public WriteImagesInfo bRz() {
        return this.idQ;
    }

    public void oL(boolean z) {
        if (bQw()) {
            this.ibq.idG.setmDisallowSlip(true);
        } else {
            this.ibq.idG.setmDisallowSlip(false);
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
            if (this.ibr == null) {
                this.ibr = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.ibr.db(e.j.orginal_tip);
                this.ibr.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.ibr != null) {
                            i.this.ibr.dismiss();
                        }
                        if (i.this.idM != null) {
                            i.this.idM.I(i, z);
                        }
                    }
                });
                this.ibr.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.ibr != null) {
                            i.this.ibr.dismiss();
                        }
                    }
                });
                this.ibr.b(this.mPageContext);
            }
            this.ibr.BS();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.idM.bQq() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.ibr == null) {
            this.ibr = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.ibr.db(e.j.orginal_tip);
            this.ibr.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.ibr != null) {
                        i.this.ibr.dismiss();
                    }
                    i.this.ibq.H(bitmap);
                }
            });
            this.ibr.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.ibr != null) {
                        i.this.ibr.dismiss();
                    }
                }
            });
            this.ibr.b(this.mPageContext);
        }
        this.ibr.BS();
        return true;
    }

    public void destroy() {
        if (this.idO != null) {
            this.idO.destroy();
        }
    }
}
