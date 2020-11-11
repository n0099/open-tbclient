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
    private BaseFragment lPJ;
    private InterfaceC0822a lPK;
    private TBSpecificationBtn lPL;
    private View.OnClickListener lPM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bg.skipToLoginActivity(a.this.lPJ.getContext());
            if (a.this.lPK != null) {
                a.this.lPK.um(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0822a {
        void um(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0822a interfaceC0822a) {
        this.lPJ = baseFragment;
        this.lPK = interfaceC0822a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.lPJ.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.lPL = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.lPJ != null && this.lPJ.getContext() != null) {
            this.lPL.setText(this.lPJ.getContext().getResources().getString(R.string.login_see_more));
        }
        this.lPL.setTextSize(R.dimen.tbds42);
        this.lPL.setConfig(aVar);
        this.lPL.setOnClickListener(this.lPM);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void bst() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.lPJ.getPageContext(), this.mView);
        if (this.lPL != null) {
            this.lPL.bsD();
        }
    }
}
