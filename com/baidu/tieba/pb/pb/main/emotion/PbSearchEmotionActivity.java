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
    private TextView eQa;
    private FrameLayout eQb;
    private b eQc;
    private View eiY;
    private BdListView eoG;
    private LinearLayout eoM;
    private SearchEditView epD;
    private TextView epE;
    private AutoLineWrapLayout epG;
    private SearchEmotionModel epI;
    private List<String> epK;
    private String epL;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private final SearchEmotionModel.a bZC = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.acs() == null || aVar.acs().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aLm();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.acr() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.acs());
            if (PbSearchEmotionActivity.this.eQc == null) {
                PbSearchEmotionActivity.this.eQc = new b(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.eQc.a(PbSearchEmotionActivity.this.eGK);
                PbSearchEmotionActivity.this.eoG.setAdapter((ListAdapter) PbSearchEmotionActivity.this.eQc);
            } else {
                PbSearchEmotionActivity.this.eQc.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aLj();
            k.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.epD);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aLm();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aLl();
        }
    };
    private final a eGK = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                aw.aN(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                c.fJ().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.epK = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
        }
        initView();
        this.epI = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
    }

    private void initView() {
        this.eoM = (LinearLayout) this.mActivity.findViewById(d.h.layout_root);
        this.eQb = (FrameLayout) this.mActivity.findViewById(d.h.layout_content);
        this.eiY = this.mActivity.findViewById(d.h.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.h.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.epD = (SearchEditView) addCustomView.findViewById(d.h.edit_search_view);
        this.epD.setCallback(this);
        this.eQa = (TextView) addCustomView.findViewById(d.h.tv_cancel);
        this.epE = (TextView) this.mActivity.findViewById(d.h.tv_tips);
        this.eoG = (BdListView) this.mActivity.findViewById(d.h.listview_emotion);
        this.eoG.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.epD.setText("");
        this.epD.acw();
        ShowSoftKeyPadDelay(this.epD, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aTQ();
        aLi();
    }

    private void aLi() {
        this.epG = (AutoLineWrapLayout) this.mActivity.findViewById(d.h.layout_hot_words);
        if (this.epK == null || this.epK.isEmpty()) {
            this.epG.setVisibility(8);
            return;
        }
        this.epE.setVisibility(0);
        this.epE.setText(getResources().getString(d.l.hot_emotion));
        int min = Math.min(this.epK.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.epK.get(i);
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
                        PbSearchEmotionActivity.this.epD.setText(str);
                        PbSearchEmotionActivity.this.epD.setSelection(str.length());
                        PbSearchEmotionActivity.this.ok(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.epG.addView(textView);
            }
        }
    }

    private void aTQ() {
        this.eQa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!i.hh()) {
                showToast(d.l.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.epL = str;
            this.epI.a(str, this.mCurrentPage + 1, 40, this.bZC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLl() {
        if (!i.hh()) {
            showToast(d.l.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.epI.a(this.epL, this.mCurrentPage + 1, 40, this.bZC);
        }
    }

    private void aLk() {
        this.epG.setVisibility(0);
        this.epE.setText(getResources().getString(d.l.hot_emotion));
        this.epE.setVisibility(0);
        this.eoG.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLj() {
        this.eoG.setVisibility(0);
        this.epE.setText(getResources().getString(d.l.click_send_emotion));
        this.epE.setVisibility(0);
        this.epG.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLm() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eQb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.g(this.mActivity, d.f.ds320)), NoDataViewFactory.d.di(d.l.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.epG.setVisibility(8);
        this.eoG.setVisibility(8);
        this.epE.setVisibility(8);
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
        getLayoutMode().t(this.eoM);
        ai.j(this.eoM, d.e.cp_bg_line_d);
        ai.k(this.eiY, d.e.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.epI != null) {
            this.epI.cancelLoadData();
        }
        if (this.eoG != null) {
            this.eoG.removeAllViewsInLayout();
            this.eoG = null;
        }
        if (this.eQc != null) {
            this.eQc.removeListener();
            this.eQc.aLq();
            this.eQc = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jx(String str) {
        ok(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jy(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.eQc != null) {
                this.eQc.notifyDataSetChanged();
            }
            aLk();
        }
    }
}
