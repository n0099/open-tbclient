package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.MessageTask;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public interface x9<M extends Message<?>, T extends MessageTask> {
    LinkedList<M> e(int i, BdUniqueId bdUniqueId);

    void f(M m, T t);

    void h(int i, BdUniqueId bdUniqueId);
}
