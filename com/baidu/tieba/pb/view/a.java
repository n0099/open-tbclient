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
    private BaseFragment jbL;
    private InterfaceC0584a jbM;
    private TBSpecificationBtn jbN;
    private View.OnClickListener jbO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.jbL.getContext());
            if (a.this.jbM != null) {
                a.this.jbM.pO(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0584a {
        void pO(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0584a interfaceC0584a) {
        this.jbL = baseFragment;
        this.jbM = interfaceC0584a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.jbL.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.jbN = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.jbL != null && this.jbL.getContext() != null) {
            this.jbN.setText(this.jbL.getContext().getResources().getString(R.string.login_see_more));
        }
        this.jbN.setTextSize(R.dimen.tbds42);
        this.jbN.setConfig(bVar);
        this.jbN.setOnClickListener(this.jbO);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aHH() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.jbL.getPageContext(), this.mView);
        if (this.jbN != null) {
            this.jbN.aHO();
        }
    }
}
