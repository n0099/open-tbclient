package com.baidu.tieba.personPolymeric.header;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.e;
import com.baidu.tbadk.data.o;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.b.i;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.BaijiahaoInfo;
/* loaded from: classes8.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a fcZ;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private com.baidu.tieba.personPolymeric.c.a myq;
    private b myr;
    private i mys;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.myr.dAs()) {
                c.this.dAF();
            } else if (view == c.this.myr.dAt()) {
                c.this.dAE();
            } else if (view != c.this.myr.dAu()) {
                if (view == c.this.myr.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new aq("c12502").dX("obj_locate", "7"));
                        c.this.dAO();
                    }
                } else if (view != c.this.myr.dAv() && view != c.this.myr.dAD()) {
                    if (view == c.this.myr.dAw()) {
                        c.this.dAK();
                    } else if (view == c.this.myr.dAy()) {
                        c.this.dAL();
                    } else if (view == c.this.myr.dAx()) {
                        c.this.dAM();
                    } else if (view == c.this.myr.dAz()) {
                        c.this.dAJ();
                    } else if (view == c.this.myr.dAA()) {
                        c.this.dAG();
                    } else if (view == c.this.myr.dAB()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new aq("c13613").dX("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new aq("c13613").dX("obj_param1", "1"));
                        }
                        c.this.dAH();
                    } else if (view == c.this.myr.dAC()) {
                        c.this.dAI();
                    }
                } else {
                    TiebaStatic.log(new aq("c12502").dX("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.bd(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.dAO();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || at.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.bd(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new aq("c12503").dX("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.dAN();
            }
        }
    };
    private CustomMessageListener fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                        if (!updateAttentionMessage.getData().fqS) {
                            c.this.mPageContext.showToast(R.string.unlike_success);
                        }
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.myr.wG(c.this.mUserData.isLike());
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
        this.myr = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.fdd);
        this.mys = new i(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.myq = aVar;
            this.mUserData = this.myq.getUserData();
            this.myr.a(this.myq.getUserData(), this.myq.dAo());
            this.mys.d(aVar);
        }
    }

    public View getView() {
        return this.myr.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.myr != null) {
            this.myr.onChangeSkinType(i);
        }
    }

    public void dAf() {
        if (this.mys != null) {
            this.mys.dAf();
        }
    }

    public void af(Intent intent) {
        if (this.mys != null) {
            this.mys.af(intent);
        }
    }

    public void wH(boolean z) {
        this.myr.wH(z);
    }

    public void QQ(String str) {
        if (this.myr != null) {
            this.myr.QQ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAE() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.fcZ == null) {
                this.fcZ = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
                this.fcZ.kh(true);
            }
            this.fcZ.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.myr.wG(this.mUserData.isLike() ? false : true);
            aq aqVar = new aq("c13570");
            aqVar.dX("obj_id", this.mUserData.getUserId());
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                aqVar.dX(IntentConfig.NID, this.mPageContext.getPageActivity().getIntent().getStringExtra(IntentConfig.NID));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.fu(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.fu(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.fu(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.fu(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dX("obj_pre_page", com.baidu.tbadk.pageInfo.c.fu(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                aqVar.dX("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAF() {
        TiebaStatic.log(new aq("c12502").dX("obj_locate", "6"));
        if (this.mIsHost) {
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                be.bwu().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (x.getItem(tShowInfo, 0) != null) {
            be.bwu().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAG() {
        AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
        if (!this.mIsHost && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
            TiebaStatic.log("c12542");
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaUserData.live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_attention", null, false, "")));
            return;
        }
        o oVar = new o();
        if (this.mUserData.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.mUserData.getBaijiahaoInfo().avatar)) {
            oVar.DA(this.mUserData.getBaijiahaoInfo().avatar);
            oVar.DB(this.mUserData.getBaijiahaoInfo().avatar);
            oVar.kG(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            oVar.DA(this.mUserData.getPortrait());
            oVar.DB(q.BQ(this.mUserData.getPortrait()));
            oVar.kG(true);
        } else {
            oVar.DA(q.BQ(this.mUserData.getPortraitH()));
            oVar.DB(q.BQ(this.mUserData.getPortrait()));
            oVar.kG(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar);
        this.mys.a((n) oVar, (List<n>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAH() {
        if (this.myq != null && this.myq.dAo() != null && !TextUtils.isEmpty(this.myq.dAo().goods_url)) {
            be.bwu().a(this.mPageContext, new String[]{this.myq.dAo().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAI() {
        if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url)) {
            be.bwu().a(this.mPageContext, new String[]{this.mUserData.getLiveRoomInfo().jump_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAJ() {
        aq aqVar = new aq("c13574");
        aqVar.an("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dX("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                Ir(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().bEc() == 1 || equals || (z && this.mUserData.getPersonPrivate().bEc() == 2)) {
                TiebaStatic.log(new aq("c11597").an("obj_locate", 4).an("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).an("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                Ir(this.mUserData.getSex());
            }
        }
    }

    private void Ir(int i) {
        BdToast.b(this.mPageContext.getPageActivity(), String.format(this.mPageContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bud();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAK() {
        TiebaStatic.log(new aq("c12502").dX("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAL() {
        aq aqVar = new aq("c13575");
        aqVar.an("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dX("obj_locate", "9"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new aq("c11597").an("obj_locate", 2).an("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).an("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAM() {
        aq aqVar = new aq("c13573");
        aqVar.an("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dX("obj_locate", "8"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.dGD().h(2, false, this.mIsHost);
            TiebaStatic.log(new aq("c11597").an("obj_locate", 3).an("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).an("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAN() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAO() {
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
                if (this.myq.mwW != null) {
                    personChangeData.setNickNameLeftDays(this.myq.mwW.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eWS);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eWT);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.myr.a(aVar);
    }

    public FollowUserSpinnerBtn dAP() {
        return this.myr.dAt();
    }

    public void dAq() {
        this.myr.dAq();
    }

    public void dAr() {
        this.myr.dAr();
    }

    public void wI(boolean z) {
        this.myr.wF(z);
    }

    public void onDestroy() {
        if (this.mys != null) {
            this.mys.onDestroy();
        }
        if (this.myr != null) {
            this.myr.onDestroy();
        }
    }
}
