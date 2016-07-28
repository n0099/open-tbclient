package com.baidu.tieba.person.god.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.personInfo.h;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a etQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.etQ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        ImageView imageView;
        TbImageView tbImageView;
        String str;
        h hVar;
        String str2;
        TextView textView3;
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        boolean aOi;
        ViewEventCenter viewEventCenter3;
        ViewEventCenter viewEventCenter4;
        Activity activity;
        boolean aOi2;
        ViewEventCenter viewEventCenter5;
        ViewEventCenter viewEventCenter6;
        Activity activity2;
        textView = this.etQ.etL;
        if (view != textView) {
            textView2 = this.etQ.etK;
            if (view != textView2) {
                imageView = this.etQ.etG;
                if (view != imageView) {
                    tbImageView = this.etQ.etx;
                    if (view != tbImageView) {
                        textView3 = this.etQ.etJ;
                        if (view != textView3) {
                            return;
                        }
                    }
                    str = this.etQ.ety;
                    if (!StringUtils.isNull(str)) {
                        bi us = bi.us();
                        hVar = this.etQ.epz;
                        TbPageContext<BaseFragmentActivity> pageContext = hVar.getPageContext();
                        str2 = this.etQ.ety;
                        us.c(pageContext, new String[]{str2});
                        return;
                    }
                    return;
                }
                viewEventCenter = this.etQ.bgJ;
                if (viewEventCenter != null) {
                    viewEventCenter2 = this.etQ.bgJ;
                    viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, null, null, null));
                    return;
                }
                return;
            }
            aOi = this.etQ.aOi();
            if (!aOi) {
                activity = this.etQ.mActivity;
                k.showToast(activity.getApplicationContext(), u.j.plugin_config_not_found);
                return;
            }
            viewEventCenter3 = this.etQ.bgJ;
            if (viewEventCenter3 != null) {
                viewEventCenter4 = this.etQ.bgJ;
                viewEventCenter4.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
                return;
            }
            return;
        }
        aOi2 = this.etQ.aOi();
        if (!aOi2) {
            activity2 = this.etQ.mActivity;
            k.showToast(activity2.getApplicationContext(), u.j.plugin_config_not_found);
            return;
        }
        viewEventCenter5 = this.etQ.bgJ;
        if (viewEventCenter5 != null) {
            viewEventCenter6 = this.etQ.bgJ;
            viewEventCenter6.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, null, null, null));
        }
    }
}
