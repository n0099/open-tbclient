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
    private InterfaceC0584a jbA;
    private TBSpecificationBtn jbB;
    private View.OnClickListener jbC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.jbz.getContext());
            if (a.this.jbA != null) {
                a.this.jbA.pO(true);
            }
        }
    };
    private BaseFragment jbz;

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0584a {
        void pO(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0584a interfaceC0584a) {
        this.jbz = baseFragment;
        this.jbA = interfaceC0584a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.jbz.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.jbB = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.jbz != null && this.jbz.getContext() != null) {
            this.jbB.setText(this.jbz.getContext().getResources().getString(R.string.login_see_more));
        }
        this.jbB.setTextSize(R.dimen.tbds42);
        this.jbB.setConfig(bVar);
        this.jbB.setOnClickListener(this.jbC);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aHG() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.jbz.getPageContext(), this.mView);
        if (this.jbB != null) {
            this.jbB.aHN();
        }
    }
}
