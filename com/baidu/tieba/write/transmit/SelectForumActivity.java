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
    private BdListView Hj;
    private View aol;
    private View dTe;
    private TextView eCZ;
    private View eDb;
    private b gTI;
    private LinearLayout gTK;
    private ImageView gTL;
    private TextView gTM;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private TextView mTitleView;
    private List<TransmitForumData> mDataList = new ArrayList();
    private List<TransmitForumData> gTJ = new ArrayList();
    private int mFrom = 0;
    private long mLiveId = -1;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != SelectForumActivity.this.eCZ.getId()) {
                    if (view.getId() != SelectForumActivity.this.dTe.getId()) {
                        if (view.getId() == SelectForumActivity.this.gTL.getId() || view.getId() == SelectForumActivity.this.gTM.getId()) {
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
                    SelectForumActivity.this.aC(arrayList);
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
            if (transmitForumData != null && transmitForumData.aaB) {
                SelectForumActivity.this.showToast(d.j.cur_forum_can_not_cancel);
                return;
            }
            CheckBox checkBox = (CheckBox) view.findViewById(d.g.transmit_check_box);
            boolean isChecked = checkBox.isChecked();
            boolean bDB = SelectForumActivity.this.bDB();
            if (!isChecked && bDB) {
                SelectForumActivity.this.showToast(d.j.transmit_max_commit);
                return;
            }
            checkBox.setChecked(!checkBox.isChecked());
            if (transmitForumData != null) {
                transmitForumData.checked = checkBox.isChecked();
            }
            SelectForumActivity.this.aOT();
            SelectForumActivity.this.a(transmitForumData);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.select_forum_activity);
        initData();
        this.mRootView = findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.dTe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.dTe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTe.getLayoutParams();
            layoutParams.leftMargin = l.f(getActivity(), d.e.ds10);
            this.dTe.setLayoutParams(layoutParams);
        }
        if (this.mFrom == 1) {
            this.mTitleView = this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.select_share_forum_bar));
        } else {
            this.mTitleView = this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.transmit_title));
        }
        this.dTe.setOnClickListener(this.mOnClickListener);
        this.gTK = (LinearLayout) findViewById(d.g.layout_search_result);
        this.gTL = (ImageView) findViewById(d.g.icon_search);
        this.gTL.setOnClickListener(this.mOnClickListener);
        this.gTM = (TextView) findViewById(d.g.textview_search);
        this.gTM.setOnClickListener(this.mOnClickListener);
        this.aol = findViewById(d.g.view_divider);
        this.eCZ = (TextView) findViewById(d.g.transmit_confirm);
        this.eCZ.setOnClickListener(this.mOnClickListener);
        this.eDb = findViewById(d.g.layout_confirm);
        this.Hj = (BdListView) findViewById(d.g.trasmit_grid_view);
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (v.u(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
        }
        for (TransmitForumData transmitForumData : this.mDataList) {
            a(transmitForumData);
        }
        this.Hj.setOnItemClickListener(this.mOnItemClickListener);
        this.Hj.addFooterView(LayoutInflater.from(getActivity()).inflate(d.h.select_forum_footer, (ViewGroup) null));
        this.gTI = new b(getActivity());
        this.Hj.setAdapter((ListAdapter) this.gTI);
        this.gTI.Z(this.mDataList);
        aOT();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void initData() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getIntExtra("extra_key_from", 0);
            this.mLiveId = getIntent().getLongExtra("extra_key_live_id", -1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(ArrayList<TransmitForumData> arrayList) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaWriteShareInBarActivityConfig(getPageContext().getPageActivity(), arrayList, String.valueOf(this.mLiveId))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TransmitForumData transmitForumData) {
        if (transmitForumData != null) {
            int i = 0;
            while (true) {
                if (i >= this.gTJ.size()) {
                    i = -1;
                    break;
                }
                TransmitForumData transmitForumData2 = this.gTJ.get(i);
                if (transmitForumData2 != null && transmitForumData.forumId == transmitForumData2.forumId) {
                    break;
                }
                i++;
            }
            if (transmitForumData.checked) {
                if (i == -1) {
                    this.gTL.setVisibility(8);
                    BarImageView barImageView = new BarImageView(getActivity());
                    int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds80);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.e.ds24);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = dimensionPixelSize2;
                    layoutParams.gravity = 16;
                    this.gTK.addView(barImageView, this.gTJ.size(), layoutParams);
                    barImageView.startLoad(transmitForumData.avatar, 10, false);
                    this.gTJ.add(transmitForumData);
                    this.gTM.setText(d.j.search);
                    return;
                }
                return;
            }
            if (i >= 0 && i < this.gTJ.size() && i < this.gTK.getChildCount()) {
                this.gTJ.remove(i);
                this.gTK.removeViewAt(i);
            }
            if (this.gTJ.size() == 0) {
                this.gTL.setVisibility(0);
                if (this.mFrom == 1) {
                    this.gTM.setText(d.j.search_forum_you_want_to_share);
                } else {
                    this.gTM.setText(d.j.search_forum_you_want);
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
                if (bDB()) {
                    showToast(d.j.transmit_max_commit);
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
                    aOT();
                }
                this.gTI.Z(this.mDataList);
                this.Hj.setSelection(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDB() {
        return v.u(bDE()) >= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOT() {
        this.eCZ.setText(getResources().getString(d.j.transmit_confirm, Integer.valueOf(v.u(bDE())), 3));
    }

    public ArrayList<TransmitForumData> bDE() {
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
        aj.i(this.mTitleView, d.C0080d.cp_cont_b);
        aj.i(this.gTM, d.C0080d.cp_cont_d);
        aj.c(this.gTL, d.f.icon_input_search_n);
        aj.j(this.eCZ, d.f.btn_all_blue);
        aj.c(this.eCZ, d.C0080d.cp_cont_g, 1);
        aj.k(this.mRootView, d.C0080d.cp_bg_line_d);
        aj.k(this.aol, d.C0080d.cp_bg_line_c);
        this.gTI.pk(i);
        this.Hj.setSelector(aj.getDrawable(d.f.selector_select_forum_item));
        aj.k(this.eDb, d.C0080d.cp_bg_line_d_alpha95);
    }
}
