package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList eWT;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.eWT = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bbI() {
        return this.eWT;
    }

    public Context getContext() {
        return this.mContext;
    }
}
