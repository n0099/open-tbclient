package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList fpi;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.fpi = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bhn() {
        return this.fpi;
    }

    public Context getContext() {
        return this.mContext;
    }
}
