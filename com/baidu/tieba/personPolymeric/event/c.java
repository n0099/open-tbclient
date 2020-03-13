package com.baidu.tieba.personPolymeric.event;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.personPolymeric.b.f;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes11.dex */
public class c extends a {
    private f jom;

    public c(TbPageContext tbPageContext, f fVar) {
        super(tbPageContext);
        this.jom = fVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0151, code lost:
        if (r0.equalsIgnoreCase(r2.getPersonalBgUrl()) == false) goto L54;
     */
    @Override // com.baidu.tieba.personPolymeric.event.a, com.baidu.tieba.view.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(View view, com.baidu.tieba.g.a aVar) {
        UserData userData;
        String str;
        int i;
        int i2 = 1;
        super.a(view, aVar);
        if (aVar != null) {
            if (aVar.gaF == null) {
                userData = null;
            } else {
                userData = (UserData) aVar.gaF.getSerializable(UserData.TYPE_USER);
            }
            switch (aVar.gaE) {
                case 1:
                    if (userData != null) {
                        n nVar = new n();
                        if (!StringUtils.isNull(userData.getPortrait()) && userData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            nVar.uU(userData.getPortrait());
                        } else {
                            nVar.uU(userData.getPortraitH());
                        }
                        nVar.uV(userData.getPortrait());
                        nVar.gu(true);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(nVar);
                        this.jom.cwP().a((m) nVar, (List<m>) arrayList, 0);
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 18:
                case 19:
                case 23:
                case 25:
                case 26:
                case 28:
                case 35:
                case 37:
                default:
                    return;
                case 8:
                    this.mPageContext.getPageActivity().finish();
                    return;
                case 9:
                    if (this.jom != null && this.jom.cwO() != null) {
                        TiebaStatic.log("c12207");
                        this.jom.cwO().cwU();
                        return;
                    }
                    return;
                case 10:
                    String str2 = null;
                    if (userData == null) {
                        str = "";
                        i = -1;
                    } else {
                        str = userData.getUserId();
                        String bg_pic = userData.getBg_pic();
                        try {
                            i = com.baidu.adp.lib.f.b.toInt(GU(bg_pic).get("props_id"), -1);
                            str2 = bg_pic;
                        } catch (URISyntaxException e) {
                            str2 = bg_pic;
                            i = -1;
                        }
                    }
                    if (i == -1 || str.equals(TbadkCoreApplication.getCurrentAccount())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(this.mPageContext.getPageActivity())));
                        return;
                    }
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        if (!StringUtils.isNull(str2) && !StringUtils.isNull(currentAccountInfo.getPersonalBgUrl())) {
                            break;
                        } else {
                            i2 = 0;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.mPageContext.getPageActivity(), i, i2)));
                        return;
                    }
                    i2 = 0;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.mPageContext.getPageActivity(), i, i2)));
                    return;
                case 11:
                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        PersonChangeData personChangeData = new PersonChangeData();
                        if (userData != null) {
                            personChangeData.setPortrait(userData.getPortrait());
                            personChangeData.setName(userData.getUserName());
                            personChangeData.setSex(userData.getSex());
                            personChangeData.setIntro(userData.getIntro());
                            personChangeData.setNameShow(userData.getName_show());
                            personChangeData.setMem(userData.getIsMem());
                            personChangeData.setCanModifyAvatar(userData.canModifyAvatar());
                            personChangeData.setCantModifyAvatarDesc(userData.getCantModifyAvatarDesc());
                            if (aVar.gaF != null) {
                                personChangeData.setNickNameLeftDays(aVar.gaF.getInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, -1));
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
                        return;
                    }
                    return;
                case 12:
                    if (userData != null) {
                        TiebaStatic.log("igift_icon_ck");
                        if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), userData.getUserIdLong(), userData.getUserName(), userData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, RequestResponseCode.REQUEST_MEMBER_GIFT);
                            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
                            return;
                        }
                        return;
                    }
                    return;
                case 13:
                    ba.aGG().b(this.mPageContext, new String[]{TbConfig.WEB_URL_FANS});
                    return;
                case 14:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 15:
                    zZ(8);
                    if (userData != null && userData.membershipInfo != null) {
                        String str3 = userData.membershipInfo.mLink;
                        if (!StringUtils.isNull(str3)) {
                            ba.aGG().b(this.mPageContext, new String[]{str3});
                            return;
                        }
                        return;
                    }
                    return;
                case 16:
                    zZ(7);
                    com.baidu.tieba.p.a.cDQ().g(7, false, this.isHost);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 17:
                    zZ(12);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ConsumptionRecordsActivityConfig(TbadkCoreApplication.getInst().getApplicationContext())));
                    return;
                case 20:
                    zZ(2);
                    com.baidu.tieba.p.a.cDQ().g(3, false, this.isHost);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mPageContext.getPageActivity())));
                    return;
                case 21:
                    zZ(5);
                    TiebaStatic.log(new an("c11590").X("obj_locate", 2).X("obj_source", this.userType));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 22:
                    TiebaStatic.log(new an("c11590").X("obj_locate", 3).X("obj_source", this.userType));
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissonDetailsActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_PHOTO_LIVE_TO_MISSON_DETAILS, userData.getAnchorLevel(), userData.getPortrait(), userData.getName_show(), "from_person")));
                        return;
                    }
                    return;
                case 24:
                    zZ(3);
                    com.baidu.tieba.p.a.cDQ().g(4, false, this.isHost);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 27:
                    zZ(10);
                    TiebaStatic.log(new an("c11948"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 29:
                    if (userData != null) {
                        zZ(6);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getPortrait(), userData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    zZ(1);
                    com.baidu.tieba.p.a.cDQ().g(8, false, this.isHost);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 31:
                    zZ(9);
                    ba.aGG().a(this.mPageContext, new String[]{aVar.gaF.getString("book_jump_link")}, true);
                    return;
                case 32:
                    if (bc.checkUpIsLogin(this.mPageContext.getPageActivity())) {
                        zZ(4);
                        com.baidu.tieba.p.a.cDQ().g(1, false, this.isHost);
                        if (userData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getName_show(), userData.getSex(), "iowner_gift")));
                            return;
                        }
                        return;
                    }
                    return;
                case 33:
                    zZ(11);
                    ba.aGG().a(this.mPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 34:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_BIG_V_TO_EDIT_MODE, false));
                    return;
                case 36:
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getName_show(), userData.getSex())));
                        return;
                    }
                    return;
                case 38:
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), userData.getSex(), false)));
                        return;
                    }
                    return;
                case 39:
                    com.baidu.tbadk.browser.a.startWebActivity(this.mPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 40:
                    if (userData != null && bc.checkUpIsLogin(this.mPageContext.getPageActivity()) && userData != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        try {
                            TiebaStatic.log(new an("c11593"));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.mPageContext.getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex(), userData.getIsFriend(), userData.getUserType())));
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 41:
                    if (userData != null && userData.getBaijiahaoInfo() != null) {
                        n nVar2 = new n();
                        nVar2.uU(userData.getBaijiahaoInfo().avatar_h);
                        nVar2.uV(userData.getBaijiahaoInfo().avatar);
                        nVar2.gu(false);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(nVar2);
                        if (this.jom.cwP() != null) {
                            this.jom.cwP().a((m) nVar2, (List<m>) arrayList2, 0, true);
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    }

    private void zZ(int i) {
        TiebaStatic.log(new an(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).X("obj_locate", i));
    }

    private Map<String, String> GU(final String str) throws URISyntaxException {
        return new HashMap<String, String>() { // from class: com.baidu.tieba.personPolymeric.event.PersonPolymericEventController$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }
}
