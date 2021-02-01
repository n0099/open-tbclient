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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes11.dex */
public class h extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private TextView aju;
    private TextView bYe;
    public CustomMessageListener bgy;
    private CustomMessageListener cak;
    private RelativeLayout gpk;
    private BdGridView gtK;
    private TextView mTitle;
    private b oFo;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e oIo;
    private TextView oIp;
    private AlaWheatMoreFunctionData oIq;
    public HttpMessageListener oIr;

    public h(TbPageContext tbPageContext, AlaWheatMoreFunctionData alaWheatMoreFunctionData) {
        super(tbPageContext);
        this.cak = new CustomMessageListener(2501081) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501081) && h.this.oIo != null) {
                    h.this.oIo.ecr();
                }
            }
        };
        this.oIr = new HttpMessageListener(1031017) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031017) {
                    h.this.ckq();
                    h.this.Am(httpResponsedMessage.getError() == 0);
                    h.this.dismiss();
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (h.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    h.this.dismiss();
                }
            }
        };
        this.oIq = alaWheatMoreFunctionData;
        Mw(80);
        Ai(true);
        Aj(true);
        g(this);
    }

    protected void initView() {
        this.bYe = (TextView) findViewById(a.f.tv_cancel);
        this.bYe.setOnClickListener(this);
        this.mTitle = (TextView) findViewById(a.f.tv_title);
        this.oIp = (TextView) findViewById(a.f.tv_clear_confirm);
        this.oIp.setOnClickListener(this);
        this.oIp.setClickable(true);
        this.oIp.setTextColor(-57755);
        this.gtK = (BdGridView) findViewById(a.f.wheat_clear_gridview);
        this.gtK.setNumColumns(5);
        this.oIo = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e(this.mContext);
        this.gtK.setAdapter((ListAdapter) this.oIo);
        this.oIo.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e.a
            public void I(View view, int i) {
                h.this.oIp.setClickable(!TextUtils.isEmpty(h.this.oIo.ecs()));
                h.this.oIp.setTextColor(!TextUtils.isEmpty(h.this.oIo.ecs()) ? -57755 : -11382190);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e.a
            public void notifyDataSetChanged() {
                h.this.bbC();
            }
        });
        this.gpk = (RelativeLayout) findViewById(a.f.rl_no_data);
        this.aju = (TextView) findViewById(a.f.wheat_clear_desc);
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
    protected boolean Ss() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean St() {
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
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.oIr);
        MessageManager.getInstance().registerListener(this.cak);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        if (this.oIo != null) {
            this.oIo.ecr();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oIp) {
            eee();
        } else if (view == this.bYe) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbC() {
        boolean z = (q.edE().Yn() == null || q.edE().Yn().isEmpty()) && (q.edE().edH() == null || q.edE().edH().isEmpty());
        if (this.gpk != null) {
            this.gpk.setVisibility(z ? 0 : 8);
        }
        if (this.gtK != null) {
            this.gtK.setVisibility(z ? 8 : 0);
        }
        if (this.aju != null) {
            this.aju.setVisibility(z ? 8 : 0);
        }
        if (this.oIp != null) {
            this.oIp.setVisibility(z ? 4 : 0);
        }
    }

    private void eee() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(this.oGe.getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dD(false);
        cVar.o(this.oGe.getString((this.oIo == null || !this.oIo.ect()) ? a.h.yuyin_ala_clear_charm_title_items : a.h.yuyin_ala_clear_charm_title_all), "", this.oGe.getString(a.h.sdk_alert_yes_button), this.oGe.getString(a.h.sdk_live_cancel));
        cVar.fl(this.oGe.getResources().getColor(a.c.sdk_black_alpha100));
        cVar.fm(this.oGe.getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dF(false);
        cVar.dG(false);
        cVar.A(this.oGe.getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(this.oGe.getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dE(false);
        cVar.fk(this.oGe.getResources().getColor(a.c.sdk_common_color_10215));
        cVar.B(this.oGe.getResources().getDimension(a.d.sdk_fontsize28));
        cVar.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.2
            @Override // com.baidu.live.view.c.a
            public void Qa() {
                if (h.this.oIo != null) {
                    if (!h.this.oIo.ect()) {
                        h.this.Wu(h.this.oIo.ecs());
                    } else {
                        h.this.eef();
                    }
                    h.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_clear_charm_loading));
                }
                cVar.dismiss();
            }

            @Override // com.baidu.live.view.c.a
            public void Qb() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    public void Wu(String str) {
        if (this.oIq != null) {
            HttpMessage httpMessage = new HttpMessage(1031017);
            httpMessage.addParam("live_id", this.oIq.mLiveId);
            httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oIq.mCustomRoomId);
            httpMessage.addParam("room_id", this.oIq.mRoomId);
            httpMessage.addParam("uks", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void eef() {
        if (this.oIq != null) {
            HttpMessage httpMessage = new HttpMessage(1031017);
            httpMessage.addParam("live_id", this.oIq.mLiveId);
            httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oIq.mCustomRoomId);
            httpMessage.addParam("room_id", this.oIq.mRoomId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Am(boolean z) {
        this.oGe.showToast(z ? a.h.yuyin_ala_audio_clear_charm_succ : a.h.yuyin_ala_audio_clear_charm_fail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.oFo == null) {
            this.oFo = new b(this.mContext);
        }
        this.oFo.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                h.this.oFo = null;
            }
        });
        if (!this.oFo.isShowing()) {
            this.oFo.show();
        }
        this.oFo.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckq() {
        if (this.oFo != null) {
            this.oFo.dismiss();
            this.oFo = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oFo != null) {
            this.oFo = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.oIr);
        MessageManager.getInstance().unRegisterListener(this.cak);
    }
}
