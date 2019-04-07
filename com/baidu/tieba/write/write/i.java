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
    private ForumWriteData jcL;
    private h jsc;
    private com.baidu.tbadk.core.dialog.a jsd;
    private StickerModel juy;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter juw = null;
    private int jux = 0;
    private int juz = 0;
    private WriteImagesInfo juA = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> juB = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jsc = hVar;
        initData(bundle);
        initListener();
        cqp();
    }

    public void cqp() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            if (this.juy == null) {
                this.juy = new StickerModel(this.mPageContext);
            }
            this.juy.LoadData();
            this.juy.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void ep(List<String> list) {
        if (this.jsc != null) {
            this.jsc.eo(list);
        }
    }

    private void initListener() {
        if (this.jsc != null) {
            if (this.jsc.jup != null) {
                this.jsc.jup.x(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.juw.O(Integer.parseInt(view.getTag().toString()), i.this.cqr());
                        }
                    }
                });
            }
            if (this.jsc.jus != null) {
                this.jsc.jus.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.mPermissionJudgement.adN();
                            i.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.Y(pageActivity)) {
                                i.this.juw.rg(false);
                                if (i.this.jsc != null) {
                                    if (i.this.juA == null || i.this.juA.getChosedFiles() == null || i.this.juA.getChosedFiles().size() <= 0 || !i.this.juA.isOriginalImg() || i.this.juz <= 0 || !i.this.crr()) {
                                        i.this.jsc.b(true, i.this.juA);
                                    } else {
                                        i.this.jsc.cro();
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
            this.jux = bundle.getInt("OutState_Write_Entrance");
            this.jcL = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.jux = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jcL = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.juA = new WriteImagesInfo();
            this.juA.parseJson(str);
            crp();
            if (this.jsc != null && this.jsc.juq != null) {
                this.juw = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jsc.juq, this.juA.getChosedFiles(), i, this, this.jsc, this.juA.mIsFromIm);
                this.jsc.juq.setAdapter(this.juw);
                int cqk = this.juw.cqk();
                this.jsc.juq.setCurrentItem(cqk, true);
                if (cqk == 0) {
                    this.juw.onPageSelected(0);
                }
                this.jsc.d(this.juA);
            }
        }
    }

    private void crp() {
        if (this.juA != null && this.juA.isOriginalImg() && this.juA.getChosedFiles() != null && this.juA.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.juA.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.juB.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int crq() {
        return this.jux;
    }

    public ForumWriteData bcS() {
        return this.jcL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crr() {
        if (this.juA == null || !this.juA.isOriginalImg() || this.juA.getChosedFiles() == null || this.juA.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.juA.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.juB.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cqq() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cqr() {
        return (this.jsc == null || this.jsc.jur == null || v.T(this.jsc.jur.getStickerViews())) ? false : true;
    }

    public void crn() {
        this.juz++;
    }

    public void crs() {
        this.juz--;
    }

    public WriteImagesInfo crt() {
        return this.juA;
    }

    public void rl(boolean z) {
        if (cqr()) {
            this.jsc.juq.setmDisallowSlip(true);
        } else {
            this.jsc.juq.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cqo() {
        crs();
        rl(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void P(int i, boolean z) {
        R(i, z);
    }

    private void R(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jsd == null) {
                this.jsd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jsd.gC(d.j.orginal_tip);
                this.jsd.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jsd != null) {
                            i.this.jsd.dismiss();
                        }
                        if (i.this.juw != null) {
                            i.this.juw.O(i, z);
                        }
                    }
                });
                this.jsd.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jsd != null) {
                            i.this.jsd.dismiss();
                        }
                    }
                });
                this.jsd.b(this.mPageContext);
            }
            this.jsd.aaW();
        }
    }

    public boolean Q(final Bitmap bitmap) {
        if (!this.juw.cql() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jsd == null) {
            this.jsd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jsd.gC(d.j.orginal_tip);
            this.jsd.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jsd != null) {
                        i.this.jsd.dismiss();
                    }
                    i.this.jsc.P(bitmap);
                }
            });
            this.jsd.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jsd != null) {
                        i.this.jsd.dismiss();
                    }
                }
            });
            this.jsd.b(this.mPageContext);
        }
        this.jsd.aaW();
        return true;
    }

    public void destroy() {
        if (this.juy != null) {
            this.juy.destroy();
        }
    }
}
