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
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.w;
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
    private com.baidu.tbadk.coreExtra.model.a dUB;
    private com.baidu.tieba.personPolymeric.c.a kOH;
    private b kOI;
    private h kOJ;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.kOI.cTR()) {
                c.this.cUd();
            } else if (view == c.this.kOI.cTS()) {
                c.this.cUc();
            } else if (view != c.this.kOI.cTT()) {
                if (view == c.this.kOI.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new ao("c12502").dk("obj_locate", "7"));
                        c.this.cUl();
                    }
                } else if (view != c.this.kOI.cTU() && view != c.this.kOI.cUb()) {
                    if (view == c.this.kOI.cTV()) {
                        c.this.cUh();
                    } else if (view == c.this.kOI.cTX()) {
                        c.this.cUi();
                    } else if (view == c.this.kOI.cTW()) {
                        c.this.cUj();
                    } else if (view == c.this.kOI.cTY()) {
                        c.this.cUg();
                    } else if (view == c.this.kOI.cTZ()) {
                        c.this.cUe();
                    } else if (view == c.this.kOI.cUa()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new ao("c13613").dk("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new ao("c13613").dk("obj_param1", "1"));
                        }
                        c.this.cUf();
                    }
                } else {
                    TiebaStatic.log(new ao("c12502").dk("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aM(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.cUl();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || ar.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.aM(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new ao("c12503").dk("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.cUk();
            }
        }
    };
    private CustomMessageListener dUF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                    c.this.kOI.tq(c.this.mUserData.isLike());
                    if (updateAttentionMessage.getData() == null || ar.isEmpty(updateAttentionMessage.getData().errorString)) {
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
        this.kOI = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.dUF);
        this.kOJ = new h(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.kOH = aVar;
            this.mUserData = this.kOH.getUserData();
            this.kOI.a(this.kOH.getUserData(), this.kOH.cTQ());
            this.kOJ.d(aVar);
        }
    }

    public View getView() {
        return this.kOI.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.kOI != null) {
            this.kOI.onChangeSkinType(i);
        }
    }

    public void cTH() {
        if (this.kOJ != null) {
            this.kOJ.cTH();
        }
    }

    public void Y(Intent intent) {
        if (this.kOJ != null) {
            this.kOJ.Y(intent);
        }
    }

    public void tr(boolean z) {
        this.kOI.tr(z);
    }

    public void KT(String str) {
        if (this.kOI != null) {
            this.kOI.KT(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUc() {
        if (be.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.dUB == null) {
                this.dUB = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
            }
            this.dUB.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.kOI.tq(this.mUserData.isLike() ? false : true);
            ao aoVar = new ao("c13570");
            aoVar.dk("obj_id", this.mUserData.getUserId());
            aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                aoVar.dk("nid", this.mPageContext.getPageActivity().getIntent().getStringExtra("nid"));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), aoVar);
            }
            TiebaStatic.log(aoVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUd() {
        TiebaStatic.log(new ao("c12502").dk("obj_locate", "6"));
        if (this.mIsHost) {
            if (be.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bc.aWU().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (w.getItem(tShowInfo, 0) != null) {
            bc.aWU().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUe() {
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
            mVar.yj(this.mUserData.getBaijiahaoInfo().avatar);
            mVar.yk(this.mUserData.getBaijiahaoInfo().avatar);
            mVar.hY(false);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            mVar.yj(this.mUserData.getPortrait());
            mVar.yk(p.wz(this.mUserData.getPortrait()));
            mVar.hY(true);
        } else {
            mVar.yj(p.wz(this.mUserData.getPortraitH()));
            mVar.yk(p.wz(this.mUserData.getPortrait()));
            mVar.hY(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(mVar);
        this.kOJ.a((q) mVar, (List<q>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUf() {
        if (this.kOH != null && this.kOH.cTQ() != null && !TextUtils.isEmpty(this.kOH.cTQ().goods_url)) {
            bc.aWU().a(this.mPageContext, new String[]{this.kOH.cTQ().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUg() {
        ao aoVar = new ao("c13574");
        aoVar.ag("obj_type", this.mIsHost ? 1 : 0);
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aoVar);
        TiebaStatic.log(new ao("c12502").dk("obj_locate", "10"));
        if (be.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                CA(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().bez() == 1 || equals || (z && this.mUserData.getPersonPrivate().bez() == 2)) {
                TiebaStatic.log(new ao("c11597").ag("obj_locate", 4).ag("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ag("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                CA(this.mUserData.getSex());
            }
        }
    }

    private void CA(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), ar.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aUS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUh() {
        TiebaStatic.log(new ao("c12502").dk("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUi() {
        ao aoVar = new ao("c13575");
        aoVar.ag("obj_type", this.mIsHost ? 1 : 0);
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aoVar);
        TiebaStatic.log(new ao("c12502").dk("obj_locate", "9"));
        if (be.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new ao("c11597").ag("obj_locate", 2).ag("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ag("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUj() {
        ao aoVar = new ao("c13573");
        aoVar.ag("obj_type", this.mIsHost ? 1 : 0);
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(aoVar);
        TiebaStatic.log(new ao("c12502").dk("obj_locate", "8"));
        if (be.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.dar().g(2, false, this.mIsHost);
            TiebaStatic.log(new ao("c11597").ag("obj_locate", 3).ag("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ag("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUk() {
        if (be.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUl() {
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
                if (this.kOH.kNC != null) {
                    personChangeData.setNickNameLeftDays(this.kOH.kNC.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().dPa);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().dPb);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void onDestroy() {
        if (this.kOJ != null) {
            this.kOJ.onDestroy();
        }
        if (this.kOI != null) {
            this.kOI.onDestroy();
        }
    }
}
