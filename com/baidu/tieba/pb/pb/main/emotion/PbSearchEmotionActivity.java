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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private BdListView fAd;
    private LinearLayout fAj;
    private SearchEditView fBk;
    private TextView fBl;
    private AutoLineWrapLayout fBn;
    private SearchEmotionModel fBp;
    private List<String> fBr;
    private String fBs;
    private String fVV;
    private TextView fWN;
    private FrameLayout fWO;
    private d fWP;
    private List<String> fWQ;
    private View fsE;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private final SearchEmotionModel.a drz = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.arj() == null || aVar.arj().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aYP();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.ari() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.arj());
            if (PbSearchEmotionActivity.this.fWP == null) {
                PbSearchEmotionActivity.this.fWP = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fWP.cX(PbSearchEmotionActivity.this.fWQ);
                PbSearchEmotionActivity.this.fWP.a(PbSearchEmotionActivity.this.fLH);
                PbSearchEmotionActivity.this.fAd.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fWP);
            } else {
                PbSearchEmotionActivity.this.fWP.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aYM();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fBk);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aYP();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aYO();
        }
    };
    private final a fLH = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ay.ba(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fVV);
                com.baidu.adp.lib.f.c.nm().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
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
        setContentView(d.h.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.fBr = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fVV = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fBs = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fWQ = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fBp = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fBs)) {
            this.fBk.setText(this.fBs);
            pV(this.fBs);
        }
    }

    private void initView() {
        this.fAj = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.fWO = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.fsE = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fBk = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.fBk.setCallback(this);
        this.fWN = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.fBl = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.fAd = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.fAd.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fBk.setText("");
        this.fBk.arq();
        ShowSoftKeyPadDelay(this.fBk, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bfX();
        aYL();
    }

    private void aYL() {
        this.fBn = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.fBr == null || this.fBr.isEmpty()) {
            this.fBn.setVisibility(8);
            return;
        }
        this.fBl.setVisibility(0);
        this.fBl.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.fBr.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fBr.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.t(textView, d.C0141d.cp_bg_line_e);
                aj.r(textView, d.C0141d.cp_cont_f);
                int t = l.t(this.mActivity, d.e.ds16);
                textView.setPadding(t, t, t, t);
                textView.setText(str2);
                textView.setTextSize(0, l.t(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fBk.setText(str);
                        PbSearchEmotionActivity.this.fBk.setSelection(str.length());
                        PbSearchEmotionActivity.this.pV(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fBn.addView(textView);
            }
        }
    }

    private void bfX() {
        this.fWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.oJ()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fBs = str;
            this.fBp.a(str, this.mCurrentPage + 1, 40, this.drz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYO() {
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fBp.a(this.fBs, this.mCurrentPage + 1, 40, this.drz);
        }
    }

    private void aYN() {
        this.fBn.setVisibility(0);
        this.fBl.setText(getResources().getString(d.j.hot_emotion));
        this.fBl.setVisibility(0);
        this.fAd.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYM() {
        this.fAd.setVisibility(0);
        this.fBl.setText(getResources().getString(d.j.click_send_emotion));
        this.fBl.setVisibility(0);
        this.fBn.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYP() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fWO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.mActivity, d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fBn.setVisibility(8);
        this.fAd.setVisibility(8);
        this.fBl.setVisibility(8);
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
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.fAj);
        aj.s(this.fAj, d.C0141d.cp_bg_line_d);
        aj.t(this.fsE, d.C0141d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fBp != null) {
            this.fBp.cancelLoadData();
        }
        if (this.fAd != null) {
            this.fAd.removeAllViewsInLayout();
            this.fAd = null;
        }
        if (this.fWP != null) {
            this.fWP.removeListener();
            this.fWP.aYR();
            this.fWP = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kU(String str) {
        pV(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kV(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fWP != null) {
                this.fWP.notifyDataSetChanged();
            }
            aYN();
        }
    }
}
