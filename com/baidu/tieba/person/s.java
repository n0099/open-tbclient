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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private String dvF;
    private TextView dvH;
    private af dvo;
    public BdListView zu = null;
    public a dvy = null;
    private ae dvz = null;
    private int dar = -1;
    private String dvA = null;
    private View dvB = null;
    private com.baidu.tbadk.core.view.q mNoDataView = null;
    private com.baidu.tbadk.core.view.w mPullView = null;
    private TextView aHS = null;
    public int dvC = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData dvD = null;
    private boolean dvE = false;
    private View dvG = null;
    private boolean cMs = false;
    private int mPageType = 0;
    private boolean bIW = true;
    private boolean dvI = false;
    private boolean dur = false;
    private boolean dvJ = false;
    private ArrayList<ForumData> hS = new ArrayList<>();
    private int dvK = t.d.navi_op_text;
    private final com.baidu.adp.framework.listener.e dvL = new t(this, 107129);
    private final CustomMessageListener dvM = new w(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener dvN = new x(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener dvO = new y(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, bp.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aBF() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonBarActivity) {
            return (PersonBarActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.dvO);
        registerListener(this.dvN);
        registerListener(this.dvM);
        registerListener(this.dvL);
        this.dvL.setSelfListener(true);
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
        if (this.dvz != null) {
            this.dvz = null;
        }
        MessageManager.getInstance().unRegisterListener(this.dvN);
        MessageManager.getInstance().unRegisterListener(this.dvO);
        MessageManager.getInstance().unRegisterListener(this.dvM);
        MessageManager.getInstance().unRegisterListener(this.dvL);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        String string;
        this.mPageType = getArguments().getInt(LegoListActivityConfig.PAGE_TYPE, 0);
        View inflate = layoutInflater.inflate(t.h.friend_fragment, viewGroup, false);
        this.dvG = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.friend_fragment_header, (ViewGroup) null);
        this.dvH = (TextView) this.dvG.findViewById(t.g.header_text_describe);
        if (aBF() == null) {
            return inflate;
        }
        this.dvF = getString(t.j.person_bar_no_more);
        this.dvo = aBF().aBw();
        this.bIW = aBF().ahP();
        this.dur = aBF().aBm();
        this.dvB = inflate.findViewById(t.g.friend_fragment_parent);
        if (this.bIW && !this.dur) {
            this.aHS = (TextView) aBF().Rf().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, aBF()).findViewById(t.g.right_textview);
            this.aHS.postDelayed(new z(this), 100L);
            this.aHS.setText(t.j.edit);
            this.aHS.setOnClickListener(new aa(this));
            this.aHS.setVisibility(0);
        }
        this.dvz = new ae(aBF(), this.dvo.aBI(), this.bIW, this.dur);
        this.dvz.mq(aBF().aBo());
        this.dvz.D(new ab(this));
        this.dvz.K(new ac(this));
        this.zu = (BdListView) inflate.findViewById(t.g.my_friend_list);
        this.zu.setAdapter((ListAdapter) this.dvz);
        this.zu.setOnItemClickListener(new ad(this));
        this.mPullView = new com.baidu.tbadk.core.view.w(aBF().getPageContext());
        this.mPullView.a(new u(this));
        this.dvy = new a(getBaseFragmentActivity());
        this.zu.setNextPage(this.dvy);
        this.zu.setOnSrollToBottomListener(new v(this));
        this.zu.setPullRefresh(this.mPullView);
        if (this.bIW) {
            BdListViewHelper.a(getActivity(), this.zu, BdListViewHelper.HeadType.DEFAULT);
            i = com.baidu.adp.lib.util.k.c(getActivity(), t.e.ds220);
            string = String.format(getString(t.j.person_bar_no_personal_info), getString(t.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.zu, BdListViewHelper.HeadType.HASTAB);
            i = BdListViewHelper.azU;
            if (this.mPageType == 0) {
                string = String.format(getString(t.j.person_bar_no_personal_info), aBF().ahO());
            } else {
                string = getString(t.j.person_bar_no_common_info);
            }
        }
        if (this.dur) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, i), NoDataViewFactory.d.ag(string, getString(t.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, i), NoDataViewFactory.d.dP(string), null);
        }
        if (this.bIW && aBF() != null && aBF().getRequestCode() != 23011) {
            asa();
        }
        if (this.mPageType == aBF().ahN()) {
            this.zu.jy();
        }
        return inflate;
    }

    public void hk(boolean z) {
        if (this.dvz != null) {
            this.dvz.atS();
            if (this.dvz.aBH()) {
                if (z) {
                    this.dvz.setEditState(false);
                    hl(true);
                    this.zu.setVisibility(0);
                    if (this.aHS != null) {
                        this.aHS.setVisibility(8);
                    }
                    if (this.dvy != null && this.dvy.getView() != null) {
                        this.dvy.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            hl(false);
            this.zu.setVisibility(0);
            if (this.aHS != null) {
                this.aHS.setVisibility(0);
            }
            if (aBF() != null && aBF().getRequestCode() == 23011 && this.aHS != null) {
                this.aHS.setVisibility(8);
            }
        }
    }

    public ae aBG() {
        return this.dvz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OR() {
        if (this.dvo != null) {
            this.dvo.a(this.bIW, this.dvo.getId(), this.dvC, this.pageSize);
        }
    }

    public void jc(int i) {
        if (this.dvo != null) {
            this.dvo.a(this.bIW, this.dvo.getId(), i, this.pageSize);
        }
    }

    public void asa() {
        if (this.dvo != null) {
            this.dvo.asa();
        }
    }

    public void a(r rVar, boolean z) {
        if (rVar != null) {
            this.hasMore = rVar.isHasMore();
            if (!z) {
                this.zu.k(2000L);
            }
            int aBn = aBF().aBn();
            int i = 0;
            if (this.dvo != null && this.dvz != null) {
                if (this.mPageType == aBF().ahN()) {
                    if (z) {
                        this.dvC = 1;
                        this.dvo.aBI().b(rVar.aBz(), rVar.aBA());
                        this.dvo.aBI().e(rVar.aBB(), rVar.aBC());
                        this.dvo.aBI().mk(rVar.aBx());
                        this.dvo.aBI().mm(rVar.aBy());
                    } else if (this.dvC == 1) {
                        this.dvo.aBI().b(rVar.aBz(), rVar.aBA());
                        this.dvo.aBI().e(rVar.aBB(), rVar.aBC());
                        this.dvo.aBI().mk(rVar.aBx());
                        this.dvo.aBI().mm(rVar.aBy());
                        this.dvC++;
                    } else {
                        this.dvo.aBI().c(rVar.aBz(), rVar.aBA());
                        this.dvo.aBI().d(rVar.aBB(), rVar.aBC());
                        this.dvo.aBI().ml(rVar.aBx());
                        this.dvo.aBI().mn(rVar.aBy());
                        this.dvC++;
                    }
                }
                if (this.mPageType == 0) {
                    this.dvz.ab(this.dvo.aBI().aBD());
                } else {
                    this.dvz.ab(this.dvo.aBI().aBE());
                }
                if (rVar.aBE() != null) {
                    i = this.dvo.aBI().aBE().size();
                }
                if (aBF() != null) {
                    aBF().au(aBn, i);
                }
                hk(true);
                this.dvz.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.dvB != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ae(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().x(this.dvB);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                com.baidu.tbadk.core.util.at.k(this.mNoDataView, t.d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (aBF() != null) {
                aBF().Rf().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cR(i);
            }
            if (this.dvz != null) {
                this.dvz.notifyDataSetChanged();
            }
            if (this.dvy != null) {
                this.dvy.cR(i);
            }
            com.baidu.tbadk.core.util.at.b(this.aHS, this.dvK, t.d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UJ() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.hS.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aJw;
        private View awm;
        private int bgColor = t.d.cp_bg_line_d;
        private TextView Sm = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View KB = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aJw = null;
            this.aJw = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View jn() {
            this.KB = LayoutInflater.from(this.aJw.getPageContext().getContext()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
            this.KB.setPadding(0, this.aJw.getResources().getDimensionPixelSize(t.e.listview_item_margin), 0, this.aJw.getResources().getDimensionPixelSize(t.e.listview_item_margin));
            this.Sm = (TextView) this.KB.findViewById(t.g.pb_more_text);
            this.awm = this.KB.findViewById(t.g.pb_more_view);
            com.baidu.tbadk.core.util.at.l(this.KB, this.bgColor);
            com.baidu.tbadk.core.util.at.l(this.awm, this.bgColor);
            this.awm.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.KB.findViewById(t.g.progress);
            dR(TbadkCoreApplication.m11getInst().getSkinType());
            this.awm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.KB;
        }

        public void dR(int i) {
            this.aJw.getLayoutMode().x(this.awm);
        }

        public void cR(int i) {
            com.baidu.tbadk.core.util.at.e(this.KB, this.bgColor, i);
            com.baidu.tbadk.core.util.at.e(this.awm, this.bgColor, i);
        }

        public void OL() {
            this.mProgressBar.setVisibility(0);
            this.Sm.setText(this.aJw.getPageContext().getPageActivity().getText(t.j.loading));
            this.awm.setVisibility(0);
        }

        public void k(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.Sm != null) {
                if (!z) {
                    this.awm.setVisibility(0);
                    this.Sm.setText(str);
                    return;
                }
                this.awm.setVisibility(8);
            }
        }

        public void mp(String str) {
            k(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.KB);
            }
        }
    }

    private void hl(boolean z) {
        if (z) {
            if (this.zu != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.zu.removeHeaderView(this.mNoDataView);
                this.zu.addHeaderView(this.mNoDataView);
            }
        } else if (this.zu != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.zu.removeHeaderView(this.mNoDataView);
        }
    }
}
