package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.share.ShareSdkView;
import com.baidu.tieba.write.share.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    private BdListView Ua;
    private View dkp;
    private String gWA;
    private String gWB;
    private String gWC;
    private OriginalThreadInfo.ShareInfo gWx;
    private String gWy;
    private String gWz;
    private LinearLayout hRo;
    private com.baidu.tieba.write.share.a lAF;
    private b lBc;
    private ImageView lBd;
    private TextView lBe;
    private com.baidu.tieba.write.share.b lBf;
    private f lBg;
    private BaijiahaoData mBaijiahaoData;
    private com.baidu.tieba.write.share.c mCheckResponseData;
    private FrameLayout mContentView;
    private View mDivider;
    private NavigationBar mNavigationBar;
    private int mPrivateThread;
    private View mRootView;
    private TextView mTitleView;
    private List<TransmitForumData> mDataList = new ArrayList();
    private int mFrom = 0;
    private long aQm = -1;
    private CustomMessageListener iPH = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                SelectForumActivity.this.mDataList.clear();
                SelectForumActivity.this.mDataList.addAll((ArrayList) customResponsedMessage.getData());
                if (SelectForumActivity.this.lBc != null) {
                    SelectForumActivity.this.hideLoadingView(SelectForumActivity.this.mContentView);
                    SelectForumActivity.this.lBc.dy(SelectForumActivity.this.mDataList);
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != SelectForumActivity.this.dkp.getId()) {
                    if ((view.getId() == SelectForumActivity.this.lBd.getId() || view.getId() == SelectForumActivity.this.lBe.getId()) && bc.checkUpIsLogin(SelectForumActivity.this)) {
                        if (SelectForumActivity.this.mCheckResponseData != null) {
                            TiebaStatic.log(new an("c13276").cI("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_source", 2));
                        } else {
                            TiebaStatic.log(new an("c13276").cI("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_source", 1));
                        }
                        SelectForumActivity.this.ES(1);
                        ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(SelectForumActivity.this.getPageContext().getPageActivity());
                        forumSearchActivityConfig.setFrom(SelectForumActivity.this.mFrom);
                        forumSearchActivityConfig.setLiveId(SelectForumActivity.this.aQm);
                        forumSearchActivityConfig.setBaijiahaoData(SelectForumActivity.this.mBaijiahaoData);
                        forumSearchActivityConfig.setOriginalThread(SelectForumActivity.this.gWx);
                        forumSearchActivityConfig.setTransmitOriginThreadComment(SelectForumActivity.this.gWy);
                        forumSearchActivityConfig.setTransmitThreadAuthorNameShow(SelectForumActivity.this.gWz);
                        forumSearchActivityConfig.setRequestCode(RequestResponseCode.REQUEST_FORUM_SEARCH);
                        forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                        forumSearchActivityConfig.setMoreForumImg(SelectForumActivity.this.gWB);
                        forumSearchActivityConfig.setMoreForumUrl(SelectForumActivity.this.gWA);
                        forumSearchActivityConfig.setMoreForumTitle(SelectForumActivity.this.gWC);
                        SelectForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumSearchActivityConfig));
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
                    SelectForumActivity.this.mCheckResponseData.lAJ = transmitForumData.forumName;
                    SelectForumActivity.this.MD(AddFriendActivityConfig.TYPE_FOCUS);
                } else if (SelectForumActivity.this.mFrom != 1 || SelectForumActivity.this.aQm <= 0) {
                    if (SelectForumActivity.this.mFrom == 2) {
                        SelectForumActivity.this.a(transmitForumData, SelectForumActivity.this.mPrivateThread);
                        SelectForumActivity.this.ES(2);
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
                    SelectForumActivity.this.aX(arrayList);
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
        registerListener(this.iPH);
        if (this.mCheckResponseData != null) {
            showLoadingView(this.mContentView);
        }
        bc.checkUpIsLogin(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lBf != null && TbadkCoreApplication.isLogin() && v.isEmpty(this.mDataList)) {
            if (this.mCheckResponseData != null) {
                this.lBf.fc(this.mCheckResponseData.appKey, this.mCheckResponseData.lAH);
                return;
            }
            return;
        }
        hideLoadingView(this.mContentView);
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
                TiebaStatic.log(new an("c13275").cI("uid", TbadkCoreApplication.getCurrentAccount()));
                try {
                    Class.forName("com.baidu.tieba.enterForum.home.CoreSearchRequestStatic");
                    Class.forName("com.baidu.tieba.enterForum.home.a");
                } catch (Exception e) {
                }
                this.mFrom = 3;
                this.mCheckResponseData = new com.baidu.tieba.write.share.c();
                this.mCheckResponseData.appKey = intent.getStringExtra("appkey");
                this.mCheckResponseData.lAH = intent.getStringExtra(SelectForumActivityConfig.KEY_APPLETSKEY);
                this.mCheckResponseData.imageUrl = intent.getStringExtra("image");
                this.mCheckResponseData.title = intent.getStringExtra("title");
                this.mCheckResponseData.content = intent.getStringExtra("desc");
                this.mCheckResponseData.linkUrl = intent.getStringExtra("link");
                this.mCheckResponseData.lAL = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_APPLETS_LINK);
                this.lBf = new com.baidu.tieba.write.share.b(getUniqueId());
                this.lAF = new com.baidu.tieba.write.share.a() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.2
                    @Override // com.baidu.tieba.write.share.a
                    public void a(com.baidu.tieba.write.share.c cVar, int i, String str2) {
                        if (cVar == null) {
                            SelectForumActivity.this.hideLoadingView(SelectForumActivity.this.mContentView);
                            SelectForumActivity.this.showToast(str2);
                            Intent intent2 = new Intent();
                            intent2.putExtra("err_code", i);
                            SelectForumActivity.this.setResult(1008, intent2);
                            SelectForumActivity.this.finish();
                            return;
                        }
                        if (SelectForumActivity.this.mCheckResponseData != null) {
                            SelectForumActivity.this.mCheckResponseData.appName = cVar.appName;
                            SelectForumActivity.this.mCheckResponseData.lAI = cVar.lAI;
                        }
                        com.baidu.tieba.c.e.bGd().bGg();
                    }
                };
                this.lBf.a(this.lAF);
                this.lBg = new f(getUniqueId());
                this.lBg.a(new com.baidu.tieba.write.share.e() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.3
                    @Override // com.baidu.tieba.write.share.e
                    public void a(com.baidu.tieba.write.share.d dVar) {
                        if (dVar == null) {
                            SelectForumActivity.this.showToast(SelectForumActivity.this.getString(R.string.share_sdk_share_faild_default));
                            Intent intent2 = new Intent();
                            intent2.putExtra("err_code", -2113);
                            SelectForumActivity.this.setResult(1008, intent2);
                        } else if (dVar.lAM != null && dVar.lAM.getError_code() != 0) {
                            SelectForumActivity.this.showToast(dVar.lAM.getError_msg());
                            Intent intent3 = new Intent();
                            intent3.putExtra("err_code", dVar.lAM.getError_code());
                            SelectForumActivity.this.setResult(1008, intent3);
                        } else {
                            TiebaStatic.log(new an("c13278").cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", dVar.fid).cI("tid", dVar.tid));
                            SelectForumActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(SelectForumActivity.this).createNormalCfg(SelectForumActivity.this.mCheckResponseData.lAJ, "")));
                        }
                        SelectForumActivity.this.finish();
                    }
                });
                return;
            }
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (v.getCount(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            this.mFrom = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0);
            this.aQm = intent.getLongExtra("extra_key_live_id", -1L);
            this.mPrivateThread = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_PRIVATE_THREAD, 0);
            this.mBaijiahaoData = (BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA);
            this.gWx = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD);
            this.gWy = intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT);
            this.gWz = intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
            this.gWB = intent.getStringExtra("more_forum_img");
            this.gWA = intent.getStringExtra("more_forum_url");
            this.gWC = intent.getStringExtra("more_forum_title");
        }
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_view);
        this.mContentView = (FrameLayout) findViewById(R.id.transmit_content_layout);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dkp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.cancel));
        if (this.dkp.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dkp.getLayoutParams();
            layoutParams.leftMargin = l.getDimens(getActivity(), R.dimen.ds10);
            this.dkp.setLayoutParams(layoutParams);
        }
        this.mTitleView = this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.select_share_forum_bar));
        this.dkp.setOnClickListener(this.mOnClickListener);
        this.hRo = (LinearLayout) findViewById(R.id.layout_search);
        this.lBd = (ImageView) findViewById(R.id.icon_search);
        this.lBd.setOnClickListener(this.mOnClickListener);
        this.lBe = (TextView) findViewById(R.id.textview_search);
        this.lBe.setOnClickListener(this.mOnClickListener);
        this.mDivider = findViewById(R.id.view_divider);
        this.Ua = (BdListView) findViewById(R.id.trasmit_grid_view);
        this.Ua.setOnItemClickListener(this.mOnItemClickListener);
        this.lBc = new b(getActivity());
        this.Ua.setAdapter((ListAdapter) this.lBc);
        this.lBc.dy(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MD(String str) {
        if (this.mCheckResponseData != null) {
            TiebaStatic.log(new an("c13277").cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("obj_source", str));
            ShareSdkView shareSdkView = new ShareSdkView(this);
            shareSdkView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            shareSdkView.setOnShareListener(new ShareSdkView.a() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.4
                @Override // com.baidu.tieba.write.share.ShareSdkView.a
                public void eL(String str2) {
                    if (SelectForumActivity.this.mCheckResponseData != null) {
                        SelectForumActivity.this.mCheckResponseData.PI = str2;
                    }
                    if (SelectForumActivity.this.lBg != null) {
                        SelectForumActivity.this.lBg.a(SelectForumActivity.this.mCheckResponseData);
                    }
                }
            });
            ((ViewGroup) this.mRootView).addView(shareSdkView);
            shareSdkView.setData(this.mCheckResponseData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(ArrayList<TransmitForumData> arrayList) {
        AlaWriteShareInBarActivityConfig alaWriteShareInBarActivityConfig = new AlaWriteShareInBarActivityConfig(getPageContext().getPageActivity(), arrayList, String.valueOf(this.aQm));
        alaWriteShareInBarActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        alaWriteShareInBarActivityConfig.setRequestCode(RequestResponseCode.REQUEST_SHARE_IN_BAR_PERMISSION_CODE);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaWriteShareInBarActivityConfig));
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(getPageContext().getPageActivity(), 9, str2, str, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.gWx);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setPrivateThread(i);
        transmitPostEditActivityConfig.setBaijiahaoData(this.mBaijiahaoData);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.gWy);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.gWz);
        transmitPostEditActivityConfig.setFrsTabInfo(a(transmitForumData));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TransmitForumData transmitForumData, int i) {
        String str = null;
        String str2 = null;
        if (transmitForumData != null) {
            str = String.valueOf(transmitForumData.forumId);
            str2 = transmitForumData.forumName;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 9, str, str2, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0, WriteActivityConfig.FROM_FORUM_SHARE);
        writeActivityConfig.setMoreForumImg(this.gWB);
        writeActivityConfig.setMoreForumUrl(this.gWA);
        writeActivityConfig.setMoreForumTitle(this.gWC);
        writeActivityConfig.setFrsTabInfo(a(transmitForumData));
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    private FrsTabInfoData a(TransmitForumData transmitForumData) {
        if (transmitForumData == null || v.isEmpty(transmitForumData.tabItemDatas)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(transmitForumData.tabItemDatas.size());
        Iterator<FrsTabItemData> it = transmitForumData.tabItemDatas.iterator();
        while (it.hasNext()) {
            FrsTabItemData next = it.next();
            if (next != null && next.isGeneralTab == 1) {
                arrayList.add(next);
            }
        }
        if (v.isEmpty(arrayList)) {
            return null;
        }
        FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
        frsTabInfoData.tabList = arrayList;
        frsTabInfoData.selectedTabId = -1;
        return frsTabInfoData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.dkp, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.hRo, R.color.cp_bg_line_e);
        am.setViewTextColor(this.lBe, (int) R.color.cp_cont_d);
        am.setImageResource(this.lBd, R.drawable.icon_post_search_n);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        this.lBc.onChangeSkinType(i);
        this.Ua.setSelector(am.getDrawable(R.drawable.selector_select_forum_item));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ES(int i) {
        TiebaStatic.log(new an("c12610").af("obj_locate", i));
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
                this.mCheckResponseData.lAJ = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_NAME);
                MD("search");
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
