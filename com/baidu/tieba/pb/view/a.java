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
    private BaseFragment jdk;
    private InterfaceC0585a jdl;
    private TBSpecificationBtn jdm;
    private View.OnClickListener jdn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.jdk.getContext());
            if (a.this.jdl != null) {
                a.this.jdl.pU(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0585a {
        void pU(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0585a interfaceC0585a) {
        this.jdk = baseFragment;
        this.jdl = interfaceC0585a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.jdk.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.jdm = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.jdk != null && this.jdk.getContext() != null) {
            this.jdm.setText(this.jdk.getContext().getResources().getString(R.string.login_see_more));
        }
        this.jdm.setTextSize(R.dimen.tbds42);
        this.jdm.setConfig(bVar);
        this.jdm.setOnClickListener(this.jdn);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aHL() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.jdk.getPageContext(), this.mView);
        if (this.jdm != null) {
            this.jdm.aHS();
        }
    }
}
