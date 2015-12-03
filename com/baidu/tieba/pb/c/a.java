package com.baidu.tieba.pb.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.c.a.c;
import com.baidu.tieba.pb.c.a.d;
import com.baidu.tieba.pb.c.a.f;
import com.baidu.tieba.pb.c.a.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class a {
    private ArrayList<d> list = new ArrayList<>();

    public ArrayList<d> getData() {
        return this.list;
    }

    public void a(TbPageContext<?> tbPageContext, List<ExcContent> list) {
        if (list != null && !list.isEmpty()) {
            g gVar = null;
            for (ExcContent excContent : list) {
                if (excContent != null && excContent.type != null) {
                    if (a(excContent)) {
                        c a = f.a(tbPageContext, excContent);
                        if (a != null) {
                            if (a.amW()) {
                                if (gVar != null) {
                                    this.list.add(gVar);
                                }
                                this.list.add(a);
                                gVar = null;
                            } else {
                                g gVar2 = gVar == null ? new g() : gVar;
                                gVar2.g(a.amV());
                                gVar = gVar2;
                            }
                        }
                    } else {
                        if (gVar != null) {
                            this.list.add(gVar);
                        }
                        this.list.add(f.c(excContent));
                        gVar = null;
                    }
                }
            }
            if (gVar != null) {
                this.list.add(gVar);
            }
        }
    }

    private boolean a(ExcContent excContent) {
        long longValue = excContent.type.longValue();
        return longValue == 2 || longValue == 0 || longValue == 1;
    }
}
