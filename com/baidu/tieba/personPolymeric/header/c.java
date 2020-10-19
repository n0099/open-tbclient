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
/* loaded from: classes24.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a ezg;
    private com.baidu.tieba.personPolymeric.c.a lMh;
    private b lMi;
    private i lMj;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.lMi.dqb()) {
                c.this.dqo();
            } else if (view == c.this.lMi.dqc()) {
                c.this.dqn();
            } else if (view != c.this.lMi.dqd()) {
                if (view == c.this.lMi.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new aq("c12502").dK("obj_locate", "7"));
                        c.this.dqx();
                    }
                } else if (view != c.this.lMi.dqe() && view != c.this.lMi.dqm()) {
                    if (view == c.this.lMi.dqf()) {
                        c.this.dqt();
                    } else if (view == c.this.lMi.dqh()) {
                        c.this.dqu();
                    } else if (view == c.this.lMi.dqg()) {
                        c.this.dqv();
                    } else if (view == c.this.lMi.dqi()) {
                        c.this.dqs();
                    } else if (view == c.this.lMi.dqj()) {
                        c.this.dqp();
                    } else if (view == c.this.lMi.dqk()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new aq("c13613").dK("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new aq("c13613").dK("obj_param1", "1"));
                        }
                        c.this.dqq();
                    } else if (view == c.this.lMi.dql()) {
                        c.this.dqr();
                    }
                } else {
                    TiebaStatic.log(new aq("c12502").dK("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aU(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.dqx();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || at.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.aU(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new aq("c12503").dK("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.dqw();
            }
        }
    };
    private CustomMessageListener ezk = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                        if (!updateAttentionMessage.getData().eMs) {
                            c.this.mPageContext.showToast(R.string.unlike_success);
                        }
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.lMi.vy(c.this.mUserData.isLike());
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
        this.lMi = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.ezk);
        this.lMj = new i(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.lMh = aVar;
            this.mUserData = this.lMh.getUserData();
            this.lMi.a(this.lMh.getUserData(), this.lMh.dpX());
            this.lMj.d(aVar);
        }
    }

    public View getView() {
        return this.lMi.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.lMi != null) {
            this.lMi.onChangeSkinType(i);
        }
    }

    public void dpO() {
        if (this.lMj != null) {
            this.lMj.dpO();
        }
    }

    public void Y(Intent intent) {
        if (this.lMj != null) {
            this.lMj.Y(intent);
        }
    }

    public void vz(boolean z) {
        this.lMi.vz(z);
    }

    public void PR(String str) {
        if (this.lMi != null) {
            this.lMi.PR(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqn() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.ezg == null) {
                this.ezg = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
                this.ezg.iY(true);
            }
            this.ezg.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.lMi.vy(this.mUserData.isLike() ? false : true);
            aq aqVar = new aq("c13570");
            aqVar.dK("obj_id", this.mUserData.getUserId());
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                aqVar.dK("nid", this.mPageContext.getPageActivity().getIntent().getStringExtra("nid"));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dK("obj_pre_page", com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                aqVar.dK("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqo() {
        TiebaStatic.log(new aq("c12502").dK("obj_locate", "6"));
        if (this.mIsHost) {
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                be.bmY().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (y.getItem(tShowInfo, 0) != null) {
            be.bmY().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqp() {
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
            nVar.CO(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.CP(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.jx(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            nVar.CO(this.mUserData.getPortrait());
            nVar.CP(q.Be(this.mUserData.getPortrait()));
            nVar.jx(true);
        } else {
            nVar.CO(q.Be(this.mUserData.getPortraitH()));
            nVar.CP(q.Be(this.mUserData.getPortrait()));
            nVar.jx(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar);
        this.lMj.a((com.baidu.adp.widget.ListView.q) nVar, (List<com.baidu.adp.widget.ListView.q>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqq() {
        if (this.lMh != null && this.lMh.dpX() != null && !TextUtils.isEmpty(this.lMh.dpX().goods_url)) {
            be.bmY().a(this.mPageContext, new String[]{this.lMh.dpX().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqr() {
        if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url)) {
            be.bmY().a(this.mPageContext, new String[]{this.mUserData.getLiveRoomInfo().jump_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqs() {
        aq aqVar = new aq("c13574");
        aqVar.aj("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dK("obj_locate", "10"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                GC(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().buz() == 1 || equals || (z && this.mUserData.getPersonPrivate().buz() == 2)) {
                TiebaStatic.log(new aq("c11597").aj("obj_locate", 4).aj("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).aj("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                GC(this.mUserData.getSex());
            }
        }
    }

    private void GC(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bkP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqt() {
        TiebaStatic.log(new aq("c12502").dK("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqu() {
        aq aqVar = new aq("c13575");
        aqVar.aj("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dK("obj_locate", "9"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new aq("c11597").aj("obj_locate", 2).aj("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).aj("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqv() {
        aq aqVar = new aq("c13573");
        aqVar.aj("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dK("obj_locate", "8"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.dwo().h(2, false, this.mIsHost);
            TiebaStatic.log(new aq("c11597").aj("obj_locate", 3).aj("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).aj("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqw() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqx() {
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
                if (this.lMh.lKN != null) {
                    personChangeData.setNickNameLeftDays(this.lMh.lKN.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().etl);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().etm);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.lMi.a(aVar);
    }

    public FollowUserSpinnerBtn dqy() {
        return this.lMi.dqc();
    }

    public void dpZ() {
        this.lMi.dpZ();
    }

    public void dqa() {
        this.lMi.dqa();
    }

    public void vA(boolean z) {
        this.lMi.vx(z);
    }

    public void onDestroy() {
        if (this.lMj != null) {
            this.lMj.onDestroy();
        }
        if (this.lMi != null) {
            this.lMi.onDestroy();
        }
    }
}
