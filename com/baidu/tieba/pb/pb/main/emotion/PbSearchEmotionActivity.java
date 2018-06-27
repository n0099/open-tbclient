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
import com.baidu.tbadk.core.util.bb;
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
    private LinearLayout dKm;
    private String fGO;
    private TextView fHF;
    private FrameLayout fHG;
    private d fHH;
    private List<String> fHI;
    private View fdR;
    private BdListView flz;
    private SearchEditView fmF;
    private TextView fmG;
    private AutoLineWrapLayout fmI;
    private SearchEmotionModel fmK;
    private List<String> fmM;
    private String fmN;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a cSF = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.apa() == null || aVar.apa().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aZo();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.aoZ() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.apa());
            if (PbSearchEmotionActivity.this.fHH == null) {
                PbSearchEmotionActivity.this.fHH = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fHH.db(PbSearchEmotionActivity.this.fHI);
                PbSearchEmotionActivity.this.fHH.a(PbSearchEmotionActivity.this.fvY);
                PbSearchEmotionActivity.this.flz.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fHH);
            } else {
                PbSearchEmotionActivity.this.fHH.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aZl();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fmF);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aZo();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aZn();
        }
    };
    private final a fvY = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bb.aU(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fGO);
                com.baidu.adp.lib.f.c.ig().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.fmM = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fGO = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fmN = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fHI = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fmK = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fmN)) {
            this.fmF.setText(this.fmN);
            qS(this.fmN);
        }
    }

    private void initView() {
        this.dKm = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.fHG = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.fdR = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fmF = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.fmF.setCallback(this);
        this.fHF = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.fmG = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.flz = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.flz.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fmF.setText("");
        this.fmF.aph();
        ShowSoftKeyPadDelay(this.fmF, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bgC();
        aZk();
    }

    private void aZk() {
        this.fmI = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.fmM == null || this.fmM.isEmpty()) {
            this.fmI.setVisibility(8);
            return;
        }
        this.fmG.setVisibility(0);
        this.fmG.setText(getResources().getString(d.k.hot_emotion));
        int min = Math.min(this.fmM.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fmM.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                am.j(textView, d.C0142d.cp_bg_line_e);
                am.h(textView, d.C0142d.cp_cont_f);
                int e = l.e(this.mActivity, d.e.ds16);
                textView.setPadding(e, e, e, e);
                textView.setText(str2);
                textView.setTextSize(0, l.e(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fmF.setText(str);
                        PbSearchEmotionActivity.this.fmF.setSelection(str.length());
                        PbSearchEmotionActivity.this.qS(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fmI.addView(textView);
            }
        }
    }

    private void bgC() {
        this.fHF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qS(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.jD()) {
                showToast(d.k.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fmN = str;
            this.fmK.a(str, this.mCurrentPage + 1, 40, this.cSF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZn() {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fmK.a(this.fmN, this.mCurrentPage + 1, 40, this.cSF);
        }
    }

    private void aZm() {
        this.fmI.setVisibility(0);
        this.fmG.setText(getResources().getString(d.k.hot_emotion));
        this.fmG.setVisibility(0);
        this.flz.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZl() {
        this.flz.setVisibility(0);
        this.fmG.setText(getResources().getString(d.k.click_send_emotion));
        this.fmG.setVisibility(0);
        this.fmI.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZo() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fHG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.mActivity, d.e.ds320)), NoDataViewFactory.d.ds(d.k.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fmI.setVisibility(8);
        this.flz.setVisibility(8);
        this.fmG.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.dKm);
        am.i(this.dKm, d.C0142d.cp_bg_line_d);
        am.j(this.fdR, d.C0142d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fmK != null) {
            this.fmK.cancelLoadData();
        }
        if (this.flz != null) {
            this.flz.removeAllViewsInLayout();
            this.flz = null;
        }
        if (this.fHH != null) {
            this.fHH.removeListener();
            this.fHH.aZq();
            this.fHH = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void lC(String str) {
        qS(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void lD(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fHH != null) {
                this.fHH.notifyDataSetChanged();
            }
            aZm();
        }
    }
}
