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
    private View.OnClickListener jbA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.jbx.getContext());
            if (a.this.jby != null) {
                a.this.jby.pO(true);
            }
        }
    };
    private BaseFragment jbx;
    private InterfaceC0584a jby;
    private TBSpecificationBtn jbz;

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0584a {
        void pO(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0584a interfaceC0584a) {
        this.jbx = baseFragment;
        this.jby = interfaceC0584a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.jbx.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.jbz = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.jbx != null && this.jbx.getContext() != null) {
            this.jbz.setText(this.jbx.getContext().getResources().getString(R.string.login_see_more));
        }
        this.jbz.setTextSize(R.dimen.tbds42);
        this.jbz.setConfig(bVar);
        this.jbz.setOnClickListener(this.jbA);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aHE() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.jbx.getPageContext(), this.mView);
        if (this.jbz != null) {
            this.jbz.aHL();
        }
    }
}
