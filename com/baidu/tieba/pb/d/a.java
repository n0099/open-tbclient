package com.baidu.tieba.pb.d;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.d.a.e;
import com.baidu.tieba.pb.d.a.g;
import com.baidu.tieba.pb.d.a.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class a {
    private ArrayList<e> rQ = new ArrayList<>();

    public ArrayList<e> getData() {
        return this.rQ;
    }

    public void a(TbPageContext<?> tbPageContext, List<Content> list) {
        if (list != null && !list.isEmpty()) {
            h hVar = null;
            for (Content content : list) {
                if (content != null && content.type != null) {
                    if (a(content)) {
                        if (hVar == null) {
                            hVar = new h();
                        }
                        hVar.d(g.a(tbPageContext, content).adN());
                    } else {
                        if (hVar != null) {
                            this.rQ.add(hVar);
                        }
                        this.rQ.add(g.c(content));
                        hVar = null;
                    }
                }
            }
            if (hVar != null) {
                this.rQ.add(hVar);
            }
        }
    }

    private boolean a(Content content) {
        long longValue = content.type.longValue();
        return longValue == 2 || longValue == 0 || longValue == 1;
    }
}
