package com.baidu.yuyinala.background;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a oJA;
    private TbPageContext mPageContext;
    private b oJB;

    public static a ekb() {
        if (oJA == null) {
            synchronized (a.class) {
                if (oJA == null) {
                    oJA = new a();
                }
            }
        }
        return oJA;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oJB = null;
        }
        if (this.oJB == null) {
            this.oJB = new b(tbPageContext, wVar);
        }
        this.oJB.show();
    }

    public void ID() {
        if (this.oJB != null && this.oJB.isShowing()) {
            this.oJB.dismiss();
        }
    }
}
