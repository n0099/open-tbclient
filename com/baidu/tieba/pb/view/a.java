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
    private BaseFragment jNw;
    private InterfaceC0644a jNx;
    private TBSpecificationBtn jNy;
    private View.OnClickListener jNz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.jNw.getContext());
            if (a.this.jNx != null) {
                a.this.jNx.qY(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0644a {
        void qY(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0644a interfaceC0644a) {
        this.jNw = baseFragment;
        this.jNx = interfaceC0644a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.jNw.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.jNy = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.jNw != null && this.jNw.getContext() != null) {
            this.jNy.setText(this.jNw.getContext().getResources().getString(R.string.login_see_more));
        }
        this.jNy.setTextSize(R.dimen.tbds42);
        this.jNy.setConfig(bVar);
        this.jNy.setOnClickListener(this.jNz);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aQa() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.jNw.getPageContext(), this.mView);
        if (this.jNy != null) {
            this.jNy.aQm();
        }
    }
}
