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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ag edG;
    private String edX;
    private TextView edZ;
    public BdListView zt = null;
    public a edQ = null;
    private af edR = null;
    private int dGZ = -1;
    private String edS = null;
    private View edT = null;
    private com.baidu.tbadk.core.view.q mNoDataView = null;
    private com.baidu.tbadk.core.view.w mPullView = null;
    private TextView aLo = null;
    public int edU = 0;
    public int pageSize = 50;
    public boolean hasMore = false;
    private ForumData edV = null;
    private boolean edW = false;
    private View edY = null;
    private boolean dsg = false;
    private int mPageType = 0;
    private boolean cgJ = true;
    private boolean eea = false;
    private boolean ecI = false;
    private boolean eeb = false;
    private ArrayList<ForumData> hR = new ArrayList<>();
    private int eec = u.d.navi_op_text;
    private final com.baidu.adp.framework.listener.e eed = new u(this, 107129);
    private final CustomMessageListener eee = new x(this, CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    private HttpMessageListener eef = new y(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener eeg = new z(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY, bq.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity aKx() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonBarActivity) {
            return (PersonBarActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.eeg);
        registerListener(this.eef);
        registerListener(this.eee);
        registerListener(this.eed);
        this.eed.setSelfListener(true);
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
        if (this.edR != null) {
            this.edR = null;
        }
        MessageManager.getInstance().unRegisterListener(this.eef);
        MessageManager.getInstance().unRegisterListener(this.eeg);
        MessageManager.getInstance().unRegisterListener(this.eee);
        MessageManager.getInstance().unRegisterListener(this.eed);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        String string;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(u.h.friend_fragment, viewGroup, false);
        this.edY = LayoutInflater.from(getPageContext().getPageActivity()).inflate(u.h.friend_fragment_header, (ViewGroup) null);
        this.edZ = (TextView) this.edY.findViewById(u.g.header_text_describe);
        if (aKx() == null) {
            return inflate;
        }
        this.edX = getString(u.j.person_bar_no_more);
        this.edG = aKx().aKo();
        this.cgJ = aKx().aqc();
        this.ecI = aKx().aKe();
        this.edT = inflate.findViewById(u.g.friend_fragment_parent);
        if (this.cgJ && !this.ecI) {
            this.aLo = (TextView) aKx().Wz().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.navigation_right_button_layout, aKx()).findViewById(u.g.right_textview);
            this.aLo.postDelayed(new aa(this), 100L);
            this.aLo.setText(u.j.edit);
            this.aLo.setOnClickListener(new ab(this));
            this.aLo.setVisibility(0);
        }
        this.edR = new af(aKx(), this.edG.aKA(), this.cgJ, this.ecI);
        this.edR.nV(aKx().aKg());
        this.edR.D(new ac(this));
        this.edR.K(new ad(this));
        this.zt = (BdListView) inflate.findViewById(u.g.my_friend_list);
        this.zt.setAdapter((ListAdapter) this.edR);
        this.zt.setOnItemClickListener(new ae(this));
        this.mPullView = new com.baidu.tbadk.core.view.w(aKx().getPageContext());
        this.mPullView.a(new v(this));
        this.edQ = new a(getBaseFragmentActivity());
        this.zt.setNextPage(this.edQ);
        this.zt.setOnSrollToBottomListener(new w(this));
        this.zt.setPullRefresh(this.mPullView);
        if (this.cgJ) {
            BdListViewHelper.a(getActivity(), this.zt, BdListViewHelper.HeadType.DEFAULT);
            i = com.baidu.adp.lib.util.k.c(getActivity(), u.e.ds220);
            string = String.format(getString(u.j.person_bar_no_personal_info), getString(u.j.you));
        } else {
            BdListViewHelper.a(getActivity(), this.zt, BdListViewHelper.HeadType.HASTAB);
            i = BdListViewHelper.aAL;
            if (this.mPageType == 0) {
                string = String.format(getString(u.j.person_bar_no_personal_info), aKx().aqb());
            } else {
                string = getString(u.j.person_bar_no_common_info);
            }
        }
        if (this.ecI) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, i), NoDataViewFactory.d.af(string, getString(u.j.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, i), NoDataViewFactory.d.dT(string), null);
        }
        if (this.cgJ && aKx() != null && aKx().getRequestCode() != 23011) {
            OR();
        }
        if (this.mPageType == aKx().aqa()) {
            this.zt.jB();
        }
        return inflate;
    }

    /* renamed from: if  reason: not valid java name */
    public void m15if(boolean z) {
        if (this.edR != null) {
            this.edR.aBX();
            if (this.edR.aKz()) {
                if (z) {
                    this.edR.setEditState(false);
                    ig(true);
                    this.zt.setVisibility(0);
                    if (this.aLo != null) {
                        this.aLo.setVisibility(8);
                    }
                    if (this.edQ != null && this.edQ.getView() != null) {
                        this.edQ.getView().setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            ig(false);
            this.zt.setVisibility(0);
            if (this.aLo != null) {
                this.aLo.setVisibility(0);
            }
            if (aKx() != null && aKx().getRequestCode() == 23011 && this.aLo != null) {
                this.aLo.setVisibility(8);
            }
        }
    }

    public af aKy() {
        return this.edR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshData() {
        if (this.edG != null) {
            this.edG.a(this.cgJ, this.edG.getId(), this.edU, this.pageSize);
        }
    }

    public void kE(int i) {
        if (this.edG != null) {
            this.edG.a(this.cgJ, this.edG.getId(), i, this.pageSize);
        }
    }

    public void OR() {
        if (this.edG != null) {
            this.edG.OR();
        }
    }

    public void a(s sVar, boolean z) {
        if (sVar != null) {
            this.hasMore = sVar.isHasMore();
            if (!z) {
                this.zt.k(2000L);
            }
            int aKf = aKx().aKf();
            int i = 0;
            if (this.edG != null && this.edR != null) {
                if (this.mPageType == aKx().aqa()) {
                    if (z) {
                        this.edU = 1;
                        this.edG.aKA().b(sVar.aKr(), sVar.aKs());
                        this.edG.aKA().e(sVar.aKt(), sVar.aKu());
                        this.edG.aKA().nL(sVar.aKp());
                        this.edG.aKA().nN(sVar.aKq());
                    } else if (this.edU == 1) {
                        this.edG.aKA().b(sVar.aKr(), sVar.aKs());
                        this.edG.aKA().e(sVar.aKt(), sVar.aKu());
                        this.edG.aKA().nL(sVar.aKp());
                        this.edG.aKA().nN(sVar.aKq());
                        this.edU++;
                    } else {
                        this.edG.aKA().c(sVar.aKr(), sVar.aKs());
                        this.edG.aKA().d(sVar.aKt(), sVar.aKu());
                        this.edG.aKA().nM(sVar.aKp());
                        this.edG.aKA().nO(sVar.aKq());
                        this.edU++;
                    }
                }
                if (this.mPageType == 0) {
                    this.edR.am(this.edG.aKA().aKv());
                } else {
                    this.edR.am(this.edG.aKA().aKw());
                }
                if (sVar.aKw() != null) {
                    i = this.edG.aKA().aKw().size();
                }
                if (aKx() != null) {
                    aKx().aL(aKf, i);
                }
                m15if(true);
                this.edR.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.edT != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().ad(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().w(this.edT);
            }
            if (this.mNoDataView != null && getBaseFragmentActivity() != null) {
                com.baidu.tbadk.core.util.av.k(this.mNoDataView, u.d.cp_bg_line_d);
                this.mNoDataView.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (aKx() != null) {
                aKx().Wz().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.cT(i);
            }
            if (this.edR != null) {
                this.edR.notifyDataSetChanged();
            }
            if (this.edQ != null) {
                this.edQ.cT(i);
            }
            com.baidu.tbadk.core.util.av.b(this.aLo, this.eec, u.d.navi_op_text_skin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaW() {
        HashSet hashSet = new HashSet();
        Iterator<ForumData> it = this.hR.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(it.next().getId())) {
                it.remove();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.c {
        private BaseFragmentActivity aMU;
        private View axc;
        private int bgColor = u.d.cp_bg_line_d;
        private TextView SD = null;
        private ProgressBar mProgressBar = null;
        private View.OnClickListener mOnClickListener = null;
        private View KB = null;

        public a(BaseFragmentActivity baseFragmentActivity) {
            this.aMU = null;
            this.aMU = baseFragmentActivity;
        }

        @Override // com.baidu.adp.widget.ListView.c
        public View jq() {
            this.KB = LayoutInflater.from(this.aMU.getPageContext().getContext()).inflate(u.h.new_pb_list_more, (ViewGroup) null);
            this.KB.setPadding(0, this.aMU.getResources().getDimensionPixelSize(u.e.ds16), 0, this.aMU.getResources().getDimensionPixelSize(u.e.ds16));
            this.SD = (TextView) this.KB.findViewById(u.g.pb_more_text);
            this.axc = this.KB.findViewById(u.g.pb_more_view);
            com.baidu.tbadk.core.util.av.l(this.KB, this.bgColor);
            com.baidu.tbadk.core.util.av.l(this.axc, this.bgColor);
            this.axc.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.KB.findViewById(u.g.progress);
            dT(TbadkCoreApplication.m9getInst().getSkinType());
            this.axc.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.KB;
        }

        public void dT(int i) {
            this.aMU.getLayoutMode().w(this.axc);
        }

        public void cT(int i) {
            com.baidu.tbadk.core.util.av.e(this.KB, this.bgColor, i);
            com.baidu.tbadk.core.util.av.e(this.axc, this.bgColor, i);
        }

        public void Un() {
            this.mProgressBar.setVisibility(0);
            this.SD.setText(this.aMU.getPageContext().getPageActivity().getText(u.j.loading));
            this.axc.setVisibility(0);
        }

        public void k(boolean z, String str) {
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            if (this.SD != null) {
                if (!z) {
                    this.axc.setVisibility(0);
                    this.SD.setText(str);
                    return;
                }
                this.axc.setVisibility(8);
            }
        }

        public void nU(String str) {
            k(false, str);
        }

        @Override // com.baidu.adp.widget.ListView.c
        public void onClick() {
            if (this.mOnClickListener != null) {
                this.mOnClickListener.onClick(this.KB);
            }
        }
    }

    private void ig(boolean z) {
        if (z) {
            if (this.zt != null) {
                if (this.mNoDataView != null) {
                    this.mNoDataView.setVisibility(0);
                }
                this.zt.removeHeaderView(this.mNoDataView);
                this.zt.addHeaderView(this.mNoDataView);
            }
        } else if (this.zt != null) {
            if (this.mNoDataView != null) {
                this.mNoDataView.setVisibility(8);
            }
            this.zt.removeHeaderView(this.mNoDataView);
        }
    }
}
