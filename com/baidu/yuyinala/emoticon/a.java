package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a ouR;
    private TbPageContext mPageContext;
    private b ouS;

    public static a eeB() {
        if (ouR == null) {
            synchronized (a.class) {
                if (ouR == null) {
                    ouR = new a();
                }
            }
        }
        return ouR;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.ouS = null;
        }
        this.ouS = new b(tbPageContext, wVar);
        this.ouS.show();
    }

    public void GM() {
        if (this.ouS != null && this.ouS.isShowing()) {
            this.ouS.dismiss();
        }
    }
}
