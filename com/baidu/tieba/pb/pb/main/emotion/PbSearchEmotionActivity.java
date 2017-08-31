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
    private TextView eRI;
    private FrameLayout eRJ;
    private b eRK;
    private View esW;
    private BdListView eyF;
    private LinearLayout eyL;
    private SearchEditView ezM;
    private TextView ezN;
    private AutoLineWrapLayout ezP;
    private SearchEmotionModel ezR;
    private List<String> ezT;
    private String ezU;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private final SearchEmotionModel.a cem = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.adM() == null || aVar.adM().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aNM();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.adL() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.adM());
            if (PbSearchEmotionActivity.this.eRK == null) {
                PbSearchEmotionActivity.this.eRK = new b(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.eRK.a(PbSearchEmotionActivity.this.eIi);
                PbSearchEmotionActivity.this.eyF.setAdapter((ListAdapter) PbSearchEmotionActivity.this.eRK);
            } else {
                PbSearchEmotionActivity.this.eRK.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aNJ();
            k.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.ezM);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aNM();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aNL();
        }
    };
    private final a eIi = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aT(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
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
            this.ezT = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
        }
        initView();
        this.ezR = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
    }

    private void initView() {
        this.eyL = (LinearLayout) this.mActivity.findViewById(d.h.layout_root);
        this.eRJ = (FrameLayout) this.mActivity.findViewById(d.h.layout_content);
        this.esW = this.mActivity.findViewById(d.h.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.h.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.ezM = (SearchEditView) addCustomView.findViewById(d.h.edit_search_view);
        this.ezM.setCallback(this);
        this.eRI = (TextView) addCustomView.findViewById(d.h.tv_cancel);
        this.ezN = (TextView) this.mActivity.findViewById(d.h.tv_tips);
        this.eyF = (BdListView) this.mActivity.findViewById(d.h.listview_emotion);
        this.eyF.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.ezM.setText("");
        this.ezM.adQ();
        ShowSoftKeyPadDelay(this.ezM, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aTN();
        aNI();
    }

    private void aNI() {
        this.ezP = (AutoLineWrapLayout) this.mActivity.findViewById(d.h.layout_hot_words);
        if (this.ezT == null || this.ezT.isEmpty()) {
            this.ezP.setVisibility(8);
            return;
        }
        this.ezN.setVisibility(0);
        this.ezN.setText(getResources().getString(d.l.hot_emotion));
        int min = Math.min(this.ezT.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.ezT.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.k(textView, d.e.cp_bg_line_e);
                aj.i(textView, d.e.cp_cont_f);
                int g = k.g(this.mActivity, d.f.ds16);
                textView.setPadding(g, g, g, g);
                textView.setText(str2);
                textView.setTextSize(0, k.g(this.mActivity, d.f.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.ezM.setText(str);
                        PbSearchEmotionActivity.this.ezM.setSelection(str.length());
                        PbSearchEmotionActivity.this.oP(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.ezP.addView(textView);
            }
        }
    }

    private void aTN() {
        this.eRI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oP(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!i.hi()) {
                showToast(d.l.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.ezU = str;
            this.ezR.a(str, this.mCurrentPage + 1, 40, this.cem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNL() {
        if (!i.hi()) {
            showToast(d.l.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.ezR.a(this.ezU, this.mCurrentPage + 1, 40, this.cem);
        }
    }

    private void aNK() {
        this.ezP.setVisibility(0);
        this.ezN.setText(getResources().getString(d.l.hot_emotion));
        this.ezN.setVisibility(0);
        this.eyF.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNJ() {
        this.eyF.setVisibility(0);
        this.ezN.setText(getResources().getString(d.l.click_send_emotion));
        this.ezN.setVisibility(0);
        this.ezP.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNM() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eRJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.g(this.mActivity, d.f.ds320)), NoDataViewFactory.d.dl(d.l.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ezP.setVisibility(8);
        this.eyF.setVisibility(8);
        this.ezN.setVisibility(8);
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
        getLayoutMode().t(this.eyL);
        aj.j(this.eyL, d.e.cp_bg_line_d);
        aj.k(this.esW, d.e.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ezR != null) {
            this.ezR.cancelLoadData();
        }
        if (this.eyF != null) {
            this.eyF.removeAllViewsInLayout();
            this.eyF = null;
        }
        if (this.eRK != null) {
            this.eRK.removeListener();
            this.eRK.aNQ();
            this.eRK = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jQ(String str) {
        oP(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jR(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.eRK != null) {
                this.eRK.notifyDataSetChanged();
            }
            aNK();
        }
    }
}
