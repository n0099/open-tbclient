package com.baidu.tieba.launcherGuide.topRec;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private af LO;
    private e bxA;
    private j bxB;
    private d bxC;
    private TRForumListData bxD;
    private List<d> bxF;
    private List<af> bxG;
    private g bxz;
    private int bxE = 0;
    private int bxH = 0;
    private l bxI = new a(this);
    private ae aJr = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.bxz = new g(this);
        this.bxz.cK(true);
    }

    private void initData() {
        this.bxA = new e(this);
        this.bxz.a(this.bxA);
        this.bxB = new j(this);
        this.bxB.a(this.bxI);
        this.bxB.LoadData();
        this.bxF = new LinkedList();
        this.bxG = new LinkedList();
        this.bxz.b(this.aJr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aa(int i, int i2) {
        if (this.bxD != null && i < this.bxD.forum_list.length) {
            this.bxD.forum_list[i].is_like = 1;
            this.bxA.notifyDataSetChanged();
            this.bxE++;
            this.bxz.gI(this.bxE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ab(int i, int i2) {
        if (this.bxD != null && i < this.bxD.forum_list.length) {
            this.bxD.forum_list[i].is_like = 0;
            this.bxA.notifyDataSetChanged();
            if (this.bxE != 0) {
                this.bxE--;
            }
            this.bxz.gI(this.bxE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Wq() {
        this.bxH++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Wr() {
        if (this.bxH != 0) {
            this.bxH--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.bxF.size();
        for (int i = 0; i < size; i++) {
            if (this.bxF.get(i) != null) {
                this.bxF.get(i).cancel();
            }
        }
        int size2 = this.bxG.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.bxG.get(i2) != null) {
                this.bxG.get(i2).KA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bxA != null) {
            int Wu = this.bxA.Wu();
            if (Wu != 0) {
                this.bxE += Wu;
                this.bxH = Wu + this.bxH;
                this.bxz.gI(this.bxE);
            }
            this.bxA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bxz.onChangeSkinType(i);
        this.bxA.ac(u.btn_add, u.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gH(int i) {
        if (this.bxD == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.bxD.forum_list.length; i2++) {
            if (this.bxD.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bxz.Wv()) {
            this.bxA.Ws();
            if (this.bxA.Wt()) {
                this.bxz.Wy();
            }
        } else if (view == this.bxz.Ww()) {
            if (this.bxH != 0) {
                showToast(String.valueOf(getPageContext().getString(y.top_rec_like_finish_a)) + this.bxH + getPageContext().getString(y.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
        } else if (this.bxD != null && this.bxD.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.bxD.forum_list.length != 0) {
                int gH = gH(intValue);
                if (this.bxD.forum_list[gH].is_like == 1) {
                    ab(gH, intValue);
                    this.bxC = new d(this, null);
                    this.bxF.add(this.bxC);
                    this.bxC.setPriority(2);
                    this.bxC.execute(Integer.valueOf(intValue));
                    return;
                }
                this.LO = new af(getPageContext());
                if (!this.LO.akP()) {
                    this.bxG.add(this.LO);
                    aa(gH, intValue);
                    this.LO.setLoadDataCallBack(new c(this, gH, intValue));
                    this.LO.setFrom("from_topRec");
                    this.LO.aV(this.bxD.forum_list[gH].forum_name, String.valueOf(this.bxD.forum_list[gH].forum_id));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bxH != 0) {
            showToast(String.valueOf(getPageContext().getString(y.top_rec_like_finish_a)) + this.bxH + getPageContext().getString(y.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
    }
}
