package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList fBz;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.fBz = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bhG() {
        return this.fBz;
    }

    public Context getContext() {
        return this.mContext;
    }
}
