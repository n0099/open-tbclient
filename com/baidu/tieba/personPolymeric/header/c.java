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
import com.baidu.searchbox.ugc.model.PublishType;
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
import com.baidu.tbadk.data.e;
import com.baidu.tbadk.data.o;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.b.i;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.BaijiahaoInfo;
/* loaded from: classes24.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a eTC;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private com.baidu.tieba.personPolymeric.c.a mtb;
    private b mtc;
    private i mtd;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String intro;
            if (view == c.this.mtc.dAC()) {
                c.this.dAP();
            } else if (view == c.this.mtc.dAD()) {
                c.this.dAO();
            } else if (view != c.this.mtc.dAE()) {
                if (view == c.this.mtc.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new ar("c12502").dY("obj_locate", "7"));
                        c.this.dAY();
                    }
                } else if (view != c.this.mtc.dAF() && view != c.this.mtc.dAN()) {
                    if (view == c.this.mtc.dAG()) {
                        c.this.dAU();
                    } else if (view == c.this.mtc.dAI()) {
                        c.this.dAV();
                    } else if (view == c.this.mtc.dAH()) {
                        c.this.dAW();
                    } else if (view == c.this.mtc.dAJ()) {
                        c.this.dAT();
                    } else if (view == c.this.mtc.dAK()) {
                        c.this.dAQ();
                    } else if (view == c.this.mtc.dAL()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new ar("c13613").dY("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new ar("c13613").dY("obj_param1", "1"));
                        }
                        c.this.dAR();
                    } else if (view == c.this.mtc.dAM()) {
                        c.this.dAS();
                    }
                } else {
                    TiebaStatic.log(new ar("c12502").dY("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.aX(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.dAY();
                        return;
                    }
                    BaijiahaoInfo baijiahaoInfo = c.this.mUserData.getBaijiahaoInfo();
                    if (baijiahaoInfo == null || au.isEmpty(baijiahaoInfo.auth_desc)) {
                        intro = c.this.mUserData.getIntro();
                    } else {
                        intro = baijiahaoInfo.auth_desc;
                    }
                    PersonIntroductionActivity.aX(c.this.mPageContext.getPageActivity(), intro);
                }
            } else {
                TiebaStatic.log(new ar("c12503").dY("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.dAX();
            }
        }
    };
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                        if (!updateAttentionMessage.getData().fhi) {
                            c.this.mPageContext.showToast(R.string.unlike_success);
                        }
                        c.this.mUserData.setLike(false);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(c.this.mPageContext.getUniqueId())) {
                    c.this.mtc.wF(c.this.mUserData.isLike());
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
        this.mtc = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.eTG);
        this.mtd = new i(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mtb = aVar;
            this.mUserData = this.mtb.getUserData();
            this.mtc.a(this.mtb.getUserData(), this.mtb.dAy());
            this.mtd.d(aVar);
        }
    }

    public View getView() {
        return this.mtc.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.mtc != null) {
            this.mtc.onChangeSkinType(i);
        }
    }

    public void dAp() {
        if (this.mtd != null) {
            this.mtd.dAp();
        }
    }

    public void Y(Intent intent) {
        if (this.mtd != null) {
            this.mtd.Y(intent);
        }
    }

    public void wG(boolean z) {
        this.mtc.wG(z);
    }

    public void Rk(String str) {
        if (this.mtc != null) {
            this.mtc.Rk(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAO() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.eTC == null) {
                this.eTC = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
                this.eTC.jL(true);
            }
            this.eTC.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.mtc.wF(this.mUserData.isLike() ? false : true);
            ar arVar = new ar("c13570");
            arVar.dY("obj_id", this.mUserData.getUserId());
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getIntent() != null) {
                arVar.dY("nid", this.mPageContext.getPageActivity().getIntent().getStringExtra("nid"));
            }
            if (this.mPageContext != null) {
                com.baidu.tbadk.pageInfo.c.b(this.mPageContext.getPageActivity(), arVar);
            }
            if (this.mPageContext != null && this.mPageContext.getPageActivity() != null && com.baidu.tbadk.pageInfo.c.eY(this.mPageContext.getPageActivity()) != null && com.baidu.tbadk.pageInfo.c.eY(this.mPageContext.getPageActivity()).getPrePageTag() != null && !TextUtils.isEmpty(com.baidu.tbadk.pageInfo.c.eY(this.mPageContext.getPageActivity()).getPrePageTag().locatePage) && PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE.equals(com.baidu.tbadk.pageInfo.c.eY(this.mPageContext.getPageActivity()).getPrePageTag().locatePage)) {
                arVar.dY("obj_pre_page", com.baidu.tbadk.pageInfo.c.eY(this.mPageContext.getPageActivity()).getPrePageTag().locatePage);
                arVar.dY("obj_cur_page", PageStayDurationConstants.PageName.PERSON);
            }
            TiebaStatic.log(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAP() {
        TiebaStatic.log(new ar("c12502").dY("obj_locate", "6"));
        if (this.mIsHost) {
            if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                bf.bua().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (y.getItem(tShowInfo, 0) != null) {
            bf.bua().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAQ() {
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
            oVar.DC(this.mUserData.getBaijiahaoInfo().avatar);
            oVar.DD(this.mUserData.getBaijiahaoInfo().avatar);
            oVar.kk(true);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            oVar.DC(this.mUserData.getPortrait());
            oVar.DD(q.BR(this.mUserData.getPortrait()));
            oVar.kk(true);
        } else {
            oVar.DC(q.BR(this.mUserData.getPortraitH()));
            oVar.DD(q.BR(this.mUserData.getPortrait()));
            oVar.kk(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar);
        this.mtd.a((com.baidu.adp.widget.ListView.q) oVar, (List<com.baidu.adp.widget.ListView.q>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAR() {
        if (this.mtb != null && this.mtb.dAy() != null && !TextUtils.isEmpty(this.mtb.dAy().goods_url)) {
            bf.bua().a(this.mPageContext, new String[]{this.mtb.dAy().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAS() {
        if (this.mUserData != null && this.mUserData.getLiveRoomInfo() != null && !TextUtils.isEmpty(this.mUserData.getLiveRoomInfo().jump_url)) {
            bf.bua().a(this.mPageContext, new String[]{this.mUserData.getLiveRoomInfo().jump_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAT() {
        ar arVar = new ar("c13574");
        arVar.al("obj_type", this.mIsHost ? 1 : 0);
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        TiebaStatic.log(new ar("c12502").dY("obj_locate", "10"));
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                Ix(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().bBH() == 1 || equals || (z && this.mUserData.getPersonPrivate().bBH() == 2)) {
                TiebaStatic.log(new ar("c11597").al("obj_locate", 4).al("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).al("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                Ix(this.mUserData.getSex());
            }
        }
    }

    private void Ix(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), au.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).brB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAU() {
        TiebaStatic.log(new ar("c12502").dY("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAV() {
        ar arVar = new ar("c13575");
        arVar.al("obj_type", this.mIsHost ? 1 : 0);
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        TiebaStatic.log(new ar("c12502").dY("obj_locate", PublishType.TYPE_VIDEO_SHARE));
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new ar("c11597").al("obj_locate", 2).al("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).al("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAW() {
        ar arVar = new ar("c13573");
        arVar.al("obj_type", this.mIsHost ? 1 : 0);
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        TiebaStatic.log(new ar("c12502").dY("obj_locate", "8"));
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.q.a.dGN().h(2, false, this.mIsHost);
            TiebaStatic.log(new ar("c11597").al("obj_locate", 3).al("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).al("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAX() {
        if (bh.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAY() {
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
                if (this.mtb.mrG != null) {
                    personChangeData.setNickNameLeftDays(this.mtb.mrG.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().eMU);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().eMV);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void a(com.baidu.tieba.personPolymeric.b.a aVar) {
        this.mtc.a(aVar);
    }

    public FollowUserSpinnerBtn dAZ() {
        return this.mtc.dAD();
    }

    public void dAA() {
        this.mtc.dAA();
    }

    public void dAB() {
        this.mtc.dAB();
    }

    public void wH(boolean z) {
        this.mtc.wE(z);
    }

    public void onDestroy() {
        if (this.mtd != null) {
            this.mtd.onDestroy();
        }
        if (this.mtc != null) {
            this.mtc.onDestroy();
        }
    }
}
