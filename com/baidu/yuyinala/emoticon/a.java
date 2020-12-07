package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a oJX;
    private TbPageContext mPageContext;
    private b oJY;

    public static a eko() {
        if (oJX == null) {
            synchronized (a.class) {
                if (oJX == null) {
                    oJX = new a();
                }
            }
        }
        return oJX;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oJY = null;
        }
        this.oJY = new b(tbPageContext, wVar);
        this.oJY.show();
    }

    public void ID() {
        if (this.oJY != null && this.oJY.isShowing()) {
            this.oJY.dismiss();
        }
    }
}
