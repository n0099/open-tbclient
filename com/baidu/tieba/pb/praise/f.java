package com.baidu.tieba.pb.praise;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private String a;
    private String b;
    private String c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private List<a> h;
    private h i;
    private HttpMessageListener j;

    public f() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = true;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = new ArrayList(100);
        this.i = null;
        this.j = new g(this, CmdConfig.PRAISE_LIST_HTTP_CMD);
        this.a = "";
        this.b = "";
    }

    public f(String str, String str2, String str3, boolean z, h hVar) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = true;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = new ArrayList(100);
        this.i = null;
        this.j = new g(this, CmdConfig.PRAISE_LIST_HTTP_CMD);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.i = hVar;
        this.d = z;
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfig.PRAISE_LIST_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.j);
    }

    public String a() {
        return this.a;
    }

    public boolean b() {
        return this.d;
    }

    public void a(Bundle bundle, String str) {
        bundle.putBoolean(str, this.d);
    }

    public void b(Bundle bundle, String str) {
        bundle.putString(str, this.a);
    }

    public void c(Bundle bundle, String str) {
        bundle.putString(str, this.b);
    }

    public void d(Bundle bundle, String str) {
        bundle.putString(str, this.c);
    }

    public void e(Bundle bundle, String str) {
        bundle.putInt(str, this.f);
    }

    public void c() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.j);
        messageManager.unRegisterTask(CmdConfig.PRAISE_LIST_HTTP_CMD);
    }

    public String d() {
        return this.c;
    }

    public void a(int i) {
        this.f = i;
    }

    public a b(int i) {
        if (i <= -1 || i >= this.h.size()) {
            return null;
        }
        return this.h.get(i);
    }

    public void e() {
        HttpMessage httpMessage = new HttpMessage(CmdConfig.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam(com.baidu.tbadk.core.frameworkData.a.POST_ID, new StringBuilder(String.valueOf(this.b)).toString());
        httpMessage.addParam("page_num", new StringBuilder(String.valueOf(this.e)).toString());
        httpMessage.addParam("res_num", "20");
        httpMessage.setTag(CmdConfig.PRAISE_LIST_HTTP_CMD);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
