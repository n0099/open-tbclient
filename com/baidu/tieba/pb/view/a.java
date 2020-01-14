package com.baidu.tieba.pb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.widget.ListView.b {
    private BaseFragment iZW;
    private InterfaceC0577a iZX;
    private TBSpecificationBtn iZY;
    private View.OnClickListener iZZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bc.skipToLoginActivity(a.this.iZW.getContext());
            if (a.this.iZX != null) {
                a.this.iZX.pL(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0577a {
        void pL(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0577a interfaceC0577a) {
        this.iZW = baseFragment;
        this.iZX = interfaceC0577a;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        this.mView = LayoutInflater.from(this.iZW.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.iZY = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (this.iZW != null && this.iZW.getContext() != null) {
            this.iZY.setText(this.iZW.getContext().getResources().getString(R.string.login_see_more));
        }
        this.iZY.setTextSize(R.dimen.tbds42);
        this.iZY.setConfig(bVar);
        this.iZY.setOnClickListener(this.iZZ);
        changeSkin(TbadkCoreApplication.getInst().getSkinType());
        return this.mView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
    }

    public void aFs() {
        this.mView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    public void changeSkin(int i) {
        com.baidu.tbadk.q.a.a(this.iZW.getPageContext(), this.mView);
        if (this.iZY != null) {
            this.iZY.aFw();
        }
    }
}
