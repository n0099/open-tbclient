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
    private ForumWriteData iBQ;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private j ntx;
    private com.baidu.tbadk.core.dialog.a nty;
    private StickerModel nwy;
    public MultiImagePagerAdapter nww = null;
    private int nwx = 0;
    private int nwz = 0;
    private WriteImagesInfo nwA = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> nwB = new HashMap<>();

    public k(TbPageContext<WriteMultiImgsActivity> tbPageContext, j jVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ntx = jVar;
        initData(bundle);
        initListener();
        dPn();
    }

    public void dPn() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (this.mPageContext.getContext() != null) {
                    com.baidu.adp.lib.util.l.showToast(this.mPageContext.getContext(), R.string.neterror);
                    return;
                }
                return;
            }
            if (this.nwy == null) {
                this.nwy = new StickerModel(this.mPageContext);
            }
            this.nwy.LoadData();
            this.nwy.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void fR(List<String> list) {
        if (this.ntx != null) {
            this.ntx.fQ(list);
        }
    }

    private void initListener() {
        if (this.ntx != null) {
            if (this.ntx.nwp != null) {
                this.ntx.nwp.F(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            k.this.nww.al(Integer.parseInt(view.getTag().toString()), k.this.dPp());
                        }
                    }
                });
            }
            if (this.ntx.nws != null) {
                this.ntx.nws.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.k.2
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
                                k.this.nww.yg(false);
                                if (k.this.ntx != null) {
                                    if (k.this.nwA == null || k.this.nwA.getChosedFiles() == null || k.this.nwA.getChosedFiles().size() <= 0 || !k.this.nwA.isOriginalImg() || k.this.nwz <= 0 || !k.this.dQN()) {
                                        k.this.ntx.b(true, k.this.nwA);
                                    } else {
                                        k.this.ntx.dQK();
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
            this.nwx = bundle.getInt("OutState_Write_Entrance");
            this.iBQ = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra("WriteImgsInfoJsonStr");
            i = intent.getIntExtra("CurrentImgIndex", 0);
            this.nwx = intent.getIntExtra("FourmWriteIndex", 0);
            this.iBQ = (ForumWriteData) intent.getSerializableExtra("FourmWriteData");
            this.mSkinType = intent.getIntExtra("skinType", TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.nwA = new WriteImagesInfo();
            this.nwA.parseJson(str);
            dQL();
            if (this.ntx != null && this.ntx.nwq != null) {
                this.nww = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.ntx.nwq, this.nwA.getChosedFiles(), i, this, this.ntx, this.nwA.mIsFromIm);
                this.ntx.nwq.setAdapter(this.nww);
                int dPi = this.nww.dPi();
                this.ntx.nwq.setCurrentItem(dPi, true);
                if (dPi == 0) {
                    this.nww.onPageSelected(0);
                }
                this.ntx.c(this.nwA);
            }
        }
    }

    private void dQL() {
        if (this.nwA != null && this.nwA.isOriginalImg() && this.nwA.getChosedFiles() != null && this.nwA.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.nwA.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.nwB.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int dQM() {
        return this.nwx;
    }

    public ForumWriteData ctl() {
        return this.iBQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dQN() {
        if (this.nwA == null || !this.nwA.isOriginalImg() || this.nwA.getChosedFiles() == null || this.nwA.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.nwA.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.nwB.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dPo() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean dPp() {
        return (this.ntx == null || this.ntx.nwr == null || y.isEmpty(this.ntx.nwr.getStickerViews())) ? false : true;
    }

    public void dQJ() {
        this.nwz++;
    }

    public void dQO() {
        this.nwz--;
    }

    public WriteImagesInfo dQP() {
        return this.nwA;
    }

    public void ym(boolean z) {
        if (dPp()) {
            this.ntx.nwq.setmDisallowSlip(true);
        } else {
            this.ntx.nwq.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void dPm() {
        dQO();
        ym(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void am(int i, boolean z) {
        an(i, z);
    }

    private void an(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.nty == null) {
                this.nty = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.nty.ob(R.string.orginal_tip);
                this.nty.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nty != null) {
                            k.this.nty.dismiss();
                        }
                        if (k.this.nww != null) {
                            k.this.nww.al(i, z);
                        }
                    }
                });
                this.nty.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (k.this.nty != null) {
                            k.this.nty.dismiss();
                        }
                    }
                });
                this.nty.b(this.mPageContext);
            }
            this.nty.bkJ();
        }
    }

    public boolean W(final Bitmap bitmap) {
        if (!this.nww.dPj() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.nty == null) {
            this.nty = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.nty.ob(R.string.orginal_tip);
            this.nty.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.k.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nty != null) {
                        k.this.nty.dismiss();
                    }
                    k.this.ntx.V(bitmap);
                }
            });
            this.nty.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.k.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (k.this.nty != null) {
                        k.this.nty.dismiss();
                    }
                }
            });
            this.nty.b(this.mPageContext);
        }
        this.nty.bkJ();
        return true;
    }

    public void destroy() {
        if (this.nwy != null) {
            this.nwy.destroy();
        }
    }
}
