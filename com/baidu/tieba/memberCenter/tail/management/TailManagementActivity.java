package com.baidu.tieba.memberCenter.tail.management;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.management.a;
/* loaded from: classes9.dex */
public class TailManagementActivity extends BaseActivity<TailManagementActivity> {
    a lsL;
    d lsM;
    e lsN;
    private a.InterfaceC0798a lsO = new a.InterfaceC0798a() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.1
        @Override // com.baidu.tieba.memberCenter.tail.management.a.InterfaceC0798a
        public void dgi() {
            boolean dgn = TailManagementActivity.this.lsM.dgn();
            if (TailManagementActivity.this.lsM.getTails().size() == 0 && dgn) {
                dgn = !TailManagementActivity.this.lsM.dgn();
                TailManagementActivity.this.lsM.tX(dgn);
            }
            TailManagementActivity.this.lsN.an(dgn, TailManagementActivity.this.lsM.getTails().size() == 0);
        }
    };
    private View.OnClickListener lsP = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.management.TailManagementActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == TailManagementActivity.this.lsN.dgp()) {
                TailManagementActivity.this.finish();
            } else if (view == TailManagementActivity.this.lsN.dgo()) {
                boolean z = !TailManagementActivity.this.lsM.dgn();
                TailManagementActivity.this.lsM.tX(z);
                TailManagementActivity.this.lsN.an(z, TailManagementActivity.this.lsM.getTails().size() == 0);
                TailManagementActivity.this.lsL.refresh();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tail_management_activity);
        this.lsM = new d(getPageContext());
        this.lsL = new a(getPageContext(), this.lsM, this.lsO);
        this.lsN = new e(this, this.lsP);
        this.lsN.d(this.lsL);
        this.lsN.an(false, this.lsM.getTails().size() == 0);
        if (this.lsM.b(getIntent().getSerializableExtra("list"))) {
            this.lsL.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lsN.onChangeSkinType(i);
        this.lsL.notifyDataSetChanged();
    }
}
