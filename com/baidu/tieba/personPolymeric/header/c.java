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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes18.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a eaU;
    private com.baidu.tieba.personPolymeric.c.a kXF;
    private b kXG;
    private h kXH;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.kXG.cXH()) {
                c.this.cXT();
            } else if (view == c.this.kXG.cXI()) {
                c.this.cXS();
            } else if (view != c.this.kXG.cXJ()) {
                if (view == c.this.kXG.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new ap("c12502").dn("obj_locate", "7"));
                        c.this.cYb();
                    }
                } else if (view != c.this.kXG.cXK() && view != c.this.kXG.cXR()) {
                    if (view == c.this.kXG.cXL()) {
                        c.this.cXX();
                    } else if (view == c.this.kXG.cXN()) {
                        c.this.cXY();
                    } else if (view == c.this.kXG.cXM()) {
                        c.this.cXZ();
                    } else if (view == c.this.kXG.cXO()) {
                        c.this.cXW();
                    } else if (view == c.this.kXG.cXP()) {
                        c.this.cXU();
                    } else if (view == c.this.kXG.cXQ()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new ap("c13613").dn("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new ap("c13613").dn("obj_param1", "1"));
                        }
                        c.this.cXV();
                    }
                } else {
                    TiebaStatic.log(new ap("c12502").dn("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aL(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.cYb();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || as.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.aL(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new ap("c12503").dn("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.cYa();
            }
        }
    };
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                    c.this.kXG.tW(c.this.mUserData.isLike());
                    if (updateAttentionMessage.getData() == null || as.isEmpty(updateAttentionMessage.getData().errorString)) {
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
        this.kXG = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.eaY);
        this.kXH = new h(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.kXF = aVar;
            this.mUserData = this.kXF.getUserData();
            this.kXG.a(this.kXF.getUserData(), this.kXF.cXG());
            this.kXH.d(aVar);
        }
    }

    public View getView() {
        return this.kXG.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.kXG != null) {
            this.kXG.onChangeSkinType(i);
        }
    }

    public void cXx() {
        if (this.kXH != null) {
            this.kXH.cXx();
        }
    }

    public void Z(Intent intent) {
        if (this.kXH != null) {
            this.kXH.Z(intent);
        }
    }

    public void tX(boolean z) {
        this.kXG.tX(z);
    }

    public void LH(String str) {
        if (this.kXG != null) {
            this.kXG.LH(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXS() {
        if (bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.eaU == null) {
                this.eaU = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
            }
            this.eaU.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.kXG.tW(this.mUserData.isLike() ? false : true);
            ap apVar = new ap("c13570");
            apVar.dn("obj_id", this.mUserData.getUserId());
            apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                apVar.dn("nid", this.mPageContext.getPageActivity().getIntent().getStringExtra("nid"));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), apVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.ea(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.ea(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.ea(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.ea(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                apVar.dn("obj_pre_page", com.baidu.tbadk.pageInfo.c.ea(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                apVar.dn("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(apVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXT() {
        TiebaStatic.log(new ap("c12502").dn("obj_locate", "6"));
        if (this.mIsHost) {
            if (bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bd.baV().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (x.getItem(tShowInfo, 0) != null) {
            bd.baV().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXU() {
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
            mVar.zp(this.mUserData.getBaijiahaoInfo().avatar);
            mVar.zq(this.mUserData.getBaijiahaoInfo().avatar);
            mVar.iC(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            mVar.zp(this.mUserData.getPortrait());
            mVar.zq(q.xH(this.mUserData.getPortrait()));
            mVar.iC(true);
        } else {
            mVar.zp(q.xH(this.mUserData.getPortraitH()));
            mVar.zq(q.xH(this.mUserData.getPortrait()));
            mVar.iC(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(mVar);
        this.kXH.a((com.baidu.adp.widget.ListView.q) mVar, (List<com.baidu.adp.widget.ListView.q>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXV() {
        if (this.kXF != null && this.kXF.cXG() != null && !TextUtils.isEmpty(this.kXF.cXG().goods_url)) {
            bd.baV().a(this.mPageContext, new String[]{this.kXF.cXG().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXW() {
        ap apVar = new ap("c13574");
        apVar.ah("obj_type", this.mIsHost ? 1 : 0);
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(apVar);
        TiebaStatic.log(new ap("c12502").dn("obj_locate", "10"));
        if (bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                Da(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().bii() == 1 || equals || (z && this.mUserData.getPersonPrivate().bii() == 2)) {
                TiebaStatic.log(new ap("c11597").ah("obj_locate", 4).ah("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ah("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                Da(this.mUserData.getSex());
            }
        }
    }

    private void Da(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), as.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).aYR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXX() {
        TiebaStatic.log(new ap("c12502").dn("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXY() {
        ap apVar = new ap("c13575");
        apVar.ah("obj_type", this.mIsHost ? 1 : 0);
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(apVar);
        TiebaStatic.log(new ap("c12502").dn("obj_locate", "9"));
        if (bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new ap("c11597").ah("obj_locate", 2).ah("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ah("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXZ() {
        ap apVar = new ap("c13573");
        apVar.ah("obj_type", this.mIsHost ? 1 : 0);
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(apVar);
        TiebaStatic.log(new ap("c12502").dn("obj_locate", "8"));
        if (bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.ddy().g(2, false, this.mIsHost);
            TiebaStatic.log(new ap("c11597").ah("obj_locate", 3).ah("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).ah("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYa() {
        if (bf.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYb() {
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
                if (this.kXF.kWC != null) {
                    personChangeData.setNickNameLeftDays(this.kXF.kWC.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().dVm);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().dVn);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void onDestroy() {
        if (this.kXH != null) {
            this.kXH.onDestroy();
        }
        if (this.kXG != null) {
            this.kXG.onDestroy();
        }
    }
}
