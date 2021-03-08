package com.baidu.webkit.sdk.plugin;
/* loaded from: classes14.dex */
public interface ZeusPluginFactory {

    /* loaded from: classes14.dex */
    public interface Invoker {
        Object get(String str);
    }

    ZeusPlugin create(Invoker invoker);

    String name();
}
