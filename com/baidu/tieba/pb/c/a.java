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
    private ArrayList<d> rK = new ArrayList<>();

    public ArrayList<d> getData() {
        return this.rK;
    }

    public void a(TbPageContext<?> tbPageContext, List<Content> list) {
        if (list != null && !list.isEmpty()) {
            g gVar = null;
            for (Content content : list) {
                if (content != null && content.type != null) {
                    if (a(content)) {
                        c a = f.a(tbPageContext, content);
                        if (a != null) {
                            if (a.ahR()) {
                                if (gVar != null) {
                                    this.rK.add(gVar);
                                }
                                this.rK.add(a);
                                gVar = null;
                            } else {
                                g gVar2 = gVar == null ? new g() : gVar;
                                gVar2.e(a.ahQ());
                                gVar = gVar2;
                            }
                        }
                    } else {
                        if (gVar != null) {
                            this.rK.add(gVar);
                        }
                        this.rK.add(f.c(content));
                        gVar = null;
                    }
                }
            }
            if (gVar != null) {
                this.rK.add(gVar);
            }
        }
    }

    private boolean a(Content content) {
        long longValue = content.type.longValue();
        return longValue == 2 || longValue == 0 || longValue == 1;
    }
}
