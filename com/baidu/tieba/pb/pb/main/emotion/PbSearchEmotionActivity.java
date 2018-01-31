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
import com.baidu.tbadk.core.view.h;
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
    private String fSU;
    private TextView fTM;
    private FrameLayout fTN;
    private d fTO;
    private List<String> fTP;
    private View fpo;
    private BdListView fwP;
    private LinearLayout fwV;
    private SearchEditView fxW;
    private TextView fxX;
    private AutoLineWrapLayout fxZ;
    private SearchEmotionModel fyb;
    private List<String> fyd;
    private String fye;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private final SearchEmotionModel.a doS = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.aqu() == null || aVar.aqu().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aXh();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.aqt() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.aqu());
            if (PbSearchEmotionActivity.this.fTO == null) {
                PbSearchEmotionActivity.this.fTO = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fTO.cR(PbSearchEmotionActivity.this.fTP);
                PbSearchEmotionActivity.this.fTO.a(PbSearchEmotionActivity.this.fII);
                PbSearchEmotionActivity.this.fwP.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fTO);
            } else {
                PbSearchEmotionActivity.this.fTO.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aXe();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fxW);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aXh();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aXg();
        }
    };
    private final a fII = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.bb(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fSU);
                com.baidu.adp.lib.f.c.nm().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.fyd = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fSU = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fye = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fTP = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fyb = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fye)) {
            this.fxW.setText(this.fye);
            pM(this.fye);
        }
    }

    private void initView() {
        this.fwV = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.fTN = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.fpo = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fxW = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.fxW.setCallback(this);
        this.fTM = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.fxX = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.fwP = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.fwP.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fxW.setText("");
        this.fxW.aqB();
        ShowSoftKeyPadDelay(this.fxW, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bey();
        aXd();
    }

    private void aXd() {
        this.fxZ = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.fyd == null || this.fyd.isEmpty()) {
            this.fxZ.setVisibility(8);
            return;
        }
        this.fxX.setVisibility(0);
        this.fxX.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.fyd.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fyd.get(i);
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
                        PbSearchEmotionActivity.this.fxW.setText(str);
                        PbSearchEmotionActivity.this.fxW.setSelection(str.length());
                        PbSearchEmotionActivity.this.pM(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fxZ.addView(textView);
            }
        }
    }

    private void bey() {
        this.fTM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pM(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.oJ()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fye = str;
            this.fyb.a(str, this.mCurrentPage + 1, 40, this.doS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXg() {
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fyb.a(this.fye, this.mCurrentPage + 1, 40, this.doS);
        }
    }

    private void aXf() {
        this.fxZ.setVisibility(0);
        this.fxX.setText(getResources().getString(d.j.hot_emotion));
        this.fxX.setVisibility(0);
        this.fwP.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXe() {
        this.fwP.setVisibility(0);
        this.fxX.setText(getResources().getString(d.j.click_send_emotion));
        this.fxX.setVisibility(0);
        this.fxZ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXh() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fTN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.s(this.mActivity, d.e.ds320)), NoDataViewFactory.d.gn(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fxZ.setVisibility(8);
        this.fwP.setVisibility(8);
        this.fxX.setVisibility(8);
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
        getLayoutMode().aN(i == 1);
        getLayoutMode().aM(this.fwV);
        aj.s(this.fwV, d.C0108d.cp_bg_line_d);
        aj.t(this.fpo, d.C0108d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fyb != null) {
            this.fyb.cancelLoadData();
        }
        if (this.fwP != null) {
            this.fwP.removeAllViewsInLayout();
            this.fwP = null;
        }
        if (this.fTO != null) {
            this.fTO.removeListener();
            this.fTO.aXj();
            this.fTO = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kM(String str) {
        pM(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kN(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fTO != null) {
                this.fTO.notifyDataSetChanged();
            }
            aXf();
        }
    }
}
