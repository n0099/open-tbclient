package com.baidu.yuyinala.emoticon;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a {
    private static a oVQ;
    private TbPageContext mPageContext;
    private b oVR;

    public static a eiX() {
        if (oVQ == null) {
            synchronized (a.class) {
                if (oVQ == null) {
                    oVQ = new a();
                }
            }
        }
        return oVQ;
    }

    public void b(TbPageContext tbPageContext, ab abVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oVR = null;
        }
        this.oVR = new b(tbPageContext, abVar);
        this.oVR.show();
    }

    public void FA() {
        if (this.oVR != null && this.oVR.isShowing()) {
            this.oVR.dismiss();
        }
    }
}
