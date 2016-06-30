package com.baidu.tieba.person.god.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a ejF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ejF = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        boolean aLF;
        ViewEventCenter viewEventCenter3;
        ViewEventCenter viewEventCenter4;
        Activity activity;
        boolean aLF2;
        ViewEventCenter viewEventCenter5;
        ViewEventCenter viewEventCenter6;
        Activity activity2;
        textView = this.ejF.ejA;
        if (view != textView) {
            textView2 = this.ejF.ejz;
            if (view != textView2) {
                imageView = this.ejF.ejy;
                if (view == imageView) {
                    viewEventCenter = this.ejF.bfx;
                    if (viewEventCenter != null) {
                        viewEventCenter2 = this.ejF.bfx;
                        viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, null, null, null));
                        return;
                    }
                    return;
                }
                return;
            }
            aLF = this.ejF.aLF();
            if (!aLF) {
                activity = this.ejF.mActivity;
                k.showToast(activity.getApplicationContext(), u.j.plugin_config_not_found);
                return;
            }
            viewEventCenter3 = this.ejF.bfx;
            if (viewEventCenter3 != null) {
                viewEventCenter4 = this.ejF.bfx;
                viewEventCenter4.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
                return;
            }
            return;
        }
        aLF2 = this.ejF.aLF();
        if (!aLF2) {
            activity2 = this.ejF.mActivity;
            k.showToast(activity2.getApplicationContext(), u.j.plugin_config_not_found);
            return;
        }
        viewEventCenter5 = this.ejF.bfx;
        if (viewEventCenter5 != null) {
            viewEventCenter6 = this.ejF.bfx;
            viewEventCenter6.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, null, null, null));
        }
    }
}
