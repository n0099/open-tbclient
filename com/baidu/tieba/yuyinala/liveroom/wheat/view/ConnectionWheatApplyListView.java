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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView;
import java.util.List;
/* loaded from: classes11.dex */
public class ConnectionWheatApplyListView extends BaseConnectionWheatListView {
    private e oBF;
    private g oBx;
    private boolean oCo;
    private c oCv;
    private boolean oCz;
    private b oFC;
    private b.a oxQ;

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
    protected void dCG() {
        this.oFC = new b(getContext());
        this.oCt.setAdapter((ListAdapter) this.oFC);
        this.bxT.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected ConnectionWheatButtonView.a getConnectionWheatButtonClickListener() {
        return new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efC() {
                ConnectionWheatApplyListView.this.NI(ConnectionWheatApplyListView.this.oCx);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efD() {
                ConnectionWheatApplyListView.this.NI(ConnectionWheatApplyListView.this.oCx < 5 ? ConnectionWheatApplyListView.this.oCx : 1);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efE() {
                ConnectionWheatApplyListView.this.NI(ConnectionWheatApplyListView.this.oCx >= 5 ? ConnectionWheatApplyListView.this.oCx : 5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NI(int i) {
        if (!this.oCo) {
            NN(i);
            return;
        }
        if (this.oBx == null) {
            this.oBx = new g(this.oAe);
            this.oBx.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    ConnectionWheatApplyListView.this.oBx.dismiss();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    ConnectionWheatApplyListView.this.eeY();
                    ConnectionWheatApplyListView.this.oBx.dismiss();
                }
            });
        }
        this.oBx.show();
        this.oBx.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeY() {
        if (this.oBF == null) {
            this.oBF = new e(this.oAe, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().eej();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.efg().zQ(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oBF.gS(getRoomId(), "1");
    }

    private String getRoomId() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zV(false);
        }
    }

    private void NN(final int i) {
        d.eeO().a(getContext(), this.oAe.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zM(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeN().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void dfl() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void eeI() {
                            ConnectionWheatApplyListView.this.oCz = true;
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().eei();
                            o.efg().zQ(true);
                            ConnectionWheatApplyListView.this.zV(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.oAe.getPageActivity(), "2", String.valueOf(i));
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zV(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oCv == null) {
            this.oCv = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.oAe, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.efz();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.efA();
                }
            });
        }
        this.oCv.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oFC != null) {
            return this.oFC.getCount();
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
        this.oCo = false;
        if (alaGetApplyWheatListHttpResponseMessage.egb()) {
            this.oCy.setVisibility(8);
        } else {
            this.oCy.setVisibility(0);
            this.oCy.aj(alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.egc());
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0 && alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
            i = alaGetApplyWheatListHttpResponseMessage.getPosition() - 1;
            this.oCo = true;
        }
        setData(alaGetApplyWheatListHttpResponseMessage.ega(), i);
        if (this.oxQ != null && this.oFC != null) {
            this.oxQ.Nx(this.oFC.getCount());
        }
        if (this.oCz) {
            this.oCz = false;
            this.oCt.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.7
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionWheatApplyListView.this.oCt.smoothScrollToPosition(i);
                }
            });
        }
    }

    private void setData(List<com.baidu.live.data.e> list, int i) {
        if (this.oFC != null) {
            this.oFC.setData(list, i);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.oxQ = aVar;
        if (this.oFC != null) {
            this.oFC.setOnItemClickLister(aVar);
        }
    }

    public void Wb(String str) {
        if (this.oFC != null) {
            this.oFC.Wb(str);
        }
        if (this.oxQ != null && this.oFC != null) {
            this.oxQ.Nx(this.oFC.getCount());
        }
    }

    public void onDestroy() {
        if (this.oBF != null) {
            this.oBF.onDestroy();
            this.oBF = null;
        }
        if (this.oCv != null) {
            this.oCv.onDestroy();
            this.oCv = null;
        }
    }
}
