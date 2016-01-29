package com.baidu.tieba.pb.d;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.d.a.c;
import com.baidu.tieba.pb.d.a.d;
import com.baidu.tieba.pb.d.a.f;
import com.baidu.tieba.pb.d.a.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class a {
    private ArrayList<d> rV = new ArrayList<>();

    public ArrayList<d> getData() {
        return this.rV;
    }

    public void a(TbPageContext<?> tbPageContext, List<ExcContent> list) {
        if (list != null && !list.isEmpty()) {
            g gVar = null;
            for (ExcContent excContent : list) {
                if (excContent != null && excContent.type != null) {
                    if (a(excContent)) {
                        c a = f.a(tbPageContext, excContent);
                        if (a != null) {
                            if (a.asQ()) {
                                if (gVar != null) {
                                    this.rV.add(gVar);
                                }
                                this.rV.add(a);
                                gVar = null;
                            } else {
                                g gVar2 = gVar == null ? new g() : gVar;
                                gVar2.f(a.asP());
                                gVar = gVar2;
                            }
                        }
                    } else {
                        if (gVar != null) {
                            this.rV.add(gVar);
                        }
                        this.rV.add(f.c(excContent));
                        gVar = null;
                    }
                }
            }
            if (gVar != null) {
                this.rV.add(gVar);
            }
        }
    }

    private boolean a(ExcContent excContent) {
        long longValue = excContent.type.longValue();
        return longValue == 2 || longValue == 0 || longValue == 1;
    }
}
