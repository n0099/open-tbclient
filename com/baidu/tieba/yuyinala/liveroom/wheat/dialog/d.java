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
/* loaded from: classes10.dex */
public class d extends a implements DialogInterface.OnDismissListener {
    private CustomMessageListener aTE;
    private AlaLoadingView bZQ;
    public CustomMessageListener bdo;
    private CommonEmptyView btf;
    private CustomMessageListener ovY;
    private g owS;
    private boolean oxJ;
    private AlaConnectionWheatListView oxO;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a oxP;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.c oxQ;
    private TextView oxR;
    private int oxS;
    private ConnectionWheatButtonView oxT;
    private boolean oxU;
    private CustomMessageListener oxV;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oxa;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.aTE = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    d.this.dismiss();
                }
            }
        };
        this.ovY = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.oxV = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012) {
                    d.this.zR(false);
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.dismiss();
                }
            }
        };
        Ma(80);
        zP(true);
        zQ(true);
        g(this);
        this.oxS = i;
    }

    protected void initView() {
        this.oxO = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.oxR = (TextView) findViewById(a.f.tv_current_rank);
        this.oxT = (ConnectionWheatButtonView) findViewById(a.f.connection_wheat_button_view);
        this.bZQ = (AlaLoadingView) findViewById(a.f.loading_view);
        this.btf = (CommonEmptyView) findViewById(a.f.empty_view_2);
        this.oxP = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.mContext);
        this.oxO.setAdapter((ListAdapter) this.oxP);
        showLoading();
        this.oxP.a(new a.InterfaceC0936a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.InterfaceC0936a
            public void a(com.baidu.live.data.e eVar) {
                d.this.dismiss();
                d.this.d(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }
        });
        this.oxT.init();
        this.oxT.setListener(new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void ebK() {
                d.this.Mb(d.this.oxS);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void ebL() {
                int i;
                d dVar = d.this;
                if (d.this.oxS < 5) {
                    i = d.this.oxS;
                } else {
                    i = 1;
                }
                dVar.Mb(i);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void ebM() {
                d.this.Mb(d.this.oxS >= 5 ? d.this.oxS : 5);
            }
        });
    }

    public void zR(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oxQ == null) {
            this.oxQ = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.ovz, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.b(alaGetApplyWheatListHttpResponseMessage.eci(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.eck());
                    d.this.hideLoading();
                    d.this.ebH();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    d.this.ebI();
                    d.this.hideLoading();
                }
            });
        }
        this.oxQ.request();
    }

    public void ebp() {
        zR(true);
    }

    public void ebH() {
        if (this.oxP != null && this.oxP.getCount() != 0) {
            this.oxO.setVisibility(0);
            this.btf.setVisibility(8);
            this.oxT.init();
            return;
        }
        this.oxO.setVisibility(8);
        this.btf.setVisibility(0);
        this.oxT.init();
        this.btf.reset();
        this.btf.setTitle(a.h.yuyin_ala_connection_wheat_empty_text);
        this.btf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.btf.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    public void ebI() {
        this.oxO.setVisibility(8);
        this.btf.setVisibility(0);
        this.oxT.setVisibility(8);
        this.btf.reset();
        this.btf.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
        this.btf.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.zR(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.btf.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.btf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.btf.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.btf.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<com.baidu.live.data.e> list, int i, int i2, int i3) {
        this.oxJ = false;
        final int i4 = -1;
        this.oxT.aj(i, i2, i3);
        if (i > 0) {
            if (i2 > 0) {
                i4 = i2 - 1;
                this.oxJ = true;
                this.oxR.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.oxR.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.oxR.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.oxP.setData(list, i4);
        if (this.oxU) {
            this.oxU = false;
            this.oxO.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.8
                @Override // java.lang.Runnable
                public void run() {
                    d.this.oxO.smoothScrollToPosition(i4);
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
        ebJ();
        MessageManager.getInstance().registerListener(this.ovY);
        MessageManager.getInstance().registerListener(this.aTE);
        MessageManager.getInstance().registerListener(this.oxV);
        MessageManager.getInstance().registerListener(this.bdo);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mb(int i) {
        if (!this.oxJ) {
            JSONObject jSONObject = new JSONObject();
            try {
                x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
                if (WA != null && WA.aGy != null) {
                    jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
                }
                jSONObject.put("error_code", 0);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_clk").setContentExt(jSONObject));
            zS(true);
            com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eaV().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void dbt() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void eaQ() {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().eaq();
                    o.ebo().zM(true);
                    d.this.oxU = true;
                    d.this.zR(false);
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                }
            }).a(this.ovz.getPageActivity(), this.ovz.getPageActivity(), "2", String.valueOf(i));
            return;
        }
        zS(false);
        if (this.owS == null) {
            this.owS = new g(this.ovz);
            this.owS.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    d.this.owS.dismiss();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    d.this.ebg();
                    d.this.owS.dismiss();
                }
            });
        }
        this.owS.show();
        this.owS.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
        if (WA != null && WA.aGd != null && WA.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ovz.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(WA.mLiveInfo.group_id), Long.toString(WA.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebg() {
        if (this.oxa == null) {
            this.oxa = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.ovz, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.11
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().ear();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.ebo().zM(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oxa.gR(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zR(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oxa != null) {
            this.oxa.onDestroy();
            this.oxa = null;
        }
        if (this.oxQ != null) {
            this.oxQ.onDestroy();
            this.oxQ = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eaV().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.ovY);
        MessageManager.getInstance().unRegisterListener(this.aTE);
        MessageManager.getInstance().unRegisterListener(this.oxV);
        MessageManager.getInstance().unRegisterListener(this.bdo);
    }

    public void showLoading() {
        if (this.bZQ != null) {
            this.bZQ.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.bZQ != null) {
            this.bZQ.setVisibility(8);
        }
    }

    private void ebJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
            if (WA != null && WA.aGy != null) {
                jSONObject.put("live_id", WA.aGy.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, WA.aGy.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "miclinktab_show").setContentExt(jSONObject));
    }

    private void zS(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
            if (WA != null && WA.aGy != null) {
                jSONObject.put("live_id", WA.aGy.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, WA.aGy.croom_id);
                int roomMode = WA.aGD.getRoomMode();
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
