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
    private ad coE;
    private String coV;
    private TextView coX;
    public BdListView mListView = null;
    public u.a coO = null;
    private ac coP = null;
    private int cbp = -1;
    private String coQ = null;
    private View coR = null;
    private com.baidu.tbadk.core.view.m mNoDataView = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private TextView aEh = null;
    public int coS = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData coT = null;
    private boolean coU = false;
    private View coW = null;
    private int coY = 0;
    private boolean mIsHost = true;
    private boolean coZ = false;
    private boolean cnI = false;
    private boolean cpa = false;
    private ArrayList<ForumData> rK = new ArrayList<>();
    private final com.baidu.adp.framework.listener.e cpb = new s(this, 107129);
    private final CustomMessageListener cpc = new u(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener cpd = new v(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener cpe = new w(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, bx.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity ais() {
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
        registerListener(this.cpe);
        registerListener(this.cpd);
        registerListener(this.cpc);
        registerListener(this.cpb);
        this.cpb.setSelfListener(true);
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
        if (this.coP != null) {
            this.coP = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cpd);
        MessageManager.getInstance().unRegisterListener(this.cpe);
        MessageManager.getInstance().unRegisterListener(this.cpc);
        MessageManager.getInstance().unRegisterListener(this.cpb);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.coY = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.coW = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.friend_fragment_header, (ViewGroup) null);
        this.coX = (TextView) this.coW.findViewById(i.f.header_text_describe);
        if (ais() == null) {
            return inflate;
        }
        this.coV = getString(i.h.person_bar_no_more);
        this.coE = ais().aij();
        this.mIsHost = ais().WK();
        this.cnI = ais().ahZ();
        this.coR = inflate.findViewById(i.f.friend_fragment_parent);
        if (this.mIsHost && !this.cnI) {
            this.aEh = (TextView) ais().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, ais()).findViewById(i.f.right_textview);
            this.aEh.setText(i.h.edit);
            this.aEh.setOnClickListener(new x(this));
            this.aEh.setVisibility(0);
        }
        this.coP = new ac(ais(), this.coE.aiv(), this.mIsHost, this.cnI);
        this.coP.jZ(ais().aib());
        this.coP.x(new y(this));
        this.coP.E(new z(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.coP);
        this.mListView.setOnItemClickListener(new aa(this));
        this.mPullView = new com.baidu.tbadk.core.view.r(ais().getPageContext());
        this.mPullView.a(new ab(this));
        this.coO = new u.a(getBaseFragmentActivity());
        this.mListView.setNextPage(this.coO);
        this.mListView.setOnSrollToBottomListener(new t(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(i.d.ds160);
            string = String.format(getString(i.h.person_bar_no_personal_info), getString(i.h.you));
        } else {
            dimension = (int) getResources().getDimension(i.d.ds80);
            if (this.coY == 0) {
                string = String.format(getString(i.h.person_bar_no_personal_info), ais().WJ());
            } else {
                string = getString(i.h.person_bar_no_common_info);
            }
        }
        if (this.cnI) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ag(string, getString(i.h.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dC(string), null);
        }
        if (this.mIsHost && ais() != null && ais().getRequestCode() != 23011) {
            HF();
        }
        if (this.coY == ais().WI()) {
            this.mListView.nw();
        }
        return inflate;
    }

    public void eV(boolean z) {
        if (this.coP != null) {
            this.coP.adx();
            if (this.coP.aiu()) {
                if (z) {
                    this.coP.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.aEh != null) {
                        this.aEh.setVisibility(8);
                    }
                    if (this.coO != null && this.coO.getView() != null) {
                        this.coO.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.aEh != null) {
                this.aEh.setVisibility(0);
            }
            if (ais() != null && ais().getRequestCode() == 23011 && this.aEh != null) {
                this.aEh.setVisibility(8);
            }
        }
    }

    public ac ait() {
        return this.coP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ko() {
        if (this.coE != null) {
            this.coE.a(this.mIsHost, this.coE.getId(), this.coS, this.pageSize);
        }
    }

    public void gW(int i) {
        if (this.coE != null) {
            this.coE.a(this.mIsHost, this.coE.getId(), i, this.pageSize);
        }
    }

    public void HF() {
        if (this.coE != null) {
            this.coE.HF();
        }
    }

    public void a(q qVar, boolean z) {
        if (qVar != null) {
            this.hasMore = qVar.isHasMore();
            if (!z) {
                this.mListView.completePullRefresh();
            }
            int aia = ais().aia();
            int i = 0;
            if (this.coE != null && this.coP != null) {
                if (this.coY == ais().WI()) {
                    if (z) {
                        this.coS = 1;
                        this.coE.aiv().b(qVar.aim(), qVar.ain());
                        this.coE.aiv().e(qVar.aio(), qVar.aip());
                        this.coE.aiv().ja(qVar.aik());
                        this.coE.aiv().jc(qVar.ail());
                    } else if (this.coS == 1) {
                        this.coE.aiv().b(qVar.aim(), qVar.ain());
                        this.coE.aiv().e(qVar.aio(), qVar.aip());
                        this.coE.aiv().ja(qVar.aik());
                        this.coE.aiv().jc(qVar.ail());
                        this.coS++;
                    } else {
                        this.coE.aiv().c(qVar.aim(), qVar.ain());
                        this.coE.aiv().d(qVar.aio(), qVar.aip());
                        this.coE.aiv().jb(qVar.aik());
                        this.coE.aiv().jd(qVar.ail());
                        this.coS++;
                    }
                }
                if (this.coY == 0) {
                    this.coP.S(this.coE.aiv().aiq());
                } else {
                    this.coP.S(this.coE.aiv().air());
                }
                if (qVar.air() != null) {
                    i = this.coE.aiv().air().size();
                }
                if (ais() != null) {
                    ais().ah(aia, i);
                }
                eV(true);
                this.coP.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.coR != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ad(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.coR);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.am.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (ais() != null) {
                ais().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cN(i);
            }
            if (this.coP != null) {
                this.coP.notifyDataSetChanged();
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
