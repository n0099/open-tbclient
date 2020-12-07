package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private Context mContext;
    private AbsDelegateAdapterList nlf;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.nlf = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList dOM() {
        return this.nlf;
    }
}
