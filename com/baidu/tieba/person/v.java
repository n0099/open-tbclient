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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class v extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ai bRB;
    private String bRS;
    private TextView bRU;
    public BdListView mListView = null;
    public com.baidu.tieba.person.post.z bRL = null;
    private ag bRM = null;
    private int bGS = -1;
    private String bRN = null;
    private View bRO = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.al mPullView = null;
    private TextView awb = null;
    public int bRP = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData bRQ = null;
    private boolean bRR = false;
    private View bRT = null;
    private int bRV = 0;
    private boolean mIsHost = true;
    private boolean bQO = false;
    private boolean bRW = false;
    private ArrayList<ForumData> rQ = new ArrayList<>();
    private final com.baidu.adp.framework.listener.e bRX = new w(this, 107129);
    private final CustomMessageListener bRY = new y(this, 2001187);
    private HttpMessageListener bRZ = new z(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener bSa = new aa(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001187, ci.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity ael() {
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
        registerListener(this.bSa);
        registerListener(this.bRZ);
        registerListener(this.bRY);
        registerListener(this.bRX);
        this.bRX.setSelfListener(true);
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
        if (this.bRM != null) {
            this.bRM = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bRZ);
        MessageManager.getInstance().unRegisterListener(this.bSa);
        MessageManager.getInstance().unRegisterListener(this.bRY);
        MessageManager.getInstance().unRegisterListener(this.bRX);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.bRV = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.r.friend_fragment, viewGroup, false);
        this.bRT = com.baidu.adp.lib.g.b.hr().inflate(getActivity().getBaseContext(), com.baidu.tieba.r.friend_fragment_header, null);
        this.bRU = (TextView) this.bRT.findViewById(com.baidu.tieba.q.header_text_describe);
        if (ael() == null) {
            return inflate;
        }
        this.bRS = getString(com.baidu.tieba.t.person_bar_no_more);
        this.bRB = ael().aec();
        this.mIsHost = ael().Ur();
        this.bQO = ael().adS();
        this.bRO = inflate.findViewById(com.baidu.tieba.q.friend_fragment_parent);
        if (this.mIsHost && !this.bQO) {
            this.awb = ael().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.t.edit));
            this.awb.setOnClickListener(new ab(this));
            this.awb.setVisibility(0);
        }
        this.bRM = new ag(ael(), this.bRB.aeo(), this.mIsHost, this.bQO);
        this.bRM.iC(ael().adU());
        this.bRM.r(new ac(this));
        this.bRM.x(new ad(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.q.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.bRM);
        this.mListView.setOnItemClickListener(new ae(this));
        this.mPullView = new com.baidu.tbadk.core.view.al(ael().getPageContext());
        this.mPullView.a(new af(this));
        this.bRL = new com.baidu.tieba.person.post.z(getBaseFragmentActivity());
        this.mListView.setNextPage(this.bRL);
        this.mListView.setOnSrollToBottomListener(new x(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(com.baidu.tieba.o.ds160);
            string = String.format(getString(com.baidu.tieba.t.person_bar_no_personal_info), getString(com.baidu.tieba.t.you));
        } else {
            dimension = (int) getResources().getDimension(com.baidu.tieba.o.ds80);
            if (this.bRV == 0) {
                string = String.format(getString(com.baidu.tieba.t.person_bar_no_personal_info), ael().Uq());
            } else {
                string = getString(com.baidu.tieba.t.person_bar_no_common_info);
            }
        }
        if (this.bQO) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.ah(string, getString(com.baidu.tieba.t.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.dq(string), null);
        }
        if (this.mIsHost && ael() != null && ael().getRequestCode() != 23011) {
            Hh();
        }
        if (this.bRV == ael().Up()) {
            this.mListView.no();
        }
        return inflate;
    }

    public void eo(boolean z) {
        if (this.bRM != null) {
            this.bRM.ZG();
            if (this.bRM.aen()) {
                if (z) {
                    this.bRM.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.awb != null) {
                        this.awb.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.awb != null) {
                this.awb.setVisibility(0);
            }
            if (ael() != null && ael().getRequestCode() == 23011 && this.awb != null) {
                this.awb.setVisibility(8);
            }
        }
    }

    public ag aem() {
        return this.bRM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WS() {
        if (this.bRB != null) {
            this.bRB.a(this.mIsHost, this.bRB.getId(), this.bRP, this.pageSize);
        }
    }

    public void hO(int i) {
        if (this.bRB != null) {
            this.bRB.a(this.mIsHost, this.bRB.getId(), i, this.pageSize);
        }
    }

    public void Hh() {
        if (this.bRB != null) {
            this.bRB.Hh();
        }
    }

    public void a(u uVar, boolean z) {
        if (uVar != null) {
            this.hasMore = uVar.isHasMore();
            if (!z) {
                this.mListView.completePullRefresh();
            }
            int adT = ael().adT();
            int i = 0;
            if (this.bRB != null && this.bRM != null) {
                if (this.bRV == ael().Up()) {
                    if (z) {
                        this.bRP = 1;
                        this.bRB.aeo().b(uVar.aef(), uVar.aeg());
                        this.bRB.aeo().e(uVar.aeh(), uVar.aei());
                        this.bRB.aeo().hK(uVar.aed());
                        this.bRB.aeo().hM(uVar.aee());
                    } else if (this.bRP == 1) {
                        this.bRB.aeo().b(uVar.aef(), uVar.aeg());
                        this.bRB.aeo().e(uVar.aeh(), uVar.aei());
                        this.bRB.aeo().hK(uVar.aed());
                        this.bRB.aeo().hM(uVar.aee());
                        this.bRP++;
                    } else {
                        this.bRB.aeo().c(uVar.aef(), uVar.aeg());
                        this.bRB.aeo().d(uVar.aeh(), uVar.aei());
                        this.bRB.aeo().hL(uVar.aed());
                        this.bRB.aeo().hN(uVar.aee());
                        this.bRP++;
                    }
                }
                if (this.bRV == 0) {
                    this.bRM.L(this.bRB.aeo().aej());
                } else {
                    this.bRM.L(this.bRB.aeo().aek());
                }
                if (uVar.aek() != null) {
                    i = this.bRB.aeo().aek().size();
                }
                if (ael() != null) {
                    ael().T(adT, i);
                }
                eo(true);
                this.bRM.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bRO != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ab(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.bRO);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ay.i(this.mNoDataView, com.baidu.tieba.n.cp_bg_line_d);
            }
            if (ael() != null) {
                ael().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cy(i);
            }
            if (this.bRM != null) {
                this.bRM.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removalDuplicate() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.rQ.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }
}
