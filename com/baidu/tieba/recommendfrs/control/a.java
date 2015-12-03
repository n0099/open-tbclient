package com.baidu.tieba.recommendfrs.control;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.f.h;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private com.baidu.tbadk.f.f cRU;
    private ScrollFragmentTabHost div;
    private com.baidu.tieba.recommendfrs.control.a.b diw;
    private CustomMessageTask diy;
    private h refreshView;
    private List<ExcellentTagInfo> dix = new ArrayList();
    private CustomMessageListener diz = new b(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private com.baidu.tieba.recommendfrs.a diA = new c(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.g.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbadkCoreApplication.m411getInst().setEnterRecommendFrs(true);
        if (this.dix == null || this.dix.size() <= 0) {
            this.diw.bx(0L);
            a(getView(), false, getResources().getDimensionPixelSize(n.d.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        IK();
        this.div = (ScrollFragmentTabHost) getView().findViewById(n.f.recommend_frs_tab_host);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.diz);
        awd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
    }

    private void awd() {
        this.diy = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new d(this));
        this.diy.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.diy);
    }

    private void IK() {
        this.diw = new com.baidu.tieba.recommendfrs.control.a.b(getPageContext(), getUniqueId());
        this.diw.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<ExcellentTagInfo> list, long j) {
        for (ExcellentTagInfo excellentTagInfo : list) {
            if (excellentTagInfo != null && excellentTagInfo.tag_code.longValue() == j && "头条".equals(excellentTagInfo.tag_name)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.cRU == null) {
            if (i < 0) {
                this.cRU = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cRU = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cRU.tH();
        }
        this.cRU.b(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(View view) {
        if (this.cRU != null) {
            this.cRU.v(view);
            this.cRU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bE(List<ExcellentTagInfo> list) {
        ExcellentTagInfo excellentTagInfo;
        if (this.dix.size() > 0 && list != null && list.size() > 0 && this.dix.size() == list.size()) {
            for (int i = 0; i < this.dix.size(); i++) {
                ExcellentTagInfo excellentTagInfo2 = (ExcellentTagInfo) y.b(this.dix, i);
                if (excellentTagInfo2 == null || (excellentTagInfo = (ExcellentTagInfo) y.b(list, i)) == null || excellentTagInfo2.tag_code != excellentTagInfo.tag_code || !excellentTagInfo2.tag_name.equals(excellentTagInfo.tag_name)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new f(this));
        }
        this.refreshView.eB(getResources().getDimensionPixelSize(n.d.ds160));
        this.refreshView.fL(str);
        this.refreshView.b(view, z);
        this.refreshView.Dn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TI() {
        if (this.refreshView != null) {
            this.refreshView.v(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.div != null) {
            this.div.onChangeSkinType(i);
        }
    }
}
