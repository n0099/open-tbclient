package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.net.http.Headers;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.m;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.BaseViewPager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
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
/* loaded from: classes4.dex */
public class HostConnectionWheatDialog extends a implements DialogInterface.OnDismissListener, ViewPager.OnPageChangeListener, View.OnClickListener {
    private CustomMessageListener aWL;
    public CustomMessageListener bgy;
    private List<View> mList;
    private CustomMessageListener ovD;
    private CustomMessageListener ovO;
    private TextView owk;
    private TextView owl;
    private TextView owm;
    private BaseViewPager own;
    private j owo;
    private RelativeLayout owp;
    private RelativeLayout owq;
    private RelativeLayout owr;
    private ConnectionWheatApplyListView ows;
    private int owt;
    private CustomMessageListener owu;

    public HostConnectionWheatDialog(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aWL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.ovO = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012 && HostConnectionWheatDialog.this.own != null && HostConnectionWheatDialog.this.own.getCurrentItem() == 0) {
                    HostConnectionWheatDialog.this.mk(false);
                }
            }
        };
        this.owu = new CustomMessageListener(2501068) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501068 && HostConnectionWheatDialog.this.own != null && HostConnectionWheatDialog.this.own.getCurrentItem() == 1) {
                    HostConnectionWheatDialog.this.mk(false);
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
        this.ovD = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        NR(80);
        zS(true);
        zT(true);
        g((DialogInterface.OnDismissListener) this);
    }

    private void initView() {
        this.own = (BaseViewPager) findViewById(a.f.connection_wheat_viewpager);
        this.owk = (TextView) findViewById(a.f.tv_connection_wheat_apply);
        this.owl = (TextView) findViewById(a.f.tv_connection_wheat_manager);
        this.owm = (TextView) findViewById(a.f.tv_connection_wheat_invite);
        this.owp = (RelativeLayout) findViewById(a.f.rl_connection_wheat_apply);
        this.owq = (RelativeLayout) findViewById(a.f.rl_connection_wheat_manager);
        this.owr = (RelativeLayout) findViewById(a.f.rl_connection_wheat_invite);
        this.own.setOnPageChangeListener(this);
    }

    private void initListener() {
        this.owk.setOnClickListener(this);
        this.owl.setOnClickListener(this);
        this.owm.setOnClickListener(this);
    }

    private void dCQ() {
        this.mList = new ArrayList();
        this.ows = new ConnectionWheatApplyListView(this.otA.getPageActivity());
        this.ows.setTbPageContext(this.otA);
        this.ows.setApplyPosition(this.owt);
        this.ows.setOnItemClickLister(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void NH(int i) {
                HostConnectionWheatDialog.this.owk.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void a(com.baidu.live.data.e eVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.d(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void b(com.baidu.live.data.e eVar) {
                if (eVar != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("click_apply_wheat_anchor_1", false);
                    HostConnectionWheatDialog.this.c(eVar);
                }
            }
        });
        this.mList.add(this.ows);
        ConnectionWheatManagerListView connectionWheatManagerListView = new ConnectionWheatManagerListView(this.otA.getPageActivity());
        connectionWheatManagerListView.setListener(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void NJ(int i) {
                HostConnectionWheatDialog.this.owl.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void i(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.d(alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, alaWheatInfoData.userName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void j(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.m(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void k(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.n(alaWheatInfoData);
            }
        });
        this.mList.add(connectionWheatManagerListView);
        ConnectionWheatInviteListView connectionWheatInviteListView = new ConnectionWheatInviteListView(this.otA.getPageActivity());
        connectionWheatInviteListView.setTbPageContext(this.otA);
        connectionWheatInviteListView.setOnItemClickLister(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void a(m mVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.d(mVar.uk, mVar.userName, mVar.portrait, mVar.sex, mVar.userName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void b(m mVar) {
                if (HostConnectionWheatDialog.this.owo == null) {
                    HostConnectionWheatDialog.this.owo = new j();
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("click_apply_wheat_anchor_1", false);
                HostConnectionWheatDialog.this.owo.a(mVar, HostConnectionWheatDialog.this.owt);
            }
        });
        this.mList.add(connectionWheatInviteListView);
        this.own.setAdapter(new ConnectionWheatPagerAdapter(this.mList));
        NU(0);
    }

    public void NT(int i) {
        this.owt = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.data.e eVar) {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.eeI().b(eVar.uk, eVar.cuid, eVar.aIM, eVar.aIO, "1");
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.eeI().a(new a.InterfaceC0941a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0941a
            public void WG(String str) {
                View view = (View) HostConnectionWheatDialog.this.mList.get(0);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).Wt(str);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                }, 300L);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0941a
            public void onSuccess() {
                if (HostConnectionWheatDialog.this.ows != null) {
                    HostConnectionWheatDialog.this.ows.zU(false);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0941a
            public void onFail() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AlaWheatInfoData alaWheatInfoData) {
        new i().a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void WM(String str) {
                if (o.efe().Wu(str) && !o.efe().ju(str)) {
                    HostConnectionWheatDialog.this.dismiss();
                }
                o.efe().bj(str, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
            }
        }).a(this.otA, alaWheatInfoData.userName, alaWheatInfoData.uk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final AlaWheatInfoData alaWheatInfoData) {
        if (o.efe().Wu(alaWheatInfoData.uk)) {
            String str = alaWheatInfoData.isOpenMike() ? "1" : "0";
            com.baidu.tieba.yuyinala.liveroom.wheat.c.m mVar = new com.baidu.tieba.yuyinala.liveroom.wheat.c.m();
            mVar.gQ(alaWheatInfoData.uk, str);
            mVar.a(new m.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void zN(boolean z) {
                    String string;
                    alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                    HostConnectionWheatDialog.this.mk(false);
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
                public void efc() {
                }
            });
            return;
        }
        String str2 = alaWheatInfoData.isOpenMike() ? "1" : "0";
        com.baidu.tieba.yuyinala.liveroom.wheat.c.m mVar2 = new com.baidu.tieba.yuyinala.liveroom.wheat.c.m();
        mVar2.gQ(alaWheatInfoData.uk, str2);
        mVar2.a(new m.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.10
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
            public void zN(boolean z) {
                alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                HostConnectionWheatDialog.this.mk(false);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
            public void efc() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Zd();
        if (Zd != null && Zd.aKr != null && Zd.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.otA.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Zd.mLiveInfo.group_id), Long.toString(Zd.mLiveInfo.live_id), false, null, null, str4, "")));
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
        return LayoutInflater.from(this.beD).inflate(a.g.yuyin_layout_dialog_connnection_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Ty() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Tz() {
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
        o.efe().zP(true);
        MessageManager.getInstance().registerListener(this.aWL);
        MessageManager.getInstance().registerListener(this.ovO);
        MessageManager.getInstance().registerListener(this.owu);
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.ovD);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        initListener();
        dCQ();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.owk) {
            setCurrentPage(0);
        } else if (view == this.owl) {
            setCurrentPage(1);
        } else if (view == this.owm) {
            setCurrentPage(2);
        }
    }

    private void setCurrentPage(int i) {
        if (this.own != null) {
            this.own.setCurrentItem(i);
        }
    }

    public void mk(boolean z) {
        if (this.own != null) {
            K(z, this.own.getCurrentItem());
        }
    }

    private void K(boolean z, int i) {
        if (this.mList != null && this.mList.size() > i) {
            View view = this.mList.get(i);
            if (view instanceof ConnectionWheatApplyListView) {
                ((ConnectionWheatApplyListView) view).zU(z);
            } else if (view instanceof ConnectionWheatManagerListView) {
                ((ConnectionWheatManagerListView) view).eff();
            } else if (view instanceof ConnectionWheatInviteListView) {
                ((ConnectionWheatInviteListView) view).zU(z);
            }
        }
    }

    private void NU(int i) {
        if (this.owp != null && this.owq != null && this.owr != null) {
            this.owp.setSelected(i == 0);
            this.owq.setSelected(i == 1);
            this.owr.setSelected(i == 2);
            this.owk.setTypeface(this.owp.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.owl.setTypeface(this.owq.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.owm.setTypeface(this.owr.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            if (this.mList != null && this.mList.size() > i) {
                View view = this.mList.get(i);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).showLoading();
                } else if (view instanceof ConnectionWheatInviteListView) {
                    ((ConnectionWheatInviteListView) view).showLoading();
                }
            }
        }
        mk(false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        NU(i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
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
        o.efe().zP(false);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.ovD);
        MessageManager.getInstance().unRegisterListener(this.aWL);
        MessageManager.getInstance().unRegisterListener(this.ovO);
        MessageManager.getInstance().unRegisterListener(this.owu);
        o.efe().zP(false);
    }
}
