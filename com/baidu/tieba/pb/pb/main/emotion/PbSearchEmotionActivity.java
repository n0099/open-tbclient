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
/* loaded from: classes2.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private String fQZ;
    private TextView fRR;
    private FrameLayout fRS;
    private d fRT;
    private List<String> fRU;
    private View fns;
    private BdListView fuU;
    private LinearLayout fva;
    private SearchEditView fwb;
    private TextView fwc;
    private AutoLineWrapLayout fwe;
    private SearchEmotionModel fwg;
    private List<String> fwi;
    private String fwj;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private final SearchEmotionModel.a djW = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.apm() == null || aVar.apm().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aWX();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.apl() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.apm());
            if (PbSearchEmotionActivity.this.fRT == null) {
                PbSearchEmotionActivity.this.fRT = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fRT.cX(PbSearchEmotionActivity.this.fRU);
                PbSearchEmotionActivity.this.fRT.a(PbSearchEmotionActivity.this.fGN);
                PbSearchEmotionActivity.this.fuU.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fRT);
            } else {
                PbSearchEmotionActivity.this.fRT.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aWU();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fwb);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aWX();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aWW();
        }
    };
    private final a fGN = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.be(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fQZ);
                com.baidu.adp.lib.f.c.nl().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.fwi = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fQZ = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fwj = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fRU = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fwg = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fwj)) {
            this.fwb.setText(this.fwj);
            pC(this.fwj);
        }
    }

    private void initView() {
        this.fva = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.fRS = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.fns = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fwb = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.fwb.setCallback(this);
        this.fRR = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.fwc = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.fuU = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.fuU.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fwb.setText("");
        this.fwb.apt();
        ShowSoftKeyPadDelay(this.fwb, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bep();
        aWT();
    }

    private void aWT() {
        this.fwe = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.fwi == null || this.fwi.isEmpty()) {
            this.fwe.setVisibility(8);
            return;
        }
        this.fwc.setVisibility(0);
        this.fwc.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.fwi.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fwi.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.t(textView, d.C0108d.cp_bg_line_e);
                aj.r(textView, d.C0108d.cp_cont_f);
                int s = l.s(this.mActivity, d.e.ds16);
                textView.setPadding(s, s, s, s);
                textView.setText(str2);
                textView.setTextSize(0, l.s(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fwb.setText(str);
                        PbSearchEmotionActivity.this.fwb.setSelection(str.length());
                        PbSearchEmotionActivity.this.pC(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fwe.addView(textView);
            }
        }
    }

    private void bep() {
        this.fRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pC(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.oI()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fwj = str;
            this.fwg.a(str, this.mCurrentPage + 1, 40, this.djW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWW() {
        if (!j.oI()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fwg.a(this.fwj, this.mCurrentPage + 1, 40, this.djW);
        }
    }

    private void aWV() {
        this.fwe.setVisibility(0);
        this.fwc.setText(getResources().getString(d.j.hot_emotion));
        this.fwc.setVisibility(0);
        this.fuU.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWU() {
        this.fuU.setVisibility(0);
        this.fwc.setText(getResources().getString(d.j.click_send_emotion));
        this.fwc.setVisibility(0);
        this.fwe.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWX() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fRS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.s(this.mActivity, d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fwe.setVisibility(8);
        this.fuU.setVisibility(8);
        this.fwc.setVisibility(8);
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
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.fva);
        aj.s(this.fva, d.C0108d.cp_bg_line_d);
        aj.t(this.fns, d.C0108d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fwg != null) {
            this.fwg.cancelLoadData();
        }
        if (this.fuU != null) {
            this.fuU.removeAllViewsInLayout();
            this.fuU = null;
        }
        if (this.fRT != null) {
            this.fRT.removeListener();
            this.fRT.aWZ();
            this.fRT = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kx(String str) {
        pC(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void ky(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fRT != null) {
                this.fRT.notifyDataSetChanged();
            }
            aWV();
        }
    }
}
