package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class MemberPayFragment extends BaseFragment {
    private boolean isPayDialog;
    private String lrk;
    private String lrl;
    private int lrm;
    private b lrn;
    private f lro = null;
    private Boolean lrp = false;
    private View mRootView;
    private int type;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.type = arguments.getInt("member_type");
        this.lrk = arguments.getString("member_refer_page");
        this.lrl = arguments.getString("member_click_zone");
        this.isPayDialog = arguments.getBoolean("member_is_pay_dialog");
        this.lrm = arguments.getInt("member_from_type");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
        this.lrn = new b(getPageContext(), this.mRootView, this.type, this.lrk, this.lrl, this.isPayDialog, this.lrm);
        this.lrn.setDataAndRefreshUI(this.lro);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setDataAndRefreshUI(f fVar) {
        this.lro = fVar;
        if (this.lrn != null) {
            this.lrn.setDataAndRefreshUI(fVar);
        }
    }

    public void n(Boolean bool) {
        this.lrp = bool;
        if (this.lrn != null) {
            this.lrn.tU(bool.booleanValue());
        }
    }

    public int getType() {
        return this.type;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lrn != null) {
            this.lrn.onChangeSkinType(i);
        }
    }
}
