package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.management.a;
/* loaded from: classes9.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    a lpb;
    d lpc;
    e lpd;
    private a.InterfaceC0812a lpe = new a.InterfaceC0812a() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.1
        @Override // com.baidu.tieba.memberCenter.tail.management.a.InterfaceC0812a
        public void dhT() {
            boolean dhY = TailManagementActivity.this.lpc.dhY();
            if (TailManagementActivity.this.lpc.getTails().size() == 0 && dhY) {
                dhY = !TailManagementActivity.this.lpc.dhY();
                TailManagementActivity.this.lpc.tO(dhY);
            }
            TailManagementActivity.this.lpd.an(dhY, TailManagementActivity.this.lpc.getTails().size() == 0);
        }
    };
    private View.OnClickListener lpf = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == TailManagementActivity.this.lpd.dia()) {
                TailManagementActivity.this.finish();
            } else if (view == TailManagementActivity.this.lpd.dhZ()) {
                boolean z = !TailManagementActivity.this.lpc.dhY();
                TailManagementActivity.this.lpc.tO(z);
                TailManagementActivity.this.lpd.an(z, TailManagementActivity.this.lpc.getTails().size() == 0);
                TailManagementActivity.this.lpb.refresh();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tail_management_activity);
        this.lpc = new d(getPageContext());
        this.lpb = new a(getPageContext(), this.lpc, this.lpe);
        this.lpd = new e(this, this.lpf);
        this.lpd.d(this.lpb);
        this.lpd.an(false, this.lpc.getTails().size() == 0);
        if (this.lpc.b(getIntent().getSerializableExtra("list"))) {
            this.lpb.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lpd.onChangeSkinType(i);
        this.lpb.notifyDataSetChanged();
    }
}
