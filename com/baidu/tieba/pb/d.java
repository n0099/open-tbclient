package com.baidu.tieba.pb;

import android.content.Context;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.view.m;
import com.baidu.tieba.tbadkCore.data.k;
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.flow.a.d<k> {
    private m ddn;
    private b.a ddo;
    private Context mContext;

    public d(m mVar, Context context, b.a aVar) {
        this.ddo = null;
        this.ddn = mVar;
        this.mContext = context;
        this.ddo = aVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void g(int i, String str) {
        if (this.ddo != null) {
            switch (i) {
                case 0:
                    this.ddo.z(str, "IMAGE1", "LINK_IMAGE");
                    break;
                case 1:
                    this.ddo.z(str, "IMAGE1", "LINK_IMAGE");
                    break;
                case 2:
                    this.ddo.z(str, "IMAGE2", "LINK_IMAGE");
                    break;
                case 3:
                    this.ddo.z(str, "IMAGE3", "LINK_IMAGE");
                    break;
            }
        }
        if (!ay.isEmpty(str)) {
            com.baidu.tbadk.browser.f.t(this.mContext, str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, k kVar) {
        if (this.ddn != null && kVar != null && this.ddn.dsB != null && this.ddn.dsC != null) {
            if (ay.isEmpty(kVar.aTE())) {
                this.ddn.dsB.setVisibility(8);
            } else {
                this.ddn.dsB.setText(kVar.aTE());
                this.ddn.dsB.setVisibility(0);
            }
            if (ay.isEmpty(kVar.getSubTitle())) {
                this.ddn.dsC.setVisibility(8);
            } else {
                this.ddn.dsC.setText(kVar.getSubTitle());
                this.ddn.dsC.setVisibility(0);
            }
            if (this.ddn.dsB.getVisibility() != 0 && this.ddn.dsC.getVisibility() != 0) {
                this.ddn.setVisibility(8);
            } else {
                this.ddn.as(kVar.oU(), i);
            }
            if (this.ddo != null && i <= this.ddo.avk()) {
                switch (i) {
                    case 2:
                        this.ddo.z(kVar.oU(), "IMAGE2", "VIEW_CAROUSEL");
                        return;
                    case 3:
                        this.ddo.z(kVar.oU(), "IMAGE3", "VIEW_CAROUSEL");
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
