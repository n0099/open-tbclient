package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private static a oQl;
    private TbPageContext mPageContext;
    private b oQm;

    public static a ekz() {
        if (oQl == null) {
            synchronized (a.class) {
                if (oQl == null) {
                    oQl = new a();
                }
            }
        }
        return oQl;
    }

    public void b(TbPageContext tbPageContext, x xVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oQm = null;
        }
        this.oQm = new b(tbPageContext, xVar);
        this.oQm.show();
    }

    public void If() {
        if (this.oQm != null && this.oQm.isShowing()) {
            this.oQm.dismiss();
        }
    }
}
