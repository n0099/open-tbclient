package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList ghF;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.ghF = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList brO() {
        return this.ghF;
    }

    public Context getContext() {
        return this.mContext;
    }
}
