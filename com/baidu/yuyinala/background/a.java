package com.baidu.yuyinala.background;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private static a oPH;
    private TbPageContext mPageContext;
    private b oPI;

    public static a ekg() {
        if (oPH == null) {
            synchronized (a.class) {
                if (oPH == null) {
                    oPH = new a();
                }
            }
        }
        return oPH;
    }

    public void b(TbPageContext tbPageContext, x xVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oPI = null;
        }
        if (this.oPI == null) {
            this.oPI = new b(tbPageContext, xVar);
        }
        this.oPI.show();
    }

    public void If() {
        if (this.oPI != null && this.oPI.isShowing()) {
            this.oPI.dismiss();
        }
    }
}
