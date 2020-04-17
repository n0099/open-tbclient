package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.b {
    private BaseFragment jNs;
    private InterfaceC0623a jNt;
    private TBSpecificationBtn jNu;
    private View.OnClickListener jNv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.jNs.getContext());
            if (a.this.jNt != null) {
                a.this.jNt.qY(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0623a {
        void qY(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0623a interfaceC0623a) {
        this.jNs = baseFragment;
        this.jNt = interfaceC0623a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.jNs.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.jNu = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.jNs != null && this.jNs.getContext() != null) {
            this.jNu.setText(this.jNs.getContext().getResources().getString(R.string.login_see_more));
        }
        this.jNu.setTextSize(R.dimen.tbds42);
        this.jNu.setConfig(bVar);
        this.jNu.setOnClickListener(this.jNv);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aQd() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.jNs.getPageContext(), this.mView);
        if (this.jNu != null) {
            this.jNu.aQp();
        }
    }
}
