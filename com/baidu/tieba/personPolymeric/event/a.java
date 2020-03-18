package com.baidu.tieba.personPolymeric.event;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.data.d;
import com.baidu.tieba.R;
import com.baidu.tieba.view.e;
/* loaded from: classes11.dex */
public class a implements e {
    protected TbPageContext mPageContext;
    protected int jqM = 1;
    protected int userType = 2;
    protected boolean isHost = false;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    @Override // com.baidu.tieba.view.e
    public void a(View view, com.baidu.tieba.g.a aVar) {
        if (aVar != null) {
            UserData userData = null;
            if (aVar.gbn != null && (userData = (UserData) aVar.gbn.getSerializable(UserData.TYPE_USER)) != null) {
                this.jqM = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), userData.getUserId()) ? 1 : 2;
                this.userType = userData.isGod() ? 1 : 2;
                this.isHost = this.jqM == 1;
            }
            switch (aVar.gbm) {
                case 2:
                    if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                        ba.aGK().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                        return;
                    }
                    return;
                case 3:
                    if (userData != null) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + userData.getUserId(), true, true, true);
                        return;
                    }
                    return;
                case 4:
                    if (userData != null) {
                        if (aVar instanceof com.baidu.tieba.personCenter.d.a) {
                            TiebaStatic.log(new an("c11586"));
                        } else {
                            TiebaStatic.log(new an("c11597").X("obj_locate", 2).X("obj_type", this.jqM).X("obj_source", this.userType));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, userData.getUserId(), userData.getSex()).updateFollowNum(userData.getConcernNum(), userData.getPortrait())));
                        return;
                    }
                    return;
                case 5:
                    com.baidu.tieba.p.a.cEk().g(2, false, this.isHost);
                    if (userData != null) {
                        TiebaStatic.log(new an("c11597").X("obj_locate", 3).X("obj_type", this.jqM).X("obj_source", this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                case 6:
                    if (userData != null) {
                        TiebaStatic.log(new an("c11597").X("obj_locate", 1).X("obj_type", this.jqM).X("obj_source", this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPostActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getSex(), userData.getPortrait())));
                        return;
                    }
                    return;
                case 7:
                    if (userData != null) {
                        TiebaStatic.log(new an("c11597").X("obj_locate", 4).X("obj_type", this.jqM).X("obj_source", this.userType));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), userData.getLike_bars(), userData.getUserId(), userData.getSex())));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
