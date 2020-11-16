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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
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
    private com.baidu.tbadk.coreExtra.model.a eMq;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private com.baidu.tieba.personPolymeric.c.a meV;
    private b meW;
    private i meX;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.meW.dvk()) {
                c.this.dvx();
            } else if (view == c.this.meW.dvl()) {
                c.this.dvw();
            } else if (view != c.this.meW.dvm()) {
                if (view == c.this.meW.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new ar("c12502").dR("obj_locate", "7"));
                        c.this.dvG();
                    }
                } else if (view != c.this.meW.dvn() && view != c.this.meW.dvv()) {
                    if (view == c.this.meW.dvo()) {
                        c.this.dvC();
                    } else if (view == c.this.meW.dvq()) {
                        c.this.dvD();
                    } else if (view == c.this.meW.dvp()) {
                        c.this.dvE();
                    } else if (view == c.this.meW.dvr()) {
                        c.this.dvB();
                    } else if (view == c.this.meW.dvs()) {
                        c.this.dvy();
                    } else if (view == c.this.meW.dvt()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new ar("c13613").dR("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new ar("c13613").dR("obj_param1", "1"));
                        }
                        c.this.dvz();
                    } else if (view == c.this.meW.dvu()) {
                        c.this.dvA();
                    }
                } else {
                    TiebaStatic.log(new ar("c12502").dR("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aT(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.dvG();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || au.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.aT(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new ar("c12503").dR("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.dvF();
            }
        }
    };
    private CustomMessageListener eMu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                        if (!updateAttentionMessage.getData().eZL) {
                            c.this.mPageContext.showToast(R.string.unlike_success);
                        }
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.meW.wb(c.this.mUserData.isLike());
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
        this.meW = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.eMu);
        this.meX = new i(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.meV = aVar;
            this.mUserData = this.meV.getUserData();
            this.meW.a(this.meV.getUserData(), this.meV.dvg());
            this.meX.d(aVar);
        }
    }

    public View getView() {
        return this.meW.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.meW != null) {
            this.meW.onChangeSkinType(i);
        }
    }

    public void duX() {
        if (this.meX != null) {
            this.meX.duX();
        }
    }

    public void Y(Intent intent) {
        if (this.meX != null) {
            this.meX.Y(intent);
        }
    }

    public void wc(boolean z) {
        this.meW.wc(z);
    }

    public void Qb(String str) {
        if (this.meW != null) {
            this.meW.Qb(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvw() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.eMq == null) {
                this.eMq = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
                this.eMq.jv(true);
            }
            this.eMq.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.meW.wb(this.mUserData.isLike() ? false : true);
            ar arVar = new ar("c13570");
            arVar.dR("obj_id", this.mUserData.getUserId());
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                arVar.dR("nid", this.mPageContext.getPageActivity().getIntent().getStringExtra("nid"));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), arVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                arVar.dR("obj_pre_page", com.baidu.tbadk.pageInfo.c.es(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                arVar.dR("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvx() {
        TiebaStatic.log(new ar("c12502").dR("obj_locate", "6"));
        if (this.mIsHost) {
            if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bf.bqF().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (y.getItem(tShowInfo, 0) != null) {
            bf.bqF().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvy() {
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
            nVar.CU(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.CV(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.jU(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            nVar.CU(this.mUserData.getPortrait());
            nVar.CV(q.Bk(this.mUserData.getPortrait()));
            nVar.jU(true);
        } else {
            nVar.CU(q.Bk(this.mUserData.getPortraitH()));
            nVar.CV(q.Bk(this.mUserData.getPortrait()));
            nVar.jU(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar);
        this.meX.a((com.baidu.adp.widget.ListView.q) nVar, (List<com.baidu.adp.widget.ListView.q>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvz() {
        if (this.meV != null && this.meV.dvg() != null && !TextUtils.isEmpty(this.meV.dvg().goods_url)) {
            bf.bqF().a(this.mPageContext, new String[]{this.meV.dvg().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvA() {
        if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url)) {
            bf.bqF().a(this.mPageContext, new String[]{this.mUserData.getLiveRoomInfo().jump_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvB() {
        ar arVar = new ar("c13574");
        arVar.ak("obj_type", this.mIsHost ? 1 : 0);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        TiebaStatic.log(new ar("c12502").dR("obj_locate", "10"));
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                HG(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().byh() == 1 || equals || (z && this.mUserData.getPersonPrivate().byh() == 2)) {
                TiebaStatic.log(new ar("c11597").ak("obj_locate", 4).ak("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ak("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                HG(this.mUserData.getSex());
            }
        }
    }

    private void HG(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), au.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).bom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvC() {
        TiebaStatic.log(new ar("c12502").dR("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvD() {
        ar arVar = new ar("c13575");
        arVar.ak("obj_type", this.mIsHost ? 1 : 0);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        TiebaStatic.log(new ar("c12502").dR("obj_locate", "9"));
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new ar("c11597").ak("obj_locate", 2).ak("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ak("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvE() {
        ar arVar = new ar("c13573");
        arVar.ak("obj_type", this.mIsHost ? 1 : 0);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        TiebaStatic.log(new ar("c12502").dR("obj_locate", "8"));
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.q.a.dBC().h(2, false, this.mIsHost);
            TiebaStatic.log(new ar("c11597").ak("obj_locate", 3).ak("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ak("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvF() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvG() {
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
                if (this.meV.mdA != null) {
                    personChangeData.setNickNameLeftDays(this.meV.mdA.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eFR);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eFS);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.meW.a(aVar);
    }

    public FollowUserSpinnerBtn dvH() {
        return this.meW.dvl();
    }

    public void dvi() {
        this.meW.dvi();
    }

    public void dvj() {
        this.meW.dvj();
    }

    public void wd(boolean z) {
        this.meW.wa(z);
    }

    public void onDestroy() {
        if (this.meX != null) {
            this.meX.onDestroy();
        }
        if (this.meW != null) {
            this.meW.onDestroy();
        }
    }
}
