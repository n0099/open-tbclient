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
    private BaseFragment kgt;
    private InterfaceC0698a kgu;
    private TBSpecificationBtn kgv;
    private View.OnClickListener kgw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.kgt.getContext());
            if (a.this.kgu != null) {
                a.this.kgu.rx(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0698a {
        void rx(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0698a interfaceC0698a) {
        this.kgt = baseFragment;
        this.kgu = interfaceC0698a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.kgt.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.kgv = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.kgt != null && this.kgt.getContext() != null) {
            this.kgv.setText(this.kgt.getContext().getResources().getString(R.string.login_see_more));
        }
        this.kgv.setTextSize(R.dimen.tbds42);
        this.kgv.setConfig(bVar);
        this.kgv.setOnClickListener(this.kgw);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aWf() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.kgt.getPageContext(), this.mView);
        if (this.kgv != null) {
            this.kgv.aWr();
        }
    }
}
