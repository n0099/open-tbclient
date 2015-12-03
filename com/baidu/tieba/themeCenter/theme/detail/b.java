package com.baidu.tieba.themeCenter.theme.detail;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ SkinDetailActivity dGJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SkinDetailActivity skinDetailActivity) {
        this.dGJ = skinDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.themeCenter.b bVar;
        com.baidu.tieba.themeCenter.b bVar2;
        com.baidu.tieba.themeCenter.b bVar3;
        com.baidu.tieba.themeCenter.b bVar4;
        g gVar;
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
        com.baidu.tieba.themeCenter.b bVar17;
        g gVar2;
        com.baidu.tieba.themeCenter.b bVar18;
        g gVar3;
        com.baidu.tieba.themeCenter.b bVar19;
        com.baidu.tieba.themeCenter.b bVar20;
        com.baidu.tieba.themeCenter.b bVar21;
        if (view instanceof SkinProgressView) {
            bVar = this.dGJ.mSkinData;
            if (bVar != null) {
                bVar2 = this.dGJ.mSkinData;
                int aFf = bVar2.aFf();
                if (aFf == 1 || aFf == 5 || aFf == 3) {
                    if (aFf == 1) {
                        TiebaStatic.log("c10275");
                    } else if (aFf == 5) {
                        TiebaStatic.log("c10354");
                    }
                    bVar3 = this.dGJ.mSkinData;
                    if (!StringUtils.isNull(bVar3.aFb())) {
                        bVar4 = this.dGJ.mSkinData;
                        if (com.baidu.tieba.themeCenter.i.f(bVar4)) {
                            gVar = this.dGJ.dGD;
                            gVar.e(2, 0.0f);
                            bVar5 = this.dGJ.mSkinData;
                            bVar5.mP(2);
                            com.baidu.tbadk.download.b Bm = com.baidu.tbadk.download.b.Bm();
                            StringBuilder sb = new StringBuilder();
                            bVar6 = this.dGJ.mSkinData;
                            String sb2 = sb.append(bVar6.getId()).toString();
                            bVar7 = this.dGJ.mSkinData;
                            String aFb = bVar7.aFb();
                            bVar8 = this.dGJ.mSkinData;
                            String title = bVar8.getTitle();
                            bVar9 = this.dGJ.mSkinData;
                            Bm.a(sb2, aFb, title, 0, bVar9.getId(), null, false, true, false);
                            return;
                        }
                        this.dGJ.aFz();
                    }
                } else if (aFf == 2) {
                    gVar3 = this.dGJ.dGD;
                    gVar3.e(3, 0.0f);
                    bVar19 = this.dGJ.mSkinData;
                    bVar19.mP(3);
                    com.baidu.tbadk.download.b Bm2 = com.baidu.tbadk.download.b.Bm();
                    bVar20 = this.dGJ.mSkinData;
                    Bm2.eV(bVar20.aFb());
                    SkinDetailActivity skinDetailActivity = this.dGJ;
                    bVar21 = this.dGJ.mSkinData;
                    skinDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, bVar21));
                } else if (aFf == 4) {
                    TiebaStatic.log("c10269");
                    bVar10 = this.dGJ.mSkinData;
                    if (com.baidu.tieba.themeCenter.i.f(bVar10)) {
                        bVar11 = this.dGJ.mSkinData;
                        if (bVar11.getId() != -1) {
                            bVar12 = this.dGJ.mSkinData;
                            if (bVar12.getId() == -2) {
                                TbadkCoreApplication.m411getInst().setSkinType(1);
                            } else {
                                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                                bVar13 = this.dGJ.mSkinData;
                                int id = bVar13.getId();
                                bVar14 = this.dGJ.mSkinData;
                                m411getInst.setUsedTheme(id, bVar14.aFe());
                                av avVar = new av("c10220");
                                bVar15 = this.dGJ.mSkinData;
                                av r = avVar.r("obj_id", bVar15.getId());
                                bVar16 = this.dGJ.mSkinData;
                                TiebaStatic.log(r.r("obj_type", bVar16.aFe()));
                                BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
                                bVar17 = this.dGJ.mSkinData;
                                backgroundSetRequestMessage.setPropId(bVar17.getId());
                                MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
                            }
                        } else {
                            TbadkCoreApplication.m411getInst().setSkinType(0);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_THEME_LIST));
                        gVar2 = this.dGJ.dGD;
                        gVar2.e(0, 0.0f);
                        bVar18 = this.dGJ.mSkinData;
                        bVar18.mP(0);
                        return;
                    }
                    this.dGJ.aFz();
                }
            }
        }
    }
}
