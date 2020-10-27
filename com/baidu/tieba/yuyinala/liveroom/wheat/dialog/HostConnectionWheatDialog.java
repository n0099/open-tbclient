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
import com.baidu.tieba.yuyinala.liveroom.wheat.b.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.i;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.l;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatManagerListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HostConnectionWheatDialog extends a implements DialogInterface.OnDismissListener, ViewPager.OnPageChangeListener, View.OnClickListener {
    private CustomMessageListener aUa;
    public CustomMessageListener bcQ;
    private List<View> mList;
    private CustomMessageListener nXG;
    private CustomMessageListener nXQ;
    private TextView nYm;
    private TextView nYn;
    private TextView nYo;
    private BaseViewPager nYp;
    private i nYq;
    private RelativeLayout nYr;
    private RelativeLayout nYs;
    private RelativeLayout nYt;
    private ConnectionWheatApplyListView nYu;
    private CustomMessageListener nYv;

    public HostConnectionWheatDialog(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aUa = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.nXQ = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012 && HostConnectionWheatDialog.this.nYp != null && HostConnectionWheatDialog.this.nYp.getCurrentItem() == 0) {
                    HostConnectionWheatDialog.this.lF(false);
                }
            }
        };
        this.nYv = new CustomMessageListener(2501068) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501068 && HostConnectionWheatDialog.this.nYp != null && HostConnectionWheatDialog.this.nYp.getCurrentItem() == 1) {
                    HostConnectionWheatDialog.this.lF(false);
                }
            }
        };
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (HostConnectionWheatDialog.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        this.nXG = new CustomMessageListener(2501071) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501071) {
                    HostConnectionWheatDialog.this.dismiss();
                }
            }
        };
        Mf(80);
        yZ(true);
        za(true);
        g(this);
    }

    private void initView() {
        this.nYp = (BaseViewPager) findViewById(a.g.connection_wheat_viewpager);
        this.nYm = (TextView) findViewById(a.g.tv_connection_wheat_apply);
        this.nYn = (TextView) findViewById(a.g.tv_connection_wheat_manager);
        this.nYo = (TextView) findViewById(a.g.tv_connection_wheat_invite);
        this.nYr = (RelativeLayout) findViewById(a.g.rl_connection_wheat_apply);
        this.nYs = (RelativeLayout) findViewById(a.g.rl_connection_wheat_manager);
        this.nYt = (RelativeLayout) findViewById(a.g.rl_connection_wheat_invite);
        this.nYp.setOnPageChangeListener(this);
    }

    private void initListener() {
        this.nYm.setOnClickListener(this);
        this.nYn.setOnClickListener(this);
        this.nYo.setOnClickListener(this);
    }

    private void dvw() {
        this.mList = new ArrayList();
        this.nYu = new ConnectionWheatApplyListView(this.nVE.getPageActivity());
        this.nYu.setTbPageContext(this.nVE);
        this.nYu.setOnItemClickLister(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void LV(int i) {
                HostConnectionWheatDialog.this.nYm.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_request_text_2) + i : TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_request_text_2));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void a(com.baidu.live.data.e eVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.c(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.a
            public void b(com.baidu.live.data.e eVar) {
                if (eVar != null) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("click_apply_wheat_anchor_1", false);
                    HostConnectionWheatDialog.this.c(eVar);
                }
            }
        });
        this.mList.add(this.nYu);
        ConnectionWheatManagerListView connectionWheatManagerListView = new ConnectionWheatManagerListView(this.nVE.getPageActivity());
        connectionWheatManagerListView.setListener(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void LX(int i) {
                HostConnectionWheatDialog.this.nYn.setText(i > 0 ? TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_manager_text) + i : TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_manager_text));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void g(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.c(alaWheatInfoData.uk, alaWheatInfoData.userName, alaWheatInfoData.portrait, alaWheatInfoData.sex, alaWheatInfoData.userName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void h(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.j(alaWheatInfoData);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d.a
            public void i(AlaWheatInfoData alaWheatInfoData) {
                HostConnectionWheatDialog.this.k(alaWheatInfoData);
            }
        });
        this.mList.add(connectionWheatManagerListView);
        ConnectionWheatInviteListView connectionWheatInviteListView = new ConnectionWheatInviteListView(this.nVE.getPageActivity());
        connectionWheatInviteListView.setTbPageContext(this.nVE);
        connectionWheatInviteListView.setOnItemClickLister(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.6
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void a(m mVar) {
                HostConnectionWheatDialog.this.dismiss();
                HostConnectionWheatDialog.this.c(mVar.uk, mVar.userName, mVar.portrait, mVar.sex, mVar.userName);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.a
            public void b(m mVar) {
                if (HostConnectionWheatDialog.this.nYq == null) {
                    HostConnectionWheatDialog.this.nYq = new i();
                }
                com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("click_apply_wheat_anchor_1", false);
                HostConnectionWheatDialog.this.nYq.c(mVar);
            }
        });
        this.mList.add(connectionWheatInviteListView);
        this.nYp.setAdapter(new ConnectionWheatPagerAdapter(this.mList));
        Mh(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.live.data.e eVar) {
        com.baidu.tieba.yuyinala.liveroom.wheat.b.a.dWf().b(eVar.uk, eVar.cuid, eVar.aGY, eVar.aGZ, "1");
        com.baidu.tieba.yuyinala.liveroom.wheat.b.a.dWf().a(new a.InterfaceC0905a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a.InterfaceC0905a
            public void Vm(String str) {
                View view = (View) HostConnectionWheatDialog.this.mList.get(0);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).Vc(str);
                }
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                    }
                }, 300L);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a.InterfaceC0905a
            public void onSuccess() {
                if (HostConnectionWheatDialog.this.nYu != null) {
                    HostConnectionWheatDialog.this.nYu.zb(false);
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.a.InterfaceC0905a
            public void onFail() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AlaWheatInfoData alaWheatInfoData) {
        new h().a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.8
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.h.a
            public void Vp(String str) {
                if (n.dWB().Vd(str) && !n.dWB().iJ(str)) {
                    HostConnectionWheatDialog.this.dismiss();
                }
                n.dWB().Vu(str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009, Headers.REFRESH));
            }
        }).a(this.nVE, alaWheatInfoData.userName, alaWheatInfoData.uk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final AlaWheatInfoData alaWheatInfoData) {
        if (n.dWB().Vd(alaWheatInfoData.uk)) {
            String str = alaWheatInfoData.isOpenMike() ? "1" : "0";
            l lVar = new l();
            lVar.gL(alaWheatInfoData.uk, str);
            lVar.a(new l.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.9
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.l.a
                public void yU(boolean z) {
                    String string;
                    alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                    HostConnectionWheatDialog.this.lF(false);
                    if (z) {
                        if (alaWheatInfoData.isOpenMike()) {
                            string = TbadkCoreApplication.getInst().getString(a.i.yuyin_sdk_connect_wheat_mic_open_txt);
                        } else {
                            string = TbadkCoreApplication.getInst().getString(a.i.yuyin_sdk_connect_wheat_mic_close_txt);
                        }
                        BdToast.makeText(TbadkCoreApplication.getInst(), string).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.l.a
                public void dWz() {
                }
            });
            return;
        }
        String str2 = alaWheatInfoData.isOpenMike() ? "1" : "0";
        l lVar2 = new l();
        lVar2.gL(alaWheatInfoData.uk, str2);
        lVar2.a(new l.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.HostConnectionWheatDialog.10
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.l.a
            public void yU(boolean z) {
                alaWheatInfoData.mikeStatus = alaWheatInfoData.isOpenMike() ? "1" : "0";
                HostConnectionWheatDialog.this.lF(false);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.l.a
            public void dWz() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3, int i, String str4) {
        w UO = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UO();
        if (UO != null && UO.aIA != null && UO.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nVE.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(UO.mLiveInfo.group_id), Long.toString(UO.mLiveInfo.live_id), false, null, null, str4, "")));
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
        return LayoutInflater.from(this.bIs).inflate(a.h.yuyin_layout_dialog_connnection_wheat, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QG() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QH() {
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
        n.dWB().yX(true);
        MessageManager.getInstance().registerListener(this.aUa);
        MessageManager.getInstance().registerListener(this.nXQ);
        MessageManager.getInstance().registerListener(this.nYv);
        MessageManager.getInstance().registerListener(this.bcQ);
        MessageManager.getInstance().registerListener(this.nXG);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        initListener();
        dvw();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nYm) {
            setCurrentPage(0);
        } else if (view == this.nYn) {
            setCurrentPage(1);
        } else if (view == this.nYo) {
            setCurrentPage(2);
        }
    }

    private void setCurrentPage(int i) {
        if (this.nYp != null) {
            this.nYp.setCurrentItem(i);
        }
    }

    public void lF(boolean z) {
        if (this.nYp != null) {
            K(z, this.nYp.getCurrentItem());
        }
    }

    private void K(boolean z, int i) {
        if (this.mList != null && this.mList.size() > i) {
            View view = this.mList.get(i);
            if (view instanceof ConnectionWheatApplyListView) {
                ((ConnectionWheatApplyListView) view).zb(z);
            } else if (view instanceof ConnectionWheatManagerListView) {
                ((ConnectionWheatManagerListView) view).dWC();
            } else if (view instanceof ConnectionWheatInviteListView) {
                ((ConnectionWheatInviteListView) view).zb(z);
            }
        }
    }

    private void Mh(int i) {
        if (this.nYr != null && this.nYs != null && this.nYt != null) {
            this.nYr.setSelected(i == 0);
            this.nYs.setSelected(i == 1);
            this.nYt.setSelected(i == 2);
            this.nYm.setTypeface(this.nYr.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.nYn.setTypeface(this.nYs.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.nYo.setTypeface(this.nYt.isSelected() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            if (this.mList != null && this.mList.size() > i) {
                View view = this.mList.get(i);
                if (view instanceof ConnectionWheatApplyListView) {
                    ((ConnectionWheatApplyListView) view).showLoading();
                } else if (view instanceof ConnectionWheatInviteListView) {
                    ((ConnectionWheatInviteListView) view).showLoading();
                }
            }
        }
        lF(false);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Mh(i);
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
        n.dWB().yX(false);
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        MessageManager.getInstance().unRegisterListener(this.nXG);
        MessageManager.getInstance().unRegisterListener(this.aUa);
        MessageManager.getInstance().unRegisterListener(this.nXQ);
        MessageManager.getInstance().unRegisterListener(this.nYv);
        n.dWB().yX(false);
    }
}
