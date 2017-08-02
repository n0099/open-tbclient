package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
/* loaded from: classes.dex */
public class d {
    private AbsDelegateAdapterList gga;
    private Context mContext;

    public d(Context context, AbsDelegateAdapterList absDelegateAdapterList) {
        this.mContext = context;
        this.gga = absDelegateAdapterList;
    }

    public AbsDelegateAdapterList brR() {
        return this.gga;
    }

    public Context getContext() {
        return this.mContext;
    }
}
