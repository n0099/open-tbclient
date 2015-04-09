package com.baidu.tieba.pb.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TbRichView extends LinearLayout {
    private c bOx;

    public TbRichView(Context context) {
        super(context);
        init();
    }

    public TbRichView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setOrientation(1);
        setOnHierarchyChangeListener(new a(this));
    }

    public void setViewProxy(c cVar) {
        this.bOx = cVar;
    }

    public void P(ArrayList<com.baidu.tieba.pb.richview.a.c> arrayList) {
        View a;
        removeAllViews();
        if (arrayList != null && arrayList.size() > 0 && this.bOx != null) {
            Iterator<com.baidu.tieba.pb.richview.a.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.richview.a.c next = it.next();
                if (next != null && (a = this.bOx.a(next)) != null) {
                    addView(a);
                }
            }
        }
    }
}
