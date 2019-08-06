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
    private BdListView hBg;
    private LinearLayout hBm;
    private SearchEditView hCk;
    private TextView hCl;
    private AutoLineWrapLayout hCn;
    private SearchEmotionModel hCp;
    private List<String> hCr;
    private String hCs;
    private String hWO;
    private TextView hXN;
    private FrameLayout hXO;
    private d hXP;
    private List<String> hXQ;
    private View htq;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a fdh = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bho() == null || aVar.bho().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.bQR();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bhn() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bho());
            if (PbSearchEmotionActivity.this.hXP == null) {
                PbSearchEmotionActivity.this.hXP = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hXP.dK(PbSearchEmotionActivity.this.hXQ);
                PbSearchEmotionActivity.this.hXP.a(PbSearchEmotionActivity.this.hMn);
                PbSearchEmotionActivity.this.hBg.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hXP);
            } else {
                PbSearchEmotionActivity.this.hXP.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bQO();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hCk);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bQR();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bQQ();
        }
    };
    private final a hMn = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bd.cF(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hWO);
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
            this.hCr = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hWO = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hCs = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hXQ = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.hCp = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hCs)) {
            this.hCk.setText(this.hCs);
            Bv(this.hCs);
        }
    }

    private void initView() {
        this.hBm = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.hXO = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.htq = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hCk = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.hCk.setCallback(this);
        this.hXN = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.hCl = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.hBg = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.hBg.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hCk.setText("");
        this.hCk.bhv();
        ShowSoftKeyPadDelay(this.hCk, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bYH();
        bQN();
    }

    private void bQN() {
        this.hCn = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.hCr == null || this.hCr.isEmpty()) {
            this.hCn.setVisibility(8);
            return;
        }
        this.hCl.setVisibility(0);
        this.hCl.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.hCr.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hCr.get(i);
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
                        PbSearchEmotionActivity.this.hCk.setText(str);
                        PbSearchEmotionActivity.this.hCk.setSelection(str.length());
                        PbSearchEmotionActivity.this.Bv(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hCn.addView(textView);
            }
        }
    }

    private void bYH() {
        this.hXN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bv(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.kc()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.hCs = str;
            this.hCp.a(str, this.mCurrentPage + 1, 40, this.fdh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQQ() {
        if (!j.kc()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.hCp.a(this.hCs, this.mCurrentPage + 1, 40, this.fdh);
        }
    }

    private void bQP() {
        this.hCn.setVisibility(0);
        this.hCl.setText(getResources().getString(R.string.hot_emotion));
        this.hCl.setVisibility(0);
        this.hBg.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQO() {
        this.hBg.setVisibility(0);
        this.hCl.setText(getResources().getString(R.string.click_send_emotion));
        this.hCl.setVisibility(0);
        this.hCn.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQR() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hXO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hCn.setVisibility(8);
        this.hBg.setVisibility(8);
        this.hCl.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.hBm);
        am.k(this.hBm, R.color.cp_bg_line_d);
        am.l(this.htq, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hCp != null) {
            this.hCp.cancelLoadData();
        }
        if (this.hBg != null) {
            this.hBg.removeAllViewsInLayout();
            this.hBg = null;
        }
        if (this.hXP != null) {
            this.hXP.removeListener();
            this.hXP.bQT();
            this.hXP = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void wd(String str) {
        Bv(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void we(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.hXP != null) {
                this.hXP.notifyDataSetChanged();
            }
            bQP();
        }
    }
}
