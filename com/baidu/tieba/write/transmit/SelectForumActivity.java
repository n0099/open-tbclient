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
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.searchbox.ng.ai.apps.core.container.init.NgWebViewInitHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.write.share.ShareSdkView;
import com.baidu.tieba.write.share.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    private BdListView OF;
    private OriginalThreadInfo dGu;
    private View fka;
    private b hUF;
    private LinearLayout hUG;
    private ImageView hUH;
    private TextView hUI;
    private com.baidu.tieba.write.share.b hUJ;
    private f hUK;
    private com.baidu.tieba.write.share.a hUh;
    private com.baidu.tieba.write.share.c mCheckResponseData;
    private FrameLayout mContentView;
    private View mDivider;
    private NavigationBar mNavigationBar;
    private int mPrivateThread;
    private View mRootView;
    private TextView mTitleView;
    private List<TransmitForumData> mDataList = new ArrayList();
    private int mFrom = 0;
    private long mLiveId = -1;
    private CustomMessageListener hyE = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                SelectForumActivity.this.mDataList.clear();
                SelectForumActivity.this.mDataList.addAll((ArrayList) customResponsedMessage.getData());
                if (SelectForumActivity.this.hUF != null) {
                    SelectForumActivity.this.hideLoadingView(SelectForumActivity.this.mContentView);
                    SelectForumActivity.this.hUF.cV(SelectForumActivity.this.mDataList);
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                if (view.getId() != SelectForumActivity.this.fka.getId()) {
                    if ((view.getId() == SelectForumActivity.this.hUH.getId() || view.getId() == SelectForumActivity.this.hUI.getId()) && ba.bJ(SelectForumActivity.this)) {
                        if (SelectForumActivity.this.mCheckResponseData != null) {
                            TiebaStatic.log(new am("c13276").aA("uid", TbadkCoreApplication.getCurrentAccount()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2));
                        } else {
                            TiebaStatic.log(new am("c13276").aA("uid", TbadkCoreApplication.getCurrentAccount()).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1));
                        }
                        SelectForumActivity.this.xl(1);
                        ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(SelectForumActivity.this.getPageContext().getPageActivity());
                        forumSearchActivityConfig.setFrom(SelectForumActivity.this.mFrom);
                        forumSearchActivityConfig.setLiveId(SelectForumActivity.this.mLiveId);
                        forumSearchActivityConfig.setOriginalThread(SelectForumActivity.this.dGu);
                        forumSearchActivityConfig.setRequestCode(25019);
                        forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
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
                    SelectForumActivity.this.mCheckResponseData.hUk = transmitForumData.forumName;
                    SelectForumActivity.this.xE("focus");
                } else if (SelectForumActivity.this.mFrom != 1 || SelectForumActivity.this.mLiveId <= 0) {
                    if (SelectForumActivity.this.mFrom == 2) {
                        SelectForumActivity.this.a(transmitForumData, SelectForumActivity.this.mPrivateThread);
                        SelectForumActivity.this.xl(2);
                        SelectForumActivity.this.finish();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                    SelectForumActivity.this.setResult(-1, intent);
                    SelectForumActivity.this.finish();
                } else {
                    SelectForumActivity.this.aA(arrayList);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.select_forum_activity);
        initData();
        initView();
        MessageManager.getInstance().registerListener(this.hyE);
        if (this.mCheckResponseData != null) {
            showLoadingView(this.mContentView);
        }
        ba.bJ(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hUJ != null && TbadkCoreApplication.isLogin() && v.I(this.mDataList)) {
            this.hUJ.cW(this.mCheckResponseData.appKey, this.mCheckResponseData.hUj);
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
            if (!StringUtils.isNull(str) && NgWebViewInitHelper.INIT_BWEBKIT_APPID.equals(str)) {
                TiebaStatic.log(new am("c13275").aA("uid", TbadkCoreApplication.getCurrentAccount()));
                try {
                    Class.forName("com.baidu.tieba.enterForum.home.CoreSearchRequestStatic");
                    Class.forName("com.baidu.tieba.enterForum.home.a");
                } catch (Exception e) {
                }
                this.mFrom = 3;
                this.mCheckResponseData = new com.baidu.tieba.write.share.c();
                this.mCheckResponseData.appKey = intent.getStringExtra("appkey");
                this.mCheckResponseData.hUj = intent.getStringExtra(SelectForumActivityConfig.KEY_APPLETSKEY);
                this.mCheckResponseData.imageUrl = intent.getStringExtra("image");
                this.mCheckResponseData.title = intent.getStringExtra("title");
                this.mCheckResponseData.content = intent.getStringExtra("desc");
                this.mCheckResponseData.linkUrl = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_LINK);
                this.mCheckResponseData.hUm = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_APPLETS_LINK);
                this.hUJ = new com.baidu.tieba.write.share.b(getUniqueId());
                this.hUh = new com.baidu.tieba.write.share.a() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.2
                    @Override // com.baidu.tieba.write.share.a
                    public void a(com.baidu.tieba.write.share.c cVar, int i, String str2) {
                        if (cVar == null) {
                            SelectForumActivity.this.hideLoadingView(SelectForumActivity.this.mContentView);
                            SelectForumActivity.this.showToast(str2);
                            Intent intent2 = new Intent();
                            intent2.putExtra(ARResourceKey.HTTP_ERR_CODE, i);
                            SelectForumActivity.this.setResult(1008, intent2);
                            SelectForumActivity.this.finish();
                            return;
                        }
                        SelectForumActivity.this.mCheckResponseData.appName = cVar.appName;
                        SelectForumActivity.this.mCheckResponseData.bGI = cVar.bGI;
                        com.baidu.tieba.c.e.aro().arr();
                    }
                };
                this.hUJ.a(this.hUh);
                this.hUK = new f(getUniqueId());
                this.hUK.a(new com.baidu.tieba.write.share.e() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.3
                    @Override // com.baidu.tieba.write.share.e
                    public void a(com.baidu.tieba.write.share.d dVar) {
                        if (dVar == null) {
                            SelectForumActivity.this.showToast(SelectForumActivity.this.getString(e.j.share_sdk_share_faild_default));
                            Intent intent2 = new Intent();
                            intent2.putExtra(ARResourceKey.HTTP_ERR_CODE, -2113);
                            SelectForumActivity.this.setResult(1008, intent2);
                        } else if (dVar.hUn != null && dVar.hUn.getError_code() != 0) {
                            SelectForumActivity.this.showToast(dVar.hUn.getError_msg());
                            Intent intent3 = new Intent();
                            intent3.putExtra(ARResourceKey.HTTP_ERR_CODE, dVar.hUn.getError_code());
                            SelectForumActivity.this.setResult(1008, intent3);
                        } else {
                            TiebaStatic.log(new am("c13278").aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_ID, dVar.fid).aA("tid", dVar.tid));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(SelectForumActivity.this).createNormalCfg(SelectForumActivity.this.mCheckResponseData.hUk, "")));
                        }
                        SelectForumActivity.this.finish();
                    }
                });
                return;
            }
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
            if (v.H(parcelableArrayListExtra) > 0) {
                this.mDataList.addAll(parcelableArrayListExtra);
            }
            this.mFrom = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0);
            this.mLiveId = intent.getLongExtra("extra_key_live_id", -1L);
            this.mPrivateThread = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_PRIVATE_THREAD, 0);
            this.dGu = (OriginalThreadInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD);
        }
    }

    private void initView() {
        this.mRootView = findViewById(e.g.root_view);
        this.mContentView = (FrameLayout) findViewById(e.g.transmit_content_layout);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.fka = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(e.j.cancel));
        if (this.fka.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fka.getLayoutParams();
            layoutParams.leftMargin = l.h(getActivity(), e.C0210e.ds10);
            this.fka.setLayoutParams(layoutParams);
        }
        this.mTitleView = this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.select_share_forum_bar));
        this.fka.setOnClickListener(this.mOnClickListener);
        this.hUG = (LinearLayout) findViewById(e.g.layout_search);
        this.hUH = (ImageView) findViewById(e.g.icon_search);
        this.hUH.setOnClickListener(this.mOnClickListener);
        this.hUI = (TextView) findViewById(e.g.textview_search);
        this.hUI.setOnClickListener(this.mOnClickListener);
        this.mDivider = findViewById(e.g.view_divider);
        this.OF = (BdListView) findViewById(e.g.trasmit_grid_view);
        this.OF.setOnItemClickListener(this.mOnItemClickListener);
        this.hUF = new b(getActivity());
        this.OF.setAdapter((ListAdapter) this.hUF);
        this.hUF.cV(this.mDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE(String str) {
        if (this.mCheckResponseData != null) {
            TiebaStatic.log(new am("c13277").aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, str));
            ShareSdkView shareSdkView = new ShareSdkView(this);
            shareSdkView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            shareSdkView.setOnShareListener(new ShareSdkView.a() { // from class: com.baidu.tieba.write.transmit.SelectForumActivity.4
                @Override // com.baidu.tieba.write.share.ShareSdkView.a
                public void xD(String str2) {
                    SelectForumActivity.this.mCheckResponseData.Jt = str2;
                    if (SelectForumActivity.this.hUK != null) {
                        SelectForumActivity.this.hUK.a(SelectForumActivity.this.mCheckResponseData);
                    }
                }
            });
            ((ViewGroup) this.mRootView).addView(shareSdkView);
            shareSdkView.setData(this.mCheckResponseData);
        }
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(getPageContext().getPageActivity(), 9, str2, str, null, null, 13011, null, null, null, this.dGu);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setPrivateThread(i);
        sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.h(this.fka, e.d.cp_cont_f);
        al.h(this.mTitleView, e.d.cp_cont_b);
        al.j(this.hUG, e.d.cp_bg_line_e);
        al.h(this.hUI, e.d.cp_cont_d);
        al.c(this.hUH, e.f.icon_post_search_n);
        al.j(this.mRootView, e.d.cp_bg_line_d);
        al.j(this.mDivider, e.d.cp_bg_line_c);
        this.hUF.onChangeSkinType(i);
        this.OF.setSelector(al.getDrawable(e.f.selector_select_forum_item));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl(int i) {
        TiebaStatic.log(new am("c12610").x("obj_locate", i));
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
                this.mCheckResponseData.hUk = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_NAME);
                xE("search");
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hyE);
    }
}
