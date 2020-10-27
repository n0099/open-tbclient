package com.baidu.yuyinala.background;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a ojI;
    private TbPageContext mPageContext;
    private b ojJ;

    public static a eaH() {
        if (ojI == null) {
            synchronized (a.class) {
                if (ojI == null) {
                    ojI = new a();
                }
            }
        }
        return ojI;
    }

    public void a(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.ojJ = null;
        }
        if (this.ojJ == null) {
            this.ojJ = new b(tbPageContext, wVar);
        }
        this.ojJ.show();
    }

    public void GU() {
        if (this.ojJ != null && this.ojJ.isShowing()) {
            this.ojJ.dismiss();
        }
    }
}
