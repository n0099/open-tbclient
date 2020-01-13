package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.widget.ListView.b {
    private BaseFragment iZR;
    private InterfaceC0577a iZS;
    private TBSpecificationBtn iZT;
    private View.OnClickListener iZU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.iZR.getContext());
            if (a.this.iZS != null) {
                a.this.iZS.pL(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0577a {
        void pL(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0577a interfaceC0577a) {
        this.iZR = baseFragment;
        this.iZS = interfaceC0577a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.iZR.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.iZT = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.iZR != null && this.iZR.getContext() != null) {
            this.iZT.setText(this.iZR.getContext().getResources().getString(R.string.login_see_more));
        }
        this.iZT.setTextSize(R.dimen.tbds42);
        this.iZT.setConfig(bVar);
        this.iZT.setOnClickListener(this.iZU);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aFs() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.iZR.getPageContext(), this.mView);
        if (this.iZT != null) {
            this.iZT.aFw();
        }
    }
}
