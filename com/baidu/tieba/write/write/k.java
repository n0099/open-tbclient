package com.baidu.tieba.write.write;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class k implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private ForumWriteData iUV;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j nNr;
    private com.baidu.tbadk.core.dialog.a nNs;
    private StickerModel nQt;
    public MultiImagePagerAdapter nQr = null;
    private int nQs = 0;
    private int nQu = 0;
    private WriteImagesInfo nQv = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> nQw = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.nNr = jVar;
        initData(bundle);
        initListener();
        dUU();
    }

    public void dUU() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    com.baidu.adp.lib.util.l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.nQt == null) {
                this.nQt = new StickerModel(this.mPageContext);
            }
            this.nQt.LoadData();
            this.nQt.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void gh(List<String> list) {
        if (this.nNr != null) {
            this.nNr.gg(list);
        }
    }

    private void initListener() {
        if (this.nNr != null) {
            if (this.nNr.nQk != null) {
                this.nNr.nQk.F(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.nQr.al(Integer.parseInt(view.getTag().toString()), k.this.dUW());
                        }
                    }
                });
            }
            if (this.nNr.nQn != null) {
                this.nNr.nQn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.nQr.yN(false);
                                if (k.this.nNr != null) {
                                    if (k.this.nQv == null || k.this.nQv.getChosedFiles() == null || k.this.nQv.getChosedFiles().size() <= 0 || !k.this.nQv.isOriginalImg() || k.this.nQu <= 0 || !k.this.dWu()) {
                                        k.this.nNr.b(true, k.this.nQv);
                                    } else {
                                        k.this.nNr.dWr();
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
            this.nQs = bundle.getInt("OutState_Write_Entrance");
            this.iUV = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.nQs = intent.getIntExtra("FourmWriteIndex", 0);
            this.iUV = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.nQv = new WriteImagesInfo();
            this.nQv.parseJson(str);
            dWs();
            if (this.nNr != null && this.nNr.nQl != null) {
                this.nQr = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.nNr.nQl, this.nQv.getChosedFiles(), i, this, this.nNr, this.nQv.mIsFromIm);
                this.nNr.nQl.setAdapter(this.nQr);
                int dUP = this.nQr.dUP();
                this.nNr.nQl.setCurrentItem(dUP, true);
                if (dUP == 0) {
                    this.nQr.onPageSelected(0);
                }
                this.nNr.c(this.nQv);
            }
        }
    }

    private void dWs() {
        if (this.nQv != null && this.nQv.isOriginalImg() && this.nQv.getChosedFiles() != null && this.nQv.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.nQv.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.nQw.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dWt() {
        return this.nQs;
    }

    public ForumWriteData cyw() {
        return this.iUV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWu() {
        if (this.nQv == null || !this.nQv.isOriginalImg() || this.nQv.getChosedFiles() == null || this.nQv.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.nQv.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.nQw.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dUV() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dUW() {
        return (this.nNr == null || this.nNr.nQm == null || y.isEmpty(this.nNr.nQm.getStickerViews())) ? false : true;
    }

    public void dWq() {
        this.nQu++;
    }

    public void dWv() {
        this.nQu--;
    }

    public WriteImagesInfo dWw() {
        return this.nQv;
    }

    public void yT(boolean z) {
        if (dUW()) {
            this.nNr.nQl.setmDisallowSlip(true);
        } else {
            this.nNr.nQl.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dUT() {
        dWv();
        yT(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void am(int i, boolean z) {
        an(i, z);
    }

    private void an(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.nNs == null) {
                this.nNs = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.nNs.os(R.string.orginal_tip);
                this.nNs.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nNs != null) {
                            k.this.nNs.dismiss();
                        }
                        if (k.this.nQr != null) {
                            k.this.nQr.al(i, z);
                        }
                    }
                });
                this.nNs.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nNs != null) {
                            k.this.nNs.dismiss();
                        }
                    }
                });
                this.nNs.b(this.mPageContext);
            }
            this.nNs.bog();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.nQr.dUQ() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.nNs == null) {
            this.nNs = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.nNs.os(R.string.orginal_tip);
            this.nNs.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nNs != null) {
                        k.this.nNs.dismiss();
                    }
                    k.this.nNr.V(bitmap);
                }
            });
            this.nNs.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nNs != null) {
                        k.this.nNs.dismiss();
                    }
                }
            });
            this.nNs.b(this.mPageContext);
        }
        this.nNs.bog();
        return true;
    }

    public void destroy() {
        if (this.nQt != null) {
            this.nQt.destroy();
        }
    }
}
