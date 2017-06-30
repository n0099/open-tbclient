package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    private BdListView Ib;
    private TextView aab;
    private View ben;
    private View dyF;
    private TextView gho;
    private d ghp;
    private LinearLayout ghr;
    private ImageView ghs;
    private TextView ght;
    private View ghu;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<TransmitForumData> mDataList = new ArrayList();
    private List<TransmitForumData> ghq = new ArrayList();
    private View.OnClickListener mOnClickListener = new b(this);
    private AdapterView.OnItemClickListener mOnItemClickListener = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.select_forum_activity);
        this.mRootView = findViewById(w.h.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(w.h.view_navigation_bar);
        this.dyF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.dyF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dyF.getLayoutParams();
            layoutParams.leftMargin = com.baidu.adp.lib.util.k.g(getActivity(), w.f.ds10);
            this.dyF.setLayoutParams(layoutParams);
        }
        this.aab = this.mNavigationBar.setCenterTextTitle(getResources().getString(w.l.transmit_title));
        this.dyF.setOnClickListener(this.mOnClickListener);
        this.ghr = (LinearLayout) findViewById(w.h.layout_search_result);
        this.ghs = (ImageView) findViewById(w.h.icon_search);
        this.ghs.setOnClickListener(this.mOnClickListener);
        this.ght = (TextView) findViewById(w.h.textview_search);
        this.ght.setOnClickListener(this.mOnClickListener);
        this.ben = findViewById(w.h.view_divider);
        this.gho = (TextView) findViewById(w.h.transmit_confirm);
        this.gho.setOnClickListener(this.mOnClickListener);
        this.ghu = findViewById(w.h.layout_confirm);
        this.Ib = (BdListView) findViewById(w.h.trasmit_grid_view);
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(SelectForumActivityConfig.KEY_INPUT_FORUM_LIST);
            if (z.s(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
        }
        for (TransmitForumData transmitForumData : this.mDataList) {
            a(transmitForumData);
        }
        this.Ib.setOnItemClickListener(this.mOnItemClickListener);
        this.Ib.addFooterView(LayoutInflater.from(getActivity()).inflate(w.j.select_forum_footer, (ViewGroup) null));
        this.ghp = new d(getActivity());
        this.Ib.setAdapter((ListAdapter) this.ghp);
        this.ghp.U(this.mDataList);
        bsU();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TransmitForumData transmitForumData) {
        if (transmitForumData != null) {
            int i = 0;
            while (true) {
                if (i >= this.ghq.size()) {
                    i = -1;
                    break;
                }
                TransmitForumData transmitForumData2 = this.ghq.get(i);
                if (transmitForumData2 != null && transmitForumData.forumId == transmitForumData2.forumId) {
                    break;
                }
                i++;
            }
            if (transmitForumData.aaP) {
                if (i == -1) {
                    this.ghs.setVisibility(8);
                    BarImageView barImageView = new BarImageView(getActivity());
                    int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds80);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(w.f.ds24);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = dimensionPixelSize2;
                    layoutParams.gravity = 16;
                    this.ghr.addView(barImageView, this.ghq.size(), layoutParams);
                    barImageView.c(transmitForumData.avatar, 10, false);
                    this.ghq.add(transmitForumData);
                    this.ght.setText(w.l.search);
                    return;
                }
                return;
            }
            if (i >= 0 && i < this.ghq.size() && i < this.ghr.getChildCount()) {
                this.ghq.remove(i);
                this.ghr.removeViewAt(i);
            }
            if (this.ghq.size() == 0) {
                this.ghs.setVisibility(0);
                this.ght.setText(w.l.search_forum_you_want);
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        TransmitForumData transmitForumData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25019 && intent != null) {
            long longExtra = intent.getLongExtra("forum_id", 0L);
            String stringExtra = intent.getStringExtra("forum_name");
            if (longExtra != 0 && !StringUtils.isNull(stringExtra)) {
                String stringExtra2 = intent.getStringExtra("forum_avatar");
                int i4 = 0;
                while (true) {
                    i3 = i4;
                    if (i3 >= this.mDataList.size()) {
                        i3 = -1;
                        break;
                    }
                    TransmitForumData transmitForumData2 = this.mDataList.get(i3);
                    if (transmitForumData2 != null && transmitForumData2.forumId == longExtra) {
                        break;
                    }
                    i4 = i3 + 1;
                }
                if (bsR()) {
                    showToast(w.l.transmit_max_commit);
                    if (i3 != -1) {
                        this.mDataList.add(0, this.mDataList.remove(i3));
                    } else {
                        this.mDataList.add(0, new TransmitForumData(longExtra, stringExtra, false, 0, stringExtra2));
                    }
                } else {
                    if (i3 != -1) {
                        transmitForumData = this.mDataList.remove(i3);
                        transmitForumData.aaP = true;
                        this.mDataList.add(0, transmitForumData);
                    } else {
                        transmitForumData = new TransmitForumData(longExtra, stringExtra, true, 0, stringExtra2);
                        this.mDataList.add(0, transmitForumData);
                    }
                    a(transmitForumData);
                    bsU();
                }
                this.ghp.U(this.mDataList);
                this.Ib.setSelection(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsR() {
        return z.s(bsV()) >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsU() {
        this.gho.setText(getResources().getString(w.l.transmit_confirm, Integer.valueOf(z.s(bsV())), 3));
    }

    public ArrayList<TransmitForumData> bsV() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData instanceof TransmitForumData) {
                TransmitForumData transmitForumData2 = transmitForumData;
                if (transmitForumData2.aaP) {
                    arrayList.add(transmitForumData2);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        as.i(this.aab, w.e.cp_cont_b);
        as.i(this.ght, w.e.cp_cont_d);
        as.c(this.ghs, w.g.icon_input_search_n);
        as.j(this.gho, w.g.btn_all_blue);
        as.c(this.gho, w.e.cp_cont_g, 1);
        as.k(this.mRootView, w.e.cp_bg_line_d);
        as.k(this.ben, w.e.cp_bg_line_c);
        this.ghp.tL(i);
        this.Ib.setSelector(as.getDrawable(w.g.selector_select_forum_item));
        as.k(this.ghu, w.e.cp_bg_line_d_alpha95);
    }
}
