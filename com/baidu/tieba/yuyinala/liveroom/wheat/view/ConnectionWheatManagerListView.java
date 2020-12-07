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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ConnectionWheatManagerListView extends BaseConnectionWheatListView {
    private d.a orN;
    private d oyx;

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
    protected void dCP() {
        this.oyx = new d(getContext());
        this.ovE.setAdapter((ListAdapter) this.oyx);
    }

    public void efe() {
        zU(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            efu();
        } else {
            efv();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zU(boolean z) {
        this.oyx.NI(o.efd().Za().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(o.efd().Za());
        arrayList.addAll(o.efd().YZ());
        gA(arrayList);
        if (this.orN != null && this.oyx != null) {
            this.orN.NJ(this.oyx.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oyx != null) {
            return this.oyx.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gA(List<AlaWheatInfoData> list) {
        if (this.oyx != null) {
            this.oyx.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.orN = aVar;
        if (this.oyx != null) {
            this.oyx.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
