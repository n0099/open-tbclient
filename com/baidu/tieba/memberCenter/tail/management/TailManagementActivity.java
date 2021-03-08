package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.management.a;
/* loaded from: classes8.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    a luO;
    d luP;
    e luQ;
    private a.InterfaceC0804a luR = new a.InterfaceC0804a() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.1
        @Override // com.baidu.tieba.memberCenter.tail.management.a.InterfaceC0804a
        public void dgr() {
            boolean dgw = TailManagementActivity.this.luP.dgw();
            if (TailManagementActivity.this.luP.getTails().size() == 0 && dgw) {
                dgw = !TailManagementActivity.this.luP.dgw();
                TailManagementActivity.this.luP.tX(dgw);
            }
            TailManagementActivity.this.luQ.an(dgw, TailManagementActivity.this.luP.getTails().size() == 0);
        }
    };
    private View.OnClickListener luS = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == TailManagementActivity.this.luQ.dgy()) {
                TailManagementActivity.this.finish();
            } else if (view == TailManagementActivity.this.luQ.dgx()) {
                boolean z = !TailManagementActivity.this.luP.dgw();
                TailManagementActivity.this.luP.tX(z);
                TailManagementActivity.this.luQ.an(z, TailManagementActivity.this.luP.getTails().size() == 0);
                TailManagementActivity.this.luO.refresh();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tail_management_activity);
        this.luP = new d(getPageContext());
        this.luO = new a(getPageContext(), this.luP, this.luR);
        this.luQ = new e(this, this.luS);
        this.luQ.d(this.luO);
        this.luQ.an(false, this.luP.getTails().size() == 0);
        if (this.luP.b(getIntent().getSerializableExtra("list"))) {
            this.luO.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.luQ.onChangeSkinType(i);
        this.luO.notifyDataSetChanged();
    }
}
