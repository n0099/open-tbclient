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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class g extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private s bEV;
    public BdListView mListView = null;
    public com.baidu.tieba.person.post.z bFf = null;
    private q bFg = null;
    private int bwG = -1;
    private String bFh = null;
    private View bFi = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.ak mPullView = null;
    private TextView alK = null;
    public int bFj = 0;
    public int bFk = 50;
    public boolean hasMore = false;
    private ForumData bFl = null;
    private boolean bFm = false;
    private int bFn = 0;
    private boolean mIsHost = true;
    private boolean bEP = false;
    private final CustomMessageListener bFo = new h(this, 2001187);
    private HttpMessageListener bFp = new i(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener bFq = new j(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001187, bs.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aag() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonBarActivity) {
            return (PersonBarActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.bFq);
        registerListener(this.bFp);
        registerListener(this.bFo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.f(getPageContext());
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
        if (this.bFg != null) {
            this.bFg = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bFp);
        MessageManager.getInstance().unRegisterListener(this.bFq);
        MessageManager.getInstance().unRegisterListener(this.bFo);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.bFn = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.friend_fragment, viewGroup, false);
        if (aag() == null) {
            return inflate;
        }
        this.bEV = aag().ZX();
        this.mIsHost = aag().Rv();
        this.bEP = aag().ZR();
        this.bFi = inflate.findViewById(com.baidu.tieba.w.friend_fragment_parent);
        if (this.mIsHost && !this.bEP) {
            this.alK = aag().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.edit));
            this.alK.setOnClickListener(new k(this));
            this.alK.setVisibility(0);
        }
        this.bFg = new q(aag(), this.bEV.aaj(), this.mIsHost, this.bEP);
        this.bFg.x(new l(this));
        this.bFg.C(new m(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.w.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.bFg);
        this.mListView.setOnItemClickListener(new n(this));
        this.mPullView = new com.baidu.tbadk.core.view.ak(aag().getPageContext().getPageActivity());
        this.mPullView.a(new o(this));
        this.bFf = new com.baidu.tieba.person.post.z(getBaseFragmentActivity());
        this.mListView.setNextPage(this.bFf);
        this.mListView.setOnSrollToBottomListener(new p(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(com.baidu.tieba.u.ds160);
            string = String.format(getString(com.baidu.tieba.z.person_bar_no_personal_info), getString(com.baidu.tieba.z.you));
        } else {
            dimension = (int) getResources().getDimension(com.baidu.tieba.u.ds80);
            if (this.bFn == 0) {
                string = String.format(getString(com.baidu.tieba.z.person_bar_no_personal_info), aag().Ru());
            } else {
                string = getString(com.baidu.tieba.z.person_bar_no_common_info);
            }
        }
        if (this.bEP) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.Z(string, getString(com.baidu.tieba.z.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.cU(string), null);
        }
        if (this.mIsHost) {
            CK();
        }
        if (this.bFn == aag().Rt()) {
            this.mListView.jK();
        }
        return inflate;
    }

    public void eb(boolean z) {
        if (this.bFg != null) {
            this.bFg.Wc();
            if (this.bFg.aai()) {
                if (z) {
                    this.bFg.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.alK != null) {
                        this.alK.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.alK != null) {
                this.alK.setVisibility(0);
            }
        }
    }

    public q aah() {
        return this.bFg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IX() {
        if (this.bEV != null) {
            this.bEV.a(this.mIsHost, this.bEV.getId(), this.bFj, this.bFk);
        }
    }

    public void he(int i) {
        if (this.bEV != null) {
            this.bEV.a(this.mIsHost, this.bEV.getId(), i, this.bFk);
        }
    }

    public void CK() {
        if (this.bEV != null) {
            this.bEV.CK();
        }
    }

    public void a(f fVar, boolean z) {
        if (fVar != null) {
            this.hasMore = fVar.isHasMore();
            if (!z) {
                this.mListView.jJ();
            }
            int ZS = aag().ZS();
            int i = 0;
            if (this.bEV != null && this.bFg != null) {
                if (this.bFn == aag().Rt()) {
                    if (z) {
                        this.bFj = 1;
                        this.bEV.aaj().a(fVar.aaa(), fVar.aab());
                        this.bEV.aaj().d(fVar.aac(), fVar.aad());
                        this.bEV.aaj().ha(fVar.ZY());
                        this.bEV.aaj().hc(fVar.ZZ());
                    } else if (this.bFj == 1) {
                        this.bEV.aaj().a(fVar.aaa(), fVar.aab());
                        this.bEV.aaj().d(fVar.aac(), fVar.aad());
                        this.bEV.aaj().ha(fVar.ZY());
                        this.bEV.aaj().hc(fVar.ZZ());
                        this.bFj++;
                    } else {
                        this.bEV.aaj().b(fVar.aaa(), fVar.aab());
                        this.bEV.aaj().c(fVar.aac(), fVar.aad());
                        this.bEV.aaj().hb(fVar.ZY());
                        this.bEV.aaj().hd(fVar.ZZ());
                        this.bFj++;
                    }
                }
                if (this.bFn == 0) {
                    this.bFg.J(this.bEV.aaj().aae());
                } else {
                    this.bFg.J(this.bEV.aaj().aaf());
                }
                if (fVar.aaf() != null) {
                    i = this.bEV.aaj().aaf().size();
                }
                if (aag() != null) {
                    aag().X(ZS, i);
                }
                eb(true);
                this.bFg.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bFi != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ab(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bFi);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ax.i(this.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (aag() != null) {
                aag().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cl(i);
            }
            if (this.bFg != null) {
                this.bFg.notifyDataSetChanged();
            }
        }
    }
}
