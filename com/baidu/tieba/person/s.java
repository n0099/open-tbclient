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
    private ae cNW;
    private String cOn;
    private TextView cOp;
    public BdListView mListView = null;
    public u.a cOg = null;
    private ad cOh = null;
    private int cyc = -1;
    private String cOi = null;
    private View cOj = null;
    private com.baidu.tbadk.core.view.o mNoDataView = null;
    private com.baidu.tbadk.core.view.t mPullView = null;
    private TextView aHJ = null;
    public int cOk = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData cOl = null;
    private boolean cOm = false;
    private View cOo = null;
    private int mPageType = 0;
    private boolean mIsHost = true;
    private boolean cOq = false;
    private boolean cNa = false;
    private boolean cOr = false;
    private ArrayList<ForumData> rN = new ArrayList<>();
    private final com.baidu.adp.framework.listener.e cOs = new t(this, 107129);
    private final CustomMessageListener cOt = new v(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener cOu = new w(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener cOv = new x(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, by.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aoI() {
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
        registerListener(this.cOv);
        registerListener(this.cOu);
        registerListener(this.cOt);
        registerListener(this.cOs);
        this.cOs.setSelfListener(true);
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
        if (this.cOh != null) {
            this.cOh = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cOu);
        MessageManager.getInstance().unRegisterListener(this.cOv);
        MessageManager.getInstance().unRegisterListener(this.cOt);
        MessageManager.getInstance().unRegisterListener(this.cOs);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(n.h.friend_fragment, viewGroup, false);
        this.cOo = LayoutInflater.from(getPageContext().getPageActivity()).inflate(n.h.friend_fragment_header, (ViewGroup) null);
        this.cOp = (TextView) this.cOo.findViewById(n.g.header_text_describe);
        if (aoI() == null) {
            return inflate;
        }
        this.cOn = getString(n.j.person_bar_no_more);
        this.cNW = aoI().aoz();
        this.mIsHost = aoI().abn();
        this.cNa = aoI().aop();
        this.cOj = inflate.findViewById(n.g.friend_fragment_parent);
        if (this.mIsHost && !this.cNa) {
            this.aHJ = (TextView) aoI().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.navigation_right_button_layout, aoI()).findViewById(n.g.right_textview);
            this.aHJ.setText(n.j.edit);
            this.aHJ.setOnClickListener(new y(this));
            this.aHJ.setVisibility(0);
        }
        this.cOh = new ad(aoI(), this.cNW.aoL(), this.mIsHost, this.cNa);
        this.cOh.kQ(aoI().aor());
        this.cOh.x(new z(this));
        this.cOh.E(new aa(this));
        this.mListView = (BdListView) inflate.findViewById(n.g.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.cOh);
        this.mListView.setOnItemClickListener(new ab(this));
        this.mPullView = new com.baidu.tbadk.core.view.t(aoI().getPageContext());
        this.mPullView.a(new ac(this));
        this.cOg = new u.a(getBaseFragmentActivity());
        this.mListView.setNextPage(this.cOg);
        this.mListView.setOnSrollToBottomListener(new u(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(n.e.ds160);
            string = String.format(getString(n.j.person_bar_no_personal_info), getString(n.j.you));
        } else {
            dimension = (int) getResources().getDimension(n.e.ds80);
            if (this.mPageType == 0) {
                string = String.format(getString(n.j.person_bar_no_personal_info), aoI().abm());
            } else {
                string = getString(n.j.person_bar_no_common_info);
            }
        }
        if (this.cNa) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ac(string, getString(n.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dN(string), null);
        }
        if (this.mIsHost && aoI() != null && aoI().getRequestCode() != 23011) {
            Ji();
        }
        if (this.mPageType == aoI().abl()) {
            this.mListView.nb();
        }
        return inflate;
    }

    public void fC(boolean z) {
        if (this.cOh != null) {
            this.cOh.ajp();
            if (this.cOh.aoK()) {
                if (z) {
                    this.cOh.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.aHJ != null) {
                        this.aHJ.setVisibility(8);
                    }
                    if (this.cOg != null && this.cOg.getView() != null) {
                        this.cOg.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.aHJ != null) {
                this.aHJ.setVisibility(0);
            }
            if (aoI() != null && aoI().getRequestCode() == 23011 && this.aHJ != null) {
                this.aHJ.setVisibility(8);
            }
        }
    }

    public ad aoJ() {
        return this.cOh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mo() {
        if (this.cNW != null) {
            this.cNW.a(this.mIsHost, this.cNW.getId(), this.cOk, this.pageSize);
        }
    }

    public void iw(int i) {
        if (this.cNW != null) {
            this.cNW.a(this.mIsHost, this.cNW.getId(), i, this.pageSize);
        }
    }

    public void Ji() {
        if (this.cNW != null) {
            this.cNW.Ji();
        }
    }

    public void a(r rVar, boolean z) {
        if (rVar != null) {
            this.hasMore = rVar.isHasMore();
            if (!z) {
                this.mListView.completePullRefresh();
            }
            int aoq = aoI().aoq();
            int i = 0;
            if (this.cNW != null && this.cOh != null) {
                if (this.mPageType == aoI().abl()) {
                    if (z) {
                        this.cOk = 1;
                        this.cNW.aoL().b(rVar.aoC(), rVar.aoD());
                        this.cNW.aoL().e(rVar.aoE(), rVar.aoF());
                        this.cNW.aoL().kF(rVar.aoA());
                        this.cNW.aoL().kH(rVar.aoB());
                    } else if (this.cOk == 1) {
                        this.cNW.aoL().b(rVar.aoC(), rVar.aoD());
                        this.cNW.aoL().e(rVar.aoE(), rVar.aoF());
                        this.cNW.aoL().kF(rVar.aoA());
                        this.cNW.aoL().kH(rVar.aoB());
                        this.cOk++;
                    } else {
                        this.cNW.aoL().c(rVar.aoC(), rVar.aoD());
                        this.cNW.aoL().d(rVar.aoE(), rVar.aoF());
                        this.cNW.aoL().kG(rVar.aoA());
                        this.cNW.aoL().kI(rVar.aoB());
                        this.cOk++;
                    }
                }
                if (this.mPageType == 0) {
                    this.cOh.X(this.cNW.aoL().aoG());
                } else {
                    this.cOh.X(this.cNW.aoL().aoH());
                }
                if (rVar.aoH() != null) {
                    i = this.cNW.aoL().aoH().size();
                }
                if (aoI() != null) {
                    aoI().ax(aoq, i);
                }
                fC(true);
                this.cOh.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cOj != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ac(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cOj);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.as.i(this.mNoDataView, n.d.cp_bg_line_d);
            }
            if (aoI() != null) {
                aoI().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cP(i);
            }
            if (this.cOh != null) {
                this.cOh.notifyDataSetChanged();
            }
            if (this.cOg != null) {
                this.cOg.cP(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removalDuplicate() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.rN.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }
}
