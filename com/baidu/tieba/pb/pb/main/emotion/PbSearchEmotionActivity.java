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
    private TextView eTi;
    private FrameLayout eTj;
    private b eTk;
    private View emk;
    private BdListView erT;
    private LinearLayout erZ;
    private SearchEditView esQ;
    private TextView esR;
    private AutoLineWrapLayout esT;
    private SearchEmotionModel esV;
    private List<String> esX;
    private String esY;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private final SearchEmotionModel.a cbv = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.acO() == null || aVar.acO().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aLZ();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.acN() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.acO());
            if (PbSearchEmotionActivity.this.eTk == null) {
                PbSearchEmotionActivity.this.eTk = new b(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.eTk.a(PbSearchEmotionActivity.this.eJT);
                PbSearchEmotionActivity.this.erT.setAdapter((ListAdapter) PbSearchEmotionActivity.this.eTk);
            } else {
                PbSearchEmotionActivity.this.eTk.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aLW();
            k.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.esQ);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aLZ();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aLY();
        }
    };
    private final a eJT = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
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
            this.esX = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
        }
        initView();
        this.esV = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
    }

    private void initView() {
        this.erZ = (LinearLayout) this.mActivity.findViewById(d.h.layout_root);
        this.eTj = (FrameLayout) this.mActivity.findViewById(d.h.layout_content);
        this.emk = this.mActivity.findViewById(d.h.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.h.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.esQ = (SearchEditView) addCustomView.findViewById(d.h.edit_search_view);
        this.esQ.setCallback(this);
        this.eTi = (TextView) addCustomView.findViewById(d.h.tv_cancel);
        this.esR = (TextView) this.mActivity.findViewById(d.h.tv_tips);
        this.erT = (BdListView) this.mActivity.findViewById(d.h.listview_emotion);
        this.erT.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.esQ.setText("");
        this.esQ.acS();
        ShowSoftKeyPadDelay(this.esQ, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aUD();
        aLV();
    }

    private void aLV() {
        this.esT = (AutoLineWrapLayout) this.mActivity.findViewById(d.h.layout_hot_words);
        if (this.esX == null || this.esX.isEmpty()) {
            this.esT.setVisibility(8);
            return;
        }
        this.esR.setVisibility(0);
        this.esR.setText(getResources().getString(d.l.hot_emotion));
        int min = Math.min(this.esX.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.esX.get(i);
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
                        PbSearchEmotionActivity.this.esQ.setText(str);
                        PbSearchEmotionActivity.this.esQ.setSelection(str.length());
                        PbSearchEmotionActivity.this.oy(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.esT.addView(textView);
            }
        }
    }

    private void aUD() {
        this.eTi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oy(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!i.hr()) {
                showToast(d.l.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.esY = str;
            this.esV.a(str, this.mCurrentPage + 1, 40, this.cbv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLY() {
        if (!i.hr()) {
            showToast(d.l.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.esV.a(this.esY, this.mCurrentPage + 1, 40, this.cbv);
        }
    }

    private void aLX() {
        this.esT.setVisibility(0);
        this.esR.setText(getResources().getString(d.l.hot_emotion));
        this.esR.setVisibility(0);
        this.erT.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLW() {
        this.erT.setVisibility(0);
        this.esR.setText(getResources().getString(d.l.click_send_emotion));
        this.esR.setVisibility(0);
        this.esT.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLZ() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eTj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.g(this.mActivity, d.f.ds320)), NoDataViewFactory.d.dk(d.l.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.esT.setVisibility(8);
        this.erT.setVisibility(8);
        this.esR.setVisibility(8);
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
        getLayoutMode().t(this.erZ);
        ai.j(this.erZ, d.e.cp_bg_line_d);
        ai.k(this.emk, d.e.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.esV != null) {
            this.esV.cancelLoadData();
        }
        if (this.erT != null) {
            this.erT.removeAllViewsInLayout();
            this.erT = null;
        }
        if (this.eTk != null) {
            this.eTk.removeListener();
            this.eTk.aMd();
            this.eTk = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jG(String str) {
        oy(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jH(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.eTk != null) {
                this.eTk.notifyDataSetChanged();
            }
            aLX();
        }
    }
}
