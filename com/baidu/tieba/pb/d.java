package com.baidu.tieba.pb;

import android.content.Context;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.view.g;
import com.baidu.tieba.tbadkCore.data.k;
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.flow.a.d<k> {
    private g daT;
    private b.a daU;
    private Context mContext;

    public d(g gVar, Context context, b.a aVar) {
        this.daU = null;
        this.daT = gVar;
        this.mContext = context;
        this.daU = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void g(int i, String str) {
        if (this.daU != null) {
            switch (i) {
                case 0:
                    this.daU.y(str, "IMAGE1", "LINK_IMAGE");
                    break;
                case 1:
                    this.daU.y(str, "IMAGE1", "LINK_IMAGE");
                    break;
                case 2:
                    this.daU.y(str, "IMAGE2", "LINK_IMAGE");
                    break;
                case 3:
                    this.daU.y(str, "IMAGE3", "LINK_IMAGE");
                    break;
            }
        }
        if (!ay.isEmpty(str)) {
            com.baidu.tbadk.browser.f.s(this.mContext, str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, k kVar) {
        if (this.daT != null && kVar != null && this.daT.dqx != null && this.daT.dqy != null) {
            if (ay.isEmpty(kVar.aSX())) {
                this.daT.dqx.setVisibility(8);
            } else {
                this.daT.dqx.setText(kVar.aSX());
                this.daT.dqx.setVisibility(0);
            }
            if (ay.isEmpty(kVar.getSubTitle())) {
                this.daT.dqy.setVisibility(8);
            } else {
                this.daT.dqy.setText(kVar.getSubTitle());
                this.daT.dqy.setVisibility(0);
            }
            if (this.daT.dqx.getVisibility() != 0 && this.daT.dqy.getVisibility() != 0) {
                this.daT.setVisibility(8);
            } else {
                this.daT.ao(kVar.rA(), i);
            }
            if (this.daU != null && i <= this.daU.avb()) {
                switch (i) {
                    case 2:
                        this.daU.y(kVar.rA(), "IMAGE2", "VIEW_CAROUSEL");
                        return;
                    case 3:
                        this.daU.y(kVar.rA(), "IMAGE3", "VIEW_CAROUSEL");
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
