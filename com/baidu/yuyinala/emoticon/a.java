package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a oki;
    private TbPageContext mPageContext;
    private b okj;

    public static a eaV() {
        if (oki == null) {
            synchronized (a.class) {
                if (oki == null) {
                    oki = new a();
                }
            }
        }
        return oki;
    }

    public void a(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.okj = null;
        }
        this.okj = new b(tbPageContext, wVar);
        this.okj.show();
    }

    public void GU() {
        if (this.okj != null && this.okj.isShowing()) {
            this.okj.dismiss();
        }
    }
}
