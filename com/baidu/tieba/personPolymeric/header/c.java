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
import com.baidu.adp.widget.ListView.m;
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
import com.baidu.tbadk.data.n;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.b.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a cVY;
    private com.baidu.tieba.personPolymeric.c.a joF;
    private b joG;
    private h joH;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.joG.cvK()) {
                c.this.cvV();
            } else if (view == c.this.joG.cvL()) {
                c.this.cvU();
            } else if (view != c.this.joG.cvM()) {
                if (view == c.this.joG.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "7"));
                        c.this.cwc();
                    }
                } else if (view != c.this.joG.cvN() && view != c.this.joG.cvT()) {
                    if (view == c.this.joG.cvO()) {
                        c.this.cvY();
                    } else if (view == c.this.joG.cvQ()) {
                        c.this.cvZ();
                    } else if (view == c.this.joG.cvP()) {
                        c.this.cwa();
                    } else if (view == c.this.joG.cvR()) {
                        c.this.cvX();
                    } else if (view == c.this.joG.cvS()) {
                        c.this.cvW();
                    }
                } else {
                    TiebaStatic.log(new an("c12502").cp("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData.getBaijiahaoInfo() != null && c.this.mUserData.getBaijiahaoInfo().auth_id.intValue() > 0) {
                            PersonIntroductionActivity.bc(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.cwc();
                        return;
                    }
                    PersonIntroductionActivity.bc(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                }
            } else {
                TiebaStatic.log(new an("c12503").cp("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.cwb();
            }
        }
    };
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (updateAttentionMessage.getData().isSucc) {
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(c.this.mPageContext.getUniqueId())) {
                        if (updateAttentionMessage.isAttention()) {
                            c.this.mPageContext.showToast(R.string.attention_success);
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
                    c.this.joG.rr(c.this.mUserData.isLike());
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
        this.joG = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.cWc);
        this.joH = new h(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.joF = aVar;
            this.mUserData = this.joF.getUserData();
            this.joG.e(this.joF.getUserData());
            this.joH.d(aVar);
        }
    }

    public View getView() {
        return this.joG.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.joG != null) {
            this.joG.onChangeSkinType(i);
        }
    }

    public void cvA() {
        if (this.joH != null) {
            this.joH.cvA();
        }
    }

    public void ap(Intent intent) {
        if (this.joH != null) {
            this.joH.ap(intent);
        }
    }

    public void rs(boolean z) {
        this.joG.rs(z);
    }

    public void GG(String str) {
        if (this.joG != null) {
            this.joG.GG(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvU() {
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.cVY == null) {
                this.cVY = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
            }
            this.cVY.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.joG.rr(this.mUserData.isLike() ? false : true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvV() {
        TiebaStatic.log(new an("c12502").cp("obj_locate", "6"));
        if (this.mIsHost) {
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                ba.aEt().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (v.getItem(tShowInfo, 0) != null) {
            ba.aEt().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvW() {
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
            nVar.uC(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.uD(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.gn(false);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            nVar.uC(this.mUserData.getPortrait());
            nVar.uD(o.sX(this.mUserData.getPortrait()));
            nVar.gn(true);
        } else {
            nVar.uC(o.sX(this.mUserData.getPortraitH()));
            nVar.uD(o.sX(this.mUserData.getPortrait()));
            nVar.gn(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar);
        this.joH.a((m) nVar, (List<m>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvX() {
        an anVar = new an("c13574");
        anVar.Z("obj_type", this.mIsHost ? 1 : 0);
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").cp("obj_locate", "10"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                zV(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().aLq() == 1 || equals || (z && this.mUserData.getPersonPrivate().aLq() == 2)) {
                TiebaStatic.log(new an("c11597").Z("obj_locate", 4).Z("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).Z("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                zV(this.mUserData.getSex());
            }
        }
    }

    private void zV(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aCu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvY() {
        TiebaStatic.log(new an("c12502").cp("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvZ() {
        an anVar = new an("c13575");
        anVar.Z("obj_type", this.mIsHost ? 1 : 0);
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").cp("obj_locate", "9"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new an("c11597").Z("obj_locate", 2).Z("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).Z("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwa() {
        an anVar = new an("c13573");
        anVar.Z("obj_type", this.mIsHost ? 1 : 0);
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").cp("obj_locate", "8"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.o.a.cCk().g(2, false, this.mIsHost);
            TiebaStatic.log(new an("c11597").Z("obj_locate", 3).Z("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).Z("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwb() {
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwc() {
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
                if (this.joF.jnC != null) {
                    personChangeData.setNickNameLeftDays(this.joF.jnC.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().cQJ);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().cQK);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void onDestroy() {
        if (this.joH != null) {
            this.joH.onDestroy();
        }
        if (this.joG != null) {
            this.joG.onDestroy();
        }
    }
}
