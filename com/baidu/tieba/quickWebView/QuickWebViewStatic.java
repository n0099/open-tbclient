package com.baidu.tieba.quickWebView;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
import d.a.o0.e3.d0.a;
/* loaded from: classes5.dex */
public class QuickWebViewStatic {
    static {
        a.h(309485, WebViewCacheResSocketMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, a.a(TbConfig.WEBVIEW_CACHE_URL, 309485));
        tbHttpMessageTask.setResponsedClass(WebViewCacheResHttpMsg.class);
        if (TbSingleton.getInstance().isDebugToolMode()) {
            if (MessageManager.getInstance().findTask(tbHttpMessageTask.getCmd()) == null) {
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                return;
            }
            return;
        }
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
