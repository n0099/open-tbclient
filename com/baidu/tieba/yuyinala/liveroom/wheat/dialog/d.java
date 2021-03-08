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
/* loaded from: classes10.dex */
public class d extends a implements DialogInterface.OnDismissListener {
    private CustomMessageListener aYj;
    public CustomMessageListener bhY;
    private CommonEmptyView byj;
    private AlaLoadingView cfw;
    private CustomMessageListener oHU;
    private boolean oJW;
    private g oJa;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.e oJh;
    private AlaConnectionWheatListView oKb;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a oKc;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.c oKd;
    private TextView oKe;
    private int oKf;
    private ConnectionWheatButtonView oKg;
    private boolean oKh;
    private CustomMessageListener oKi;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.aYj = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    d.this.dismiss();
                }
            }
        };
        this.oHU = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.oKi = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012) {
                    d.this.Aj(false);
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.dismiss();
                }
            }
        };
        MB(80);
        Ah(true);
        Ai(true);
        g(this);
        this.oKf = i;
    }

    protected void initView() {
        this.oKb = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.oKe = (TextView) findViewById(a.f.tv_current_rank);
        this.oKg = (ConnectionWheatButtonView) findViewById(a.f.connection_wheat_button_view);
        this.cfw = (AlaLoadingView) findViewById(a.f.loading_view);
        this.byj = (CommonEmptyView) findViewById(a.f.empty_view_2);
        this.oKc = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.mContext);
        this.oKb.setAdapter((ListAdapter) this.oKc);
        showLoading();
        this.oKc.a(new a.InterfaceC0948a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.InterfaceC0948a
            public void a(com.baidu.live.data.e eVar) {
                d.this.dismiss();
                d.this.d(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }
        });
        this.oKg.init();
        this.oKg.setListener(new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eeo() {
                d.this.MC(d.this.oKf);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eep() {
                int i;
                d dVar = d.this;
                if (d.this.oKf < 5) {
                    i = d.this.oKf;
                } else {
                    i = 1;
                }
                dVar.MC(i);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void eeq() {
                d.this.MC(d.this.oKf >= 5 ? d.this.oKf : 5);
            }
        });
    }

    public void Aj(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oKd == null) {
            this.oKd = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.oIJ, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.b(alaGetApplyWheatListHttpResponseMessage.eeM(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.eeO());
                    d.this.hideLoading();
                    d.this.eel();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    d.this.eem();
                    d.this.hideLoading();
                }
            });
        }
        this.oKd.request();
    }

    public void edV() {
        Aj(true);
    }

    public void eel() {
        if (this.oKc != null && this.oKc.getCount() != 0) {
            this.oKb.setVisibility(0);
            this.byj.setVisibility(8);
            this.oKg.init();
            return;
        }
        this.oKb.setVisibility(8);
        this.byj.setVisibility(0);
        this.oKg.init();
        this.byj.reset();
        this.byj.setTitle(a.h.yuyin_ala_connection_wheat_empty_text);
        this.byj.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.byj.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    public void eem() {
        this.oKb.setVisibility(8);
        this.byj.setVisibility(0);
        this.oKg.setVisibility(8);
        this.byj.reset();
        this.byj.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
        this.byj.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.Aj(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.byj.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.byj.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.byj.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.byj.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<com.baidu.live.data.e> list, int i, int i2, int i3) {
        this.oJW = false;
        final int i4 = -1;
        this.oKg.ah(i, i2, i3);
        if (i > 0) {
            if (i2 > 0) {
                i4 = i2 - 1;
                this.oJW = true;
                this.oKe.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.oKe.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.oKe.setText(String.format(this.mContext.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.oKc.setData(list, i4);
        if (this.oKh) {
            this.oKh = false;
            this.oKb.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.8
                @Override // java.lang.Runnable
                public void run() {
                    d.this.oKb.smoothScrollToPosition(i4);
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
    protected boolean Sv() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Sw() {
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
        een();
        MessageManager.getInstance().registerListener(this.oHU);
        MessageManager.getInstance().registerListener(this.aYj);
        MessageManager.getInstance().registerListener(this.oKi);
        MessageManager.getInstance().registerListener(this.bhY);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MC(int i) {
        if (!com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edg()) {
            if (this.oIJ != null) {
                this.oIJ.showToast(a.h.yuyin_ala_relogin_join_chat);
            }
        } else if (!this.oJW) {
            JSONObject jSONObject = new JSONObject();
            try {
                ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
                if (Yt != null && Yt.aKu != null) {
                    jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, Yt.aKu.live_id);
                }
                jSONObject.put("error_code", 0);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "user_apply_join_chat_clk").setContentExt(jSONObject));
            Ak(true);
            com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edw().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void ddH() {
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                public void eds() {
                    com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().ecQ();
                    q.edU().Ae(true);
                    d.this.oKh = true;
                    d.this.Aj(false);
                    BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                }
            }).a(this.oIJ.getPageActivity(), this.oIJ.getPageActivity(), "2", String.valueOf(i));
        } else {
            Ak(false);
            if (this.oJa == null) {
                this.oJa = new g(this.oIJ);
                this.oJa.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        d.this.oJa.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        d.this.edJ();
                        d.this.oJa.dismiss();
                    }
                });
            }
            this.oJa.show();
            this.oJa.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
        if (Yt != null && Yt.aJZ != null && Yt.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oIJ.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Yt.mLiveInfo.group_id), Long.toString(Yt.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edJ() {
        if (this.oJh == null) {
            this.oJh = new com.baidu.tieba.yuyinala.liveroom.wheat.model.e(this.oIJ, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.11
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().ecR();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        q.edU().Ae(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oJh.ha(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().yp(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            Aj(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oJh != null) {
            this.oJh.onDestroy();
            this.oJh = null;
        }
        if (this.oKd != null) {
            this.oKd.onDestroy();
            this.oKd = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.edw().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.oHU);
        MessageManager.getInstance().unRegisterListener(this.aYj);
        MessageManager.getInstance().unRegisterListener(this.oKi);
        MessageManager.getInstance().unRegisterListener(this.bhY);
    }

    public void showLoading() {
        if (this.cfw != null) {
            this.cfw.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.cfw != null) {
            this.cfw.setVisibility(8);
        }
    }

    private void een() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put("live_id", Yt.aKu.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "miclinktab_show").setContentExt(jSONObject));
    }

    private void Ak(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
            if (Yt != null && Yt.aKu != null) {
                jSONObject.put("live_id", Yt.aKu.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Yt.aKu.croom_id);
                int roomMode = Yt.aKy.getRoomMode();
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
