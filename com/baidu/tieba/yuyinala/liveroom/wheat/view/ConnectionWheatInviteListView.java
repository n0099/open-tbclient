package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.data.m;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetInviteConnectionWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.f;
import java.util.List;
/* loaded from: classes4.dex */
public class ConnectionWheatInviteListView extends BaseConnectionWheatListView {
    private c oyw;
    private f oyx;

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
    protected void dCQ() {
        this.oyw = new c(getContext());
        this.ovG.setAdapter((ListAdapter) this.oyw);
        this.btg.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zU(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oyx == null) {
            this.oyx = new f(this.otA, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void a(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage) {
                    ConnectionWheatInviteListView.this.b(alaGetInviteConnectionWheatListHttpResponseMessage);
                    ConnectionWheatInviteListView.this.hideLoading();
                    ConnectionWheatInviteListView.this.efv();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.f.a
                public void onFail(int i, String str) {
                    ConnectionWheatInviteListView.this.b(null);
                    ConnectionWheatInviteListView.this.hideLoading();
                    ConnectionWheatInviteListView.this.efw();
                }
            });
        }
        this.oyx.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oyw != null) {
            return this.oyw.getCount();
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
            this.oyb.setVisibility(0);
            this.oyb.setText(String.format(getContext().getString(a.h.yuyin_ala_connection_wheat_online_audience_counts_text), Integer.valueOf(alaGetInviteConnectionWheatListHttpResponseMessage.getCount())));
        } else {
            this.oyb.setVisibility(8);
        }
        setData(alaGetInviteConnectionWheatListHttpResponseMessage.efS());
    }

    private void setData(List<m> list) {
        if (this.oyw != null) {
            this.oyw.setData(list);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void setTbPageContext(TbPageContext tbPageContext) {
        this.otA = tbPageContext;
    }

    public void setOnItemClickLister(c.a aVar) {
        if (this.oyw != null) {
            this.oyw.setOnItemClickLister(aVar);
        }
    }

    public void onDestroy() {
        if (this.oyw != null) {
            this.oyw.clear();
        }
        if (this.oyx != null) {
            this.oyx.onDestroy();
            this.oyx = null;
        }
    }
}
