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
import com.baidu.tieba.person.post.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private TextView ciA;
    private ad cih;
    private String ciy;
    public BdListView mListView = null;
    public p.a cir = null;
    private ac cis = null;
    private int bWM = -1;
    private String cit = null;
    private View ciu = null;
    private com.baidu.tbadk.core.view.u mNoDataView = null;
    private com.baidu.tbadk.core.view.z mPullView = null;
    private TextView aDu = null;
    public int civ = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData ciw = null;
    private boolean cix = false;
    private View ciz = null;
    private int ciB = 0;
    private boolean mIsHost = true;
    private boolean ciC = false;
    private boolean chs = false;
    private boolean ciD = false;
    private ArrayList<ForumData> rM = new ArrayList<>();
    private final com.baidu.adp.framework.listener.e ciE = new s(this, 107129);
    private final CustomMessageListener ciF = new u(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener ciG = new v(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener ciH = new w(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, bw.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity agd() {
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
        registerListener(this.ciH);
        registerListener(this.ciG);
        registerListener(this.ciF);
        registerListener(this.ciE);
        this.ciE.setSelfListener(true);
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
        if (this.cis != null) {
            this.cis = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ciG);
        MessageManager.getInstance().unRegisterListener(this.ciH);
        MessageManager.getInstance().unRegisterListener(this.ciF);
        MessageManager.getInstance().unRegisterListener(this.ciE);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.ciB = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.ciz = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.friend_fragment_header, (ViewGroup) null);
        this.ciA = (TextView) this.ciz.findViewById(i.f.header_text_describe);
        if (agd() == null) {
            return inflate;
        }
        this.ciy = getString(i.C0057i.person_bar_no_more);
        this.cih = agd().afU();
        this.mIsHost = agd().VZ();
        this.chs = agd().afK();
        this.ciu = inflate.findViewById(i.f.friend_fragment_parent);
        if (this.mIsHost && !this.chs) {
            this.aDu = agd().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.C0057i.edit));
            this.aDu.setOnClickListener(new x(this));
            this.aDu.setVisibility(0);
        }
        this.cis = new ac(agd(), this.cih.agg(), this.mIsHost, this.chs);
        this.cis.jw(agd().afM());
        this.cis.x(new y(this));
        this.cis.E(new z(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.cis);
        this.mListView.setOnItemClickListener(new aa(this));
        this.mPullView = new com.baidu.tbadk.core.view.z(agd().getPageContext());
        this.mPullView.a(new ab(this));
        this.cir = new p.a(getBaseFragmentActivity());
        this.mListView.setNextPage(this.cir);
        this.mListView.setOnSrollToBottomListener(new t(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(i.d.ds160);
            string = String.format(getString(i.C0057i.person_bar_no_personal_info), getString(i.C0057i.you));
        } else {
            dimension = (int) getResources().getDimension(i.d.ds80);
            if (this.ciB == 0) {
                string = String.format(getString(i.C0057i.person_bar_no_personal_info), agd().VY());
            } else {
                string = getString(i.C0057i.person_bar_no_common_info);
            }
        }
        if (this.chs) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ah(string, getString(i.C0057i.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dr(string), null);
        }
        if (this.mIsHost && agd() != null && agd().getRequestCode() != 23011) {
            HX();
        }
        if (this.ciB == agd().VX()) {
            this.mListView.ny();
        }
        return inflate;
    }

    public void eG(boolean z) {
        if (this.cis != null) {
            this.cis.abX();
            if (this.cis.agf()) {
                if (z) {
                    this.cis.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.aDu != null) {
                        this.aDu.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.aDu != null) {
                this.aDu.setVisibility(0);
            }
            if (agd() != null && agd().getRequestCode() == 23011 && this.aDu != null) {
                this.aDu.setVisibility(8);
            }
        }
    }

    public ac age() {
        return this.cis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KF() {
        if (this.cih != null) {
            this.cih.a(this.mIsHost, this.cih.getId(), this.civ, this.pageSize);
        }
    }

    public void gG(int i) {
        if (this.cih != null) {
            this.cih.a(this.mIsHost, this.cih.getId(), i, this.pageSize);
        }
    }

    public void HX() {
        if (this.cih != null) {
            this.cih.HX();
        }
    }

    public void a(q qVar, boolean z) {
        if (qVar != null) {
            this.hasMore = qVar.isHasMore();
            if (!z) {
                this.mListView.completePullRefresh();
            }
            int afL = agd().afL();
            int i = 0;
            if (this.cih != null && this.cis != null) {
                if (this.ciB == agd().VX()) {
                    if (z) {
                        this.civ = 1;
                        this.cih.agg().b(qVar.afX(), qVar.afY());
                        this.cih.agg().e(qVar.afZ(), qVar.aga());
                        this.cih.agg().iE(qVar.afV());
                        this.cih.agg().iG(qVar.afW());
                    } else if (this.civ == 1) {
                        this.cih.agg().b(qVar.afX(), qVar.afY());
                        this.cih.agg().e(qVar.afZ(), qVar.aga());
                        this.cih.agg().iE(qVar.afV());
                        this.cih.agg().iG(qVar.afW());
                        this.civ++;
                    } else {
                        this.cih.agg().c(qVar.afX(), qVar.afY());
                        this.cih.agg().d(qVar.afZ(), qVar.aga());
                        this.cih.agg().iF(qVar.afV());
                        this.cih.agg().iH(qVar.afW());
                        this.civ++;
                    }
                }
                if (this.ciB == 0) {
                    this.cis.R(this.cih.agg().agb());
                } else {
                    this.cis.R(this.cih.agg().agc());
                }
                if (qVar.agc() != null) {
                    i = this.cih.agg().agc().size();
                }
                if (agd() != null) {
                    agd().ag(afL, i);
                }
                eG(true);
                this.cis.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.ciu != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ad(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.ciu);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.al.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (agd() != null) {
                agd().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cG(i);
            }
            if (this.cir != null) {
                this.cir.dw(i);
            }
            if (this.cis != null) {
                this.cis.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removalDuplicate() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.rM.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }
}
