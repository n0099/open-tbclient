package com.baidu.tieba.write.write;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bi;
import java.util.Map;
/* loaded from: classes.dex */
class bk implements bi.b {
    @Override // com.baidu.tbadk.core.util.bi.b
    public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
        if (tbPageContext == null) {
            return;
        }
        WriteActivityStatic.D(tbPageContext);
    }
}
