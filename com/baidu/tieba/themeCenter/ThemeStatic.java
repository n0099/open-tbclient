package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleListActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.background.BackgroundGroupActivity;
import com.baidu.tieba.themeCenter.background.BackgroundListActivity;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.BackgroundSetHttpResponseMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetSocketResponseMessage;
import com.baidu.tieba.themeCenter.bubble.group.BubbleGroupActivity;
import com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity;
import com.baidu.tieba.themeCenter.card.detail.PersonalCardDetailActivity;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes9.dex */
public class ThemeStatic {
    static {
        dQU();
        dQV();
        dQW();
        dQT();
        dQX();
        TbadkApplication.getInst().RegisterIntent(DressupCenterActivityConfig.class, DressupCenterActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonalBackdropGroupActivityConfig.class, BackgroundGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonalBackdropListActivityConfig.class, BackgroundListActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonalBackgroundPreviewActivityConfig.class, BackgroundPreviewActivity.class);
        TbadkApplication.getInst().RegisterIntent(BubbleGroupActivityConfig.class, BubbleGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(BubbleListActivityConfig.class, BubbleListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonalCardCategoryActivityConfig.class, PersonalCardCategoryActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonalCardDetailActivityConfig.class, PersonalCardDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AvatarPendantActivityConfig.class, AvatarPendantActivity.class);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, BackgroundSetSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_PERSONAL_BACKGROUND_SET, 1003036, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    private static void dQT() {
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.themeCenter.ThemeStatic.1
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL) && str.contains("props_id=")) {
                    String substring = str.substring(str.lastIndexOf("props_id=") + "props_id=".length());
                    int indexOf = substring.indexOf(ETAG.ITEM_SEPARATOR);
                    if (indexOf == -1) {
                        indexOf = substring.length();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.f.b.toLong(substring.substring(0, indexOf), 0L))));
                    return 0;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardCategoryActivityConfig(tbPageContext.getPageActivity())));
                    return 3;
                } else {
                    return 3;
                }
            }
        });
    }

    private static void dQU() {
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.themeCenter.ThemeStatic.2
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_BG) && str.contains("props_id=")) {
                    String substring = str.substring(str.lastIndexOf("props_id=") + "props_id=".length());
                    int indexOf = substring.indexOf(ETAG.ITEM_SEPARATOR);
                    if (indexOf == -1) {
                        indexOf = substring.length();
                    }
                    int i = com.baidu.adp.lib.f.b.toInt(substring.substring(0, indexOf), 0);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(tbPageContext.getPageActivity(), i, i == com.baidu.tbadk.core.sharedPref.b.brQ().getInt(new StringBuilder().append(SharedPrefConfig.CURRENT_USED_PERSONAL_BACKGROUND).append(TbadkCoreApplication.getCurrentAccount()).toString(), 0) ? 1 : 0)));
                    return 0;
                }
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_BG)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(tbPageContext.getPageActivity())));
                }
                return 3;
            }
        });
    }

    private static void dQV() {
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.themeCenter.ThemeStatic.3
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                if (strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(tbPageContext.getPageActivity())));
                    return 0;
                }
                return 3;
            }
        });
    }

    private static void dQW() {
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.themeCenter.ThemeStatic.4
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_POST_BUBBLE)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(tbPageContext.getPageActivity())));
                    return 0;
                } else if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.GOTO_BUBBLE_LIST)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleChooseActivityConfig(tbPageContext.getPageActivity())));
                    return 1;
                } else {
                    return 3;
                }
            }
        });
    }

    private static void dQX() {
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.themeCenter.ThemeStatic.5
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                if (strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PENDANT_LIST)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(tbPageContext.getPageActivity())));
                    return 0;
                }
                return 3;
            }
        });
    }
}
