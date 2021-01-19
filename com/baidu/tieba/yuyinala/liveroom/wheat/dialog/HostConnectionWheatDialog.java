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
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.n;
import com.baidu.live.data.x;
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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.j;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.m;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatManagerListView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class HostConnectionWheatDialog extends a implements DialogInterface.OnDismissListener, View.OnClickListener, ViewPager.OnPageChangeListener {
    private CustomMessageListener aTE;
    public CustomMessageListener bdo;
    private List<View> mList;
    private CustomMessageListener oxM;
    private CustomMessageListener oxW;
    private RelativeLayout oyA;
    private ConnectionWheatApplyListView oyB;
    private int oyC;
    private CustomMessageListener oyD;
    private TextView oyt;
    private TextView oyu;
    private TextView oyv;
    private BaseViewPager oyw;
    private j oyx;
    private RelativeLayout oyy;
    private RelativeLayout oyz;

    public HostConnectionWheatDialog(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aTE = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.oxW = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012 && HostConnectionWheatDialog.this.oyw != null && HostConnectionWheatDialog.this.oyw.getCurrentItem() == 0) {
                    HostConnectionWheatDialog.this.mD(false);
                }
            }
        };
        this.oyD = new CustomMessageListener(2501068) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501068 && HostConnectionWheatDialog.this.oyw != null && HostConnectionWheatDialog.this.oyw.getCurrentItem() == 1) {
                    HostConnectionWheatDialog.this.mD(false);
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (HostConnectionWheatDialog.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.oxM = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        Ma(80);
        zP(true);
        zQ(true);
        g((DialogInterface.OnDismissListener) this);
    }

    private void initView() {
        this.oyw = (BaseViewPager) findViewById(a.f.connection_wheat_viewpager);
        this.oyt = (TextView) findViewById(a.f.tv_connection_wheat_apply);
        this.oyu = (TextView) findViewById(a.f.tv_connection_wheat_manager);
        this.oyv = (TextView) findViewById(a.f.tv_connection_wheat_invite);
        this.oyy = (RelativeLayout) findViewById(a.f.rl_connection_wheat_apply);
        this.oyz = (RelativeLayout) findViewById(a.f.rl_connection_wheat_manager);
        this.oyA = (RelativeLayout) findViewById(a.f.rl_connection_wheat_invite);
        this.oyw.setOnPageChangeListener(this);
    }

    private void initListener() {
        this.oyt.setOnClickListener(this);
        this.oyu.setOnClickListener(this);
        this.oyv.setOnClickListener(this);
    }

    private void dyO() {
        this.mList = new ArrayList();
        this.oyB = new ConnectionWheatApplyListView(this.ovA.getPageActivity());
        this.oyB.setTbPageContext(this.ovA);
        this.oyB.setApplyPosition(this.oyC);
        this.oyB.setOnItemClickLister(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void LQ(int i) {
                HostConnectionWheatDialog.this.oyt.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2));
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
        this.mList.add(this.oyB);
        ConnectionWheatManagerListView connectionWheatManagerListView = new ConnectionWheatManagerListView(this.ovA.getPageActivity());
        connectionWheatManagerListView.setListener(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void LS(int i) {
                HostConnectionWheatDialog.this.oyu.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text));
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
        ConnectionWheatInviteListView connectionWheatInviteListView = new ConnectionWheatInviteListView(this.ovA.getPageActivity());
        connectionWheatInviteListView.setTbPageContext(this.ovA);
        connectionWheatInviteListView.setOnItemClickLister(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void a(n nVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.d(nVar.uk, nVar.userName, nVar.portrait, nVar.sex, nVar.userName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void a(n nVar, boolean z) {
                int i = 1;
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
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micinvite_clk").setContentExt(jSONObject));
                if (HostConnectionWheatDialog.this.oyx == null) {
                    HostConnectionWheatDialog.this.oyx = new j();
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_apply_wheat_anchor_1", false);
                int i2 = HostConnectionWheatDialog.this.oyC;
                if (o.ebo().ebE()) {
                    if (!z || i2 < 5) {
                        if (!z && i2 < 5) {
                            i = 5;
                        }
                    }
                    HostConnectionWheatDialog.this.oyx.a(nVar, i);
                }
                i = i2;
                HostConnectionWheatDialog.this.oyx.a(nVar, i);
            }
        });
        this.mList.add(connectionWheatInviteListView);
        this.oyw.setAdapter(new ConnectionWheatPagerAdapter(this.mList));
        Me(0);
    }

    public void Md(int i) {
        this.oyC = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.data.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
            if (WA != null && WA.aGy != null) {
                jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, WA.aGy.live_id);
            }
            jSONObject.put("accept_uid", eVar.uk);
            jSONObject.put("error_code", 0);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_OWNER_JOIN_CHAT, "click", UbcStatConstant.Page.AUDIO_LIVE_ROOM, "owner_accept_apply_invite").setContentExt(jSONObject));
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.eaR().b(eVar.uk, eVar.cuid, eVar.aEv, eVar.aEx, "1");
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.eaR().a(new a.InterfaceC0938a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0938a
            public void Vi(String str) {
                View view = (View) HostConnectionWheatDialog.this.mList.get(0);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).UU(str);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                }, 300L);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0938a
            public void onSuccess() {
                if (HostConnectionWheatDialog.this.oyB != null) {
                    HostConnectionWheatDialog.this.oyB.zR(false);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0938a
            public void onFail() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AlaWheatInfoData alaWheatInfoData) {
        new i().a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void Vo(String str) {
                if (o.ebo().UV(str) && !o.ebo().ic(str)) {
                    HostConnectionWheatDialog.this.dismiss();
                }
                o.ebo().bi(str, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
            }
        }).a(this.ovA, alaWheatInfoData.userName, alaWheatInfoData.uk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final AlaWheatInfoData alaWheatInfoData) {
        if (o.ebo().UV(alaWheatInfoData.uk)) {
            String str = alaWheatInfoData.isOpenMike() ? "1" : "0";
            m mVar = new m();
            mVar.gN(alaWheatInfoData.uk, str);
            mVar.a(new m.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void zL(boolean z) {
                    String string;
                    alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                    HostConnectionWheatDialog.this.mD(false);
                    if (z) {
                        if (alaWheatInfoData.isOpenMike()) {
                            string = TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_open_txt);
                        } else {
                            string = TbadkCoreApplication.getInst().getString(a.h.yuyin_sdk_connect_wheat_mic_close_txt);
                        }
                        BdToast.makeText(TbadkCoreApplication.getInst(), string).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void ebm() {
                }
            });
            return;
        }
        String str2 = alaWheatInfoData.isOpenMike() ? "1" : "0";
        m mVar2 = new m();
        mVar2.gN(alaWheatInfoData.uk, str2);
        mVar2.a(new m.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.10
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
            public void zL(boolean z) {
                alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                HostConnectionWheatDialog.this.mD(false);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
            public void ebm() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        x WA = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().WA();
        if (WA != null && WA.aGd != null && WA.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ovA.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(WA.mLiveInfo.group_id), Long.toString(WA.mLiveInfo.live_id), false, null, null, str4, "")));
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
        setCurrentPage(0);
        o.ebo().zN(true);
        MessageManager.getInstance().registerListener(this.aTE);
        MessageManager.getInstance().registerListener(this.oxW);
        MessageManager.getInstance().registerListener(this.oyD);
        MessageManager.getInstance().registerListener(this.bdo);
        MessageManager.getInstance().registerListener(this.oxM);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        initListener();
        dyO();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oyt) {
            setCurrentPage(0);
        } else if (view == this.oyu) {
            setCurrentPage(1);
        } else if (view == this.oyv) {
            setCurrentPage(2);
        }
    }

    private void setCurrentPage(int i) {
        if (this.oyw != null) {
            this.oyw.setCurrentItem(i);
        }
    }

    public void mD(boolean z) {
        if (this.oyw != null) {
            J(z, this.oyw.getCurrentItem());
        }
    }

    private void J(boolean z, int i) {
        if (this.mList != null && this.mList.size() > i) {
            View view = this.mList.get(i);
            if (view instanceof ConnectionWheatApplyListView) {
                ((ConnectionWheatApplyListView) view).zR(z);
            } else if (view instanceof ConnectionWheatManagerListView) {
                ((ConnectionWheatManagerListView) view).ebp();
            } else if (view instanceof ConnectionWheatInviteListView) {
                ((ConnectionWheatInviteListView) view).zR(z);
            }
        }
    }

    private void Me(int i) {
        if (this.oyy != null && this.oyz != null && this.oyA != null) {
            this.oyy.setSelected(i == 0);
            this.oyz.setSelected(i == 1);
            this.oyA.setSelected(i == 2);
            this.oyt.setTypeface(this.oyy.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.oyu.setTypeface(this.oyz.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.oyv.setTypeface(this.oyA.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            if (this.mList != null && this.mList.size() > i) {
                View view = this.mList.get(i);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).showLoading();
                } else if (view instanceof ConnectionWheatInviteListView) {
                    ((ConnectionWheatInviteListView) view).showLoading();
                }
            }
        }
        mD(false);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Me(i);
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
        o.ebo().zN(false);
        MessageManager.getInstance().unRegisterListener(this.bdo);
        MessageManager.getInstance().unRegisterListener(this.oxM);
        MessageManager.getInstance().unRegisterListener(this.aTE);
        MessageManager.getInstance().unRegisterListener(this.oxW);
        MessageManager.getInstance().unRegisterListener(this.oyD);
        o.ebo().zN(false);
    }
}
