package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.adp.widget.ListView.c {
    private BaseFragment kJj;
    private InterfaceC0726a kJk;
    private TBSpecificationBtn kJl;
    private View.OnClickListener kJm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bf.skipToLoginActivity(a.this.kJj.getContext());
            if (a.this.kJk != null) {
                a.this.kJk.sp(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0726a {
        void sp(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0726a interfaceC0726a) {
        this.kJj = baseFragment;
        this.kJk = interfaceC0726a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.kJj.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.kJl = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.kJj != null && this.kJj.getContext() != null) {
            this.kJl.setText(this.kJj.getContext().getResources().getString(R.string.login_see_more));
        }
        this.kJl.setTextSize(R.dimen.tbds42);
        this.kJl.setConfig(bVar);
        this.kJl.setOnClickListener(this.kJm);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void bbZ() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.kJj.getPageContext(), this.mView);
        if (this.kJl != null) {
            this.kJl.bci();
        }
    }
}
