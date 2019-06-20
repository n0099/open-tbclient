package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PointerIconCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.write.share.ShareSdkView;
import com.baidu.tieba.write.share.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    private BdListView MR;
    private View aMY;
    private View bBi;
    private OriginalThreadInfo fna;
    private String fnb;
    private String fnc;
    private String fnd;
    private b jIO;
    private LinearLayout jIP;
    private ImageView jIQ;
    private TextView jIR;
    private com.baidu.tieba.write.share.b jIS;
    private f jIT;
    private com.baidu.tieba.write.share.a jIp;
    private com.baidu.tieba.write.share.c mCheckResponseData;
    private FrameLayout mContentView;
    private NavigationBar mNavigationBar;
    private int mPrivateThread;
    private View mRootView;
    private TextView mTitleView;
    private List<TransmitForumData> mDataList = new ArrayList();
    private int mFrom = 0;
    private long mLiveId = -1;
    private CustomMessageListener jmx = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                SelectForumActivity.this.mDataList.clear();
                SelectForumActivity.this.mDataList.addAll((ArrayList) customResponsedMessage.getData());
                if (SelectForumActivity.this.jIO != null) {
                    SelectForumActivity.this.hideLoadingView(SelectForumActivity.this.mContentView);
                    SelectForumActivity.this.jIO.m23do(SelectForumActivity.this.mDataList);
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != SelectForumActivity.this.bBi.getId()) {
                    if ((view.getId() == SelectForumActivity.this.jIQ.getId() || view.getId() == SelectForumActivity.this.jIR.getId()) && bc.cE(SelectForumActivity.this)) {
                        if (SelectForumActivity.this.mCheckResponseData != null) {
                            TiebaStatic.log(new am("c13276").bT("uid", TbadkCoreApplication.getCurrentAccount()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c13276").bT("uid", TbadkCoreApplication.getCurrentAccount()).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        SelectForumActivity.this.Cv(1);
                        ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(SelectForumActivity.this.getPageContext().getPageActivity());
                        forumSearchActivityConfig.setFrom(SelectForumActivity.this.mFrom);
                        forumSearchActivityConfig.setLiveId(SelectForumActivity.this.mLiveId);
                        forumSearchActivityConfig.setOriginalThread(SelectForumActivity.this.fna);
                        forumSearchActivityConfig.setRequestCode(25019);
                        forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        forumSearchActivityConfig.setMoreForumImg(SelectForumActivity.this.fnc);
                        forumSearchActivityConfig.setMoreForumUrl(SelectForumActivity.this.fnb);
                        forumSearchActivityConfig.setMoreForumTitle(SelectForumActivity.this.fnd);
                        SelectForumActivity.this.sendMessage(new CustomMessage(2002001, forumSearchActivityConfig));
                        return;
                    }
                    return;
                }
                SelectForumActivity.this.setResult(0);
                SelectForumActivity.this.finish();
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.6
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TransmitForumData transmitForumData = (TransmitForumData) SelectForumActivity.this.mDataList.get(i);
            if (transmitForumData != null) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(transmitForumData);
                if (SelectForumActivity.this.mCheckResponseData != null) {
                    SelectForumActivity.this.mCheckResponseData.forumId = String.valueOf(transmitForumData.forumId);
                    SelectForumActivity.this.mCheckResponseData.jIt = transmitForumData.forumName;
                    SelectForumActivity.this.FT(AddFriendActivityConfig.TYPE_FOCUS);
                } else if (SelectForumActivity.this.mFrom != 1 || SelectForumActivity.this.mLiveId <= 0) {
                    if (SelectForumActivity.this.mFrom == 2) {
                        SelectForumActivity.this.a(transmitForumData, SelectForumActivity.this.mPrivateThread);
                        SelectForumActivity.this.Cv(2);
                        SelectForumActivity.this.finish();
                    } else if (SelectForumActivity.this.mFrom == 4) {
                        SelectForumActivity.this.b(transmitForumData, SelectForumActivity.this.mPrivateThread);
                        SelectForumActivity.this.finish();
                    } else {
                        Intent intent = new Intent();
                        intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                        SelectForumActivity.this.setResult(-1, intent);
                        SelectForumActivity.this.finish();
                    }
                } else {
                    SelectForumActivity.this.aJ(arrayList);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_forum_activity);
        initData();
        initView();
        MessageManager.getInstance().registerListener(this.jmx);
        if (this.mCheckResponseData != null) {
            showLoadingView(this.mContentView);
        }
        bc.cE(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jIS != null && TbadkCoreApplication.isLogin() && v.aa(this.mDataList)) {
            this.jIS.ew(this.mCheckResponseData.appKey, this.mCheckResponseData.jIr);
        } else {
            hideLoadingView(this.mContentView);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getScheme();
            }
            if (!StringUtils.isNull(str) && "tieba".equals(str)) {
                TiebaStatic.log(new am("c13275").bT("uid", TbadkCoreApplication.getCurrentAccount()));
                try {
                    Class.forName("com.baidu.tieba.enterForum.home.CoreSearchRequestStatic");
                    Class.forName("com.baidu.tieba.enterForum.home.a");
                } catch (Exception e) {
                }
                this.mFrom = 3;
                this.mCheckResponseData = new com.baidu.tieba.write.share.c();
                this.mCheckResponseData.appKey = intent.getStringExtra("appkey");
                this.mCheckResponseData.jIr = intent.getStringExtra(SelectForumActivityConfig.KEY_APPLETSKEY);
                this.mCheckResponseData.imageUrl = intent.getStringExtra("image");
                this.mCheckResponseData.title = intent.getStringExtra("title");
                this.mCheckResponseData.content = intent.getStringExtra("desc");
                this.mCheckResponseData.linkUrl = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_LINK);
                this.mCheckResponseData.jIv = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_APPLETS_LINK);
                this.jIS = new com.baidu.tieba.write.share.b(getUniqueId());
                this.jIp = new com.baidu.tieba.write.share.a() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.2
                    @Override // com.baidu.tieba.write.share.a
                    public void a(com.baidu.tieba.write.share.c cVar, int i, String str2) {
                        if (cVar == null) {
                            SelectForumActivity.this.hideLoadingView(SelectForumActivity.this.mContentView);
                            SelectForumActivity.this.showToast(str2);
                            Intent intent2 = new Intent();
                            intent2.putExtra("err_code", i);
                            SelectForumActivity.this.setResult(PointerIconCompat.TYPE_TEXT, intent2);
                            SelectForumActivity.this.finish();
                            return;
                        }
                        SelectForumActivity.this.mCheckResponseData.appName = cVar.appName;
                        SelectForumActivity.this.mCheckResponseData.jIs = cVar.jIs;
                        com.baidu.tieba.c.e.aZC().aZF();
                    }
                };
                this.jIS.a(this.jIp);
                this.jIT = new f(getUniqueId());
                this.jIT.a(new com.baidu.tieba.write.share.e() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.3
                    @Override // com.baidu.tieba.write.share.e
                    public void a(com.baidu.tieba.write.share.d dVar) {
                        if (dVar == null) {
                            SelectForumActivity.this.showToast(SelectForumActivity.this.getString(R.string.share_sdk_share_faild_default));
                            Intent intent2 = new Intent();
                            intent2.putExtra("err_code", -2113);
                            SelectForumActivity.this.setResult(PointerIconCompat.TYPE_TEXT, intent2);
                        } else if (dVar.jIw != null && dVar.jIw.getError_code() != 0) {
                            SelectForumActivity.this.showToast(dVar.jIw.getError_msg());
                            Intent intent3 = new Intent();
                            intent3.putExtra("err_code", dVar.jIw.getError_code());
                            SelectForumActivity.this.setResult(PointerIconCompat.TYPE_TEXT, intent3);
                        } else {
                            TiebaStatic.log(new am("c13278").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", dVar.fid).bT("tid", dVar.tid));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(SelectForumActivity.this).createNormalCfg(SelectForumActivity.this.mCheckResponseData.jIt, "")));
                        }
                        SelectForumActivity.this.finish();
                    }
                });
                return;
            }
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (v.Z(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            this.mFrom = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0);
            this.mLiveId = intent.getLongExtra("extra_key_live_id", -1L);
            this.mPrivateThread = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_PRIVATE_THREAD, 0);
            this.fna = (OriginalThreadInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD);
            this.fnc = intent.getStringExtra("more_forum_img");
            this.fnb = intent.getStringExtra("more_forum_url");
            this.fnd = intent.getStringExtra("more_forum_title");
        }
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_view);
        this.mContentView = (FrameLayout) findViewById(R.id.transmit_content_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bBi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel));
        if (this.bBi.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bBi.getLayoutParams();
            layoutParams.leftMargin = l.g(getActivity(), R.dimen.ds10);
            this.bBi.setLayoutParams(layoutParams);
        }
        this.mTitleView = this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.select_share_forum_bar));
        this.bBi.setOnClickListener(this.mOnClickListener);
        this.jIP = (LinearLayout) findViewById(R.id.layout_search);
        this.jIQ = (ImageView) findViewById(R.id.icon_search);
        this.jIQ.setOnClickListener(this.mOnClickListener);
        this.jIR = (TextView) findViewById(R.id.textview_search);
        this.jIR.setOnClickListener(this.mOnClickListener);
        this.aMY = findViewById(R.id.view_divider);
        this.MR = (BdListView) findViewById(R.id.trasmit_grid_view);
        this.MR.setOnItemClickListener(this.mOnItemClickListener);
        this.jIO = new b(getActivity());
        this.MR.setAdapter((ListAdapter) this.jIO);
        this.jIO.m23do(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT(String str) {
        if (this.mCheckResponseData != null) {
            TiebaStatic.log(new am("c13277").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
            ShareSdkView shareSdkView = new ShareSdkView(this);
            shareSdkView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            shareSdkView.setOnShareListener(new ShareSdkView.a() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.4
                @Override // com.baidu.tieba.write.share.ShareSdkView.a
                public void FS(String str2) {
                    SelectForumActivity.this.mCheckResponseData.Hj = str2;
                    if (SelectForumActivity.this.jIT != null) {
                        SelectForumActivity.this.jIT.a(SelectForumActivity.this.mCheckResponseData);
                    }
                }
            });
            ((ViewGroup) this.mRootView).addView(shareSdkView);
            shareSdkView.setData(this.mCheckResponseData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(ArrayList<TransmitForumData> arrayList) {
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(getPageContext().getPageActivity(), 9, str2, str, null, null, 13011, null, null, null, this.fna);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setPrivateThread(i);
        sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TransmitForumData transmitForumData, int i) {
        String str = null;
        String str2 = null;
        if (transmitForumData != null) {
            str = String.valueOf(transmitForumData.forumId);
            str2 = transmitForumData.forumName;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 9, str, str2, null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.fnc);
        writeActivityConfig.setMoreForumUrl(this.fnb);
        writeActivityConfig.setMoreForumTitle(this.fnd);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.j(this.bBi, R.color.cp_cont_f);
        al.j(this.mTitleView, R.color.cp_cont_b);
        al.l(this.jIP, R.color.cp_bg_line_e);
        al.j(this.jIR, R.color.cp_cont_d);
        al.c(this.jIQ, (int) R.drawable.icon_post_search_n);
        al.l(this.mRootView, R.color.cp_bg_line_d);
        al.l(this.aMY, R.color.cp_bg_line_c);
        this.jIO.onChangeSkinType(i);
        this.MR.setSelector(al.getDrawable(R.drawable.selector_select_forum_item));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cv(int i) {
        TiebaStatic.log(new am("c12610").P("obj_locate", i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25038) {
            finish();
        } else if (i2 == -1 && i == 25019) {
            if (this.mCheckResponseData != null && intent != null) {
                this.mCheckResponseData.forumId = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_ID);
                this.mCheckResponseData.jIt = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_NAME);
                FT("search");
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jmx);
    }
}
