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
    private s bGF;
    public BdListView mListView = null;
    public com.baidu.tieba.person.post.y bGP = null;
    private q bGQ = null;
    private int byo = -1;
    private String bGR = null;
    private View bGS = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.ak mPullView = null;
    private TextView amB = null;
    public int bGT = 0;
    public int bGU = 50;
    public boolean hasMore = false;
    private ForumData bGV = null;
    private boolean bGW = false;
    private int bGX = 0;
    private boolean mIsHost = true;
    private boolean bGz = false;
    private final CustomMessageListener bGY = new h(this, 2001187);
    private HttpMessageListener bGZ = new i(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener bHa = new j(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001187, br.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aaG() {
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
        registerListener(this.bHa);
        registerListener(this.bGZ);
        registerListener(this.bGY);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.f(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.bGQ != null) {
            this.bGQ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bGZ);
        MessageManager.getInstance().unRegisterListener(this.bHa);
        MessageManager.getInstance().unRegisterListener(this.bGY);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.bGX = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.friend_fragment, viewGroup, false);
        if (aaG() == null) {
            return inflate;
        }
        this.bGF = aaG().aax();
        this.mIsHost = aaG().RM();
        this.bGz = aaG().aar();
        this.bGS = inflate.findViewById(com.baidu.tieba.w.friend_fragment_parent);
        if (this.mIsHost && !this.bGz) {
            this.amB = aaG().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.edit));
            this.amB.setOnClickListener(new k(this));
            this.amB.setVisibility(0);
        }
        this.bGQ = new q(aaG(), this.bGF.aaJ(), this.mIsHost, this.bGz);
        this.bGQ.y(new l(this));
        this.bGQ.D(new m(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.w.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.bGQ);
        this.mListView.setOnItemClickListener(new n(this));
        this.mPullView = new com.baidu.tbadk.core.view.ak(aaG().getPageContext());
        this.mPullView.a(new o(this));
        this.bGP = new com.baidu.tieba.person.post.y(getBaseFragmentActivity());
        this.mListView.setNextPage(this.bGP);
        this.mListView.setOnSrollToBottomListener(new p(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(com.baidu.tieba.u.ds160);
            string = String.format(getString(com.baidu.tieba.z.person_bar_no_personal_info), getString(com.baidu.tieba.z.you));
        } else {
            dimension = (int) getResources().getDimension(com.baidu.tieba.u.ds80);
            if (this.bGX == 0) {
                string = String.format(getString(com.baidu.tieba.z.person_bar_no_personal_info), aaG().RL());
            } else {
                string = getString(com.baidu.tieba.z.person_bar_no_common_info);
            }
        }
        if (this.bGz) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.ac(string, getString(com.baidu.tieba.z.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.cQ(string), null);
        }
        if (this.mIsHost) {
            Dd();
        }
        if (this.bGX == aaG().RK()) {
            this.mListView.jC();
        }
        return inflate;
    }

    public void eh(boolean z) {
        if (this.bGQ != null) {
            this.bGQ.WC();
            if (this.bGQ.aaI()) {
                if (z) {
                    this.bGQ.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.amB != null) {
                        this.amB.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.amB != null) {
                this.amB.setVisibility(0);
            }
        }
    }

    public q aaH() {
        return this.bGQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jq() {
        if (this.bGF != null) {
            this.bGF.a(this.mIsHost, this.bGF.getId(), this.bGT, this.bGU);
        }
    }

    public void hn(int i) {
        if (this.bGF != null) {
            this.bGF.a(this.mIsHost, this.bGF.getId(), i, this.bGU);
        }
    }

    public void Dd() {
        if (this.bGF != null) {
            this.bGF.Dd();
        }
    }

    public void a(f fVar, boolean z) {
        if (fVar != null) {
            this.hasMore = fVar.isHasMore();
            if (!z) {
                this.mListView.jB();
            }
            int aas = aaG().aas();
            int i = 0;
            if (this.bGF != null && this.bGQ != null) {
                if (this.bGX == aaG().RK()) {
                    if (z) {
                        this.bGT = 1;
                        this.bGF.aaJ().b(fVar.aaA(), fVar.aaB());
                        this.bGF.aaJ().e(fVar.aaC(), fVar.aaD());
                        this.bGF.aaJ().hj(fVar.aay());
                        this.bGF.aaJ().hl(fVar.aaz());
                    } else if (this.bGT == 1) {
                        this.bGF.aaJ().b(fVar.aaA(), fVar.aaB());
                        this.bGF.aaJ().e(fVar.aaC(), fVar.aaD());
                        this.bGF.aaJ().hj(fVar.aay());
                        this.bGF.aaJ().hl(fVar.aaz());
                        this.bGT++;
                    } else {
                        this.bGF.aaJ().c(fVar.aaA(), fVar.aaB());
                        this.bGF.aaJ().d(fVar.aaC(), fVar.aaD());
                        this.bGF.aaJ().hk(fVar.aay());
                        this.bGF.aaJ().hm(fVar.aaz());
                        this.bGT++;
                    }
                }
                if (this.bGX == 0) {
                    this.bGQ.K(this.bGF.aaJ().aaE());
                } else {
                    this.bGQ.K(this.bGF.aaJ().aaF());
                }
                if (fVar.aaF() != null) {
                    i = this.bGF.aaJ().aaF().size();
                }
                if (aaG() != null) {
                    aaG().Z(aas, i);
                }
                eh(true);
                this.bGQ.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bGS != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ab(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bGS);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.bc.i(this.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (aaG() != null) {
                aaG().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cs(i);
            }
            if (this.bGQ != null) {
                this.bGQ.notifyDataSetChanged();
            }
        }
    }
}
