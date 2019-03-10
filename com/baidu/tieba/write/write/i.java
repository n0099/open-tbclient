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
    private ForumWriteData jdf;
    private h jsu;
    private com.baidu.tbadk.core.dialog.a jsv;
    private StickerModel juQ;
    private TbPageContext<WriteMultiImgsActivity> mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public MultiImagePagerAdapter juO = null;
    private int juP = 0;
    private int juR = 0;
    private WriteImagesInfo juS = null;
    public int mSkinType = TbadkCoreApplication.getInst().getSkinType();
    private HashMap<String, String> juT = new HashMap<>();

    public i(TbPageContext<WriteMultiImgsActivity> tbPageContext, h hVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.jsu = hVar;
        initData(bundle);
        initListener();
        cqo();
    }

    public void cqo() {
        if (this.mPageContext != null) {
            if (!com.baidu.adp.lib.util.j.kY()) {
                if (this.mPageContext.getContext() != null) {
                    l.showToast(this.mPageContext.getContext(), d.j.neterror);
                    return;
                }
                return;
            }
            if (this.juQ == null) {
                this.juQ = new StickerModel(this.mPageContext);
            }
            this.juQ.LoadData();
            this.juQ.a(this);
        }
    }

    @Override // com.baidu.tieba.write.write.model.a
    public void es(List<String> list) {
        if (this.jsu != null) {
            this.jsu.er(list);
        }
    }

    private void initListener() {
        if (this.jsu != null) {
            if (this.jsu.juH != null) {
                this.jsu.juH.x(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getTag() != null) {
                            i.this.juO.O(Integer.parseInt(view.getTag().toString()), i.this.cqq());
                        }
                    }
                });
            }
            if (this.jsu.juK != null) {
                this.jsu.juK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.i.2
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
                                i.this.juO.rg(false);
                                if (i.this.jsu != null) {
                                    if (i.this.juS == null || i.this.juS.getChosedFiles() == null || i.this.juS.getChosedFiles().size() <= 0 || !i.this.juS.isOriginalImg() || i.this.juR <= 0 || !i.this.crq()) {
                                        i.this.jsu.b(true, i.this.juS);
                                    } else {
                                        i.this.jsu.crn();
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
            this.juP = bundle.getInt("OutState_Write_Entrance");
            this.jdf = (ForumWriteData) bundle.getSerializable("OutState_Write_Info_Data");
            this.mSkinType = bundle.getInt(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = string;
        } else if (this.mPageContext == null || this.mPageContext.getPageActivity() == null || (intent = this.mPageContext.getPageActivity().getIntent()) == null) {
            i = -1;
        } else {
            String stringExtra = intent.getStringExtra(WriteMulitImageActivityConfig.EXTRA_WRITE_IMG_INFO_JSON_STR);
            i = intent.getIntExtra(WriteMulitImageActivityConfig.EXTRA_IMG_CURRENT_INDEX, 0);
            this.juP = intent.getIntExtra(WriteMulitImageActivityConfig.FOURM_WRITE_ENTRANCE, 0);
            this.jdf = (ForumWriteData) intent.getSerializableExtra(WriteMulitImageActivityConfig.FOURM_WRITE_DATA);
            this.mSkinType = intent.getIntExtra(WriteMulitImageActivityConfig.SKIN_TYPE, TbadkCoreApplication.getInst().getSkinType());
            str = stringExtra;
        }
        if (str != null && i != -1) {
            this.juS = new WriteImagesInfo();
            this.juS.parseJson(str);
            cro();
            if (this.jsu != null && this.jsu.juI != null) {
                this.juO = new MultiImagePagerAdapter(this.mPageContext.getOrignalPage(), this.jsu.juI, this.juS.getChosedFiles(), i, this, this.jsu, this.juS.mIsFromIm);
                this.jsu.juI.setAdapter(this.juO);
                int cqj = this.juO.cqj();
                this.jsu.juI.setCurrentItem(cqj, true);
                if (cqj == 0) {
                    this.juO.onPageSelected(0);
                }
                this.jsu.d(this.juS);
            }
        }
    }

    private void cro() {
        if (this.juS != null && this.juS.isOriginalImg() && this.juS.getChosedFiles() != null && this.juS.getChosedFiles().size() != 0) {
            Iterator<ImageFileInfo> it = this.juS.getChosedFiles().iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.hasActionsWithoutResize()) {
                    this.juT.put(next.getFilePath(), "1");
                }
            }
        }
    }

    public int crp() {
        return this.juP;
    }

    public ForumWriteData bcV() {
        return this.jdf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean crq() {
        if (this.juS == null || !this.juS.isOriginalImg() || this.juS.getChosedFiles() == null || this.juS.getChosedFiles().size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.juS.getChosedFiles().iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.hasActionsWithoutResize() && StringUtils.isNull(this.juT.get(next.getFilePath()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cqp() {
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public boolean cqq() {
        return (this.jsu == null || this.jsu.juJ == null || v.T(this.jsu.juJ.getStickerViews())) ? false : true;
    }

    public void crm() {
        this.juR++;
    }

    public void crr() {
        this.juR--;
    }

    public WriteImagesInfo crs() {
        return this.juS;
    }

    public void rl(boolean z) {
        if (cqq()) {
            this.jsu.juI.setmDisallowSlip(true);
        } else {
            this.jsu.juI.setmDisallowSlip(false);
        }
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void cqn() {
        crr();
        rl(false);
    }

    @Override // com.baidu.tieba.write.write.MultiImagePagerAdapter.a
    public void P(int i, boolean z) {
        R(i, z);
    }

    private void R(final int i, final boolean z) {
        if (this.mPageContext != null && this.mPageContext.getPageActivity() != null) {
            if (this.jsv == null) {
                this.jsv = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                this.jsv.gD(d.j.orginal_tip);
                this.jsv.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jsv != null) {
                            i.this.jsv.dismiss();
                        }
                        if (i.this.juO != null) {
                            i.this.juO.O(i, z);
                        }
                    }
                });
                this.jsv.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        if (i.this.jsv != null) {
                            i.this.jsv.dismiss();
                        }
                    }
                });
                this.jsv.b(this.mPageContext);
            }
            this.jsv.aaZ();
        }
    }

    public boolean Q(final Bitmap bitmap) {
        if (!this.juO.cqk() || this.mPageContext == null || this.mPageContext.getPageActivity() == null) {
            return false;
        }
        if (this.jsv == null) {
            this.jsv = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.jsv.gD(d.j.orginal_tip);
            this.jsv.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.write.i.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jsv != null) {
                        i.this.jsv.dismiss();
                    }
                    i.this.jsu.P(bitmap);
                }
            });
            this.jsv.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.write.i.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (i.this.jsv != null) {
                        i.this.jsv.dismiss();
                    }
                }
            });
            this.jsv.b(this.mPageContext);
        }
        this.jsv.aaZ();
        return true;
    }

    public void destroy() {
        if (this.juQ != null) {
            this.juQ.destroy();
        }
    }
}
