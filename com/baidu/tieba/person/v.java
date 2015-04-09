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
public class v extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String bPQ;
    private ah bPy;
    public BdListView mListView = null;
    public com.baidu.tieba.person.post.z bPI = null;
    private af bPJ = null;
    private int bDX = -1;
    private String bPK = null;
    private View bPL = null;
    private com.baidu.tbadk.core.view.s mNoDataView = null;
    private com.baidu.tbadk.core.view.ag mPullView = null;
    private TextView auy = null;
    public int bPM = 0;
    public int bPN = 50;
    public boolean hasMore = false;
    private ForumData bPO = null;
    private boolean bPP = false;
    private int bPR = 0;
    private boolean mIsHost = true;
    private boolean bON = false;
    private final CustomMessageListener bPS = new w(this, 2001187);
    private HttpMessageListener bPT = new x(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener bPU = new y(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001187, bp.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity adl() {
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
        registerListener(this.bPU);
        registerListener(this.bPT);
        registerListener(this.bPS);
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
        if (this.bPJ != null) {
            this.bPJ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bPT);
        MessageManager.getInstance().unRegisterListener(this.bPU);
        MessageManager.getInstance().unRegisterListener(this.bPS);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.bPR = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.friend_fragment, viewGroup, false);
        if (adl() == null) {
            return inflate;
        }
        this.bPQ = getString(com.baidu.tieba.y.person_bar_no_more);
        this.bPy = adl().adc();
        this.mIsHost = adl().Te();
        this.bON = adl().acT();
        this.bPL = inflate.findViewById(com.baidu.tieba.v.friend_fragment_parent);
        if (this.mIsHost && !this.bON) {
            this.auy = adl().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.edit));
            this.auy.setOnClickListener(new z(this));
            this.auy.setVisibility(0);
        }
        this.bPJ = new af(adl(), this.bPy.ado(), this.mIsHost, this.bON);
        this.bPJ.s(new aa(this));
        this.bPJ.z(new ab(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.v.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.bPJ);
        this.mListView.setOnItemClickListener(new ac(this));
        this.mPullView = new com.baidu.tbadk.core.view.ag(adl().getPageContext());
        this.mPullView.a(new ad(this));
        this.bPI = new com.baidu.tieba.person.post.z(getBaseFragmentActivity());
        this.mListView.setNextPage(this.bPI);
        this.mListView.setOnSrollToBottomListener(new ae(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(com.baidu.tieba.t.ds160);
            string = String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), getString(com.baidu.tieba.y.you));
        } else {
            dimension = (int) getResources().getDimension(com.baidu.tieba.t.ds80);
            if (this.bPR == 0) {
                string = String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), adl().Td());
            } else {
                string = getString(com.baidu.tieba.y.person_bar_no_common_info);
            }
        }
        if (this.bON) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.w.ac(string, getString(com.baidu.tieba.y.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.w.cZ(string), null);
        }
        if (this.mIsHost) {
            Ge();
        }
        if (this.bPR == adl().Tc()) {
            this.mListView.mX();
        }
        return inflate;
    }

    public void ec(boolean z) {
        if (this.bPJ != null) {
            this.bPJ.Yg();
            if (this.bPJ.adn()) {
                if (z) {
                    this.bPJ.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.auy != null) {
                        this.auy.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.auy != null) {
                this.auy.setVisibility(0);
            }
        }
    }

    public af adm() {
        return this.bPJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VA() {
        if (this.bPy != null) {
            this.bPy.a(this.mIsHost, this.bPy.getId(), this.bPM, this.bPN);
        }
    }

    public void hB(int i) {
        if (this.bPy != null) {
            this.bPy.a(this.mIsHost, this.bPy.getId(), i, this.bPN);
        }
    }

    public void Ge() {
        if (this.bPy != null) {
            this.bPy.Ge();
        }
    }

    public void a(u uVar, boolean z) {
        if (uVar != null) {
            this.hasMore = uVar.isHasMore();
            if (!z) {
                this.mListView.mW();
            }
            int acU = adl().acU();
            int i = 0;
            if (this.bPy != null && this.bPJ != null) {
                if (this.bPR == adl().Tc()) {
                    if (z) {
                        this.bPM = 1;
                        this.bPy.ado().b(uVar.adf(), uVar.adg());
                        this.bPy.ado().e(uVar.adh(), uVar.adi());
                        this.bPy.ado().hx(uVar.add());
                        this.bPy.ado().hz(uVar.ade());
                    } else if (this.bPM == 1) {
                        this.bPy.ado().b(uVar.adf(), uVar.adg());
                        this.bPy.ado().e(uVar.adh(), uVar.adi());
                        this.bPy.ado().hx(uVar.add());
                        this.bPy.ado().hz(uVar.ade());
                        this.bPM++;
                    } else {
                        this.bPy.ado().c(uVar.adf(), uVar.adg());
                        this.bPy.ado().d(uVar.adh(), uVar.adi());
                        this.bPy.ado().hy(uVar.add());
                        this.bPy.ado().hA(uVar.ade());
                        this.bPM++;
                    }
                }
                if (this.bPR == 0) {
                    this.bPJ.Q(this.bPy.ado().adj());
                } else {
                    this.bPJ.Q(this.bPy.ado().adk());
                }
                if (uVar.adk() != null) {
                    i = this.bPy.ado().adk().size();
                }
                if (adl() != null) {
                    adl().R(acU, i);
                }
                ec(true);
                this.bPJ.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bPL != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().X(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bPL);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ba.i(this.mNoDataView, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (adl() != null) {
                adl().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.ct(i);
            }
            if (this.bPJ != null) {
                this.bPJ.notifyDataSetChanged();
            }
        }
    }
}
