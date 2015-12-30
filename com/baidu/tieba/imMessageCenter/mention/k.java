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
public class k extends w {
    private final CustomMessageListener aJm;
    private boolean aUR;
    private final CustomMessageListener bNr;
    private com.baidu.tieba.im.chat.notify.a bNs;
    private ImMessageCenterShowItemData cdA;
    private BdListView cdB;
    private ImMessageCenterListAdapter cdC;
    private ShutDownValidateTipView cdE;
    com.baidu.tbadk.core.dialog.c cdF;
    private c.b cdG;
    private int cdH;
    private boolean cdI;
    private RelativeLayout cdJ;
    private final AdapterView.OnItemLongClickListener cdK;
    private ImMessageCenterModel cdy;
    private com.baidu.tbadk.mvc.f.a.b cio;
    private final bd ciq;
    private CustomMessageListener cir;
    private final AdapterView.OnItemClickListener mItemClickListener;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private View rootView;

    public k(bd bdVar) {
        super(bdVar);
        this.cdy = null;
        this.cdA = null;
        this.cdB = null;
        this.cdC = null;
        this.cdF = null;
        this.cdI = true;
        this.aUR = false;
        this.aJm = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.cir = new n(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.mItemClickListener = new o(this);
        this.cdK = new q(this);
        this.bNr = new r(this, 0);
        this.bNs = new s(this);
        this.ciq = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View oE() {
        this.cdH = 3;
        this.rootView = LayoutInflater.from(this.ciq.getPageContext().getPageActivity()).inflate(n.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        B(this.rootView);
        TiebaStatic.eventStat(this.ciq.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        ov();
        return this.rootView;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View getView() {
        return this.rootView;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void ov() {
        this.cdB.nb();
        this.aUR = TbadkCoreApplication.isLogin();
        if (!this.aUR) {
            k(this.aUR, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void aet() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void aeu() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void DM() {
        super.DM();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b DL() {
        if (this.cio == null) {
            this.cio = new com.baidu.tbadk.mvc.f.a.b();
            this.cio.setTitle(this.cih.getPageContext().getString(n.j.mention_chatme));
            this.cio.ex(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cih.getActivity() != null) {
                aVar.view = this.cih.getActivity().getLayoutInflater().inflate(n.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.as.b(aVar.view, n.d.frs_slidebar_message_text, 1);
            }
            aVar.uw = 4;
            this.cio.a(aVar);
            this.cio.fS("msg_tip_key");
        }
        return this.cio;
    }

    private void registerListener() {
        this.ciq.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bNr);
        this.ciq.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bNr);
        this.ciq.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bNr);
        this.ciq.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bNr);
        this.ciq.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bNr);
        this.ciq.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bNr);
        this.ciq.registerListener(this.aJm);
        this.ciq.registerListener(this.cir);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.aUR != isLogin) {
            this.aUR = isLogin;
            onUserChanged(this.aUR);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.ciq.getPageContext());
        }
    }

    private void initData() {
        this.cdy = new ImMessageCenterModel();
        dT(com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void B(View view) {
        this.cdJ = (RelativeLayout) view.findViewById(n.g.chat_list);
        this.cdE = (ShutDownValidateTipView) view.findViewById(n.g.view_no_validate);
        this.cdE.setVisibility(8);
        this.cdE.setShutDownClickListener(new t(this));
        this.cdB = (BdListView) view.findViewById(n.g.chat_list_content);
        this.aRc = this.cdB;
        this.cdB.setDividerHeight(0);
        this.cdC = new ImMessageCenterListAdapter(this.ciq.getPageContext().getPageActivity());
        this.cdC.a(this);
        this.cdB.setAdapter((ListAdapter) this.cdC);
        this.cdB.setOnItemClickListener(this.mItemClickListener);
        this.cdB.setOnItemLongClickListener(this.cdK);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cdH == i) {
            return false;
        }
        this.cdH = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ciq.getPageContext(), i);
        }
        if (this.cdE != null) {
            this.cdE.onChangeSkinType(i);
        }
        if (this.cdC != null) {
            this.cdC.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().k(this.cdJ);
        }
        if (this.cio == null || this.cio.DP() == null || this.cio.DP().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.as.b(this.cio.DP().view, n.d.frs_slidebar_message_text, 1);
        return true;
    }

    private void eb(boolean z) {
        if (z) {
            acv();
        } else {
            acw();
        }
    }

    private void acv() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ciq.getResources().getString(n.j.maintab_imcenter_button_text), new u(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.ciq.getPageContext().getPageActivity(), this.cdJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.ciq.getResources().getDimension(n.e.ds80)), NoDataViewFactory.d.cM(n.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void acw() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.ciq.getResources().getString(n.j.maintab_imcenter_unlogin_button_text), new v(this));
        int dimensionPixelSize = this.ciq.getResources().getDimensionPixelSize(n.e.ds100);
        int dimensionPixelSize2 = this.ciq.getResources().getDimensionPixelSize(n.e.ds480);
        int dimensionPixelSize3 = this.ciq.getResources().getDimensionPixelSize(n.e.ds360);
        int dimensionPixelSize4 = this.ciq.getResources().getDimensionPixelSize(n.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.ciq.getPageContext().getPageActivity(), this.cdJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, n.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.B(n.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.ciq.getResources().getDimensionPixelSize(n.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        k(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cdG = new m(this, imMessageCenterShowItemData);
        String string = this.ciq.getPageContext().getPageActivity().getString(n.j.delete_user_chat);
        this.cdF = new com.baidu.tbadk.core.dialog.c(this.ciq.getPageContext().getPageActivity());
        this.cdF.bJ(n.j.operation);
        this.cdF.a(new String[]{string}, this.cdG);
        this.cdF.d(this.ciq.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bP(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.cdB.completePullRefresh();
        }
        return true;
    }

    public void dR(boolean z) {
        if (z) {
            if (acx() && this.cdE.getVisibility() != 0) {
                this.cdE.setVisibility(0);
            }
        } else if (this.cdE.getVisibility() != 8) {
            this.cdE.setVisibility(8);
        }
    }

    public void k(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mNoDataView != null) {
            this.cdJ.removeView(this.mNoDataView);
        }
        eb(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean acx() {
        return this.cdI;
    }

    public void dT(boolean z) {
        this.cdI = z;
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
                if (this.cdy != null) {
                    this.cdy.insertOrUpdate(data, this.bNs);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.cdy != null) {
                this.cdy.remove(data, this.bNs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.cdy != null) {
                this.cdy.setData(data, this.bNs);
            }
        }
    }
}
