package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class o extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private z bBn;
    public BdListView vl = null;
    private x bBt = null;
    private int bAU = -1;
    private String bBu = null;
    private View bBv = null;
    private com.baidu.tbadk.core.view.o ahO = null;
    private com.baidu.tbadk.core.view.y Yc = null;
    private TextView aek = null;
    private ForumData bBw = null;
    private boolean bBx = false;
    private int bnd = 0;
    private boolean mIsHost = true;
    private boolean bAN = false;
    private final CustomMessageListener bBy = new p(this, 2001187);
    private HttpMessageListener bBz = new q(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener bBA = new r(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.ai.b(2001187, by.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity ZM() {
        FragmentActivity activity = getActivity();
        if (activity instanceof PersonBarActivity) {
            return (PersonBarActivity) activity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bBA);
        registerListener(this.bBz);
        registerListener(this.bBy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ahO != null) {
            this.ahO.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ahO != null) {
            this.ahO.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bBt != null) {
            this.bBt = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bBz);
        MessageManager.getInstance().unRegisterListener(this.bBA);
        MessageManager.getInstance().unRegisterListener(this.bBy);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.bnd = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.friend_fragment, viewGroup, false);
        if (ZM() == null) {
            return inflate;
        }
        this.bBn = ZM().ZH();
        this.mIsHost = ZM().Ax();
        this.bAN = ZM().Zu();
        this.bBv = inflate.findViewById(com.baidu.tieba.v.friend_fragment_parent);
        if (this.mIsHost && !this.bAN) {
            this.aek = ZM().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.edit));
            this.aek.setOnClickListener(new s(this));
            this.aek.setVisibility(0);
        }
        this.bBt = new x(ZM(), this.bBn.ZQ(), this.mIsHost, this.bAN);
        this.bBt.w(new t(this));
        this.bBt.x(new u(this));
        this.vl = (BdListView) inflate.findViewById(com.baidu.tieba.v.my_friend_list);
        this.vl.setAdapter((ListAdapter) this.bBt);
        this.vl.setOnItemClickListener(new v(this));
        this.Yc = new com.baidu.tbadk.core.view.y(ZM());
        this.Yc.a(new w(this));
        this.vl.setPullRefresh(this.Yc);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(com.baidu.tieba.t.ds160);
            string = String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), getString(com.baidu.tieba.y.you));
        } else {
            dimension = (int) getResources().getDimension(com.baidu.tieba.t.ds80);
            if (this.bnd == 0) {
                string = String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), ZM().QS());
            } else {
                string = getString(com.baidu.tieba.y.person_bar_no_common_info);
            }
        }
        if (this.bAN) {
            this.ahO = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.s.O(string, getString(com.baidu.tieba.y.share_choose_bar_nothing_tip)), null);
        } else {
            this.ahO = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.s.cc(string), null);
        }
        if (this.mIsHost) {
            ZO();
        }
        if (this.bnd == ZM().QR()) {
            this.vl.hO();
        }
        return inflate;
    }

    public void et(boolean z) {
        if (this.bBt != null) {
            this.bBt.ZG();
            if (this.bBt.ZP()) {
                if (z) {
                    this.bBt.setEditState(false);
                    this.ahO.setVisibility(0);
                    this.vl.setVisibility(0);
                    return;
                }
                return;
            }
            this.ahO.setVisibility(8);
            this.vl.setVisibility(0);
        }
    }

    public x ZN() {
        return this.bBt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VX() {
        if (this.bBn != null) {
            this.bBn.f(this.mIsHost, this.bBn.getId());
        }
    }

    public void ZO() {
        if (this.bBn != null) {
            this.bBn.ZO();
        }
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            if (!z) {
                this.vl.hN();
            }
            int size = nVar.ZK() != null ? nVar.ZK().size() : 0;
            int size2 = nVar.ZL() != null ? nVar.ZL().size() : 0;
            if (ZM() != null) {
                ZM().P(size, size2);
            }
            if (this.bBn != null && this.bBt != null) {
                this.bBn.ZQ().E(nVar.ZK());
                this.bBn.ZQ().F(nVar.ZL());
                this.bBn.ZQ().gV(nVar.ZI());
                this.bBn.ZQ().gW(nVar.ZJ());
                if (this.bnd == 0) {
                    this.bBt.E(this.bBn.ZQ().ZK());
                } else {
                    this.bBt.E(this.bBn.ZQ().ZL());
                }
                et(true);
                this.bBt.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bBv != null && getActivity() != null) {
                ((BaseFragmentActivity) getActivity()).getLayoutMode().h(this.bBv);
            }
            if (this.ahO != null) {
                com.baidu.tbadk.core.util.aw.h(this.ahO, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (ZM() != null) {
                ZM().getNavigationBar().onChangeSkinType(i);
            }
            if (this.Yc != null) {
                this.Yc.bM(i);
            }
            if (this.bBt != null) {
                this.bBt.notifyDataSetChanged();
            }
        }
    }
}
