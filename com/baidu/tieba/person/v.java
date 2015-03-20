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
    private String bPA;
    private ah bPi;
    public BdListView mListView = null;
    public com.baidu.tieba.person.post.z bPs = null;
    private af bPt = null;
    private int bDK = -1;
    private String bPu = null;
    private View bPv = null;
    private com.baidu.tbadk.core.view.s mNoDataView = null;
    private com.baidu.tbadk.core.view.ag mPullView = null;
    private TextView auq = null;
    public int bPw = 0;
    public int bPx = 50;
    public boolean hasMore = false;
    private ForumData bPy = null;
    private boolean bPz = false;
    private int bPB = 0;
    private boolean mIsHost = true;
    private boolean bOx = false;
    private final CustomMessageListener bPC = new w(this, 2001187);
    private HttpMessageListener bPD = new x(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener bPE = new y(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001187, bp.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity acW() {
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
        registerListener(this.bPE);
        registerListener(this.bPD);
        registerListener(this.bPC);
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
        if (this.bPt != null) {
            this.bPt = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bPD);
        MessageManager.getInstance().unRegisterListener(this.bPE);
        MessageManager.getInstance().unRegisterListener(this.bPC);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int dimension;
        String string;
        this.bPB = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.friend_fragment, viewGroup, false);
        if (acW() == null) {
            return inflate;
        }
        this.bPA = getString(com.baidu.tieba.y.person_bar_no_more);
        this.bPi = acW().acN();
        this.mIsHost = acW().SR();
        this.bOx = acW().acE();
        this.bPv = inflate.findViewById(com.baidu.tieba.v.friend_fragment_parent);
        if (this.mIsHost && !this.bOx) {
            this.auq = acW().getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.edit));
            this.auq.setOnClickListener(new z(this));
            this.auq.setVisibility(0);
        }
        this.bPt = new af(acW(), this.bPi.acZ(), this.mIsHost, this.bOx);
        this.bPt.r(new aa(this));
        this.bPt.y(new ab(this));
        this.mListView = (BdListView) inflate.findViewById(com.baidu.tieba.v.my_friend_list);
        this.mListView.setAdapter((ListAdapter) this.bPt);
        this.mListView.setOnItemClickListener(new ac(this));
        this.mPullView = new com.baidu.tbadk.core.view.ag(acW().getPageContext());
        this.mPullView.a(new ad(this));
        this.bPs = new com.baidu.tieba.person.post.z(getBaseFragmentActivity());
        this.mListView.setNextPage(this.bPs);
        this.mListView.setOnSrollToBottomListener(new ae(this));
        this.mListView.setPullRefresh(this.mPullView);
        if (this.mIsHost) {
            dimension = (int) getResources().getDimension(com.baidu.tieba.t.ds160);
            string = String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), getString(com.baidu.tieba.y.you));
        } else {
            dimension = (int) getResources().getDimension(com.baidu.tieba.t.ds80);
            if (this.bPB == 0) {
                string = String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), acW().SQ());
            } else {
                string = getString(com.baidu.tieba.y.person_bar_no_common_info);
            }
        }
        if (this.bOx) {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.w.ac(string, getString(com.baidu.tieba.y.share_choose_bar_nothing_tip)), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, dimension), com.baidu.tbadk.core.view.w.cZ(string), null);
        }
        if (this.mIsHost) {
            FY();
        }
        if (this.bPB == acW().SP()) {
            this.mListView.mX();
        }
        return inflate;
    }

    public void ee(boolean z) {
        if (this.bPt != null) {
            this.bPt.XU();
            if (this.bPt.acY()) {
                if (z) {
                    this.bPt.setEditState(false);
                    this.mNoDataView.setVisibility(0);
                    this.mListView.setVisibility(0);
                    if (this.auq != null) {
                        this.auq.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
            if (this.auq != null) {
                this.auq.setVisibility(0);
            }
        }
    }

    public af acX() {
        return this.bPt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vn() {
        if (this.bPi != null) {
            this.bPi.a(this.mIsHost, this.bPi.getId(), this.bPw, this.bPx);
        }
    }

    public void hy(int i) {
        if (this.bPi != null) {
            this.bPi.a(this.mIsHost, this.bPi.getId(), i, this.bPx);
        }
    }

    public void FY() {
        if (this.bPi != null) {
            this.bPi.FY();
        }
    }

    public void a(u uVar, boolean z) {
        if (uVar != null) {
            this.hasMore = uVar.isHasMore();
            if (!z) {
                this.mListView.mW();
            }
            int acF = acW().acF();
            int i = 0;
            if (this.bPi != null && this.bPt != null) {
                if (this.bPB == acW().SP()) {
                    if (z) {
                        this.bPw = 1;
                        this.bPi.acZ().b(uVar.acQ(), uVar.acR());
                        this.bPi.acZ().e(uVar.acS(), uVar.acT());
                        this.bPi.acZ().hu(uVar.acO());
                        this.bPi.acZ().hw(uVar.acP());
                    } else if (this.bPw == 1) {
                        this.bPi.acZ().b(uVar.acQ(), uVar.acR());
                        this.bPi.acZ().e(uVar.acS(), uVar.acT());
                        this.bPi.acZ().hu(uVar.acO());
                        this.bPi.acZ().hw(uVar.acP());
                        this.bPw++;
                    } else {
                        this.bPi.acZ().c(uVar.acQ(), uVar.acR());
                        this.bPi.acZ().d(uVar.acS(), uVar.acT());
                        this.bPi.acZ().hv(uVar.acO());
                        this.bPi.acZ().hx(uVar.acP());
                        this.bPw++;
                    }
                }
                if (this.bPB == 0) {
                    this.bPt.O(this.bPi.acZ().acU());
                } else {
                    this.bPt.O(this.bPi.acZ().acV());
                }
                if (uVar.acV() != null) {
                    i = this.bPi.acZ().acV().size();
                }
                if (acW() != null) {
                    acW().R(acF, i);
                }
                ee(true);
                this.bPt.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.bPv != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().X(i == 1);
                getBaseFragmentActivity().getPageContext().getLayoutMode().h(this.bPv);
            }
            if (this.mNoDataView != null) {
                com.baidu.tbadk.core.util.ba.i(this.mNoDataView, com.baidu.tieba.s.cp_bg_line_d);
            }
            if (acW() != null) {
                acW().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i);
            }
            if (this.mPullView != null) {
                this.mPullView.ct(i);
            }
            if (this.bPt != null) {
                this.bPt.notifyDataSetChanged();
            }
        }
    }
}
