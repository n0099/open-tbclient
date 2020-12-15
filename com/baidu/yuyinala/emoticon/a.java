package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private static a oJZ;
    private TbPageContext mPageContext;
    private b oKa;

    public static a ekp() {
        if (oJZ == null) {
            synchronized (a.class) {
                if (oJZ == null) {
                    oJZ = new a();
                }
            }
        }
        return oJZ;
    }

    public void b(TbPageContext tbPageContext, w wVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oKa = null;
        }
        this.oKa = new b(tbPageContext, wVar);
        this.oKa.show();
    }

    public void ID() {
        if (this.oKa != null && this.oKa.isShowing()) {
            this.oKa.dismiss();
        }
    }
}
