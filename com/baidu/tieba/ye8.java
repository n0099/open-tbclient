package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes6.dex */
public interface ye8 extends IAdBaseAsyncController {
    View b(String str, boolean z);

    AdvertAppInfo d(String str);

    void e(String str, AdvertAppInfo advertAppInfo);

    boolean f(String str);

    void g(ah5 ah5Var);

    int getAdCount();

    void h(TbPageContext tbPageContext, DragImageView.h hVar, boolean z);

    void j(String str);

    void k(AdvertAppInfo advertAppInfo);

    void l();

    boolean n();

    void o(String str);

    void onDestroy();
}
