package com.baidu.yuyinala.background;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private static a oVm;
    private TbPageContext mPageContext;
    private b oVn;

    public static a eiF() {
        if (oVm == null) {
            synchronized (a.class) {
                if (oVm == null) {
                    oVm = new a();
                }
            }
        }
        return oVm;
    }

    public void b(TbPageContext tbPageContext, ab abVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oVn = null;
        }
        if (this.oVn == null) {
            this.oVn = new b(tbPageContext, abVar);
        }
        this.oVn.show();
    }

    public void FA() {
        if (this.oVn != null && this.oVn.isShowing()) {
            this.oVn.dismiss();
        }
    }
}
