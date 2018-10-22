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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private LinearLayout eck;
    private BdListView fAH;
    private SearchEditView fBL;
    private TextView fBM;
    private AutoLineWrapLayout fBO;
    private SearchEmotionModel fBQ;
    private List<String> fBS;
    private String fBT;
    private String fVW;
    private TextView fWU;
    private FrameLayout fWV;
    private d fWW;
    private List<String> fWX;
    private View fsY;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a djr = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.auM() == null || aVar.auM().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.bdf();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.auL() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.auM());
            if (PbSearchEmotionActivity.this.fWW == null) {
                PbSearchEmotionActivity.this.fWW = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fWW.dm(PbSearchEmotionActivity.this.fWX);
                PbSearchEmotionActivity.this.fWW.a(PbSearchEmotionActivity.this.fLx);
                PbSearchEmotionActivity.this.fAH.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fWW);
            } else {
                PbSearchEmotionActivity.this.fWW.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bdc();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fBL);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bdf();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bde();
        }
    };
    private final a fLx = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bI(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fVW);
                com.baidu.adp.lib.f.c.jC().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
        setContentView(e.h.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.fBS = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fVW = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fBT = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fWX = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fBQ = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fBT)) {
            this.fBL.setText(this.fBT);
            rT(this.fBT);
        }
    }

    private void initView() {
        this.eck = (LinearLayout) this.mActivity.findViewById(e.g.layout_root);
        this.fWV = (FrameLayout) this.mActivity.findViewById(e.g.layout_content);
        this.fsY = this.mActivity.findViewById(e.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(e.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fBL = (SearchEditView) addCustomView.findViewById(e.g.edit_search_view);
        this.fBL.setCallback(this);
        this.fWU = (TextView) addCustomView.findViewById(e.g.tv_cancel);
        this.fBM = (TextView) this.mActivity.findViewById(e.g.tv_tips);
        this.fAH = (BdListView) this.mActivity.findViewById(e.g.listview_emotion);
        this.fAH.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fBL.setText("");
        this.fBL.auT();
        ShowSoftKeyPadDelay(this.fBL, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bkG();
        bdb();
    }

    private void bdb() {
        this.fBO = (AutoLineWrapLayout) this.mActivity.findViewById(e.g.layout_hot_words);
        if (this.fBS == null || this.fBS.isEmpty()) {
            this.fBO.setVisibility(8);
            return;
        }
        this.fBM.setVisibility(0);
        this.fBM.setText(getResources().getString(e.j.hot_emotion));
        int min = Math.min(this.fBS.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fBS.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                al.j(textView, e.d.cp_bg_line_e);
                al.h(textView, e.d.cp_cont_f);
                int h = l.h(this.mActivity, e.C0175e.ds16);
                textView.setPadding(h, h, h, h);
                textView.setText(str2);
                textView.setTextSize(0, l.h(this.mActivity, e.C0175e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fBL.setText(str);
                        PbSearchEmotionActivity.this.fBL.setSelection(str.length());
                        PbSearchEmotionActivity.this.rT(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fBO.addView(textView);
            }
        }
    }

    private void bkG() {
        this.fWU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rT(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.kX()) {
                showToast(e.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fBT = str;
            this.fBQ.a(str, this.mCurrentPage + 1, 40, this.djr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bde() {
        if (!j.kX()) {
            showToast(e.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fBQ.a(this.fBT, this.mCurrentPage + 1, 40, this.djr);
        }
    }

    private void bdd() {
        this.fBO.setVisibility(0);
        this.fBM.setText(getResources().getString(e.j.hot_emotion));
        this.fBM.setVisibility(0);
        this.fAH.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdc() {
        this.fAH.setVisibility(0);
        this.fBM.setText(getResources().getString(e.j.click_send_emotion));
        this.fBM.setVisibility(0);
        this.fBO.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdf() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fWV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.mActivity, e.C0175e.ds320)), NoDataViewFactory.d.dO(e.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fBO.setVisibility(8);
        this.fAH.setVisibility(8);
        this.fBM.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.eck);
        al.i(this.eck, e.d.cp_bg_line_d);
        al.j(this.fsY, e.d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fBQ != null) {
            this.fBQ.cancelLoadData();
        }
        if (this.fAH != null) {
            this.fAH.removeAllViewsInLayout();
            this.fAH = null;
        }
        if (this.fWW != null) {
            this.fWW.removeListener();
            this.fWW.bdh();
            this.fWW = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void mH(String str) {
        rT(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void mI(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fWW != null) {
                this.fWW.notifyDataSetChanged();
            }
            bdd();
        }
    }
}
