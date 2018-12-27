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
    private com.baidu.tbadk.core.util.b.a bzi;
    private ForumWriteData hLt;
    private h iai;
    private com.baidu.tbadk.core.dialog.a iaj;
    private StickerModel icD;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter icB = null;
    private int icC = 0;
    private int icE = 0;
    private WriteImagesInfo icF = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> icG = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.iai = hVar;
        initData(bundle);
        initListener();
        bPM();
    }

    public void bPM() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), e.j.neterror);
                    return;
                }
                return;
            }
            if (this.icD == null) {
                this.icD = new StickerModel(this.mPageContext);
            }
            this.icD.LoadData();
            this.icD.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void em(List<String> list) {
        if (this.iai != null) {
            this.iai.el(list);
        }
    }

    private void initListener() {
        if (this.iai != null) {
            if (this.iai.icu != null) {
                this.iai.icu.w(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.icB.I(Integer.parseInt(view.getTag().toString()), i.this.bPO());
                        }
                    }
                });
            }
            if (this.iai.icx != null) {
                this.iai.icx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.bzi == null) {
                                i.this.bzi = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.bzi.Et();
                            i.this.bzi.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.bzi.A(pageActivity)) {
                                i.this.icB.oF(false);
                                if (i.this.iai != null) {
                                    if (i.this.icF == null || i.this.icF.getChosedFiles() == null || i.this.icF.getChosedFiles().size() <= 0 || !i.this.icF.isOriginalImg() || i.this.icE <= 0 || !i.this.bQP()) {
                                        i.this.iai.b(true, i.this.icF);
                                    } else {
                                        i.this.iai.bQM();
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
            this.icC = bundle.getInt("OutState_Write_Entrance");
            this.hLt = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.icC = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hLt = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.icF = new WriteImagesInfo();
            this.icF.parseJson(str);
            bQN();
            if (this.iai != null && this.iai.icv != null) {
                this.icB = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.iai.icv, this.icF.getChosedFiles(), i, this, this.iai, this.icF.mIsFromIm);
                this.iai.icv.setAdapter(this.icB);
                this.iai.icv.setCurrentItem(i, true);
                if (i == 0) {
                    this.icB.onPageSelected(0);
                }
                this.iai.d(this.icF);
            }
        }
    }

    private void bQN() {
        if (this.icF != null && this.icF.isOriginalImg() && this.icF.getChosedFiles() != null && this.icF.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.icF.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.icG.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bQO() {
        return this.icC;
    }

    public ForumWriteData aBR() {
        return this.hLt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bQP() {
        if (this.icF == null || !this.icF.isOriginalImg() || this.icF.getChosedFiles() == null || this.icF.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.icF.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.icG.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bPN() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bPO() {
        return (this.iai == null || this.iai.icw == null || v.I(this.iai.icw.getStickerViews())) ? false : true;
    }

    public void bQL() {
        this.icE++;
    }

    public void bQQ() {
        this.icE--;
    }

    public WriteImagesInfo bQR() {
        return this.icF;
    }

    public void oK(boolean z) {
        if (bPO()) {
            this.iai.icv.setmDisallowSlip(true);
        } else {
            this.iai.icv.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bPL() {
        bQQ();
        oK(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.iaj == null) {
                this.iaj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.iaj.db(e.j.orginal_tip);
                this.iaj.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.iaj != null) {
                            i.this.iaj.dismiss();
                        }
                        if (i.this.icB != null) {
                            i.this.icB.I(i, z);
                        }
                    }
                });
                this.iaj.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.iaj != null) {
                            i.this.iaj.dismiss();
                        }
                    }
                });
                this.iaj.b(this.mPageContext);
            }
            this.iaj.BF();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.icB.bPI() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.iaj == null) {
            this.iaj = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.iaj.db(e.j.orginal_tip);
            this.iaj.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.iaj != null) {
                        i.this.iaj.dismiss();
                    }
                    i.this.iai.H(bitmap);
                }
            });
            this.iaj.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.iaj != null) {
                        i.this.iaj.dismiss();
                    }
                }
            });
            this.iaj.b(this.mPageContext);
        }
        this.iaj.BF();
        return true;
    }

    public void destroy() {
        if (this.icD != null) {
            this.icD.destroy();
        }
    }
}
