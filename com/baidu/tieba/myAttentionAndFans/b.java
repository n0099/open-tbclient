package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> dJp = null;
    boolean fED = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean eY(long j);

    public void resetData() {
        this.dJp.clear();
    }

    public void bvW() {
        this.fED = false;
        if (this.dJp != null && this.dJp.size() == 0) {
            this.fED = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
