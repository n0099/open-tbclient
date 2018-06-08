package com.baidu.tieba.quickWebView;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
/* loaded from: classes.dex */
public class QuickWebViewStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.a(309485, WebViewCacheResSocketMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, com.baidu.tieba.tbadkCore.a.a.aN("c/s/getWebviewCacheInfo", 309485));
        tbHttpMessageTask.setResponsedClass(WebViewCacheResHttpMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
