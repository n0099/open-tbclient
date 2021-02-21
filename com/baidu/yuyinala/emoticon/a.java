package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private static a oWq;
    private TbPageContext mPageContext;
    private b oWr;

    public static a ejf() {
        if (oWq == null) {
            synchronized (a.class) {
                if (oWq == null) {
                    oWq = new a();
                }
            }
        }
        return oWq;
    }

    public void b(TbPageContext tbPageContext, ab abVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oWr = null;
        }
        this.oWr = new b(tbPageContext, abVar);
        this.oWr.show();
    }

    public void FA() {
        if (this.oWr != null && this.oWr.isShowing()) {
            this.oWr.dismiss();
        }
    }
}
