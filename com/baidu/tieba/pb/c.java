package com.baidu.tieba.pb;

import android.content.Context;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.pb.view.g;
import com.baidu.tieba.tbadkCore.data.j;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.flow.a.d<j> {
    private g cBe;
    private a.InterfaceC0072a cBf;
    private Context mContext;

    public c(g gVar, Context context, a.InterfaceC0072a interfaceC0072a) {
        this.cBf = null;
        this.cBe = gVar;
        this.mContext = context;
        this.cBf = interfaceC0072a;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        if (this.cBf != null) {
            switch (i) {
                case 0:
                    this.cBf.t(str, "IMAGE1", "LINK_IMAGE");
                    break;
                case 1:
                    this.cBf.t(str, "IMAGE1", "LINK_IMAGE");
                    break;
                case 2:
                    this.cBf.t(str, "IMAGE2", "LINK_IMAGE");
                    break;
                case 3:
                    this.cBf.t(str, "IMAGE3", "LINK_IMAGE");
                    break;
            }
        }
        if (!ax.isEmpty(str)) {
            f.B(this.mContext, str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, j jVar) {
        if (this.cBe != null && jVar != null && this.cBe.cMO != null && this.cBe.cMP != null) {
            if (ax.isEmpty(jVar.aEV())) {
                this.cBe.cMO.setVisibility(8);
            } else {
                this.cBe.cMO.setText(jVar.aEV());
                this.cBe.cMO.setVisibility(0);
            }
            if (ax.isEmpty(jVar.sX())) {
                this.cBe.cMP.setVisibility(8);
            } else {
                this.cBe.cMP.setText(jVar.sX());
                this.cBe.cMP.setVisibility(0);
            }
            if (this.cBe.cMO.getVisibility() != 0 && this.cBe.cMP.getVisibility() != 0) {
                this.cBe.setVisibility(8);
            } else {
                this.cBe.ad(jVar.rt(), i);
            }
            if (this.cBf != null && i <= this.cBf.akq()) {
                switch (i) {
                    case 2:
                        this.cBf.t(jVar.rt(), "IMAGE2", "VIEW_CAROUSEL");
                        return;
                    case 3:
                        this.cBf.t(jVar.rt(), "IMAGE3", "VIEW_CAROUSEL");
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
