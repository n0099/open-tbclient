package com.baidu.tieba.write.write;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
import java.util.Map;
/* loaded from: classes.dex */
class bl implements be.b {
    @Override // com.baidu.tbadk.core.util.be.b
    public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
        if (tbPageContext == null) {
            return;
        }
        WriteActivityStatic.A(tbPageContext);
    }
}
