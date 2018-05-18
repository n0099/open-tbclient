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
    private View eOI;
    private BdListView eWh;
    private LinearLayout eWn;
    private SearchEditView eXo;
    private TextView eXp;
    private AutoLineWrapLayout eXr;
    private SearchEmotionModel eXt;
    private List<String> eXv;
    private String eXw;
    private String frw;
    private TextView fsn;
    private FrameLayout fso;
    private d fsp;
    private List<String> fsq;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a cLx = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
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
            if (PbSearchEmotionActivity.this.fsp == null) {
                PbSearchEmotionActivity.this.fsp = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fsp.cS(PbSearchEmotionActivity.this.fsq);
                PbSearchEmotionActivity.this.fsp.a(PbSearchEmotionActivity.this.fgH);
                PbSearchEmotionActivity.this.eWh.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fsp);
            } else {
                PbSearchEmotionActivity.this.fsp.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aTI();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.eXo);
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
    private final a fgH = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                az.aK(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.frw);
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
            this.eXv = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.frw = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.eXw = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fsq = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.eXt = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.eXw)) {
            this.eXo.setText(this.eXw);
            qe(this.eXw);
        }
    }

    private void initView() {
        this.eWn = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.fso = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.eOI = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.eXo = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.eXo.setCallback(this);
        this.fsn = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.eXp = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.eWh = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.eWh.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.eXo.setText("");
        this.eXo.alH();
        ShowSoftKeyPadDelay(this.eXo, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        baV();
        aTH();
    }

    private void aTH() {
        this.eXr = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.eXv == null || this.eXv.isEmpty()) {
            this.eXr.setVisibility(8);
            return;
        }
        this.eXp.setVisibility(0);
        this.eXp.setText(getResources().getString(d.k.hot_emotion));
        int min = Math.min(this.eXv.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.eXv.get(i);
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
                        PbSearchEmotionActivity.this.eXo.setText(str);
                        PbSearchEmotionActivity.this.eXo.setSelection(str.length());
                        PbSearchEmotionActivity.this.qe(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.eXr.addView(textView);
            }
        }
    }

    private void baV() {
        this.fsn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.gP()) {
                showToast(d.k.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.eXw = str;
            this.eXt.a(str, this.mCurrentPage + 1, 40, this.cLx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTK() {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.eXt.a(this.eXw, this.mCurrentPage + 1, 40, this.cLx);
        }
    }

    private void aTJ() {
        this.eXr.setVisibility(0);
        this.eXp.setText(getResources().getString(d.k.hot_emotion));
        this.eXp.setVisibility(0);
        this.eWh.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTI() {
        this.eWh.setVisibility(0);
        this.eXp.setText(getResources().getString(d.k.click_send_emotion));
        this.eXp.setVisibility(0);
        this.eXr.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTL() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fso, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.mActivity, d.e.ds320)), NoDataViewFactory.d.dp(d.k.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eXr.setVisibility(8);
        this.eWh.setVisibility(8);
        this.eXp.setVisibility(8);
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
        getLayoutMode().u(this.eWn);
        ak.i(this.eWn, d.C0126d.cp_bg_line_d);
        ak.j(this.eOI, d.C0126d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eXt != null) {
            this.eXt.cancelLoadData();
        }
        if (this.eWh != null) {
            this.eWh.removeAllViewsInLayout();
            this.eWh = null;
        }
        if (this.fsp != null) {
            this.fsp.removeListener();
            this.fsp.aTN();
            this.fsp = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void la(String str) {
        qe(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void lb(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fsp != null) {
                this.fsp.notifyDataSetChanged();
            }
            aTJ();
        }
    }
}
