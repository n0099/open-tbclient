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
import com.baidu.tbadk.core.util.bd;
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
    private BdListView hAo;
    private LinearLayout hAu;
    private String hBA;
    private SearchEditView hBs;
    private TextView hBt;
    private AutoLineWrapLayout hBv;
    private SearchEmotionModel hBx;
    private List<String> hBz;
    private String hVS;
    private TextView hWR;
    private FrameLayout hWS;
    private d hWT;
    private List<String> hWU;
    private View hsy;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a fcH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bhh() == null || aVar.bhh().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.bQD();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bhg() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bhh());
            if (PbSearchEmotionActivity.this.hWT == null) {
                PbSearchEmotionActivity.this.hWT = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hWT.dL(PbSearchEmotionActivity.this.hWU);
                PbSearchEmotionActivity.this.hWT.a(PbSearchEmotionActivity.this.hLt);
                PbSearchEmotionActivity.this.hAo.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hWT);
            } else {
                PbSearchEmotionActivity.this.hWT.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bQA();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hBs);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bQD();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bQC();
        }
    };
    private final a hLt = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bd.cF(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hVS);
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
            this.hBz = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hVS = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hBA = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hWU = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.hBx = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hBA)) {
            this.hBs.setText(this.hBA);
            Bu(this.hBA);
        }
    }

    private void initView() {
        this.hAu = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.hWS = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.hsy = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hBs = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.hBs.setCallback(this);
        this.hWR = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.hBt = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.hAo = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.hAo.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hBs.setText("");
        this.hBs.bho();
        ShowSoftKeyPadDelay(this.hBs, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bYq();
        bQz();
    }

    private void bQz() {
        this.hBv = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.hBz == null || this.hBz.isEmpty()) {
            this.hBv.setVisibility(8);
            return;
        }
        this.hBt.setVisibility(0);
        this.hBt.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.hBz.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hBz.get(i);
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
                        PbSearchEmotionActivity.this.hBs.setText(str);
                        PbSearchEmotionActivity.this.hBs.setSelection(str.length());
                        PbSearchEmotionActivity.this.Bu(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hBv.addView(textView);
            }
        }
    }

    private void bYq() {
        this.hWR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.kc()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.hBA = str;
            this.hBx.a(str, this.mCurrentPage + 1, 40, this.fcH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQC() {
        if (!j.kc()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.hBx.a(this.hBA, this.mCurrentPage + 1, 40, this.fcH);
        }
    }

    private void bQB() {
        this.hBv.setVisibility(0);
        this.hBt.setText(getResources().getString(R.string.hot_emotion));
        this.hBt.setVisibility(0);
        this.hAo.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQA() {
        this.hAo.setVisibility(0);
        this.hBt.setText(getResources().getString(R.string.click_send_emotion));
        this.hBt.setVisibility(0);
        this.hBv.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQD() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hWS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hBv.setVisibility(8);
        this.hAo.setVisibility(8);
        this.hBt.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.hAu);
        am.k(this.hAu, R.color.cp_bg_line_d);
        am.l(this.hsy, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hBx != null) {
            this.hBx.cancelLoadData();
        }
        if (this.hAo != null) {
            this.hAo.removeAllViewsInLayout();
            this.hAo = null;
        }
        if (this.hWT != null) {
            this.hWT.removeListener();
            this.hWT.bQF();
            this.hWT = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void wc(String str) {
        Bu(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void wd(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.hWT != null) {
                this.hWT.notifyDataSetChanged();
            }
            bQB();
        }
    }
}
