package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.b {
    private BaseFragment mjp;
    private InterfaceC0857a mjq;
    private TBSpecificationBtn mjr;
    private View.OnClickListener mjs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bg.skipToLoginActivity(a.this.mjp.getContext());
            if (a.this.mjq != null) {
                a.this.mjq.uS(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0857a {
        void uS(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0857a interfaceC0857a) {
        this.mjp = baseFragment;
        this.mjq = interfaceC0857a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.mjp.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.mjr = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.mjp != null && this.mjp.getContext() != null) {
            this.mjr.setText(this.mjp.getContext().getResources().getString(R.string.login_see_more));
        }
        this.mjr.setTextSize(R.dimen.tbds42);
        this.mjr.setConfig(aVar);
        this.mjr.setOnClickListener(this.mjs);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void bxD() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.mjp.getPageContext(), this.mView);
        if (this.mjr != null) {
            this.mjr.bxP();
        }
    }
}
