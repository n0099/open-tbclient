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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    private BdListView Ib;
    private TextView aaA;
    private View bfY;
    private View dHh;
    private TextView gBn;
    private b gBo;
    private LinearLayout gBq;
    private ImageView gBr;
    private TextView gBs;
    private View gBt;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private List<TransmitForumData> mDataList = new ArrayList();
    private List<TransmitForumData> gBp = new ArrayList();
    private int mFrom = 0;
    private long mLiveId = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != SelectForumActivity.this.gBn.getId()) {
                    if (view.getId() != SelectForumActivity.this.dHh.getId()) {
                        if (view.getId() == SelectForumActivity.this.gBr.getId() || view.getId() == SelectForumActivity.this.gBs.getId()) {
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
                    SelectForumActivity.this.aD(arrayList);
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
            if (transmitForumData != null && transmitForumData.ZN) {
                SelectForumActivity.this.showToast(d.l.cur_forum_can_not_cancel);
                return;
            }
            CheckBox checkBox = (CheckBox) view.findViewById(d.h.transmit_check_box);
            boolean isChecked = checkBox.isChecked();
            boolean byA = SelectForumActivity.this.byA();
            if (!isChecked && byA) {
                SelectForumActivity.this.showToast(d.l.transmit_max_commit);
                return;
            }
            checkBox.setChecked(!checkBox.isChecked());
            if (transmitForumData != null) {
                transmitForumData.ZM = checkBox.isChecked();
            }
            SelectForumActivity.this.byD();
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
        this.dHh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.dHh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dHh.getLayoutParams();
            layoutParams.leftMargin = k.g(getActivity(), d.f.ds10);
            this.dHh.setLayoutParams(layoutParams);
        }
        if (this.mFrom == 1) {
            this.aaA = this.mNavigationBar.setCenterTextTitle(getResources().getString(d.l.select_share_forum_bar));
        } else {
            this.aaA = this.mNavigationBar.setCenterTextTitle(getResources().getString(d.l.transmit_title));
        }
        this.dHh.setOnClickListener(this.mOnClickListener);
        this.gBq = (LinearLayout) findViewById(d.h.layout_search_result);
        this.gBr = (ImageView) findViewById(d.h.icon_search);
        this.gBr.setOnClickListener(this.mOnClickListener);
        this.gBs = (TextView) findViewById(d.h.textview_search);
        this.gBs.setOnClickListener(this.mOnClickListener);
        this.bfY = findViewById(d.h.view_divider);
        this.gBn = (TextView) findViewById(d.h.transmit_confirm);
        this.gBn.setOnClickListener(this.mOnClickListener);
        this.gBt = findViewById(d.h.layout_confirm);
        this.Ib = (BdListView) findViewById(d.h.trasmit_grid_view);
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(SelectForumActivityConfig.KEY_INPUT_FORUM_LIST);
            if (u.u(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
        }
        for (TransmitForumData transmitForumData : this.mDataList) {
            a(transmitForumData);
        }
        this.Ib.setOnItemClickListener(this.mOnItemClickListener);
        this.Ib.addFooterView(LayoutInflater.from(getActivity()).inflate(d.j.select_forum_footer, (ViewGroup) null));
        this.gBo = new b(getActivity());
        this.Ib.setAdapter((ListAdapter) this.gBo);
        this.gBo.Z(this.mDataList);
        byD();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("extra_key_from", 0);
            this.mLiveId = getIntent().getLongExtra("extra_key_live_id", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(ArrayList<TransmitForumData> arrayList) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(getPageContext().getPageActivity(), arrayList, String.valueOf(this.mLiveId))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TransmitForumData transmitForumData) {
        if (transmitForumData != null) {
            int i = 0;
            while (true) {
                if (i >= this.gBp.size()) {
                    i = -1;
                    break;
                }
                TransmitForumData transmitForumData2 = this.gBp.get(i);
                if (transmitForumData2 != null && transmitForumData.forumId == transmitForumData2.forumId) {
                    break;
                }
                i++;
            }
            if (transmitForumData.ZM) {
                if (i == -1) {
                    this.gBr.setVisibility(8);
                    BarImageView barImageView = new BarImageView(getActivity());
                    int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds80);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f.ds24);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = dimensionPixelSize2;
                    layoutParams.gravity = 16;
                    this.gBq.addView(barImageView, this.gBp.size(), layoutParams);
                    barImageView.c(transmitForumData.avatar, 10, false);
                    this.gBp.add(transmitForumData);
                    this.gBs.setText(d.l.search);
                    return;
                }
                return;
            }
            if (i >= 0 && i < this.gBp.size() && i < this.gBq.getChildCount()) {
                this.gBp.remove(i);
                this.gBq.removeViewAt(i);
            }
            if (this.gBp.size() == 0) {
                this.gBr.setVisibility(0);
                if (this.mFrom == 1) {
                    this.gBs.setText(d.l.search_forum_you_want_to_share);
                } else {
                    this.gBs.setText(d.l.search_forum_you_want);
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
                if (byA()) {
                    showToast(d.l.transmit_max_commit);
                    if (i3 != -1) {
                        this.mDataList.add(0, this.mDataList.remove(i3));
                    } else {
                        this.mDataList.add(0, new TransmitForumData(longExtra, stringExtra, false, 0, stringExtra2));
                    }
                } else {
                    if (i3 != -1) {
                        transmitForumData = this.mDataList.remove(i3);
                        transmitForumData.ZM = true;
                        this.mDataList.add(0, transmitForumData);
                    } else {
                        TransmitForumData transmitForumData3 = new TransmitForumData(longExtra, stringExtra, true, 0, stringExtra2);
                        this.mDataList.add(0, transmitForumData3);
                        transmitForumData = transmitForumData3;
                    }
                    a(transmitForumData);
                    byD();
                }
                this.gBo.Z(this.mDataList);
                this.Ib.setSelection(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byA() {
        return u.u(byE()) >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byD() {
        this.gBn.setText(getResources().getString(d.l.transmit_confirm, Integer.valueOf(u.u(byE())), 3));
    }

    public ArrayList<TransmitForumData> byE() {
        ArrayList<TransmitForumData> arrayList = new ArrayList<>();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData instanceof TransmitForumData) {
                TransmitForumData transmitForumData2 = transmitForumData;
                if (transmitForumData2.ZM) {
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
        ai.i(this.aaA, d.e.cp_cont_b);
        ai.i(this.gBs, d.e.cp_cont_d);
        ai.c(this.gBr, d.g.icon_input_search_n);
        ai.j(this.gBn, d.g.btn_all_blue);
        ai.c(this.gBn, d.e.cp_cont_g, 1);
        ai.k(this.mRootView, d.e.cp_bg_line_d);
        ai.k(this.bfY, d.e.cp_bg_line_c);
        this.gBo.um(i);
        this.Ib.setSelector(ai.getDrawable(d.g.selector_select_forum_item));
        ai.k(this.gBt, d.e.cp_bg_line_d_alpha95);
    }
}
