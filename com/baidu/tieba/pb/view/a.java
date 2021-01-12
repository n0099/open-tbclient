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
    private BaseFragment meJ;
    private InterfaceC0840a meK;
    private TBSpecificationBtn meL;
    private View.OnClickListener meM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bg.skipToLoginActivity(a.this.meJ.getContext());
            if (a.this.meK != null) {
                a.this.meK.uO(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0840a {
        void uO(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0840a interfaceC0840a) {
        this.meJ = baseFragment;
        this.meK = interfaceC0840a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.meJ.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.meL = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.meJ != null && this.meJ.getContext() != null) {
            this.meL.setText(this.meJ.getContext().getResources().getString(R.string.login_see_more));
        }
        this.meL.setTextSize(R.dimen.tbds42);
        this.meL.setConfig(aVar);
        this.meL.setOnClickListener(this.meM);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void btJ() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.meJ.getPageContext(), this.mView);
        if (this.meL != null) {
            this.meL.btV();
        }
    }
}
