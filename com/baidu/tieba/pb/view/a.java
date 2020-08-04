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
    private BaseFragment kJl;
    private InterfaceC0726a kJm;
    private TBSpecificationBtn kJn;
    private View.OnClickListener kJo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bf.skipToLoginActivity(a.this.kJl.getContext());
            if (a.this.kJm != null) {
                a.this.kJm.sp(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0726a {
        void sp(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0726a interfaceC0726a) {
        this.kJl = baseFragment;
        this.kJm = interfaceC0726a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.kJl.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.kJn = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.kJl != null && this.kJl.getContext() != null) {
            this.kJn.setText(this.kJl.getContext().getResources().getString(R.string.login_see_more));
        }
        this.kJn.setTextSize(R.dimen.tbds42);
        this.kJn.setConfig(bVar);
        this.kJn.setOnClickListener(this.kJo);
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
        com.baidu.tbadk.r.a.a(this.kJl.getPageContext(), this.mView);
        if (this.kJn != null) {
            this.kJn.bci();
        }
    }
}
