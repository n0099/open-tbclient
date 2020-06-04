package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList llp;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.llp = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList ddo() {
        return this.llp;
    }
}
