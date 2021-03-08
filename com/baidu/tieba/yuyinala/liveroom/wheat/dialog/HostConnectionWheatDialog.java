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
/* loaded from: classes10.dex */
public class HostConnectionWheatDialog extends a implements DialogInterface.OnDismissListener, View.OnClickListener, ViewPager.OnPageChangeListener {
    private CustomMessageListener aYj;
    public CustomMessageListener bhY;
    private List<View> mList;
    private CustomMessageListener oJY;
    private TextView oKF;
    private TextView oKG;
    private TextView oKH;
    private BaseViewPager oKI;
    private l oKJ;
    private RelativeLayout oKK;
    private RelativeLayout oKL;
    private RelativeLayout oKM;
    private ConnectionWheatApplyListView oKN;
    private int oKO;
    private CustomMessageListener oKP;
    private CustomMessageListener oKi;

    public HostConnectionWheatDialog(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aYj = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.oKi = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012 && HostConnectionWheatDialog.this.oKI != null && HostConnectionWheatDialog.this.oKI.getCurrentItem() == 0) {
                    HostConnectionWheatDialog.this.mH(false);
                }
            }
        };
        this.oKP = new CustomMessageListener(2501068) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501068 && HostConnectionWheatDialog.this.oKI != null && HostConnectionWheatDialog.this.oKI.getCurrentItem() == 1) {
                    HostConnectionWheatDialog.this.mH(false);
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (HostConnectionWheatDialog.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.oJY = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        MB(80);
        Ah(true);
        Ai(true);
        g((DialogInterface.OnDismissListener) this);
    }

    private void initView() {
        this.oKI = (BaseViewPager) findViewById(a.f.connection_wheat_viewpager);
        this.oKF = (TextView) findViewById(a.f.tv_connection_wheat_apply);
        this.oKG = (TextView) findViewById(a.f.tv_connection_wheat_manager);
        this.oKH = (TextView) findViewById(a.f.tv_connection_wheat_invite);
        this.oKK = (RelativeLayout) findViewById(a.f.rl_connection_wheat_apply);
        this.oKL = (RelativeLayout) findViewById(a.f.rl_connection_wheat_manager);
        this.oKM = (RelativeLayout) findViewById(a.f.rl_connection_wheat_invite);
        this.oKI.setOnPageChangeListener(this);
    }

    private void initListener() {
        this.oKF.setOnClickListener(this);
        this.oKG.setOnClickListener(this);
        this.oKH.setOnClickListener(this);
    }

    private void dBn() {
        this.mList = new ArrayList();
        this.oKN = new ConnectionWheatApplyListView(this.oIJ.getPageActivity());
        this.oKN.setTbPageContext(this.oIJ);
        this.oKN.setApplyPosition(this.oKO);
        this.oKN.setOnItemClickLister(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void Mq(int i) {
                HostConnectionWheatDialog.this.oKF.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2));
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
        this.mList.add(this.oKN);
        ConnectionWheatManagerListView connectionWheatManagerListView = new ConnectionWheatManagerListView(this.oIJ.getPageActivity());
        connectionWheatManagerListView.setListener(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void Ms(int i) {
                HostConnectionWheatDialog.this.oKG.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text));
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
        ConnectionWheatInviteListView connectionWheatInviteListView = new ConnectionWheatInviteListView(this.oIJ.getPageActivity());
        connectionWheatInviteListView.setTbPageContext(this.oIJ);
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
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micinvite_clk").setContentExt(jSONObject));
                if (HostConnectionWheatDialog.this.oKJ == null) {
                    HostConnectionWheatDialog.this.oKJ = new l();
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_apply_wheat_anchor_1", false);
                int i2 = HostConnectionWheatDialog.this.oKO;
                if (q.edU().eeh()) {
                    if (!z || i2 < 5) {
                        if (!z && i2 < 5) {
                            i = 5;
                        }
                    }
                    if (HostConnectionWheatDialog.this.oKJ == null) {
                        HostConnectionWheatDialog.this.oKJ.a(rVar, i);
                        return;
                    }
                    return;
                }
                i = i2;
                if (HostConnectionWheatDialog.this.oKJ == null) {
                }
            }
        });
        this.mList.add(connectionWheatInviteListView);
        this.oKI.setAdapter(new ConnectionWheatPagerAdapter(this.mList));
        MF(0);
    }

    public void ME(int i) {
        this.oKO = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.data.e eVar) {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.edt().a(eVar.uk, eVar.cuid, eVar.aHI, eVar.aHK, "1");
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.edt().a(new a.InterfaceC0950a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0950a
            public void Wy(String str) {
                View view = (View) HostConnectionWheatDialog.this.mList.get(0);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).Wl(str);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                }, 300L);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0950a
            public void onSuccess() {
                if (HostConnectionWheatDialog.this.oKN != null) {
                    HostConnectionWheatDialog.this.oKN.Aj(false);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0950a
            public void onFail() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AlaWheatInfoData alaWheatInfoData) {
        new k().a(new k.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.k.a
            public void WE(String str) {
                if (q.edU().Wm(str) && !q.edU().iO(str)) {
                    HostConnectionWheatDialog.this.dismiss();
                }
                q.edU().bi(str, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
            }
        }).a(this.oIJ, alaWheatInfoData.userName, alaWheatInfoData.uk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final AlaWheatInfoData alaWheatInfoData) {
        if (q.edU().Wm(alaWheatInfoData.uk)) {
            String str = alaWheatInfoData.isOpenMike() ? "1" : "0";
            o oVar = new o();
            oVar.gW(alaWheatInfoData.uk, str);
            oVar.a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
                public void Ad(boolean z) {
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
                public void edP() {
                }
            });
            return;
        }
        String str2 = alaWheatInfoData.isOpenMike() ? "1" : "0";
        o oVar2 = new o();
        oVar2.gW(alaWheatInfoData.uk, str2);
        oVar2.a(new o.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.10
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void Ad(boolean z) {
                alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                HostConnectionWheatDialog.this.mH(false);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.o.a
            public void edP() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
        if (Yt != null && Yt.aJZ != null && Yt.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oIJ.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Yt.mLiveInfo.group_id), Long.toString(Yt.mLiveInfo.live_id), false, null, null, str4, "")));
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
        setCurrentPage(0);
        q.edU().Af(true);
        MessageManager.getInstance().registerListener(this.aYj);
        MessageManager.getInstance().registerListener(this.oKi);
        MessageManager.getInstance().registerListener(this.oKP);
        MessageManager.getInstance().registerListener(this.bhY);
        MessageManager.getInstance().registerListener(this.oJY);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        initListener();
        dBn();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oKF) {
            setCurrentPage(0);
        } else if (view == this.oKG) {
            setCurrentPage(1);
        } else if (view == this.oKH) {
            setCurrentPage(2);
        }
    }

    private void setCurrentPage(int i) {
        if (this.oKI != null) {
            this.oKI.setCurrentItem(i);
        }
    }

    public void mH(boolean z) {
        if (this.oKI != null) {
            J(z, this.oKI.getCurrentItem());
        }
    }

    private void J(boolean z, int i) {
        if (this.mList != null && this.mList.size() > i) {
            View view = this.mList.get(i);
            if (view instanceof ConnectionWheatApplyListView) {
                ((ConnectionWheatApplyListView) view).Aj(z);
            } else if (view instanceof ConnectionWheatManagerListView) {
                ((ConnectionWheatManagerListView) view).edV();
            } else if (view instanceof ConnectionWheatInviteListView) {
                ((ConnectionWheatInviteListView) view).Aj(z);
            }
        }
    }

    private void MF(int i) {
        if (this.oKK != null && this.oKL != null && this.oKM != null) {
            this.oKK.setSelected(i == 0);
            this.oKL.setSelected(i == 1);
            this.oKM.setSelected(i == 2);
            this.oKF.setTypeface(this.oKK.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.oKG.setTypeface(this.oKL.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.oKH.setTypeface(this.oKM.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
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
        MF(i);
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
        q.edU().Af(false);
        MessageManager.getInstance().unRegisterListener(this.bhY);
        MessageManager.getInstance().unRegisterListener(this.oJY);
        MessageManager.getInstance().unRegisterListener(this.aYj);
        MessageManager.getInstance().unRegisterListener(this.oKi);
        MessageManager.getInstance().unRegisterListener(this.oKP);
        q.edU().Af(false);
    }
}
