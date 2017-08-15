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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aw;
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
    private TextView eTg;
    private FrameLayout eTh;
    private b eTi;
    private View emk;
    private BdListView erR;
    private LinearLayout erX;
    private SearchEditView esO;
    private TextView esP;
    private AutoLineWrapLayout esR;
    private SearchEmotionModel esT;
    private List<String> esV;
    private String esW;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private final SearchEmotionModel.a cbu = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.acS() == null || aVar.acS().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aMe();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.acR() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.acS());
            if (PbSearchEmotionActivity.this.eTi == null) {
                PbSearchEmotionActivity.this.eTi = new b(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.eTi.a(PbSearchEmotionActivity.this.eJR);
                PbSearchEmotionActivity.this.erR.setAdapter((ListAdapter) PbSearchEmotionActivity.this.eTi);
            } else {
                PbSearchEmotionActivity.this.eTi.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aMb();
            k.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.esO);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aMe();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aMd();
        }
    };
    private final a eJR = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                aw.aO(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                c.fU().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.esV = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
        }
        initView();
        this.esT = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
    }

    private void initView() {
        this.erX = (LinearLayout) this.mActivity.findViewById(d.h.layout_root);
        this.eTh = (FrameLayout) this.mActivity.findViewById(d.h.layout_content);
        this.emk = this.mActivity.findViewById(d.h.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.h.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.esO = (SearchEditView) addCustomView.findViewById(d.h.edit_search_view);
        this.esO.setCallback(this);
        this.eTg = (TextView) addCustomView.findViewById(d.h.tv_cancel);
        this.esP = (TextView) this.mActivity.findViewById(d.h.tv_tips);
        this.erR = (BdListView) this.mActivity.findViewById(d.h.listview_emotion);
        this.erR.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.esO.setText("");
        this.esO.acW();
        ShowSoftKeyPadDelay(this.esO, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aUI();
        aMa();
    }

    private void aMa() {
        this.esR = (AutoLineWrapLayout) this.mActivity.findViewById(d.h.layout_hot_words);
        if (this.esV == null || this.esV.isEmpty()) {
            this.esR.setVisibility(8);
            return;
        }
        this.esP.setVisibility(0);
        this.esP.setText(getResources().getString(d.l.hot_emotion));
        int min = Math.min(this.esV.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.esV.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                ai.k(textView, d.e.cp_bg_line_e);
                ai.i(textView, d.e.cp_cont_f);
                int g = k.g(this.mActivity, d.f.ds16);
                textView.setPadding(g, g, g, g);
                textView.setText(str2);
                textView.setTextSize(0, k.g(this.mActivity, d.f.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.esO.setText(str);
                        PbSearchEmotionActivity.this.esO.setSelection(str.length());
                        PbSearchEmotionActivity.this.ot(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.esR.addView(textView);
            }
        }
    }

    private void aUI() {
        this.eTg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!i.hr()) {
                showToast(d.l.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.esW = str;
            this.esT.a(str, this.mCurrentPage + 1, 40, this.cbu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMd() {
        if (!i.hr()) {
            showToast(d.l.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.esT.a(this.esW, this.mCurrentPage + 1, 40, this.cbu);
        }
    }

    private void aMc() {
        this.esR.setVisibility(0);
        this.esP.setText(getResources().getString(d.l.hot_emotion));
        this.esP.setVisibility(0);
        this.erR.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMb() {
        this.erR.setVisibility(0);
        this.esP.setText(getResources().getString(d.l.click_send_emotion));
        this.esP.setVisibility(0);
        this.esR.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMe() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eTh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.g(this.mActivity, d.f.ds320)), NoDataViewFactory.d.dk(d.l.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.esR.setVisibility(8);
        this.erR.setVisibility(8);
        this.esP.setVisibility(8);
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
        getLayoutMode().t(this.erX);
        ai.j(this.erX, d.e.cp_bg_line_d);
        ai.k(this.emk, d.e.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.esT != null) {
            this.esT.cancelLoadData();
        }
        if (this.erR != null) {
            this.erR.removeAllViewsInLayout();
            this.erR = null;
        }
        if (this.eTi != null) {
            this.eTi.removeListener();
            this.eTi.aMi();
            this.eTi = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jD(String str) {
        ot(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jE(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.eTi != null) {
                this.eTi.notifyDataSetChanged();
            }
            aMc();
        }
    }
}
