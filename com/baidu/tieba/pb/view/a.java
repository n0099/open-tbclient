package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a extends com.baidu.adp.widget.ListView.c {
    private BaseFragment lhY;
    private InterfaceC0774a lhZ;
    private TBSpecificationBtn lia;
    private View.OnClickListener lib = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bg.skipToLoginActivity(a.this.lhY.getContext());
            if (a.this.lhZ != null) {
                a.this.lhZ.tf(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0774a {
        void tf(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0774a interfaceC0774a) {
        this.lhY = baseFragment;
        this.lhZ = interfaceC0774a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.lhY.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.lia = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.lhY != null && this.lhY.getContext() != null) {
            this.lia.setText(this.lhY.getContext().getResources().getString(R.string.login_see_more));
        }
        this.lia.setTextSize(R.dimen.tbds42);
        this.lia.setConfig(aVar);
        this.lia.setOnClickListener(this.lib);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void blq() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.lhY.getPageContext(), this.mView);
        if (this.lia != null) {
            this.lia.blA();
        }
    }
}
