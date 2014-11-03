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
    private z bBB;
    public BdListView vl = null;
    private x bBH = null;
    private int bBi = -1;
    private String bBI = null;
    private View bBJ = null;
    private com.baidu.tbadk.core.view.o ahX = null;
    private com.baidu.tbadk.core.view.y Yg = null;
    private TextView aes = null;
    private ForumData bBK = null;
    private boolean bBL = false;
    private int bnr = 0;
    private boolean mIsHost = true;
    private boolean bBb = false;
    private final CustomMessageListener bBM = new p(this, 2001187);
    private HttpMessageListener bBN = new q(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener bBO = new r(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.ai.b(2001187, bz.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity ZO() {
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
        registerListener(this.bBO);
        registerListener(this.bBN);
        registerListener(this.bBM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ahX != null) {
            this.ahX.nv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ahX != null) {
            this.ahX.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bBH != null) {
            this.bBH = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bBN);
        MessageManager.getInstance().unRegisterListener(this.bBO);
        MessageManager.getInstance().unRegisterListener(this.bBM);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.bnr = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.friend_fragment, viewGroup, false);
        if (ZO() == null) {
            return inflate;
        }
        this.bBB = ZO().ZJ();
        this.mIsHost = ZO().Az();
        this.bBb = ZO().Zx();
        this.bBJ = inflate.findViewById(com.baidu.tieba.v.friend_fragment_parent);
        if (this.mIsHost && !this.bBb) {
            this.aes = ZO().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.edit));
            this.aes.setOnClickListener(new s(this));
            this.aes.setVisibility(0);
        }
        this.bBH = new x(ZO(), this.bBB.ZS(), this.mIsHost, this.bBb);
        this.bBH.w(new t(this));
        this.bBH.x(new u(this));
        this.vl = (BdListView) inflate.findViewById(com.baidu.tieba.v.my_friend_list);
        this.vl.setAdapter((ListAdapter) this.bBH);
        this.vl.setOnItemClickListener(new v(this));
        this.Yg = new com.baidu.tbadk.core.view.y(ZO());
        this.Yg.a(new w(this));
        this.vl.setPullRefresh(this.Yg);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(com.baidu.tieba.t.ds160);
            string = String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), getString(com.baidu.tieba.y.you));
        } else {
            dimension = (int) getResources().getDimension(com.baidu.tieba.t.ds80);
            if (this.bnr == 0) {
                string = String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), ZO().QV());
            } else {
                string = getString(com.baidu.tieba.y.person_bar_no_common_info);
            }
        }
        if (this.bBb) {
            this.ahX = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.s.O(string, getString(com.baidu.tieba.y.share_choose_bar_nothing_tip)), null);
        } else {
            this.ahX = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.r.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.s.cc(string), null);
        }
        if (this.mIsHost) {
            ZQ();
        }
        if (this.bnr == ZO().QU()) {
            this.vl.hO();
        }
        return inflate;
    }

    public void et(boolean z) {
        if (this.bBH != null) {
            this.bBH.ZI();
            if (this.bBH.ZR()) {
                if (z) {
                    this.bBH.setEditState(false);
                    this.ahX.setVisibility(0);
                    this.vl.setVisibility(0);
                    return;
                }
                return;
            }
            this.ahX.setVisibility(8);
            this.vl.setVisibility(0);
        }
    }

    public x ZP() {
        return this.bBH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wa() {
        if (this.bBB != null) {
            this.bBB.f(this.mIsHost, this.bBB.getId());
        }
    }

    public void ZQ() {
        if (this.bBB != null) {
            this.bBB.ZQ();
        }
    }

    public void a(n nVar, boolean z) {
        if (nVar != null) {
            if (!z) {
                this.vl.hN();
            }
            int size = nVar.ZM() != null ? nVar.ZM().size() : 0;
            int size2 = nVar.ZN() != null ? nVar.ZN().size() : 0;
            if (ZO() != null) {
                ZO().P(size, size2);
            }
            if (this.bBB != null && this.bBH != null) {
                this.bBB.ZS().F(nVar.ZM());
                this.bBB.ZS().G(nVar.ZN());
                this.bBB.ZS().gV(nVar.ZK());
                this.bBB.ZS().gW(nVar.ZL());
                if (this.bnr == 0) {
                    this.bBH.F(this.bBB.ZS().ZM());
                } else {
                    this.bBH.F(this.bBB.ZS().ZN());
                }
                et(true);
                this.bBH.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bBJ != null && getActivity() != null) {
                ((BaseFragmentActivity) getActivity()).getLayoutMode().h(this.bBJ);
            }
            if (this.ahX != null) {
                com.baidu.tbadk.core.util.aw.h(this.ahX, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (ZO() != null) {
                ZO().getNavigationBar().onChangeSkinType(i);
            }
            if (this.Yg != null) {
                this.Yg.bM(i);
            }
            if (this.bBH != null) {
                this.bBH.notifyDataSetChanged();
            }
        }
    }
}
