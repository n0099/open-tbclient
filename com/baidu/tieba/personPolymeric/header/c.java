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
import com.baidu.tbadk.data.m;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.b.i;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.BaijiahaoInfo;
/* loaded from: classes18.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a ekD;
    private com.baidu.tieba.personPolymeric.c.a lnK;
    private b lnL;
    private i lnM;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.lnL.diJ()) {
                c.this.diV();
            } else if (view == c.this.lnL.diK()) {
                c.this.diU();
            } else if (view != c.this.lnL.diL()) {
                if (view == c.this.lnL.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new aq("c12502").dD("obj_locate", "7"));
                        c.this.djd();
                    }
                } else if (view != c.this.lnL.diM() && view != c.this.lnL.diT()) {
                    if (view == c.this.lnL.diN()) {
                        c.this.diZ();
                    } else if (view == c.this.lnL.diP()) {
                        c.this.dja();
                    } else if (view == c.this.lnL.diO()) {
                        c.this.djb();
                    } else if (view == c.this.lnL.diQ()) {
                        c.this.diY();
                    } else if (view == c.this.lnL.diR()) {
                        c.this.diW();
                    } else if (view == c.this.lnL.diS()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new aq("c13613").dD("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new aq("c13613").dD("obj_param1", "1"));
                        }
                        c.this.diX();
                    }
                } else {
                    TiebaStatic.log(new aq("c12502").dD("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aP(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.djd();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || at.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.aP(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new aq("c12503").dD("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.djc();
            }
        }
    };
    private CustomMessageListener ekH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                        if (!updateAttentionMessage.getData().eyb) {
                            c.this.mPageContext.showToast(R.string.unlike_success);
                        }
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.lnL.uH(c.this.mUserData.isLike());
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
        this.lnL = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.ekH);
        this.lnM = new i(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.lnK = aVar;
            this.mUserData = this.lnK.getUserData();
            this.lnL.a(this.lnK.getUserData(), this.lnK.diF());
            this.lnM.d(aVar);
        }
    }

    public View getView() {
        return this.lnL.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.lnL != null) {
            this.lnL.onChangeSkinType(i);
        }
    }

    public void diw() {
        if (this.lnM != null) {
            this.lnM.diw();
        }
    }

    public void ab(Intent intent) {
        if (this.lnM != null) {
            this.lnM.ab(intent);
        }
    }

    public void uI(boolean z) {
        this.lnL.uI(z);
    }

    public void OA(String str) {
        if (this.lnL != null) {
            this.lnL.OA(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diU() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.ekD == null) {
                this.ekD = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
                this.ekD.iC(true);
            }
            this.ekD.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.lnL.uH(this.mUserData.isLike() ? false : true);
            aq aqVar = new aq("c13570");
            aqVar.dD("obj_id", this.mUserData.getUserId());
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                aqVar.dD("nid", this.mPageContext.getPageActivity().getIntent().getStringExtra("nid"));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dD("obj_pre_page", com.baidu.tbadk.pageInfo.c.ej(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                aqVar.dD("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diV() {
        TiebaStatic.log(new aq("c12502").dD("obj_locate", "6"));
        if (this.mIsHost) {
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                be.bju().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (y.getItem(tShowInfo, 0) != null) {
            be.bju().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diW() {
        AlaUserInfoData alaUserData = this.mUserData.getAlaUserData();
        if (!this.mIsHost && alaUserData != null && alaUserData.live_status == 1 && alaUserData.live_id > 0) {
            TiebaStatic.log("c12542");
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.liveID = alaUserData.live_id;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "person_attention", null, false, "")));
            return;
        }
        m mVar = new m();
        if (this.mUserData.getBaijiahaoInfo() != null && !TextUtils.isEmpty(this.mUserData.getBaijiahaoInfo().avatar)) {
            mVar.BF(this.mUserData.getBaijiahaoInfo().avatar);
            mVar.BG(this.mUserData.getBaijiahaoInfo().avatar);
            mVar.ja(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            mVar.BF(this.mUserData.getPortrait());
            mVar.BG(q.zV(this.mUserData.getPortrait()));
            mVar.ja(true);
        } else {
            mVar.BF(q.zV(this.mUserData.getPortraitH()));
            mVar.BG(q.zV(this.mUserData.getPortrait()));
            mVar.ja(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(mVar);
        this.lnM.a((com.baidu.adp.widget.ListView.q) mVar, (List<com.baidu.adp.widget.ListView.q>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diX() {
        if (this.lnK != null && this.lnK.diF() != null && !TextUtils.isEmpty(this.lnK.diF().goods_url)) {
            be.bju().a(this.mPageContext, new String[]{this.lnK.diF().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diY() {
        aq aqVar = new aq("c13574");
        aqVar.ai("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dD("obj_locate", "10"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                Fv(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().bqU() == 1 || equals || (z && this.mUserData.getPersonPrivate().bqU() == 2)) {
                TiebaStatic.log(new aq("c11597").ai("obj_locate", 4).ai("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ai("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                Fv(this.mUserData.getSex());
            }
        }
    }

    private void Fv(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bhm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diZ() {
        TiebaStatic.log(new aq("c12502").dD("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dja() {
        aq aqVar = new aq("c13575");
        aqVar.ai("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dD("obj_locate", "9"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new aq("c11597").ai("obj_locate", 2).ai("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ai("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djb() {
        aq aqVar = new aq("c13573");
        aqVar.ai("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dD("obj_locate", "8"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.doQ().h(2, false, this.mIsHost);
            TiebaStatic.log(new aq("c11597").ai("obj_locate", 3).ai("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ai("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djc() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djd() {
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
                if (this.lnK.lmt != null) {
                    personChangeData.setNickNameLeftDays(this.lnK.lmt.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eeM);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eeN);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.lnL.a(aVar);
    }

    public FollowUserSpinnerBtn dje() {
        return this.lnL.diK();
    }

    public void diH() {
        this.lnL.diH();
    }

    public void diI() {
        this.lnL.diI();
    }

    public void uJ(boolean z) {
        this.lnL.uG(z);
    }

    public void onDestroy() {
        if (this.lnM != null) {
            this.lnM.onDestroy();
        }
        if (this.lnL != null) {
            this.lnL.onDestroy();
        }
    }
}
