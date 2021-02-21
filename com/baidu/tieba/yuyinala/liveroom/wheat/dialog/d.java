package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.view.AlaLoadingView;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaConnectionWheatListView;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends a implements DialogInterface.OnDismissListener {
    private CustomMessageListener aWJ;
    public CustomMessageListener bgy;
    private CommonEmptyView bwJ;
    private AlaLoadingView cdW;
    private CustomMessageListener oFP;
    private g oGV;
    private boolean oHR;
    private AlaConnectionWheatListView oHW;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a oHX;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.c oHY;
    private TextView oHZ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oHc;
    private int oIa;
    private ConnectionWheatButtonView oIb;
    private boolean oIc;
    private CustomMessageListener oId;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.aWJ = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    d.this.dismiss();
                }
            }
        };
        this.oFP = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.oId = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012) {
                    d.this.Ak(false);
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.dismiss();
                }
            }
        };
        Mx(80);
        Ai(true);
        Aj(true);
        g(this);
        this.oIa = i;
    }

    protected void initView() {
        this.oHW = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.oHZ = (TextView) findViewById(a.f.tv_current_rank);
        this.oIb = (ConnectionWheatButtonView) findViewById(a.f.connection_wheat_button_view);
        this.cdW = (AlaLoadingView) findViewById(a.f.loading_view);
        this.bwJ = (CommonEmptyView) findViewById(a.f.empty_view_2);
        this.oHX = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.mContext);
        this.oHW.setAdapter((ListAdapter) this.oHX);
        showLoading();
        this.oHX.a(new a.InterfaceC0942a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.InterfaceC0942a
            public void a(com.baidu.live.data.e eVar) {
                d.this.dismiss();
                d.this.d(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }
        });
        this.oIb.init();
        this.oIb.setListener(new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eeg() {
                d.this.My(d.this.oIa);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eeh() {
                int i;
                d dVar = d.this;
                if (d.this.oIa < 5) {
                    i = d.this.oIa;
                } else {
                    i = 1;
                }
                dVar.My(i);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eei() {
                d.this.My(d.this.oIa >= 5 ? d.this.oIa : 5);
            }
        });
    }

    public void Ak(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oHY == null) {
            this.oHY = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.oGE, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.b(alaGetApplyWheatListHttpResponseMessage.eeE(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.eeG());
                    d.this.hideLoading();
                    d.this.eed();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    d.this.eee();
                    d.this.hideLoading();
                }
            });
        }
        this.oHY.request();
    }

    public void edN() {
        Ak(true);
    }

    public void eed() {
        if (this.oHX != null && this.oHX.getCount() != 0) {
            this.oHW.setVisibility(0);
            this.bwJ.setVisibility(8);
            this.oIb.init();
            return;
        }
        this.oHW.setVisibility(8);
        this.bwJ.setVisibility(0);
        this.oIb.init();
        this.bwJ.reset();
        this.bwJ.setTitle(a.h.yuyin_ala_connection_wheat_empty_text);
        this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.bwJ.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    public void eee() {
        this.oHW.setVisibility(8);
        this.bwJ.setVisibility(0);
        this.oIb.setVisibility(8);
        this.bwJ.reset();
        this.bwJ.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
        this.bwJ.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Ak(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bwJ.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.bwJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bwJ.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bwJ.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<com.baidu.live.data.e> list, int i, int i2, int i3) {
        this.oHR = false;
        final int i4 = -1;
        this.oIb.ah(i, i2, i3);
        if (i > 0) {
            if (i2 > 0) {
                i4 = i2 - 1;
                this.oHR = true;
                this.oHZ.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.oHZ.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.oHZ.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.oHX.setData(list, i4);
        if (this.oIc) {
            this.oIc = false;
            this.oHW.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.8
                @Override // java.lang.Runnable
                public void run() {
                    d.this.oHW.smoothScrollToPosition(i4);
                }
            });
        }
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
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_connection_wheat_apply, (ViewGroup) null);
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
        eef();
        MessageManager.getInstance().registerListener(this.oFP);
        MessageManager.getInstance().registerListener(this.aWJ);
        MessageManager.getInstance().registerListener(this.oId);
        MessageManager.getInstance().registerListener(this.bgy);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void My(int i) {
        if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecY()) {
            if (this.oGE != null) {
                this.oGE.showToast(a.h.yuyin_ala_relogin_join_chat);
            }
        } else if (!this.oHR) {
            JSONObject jSONObject = new JSONObject();
            try {
                ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
                if (Yq != null && Yq.aIU != null) {
                    jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yq.aIU.live_id);
                }
                jSONObject.put("error_code", 0);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_clk").setContentExt(jSONObject));
            Al(true);
            com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edo().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void ddy() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void edk() {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().ecI();
                    q.edM().Af(true);
                    d.this.oIc = true;
                    d.this.Ak(false);
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                }
            }).a(this.oGE.getPageActivity(), this.oGE.getPageActivity(), "2", String.valueOf(i));
        } else {
            Al(false);
            if (this.oGV == null) {
                this.oGV = new g(this.oGE);
                this.oGV.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        d.this.oGV.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        d.this.edB();
                        d.this.oGV.dismiss();
                    }
                });
            }
            this.oGV.show();
            this.oGV.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
        if (Yq != null && Yq.aIz != null && Yq.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oGE.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Yq.mLiveInfo.group_id), Long.toString(Yq.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edB() {
        if (this.oHc == null) {
            this.oHc = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.oGE, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.11
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().ecJ();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        q.edM().Af(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oHc.ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ym(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            Ak(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oHc != null) {
            this.oHc.onDestroy();
            this.oHc = null;
        }
        if (this.oHY != null) {
            this.oHY.onDestroy();
            this.oHY = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edo().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.oFP);
        MessageManager.getInstance().unRegisterListener(this.aWJ);
        MessageManager.getInstance().unRegisterListener(this.oId);
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public void showLoading() {
        if (this.cdW != null) {
            this.cdW.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.cdW != null) {
            this.cdW.setVisibility(8);
        }
    }

    private void eef() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put("live_id", Yq.aIU.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yq.aIU.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "miclinktab_show").setContentExt(jSONObject));
    }

    private void Al(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
            if (Yq != null && Yq.aIU != null) {
                jSONObject.put("live_id", Yq.aIU.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yq.aIU.croom_id);
                int roomMode = Yq.aIY.getRoomMode();
                if (roomMode == 0) {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "normal");
                } else if (roomMode == 1) {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "dating");
                } else if (roomMode == 2) {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "battle");
                }
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "cancel");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micapplybtn_clk").setContentExt(jSONObject));
    }
}
