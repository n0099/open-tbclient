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
    private BaseFragment mjq;
    private InterfaceC0824a mjr;
    private TBSpecificationBtn mjs;
    private View.OnClickListener mjt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bg.skipToLoginActivity(a.this.mjq.getContext());
            if (a.this.mjr != null) {
                a.this.mjr.uS(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0824a {
        void uS(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0824a interfaceC0824a) {
        this.mjq = baseFragment;
        this.mjr = interfaceC0824a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.mjq.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.mjs = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.mjq != null && this.mjq.getContext() != null) {
            this.mjs.setText(this.mjq.getContext().getResources().getString(R.string.login_see_more));
        }
        this.mjs.setTextSize(R.dimen.tbds42);
        this.mjs.setConfig(aVar);
        this.mjs.setOnClickListener(this.mjt);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void bxC() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.mjq.getPageContext(), this.mView);
        if (this.mjs != null) {
            this.mjs.bxO();
        }
    }
}
