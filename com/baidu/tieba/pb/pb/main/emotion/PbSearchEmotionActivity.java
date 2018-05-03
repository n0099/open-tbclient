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
    private View eNB;
    private BdListView eVa;
    private LinearLayout eVg;
    private SearchEditView eWh;
    private TextView eWi;
    private AutoLineWrapLayout eWk;
    private SearchEmotionModel eWm;
    private List<String> eWo;
    private String eWp;
    private String fqo;
    private TextView frf;
    private FrameLayout frg;
    private d frh;
    private List<String> fri;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a cKq = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
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
            if (PbSearchEmotionActivity.this.frh == null) {
                PbSearchEmotionActivity.this.frh = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.frh.cP(PbSearchEmotionActivity.this.fri);
                PbSearchEmotionActivity.this.frh.a(PbSearchEmotionActivity.this.ffA);
                PbSearchEmotionActivity.this.eVa.setAdapter((ListAdapter) PbSearchEmotionActivity.this.frh);
            } else {
                PbSearchEmotionActivity.this.frh.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aTI();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.eWh);
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
    private final a ffA = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                az.aK(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fqo);
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
            this.eWo = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fqo = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.eWp = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fri = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.eWm = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.eWp)) {
            this.eWh.setText(this.eWp);
            qb(this.eWp);
        }
    }

    private void initView() {
        this.eVg = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.frg = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.eNB = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.eWh = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.eWh.setCallback(this);
        this.frf = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.eWi = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.eVa = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.eVa.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.eWh.setText("");
        this.eWh.alH();
        ShowSoftKeyPadDelay(this.eWh, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        baV();
        aTH();
    }

    private void aTH() {
        this.eWk = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.eWo == null || this.eWo.isEmpty()) {
            this.eWk.setVisibility(8);
            return;
        }
        this.eWi.setVisibility(0);
        this.eWi.setText(getResources().getString(d.k.hot_emotion));
        int min = Math.min(this.eWo.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.eWo.get(i);
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
                        PbSearchEmotionActivity.this.eWh.setText(str);
                        PbSearchEmotionActivity.this.eWh.setSelection(str.length());
                        PbSearchEmotionActivity.this.qb(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.eWk.addView(textView);
            }
        }
    }

    private void baV() {
        this.frf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
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
            this.eWp = str;
            this.eWm.a(str, this.mCurrentPage + 1, 40, this.cKq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTK() {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.eWm.a(this.eWp, this.mCurrentPage + 1, 40, this.cKq);
        }
    }

    private void aTJ() {
        this.eWk.setVisibility(0);
        this.eWi.setText(getResources().getString(d.k.hot_emotion));
        this.eWi.setVisibility(0);
        this.eVa.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTI() {
        this.eVa.setVisibility(0);
        this.eWi.setText(getResources().getString(d.k.click_send_emotion));
        this.eWi.setVisibility(0);
        this.eWk.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTL() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.frg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.mActivity, d.e.ds320)), NoDataViewFactory.d.m16do(d.k.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eWk.setVisibility(8);
        this.eVa.setVisibility(8);
        this.eWi.setVisibility(8);
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
        getLayoutMode().u(this.eVg);
        ak.i(this.eVg, d.C0126d.cp_bg_line_d);
        ak.j(this.eNB, d.C0126d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eWm != null) {
            this.eWm.cancelLoadData();
        }
        if (this.eVa != null) {
            this.eVa.removeAllViewsInLayout();
            this.eVa = null;
        }
        if (this.frh != null) {
            this.frh.removeListener();
            this.frh.aTN();
            this.frh = null;
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
            if (this.frh != null) {
                this.frh.notifyDataSetChanged();
            }
            aTJ();
        }
    }
}
