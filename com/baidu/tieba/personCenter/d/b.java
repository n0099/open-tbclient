package com.baidu.tieba.personCenter.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.e.a, com.baidu.tieba.view.m
    public void a(View view, com.baidu.tieba.e.b bVar) {
        UserData userData;
        super.a(view, bVar);
        if (bVar != null) {
            if (bVar.bso == null) {
                userData = null;
            } else {
                userData = (UserData) bVar.bso.getSerializable(UserData.TYPE_USER);
            }
            switch (bVar.bsn) {
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.GO.getPageActivity()).createNormalConfig(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true)));
                    return;
                case 9:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.GO.getPageActivity(), 0L)));
                    return;
                case 10:
                    com.baidu.tieba.f.a.aYA().D(1, false);
                    if (userData != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.GO.getPageActivity(), userData.getUserId(), userData.getUserName(), userData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new at("c11590").s("obj_locate", 4).s("obj_source", this.userType));
                    if (userData != null && userData.membershipInfo != null) {
                        String str = userData.membershipInfo.mLink;
                        if (!StringUtils.isNull(str)) {
                            bc.vz().c(this.GO, new String[]{str});
                            return;
                        }
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.f.a.aYA().D(7, false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.GO.getPageActivity())));
                    return;
                case 13:
                    TiebaStatic.log(new at("c11590").s("obj_locate", 1).s("obj_source", this.userType));
                    ou(bVar.bso.getString("type_center_consume_url"));
                    return;
                case 14:
                    TiebaStatic.log(new at("c11590").s("obj_locate", 5).s("obj_source", this.userType));
                    ou(bVar.bso.getString("type_center_order_url"));
                    return;
                case 15:
                    ou(bVar.bso.getString("type_center_myshop_url"));
                    return;
                case 16:
                    com.baidu.tieba.f.a.aYA().D(3, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.GO.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new at("c11590").s("obj_locate", 2).s("obj_source", this.userType));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.GO.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new at("c11590").s("obj_locate", 3).s("obj_source", this.userType));
                    if (userData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MissonDetailsActivityConfig(this.GO.getPageActivity(), 24004, userData.getAnchorLevel(), userData.getPortrait(), userData.getName_show(), MissonDetailsActivityConfig.FROM_PERSON)));
                        return;
                    }
                    return;
                case 20:
                    com.baidu.tieba.f.a.aYA().D(4, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLEAR_ADDRESSLIST_TIP));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddressListActivityConfig(this.GO.getPageActivity())));
                    return;
                case 21:
                    if (userData != null) {
                        if (userData.getPersonPrivate().BX() == 1 || TbadkCoreApplication.getCurrentAccount().equals(userData.getUserId()) || (userData.getIsFriend() == 1 && userData.getPersonPrivate().BX() == 2)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.GO.getPageActivity(), userData.getUserId(), userData.getSex())));
                            return;
                        } else {
                            gM(userData.getSex());
                            return;
                        }
                    }
                    return;
                case 22:
                    bc.vz().c(this.GO, new String[]{TbConfig.WEB_URL_FANS});
                    return;
                case 23:
                    TiebaStatic.log(new at("c11948"));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BigImgPbActivityConfig(this.GO.getPageActivity())));
                    return;
                case 24:
                    bc.vz().c(this.GO, new String[]{bVar.bso.getString("person_center_item_click_url")});
                    return;
            }
        }
    }

    private void ou(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                bc.vz().c(this.GO, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                f.a(this.GO.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void e(UserData userData) {
        ArrayList<String> arrayList = new ArrayList<>();
        String ov = ov(userData.getPortraitH());
        arrayList.add(ov);
        this.GO.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.GO.getPageActivity()).createConfig(arrayList, 0, null, "", "", true, ov, true)));
    }

    private String ov(String str) {
        return ((float) this.GO.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }
}
