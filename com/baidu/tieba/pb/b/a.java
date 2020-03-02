package com.baidu.tieba.pb.b;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.b.a.c;
import com.baidu.tieba.pb.b.a.d;
import com.baidu.tieba.pb.b.a.f;
import com.baidu.tieba.pb.b.a.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class a {
    private ArrayList<d> list = new ArrayList<>();

    public ArrayList<d> getData() {
        return this.list;
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
                            if (a.csh()) {
                                if (gVar2 != null) {
                                    this.list.add(gVar2);
                                }
                                this.list.add(a);
                                gVar = null;
                            } else {
                                gVar = gVar2 == null ? new g() : gVar2;
                                gVar.l(a.csg());
                            }
                        }
                    } else {
                        if (gVar2 != null) {
                            this.list.add(gVar2);
                        }
                        this.list.add(f.c(excContent));
                        gVar = null;
                    }
                    gVar2 = gVar;
                }
            }
            if (gVar2 != null) {
                this.list.add(gVar2);
            }
        }
    }

    private boolean a(ExcContent excContent) {
        long longValue = excContent.type.longValue();
        return longValue == 2 || longValue == 0 || longValue == 1;
    }
}
