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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
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
    private View eNE;
    private BdListView eVd;
    private LinearLayout eVj;
    private SearchEditView eWk;
    private TextView eWl;
    private AutoLineWrapLayout eWn;
    private SearchEmotionModel eWp;
    private List<String> eWr;
    private String eWs;
    private String fqr;
    private TextView fri;
    private FrameLayout frj;
    private d frk;
    private List<String> frl;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a cKt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.alA() == null || aVar.alA().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aTL();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.alz() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.alA());
            if (PbSearchEmotionActivity.this.frk == null) {
                PbSearchEmotionActivity.this.frk = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.frk.cP(PbSearchEmotionActivity.this.frl);
                PbSearchEmotionActivity.this.frk.a(PbSearchEmotionActivity.this.ffD);
                PbSearchEmotionActivity.this.eVd.setAdapter((ListAdapter) PbSearchEmotionActivity.this.frk);
            } else {
                PbSearchEmotionActivity.this.frk.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aTI();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.eWk);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aTL();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aTK();
        }
    };
    private final a ffD = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                az.aK(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fqr);
                com.baidu.adp.lib.f.c.fp().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
        setContentView(d.i.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.eWr = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fqr = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.eWs = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.frl = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.eWp = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.eWs)) {
            this.eWk.setText(this.eWs);
            qb(this.eWs);
        }
    }

    private void initView() {
        this.eVj = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.frj = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.eNE = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.eWk = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.eWk.setCallback(this);
        this.fri = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.eWl = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.eVd = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.eVd.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.eWk.setText("");
        this.eWk.alH();
        ShowSoftKeyPadDelay(this.eWk, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        baV();
        aTH();
    }

    private void aTH() {
        this.eWn = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.eWr == null || this.eWr.isEmpty()) {
            this.eWn.setVisibility(8);
            return;
        }
        this.eWl.setVisibility(0);
        this.eWl.setText(getResources().getString(d.k.hot_emotion));
        int min = Math.min(this.eWr.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.eWr.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                ak.j(textView, d.C0126d.cp_bg_line_e);
                ak.h(textView, d.C0126d.cp_cont_f);
                int e = l.e(this.mActivity, d.e.ds16);
                textView.setPadding(e, e, e, e);
                textView.setText(str2);
                textView.setTextSize(0, l.e(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        PbSearchEmotionActivity.this.eWk.setText(str);
                        PbSearchEmotionActivity.this.eWk.setSelection(str.length());
                        PbSearchEmotionActivity.this.qb(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.eWn.addView(textView);
            }
        }
    }

    private void baV() {
        this.fri.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qb(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.gP()) {
                showToast(d.k.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.eWs = str;
            this.eWp.a(str, this.mCurrentPage + 1, 40, this.cKt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTK() {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.eWp.a(this.eWs, this.mCurrentPage + 1, 40, this.cKt);
        }
    }

    private void aTJ() {
        this.eWn.setVisibility(0);
        this.eWl.setText(getResources().getString(d.k.hot_emotion));
        this.eWl.setVisibility(0);
        this.eVd.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTI() {
        this.eVd.setVisibility(0);
        this.eWl.setText(getResources().getString(d.k.click_send_emotion));
        this.eWl.setVisibility(0);
        this.eWn.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTL() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.frj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.mActivity, d.e.ds320)), NoDataViewFactory.d.m16do(d.k.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eWn.setVisibility(8);
        this.eVd.setVisibility(8);
        this.eWl.setVisibility(8);
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
        getLayoutMode().u(this.eVj);
        ak.i(this.eVj, d.C0126d.cp_bg_line_d);
        ak.j(this.eNE, d.C0126d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eWp != null) {
            this.eWp.cancelLoadData();
        }
        if (this.eVd != null) {
            this.eVd.removeAllViewsInLayout();
            this.eVd = null;
        }
        if (this.frk != null) {
            this.frk.removeListener();
            this.frk.aTN();
            this.frk = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kX(String str) {
        qb(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kY(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.frk != null) {
                this.frk.notifyDataSetChanged();
            }
            aTJ();
        }
    }
}
