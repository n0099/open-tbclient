package com.baidu.tieba.pb.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.b.a.c;
import com.baidu.tieba.pb.b.a.d;
import com.baidu.tieba.pb.b.a.f;
import com.baidu.tieba.pb.b.a.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class a {
    private ArrayList<d> agb = new ArrayList<>();

    public ArrayList<d> getData() {
        return this.agb;
    }

    public void a(TbPageContext<?> tbPageContext, List<ExcContent> list) {
        g gVar;
        if (list != null && !list.isEmpty()) {
            g gVar2 = null;
            for (ExcContent excContent : list) {
                if (excContent != null && excContent.type != null) {
                    if (a(excContent)) {
                        c a = f.a(tbPageContext, excContent);
                        if (a != null) {
                            if (a.bhh()) {
                                if (gVar2 != null) {
                                    this.agb.add(gVar2);
                                }
                                this.agb.add(a);
                                gVar = null;
                            } else {
                                gVar = gVar2 == null ? new g() : gVar2;
                                gVar.t(a.bhg());
                            }
                        }
                    } else {
                        if (gVar2 != null) {
                            this.agb.add(gVar2);
                        }
                        this.agb.add(f.c(excContent));
                        gVar = null;
                    }
                    gVar2 = gVar;
                }
            }
            if (gVar2 != null) {
                this.agb.add(gVar2);
            }
        }
    }

    private boolean a(ExcContent excContent) {
        long longValue = excContent.type.longValue();
        return longValue == 2 || longValue == 0 || longValue == 1;
    }
}
