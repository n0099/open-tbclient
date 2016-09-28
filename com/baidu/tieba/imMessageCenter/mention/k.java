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
    private View aAy;
    private final CustomMessageListener aTT;
    private RelativeLayout bMV;
    private final CustomMessageListener cXB;
    private com.baidu.tieba.im.chat.notify.a cXD;
    private ImMessageCenterModel doT;
    private ImMessageCenterShowItemData doV;
    private BdListView doW;
    private ImMessageCenterListAdapter doX;
    private ShutDownValidateTipView doZ;
    com.baidu.tbadk.core.dialog.c dpa;
    private c.b dpb;
    private int dpc;
    private boolean dpd;
    private final AdapterView.OnItemClickListener dpe;
    private final AdapterView.OnItemLongClickListener dpf;
    private com.baidu.tbadk.mvc.f.a.b dtJ;
    private final bf dtL;
    private boolean dtM;
    private CustomMessageListener dtN;
    private com.baidu.tbadk.core.view.v mNoDataView;

    public k(bf bfVar) {
        super(bfVar);
        this.doT = null;
        this.doV = null;
        this.doW = null;
        this.doX = null;
        this.dpa = null;
        this.dpd = true;
        this.dtM = false;
        this.aTT = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dtN = new n(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.dpe = new o(this);
        this.dpf = new q(this);
        this.cXB = new r(this, 0);
        this.cXD = new s(this);
        this.dtL = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void f(Bundle bundle) {
        super.f(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View mb() {
        this.dpc = 3;
        this.aAy = LayoutInflater.from(this.dtL.getPageContext().getPageActivity()).inflate(r.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        Z(this.aAy);
        TiebaStatic.eventStat(this.dtL.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        lQ();
        return this.aAy;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View getView() {
        return this.aAy;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void lQ() {
        azs();
        this.doW.kv();
        this.dtM = TbadkCoreApplication.isLogin();
        if (!this.dtM) {
            t(this.dtM, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void azq() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void azr() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void Fn() {
        super.Fn();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Fm() {
        if (this.dtJ == null) {
            this.dtJ = new com.baidu.tbadk.mvc.f.a.b();
            this.dtJ.setTitle(this.dtC.getPageContext().getString(r.j.mention_chatme));
            this.dtJ.eU(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dtC.getActivity() != null) {
                aVar.view = this.dtC.getActivity().getLayoutInflater().inflate(r.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, r.d.common_color_10225, 1);
            }
            aVar.nB = 4;
            this.dtJ.a(aVar);
            this.dtJ.gg("msg_tip_key");
        }
        return this.dtJ;
    }

    private void registerListener() {
        this.dtL.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cXB);
        this.dtL.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cXB);
        this.dtL.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cXB);
        this.dtL.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cXB);
        this.dtL.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cXB);
        this.dtL.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cXB);
        this.dtL.registerListener(this.aTT);
        this.dtL.registerListener(this.dtN);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.doX != null && this.doX.getCount() == 0) {
            gx(true);
        }
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.dtM != isLogin) {
            this.dtM = isLogin;
            onUserChanged(this.dtM);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dtL.getPageContext());
        }
    }

    private void initData() {
        this.doT = new ImMessageCenterModel();
        go(com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void Z(View view) {
        this.bMV = (RelativeLayout) view.findViewById(r.g.chat_list);
        this.doZ = (ShutDownValidateTipView) view.findViewById(r.g.view_no_validate);
        this.doZ.setVisibility(8);
        this.doZ.setShutDownClickListener(new t(this));
        this.doW = (BdListView) view.findViewById(r.g.chat_list_content);
        this.bdv = this.doW;
        this.doW.setDividerHeight(0);
        this.doX = new ImMessageCenterListAdapter(this.dtL.getPageContext().getPageActivity());
        this.doX.a(this);
        this.doW.setAdapter((ListAdapter) this.doX);
        this.doW.setOnItemClickListener(this.dpe);
        this.doW.setOnItemLongClickListener(this.dpf);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.dpc == i) {
            return false;
        }
        this.dpc = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dtL.getPageContext(), i);
        }
        if (this.doZ != null) {
            this.doZ.onChangeSkinType(i);
        }
        if (this.doX != null) {
            this.doX.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().x(this.bMV);
        }
        if (this.dtJ == null || this.dtJ.Fq() == null || this.dtJ.Fq().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.av.c(this.dtJ.Fq().view, r.d.common_color_10225, 1);
        return true;
    }

    private void gw(boolean z) {
        if (z) {
            axt();
        } else {
            axu();
        }
    }

    private void axt() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dtL.getResources().getString(r.j.maintab_imcenter_button_text), new u(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dtL.getPageContext().getPageActivity(), this.bMV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dtL.getResources().getDimension(r.e.ds320)), NoDataViewFactory.d.de(r.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void axu() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dtL.getResources().getString(r.j.maintab_imcenter_unlogin_button_text), new v(this));
        int dimensionPixelSize = this.dtL.getResources().getDimensionPixelSize(r.e.ds320);
        int dimensionPixelSize2 = this.dtL.getResources().getDimensionPixelSize(r.e.ds480);
        int dimensionPixelSize3 = this.dtL.getResources().getDimensionPixelSize(r.e.ds360);
        int dimensionPixelSize4 = this.dtL.getResources().getDimensionPixelSize(r.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dtL.getPageContext().getPageActivity(), this.bMV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(r.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dtL.getResources().getDimensionPixelSize(r.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        t(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dpb = new m(this, imMessageCenterShowItemData);
        String string = this.dtL.getPageContext().getPageActivity().getString(r.j.delete_user_chat);
        this.dpa = new com.baidu.tbadk.core.dialog.c(this.dtL.getPageContext().getPageActivity());
        this.dpa.cc(r.j.operation);
        this.dpa.a(new String[]{string}, this.dpb);
        this.dpa.d(this.dtL.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cv(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.doW.l(2000L);
        }
        return true;
    }

    public void gm(boolean z) {
        if (z) {
            if (axv() && this.doZ.getVisibility() != 0) {
                this.doZ.setVisibility(0);
            }
        } else if (this.doZ.getVisibility() != 8) {
            this.doZ.setVisibility(8);
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
            this.bMV.removeView(this.mNoDataView);
        }
        gw(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean axv() {
        return this.dpd;
    }

    public void go(boolean z) {
        this.dpd = z;
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
                if (this.doT != null) {
                    this.doT.insertOrUpdate(data, this.cXD);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.doT != null) {
                this.doT.remove(data, this.cXD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.doT != null) {
                this.doT.setData(data, this.cXD);
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bO(boolean z) {
        super.bO(z);
    }
}
