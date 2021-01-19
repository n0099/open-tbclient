package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaWheatMoreFunctionData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.view.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes10.dex */
public class h extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private TextView ajF;
    private TextView bUf;
    private CustomMessageListener bWi;
    public CustomMessageListener bdo;
    private RelativeLayout gmB;
    private BdGridView gra;
    private TextView mTitle;
    private b ovY;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e oyH;
    private TextView oyI;
    private AlaWheatMoreFunctionData oyJ;
    public HttpMessageListener oyK;

    public h(TbPageContext tbPageContext, AlaWheatMoreFunctionData alaWheatMoreFunctionData) {
        super(tbPageContext);
        this.bWi = new CustomMessageListener(2501081) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501081) && h.this.oyH != null) {
                    h.this.oyH.eae();
                }
            }
        };
        this.oyK = new HttpMessageListener(1031017) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031017) {
                    h.this.cjr();
                    h.this.zT(httpResponsedMessage.getError() == 0);
                    h.this.dismiss();
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (h.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    h.this.dismiss();
                }
            }
        };
        this.oyJ = alaWheatMoreFunctionData;
        Ma(80);
        zP(true);
        zQ(true);
        g(this);
    }

    protected void initView() {
        this.bUf = (TextView) findViewById(a.f.tv_cancel);
        this.bUf.setOnClickListener(this);
        this.mTitle = (TextView) findViewById(a.f.tv_title);
        this.oyI = (TextView) findViewById(a.f.tv_clear_confirm);
        this.oyI.setOnClickListener(this);
        this.oyI.setClickable(true);
        this.oyI.setTextColor(-57755);
        this.gra = (BdGridView) findViewById(a.f.wheat_clear_gridview);
        this.gra.setNumColumns(5);
        this.oyH = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e(this.mContext);
        this.gra.setAdapter((ListAdapter) this.oyH);
        this.oyH.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e.a
            public void I(View view, int i) {
                h.this.oyI.setClickable(!TextUtils.isEmpty(h.this.oyH.eaf()));
                h.this.oyI.setTextColor(!TextUtils.isEmpty(h.this.oyH.eaf()) ? -57755 : -11382190);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e.a
            public void notifyDataSetChanged() {
                h.this.bbp();
            }
        });
        this.gmB = (RelativeLayout) findViewById(a.f.rl_no_data);
        this.ajF = (TextView) findViewById(a.f.wheat_clear_desc);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_wheat_clear, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QI() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QJ() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    public void show() {
        try {
            super.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        MessageManager.getInstance().registerListener(this.bdo);
        MessageManager.getInstance().registerListener(this.oyK);
        MessageManager.getInstance().registerListener(this.bWi);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        if (this.oyH != null) {
            this.oyH.eae();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oyI) {
            ebQ();
        } else if (view == this.bUf) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbp() {
        boolean z = (o.ebo().Wx() == null || o.ebo().Wx().isEmpty()) && (o.ebo().ebr() == null || o.ebo().ebr().isEmpty());
        if (this.gmB != null) {
            this.gmB.setVisibility(z ? 0 : 8);
        }
        if (this.gra != null) {
            this.gra.setVisibility(z ? 8 : 0);
        }
        if (this.ajF != null) {
            this.ajF.setVisibility(z ? 8 : 0);
        }
        if (this.oyI != null) {
            this.oyI.setVisibility(z ? 4 : 0);
        }
    }

    private void ebQ() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(this.ovA.getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dv(false);
        cVar.o(this.ovA.getString((this.oyH == null || !this.oyH.eag()) ? a.h.yuyin_ala_clear_charm_title_items : a.h.yuyin_ala_clear_charm_title_all), "", this.ovA.getString(a.h.sdk_alert_yes_button), this.ovA.getString(a.h.sdk_live_cancel));
        cVar.fh(this.ovA.getResources().getColor(a.c.sdk_black_alpha100));
        cVar.fi(this.ovA.getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dx(false);
        cVar.dy(false);
        cVar.A(this.ovA.getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(this.ovA.getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dw(false);
        cVar.fg(this.ovA.getResources().getColor(a.c.sdk_common_color_10215));
        cVar.B(this.ovA.getResources().getDimension(a.d.sdk_fontsize28));
        cVar.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.2
            @Override // com.baidu.live.view.c.a
            public void OB() {
                if (h.this.oyH != null) {
                    if (!h.this.oyH.eag()) {
                        h.this.Vv(h.this.oyH.eaf());
                    } else {
                        h.this.ebR();
                    }
                    h.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_clear_charm_loading));
                }
                cVar.dismiss();
            }

            @Override // com.baidu.live.view.c.a
            public void OC() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    public void Vv(String str) {
        if (this.oyJ != null) {
            HttpMessage httpMessage = new HttpMessage(1031017);
            httpMessage.addParam("live_id", this.oyJ.mLiveId);
            httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oyJ.mCustomRoomId);
            httpMessage.addParam("room_id", this.oyJ.mRoomId);
            httpMessage.addParam("uks", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void ebR() {
        if (this.oyJ != null) {
            HttpMessage httpMessage = new HttpMessage(1031017);
            httpMessage.addParam("live_id", this.oyJ.mLiveId);
            httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oyJ.mCustomRoomId);
            httpMessage.addParam("room_id", this.oyJ.mRoomId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void zT(boolean z) {
        this.ovA.showToast(z ? a.h.yuyin_ala_audio_clear_charm_succ : a.h.yuyin_ala_audio_clear_charm_fail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.ovY == null) {
            this.ovY = new b(this.mContext);
        }
        this.ovY.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                h.this.ovY = null;
            }
        });
        if (!this.ovY.isShowing()) {
            this.ovY.show();
        }
        this.ovY.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjr() {
        if (this.ovY != null) {
            this.ovY.dismiss();
            this.ovY = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.ovY != null) {
            this.ovY = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bdo);
        MessageManager.getInstance().unRegisterListener(this.oyK);
        MessageManager.getInstance().unRegisterListener(this.bWi);
    }
}
