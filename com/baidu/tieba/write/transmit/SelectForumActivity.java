package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    private BdListView LO;
    private View bHR;
    private OriginalThreadInfo dkM;
    private View eMP;
    private b hwb;
    private LinearLayout hwc;
    private ImageView hwd;
    private TextView hwe;
    private NavigationBar mNavigationBar;
    private int mPrivateThread;
    private View mRootView;
    private TextView mTitleView;
    private List<TransmitForumData> mDataList = new ArrayList();
    private int mFrom = 0;
    private long mLiveId = -1;
    private CustomMessageListener hay = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                SelectForumActivity.this.mDataList.clear();
                SelectForumActivity.this.mDataList.addAll((ArrayList) customResponsedMessage.getData());
                if (SelectForumActivity.this.hwb != null) {
                    SelectForumActivity.this.hwb.cD(SelectForumActivity.this.mDataList);
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != SelectForumActivity.this.eMP.getId()) {
                    if (view.getId() == SelectForumActivity.this.hwd.getId() || view.getId() == SelectForumActivity.this.hwe.getId()) {
                        ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(SelectForumActivity.this.getPageContext().getPageActivity());
                        forumSearchActivityConfig.setFrom(SelectForumActivity.this.mFrom);
                        forumSearchActivityConfig.setLiveId(SelectForumActivity.this.mLiveId);
                        forumSearchActivityConfig.setOriginalThread(SelectForumActivity.this.dkM);
                        forumSearchActivityConfig.setRequestCode(25019);
                        forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        SelectForumActivity.this.sendMessage(new CustomMessage(2002001, forumSearchActivityConfig));
                        TiebaStatic.log("c12259");
                        SelectForumActivity.this.vy(1);
                        return;
                    }
                    return;
                }
                SelectForumActivity.this.setResult(0);
                SelectForumActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.3
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TransmitForumData transmitForumData = (TransmitForumData) SelectForumActivity.this.mDataList.get(i);
            if (transmitForumData != null) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(transmitForumData);
                if (SelectForumActivity.this.mFrom != 1 || SelectForumActivity.this.mLiveId <= 0) {
                    if (SelectForumActivity.this.mFrom == 2) {
                        SelectForumActivity.this.a(transmitForumData, SelectForumActivity.this.mPrivateThread);
                        SelectForumActivity.this.vy(2);
                        SelectForumActivity.this.finish();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                    SelectForumActivity.this.setResult(-1, intent);
                    SelectForumActivity.this.finish();
                    return;
                }
                SelectForumActivity.this.aA(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.select_forum_activity);
        initData();
        initView();
        MessageManager.getInstance().registerListener(this.hay);
    }

    private void initData() {
        if (getIntent() != null) {
            ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (w.y(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            this.mFrom = getIntent().getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0);
            this.mLiveId = getIntent().getLongExtra("extra_key_live_id", -1L);
            this.mPrivateThread = getIntent().getIntExtra(SelectForumActivityConfig.EXTRA_KEY_PRIVATE_THREAD, 0);
            this.dkM = (OriginalThreadInfo) getIntent().getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD);
        }
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.eMP = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.j.cancel));
        if (this.eMP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMP.getLayoutParams();
            layoutParams.leftMargin = l.f(getActivity(), d.e.ds10);
            this.eMP.setLayoutParams(layoutParams);
        }
        this.mTitleView = this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.select_share_forum_bar));
        this.eMP.setOnClickListener(this.mOnClickListener);
        this.hwc = (LinearLayout) findViewById(d.g.layout_search);
        this.hwd = (ImageView) findViewById(d.g.icon_search);
        this.hwd.setOnClickListener(this.mOnClickListener);
        this.hwe = (TextView) findViewById(d.g.textview_search);
        this.hwe.setOnClickListener(this.mOnClickListener);
        this.bHR = findViewById(d.g.view_divider);
        this.LO = (BdListView) findViewById(d.g.trasmit_grid_view);
        this.LO.setOnItemClickListener(this.mOnItemClickListener);
        this.hwb = new b(getActivity());
        this.LO.setAdapter((ListAdapter) this.hwb);
        this.hwb.cD(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(ArrayList<TransmitForumData> arrayList) {
        AlaWriteShareInBarActivityConfig alaWriteShareInBarActivityConfig = new AlaWriteShareInBarActivityConfig(getPageContext().getPageActivity(), arrayList, String.valueOf(this.mLiveId));
        alaWriteShareInBarActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        alaWriteShareInBarActivityConfig.setRequestCode(25038);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alaWriteShareInBarActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TransmitForumData transmitForumData, int i) {
        String str;
        String str2;
        if (transmitForumData != null) {
            str2 = String.valueOf(transmitForumData.forumId);
            str = transmitForumData.forumName;
        } else {
            str = null;
            str2 = null;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(getPageContext().getPageActivity(), 9, str2, str, null, null, 13011, null, null, null, this.dkM);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setPrivateThread(i);
        sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.h(this.eMP, d.C0140d.cp_cont_f);
        am.h(this.mTitleView, d.C0140d.cp_cont_b);
        am.j(this.hwc, d.C0140d.cp_bg_line_e);
        am.h(this.hwe, d.C0140d.cp_cont_d);
        am.c(this.hwd, d.f.icon_post_search_n);
        am.j(this.mRootView, d.C0140d.cp_bg_line_d);
        am.j(this.bHR, d.C0140d.cp_bg_line_c);
        this.hwb.onChangeSkinType(i);
        this.LO.setSelector(am.getDrawable(d.f.selector_select_forum_item));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vy(int i) {
        TiebaStatic.log(new an("c12610").r("obj_locate", i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25038) {
            finish();
        } else if (i2 == -1 && i == 25019) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hay);
    }
}
