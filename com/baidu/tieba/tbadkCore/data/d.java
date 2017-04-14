package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList fvn;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.fvn = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bhL() {
        return this.fvn;
    }

    public Context getContext() {
        return this.mContext;
    }
}
