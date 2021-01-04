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
/* loaded from: classes11.dex */
public class ConnectionWheatManagerListView extends BaseConnectionWheatListView {
    private d oFP;
    private d.a oyd;

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
    protected void dCF() {
        this.oFP = new d(getContext());
        this.oCu.setAdapter((ListAdapter) this.oFP);
    }

    public void efg() {
        zV(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            efy();
        } else {
            efz();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zV(boolean z) {
        this.oFP.Ny(o.eff().aap().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(o.eff().aap());
        arrayList.addAll(o.eff().aao());
        gs(arrayList);
        if (this.oyd != null && this.oFP != null) {
            this.oyd.Nz(this.oFP.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oFP != null) {
            return this.oFP.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gs(List<AlaWheatInfoData> list) {
        if (this.oFP != null) {
            this.oFP.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.oyd = aVar;
        if (this.oFP != null) {
            this.oFP.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
