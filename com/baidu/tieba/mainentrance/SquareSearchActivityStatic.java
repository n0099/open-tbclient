package com.baidu.tieba.mainentrance;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes11.dex */
public class SquareSearchActivityStatic {
    public static String Tag = "tag";

    static {
        cvW();
        cvX();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_SQUARESEARCH, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(NewSquareSearchActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_WRITE_SEARCHPERSON_HISTORY, f.class);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_READ_SEARCHPERSON_HISTORY, e.class);
        cvY();
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_GET_HOTFORUM, HotForumSocketResponseMessage.class, false);
        cvV();
        cvZ();
        cwa();
    }

    private static void cvV() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(CmdConfigSocket.CMD_SEARCH_LIST);
        bVar.setResponsedClass(SearchListSocketResMessage.class);
        bVar.setNeedAck(true);
        bVar.setNeedCompress(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003196, com.baidu.tieba.tbadkCore.a.a.bF(Config.GET_SEARCH_LIST, CmdConfigSocket.CMD_SEARCH_LIST));
        tbHttpMessageTask.setResponsedClass(SearchListHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cvW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ArrayList<String>> run(CustomMessage customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.GET_ALL_SEARCH_BAR_DATA, com.baidu.tieba.tbadkCore.util.a.deD());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cvX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ArrayList<String>> run(CustomMessage customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.GET_ALL_SEARCH_POST_DATA, com.baidu.tieba.tbadkCore.util.a.deE());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cvY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001534, com.baidu.tieba.tbadkCore.a.a.bF(TbConfig.GET_HOT_FORUM_URL, CmdConfigSocket.CMD_GET_HOTFORUM));
        tbHttpMessageTask.setResponsedClass(HotForumHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void cvZ() {
        ba.aVa().a(new ba.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.4
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                Matcher matcher = Pattern.compile("http[s]?://tieba\\.baidu\\.com/mo/q/creat\\?word=(.*)&jump_tieba_native=1&type=create_forum").matcher(strArr[0]);
                if (matcher.find()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEARCH_CREATE_BAR, Uri.decode(matcher.group(1))));
                    return 0;
                }
                return 3;
            }
        });
    }

    private static void cwa() {
        ba.aVa().a(new ba.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.5
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                if (strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_SEARCH)) {
                    new SquareSearchActivityConfig(tbPageContext.getPageActivity(), "", false).startActivity(SquareSearchActivity.class);
                    return 0;
                }
                return 3;
            }
        });
    }
}
