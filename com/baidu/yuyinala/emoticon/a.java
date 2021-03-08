package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private static a oYv;
    private TbPageContext mPageContext;
    private b oYw;

    public static a ejp() {
        if (oYv == null) {
            synchronized (a.class) {
                if (oYv == null) {
                    oYv = new a();
                }
            }
        }
        return oYv;
    }

    public void b(TbPageContext tbPageContext, ab abVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oYw = null;
        }
        this.oYw = new b(tbPageContext, abVar);
        this.oYw.show();
    }

    public void FD() {
        if (this.oYw != null && this.oYw.isShowing()) {
            this.oYw.dismiss();
        }
    }
}
