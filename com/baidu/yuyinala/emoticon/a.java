package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private static a oLK;
    private TbPageContext mPageContext;
    private b oLL;

    public static a egF() {
        if (oLK == null) {
            synchronized (a.class) {
                if (oLK == null) {
                    oLK = new a();
                }
            }
        }
        return oLK;
    }

    public void b(TbPageContext tbPageContext, x xVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oLL = null;
        }
        this.oLL = new b(tbPageContext, xVar);
        this.oLL.show();
    }

    public void Ek() {
        if (this.oLL != null && this.oLL.isShowing()) {
            this.oLL.dismiss();
        }
    }
}
