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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    private BdListView LQ;
    private View bFh;
    private OriginalThreadInfo dgf;
    private View eFf;
    private b hqM;
    private LinearLayout hqN;
    private ImageView hqO;
    private TextView hqP;
    private NavigationBar mNavigationBar;
    private int mPrivateThread;
    private View mRootView;
    private TextView mTitleView;
    private List<TransmitForumData> mDataList = new ArrayList();
    private int mFrom = 0;
    private long mLiveId = -1;
    private CustomMessageListener gVt = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                SelectForumActivity.this.mDataList.clear();
                SelectForumActivity.this.mDataList.addAll((ArrayList) customResponsedMessage.getData());
                if (SelectForumActivity.this.hqM != null) {
                    SelectForumActivity.this.hqM.cz(SelectForumActivity.this.mDataList);
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != SelectForumActivity.this.eFf.getId()) {
                    if (view.getId() == SelectForumActivity.this.hqO.getId() || view.getId() == SelectForumActivity.this.hqP.getId()) {
                        ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(SelectForumActivity.this.getPageContext().getPageActivity());
                        forumSearchActivityConfig.setFrom(SelectForumActivity.this.mFrom);
                        forumSearchActivityConfig.setLiveId(SelectForumActivity.this.mLiveId);
                        forumSearchActivityConfig.setOriginalThread(SelectForumActivity.this.dgf);
                        forumSearchActivityConfig.setRequestCode(25019);
                        forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        SelectForumActivity.this.sendMessage(new CustomMessage(2002001, forumSearchActivityConfig));
                        TiebaStatic.log("c12259");
                        SelectForumActivity.this.vq(1);
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
                        SelectForumActivity.this.vq(2);
                        SelectForumActivity.this.finish();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                    SelectForumActivity.this.setResult(-1, intent);
                    SelectForumActivity.this.finish();
                    return;
                }
                SelectForumActivity.this.ay(arrayList);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.select_forum_activity);
        initData();
        initView();
        MessageManager.getInstance().registerListener(this.gVt);
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
            this.dgf = (OriginalThreadInfo) getIntent().getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD);
        }
    }

    private void initView() {
        this.mRootView = findViewById(d.g.root_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.eFf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(d.k.cancel));
        if (this.eFf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFf.getLayoutParams();
            layoutParams.leftMargin = l.e(getActivity(), d.e.ds10);
            this.eFf.setLayoutParams(layoutParams);
        }
        this.mTitleView = this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.select_share_forum_bar));
        this.eFf.setOnClickListener(this.mOnClickListener);
        this.hqN = (LinearLayout) findViewById(d.g.layout_search);
        this.hqO = (ImageView) findViewById(d.g.icon_search);
        this.hqO.setOnClickListener(this.mOnClickListener);
        this.hqP = (TextView) findViewById(d.g.textview_search);
        this.hqP.setOnClickListener(this.mOnClickListener);
        this.bFh = findViewById(d.g.view_divider);
        this.LQ = (BdListView) findViewById(d.g.trasmit_grid_view);
        this.LQ.setOnItemClickListener(this.mOnItemClickListener);
        this.hqM = new b(getActivity());
        this.LQ.setAdapter((ListAdapter) this.hqM);
        this.hqM.cz(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(ArrayList<TransmitForumData> arrayList) {
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(getPageContext().getPageActivity(), 9, str2, str, null, null, 13011, null, null, null, this.dgf);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setPrivateThread(i);
        sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.eFf, d.C0141d.cp_cont_f);
        al.h(this.mTitleView, d.C0141d.cp_cont_b);
        al.j(this.hqN, d.C0141d.cp_bg_line_e);
        al.h(this.hqP, d.C0141d.cp_cont_d);
        al.c(this.hqO, d.f.icon_post_search_n);
        al.j(this.mRootView, d.C0141d.cp_bg_line_d);
        al.j(this.bFh, d.C0141d.cp_bg_line_c);
        this.hqM.onChangeSkinType(i);
        this.LQ.setSelector(al.getDrawable(d.f.selector_select_forum_item));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(int i) {
        TiebaStatic.log(new am("c12610").r("obj_locate", i));
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
        MessageManager.getInstance().unRegisterListener(this.gVt);
    }
}
