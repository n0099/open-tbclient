package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class MemberPayFragment extends BaseFragment {
    private boolean isPayDialog;
    private String lls;
    private String llt;
    private int llu;
    private b llv;
    private f llw = null;
    private Boolean llx = false;
    private View mRootView;
    private int type;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.type = arguments.getInt("member_type");
        this.lls = arguments.getString("member_refer_page");
        this.llt = arguments.getString("member_click_zone");
        this.isPayDialog = arguments.getBoolean("member_is_pay_dialog");
        this.llu = arguments.getInt("member_from_type");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
        this.llv = new b(getPageContext(), this.mRootView, this.type, this.lls, this.llt, this.isPayDialog, this.llu);
        this.llv.setDataAndRefreshUI(this.llw);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setDataAndRefreshUI(f fVar) {
        this.llw = fVar;
        if (this.llv != null) {
            this.llv.setDataAndRefreshUI(fVar);
        }
    }

    public void o(Boolean bool) {
        this.llx = bool;
        if (this.llv != null) {
            this.llv.tL(bool.booleanValue());
        }
    }

    public int getType() {
        return this.type;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.llv != null) {
            this.llv.onChangeSkinType(i);
        }
    }
}
