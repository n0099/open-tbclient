package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private Context mContext;
    private List<e> mItems = new ArrayList();
    private int mViewType;

    public c(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void c(e eVar) {
        this.mItems.add(eVar);
    }

    public List<e> ekL() {
        return this.mItems;
    }

    public void setViewType(int i) {
        this.mViewType = i;
    }
}
