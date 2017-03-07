package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList ftE;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.ftE = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bha() {
        return this.ftE;
    }

    public Context getContext() {
        return this.mContext;
    }
}
