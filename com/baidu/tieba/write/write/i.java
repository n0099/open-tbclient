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
import com.baidu.tbadk.core.util.w;
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
    private com.baidu.tbadk.core.util.b.a bkU;
    private StickerModel hAM;
    private ForumWriteData hki;
    private h hyr;
    private com.baidu.tbadk.core.dialog.a hys;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hAK = null;
    private int hAL = 0;
    private int hAN = 0;
    private WriteImagesInfo hAO = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hAP = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hyr = hVar;
        initData(bundle);
        initListener();
        bHk();
    }

    public void bHk() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.jE()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            if (this.hAM == null) {
                this.hAM = new StickerModel(this.mPageContext);
            }
            this.hAM.LoadData();
            this.hAM.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dU(List<String> list) {
        if (this.hyr != null) {
            this.hyr.dT(list);
        }
    }

    private void initListener() {
        if (this.hyr != null) {
            if (this.hyr.hAD != null) {
                this.hyr.hAD.u(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.hAK.H(Integer.parseInt(view.getTag().toString()), i.this.bHm());
                        }
                    }
                });
            }
            if (this.hyr.hAG != null) {
                this.hyr.hAG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.bkU == null) {
                                i.this.bkU = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.bkU.zY();
                            i.this.bkU.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.bkU.u(pageActivity)) {
                                i.this.hAK.nz(false);
                                if (i.this.hyr != null) {
                                    if (i.this.hAO == null || i.this.hAO.getChosedFiles() == null || i.this.hAO.getChosedFiles().size() <= 0 || !i.this.hAO.isOriginalImg() || i.this.hAN <= 0 || !i.this.bIo()) {
                                        i.this.hyr.b(true, i.this.hAO);
                                    } else {
                                        i.this.hyr.bIl();
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
            this.hAL = bundle.getInt("OutState_Write_Entrance");
            this.hki = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hAL = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hki = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hAO = new WriteImagesInfo();
            this.hAO.parseJson(str);
            bIm();
            if (this.hyr != null && this.hyr.hAE != null) {
                this.hAK = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hyr.hAE, this.hAO.getChosedFiles(), i, this, this.hyr, this.hAO.mIsFromIm);
                this.hyr.hAE.setAdapter(this.hAK);
                this.hyr.hAE.setCurrentItem(i, true);
                if (i == 0) {
                    this.hAK.onPageSelected(0);
                }
                this.hyr.d(this.hAO);
            }
        }
    }

    private void bIm() {
        if (this.hAO != null && this.hAO.isOriginalImg() && this.hAO.getChosedFiles() != null && this.hAO.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hAO.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hAP.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bIn() {
        return this.hAL;
    }

    public ForumWriteData auG() {
        return this.hki;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIo() {
        if (this.hAO == null || !this.hAO.isOriginalImg() || this.hAO.getChosedFiles() == null || this.hAO.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hAO.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hAP.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bHl() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bHm() {
        return (this.hyr == null || this.hyr.hAF == null || w.z(this.hyr.hAF.getStickerViews())) ? false : true;
    }

    public void bIk() {
        this.hAN++;
    }

    public void bIp() {
        this.hAN--;
    }

    public WriteImagesInfo bIq() {
        return this.hAO;
    }

    public void nE(boolean z) {
        if (bHm()) {
            this.hyr.hAE.setmDisallowSlip(true);
        } else {
            this.hyr.hAE.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bHj() {
        bIp();
        nE(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void I(int i, boolean z) {
        K(i, z);
    }

    private void K(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hys == null) {
                this.hys = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hys.cf(d.j.orginal_tip);
                this.hys.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hys != null) {
                            i.this.hys.dismiss();
                        }
                        if (i.this.hAK != null) {
                            i.this.hAK.H(i, z);
                        }
                    }
                });
                this.hys.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hys != null) {
                            i.this.hys.dismiss();
                        }
                    }
                });
                this.hys.b(this.mPageContext);
            }
            this.hys.xf();
        }
    }

    public boolean H(final Bitmap bitmap) {
        if (!this.hAK.bHg() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hys == null) {
            this.hys = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hys.cf(d.j.orginal_tip);
            this.hys.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hys != null) {
                        i.this.hys.dismiss();
                    }
                    i.this.hyr.G(bitmap);
                }
            });
            this.hys.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hys != null) {
                        i.this.hys.dismiss();
                    }
                }
            });
            this.hys.b(this.mPageContext);
        }
        this.hys.xf();
        return true;
    }

    public void destroy() {
        if (this.hAM != null) {
            this.hAM.destroy();
        }
    }
}
