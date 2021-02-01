package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.net.http.Headers;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.BaseViewPager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.ConnectionWheatPagerAdapter;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.k;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.l;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatManagerListView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class HostConnectionWheatDialog extends a implements DialogInterface.OnDismissListener, View.OnClickListener, ViewPager.OnPageChangeListener {
    private CustomMessageListener aWJ;
    public CustomMessageListener bgy;
    private List<View> mList;
    private CustomMessageListener oHD;
    private CustomMessageListener oHt;
    private TextView oIa;
    private TextView oIb;
    private TextView oIc;
    private BaseViewPager oId;
    private l oIe;
    private RelativeLayout oIf;
    private RelativeLayout oIg;
    private RelativeLayout oIh;
    private ConnectionWheatApplyListView oIi;
    private int oIj;
    private CustomMessageListener oIk;

    public HostConnectionWheatDialog(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aWJ = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.oHD = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012 && HostConnectionWheatDialog.this.oId != null && HostConnectionWheatDialog.this.oId.getCurrentItem() == 0) {
                    HostConnectionWheatDialog.this.mH(false);
                }
            }
        };
        this.oIk = new CustomMessageListener(2501068) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501068 && HostConnectionWheatDialog.this.oId != null && HostConnectionWheatDialog.this.oId.getCurrentItem() == 1) {
                    HostConnectionWheatDialog.this.mH(false);
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (HostConnectionWheatDialog.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.oHt = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        Mw(80);
        Ai(true);
        Aj(true);
        g((DialogInterface.OnDismissListener) this);
    }

    private void initView() {
        this.oId = (BaseViewPager) findViewById(a.f.connection_wheat_viewpager);
        this.oIa = (TextView) findViewById(a.f.tv_connection_wheat_apply);
        this.oIb = (TextView) findViewById(a.f.tv_connection_wheat_manager);
        this.oIc = (TextView) findViewById(a.f.tv_connection_wheat_invite);
        this.oIf = (RelativeLayout) findViewById(a.f.rl_connection_wheat_apply);
        this.oIg = (RelativeLayout) findViewById(a.f.rl_connection_wheat_manager);
        this.oIh = (RelativeLayout) findViewById(a.f.rl_connection_wheat_invite);
        this.oId.setOnPageChangeListener(this);
    }

    private void initListener() {
        this.oIa.setOnClickListener(this);
        this.oIb.setOnClickListener(this);
        this.oIc.setOnClickListener(this);
    }

    private void dAY() {
        this.mList = new ArrayList();
        this.oIi = new ConnectionWheatApplyListView(this.oGe.getPageActivity());
        this.oIi.setTbPageContext(this.oGe);
        this.oIi.setApplyPosition(this.oIj);
        this.oIi.setOnItemClickLister(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void Ml(int i) {
                HostConnectionWheatDialog.this.oIa.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void a(com.baidu.live.data.e eVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.d(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void b(com.baidu.live.data.e eVar) {
                if (eVar != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_apply_wheat_anchor_1", false);
                    HostConnectionWheatDialog.this.c(eVar);
                }
            }
        });
        this.mList.add(this.oIi);
        ConnectionWheatManagerListView connectionWheatManagerListView = new ConnectionWheatManagerListView(this.oGe.getPageActivity());
        connectionWheatManagerListView.setListener(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void Mn(int i) {
                HostConnectionWheatDialog.this.oIb.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void g(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.d(alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, alaWheatInfoData.userName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void h(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.k(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void i(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.l(alaWheatInfoData);
            }
        });
        this.mList.add(connectionWheatManagerListView);
        ConnectionWheatInviteListView connectionWheatInviteListView = new ConnectionWheatInviteListView(this.oGe.getPageActivity());
        connectionWheatInviteListView.setTbPageContext(this.oGe);
        connectionWheatInviteListView.setOnItemClickLister(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void a(r rVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.d(rVar.uk, rVar.userName, rVar.portrait, rVar.sex, rVar.userName);
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
            /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a(r rVar, boolean z) {
                int i = 1;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
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
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micinvite_clk").setContentExt(jSONObject));
                if (HostConnectionWheatDialog.this.oIe == null) {
                    HostConnectionWheatDialog.this.oIe = new l();
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_apply_wheat_anchor_1", false);
                int i2 = HostConnectionWheatDialog.this.oIj;
                if (q.edE().edR()) {
                    if (!z || i2 < 5) {
                        if (!z && i2 < 5) {
                            i = 5;
                        }
                    }
                    if (HostConnectionWheatDialog.this.oIe == null) {
                        HostConnectionWheatDialog.this.oIe.a(rVar, i);
                        return;
                    }
                    return;
                }
                i = i2;
                if (HostConnectionWheatDialog.this.oIe == null) {
                }
            }
        });
        this.mList.add(connectionWheatInviteListView);
        this.oId.setAdapter(new ConnectionWheatPagerAdapter(this.mList));
        MA(0);
    }

    public void Mz(int i) {
        this.oIj = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.data.e eVar) {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.edd().a(eVar.uk, eVar.cuid, eVar.aGi, eVar.aGk, "1");
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.edd().a(new a.InterfaceC0942a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0942a
            public void Wf(String str) {
                View view = (View) HostConnectionWheatDialog.this.mList.get(0);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).VS(str);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                }, 300L);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0942a
            public void onSuccess() {
                if (HostConnectionWheatDialog.this.oIi != null) {
                    HostConnectionWheatDialog.this.oIi.Ak(false);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0942a
            public void onFail() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AlaWheatInfoData alaWheatInfoData) {
        new k().a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
            public void Wl(String str) {
                if (q.edE().VT(str) && !q.edE().iI(str)) {
                    HostConnectionWheatDialog.this.dismiss();
                }
                q.edE().bi(str, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
            }
        }).a(this.oGe, alaWheatInfoData.userName, alaWheatInfoData.uk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final AlaWheatInfoData alaWheatInfoData) {
        if (q.edE().VT(alaWheatInfoData.uk)) {
            String str = alaWheatInfoData.isOpenMike() ? "1" : "0";
            o oVar = new o();
            oVar.gU(alaWheatInfoData.uk, str);
            oVar.a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
                public void Ae(boolean z) {
                    String string;
                    alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                    HostConnectionWheatDialog.this.mH(false);
                    if (z) {
                        if (alaWheatInfoData.isOpenMike()) {
                            string = TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_open_txt);
                        } else {
                            string = TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_close_txt);
                        }
                        BdToast.makeText(TbadkCoreApplication.getInst(), string).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
                public void edz() {
                }
            });
            return;
        }
        String str2 = alaWheatInfoData.isOpenMike() ? "1" : "0";
        o oVar2 = new o();
        oVar2.gU(alaWheatInfoData.uk, str2);
        oVar2.a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.10
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void Ae(boolean z) {
                alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                HostConnectionWheatDialog.this.mH(false);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void edz() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
        if (Yq != null && Yq.aIz != null && Yq.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oGe.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Yq.mLiveInfo.group_id), Long.toString(Yq.mLiveInfo.live_id), false, null, null, str4, "")));
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
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_connnection_wheat, (ViewGroup) null);
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
        setCurrentPage(0);
        q.edE().Ag(true);
        MessageManager.getInstance().registerListener(this.aWJ);
        MessageManager.getInstance().registerListener(this.oHD);
        MessageManager.getInstance().registerListener(this.oIk);
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.oHt);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        initListener();
        dAY();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oIa) {
            setCurrentPage(0);
        } else if (view == this.oIb) {
            setCurrentPage(1);
        } else if (view == this.oIc) {
            setCurrentPage(2);
        }
    }

    private void setCurrentPage(int i) {
        if (this.oId != null) {
            this.oId.setCurrentItem(i);
        }
    }

    public void mH(boolean z) {
        if (this.oId != null) {
            J(z, this.oId.getCurrentItem());
        }
    }

    private void J(boolean z, int i) {
        if (this.mList != null && this.mList.size() > i) {
            View view = this.mList.get(i);
            if (view instanceof ConnectionWheatApplyListView) {
                ((ConnectionWheatApplyListView) view).Ak(z);
            } else if (view instanceof ConnectionWheatManagerListView) {
                ((ConnectionWheatManagerListView) view).edF();
            } else if (view instanceof ConnectionWheatInviteListView) {
                ((ConnectionWheatInviteListView) view).Ak(z);
            }
        }
    }

    private void MA(int i) {
        if (this.oIf != null && this.oIg != null && this.oIh != null) {
            this.oIf.setSelected(i == 0);
            this.oIg.setSelected(i == 1);
            this.oIh.setSelected(i == 2);
            this.oIa.setTypeface(this.oIf.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.oIb.setTypeface(this.oIg.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.oIc.setTypeface(this.oIh.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            if (this.mList != null && this.mList.size() > i) {
                View view = this.mList.get(i);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).showLoading();
                } else if (view instanceof ConnectionWheatInviteListView) {
                    ((ConnectionWheatInviteListView) view).showLoading();
                }
            }
        }
        mH(false);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        MA(i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (ListUtils.getCount(this.mList) > 0) {
            for (int i = 0; i < this.mList.size(); i++) {
                View view = this.mList.get(i);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).onDestroy();
                } else if (view instanceof ConnectionWheatManagerListView) {
                    ((ConnectionWheatManagerListView) view).onDestroy();
                } else if (view instanceof ConnectionWheatInviteListView) {
                    ((ConnectionWheatInviteListView) view).onDestroy();
                }
            }
        }
        q.edE().Ag(false);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.oHt);
        MessageManager.getInstance().unRegisterListener(this.aWJ);
        MessageManager.getInstance().unRegisterListener(this.oHD);
        MessageManager.getInstance().unRegisterListener(this.oIk);
        q.edE().Ag(false);
    }
}
