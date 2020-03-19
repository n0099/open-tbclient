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
/* loaded from: classes11.dex */
public class c {
    private com.baidu.tbadk.coreExtra.model.a dap;
    private com.baidu.tieba.personPolymeric.c.a jrt;
    private b jru;
    private h jrv;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == c.this.jru.cxC()) {
                c.this.cxO();
            } else if (view == c.this.jru.cxD()) {
                c.this.cxN();
            } else if (view != c.this.jru.cxE()) {
                if (view == c.this.jru.getUserName()) {
                    if (c.this.mIsHost) {
                        TiebaStatic.log(new an("c12502").cx("obj_locate", "7"));
                        c.this.cxW();
                    }
                } else if (view != c.this.jru.cxF() && view != c.this.jru.cxM()) {
                    if (view == c.this.jru.cxG()) {
                        c.this.cxS();
                    } else if (view == c.this.jru.cxI()) {
                        c.this.cxT();
                    } else if (view == c.this.jru.cxH()) {
                        c.this.cxU();
                    } else if (view == c.this.jru.cxJ()) {
                        c.this.cxR();
                    } else if (view == c.this.jru.cxK()) {
                        c.this.cxP();
                    } else if (view == c.this.jru.cxL()) {
                        if (c.this.mIsHost) {
                            TiebaStatic.log(new an("c13613").cx("obj_param1", "0"));
                        } else {
                            TiebaStatic.log(new an("c13613").cx("obj_param1", "1"));
                        }
                        c.this.cxQ();
                    }
                } else {
                    TiebaStatic.log(new an("c12502").cx("obj_locate", "14"));
                    if (c.this.mIsHost) {
                        if (c.this.mUserData != null && c.this.mUserData.isBaijiahaoUser()) {
                            PersonIntroductionActivity.bc(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                        }
                        c.this.cxW();
                        return;
                    }
                    PersonIntroductionActivity.bc(c.this.mPageContext.getPageActivity(), c.this.mUserData.getIntro());
                }
            } else {
                TiebaStatic.log(new an("c12503").cx("obj_locate", "3"));
                TiebaStatic.log("igift_icon_ck");
                c.this.cxV();
            }
        }
    };
    private CustomMessageListener dat = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.personPolymeric.header.c.2
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
                    c.this.jru.rA(c.this.mUserData.isLike());
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
        this.jru = new b(this.mPageContext, this.mIsHost, this.mClickListener);
        this.mPageContext.registerListener(this.dat);
        this.jrv = new h(this.mPageContext, this.mPageContext.getUniqueId(), z);
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.jrt = aVar;
            this.mUserData = this.jrt.getUserData();
            this.jru.a(this.jrt.getUserData(), this.jrt.cxA());
            this.jrv.d(aVar);
        }
    }

    public View getView() {
        return this.jru.getView();
    }

    public void onChangeSkinType(int i) {
        if (this.jru != null) {
            this.jru.onChangeSkinType(i);
        }
    }

    public void cxr() {
        if (this.jrv != null) {
            this.jrv.cxr();
        }
    }

    public void ap(Intent intent) {
        if (this.jrv != null) {
            this.jrv.ap(intent);
        }
    }

    public void rB(boolean z) {
        this.jru.rB(z);
    }

    public void GV(String str) {
        if (this.jru != null) {
            this.jru.GV(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxN() {
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            if (this.dap == null) {
                this.dap = new com.baidu.tbadk.coreExtra.model.a(this.mPageContext);
            }
            this.dap.a(!this.mUserData.isLike(), this.mUserData.getPortrait(), this.mUserData.getUserId(), this.mUserData.isGod(), "2", this.mPageContext.getUniqueId(), null, "0");
            this.jru.rA(this.mUserData.isLike() ? false : true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxO() {
        TiebaStatic.log(new an("c12502").cx("obj_locate", "6"));
        if (this.mIsHost) {
            if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                ba.aGK().b(this.mPageContext, new String[]{TbConfig.URL_MEMBER_BUY});
                return;
            }
            return;
        }
        ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
        if (v.getItem(tShowInfo, 0) != null) {
            ba.aGK().b(this.mPageContext, new String[]{tShowInfo.get(0).getUrl()});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxP() {
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
            nVar.uU(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.uV(this.mUserData.getBaijiahaoInfo().avatar);
            nVar.gv(false);
        } else if (!StringUtils.isNull(this.mUserData.getPortrait()) && this.mUserData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            nVar.uU(this.mUserData.getPortrait());
            nVar.uV(o.tn(this.mUserData.getPortrait()));
            nVar.gv(true);
        } else {
            nVar.uU(o.tn(this.mUserData.getPortraitH()));
            nVar.uV(o.tn(this.mUserData.getPortrait()));
            nVar.gv(true);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(nVar);
        this.jrv.a((m) nVar, (List<m>) arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxQ() {
        if (this.jrt != null && this.jrt.cxA() != null && !TextUtils.isEmpty(this.jrt.cxA().goods_url)) {
            ba.aGK().a(this.mPageContext, new String[]{this.jrt.cxA().goods_url}, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxR() {
        an anVar = new an("c13574");
        anVar.X("obj_type", this.mIsHost ? 1 : 0);
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").cx("obj_locate", "10"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(this.mUserData.getUserId());
            boolean z = this.mUserData.getIsFriend() == 1;
            if (this.mUserData.getPersonPrivate() == null) {
                Ak(this.mUserData.getSex());
            } else if (this.mUserData.getPersonPrivate().aNT() == 1 || equals || (z && this.mUserData.getPersonPrivate().aNT() == 2)) {
                TiebaStatic.log(new an("c11597").X("obj_locate", 4).X("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).X("obj_source", this.mUserData.isGod() ? 1 : 2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonBarActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getLike_bars(), this.mUserData.getUserId(), this.mUserData.getSex())));
            } else {
                Ak(this.mUserData.getSex());
            }
        }
    }

    private void Ak(int i) {
        BdToast.a((Context) this.mPageContext.getPageActivity(), (CharSequence) String.format(this.mPageContext.getString(R.string.person_privacy_toast), aq.getUserDescByGender(i)), (int) R.drawable.icon_pure_toast_mistake40_svg, true).aEL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxS() {
        TiebaStatic.log(new an("c12502").cx("obj_locate", "4"));
        com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), this.mPageContext.getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + this.mUserData.getUserId(), true, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxT() {
        an anVar = new an("c13575");
        anVar.X("obj_type", this.mIsHost ? 1 : 0);
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").cx("obj_locate", "9"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new an("c11597").X("obj_locate", 2).X("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).X("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), true, this.mUserData.getUserId(), this.mUserData.getSex()).updateFollowNum(this.mUserData.getConcernNum(), this.mUserData.getPortrait())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxU() {
        an anVar = new an("c13573");
        anVar.X("obj_type", this.mIsHost ? 1 : 0);
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        TiebaStatic.log(new an("c12502").cx("obj_locate", "8"));
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            com.baidu.tieba.p.a.cEk().g(2, false, this.mIsHost);
            TiebaStatic.log(new an("c11597").X("obj_locate", 3).X("obj_type", TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.mUserData.getUserId()) ? 1 : 2).X("obj_source", this.mUserData.isGod() ? 1 : 2));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(this.mPageContext.getPageActivity(), false, this.mUserData.getUserId(), this.mUserData.getSex())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxV() {
        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), this.mUserData.getUserIdLong(), this.mUserData.getUserName(), this.mUserData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxW() {
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
                if (this.jrt.jqo != null) {
                    personChangeData.setNickNameLeftDays(this.jrt.jqo.left_days.intValue());
                }
                if (this.mUserData.getBirthdayInfo() != null) {
                    personChangeData.setUserAge(this.mUserData.getBirthdayInfo().age);
                    personChangeData.setBirthdayTime(this.mUserData.getBirthdayInfo().cVa);
                    personChangeData.setBirthdayShowStatus(this.mUserData.getBirthdayInfo().cVb);
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
        }
    }

    public void onDestroy() {
        if (this.jrv != null) {
            this.jrv.onDestroy();
        }
        if (this.jru != null) {
            this.jru.onDestroy();
        }
    }
}
