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
    private com.baidu.tbadk.coreExtra.model.a eNr;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private com.baidu.tieba.personPolymeric.c.a meD;
    private b meE;
    private i meF;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.meE.dvK()) {
                c.this.dvX();
            } else if (view == c.this.meE.dvL()) {
                c.this.dvW();
            } else if (view != c.this.meE.dvM()) {
                if (view == c.this.meE.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new aq("c12502").dR("obj_locate", "7"));
                        c.this.dwg();
                    }
                } else if (view != c.this.meE.dvN() && view != c.this.meE.dvV()) {
                    if (view == c.this.meE.dvO()) {
                        c.this.dwc();
                    } else if (view == c.this.meE.dvQ()) {
                        c.this.dwd();
                    } else if (view == c.this.meE.dvP()) {
                        c.this.dwe();
                    } else if (view == c.this.meE.dvR()) {
                        c.this.dwb();
                    } else if (view == c.this.meE.dvS()) {
                        c.this.dvY();
                    } else if (view == c.this.meE.dvT()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new aq("c13613").dR("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new aq("c13613").dR("obj_param1", "1"));
                        }
                        c.this.dvZ();
                    } else if (view == c.this.meE.dvU()) {
                        c.this.dwa();
                    }
                } else {
                    TiebaStatic.log(new aq("c12502").dR("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aW(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.dwg();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || at.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.aW(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new aq("c12503").dR("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.dwf();
            }
        }
    };
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                        if (!updateAttentionMessage.getData().faD) {
                            c.this.mPageContext.showToast(R.string.unlike_success);
                        }
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.meE.vY(c.this.mUserData.isLike());
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
        this.meE = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.eNv);
        this.meF = new i(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.meD = aVar;
            this.mUserData = this.meD.getUserData();
            this.meE.a(this.meD.getUserData(), this.meD.dvG());
            this.meF.d(aVar);
        }
    }

    public View getView() {
        return this.meE.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.meE != null) {
            this.meE.onChangeSkinType(i);
        }
    }

    public void dvx() {
        if (this.meF != null) {
            this.meF.dvx();
        }
    }

    public void Y(Intent intent) {
        if (this.meF != null) {
            this.meF.Y(intent);
        }
    }

    public void vZ(boolean z) {
        this.meE.vZ(z);
    }

    public void QG(String str) {
        if (this.meE != null) {
            this.meE.QG(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvW() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.eNr == null) {
                this.eNr = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
                this.eNr.ju(true);
            }
            this.eNr.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.meE.vY(this.mUserData.isLike() ? false : true);
            aq aqVar = new aq("c13570");
            aqVar.dR("obj_id", this.mUserData.getUserId());
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                aqVar.dR("nid", this.mPageContext.getPageActivity().getIntent().getStringExtra("nid"));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dR("obj_pre_page", com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                aqVar.dR("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvX() {
        TiebaStatic.log(new aq("c12502").dR("obj_locate", "6"));
        if (this.mIsHost) {
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                be.brr().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (y.getItem(tShowInfo, 0) != null) {
            be.brr().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvY() {
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
            nVar.Dv(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.Dw(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.jT(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            nVar.Dv(this.mUserData.getPortrait());
            nVar.Dw(q.BL(this.mUserData.getPortrait()));
            nVar.jT(true);
        } else {
            nVar.Dv(q.BL(this.mUserData.getPortraitH()));
            nVar.Dw(q.BL(this.mUserData.getPortrait()));
            nVar.jT(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar);
        this.meF.a((com.baidu.adp.widget.ListView.q) nVar, (List<com.baidu.adp.widget.ListView.q>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvZ() {
        if (this.meD != null && this.meD.dvG() != null && !TextUtils.isEmpty(this.meD.dvG().goods_url)) {
            be.brr().a(this.mPageContext, new String[]{this.meD.dvG().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwa() {
        if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url)) {
            be.brr().a(this.mPageContext, new String[]{this.mUserData.getLiveRoomInfo().jump_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwb() {
        aq aqVar = new aq("c13574");
        aqVar.al("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dR("obj_locate", "10"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                Hi(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().byR() == 1 || equals || (z && this.mUserData.getPersonPrivate().byR() == 2)) {
                TiebaStatic.log(new aq("c11597").al("obj_locate", 4).al("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).al("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                Hi(this.mUserData.getSex());
            }
        }
    }

    private void Hi(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).bpi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwc() {
        TiebaStatic.log(new aq("c12502").dR("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwd() {
        aq aqVar = new aq("c13575");
        aqVar.al("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dR("obj_locate", "9"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new aq("c11597").al("obj_locate", 2).al("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).al("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwe() {
        aq aqVar = new aq("c13573");
        aqVar.al("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dR("obj_locate", "8"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.dBY().h(2, false, this.mIsHost);
            TiebaStatic.log(new aq("c11597").al("obj_locate", 3).al("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).al("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwf() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwg() {
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
                if (this.meD.mdi != null) {
                    personChangeData.setNickNameLeftDays(this.meD.mdi.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eHz);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eHA);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.meE.a(aVar);
    }

    public FollowUserSpinnerBtn dwh() {
        return this.meE.dvL();
    }

    public void dvI() {
        this.meE.dvI();
    }

    public void dvJ() {
        this.meE.dvJ();
    }

    public void wa(boolean z) {
        this.meE.vX(z);
    }

    public void onDestroy() {
        if (this.meF != null) {
            this.meF.onDestroy();
        }
        if (this.meE != null) {
            this.meE.onDestroy();
        }
    }
}
