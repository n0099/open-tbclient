package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList esf;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.esf = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList aTp() {
        return this.esf;
    }

    public Context getContext() {
        return this.mContext;
    }
}
