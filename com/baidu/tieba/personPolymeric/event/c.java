package com.baidu.tieba.personPolymeric.event;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelListActivityConfig;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.personPolymeric.b.e;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class c extends a {
    private e hQW;
    private com.baidu.tieba.personPolymeric.b.a hQw;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(e eVar) {
        this.hQW = eVar;
        if (this.hQW != null) {
            this.hQw = this.hQW.bRM();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0151, code lost:
        if (r0.equalsIgnoreCase(r2.getPersonalBgUrl()) == false) goto L54;
     */
    @Override // com.baidu.tieba.personPolymeric.event.a, com.baidu.tieba.view.g
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
            if (aVar.eHm == null) {
                userData = null;
            } else {
                userData = (UserData) aVar.eHm.getSerializable(UserData.TYPE_USER);
            }
            switch (aVar.eHl) {
                case 1:
                    if (userData != null) {
                        m mVar = new m();
                        if (!StringUtils.isNull(userData.getPortrait()) && userData.getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            mVar.oy(userData.getPortrait());
                        } else {
                            mVar.oy(userData.getPortraitH());
                        }
                        mVar.oz(userData.getPortrait());
                        mVar.eA(true);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(mVar);
                        this.hQW.bRN().a((com.baidu.adp.widget.ListView.m) mVar, (List<com.baidu.adp.widget.ListView.m>) arrayList, 0);
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
                case 37:
                case 39:
                default:
                    return;
                case 8:
                    this.mPageContext.getPageActivity().finish();
                    return;
                case 9:
                    if (this.hQw != null && this.hQw.bRG() != null) {
                        TiebaStatic.log("c12207");
                        this.hQw.bRG().bRT();
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
                            i = com.baidu.adp.lib.g.b.l(AJ(bg_pic).get("props_id"), -1);
                            str2 = bg_pic;
                        } catch (URISyntaxException e) {
                            str2 = bg_pic;
                            i = -1;
                        }
                    }
                    if (i == -1 || str.equals(TbadkCoreApplication.getCurrentAccount())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(this.mPageContext.getPageActivity())));
                        return;
                    }
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        if (!StringUtils.isNull(str2) && !StringUtils.isNull(currentAccountInfo.getPersonalBgUrl())) {
                            break;
                        } else {
                            i2 = 0;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackgroundPreviewActivityConfig(this.mPageContext.getPageActivity(), i, i2)));
                        return;
                    }
                    i2 = 0;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackgroundPreviewActivityConfig(this.mPageContext.getPageActivity(), i, i2)));
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
                            if (aVar.eHm != null) {
                                personChangeData.setNickNameLeftDays(aVar.eHm.getInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, -1));
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonChangeActivityConfig(this.mPageContext.getPageActivity(), 101, personChangeData, false)));
                        return;
                    }
                    return;
                case 12:
                    if (userData != null) {
                        TiebaStatic.log("igift_icon_ck");
                        if (bc.cZ(this.mPageContext.getPageActivity())) {
                            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mPageContext.getPageActivity(), userData.getUserIdLong(), userData.getUserName(), userData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
                            giftTabActivityConfig.setReferPageAndClickZone("he/her_personal_center_V8.9", "T_recharge_V8.9");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
                            return;
                        }
                        return;
                    }
                    return;
                case 13:
                    ba.adA().c(this.mPageContext, new String[]{TbConfig.WEB_URL_FANS});
                    return;
                case 14:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
                    return;
                case 15:
                    xd(8);
                    if (userData != null && userData.membershipInfo != null) {
                        String str3 = userData.membershipInfo.mLink;
                        if (!StringUtils.isNull(str3)) {
                            ba.adA().c(this.mPageContext, new String[]{str3});
                            return;
                        }
                        return;
                    }
                    return;
                case 16:
                    xd(7);
                    com.baidu.tieba.o.a.bXS().d(7, false, this.isHost);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 17:
                    xd(12);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ConsumptionRecordsActivityConfig(TbadkCoreApplication.getInst().getApplicationContext())));
                    return;
                case 20:
                    xd(2);
                    com.baidu.tieba.o.a.bXS().d(3, false, this.isHost);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mPageContext.getPageActivity())));
                    return;
                case 21:
                    xd(5);
                    TiebaStatic.log(new am("c11590").T("obj_locate", 2).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 22:
                    TiebaStatic.log(new am("c11590").T("obj_locate", 3).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MissonDetailsActivityConfig(this.mPageContext.getPageActivity(), 24004, userData.getAnchorLevel(), userData.getPortrait(), userData.getName_show(), "from_person")));
                        return;
                    }
                    return;
                case 24:
                    xd(3);
                    com.baidu.tieba.o.a.bXS().d(4, false, this.isHost);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001185));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddressListActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 27:
                    xd(10);
                    TiebaStatic.log(new am("c11948"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BigImgPbActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 29:
                    if (userData != null) {
                        xd(6);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getPortrait(), userData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(ChannelHomeActivityConfig.class)) {
                        xd(7);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(this.mPageContext.getPageActivity(), 4)));
                        return;
                    }
                    return;
                case 31:
                    if (userData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(ChannelListActivityConfig.class)) {
                        TiebaStatic.log(new am("c11955"));
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelListActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId())));
                        return;
                    }
                    return;
                case 32:
                    xd(1);
                    com.baidu.tieba.o.a.bXS().d(8, false, this.isHost);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.mPageContext.getPageActivity())));
                    return;
                case 33:
                    xd(9);
                    ba.adA().a(this.mPageContext, new String[]{aVar.eHm.getString("book_jump_link")}, true);
                    return;
                case 34:
                    if (bc.cZ(this.mPageContext.getPageActivity())) {
                        xd(4);
                        com.baidu.tieba.o.a.bXS().d(1, false, this.isHost);
                        if (userData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getName_show(), userData.getSex(), "iowner_gift")));
                            return;
                        }
                        return;
                    }
                    return;
                case 35:
                    xd(11);
                    ba.adA().a(this.mPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 36:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921008, false));
                    return;
                case 38:
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getName_show(), userData.getSex())));
                        return;
                    }
                    return;
                case 40:
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mPageContext.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), userData.getSex(), false)));
                        return;
                    }
                    return;
                case 41:
                    com.baidu.tbadk.browser.a.ar(this.mPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 42:
                    if (userData != null && bc.cZ(this.mPageContext.getPageActivity()) && userData != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        try {
                            TiebaStatic.log(new am("c11593"));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.mPageContext.getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex(), userData.getIsFriend(), userData.getUserType())));
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
            }
        }
    }

    private void xd(int i) {
        TiebaStatic.log(new am("c12044").T("obj_locate", i));
    }

    private Map<String, String> AJ(final String str) throws URISyntaxException {
        return new HashMap<String, String>() { // from class: com.baidu.tieba.personPolymeric.event.PersonPolymericEventController$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), HTTP.UTF_8)) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }
}
