package com.baidu.tieba.pb.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.c.a.c;
import com.baidu.tieba.pb.c.a.d;
import com.baidu.tieba.pb.c.a.f;
import com.baidu.tieba.pb.c.a.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class a {
    private ArrayList<d> rM = new ArrayList<>();

    public ArrayList<d> getData() {
        return this.rM;
    }

    public void a(TbPageContext<?> tbPageContext, List<Content> list) {
        if (list != null && !list.isEmpty()) {
            g gVar = null;
            for (Content content : list) {
                if (content != null && content.type != null) {
                    if (a(content)) {
                        c a = f.a(tbPageContext, content);
                        if (a != null) {
                            if (a.afB()) {
                                if (gVar != null) {
                                    this.rM.add(gVar);
                                }
                                this.rM.add(a);
                                gVar = null;
                            } else {
                                g gVar2 = gVar == null ? new g() : gVar;
                                gVar2.d(a.afA());
                                gVar = gVar2;
                            }
                        }
                    } else {
                        if (gVar != null) {
                            this.rM.add(gVar);
                        }
                        this.rM.add(f.c(content));
                        gVar = null;
                    }
                }
            }
            if (gVar != null) {
                this.rM.add(gVar);
            }
        }
    }

    private boolean a(Content content) {
        long longValue = content.type.longValue();
        return longValue == 2 || longValue == 0 || longValue == 1;
    }
}
