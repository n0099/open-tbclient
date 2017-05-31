package com.baidu.tieba.personPolymeric.event;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
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
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.personPolymeric.b.n;
import com.baidu.tieba.w;
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
    private n bwN;
    private com.baidu.tieba.personPolymeric.b.a eLd;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(n nVar) {
        this.bwN = nVar;
        if (this.bwN != null) {
            this.eLd = this.bwN.aQV();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x011f, code lost:
        if (r0.equalsIgnoreCase(r3.getPersonalBgUrl()) == false) goto L48;
     */
    @Override // com.baidu.tieba.f.a, com.baidu.tieba.view.r
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
            if (bVar.bOj == null) {
                userData = null;
            } else {
                userData = (UserData) bVar.bOj.getSerializable(UserData.TYPE_USER);
            }
            switch (bVar.bOi) {
                case 1:
                    if (userData != null) {
                        k kVar = new k();
                        kVar.eS(userData.getPortraitH());
                        kVar.eT(userData.getPortrait());
                        kVar.bt(true);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(kVar);
                        this.bwN.aQW().a((v) kVar, (List<v>) arrayList, 0);
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 16:
                case 18:
                case 19:
                case 23:
                case 25:
                case 26:
                case 28:
                default:
                    return;
                case 8:
                    this.ajh.getPageActivity().finish();
                    return;
                case 9:
                    if (this.eLd != null && this.eLd.Tt() != null) {
                        this.eLd.Tt().aRc();
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
                            i = com.baidu.adp.lib.g.b.g(ov(bg_pic).get("props_id"), -1);
                            str2 = bg_pic;
                        } catch (URISyntaxException e) {
                            str2 = bg_pic;
                            i = -1;
                        }
                    }
                    if (i == -1 || str.equals(TbadkCoreApplication.getCurrentAccount())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(this.ajh.getPageActivity())));
                        return;
                    }
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        if (!StringUtils.isNull(str2) && !StringUtils.isNull(currentAccountInfo.getPersonalBgUrl())) {
                            break;
                        } else {
                            i2 = 0;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.ajh.getPageActivity(), i, i2)));
                        return;
                    }
                    i2 = 0;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.ajh.getPageActivity(), i, i2)));
                    return;
                case 11:
                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        PersonChangeData personChangeData = new PersonChangeData();
                        if (userData != null) {
                            personChangeData.setPortrait(userData.getPortrait());
                            personChangeData.setName(userData.getUserName());
                            personChangeData.setSex(userData.getSex());
                            personChangeData.setIntro(userData.getIntro());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.ajh.getPageActivity(), 101, personChangeData, false)));
                        return;
                    }
                    return;
                case 12:
                    if (userData != null) {
                        TiebaStatic.log("igift_icon_ck");
                        if (bh.aN(this.ajh.getPageActivity())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.ajh.getPageActivity(), userData.getUserIdLong(), userData.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001)));
                            return;
                        }
                        return;
                    }
                    return;
                case 13:
                    bb.vy().c(this.ajh, new String[]{TbConfig.WEB_URL_FANS});
                    return;
                case 14:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.ajh.getPageActivity(), 0L)));
                    return;
                case 15:
                    pw(8);
                    if (userData != null && userData.membershipInfo != null) {
                        String str3 = userData.membershipInfo.mLink;
                        if (!StringUtils.isNull(str3)) {
                            bb.vy().c(this.ajh, new String[]{str3});
                            return;
                        }
                        return;
                    }
                    return;
                case 17:
                    pw(12);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ConsumptionRecordsActivityConfig(TbadkCoreApplication.m9getInst().getApplicationContext())));
                    return;
                case 20:
                    pw(2);
                    com.baidu.tieba.j.a.baD().C(3, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.ajh.getPageActivity())));
                    return;
                case 21:
                    pw(5);
                    TiebaStatic.log(new as("c11590").r("obj_locate", 2).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.ajh.getPageActivity())));
                    return;
                case 22:
                    TiebaStatic.log(new as("c11590").r("obj_locate", 3).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissonDetailsActivityConfig(this.ajh.getPageActivity(), 24004, userData.getAnchorLevel(), userData.getPortrait(), userData.getName_show(), MissonDetailsActivityConfig.FROM_PERSON)));
                        return;
                    }
                    return;
                case 24:
                    pw(3);
                    com.baidu.tieba.j.a.baD().C(4, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(this.ajh.getPageActivity())));
                    return;
                case 27:
                    pw(10);
                    TiebaStatic.log(new as("c11948"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.ajh.getPageActivity())));
                    return;
                case 29:
                    if (userData != null) {
                        pw(6);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.ajh.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getPortrait(), userData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(ChannelHomeActivityConfig.class)) {
                        pw(7);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.ajh.getPageActivity(), 4)));
                        return;
                    }
                    return;
                case 31:
                    if (userData != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(ChannelListActivityConfig.class)) {
                        TiebaStatic.log(new as("c11955"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelListActivityConfig(this.ajh.getPageActivity(), userData.getUserId())));
                        return;
                    }
                    return;
                case 32:
                    pw(1);
                    com.baidu.tieba.j.a.baD().C(8, false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MessageCenterActivityConfig(this.ajh.getPageActivity())));
                    return;
                case 33:
                    pw(9);
                    String string = bVar.bOj.getString("book_jump_link");
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyBookrackActivityConfig.class)) {
                        com.baidu.adp.lib.util.k.showToast(this.ajh.getPageActivity(), w.l.book_plugin_not_install_tip);
                        return;
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyBookrackActivityConfig(this.ajh.getPageActivity(), 0, string)));
                        return;
                    }
                case 34:
                    pw(4);
                    com.baidu.tieba.j.a.baD().C(1, false);
                    if (userData != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.ajh.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 35:
                    pw(11);
                    bb.vy().a(this.ajh, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 36:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_BIG_V_TO_EDIT_MODE, false));
                    return;
            }
        }
    }

    private void pw(int i) {
        TiebaStatic.log(new as("c12044").r("obj_locate", i));
    }

    private Map<String, String> ov(final String str) throws URISyntaxException {
        return new HashMap<String, String>(str) { // from class: com.baidu.tieba.personPolymeric.event.PersonPolymericEventController$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }
}
