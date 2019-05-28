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
    private h jLg;
    private com.baidu.tbadk.core.dialog.a jLh;
    private StickerModel jNC;
    private ForumWriteData jvH;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter jNA = null;
    private int jNB = 0;
    private int jND = 0;
    private WriteImagesInfo jNE = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> jNF = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jLg = hVar;
        initData(bundle);
        initListener();
        cyw();
    }

    public void cyw() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.jS()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), (int) R.string.neterror);
                    return;
                }
                return;
            }
            if (this.jNC == null) {
                this.jNC = new StickerModel(this.mPageContext);
            }
            this.jNC.LoadData();
            this.jNC.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void ez(List<String> list) {
        if (this.jLg != null) {
            this.jLg.ey(list);
        }
    }

    private void initListener() {
        if (this.jLg != null) {
            if (this.jLg.jNt != null) {
                this.jLg.jNt.z(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.jNA.T(Integer.parseInt(view.getTag().toString()), i.this.cyy());
                        }
                    }
                });
            }
            if (this.jLg.jNw != null) {
                this.jLg.jNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.jNA.rV(false);
                                if (i.this.jLg != null) {
                                    if (i.this.jNE == null || i.this.jNE.getChosedFiles() == null || i.this.jNE.getChosedFiles().size() <= 0 || !i.this.jNE.isOriginalImg() || i.this.jND <= 0 || !i.this.czA()) {
                                        i.this.jLg.b(true, i.this.jNE);
                                    } else {
                                        i.this.jLg.czx();
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
            this.jNB = bundle.getInt("OutState_Write_Entrance");
            this.jvH = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.jNB = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jvH = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.jNE = new WriteImagesInfo();
            this.jNE.parseJson(str);
            czy();
            if (this.jLg != null && this.jLg.jNu != null) {
                this.jNA = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jLg.jNu, this.jNE.getChosedFiles(), i, this, this.jLg, this.jNE.mIsFromIm);
                this.jLg.jNu.setAdapter(this.jNA);
                int cyr = this.jNA.cyr();
                this.jLg.jNu.setCurrentItem(cyr, true);
                if (cyr == 0) {
                    this.jNA.onPageSelected(0);
                }
                this.jLg.d(this.jNE);
            }
        }
    }

    private void czy() {
        if (this.jNE != null && this.jNE.isOriginalImg() && this.jNE.getChosedFiles() != null && this.jNE.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.jNE.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.jNF.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int czz() {
        return this.jNB;
    }

    public ForumWriteData bkp() {
        return this.jvH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean czA() {
        if (this.jNE == null || !this.jNE.isOriginalImg() || this.jNE.getChosedFiles() == null || this.jNE.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.jNE.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.jNF.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cyx() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cyy() {
        return (this.jLg == null || this.jLg.jNv == null || v.aa(this.jLg.jNv.getStickerViews())) ? false : true;
    }

    public void czw() {
        this.jND++;
    }

    public void czB() {
        this.jND--;
    }

    public WriteImagesInfo czC() {
        return this.jNE;
    }

    public void sa(boolean z) {
        if (cyy()) {
            this.jLg.jNu.setmDisallowSlip(true);
        } else {
            this.jLg.jNu.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cyv() {
        czB();
        sa(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void U(int i, boolean z) {
        W(i, z);
    }

    private void W(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jLh == null) {
                this.jLh = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jLh.ho(R.string.orginal_tip);
                this.jLh.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jLh != null) {
                            i.this.jLh.dismiss();
                        }
                        if (i.this.jNA != null) {
                            i.this.jNA.T(i, z);
                        }
                    }
                });
                this.jLh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jLh != null) {
                            i.this.jLh.dismiss();
                        }
                    }
                });
                this.jLh.b(this.mPageContext);
            }
            this.jLh.afG();
        }
    }

    public boolean R(final Bitmap bitmap) {
        if (!this.jNA.cys() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jLh == null) {
            this.jLh = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jLh.ho(R.string.orginal_tip);
            this.jLh.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jLh != null) {
                        i.this.jLh.dismiss();
                    }
                    i.this.jLg.Q(bitmap);
                }
            });
            this.jLh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jLh != null) {
                        i.this.jLh.dismiss();
                    }
                }
            });
            this.jLh.b(this.mPageContext);
        }
        this.jLh.afG();
        return true;
    }

    public void destroy() {
        if (this.jNC != null) {
            this.jNC.destroy();
        }
    }
}
