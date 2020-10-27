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
    private BaseFragment lJN;
    private InterfaceC0807a lJO;
    private TBSpecificationBtn lJP;
    private View.OnClickListener lJQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bg.skipToLoginActivity(a.this.lJN.getContext());
            if (a.this.lJO != null) {
                a.this.lJO.ud(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0807a {
        void ud(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0807a interfaceC0807a) {
        this.lJN = baseFragment;
        this.lJO = interfaceC0807a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.lJN.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.lJP = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.lJN != null && this.lJN.getContext() != null) {
            this.lJP.setText(this.lJN.getContext().getResources().getString(R.string.login_see_more));
        }
        this.lJP.setTextSize(R.dimen.tbds42);
        this.lJP.setConfig(aVar);
        this.lJP.setOnClickListener(this.lJQ);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void bpT() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.lJN.getPageContext(), this.mView);
        if (this.lJP != null) {
            this.lJP.bqd();
        }
    }
}
