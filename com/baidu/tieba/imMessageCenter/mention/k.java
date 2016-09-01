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
    private View aAV;
    private final CustomMessageListener aTj;
    private RelativeLayout bMY;
    private final CustomMessageListener cWe;
    private com.baidu.tieba.im.chat.notify.a cWg;
    private ShutDownValidateTipView dnB;
    com.baidu.tbadk.core.dialog.c dnC;
    private c.b dnD;
    private int dnE;
    private boolean dnF;
    private final AdapterView.OnItemClickListener dnG;
    private final AdapterView.OnItemLongClickListener dnH;
    private ImMessageCenterModel dnv;
    private ImMessageCenterShowItemData dnx;
    private BdListView dny;
    private ImMessageCenterListAdapter dnz;
    private com.baidu.tbadk.mvc.f.a.b dsm;
    private final bf dso;
    private boolean dsp;
    private CustomMessageListener dsq;
    private com.baidu.tbadk.core.view.q mNoDataView;

    public k(bf bfVar) {
        super(bfVar);
        this.dnv = null;
        this.dnx = null;
        this.dny = null;
        this.dnz = null;
        this.dnC = null;
        this.dnF = true;
        this.dsp = false;
        this.aTj = new l(this, CmdConfigCustom.CMD_RE_LOGIN_FROM_KUANG);
        this.dsq = new n(this, CmdConfigCustom.CMD_ADDRESSLIST_PLUGIN_INSTALL_SUCCESS);
        this.dnG = new o(this);
        this.dnH = new q(this);
        this.cWe = new r(this, 0);
        this.cWg = new s(this);
        this.dso = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void f(Bundle bundle) {
        super.f(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View mb() {
        this.dnE = 3;
        this.aAV = LayoutInflater.from(this.dso.getPageContext().getPageActivity()).inflate(t.h.chat_list_activity, (ViewGroup) null, false);
        initData();
        Z(this.aAV);
        TiebaStatic.eventStat(this.dso.getPageContext().getPageActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        registerListener();
        lQ();
        return this.aAV;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public View getView() {
        return this.aAV;
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void lQ() {
        ayU();
        this.dny.kv();
        this.dsp = TbadkCoreApplication.isLogin();
        if (!this.dsp) {
            r(this.dsp, true);
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void ayS() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public void ayT() {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    protected void a(ErrorData errorData) {
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void Fo() {
        super.Fo();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public com.baidu.tbadk.mvc.f.a.b Fn() {
        if (this.dsm == null) {
            this.dsm = new com.baidu.tbadk.mvc.f.a.b();
            this.dsm.setTitle(this.dsf.getPageContext().getString(t.j.mention_chatme));
            this.dsm.eV(0);
            FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
            if (this.dsf.getActivity() != null) {
                aVar.view = this.dsf.getActivity().getLayoutInflater().inflate(t.h.message_tip_item, (ViewGroup) null);
                com.baidu.tbadk.core.util.av.c(aVar.view, t.d.common_color_10225, 1);
            }
            aVar.nB = 4;
            this.dsm.a(aVar);
            this.dsm.gc("msg_tip_key");
        }
        return this.dsm;
    }

    private void registerListener() {
        this.dso.registerListener(CmdConfigCustom.MEMORY_CHANGED, this.cWe);
        this.dso.registerListener(CmdConfigCustom.MEMORY_CLEAR, this.cWe);
        this.dso.registerListener(CmdConfigCustom.MEMORY_SWITCH_CHANGE, this.cWe);
        this.dso.registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cWe);
        this.dso.registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.cWe);
        this.dso.registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cWe);
        this.dso.registerListener(this.aTj);
        this.dso.registerListener(this.dsq);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void onPrimary() {
        if (this.dnz != null && this.dnz.getCount() == 0) {
            gu(true);
        }
        super.onPrimary();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.dsp != isLogin) {
            this.dsp = isLogin;
            onUserChanged(this.dsp);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dso.getPageContext());
        }
    }

    private void initData() {
        this.dnv = new ImMessageCenterModel();
        gl(com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("is_shut_down_validate", false) ? false : true);
    }

    private void Z(View view) {
        this.bMY = (RelativeLayout) view.findViewById(t.g.chat_list);
        this.dnB = (ShutDownValidateTipView) view.findViewById(t.g.view_no_validate);
        this.dnB.setVisibility(8);
        this.dnB.setShutDownClickListener(new t(this));
        this.dny = (BdListView) view.findViewById(t.g.chat_list_content);
        this.bdb = this.dny;
        this.dny.setDividerHeight(0);
        this.dnz = new ImMessageCenterListAdapter(this.dso.getPageContext().getPageActivity());
        this.dnz.a(this);
        this.dny.setAdapter((ListAdapter) this.dnz);
        this.dny.setOnItemClickListener(this.dnG);
        this.dny.setOnItemLongClickListener(this.dnH);
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.dnE == i) {
            return false;
        }
        this.dnE = i;
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dso.getPageContext(), i);
        }
        if (this.dnB != null) {
            this.dnB.onChangeSkinType(i);
        }
        if (this.dnz != null) {
            this.dnz.notifyDataSetChanged();
        }
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().x(this.bMY);
        }
        if (this.dsm == null || this.dsm.Fr() == null || this.dsm.Fr().view == null) {
            return true;
        }
        com.baidu.tbadk.core.util.av.c(this.dsm.Fr().view, t.d.common_color_10225, 1);
        return true;
    }

    private void gt(boolean z) {
        if (z) {
            awU();
        } else {
            awV();
        }
    }

    private void awU() {
        NoDataViewFactory.b bVar = null;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            bVar = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dso.getResources().getString(t.j.maintab_imcenter_button_text), new u(this)));
        }
        this.mNoDataView = NoDataViewFactory.a(this.dso.getPageContext().getPageActivity(), this.bMY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dso.getResources().getDimension(t.e.ds320)), NoDataViewFactory.d.de(t.j.no_recent_chat), bVar);
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    private void awV() {
        NoDataViewFactory.a aVar = new NoDataViewFactory.a(this.dso.getResources().getString(t.j.maintab_imcenter_unlogin_button_text), new v(this));
        int dimensionPixelSize = this.dso.getResources().getDimensionPixelSize(t.e.ds320);
        int dimensionPixelSize2 = this.dso.getResources().getDimensionPixelSize(t.e.ds480);
        int dimensionPixelSize3 = this.dso.getResources().getDimensionPixelSize(t.e.ds360);
        int dimensionPixelSize4 = this.dso.getResources().getDimensionPixelSize(t.e.ds60);
        this.mNoDataView = NoDataViewFactory.a(this.dso.getPageContext().getPageActivity(), this.bMY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(t.j.msg_center_unlogin_tip, dimensionPixelSize4), NoDataViewFactory.b.a(aVar, this.dso.getResources().getDimensionPixelSize(t.e.ds20)));
        this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
    }

    protected void onUserChanged(boolean z) {
        r(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dnD = new m(this, imMessageCenterShowItemData);
        String string = this.dso.getPageContext().getPageActivity().getString(t.j.delete_user_chat);
        this.dnC = new com.baidu.tbadk.core.dialog.c(this.dso.getPageContext().getPageActivity());
        this.dnC.cc(t.j.operation);
        this.dnC.a(new String[]{string}, this.dnD);
        this.dnC.d(this.dso.getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cu(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.dny.l(2000L);
        }
        return true;
    }

    public void gj(boolean z) {
        if (z) {
            if (awW() && this.dnB.getVisibility() != 0) {
                this.dnB.setVisibility(0);
            }
        } else if (this.dnB.getVisibility() != 8) {
            this.dnB.setVisibility(8);
        }
    }

    public void r(boolean z, boolean z2) {
        if (!z2) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mNoDataView != null) {
            this.bMY.removeView(this.mNoDataView);
        }
        gt(z);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(0);
        }
    }

    public boolean awW() {
        return this.dnF;
    }

    public void gl(boolean z) {
        this.dnF = z;
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
                if (this.dnv != null) {
                    this.dnv.insertOrUpdate(data, this.cWg);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dnv != null) {
                this.dnv.remove(data, this.cWg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1 && this.dnv != null) {
                this.dnv.setData(data, this.cWg);
            }
        }
    }

    @Override // com.baidu.tieba.imMessageCenter.mention.w, com.baidu.tbadk.mvc.f.a.a
    public void bP(boolean z) {
        super.bP(z);
    }
}
