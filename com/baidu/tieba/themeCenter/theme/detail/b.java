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
    final /* synthetic */ SkinDetailActivity dOk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SkinDetailActivity skinDetailActivity) {
        this.dOk = skinDetailActivity;
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
        int id;
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
            bVar = this.dOk.mSkinData;
            if (bVar != null) {
                bVar2 = this.dOk.mSkinData;
                int aHu = bVar2.aHu();
                if (aHu == 1 || aHu == 5 || aHu == 3) {
                    if (aHu == 1) {
                        TiebaStatic.log("c10275");
                    } else if (aHu == 5) {
                        TiebaStatic.log("c10354");
                    }
                    bVar3 = this.dOk.mSkinData;
                    if (!StringUtils.isNull(bVar3.aHq())) {
                        bVar4 = this.dOk.mSkinData;
                        if (com.baidu.tieba.themeCenter.i.f(bVar4)) {
                            gVar = this.dOk.dOe;
                            gVar.e(2, 0.0f);
                            bVar5 = this.dOk.mSkinData;
                            bVar5.nr(2);
                            com.baidu.tbadk.download.b Bb = com.baidu.tbadk.download.b.Bb();
                            StringBuilder sb = new StringBuilder();
                            bVar6 = this.dOk.mSkinData;
                            String sb2 = sb.append(bVar6.getId()).toString();
                            bVar7 = this.dOk.mSkinData;
                            String aHq = bVar7.aHq();
                            bVar8 = this.dOk.mSkinData;
                            String title = bVar8.getTitle();
                            bVar9 = this.dOk.mSkinData;
                            Bb.a(sb2, aHq, title, 0, bVar9.getId(), null, false, true, false);
                            return;
                        }
                        this.dOk.aHO();
                    }
                } else if (aHu == 2) {
                    gVar3 = this.dOk.dOe;
                    gVar3.e(3, 0.0f);
                    bVar19 = this.dOk.mSkinData;
                    bVar19.nr(3);
                    com.baidu.tbadk.download.b Bb2 = com.baidu.tbadk.download.b.Bb();
                    bVar20 = this.dOk.mSkinData;
                    Bb2.eZ(bVar20.aHq());
                    SkinDetailActivity skinDetailActivity = this.dOk;
                    bVar21 = this.dOk.mSkinData;
                    skinDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, bVar21));
                } else if (aHu == 4) {
                    TiebaStatic.log("c10269");
                    bVar10 = this.dOk.mSkinData;
                    if (com.baidu.tieba.themeCenter.i.f(bVar10)) {
                        bVar11 = this.dOk.mSkinData;
                        if (bVar11.getId() != -1) {
                            bVar12 = this.dOk.mSkinData;
                            if (bVar12.getId() != -2) {
                                bVar13 = this.dOk.mSkinData;
                                id = bVar13.getId();
                                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                                bVar14 = this.dOk.mSkinData;
                                int id2 = bVar14.getId();
                                bVar15 = this.dOk.mSkinData;
                                m411getInst.setUsedTheme(id2, bVar15.aHt());
                                av avVar = new av("c10220");
                                bVar16 = this.dOk.mSkinData;
                                av r = avVar.r("obj_id", bVar16.getId());
                                bVar17 = this.dOk.mSkinData;
                                TiebaStatic.log(r.r("obj_type", bVar17.aHt()));
                            } else {
                                TbadkCoreApplication.m411getInst().setSkinType(1);
                                id = 125000;
                            }
                        } else {
                            TbadkCoreApplication.m411getInst().setSkinType(0);
                            id = 125000;
                        }
                        BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
                        backgroundSetRequestMessage.setPropId(id);
                        MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_THEME_LIST));
                        gVar2 = this.dOk.dOe;
                        gVar2.e(0, 0.0f);
                        bVar18 = this.dOk.mSkinData;
                        bVar18.nr(0);
                        return;
                    }
                    this.dOk.aHO();
                }
            }
        }
    }
}
