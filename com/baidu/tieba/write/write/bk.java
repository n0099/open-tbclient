package com.baidu.tieba.write.write;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import java.util.Map;
/* loaded from: classes.dex */
class bk implements ba.b {
    @Override // com.baidu.tbadk.core.util.ba.b
    public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
        if (tbPageContext == null) {
            return;
        }
        WriteActivityStatic.E(tbPageContext);
    }
}
