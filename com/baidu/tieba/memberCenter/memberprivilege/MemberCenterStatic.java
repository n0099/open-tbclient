package com.baidu.tieba.memberCenter.memberprivilege;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MemberExchangeActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MemberTaskCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleListModel;
import com.baidu.tieba.memberCenter.bubble.ResponseBubbleListMessage;
import com.baidu.tieba.memberCenter.index.MembercenterActivity;
import com.baidu.tieba.memberCenter.memberExchange.MemberExchangeActivity;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterActivity;
import com.baidu.tieba.memberCenter.memberpay.CardBoxMemberPayActivity;
import com.baidu.tieba.memberCenter.memberpay.MemberPayFragmentActivity;
import com.baidu.tieba.memberCenter.memberpay.MemberPayResultActivity;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.tieba.memberCenter.tail.edit.TailEditActivity;
import com.baidu.tieba.memberCenter.tail.management.TailManagementActivity;
import com.baidu.tieba.memberCenter.tail.message.AddTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailSocketResponseMessage;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class MemberCenterStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(TailManagementActivityConfig.class, TailManagementActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TailEditActivityConfig.class, TailEditActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MemberTaskCenterActivityConfig.class, MemberTaskCenterActivity.class);
        TbadkApplication.getInst().RegisterIntent(BubbleChooseActivityConfig.class, BubbleChooseActivity.class);
        TbadkApplication.getInst().RegisterIntent(MemberPayActivityConfig.class, MemberPayFragmentActivity.class);
        TbadkApplication.getInst().RegisterIntent(MemberPrivilegeActivityConfig.class, MemberPrivilegeActivity.class);
        TbadkApplication.getInst().RegisterIntent(MembercenterActivityConfig.class, MembercenterActivity.class);
        TbadkApplication.getInst().RegisterIntent(CardBoxMemberPayActivityConfig.class, CardBoxMemberPayActivity.class);
        TbadkApplication.getInst().RegisterIntent(MemberPayResultActivityConfig.class, MemberPayResultActivity.class);
        TbadkApplication.getInst().RegisterIntent(MemberExchangeActivityConfig.class, MemberExchangeActivity.class);
        dfG();
        dfH();
        dfI();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_MEMBER_CENTER_RES_TOOL, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Object> run(CustomMessage<String> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_MEMBER_CENTER_RES_TOOL, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_RESET_BUBBLE, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Boolean> run(CustomMessage<TbPageContext> customMessage) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof TbPageContext)) {
                    BubbleListModel bubbleListModel = new BubbleListModel(customMessage.getData());
                    bubbleListModel.deZ();
                    bubbleListModel.W(0, l.getEquipmentWidth(customMessage.getData().getPageActivity()), l.getEquipmentHeight(customMessage.getData().getPageActivity()));
                }
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_DECODE_BUBBLE, new CustomMessageTask.CustomRunnable<HttpResponsedMessage>() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.8
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage<HttpResponsedMessage> customMessage) {
                BubbleListData bubbleListData;
                String str;
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof ResponseBubbleListMessage) || (bubbleListData = ((ResponseBubbleListMessage) customMessage.getData()).getBubbleListData()) == null || bubbleListData.getB_info() == null || bubbleListData.getB_info().size() <= 0) {
                    return null;
                }
                Iterator<BubbleListData.BubbleData> it = bubbleListData.getB_info().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    BubbleListData.BubbleData next = it.next();
                    if (next.getIs_free() == 1) {
                        str = next.getB_url();
                        break;
                    }
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_DECODE_BUBBLE, str);
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.9
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<m> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, new com.baidu.tieba.memberCenter.a.b(customMessage.getData()));
            }
        });
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.10
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                if (strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_TASK_CENTER)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberTaskCenterActivityConfig(tbPageContext.getPageActivity())));
                    return 0;
                }
                return 3;
            }
        });
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.11
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str) || !str.equals(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_CENTER) || tbPageContext == null) {
                    return 3;
                }
                if (bh.checkUpIsLogin(tbPageContext.getContext())) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(tbPageContext.getPageActivity())));
                }
                return 0;
            }
        });
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.12
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                Bundle parserQuery;
                int i;
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return 3;
                }
                if (!str.contains("jump_tieba_native=1") || !str.contains(UrlSchemaHelper.PAY_MEMBER_PAGE) || (parserQuery = al.parserQuery(str)) == null || tbPageContext.getPageActivity() == null) {
                    return 3;
                }
                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                int vipStatus = (currentAccountInfo == null || currentAccountInfo.getVipInfo() == null) ? 0 : currentAccountInfo.getVipInfo().getVipStatus();
                String string = parserQuery.getString("fromtype");
                String string2 = parserQuery.getString("refer_page");
                String string3 = parserQuery.getString("click_zone");
                if (!StringUtils.isNull(string)) {
                    if (string.equals(TbadkCoreStatisticKey.TAIL_PAY_MEMBER_SUCCESS)) {
                        i = 6;
                    } else if (string.equals(TbadkCoreStatisticKey.BUBBLE_PAY_MEMBER_SUCCESS)) {
                        i = 7;
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), vipStatus, false, i, com.baidu.adp.lib.f.b.toInt(parserQuery.getString("from_scene"), 0));
                    memberPayActivityConfig.setReferPageClickZone(string2, string3);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    return 0;
                }
                i = 0;
                MemberPayActivityConfig memberPayActivityConfig2 = new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), vipStatus, false, i, com.baidu.adp.lib.f.b.toInt(parserQuery.getString("from_scene"), 0));
                memberPayActivityConfig2.setReferPageClickZone(string2, string3);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig2));
                return 0;
            }
        });
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.13
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if ((str.equals(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_BUY_ASSIST)) && tbPageContext != null) {
                    String paramFromURL = al.getParamFromURL(str, "refer_page");
                    String paramFromURL2 = al.getParamFromURL(str, "click_zone");
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(tbPageContext.getPageActivity(), 0);
                    memberPayActivityConfig.setReferPageClickZone(paramFromURL, paramFromURL2);
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    return 0;
                }
                return 3;
            }
        });
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.14
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str) || !str.contains("jumpmemberbuy://") || tbPageContext == null) {
                    return 3;
                }
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), true, 220010, (String) null, 25)));
                return 0;
            }
        });
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.2
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_CARD_BOX_MEMBER_BUY) && str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_CARD_BOX_MEMBER_BUY_ASSIST)) {
                    if (!j.isNetWorkAvailable()) {
                        BdToast.b(tbPageContext.getPageActivity(), tbPageContext.getString(R.string.neterror)).bqD();
                    } else if (bh.checkUpIsLogin(tbPageContext.getPageActivity())) {
                        Bundle parserQuery = al.parserQuery(str);
                        String str2 = "";
                        String str3 = "";
                        String str4 = "";
                        if (parserQuery != null) {
                            if (!au.isEmpty(parserQuery.getString(CardBoxMemberPayActivityConfig.PACKET_ID))) {
                                str2 = parserQuery.getString(CardBoxMemberPayActivityConfig.PACKET_ID);
                            }
                            if (!au.isEmpty(parserQuery.getString("refer_page"))) {
                                str3 = parserQuery.getString("refer_page");
                            }
                            if (!au.isEmpty(parserQuery.getString("click_zone"))) {
                                str4 = parserQuery.getString("click_zone");
                            }
                        }
                        if (tbPageContext != null) {
                            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CardBoxMemberPayActivityConfig(tbPageContext.getPageActivity(), str2, str3, str4)));
                        }
                    }
                    return 0;
                }
                return 3;
            }
        });
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.3
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str) || !str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_MEMBER_EXCHANGE)) {
                    return 3;
                }
                if (!j.isNetWorkAvailable()) {
                    BdToast.b(tbPageContext.getPageActivity(), tbPageContext.getString(R.string.neterror)).bqD();
                } else if (bh.checkUpIsLogin(tbPageContext.getPageActivity())) {
                    String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
                    String paramFromURL = al.getParamFromURL(str, MemberExchangeActivityConfig.MEMBER_NAME);
                    String paramFromURL2 = al.getParamFromURL(str, MemberExchangeActivityConfig.MEMBER_LEVEL_IMAGE);
                    String paramFromURL3 = al.getParamFromURL(str, MemberExchangeActivityConfig.DUE_DATE);
                    String paramFromURL4 = al.getParamFromURL(str, MemberExchangeActivityConfig.DESC_STR);
                    if (tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberExchangeActivityConfig(tbPageContext.getPageActivity(), currentPortrait, paramFromURL, paramFromURL2, paramFromURL3, paramFromURL4)));
                    }
                }
                return 0;
            }
        });
        bf.bsV().a(new bf.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.4
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.GOTO_TAIL_MANAGER)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailManagementActivityConfig(tbPageContext.getPageActivity())));
                    return 1;
                }
                return 3;
            }
        });
    }

    public static void c(TbPageContext<?> tbPageContext, String[] strArr) {
        boolean z = false;
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(strArr[0])) {
            String str = strArr[0];
            if ((str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_DRESSUP_CENTER) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_BG) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL)) ? true : true) {
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(DressupCenterActivityConfig.class)) {
                    bf.bsV().b(tbPageContext, strArr);
                    return;
                } else {
                    l.showToast(tbPageContext.getPageActivity(), R.string.pluginstatus_tip_unknown);
                    return;
                }
            }
            bf.bsV().b(tbPageContext, strArr);
        }
    }

    private static void dfG() {
        a(1003019, CmdConfigSocket.CMD_TAIL_ADD, TbConfig.TAIL_ADD, AddTailHttpResponseMessage.class, AddTailSocketResponseMessage.class);
        a(1003023, CmdConfigSocket.CMD_TAIL_UPDATE, TbConfig.TAIL_UPDATE, UpdateTailHttpResponseMessage.class, UpdateTailSocketResponseMessage.class);
        a(1003022, CmdConfigSocket.CMD_TAIL_SET, TbConfig.TAIL_SET, SetTailHttpResponseMessage.class, SetTailSocketResponseMessage.class);
        a(1003020, CmdConfigSocket.CMD_TAIL_DELETE, TbConfig.TAIL_DELETE, DeleteTailHttpResponseMessage.class, DeleteTailSocketResponseMessage.class);
        a(1003021, CmdConfigSocket.CMD_TAIL_GET, TbConfig.TAIL_GET, GetTailsHttpResponseMessage.class, GetTailsSocketResponseMessage.class);
    }

    private static void a(int i, int i2, String str, Class<? extends HttpResponsedMessage> cls, Class<? extends SocketResponsedMessage> cls2) {
        com.baidu.tieba.tbadkCore.a.a.a(i2, cls2, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(i2, i, str, cls, false, false, false, false);
    }

    private static void dfH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_TAIL_TOOL_CRTL, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<m> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_TAIL_TOOL_CRTL, new com.baidu.tieba.memberCenter.tail.tool.a(customMessage.getData(), 1));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void dfI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<m> run(CustomMessage<Context> customMessage) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof Context)) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, new com.baidu.tieba.memberCenter.tail.privilegetool.b(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
