package com.baidu.tieba.person.god.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a ddt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ddt = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        ViewEventCenter viewEventCenter4;
        ViewEventCenter viewEventCenter5;
        ViewEventCenter viewEventCenter6;
        textView = this.ddt.ddo;
        if (view != textView) {
            textView2 = this.ddt.ddn;
            if (view != textView2) {
                imageView = this.ddt.ddm;
                if (view == imageView) {
                    viewEventCenter = this.ddt.aWA;
                    if (viewEventCenter != null) {
                        viewEventCenter2 = this.ddt.aWA;
                        viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, null, null, null));
                        return;
                    }
                    return;
                }
                return;
            }
            viewEventCenter3 = this.ddt.aWA;
            if (viewEventCenter3 != null) {
                viewEventCenter4 = this.ddt.aWA;
                viewEventCenter4.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
                return;
            }
            return;
        }
        viewEventCenter5 = this.ddt.aWA;
        if (viewEventCenter5 != null) {
            viewEventCenter6 = this.ddt.aWA;
            viewEventCenter6.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, null, null, null));
        }
    }
}
