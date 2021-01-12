package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.data.n;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetInviteConnectionWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.g;
import java.util.List;
/* loaded from: classes10.dex */
public class ConnectionWheatInviteListView extends BaseConnectionWheatListView {
    private c oBg;
    private g oBh;

    public ConnectionWheatInviteListView(@NonNull Context context) {
        this(context, null);
    }

    public ConnectionWheatInviteListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConnectionWheatInviteListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void initListener() {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dyO() {
        this.oBg = new c(getContext());
        this.oxO.setAdapter((ListAdapter) this.oBg);
        this.btf.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zR(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oBh == null) {
            this.oBh = new g(this.ovz, new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
                public void a(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage) {
                    ConnectionWheatInviteListView.this.b(alaGetInviteConnectionWheatListHttpResponseMessage);
                    ConnectionWheatInviteListView.this.hideLoading();
                    ConnectionWheatInviteListView.this.ebH();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
                public void onFail(int i, String str) {
                    ConnectionWheatInviteListView.this.b(null);
                    ConnectionWheatInviteListView.this.hideLoading();
                    ConnectionWheatInviteListView.this.ebI();
                }
            });
        }
        this.oBh.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oBg != null) {
            return this.oBg.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage) {
        if (alaGetInviteConnectionWheatListHttpResponseMessage == null) {
            setData(null);
            return;
        }
        if (alaGetInviteConnectionWheatListHttpResponseMessage.getCount() > 0) {
            this.oAu.setVisibility(0);
            this.oAu.setText(String.format(getContext().getString(a.h.yuyin_ala_connection_wheat_online_audience_counts_text), Integer.valueOf(alaGetInviteConnectionWheatListHttpResponseMessage.getCount())));
        } else {
            this.oAu.setVisibility(8);
        }
        setData(alaGetInviteConnectionWheatListHttpResponseMessage.ecl());
    }

    private void setData(List<n> list) {
        if (this.oBg != null) {
            this.oBg.setData(list);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void setTbPageContext(TbPageContext tbPageContext) {
        this.ovz = tbPageContext;
    }

    public void setOnItemClickLister(c.a aVar) {
        if (this.oBg != null) {
            this.oBg.setOnItemClickLister(aVar);
        }
    }

    public void onDestroy() {
        if (this.oBg != null) {
            this.oBg.clear();
        }
        if (this.oBh != null) {
            this.oBh.onDestroy();
            this.oBh = null;
        }
    }
}
