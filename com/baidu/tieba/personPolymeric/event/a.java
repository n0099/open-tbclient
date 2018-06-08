package com.baidu.tieba.personPolymeric.event;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.view.g;
/* loaded from: classes3.dex */
public class a implements g {
    protected TbPageContext mPageContext;
    protected int fWV = 1;
    protected int userType = 2;
    protected boolean isHost = false;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.view.g
    public void a(View view, com.baidu.tieba.g.a aVar) {
        if (aVar != null) {
            UserData userData = null;
            if (aVar.cUs != null && (userData = (UserData) aVar.cUs.getSerializable(UserData.TYPE_USER)) != null) {
                this.fWV = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
                this.userType = userData.isGod() ? 1 : 2;
                this.isHost = this.fWV == 1;
            }
            switch (aVar.cUr) {
                case 2:
                    if (ba.aU(this.mPageContext.getPageActivity())) {
                        ay.zG().c(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                        return;
                    }
                    return;
                case 3:
                    if (userData != null) {
                        com.baidu.tbadk.browser.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getString(d.k.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + userData.getUserId(), true, true, true);
                        return;
                    }
                    return;
                case 4:
                    if (userData != null) {
                        if (aVar instanceof com.baidu.tieba.personCenter.c.a) {
                            TiebaStatic.log(new am("c11586"));
                        } else {
                            TiebaStatic.log(new am("c11597").r("obj_locate", 2).r("obj_type", this.fWV).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 5:
                    com.baidu.tieba.o.a.bpq().b(2, false, this.isHost);
                    if (userData != null) {
                        TiebaStatic.log(new am("c11597").r("obj_locate", 3).r("obj_type", this.fWV).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 6:
                    if (userData != null) {
                        TiebaStatic.log(new am("c11597").r("obj_locate", 1).r("obj_type", this.fWV).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                        return;
                    }
                    return;
                case 7:
                    if (userData != null) {
                        TiebaStatic.log(new am("c11597").r("obj_locate", 4).r("obj_type", this.fWV).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
