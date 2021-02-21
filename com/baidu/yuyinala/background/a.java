package com.baidu.yuyinala.background;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private static a oVM;
    private TbPageContext mPageContext;
    private b oVN;

    public static a eiN() {
        if (oVM == null) {
            synchronized (a.class) {
                if (oVM == null) {
                    oVM = new a();
                }
            }
        }
        return oVM;
    }

    public void b(TbPageContext tbPageContext, ab abVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oVN = null;
        }
        if (this.oVN == null) {
            this.oVN = new b(tbPageContext, abVar);
        }
        this.oVN.show();
    }

    public void FA() {
        if (this.oVN != null && this.oVN.isShowing()) {
            this.oVN.dismiss();
        }
    }
}
