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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private View eBq;
    private LinearLayout eIA;
    private BdListView eIu;
    private SearchEditView eJB;
    private TextView eJC;
    private AutoLineWrapLayout eJE;
    private SearchEmotionModel eJG;
    private List<String> eJI;
    private String eJJ;
    private TextView feT;
    private FrameLayout feU;
    private d feV;
    private List<String> feW;
    private String feb;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private final SearchEmotionModel.a cvw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.ahN() == null || aVar.ahN().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aPN();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.ahM() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.ahN());
            if (PbSearchEmotionActivity.this.feV == null) {
                PbSearchEmotionActivity.this.feV = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.feV.cM(PbSearchEmotionActivity.this.feW);
                PbSearchEmotionActivity.this.feV.a(PbSearchEmotionActivity.this.eUg);
                PbSearchEmotionActivity.this.eIu.setAdapter((ListAdapter) PbSearchEmotionActivity.this.feV);
            } else {
                PbSearchEmotionActivity.this.feV.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aPK();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.eJB);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aPN();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aPM();
        }
    };
    private final a eUg = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aS(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.feb);
                com.baidu.adp.lib.f.c.fJ().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbSearchEmotionActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbSearchEmotionActivity.this.getUniqueId());
            } else {
                PbSearchEmotionActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_SEARCH)));
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
            this.eJI = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.feb = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.eJJ = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.feW = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.eJG = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.eJJ)) {
            this.eJB.setText(this.eJJ);
            ps(this.eJJ);
        }
    }

    private void initView() {
        this.eIA = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.feU = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.eBq = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.eJB = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.eJB.setCallback(this);
        this.feT = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.eJC = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.eIu = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.eIu.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.eJB.setText("");
        this.eJB.ahU();
        ShowSoftKeyPadDelay(this.eJB, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aXb();
        aPJ();
    }

    private void aPJ() {
        this.eJE = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.eJI == null || this.eJI.isEmpty()) {
            this.eJE.setVisibility(8);
            return;
        }
        this.eJC.setVisibility(0);
        this.eJC.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.eJI.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.eJI.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.k(textView, d.C0096d.cp_bg_line_e);
                aj.i(textView, d.C0096d.cp_cont_f);
                int f = l.f(this.mActivity, d.e.ds16);
                textView.setPadding(f, f, f, f);
                textView.setText(str2);
                textView.setTextSize(0, l.f(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.eJB.setText(str);
                        PbSearchEmotionActivity.this.eJB.setSelection(str.length());
                        PbSearchEmotionActivity.this.ps(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.eJE.addView(textView);
            }
        }
    }

    private void aXb() {
        this.feT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ps(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.hh()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.eJJ = str;
            this.eJG.a(str, this.mCurrentPage + 1, 40, this.cvw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPM() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.eJG.a(this.eJJ, this.mCurrentPage + 1, 40, this.cvw);
        }
    }

    private void aPL() {
        this.eJE.setVisibility(0);
        this.eJC.setText(getResources().getString(d.j.hot_emotion));
        this.eJC.setVisibility(0);
        this.eIu.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPK() {
        this.eIu.setVisibility(0);
        this.eJC.setText(getResources().getString(d.j.click_send_emotion));
        this.eJC.setVisibility(0);
        this.eJE.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPN() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.feU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.mActivity, d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eJE.setVisibility(8);
        this.eIu.setVisibility(8);
        this.eJC.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
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
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.eIA);
        aj.j(this.eIA, d.C0096d.cp_bg_line_d);
        aj.k(this.eBq, d.C0096d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eJG != null) {
            this.eJG.cancelLoadData();
        }
        if (this.eIu != null) {
            this.eIu.removeAllViewsInLayout();
            this.eIu = null;
        }
        if (this.feV != null) {
            this.feV.removeListener();
            this.feV.aPP();
            this.feV = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kr(String str) {
        ps(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void ks(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.feV != null) {
                this.feV.notifyDataSetChanged();
            }
            aPL();
        }
    }
}
