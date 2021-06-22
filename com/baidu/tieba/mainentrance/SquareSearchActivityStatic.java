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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListHttpResMessage;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListSocketResMessage;
import d.a.o0.p1.f;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class SquareSearchActivityStatic {

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(NewSquareSearchActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements CustomMessageTask.CustomRunnable {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ArrayList<String>> run(CustomMessage customMessage) {
            if (customMessage == null) {
                return null;
            }
            return new CustomResponsedMessage<>(2009002, d.a.o0.e3.n0.a.k());
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements CustomMessageTask.CustomRunnable {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ArrayList<String>> run(CustomMessage customMessage) {
            if (customMessage == null) {
                return null;
            }
            return new CustomResponsedMessage<>(2009001, d.a.o0.e3.n0.a.m());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr[0] != null) {
                Matcher matcher = Pattern.compile("http[s]?://tieba\\.baidu\\.com/mo/q/creat\\?word=(.*)&jump_tieba_native=1&type=create_forum").matcher(strArr[0]);
                if (matcher.find()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001608, Uri.decode(matcher.group(1))));
                    return 0;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr == null || strArr[0] == null || !strArr[0].contains(UrlSchemaHelper.SCHEMA_TYPE_SQUARE_SEARCH)) {
                return 3;
            }
            new SquareSearchActivityConfig(tbPageContext.getPageActivity(), "", false).startActivity(SquareSearchActivity.class);
            return 0;
        }
    }

    static {
        c();
        d();
        CustomMessageTask customMessageTask = new CustomMessageTask(2015003, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        d.a.o0.e3.d0.a.b(2001190, f.class);
        d.a.o0.e3.d0.a.b(2001191, d.a.o0.p1.e.class);
        e();
        d.a.o0.e3.d0.a.f(303116, HotForumSocketResponseMessage.class, false);
        f();
        b();
        a();
    }

    public static void a() {
        UrlManager.getInstance().addListener(new e());
    }

    public static void b() {
        UrlManager.getInstance().addListener(new d());
    }

    public static void c() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009002, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009001, new c());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void e() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, d.a.o0.e3.d0.a.a(TbConfig.GET_HOT_FORUM_URL, 303116));
        tbHttpMessageTask.setResponsedClass(HotForumHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void f() {
        d.a.n0.v0.b bVar = new d.a.n0.v0.b(309438);
        bVar.setResponsedClass(SearchListSocketResMessage.class);
        bVar.g(true);
        bVar.h(false);
        bVar.f(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SEARCH_LIST, d.a.o0.e3.d0.a.a("c/s/searchSug", 309438));
        tbHttpMessageTask.setResponsedClass(SearchListHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
