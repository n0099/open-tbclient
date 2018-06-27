package com.baidu.tieba.mainentrance;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class SquareSearchActivityStatic {
    static {
        aSl();
        aSm();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015003, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.1
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
        com.baidu.tieba.tbadkCore.a.a.b(2001190, f.class);
        com.baidu.tieba.tbadkCore.a.a.b(2001191, e.class);
        aSn();
        com.baidu.tieba.tbadkCore.a.a.c(303116, HotForumSocketResponseMessage.class, false);
        aSk();
        aSo();
        aSp();
    }

    private static void aSk() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309438);
        bVar.setResponsedClass(SearchListSocketResMessage.class);
        bVar.p(true);
        bVar.q(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SEARCH_LIST, com.baidu.tieba.tbadkCore.a.a.aO("c/s/searchSug", 309438));
        tbHttpMessageTask.setResponsedClass(SearchListHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aSl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ArrayList<String>> run(CustomMessage customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2009002, com.baidu.tieba.tbadkCore.util.a.byu());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aSm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009001, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ArrayList<String>> run(CustomMessage customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2009001, com.baidu.tieba.tbadkCore.util.a.byv());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aSn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, com.baidu.tieba.tbadkCore.a.a.aO(TbConfig.GET_HOT_FORUM_URL, 303116));
        tbHttpMessageTask.setResponsedClass(HotForumHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aSo() {
        az.zV().a(new az.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.4
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                Matcher matcher = Pattern.compile("http[s]?://tieba\\.baidu\\.com/mo/q/creat\\?word=(.*)&jump_tieba_native=1&type=create_forum").matcher(strArr[0]);
                if (matcher.find()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001608, Uri.decode(matcher.group(1))));
                    return 0;
                }
                return 3;
            }
        });
    }

    private static void aSp() {
        az.zV().a(new az.a() { // from class: com.baidu.tieba.mainentrance.SquareSearchActivityStatic.5
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                if (strArr[0].contains("squaresearch:")) {
                    new SquareSearchActivityConfig(tbPageContext.getPageActivity(), "", false).startActivity(SquareSearchActivity.class);
                    return 0;
                }
                return 3;
            }
        });
    }
}
