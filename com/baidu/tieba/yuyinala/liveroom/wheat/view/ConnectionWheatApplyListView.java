package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView;
import java.util.List;
/* loaded from: classes10.dex */
public class ConnectionWheatApplyListView extends BaseConnectionWheatListView {
    private b.a oFB;
    private boolean oJW;
    private g oJa;
    private e oJh;
    private c oKd;
    private boolean oKh;
    private b oNn;

    public ConnectionWheatApplyListView(@NonNull Context context) {
        this(context, null);
    }

    public ConnectionWheatApplyListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConnectionWheatApplyListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void initListener() {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dBn() {
        this.oNn = new b(getContext());
        this.oKb.setAdapter((ListAdapter) this.oNn);
        this.byj.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected ConnectionWheatButtonView.a getConnectionWheatButtonClickListener() {
        return new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eeo() {
                ConnectionWheatApplyListView.this.MC(ConnectionWheatApplyListView.this.oKf);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eep() {
                ConnectionWheatApplyListView.this.MC(ConnectionWheatApplyListView.this.oKf < 5 ? ConnectionWheatApplyListView.this.oKf : 1);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eeq() {
                ConnectionWheatApplyListView.this.MC(ConnectionWheatApplyListView.this.oKf >= 5 ? ConnectionWheatApplyListView.this.oKf : 5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MC(int i) {
        if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edg()) {
            BdToast.makeText(getContext(), getContext().getString(a.h.yuyin_ala_relogin_join_chat)).show();
        } else if (!this.oJW) {
            MH(i);
        } else {
            if (this.oJa == null) {
                this.oJa = new g(this.oIJ);
                this.oJa.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        ConnectionWheatApplyListView.this.oJa.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        ConnectionWheatApplyListView.this.edJ();
                        ConnectionWheatApplyListView.this.oJa.dismiss();
                    }
                });
            }
            this.oJa.show();
            this.oJa.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edJ() {
        if (this.oJh == null) {
            this.oJh = new e(this.oIJ, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().ecR();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        q.edU().Ae(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oJh.ha(getRoomId(), "1");
    }

    private String getRoomId() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            Aj(false);
        }
    }

    private void MH(final int i) {
        d.edx().a(getContext(), this.oIJ.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void Aa(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edw().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void ddH() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void eds() {
                            ConnectionWheatApplyListView.this.oKh = true;
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().ecQ();
                            q.edU().Ae(true);
                            ConnectionWheatApplyListView.this.Aj(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.oIJ.getPageActivity(), "2", String.valueOf(i));
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void Aj(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oKd == null) {
            this.oKd = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.oIJ, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.eel();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.eem();
                }
            });
        }
        this.oKd.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oNn != null) {
            return this.oNn.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_empty_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
        final int i = -1;
        if (alaGetApplyWheatListHttpResponseMessage == null) {
            setData(null, -1);
            return;
        }
        this.oJW = false;
        if (alaGetApplyWheatListHttpResponseMessage.eeN()) {
            this.oKg.setVisibility(8);
        } else {
            this.oKg.setVisibility(0);
            this.oKg.ah(alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.eeO());
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0 && alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
            i = alaGetApplyWheatListHttpResponseMessage.getPosition() - 1;
            this.oJW = true;
        }
        setData(alaGetApplyWheatListHttpResponseMessage.eeM(), i);
        if (this.oFB != null && this.oNn != null) {
            this.oFB.Mq(this.oNn.getCount());
        }
        if (this.oKh) {
            this.oKh = false;
            this.oKb.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.7
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionWheatApplyListView.this.oKb.smoothScrollToPosition(i);
                }
            });
        }
    }

    private void setData(List<com.baidu.live.data.e> list, int i) {
        if (this.oNn != null) {
            this.oNn.setData(list, i);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.oFB = aVar;
        if (this.oNn != null) {
            this.oNn.setOnItemClickLister(aVar);
        }
    }

    public void Wl(String str) {
        if (this.oNn != null) {
            this.oNn.Wl(str);
        }
        if (this.oFB != null && this.oNn != null) {
            this.oFB.Mq(this.oNn.getCount());
        }
    }

    public void onDestroy() {
        if (this.oJh != null) {
            this.oJh.onDestroy();
            this.oJh = null;
        }
        if (this.oKd != null) {
            this.oKd.onDestroy();
            this.oKd = null;
        }
    }
}
