package com.baidu.tieba.personCenter.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelListActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.g.a {
    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.g.a, com.baidu.tieba.view.m
    public void a(View view, com.baidu.tieba.g.b bVar) {
        UserData userData;
        super.a(view, bVar);
        if (bVar != null) {
            if (bVar.bzZ == null) {
                userData = null;
            } else {
                userData = (UserData) bVar.bzZ.getSerializable(UserData.TYPE_USER);
            }
            switch (bVar.bzY) {
                case 1:
                    if (userData != null) {
                        e(userData);
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 19:
                default:
                    return;
                case 8:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.FY.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true)));
                    return;
                case 9:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.FY.getPageActivity(), 0L)));
                    return;
                case 10:
                    com.baidu.tieba.h.a.bap().D(1, false);
                    if (userData != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.FY.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new ar("c11590").s("obj_locate", 4).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    if (userData != null && userData.membershipInfo != null) {
                        String str = userData.membershipInfo.mLink;
                        if (!StringUtils.isNull(str)) {
                            ba.vt().c(this.FY, new String[]{str});
                            return;
                        }
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.h.a.bap().D(7, false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.FY.getPageActivity())));
                    return;
                case 13:
                    TiebaStatic.log(new ar("c11590").s("obj_locate", 1).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    oM(bVar.bzZ.getString("type_center_consume_url"));
                    return;
                case 14:
                    TiebaStatic.log(new ar("c11590").s("obj_locate", 5).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    oM(bVar.bzZ.getString("type_center_order_url"));
                    return;
                case 15:
                    oM(bVar.bzZ.getString("type_center_myshop_url"));
                    return;
                case 16:
                    com.baidu.tieba.h.a.bap().D(3, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.FY.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new ar("c11590").s("obj_locate", 2).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.FY.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new ar("c11590").s("obj_locate", 3).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.userType));
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissonDetailsActivityConfig(this.FY.getPageActivity(), 24004, userData.getAnchorLevel(), userData.getPortrait(), userData.getName_show(), MissonDetailsActivityConfig.FROM_PERSON)));
                        return;
                    }
                    return;
                case 20:
                    com.baidu.tieba.h.a.bap().D(4, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(this.FY.getPageActivity())));
                    return;
                case 21:
                    if (userData != null) {
                        if (userData.getPersonPrivate().BS() == 1 || TbadkCoreApplication.getCurrentAccount().equals(userData.getUserId()) || (userData.getIsFriend() == 1 && userData.getPersonPrivate().BS() == 2)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.FY.getPageActivity(), userData.getUserId(), userData.getSex())));
                            return;
                        } else {
                            hy(userData.getSex());
                            return;
                        }
                    }
                    return;
                case 22:
                    ba.vt().c(this.FY, new String[]{TbConfig.WEB_URL_FANS});
                    return;
                case 23:
                    TiebaStatic.log(new ar("c11948"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.FY.getPageActivity())));
                    return;
                case 24:
                    ba.vt().c(this.FY, new String[]{bVar.bzZ.getString("person_center_item_click_url")});
                    return;
                case 25:
                    if (userData != null) {
                        TiebaStatic.log(new ar("c11853").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.FY.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getPortrait(), userData.getSex(), true)));
                        return;
                    }
                    return;
                case 26:
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(ChannelHomeActivityConfig.class)) {
                        TiebaStatic.log(new ar("c11938"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(this.FY.getPageActivity(), 4)));
                        return;
                    }
                    return;
                case 27:
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(ChannelListActivityConfig.class)) {
                        TiebaStatic.log(new ar("c11955"));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelListActivityConfig(this.FY.getPageActivity(), userData.getUserId())));
                        return;
                    }
                    return;
            }
        }
    }

    private void oM(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                ba.vt().c(this.FY, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                f.a(this.FY.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void e(UserData userData) {
        ArrayList<String> arrayList = new ArrayList<>();
        String oN = oN(userData.getPortraitH());
        arrayList.add(oN);
        this.FY.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.FY.getPageActivity()).createConfig(arrayList, 0, null, "", "", true, oN, true)));
    }

    private String oN(String str) {
        return ((float) this.FY.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }
}
