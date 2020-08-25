package com.baidu.tieba.pb.interactionpopupwindow;

import android.view.ViewGroup;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes2.dex */
public interface g<D extends IBaseDialogData> {
    void a(D d);

    int getLayout();

    ViewGroup getViewGroup();

    void initView();
}
