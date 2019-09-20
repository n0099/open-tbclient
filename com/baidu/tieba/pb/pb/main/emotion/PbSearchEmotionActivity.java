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
/* loaded from: classes4.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private BdListView hDc;
    private LinearLayout hDi;
    private SearchEditView hEg;
    private TextView hEh;
    private AutoLineWrapLayout hEj;
    private SearchEmotionModel hEl;
    private List<String> hEn;
    private String hEo;
    private String hYL;
    private TextView hZK;
    private FrameLayout hZL;
    private d hZM;
    private List<String> hZN;
    private View hvk;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a feU = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bhZ() == null || aVar.bhZ().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.bRF();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bhY() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bhZ());
            if (PbSearchEmotionActivity.this.hZM == null) {
                PbSearchEmotionActivity.this.hZM = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hZM.dK(PbSearchEmotionActivity.this.hZN);
                PbSearchEmotionActivity.this.hZM.a(PbSearchEmotionActivity.this.hOk);
                PbSearchEmotionActivity.this.hDc.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hZM);
            } else {
                PbSearchEmotionActivity.this.hZM.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bRC();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hEg);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bRF();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bRE();
        }
    };
    private final a hOk = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.cF(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hYL);
                com.baidu.adp.lib.f.c.iE().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbSearchEmotionActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbSearchEmotionActivity.this.getUniqueId());
            } else {
                PbSearchEmotionActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_SEARCH)));
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
            this.hEn = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hYL = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hEo = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hZN = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.hEl = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hEo)) {
            this.hEg.setText(this.hEo);
            BU(this.hEo);
        }
    }

    private void initView() {
        this.hDi = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.hZL = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.hvk = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hEg = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.hEg.setCallback(this);
        this.hZK = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.hEh = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.hDc = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.hDc.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hEg.setText("");
        this.hEg.big();
        ShowSoftKeyPadDelay(this.hEg, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bZu();
        bRB();
    }

    private void bRB() {
        this.hEj = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.hEn == null || this.hEn.isEmpty()) {
            this.hEj.setVisibility(8);
            return;
        }
        this.hEh.setVisibility(0);
        this.hEh.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.hEn.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hEn.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                am.l(textView, R.color.cp_bg_line_e);
                am.j(textView, R.color.cp_cont_f);
                int g = l.g(this.mActivity, R.dimen.ds16);
                textView.setPadding(g, g, g, g);
                textView.setText(str2);
                textView.setTextSize(0, l.g(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.hEg.setText(str);
                        PbSearchEmotionActivity.this.hEg.setSelection(str.length());
                        PbSearchEmotionActivity.this.BU(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hEj.addView(textView);
            }
        }
    }

    private void bZu() {
        this.hZK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.kc()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.hEo = str;
            this.hEl.a(str, this.mCurrentPage + 1, 40, this.feU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRE() {
        if (!j.kc()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.hEl.a(this.hEo, this.mCurrentPage + 1, 40, this.feU);
        }
    }

    private void bRD() {
        this.hEj.setVisibility(0);
        this.hEh.setText(getResources().getString(R.string.hot_emotion));
        this.hEh.setVisibility(0);
        this.hDc.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRC() {
        this.hDc.setVisibility(0);
        this.hEh.setText(getResources().getString(R.string.click_send_emotion));
        this.hEh.setVisibility(0);
        this.hEj.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRF() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hZL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.iQ(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hEj.setVisibility(8);
        this.hDc.setVisibility(8);
        this.hEh.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.hDi);
        am.k(this.hDi, R.color.cp_bg_line_d);
        am.l(this.hvk, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hEl != null) {
            this.hEl.cancelLoadData();
        }
        if (this.hDc != null) {
            this.hDc.removeAllViewsInLayout();
            this.hDc = null;
        }
        if (this.hZM != null) {
            this.hZM.removeListener();
            this.hZM.bRH();
            this.hZM = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void wC(String str) {
        BU(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void wD(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.hZM != null) {
                this.hZM.notifyDataSetChanged();
            }
            bRD();
        }
    }
}
