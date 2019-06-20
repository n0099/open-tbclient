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
    private String hPF;
    private TextView hQE;
    private FrameLayout hQF;
    private d hQG;
    private List<String> hQH;
    private View hml;
    private BdListView huc;
    private LinearLayout hui;
    private SearchEditView hvg;
    private TextView hvh;
    private AutoLineWrapLayout hvj;
    private SearchEmotionModel hvl;
    private List<String> hvn;
    private String hvo;
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
                    PbSearchEmotionActivity.this.bNU();
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
            if (PbSearchEmotionActivity.this.hQG == null) {
                PbSearchEmotionActivity.this.hQG = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hQG.dJ(PbSearchEmotionActivity.this.hQH);
                PbSearchEmotionActivity.this.hQG.a(PbSearchEmotionActivity.this.hFg);
                PbSearchEmotionActivity.this.huc.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hQG);
            } else {
                PbSearchEmotionActivity.this.hQG.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bNR();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hvg);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bNU();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bNT();
        }
    };
    private final a hFg = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.cE(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hPF);
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
            this.hvn = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hPF = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hvo = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hQH = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.hvl = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hvo)) {
            this.hvg.setText(this.hvo);
            AJ(this.hvo);
        }
    }

    private void initView() {
        this.hui = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.hQF = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.hml = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hvg = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.hvg.setCallback(this);
        this.hQE = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.hvh = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.huc = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.huc.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hvg.setText("");
        this.hvg.bfl();
        ShowSoftKeyPadDelay(this.hvg, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bVC();
        bNQ();
    }

    private void bNQ() {
        this.hvj = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.hvn == null || this.hvn.isEmpty()) {
            this.hvj.setVisibility(8);
            return;
        }
        this.hvh.setVisibility(0);
        this.hvh.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.hvn.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hvn.get(i);
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
                        PbSearchEmotionActivity.this.hvg.setText(str);
                        PbSearchEmotionActivity.this.hvg.setSelection(str.length());
                        PbSearchEmotionActivity.this.AJ(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hvj.addView(textView);
            }
        }
    }

    private void bVC() {
        this.hQE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.jS()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.hvo = str;
            this.hvl.a(str, this.mCurrentPage + 1, 40, this.eXG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNT() {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.hvl.a(this.hvo, this.mCurrentPage + 1, 40, this.eXG);
        }
    }

    private void bNS() {
        this.hvj.setVisibility(0);
        this.hvh.setText(getResources().getString(R.string.hot_emotion));
        this.hvh.setVisibility(0);
        this.huc.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNR() {
        this.huc.setVisibility(0);
        this.hvh.setText(getResources().getString(R.string.click_send_emotion));
        this.hvh.setVisibility(0);
        this.hvj.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNU() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hQF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hvj.setVisibility(8);
        this.huc.setVisibility(8);
        this.hvh.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.hui);
        al.k(this.hui, R.color.cp_bg_line_d);
        al.l(this.hml, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hvl != null) {
            this.hvl.cancelLoadData();
        }
        if (this.huc != null) {
            this.huc.removeAllViewsInLayout();
            this.huc = null;
        }
        if (this.hQG != null) {
            this.hQG.removeListener();
            this.hQG.bNW();
            this.hQG = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void vx(String str) {
        AJ(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void vy(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.hQG != null) {
                this.hQG.notifyDataSetChanged();
            }
            bNS();
        }
    }
}
