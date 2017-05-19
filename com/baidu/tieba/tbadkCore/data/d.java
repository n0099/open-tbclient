package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList ftI;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.ftI = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList bgj() {
        return this.ftI;
    }

    public Context getContext() {
        return this.mContext;
    }
}
