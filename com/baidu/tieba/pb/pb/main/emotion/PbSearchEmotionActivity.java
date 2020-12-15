package com.baidu.tieba.pb.pb.main.emotion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int bbx;
    private String lQZ;
    private TextView lTj;
    private FrameLayout lTk;
    private d lTl;
    private List<String> lTm;
    private View lhS;
    private BdListView lrV;
    private LinearLayout lsb;
    private SearchEditView lta;
    private TextView ltb;
    private AutoLineWrapLayout ltd;
    private SearchEmotionModel ltf;
    private List<String> lth;
    private String lti;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iFh = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.cxT() == null || aVar.cxT().isEmpty()) {
                if (PbSearchEmotionActivity.this.bbx == 0) {
                    PbSearchEmotionActivity.this.dkR();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.bbx = aVar.getPage();
            if (PbSearchEmotionActivity.this.bbx == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.cxS() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.cxT());
            if (PbSearchEmotionActivity.this.lTl == null) {
                PbSearchEmotionActivity.this.lTl = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.lTl.fq(PbSearchEmotionActivity.this.lTm);
                PbSearchEmotionActivity.this.lTl.a(PbSearchEmotionActivity.this.lTn);
                PbSearchEmotionActivity.this.lrV.setAdapter((ListAdapter) PbSearchEmotionActivity.this.lTl);
            } else {
                PbSearchEmotionActivity.this.lTl.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.dkO();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.lta);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.bbx == 1) {
                PbSearchEmotionActivity.this.dkR();
            }
        }
    };
    private final BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.dkQ();
        }
    };
    private final a lTn = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bh.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.lQZ);
                com.baidu.adp.lib.e.c.mS().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbSearchEmotionActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_EMOTION_EDIT, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbSearchEmotionActivity.this.getUniqueId());
            } else {
                PbSearchEmotionActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_EMOTION_EDIT, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_SEARCH)));
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.lth = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.lQZ = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.lti = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.lTm = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.ltf = new SearchEmotionModel();
        this.bbx = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.lti)) {
            this.lta.setText(this.lti);
            PF(this.lti);
        }
    }

    private void initView() {
        this.lsb = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.lTk = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.lhS = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.lta = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.lta.setCallback(this);
        this.lTj = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.ltb = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.lrV = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.lrV.setOnSrollToBottomListener(this.WQ);
        this.lta.setText("");
        this.lta.cya();
        ShowSoftKeyPadDelay(this.lta, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dtL();
        dkN();
    }

    private void dkN() {
        this.ltd = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.lth == null || this.lth.isEmpty()) {
            this.ltd.setVisibility(8);
            return;
        }
        this.ltb.setVisibility(0);
        this.ltb.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.lth.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lth.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                ap.setBackgroundColor(textView, R.color.CAM_X0205);
                ap.setViewTextColor(textView, R.color.CAM_X0106);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.lta.setText(str);
                        PbSearchEmotionActivity.this.lta.setSelection(str.length());
                        PbSearchEmotionActivity.this.PF(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.ltd.addView(textView);
            }
        }
    }

    private void dtL() {
        this.lTj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.bbx = 0;
            this.lti = str;
            this.ltf.a(str, this.bbx + 1, 40, this.iFh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkQ() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.ltf.a(this.lti, this.bbx + 1, 40, this.iFh);
        }
    }

    private void dkP() {
        this.ltd.setVisibility(0);
        this.ltb.setText(getResources().getString(R.string.hot_emotion));
        this.ltb.setVisibility(0);
        this.lrV.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkO() {
        this.lrV.setVisibility(0);
        this.ltb.setText(getResources().getString(R.string.click_send_emotion));
        this.ltb.setVisibility(0);
        this.ltd.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkR() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lTk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.qP(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ltd.setVisibility(8);
        this.lrV.setVisibility(8);
        this.ltb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Serializable serializableExtra;
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25023 && (serializableExtra = intent.getSerializableExtra("emotion_data")) != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
            c(emotionImageData);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    private void c(EmotionImageData emotionImageData) {
        Intent intent = new Intent();
        intent.putExtra("emotion_data", emotionImageData);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lsb);
        ap.setBackgroundResource(this.lsb, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lhS, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ltf != null) {
            this.ltf.cancelLoadData();
        }
        if (this.lrV != null) {
            this.lrV.removeAllViewsInLayout();
            this.lrV = null;
        }
        if (this.lTl != null) {
            this.lTl.removeListener();
            this.lTl.dkT();
            this.lTl = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JW(String str) {
        PF(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JX(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lTl != null) {
                this.lTl.notifyDataSetChanged();
            }
            dkP();
        }
    }
}
