package com.baidu.tieba.write.write;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import java.util.Map;
/* loaded from: classes.dex */
class bl implements bc.b {
    @Override // com.baidu.tbadk.core.util.bc.b
    public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
        if (tbPageContext == null) {
            return;
        }
        WriteActivityStatic.G(tbPageContext);
    }
}
