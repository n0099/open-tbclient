package com.baidu.tieba.topRec;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.model.ag;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity {
    private ag avA;
    private g bPB;
    private e bPC;
    private j bPD;
    private d bPE;
    private TRForumListData bPF;
    private List<d> bPH;
    private List<ag> bPI;
    private int bPG = 0;
    private int bPJ = 0;
    private l bPK = new a(this);
    private com.baidu.adp.widget.ListView.f avS = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.bPB = new g(this);
        this.bPB.da(true);
    }

    private void initData() {
        this.bPC = new e(this);
        this.bPB.a(this.bPC);
        this.bPD = new j(this);
        this.bPD.a(this.bPK);
        this.bPD.LoadData();
        this.bPH = new LinkedList();
        this.bPI = new LinkedList();
        this.bPB.b(this.avS);
    }

    public static void aj(Context context) {
        context.startActivity(new Intent(context, TopRecActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void W(int i, int i2) {
        if (this.bPF != null && i < this.bPF.forum_list.length) {
            this.bPF.forum_list[i].is_like = 1;
            this.bPC.notifyDataSetChanged();
            this.bPG++;
            this.bPB.hv(this.bPG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void X(int i, int i2) {
        if (this.bPF != null && i < this.bPF.forum_list.length) {
            this.bPF.forum_list[i].is_like = 0;
            this.bPC.notifyDataSetChanged();
            if (this.bPG != 0) {
                this.bPG--;
            }
            this.bPB.hv(this.bPG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aer() {
        this.bPJ++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aes() {
        if (this.bPJ != 0) {
            this.bPJ--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.bPH.size();
        for (int i = 0; i < size; i++) {
            if (this.bPH.get(i) != null) {
                this.bPH.get(i).cancel();
            }
        }
        int size2 = this.bPI.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.bPI.get(i2) != null) {
                this.bPI.get(i2).TI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bPC != null) {
            int aev = this.bPC.aev();
            if (aev != 0) {
                this.bPG += aev;
                this.bPJ = aev + this.bPJ;
                this.bPB.hv(this.bPG);
            }
            this.bPC.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bPB.onChangeSkinType(i);
        this.bPC.H(u.btn_add, u.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hu(int i) {
        if (this.bPF == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.bPF.forum_list.length; i2++) {
            if (this.bPF.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bPB.aew()) {
            this.bPC.aet();
            if (this.bPC.aeu()) {
                this.bPB.aez();
            }
        } else if (view == this.bPB.aex()) {
            if (this.bPJ != 0) {
                showToast(String.valueOf(getString(y.top_rec_like_finish_a)) + this.bPJ + getString(y.top_rec_like_finish_b));
                TiebaStatic.eventStat(this, "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(this, "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.b.b.d(this, 1);
        } else if (this.bPF != null && this.bPF.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.bPF.forum_list.length != 0) {
                int hu = hu(intValue);
                if (this.bPF.forum_list[hu].is_like == 1) {
                    X(hu, intValue);
                    this.bPE = new d(this, null);
                    this.bPH.add(this.bPE);
                    this.bPE.setPriority(2);
                    this.bPE.execute(Integer.valueOf(intValue));
                    return;
                }
                this.avA = new ag(this);
                if (!this.avA.TJ()) {
                    this.bPI.add(this.avA);
                    W(hu, intValue);
                    this.avA.setLoadDataCallBack(new c(this, hu, intValue));
                    this.avA.setFrom("from_topRec");
                    this.avA.ay(this.bPF.forum_list[hu].forum_name, String.valueOf(this.bPF.forum_list[hu].forum_id));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bPJ != 0) {
            showToast(String.valueOf(getString(y.top_rec_like_finish_a)) + this.bPJ + getString(y.top_rec_like_finish_b));
            TiebaStatic.eventStat(this, "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(this, "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.b.b.d(this, 1);
    }
}
