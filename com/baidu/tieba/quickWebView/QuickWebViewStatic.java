package com.baidu.tieba.quickWebView;

import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
/* loaded from: classes.dex */
public class QuickWebViewStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.WEBVIEW_CACHE_INFO, WebViewCacheResSocketMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003365, com.baidu.tieba.tbadkCore.a.a.bu("c/s/getWebviewCacheInfo", CmdConfigSocket.WEBVIEW_CACHE_INFO));
        tbHttpMessageTask.setResponsedClass(WebViewCacheResHttpMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
