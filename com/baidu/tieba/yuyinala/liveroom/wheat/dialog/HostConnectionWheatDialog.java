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
    private CustomMessageListener aVs;
    public CustomMessageListener bek;
    private List<View> mList;
    private CustomMessageListener oeX;
    private TextView ofF;
    private TextView ofG;
    private TextView ofH;
    private BaseViewPager ofI;
    private j ofJ;
    private RelativeLayout ofK;
    private RelativeLayout ofL;
    private RelativeLayout ofM;
    private ConnectionWheatApplyListView ofN;
    private int ofO;
    private CustomMessageListener ofP;
    private CustomMessageListener ofj;

    public HostConnectionWheatDialog(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aVs = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.ofj = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012 && HostConnectionWheatDialog.this.ofI != null && HostConnectionWheatDialog.this.ofI.getCurrentItem() == 0) {
                    HostConnectionWheatDialog.this.lO(false);
                }
            }
        };
        this.ofP = new CustomMessageListener(2501068) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501068 && HostConnectionWheatDialog.this.ofI != null && HostConnectionWheatDialog.this.ofI.getCurrentItem() == 1) {
                    HostConnectionWheatDialog.this.lO(false);
                }
            }
        };
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (HostConnectionWheatDialog.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.oeX = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        Mw(80);
        zh(true);
        zi(true);
        g((DialogInterface.OnDismissListener) this);
    }

    private void initView() {
        this.ofI = (BaseViewPager) findViewById(a.f.connection_wheat_viewpager);
        this.ofF = (TextView) findViewById(a.f.tv_connection_wheat_apply);
        this.ofG = (TextView) findViewById(a.f.tv_connection_wheat_manager);
        this.ofH = (TextView) findViewById(a.f.tv_connection_wheat_invite);
        this.ofK = (RelativeLayout) findViewById(a.f.rl_connection_wheat_apply);
        this.ofL = (RelativeLayout) findViewById(a.f.rl_connection_wheat_manager);
        this.ofM = (RelativeLayout) findViewById(a.f.rl_connection_wheat_invite);
        this.ofI.setOnPageChangeListener(this);
    }

    private void initListener() {
        this.ofF.setOnClickListener(this);
        this.ofG.setOnClickListener(this);
        this.ofH.setOnClickListener(this);
    }

    private void dxY() {
        this.mList = new ArrayList();
        this.ofN = new ConnectionWheatApplyListView(this.ocV.getPageActivity());
        this.ofN.setTbPageContext(this.ocV);
        this.ofN.setApplyPosition(this.ofO);
        this.ofN.setOnItemClickLister(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void Mm(int i) {
                HostConnectionWheatDialog.this.ofF.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_request_text_2));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void a(com.baidu.live.data.e eVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.c(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void b(com.baidu.live.data.e eVar) {
                if (eVar != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_apply_wheat_anchor_1", false);
                    HostConnectionWheatDialog.this.c(eVar);
                }
            }
        });
        this.mList.add(this.ofN);
        ConnectionWheatManagerListView connectionWheatManagerListView = new ConnectionWheatManagerListView(this.ocV.getPageActivity());
        connectionWheatManagerListView.setListener(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void Mo(int i) {
                HostConnectionWheatDialog.this.ofG.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text) + i : TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_manager_text));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void i(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.c(alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, alaWheatInfoData.userName);
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
        ConnectionWheatInviteListView connectionWheatInviteListView = new ConnectionWheatInviteListView(this.ocV.getPageActivity());
        connectionWheatInviteListView.setTbPageContext(this.ocV);
        connectionWheatInviteListView.setOnItemClickLister(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void a(m mVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.c(mVar.uk, mVar.userName, mVar.portrait, mVar.sex, mVar.userName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void b(m mVar) {
                if (HostConnectionWheatDialog.this.ofJ == null) {
                    HostConnectionWheatDialog.this.ofJ = new j();
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("click_apply_wheat_anchor_1", false);
                HostConnectionWheatDialog.this.ofJ.a(mVar, HostConnectionWheatDialog.this.ofO);
            }
        });
        this.mList.add(connectionWheatInviteListView);
        this.ofI.setAdapter(new ConnectionWheatPagerAdapter(this.mList));
        Mz(0);
    }

    public void My(int i) {
        this.ofO = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.data.e eVar) {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.dZe().b(eVar.uk, eVar.cuid, eVar.aHO, eVar.aHQ, "1");
        com.baidu.tieba.yuyinala.liveroom.wheat.c.a.dZe().a(new a.InterfaceC0921a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0921a
            public void VG(String str) {
                View view = (View) HostConnectionWheatDialog.this.mList.get(0);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).Vt(str);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                }, 300L);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0921a
            public void onSuccess() {
                if (HostConnectionWheatDialog.this.ofN != null) {
                    HostConnectionWheatDialog.this.ofN.zj(false);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.a.InterfaceC0921a
            public void onFail() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(AlaWheatInfoData alaWheatInfoData) {
        new i().a(new i.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.i.a
            public void VM(String str) {
                if (o.dZA().Vu(str) && !o.dZA().iW(str)) {
                    HostConnectionWheatDialog.this.dismiss();
                }
                o.dZA().bi(str, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
            }
        }).a(this.ocV, alaWheatInfoData.userName, alaWheatInfoData.uk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final AlaWheatInfoData alaWheatInfoData) {
        if (o.dZA().Vu(alaWheatInfoData.uk)) {
            String str = alaWheatInfoData.isOpenMike() ? "1" : "0";
            com.baidu.tieba.yuyinala.liveroom.wheat.c.m mVar = new com.baidu.tieba.yuyinala.liveroom.wheat.c.m();
            mVar.gL(alaWheatInfoData.uk, str);
            mVar.a(new m.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
                public void zc(boolean z) {
                    String string;
                    alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                    HostConnectionWheatDialog.this.lO(false);
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
                public void dZy() {
                }
            });
            return;
        }
        String str2 = alaWheatInfoData.isOpenMike() ? "1" : "0";
        com.baidu.tieba.yuyinala.liveroom.wheat.c.m mVar2 = new com.baidu.tieba.yuyinala.liveroom.wheat.c.m();
        mVar2.gL(alaWheatInfoData.uk, str2);
        mVar2.a(new m.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.10
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
            public void zc(boolean z) {
                alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                HostConnectionWheatDialog.this.lO(false);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.m.a
            public void dZy() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3, int i, String str4) {
        w Xn = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xn();
        if (Xn != null && Xn.aJr != null && Xn.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ocV.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Xn.mLiveInfo.group_id), Long.toString(Xn.mLiveInfo.live_id), false, null, null, str4, "")));
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
        return LayoutInflater.from(this.bNY).inflate(a.g.yuyin_layout_dialog_connnection_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean RJ() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean RK() {
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
        o.dZA().ze(true);
        MessageManager.getInstance().registerListener(this.aVs);
        MessageManager.getInstance().registerListener(this.ofj);
        MessageManager.getInstance().registerListener(this.ofP);
        MessageManager.getInstance().registerListener(this.bek);
        MessageManager.getInstance().registerListener(this.oeX);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        initListener();
        dxY();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ofF) {
            setCurrentPage(0);
        } else if (view == this.ofG) {
            setCurrentPage(1);
        } else if (view == this.ofH) {
            setCurrentPage(2);
        }
    }

    private void setCurrentPage(int i) {
        if (this.ofI != null) {
            this.ofI.setCurrentItem(i);
        }
    }

    public void lO(boolean z) {
        if (this.ofI != null) {
            L(z, this.ofI.getCurrentItem());
        }
    }

    private void L(boolean z, int i) {
        if (this.mList != null && this.mList.size() > i) {
            View view = this.mList.get(i);
            if (view instanceof ConnectionWheatApplyListView) {
                ((ConnectionWheatApplyListView) view).zj(z);
            } else if (view instanceof ConnectionWheatManagerListView) {
                ((ConnectionWheatManagerListView) view).dZB();
            } else if (view instanceof ConnectionWheatInviteListView) {
                ((ConnectionWheatInviteListView) view).zj(z);
            }
        }
    }

    private void Mz(int i) {
        if (this.ofK != null && this.ofL != null && this.ofM != null) {
            this.ofK.setSelected(i == 0);
            this.ofL.setSelected(i == 1);
            this.ofM.setSelected(i == 2);
            this.ofF.setTypeface(this.ofK.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.ofG.setTypeface(this.ofL.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.ofH.setTypeface(this.ofM.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            if (this.mList != null && this.mList.size() > i) {
                View view = this.mList.get(i);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).showLoading();
                } else if (view instanceof ConnectionWheatInviteListView) {
                    ((ConnectionWheatInviteListView) view).showLoading();
                }
            }
        }
        lO(false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Mz(i);
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
        o.dZA().ze(false);
        MessageManager.getInstance().unRegisterListener(this.bek);
        MessageManager.getInstance().unRegisterListener(this.oeX);
        MessageManager.getInstance().unRegisterListener(this.aVs);
        MessageManager.getInstance().unRegisterListener(this.ofj);
        MessageManager.getInstance().unRegisterListener(this.ofP);
        o.dZA().ze(false);
    }
}
