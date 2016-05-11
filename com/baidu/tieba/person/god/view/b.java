package com.baidu.tieba.person.god.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a dBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dBa = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        boolean aCI;
        ViewEventCenter viewEventCenter3;
        ViewEventCenter viewEventCenter4;
        Activity activity;
        boolean aCI2;
        ViewEventCenter viewEventCenter5;
        ViewEventCenter viewEventCenter6;
        Activity activity2;
        textView = this.dBa.dAV;
        if (view != textView) {
            textView2 = this.dBa.dAU;
            if (view != textView2) {
                imageView = this.dBa.dAT;
                if (view == imageView) {
                    viewEventCenter = this.dBa.aXs;
                    if (viewEventCenter != null) {
                        viewEventCenter2 = this.dBa.aXs;
                        viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, null, null, null));
                        return;
                    }
                    return;
                }
                return;
            }
            aCI = this.dBa.aCI();
            if (!aCI) {
                activity = this.dBa.mActivity;
                k.showToast(activity.getApplicationContext(), t.j.plugin_config_not_found);
                return;
            }
            viewEventCenter3 = this.dBa.aXs;
            if (viewEventCenter3 != null) {
                viewEventCenter4 = this.dBa.aXs;
                viewEventCenter4.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
                return;
            }
            return;
        }
        aCI2 = this.dBa.aCI();
        if (!aCI2) {
            activity2 = this.dBa.mActivity;
            k.showToast(activity2.getApplicationContext(), t.j.plugin_config_not_found);
            return;
        }
        viewEventCenter5 = this.dBa.aXs;
        if (viewEventCenter5 != null) {
            viewEventCenter6 = this.dBa.aXs;
            viewEventCenter6.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, null, null, null));
        }
    }
}
