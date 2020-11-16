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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.d;
import java.util.List;
/* loaded from: classes4.dex */
public class ConnectionWheatApplyListView extends BaseConnectionWheatListView {
    private b.a ocC;
    private g ofL;
    private d ofS;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.b ogG;
    private boolean ogz;
    private b ojp;

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
        this.ogI.setOnClickListener(this);
        this.ogI.setOnTouchListener(new a());
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dxy() {
        this.ojp = new b(getContext());
        this.ogE.setAdapter((ListAdapter) this.ojp);
        this.bnY.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ogI) {
            if (!this.ogz) {
                Nd(this.ogL);
                return;
            }
            if (this.ofL == null) {
                this.ofL = new g(this.oey);
                this.ofL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        ConnectionWheatApplyListView.this.ofL.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        ConnectionWheatApplyListView.this.dZr();
                        ConnectionWheatApplyListView.this.ofL.dismiss();
                    }
                });
            }
            this.ofL.show();
            this.ofL.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZr() {
        if (this.ofS == null) {
            this.ofS = new d(this.oey, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        c.dYK().dYM().dYE();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.dZz().zk(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.ofS.gP(getRoomId(), "1");
    }

    private String getRoomId() {
        return c.dYK().Br();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zq(false);
        }
    }

    private void Nd(final int i) {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.d.dZi().a(getContext(), this.oey.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zg(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZh().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void dal() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void dZc() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().dYD();
                            o.dZz().zk(true);
                            ConnectionWheatApplyListView.this.zq(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.oey.getPageActivity(), "2", String.valueOf(i));
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zq(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.ogG == null) {
            this.ogG = new com.baidu.tieba.yuyinala.liveroom.wheat.model.b(this.oey, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.dZP();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.dZQ();
                }
            });
        }
        this.ogG.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.ojp != null) {
            return this.ojp.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_empty_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
        if (alaGetApplyWheatListHttpResponseMessage == null) {
            setData(null);
            return;
        }
        this.ogz = false;
        if (alaGetApplyWheatListHttpResponseMessage.eal()) {
            this.ogJ.setVisibility(8);
        } else {
            this.ogJ.setVisibility(0);
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0) {
            if (alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
                this.ogz = true;
                this.ogI.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
            } else {
                this.ogI.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            }
        } else {
            this.ogI.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        }
        setData(alaGetApplyWheatListHttpResponseMessage.eak());
        if (this.ocC != null && this.ojp != null) {
            this.ocC.MP(this.ojp.getCount());
        }
    }

    private void setData(List<e> list) {
        if (this.ojp != null) {
            this.ojp.setData(list);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.ocC = aVar;
        if (this.ojp != null) {
            this.ojp.setOnItemClickLister(aVar);
        }
    }

    public void Ve(String str) {
        if (this.ojp != null) {
            this.ojp.Ve(str);
        }
        if (this.ocC != null && this.ojp != null) {
            this.ocC.MP(this.ojp.getCount());
        }
    }

    public void onDestroy() {
        if (this.ofS != null) {
            this.ofS.onDestroy();
            this.ofS = null;
        }
        if (this.ogG != null) {
            this.ogG.onDestroy();
            this.ogG = null;
        }
    }
}
