package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i {
    private int dgZ;
    private TbPageContext<?> mPageContext;

    public i(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(DressItemData dressItemData) {
        if (dressItemData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.mPageContext.getPageActivity(), dressItemData.getPropsId(), dressItemData.getInUse() ? 1 : 0)));
        }
    }

    public void a(DressItemData dressItemData, boolean z) {
        if (dressItemData != null) {
            if (com.baidu.tieba.themeCenter.i.lH(dressItemData.getFreeUserLevel())) {
                this.dgZ = dressItemData.getPropsId();
                BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
                backgroundSetRequestMessage.setPropId(this.dgZ);
                MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
                return;
            }
            com.baidu.tieba.themeCenter.i.a(this.mPageContext, z ? 4 : 2, i.h.become_member_can_use_bg);
        }
    }

    public int getPropId() {
        return this.dgZ;
    }
}
