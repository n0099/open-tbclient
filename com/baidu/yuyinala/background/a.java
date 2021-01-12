package com.baidu.yuyinala.background;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private static a oLf;
    private TbPageContext mPageContext;
    private b oLg;

    public static a egn() {
        if (oLf == null) {
            synchronized (a.class) {
                if (oLf == null) {
                    oLf = new a();
                }
            }
        }
        return oLf;
    }

    public void b(TbPageContext tbPageContext, x xVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oLg = null;
        }
        if (this.oLg == null) {
            this.oLg = new b(tbPageContext, xVar);
        }
        this.oLg.show();
    }

    public void Ek() {
        if (this.oLg != null && this.oLg.isShowing()) {
            this.oLg.dismiss();
        }
    }
}
