package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes8.dex */
public class d {
    private int mFrom = -1;
    private TbPageContext<?> mPageContext;
    private int nwW;
    public BdUniqueId nwX;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.nwX = null;
        this.mPageContext = tbPageContext;
        this.nwX = bdUniqueId;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void e(DressItemData dressItemData) {
        if (dressItemData != null && dressItemData.getPropsId() != 0) {
            PersonalBackgroundPreviewActivityConfig personalBackgroundPreviewActivityConfig = new PersonalBackgroundPreviewActivityConfig(this.mPageContext.getPageActivity(), dressItemData.getPropsId(), dressItemData.getInUse() ? 1 : 0);
            personalBackgroundPreviewActivityConfig.setFrom(this.mFrom);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personalBackgroundPreviewActivityConfig));
        }
    }

    public void a(DressItemData dressItemData, boolean z) {
        if (dressItemData != null) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.skipToLoginActivity(this.mPageContext.getPageActivity());
                return;
            }
            this.nwW = dressItemData.getPropsId();
            BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
            backgroundSetRequestMessage.setFromDetail(z);
            backgroundSetRequestMessage.setRequestUniqueId(this.nwX);
            backgroundSetRequestMessage.setPropId(this.nwW);
            MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_PERSONAL));
        }
    }

    public void a(int i, String str, DressItemData dressItemData, boolean z) {
        int i2;
        if (dressItemData.getFreeUserLevel() == 101) {
            i2 = 9;
        } else {
            i2 = 0;
        }
        if (!StringUtils.isNull(str)) {
            if (i == com.baidu.tieba.themeCenter.c.nvR) {
                String str2 = "";
                if (this.mFrom == 1) {
                    str2 = MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND_TRY;
                } else if (this.mFrom == 0) {
                    str2 = MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND_TRY;
                }
                com.baidu.tieba.themeCenter.b.a(this.mPageContext, z ? 4 : 2, str, i2, str2, MemberPayStatistic.CLICK_ZONE_BOTTOM_OPENDE_RENEWALFEE_BUTTON);
            } else if (i == com.baidu.tieba.themeCenter.c.nvS) {
                com.baidu.tieba.themeCenter.b.a(this.mPageContext, z ? 4 : 2, str, i2);
            }
        }
    }

    public int getPropId() {
        return this.nwW;
    }
}
