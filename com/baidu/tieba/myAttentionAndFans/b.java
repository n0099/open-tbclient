package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.be;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> eTF = null;
    boolean hgz = false;
    private boolean mHasMore = false;

    public abstract void a(be beVar);

    public abstract boolean hh(long j);

    public void resetData() {
        this.eTF.clear();
    }

    public void bXr() {
        this.hgz = false;
        if (this.eTF != null && this.eTF.size() == 0) {
            this.hgz = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
