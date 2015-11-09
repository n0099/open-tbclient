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
    final /* synthetic */ SkinDetailActivity diy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SkinDetailActivity skinDetailActivity) {
        this.diy = skinDetailActivity;
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
            bVar = this.diy.mSkinData;
            if (bVar != null) {
                bVar2 = this.diy.mSkinData;
                int azY = bVar2.azY();
                if (azY == 1 || azY == 5 || azY == 3) {
                    if (azY == 1) {
                        TiebaStatic.log("c10275");
                    } else if (azY == 5) {
                        TiebaStatic.log("c10354");
                    }
                    bVar3 = this.diy.mSkinData;
                    if (!StringUtils.isNull(bVar3.azU())) {
                        bVar4 = this.diy.mSkinData;
                        if (i.lH(bVar4.azX())) {
                            fVar = this.diy.dit;
                            fVar.e(2, 0.0f);
                            bVar5 = this.diy.mSkinData;
                            bVar5.lF(2);
                            com.baidu.tbadk.download.b Ap = com.baidu.tbadk.download.b.Ap();
                            StringBuilder sb = new StringBuilder();
                            bVar6 = this.diy.mSkinData;
                            String sb2 = sb.append(bVar6.getId()).toString();
                            bVar7 = this.diy.mSkinData;
                            String azU = bVar7.azU();
                            bVar8 = this.diy.mSkinData;
                            String title = bVar8.getTitle();
                            bVar9 = this.diy.mSkinData;
                            Ap.a(sb2, azU, title, 0, bVar9.getId(), false, true, false);
                            return;
                        }
                        i.a(this.diy.getPageContext(), 3, i.h.become_member_can_use);
                    }
                } else if (azY == 2) {
                    fVar3 = this.diy.dit;
                    fVar3.e(3, 0.0f);
                    bVar18 = this.diy.mSkinData;
                    bVar18.lF(3);
                    com.baidu.tbadk.download.b Ap2 = com.baidu.tbadk.download.b.Ap();
                    bVar19 = this.diy.mSkinData;
                    Ap2.eG(bVar19.azU());
                    SkinDetailActivity skinDetailActivity = this.diy;
                    bVar20 = this.diy.mSkinData;
                    skinDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, bVar20));
                } else if (azY == 4) {
                    TiebaStatic.log("c10269");
                    bVar10 = this.diy.mSkinData;
                    if (com.baidu.tieba.themeCenter.i.lH(bVar10.azX())) {
                        bVar11 = this.diy.mSkinData;
                        if (bVar11.getId() != -1) {
                            bVar12 = this.diy.mSkinData;
                            if (bVar12.getId() == -2) {
                                TbadkCoreApplication.m411getInst().setSkinType(1);
                            } else {
                                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                                bVar13 = this.diy.mSkinData;
                                int id = bVar13.getId();
                                bVar14 = this.diy.mSkinData;
                                m411getInst.setUsedTheme(id, bVar14.azX());
                                aq aqVar = new aq("c10220");
                                bVar15 = this.diy.mSkinData;
                                aq r = aqVar.r("obj_id", bVar15.getId());
                                bVar16 = this.diy.mSkinData;
                                TiebaStatic.log(r.r("obj_type", bVar16.azX()));
                            }
                        } else {
                            TbadkCoreApplication.m411getInst().setSkinType(0);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_THEME_LIST));
                        fVar2 = this.diy.dit;
                        fVar2.e(0, 0.0f);
                        bVar17 = this.diy.mSkinData;
                        bVar17.lF(0);
                        return;
                    }
                    com.baidu.tieba.themeCenter.i.a(this.diy.getPageContext(), 3, i.h.become_member_can_use);
                }
            }
        }
    }
}
