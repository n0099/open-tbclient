package com.baidu.tieba.personPolymeric.event;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.b.e;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.f.a {
    private e ffL;
    private com.baidu.tieba.personPolymeric.b.a ffj;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(e eVar) {
        this.ffL = eVar;
        if (this.ffL != null) {
            this.ffj = this.ffL.aWy();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0130, code lost:
        if (r0.equalsIgnoreCase(r2.getPersonalBgUrl()) == false) goto L48;
     */
    @Override // com.baidu.tieba.f.a, com.baidu.tieba.view.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(View view, com.baidu.tieba.f.b bVar) {
        UserData userData;
        String str;
        int i;
        int i2 = 1;
        super.a(view, bVar);
        if (bVar != null) {
            if (bVar.ceJ == null) {
                userData = null;
            } else {
                userData = (UserData) bVar.ceJ.getSerializable(UserData.TYPE_USER);
            }
            switch (bVar.ceI) {
                case 1:
                    if (userData != null) {
                        j jVar = new j();
                        jVar.fn(userData.getPortraitH());
                        jVar.fo(userData.getPortrait());
                        jVar.bu(true);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(jVar);
                        this.ffL.aWz().a((f) jVar, (List<f>) arrayList, 0);
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
                case d.n.View_longClickable /* 37 */:
                case d.n.View_filterTouchesWhenObscured /* 39 */:
                default:
                    return;
                case 8:
                    this.mH.getPageActivity().finish();
                    return;
                case 9:
                    if (this.ffj != null && this.ffj.aWr() != null) {
                        TiebaStatic.log("c12207");
                        this.ffj.aWr().aWF();
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
                            i = com.baidu.adp.lib.g.b.g(pB(bg_pic).get("props_id"), -1);
                            str2 = bg_pic;
                        } catch (URISyntaxException e) {
                            str2 = bg_pic;
                            i = -1;
                        }
                    }
                    if (i == -1 || str.equals(TbadkCoreApplication.getCurrentAccount())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(this.mH.getPageActivity())));
                        return;
                    }
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        if (!StringUtils.isNull(str2) && !StringUtils.isNull(currentAccountInfo.getPersonalBgUrl())) {
                            break;
                        } else {
                            i2 = 0;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.mH.getPageActivity(), i, i2)));
                        return;
                    }
                    i2 = 0;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.mH.getPageActivity(), i, i2)));
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
                            if (bVar.ceJ != null) {
                                personChangeData.setNickNameLeftDays(bVar.ceJ.getInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, -1));
                            }
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.mH.getPageActivity(), 101, personChangeData, false)));
                        return;
                    }
                    return;
                case 12:
                    if (userData != null) {
                        TiebaStatic.log("igift_icon_ck");
                        if (ax.aT(this.mH.getPageActivity())) {
                            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(this.mH.getPageActivity(), userData.getUserIdLong(), userData.getUserName(), userData.getName_show(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001);
                            giftTabActivityConfig.setReferPageAndClickZone("he/her_personal_center_V8.9", "T_recharge_V8.9");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
                            return;
                        }
                        return;
                    }
                    return;
                case 13:
                    av.vA().c(this.mH, new String[]{TbConfig.WEB_URL_FANS});
                    return;
                case 14:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mH.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 15:
                    qo(8);
                    if (userData != null && userData.membershipInfo != null) {
                        String str3 = userData.membershipInfo.mLink;
                        if (!StringUtils.isNull(str3)) {
                            av.vA().c(this.mH, new String[]{str3});
                            return;
                        }
                        return;
                    }
                    return;
                case 16:
                    qo(7);
                    com.baidu.tieba.j.a.bgJ().b(7, false, this.isHost);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.mH.getPageActivity())));
                    return;
                case 17:
                    qo(12);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ConsumptionRecordsActivityConfig(TbadkCoreApplication.getInst().getApplicationContext())));
                    return;
                case 20:
                    qo(2);
                    com.baidu.tieba.j.a.bgJ().b(3, false, this.isHost);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mH.getPageActivity())));
                    return;
                case 21:
                    qo(5);
                    TiebaStatic.log(new ak("c11590").r("obj_locate", 2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mH.getPageActivity())));
                    return;
                case 22:
                    TiebaStatic.log(new ak("c11590").r("obj_locate", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissonDetailsActivityConfig(this.mH.getPageActivity(), 24004, userData.getAnchorLevel(), userData.getPortrait(), userData.getName_show(), MissonDetailsActivityConfig.FROM_PERSON)));
                        return;
                    }
                    return;
                case 24:
                    qo(3);
                    com.baidu.tieba.j.a.bgJ().b(4, false, this.isHost);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(this.mH.getPageActivity())));
                    return;
                case 27:
                    qo(10);
                    TiebaStatic.log(new ak("c11948"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.mH.getPageActivity())));
                    return;
                case 29:
                    if (userData != null) {
                        qo(6);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mH.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getPortrait(), userData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    if (TbadkCoreApplication.getInst().appResponseToIntentClass(ChannelHomeActivityConfig.class)) {
                        qo(7);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.mH.getPageActivity(), 4)));
                        return;
                    }
                    return;
                case 31:
                    if (userData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(ChannelListActivityConfig.class)) {
                        TiebaStatic.log(new ak("c11955"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelListActivityConfig(this.mH.getPageActivity(), userData.getUserId())));
                        return;
                    }
                    return;
                case 32:
                    qo(1);
                    com.baidu.tieba.j.a.bgJ().b(8, false, this.isHost);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(this.mH.getPageActivity())));
                    return;
                case 33:
                    qo(9);
                    av.vA().a(this.mH, new String[]{bVar.ceJ.getString("book_jump_link")}, true);
                    return;
                case 34:
                    if (ax.aT(this.mH.getPageActivity())) {
                        qo(4);
                        com.baidu.tieba.j.a.bgJ().b(1, false, this.isHost);
                        if (userData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mH.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getName_show(), userData.getSex(), "iowner_gift")));
                            return;
                        }
                        return;
                    }
                    return;
                case 35:
                    qo(11);
                    av.vA().a(this.mH, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case d.n.View_clickable /* 36 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_BIG_V_TO_EDIT_MODE, false));
                    return;
                case d.n.View_saveEnabled /* 38 */:
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mH.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getName_show(), userData.getSex())));
                        return;
                    }
                    return;
                case d.n.View_drawingCacheQuality /* 40 */:
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mH.getPageActivity(), userData.getUserId(), userData.getName_show(), userData.getPortrait(), userData.getSex(), false)));
                        return;
                    }
                    return;
                case d.n.View_keepScreenOn /* 41 */:
                    com.baidu.tbadk.browser.a.O(this.mH.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case d.n.View_duplicateParentState /* 42 */:
                    if (userData != null && ax.aT(this.mH.getPageActivity()) && userData != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        try {
                            TiebaStatic.log(new ak("c11593"));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(this.mH.getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getPortrait(), userData.getSex(), userData.getIsFriend())));
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

    private void qo(int i) {
        TiebaStatic.log(new ak("c12044").r("obj_locate", i));
    }

    private Map<String, String> pB(final String str) throws URISyntaxException {
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
