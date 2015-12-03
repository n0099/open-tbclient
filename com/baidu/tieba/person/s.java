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
import com.baidu.tieba.n;
import com.baidu.tieba.person.post.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ae cJG;
    private String cJX;
    private TextView cJZ;
    public BdListView mListView = null;
    public u.a cJQ = null;
    private ad cJR = null;
    private int cua = -1;
    private String cJS = null;
    private View cJT = null;
    private com.baidu.tbadk.core.view.n mNoDataView = null;
    private com.baidu.tbadk.core.view.s mPullView = null;
    private TextView aGj = null;
    public int cJU = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData cJV = null;
    private boolean cJW = false;
    private View cJY = null;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean cKa = false;
    private boolean cIK = false;
    private boolean cKb = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private final com.baidu.adp.framework.listener.e cKc = new t(this, 107129);
    private final CustomMessageListener cKd = new v(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener cKe = new w(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener cKf = new x(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, by.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity anx() {
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
        registerListener(this.cKf);
        registerListener(this.cKe);
        registerListener(this.cKd);
        registerListener(this.cKc);
        this.cKc.setSelfListener(true);
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
        if (this.cJR != null) {
            this.cJR = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cKe);
        MessageManager.getInstance().unRegisterListener(this.cKf);
        MessageManager.getInstance().unRegisterListener(this.cKd);
        MessageManager.getInstance().unRegisterListener(this.cKc);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(n.g.friend_fragment, viewGroup, false);
        this.cJY = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.g.friend_fragment_header, (ViewGroup) null);
        this.cJZ = (TextView) this.cJY.findViewById(n.f.header_text_describe);
        if (anx() == null) {
            return inflate;
        }
        this.cJX = getString(n.i.person_bar_no_more);
        this.cJG = anx().ano();
        this.mIsHost = anx().aah();
        this.cIK = anx().ane();
        this.cJT = inflate.findViewById(n.f.friend_fragment_parent);
        if (this.mIsHost && !this.cIK) {
            this.aGj = (TextView) anx().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.navigation_right_button_layout, anx()).findViewById(n.f.right_textview);
            this.aGj.setText(n.i.edit);
            this.aGj.setOnClickListener(new y(this));
            this.aGj.setVisibility(0);
        }
        this.cJR = new ad(anx(), this.cJG.anA(), this.mIsHost, this.cIK);
        this.cJR.kT(anx().ang());
        this.cJR.x(new z(this));
        this.cJR.E(new aa(this));
        this.mListView = (BdListView) inflate.findViewById(n.f.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.cJR);
        this.mListView.setOnItemClickListener(new ab(this));
        this.mPullView = new com.baidu.tbadk.core.view.s(anx().getPageContext());
        this.mPullView.a(new ac(this));
        this.cJQ = new u.a(getBaseFragmentActivity());
        this.mListView.setNextPage(this.cJQ);
        this.mListView.setOnSrollToBottomListener(new u(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(n.d.ds160);
            string = String.format(getString(n.i.person_bar_no_personal_info), getString(n.i.you));
        } else {
            dimension = (int) getResources().getDimension(n.d.ds80);
            if (this.mPageType == 0) {
                string = String.format(getString(n.i.person_bar_no_personal_info), anx().aag());
            } else {
                string = getString(n.i.person_bar_no_common_info);
            }
        }
        if (this.cIK) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ad(string, getString(n.i.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dK(string), null);
        }
        if (this.mIsHost && anx() != null && anx().getRequestCode() != 23011) {
            IR();
        }
        if (this.mPageType == anx().aaf()) {
            this.mListView.nD();
        }
        return inflate;
    }

    public void fD(boolean z) {
        if (this.cJR != null) {
            this.cJR.aic();
            if (this.cJR.anz()) {
                if (z) {
                    this.cJR.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.aGj != null) {
                        this.aGj.setVisibility(8);
                    }
                    if (this.cJQ != null && this.cJQ.getView() != null) {
                        this.cJQ.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.aGj != null) {
                this.aGj.setVisibility(0);
            }
            if (anx() != null && anx().getRequestCode() == 23011 && this.aGj != null) {
                this.aGj.setVisibility(8);
            }
        }
    }

    public ad any() {
        return this.cJR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LV() {
        if (this.cJG != null) {
            this.cJG.a(this.mIsHost, this.cJG.getId(), this.cJU, this.pageSize);
        }
    }

    public void hW(int i) {
        if (this.cJG != null) {
            this.cJG.a(this.mIsHost, this.cJG.getId(), i, this.pageSize);
        }
    }

    public void IR() {
        if (this.cJG != null) {
            this.cJG.IR();
        }
    }

    public void a(r rVar, boolean z) {
        if (rVar != null) {
            this.hasMore = rVar.isHasMore();
            if (!z) {
                this.mListView.completePullRefresh();
            }
            int anf = anx().anf();
            int i = 0;
            if (this.cJG != null && this.cJR != null) {
                if (this.mPageType == anx().aaf()) {
                    if (z) {
                        this.cJU = 1;
                        this.cJG.anA().b(rVar.anr(), rVar.ans());
                        this.cJG.anA().e(rVar.ant(), rVar.anu());
                        this.cJG.anA().ki(rVar.anp());
                        this.cJG.anA().kk(rVar.anq());
                    } else if (this.cJU == 1) {
                        this.cJG.anA().b(rVar.anr(), rVar.ans());
                        this.cJG.anA().e(rVar.ant(), rVar.anu());
                        this.cJG.anA().ki(rVar.anp());
                        this.cJG.anA().kk(rVar.anq());
                        this.cJU++;
                    } else {
                        this.cJG.anA().c(rVar.anr(), rVar.ans());
                        this.cJG.anA().d(rVar.ant(), rVar.anu());
                        this.cJG.anA().kj(rVar.anp());
                        this.cJG.anA().kl(rVar.anq());
                        this.cJU++;
                    }
                }
                if (this.mPageType == 0) {
                    this.cJR.Y(this.cJG.anA().anv());
                } else {
                    this.cJR.Y(this.cJG.anA().anw());
                }
                if (rVar.anw() != null) {
                    i = this.cJG.anA().anw().size();
                }
                if (anx() != null) {
                    anx().al(anf, i);
                }
                fD(true);
                this.cJR.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cJT != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().af(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cJT);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.as.i(this.mNoDataView, n.c.cp_bg_line_d);
            }
            if (anx() != null) {
                anx().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cV(i);
            }
            if (this.cJR != null) {
                this.cJR.notifyDataSetChanged();
            }
            if (this.cJQ != null) {
                this.cJQ.cV(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removalDuplicate() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }
}
