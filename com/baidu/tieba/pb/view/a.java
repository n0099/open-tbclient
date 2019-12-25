package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.b {
    private BaseFragment iWo;
    private InterfaceC0572a iWp;
    private TBSpecificationBtn iWq;
    private View.OnClickListener iWr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.iWo.getContext());
            if (a.this.iWp != null) {
                a.this.iWp.pz(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0572a {
        void pz(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0572a interfaceC0572a) {
        this.iWo = baseFragment;
        this.iWp = interfaceC0572a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.iWo.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.iWq = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.iWo != null && this.iWo.getContext() != null) {
            this.iWq.setText(this.iWo.getContext().getResources().getString(R.string.login_see_more));
        }
        this.iWq.setTextSize(R.dimen.tbds42);
        this.iWq.setConfig(bVar);
        this.iWq.setOnClickListener(this.iWr);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aEZ() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.iWo.getPageContext(), this.mView);
        if (this.iWq != null) {
            this.iWq.aFd();
        }
    }
}
