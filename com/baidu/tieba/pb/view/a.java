package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a extends com.baidu.adp.widget.ListView.c {
    private BaseFragment kYZ;
    private InterfaceC0777a kZa;
    private TBSpecificationBtn kZb;
    private View.OnClickListener kZc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bg.skipToLoginActivity(a.this.kYZ.getContext());
            if (a.this.kZa != null) {
                a.this.kZa.sW(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0777a {
        void sW(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0777a interfaceC0777a) {
        this.kYZ = baseFragment;
        this.kZa = interfaceC0777a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.kYZ.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.kZb = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.kYZ != null && this.kYZ.getContext() != null) {
            this.kZb.setText(this.kYZ.getContext().getResources().getString(R.string.login_see_more));
        }
        this.kZb.setTextSize(R.dimen.tbds42);
        this.kZb.setConfig(aVar);
        this.kZb.setOnClickListener(this.kZc);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
    }

    public void bkv() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.kYZ.getPageContext(), this.mView);
        if (this.kZb != null) {
            this.kZb.bkF();
        }
    }
}
