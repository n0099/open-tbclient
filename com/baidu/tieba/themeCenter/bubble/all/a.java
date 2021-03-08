package com.baidu.tieba.themeCenter.bubble.all;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.b;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes8.dex */
public class a {
    private TbPageContext<?> mPageContext;
    private int nJn;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void b(DressItemData dressItemData, boolean z) {
        String string;
        String str;
        int i = 0;
        if (dressItemData != null) {
            boolean a2 = b.a(dressItemData);
            if (!a2) {
                a2 = h(dressItemData);
            }
            if (a2) {
                this.nJn = dressItemData.getPropsId();
                HttpMessage httpMessage = new HttpMessage(1003056);
                httpMessage.setExtra(Integer.valueOf(this.nJn));
                httpMessage.addParam("bcode", String.valueOf(this.nJn));
                MessageManager.getInstance().sendMessage(httpMessage);
            } else if (dressItemData.getFreeUserLevel() == 100) {
                if (dressItemData.getActivityFinish() == 0) {
                    b.a(this.mPageContext, 5, dressItemData.getActivityUrl());
                }
            } else {
                if (dressItemData.getFreeUserLevel() == 101) {
                    i = 9;
                    string = this.mPageContext.getString(R.string.become_annual_can_use_bubble);
                } else if (dressItemData.getFreeUserLevel() > 1) {
                    string = String.format(this.mPageContext.getString(R.string.become_vip_can_use_bubble), Integer.valueOf(dressItemData.getFreeUserLevel()));
                } else {
                    string = this.mPageContext.getString(R.string.become_member_can_use_bubble);
                }
                if (z) {
                    str = MemberPayStatistic.REFER_PAGE_POST_BUBBLE;
                } else {
                    str = MemberPayStatistic.REFER_PAGE_ALL_BUBBLE;
                }
                b.a(this.mPageContext, 5, string, i, str, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
            }
        }
    }

    private boolean h(DressItemData dressItemData) {
        return TbadkCoreApplication.getCurrentMemberType() == 1 && dressItemData.getFreeUserLevel() == 1;
    }
}
