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
    private s bGG;
    public BdListView mListView = null;
    public com.baidu.tieba.person.post.y bGQ = null;
    private q bGR = null;
    private int byp = -1;
    private String bGS = null;
    private View bGT = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.ak mPullView = null;
    private TextView amE = null;
    public int bGU = 0;
    public int bGV = 50;
    public boolean hasMore = false;
    private ForumData bGW = null;
    private boolean bGX = false;
    private int bGY = 0;
    private boolean mIsHost = true;
    private boolean bGA = false;
    private final CustomMessageListener bGZ = new h(this, 2001187);
    private HttpMessageListener bHa = new i(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener bHb = new j(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001187, br.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aaL() {
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
        registerListener(this.bHb);
        registerListener(this.bHa);
        registerListener(this.bGZ);
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
        if (this.bGR != null) {
            this.bGR = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bHa);
        MessageManager.getInstance().unRegisterListener(this.bHb);
        MessageManager.getInstance().unRegisterListener(this.bGZ);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.bGY = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.x.friend_fragment, viewGroup, false);
        if (aaL() == null) {
            return inflate;
        }
        this.bGG = aaL().aaC();
        this.mIsHost = aaL().RR();
        this.bGA = aaL().aaw();
        this.bGT = inflate.findViewById(com.baidu.tieba.w.friend_fragment_parent);
        if (this.mIsHost && !this.bGA) {
            this.amE = aaL().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.z.edit));
            this.amE.setOnClickListener(new k(this));
            this.amE.setVisibility(0);
        }
        this.bGR = new q(aaL(), this.bGG.aaO(), this.mIsHost, this.bGA);
        this.bGR.y(new l(this));
        this.bGR.D(new m(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.w.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.bGR);
        this.mListView.setOnItemClickListener(new n(this));
        this.mPullView = new com.baidu.tbadk.core.view.ak(aaL().getPageContext());
        this.mPullView.a(new o(this));
        this.bGQ = new com.baidu.tieba.person.post.y(getBaseFragmentActivity());
        this.mListView.setNextPage(this.bGQ);
        this.mListView.setOnSrollToBottomListener(new p(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(com.baidu.tieba.u.ds160);
            string = String.format(getString(com.baidu.tieba.z.person_bar_no_personal_info), getString(com.baidu.tieba.z.you));
        } else {
            dimension = (int) getResources().getDimension(com.baidu.tieba.u.ds80);
            if (this.bGY == 0) {
                string = String.format(getString(com.baidu.tieba.z.person_bar_no_personal_info), aaL().RQ());
            } else {
                string = getString(com.baidu.tieba.z.person_bar_no_common_info);
            }
        }
        if (this.bGA) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.ac(string, getString(com.baidu.tieba.z.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.cT(string), null);
        }
        if (this.mIsHost) {
            Dj();
        }
        if (this.bGY == aaL().RP()) {
            this.mListView.jJ();
        }
        return inflate;
    }

    public void eh(boolean z) {
        if (this.bGR != null) {
            this.bGR.WH();
            if (this.bGR.aaN()) {
                if (z) {
                    this.bGR.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.amE != null) {
                        this.amE.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.amE != null) {
                this.amE.setVisibility(0);
            }
        }
    }

    public q aaM() {
        return this.bGR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jv() {
        if (this.bGG != null) {
            this.bGG.a(this.mIsHost, this.bGG.getId(), this.bGU, this.bGV);
        }
    }

    public void hn(int i) {
        if (this.bGG != null) {
            this.bGG.a(this.mIsHost, this.bGG.getId(), i, this.bGV);
        }
    }

    public void Dj() {
        if (this.bGG != null) {
            this.bGG.Dj();
        }
    }

    public void a(f fVar, boolean z) {
        if (fVar != null) {
            this.hasMore = fVar.isHasMore();
            if (!z) {
                this.mListView.jI();
            }
            int aax = aaL().aax();
            int i = 0;
            if (this.bGG != null && this.bGR != null) {
                if (this.bGY == aaL().RP()) {
                    if (z) {
                        this.bGU = 1;
                        this.bGG.aaO().b(fVar.aaF(), fVar.aaG());
                        this.bGG.aaO().e(fVar.aaH(), fVar.aaI());
                        this.bGG.aaO().hj(fVar.aaD());
                        this.bGG.aaO().hl(fVar.aaE());
                    } else if (this.bGU == 1) {
                        this.bGG.aaO().b(fVar.aaF(), fVar.aaG());
                        this.bGG.aaO().e(fVar.aaH(), fVar.aaI());
                        this.bGG.aaO().hj(fVar.aaD());
                        this.bGG.aaO().hl(fVar.aaE());
                        this.bGU++;
                    } else {
                        this.bGG.aaO().c(fVar.aaF(), fVar.aaG());
                        this.bGG.aaO().d(fVar.aaH(), fVar.aaI());
                        this.bGG.aaO().hk(fVar.aaD());
                        this.bGG.aaO().hm(fVar.aaE());
                        this.bGU++;
                    }
                }
                if (this.bGY == 0) {
                    this.bGR.K(this.bGG.aaO().aaJ());
                } else {
                    this.bGR.K(this.bGG.aaO().aaK());
                }
                if (fVar.aaK() != null) {
                    i = this.bGG.aaO().aaK().size();
                }
                if (aaL() != null) {
                    aaL().Y(aax, i);
                }
                eh(true);
                this.bGR.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bGT != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ab(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bGT);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.bc.i(this.mNoDataView, com.baidu.tieba.t.cp_bg_line_d);
            }
            if (aaL() != null) {
                aaL().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cs(i);
            }
            if (this.bGR != null) {
                this.bGR.notifyDataSetChanged();
            }
        }
    }
}
