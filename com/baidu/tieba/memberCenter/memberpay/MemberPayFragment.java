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
    private String lgN;
    private String lgO;
    private int lgP;
    private b lgQ;
    private f lgR = null;
    private Boolean lgS = false;
    private View mRootView;
    private int type;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.type = arguments.getInt("member_type");
        this.lgN = arguments.getString("member_refer_page");
        this.lgO = arguments.getString("member_click_zone");
        this.isPayDialog = arguments.getBoolean("member_is_pay_dialog");
        this.lgP = arguments.getInt("member_from_type");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
        this.lgQ = new b(getPageContext(), this.mRootView, this.type, this.lgN, this.lgO, this.isPayDialog, this.lgP);
        this.lgQ.setDataAndRefreshUI(this.lgR);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setDataAndRefreshUI(f fVar) {
        this.lgR = fVar;
        if (this.lgQ != null) {
            this.lgQ.setDataAndRefreshUI(fVar);
        }
    }

    public void o(Boolean bool) {
        this.lgS = bool;
        if (this.lgQ != null) {
            this.lgQ.tH(bool.booleanValue());
        }
    }

    public int getType() {
        return this.type;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lgQ != null) {
            this.lgQ.onChangeSkinType(i);
        }
    }
}
