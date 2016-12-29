package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList ffN;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.ffN = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bfx() {
        return this.ffN;
    }

    public Context getContext() {
        return this.mContext;
    }
}
