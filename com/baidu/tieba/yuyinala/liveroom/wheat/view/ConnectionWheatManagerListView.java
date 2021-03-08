package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ConnectionWheatManagerListView extends BaseConnectionWheatListView {
    private d.a oFN;
    private d oNz;

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
    protected void dBn() {
        this.oNz = new d(getContext());
        this.oKb.setAdapter((ListAdapter) this.oNz);
    }

    public void edV() {
        Aj(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            eel();
        } else {
            eem();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void Aj(boolean z) {
        this.oNz.Mr(q.edU().Yq().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(q.edU().Yq());
        arrayList.addAll(q.edU().Yp());
        gq(arrayList);
        if (this.oFN != null && this.oNz != null) {
            this.oFN.Ms(this.oNz.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oNz != null) {
            return this.oNz.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gq(List<AlaWheatInfoData> list) {
        if (this.oNz != null) {
            this.oNz.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.oFN = aVar;
        if (this.oNz != null) {
            this.oNz.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
