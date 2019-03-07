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
    private h jsb;
    private com.baidu.tbadk.core.dialog.a jsc;
    private StickerModel jux;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter juv = null;
    private int juw = 0;
    private int juy = 0;
    private WriteImagesInfo juz = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> juA = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jsb = hVar;
        initData(bundle);
        initListener();
        cqe();
    }

    public void cqe() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            if (this.jux == null) {
                this.jux = new StickerModel(this.mPageContext);
            }
            this.jux.LoadData();
            this.jux.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void es(List<String> list) {
        if (this.jsb != null) {
            this.jsb.er(list);
        }
    }

    private void initListener() {
        if (this.jsb != null) {
            if (this.jsb.juo != null) {
                this.jsb.juo.x(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.juv.O(Integer.parseInt(view.getTag().toString()), i.this.cqg());
                        }
                    }
                });
            }
            if (this.jsb.jur != null) {
                this.jsb.jur.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.juv.rg(false);
                                if (i.this.jsb != null) {
                                    if (i.this.juz == null || i.this.juz.getChosedFiles() == null || i.this.juz.getChosedFiles().size() <= 0 || !i.this.juz.isOriginalImg() || i.this.juy <= 0 || !i.this.crg()) {
                                        i.this.jsb.b(true, i.this.juz);
                                    } else {
                                        i.this.jsb.crd();
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
            this.juw = bundle.getInt("OutState_Write_Entrance");
            this.jcL = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.juw = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jcL = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.juz = new WriteImagesInfo();
            this.juz.parseJson(str);
            cre();
            if (this.jsb != null && this.jsb.jup != null) {
                this.juv = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jsb.jup, this.juz.getChosedFiles(), i, this, this.jsb, this.juz.mIsFromIm);
                this.jsb.jup.setAdapter(this.juv);
                int cpZ = this.juv.cpZ();
                this.jsb.jup.setCurrentItem(cpZ, true);
                if (cpZ == 0) {
                    this.juv.onPageSelected(0);
                }
                this.jsb.d(this.juz);
            }
        }
    }

    private void cre() {
        if (this.juz != null && this.juz.isOriginalImg() && this.juz.getChosedFiles() != null && this.juz.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.juz.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.juA.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int crf() {
        return this.juw;
    }

    public ForumWriteData bcU() {
        return this.jcL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crg() {
        if (this.juz == null || !this.juz.isOriginalImg() || this.juz.getChosedFiles() == null || this.juz.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.juz.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.juA.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cqf() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cqg() {
        return (this.jsb == null || this.jsb.juq == null || v.T(this.jsb.juq.getStickerViews())) ? false : true;
    }

    public void crc() {
        this.juy++;
    }

    public void crh() {
        this.juy--;
    }

    public WriteImagesInfo cri() {
        return this.juz;
    }

    public void rl(boolean z) {
        if (cqg()) {
            this.jsb.jup.setmDisallowSlip(true);
        } else {
            this.jsb.jup.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cqd() {
        crh();
        rl(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void P(int i, boolean z) {
        R(i, z);
    }

    private void R(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jsc == null) {
                this.jsc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jsc.gD(d.j.orginal_tip);
                this.jsc.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jsc != null) {
                            i.this.jsc.dismiss();
                        }
                        if (i.this.juv != null) {
                            i.this.juv.O(i, z);
                        }
                    }
                });
                this.jsc.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jsc != null) {
                            i.this.jsc.dismiss();
                        }
                    }
                });
                this.jsc.b(this.mPageContext);
            }
            this.jsc.aaZ();
        }
    }

    public boolean Q(final Bitmap bitmap) {
        if (!this.juv.cqa() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jsc == null) {
            this.jsc = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jsc.gD(d.j.orginal_tip);
            this.jsc.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jsc != null) {
                        i.this.jsc.dismiss();
                    }
                    i.this.jsb.P(bitmap);
                }
            });
            this.jsc.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jsc != null) {
                        i.this.jsc.dismiss();
                    }
                }
            });
            this.jsc.b(this.mPageContext);
        }
        this.jsc.aaZ();
        return true;
    }

    public void destroy() {
        if (this.jux != null) {
            this.jux.destroy();
        }
    }
}
