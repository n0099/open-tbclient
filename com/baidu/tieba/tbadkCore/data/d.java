package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList fBI;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.fBI = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList blI() {
        return this.fBI;
    }

    public Context getContext() {
        return this.mContext;
    }
}
