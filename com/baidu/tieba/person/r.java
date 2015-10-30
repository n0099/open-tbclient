package com.baidu.tieba.person;

import android.os.Bundle;
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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.i;
import com.baidu.tieba.person.post.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ad coP;
    private String cpg;
    private TextView cpi;
    public BdListView mListView = null;
    public u.a coZ = null;
    private ac cpa = null;
    private int cbA = -1;
    private String cpb = null;
    private View cpc = null;
    private com.baidu.tbadk.core.view.m mNoDataView = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private TextView aEs = null;
    public int cpd = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData cpe = null;
    private boolean cpf = false;
    private View cph = null;
    private int cpj = 0;
    private boolean mIsHost = true;
    private boolean cpk = false;
    private boolean cnT = false;
    private boolean cpl = false;
    private ArrayList<ForumData> rK = new ArrayList<>();
    private final com.baidu.adp.framework.listener.e cpm = new s(this, 107129);
    private final CustomMessageListener cpn = new u(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener cpo = new v(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener cpp = new w(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, bx.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aio() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonBarActivity) {
            return (PersonBarActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.cpp);
        registerListener(this.cpo);
        registerListener(this.cpn);
        registerListener(this.cpm);
        this.cpm.setSelfListener(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.cpa != null) {
            this.cpa = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cpo);
        MessageManager.getInstance().unRegisterListener(this.cpp);
        MessageManager.getInstance().unRegisterListener(this.cpn);
        MessageManager.getInstance().unRegisterListener(this.cpm);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.cpj = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.cph = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.friend_fragment_header, (ViewGroup) null);
        this.cpi = (TextView) this.cph.findViewById(i.f.header_text_describe);
        if (aio() == null) {
            return inflate;
        }
        this.cpg = getString(i.h.person_bar_no_more);
        this.coP = aio().aif();
        this.mIsHost = aio().WG();
        this.cnT = aio().ahV();
        this.cpc = inflate.findViewById(i.f.friend_fragment_parent);
        if (this.mIsHost && !this.cnT) {
            this.aEs = (TextView) aio().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, aio()).findViewById(i.f.right_textview);
            this.aEs.setText(i.h.edit);
            this.aEs.setOnClickListener(new x(this));
            this.aEs.setVisibility(0);
        }
        this.cpa = new ac(aio(), this.coP.air(), this.mIsHost, this.cnT);
        this.cpa.jZ(aio().ahX());
        this.cpa.x(new y(this));
        this.cpa.E(new z(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.cpa);
        this.mListView.setOnItemClickListener(new aa(this));
        this.mPullView = new com.baidu.tbadk.core.view.r(aio().getPageContext());
        this.mPullView.a(new ab(this));
        this.coZ = new u.a(getBaseFragmentActivity());
        this.mListView.setNextPage(this.coZ);
        this.mListView.setOnSrollToBottomListener(new t(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(i.d.ds160);
            string = String.format(getString(i.h.person_bar_no_personal_info), getString(i.h.you));
        } else {
            dimension = (int) getResources().getDimension(i.d.ds80);
            if (this.cpj == 0) {
                string = String.format(getString(i.h.person_bar_no_personal_info), aio().WF());
            } else {
                string = getString(i.h.person_bar_no_common_info);
            }
        }
        if (this.cnT) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ag(string, getString(i.h.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dC(string), null);
        }
        if (this.mIsHost && aio() != null && aio().getRequestCode() != 23011) {
            HB();
        }
        if (this.cpj == aio().WE()) {
            this.mListView.nw();
        }
        return inflate;
    }

    public void eV(boolean z) {
        if (this.cpa != null) {
            this.cpa.adt();
            if (this.cpa.aiq()) {
                if (z) {
                    this.cpa.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.aEs != null) {
                        this.aEs.setVisibility(8);
                    }
                    if (this.coZ != null && this.coZ.getView() != null) {
                        this.coZ.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.aEs != null) {
                this.aEs.setVisibility(0);
            }
            if (aio() != null && aio().getRequestCode() == 23011 && this.aEs != null) {
                this.aEs.setVisibility(8);
            }
        }
    }

    public ac aip() {
        return this.cpa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kk() {
        if (this.coP != null) {
            this.coP.a(this.mIsHost, this.coP.getId(), this.cpd, this.pageSize);
        }
    }

    public void gW(int i) {
        if (this.coP != null) {
            this.coP.a(this.mIsHost, this.coP.getId(), i, this.pageSize);
        }
    }

    public void HB() {
        if (this.coP != null) {
            this.coP.HB();
        }
    }

    public void a(q qVar, boolean z) {
        if (qVar != null) {
            this.hasMore = qVar.isHasMore();
            if (!z) {
                this.mListView.completePullRefresh();
            }
            int ahW = aio().ahW();
            int i = 0;
            if (this.coP != null && this.cpa != null) {
                if (this.cpj == aio().WE()) {
                    if (z) {
                        this.cpd = 1;
                        this.coP.air().b(qVar.aii(), qVar.aij());
                        this.coP.air().e(qVar.aik(), qVar.ail());
                        this.coP.air().ja(qVar.aig());
                        this.coP.air().jc(qVar.aih());
                    } else if (this.cpd == 1) {
                        this.coP.air().b(qVar.aii(), qVar.aij());
                        this.coP.air().e(qVar.aik(), qVar.ail());
                        this.coP.air().ja(qVar.aig());
                        this.coP.air().jc(qVar.aih());
                        this.cpd++;
                    } else {
                        this.coP.air().c(qVar.aii(), qVar.aij());
                        this.coP.air().d(qVar.aik(), qVar.ail());
                        this.coP.air().jb(qVar.aig());
                        this.coP.air().jd(qVar.aih());
                        this.cpd++;
                    }
                }
                if (this.cpj == 0) {
                    this.cpa.S(this.coP.air().aim());
                } else {
                    this.cpa.S(this.coP.air().ain());
                }
                if (qVar.ain() != null) {
                    i = this.coP.air().ain().size();
                }
                if (aio() != null) {
                    aio().ah(ahW, i);
                }
                eV(true);
                this.cpa.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cpc != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ad(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cpc);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.an.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (aio() != null) {
                aio().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cN(i);
            }
            if (this.cpa != null) {
                this.cpa.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removalDuplicate() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.rK.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }
}
