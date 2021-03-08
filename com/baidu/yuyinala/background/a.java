package com.baidu.yuyinala.background;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private static a oXR;
    private TbPageContext mPageContext;
    private b oXS;

    public static a eiX() {
        if (oXR == null) {
            synchronized (a.class) {
                if (oXR == null) {
                    oXR = new a();
                }
            }
        }
        return oXR;
    }

    public void b(TbPageContext tbPageContext, ab abVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oXS = null;
        }
        if (this.oXS == null) {
            this.oXS = new b(tbPageContext, abVar);
        }
        this.oXS.show();
    }

    public void FD() {
        if (this.oXS != null && this.oXS.isShowing()) {
            this.oXS.dismiss();
        }
    }
}
