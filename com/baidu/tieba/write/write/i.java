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
    private com.baidu.tbadk.core.util.b.a bqO;
    private h hGQ;
    private com.baidu.tbadk.core.dialog.a hGR;
    private StickerModel hJl;
    private ForumWriteData hrY;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    public MultiImagePagerAdapter hJj = null;
    private int hJk = 0;
    private int hJm = 0;
    private WriteImagesInfo hJn = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> hJo = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.hGQ = hVar;
        initData(bundle);
        initListener();
        bKf();
    }

    public void bKf() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kK()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), e.j.neterror);
                    return;
                }
                return;
            }
            if (this.hJl == null) {
                this.hJl = new StickerModel(this.mPageContext);
            }
            this.hJl.LoadData();
            this.hJl.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void dV(List<String> list) {
        if (this.hGQ != null) {
            this.hGQ.dU(list);
        }
    }

    private void initListener() {
        if (this.hGQ != null) {
            if (this.hGQ.hJc != null) {
                this.hGQ.hJc.u(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.hJj.I(Integer.parseInt(view.getTag().toString()), i.this.bKh());
                        }
                    }
                });
            }
            if (this.hGQ.hJf != null) {
                this.hGQ.hJf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.bqO == null) {
                                i.this.bqO = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.bqO.Bb();
                            i.this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.bqO.x(pageActivity)) {
                                i.this.hJj.nW(false);
                                if (i.this.hGQ != null) {
                                    if (i.this.hJn == null || i.this.hJn.getChosedFiles() == null || i.this.hJn.getChosedFiles().size() <= 0 || !i.this.hJn.isOriginalImg() || i.this.hJm <= 0 || !i.this.bLj()) {
                                        i.this.hGQ.b(true, i.this.hJn);
                                    } else {
                                        i.this.hGQ.bLg();
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
            this.hJk = bundle.getInt("OutState_Write_Entrance");
            this.hrY = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.hJk = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.hrY = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.hJn = new WriteImagesInfo();
            this.hJn.parseJson(str);
            bLh();
            if (this.hGQ != null && this.hGQ.hJd != null) {
                this.hJj = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.hGQ.hJd, this.hJn.getChosedFiles(), i, this, this.hGQ, this.hJn.mIsFromIm);
                this.hGQ.hJd.setAdapter(this.hJj);
                this.hGQ.hJd.setCurrentItem(i, true);
                if (i == 0) {
                    this.hJj.onPageSelected(0);
                }
                this.hGQ.d(this.hJn);
            }
        }
    }

    private void bLh() {
        if (this.hJn != null && this.hJn.isOriginalImg() && this.hJn.getChosedFiles() != null && this.hJn.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.hJn.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.hJo.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int bLi() {
        return this.hJk;
    }

    public ForumWriteData awy() {
        return this.hrY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLj() {
        if (this.hJn == null || !this.hJn.isOriginalImg() || this.hJn.getChosedFiles() == null || this.hJn.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.hJn.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.hJo.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bKg() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean bKh() {
        return (this.hGQ == null || this.hGQ.hJe == null || v.z(this.hGQ.hJe.getStickerViews())) ? false : true;
    }

    public void bLf() {
        this.hJm++;
    }

    public void bLk() {
        this.hJm--;
    }

    public WriteImagesInfo bLl() {
        return this.hJn;
    }

    public void ob(boolean z) {
        if (bKh()) {
            this.hGQ.hJd.setmDisallowSlip(true);
        } else {
            this.hGQ.hJd.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void bKe() {
        bLk();
        ob(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void J(int i, boolean z) {
        L(i, z);
    }

    private void L(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.hGR == null) {
                this.hGR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.hGR.cp(e.j.orginal_tip);
                this.hGR.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hGR != null) {
                            i.this.hGR.dismiss();
                        }
                        if (i.this.hJj != null) {
                            i.this.hJj.I(i, z);
                        }
                    }
                });
                this.hGR.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.hGR != null) {
                            i.this.hGR.dismiss();
                        }
                    }
                });
                this.hGR.b(this.mPageContext);
            }
            this.hGR.yl();
        }
    }

    public boolean I(final Bitmap bitmap) {
        if (!this.hJj.bKb() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.hGR == null) {
            this.hGR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.hGR.cp(e.j.orginal_tip);
            this.hGR.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hGR != null) {
                        i.this.hGR.dismiss();
                    }
                    i.this.hGQ.H(bitmap);
                }
            });
            this.hGR.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.hGR != null) {
                        i.this.hGR.dismiss();
                    }
                }
            });
            this.hGR.b(this.mPageContext);
        }
        this.hGR.yl();
        return true;
    }

    public void destroy() {
        if (this.hJl != null) {
            this.hJl.destroy();
        }
    }
}
