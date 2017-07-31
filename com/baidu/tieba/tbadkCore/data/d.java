package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList ghl;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.ghl = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList brY() {
        return this.ghl;
    }

    public Context getContext() {
        return this.mContext;
    }
}
