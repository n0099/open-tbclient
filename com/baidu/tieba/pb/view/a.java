package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.widget.ListView.c {
    private BaseFragment lxp;
    private InterfaceC0792a lxq;
    private TBSpecificationBtn lxr;
    private View.OnClickListener lxs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bg.skipToLoginActivity(a.this.lxp.getContext());
            if (a.this.lxq != null) {
                a.this.lxq.tM(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0792a {
        void tM(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0792a interfaceC0792a) {
        this.lxp = baseFragment;
        this.lxq = interfaceC0792a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.lxp.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.lxr = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.lxp != null && this.lxp.getContext() != null) {
            this.lxr.setText(this.lxp.getContext().getResources().getString(R.string.login_see_more));
        }
        this.lxr.setTextSize(R.dimen.tbds42);
        this.lxr.setConfig(aVar);
        this.lxr.setOnClickListener(this.lxs);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void boa() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.lxp.getPageContext(), this.mView);
        if (this.lxr != null) {
            this.lxr.bok();
        }
    }
}
