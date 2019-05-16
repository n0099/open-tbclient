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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.MultiImagePagerAdapter;
import com.baidu.tieba.write.write.model.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements MultiImagePagerAdapter.a, com.baidu.tieba.write.write.model.a {
    private h jLf;
    private com.baidu.tbadk.core.dialog.a jLg;
    private StickerModel jNB;
    private ForumWriteData jvG;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter jNz = null;
    private int jNA = 0;
    private int jNC = 0;
    private WriteImagesInfo jND = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> jNE = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jLf = hVar;
        initData(bundle);
        initListener();
        cyu();
    }

    public void cyu() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.jS()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.jNB == null) {
                this.jNB = new StickerModel(this.mPageContext);
            }
            this.jNB.LoadData();
            this.jNB.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void ez(List<String> list) {
        if (this.jLf != null) {
            this.jLf.ey(list);
        }
    }

    private void initListener() {
        if (this.jLf != null) {
            if (this.jLf.jNs != null) {
                this.jLf.jNs.z(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.jNz.T(Integer.parseInt(view.getTag().toString()), i.this.cyw());
                        }
                    }
                });
            }
            if (this.jLf.jNv != null) {
                this.jLf.jNv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (i.this.mPageContext != null) {
                            Activity pageActivity = i.this.mPageContext.getPageActivity();
                            if (i.this.mPermissionJudgement == null) {
                                i.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                            }
                            i.this.mPermissionJudgement.aiM();
                            i.this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (!i.this.mPermissionJudgement.aa(pageActivity)) {
                                i.this.jNz.rV(false);
                                if (i.this.jLf != null) {
                                    if (i.this.jND == null || i.this.jND.getChosedFiles() == null || i.this.jND.getChosedFiles().size() <= 0 || !i.this.jND.isOriginalImg() || i.this.jNC <= 0 || !i.this.czy()) {
                                        i.this.jLf.b(true, i.this.jND);
                                    } else {
                                        i.this.jLf.czv();
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
            this.jNA = bundle.getInt("OutState_Write_Entrance");
            this.jvG = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.jNA = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jvG = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.jND = new WriteImagesInfo();
            this.jND.parseJson(str);
            czw();
            if (this.jLf != null && this.jLf.jNt != null) {
                this.jNz = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jLf.jNt, this.jND.getChosedFiles(), i, this, this.jLf, this.jND.mIsFromIm);
                this.jLf.jNt.setAdapter(this.jNz);
                int cyp = this.jNz.cyp();
                this.jLf.jNt.setCurrentItem(cyp, true);
                if (cyp == 0) {
                    this.jNz.onPageSelected(0);
                }
                this.jLf.d(this.jND);
            }
        }
    }

    private void czw() {
        if (this.jND != null && this.jND.isOriginalImg() && this.jND.getChosedFiles() != null && this.jND.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.jND.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.jNE.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int czx() {
        return this.jNA;
    }

    public ForumWriteData bkm() {
        return this.jvG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czy() {
        if (this.jND == null || !this.jND.isOriginalImg() || this.jND.getChosedFiles() == null || this.jND.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.jND.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.jNE.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cyv() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cyw() {
        return (this.jLf == null || this.jLf.jNu == null || v.aa(this.jLf.jNu.getStickerViews())) ? false : true;
    }

    public void czu() {
        this.jNC++;
    }

    public void czz() {
        this.jNC--;
    }

    public WriteImagesInfo czA() {
        return this.jND;
    }

    public void sa(boolean z) {
        if (cyw()) {
            this.jLf.jNt.setmDisallowSlip(true);
        } else {
            this.jLf.jNt.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cyt() {
        czz();
        sa(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void U(int i, boolean z) {
        W(i, z);
    }

    private void W(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jLg == null) {
                this.jLg = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jLg.ho(R.string.orginal_tip);
                this.jLg.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jLg != null) {
                            i.this.jLg.dismiss();
                        }
                        if (i.this.jNz != null) {
                            i.this.jNz.T(i, z);
                        }
                    }
                });
                this.jLg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jLg != null) {
                            i.this.jLg.dismiss();
                        }
                    }
                });
                this.jLg.b(this.mPageContext);
            }
            this.jLg.afG();
        }
    }

    public boolean R(final Bitmap bitmap) {
        if (!this.jNz.cyq() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jLg == null) {
            this.jLg = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jLg.ho(R.string.orginal_tip);
            this.jLg.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jLg != null) {
                        i.this.jLg.dismiss();
                    }
                    i.this.jLf.Q(bitmap);
                }
            });
            this.jLg.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jLg != null) {
                        i.this.jLg.dismiss();
                    }
                }
            });
            this.jLg.b(this.mPageContext);
        }
        this.jLg.afG();
        return true;
    }

    public void destroy() {
        if (this.jNB != null) {
            this.jNB.destroy();
        }
    }
}
