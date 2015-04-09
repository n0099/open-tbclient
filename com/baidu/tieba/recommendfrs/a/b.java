package com.baidu.tieba.recommendfrs.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.mvc.model.q;
import java.text.SimpleDateFormat;
/* loaded from: classes.dex */
public class b {
    private a bYf;
    private f bYg;
    private com.baidu.tieba.recommendfrs.data.d bYh = new com.baidu.tieba.recommendfrs.data.d();
    private e bYi;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.bYf = new a(tbPageContext);
        this.bYg = new f(tbPageContext, this.bYh);
        this.bYf.a(new c(this));
        this.bYg.a((q) new d(this));
    }

    public void Ge() {
        this.bYf.AR();
    }

    public void hP(int i) {
        this.bYh.hO(i);
        this.bYg.AZ();
    }

    public static String hQ(int i) {
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(i * 1000));
    }

    public void a(e eVar) {
        this.bYi = eVar;
    }
}
