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
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.view.j;
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
    private SearchEditView eAG;
    private TextView eAH;
    private AutoLineWrapLayout eAJ;
    private SearchEmotionModel eAL;
    private List<String> eAN;
    private String eAO;
    private TextView eSC;
    private FrameLayout eSD;
    private b eSE;
    private View etR;
    private LinearLayout ezF;
    private BdListView ezz;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private final SearchEmotionModel.a cfe = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.adX() == null || aVar.adX().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aNX();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.adW() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.adX());
            if (PbSearchEmotionActivity.this.eSE == null) {
                PbSearchEmotionActivity.this.eSE = new b(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.eSE.a(PbSearchEmotionActivity.this.eJc);
                PbSearchEmotionActivity.this.ezz.setAdapter((ListAdapter) PbSearchEmotionActivity.this.eSE);
            } else {
                PbSearchEmotionActivity.this.eSE.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aNU();
            k.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.eAG);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aNX();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aNW();
        }
    };
    private final a eJc = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aU(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                c.fK().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
        setContentView(d.j.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.eAN = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
        }
        initView();
        this.eAL = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
    }

    private void initView() {
        this.ezF = (LinearLayout) this.mActivity.findViewById(d.h.layout_root);
        this.eSD = (FrameLayout) this.mActivity.findViewById(d.h.layout_content);
        this.etR = this.mActivity.findViewById(d.h.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.h.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.eAG = (SearchEditView) addCustomView.findViewById(d.h.edit_search_view);
        this.eAG.setCallback(this);
        this.eSC = (TextView) addCustomView.findViewById(d.h.tv_cancel);
        this.eAH = (TextView) this.mActivity.findViewById(d.h.tv_tips);
        this.ezz = (BdListView) this.mActivity.findViewById(d.h.listview_emotion);
        this.ezz.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.eAG.setText("");
        this.eAG.aeb();
        ShowSoftKeyPadDelay(this.eAG, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aTY();
        aNT();
    }

    private void aNT() {
        this.eAJ = (AutoLineWrapLayout) this.mActivity.findViewById(d.h.layout_hot_words);
        if (this.eAN == null || this.eAN.isEmpty()) {
            this.eAJ.setVisibility(8);
            return;
        }
        this.eAH.setVisibility(0);
        this.eAH.setText(getResources().getString(d.l.hot_emotion));
        int min = Math.min(this.eAN.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.eAN.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.k(textView, d.e.cp_bg_line_e);
                aj.i(textView, d.e.cp_cont_f);
                int f = k.f(this.mActivity, d.f.ds16);
                textView.setPadding(f, f, f, f);
                textView.setText(str2);
                textView.setTextSize(0, k.f(this.mActivity, d.f.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.eAG.setText(str);
                        PbSearchEmotionActivity.this.eAG.setSelection(str.length());
                        PbSearchEmotionActivity.this.oR(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.eAJ.addView(textView);
            }
        }
    }

    private void aTY() {
        this.eSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!i.hi()) {
                showToast(d.l.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.eAO = str;
            this.eAL.a(str, this.mCurrentPage + 1, 40, this.cfe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNW() {
        if (!i.hi()) {
            showToast(d.l.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.eAL.a(this.eAO, this.mCurrentPage + 1, 40, this.cfe);
        }
    }

    private void aNV() {
        this.eAJ.setVisibility(0);
        this.eAH.setText(getResources().getString(d.l.hot_emotion));
        this.eAH.setVisibility(0);
        this.ezz.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNU() {
        this.ezz.setVisibility(0);
        this.eAH.setText(getResources().getString(d.l.click_send_emotion));
        this.eAH.setVisibility(0);
        this.eAJ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNX() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eSD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.f(this.mActivity, d.f.ds320)), NoDataViewFactory.d.dl(d.l.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eAJ.setVisibility(8);
        this.ezz.setVisibility(8);
        this.eAH.setVisibility(8);
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
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.ezF);
        aj.j(this.ezF, d.e.cp_bg_line_d);
        aj.k(this.etR, d.e.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eAL != null) {
            this.eAL.cancelLoadData();
        }
        if (this.ezz != null) {
            this.ezz.removeAllViewsInLayout();
            this.ezz = null;
        }
        if (this.eSE != null) {
            this.eSE.removeListener();
            this.eSE.aOb();
            this.eSE = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jS(String str) {
        oR(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jT(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.eSE != null) {
                this.eSE.notifyDataSetChanged();
            }
            aNV();
        }
    }
}
