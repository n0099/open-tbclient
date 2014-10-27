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
    private ag avr;
    private g bPm;
    private e bPn;
    private j bPo;
    private d bPp;
    private TRForumListData bPq;
    private List<d> bPs;
    private List<ag> bPt;
    private int bPr = 0;
    private int bPu = 0;
    private l bPv = new a(this);
    private com.baidu.adp.widget.ListView.f avJ = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.bPm = new g(this);
        this.bPm.da(true);
    }

    private void initData() {
        this.bPn = new e(this);
        this.bPm.a(this.bPn);
        this.bPo = new j(this);
        this.bPo.a(this.bPv);
        this.bPo.LoadData();
        this.bPs = new LinkedList();
        this.bPt = new LinkedList();
        this.bPm.b(this.avJ);
    }

    public static void aj(Context context) {
        context.startActivity(new Intent(context, TopRecActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void W(int i, int i2) {
        if (this.bPq != null && i < this.bPq.forum_list.length) {
            this.bPq.forum_list[i].is_like = 1;
            this.bPn.notifyDataSetChanged();
            this.bPr++;
            this.bPm.hv(this.bPr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void X(int i, int i2) {
        if (this.bPq != null && i < this.bPq.forum_list.length) {
            this.bPq.forum_list[i].is_like = 0;
            this.bPn.notifyDataSetChanged();
            if (this.bPr != 0) {
                this.bPr--;
            }
            this.bPm.hv(this.bPr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aeo() {
        this.bPu++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aep() {
        if (this.bPu != 0) {
            this.bPu--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.bPs.size();
        for (int i = 0; i < size; i++) {
            if (this.bPs.get(i) != null) {
                this.bPs.get(i).cancel();
            }
        }
        int size2 = this.bPt.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.bPt.get(i2) != null) {
                this.bPt.get(i2).TF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bPn != null) {
            int aes = this.bPn.aes();
            if (aes != 0) {
                this.bPr += aes;
                this.bPu = aes + this.bPu;
                this.bPm.hv(this.bPr);
            }
            this.bPn.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bPm.onChangeSkinType(i);
        this.bPn.H(u.btn_add, u.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hu(int i) {
        if (this.bPq == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.bPq.forum_list.length; i2++) {
            if (this.bPq.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bPm.aet()) {
            this.bPn.aeq();
            if (this.bPn.aer()) {
                this.bPm.aew();
            }
        } else if (view == this.bPm.aeu()) {
            if (this.bPu != 0) {
                showToast(String.valueOf(getString(y.top_rec_like_finish_a)) + this.bPu + getString(y.top_rec_like_finish_b));
                TiebaStatic.eventStat(this, "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(this, "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.b.b.d(this, 1);
        } else if (this.bPq != null && this.bPq.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.bPq.forum_list.length != 0) {
                int hu = hu(intValue);
                if (this.bPq.forum_list[hu].is_like == 1) {
                    X(hu, intValue);
                    this.bPp = new d(this, null);
                    this.bPs.add(this.bPp);
                    this.bPp.setPriority(2);
                    this.bPp.execute(Integer.valueOf(intValue));
                    return;
                }
                this.avr = new ag(this);
                if (!this.avr.TG()) {
                    this.bPt.add(this.avr);
                    W(hu, intValue);
                    this.avr.setLoadDataCallBack(new c(this, hu, intValue));
                    this.avr.setFrom("from_topRec");
                    this.avr.ay(this.bPq.forum_list[hu].forum_name, String.valueOf(this.bPq.forum_list[hu].forum_id));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bPu != 0) {
            showToast(String.valueOf(getString(y.top_rec_like_finish_a)) + this.bPu + getString(y.top_rec_like_finish_b));
            TiebaStatic.eventStat(this, "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(this, "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.b.b.d(this, 1);
    }
}
