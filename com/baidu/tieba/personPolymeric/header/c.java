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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.b.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.BaijiahaoInfo;
/* loaded from: classes11.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a dNL;
    private com.baidu.tieba.personPolymeric.c.a ktE;
    private b ktF;
    private h ktG;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.ktF.cPj()) {
                c.this.cPv();
            } else if (view == c.this.ktF.cPk()) {
                c.this.cPu();
            } else if (view != c.this.ktF.cPl()) {
                if (view == c.this.ktF.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "7"));
                        c.this.cPD();
                    }
                } else if (view != c.this.ktF.cPm() && view != c.this.ktF.cPt()) {
                    if (view == c.this.ktF.cPn()) {
                        c.this.cPz();
                    } else if (view == c.this.ktF.cPp()) {
                        c.this.cPA();
                    } else if (view == c.this.ktF.cPo()) {
                        c.this.cPB();
                    } else if (view == c.this.ktF.cPq()) {
                        c.this.cPy();
                    } else if (view == c.this.ktF.cPr()) {
                        c.this.cPw();
                    } else if (view == c.this.ktF.cPs()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new an("c13613").dh("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new an("c13613").dh("obj_param1", "1"));
                        }
                        c.this.cPx();
                    }
                } else {
                    TiebaStatic.log(new an("c12502").dh("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aM(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.cPD();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || aq.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.aM(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new an("c12503").dh("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.cPC();
            }
        }
    };
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                        c.this.mPageContext.showToast(R.string.unlike_success);
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.ktF.tc(c.this.mUserData.isLike());
                    if (updateAttentionMessage.getData() == null || aq.isEmpty(updateAttentionMessage.getData().errorString)) {
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
        this.ktF = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.dNP);
        this.ktG = new h(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.ktE = aVar;
            this.mUserData = this.ktE.getUserData();
            this.ktF.a(this.ktE.getUserData(), this.ktE.cPi());
            this.ktG.d(aVar);
        }
    }

    public View getView() {
        return this.ktF.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.ktF != null) {
            this.ktF.onChangeSkinType(i);
        }
    }

    public void cOZ() {
        if (this.ktG != null) {
            this.ktG.cOZ();
        }
    }

    public void Y(Intent intent) {
        if (this.ktG != null) {
            this.ktG.Y(intent);
        }
    }

    public void td(boolean z) {
        this.ktF.td(z);
    }

    public void Kr(String str) {
        if (this.ktF != null) {
            this.ktF.Kr(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPu() {
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.dNL == null) {
                this.dNL = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
            }
            this.dNL.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.ktF.tc(this.mUserData.isLike() ? false : true);
            an anVar = new an("c13570");
            anVar.dh("obj_id", this.mUserData.getUserId());
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                anVar.dh("nid", this.mPageContext.getPageActivity().getIntent().getStringExtra("nid"));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), anVar);
            }
            TiebaStatic.log(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPv() {
        TiebaStatic.log(new an("c12502").dh("obj_locate", "6"));
        if (this.mIsHost) {
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                ba.aUZ().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (v.getItem(tShowInfo, 0) != null) {
            ba.aUZ().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPw() {
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
            mVar.xQ(this.mUserData.getBaijiahaoInfo().avatar);
            mVar.xR(this.mUserData.getBaijiahaoInfo().avatar);
            mVar.hP(false);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            mVar.xQ(this.mUserData.getPortrait());
            mVar.xR(o.wj(this.mUserData.getPortrait()));
            mVar.hP(true);
        } else {
            mVar.xQ(o.wj(this.mUserData.getPortraitH()));
            mVar.xR(o.wj(this.mUserData.getPortrait()));
            mVar.hP(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(mVar);
        this.ktG.a((com.baidu.adp.widget.ListView.o) mVar, (List<com.baidu.adp.widget.ListView.o>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPx() {
        if (this.ktE != null && this.ktE.cPi() != null && !TextUtils.isEmpty(this.ktE.cPi().goods_url)) {
            ba.aUZ().a(this.mPageContext, new String[]{this.ktE.cPi().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPy() {
        an anVar = new an("c13574");
        anVar.ag("obj_type", this.mIsHost ? 1 : 0);
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").dh("obj_locate", "10"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                Bw(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().bcw() == 1 || equals || (z && this.mUserData.getPersonPrivate().bcw() == 2)) {
                TiebaStatic.log(new an("c11597").ag("obj_locate", 4).ag("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ag("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                Bw(this.mUserData.getSex());
            }
        }
    }

    private void Bw(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aSY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPz() {
        TiebaStatic.log(new an("c12502").dh("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPA() {
        an anVar = new an("c13575");
        anVar.ag("obj_type", this.mIsHost ? 1 : 0);
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").dh("obj_locate", "9"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new an("c11597").ag("obj_locate", 2).ag("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ag("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPB() {
        an anVar = new an("c13573");
        anVar.ag("obj_type", this.mIsHost ? 1 : 0);
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").dh("obj_locate", "8"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.cVL().g(2, false, this.mIsHost);
            TiebaStatic.log(new an("c11597").ag("obj_locate", 3).ag("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ag("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPC() {
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPD() {
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
                if (this.ktE.ksz != null) {
                    personChangeData.setNickNameLeftDays(this.ktE.ksz.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().dIk);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().dIl);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void onDestroy() {
        if (this.ktG != null) {
            this.ktG.onDestroy();
        }
        if (this.ktF != null) {
            this.ktF.onDestroy();
        }
    }
}
