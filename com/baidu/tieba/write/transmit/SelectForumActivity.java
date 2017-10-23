package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    private BdListView HO;
    private TextView aaS;
    private View anR;
    private View dLn;
    private TextView euw;
    private View euy;
    private b gIC;
    private LinearLayout gIE;
    private ImageView gIF;
    private TextView gIG;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<TransmitForumData> mDataList = new ArrayList();
    private List<TransmitForumData> gID = new ArrayList();
    private int mFrom = 0;
    private long mLiveId = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != SelectForumActivity.this.euw.getId()) {
                    if (view.getId() != SelectForumActivity.this.dLn.getId()) {
                        if (view.getId() == SelectForumActivity.this.gIF.getId() || view.getId() == SelectForumActivity.this.gIG.getId()) {
                            ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(SelectForumActivity.this.getPageContext().getPageActivity());
                            if (SelectForumActivity.this.mFrom == 1) {
                                forumSearchActivityConfig.setFrom(1);
                            }
                            forumSearchActivityConfig.setRequestCode(25019);
                            forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumSearchActivityConfig));
                            TiebaStatic.log("c12259");
                            return;
                        }
                        return;
                    }
                    SelectForumActivity.this.setResult(0);
                    SelectForumActivity.this.finish();
                    return;
                }
                Intent intent = new Intent();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (f fVar : SelectForumActivity.this.mDataList) {
                    if (fVar instanceof TransmitForumData) {
                        arrayList.add((TransmitForumData) fVar);
                    }
                }
                if (SelectForumActivity.this.mFrom == 1 && SelectForumActivity.this.mLiveId > 0) {
                    SelectForumActivity.this.aB(arrayList);
                    SelectForumActivity.this.finish();
                    return;
                }
                intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                SelectForumActivity.this.setResult(-1, intent);
                SelectForumActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TransmitForumData transmitForumData = (TransmitForumData) SelectForumActivity.this.mDataList.get(i);
            if (transmitForumData != null && transmitForumData.aae) {
                SelectForumActivity.this.showToast(d.l.cur_forum_can_not_cancel);
                return;
            }
            CheckBox checkBox = (CheckBox) view.findViewById(d.h.transmit_check_box);
            boolean isChecked = checkBox.isChecked();
            boolean bzR = SelectForumActivity.this.bzR();
            if (!isChecked && bzR) {
                SelectForumActivity.this.showToast(d.l.transmit_max_commit);
                return;
            }
            checkBox.setChecked(!checkBox.isChecked());
            if (transmitForumData != null) {
                transmitForumData.checked = checkBox.isChecked();
            }
            SelectForumActivity.this.aLT();
            SelectForumActivity.this.a(transmitForumData);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.select_forum_activity);
        initData();
        this.mRootView = findViewById(d.h.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.view_navigation_bar);
        this.dLn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.dLn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLn.getLayoutParams();
            layoutParams.leftMargin = l.f(getActivity(), d.f.ds10);
            this.dLn.setLayoutParams(layoutParams);
        }
        if (this.mFrom == 1) {
            this.aaS = this.mNavigationBar.setCenterTextTitle(getResources().getString(d.l.select_share_forum_bar));
        } else {
            this.aaS = this.mNavigationBar.setCenterTextTitle(getResources().getString(d.l.transmit_title));
        }
        this.dLn.setOnClickListener(this.mOnClickListener);
        this.gIE = (LinearLayout) findViewById(d.h.layout_search_result);
        this.gIF = (ImageView) findViewById(d.h.icon_search);
        this.gIF.setOnClickListener(this.mOnClickListener);
        this.gIG = (TextView) findViewById(d.h.textview_search);
        this.gIG.setOnClickListener(this.mOnClickListener);
        this.anR = findViewById(d.h.view_divider);
        this.euw = (TextView) findViewById(d.h.transmit_confirm);
        this.euw.setOnClickListener(this.mOnClickListener);
        this.euy = findViewById(d.h.layout_confirm);
        this.HO = (BdListView) findViewById(d.h.trasmit_grid_view);
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (v.t(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
        }
        for (TransmitForumData transmitForumData : this.mDataList) {
            a(transmitForumData);
        }
        this.HO.setOnItemClickListener(this.mOnItemClickListener);
        this.HO.addFooterView(LayoutInflater.from(getActivity()).inflate(d.j.select_forum_footer, (ViewGroup) null));
        this.gIC = new b(getActivity());
        this.HO.setAdapter((ListAdapter) this.gIC);
        this.gIC.Z(this.mDataList);
        aLT();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("extra_key_from", 0);
            this.mLiveId = getIntent().getLongExtra("extra_key_live_id", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(ArrayList<TransmitForumData> arrayList) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(getPageContext().getPageActivity(), arrayList, String.valueOf(this.mLiveId))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TransmitForumData transmitForumData) {
        if (transmitForumData != null) {
            int i = 0;
            while (true) {
                if (i >= this.gID.size()) {
                    i = -1;
                    break;
                }
                TransmitForumData transmitForumData2 = this.gID.get(i);
                if (transmitForumData2 != null && transmitForumData.forumId == transmitForumData2.forumId) {
                    break;
                }
                i++;
            }
            if (transmitForumData.checked) {
                if (i == -1) {
                    this.gIF.setVisibility(8);
                    BarImageView barImageView = new BarImageView(getActivity());
                    int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds80);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds24);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = dimensionPixelSize2;
                    layoutParams.gravity = 16;
                    this.gIE.addView(barImageView, this.gID.size(), layoutParams);
                    barImageView.c(transmitForumData.avatar, 10, false);
                    this.gID.add(transmitForumData);
                    this.gIG.setText(d.l.search);
                    return;
                }
                return;
            }
            if (i >= 0 && i < this.gID.size() && i < this.gIE.getChildCount()) {
                this.gID.remove(i);
                this.gIE.removeViewAt(i);
            }
            if (this.gID.size() == 0) {
                this.gIF.setVisibility(0);
                if (this.mFrom == 1) {
                    this.gIG.setText(d.l.search_forum_you_want_to_share);
                } else {
                    this.gIG.setText(d.l.search_forum_you_want);
                }
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
                if (bzR()) {
                    showToast(d.l.transmit_max_commit);
                    if (i3 != -1) {
                        this.mDataList.add(0, this.mDataList.remove(i3));
                    } else {
                        this.mDataList.add(0, new TransmitForumData(longExtra, stringExtra, false, 0, stringExtra2));
                    }
                } else {
                    if (i3 != -1) {
                        transmitForumData = this.mDataList.remove(i3);
                        transmitForumData.checked = true;
                        this.mDataList.add(0, transmitForumData);
                    } else {
                        TransmitForumData transmitForumData3 = new TransmitForumData(longExtra, stringExtra, true, 0, stringExtra2);
                        this.mDataList.add(0, transmitForumData3);
                        transmitForumData = transmitForumData3;
                    }
                    a(transmitForumData);
                    aLT();
                }
                this.gIC.Z(this.mDataList);
                this.HO.setSelection(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzR() {
        return v.t(bzU()) >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLT() {
        this.euw.setText(getResources().getString(d.l.transmit_confirm, Integer.valueOf(v.t(bzU())), 3));
    }

    public ArrayList<TransmitForumData> bzU() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData instanceof TransmitForumData) {
                TransmitForumData transmitForumData2 = transmitForumData;
                if (transmitForumData2.checked) {
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
        aj.i(this.aaS, d.e.cp_cont_b);
        aj.i(this.gIG, d.e.cp_cont_d);
        aj.c(this.gIF, d.g.icon_input_search_n);
        aj.j(this.euw, d.g.btn_all_blue);
        aj.c(this.euw, d.e.cp_cont_g, 1);
        aj.k(this.mRootView, d.e.cp_bg_line_d);
        aj.k(this.anR, d.e.cp_bg_line_c);
        this.gIC.oP(i);
        this.HO.setSelector(aj.getDrawable(d.g.selector_select_forum_item));
        aj.k(this.euy, d.e.cp_bg_line_d_alpha95);
    }
}
