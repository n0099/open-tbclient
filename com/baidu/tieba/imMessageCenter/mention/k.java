package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class k extends w {
    private View aBq;
    private final CustomMessageListener aWe;
    private RelativeLayout bPO;
    private final CustomMessageListener ddn;
    private com.baidu.tieba.im.chat.notify.a ddp;
    private ImMessageCenterModel duB;
    private ImMessageCenterShowItemData duD;
    private BdListView duE;
    private ImMessageCenterListAdapter duF;
    private ShutDownValidateTipView duH;
    com.baidu.tbadk.core.dialog.c duI;
    private c.b duJ;
    private int duK;
    private boolean duL;
    private final AdapterView.OnItemClickListener duM;
    private final AdapterView.OnItemLongClickListener duN;
    private com.baidu.tbadk.mvc.f.a.b dzo;
    private final bf dzq;
    private boolean dzr;
    private CustomMessageListener dzs;
    private com.baidu.tbadk.core.view.w mNoDataView;

    public k(bf bfVar) {
        super(bfVar);
        this.duB = null;
        this.duD = null;
        this.duE = null;
        this.duF = null;
        this.duI = null;
        this.duL = true;
        this.dzr = false;
        this.aWe = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dzs = new n(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.duM = new o(this);
        this.duN = new q(this);
        this.ddn = new r(this, 0);
        this.ddp = new s(this);
        this.dzq = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void f(Bundle bundle) {
        super.f(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View me() {
        this.duK = 3;
        this.aBq = LayoutInflater.from(this.dzq.getPageContext().getPageActivity()).inflate(r.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        aa(this.aBq);
        TiebaStatic.eventStat(this.dzq.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        lT();
        return this.aBq;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View getView() {
        return this.aBq;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void lT() {
        aBp();
        this.duE.kv();
        this.dzr = TbadkCoreApplication.isLogin();
        if (!this.dzr) {
            t(this.dzr, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void aBn() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void aBo() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void Fs() {
        super.Fs();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Fr() {
        if (this.dzo == null) {
            this.dzo = new com.baidu.tbadk.mvc.f.a.b();
            this.dzo.setTitle(this.dzh.getPageContext().getString(r.j.mention_chatme));
            this.dzo.eX(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dzh.getActivity() != null) {
                aVar.view = this.dzh.getActivity().getLayoutInflater().inflate(r.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.at.c(aVar.view, r.d.common_color_10225, 1);
            }
            aVar.nC = 4;
            this.dzo.a(aVar);
            this.dzo.gj("msg_tip_key");
        }
        return this.dzo;
    }

    private void registerListener() {
        this.dzq.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.ddn);
        this.dzq.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.ddn);
        this.dzq.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.ddn);
        this.dzq.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.ddn);
        this.dzq.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.ddn);
        this.dzq.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.ddn);
        this.dzq.registerListener(this.aWe);
        this.dzq.registerListener(this.dzs);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.duF != null && this.duF.getCount() == 0) {
            gR(true);
        }
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.dzr != isLogin) {
            this.dzr = isLogin;
            onUserChanged(this.dzr);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dzq.getPageContext());
        }
    }

    private void initData() {
        this.duB = new ImMessageCenterModel();
        gI(com.baidu.tbadk.core.sharedPref.b.um().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void aa(View view) {
        this.bPO = (RelativeLayout) view.findViewById(r.g.chat_list);
        this.duH = (ShutDownValidateTipView) view.findViewById(r.g.view_no_validate);
        this.duH.setVisibility(8);
        this.duH.setShutDownClickListener(new t(this));
        this.duE = (BdListView) view.findViewById(r.g.chat_list_content);
        this.bgv = this.duE;
        this.duE.setDividerHeight(0);
        this.duF = new ImMessageCenterListAdapter(this.dzq.getPageContext().getPageActivity());
        this.duF.a(this);
        this.duE.setAdapter((ListAdapter) this.duF);
        this.duE.setOnItemClickListener(this.duM);
        this.duE.setOnItemLongClickListener(this.duN);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.duK == i) {
            return false;
        }
        this.duK = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dzq.getPageContext(), i);
        }
        if (this.duH != null) {
            this.duH.onChangeSkinType(i);
        }
        if (this.duF != null) {
            this.duF.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().x(this.bPO);
        }
        if (this.dzo == null || this.dzo.Fv() == null || this.dzo.Fv().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.at.c(this.dzo.Fv().view, r.d.common_color_10225, 1);
        return true;
    }

    private void gQ(boolean z) {
        if (z) {
            azq();
        } else {
            azr();
        }
    }

    private void azq() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dzq.getResources().getString(r.j.maintab_imcenter_button_text), new u(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dzq.getPageContext().getPageActivity(), this.bPO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dzq.getResources().getDimension(r.e.ds320)), NoDataViewFactory.d.df(r.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void azr() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dzq.getResources().getString(r.j.maintab_imcenter_unlogin_button_text), new v(this));
        int dimensionPixelSize = this.dzq.getResources().getDimensionPixelSize(r.e.ds320);
        int dimensionPixelSize2 = this.dzq.getResources().getDimensionPixelSize(r.e.ds480);
        int dimensionPixelSize3 = this.dzq.getResources().getDimensionPixelSize(r.e.ds360);
        int dimensionPixelSize4 = this.dzq.getResources().getDimensionPixelSize(r.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dzq.getPageContext().getPageActivity(), this.bPO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(r.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dzq.getResources().getDimensionPixelSize(r.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        t(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.duJ = new m(this, imMessageCenterShowItemData);
        String string = this.dzq.getPageContext().getPageActivity().getString(r.j.delete_user_chat);
        this.duI = new com.baidu.tbadk.core.dialog.c(this.dzq.getPageContext().getPageActivity());
        this.duI.cd(r.j.operation);
        this.duI.a(new String[]{string}, this.duJ);
        this.duI.d(this.dzq.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cA(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.duE.l(2000L);
        }
        return true;
    }

    public void gG(boolean z) {
        if (z) {
            if (azs() && this.duH.getVisibility() != 0) {
                this.duH.setVisibility(0);
            }
        } else if (this.duH.getVisibility() != 8) {
            this.duH.setVisibility(8);
        }
    }

    public void t(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mNoDataView != null) {
            this.bPO.removeView(this.mNoDataView);
        }
        gQ(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean azs() {
        return this.duL;
    }

    public void gI(boolean z) {
        this.duL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.duB != null) {
                    this.duB.insertOrUpdate(data, this.ddp);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.duB != null) {
                this.duB.remove(data, this.ddp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.duB != null) {
                this.duB.setData(data, this.ddp);
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bS(boolean z) {
        super.bS(z);
    }
}
