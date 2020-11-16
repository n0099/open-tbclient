package com.baidu.yuyinala.background;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a our;
    private TbPageContext mPageContext;
    private b ous;

    public static a een() {
        if (our == null) {
            synchronized (a.class) {
                if (our == null) {
                    our = new a();
                }
            }
        }
        return our;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.ous = null;
        }
        if (this.ous == null) {
            this.ous = new b(tbPageContext, wVar);
        }
        this.ous.show();
    }

    public void GM() {
        if (this.ous != null && this.ous.isShowing()) {
            this.ous.dismiss();
        }
    }
}
