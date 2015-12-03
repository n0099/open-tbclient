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
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class k extends v {
    private final CustomMessageListener aHO;
    private boolean aRa;
    private final CustomMessageListener bJJ;
    private com.baidu.tieba.im.chat.notify.a bJK;
    private ImMessageCenterShowItemData bZA;
    private BdListView bZB;
    private ImMessageCenterListAdapter bZC;
    private ShutDownValidateTipView bZE;
    com.baidu.tbadk.core.dialog.c bZF;
    private c.b bZG;
    private boolean bZH;
    private RelativeLayout bZI;
    private final AdapterView.OnItemLongClickListener bZJ;
    private ImMessageCenterModel bZy;
    private int bxU;
    private com.baidu.tbadk.mvc.f.a.b cen;
    private final bc cep;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private View rootView;

    public k(bc bcVar) {
        super(bcVar);
        this.bZy = null;
        this.bZA = null;
        this.bZB = null;
        this.bZC = null;
        this.bZF = null;
        this.bZH = true;
        this.aRa = false;
        this.aHO = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.mItemClickListener = new m(this);
        this.bZJ = new o(this);
        this.bJJ = new p(this, 0);
        this.bJK = new q(this);
        this.cep = bcVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public void h(Bundle bundle) {
        super.h(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public View pg() {
        this.bxU = 3;
        this.rootView = LayoutInflater.from(this.cep.getPageContext().getPageActivity()).inflate(n.g.chat_list_activity, (ViewGroup) null, false);
        initData();
        A(this.rootView);
        TiebaStatic.eventStat(this.cep.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        oX();
        return this.rootView;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public View getView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v
    protected void oX() {
        this.bZB.nD();
        this.aRa = TbadkCoreApplication.isLogin();
        if (!this.aRa) {
            i(this.aRa, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public void adk() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public void adl() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v, com.baidu.tbadk.mvc.f.a.a
    public void DX() {
        super.DX();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DW() {
        if (this.cen == null) {
            this.cen = new com.baidu.tbadk.mvc.f.a.b();
            this.cen.setTitle(this.ceg.getPageContext().getString(n.i.mention_chatme));
            this.cen.eD(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.ceg.getActivity() != null) {
                aVar.view = this.ceg.getActivity().getLayoutInflater().inflate(n.g.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.as.b(aVar.view, n.c.frs_slidebar_message_text, 1);
            }
            aVar.uu = 4;
            this.cen.a(aVar);
            this.cen.fO("msg_tip_key");
        }
        return this.cen;
    }

    private void registerListener() {
        this.cep.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bJJ);
        this.cep.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bJJ);
        this.cep.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bJJ);
        this.cep.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bJJ);
        this.cep.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bJJ);
        this.cep.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bJJ);
        this.cep.registerListener(this.aHO);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.aRa != isLogin) {
            this.aRa = isLogin;
            onUserChanged(this.aRa);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.cep.getPageContext());
        }
    }

    private void initData() {
        this.bZy = new ImMessageCenterModel();
        dT(com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void A(View view) {
        this.bZI = (RelativeLayout) view.findViewById(n.f.chat_list);
        this.bZE = (ShutDownValidateTipView) view.findViewById(n.f.view_no_validate);
        this.bZE.setVisibility(8);
        this.bZE.setShutDownClickListener(new r(this));
        this.bZB = (BdListView) view.findViewById(n.f.chat_list_content);
        this.aNj = this.bZB;
        this.bZB.setDividerHeight(0);
        this.bZC = new ImMessageCenterListAdapter(this.cep.getPageContext().getPageActivity());
        this.bZC.a(this);
        this.bZB.setAdapter((ListAdapter) this.bZC);
        this.bZB.setOnItemClickListener(this.mItemClickListener);
        this.bZB.setOnItemLongClickListener(this.bZJ);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.v
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bxU == i) {
            return false;
        }
        this.bxU = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cep.getPageContext(), i);
        }
        if (this.bZE != null) {
            this.bZE.onChangeSkinType(i);
        }
        if (this.bZC != null) {
            this.bZC.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().k(this.bZI);
        }
        if (this.cen == null || this.cen.Ea() == null || this.cen.Ea().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.as.b(this.cen.Ea().view, n.c.frs_slidebar_message_text, 1);
        return true;
    }

    private void eb(boolean z) {
        if (z) {
            abm();
        } else {
            abn();
        }
    }

    private void abm() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cep.getResources().getString(n.i.maintab_imcenter_button_text), new s(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.cep.getPageContext().getPageActivity(), this.bZI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cep.getResources().getDimension(n.d.ds80)), NoDataViewFactory.d.cS(n.i.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void abn() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.cep.getResources().getString(n.i.maintab_imcenter_unlogin_button_text), new t(this));
        int dimensionPixelSize = this.cep.getResources().getDimensionPixelSize(n.d.ds100);
        int dimensionPixelSize2 = this.cep.getResources().getDimensionPixelSize(n.d.ds480);
        int dimensionPixelSize3 = this.cep.getResources().getDimensionPixelSize(n.d.ds360);
        int dimensionPixelSize4 = this.cep.getResources().getDimensionPixelSize(n.d.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.cep.getPageContext().getPageActivity(), this.bZI, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.e.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.C(n.i.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.cep.getResources().getDimensionPixelSize(n.d.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        i(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bZG = new u(this, imMessageCenterShowItemData);
        String string = this.cep.getPageContext().getPageActivity().getString(n.i.delete_user_chat);
        this.bZF = new com.baidu.tbadk.core.dialog.c(this.cep.getPageContext().getPageActivity());
        this.bZF.bQ(n.i.operation);
        this.bZF.a(new String[]{string}, this.bZG);
        this.bZF.d(this.cep.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bO(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.bZB.completePullRefresh();
        }
        return true;
    }

    public void dR(boolean z) {
        if (z) {
            if (abo() && this.bZE.getVisibility() != 0) {
                this.bZE.setVisibility(0);
            }
        } else if (this.bZE.getVisibility() != 8) {
            this.bZE.setVisibility(8);
        }
    }

    public void i(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mNoDataView != null) {
            this.bZI.removeView(this.mNoDataView);
        }
        eb(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean abo() {
        return this.bZH;
    }

    public void dT(boolean z) {
        this.bZH = z;
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
                if (this.bZy != null) {
                    this.bZy.insertOrUpdate(data, this.bJK);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.bZy != null) {
                this.bZy.remove(data, this.bJK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.bZy != null) {
                this.bZy.setData(data, this.bJK);
            }
        }
    }
}
