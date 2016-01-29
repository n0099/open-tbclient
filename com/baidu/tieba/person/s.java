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
import com.baidu.tieba.person.post.v;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String cXH;
    private TextView cXJ;
    private ae cXq;
    public BdListView IY = null;
    public v.a cXA = null;
    private ad cXB = null;
    private int cEJ = -1;
    private String cXC = null;
    private View cXD = null;
    private com.baidu.tbadk.core.view.o mNoDataView = null;
    private com.baidu.tbadk.core.view.t mPullView = null;
    private TextView aIL = null;
    public int cXE = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData cXF = null;
    private boolean cXG = false;
    private View cXI = null;
    private boolean cwB = false;
    private int mPageType = 0;
    private boolean bDs = true;
    private boolean cXK = false;
    private boolean cWu = false;
    private boolean cXL = false;
    private ArrayList<ForumData> rV = new ArrayList<>();
    private int cXM = t.d.navi_op_text;
    private final com.baidu.adp.framework.listener.e cXN = new t(this, 107129);
    private final CustomMessageListener cXO = new v(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener cXP = new w(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener cXQ = new x(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, bz.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity atz() {
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
        registerListener(this.cXQ);
        registerListener(this.cXP);
        registerListener(this.cXO);
        registerListener(this.cXN);
        this.cXN.setSelfListener(true);
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
        if (this.cXB != null) {
            this.cXB = null;
        }
        MessageManager.getInstance().unRegisterListener(this.cXP);
        MessageManager.getInstance().unRegisterListener(this.cXQ);
        MessageManager.getInstance().unRegisterListener(this.cXO);
        MessageManager.getInstance().unRegisterListener(this.cXN);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(t.h.friend_fragment, viewGroup, false);
        this.cXI = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.friend_fragment_header, (ViewGroup) null);
        this.cXJ = (TextView) this.cXI.findViewById(t.g.header_text_describe);
        if (atz() == null) {
            return inflate;
        }
        this.cXH = getString(t.j.person_bar_no_more);
        this.cXq = atz().atq();
        this.bDs = atz().aen();
        this.cWu = atz().atg();
        this.cXD = inflate.findViewById(t.g.friend_fragment_parent);
        if (this.bDs && !this.cWu) {
            this.aIL = (TextView) atz().atb().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, atz()).findViewById(t.g.right_textview);
            this.aIL.setText(t.j.edit);
            this.aIL.setOnClickListener(new y(this));
            this.aIL.setVisibility(0);
        }
        this.cXB = new ad(atz(), this.cXq.atD(), this.bDs, this.cWu);
        this.cXB.kX(atz().ati());
        this.cXB.D(new z(this));
        this.cXB.K(new aa(this));
        this.IY = (BdListView) inflate.findViewById(t.g.my_friend_list);
        this.IY.setAdapter((ListAdapter) this.cXB);
        this.IY.setOnItemClickListener(new ab(this));
        this.mPullView = new com.baidu.tbadk.core.view.t(atz().getPageContext());
        this.mPullView.a(new ac(this));
        this.cXA = new v.a(getBaseFragmentActivity());
        this.IY.setNextPage(this.cXA);
        this.IY.setOnSrollToBottomListener(new u(this));
        this.IY.setPullRefresh(this.mPullView);
        if (this.bDs) {
            dimension = (int) getResources().getDimension(t.e.ds160);
            string = String.format(getString(t.j.person_bar_no_personal_info), getString(t.j.you));
        } else {
            dimension = (int) getResources().getDimension(t.e.ds80);
            if (this.mPageType == 0) {
                string = String.format(getString(t.j.person_bar_no_personal_info), atz().aem());
            } else {
                string = getString(t.j.person_bar_no_common_info);
            }
        }
        if (this.cWu) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ac(string, getString(t.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dM(string), null);
        }
        if (this.bDs && atz() != null && atz().getRequestCode() != 23011) {
            atB();
        }
        if (this.mPageType == atz().ael()) {
            this.IY.ns();
        }
        return inflate;
    }

    public void fR(boolean z) {
        if (this.cXB != null) {
            this.cXB.ann();
            if (this.cXB.atC()) {
                if (z) {
                    this.cXB.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.IY.setVisibility(0);
                    if (this.aIL != null) {
                        this.aIL.setVisibility(8);
                    }
                    if (this.cXA != null && this.cXA.getView() != null) {
                        this.cXA.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.IY.setVisibility(0);
            if (this.aIL != null) {
                this.aIL.setVisibility(0);
            }
            if (atz() != null && atz().getRequestCode() == 23011 && this.aIL != null) {
                this.aIL.setVisibility(8);
            }
        }
    }

    public ad atA() {
        return this.cXB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        if (this.cXq != null) {
            this.cXq.a(this.bDs, this.cXq.getId(), this.cXE, this.pageSize);
        }
    }

    public void iT(int i) {
        if (this.cXq != null) {
            this.cXq.a(this.bDs, this.cXq.getId(), i, this.pageSize);
        }
    }

    public void atB() {
        if (this.cXq != null) {
            this.cXq.atB();
        }
    }

    public void a(r rVar, boolean z) {
        if (rVar != null) {
            this.hasMore = rVar.isHasMore();
            if (!z) {
                this.IY.nr();
            }
            int ath = atz().ath();
            int i = 0;
            if (this.cXq != null && this.cXB != null) {
                if (this.mPageType == atz().ael()) {
                    if (z) {
                        this.cXE = 1;
                        this.cXq.atD().b(rVar.att(), rVar.atu());
                        this.cXq.atD().e(rVar.atv(), rVar.atw());
                        this.cXq.atD().ll(rVar.atr());
                        this.cXq.atD().ln(rVar.ats());
                    } else if (this.cXE == 1) {
                        this.cXq.atD().b(rVar.att(), rVar.atu());
                        this.cXq.atD().e(rVar.atv(), rVar.atw());
                        this.cXq.atD().ll(rVar.atr());
                        this.cXq.atD().ln(rVar.ats());
                        this.cXE++;
                    } else {
                        this.cXq.atD().c(rVar.att(), rVar.atu());
                        this.cXq.atD().d(rVar.atv(), rVar.atw());
                        this.cXq.atD().lm(rVar.atr());
                        this.cXq.atD().lo(rVar.ats());
                        this.cXE++;
                    }
                }
                if (this.mPageType == 0) {
                    this.cXB.Y(this.cXq.atD().atx());
                } else {
                    this.cXB.Y(this.cXq.atD().aty());
                }
                if (rVar.aty() != null) {
                    i = this.cXq.atD().aty().size();
                }
                if (atz() != null) {
                    atz().ay(ath, i);
                }
                fR(true);
                this.cXB.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.cXD != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ac(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().x(this.cXD);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ar.k(this.mNoDataView, t.d.cp_bg_line_d);
            }
            if (atz() != null) {
                atz().atb().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.dg(i);
            }
            if (this.cXB != null) {
                this.cXB.notifyDataSetChanged();
            }
            if (this.cXA != null) {
                this.cXA.dg(i);
            }
            com.baidu.tbadk.core.util.ar.b(this.aIL, this.cXM, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SR() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.rV.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }
}
