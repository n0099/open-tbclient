package com.baidu.tieba.recommendfrs.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.mvc.model.q;
import java.text.SimpleDateFormat;
/* loaded from: classes.dex */
public class b {
    private a bXQ;
    private f bXR;
    private com.baidu.tieba.recommendfrs.data.d bXS = new com.baidu.tieba.recommendfrs.data.d();
    private e bXT;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.bXQ = new a(tbPageContext);
        this.bXR = new f(tbPageContext, this.bXS);
        this.bXQ.a(new c(this));
        this.bXR.a((q) new d(this));
    }

    public void FY() {
        this.bXQ.AL();
    }

    public void hM(int i) {
        this.bXS.hL(i);
        this.bXR.AT();
    }

    public static String hN(int i) {
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(i * 1000));
    }

    public void a(e eVar) {
        this.bXT = eVar;
    }
}
