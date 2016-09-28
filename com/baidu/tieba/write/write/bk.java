package com.baidu.tieba.write.write;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bh;
import java.util.Map;
/* loaded from: classes.dex */
class bk implements bh.b {
    @Override // com.baidu.tbadk.core.util.bh.b
    public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
        if (tbPageContext == null) {
            return;
        }
        WriteActivityStatic.G(tbPageContext);
    }
}
