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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData lHN;
    private h lXc;
    private com.baidu.tbadk.core.dialog.a lXd;
    private StickerModel lZy;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    public MultiImagePagerAdapter lZw = null;
    private int lZx = 0;
    private int lZz = 0;
    private WriteImagesInfo lZA = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> lZB = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.lXc = hVar;
        initData(bundle);
        initListener();
        doa();
    }

    public void doa() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.lZy == null) {
                this.lZy = new StickerModel(this.mPageContext);
            }
            this.lZy.LoadData();
            this.lZy.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void eX(List<String> list) {
        if (this.lXc != null) {
            this.lXc.eW(list);
        }
    }

    private void initListener() {
        if (this.lXc != null) {
            if (this.lXc.lZp != null) {
                this.lXc.lZp.D(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.lZw.ae(Integer.parseInt(view.getTag().toString()), i.this.doc());
                        }
                    }
                });
            }
            if (this.lXc.lZs != null) {
                this.lXc.lZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new PermissionJudgePolicy();
                            }
                            i.this.mPermissionJudgement.clearRequestPermissionList();
                            i.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                i.this.lZw.vy(false);
                                if (i.this.lXc != null) {
                                    if (i.this.lZA == null || i.this.lZA.getChosedFiles() == null || i.this.lZA.getChosedFiles().size() <= 0 || !i.this.lZA.isOriginalImg() || i.this.lZz <= 0 || !i.this.dpg()) {
                                        i.this.lXc.b(true, i.this.lZA);
                                    } else {
                                        i.this.lXc.dpd();
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
            this.lZx = bundle.getInt("OutState_Write_Entrance");
            this.lHN = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.lZx = intent.getIntExtra("FourmWriteIndex", 0);
            this.lHN = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.lZA = new WriteImagesInfo();
            this.lZA.parseJson(str);
            dpe();
            if (this.lXc != null && this.lXc.lZq != null) {
                this.lZw = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.lXc.lZq, this.lZA.getChosedFiles(), i, this, this.lXc, this.lZA.mIsFromIm);
                this.lXc.lZq.setAdapter(this.lZw);
                int dnV = this.lZw.dnV();
                this.lXc.lZq.setCurrentItem(dnV, true);
                if (dnV == 0) {
                    this.lZw.onPageSelected(0);
                }
                this.lXc.c(this.lZA);
            }
        }
    }

    private void dpe() {
        if (this.lZA != null && this.lZA.isOriginalImg() && this.lZA.getChosedFiles() != null && this.lZA.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.lZA.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.lZB.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dpf() {
        return this.lZx;
    }

    public ForumWriteData bVw() {
        return this.lHN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dpg() {
        if (this.lZA == null || !this.lZA.isOriginalImg() || this.lZA.getChosedFiles() == null || this.lZA.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.lZA.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.lZB.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dob() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean doc() {
        return (this.lXc == null || this.lXc.lZr == null || v.isEmpty(this.lXc.lZr.getStickerViews())) ? false : true;
    }

    public void dpc() {
        this.lZz++;
    }

    public void dph() {
        this.lZz--;
    }

    public WriteImagesInfo dpi() {
        return this.lZA;
    }

    public void vD(boolean z) {
        if (doc()) {
            this.lXc.lZq.setmDisallowSlip(true);
        } else {
            this.lXc.lZq.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dnZ() {
        dph();
        vD(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void af(int i, boolean z) {
        ah(i, z);
    }

    private void ah(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.lXd == null) {
                this.lXd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.lXd.kD(R.string.orginal_tip);
                this.lXd.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.lXd != null) {
                            i.this.lXd.dismiss();
                        }
                        if (i.this.lZw != null) {
                            i.this.lZw.ae(i, z);
                        }
                    }
                });
                this.lXd.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.lXd != null) {
                            i.this.lXd.dismiss();
                        }
                    }
                });
                this.lXd.b(this.mPageContext);
            }
            this.lXd.aST();
        }
    }

    public boolean U(final Bitmap bitmap) {
        if (!this.lZw.dnW() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.lXd == null) {
            this.lXd = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.lXd.kD(R.string.orginal_tip);
            this.lXd.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.lXd != null) {
                        i.this.lXd.dismiss();
                    }
                    i.this.lXc.T(bitmap);
                }
            });
            this.lXd.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.lXd != null) {
                        i.this.lXd.dismiss();
                    }
                }
            });
            this.lXd.b(this.mPageContext);
        }
        this.lXd.aST();
        return true;
    }

    public void destroy() {
        if (this.lZy != null) {
            this.lZy.destroy();
        }
    }
}
