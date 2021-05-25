package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
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
/* loaded from: classes5.dex */
public class ThemeStatic {

    /* loaded from: classes5.dex */
    public static class a implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL) && str.contains("props_id=")) {
                    String substring = str.substring(str.lastIndexOf("props_id=") + 9);
                    int indexOf = substring.indexOf("&");
                    if (indexOf == -1) {
                        indexOf = substring.length();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(tbPageContext.getPageActivity(), d.a.c.e.m.b.f(substring.substring(0, indexOf), 0L))));
                    return 0;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(tbPageContext.getPageActivity())));
                }
            }
            return 3;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_BG) && str.contains("props_id=")) {
                    String substring = str.substring(str.lastIndexOf("props_id=") + 9);
                    int indexOf = substring.indexOf("&");
                    if (indexOf == -1) {
                        indexOf = substring.length();
                    }
                    int d2 = d.a.c.e.m.b.d(substring.substring(0, indexOf), 0);
                    d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
                    StringBuilder sb = new StringBuilder();
                    sb.append("current_used_personal_background_");
                    sb.append(TbadkCoreApplication.getCurrentAccount());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackgroundPreviewActivityConfig(tbPageContext.getPageActivity(), d2, d2 == j.k(sb.toString(), 0) ? 1 : 0)));
                    return 0;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_BG)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(tbPageContext.getPageActivity())));
                }
            }
            return 3;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr == null || strArr.length == 0 || !strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER)) {
                return 3;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(tbPageContext.getPageActivity())));
            return 0;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_POST_BUBBLE)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(tbPageContext.getPageActivity())));
                    return 0;
                } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_BUBBLE_LIST)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleChooseActivityConfig(tbPageContext.getPageActivity())));
                    return 1;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr == null || strArr.length == 0 || !strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PENDANT_LIST)) {
                return 3;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(tbPageContext.getPageActivity())));
            return 0;
        }
    }

    static {
        b();
        d();
        c();
        e();
        a();
        TbadkApplication.getInst().RegisterIntent(DressupCenterActivityConfig.class, DressupCenterActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonalBackdropGroupActivityConfig.class, BackgroundGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonalBackdropListActivityConfig.class, BackgroundListActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonalBackgroundPreviewActivityConfig.class, BackgroundPreviewActivity.class);
        TbadkApplication.getInst().RegisterIntent(BubbleGroupActivityConfig.class, BubbleGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(BubbleListActivityConfig.class, BubbleListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonalCardCategoryActivityConfig.class, PersonalCardCategoryActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(PersonalCardDetailActivityConfig.class, PersonalCardDetailActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AvatarPendantActivityConfig.class, AvatarPendantActivity.class);
        d.a.n0.e3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
    }

    public static void a() {
        UrlManager.getInstance().addListener(new e());
    }

    public static void b() {
        UrlManager.getInstance().addListener(new b());
    }

    public static void c() {
        UrlManager.getInstance().addListener(new d());
    }

    public static void d() {
        UrlManager.getInstance().addListener(new c());
    }

    public static void e() {
        UrlManager.getInstance().addListener(new a());
    }
}
