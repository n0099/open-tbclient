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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class k extends w {
    private final CustomMessageListener aNP;
    private View axO;
    private RelativeLayout bBw;
    private com.baidu.tieba.im.chat.notify.a cKB;
    private final CustomMessageListener cKz;
    private ImMessageCenterModel dbN;
    private ImMessageCenterShowItemData dbP;
    private BdListView dbQ;
    private ImMessageCenterListAdapter dbR;
    private ShutDownValidateTipView dbT;
    com.baidu.tbadk.core.dialog.c dbU;
    private c.b dbV;
    private int dbW;
    private boolean dbX;
    private final AdapterView.OnItemClickListener dbY;
    private final AdapterView.OnItemLongClickListener dbZ;
    private com.baidu.tbadk.mvc.f.a.b dgG;
    private final bf dgI;
    private boolean dgJ;
    private CustomMessageListener dgK;
    private com.baidu.tbadk.core.view.q mNoDataView;

    public k(bf bfVar) {
        super(bfVar);
        this.dbN = null;
        this.dbP = null;
        this.dbQ = null;
        this.dbR = null;
        this.dbU = null;
        this.dbX = true;
        this.dgJ = false;
        this.aNP = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dgK = new n(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.dbY = new o(this);
        this.dbZ = new q(this);
        this.cKz = new r(this, 0);
        this.cKB = new s(this);
        this.dgI = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void f(Bundle bundle) {
        super.f(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View lg() {
        this.dbW = 3;
        this.axO = LayoutInflater.from(this.dgI.getPageContext().getPageActivity()).inflate(u.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        Z(this.axO);
        TiebaStatic.eventStat(this.dgI.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        kV();
        return this.axO;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View getView() {
        return this.axO;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void kV() {
        aug();
        this.dbQ.jA();
        this.dgJ = TbadkCoreApplication.isLogin();
        if (!this.dgJ) {
            o(this.dgJ, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void aue() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void auf() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void DU() {
        super.DU();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DT() {
        if (this.dgG == null) {
            this.dgG = new com.baidu.tbadk.mvc.f.a.b();
            this.dgG.setTitle(this.dgz.getPageContext().getString(u.j.mention_chatme));
            this.dgG.eH(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dgz.getActivity() != null) {
                aVar.view = this.dgz.getActivity().getLayoutInflater().inflate(u.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, u.d.common_color_10225, 1);
            }
            aVar.lg = 4;
            this.dgG.a(aVar);
            this.dgG.fZ("msg_tip_key");
        }
        return this.dgG;
    }

    private void registerListener() {
        this.dgI.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cKz);
        this.dgI.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cKz);
        this.dgI.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cKz);
        this.dgI.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cKz);
        this.dgI.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cKz);
        this.dgI.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cKz);
        this.dgI.registerListener(this.aNP);
        this.dgI.registerListener(this.dgK);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.dbR != null && this.dbR.getCount() == 0) {
            fY(true);
        }
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.dgJ != isLogin) {
            this.dgJ = isLogin;
            onUserChanged(this.dgJ);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dgI.getPageContext());
        }
    }

    private void initData() {
        this.dbN = new ImMessageCenterModel();
        fP(com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void Z(View view) {
        this.bBw = (RelativeLayout) view.findViewById(u.g.chat_list);
        this.dbT = (ShutDownValidateTipView) view.findViewById(u.g.view_no_validate);
        this.dbT.setVisibility(8);
        this.dbT.setShutDownClickListener(new t(this));
        this.dbQ = (BdListView) view.findViewById(u.g.chat_list_content);
        this.aXi = this.dbQ;
        this.dbQ.setDividerHeight(0);
        this.dbR = new ImMessageCenterListAdapter(this.dgI.getPageContext().getPageActivity());
        this.dbR.a(this);
        this.dbQ.setAdapter((ListAdapter) this.dbR);
        this.dbQ.setOnItemClickListener(this.dbY);
        this.dbQ.setOnItemLongClickListener(this.dbZ);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.dbW == i) {
            return false;
        }
        this.dbW = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dgI.getPageContext(), i);
        }
        if (this.dbT != null) {
            this.dbT.onChangeSkinType(i);
        }
        if (this.dbR != null) {
            this.dbR.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().w(this.bBw);
        }
        if (this.dgG == null || this.dgG.DX() == null || this.dgG.DX().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.av.c(this.dgG.DX().view, u.d.common_color_10225, 1);
        return true;
    }

    private void fX(boolean z) {
        if (z) {
            asg();
        } else {
            ash();
        }
    }

    private void asg() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dgI.getResources().getString(u.j.maintab_imcenter_button_text), new u(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dgI.getPageContext().getPageActivity(), this.bBw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dgI.getResources().getDimension(u.e.ds320)), NoDataViewFactory.d.cQ(u.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
    }

    private void ash() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dgI.getResources().getString(u.j.maintab_imcenter_unlogin_button_text), new v(this));
        int dimensionPixelSize = this.dgI.getResources().getDimensionPixelSize(u.e.ds320);
        int dimensionPixelSize2 = this.dgI.getResources().getDimensionPixelSize(u.e.ds480);
        int dimensionPixelSize3 = this.dgI.getResources().getDimensionPixelSize(u.e.ds360);
        int dimensionPixelSize4 = this.dgI.getResources().getDimensionPixelSize(u.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dgI.getPageContext().getPageActivity(), this.bBw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, u.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(u.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dgI.getResources().getDimensionPixelSize(u.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        o(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dbV = new m(this, imMessageCenterShowItemData);
        String string = this.dgI.getPageContext().getPageActivity().getString(u.j.delete_user_chat);
        this.dbU = new com.baidu.tbadk.core.dialog.c(this.dgI.getPageContext().getPageActivity());
        this.dbU.bP(u.j.operation);
        this.dbU.a(new String[]{string}, this.dbV);
        this.dbU.d(this.dgI.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean co(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dbQ.l(2000L);
        }
        return true;
    }

    public void fN(boolean z) {
        if (z) {
            if (asi() && this.dbT.getVisibility() != 0) {
                this.dbT.setVisibility(0);
            }
        } else if (this.dbT.getVisibility() != 8) {
            this.dbT.setVisibility(8);
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
            this.bBw.removeView(this.mNoDataView);
        }
        fX(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean asi() {
        return this.dbX;
    }

    public void fP(boolean z) {
        this.dbX = z;
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
                if (this.dbN != null) {
                    this.dbN.insertOrUpdate(data, this.cKB);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dbN != null) {
                this.dbN.remove(data, this.cKB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dbN != null) {
                this.dbN.setData(data, this.cKB);
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bN(boolean z) {
        super.bN(z);
    }
}
