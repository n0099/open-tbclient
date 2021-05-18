package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import d.a.k0.r1.h.c.a;
import d.a.k0.r1.h.c.d;
import d.a.k0.r1.h.c.e;
/* loaded from: classes3.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    public d.a.k0.r1.h.c.a mAdapter;
    public d mModel;
    public e mView;
    public a.f mRefreshCallbackListener = new a();
    public View.OnClickListener mNavBtnClickListener = new b();

    /* loaded from: classes3.dex */
    public class a implements a.f {
        public a() {
        }

        @Override // d.a.k0.r1.h.c.a.f
        public void callback() {
            boolean g2 = TailManagementActivity.this.mModel.g();
            if (TailManagementActivity.this.mModel.h().size() == 0 && g2) {
                g2 = !TailManagementActivity.this.mModel.g();
                TailManagementActivity.this.mModel.l(g2);
            }
            TailManagementActivity tailManagementActivity = TailManagementActivity.this;
            tailManagementActivity.mView.e(g2, tailManagementActivity.mModel.h().size() == 0);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == TailManagementActivity.this.mView.a()) {
                TailManagementActivity.this.finish();
            } else if (view == TailManagementActivity.this.mView.b()) {
                boolean z = !TailManagementActivity.this.mModel.g();
                TailManagementActivity.this.mModel.l(z);
                TailManagementActivity tailManagementActivity = TailManagementActivity.this;
                tailManagementActivity.mView.e(z, tailManagementActivity.mModel.h().size() == 0);
                TailManagementActivity.this.mAdapter.j();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.c(i2);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tail_management_activity);
        this.mModel = new d(getPageContext());
        this.mAdapter = new d.a.k0.r1.h.c.a(getPageContext(), this.mModel, this.mRefreshCallbackListener);
        e eVar = new e(this, this.mNavBtnClickListener);
        this.mView = eVar;
        eVar.d(this.mAdapter);
        this.mView.e(false, this.mModel.h().size() == 0);
        if (this.mModel.i(getIntent().getSerializableExtra("list"))) {
            this.mAdapter.j();
        }
    }
}
