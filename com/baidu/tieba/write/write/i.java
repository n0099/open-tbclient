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
    private ForumWriteData jcM;
    private h jsd;
    private com.baidu.tbadk.core.dialog.a jse;
    private StickerModel juz;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter jux = null;
    private int juy = 0;
    private int juA = 0;
    private WriteImagesInfo juB = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> juC = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jsd = hVar;
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
            if (this.juz == null) {
                this.juz = new StickerModel(this.mPageContext);
            }
            this.juz.LoadData();
            this.juz.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void ep(List<String> list) {
        if (this.jsd != null) {
            this.jsd.eo(list);
        }
    }

    private void initListener() {
        if (this.jsd != null) {
            if (this.jsd.juq != null) {
                this.jsd.juq.x(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.jux.O(Integer.parseInt(view.getTag().toString()), i.this.cqr());
                        }
                    }
                });
            }
            if (this.jsd.jut != null) {
                this.jsd.jut.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.jux.rg(false);
                                if (i.this.jsd != null) {
                                    if (i.this.juB == null || i.this.juB.getChosedFiles() == null || i.this.juB.getChosedFiles().size() <= 0 || !i.this.juB.isOriginalImg() || i.this.juA <= 0 || !i.this.crr()) {
                                        i.this.jsd.b(true, i.this.juB);
                                    } else {
                                        i.this.jsd.cro();
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
            this.juy = bundle.getInt("OutState_Write_Entrance");
            this.jcM = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.juy = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jcM = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.juB = new WriteImagesInfo();
            this.juB.parseJson(str);
            crp();
            if (this.jsd != null && this.jsd.jur != null) {
                this.jux = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jsd.jur, this.juB.getChosedFiles(), i, this, this.jsd, this.juB.mIsFromIm);
                this.jsd.jur.setAdapter(this.jux);
                int cqk = this.jux.cqk();
                this.jsd.jur.setCurrentItem(cqk, true);
                if (cqk == 0) {
                    this.jux.onPageSelected(0);
                }
                this.jsd.d(this.juB);
            }
        }
    }

    private void crp() {
        if (this.juB != null && this.juB.isOriginalImg() && this.juB.getChosedFiles() != null && this.juB.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.juB.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.juC.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int crq() {
        return this.juy;
    }

    public ForumWriteData bcS() {
        return this.jcM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crr() {
        if (this.juB == null || !this.juB.isOriginalImg() || this.juB.getChosedFiles() == null || this.juB.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.juB.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.juC.get(next.getFilePath()))) {
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
        return (this.jsd == null || this.jsd.jus == null || v.T(this.jsd.jus.getStickerViews())) ? false : true;
    }

    public void crn() {
        this.juA++;
    }

    public void crs() {
        this.juA--;
    }

    public WriteImagesInfo crt() {
        return this.juB;
    }

    public void rl(boolean z) {
        if (cqr()) {
            this.jsd.jur.setmDisallowSlip(true);
        } else {
            this.jsd.jur.setmDisallowSlip(false);
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
            if (this.jse == null) {
                this.jse = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jse.gC(d.j.orginal_tip);
                this.jse.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jse != null) {
                            i.this.jse.dismiss();
                        }
                        if (i.this.jux != null) {
                            i.this.jux.O(i, z);
                        }
                    }
                });
                this.jse.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jse != null) {
                            i.this.jse.dismiss();
                        }
                    }
                });
                this.jse.b(this.mPageContext);
            }
            this.jse.aaW();
        }
    }

    public boolean Q(final Bitmap bitmap) {
        if (!this.jux.cql() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jse == null) {
            this.jse = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jse.gC(d.j.orginal_tip);
            this.jse.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jse != null) {
                        i.this.jse.dismiss();
                    }
                    i.this.jsd.P(bitmap);
                }
            });
            this.jse.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jse != null) {
                        i.this.jse.dismiss();
                    }
                }
            });
            this.jse.b(this.mPageContext);
        }
        this.jse.aaW();
        return true;
    }

    public void destroy() {
        if (this.juz != null) {
            this.juz.destroy();
        }
    }
}
