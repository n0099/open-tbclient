package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ConnectionWheatManagerListView extends BaseConnectionWheatListView {
    private d.a nTU;
    private d nZp;

    public ConnectionWheatManagerListView(@NonNull Context context) {
        this(context, null);
    }

    public ConnectionWheatManagerListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConnectionWheatManagerListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void initListener() {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dvw() {
        this.nZp = new d(getContext());
        this.nXJ.setAdapter((ListAdapter) this.nZp);
    }

    public void dWC() {
        zb(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            dWR();
        } else {
            dWS();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zb(boolean z) {
        this.nZp.LW(n.dWB().UL().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(n.dWB().UL());
        arrayList.addAll(n.dWB().UK());
        gd(arrayList);
        if (this.nTU != null && this.nZp != null) {
            this.nTU.LX(this.nZp.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.nZp != null) {
            return this.nZp.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.i.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gd(List<AlaWheatInfoData> list) {
        if (this.nZp != null) {
            this.nZp.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.nTU = aVar;
        if (this.nZp != null) {
            this.nZp.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
