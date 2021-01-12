package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private static a oLJ;
    private TbPageContext mPageContext;
    private b oLK;

    public static a egF() {
        if (oLJ == null) {
            synchronized (a.class) {
                if (oLJ == null) {
                    oLJ = new a();
                }
            }
        }
        return oLJ;
    }

    public void b(TbPageContext tbPageContext, x xVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oLK = null;
        }
        this.oLK = new b(tbPageContext, xVar);
        this.oLK.show();
    }

    public void Ek() {
        if (this.oLK != null && this.oLK.isShowing()) {
            this.oLK.dismiss();
        }
    }
}
