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
    private final CustomMessageListener aKr;
    private boolean aXd;
    private View azA;
    private final CustomMessageListener bRp;
    private com.baidu.tieba.im.chat.notify.a bRq;
    private ImMessageCenterModel chW;
    private ImMessageCenterShowItemData chY;
    private BdListView chZ;
    private ImMessageCenterListAdapter cia;
    private ShutDownValidateTipView cic;
    com.baidu.tbadk.core.dialog.c cie;
    private c.b cif;
    private int cig;
    private boolean cih;
    private RelativeLayout cii;
    private final AdapterView.OnItemClickListener cij;
    private final AdapterView.OnItemLongClickListener cik;
    private com.baidu.tbadk.mvc.f.a.b cmO;
    private final bd cmQ;
    private CustomMessageListener cmR;
    private com.baidu.tbadk.core.view.o mNoDataView;

    public k(bd bdVar) {
        super(bdVar);
        this.chW = null;
        this.chY = null;
        this.chZ = null;
        this.cia = null;
        this.cie = null;
        this.cih = true;
        this.aXd = false;
        this.aKr = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.cmR = new n(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.cij = new o(this);
        this.cik = new q(this);
        this.bRp = new r(this, 0);
        this.bRq = new s(this);
        this.cmQ = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void e(Bundle bundle) {
        super.e(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View pa() {
        this.cig = 3;
        this.azA = LayoutInflater.from(this.cmQ.getPageContext().getPageActivity()).inflate(t.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        R(this.azA);
        TiebaStatic.eventStat(this.cmQ.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        oQ();
        return this.azA;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View getView() {
        return this.azA;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void oQ() {
        this.chZ.ns();
        this.aXd = TbadkCoreApplication.isLogin();
        if (!this.aXd) {
            m(this.aXd, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void ahD() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void ahE() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void Fg() {
        super.Fg();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Ff() {
        if (this.cmO == null) {
            this.cmO = new com.baidu.tbadk.mvc.f.a.b();
            this.cmO.setTitle(this.cmH.getPageContext().getString(t.j.mention_chatme));
            this.cmO.eR(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.cmH.getActivity() != null) {
                aVar.view = this.cmH.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.ar.b(aVar.view, t.d.frs_slidebar_message_text, 1);
            }
            aVar.uF = 4;
            this.cmO.a(aVar);
            this.cmO.fQ("msg_tip_key");
        }
        return this.cmO;
    }

    private void registerListener() {
        this.cmQ.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.bRp);
        this.cmQ.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.bRp);
        this.cmQ.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.bRp);
        this.cmQ.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bRp);
        this.cmQ.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.bRp);
        this.cmQ.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bRp);
        this.cmQ.registerListener(this.aKr);
        this.cmQ.registerListener(this.cmR);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.cia != null && this.cia.getCount() == 0) {
            ej(true);
        }
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.aXd != isLogin) {
            this.aXd = isLogin;
            onUserChanged(this.aXd);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.cmQ.getPageContext());
        }
    }

    private void initData() {
        this.chW = new ImMessageCenterModel();
        ea(com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void R(View view) {
        this.cii = (RelativeLayout) view.findViewById(t.g.chat_list);
        this.cic = (ShutDownValidateTipView) view.findViewById(t.g.view_no_validate);
        this.cic.setVisibility(8);
        this.cic.setShutDownClickListener(new t(this));
        this.chZ = (BdListView) view.findViewById(t.g.chat_list_content);
        this.aTj = this.chZ;
        this.chZ.setDividerHeight(0);
        this.cia = new ImMessageCenterListAdapter(this.cmQ.getPageContext().getPageActivity());
        this.cia.a(this);
        this.chZ.setAdapter((ListAdapter) this.cia);
        this.chZ.setOnItemClickListener(this.cij);
        this.chZ.setOnItemLongClickListener(this.cik);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.cig == i) {
            return false;
        }
        this.cig = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cmQ.getPageContext(), i);
        }
        if (this.cic != null) {
            this.cic.onChangeSkinType(i);
        }
        if (this.cia != null) {
            this.cia.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().x(this.cii);
        }
        if (this.cmO == null || this.cmO.Fj() == null || this.cmO.Fj().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.ar.b(this.cmO.Fj().view, t.d.frs_slidebar_message_text, 1);
        return true;
    }

    private void ei(boolean z) {
        if (z) {
            afD();
        } else {
            afE();
        }
    }

    private void afD() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cmQ.getResources().getString(t.j.maintab_imcenter_button_text), new u(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.cmQ.getPageContext().getPageActivity(), this.cii, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.cmQ.getResources().getDimension(t.e.ds80)), NoDataViewFactory.d.dd(t.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void afE() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.cmQ.getResources().getString(t.j.maintab_imcenter_unlogin_button_text), new v(this));
        int dimensionPixelSize = this.cmQ.getResources().getDimensionPixelSize(t.e.ds100);
        int dimensionPixelSize2 = this.cmQ.getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = this.cmQ.getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = this.cmQ.getResources().getDimensionPixelSize(t.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.cmQ.getPageContext().getPageActivity(), this.cii, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.x(t.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.cmQ.getResources().getDimensionPixelSize(t.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        m(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cif = new m(this, imMessageCenterShowItemData);
        String string = this.cmQ.getPageContext().getPageActivity().getString(t.j.delete_user_chat);
        this.cie = new com.baidu.tbadk.core.dialog.c(this.cmQ.getPageContext().getPageActivity());
        this.cie.cb(t.j.operation);
        this.cie.a(new String[]{string}, this.cif);
        this.cie.d(this.cmQ.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bU(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.chZ.nr();
        }
        return true;
    }

    public void dY(boolean z) {
        if (z) {
            if (afF() && this.cic.getVisibility() != 0) {
                this.cic.setVisibility(0);
            }
        } else if (this.cic.getVisibility() != 8) {
            this.cic.setVisibility(8);
        }
    }

    public void m(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mNoDataView != null) {
            this.cii.removeView(this.mNoDataView);
        }
        ei(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean afF() {
        return this.cih;
    }

    public void ea(boolean z) {
        this.cih = z;
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
                if (this.chW != null) {
                    this.chW.insertOrUpdate(data, this.bRq);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.chW != null) {
                this.chW.remove(data, this.bRq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.chW != null) {
                this.chW.setData(data, this.bRq);
            }
        }
    }
}
