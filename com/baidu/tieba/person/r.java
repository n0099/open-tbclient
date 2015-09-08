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
    private ad cjb;
    private String cjs;
    private TextView cju;
    public BdListView mListView = null;
    public u.a cjl = null;
    private ac cjm = null;
    private int bXD = -1;
    private String cjn = null;
    private View cjo = null;
    private com.baidu.tbadk.core.view.u mNoDataView = null;
    private com.baidu.tbadk.core.view.z mPullView = null;
    private TextView aFc = null;
    public int cjp = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData cjq = null;
    private boolean cjr = false;
    private View cjt = null;
    private int cjv = 0;
    private boolean mIsHost = true;
    private boolean cjw = false;
    private boolean cim = false;
    private boolean cjx = false;
    private ArrayList<ForumData> rK = new ArrayList<>();
    private final com.baidu.adp.framework.listener.e cjy = new s(this, 107129);
    private final CustomMessageListener cjz = new u(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener cjA = new v(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener cjB = new w(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, bw.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity agt() {
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
        registerListener(this.cjB);
        registerListener(this.cjA);
        registerListener(this.cjz);
        registerListener(this.cjy);
        this.cjy.setSelfListener(true);
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
        if (this.cjm != null) {
            this.cjm = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cjA);
        MessageManager.getInstance().unRegisterListener(this.cjB);
        MessageManager.getInstance().unRegisterListener(this.cjz);
        MessageManager.getInstance().unRegisterListener(this.cjy);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.cjv = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.cjt = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.friend_fragment_header, (ViewGroup) null);
        this.cju = (TextView) this.cjt.findViewById(i.f.header_text_describe);
        if (agt() == null) {
            return inflate;
        }
        this.cjs = getString(i.h.person_bar_no_more);
        this.cjb = agt().agk();
        this.mIsHost = agt().Wb();
        this.cim = agt().aga();
        this.cjo = inflate.findViewById(i.f.friend_fragment_parent);
        if (this.mIsHost && !this.cim) {
            this.aFc = agt().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(i.h.edit));
            this.aFc.setOnClickListener(new x(this));
            this.aFc.setVisibility(0);
        }
        this.cjm = new ac(agt(), this.cjb.agw(), this.mIsHost, this.cim);
        this.cjm.jE(agt().agc());
        this.cjm.w(new y(this));
        this.cjm.D(new z(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.cjm);
        this.mListView.setOnItemClickListener(new aa(this));
        this.mPullView = new com.baidu.tbadk.core.view.z(agt().getPageContext());
        this.mPullView.a(new ab(this));
        this.cjl = new u.a(getBaseFragmentActivity());
        this.mListView.setNextPage(this.cjl);
        this.mListView.setOnSrollToBottomListener(new t(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(i.d.ds160);
            string = String.format(getString(i.h.person_bar_no_personal_info), getString(i.h.you));
        } else {
            dimension = (int) getResources().getDimension(i.d.ds80);
            if (this.cjv == 0) {
                string = String.format(getString(i.h.person_bar_no_personal_info), agt().Wa());
            } else {
                string = getString(i.h.person_bar_no_common_info);
            }
        }
        if (this.cim) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ah(string, getString(i.h.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dy(string), null);
        }
        if (this.mIsHost && agt() != null && agt().getRequestCode() != 23011) {
            HL();
        }
        if (this.cjv == agt().VZ()) {
            this.mListView.nv();
        }
        return inflate;
    }

    public void eP(boolean z) {
        if (this.cjm != null) {
            this.cjm.acf();
            if (this.cjm.agv()) {
                if (z) {
                    this.cjm.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.aFc != null) {
                        this.aFc.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.aFc != null) {
                this.aFc.setVisibility(0);
            }
            if (agt() != null && agt().getRequestCode() == 23011 && this.aFc != null) {
                this.aFc.setVisibility(8);
            }
        }
    }

    public ac agu() {
        return this.cjm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kt() {
        if (this.cjb != null) {
            this.cjb.a(this.mIsHost, this.cjb.getId(), this.cjp, this.pageSize);
        }
    }

    public void gQ(int i) {
        if (this.cjb != null) {
            this.cjb.a(this.mIsHost, this.cjb.getId(), i, this.pageSize);
        }
    }

    public void HL() {
        if (this.cjb != null) {
            this.cjb.HL();
        }
    }

    public void a(q qVar, boolean z) {
        if (qVar != null) {
            this.hasMore = qVar.isHasMore();
            if (!z) {
                this.mListView.completePullRefresh();
            }
            int agb = agt().agb();
            int i = 0;
            if (this.cjb != null && this.cjm != null) {
                if (this.cjv == agt().VZ()) {
                    if (z) {
                        this.cjp = 1;
                        this.cjb.agw().b(qVar.agn(), qVar.ago());
                        this.cjb.agw().e(qVar.agp(), qVar.agq());
                        this.cjb.agw().iQ(qVar.agl());
                        this.cjb.agw().iS(qVar.agm());
                    } else if (this.cjp == 1) {
                        this.cjb.agw().b(qVar.agn(), qVar.ago());
                        this.cjb.agw().e(qVar.agp(), qVar.agq());
                        this.cjb.agw().iQ(qVar.agl());
                        this.cjb.agw().iS(qVar.agm());
                        this.cjp++;
                    } else {
                        this.cjb.agw().c(qVar.agn(), qVar.ago());
                        this.cjb.agw().d(qVar.agp(), qVar.agq());
                        this.cjb.agw().iR(qVar.agl());
                        this.cjb.agw().iT(qVar.agm());
                        this.cjp++;
                    }
                }
                if (this.cjv == 0) {
                    this.cjm.R(this.cjb.agw().agr());
                } else {
                    this.cjm.R(this.cjb.agw().ags());
                }
                if (qVar.ags() != null) {
                    i = this.cjb.agw().ags().size();
                }
                if (agt() != null) {
                    agt().ag(agb, i);
                }
                eP(true);
                this.cjm.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cjo != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ad(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cjo);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.al.h(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (agt() != null) {
                agt().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cM(i);
            }
            if (this.cjm != null) {
                this.cjm.notifyDataSetChanged();
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
