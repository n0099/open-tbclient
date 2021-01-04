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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class k implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData jst;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j odW;
    private com.baidu.tbadk.core.dialog.a odX;
    private StickerModel ohk;
    public MultiImagePagerAdapter ohi = null;
    private int ohj = 0;
    private int ohl = 0;
    private WriteImagesInfo ohm = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> ohn = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.odW = jVar;
        initData(bundle);
        initListener();
        dZA();
    }

    public void dZA() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.ohk == null) {
                this.ohk = new StickerModel(this.mPageContext);
            }
            this.ohk.LoadData();
            this.ohk.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void go(List<String> list) {
        if (this.odW != null) {
            this.odW.gn(list);
        }
    }

    private void initListener() {
        if (this.odW != null) {
            if (this.odW.ohb != null) {
                this.odW.ohb.H(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.ohi.aj(Integer.parseInt(view.getTag().toString()), k.this.dZC());
                        }
                    }
                });
            }
            if (this.odW.ohe != null) {
                this.odW.ohe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (k.this.mPageContext != null) {
                            Activity pageActivity = k.this.mPageContext.getPageActivity();
                            if (k.this.mPermissionJudgement == null) {
                                k.this.mPermissionJudgement = new PermissionJudgePolicy();
                            }
                            k.this.mPermissionJudgement.clearRequestPermissionList();
                            k.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!k.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                                k.this.ohi.zp(false);
                                if (k.this.odW != null) {
                                    if (k.this.ohm == null || k.this.ohm.getChosedFiles() == null || k.this.ohm.getChosedFiles().size() <= 0 || !k.this.ohm.isOriginalImg() || k.this.ohl <= 0 || !k.this.ebe()) {
                                        k.this.odW.a(true, k.this.ohm);
                                    } else {
                                        k.this.odW.ebb();
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
            this.ohj = bundle.getInt("OutState_Write_Entrance");
            this.jst = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.ohj = intent.getIntExtra("FourmWriteIndex", 0);
            this.jst = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.ohm = new WriteImagesInfo();
            this.ohm.parseJson(str);
            ebc();
            if (this.odW != null && this.odW.ohc != null) {
                this.ohi = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.odW.ohc, this.ohm.getChosedFiles(), i, this, this.odW, this.ohm.mIsFromIm);
                this.odW.ohc.setAdapter(this.ohi);
                int dZv = this.ohi.dZv();
                this.odW.ohc.setCurrentItem(dZv, true);
                if (dZv == 0) {
                    this.ohi.onPageSelected(0);
                }
                this.odW.c(this.ohm);
            }
        }
    }

    private void ebc() {
        if (this.ohm != null && this.ohm.isOriginalImg() && this.ohm.getChosedFiles() != null && this.ohm.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.ohm.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.ohn.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int ebd() {
        return this.ohj;
    }

    public ForumWriteData cFI() {
        return this.jst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ebe() {
        if (this.ohm == null || !this.ohm.isOriginalImg() || this.ohm.getChosedFiles() == null || this.ohm.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.ohm.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.ohn.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dZB() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dZC() {
        return (this.odW == null || this.odW.ohd == null || x.isEmpty(this.odW.ohd.getStickerViews())) ? false : true;
    }

    public void eba() {
        this.ohl++;
    }

    public void ebf() {
        this.ohl--;
    }

    public WriteImagesInfo ebg() {
        return this.ohm;
    }

    public void zv(boolean z) {
        if (dZC()) {
            this.odW.ohc.setmDisallowSlip(true);
        } else {
            this.odW.ohc.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dZz() {
        ebf();
        zv(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ak(int i, boolean z) {
        al(i, z);
    }

    private void al(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.odX == null) {
                this.odX = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.odX.pa(R.string.orginal_tip);
                this.odX.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.odX != null) {
                            k.this.odX.dismiss();
                        }
                        if (k.this.ohi != null) {
                            k.this.ohi.aj(i, z);
                        }
                    }
                });
                this.odX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.odX != null) {
                            k.this.odX.dismiss();
                        }
                    }
                });
                this.odX.b(this.mPageContext);
            }
            this.odX.btX();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.ohi.dZw() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.odX == null) {
            this.odX = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.odX.pa(R.string.orginal_tip);
            this.odX.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.odX != null) {
                        k.this.odX.dismiss();
                    }
                    k.this.odW.V(bitmap);
                }
            });
            this.odX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.odX != null) {
                        k.this.odX.dismiss();
                    }
                }
            });
            this.odX.b(this.mPageContext);
        }
        this.odX.btX();
        return true;
    }

    public void destroy() {
        if (this.ohk != null) {
            this.ohk.destroy();
        }
    }
}
