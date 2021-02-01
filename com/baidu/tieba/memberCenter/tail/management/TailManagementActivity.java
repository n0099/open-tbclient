package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.management.a;
/* loaded from: classes9.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    private a.InterfaceC0797a lsA = new a.InterfaceC0797a() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.1
        @Override // com.baidu.tieba.memberCenter.tail.management.a.InterfaceC0797a
        public void dgb() {
            boolean dgg = TailManagementActivity.this.lsy.dgg();
            if (TailManagementActivity.this.lsy.getTails().size() == 0 && dgg) {
                dgg = !TailManagementActivity.this.lsy.dgg();
                TailManagementActivity.this.lsy.tX(dgg);
            }
            TailManagementActivity.this.lsz.an(dgg, TailManagementActivity.this.lsy.getTails().size() == 0);
        }
    };
    private View.OnClickListener lsB = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == TailManagementActivity.this.lsz.dgi()) {
                TailManagementActivity.this.finish();
            } else if (view == TailManagementActivity.this.lsz.dgh()) {
                boolean z = !TailManagementActivity.this.lsy.dgg();
                TailManagementActivity.this.lsy.tX(z);
                TailManagementActivity.this.lsz.an(z, TailManagementActivity.this.lsy.getTails().size() == 0);
                TailManagementActivity.this.lsx.refresh();
            }
        }
    };
    a lsx;
    d lsy;
    e lsz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tail_management_activity);
        this.lsy = new d(getPageContext());
        this.lsx = new a(getPageContext(), this.lsy, this.lsA);
        this.lsz = new e(this, this.lsB);
        this.lsz.d(this.lsx);
        this.lsz.an(false, this.lsy.getTails().size() == 0);
        if (this.lsy.b(getIntent().getSerializableExtra("list"))) {
            this.lsx.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lsz.onChangeSkinType(i);
        this.lsx.notifyDataSetChanged();
    }
}
