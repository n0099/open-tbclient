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
    private String cqC;
    private TextView cqE;
    private ad cql;
    public BdListView mListView = null;
    public u.a cqv = null;
    private ac cqw = null;
    private int ccb = -1;
    private String cqx = null;
    private View cqy = null;
    private com.baidu.tbadk.core.view.m mNoDataView = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private TextView aDm = null;
    public int cqz = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData cqA = null;
    private boolean cqB = false;
    private View cqD = null;
    private int cqF = 0;
    private boolean mIsHost = true;
    private boolean cqG = false;
    private boolean cpp = false;
    private boolean cqH = false;
    private ArrayList<ForumData> rK = new ArrayList<>();
    private final com.baidu.adp.framework.listener.e cqI = new s(this, 107129);
    private final CustomMessageListener cqJ = new u(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener cqK = new v(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener cqL = new w(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, bx.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aiU() {
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
        registerListener(this.cqL);
        registerListener(this.cqK);
        registerListener(this.cqJ);
        registerListener(this.cqI);
        this.cqI.setSelfListener(true);
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
        if (this.cqw != null) {
            this.cqw = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cqK);
        MessageManager.getInstance().unRegisterListener(this.cqL);
        MessageManager.getInstance().unRegisterListener(this.cqJ);
        MessageManager.getInstance().unRegisterListener(this.cqI);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.cqF = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(i.g.friend_fragment, viewGroup, false);
        this.cqD = LayoutInflater.from(getPageContext().getPageActivity()).inflate(i.g.friend_fragment_header, (ViewGroup) null);
        this.cqE = (TextView) this.cqD.findViewById(i.f.header_text_describe);
        if (aiU() == null) {
            return inflate;
        }
        this.cqC = getString(i.h.person_bar_no_more);
        this.cql = aiU().aiL();
        this.mIsHost = aiU().Xb();
        this.cpp = aiU().aiB();
        this.cqy = inflate.findViewById(i.f.friend_fragment_parent);
        if (this.mIsHost && !this.cpp) {
            this.aDm = (TextView) aiU().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, aiU()).findViewById(i.f.right_textview);
            this.aDm.setText(i.h.edit);
            this.aDm.setOnClickListener(new x(this));
            this.aDm.setVisibility(0);
        }
        this.cqw = new ac(aiU(), this.cql.aiX(), this.mIsHost, this.cpp);
        this.cqw.kc(aiU().aiD());
        this.cqw.x(new y(this));
        this.cqw.E(new z(this));
        this.mListView = (BdListView) inflate.findViewById(i.f.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.cqw);
        this.mListView.setOnItemClickListener(new aa(this));
        this.mPullView = new com.baidu.tbadk.core.view.r(aiU().getPageContext());
        this.mPullView.a(new ab(this));
        this.cqv = new u.a(getBaseFragmentActivity());
        this.mListView.setNextPage(this.cqv);
        this.mListView.setOnSrollToBottomListener(new t(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(i.d.ds160);
            string = String.format(getString(i.h.person_bar_no_personal_info), getString(i.h.you));
        } else {
            dimension = (int) getResources().getDimension(i.d.ds80);
            if (this.cqF == 0) {
                string = String.format(getString(i.h.person_bar_no_personal_info), aiU().Xa());
            } else {
                string = getString(i.h.person_bar_no_common_info);
            }
        }
        if (this.cpp) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ag(string, getString(i.h.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dC(string), null);
        }
        if (this.mIsHost && aiU() != null && aiU().getRequestCode() != 23011) {
            Hy();
        }
        if (this.cqF == aiU().WZ()) {
            this.mListView.nx();
        }
        return inflate;
    }

    public void eY(boolean z) {
        if (this.cqw != null) {
            this.cqw.adO();
            if (this.cqw.aiW()) {
                if (z) {
                    this.cqw.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.aDm != null) {
                        this.aDm.setVisibility(8);
                    }
                    if (this.cqv != null && this.cqv.getView() != null) {
                        this.cqv.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.aDm != null) {
                this.aDm.setVisibility(0);
            }
            if (aiU() != null && aiU().getRequestCode() == 23011 && this.aDm != null) {
                this.aDm.setVisibility(8);
            }
        }
    }

    public ac aiV() {
        return this.cqw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KA() {
        if (this.cql != null) {
            this.cql.a(this.mIsHost, this.cql.getId(), this.cqz, this.pageSize);
        }
    }

    public void hj(int i) {
        if (this.cql != null) {
            this.cql.a(this.mIsHost, this.cql.getId(), i, this.pageSize);
        }
    }

    public void Hy() {
        if (this.cql != null) {
            this.cql.Hy();
        }
    }

    public void a(q qVar, boolean z) {
        if (qVar != null) {
            this.hasMore = qVar.isHasMore();
            if (!z) {
                this.mListView.completePullRefresh();
            }
            int aiC = aiU().aiC();
            int i = 0;
            if (this.cql != null && this.cqw != null) {
                if (this.cqF == aiU().WZ()) {
                    if (z) {
                        this.cqz = 1;
                        this.cql.aiX().b(qVar.aiO(), qVar.aiP());
                        this.cql.aiX().e(qVar.aiQ(), qVar.aiR());
                        this.cql.aiX().jo(qVar.aiM());
                        this.cql.aiX().jq(qVar.aiN());
                    } else if (this.cqz == 1) {
                        this.cql.aiX().b(qVar.aiO(), qVar.aiP());
                        this.cql.aiX().e(qVar.aiQ(), qVar.aiR());
                        this.cql.aiX().jo(qVar.aiM());
                        this.cql.aiX().jq(qVar.aiN());
                        this.cqz++;
                    } else {
                        this.cql.aiX().c(qVar.aiO(), qVar.aiP());
                        this.cql.aiX().d(qVar.aiQ(), qVar.aiR());
                        this.cql.aiX().jp(qVar.aiM());
                        this.cql.aiX().jr(qVar.aiN());
                        this.cqz++;
                    }
                }
                if (this.cqF == 0) {
                    this.cqw.S(this.cql.aiX().aiS());
                } else {
                    this.cqw.S(this.cql.aiX().aiT());
                }
                if (qVar.aiT() != null) {
                    i = this.cql.aiX().aiT().size();
                }
                if (aiU() != null) {
                    aiU().aj(aiC, i);
                }
                eY(true);
                this.cqw.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cqy != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ad(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.cqy);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.an.i(this.mNoDataView, i.c.cp_bg_line_d);
            }
            if (aiU() != null) {
                aiU().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cN(i);
            }
            if (this.cqw != null) {
                this.cqw.notifyDataSetChanged();
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
