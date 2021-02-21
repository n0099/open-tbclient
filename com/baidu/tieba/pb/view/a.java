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
    private BaseFragment moa;
    private InterfaceC0844a mob;
    private TBSpecificationBtn moc;
    private View.OnClickListener mod = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bh.skipToLoginActivity(a.this.moa.getContext());
            if (a.this.mob != null) {
                a.this.mob.vd(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0844a {
        void vd(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0844a interfaceC0844a) {
        this.moa = baseFragment;
        this.mob = interfaceC0844a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.moa.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.moc = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.moa != null && this.moa.getContext() != null) {
            this.moc.setText(this.moa.getContext().getResources().getString(R.string.login_see_more));
        }
        this.moc.setTextSize(R.dimen.tbds42);
        this.moc.setConfig(aVar);
        this.moc.setOnClickListener(this.mod);
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
        com.baidu.tbadk.r.a.a(this.moa.getPageContext(), this.mView);
        if (this.moc != null) {
            this.moc.bup();
        }
    }
}
