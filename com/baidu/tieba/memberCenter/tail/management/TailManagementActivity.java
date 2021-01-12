package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.management.a;
/* loaded from: classes8.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    a lkr;
    d lks;
    e lkt;
    private a.InterfaceC0795a lku = new a.InterfaceC0795a() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.1
        @Override // com.baidu.tieba.memberCenter.tail.management.a.InterfaceC0795a
        public void deb() {
            boolean deg = TailManagementActivity.this.lks.deg();
            if (TailManagementActivity.this.lks.getTails().size() == 0 && deg) {
                deg = !TailManagementActivity.this.lks.deg();
                TailManagementActivity.this.lks.tK(deg);
            }
            TailManagementActivity.this.lkt.an(deg, TailManagementActivity.this.lks.getTails().size() == 0);
        }
    };
    private View.OnClickListener lkv = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == TailManagementActivity.this.lkt.dei()) {
                TailManagementActivity.this.finish();
            } else if (view == TailManagementActivity.this.lkt.deh()) {
                boolean z = !TailManagementActivity.this.lks.deg();
                TailManagementActivity.this.lks.tK(z);
                TailManagementActivity.this.lkt.an(z, TailManagementActivity.this.lks.getTails().size() == 0);
                TailManagementActivity.this.lkr.refresh();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tail_management_activity);
        this.lks = new d(getPageContext());
        this.lkr = new a(getPageContext(), this.lks, this.lku);
        this.lkt = new e(this, this.lkv);
        this.lkt.d(this.lkr);
        this.lkt.an(false, this.lks.getTails().size() == 0);
        if (this.lks.b(getIntent().getSerializableExtra("list"))) {
            this.lkr.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lkt.onChangeSkinType(i);
        this.lkr.notifyDataSetChanged();
    }
}
