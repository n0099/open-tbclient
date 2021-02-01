package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.b {
    private BaseFragment mnL;
    private InterfaceC0843a mnM;
    private TBSpecificationBtn mnN;
    private View.OnClickListener mnO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bh.skipToLoginActivity(a.this.mnL.getContext());
            if (a.this.mnM != null) {
                a.this.mnM.vd(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0843a {
        void vd(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0843a interfaceC0843a) {
        this.mnL = baseFragment;
        this.mnM = interfaceC0843a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.mnL.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.mnN = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.mnL != null && this.mnL.getContext() != null) {
            this.mnN.setText(this.mnL.getContext().getResources().getString(R.string.login_see_more));
        }
        this.mnN.setTextSize(R.dimen.tbds42);
        this.mnN.setConfig(aVar);
        this.mnN.setOnClickListener(this.mnO);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void bud() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.mnL.getPageContext(), this.mView);
        if (this.mnN != null) {
            this.mnN.bup();
        }
    }
}
