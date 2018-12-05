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
    private com.baidu.tbadk.core.util.b.a bzf;
    private ForumWriteData hIi;
    private h hWX;
    private com.baidu.tbadk.core.dialog.a hWY;
    private StickerModel hZs;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hZq = null;
    private int hZr = 0;
    private int hZt = 0;
    private WriteImagesInfo hZu = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hZv = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hWX = hVar;
        initData(bundle);
        initListener();
        bOW();
    }

    public void bOW() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kV()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), e.j.neterror);
                    return;
                }
                return;
            }
            if (this.hZs == null) {
                this.hZs = new StickerModel(this.mPageContext);
            }
            this.hZs.LoadData();
            this.hZs.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void el(List<String> list) {
        if (this.hWX != null) {
            this.hWX.ek(list);
        }
    }

    private void initListener() {
        if (this.hWX != null) {
            if (this.hWX.hZj != null) {
                this.hWX.hZj.w(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.hZq.I(Integer.parseInt(view.getTag().toString()), i.this.bOY());
                        }
                    }
                });
            }
            if (this.hWX.hZm != null) {
                this.hWX.hZm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.bzf == null) {
                                i.this.bzf = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.bzf.Et();
                            i.this.bzf.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.bzf.A(pageActivity)) {
                                i.this.hZq.oC(false);
                                if (i.this.hWX != null) {
                                    if (i.this.hZu == null || i.this.hZu.getChosedFiles() == null || i.this.hZu.getChosedFiles().size() <= 0 || !i.this.hZu.isOriginalImg() || i.this.hZt <= 0 || !i.this.bPZ()) {
                                        i.this.hWX.b(true, i.this.hZu);
                                    } else {
                                        i.this.hWX.bPW();
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
            this.hZr = bundle.getInt("OutState_Write_Entrance");
            this.hIi = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hZr = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hIi = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hZu = new WriteImagesInfo();
            this.hZu.parseJson(str);
            bPX();
            if (this.hWX != null && this.hWX.hZk != null) {
                this.hZq = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hWX.hZk, this.hZu.getChosedFiles(), i, this, this.hWX, this.hZu.mIsFromIm);
                this.hWX.hZk.setAdapter(this.hZq);
                this.hWX.hZk.setCurrentItem(i, true);
                if (i == 0) {
                    this.hZq.onPageSelected(0);
                }
                this.hWX.d(this.hZu);
            }
        }
    }

    private void bPX() {
        if (this.hZu != null && this.hZu.isOriginalImg() && this.hZu.getChosedFiles() != null && this.hZu.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hZu.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hZv.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bPY() {
        return this.hZr;
    }

    public ForumWriteData aBc() {
        return this.hIi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPZ() {
        if (this.hZu == null || !this.hZu.isOriginalImg() || this.hZu.getChosedFiles() == null || this.hZu.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hZu.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hZv.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bOX() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bOY() {
        return (this.hWX == null || this.hWX.hZl == null || v.I(this.hWX.hZl.getStickerViews())) ? false : true;
    }

    public void bPV() {
        this.hZt++;
    }

    public void bQa() {
        this.hZt--;
    }

    public WriteImagesInfo bQb() {
        return this.hZu;
    }

    public void oH(boolean z) {
        if (bOY()) {
            this.hWX.hZk.setmDisallowSlip(true);
        } else {
            this.hWX.hZk.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bOV() {
        bQa();
        oH(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hWY == null) {
                this.hWY = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hWY.db(e.j.orginal_tip);
                this.hWY.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hWY != null) {
                            i.this.hWY.dismiss();
                        }
                        if (i.this.hZq != null) {
                            i.this.hZq.I(i, z);
                        }
                    }
                });
                this.hWY.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hWY != null) {
                            i.this.hWY.dismiss();
                        }
                    }
                });
                this.hWY.b(this.mPageContext);
            }
            this.hWY.BF();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.hZq.bOS() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hWY == null) {
            this.hWY = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hWY.db(e.j.orginal_tip);
            this.hWY.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hWY != null) {
                        i.this.hWY.dismiss();
                    }
                    i.this.hWX.H(bitmap);
                }
            });
            this.hWY.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hWY != null) {
                        i.this.hWY.dismiss();
                    }
                }
            });
            this.hWY.b(this.mPageContext);
        }
        this.hWY.BF();
        return true;
    }

    public void destroy() {
        if (this.hZs != null) {
            this.hZs.destroy();
        }
    }
}
