package com.baidu.yuyinala.background;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a oJy;
    private TbPageContext mPageContext;
    private b oJz;

    public static a eka() {
        if (oJy == null) {
            synchronized (a.class) {
                if (oJy == null) {
                    oJy = new a();
                }
            }
        }
        return oJy;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oJz = null;
        }
        if (this.oJz == null) {
            this.oJz = new b(tbPageContext, wVar);
        }
        this.oJz.show();
    }

    public void ID() {
        if (this.oJz != null && this.oJz.isShowing()) {
            this.oJz.dismiss();
        }
    }
}
