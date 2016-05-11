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
    private final CustomMessageListener aJx;
    private boolean aXV;
    private View awk;
    private final CustomMessageListener cco;
    private com.baidu.tieba.im.chat.notify.a ccq;
    private ImMessageCenterModel ctA;
    private ImMessageCenterShowItemData ctC;
    private BdListView ctD;
    private ImMessageCenterListAdapter ctE;
    private ShutDownValidateTipView ctG;
    com.baidu.tbadk.core.dialog.c ctH;
    private c.b ctI;
    private int ctJ;
    private boolean ctK;
    private RelativeLayout ctL;
    private final AdapterView.OnItemClickListener ctM;
    private final AdapterView.OnItemLongClickListener ctN;
    private com.baidu.tbadk.mvc.f.a.b cyo;
    private final bf cyq;
    private CustomMessageListener cyr;
    private com.baidu.tbadk.core.view.q mNoDataView;

    public k(bf bfVar) {
        super(bfVar);
        this.ctA = null;
        this.ctC = null;
        this.ctD = null;
        this.ctE = null;
        this.ctH = null;
        this.ctK = true;
        this.aXV = false;
        this.aJx = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.cyr = new n(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.ctM = new o(this);
        this.ctN = new q(this);
        this.cco = new r(this, 0);
        this.ccq = new s(this);
        this.cyq = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void h(Bundle bundle) {
        super.h(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View lg() {
        this.ctJ = 3;
        this.awk = LayoutInflater.from(this.cyq.getPageContext().getPageActivity()).inflate(t.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        X(this.awk);
        TiebaStatic.eventStat(this.cyq.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        kW();
        return this.awk;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View getView() {
        return this.awk;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void kW() {
        alf();
        this.ctD.jy();
        this.aXV = TbadkCoreApplication.isLogin();
        if (!this.aXV) {
            n(this.aXV, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void ald() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void ale() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void DL() {
        super.DL();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DK() {
        if (this.cyo == null) {
            this.cyo = new com.baidu.tbadk.mvc.f.a.b();
            this.cyo.setTitle(this.cyh.getPageContext().getString(t.j.mention_chatme));
            this.cyo.eD(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cyh.getActivity() != null) {
                aVar.view = this.cyh.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.at.c(aVar.view, t.d.frs_slidebar_message_text, 1);
            }
            aVar.kF = 4;
            this.cyo.a(aVar);
            this.cyo.fV("msg_tip_key");
        }
        return this.cyo;
    }

    private void registerListener() {
        this.cyq.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cco);
        this.cyq.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cco);
        this.cyq.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cco);
        this.cyq.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cco);
        this.cyq.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cco);
        this.cyq.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cco);
        this.cyq.registerListener(this.aJx);
        this.cyq.registerListener(this.cyr);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.ctE != null && this.ctE.getCount() == 0) {
            fh(true);
        }
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.aXV != isLogin) {
            this.aXV = isLogin;
            onUserChanged(this.aXV);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.cyq.getPageContext());
        }
    }

    private void initData() {
        this.ctA = new ImMessageCenterModel();
        eY(com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void X(View view) {
        this.ctL = (RelativeLayout) view.findViewById(t.g.chat_list);
        this.ctG = (ShutDownValidateTipView) view.findViewById(t.g.view_no_validate);
        this.ctG.setVisibility(8);
        this.ctG.setShutDownClickListener(new t(this));
        this.ctD = (BdListView) view.findViewById(t.g.chat_list_content);
        this.aSP = this.ctD;
        this.ctD.setDividerHeight(0);
        this.ctE = new ImMessageCenterListAdapter(this.cyq.getPageContext().getPageActivity());
        this.ctE.a(this);
        this.ctD.setAdapter((ListAdapter) this.ctE);
        this.ctD.setOnItemClickListener(this.ctM);
        this.ctD.setOnItemLongClickListener(this.ctN);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.ctJ == i) {
            return false;
        }
        this.ctJ = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cyq.getPageContext(), i);
        }
        if (this.ctG != null) {
            this.ctG.onChangeSkinType(i);
        }
        if (this.ctE != null) {
            this.ctE.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().x(this.ctL);
        }
        if (this.cyo == null || this.cyo.DO() == null || this.cyo.DO().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.at.c(this.cyo.DO().view, t.d.frs_slidebar_message_text, 1);
        return true;
    }

    private void fg(boolean z) {
        if (z) {
            aje();
        } else {
            ajf();
        }
    }

    private void aje() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cyq.getResources().getString(t.j.maintab_imcenter_button_text), new u(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.cyq.getPageContext().getPageActivity(), this.ctL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cyq.getResources().getDimension(t.e.ds320)), NoDataViewFactory.d.cP(t.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
    }

    private void ajf() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.cyq.getResources().getString(t.j.maintab_imcenter_unlogin_button_text), new v(this));
        int dimensionPixelSize = this.cyq.getResources().getDimensionPixelSize(t.e.ds320);
        int dimensionPixelSize2 = this.cyq.getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = this.cyq.getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = this.cyq.getResources().getDimensionPixelSize(t.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.cyq.getPageContext().getPageActivity(), this.ctL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.u(t.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.cyq.getResources().getDimensionPixelSize(t.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        n(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ctI = new m(this, imMessageCenterShowItemData);
        String string = this.cyq.getPageContext().getPageActivity().getString(t.j.delete_user_chat);
        this.ctH = new com.baidu.tbadk.core.dialog.c(this.cyq.getPageContext().getPageActivity());
        this.ctH.bP(t.j.operation);
        this.ctH.a(new String[]{string}, this.ctI);
        this.ctH.d(this.cyq.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ck(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.ctD.k(2000L);
        }
        return true;
    }

    public void eW(boolean z) {
        if (z) {
            if (ajg() && this.ctG.getVisibility() != 0) {
                this.ctG.setVisibility(0);
            }
        } else if (this.ctG.getVisibility() != 8) {
            this.ctG.setVisibility(8);
        }
    }

    public void n(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mNoDataView != null) {
            this.ctL.removeView(this.mNoDataView);
        }
        fg(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean ajg() {
        return this.ctK;
    }

    public void eY(boolean z) {
        this.ctK = z;
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
                if (this.ctA != null) {
                    this.ctA.insertOrUpdate(data, this.ccq);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.ctA != null) {
                this.ctA.remove(data, this.ccq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.ctA != null) {
                this.ctA.setData(data, this.ccq);
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bL(boolean z) {
        super.bL(z);
    }
}
