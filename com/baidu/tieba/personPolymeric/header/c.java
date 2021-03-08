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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.y;
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
    private com.baidu.tbadk.coreExtra.model.a fce;
    private com.baidu.tieba.personPolymeric.c.a mFg;
    private b mFh;
    private i mFi;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.mFh.dza()) {
                c.this.dzn();
            } else if (view == c.this.mFh.dzb()) {
                c.this.dzm();
            } else if (view != c.this.mFh.dzc()) {
                if (view == c.this.mFh.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "7"));
                        c.this.dzw();
                    }
                } else if (view != c.this.mFh.dzd() && view != c.this.mFh.dzl()) {
                    if (view == c.this.mFh.dze()) {
                        c.this.dzs();
                    } else if (view == c.this.mFh.dzg()) {
                        c.this.dzt();
                    } else if (view == c.this.mFh.dzf()) {
                        c.this.dzu();
                    } else if (view == c.this.mFh.dzh()) {
                        c.this.dzr();
                    } else if (view == c.this.mFh.dzi()) {
                        c.this.dzo();
                    } else if (view == c.this.mFh.dzj()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new ar("c13613").dR("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new ar("c13613").dR("obj_param1", "1"));
                        }
                        c.this.dzp();
                    } else if (view == c.this.mFh.dzk()) {
                        c.this.dzq();
                    }
                } else {
                    TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.ba(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.dzw();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || au.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.ba(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new ar("c12503").dR("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.dzv();
            }
        }
    };
    private CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                        if (!updateAttentionMessage.getData().fqb) {
                            c.this.mPageContext.showToast(R.string.unlike_success);
                        }
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.mFh.wT(c.this.mUserData.isLike());
                    if (updateAttentionMessage.getData() == null || au.isEmpty(updateAttentionMessage.getData().errorString)) {
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
        this.mFh = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.fci);
        this.mFi = new i(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mFg = aVar;
            this.mUserData = this.mFg.getUserData();
            this.mFh.a(this.mFg.getUserData(), this.mFg.dyW());
            this.mFi.d(aVar);
        }
    }

    public View getView() {
        return this.mFh.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.mFh != null) {
            this.mFh.onChangeSkinType(i);
        }
    }

    public void dyN() {
        if (this.mFi != null) {
            this.mFi.dyN();
        }
    }

    public void af(Intent intent) {
        if (this.mFi != null) {
            this.mFi.af(intent);
        }
    }

    public void wU(boolean z) {
        this.mFh.wU(z);
    }

    public void QG(String str) {
        if (this.mFh != null) {
            this.mFh.QG(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzm() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.fce == null) {
                this.fce = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
                this.fce.kg(true);
            }
            this.fce.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.mFh.wT(this.mUserData.isLike() ? false : true);
            ar arVar = new ar("c13570");
            arVar.dR("obj_id", this.mUserData.getUserId());
            arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                arVar.dR(IntentConfig.NID, this.mPageContext.getPageActivity().getIntent().getStringExtra(IntentConfig.NID));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), arVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.fq(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.fq(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.fq(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.fq(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                arVar.dR("obj_pre_page", com.baidu.tbadk.pageInfo.c.fq(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                arVar.dR("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzn() {
        TiebaStatic.log(new ar("c12502").dR("obj_locate", "6"));
        if (this.mIsHost) {
            if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bf.bsY().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (y.getItem(tShowInfo, 0) != null) {
            bf.bsY().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzo() {
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
            oVar.CM(this.mUserData.getBaijiahaoInfo().avatar);
            oVar.CN(this.mUserData.getBaijiahaoInfo().avatar);
            oVar.kF(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            oVar.CM(this.mUserData.getPortrait());
            oVar.CN(r.Bc(this.mUserData.getPortrait()));
            oVar.kF(true);
        } else {
            oVar.CM(r.Bc(this.mUserData.getPortraitH()));
            oVar.CN(r.Bc(this.mUserData.getPortrait()));
            oVar.kF(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar);
        this.mFi.a((n) oVar, (List<n>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzp() {
        if (this.mFg != null && this.mFg.dyW() != null && !TextUtils.isEmpty(this.mFg.dyW().goods_url)) {
            bf.bsY().a(this.mPageContext, new String[]{this.mFg.dyW().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzq() {
        if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url)) {
            bf.bsY().a(this.mPageContext, new String[]{this.mUserData.getLiveRoomInfo().jump_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzr() {
        ar arVar = new ar("c13574");
        arVar.aq("obj_type", this.mIsHost ? 1 : 0);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        TiebaStatic.log(new ar("c12502").dR("obj_locate", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                Hf(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().bAE() == 1 || equals || (z && this.mUserData.getPersonPrivate().bAE() == 2)) {
                TiebaStatic.log(new ar("c11597").aq("obj_locate", 4).aq("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).aq("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                Hf(this.mUserData.getSex());
            }
        }
    }

    private void Hf(int i) {
        BdToast.b(this.mPageContext.getPageActivity(), String.format(this.mPageContext.getString(R.string.person_privacy_toast), au.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzs() {
        TiebaStatic.log(new ar("c12502").dR("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzt() {
        ar arVar = new ar("c13575");
        arVar.aq("obj_type", this.mIsHost ? 1 : 0);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new ar("c11597").aq("obj_locate", 2).aq("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).aq("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzu() {
        ar arVar = new ar("c13573");
        arVar.aq("obj_type", this.mIsHost ? 1 : 0);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.dFm().h(2, false, this.mIsHost);
            TiebaStatic.log(new ar("c11597").aq("obj_locate", 3).aq("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).aq("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzv() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzw() {
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
                if (this.mFg.mDM != null) {
                    personChangeData.setNickNameLeftDays(this.mFg.mDM.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eVU);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eVV);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.mFh.a(aVar);
    }

    public FollowUserSpinnerBtn dzx() {
        return this.mFh.dzb();
    }

    public void dyY() {
        this.mFh.dyY();
    }

    public void dyZ() {
        this.mFh.dyZ();
    }

    public void wV(boolean z) {
        this.mFh.wS(z);
    }

    public void onDestroy() {
        if (this.mFi != null) {
            this.mFi.onDestroy();
        }
        if (this.mFh != null) {
            this.mFh.onDestroy();
        }
    }
}
