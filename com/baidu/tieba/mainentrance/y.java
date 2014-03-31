package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class y implements com.baidu.adp.framework.task.a {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<ArrayList<String>> a(com.baidu.adp.framework.message.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2009001, com.baidu.tieba.util.k.i());
    }
}
