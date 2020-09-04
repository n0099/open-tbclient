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
    private BaseFragment kZg;
    private InterfaceC0777a kZh;
    private TBSpecificationBtn kZi;
    private View.OnClickListener kZj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bg.skipToLoginActivity(a.this.kZg.getContext());
            if (a.this.kZh != null) {
                a.this.kZh.sY(true);
            }
        }
    };

    /* renamed from: com.baidu.tieba.pb.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0777a {
        void sY(boolean z);
    }

    public a(BaseFragment baseFragment, InterfaceC0777a interfaceC0777a) {
        this.kZg = baseFragment;
        this.kZh = interfaceC0777a;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        this.mView = LayoutInflater.from(this.kZg.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
        this.kZi = (TBSpecificationBtn) this.mView.findViewById(R.id.login_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        if (this.kZg != null && this.kZg.getContext() != null) {
            this.kZi.setText(this.kZg.getContext().getResources().getString(R.string.login_see_more));
        }
        this.kZi.setTextSize(R.dimen.tbds42);
        this.kZi.setConfig(aVar);
        this.kZi.setOnClickListener(this.kZj);
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
        com.baidu.tbadk.r.a.a(this.kZg.getPageContext(), this.mView);
        if (this.kZi != null) {
            this.kZi.bkF();
        }
    }
}
