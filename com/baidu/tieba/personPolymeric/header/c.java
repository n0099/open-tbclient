package com.baidu.tieba.personPolymeric.header;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.b.i;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.BaijiahaoInfo;
/* loaded from: classes23.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a emW;
    private com.baidu.tieba.personPolymeric.c.a lwR;
    private b lwS;
    private i lwT;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.lwS.dmr()) {
                c.this.dmD();
            } else if (view == c.this.lwS.dms()) {
                c.this.dmC();
            } else if (view != c.this.lwS.dmt()) {
                if (view == c.this.lwS.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new aq("c12502").dF("obj_locate", "7"));
                        c.this.dmL();
                    }
                } else if (view != c.this.lwS.dmu() && view != c.this.lwS.dmB()) {
                    if (view == c.this.lwS.dmv()) {
                        c.this.dmH();
                    } else if (view == c.this.lwS.dmx()) {
                        c.this.dmI();
                    } else if (view == c.this.lwS.dmw()) {
                        c.this.dmJ();
                    } else if (view == c.this.lwS.dmy()) {
                        c.this.dmG();
                    } else if (view == c.this.lwS.dmz()) {
                        c.this.dmE();
                    } else if (view == c.this.lwS.dmA()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new aq("c13613").dF("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new aq("c13613").dF("obj_param1", "1"));
                        }
                        c.this.dmF();
                    }
                } else {
                    TiebaStatic.log(new aq("c12502").dF("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aS(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.dmL();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || at.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.aS(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new aq("c12503").dF("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.dmK();
            }
        }
    };
    private CustomMessageListener ena = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (updateAttentionMessage.getData().isSucc) {
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(c.this.mPageContext.getUniqueId())) {
                        if (updateAttentionMessage.isAttention()) {
                            c.this.mUserData.setLike(true);
                            return;
                        }
                        if (!updateAttentionMessage.getData().eAl) {
                            c.this.mPageContext.showToast(R.string.unlike_success);
                        }
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.lwS.uR(c.this.mUserData.isLike());
                    if (updateAttentionMessage.getData() == null || at.isEmpty(updateAttentionMessage.getData().errorString)) {
                        if (c.this.mUserData.getIsLike()) {
                            c.this.mPageContext.showToast(R.string.unlike_failure);
                            return;
                        } else {
                            c.this.mPageContext.showToast(R.string.attention_fail);
                            return;
                        }
                    }
                    c.this.mPageContext.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.lwS = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.ena);
        this.lwT = new i(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.lwR = aVar;
            this.mUserData = this.lwR.getUserData();
            this.lwS.a(this.lwR.getUserData(), this.lwR.dmn());
            this.lwT.d(aVar);
        }
    }

    public View getView() {
        return this.lwS.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.lwS != null) {
            this.lwS.onChangeSkinType(i);
        }
    }

    public void dme() {
        if (this.lwT != null) {
            this.lwT.dme();
        }
    }

    public void aa(Intent intent) {
        if (this.lwT != null) {
            this.lwT.aa(intent);
        }
    }

    public void uS(boolean z) {
        this.lwS.uS(z);
    }

    public void Pc(String str) {
        if (this.lwS != null) {
            this.lwS.Pc(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmC() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.emW == null) {
                this.emW = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
                this.emW.iA(true);
            }
            this.emW.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.lwS.uR(this.mUserData.isLike() ? false : true);
            aq aqVar = new aq("c13570");
            aqVar.dF("obj_id", this.mUserData.getUserId());
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                aqVar.dF("nid", this.mPageContext.getPageActivity().getIntent().getStringExtra("nid"));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.el(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.el(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.el(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.el(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dF("obj_pre_page", com.baidu.tbadk.pageInfo.c.el(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                aqVar.dF("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmD() {
        TiebaStatic.log(new aq("c12502").dF("obj_locate", "6"));
        if (this.mIsHost) {
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                be.bkp().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (y.getItem(tShowInfo, 0) != null) {
            be.bkp().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmE() {
        AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
        if (!this.mIsHost && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
            TiebaStatic.log("c12542");
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaUserData.live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_attention", null, false, "")));
            return;
        }
        n nVar = new n();
        if (this.mUserData.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.mUserData.getBaijiahaoInfo().avatar)) {
            nVar.Cc(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.Cd(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.iZ(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            nVar.Cc(this.mUserData.getPortrait());
            nVar.Cd(q.As(this.mUserData.getPortrait()));
            nVar.iZ(true);
        } else {
            nVar.Cc(q.As(this.mUserData.getPortraitH()));
            nVar.Cd(q.As(this.mUserData.getPortrait()));
            nVar.iZ(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar);
        this.lwT.a((com.baidu.adp.widget.ListView.q) nVar, (List<com.baidu.adp.widget.ListView.q>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmF() {
        if (this.lwR != null && this.lwR.dmn() != null && !TextUtils.isEmpty(this.lwR.dmn().goods_url)) {
            be.bkp().a(this.mPageContext, new String[]{this.lwR.dmn().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmG() {
        aq aqVar = new aq("c13574");
        aqVar.ai("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dF("obj_locate", "10"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                FW(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().brP() == 1 || equals || (z && this.mUserData.getPersonPrivate().brP() == 2)) {
                TiebaStatic.log(new aq("c11597").ai("obj_locate", 4).ai("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ai("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                FW(this.mUserData.getSex());
            }
        }
    }

    private void FW(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).big();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmH() {
        TiebaStatic.log(new aq("c12502").dF("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmI() {
        aq aqVar = new aq("c13575");
        aqVar.ai("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dF("obj_locate", "9"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new aq("c11597").ai("obj_locate", 2).ai("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ai("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmJ() {
        aq aqVar = new aq("c13573");
        aqVar.ai("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dF("obj_locate", "8"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.dsD().h(2, false, this.mIsHost);
            TiebaStatic.log(new aq("c11597").ai("obj_locate", 3).ai("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ai("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmK() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmL() {
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.mUserData != null) {
                personChangeData.setPortrait(this.mUserData.getPortrait());
                personChangeData.setName(this.mUserData.getUserName());
                personChangeData.setSex(this.mUserData.getSex());
                personChangeData.setIntro(this.mUserData.getIntro());
                personChangeData.setNameShow(this.mUserData.getName_show());
                personChangeData.setMem(this.mUserData.getIsMem());
                personChangeData.setForumAge(this.mUserData.getTb_age());
                personChangeData.setCanModifyAvatar(this.mUserData.canModifyAvatar());
                personChangeData.setCantModifyAvatarDesc(this.mUserData.getCantModifyAvatarDesc());
                if (this.mUserData.alaUserData != null) {
                    personChangeData.setAlaId(this.mUserData.alaUserData.ala_id);
                }
                if (this.lwR.lvB != null) {
                    personChangeData.setNickNameLeftDays(this.lwR.lvB.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().ehe);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().ehf);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.lwS.a(aVar);
    }

    public FollowUserSpinnerBtn dmM() {
        return this.lwS.dms();
    }

    public void dmp() {
        this.lwS.dmp();
    }

    public void dmq() {
        this.lwS.dmq();
    }

    public void uT(boolean z) {
        this.lwS.uQ(z);
    }

    public void onDestroy() {
        if (this.lwT != null) {
            this.lwT.onDestroy();
        }
        if (this.lwS != null) {
            this.lwS.onDestroy();
        }
    }
}
