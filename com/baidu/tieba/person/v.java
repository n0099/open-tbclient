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
    private ai bRC;
    private String bRT;
    private TextView bRV;
    public BdListView mListView = null;
    public com.baidu.tieba.person.post.z bRM = null;
    private ag bRN = null;
    private int bGT = -1;
    private String bRO = null;
    private View bRP = null;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private com.baidu.tbadk.core.view.al mPullView = null;
    private TextView awc = null;
    public int bRQ = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData bRR = null;
    private boolean bRS = false;
    private View bRU = null;
    private int bRW = 0;
    private boolean mIsHost = true;
    private boolean bQP = false;
    private boolean bRX = false;
    private ArrayList<ForumData> rQ = new ArrayList<>();
    private final com.baidu.adp.framework.listener.e bRY = new w(this, 107129);
    private final CustomMessageListener bRZ = new y(this, 2001187);
    private HttpMessageListener bSa = new z(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener bSb = new aa(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001187, ci.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aem() {
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
        registerListener(this.bSb);
        registerListener(this.bSa);
        registerListener(this.bRZ);
        registerListener(this.bRY);
        this.bRY.setSelfListener(true);
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
        if (this.bRN != null) {
            this.bRN = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bSa);
        MessageManager.getInstance().unRegisterListener(this.bSb);
        MessageManager.getInstance().unRegisterListener(this.bRZ);
        MessageManager.getInstance().unRegisterListener(this.bRY);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.bRW = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.r.friend_fragment, viewGroup, false);
        this.bRU = com.baidu.adp.lib.g.b.hr().inflate(getActivity().getBaseContext(), com.baidu.tieba.r.friend_fragment_header, null);
        this.bRV = (TextView) this.bRU.findViewById(com.baidu.tieba.q.header_text_describe);
        if (aem() == null) {
            return inflate;
        }
        this.bRT = getString(com.baidu.tieba.t.person_bar_no_more);
        this.bRC = aem().aed();
        this.mIsHost = aem().Us();
        this.bQP = aem().adT();
        this.bRP = inflate.findViewById(com.baidu.tieba.q.friend_fragment_parent);
        if (this.mIsHost && !this.bQP) {
            this.awc = aem().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.t.edit));
            this.awc.setOnClickListener(new ab(this));
            this.awc.setVisibility(0);
        }
        this.bRN = new ag(aem(), this.bRC.aep(), this.mIsHost, this.bQP);
        this.bRN.iC(aem().adV());
        this.bRN.r(new ac(this));
        this.bRN.x(new ad(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.q.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.bRN);
        this.mListView.setOnItemClickListener(new ae(this));
        this.mPullView = new com.baidu.tbadk.core.view.al(aem().getPageContext());
        this.mPullView.a(new af(this));
        this.bRM = new com.baidu.tieba.person.post.z(getBaseFragmentActivity());
        this.mListView.setNextPage(this.bRM);
        this.mListView.setOnSrollToBottomListener(new x(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(com.baidu.tieba.o.ds160);
            string = String.format(getString(com.baidu.tieba.t.person_bar_no_personal_info), getString(com.baidu.tieba.t.you));
        } else {
            dimension = (int) getResources().getDimension(com.baidu.tieba.o.ds80);
            if (this.bRW == 0) {
                string = String.format(getString(com.baidu.tieba.t.person_bar_no_personal_info), aem().Ur());
            } else {
                string = getString(com.baidu.tieba.t.person_bar_no_common_info);
            }
        }
        if (this.bQP) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.ah(string, getString(com.baidu.tieba.t.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.ab.dq(string), null);
        }
        if (this.mIsHost && aem() != null && aem().getRequestCode() != 23011) {
            Hi();
        }
        if (this.bRW == aem().Uq()) {
            this.mListView.no();
        }
        return inflate;
    }

    public void eo(boolean z) {
        if (this.bRN != null) {
            this.bRN.ZH();
            if (this.bRN.aeo()) {
                if (z) {
                    this.bRN.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.awc != null) {
                        this.awc.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.awc != null) {
                this.awc.setVisibility(0);
            }
            if (aem() != null && aem().getRequestCode() == 23011 && this.awc != null) {
                this.awc.setVisibility(8);
            }
        }
    }

    public ag aen() {
        return this.bRN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WT() {
        if (this.bRC != null) {
            this.bRC.a(this.mIsHost, this.bRC.getId(), this.bRQ, this.pageSize);
        }
    }

    public void hO(int i) {
        if (this.bRC != null) {
            this.bRC.a(this.mIsHost, this.bRC.getId(), i, this.pageSize);
        }
    }

    public void Hi() {
        if (this.bRC != null) {
            this.bRC.Hi();
        }
    }

    public void a(u uVar, boolean z) {
        if (uVar != null) {
            this.hasMore = uVar.isHasMore();
            if (!z) {
                this.mListView.completePullRefresh();
            }
            int adU = aem().adU();
            int i = 0;
            if (this.bRC != null && this.bRN != null) {
                if (this.bRW == aem().Uq()) {
                    if (z) {
                        this.bRQ = 1;
                        this.bRC.aep().b(uVar.aeg(), uVar.aeh());
                        this.bRC.aep().e(uVar.aei(), uVar.aej());
                        this.bRC.aep().hK(uVar.aee());
                        this.bRC.aep().hM(uVar.aef());
                    } else if (this.bRQ == 1) {
                        this.bRC.aep().b(uVar.aeg(), uVar.aeh());
                        this.bRC.aep().e(uVar.aei(), uVar.aej());
                        this.bRC.aep().hK(uVar.aee());
                        this.bRC.aep().hM(uVar.aef());
                        this.bRQ++;
                    } else {
                        this.bRC.aep().c(uVar.aeg(), uVar.aeh());
                        this.bRC.aep().d(uVar.aei(), uVar.aej());
                        this.bRC.aep().hL(uVar.aee());
                        this.bRC.aep().hN(uVar.aef());
                        this.bRQ++;
                    }
                }
                if (this.bRW == 0) {
                    this.bRN.L(this.bRC.aep().aek());
                } else {
                    this.bRN.L(this.bRC.aep().ael());
                }
                if (uVar.ael() != null) {
                    i = this.bRC.aep().ael().size();
                }
                if (aem() != null) {
                    aem().T(adU, i);
                }
                eo(true);
                this.bRN.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bRP != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ab(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.bRP);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ay.i(this.mNoDataView, com.baidu.tieba.n.cp_bg_line_d);
            }
            if (aem() != null) {
                aem().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cy(i);
            }
            if (this.bRN != null) {
                this.bRN.notifyDataSetChanged();
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
