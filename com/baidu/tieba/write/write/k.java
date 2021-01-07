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
    private j odV;
    private com.baidu.tbadk.core.dialog.a odW;
    private StickerModel ohj;
    public MultiImagePagerAdapter ohh = null;
    private int ohi = 0;
    private int ohk = 0;
    private WriteImagesInfo ohl = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> ohm = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.odV = jVar;
        initData(bundle);
        initListener();
        dZB();
    }

    public void dZB() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.ohj == null) {
                this.ohj = new StickerModel(this.mPageContext);
            }
            this.ohj.LoadData();
            this.ohj.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void go(List<String> list) {
        if (this.odV != null) {
            this.odV.gn(list);
        }
    }

    private void initListener() {
        if (this.odV != null) {
            if (this.odV.oha != null) {
                this.odV.oha.H(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.ohh.aj(Integer.parseInt(view.getTag().toString()), k.this.dZD());
                        }
                    }
                });
            }
            if (this.odV.ohd != null) {
                this.odV.ohd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.ohh.zp(false);
                                if (k.this.odV != null) {
                                    if (k.this.ohl == null || k.this.ohl.getChosedFiles() == null || k.this.ohl.getChosedFiles().size() <= 0 || !k.this.ohl.isOriginalImg() || k.this.ohk <= 0 || !k.this.ebf()) {
                                        k.this.odV.a(true, k.this.ohl);
                                    } else {
                                        k.this.odV.ebc();
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
            this.ohi = bundle.getInt("OutState_Write_Entrance");
            this.jst = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.ohi = intent.getIntExtra("FourmWriteIndex", 0);
            this.jst = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.ohl = new WriteImagesInfo();
            this.ohl.parseJson(str);
            ebd();
            if (this.odV != null && this.odV.ohb != null) {
                this.ohh = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.odV.ohb, this.ohl.getChosedFiles(), i, this, this.odV, this.ohl.mIsFromIm);
                this.odV.ohb.setAdapter(this.ohh);
                int dZw = this.ohh.dZw();
                this.odV.ohb.setCurrentItem(dZw, true);
                if (dZw == 0) {
                    this.ohh.onPageSelected(0);
                }
                this.odV.c(this.ohl);
            }
        }
    }

    private void ebd() {
        if (this.ohl != null && this.ohl.isOriginalImg() && this.ohl.getChosedFiles() != null && this.ohl.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.ohl.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.ohm.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int ebe() {
        return this.ohi;
    }

    public ForumWriteData cFJ() {
        return this.jst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ebf() {
        if (this.ohl == null || !this.ohl.isOriginalImg() || this.ohl.getChosedFiles() == null || this.ohl.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.ohl.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.ohm.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dZC() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dZD() {
        return (this.odV == null || this.odV.ohc == null || x.isEmpty(this.odV.ohc.getStickerViews())) ? false : true;
    }

    public void ebb() {
        this.ohk++;
    }

    public void ebg() {
        this.ohk--;
    }

    public WriteImagesInfo ebh() {
        return this.ohl;
    }

    public void zv(boolean z) {
        if (dZD()) {
            this.odV.ohb.setmDisallowSlip(true);
        } else {
            this.odV.ohb.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dZA() {
        ebg();
        zv(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void ak(int i, boolean z) {
        al(i, z);
    }

    private void al(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.odW == null) {
                this.odW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.odW.pa(R.string.orginal_tip);
                this.odW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.odW != null) {
                            k.this.odW.dismiss();
                        }
                        if (k.this.ohh != null) {
                            k.this.ohh.aj(i, z);
                        }
                    }
                });
                this.odW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.odW != null) {
                            k.this.odW.dismiss();
                        }
                    }
                });
                this.odW.b(this.mPageContext);
            }
            this.odW.btY();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.ohh.dZx() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.odW == null) {
            this.odW = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.odW.pa(R.string.orginal_tip);
            this.odW.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.odW != null) {
                        k.this.odW.dismiss();
                    }
                    k.this.odV.V(bitmap);
                }
            });
            this.odW.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.odW != null) {
                        k.this.odW.dismiss();
                    }
                }
            });
            this.odW.b(this.mPageContext);
        }
        this.odW.btY();
        return true;
    }

    public void destroy() {
        if (this.ohj != null) {
            this.ohj.destroy();
        }
    }
}
