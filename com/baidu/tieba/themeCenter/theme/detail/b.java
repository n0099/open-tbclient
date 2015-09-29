package com.baidu.tieba.themeCenter.theme.detail;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.tieba.themeCenter.i;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ SkinDetailActivity dgs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SkinDetailActivity skinDetailActivity) {
        this.dgs = skinDetailActivity;
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
            bVar = this.dgs.mSkinData;
            if (bVar != null) {
                bVar2 = this.dgs.mSkinData;
                int azc = bVar2.azc();
                if (azc == 1 || azc == 5 || azc == 3) {
                    if (azc == 1) {
                        TiebaStatic.log("c10275");
                    } else if (azc == 5) {
                        TiebaStatic.log("c10354");
                    }
                    bVar3 = this.dgs.mSkinData;
                    if (!StringUtils.isNull(bVar3.ayY())) {
                        bVar4 = this.dgs.mSkinData;
                        if (i.lr(bVar4.azb())) {
                            fVar = this.dgs.dgn;
                            fVar.e(2, 0.0f);
                            bVar5 = this.dgs.mSkinData;
                            bVar5.lp(2);
                            com.baidu.tbadk.download.b An = com.baidu.tbadk.download.b.An();
                            StringBuilder sb = new StringBuilder();
                            bVar6 = this.dgs.mSkinData;
                            String sb2 = sb.append(bVar6.getId()).toString();
                            bVar7 = this.dgs.mSkinData;
                            String ayY = bVar7.ayY();
                            bVar8 = this.dgs.mSkinData;
                            String title = bVar8.getTitle();
                            bVar9 = this.dgs.mSkinData;
                            An.a(sb2, ayY, title, 0, bVar9.getId(), false, true, false);
                            return;
                        }
                        i.a(this.dgs.getPageContext(), 3, i.h.become_member_can_use);
                    }
                } else if (azc == 2) {
                    fVar3 = this.dgs.dgn;
                    fVar3.e(3, 0.0f);
                    bVar18 = this.dgs.mSkinData;
                    bVar18.lp(3);
                    com.baidu.tbadk.download.b An2 = com.baidu.tbadk.download.b.An();
                    bVar19 = this.dgs.mSkinData;
                    An2.eG(bVar19.ayY());
                    SkinDetailActivity skinDetailActivity = this.dgs;
                    bVar20 = this.dgs.mSkinData;
                    skinDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, bVar20));
                } else if (azc == 4) {
                    TiebaStatic.log("c10269");
                    bVar10 = this.dgs.mSkinData;
                    if (com.baidu.tieba.themeCenter.i.lr(bVar10.azb())) {
                        bVar11 = this.dgs.mSkinData;
                        if (bVar11.getId() != -1) {
                            bVar12 = this.dgs.mSkinData;
                            if (bVar12.getId() == -2) {
                                TbadkCoreApplication.m411getInst().setSkinType(1);
                            } else {
                                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                                bVar13 = this.dgs.mSkinData;
                                int id = bVar13.getId();
                                bVar14 = this.dgs.mSkinData;
                                m411getInst.setUsedTheme(id, bVar14.azb());
                                ap apVar = new ap("c10220");
                                bVar15 = this.dgs.mSkinData;
                                ap r = apVar.r("obj_id", bVar15.getId());
                                bVar16 = this.dgs.mSkinData;
                                TiebaStatic.log(r.r("obj_type", bVar16.azb()));
                            }
                        } else {
                            TbadkCoreApplication.m411getInst().setSkinType(0);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_THEME_LIST));
                        fVar2 = this.dgs.dgn;
                        fVar2.e(0, 0.0f);
                        bVar17 = this.dgs.mSkinData;
                        bVar17.lp(0);
                        return;
                    }
                    com.baidu.tieba.themeCenter.i.a(this.dgs.getPageContext(), 3, i.h.become_member_can_use);
                }
            }
        }
    }
}
