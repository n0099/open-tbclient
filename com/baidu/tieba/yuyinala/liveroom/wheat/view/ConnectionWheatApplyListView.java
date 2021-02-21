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
/* loaded from: classes11.dex */
public class ConnectionWheatApplyListView extends BaseConnectionWheatListView {
    private b.a oDw;
    private g oGV;
    private boolean oHR;
    private c oHY;
    private e oHc;
    private boolean oIc;
    private b oLi;

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
    protected void dBf() {
        this.oLi = new b(getContext());
        this.oHW.setAdapter((ListAdapter) this.oLi);
        this.bwJ.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected ConnectionWheatButtonView.a getConnectionWheatButtonClickListener() {
        return new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eeg() {
                ConnectionWheatApplyListView.this.My(ConnectionWheatApplyListView.this.oIa);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eeh() {
                ConnectionWheatApplyListView.this.My(ConnectionWheatApplyListView.this.oIa < 5 ? ConnectionWheatApplyListView.this.oIa : 1);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eei() {
                ConnectionWheatApplyListView.this.My(ConnectionWheatApplyListView.this.oIa >= 5 ? ConnectionWheatApplyListView.this.oIa : 5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void My(int i) {
        if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecY()) {
            BdToast.makeText(getContext(), getContext().getString(a.h.yuyin_ala_relogin_join_chat)).show();
        } else if (!this.oHR) {
            MD(i);
        } else {
            if (this.oGV == null) {
                this.oGV = new g(this.oGE);
                this.oGV.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        ConnectionWheatApplyListView.this.oGV.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        ConnectionWheatApplyListView.this.edB();
                        ConnectionWheatApplyListView.this.oGV.dismiss();
                    }
                });
            }
            this.oGV.show();
            this.oGV.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edB() {
        if (this.oHc == null) {
            this.oHc = new e(this.oGE, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().ecJ();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        q.edM().Af(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oHc.ha(getRoomId(), "1");
    }

    private String getRoomId() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            Ak(false);
        }
    }

    private void MD(final int i) {
        d.edp().a(getContext(), this.oGE.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void Ab(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edo().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void ddy() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void edk() {
                            ConnectionWheatApplyListView.this.oIc = true;
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().ecI();
                            q.edM().Af(true);
                            ConnectionWheatApplyListView.this.Ak(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.oGE.getPageActivity(), "2", String.valueOf(i));
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void Ak(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oHY == null) {
            this.oHY = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.oGE, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.eed();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.eee();
                }
            });
        }
        this.oHY.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oLi != null) {
            return this.oLi.getCount();
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
        this.oHR = false;
        if (alaGetApplyWheatListHttpResponseMessage.eeF()) {
            this.oIb.setVisibility(8);
        } else {
            this.oIb.setVisibility(0);
            this.oIb.ah(alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.eeG());
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0 && alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
            i = alaGetApplyWheatListHttpResponseMessage.getPosition() - 1;
            this.oHR = true;
        }
        setData(alaGetApplyWheatListHttpResponseMessage.eeE(), i);
        if (this.oDw != null && this.oLi != null) {
            this.oDw.Mm(this.oLi.getCount());
        }
        if (this.oIc) {
            this.oIc = false;
            this.oHW.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.7
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionWheatApplyListView.this.oHW.smoothScrollToPosition(i);
                }
            });
        }
    }

    private void setData(List<com.baidu.live.data.e> list, int i) {
        if (this.oLi != null) {
            this.oLi.setData(list, i);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.oDw = aVar;
        if (this.oLi != null) {
            this.oLi.setOnItemClickLister(aVar);
        }
    }

    public void We(String str) {
        if (this.oLi != null) {
            this.oLi.We(str);
        }
        if (this.oDw != null && this.oLi != null) {
            this.oDw.Mm(this.oLi.getCount());
        }
    }

    public void onDestroy() {
        if (this.oHc != null) {
            this.oHc.onDestroy();
            this.oHc = null;
        }
        if (this.oHY != null) {
            this.oHY.onDestroy();
            this.oHY = null;
        }
    }
}
