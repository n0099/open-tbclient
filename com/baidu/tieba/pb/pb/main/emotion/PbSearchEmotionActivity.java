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
import com.baidu.tieba.f;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private LinearLayout dMY;
    private String fGU;
    private TextView fHN;
    private FrameLayout fHO;
    private d fHP;
    private List<String> fHQ;
    private View fdR;
    private BdListView flF;
    private SearchEditView fmK;
    private TextView fmL;
    private AutoLineWrapLayout fmN;
    private SearchEmotionModel fmP;
    private List<String> fmR;
    private String fmS;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a cVo = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.apB() == null || aVar.apB().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aXG();
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
            if (PbSearchEmotionActivity.this.fHP == null) {
                PbSearchEmotionActivity.this.fHP = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fHP.cX(PbSearchEmotionActivity.this.fHQ);
                PbSearchEmotionActivity.this.fHP.a(PbSearchEmotionActivity.this.fwd);
                PbSearchEmotionActivity.this.flF.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fHP);
            } else {
                PbSearchEmotionActivity.this.fHP.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aXD();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fmK);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aXG();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aXF();
        }
    };
    private final a fwd = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bb.aU(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fGU);
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
        setContentView(f.h.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.fmR = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fGU = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fmS = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fHQ = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fmP = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fmS)) {
            this.fmK.setText(this.fmS);
            qO(this.fmS);
        }
    }

    private void initView() {
        this.dMY = (LinearLayout) this.mActivity.findViewById(f.g.layout_root);
        this.fHO = (FrameLayout) this.mActivity.findViewById(f.g.layout_content);
        this.fdR = this.mActivity.findViewById(f.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(f.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fmK = (SearchEditView) addCustomView.findViewById(f.g.edit_search_view);
        this.fmK.setCallback(this);
        this.fHN = (TextView) addCustomView.findViewById(f.g.tv_cancel);
        this.fmL = (TextView) this.mActivity.findViewById(f.g.tv_tips);
        this.flF = (BdListView) this.mActivity.findViewById(f.g.listview_emotion);
        this.flF.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fmK.setText("");
        this.fmK.apI();
        ShowSoftKeyPadDelay(this.fmK, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        beQ();
        aXC();
    }

    private void aXC() {
        this.fmN = (AutoLineWrapLayout) this.mActivity.findViewById(f.g.layout_hot_words);
        if (this.fmR == null || this.fmR.isEmpty()) {
            this.fmN.setVisibility(8);
            return;
        }
        this.fmL.setVisibility(0);
        this.fmL.setText(getResources().getString(f.j.hot_emotion));
        int min = Math.min(this.fmR.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fmR.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                am.j(textView, f.d.cp_bg_line_e);
                am.h(textView, f.d.cp_cont_f);
                int f = l.f(this.mActivity, f.e.ds16);
                textView.setPadding(f, f, f, f);
                textView.setText(str2);
                textView.setTextSize(0, l.f(this.mActivity, f.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fmK.setText(str);
                        PbSearchEmotionActivity.this.fmK.setSelection(str.length());
                        PbSearchEmotionActivity.this.qO(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fmN.addView(textView);
            }
        }
    }

    private void beQ() {
        this.fHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qO(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.jE()) {
                showToast(f.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fmS = str;
            this.fmP.a(str, this.mCurrentPage + 1, 40, this.cVo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXF() {
        if (!j.jE()) {
            showToast(f.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fmP.a(this.fmS, this.mCurrentPage + 1, 40, this.cVo);
        }
    }

    private void aXE() {
        this.fmN.setVisibility(0);
        this.fmL.setText(getResources().getString(f.j.hot_emotion));
        this.fmL.setVisibility(0);
        this.flF.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXD() {
        this.flF.setVisibility(0);
        this.fmL.setText(getResources().getString(f.j.click_send_emotion));
        this.fmL.setVisibility(0);
        this.fmN.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXG() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fHO, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.mActivity, f.e.ds320)), NoDataViewFactory.d.dt(f.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fmN.setVisibility(8);
        this.flF.setVisibility(8);
        this.fmL.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.dMY);
        am.i(this.dMY, f.d.cp_bg_line_d);
        am.j(this.fdR, f.d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fmP != null) {
            this.fmP.cancelLoadData();
        }
        if (this.flF != null) {
            this.flF.removeAllViewsInLayout();
            this.flF = null;
        }
        if (this.fHP != null) {
            this.fHP.removeListener();
            this.fHP.aXI();
            this.fHP = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void lD(String str) {
        qO(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void lE(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fHP != null) {
                this.fHP.notifyDataSetChanged();
            }
            aXE();
        }
    }
}
