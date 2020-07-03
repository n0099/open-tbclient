package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.adp.widget.ListView.c {
    private BaseFragment kAh;
    private InterfaceC0714a kAi;
    private TBSpecificationBtn kAj;
    private View.OnClickListener kAk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            be.skipToLoginActivity(a.this.kAh.getContext());
            if (a.this.kAi != null) {
                a.this.kAi.rK(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0714a {
        void rK(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0714a interfaceC0714a) {
        this.kAh = baseFragment;
        this.kAi = interfaceC0714a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.kAh.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.kAj = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.kAh != null && this.kAh.getContext() != null) {
            this.kAj.setText(this.kAh.getContext().getResources().getString(R.string.login_see_more));
        }
        this.kAj.setTextSize(R.dimen.tbds42);
        this.kAj.setConfig(bVar);
        this.kAj.setOnClickListener(this.kAk);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void aXZ() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.kAh.getPageContext(), this.mView);
        if (this.kAj != null) {
            this.kAj.aYj();
        }
    }
}
