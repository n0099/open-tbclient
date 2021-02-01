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
    private String loU;
    private String loV;
    private int loW;
    private b loX;
    private f loY = null;
    private Boolean loZ = false;
    private View mRootView;
    private int type;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.type = arguments.getInt("member_type");
        this.loU = arguments.getString("member_refer_page");
        this.loV = arguments.getString("member_click_zone");
        this.isPayDialog = arguments.getBoolean("member_is_pay_dialog");
        this.loW = arguments.getInt("member_from_type");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
        this.loX = new b(getPageContext(), this.mRootView, this.type, this.loU, this.loV, this.isPayDialog, this.loW);
        this.loX.setDataAndRefreshUI(this.loY);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setDataAndRefreshUI(f fVar) {
        this.loY = fVar;
        if (this.loX != null) {
            this.loX.setDataAndRefreshUI(fVar);
        }
    }

    public void n(Boolean bool) {
        this.loZ = bool;
        if (this.loX != null) {
            this.loX.tU(bool.booleanValue());
        }
    }

    public int getType() {
        return this.type;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.loX != null) {
            this.loX.onChangeSkinType(i);
        }
    }
}
