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
    private ForumWriteData iUj;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j nLQ;
    private com.baidu.tbadk.core.dialog.a nLR;
    private StickerModel nOQ;
    public MultiImagePagerAdapter nOO = null;
    private int nOP = 0;
    private int nOR = 0;
    private WriteImagesInfo nOS = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> nOT = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.nLQ = jVar;
        initData(bundle);
        initListener();
        dUV();
    }

    public void dUV() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    com.baidu.adp.lib.util.l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.nOQ == null) {
                this.nOQ = new StickerModel(this.mPageContext);
            }
            this.nOQ.LoadData();
            this.nOQ.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void gh(List<String> list) {
        if (this.nLQ != null) {
            this.nLQ.gg(list);
        }
    }

    private void initListener() {
        if (this.nLQ != null) {
            if (this.nLQ.nOH != null) {
                this.nLQ.nOH.G(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.nOO.al(Integer.parseInt(view.getTag().toString()), k.this.dUX());
                        }
                    }
                });
            }
            if (this.nLQ.nOK != null) {
                this.nLQ.nOK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.nOO.yG(false);
                                if (k.this.nLQ != null) {
                                    if (k.this.nOS == null || k.this.nOS.getChosedFiles() == null || k.this.nOS.getChosedFiles().size() <= 0 || !k.this.nOS.isOriginalImg() || k.this.nOR <= 0 || !k.this.dWv()) {
                                        k.this.nLQ.b(true, k.this.nOS);
                                    } else {
                                        k.this.nLQ.dWs();
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
            this.nOP = bundle.getInt("OutState_Write_Entrance");
            this.iUj = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.nOP = intent.getIntExtra("FourmWriteIndex", 0);
            this.iUj = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.nOS = new WriteImagesInfo();
            this.nOS.parseJson(str);
            dWt();
            if (this.nLQ != null && this.nLQ.nOI != null) {
                this.nOO = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.nLQ.nOI, this.nOS.getChosedFiles(), i, this, this.nLQ, this.nOS.mIsFromIm);
                this.nLQ.nOI.setAdapter(this.nOO);
                int dUQ = this.nOO.dUQ();
                this.nLQ.nOI.setCurrentItem(dUQ, true);
                if (dUQ == 0) {
                    this.nOO.onPageSelected(0);
                }
                this.nLQ.c(this.nOS);
            }
        }
    }

    private void dWt() {
        if (this.nOS != null && this.nOS.isOriginalImg() && this.nOS.getChosedFiles() != null && this.nOS.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.nOS.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.nOT.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dWu() {
        return this.nOP;
    }

    public ForumWriteData cyT() {
        return this.iUj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWv() {
        if (this.nOS == null || !this.nOS.isOriginalImg() || this.nOS.getChosedFiles() == null || this.nOS.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.nOS.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.nOT.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dUW() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dUX() {
        return (this.nLQ == null || this.nLQ.nOJ == null || y.isEmpty(this.nLQ.nOJ.getStickerViews())) ? false : true;
    }

    public void dWr() {
        this.nOR++;
    }

    public void dWw() {
        this.nOR--;
    }

    public WriteImagesInfo dWx() {
        return this.nOS;
    }

    public void yM(boolean z) {
        if (dUX()) {
            this.nLQ.nOI.setmDisallowSlip(true);
        } else {
            this.nLQ.nOI.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dUU() {
        dWw();
        yM(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void am(int i, boolean z) {
        an(i, z);
    }

    private void an(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.nLR == null) {
                this.nLR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.nLR.ow(R.string.orginal_tip);
                this.nLR.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nLR != null) {
                            k.this.nLR.dismiss();
                        }
                        if (k.this.nOO != null) {
                            k.this.nOO.al(i, z);
                        }
                    }
                });
                this.nLR.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nLR != null) {
                            k.this.nLR.dismiss();
                        }
                    }
                });
                this.nLR.b(this.mPageContext);
            }
            this.nLR.bpc();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.nOO.dUR() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.nLR == null) {
            this.nLR = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.nLR.ow(R.string.orginal_tip);
            this.nLR.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nLR != null) {
                        k.this.nLR.dismiss();
                    }
                    k.this.nLQ.V(bitmap);
                }
            });
            this.nLR.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nLR != null) {
                        k.this.nLR.dismiss();
                    }
                }
            });
            this.nLR.b(this.mPageContext);
        }
        this.nLR.bpc();
        return true;
    }

    public void destroy() {
        if (this.nOQ != null) {
            this.nOQ.destroy();
        }
    }
}
