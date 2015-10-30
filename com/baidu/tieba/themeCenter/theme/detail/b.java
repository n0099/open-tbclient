package com.baidu.tieba.themeCenter.theme.detail;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.tieba.themeCenter.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ SkinDetailActivity dgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SkinDetailActivity skinDetailActivity) {
        this.dgS = skinDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.themeCenter.b bVar;
        com.baidu.tieba.themeCenter.b bVar2;
        com.baidu.tieba.themeCenter.b bVar3;
        com.baidu.tieba.themeCenter.b bVar4;
        f fVar;
        com.baidu.tieba.themeCenter.b bVar5;
        com.baidu.tieba.themeCenter.b bVar6;
        com.baidu.tieba.themeCenter.b bVar7;
        com.baidu.tieba.themeCenter.b bVar8;
        com.baidu.tieba.themeCenter.b bVar9;
        com.baidu.tieba.themeCenter.b bVar10;
        com.baidu.tieba.themeCenter.b bVar11;
        com.baidu.tieba.themeCenter.b bVar12;
        com.baidu.tieba.themeCenter.b bVar13;
        com.baidu.tieba.themeCenter.b bVar14;
        com.baidu.tieba.themeCenter.b bVar15;
        com.baidu.tieba.themeCenter.b bVar16;
        f fVar2;
        com.baidu.tieba.themeCenter.b bVar17;
        f fVar3;
        com.baidu.tieba.themeCenter.b bVar18;
        com.baidu.tieba.themeCenter.b bVar19;
        com.baidu.tieba.themeCenter.b bVar20;
        if (view instanceof SkinProgressView) {
            bVar = this.dgS.mSkinData;
            if (bVar != null) {
                bVar2 = this.dgS.mSkinData;
                int azi = bVar2.azi();
                if (azi == 1 || azi == 5 || azi == 3) {
                    if (azi == 1) {
                        TiebaStatic.log("c10275");
                    } else if (azi == 5) {
                        TiebaStatic.log("c10354");
                    }
                    bVar3 = this.dgS.mSkinData;
                    if (!StringUtils.isNull(bVar3.aze())) {
                        bVar4 = this.dgS.mSkinData;
                        if (i.lt(bVar4.azh())) {
                            fVar = this.dgS.dgN;
                            fVar.e(2, 0.0f);
                            bVar5 = this.dgS.mSkinData;
                            bVar5.lr(2);
                            com.baidu.tbadk.download.b Ak = com.baidu.tbadk.download.b.Ak();
                            StringBuilder sb = new StringBuilder();
                            bVar6 = this.dgS.mSkinData;
                            String sb2 = sb.append(bVar6.getId()).toString();
                            bVar7 = this.dgS.mSkinData;
                            String aze = bVar7.aze();
                            bVar8 = this.dgS.mSkinData;
                            String title = bVar8.getTitle();
                            bVar9 = this.dgS.mSkinData;
                            Ak.a(sb2, aze, title, 0, bVar9.getId(), false, true, false);
                            return;
                        }
                        i.a(this.dgS.getPageContext(), 3, i.h.become_member_can_use);
                    }
                } else if (azi == 2) {
                    fVar3 = this.dgS.dgN;
                    fVar3.e(3, 0.0f);
                    bVar18 = this.dgS.mSkinData;
                    bVar18.lr(3);
                    com.baidu.tbadk.download.b Ak2 = com.baidu.tbadk.download.b.Ak();
                    bVar19 = this.dgS.mSkinData;
                    Ak2.eG(bVar19.aze());
                    SkinDetailActivity skinDetailActivity = this.dgS;
                    bVar20 = this.dgS.mSkinData;
                    skinDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, bVar20));
                } else if (azi == 4) {
                    TiebaStatic.log("c10269");
                    bVar10 = this.dgS.mSkinData;
                    if (com.baidu.tieba.themeCenter.i.lt(bVar10.azh())) {
                        bVar11 = this.dgS.mSkinData;
                        if (bVar11.getId() != -1) {
                            bVar12 = this.dgS.mSkinData;
                            if (bVar12.getId() == -2) {
                                TbadkCoreApplication.m411getInst().setSkinType(1);
                            } else {
                                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                                bVar13 = this.dgS.mSkinData;
                                int id = bVar13.getId();
                                bVar14 = this.dgS.mSkinData;
                                m411getInst.setUsedTheme(id, bVar14.azh());
                                aq aqVar = new aq("c10220");
                                bVar15 = this.dgS.mSkinData;
                                aq r = aqVar.r("obj_id", bVar15.getId());
                                bVar16 = this.dgS.mSkinData;
                                TiebaStatic.log(r.r("obj_type", bVar16.azh()));
                            }
                        } else {
                            TbadkCoreApplication.m411getInst().setSkinType(0);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_THEME_LIST));
                        fVar2 = this.dgS.dgN;
                        fVar2.e(0, 0.0f);
                        bVar17 = this.dgS.mSkinData;
                        bVar17.lr(0);
                        return;
                    }
                    com.baidu.tieba.themeCenter.i.a(this.dgS.getPageContext(), 3, i.h.become_member_can_use);
                }
            }
        }
    }
}
