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
    private BaseFragment mea;
    private InterfaceC0840a meb;
    private TBSpecificationBtn mec;
    private View.OnClickListener med = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bh.skipToLoginActivity(a.this.mea.getContext());
            if (a.this.meb != null) {
                a.this.meb.uR(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0840a {
        void uR(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0840a interfaceC0840a) {
        this.mea = baseFragment;
        this.meb = interfaceC0840a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.mea.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.mec = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.mea != null && this.mea.getContext() != null) {
            this.mec.setText(this.mea.getContext().getResources().getString(R.string.login_see_more));
        }
        this.mec.setTextSize(R.dimen.tbds42);
        this.mec.setConfig(aVar);
        this.mec.setOnClickListener(this.med);
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
        com.baidu.tbadk.r.a.a(this.mea.getPageContext(), this.mView);
        if (this.mec != null) {
            this.mec.bvt();
        }
    }
}
