package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.data.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class ConnectionWheatApplyListView extends BaseConnectionWheatListView {
    private b.a nTK;
    private g nWI;
    private d nWP;
    private boolean nXE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.b nXL;
    private b nZj;

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
        this.nXN.setOnClickListener(this);
        this.nXN.setOnTouchListener(new a());
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dvw() {
        this.nZj = new b(getContext());
        this.nXJ.setAdapter((ListAdapter) this.nZj);
        this.boq.setRefreshButton(getResources().getString(a.i.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nXN) {
            if (!this.nXE) {
                dXf();
                return;
            }
            if (this.nWI == null) {
                this.nWI = new g(this.nVE);
                this.nWI.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        ConnectionWheatApplyListView.this.nWI.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        ConnectionWheatApplyListView.this.dWt();
                        ConnectionWheatApplyListView.this.nWI.dismiss();
                    }
                });
            }
            this.nWI.show();
            this.nWI.setText(getContext().getString(a.i.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWt() {
        if (this.nWP == null) {
            this.nWP = new d(this.nVE, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        c.dVV().dVX().dVP();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        n.dWB().yW(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.i.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.nWP.gN(getRoomId(), "1");
    }

    private String getRoomId() {
        return c.dVV().dWa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zb(false);
        }
    }

    private void dXf() {
        com.baidu.tieba.yuyinala.liveroom.wheat.b.d.dWl().a(getContext(), this.nVE.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.d.a
            public void yR(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.b.c.dWj().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a
                        public void cYn() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a
                        public void dWk() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().dVO();
                            n.dWB().yW(true);
                            ConnectionWheatApplyListView.this.zb(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.i.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.nVE.getPageActivity(), "2");
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zb(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.nXL == null) {
            this.nXL = new com.baidu.tieba.yuyinala.liveroom.wheat.c.b(this.nVE, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.dWR();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.b.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.dWS();
                }
            });
        }
        this.nXL.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.nZj != null) {
            return this.nZj.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.i.yuyin_ala_connection_wheat_empty_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
        if (alaGetApplyWheatListHttpResponseMessage == null) {
            setData(null);
            return;
        }
        this.nXE = false;
        if (alaGetApplyWheatListHttpResponseMessage.dXc()) {
            this.nXO.setVisibility(8);
        } else {
            this.nXO.setVisibility(0);
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0) {
            if (alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
                this.nXE = true;
                this.nXN.setText(getContext().getString(a.i.yuyin_ala_connection_wheat_cancel_text));
            } else {
                this.nXN.setText(getContext().getString(a.i.yuyin_ala_connection_wheat_request_text));
            }
        } else {
            this.nXN.setText(getContext().getString(a.i.yuyin_ala_connection_wheat_request_text));
        }
        setData(alaGetApplyWheatListHttpResponseMessage.dXb());
        if (this.nTK != null && this.nZj != null) {
            this.nTK.LV(this.nZj.getCount());
        }
    }

    private void setData(List<e> list) {
        if (this.nZj != null) {
            this.nZj.setData(list);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.nTK = aVar;
        if (this.nZj != null) {
            this.nZj.setOnItemClickLister(aVar);
        }
    }

    public void Vc(String str) {
        if (this.nZj != null) {
            this.nZj.Vc(str);
        }
        if (this.nTK != null && this.nZj != null) {
            this.nTK.LV(this.nZj.getCount());
        }
    }

    public void onDestroy() {
        if (this.nWP != null) {
            this.nWP.onDestroy();
            this.nWP = null;
        }
        if (this.nXL != null) {
            this.nXL.onDestroy();
            this.nXL = null;
        }
    }
}
