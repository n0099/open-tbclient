package com.baidu.yuyinala.background;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a osO;
    private TbPageContext mPageContext;
    private b osP;

    public static a eep() {
        if (osO == null) {
            synchronized (a.class) {
                if (osO == null) {
                    osO = new a();
                }
            }
        }
        return osO;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.osP = null;
        }
        if (this.osP == null) {
            this.osP = new b(tbPageContext, wVar);
        }
        this.osP.show();
    }

    public void Hv() {
        if (this.osP != null && this.osP.isShowing()) {
            this.osP.dismiss();
        }
    }
}
