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
/* loaded from: classes7.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a eYq;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private com.baidu.tieba.personPolymeric.c.a mtL;
    private b mtM;
    private i mtN;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.mtM.dwB()) {
                c.this.dwO();
            } else if (view == c.this.mtM.dwC()) {
                c.this.dwN();
            } else if (view != c.this.mtM.dwD()) {
                if (view == c.this.mtM.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new aq("c12502").dW("obj_locate", "7"));
                        c.this.dwX();
                    }
                } else if (view != c.this.mtM.dwE() && view != c.this.mtM.dwM()) {
                    if (view == c.this.mtM.dwF()) {
                        c.this.dwT();
                    } else if (view == c.this.mtM.dwH()) {
                        c.this.dwU();
                    } else if (view == c.this.mtM.dwG()) {
                        c.this.dwV();
                    } else if (view == c.this.mtM.dwI()) {
                        c.this.dwS();
                    } else if (view == c.this.mtM.dwJ()) {
                        c.this.dwP();
                    } else if (view == c.this.mtM.dwK()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new aq("c13613").dW("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new aq("c13613").dW("obj_param1", "1"));
                        }
                        c.this.dwQ();
                    } else if (view == c.this.mtM.dwL()) {
                        c.this.dwR();
                    }
                } else {
                    TiebaStatic.log(new aq("c12502").dW("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.bd(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.dwX();
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
                TiebaStatic.log(new aq("c12503").dW("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.dwW();
            }
        }
    };
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                        if (!updateAttentionMessage.getData().fmi) {
                            c.this.mPageContext.showToast(R.string.unlike_success);
                        }
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.mtM.wC(c.this.mUserData.isLike());
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
        this.mtM = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.eYu);
        this.mtN = new i(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mtL = aVar;
            this.mUserData = this.mtL.getUserData();
            this.mtM.a(this.mtL.getUserData(), this.mtL.dwx());
            this.mtN.d(aVar);
        }
    }

    public View getView() {
        return this.mtM.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.mtM != null) {
            this.mtM.onChangeSkinType(i);
        }
    }

    public void dwo() {
        if (this.mtN != null) {
            this.mtN.dwo();
        }
    }

    public void af(Intent intent) {
        if (this.mtN != null) {
            this.mtN.af(intent);
        }
    }

    public void wD(boolean z) {
        this.mtM.wD(z);
    }

    public void PH(String str) {
        if (this.mtM != null) {
            this.mtM.PH(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwN() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.eYq == null) {
                this.eYq = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
                this.eYq.kd(true);
            }
            this.eYq.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.mtM.wC(this.mUserData.isLike() ? false : true);
            aq aqVar = new aq("c13570");
            aqVar.dW("obj_id", this.mUserData.getUserId());
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                aqVar.dW(IntentConfig.NID, this.mPageContext.getPageActivity().getIntent().getStringExtra(IntentConfig.NID));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aqVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.fs(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.fs(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.fs(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.fs(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                aqVar.dW("obj_pre_page", com.baidu.tbadk.pageInfo.c.fs(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                aqVar.dW("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwO() {
        TiebaStatic.log(new aq("c12502").dW("obj_locate", "6"));
        if (this.mIsHost) {
            if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                be.bsB().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (x.getItem(tShowInfo, 0) != null) {
            be.bsB().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwP() {
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
            oVar.Co(this.mUserData.getBaijiahaoInfo().avatar);
            oVar.Cp(this.mUserData.getBaijiahaoInfo().avatar);
            oVar.kC(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            oVar.Co(this.mUserData.getPortrait());
            oVar.Cp(q.AE(this.mUserData.getPortrait()));
            oVar.kC(true);
        } else {
            oVar.Co(q.AE(this.mUserData.getPortraitH()));
            oVar.Cp(q.AE(this.mUserData.getPortrait()));
            oVar.kC(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar);
        this.mtN.a((n) oVar, (List<n>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwQ() {
        if (this.mtL != null && this.mtL.dwx() != null && !TextUtils.isEmpty(this.mtL.dwx().goods_url)) {
            be.bsB().a(this.mPageContext, new String[]{this.mtL.dwx().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwR() {
        if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url)) {
            be.bsB().a(this.mPageContext, new String[]{this.mUserData.getLiveRoomInfo().jump_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwS() {
        aq aqVar = new aq("c13574");
        aqVar.an("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dW("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                GK(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().bAj() == 1 || equals || (z && this.mUserData.getPersonPrivate().bAj() == 2)) {
                TiebaStatic.log(new aq("c11597").an("obj_locate", 4).an("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).an("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                GK(this.mUserData.getSex());
            }
        }
    }

    private void GK(int i) {
        BdToast.b(this.mPageContext.getPageActivity(), String.format(this.mPageContext.getString(R.string.person_privacy_toast), at.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwT() {
        TiebaStatic.log(new aq("c12502").dW("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwU() {
        aq aqVar = new aq("c13575");
        aqVar.an("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dW("obj_locate", "9"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new aq("c11597").an("obj_locate", 2).an("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).an("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwV() {
        aq aqVar = new aq("c13573");
        aqVar.an("obj_type", this.mIsHost ? 1 : 0);
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aqVar);
        TiebaStatic.log(new aq("c12502").dW("obj_locate", "8"));
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.dCM().h(2, false, this.mIsHost);
            TiebaStatic.log(new aq("c11597").an("obj_locate", 3).an("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).an("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwW() {
        if (bg.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwX() {
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
                if (this.mtL.msr != null) {
                    personChangeData.setNickNameLeftDays(this.mtL.msr.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eSh);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eSi);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.mtM.a(aVar);
    }

    public FollowUserSpinnerBtn dwY() {
        return this.mtM.dwC();
    }

    public void dwz() {
        this.mtM.dwz();
    }

    public void dwA() {
        this.mtM.dwA();
    }

    public void wE(boolean z) {
        this.mtM.wB(z);
    }

    public void onDestroy() {
        if (this.mtN != null) {
            this.mtN.onDestroy();
        }
        if (this.mtM != null) {
            this.mtM.onDestroy();
        }
    }
}
