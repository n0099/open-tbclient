package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i {
    private int deT;
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
            if (com.baidu.tieba.themeCenter.i.lr(dressItemData.getFreeUserLevel())) {
                this.deT = dressItemData.getPropsId();
                BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
                backgroundSetRequestMessage.setPropId(this.deT);
                MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
                return;
            }
            com.baidu.tieba.themeCenter.i.a(this.mPageContext, z ? 4 : 2, i.h.become_member_can_use_bg);
        }
    }

    public int getPropId() {
        return this.deT;
    }
}
