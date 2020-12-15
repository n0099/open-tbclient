package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.widget.ListView.c {
    private BaseFragment mec;
    private InterfaceC0840a med;
    private TBSpecificationBtn mee;
    private View.OnClickListener mef = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bh.skipToLoginActivity(a.this.mec.getContext());
            if (a.this.med != null) {
                a.this.med.uR(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0840a {
        void uR(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0840a interfaceC0840a) {
        this.mec = baseFragment;
        this.med = interfaceC0840a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.mec.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.mee = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.mec != null && this.mec.getContext() != null) {
            this.mee.setText(this.mec.getContext().getResources().getString(R.string.login_see_more));
        }
        this.mee.setTextSize(R.dimen.tbds42);
        this.mee.setConfig(aVar);
        this.mee.setOnClickListener(this.mef);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void bvh() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.mec.getPageContext(), this.mView);
        if (this.mee != null) {
            this.mee.bvt();
        }
    }
}
