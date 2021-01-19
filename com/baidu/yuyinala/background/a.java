package com.baidu.yuyinala.background;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private static a oLg;
    private TbPageContext mPageContext;
    private b oLh;

    public static a egn() {
        if (oLg == null) {
            synchronized (a.class) {
                if (oLg == null) {
                    oLg = new a();
                }
            }
        }
        return oLg;
    }

    public void b(TbPageContext tbPageContext, x xVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oLh = null;
        }
        if (this.oLh == null) {
            this.oLh = new b(tbPageContext, xVar);
        }
        this.oLh.show();
    }

    public void Ek() {
        if (this.oLh != null && this.oLh.isShowing()) {
            this.oLh.dismiss();
        }
    }
}
