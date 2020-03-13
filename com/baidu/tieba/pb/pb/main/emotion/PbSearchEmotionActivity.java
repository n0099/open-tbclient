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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
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
/* loaded from: classes9.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int akk;
    private String iPJ;
    private TextView iRN;
    private FrameLayout iRO;
    private d iRP;
    private List<String> iRQ;
    private View inf;
    private BdListView iuK;
    private LinearLayout iuQ;
    private SearchEditView ivN;
    private TextView ivO;
    private AutoLineWrapLayout ivQ;
    private SearchEmotionModel ivS;
    private List<String> ivU;
    private String ivV;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a gaQ = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bzR() == null || aVar.bzR().isEmpty()) {
                if (PbSearchEmotionActivity.this.akk == 0) {
                    PbSearchEmotionActivity.this.ciB();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.akk = aVar.getPage();
            if (PbSearchEmotionActivity.this.akk == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bzQ() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bzR());
            if (PbSearchEmotionActivity.this.iRP == null) {
                PbSearchEmotionActivity.this.iRP = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.iRP.dI(PbSearchEmotionActivity.this.iRQ);
                PbSearchEmotionActivity.this.iRP.a(PbSearchEmotionActivity.this.iRR);
                PbSearchEmotionActivity.this.iuK.setAdapter((ListAdapter) PbSearchEmotionActivity.this.iRP);
            } else {
                PbSearchEmotionActivity.this.iRP.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.ciy();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.ivN);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.akk == 1) {
                PbSearchEmotionActivity.this.ciB();
            }
        }
    };
    private final BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.ciA();
        }
    };
    private final a iRR = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.iPJ);
                com.baidu.adp.lib.e.c.gr().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.ivU = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.iPJ = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.ivV = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.iRQ = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.ivS = new SearchEmotionModel();
        this.akk = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.ivV)) {
            this.ivN.setText(this.ivV);
            Fu(this.ivV);
        }
    }

    private void initView() {
        this.iuQ = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.iRO = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.inf = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.ivN = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.ivN.setCallback(this);
        this.iRN = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.ivO = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.iuK = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.iuK.setOnSrollToBottomListener(this.Az);
        this.ivN.setText("");
        this.ivN.bzY();
        ShowSoftKeyPadDelay(this.ivN, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        cqP();
        cix();
    }

    private void cix() {
        this.ivQ = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.ivU == null || this.ivU.isEmpty()) {
            this.ivQ.setVisibility(8);
            return;
        }
        this.ivO.setVisibility(0);
        this.ivO.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.ivU.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.ivU.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                am.setBackgroundColor(textView, R.color.cp_bg_line_e);
                am.setViewTextColor(textView, (int) R.color.cp_cont_f);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.ivN.setText(str);
                        PbSearchEmotionActivity.this.ivN.setSelection(str.length());
                        PbSearchEmotionActivity.this.Fu(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.ivQ.addView(textView);
            }
        }
    }

    private void cqP() {
        this.iRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fu(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.akk = 0;
            this.ivV = str;
            this.ivS.a(str, this.akk + 1, 40, this.gaQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciA() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.ivS.a(this.ivV, this.akk + 1, 40, this.gaQ);
        }
    }

    private void ciz() {
        this.ivQ.setVisibility(0);
        this.ivO.setText(getResources().getString(R.string.hot_emotion));
        this.ivO.setVisibility(0);
        this.iuK.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciy() {
        this.iuK.setVisibility(0);
        this.ivO.setText(getResources().getString(R.string.click_send_emotion));
        this.ivO.setVisibility(0);
        this.ivQ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciB() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.iRO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ivQ.setVisibility(8);
        this.iuK.setVisibility(8);
        this.ivO.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.iuQ);
        am.setBackgroundResource(this.iuQ, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.inf, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ivS != null) {
            this.ivS.cancelLoadData();
        }
        if (this.iuK != null) {
            this.iuK.removeAllViewsInLayout();
            this.iuK = null;
        }
        if (this.iRP != null) {
            this.iRP.removeListener();
            this.iRP.ciD();
            this.iRP = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void At(String str) {
        Fu(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Au(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.iRP != null) {
                this.iRP.notifyDataSetChanged();
            }
            ciz();
        }
    }
}
