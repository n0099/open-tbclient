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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ConnectionWheatManagerListView extends BaseConnectionWheatListView {
    private d oBj;
    private d.a otw;

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
    protected void dyO() {
        this.oBj = new d(getContext());
        this.oxO.setAdapter((ListAdapter) this.oBj);
    }

    public void ebp() {
        zR(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            ebH();
        } else {
            ebI();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zR(boolean z) {
        this.oBj.LR(o.ebo().Wx().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(o.ebo().Wx());
        arrayList.addAll(o.ebo().Ww());
        gs(arrayList);
        if (this.otw != null && this.oBj != null) {
            this.otw.LS(this.oBj.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oBj != null) {
            return this.oBj.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gs(List<AlaWheatInfoData> list) {
        if (this.oBj != null) {
            this.oBj.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.otw = aVar;
        if (this.oBj != null) {
            this.oBj.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
