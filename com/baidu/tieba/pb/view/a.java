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
    private BaseFragment kfn;
    private InterfaceC0697a kfo;
    private TBSpecificationBtn kfp;
    private View.OnClickListener kfq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.kfn.getContext());
            if (a.this.kfo != null) {
                a.this.kfo.rx(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0697a {
        void rx(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0697a interfaceC0697a) {
        this.kfn = baseFragment;
        this.kfo = interfaceC0697a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.kfn.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.kfp = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.kfn != null && this.kfn.getContext() != null) {
            this.kfp.setText(this.kfn.getContext().getResources().getString(R.string.login_see_more));
        }
        this.kfp.setTextSize(R.dimen.tbds42);
        this.kfp.setConfig(bVar);
        this.kfp.setOnClickListener(this.kfq);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aWe() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.kfn.getPageContext(), this.mView);
        if (this.kfp != null) {
            this.kfp.aWq();
        }
    }
}
