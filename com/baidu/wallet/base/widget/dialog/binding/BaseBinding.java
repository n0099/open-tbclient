package com.baidu.wallet.base.widget.dialog.binding;

import android.content.Context;
import android.view.View;
import com.baidu.wallet.base.widget.dialog.model.BaseModel;
/* loaded from: classes5.dex */
public abstract class BaseBinding<T extends BaseModel> {
    public Context context;
    public View rootView;
    public T viewModel;

    public BaseBinding(View view) {
        this.rootView = view;
        this.context = view.getContext();
    }

    public abstract void executeBindings();

    public T getViewModel() {
        return this.viewModel;
    }

    public void setViewModel(T t) {
        this.viewModel = t;
        if (t != null) {
            executeBindings();
        }
    }
}
