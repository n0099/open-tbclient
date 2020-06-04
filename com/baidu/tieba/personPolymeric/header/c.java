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
    private com.baidu.tieba.personPolymeric.c.a kuK;
    private b kuL;
    private h kuM;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.kuL.cPz()) {
                c.this.cPL();
            } else if (view == c.this.kuL.cPA()) {
                c.this.cPK();
            } else if (view != c.this.kuL.cPB()) {
                if (view == c.this.kuL.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "7"));
                        c.this.cPT();
                    }
                } else if (view != c.this.kuL.cPC() && view != c.this.kuL.cPJ()) {
                    if (view == c.this.kuL.cPD()) {
                        c.this.cPP();
                    } else if (view == c.this.kuL.cPF()) {
                        c.this.cPQ();
                    } else if (view == c.this.kuL.cPE()) {
                        c.this.cPR();
                    } else if (view == c.this.kuL.cPG()) {
                        c.this.cPO();
                    } else if (view == c.this.kuL.cPH()) {
                        c.this.cPM();
                    } else if (view == c.this.kuL.cPI()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new an("c13613").dh("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new an("c13613").dh("obj_param1", "1"));
                        }
                        c.this.cPN();
                    }
                } else {
                    TiebaStatic.log(new an("c12502").dh("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aM(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.cPT();
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
                c.this.cPS();
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
                    c.this.kuL.tc(c.this.mUserData.isLike());
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
        this.kuL = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.dNP);
        this.kuM = new h(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.kuK = aVar;
            this.mUserData = this.kuK.getUserData();
            this.kuL.a(this.kuK.getUserData(), this.kuK.cPy());
            this.kuM.d(aVar);
        }
    }

    public View getView() {
        return this.kuL.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.kuL != null) {
            this.kuL.onChangeSkinType(i);
        }
    }

    public void cPp() {
        if (this.kuM != null) {
            this.kuM.cPp();
        }
    }

    public void Y(Intent intent) {
        if (this.kuM != null) {
            this.kuM.Y(intent);
        }
    }

    public void td(boolean z) {
        this.kuL.td(z);
    }

    public void Ks(String str) {
        if (this.kuL != null) {
            this.kuL.Ks(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPK() {
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.dNL == null) {
                this.dNL = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
            }
            this.dNL.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.kuL.tc(this.mUserData.isLike() ? false : true);
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
    public void cPL() {
        TiebaStatic.log(new an("c12502").dh("obj_locate", "6"));
        if (this.mIsHost) {
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                ba.aVa().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (v.getItem(tShowInfo, 0) != null) {
            ba.aVa().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPM() {
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
        this.kuM.a((com.baidu.adp.widget.ListView.o) mVar, (List<com.baidu.adp.widget.ListView.o>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPN() {
        if (this.kuK != null && this.kuK.cPy() != null && !TextUtils.isEmpty(this.kuK.cPy().goods_url)) {
            ba.aVa().a(this.mPageContext, new String[]{this.kuK.cPy().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPO() {
        an anVar = new an("c13574");
        anVar.ag("obj_type", this.mIsHost ? 1 : 0);
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").dh("obj_locate", "10"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                By(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().bcx() == 1 || equals || (z && this.mUserData.getPersonPrivate().bcx() == 2)) {
                TiebaStatic.log(new an("c11597").ag("obj_locate", 4).ag("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ag("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                By(this.mUserData.getSex());
            }
        }
    }

    private void By(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aSY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPP() {
        TiebaStatic.log(new an("c12502").dh("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPQ() {
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
    public void cPR() {
        an anVar = new an("c13573");
        anVar.ag("obj_type", this.mIsHost ? 1 : 0);
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").dh("obj_locate", "8"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.cWb().g(2, false, this.mIsHost);
            TiebaStatic.log(new an("c11597").ag("obj_locate", 3).ag("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ag("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPS() {
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPT() {
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
                if (this.kuK.ktF != null) {
                    personChangeData.setNickNameLeftDays(this.kuK.ktF.left_days.intValue());
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
        if (this.kuM != null) {
            this.kuM.onDestroy();
        }
        if (this.kuL != null) {
            this.kuL.onDestroy();
        }
    }
}
