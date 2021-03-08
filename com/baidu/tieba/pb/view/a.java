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
    private BaseFragment mqd;
    private InterfaceC0850a mqe;
    private TBSpecificationBtn mqf;
    private View.OnClickListener mqg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bh.skipToLoginActivity(a.this.mqd.getContext());
            if (a.this.mqe != null) {
                a.this.mqe.vd(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0850a {
        void vd(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0850a interfaceC0850a) {
        this.mqd = baseFragment;
        this.mqe = interfaceC0850a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.mqd.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.mqf = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.mqd != null && this.mqd.getContext() != null) {
            this.mqf.setText(this.mqd.getContext().getResources().getString(R.string.login_see_more));
        }
        this.mqf.setTextSize(R.dimen.tbds42);
        this.mqf.setConfig(aVar);
        this.mqf.setOnClickListener(this.mqg);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void bug() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.r.a.a(this.mqd.getPageContext(), this.mView);
        if (this.mqf != null) {
            this.mqf.bus();
        }
    }
}
