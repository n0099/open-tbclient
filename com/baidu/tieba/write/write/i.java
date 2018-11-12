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
    private com.baidu.tbadk.core.util.b.a bvI;
    private ForumWriteData hAW;
    private h hPN;
    private com.baidu.tbadk.core.dialog.a hPO;
    private StickerModel hSi;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hSg = null;
    private int hSh = 0;
    private int hSj = 0;
    private WriteImagesInfo hSk = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hSl = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hPN = hVar;
        initData(bundle);
        initListener();
        bMQ();
    }

    public void bMQ() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), e.j.neterror);
                    return;
                }
                return;
            }
            if (this.hSi == null) {
                this.hSi = new StickerModel(this.mPageContext);
            }
            this.hSi.LoadData();
            this.hSi.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eh(List<String> list) {
        if (this.hPN != null) {
            this.hPN.eg(list);
        }
    }

    private void initListener() {
        if (this.hPN != null) {
            if (this.hPN.hRZ != null) {
                this.hPN.hRZ.w(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.hSg.I(Integer.parseInt(view.getTag().toString()), i.this.bMS());
                        }
                    }
                });
            }
            if (this.hPN.hSc != null) {
                this.hPN.hSc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.bvI == null) {
                                i.this.bvI = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.bvI.Dp();
                            i.this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.bvI.A(pageActivity)) {
                                i.this.hSg.oA(false);
                                if (i.this.hPN != null) {
                                    if (i.this.hSk == null || i.this.hSk.getChosedFiles() == null || i.this.hSk.getChosedFiles().size() <= 0 || !i.this.hSk.isOriginalImg() || i.this.hSj <= 0 || !i.this.bNT()) {
                                        i.this.hPN.b(true, i.this.hSk);
                                    } else {
                                        i.this.hPN.bNQ();
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
            this.hSh = bundle.getInt("OutState_Write_Entrance");
            this.hAW = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hSh = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hAW = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hSk = new WriteImagesInfo();
            this.hSk.parseJson(str);
            bNR();
            if (this.hPN != null && this.hPN.hSa != null) {
                this.hSg = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hPN.hSa, this.hSk.getChosedFiles(), i, this, this.hPN, this.hSk.mIsFromIm);
                this.hPN.hSa.setAdapter(this.hSg);
                this.hPN.hSa.setCurrentItem(i, true);
                if (i == 0) {
                    this.hSg.onPageSelected(0);
                }
                this.hPN.d(this.hSk);
            }
        }
    }

    private void bNR() {
        if (this.hSk != null && this.hSk.isOriginalImg() && this.hSk.getChosedFiles() != null && this.hSk.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hSk.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hSl.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bNS() {
        return this.hSh;
    }

    public ForumWriteData azs() {
        return this.hAW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNT() {
        if (this.hSk == null || !this.hSk.isOriginalImg() || this.hSk.getChosedFiles() == null || this.hSk.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hSk.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hSl.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bMR() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bMS() {
        return (this.hPN == null || this.hPN.hSb == null || v.I(this.hPN.hSb.getStickerViews())) ? false : true;
    }

    public void bNP() {
        this.hSj++;
    }

    public void bNU() {
        this.hSj--;
    }

    public WriteImagesInfo bNV() {
        return this.hSk;
    }

    public void oF(boolean z) {
        if (bMS()) {
            this.hPN.hSa.setmDisallowSlip(true);
        } else {
            this.hPN.hSa.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bMP() {
        bNU();
        oF(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hPO == null) {
                this.hPO = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hPO.cN(e.j.orginal_tip);
                this.hPO.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hPO != null) {
                            i.this.hPO.dismiss();
                        }
                        if (i.this.hSg != null) {
                            i.this.hSg.I(i, z);
                        }
                    }
                });
                this.hPO.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hPO != null) {
                            i.this.hPO.dismiss();
                        }
                    }
                });
                this.hPO.b(this.mPageContext);
            }
            this.hPO.AB();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.hSg.bMM() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hPO == null) {
            this.hPO = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hPO.cN(e.j.orginal_tip);
            this.hPO.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hPO != null) {
                        i.this.hPO.dismiss();
                    }
                    i.this.hPN.H(bitmap);
                }
            });
            this.hPO.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hPO != null) {
                        i.this.hPO.dismiss();
                    }
                }
            });
            this.hPO.b(this.mPageContext);
        }
        this.hPO.AB();
        return true;
    }

    public void destroy() {
        if (this.hSi != null) {
            this.hSi.destroy();
        }
    }
}
