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
import com.baidu.live.data.x;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
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
    private CustomMessageListener aYr;
    public CustomMessageListener bih;
    private CommonEmptyView bxT;
    private AlaLoadingView ceG;
    private CustomMessageListener oAD;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oBF;
    private g oBx;
    private CustomMessageListener oCA;
    private boolean oCo;
    private AlaConnectionWheatListView oCt;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a oCu;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.c oCv;
    private TextView oCw;
    private int oCx;
    private ConnectionWheatButtonView oCy;
    private boolean oCz;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.aYr = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    d.this.dismiss();
                }
            }
        };
        this.oAD = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.oCA = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012) {
                    d.this.zV(false);
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.dismiss();
                }
            }
        };
        NH(80);
        zT(true);
        zU(true);
        g(this);
        this.oCx = i;
    }

    protected void initView() {
        this.oCt = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.oCw = (TextView) findViewById(a.f.tv_current_rank);
        this.oCy = (ConnectionWheatButtonView) findViewById(a.f.connection_wheat_button_view);
        this.ceG = (AlaLoadingView) findViewById(a.f.loading_view);
        this.bxT = (CommonEmptyView) findViewById(a.f.empty_view_2);
        this.oCu = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.mContext);
        this.oCt.setAdapter((ListAdapter) this.oCu);
        showLoading();
        this.oCu.a(new a.InterfaceC0953a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.InterfaceC0953a
            public void a(com.baidu.live.data.e eVar) {
                d.this.dismiss();
                d.this.d(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }
        });
        this.oCy.init();
        this.oCy.setListener(new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efC() {
                d.this.NI(d.this.oCx);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efD() {
                int i;
                d dVar = d.this;
                if (d.this.oCx < 5) {
                    i = d.this.oCx;
                } else {
                    i = 1;
                }
                dVar.NI(i);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efE() {
                d.this.NI(d.this.oCx >= 5 ? d.this.oCx : 5);
            }
        });
    }

    public void zV(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oCv == null) {
            this.oCv = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.oAe, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.b(alaGetApplyWheatListHttpResponseMessage.ega(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.egc());
                    d.this.hideLoading();
                    d.this.efz();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    d.this.efA();
                    d.this.hideLoading();
                }
            });
        }
        this.oCv.request();
    }

    public void efh() {
        zV(true);
    }

    public void efz() {
        if (this.oCu != null && this.oCu.getCount() != 0) {
            this.oCt.setVisibility(0);
            this.bxT.setVisibility(8);
            this.oCy.init();
            return;
        }
        this.oCt.setVisibility(8);
        this.bxT.setVisibility(0);
        this.oCy.init();
        this.bxT.reset();
        this.bxT.setTitle(a.h.yuyin_ala_connection_wheat_empty_text);
        this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.bxT.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    public void efA() {
        this.oCt.setVisibility(8);
        this.bxT.setVisibility(0);
        this.oCy.setVisibility(8);
        this.bxT.reset();
        this.bxT.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
        this.bxT.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.zV(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bxT.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.bxT.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bxT.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bxT.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<com.baidu.live.data.e> list, int i, int i2, int i3) {
        this.oCo = false;
        final int i4 = -1;
        this.oCy.aj(i, i2, i3);
        if (i > 0) {
            if (i2 > 0) {
                i4 = i2 - 1;
                this.oCo = true;
                this.oCw.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.oCw.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.oCw.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.oCu.setData(list, i4);
        if (this.oCz) {
            this.oCz = false;
            this.oCt.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.8
                @Override // java.lang.Runnable
                public void run() {
                    d.this.oCt.smoothScrollToPosition(i4);
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
    protected boolean UD() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean UE() {
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
        efB();
        MessageManager.getInstance().registerListener(this.oAD);
        MessageManager.getInstance().registerListener(this.aYr);
        MessageManager.getInstance().registerListener(this.oCA);
        MessageManager.getInstance().registerListener(this.bih);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NI(int i) {
        if (!this.oCo) {
            JSONObject jSONObject = new JSONObject();
            try {
                x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
                if (aat != null && aat.aLl != null) {
                    jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aat.aLl.live_id);
                }
                jSONObject.put("error_code", 0);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_clk").setContentExt(jSONObject));
            zW(true);
            com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeN().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void dfl() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void eeI() {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().eei();
                    o.efg().zQ(true);
                    d.this.oCz = true;
                    d.this.zV(false);
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                }
            }).a(this.oAe.getPageActivity(), this.oAe.getPageActivity(), "2", String.valueOf(i));
            return;
        }
        zW(false);
        if (this.oBx == null) {
            this.oBx = new g(this.oAe);
            this.oBx.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    d.this.oBx.dismiss();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    d.this.eeY();
                    d.this.oBx.dismiss();
                }
            });
        }
        this.oBx.show();
        this.oBx.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
        if (aat != null && aat.aKQ != null && aat.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oAe.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(aat.mLiveInfo.group_id), Long.toString(aat.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeY() {
        if (this.oBF == null) {
            this.oBF = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.oAe, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.11
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().eej();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.efg().zQ(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oBF.gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Cq(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zV(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oBF != null) {
            this.oBF.onDestroy();
            this.oBF = null;
        }
        if (this.oCv != null) {
            this.oCv.onDestroy();
            this.oCv = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeN().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.oAD);
        MessageManager.getInstance().unRegisterListener(this.aYr);
        MessageManager.getInstance().unRegisterListener(this.oCA);
        MessageManager.getInstance().unRegisterListener(this.bih);
    }

    public void showLoading() {
        if (this.ceG != null) {
            this.ceG.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.ceG != null) {
            this.ceG.setVisibility(8);
        }
    }

    private void efB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
            if (aat != null && aat.aLl != null) {
                jSONObject.put("live_id", aat.aLl.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aat.aLl.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "miclinktab_show").setContentExt(jSONObject));
    }

    private void zW(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            x aat = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().aat();
            if (aat != null && aat.aLl != null) {
                jSONObject.put("live_id", aat.aLl.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aat.aLl.croom_id);
                int roomMode = aat.aLq.getRoomMode();
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
