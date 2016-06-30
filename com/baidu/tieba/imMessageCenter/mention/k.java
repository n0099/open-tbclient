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
    private final CustomMessageListener aMV;
    private View axa;
    private RelativeLayout bzi;
    private final CustomMessageListener cHK;
    private com.baidu.tieba.im.chat.notify.a cHM;
    private ImMessageCenterModel cYQ;
    private ImMessageCenterShowItemData cYS;
    private BdListView cYT;
    private ImMessageCenterListAdapter cYU;
    private ShutDownValidateTipView cYW;
    com.baidu.tbadk.core.dialog.c cYX;
    private c.b cYY;
    private int cYZ;
    private boolean cZa;
    private final AdapterView.OnItemClickListener cZb;
    private final AdapterView.OnItemLongClickListener cZc;
    private com.baidu.tbadk.mvc.f.a.b ddK;
    private final bf ddM;
    private boolean ddN;
    private CustomMessageListener ddO;
    private com.baidu.tbadk.core.view.q mNoDataView;

    public k(bf bfVar) {
        super(bfVar);
        this.cYQ = null;
        this.cYS = null;
        this.cYT = null;
        this.cYU = null;
        this.cYX = null;
        this.cZa = true;
        this.ddN = false;
        this.aMV = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.ddO = new n(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.cZb = new o(this);
        this.cZc = new q(this);
        this.cHK = new r(this, 0);
        this.cHM = new s(this);
        this.ddM = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void i(Bundle bundle) {
        super.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View lk() {
        this.cYZ = 3;
        this.axa = LayoutInflater.from(this.ddM.getPageContext().getPageActivity()).inflate(u.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        Z(this.axa);
        TiebaStatic.eventStat(this.ddM.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        kZ();
        return this.axa;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View getView() {
        return this.axa;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void kZ() {
        atu();
        this.cYT.jB();
        this.ddN = TbadkCoreApplication.isLogin();
        if (!this.ddN) {
            o(this.ddN, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void ats() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void att() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void DV() {
        super.DV();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DU() {
        if (this.ddK == null) {
            this.ddK = new com.baidu.tbadk.mvc.f.a.b();
            this.ddK.setTitle(this.ddD.getPageContext().getString(u.j.mention_chatme));
            this.ddK.eH(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.ddD.getActivity() != null) {
                aVar.view = this.ddD.getActivity().getLayoutInflater().inflate(u.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, u.d.common_color_10225, 1);
            }
            aVar.kD = 4;
            this.ddK.a(aVar);
            this.ddK.gb("msg_tip_key");
        }
        return this.ddK;
    }

    private void registerListener() {
        this.ddM.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cHK);
        this.ddM.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cHK);
        this.ddM.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cHK);
        this.ddM.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cHK);
        this.ddM.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cHK);
        this.ddM.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cHK);
        this.ddM.registerListener(this.aMV);
        this.ddM.registerListener(this.ddO);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cYU != null && this.cYU.getCount() == 0) {
            fV(true);
        }
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.ddN != isLogin) {
            this.ddN = isLogin;
            onUserChanged(this.ddN);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.ddM.getPageContext());
        }
    }

    private void initData() {
        this.cYQ = new ImMessageCenterModel();
        fM(com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void Z(View view) {
        this.bzi = (RelativeLayout) view.findViewById(u.g.chat_list);
        this.cYW = (ShutDownValidateTipView) view.findViewById(u.g.view_no_validate);
        this.cYW.setVisibility(8);
        this.cYW.setShutDownClickListener(new t(this));
        this.cYT = (BdListView) view.findViewById(u.g.chat_list_content);
        this.aWk = this.cYT;
        this.cYT.setDividerHeight(0);
        this.cYU = new ImMessageCenterListAdapter(this.ddM.getPageContext().getPageActivity());
        this.cYU.a(this);
        this.cYT.setAdapter((ListAdapter) this.cYU);
        this.cYT.setOnItemClickListener(this.cZb);
        this.cYT.setOnItemLongClickListener(this.cZc);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cYZ == i) {
            return false;
        }
        this.cYZ = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ddM.getPageContext(), i);
        }
        if (this.cYW != null) {
            this.cYW.onChangeSkinType(i);
        }
        if (this.cYU != null) {
            this.cYU.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().w(this.bzi);
        }
        if (this.ddK == null || this.ddK.DY() == null || this.ddK.DY().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.av.c(this.ddK.DY().view, u.d.common_color_10225, 1);
        return true;
    }

    private void fU(boolean z) {
        if (z) {
            aru();
        } else {
            arv();
        }
    }

    private void aru() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ddM.getResources().getString(u.j.maintab_imcenter_button_text), new u(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.ddM.getPageContext().getPageActivity(), this.bzi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.ddM.getResources().getDimension(u.e.ds320)), NoDataViewFactory.d.cQ(u.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void arv() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.ddM.getResources().getString(u.j.maintab_imcenter_unlogin_button_text), new v(this));
        int dimensionPixelSize = this.ddM.getResources().getDimensionPixelSize(u.e.ds320);
        int dimensionPixelSize2 = this.ddM.getResources().getDimensionPixelSize(u.e.ds480);
        int dimensionPixelSize3 = this.ddM.getResources().getDimensionPixelSize(u.e.ds360);
        int dimensionPixelSize4 = this.ddM.getResources().getDimensionPixelSize(u.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.ddM.getPageContext().getPageActivity(), this.bzi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, u.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(u.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.ddM.getResources().getDimensionPixelSize(u.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        o(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cYY = new m(this, imMessageCenterShowItemData);
        String string = this.ddM.getPageContext().getPageActivity().getString(u.j.delete_user_chat);
        this.cYX = new com.baidu.tbadk.core.dialog.c(this.ddM.getPageContext().getPageActivity());
        this.cYX.bP(u.j.operation);
        this.cYX.a(new String[]{string}, this.cYY);
        this.cYX.d(this.ddM.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cl(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.cYT.k(2000L);
        }
        return true;
    }

    public void fK(boolean z) {
        if (z) {
            if (arw() && this.cYW.getVisibility() != 0) {
                this.cYW.setVisibility(0);
            }
        } else if (this.cYW.getVisibility() != 8) {
            this.cYW.setVisibility(8);
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
            this.bzi.removeView(this.mNoDataView);
        }
        fU(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean arw() {
        return this.cZa;
    }

    public void fM(boolean z) {
        this.cZa = z;
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
                if (this.cYQ != null) {
                    this.cYQ.insertOrUpdate(data, this.cHM);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.cYQ != null) {
                this.cYQ.remove(data, this.cHM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.cYQ != null) {
                this.cYQ.setData(data, this.cHM);
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bK(boolean z) {
        super.bK(z);
    }
}
