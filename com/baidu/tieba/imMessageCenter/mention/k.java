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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class k extends w {
    private View aAh;
    private final CustomMessageListener aNn;
    private boolean bbM;
    private final CustomMessageListener cbJ;
    private com.baidu.tieba.im.chat.notify.a cbL;
    private ImMessageCenterModel csC;
    private ImMessageCenterShowItemData csE;
    private BdListView csF;
    private ImMessageCenterListAdapter csG;
    private ShutDownValidateTipView csI;
    com.baidu.tbadk.core.dialog.c csJ;
    private c.b csK;
    private int csL;
    private boolean csM;
    private RelativeLayout csN;
    private final AdapterView.OnItemClickListener csO;
    private final AdapterView.OnItemLongClickListener csP;
    private com.baidu.tbadk.mvc.f.a.b cxq;
    private final be cxs;
    private CustomMessageListener cxt;
    private com.baidu.tbadk.core.view.p mNoDataView;

    public k(be beVar) {
        super(beVar);
        this.csC = null;
        this.csE = null;
        this.csF = null;
        this.csG = null;
        this.csJ = null;
        this.csM = true;
        this.bbM = false;
        this.aNn = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.cxt = new n(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.csO = new o(this);
        this.csP = new q(this);
        this.cbJ = new r(this, 0);
        this.cbL = new s(this);
        this.cxs = beVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void g(Bundle bundle) {
        super.g(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View oT() {
        this.csL = 3;
        this.aAh = LayoutInflater.from(this.cxs.getPageContext().getPageActivity()).inflate(t.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        V(this.aAh);
        TiebaStatic.eventStat(this.cxs.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        oJ();
        return this.aAh;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View getView() {
        return this.aAh;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void oJ() {
        this.csF.nk();
        this.bbM = TbadkCoreApplication.isLogin();
        if (!this.bbM) {
            o(this.bbM, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void akX() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void akY() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void FT() {
        super.FT();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b FS() {
        if (this.cxq == null) {
            this.cxq = new com.baidu.tbadk.mvc.f.a.b();
            this.cxq.setTitle(this.cxj.getPageContext().getString(t.j.mention_chatme));
            this.cxq.eX(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cxj.getActivity() != null) {
                aVar.view = this.cxj.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.at.b(aVar.view, t.d.frs_slidebar_message_text, 1);
            }
            aVar.uO = 4;
            this.cxq.a(aVar);
            this.cxq.fY("msg_tip_key");
        }
        return this.cxq;
    }

    private void registerListener() {
        this.cxs.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cbJ);
        this.cxs.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cbJ);
        this.cxs.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cbJ);
        this.cxs.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cbJ);
        this.cxs.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cbJ);
        this.cxs.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cbJ);
        this.cxs.registerListener(this.aNn);
        this.cxs.registerListener(this.cxt);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.csG != null && this.csG.getCount() == 0) {
            eF(true);
        }
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.bbM != isLogin) {
            this.bbM = isLogin;
            onUserChanged(this.bbM);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.cxs.getPageContext());
        }
    }

    private void initData() {
        this.csC = new ImMessageCenterModel();
        ew(com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void V(View view) {
        this.csN = (RelativeLayout) view.findViewById(t.g.chat_list);
        this.csI = (ShutDownValidateTipView) view.findViewById(t.g.view_no_validate);
        this.csI.setVisibility(8);
        this.csI.setShutDownClickListener(new t(this));
        this.csF = (BdListView) view.findViewById(t.g.chat_list_content);
        this.aWV = this.csF;
        this.csF.setDividerHeight(0);
        this.csG = new ImMessageCenterListAdapter(this.cxs.getPageContext().getPageActivity());
        this.csG.a(this);
        this.csF.setAdapter((ListAdapter) this.csG);
        this.csF.setOnItemClickListener(this.csO);
        this.csF.setOnItemLongClickListener(this.csP);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.csL == i) {
            return false;
        }
        this.csL = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cxs.getPageContext(), i);
        }
        if (this.csI != null) {
            this.csI.onChangeSkinType(i);
        }
        if (this.csG != null) {
            this.csG.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().x(this.csN);
        }
        if (this.cxq == null || this.cxq.FW() == null || this.cxq.FW().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.at.b(this.cxq.FW().view, t.d.frs_slidebar_message_text, 1);
        return true;
    }

    private void eE(boolean z) {
        if (z) {
            aiX();
        } else {
            aiY();
        }
    }

    private void aiX() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cxs.getResources().getString(t.j.maintab_imcenter_button_text), new u(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.cxs.getPageContext().getPageActivity(), this.csN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cxs.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dg(t.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void aiY() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.cxs.getResources().getString(t.j.maintab_imcenter_unlogin_button_text), new v(this));
        int dimensionPixelSize = this.cxs.getResources().getDimensionPixelSize(t.e.ds100);
        int dimensionPixelSize2 = this.cxs.getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = this.cxs.getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = this.cxs.getResources().getDimensionPixelSize(t.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.cxs.getPageContext().getPageActivity(), this.csN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(t.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.cxs.getResources().getDimensionPixelSize(t.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        o(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.csK = new m(this, imMessageCenterShowItemData);
        String string = this.cxs.getPageContext().getPageActivity().getString(t.j.delete_user_chat);
        this.csJ = new com.baidu.tbadk.core.dialog.c(this.cxs.getPageContext().getPageActivity());
        this.csJ.cd(t.j.operation);
        this.csJ.a(new String[]{string}, this.csK);
        this.csJ.d(this.cxs.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ce(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.csF.nj();
        }
        return true;
    }

    public void eu(boolean z) {
        if (z) {
            if (aiZ() && this.csI.getVisibility() != 0) {
                this.csI.setVisibility(0);
            }
        } else if (this.csI.getVisibility() != 8) {
            this.csI.setVisibility(8);
        }
    }

    public void o(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mNoDataView != null) {
            this.csN.removeView(this.mNoDataView);
        }
        eE(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean aiZ() {
        return this.csM;
    }

    public void ew(boolean z) {
        this.csM = z;
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
                if (this.csC != null) {
                    this.csC.insertOrUpdate(data, this.cbL);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.csC != null) {
                this.csC.remove(data, this.cbL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.csC != null) {
                this.csC.setData(data, this.cbL);
            }
        }
    }
}
