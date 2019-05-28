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
import com.baidu.tbadk.core.util.al;
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
    private String hPE;
    private TextView hQD;
    private FrameLayout hQE;
    private d hQF;
    private List<String> hQG;
    private View hmk;
    private BdListView hub;
    private LinearLayout huh;
    private SearchEditView hvf;
    private TextView hvg;
    private AutoLineWrapLayout hvi;
    private SearchEmotionModel hvk;
    private List<String> hvm;
    private String hvn;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a eXG = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bfe() == null || aVar.bfe().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.bNT();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bfd() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bfe());
            if (PbSearchEmotionActivity.this.hQF == null) {
                PbSearchEmotionActivity.this.hQF = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hQF.dJ(PbSearchEmotionActivity.this.hQG);
                PbSearchEmotionActivity.this.hQF.a(PbSearchEmotionActivity.this.hFf);
                PbSearchEmotionActivity.this.hub.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hQF);
            } else {
                PbSearchEmotionActivity.this.hQF.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bNQ();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hvf);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bNT();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bNS();
        }
    };
    private final a hFf = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.cE(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hPE);
                com.baidu.adp.lib.f.c.iv().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.hvm = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hPE = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hvn = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hQG = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.hvk = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hvn)) {
            this.hvf.setText(this.hvn);
            AH(this.hvn);
        }
    }

    private void initView() {
        this.huh = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.hQE = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.hmk = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hvf = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.hvf.setCallback(this);
        this.hQD = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.hvg = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.hub = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.hub.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hvf.setText("");
        this.hvf.bfl();
        ShowSoftKeyPadDelay(this.hvf, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bVB();
        bNP();
    }

    private void bNP() {
        this.hvi = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.hvm == null || this.hvm.isEmpty()) {
            this.hvi.setVisibility(8);
            return;
        }
        this.hvg.setVisibility(0);
        this.hvg.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.hvm.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hvm.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                al.l(textView, R.color.cp_bg_line_e);
                al.j(textView, R.color.cp_cont_f);
                int g = l.g(this.mActivity, R.dimen.ds16);
                textView.setPadding(g, g, g, g);
                textView.setText(str2);
                textView.setTextSize(0, l.g(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.hvf.setText(str);
                        PbSearchEmotionActivity.this.hvf.setSelection(str.length());
                        PbSearchEmotionActivity.this.AH(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hvi.addView(textView);
            }
        }
    }

    private void bVB() {
        this.hQD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AH(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.jS()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.hvn = str;
            this.hvk.a(str, this.mCurrentPage + 1, 40, this.eXG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNS() {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.hvk.a(this.hvn, this.mCurrentPage + 1, 40, this.eXG);
        }
    }

    private void bNR() {
        this.hvi.setVisibility(0);
        this.hvg.setText(getResources().getString(R.string.hot_emotion));
        this.hvg.setVisibility(0);
        this.hub.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNQ() {
        this.hub.setVisibility(0);
        this.hvg.setText(getResources().getString(R.string.click_send_emotion));
        this.hvg.setVisibility(0);
        this.hvi.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNT() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hQE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hvi.setVisibility(8);
        this.hub.setVisibility(8);
        this.hvg.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.huh);
        al.k(this.huh, R.color.cp_bg_line_d);
        al.l(this.hmk, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hvk != null) {
            this.hvk.cancelLoadData();
        }
        if (this.hub != null) {
            this.hub.removeAllViewsInLayout();
            this.hub = null;
        }
        if (this.hQF != null) {
            this.hQF.removeListener();
            this.hQF.bNV();
            this.hQF = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void vy(String str) {
        AH(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void vz(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.hQF != null) {
                this.hQF.notifyDataSetChanged();
            }
            bNR();
        }
    }
}
