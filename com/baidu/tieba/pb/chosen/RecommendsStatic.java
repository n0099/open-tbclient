package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import d.a.c.e.m.b;
/* loaded from: classes3.dex */
public class RecommendsStatic {

    /* loaded from: classes3.dex */
    public static class a implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (strArr != null && strArr.length > 0) {
                String str = strArr[0];
                if (str.startsWith("http://tieba.baidu.com/mo/q/recommendpb") && str.contains("ftid=")) {
                    String substring = str.substring(str.lastIndexOf("ftid=") + 5);
                    if (tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, new PbChosenActivityConfig(tbPageContext.getPageActivity(), b.f(substring, 0L), null)));
                        return 0;
                    }
                }
            }
            return 3;
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(PbChosenActivityConfig.class, PbChosenActivity.class);
        a();
    }

    public static void a() {
        UrlManager.getInstance().addListener(new a());
    }
}
