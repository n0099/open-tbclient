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
    private af LQ;
    private g bxP;
    private e bxQ;
    private j bxR;
    private d bxS;
    private TRForumListData bxT;
    private List<d> bxV;
    private List<af> bxW;
    private int bxU = 0;
    private int bxX = 0;
    private l bxY = new a(this);
    private ae aJB = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.bxP = new g(this);
        this.bxP.cI(true);
    }

    private void initData() {
        this.bxQ = new e(this);
        this.bxP.a(this.bxQ);
        this.bxR = new j(this);
        this.bxR.a(this.bxY);
        this.bxR.LoadData();
        this.bxV = new LinkedList();
        this.bxW = new LinkedList();
        this.bxP.b(this.aJB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aa(int i, int i2) {
        if (this.bxT != null && i < this.bxT.forum_list.length) {
            this.bxT.forum_list[i].is_like = 1;
            this.bxQ.notifyDataSetChanged();
            this.bxU++;
            this.bxP.gK(this.bxU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ab(int i, int i2) {
        if (this.bxT != null && i < this.bxT.forum_list.length) {
            this.bxT.forum_list[i].is_like = 0;
            this.bxQ.notifyDataSetChanged();
            if (this.bxU != 0) {
                this.bxU--;
            }
            this.bxP.gK(this.bxU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void WD() {
        this.bxX++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void WE() {
        if (this.bxX != 0) {
            this.bxX--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.bxV.size();
        for (int i = 0; i < size; i++) {
            if (this.bxV.get(i) != null) {
                this.bxV.get(i).cancel();
            }
        }
        int size2 = this.bxW.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.bxW.get(i2) != null) {
                this.bxW.get(i2).KK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bxQ != null) {
            int WH = this.bxQ.WH();
            if (WH != 0) {
                this.bxU += WH;
                this.bxX = WH + this.bxX;
                this.bxP.gK(this.bxU);
            }
            this.bxQ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bxP.onChangeSkinType(i);
        this.bxQ.ac(u.btn_add, u.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int gJ(int i) {
        if (this.bxT == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.bxT.forum_list.length; i2++) {
            if (this.bxT.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bxP.WI()) {
            this.bxQ.WF();
            if (this.bxQ.WG()) {
                this.bxP.WL();
            }
        } else if (view == this.bxP.WJ()) {
            if (this.bxX != 0) {
                showToast(String.valueOf(getPageContext().getString(y.top_rec_like_finish_a)) + this.bxX + getPageContext().getString(y.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
        } else if (this.bxT != null && this.bxT.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.bxT.forum_list.length != 0) {
                int gJ = gJ(intValue);
                if (this.bxT.forum_list[gJ].is_like == 1) {
                    ab(gJ, intValue);
                    this.bxS = new d(this, null);
                    this.bxV.add(this.bxS);
                    this.bxS.setPriority(2);
                    this.bxS.execute(Integer.valueOf(intValue));
                    return;
                }
                this.LQ = new af(getPageContext());
                if (!this.LQ.ale()) {
                    this.bxW.add(this.LQ);
                    aa(gJ, intValue);
                    this.LQ.setLoadDataCallBack(new c(this, gJ, intValue));
                    this.LQ.setFrom("from_topRec");
                    this.LQ.aV(this.bxT.forum_list[gJ].forum_name, String.valueOf(this.bxT.forum_list[gJ].forum_id));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bxX != 0) {
            showToast(String.valueOf(getPageContext().getString(y.top_rec_like_finish_a)) + this.bxX + getPageContext().getString(y.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
    }
}
