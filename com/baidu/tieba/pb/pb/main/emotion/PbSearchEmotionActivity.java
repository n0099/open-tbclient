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
import com.baidu.tbadk.core.util.ba;
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
    private LinearLayout dNc;
    private TextView fHU;
    private FrameLayout fHV;
    private d fHW;
    private List<String> fHX;
    private String fHb;
    private View fdX;
    private BdListView flL;
    private SearchEditView fmQ;
    private TextView fmR;
    private AutoLineWrapLayout fmT;
    private SearchEmotionModel fmV;
    private List<String> fmX;
    private String fmY;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a cVs = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.apB() == null || aVar.apB().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aXK();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.apA() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.apB());
            if (PbSearchEmotionActivity.this.fHW == null) {
                PbSearchEmotionActivity.this.fHW = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fHW.cX(PbSearchEmotionActivity.this.fHX);
                PbSearchEmotionActivity.this.fHW.a(PbSearchEmotionActivity.this.fwk);
                PbSearchEmotionActivity.this.flL.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fHW);
            } else {
                PbSearchEmotionActivity.this.fHW.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aXH();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fmQ);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aXK();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aXJ();
        }
    };
    private final a fwk = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.aV(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fHb);
                com.baidu.adp.lib.f.c.ih().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
        setContentView(d.h.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.fmX = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fHb = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fmY = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fHX = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fmV = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fmY)) {
            this.fmQ.setText(this.fmY);
            qL(this.fmY);
        }
    }

    private void initView() {
        this.dNc = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.fHV = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.fdX = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fmQ = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.fmQ.setCallback(this);
        this.fHU = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.fmR = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.flL = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.flL.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fmQ.setText("");
        this.fmQ.apI();
        ShowSoftKeyPadDelay(this.fmQ, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        beV();
        aXG();
    }

    private void aXG() {
        this.fmT = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.fmX == null || this.fmX.isEmpty()) {
            this.fmT.setVisibility(8);
            return;
        }
        this.fmR.setVisibility(0);
        this.fmR.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.fmX.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fmX.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                am.j(textView, d.C0140d.cp_bg_line_e);
                am.h(textView, d.C0140d.cp_cont_f);
                int f = l.f(this.mActivity, d.e.ds16);
                textView.setPadding(f, f, f, f);
                textView.setText(str2);
                textView.setTextSize(0, l.f(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fmQ.setText(str);
                        PbSearchEmotionActivity.this.fmQ.setSelection(str.length());
                        PbSearchEmotionActivity.this.qL(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fmT.addView(textView);
            }
        }
    }

    private void beV() {
        this.fHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qL(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.jE()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fmY = str;
            this.fmV.a(str, this.mCurrentPage + 1, 40, this.cVs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXJ() {
        if (!j.jE()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fmV.a(this.fmY, this.mCurrentPage + 1, 40, this.cVs);
        }
    }

    private void aXI() {
        this.fmT.setVisibility(0);
        this.fmR.setText(getResources().getString(d.j.hot_emotion));
        this.fmR.setVisibility(0);
        this.flL.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXH() {
        this.flL.setVisibility(0);
        this.fmR.setText(getResources().getString(d.j.click_send_emotion));
        this.fmR.setVisibility(0);
        this.fmT.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXK() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fHV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.mActivity, d.e.ds320)), NoDataViewFactory.d.du(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fmT.setVisibility(8);
        this.flL.setVisibility(8);
        this.fmR.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.dNc);
        am.i(this.dNc, d.C0140d.cp_bg_line_d);
        am.j(this.fdX, d.C0140d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fmV != null) {
            this.fmV.cancelLoadData();
        }
        if (this.flL != null) {
            this.flL.removeAllViewsInLayout();
            this.flL = null;
        }
        if (this.fHW != null) {
            this.fHW.removeListener();
            this.fHW.aXM();
            this.fHW = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void lB(String str) {
        qL(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void lC(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fHW != null) {
                this.fHW.notifyDataSetChanged();
            }
            aXI();
        }
    }
}
