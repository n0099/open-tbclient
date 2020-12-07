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
    private CustomMessageListener ovB;
    private CustomMessageListener ovM;
    private TextView owi;
    private TextView owj;
    private TextView owk;
    private BaseViewPager owl;
    private j owm;
    private RelativeLayout own;
    private RelativeLayout owo;
    private RelativeLayout owp;
    private ConnectionWheatApplyListView owq;
    private int owr;
    private CustomMessageListener ows;

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
        this.ovM = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012 && HostConnectionWheatDialog.this.owl != null && HostConnectionWheatDialog.this.owl.getCurrentItem() == 0) {
                    HostConnectionWheatDialog.this.mk(false);
                }
            }
        };
        this.ows = new CustomMessageListener(2501068) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501068 && HostConnectionWheatDialog.this.owl != null && HostConnectionWheatDialog.this.owl.getCurrentItem() == 1) {
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
        this.ovB = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.4
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
        this.owl = (BaseViewPager) findViewById(a.f.connection_wheat_viewpager);
        this.owi = (TextView) findViewById(a.f.tv_connection_wheat_apply);
        this.owj = (TextView) findViewById(a.f.tv_connection_wheat_manager);
        this.owk = (TextView) findViewById(a.f.tv_connection_wheat_invite);
        this.own = (RelativeLayout) findViewById(a.f.rl_connection_wheat_apply);
        this.owo = (RelativeLayout) findViewById(a.f.rl_connection_wheat_manager);
        this.owp = (RelativeLayout) findViewById(a.f.rl_connection_wheat_invite);
        this.owl.setOnPageChangeListener(this);
    }

    private void initListener() {
        this.owi.setOnClickListener(this);
        this.owj.setOnClickListener(this);
        this.owk.setOnClickListener(this);
    }

    private void dCP() {
        this.mList = new ArrayList();
        this.owq = new ConnectionWheatApplyListView(this.oty.getPageActivity());
        this.owq.setTbPageContext(this.oty);
        this.owq.setApplyPosition(this.owr);
        this.owq.setOnItemClickLister(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void NH(int i) {
                HostConnectionWheatDialog.this.owi.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2));
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
        this.mList.add(this.owq);
        ConnectionWheatManagerListView connectionWheatManagerListView = new ConnectionWheatManagerListView(this.oty.getPageActivity());
        connectionWheatManagerListView.setListener(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void NJ(int i) {
                HostConnectionWheatDialog.this.owj.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text));
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
        ConnectionWheatInviteListView connectionWheatInviteListView = new ConnectionWheatInviteListView(this.oty.getPageActivity());
        connectionWheatInviteListView.setTbPageContext(this.oty);
        connectionWheatInviteListView.setOnItemClickLister(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void a(m mVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.d(mVar.uk, mVar.userName, mVar.portrait, mVar.sex, mVar.userName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void b(m mVar) {
                if (HostConnectionWheatDialog.this.owm == null) {
                    HostConnectionWheatDialog.this.owm = new j();
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("click_apply_wheat_anchor_1", false);
                HostConnectionWheatDialog.this.owm.a(mVar, HostConnectionWheatDialog.this.owr);
            }
        });
        this.mList.add(connectionWheatInviteListView);
        this.owl.setAdapter(new ConnectionWheatPagerAdapter(this.mList));
        NU(0);
    }

    public void NT(int i) {
        this.owr = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.data.e eVar) {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.eeH().b(eVar.uk, eVar.cuid, eVar.aIM, eVar.aIO, "1");
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.eeH().a(new a.InterfaceC0941a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7
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
                if (HostConnectionWheatDialog.this.owq != null) {
                    HostConnectionWheatDialog.this.owq.zU(false);
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
                if (o.efd().Wu(str) && !o.efd().ju(str)) {
                    HostConnectionWheatDialog.this.dismiss();
                }
                o.efd().bj(str, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
            }
        }).a(this.oty, alaWheatInfoData.userName, alaWheatInfoData.uk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final AlaWheatInfoData alaWheatInfoData) {
        if (o.efd().Wu(alaWheatInfoData.uk)) {
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
                public void efb() {
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
            public void efb() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zd();
        if (Zd != null && Zd.aKr != null && Zd.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oty.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Zd.mLiveInfo.group_id), Long.toString(Zd.mLiveInfo.live_id), false, null, null, str4, "")));
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
        o.efd().zP(true);
        MessageManager.getInstance().registerListener(this.aWL);
        MessageManager.getInstance().registerListener(this.ovM);
        MessageManager.getInstance().registerListener(this.ows);
        MessageManager.getInstance().registerListener(this.bgy);
        MessageManager.getInstance().registerListener(this.ovB);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        initListener();
        dCP();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.owi) {
            setCurrentPage(0);
        } else if (view == this.owj) {
            setCurrentPage(1);
        } else if (view == this.owk) {
            setCurrentPage(2);
        }
    }

    private void setCurrentPage(int i) {
        if (this.owl != null) {
            this.owl.setCurrentItem(i);
        }
    }

    public void mk(boolean z) {
        if (this.owl != null) {
            K(z, this.owl.getCurrentItem());
        }
    }

    private void K(boolean z, int i) {
        if (this.mList != null && this.mList.size() > i) {
            View view = this.mList.get(i);
            if (view instanceof ConnectionWheatApplyListView) {
                ((ConnectionWheatApplyListView) view).zU(z);
            } else if (view instanceof ConnectionWheatManagerListView) {
                ((ConnectionWheatManagerListView) view).efe();
            } else if (view instanceof ConnectionWheatInviteListView) {
                ((ConnectionWheatInviteListView) view).zU(z);
            }
        }
    }

    private void NU(int i) {
        if (this.own != null && this.owo != null && this.owp != null) {
            this.own.setSelected(i == 0);
            this.owo.setSelected(i == 1);
            this.owp.setSelected(i == 2);
            this.owi.setTypeface(this.own.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.owj.setTypeface(this.owo.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.owk.setTypeface(this.owp.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
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
        o.efd().zP(false);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        MessageManager.getInstance().unRegisterListener(this.ovB);
        MessageManager.getInstance().unRegisterListener(this.aWL);
        MessageManager.getInstance().unRegisterListener(this.ovM);
        MessageManager.getInstance().unRegisterListener(this.ows);
        o.efd().zP(false);
    }
}
