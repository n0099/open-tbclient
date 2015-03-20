package com.baidu.tieba.pb.richview;

import android.content.Context;
import com.baidu.tieba.pb.richview.a.e;
import com.baidu.tieba.pb.richview.a.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class b {
    private ArrayList<com.baidu.tieba.pb.richview.a.c> xa = new ArrayList<>();

    public b(Context context) {
    }

    public ArrayList<com.baidu.tieba.pb.richview.a.c> getData() {
        return this.xa;
    }

    public void aQ(List<Content> list) {
        if (list != null && !list.isEmpty()) {
            f fVar = null;
            for (Content content : list) {
                if (content != null && content.type != null) {
                    if (a(content)) {
                        if (fVar == null) {
                            fVar = new f();
                        }
                        fVar.d(e.d(content).acw());
                    } else {
                        if (fVar != null) {
                            this.xa.add(fVar);
                        }
                        this.xa.add(e.c(content));
                        fVar = null;
                    }
                }
            }
            if (fVar != null) {
                this.xa.add(fVar);
            }
        }
    }

    private boolean a(Content content) {
        long longValue = content.type.longValue();
        return longValue == 2 || longValue == 0;
    }
}
