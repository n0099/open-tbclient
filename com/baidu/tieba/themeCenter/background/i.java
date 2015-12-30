package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class i {
    private int dMg;
    private TbPageContext<?> mPageContext;

    public i(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void b(DressItemData dressItemData) {
        if (dressItemData != null && dressItemData.getPropsId() != 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.mPageContext.getPageActivity(), dressItemData.getPropsId(), dressItemData.getInUse() ? 1 : 0)));
        }
    }

    public void a(DressItemData dressItemData, boolean z) {
        String string;
        if (dressItemData != null) {
            if (com.baidu.tieba.themeCenter.i.a(dressItemData)) {
                this.dMg = dressItemData.getPropsId();
                BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
                backgroundSetRequestMessage.setPropId(this.dMg);
                MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
            } else if (dressItemData.getFreeUserLevel() == 100) {
                if (dressItemData.getActivityFinish() == 0) {
                    if (z) {
                        TbadkCoreApplication.m411getInst().setThemeWebviewOpen(true);
                        com.baidu.tbadk.browser.f.C(this.mPageContext.getPageActivity(), dressItemData.getActivityUrl());
                        return;
                    }
                    com.baidu.tieba.themeCenter.i.b(this.mPageContext, 1, dressItemData.getActivityUrl());
                }
            } else {
                if (dressItemData.getFreeUserLevel() == 101) {
                    string = this.mPageContext.getString(n.j.become_annual_can_use_bg);
                } else if (dressItemData.getFreeUserLevel() > 1) {
                    string = String.format(this.mPageContext.getString(n.j.become_vip_can_use_bg), Integer.valueOf(dressItemData.getFreeUserLevel()));
                } else {
                    string = this.mPageContext.getString(n.j.become_member_can_use_bg);
                }
                com.baidu.tieba.themeCenter.i.a(this.mPageContext, z ? 4 : 2, string);
            }
        }
    }

    public int getPropId() {
        return this.dMg;
    }
}
