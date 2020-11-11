package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a otn;
    private TbPageContext mPageContext;
    private b oto;

    public static a eeD() {
        if (otn == null) {
            synchronized (a.class) {
                if (otn == null) {
                    otn = new a();
                }
            }
        }
        return otn;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oto = null;
        }
        this.oto = new b(tbPageContext, wVar);
        this.oto.show();
    }

    public void Hv() {
        if (this.oto != null && this.oto.isShowing()) {
            this.oto.dismiss();
        }
    }
}
