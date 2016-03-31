package com.baidu.tieba.person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ae drS;
    private String dsj;
    private TextView dsl;
    public BdListView Je = null;
    public a dsc = null;
    private ad dsd = null;
    private int cYb = -1;
    private String dse = null;
    private View dsf = null;
    private com.baidu.tbadk.core.view.p mNoDataView = null;
    private com.baidu.tbadk.core.view.u mPullView = null;
    private TextView aLH = null;
    public int dsg = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData dsh = null;
    private boolean dsi = false;
    private View dsk = null;
    private boolean cLw = false;
    private int mPageType = 0;
    private boolean bIP = true;
    private boolean dsm = false;
    private boolean dqW = false;
    private boolean dsn = false;
    private ArrayList<ForumData> list = new ArrayList<>();
    private int dso = t.d.navi_op_text;
    private final com.baidu.adp.framework.listener.e dsp = new t(this, 107129);
    private final CustomMessageListener dsq = new v(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener dsr = new w(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener dss = new x(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, bz.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aBf() {
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
        registerListener(this.dss);
        registerListener(this.dsr);
        registerListener(this.dsq);
        registerListener(this.dsp);
        this.dsp.setSelfListener(true);
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
        if (this.dsd != null) {
            this.dsd = null;
        }
        MessageManager.getInstance().unRegisterListener(this.dsr);
        MessageManager.getInstance().unRegisterListener(this.dss);
        MessageManager.getInstance().unRegisterListener(this.dsq);
        MessageManager.getInstance().unRegisterListener(this.dsp);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.mPageType = getArguments().getInt(LegoListActivityConfig.PAGE_TYPE, 0);
        View inflate = layoutInflater.inflate(t.h.friend_fragment, viewGroup, false);
        this.dsk = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.friend_fragment_header, (ViewGroup) null);
        this.dsl = (TextView) this.dsk.findViewById(t.g.header_text_describe);
        if (aBf() == null) {
            return inflate;
        }
        this.dsj = getString(t.j.person_bar_no_more);
        this.drS = aBf().aAW();
        this.bIP = aBf().ahG();
        this.dqW = aBf().aAM();
        this.dsf = inflate.findViewById(t.g.friend_fragment_parent);
        if (this.bIP && !this.dqW) {
            this.aLH = (TextView) aBf().aAH().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, aBf()).findViewById(t.g.right_textview);
            this.aLH.setText(t.j.edit);
            this.aLH.setOnClickListener(new y(this));
            this.aLH.setVisibility(0);
        }
        this.dsd = new ad(aBf(), this.drS.aBj(), this.bIP, this.dqW);
        this.dsd.mm(aBf().aAO());
        this.dsd.H(new z(this));
        this.dsd.O(new aa(this));
        this.Je = (BdListView) inflate.findViewById(t.g.my_friend_list);
        this.Je.setAdapter((ListAdapter) this.dsd);
        this.Je.setOnItemClickListener(new ab(this));
        this.mPullView = new com.baidu.tbadk.core.view.u(aBf().getPageContext());
        this.mPullView.a(new ac(this));
        this.dsc = new a(getBaseFragmentActivity());
        this.Je.setNextPage(this.dsc);
        this.Je.setOnSrollToBottomListener(new u(this));
        this.Je.setPullRefresh(this.mPullView);
        if (this.bIP) {
            dimension = (int) getResources().getDimension(t.e.ds160);
            string = String.format(getString(t.j.person_bar_no_personal_info), getString(t.j.you));
        } else {
            dimension = (int) getResources().getDimension(t.e.ds80);
            if (this.mPageType == 0) {
                string = String.format(getString(t.j.person_bar_no_personal_info), aBf().ahF());
            } else {
                string = getString(t.j.person_bar_no_common_info);
            }
        }
        if (this.dqW) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.ag(string, getString(t.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.d.dS(string), null);
        }
        if (this.bIP && aBf() != null && aBf().getRequestCode() != 23011) {
            aBh();
        }
        if (this.mPageType == aBf().ahE()) {
            this.Je.nk();
        }
        return inflate;
    }

    public void gE(boolean z) {
        if (this.dsd != null) {
            this.dsd.aug();
            if (this.dsd.aBi()) {
                if (z) {
                    this.dsd.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.Je.setVisibility(0);
                    if (this.aLH != null) {
                        this.aLH.setVisibility(8);
                    }
                    if (this.dsc != null && this.dsc.getView() != null) {
                        this.dsc.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.Je.setVisibility(0);
            if (this.aLH != null) {
                this.aLH.setVisibility(0);
            }
            if (aBf() != null && aBf().getRequestCode() == 23011 && this.aLH != null) {
                this.aLH.setVisibility(8);
            }
        }
    }

    public ad aBg() {
        return this.dsd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PW() {
        if (this.drS != null) {
            this.drS.a(this.bIP, this.drS.getId(), this.dsg, this.pageSize);
        }
    }

    public void jz(int i) {
        if (this.drS != null) {
            this.drS.a(this.bIP, this.drS.getId(), i, this.pageSize);
        }
    }

    public void aBh() {
        if (this.drS != null) {
            this.drS.aBh();
        }
    }

    public void a(r rVar, boolean z) {
        if (rVar != null) {
            this.hasMore = rVar.isHasMore();
            if (!z) {
                this.Je.nj();
            }
            int aAN = aBf().aAN();
            int i = 0;
            if (this.drS != null && this.dsd != null) {
                if (this.mPageType == aBf().ahE()) {
                    if (z) {
                        this.dsg = 1;
                        this.drS.aBj().b(rVar.aAZ(), rVar.aBa());
                        this.drS.aBj().e(rVar.aBb(), rVar.aBc());
                        this.drS.aBj().mu(rVar.aAX());
                        this.drS.aBj().mw(rVar.aAY());
                    } else if (this.dsg == 1) {
                        this.drS.aBj().b(rVar.aAZ(), rVar.aBa());
                        this.drS.aBj().e(rVar.aBb(), rVar.aBc());
                        this.drS.aBj().mu(rVar.aAX());
                        this.drS.aBj().mw(rVar.aAY());
                        this.dsg++;
                    } else {
                        this.drS.aBj().c(rVar.aAZ(), rVar.aBa());
                        this.drS.aBj().d(rVar.aBb(), rVar.aBc());
                        this.drS.aBj().mv(rVar.aAX());
                        this.drS.aBj().mx(rVar.aAY());
                        this.dsg++;
                    }
                }
                if (this.mPageType == 0) {
                    this.dsd.Z(this.drS.aBj().aBd());
                } else {
                    this.dsd.Z(this.drS.aBj().aBe());
                }
                if (rVar.aBe() != null) {
                    i = this.drS.aBj().aBe().size();
                }
                if (aBf() != null) {
                    aBf().av(aAN, i);
                }
                gE(true);
                this.dsd.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dsf != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ab(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().x(this.dsf);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.at.k(this.mNoDataView, t.d.cp_bg_line_d);
            }
            if (aBf() != null) {
                aBf().aAH().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.dj(i);
            }
            if (this.dsd != null) {
                this.dsd.notifyDataSetChanged();
            }
            if (this.dsc != null) {
                this.dsc.dj(i);
            }
            com.baidu.tbadk.core.util.at.b(this.aLH, this.dso, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UI() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.list.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private View aAj;
        private BaseFragmentActivity aNm;
        private int bgColor = t.d.cp_bg_line_d;
        private TextView WY = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View PL = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aNm = null;
            this.aNm = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View mZ() {
            this.PL = LayoutInflater.from(this.aNm.getPageContext().getContext()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
            this.PL.setPadding(0, this.aNm.getResources().getDimensionPixelSize(t.e.listview_item_margin), 0, this.aNm.getResources().getDimensionPixelSize(t.e.listview_item_margin));
            this.WY = (TextView) this.PL.findViewById(t.g.pb_more_text);
            this.aAj = this.PL.findViewById(t.g.pb_more_view);
            com.baidu.tbadk.core.util.at.l(this.PL, this.bgColor);
            com.baidu.tbadk.core.util.at.l(this.aAj, this.bgColor);
            this.aAj.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.PL.findViewById(t.g.progress);
            em(TbadkCoreApplication.m411getInst().getSkinType());
            this.aAj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.PL;
        }

        public void em(int i) {
            this.aNm.getLayoutMode().x(this.aAj);
        }

        public void dj(int i) {
            com.baidu.tbadk.core.util.at.d(this.PL, this.bgColor, i);
            com.baidu.tbadk.core.util.at.d(this.aAj, this.bgColor, i);
        }

        public void PQ() {
            this.mProgressBar.setVisibility(0);
            this.WY.setText(this.aNm.getPageContext().getPageActivity().getText(t.j.loading));
            this.aAj.setVisibility(0);
        }

        public void j(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.WY != null) {
                if (!z) {
                    this.aAj.setVisibility(0);
                    this.WY.setText(str);
                    return;
                }
                this.aAj.setVisibility(8);
            }
        }

        public void ml(String str) {
            j(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.PL);
            }
        }
    }
}
