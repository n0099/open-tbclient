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
    private String lpi;
    private String lpj;
    private int lpk;
    private b lpl;
    private f lpm = null;
    private Boolean lpn = false;
    private View mRootView;
    private int type;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.type = arguments.getInt("member_type");
        this.lpi = arguments.getString("member_refer_page");
        this.lpj = arguments.getString("member_click_zone");
        this.isPayDialog = arguments.getBoolean("member_is_pay_dialog");
        this.lpk = arguments.getInt("member_from_type");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
        this.lpl = new b(getPageContext(), this.mRootView, this.type, this.lpi, this.lpj, this.isPayDialog, this.lpk);
        this.lpl.setDataAndRefreshUI(this.lpm);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void setDataAndRefreshUI(f fVar) {
        this.lpm = fVar;
        if (this.lpl != null) {
            this.lpl.setDataAndRefreshUI(fVar);
        }
    }

    public void n(Boolean bool) {
        this.lpn = bool;
        if (this.lpl != null) {
            this.lpl.tU(bool.booleanValue());
        }
    }

    public int getType() {
        return this.type;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lpl != null) {
            this.lpl.onChangeSkinType(i);
        }
    }
}
