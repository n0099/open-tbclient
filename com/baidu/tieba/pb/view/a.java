package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a extends com.baidu.adp.widget.ListView.c {
    private BaseFragment lPY;
    private InterfaceC0824a lPZ;
    private TBSpecificationBtn lQa;
    private View.OnClickListener lQb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bh.skipToLoginActivity(a.this.lPY.getContext());
            if (a.this.lPZ != null) {
                a.this.lPZ.up(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0824a {
        void up(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0824a interfaceC0824a) {
        this.lPY = baseFragment;
        this.lPZ = interfaceC0824a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.lPY.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.lQa = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.lPY != null && this.lPY.getContext() != null) {
            this.lQa.setText(this.lPY.getContext().getResources().getString(R.string.login_see_more));
        }
        this.lQa.setTextSize(R.dimen.tbds42);
        this.lQa.setConfig(aVar);
        this.lQa.setOnClickListener(this.lQb);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void brI() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.lPY.getPageContext(), this.mView);
        if (this.lQa != null) {
            this.lQa.brT();
        }
    }
}
