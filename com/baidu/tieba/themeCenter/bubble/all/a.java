package com.baidu.tieba.themeCenter.bubble.all;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.i;
/* loaded from: classes.dex */
public class a {
    private int dMg;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void f(DressItemData dressItemData) {
        String string;
        if (dressItemData != null) {
            boolean a = i.a(dressItemData);
            if (!a) {
                a = g(dressItemData);
            }
            if (a) {
                this.dMg = dressItemData.getPropsId();
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_BUBBLE_SET);
                httpMessage.setExtra(Integer.valueOf(this.dMg));
                httpMessage.addParam("bcode", String.valueOf(this.dMg));
                MessageManager.getInstance().sendMessage(httpMessage);
            } else if (dressItemData.getFreeUserLevel() == 100) {
                if (dressItemData.getActivityFinish() == 0) {
                    i.b(this.mPageContext, 5, dressItemData.getActivityUrl());
                }
            } else {
                if (dressItemData.getFreeUserLevel() == 101) {
                    string = this.mPageContext.getString(n.j.become_annual_can_use_bubble);
                } else if (dressItemData.getFreeUserLevel() > 1) {
                    string = String.format(this.mPageContext.getString(n.j.become_vip_can_use_bubble), Integer.valueOf(dressItemData.getFreeUserLevel()));
                } else {
                    string = this.mPageContext.getString(n.j.become_member_can_use_bubble);
                }
                i.a(this.mPageContext, 5, string);
            }
        }
    }

    private boolean g(DressItemData dressItemData) {
        return TbadkCoreApplication.getCurrentVipLevel() == 1 && dressItemData.getFreeUserLevel() == 1;
    }
}
