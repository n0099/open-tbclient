package com.baidu.tieba.pb;

import android.content.Context;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.pb.view.g;
import com.baidu.tieba.tbadkCore.data.j;
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.flow.a.d<j> {
    private g cHK;
    private a.InterfaceC0074a cHL;
    private Context mContext;

    public c(g gVar, Context context, a.InterfaceC0074a interfaceC0074a) {
        this.cHL = null;
        this.cHK = gVar;
        this.mContext = context;
        this.cHL = interfaceC0074a;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        if (this.cHL != null) {
            switch (i) {
                case 0:
                    this.cHL.u(str, "IMAGE1", "LINK_IMAGE");
                    break;
                case 1:
                    this.cHL.u(str, "IMAGE1", "LINK_IMAGE");
                    break;
                case 2:
                    this.cHL.u(str, "IMAGE2", "LINK_IMAGE");
                    break;
                case 3:
                    this.cHL.u(str, "IMAGE3", "LINK_IMAGE");
                    break;
            }
        }
        if (!aw.isEmpty(str)) {
            f.B(this.mContext, str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, j jVar) {
        if (this.cHK != null && jVar != null && this.cHK.cVC != null && this.cHK.cVD != null) {
            if (aw.isEmpty(jVar.aMb())) {
                this.cHK.cVC.setVisibility(8);
            } else {
                this.cHK.cVC.setText(jVar.aMb());
                this.cHK.cVC.setVisibility(0);
            }
            if (aw.isEmpty(jVar.tV())) {
                this.cHK.cVD.setVisibility(8);
            } else {
                this.cHK.cVD.setText(jVar.tV());
                this.cHK.cVD.setVisibility(0);
            }
            if (this.cHK.cVC.getVisibility() != 0 && this.cHK.cVD.getVisibility() != 0) {
                this.cHK.setVisibility(8);
            } else {
                this.cHK.af(jVar.rX(), i);
            }
            if (this.cHL != null && i <= this.cHL.aoo()) {
                switch (i) {
                    case 2:
                        this.cHL.u(jVar.rX(), "IMAGE2", "VIEW_CAROUSEL");
                        return;
                    case 3:
                        this.cHL.u(jVar.rX(), "IMAGE3", "VIEW_CAROUSEL");
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
