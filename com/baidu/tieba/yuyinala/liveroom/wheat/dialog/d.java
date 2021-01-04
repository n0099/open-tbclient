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
    private CustomMessageListener oAE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oBG;
    private g oBy;
    private boolean oCA;
    private CustomMessageListener oCB;
    private boolean oCp;
    private AlaConnectionWheatListView oCu;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a oCv;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.c oCw;
    private TextView oCx;
    private int oCy;
    private ConnectionWheatButtonView oCz;

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
        this.oAE = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.oCB = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
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
        this.oCy = i;
    }

    protected void initView() {
        this.oCu = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.oCx = (TextView) findViewById(a.f.tv_current_rank);
        this.oCz = (ConnectionWheatButtonView) findViewById(a.f.connection_wheat_button_view);
        this.ceG = (AlaLoadingView) findViewById(a.f.loading_view);
        this.bxT = (CommonEmptyView) findViewById(a.f.empty_view_2);
        this.oCv = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.mContext);
        this.oCu.setAdapter((ListAdapter) this.oCv);
        showLoading();
        this.oCv.a(new a.InterfaceC0915a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.InterfaceC0915a
            public void a(com.baidu.live.data.e eVar) {
                d.this.dismiss();
                d.this.d(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }
        });
        this.oCz.init();
        this.oCz.setListener(new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efB() {
                d.this.NI(d.this.oCy);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efC() {
                int i;
                d dVar = d.this;
                if (d.this.oCy < 5) {
                    i = d.this.oCy;
                } else {
                    i = 1;
                }
                dVar.NI(i);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efD() {
                d.this.NI(d.this.oCy >= 5 ? d.this.oCy : 5);
            }
        });
    }

    public void zV(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oCw == null) {
            this.oCw = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.oAf, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.b(alaGetApplyWheatListHttpResponseMessage.efZ(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.egb());
                    d.this.hideLoading();
                    d.this.efy();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    d.this.efz();
                    d.this.hideLoading();
                }
            });
        }
        this.oCw.request();
    }

    public void efg() {
        zV(true);
    }

    public void efy() {
        if (this.oCv != null && this.oCv.getCount() != 0) {
            this.oCu.setVisibility(0);
            this.bxT.setVisibility(8);
            this.oCz.init();
            return;
        }
        this.oCu.setVisibility(8);
        this.bxT.setVisibility(0);
        this.oCz.init();
        this.bxT.reset();
        this.bxT.setTitle(a.h.yuyin_ala_connection_wheat_empty_text);
        this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.bxT.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    public void efz() {
        this.oCu.setVisibility(8);
        this.bxT.setVisibility(0);
        this.oCz.setVisibility(8);
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
        this.oCp = false;
        final int i4 = -1;
        this.oCz.aj(i, i2, i3);
        if (i > 0) {
            if (i2 > 0) {
                i4 = i2 - 1;
                this.oCp = true;
                this.oCx.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.oCx.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.oCx.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.oCv.setData(list, i4);
        if (this.oCA) {
            this.oCA = false;
            this.oCu.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.8
                @Override // java.lang.Runnable
                public void run() {
                    d.this.oCu.smoothScrollToPosition(i4);
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
        efA();
        MessageManager.getInstance().registerListener(this.oAE);
        MessageManager.getInstance().registerListener(this.aYr);
        MessageManager.getInstance().registerListener(this.oCB);
        MessageManager.getInstance().registerListener(this.bih);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NI(int i) {
        if (!this.oCp) {
            JSONObject jSONObject = new JSONObject();
            try {
                x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
                if (aas != null && aas.aLl != null) {
                    jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, aas.aLl.live_id);
                }
                jSONObject.put("error_code", 0);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_clk").setContentExt(jSONObject));
            zW(true);
            com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void dfk() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void eeH() {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().eeh();
                    o.eff().zQ(true);
                    d.this.oCA = true;
                    d.this.zV(false);
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                }
            }).a(this.oAf.getPageActivity(), this.oAf.getPageActivity(), "2", String.valueOf(i));
            return;
        }
        zW(false);
        if (this.oBy == null) {
            this.oBy = new g(this.oAf);
            this.oBy.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    d.this.oBy.dismiss();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    d.this.eeX();
                    d.this.oBy.dismiss();
                }
            });
        }
        this.oBy.show();
        this.oBy.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
        if (aas != null && aas.aKQ != null && aas.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oAf.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(aas.mLiveInfo.group_id), Long.toString(aas.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeX() {
        if (this.oBG == null) {
            this.oBG = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.oAf, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.11
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().eei();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.eff().zQ(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oBG.gS(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zV(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oBG != null) {
            this.oBG.onDestroy();
            this.oBG = null;
        }
        if (this.oCw != null) {
            this.oCw.onDestroy();
            this.oCw = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.oAE);
        MessageManager.getInstance().unRegisterListener(this.aYr);
        MessageManager.getInstance().unRegisterListener(this.oCB);
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

    private void efA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
            if (aas != null && aas.aLl != null) {
                jSONObject.put("live_id", aas.aLl.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aas.aLl.croom_id);
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
            x aas = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().aas();
            if (aas != null && aas.aLl != null) {
                jSONObject.put("live_id", aas.aLl.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aas.aLl.croom_id);
                int roomMode = aas.aLq.getRoomMode();
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
