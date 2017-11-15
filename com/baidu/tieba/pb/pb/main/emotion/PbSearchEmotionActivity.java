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
import com.baidu.tbadk.core.view.f;
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
    private BdListView eBd;
    private LinearLayout eBj;
    private SearchEditView eCj;
    private TextView eCk;
    private AutoLineWrapLayout eCm;
    private SearchEmotionModel eCo;
    private List<String> eCq;
    private String eCr;
    private String eUp;
    private d eVA;
    private List<String> eVB;
    private TextView eVy;
    private FrameLayout eVz;
    private View euw;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private final SearchEmotionModel.a cmz = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.afU() == null || aVar.afU().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aOO();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.afT() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.afU());
            if (PbSearchEmotionActivity.this.eVA == null) {
                PbSearchEmotionActivity.this.eVA = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.eVA.cy(PbSearchEmotionActivity.this.eVB);
                PbSearchEmotionActivity.this.eVA.a(PbSearchEmotionActivity.this.eLw);
                PbSearchEmotionActivity.this.eBd.setAdapter((ListAdapter) PbSearchEmotionActivity.this.eVA);
            } else {
                PbSearchEmotionActivity.this.eVA.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aOL();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.eCj);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aOO();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aON();
        }
    };
    private final a eLw = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aT(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.eUp);
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
            this.eCq = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.eUp = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.eCr = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.eVB = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.eCo = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.eCr)) {
            this.eCj.setText(this.eCr);
            pe(this.eCr);
        }
    }

    private void initView() {
        this.eBj = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.eVz = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.euw = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.eCj = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.eCj.setCallback(this);
        this.eVy = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.eCk = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.eBd = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.eBd.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.eCj.setText("");
        this.eCj.agb();
        ShowSoftKeyPadDelay(this.eCj, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aVy();
        aOK();
    }

    private void aOK() {
        this.eCm = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.eCq == null || this.eCq.isEmpty()) {
            this.eCm.setVisibility(8);
            return;
        }
        this.eCk.setVisibility(0);
        this.eCk.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.eCq.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.eCq.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.k(textView, d.C0080d.cp_bg_line_e);
                aj.i(textView, d.C0080d.cp_cont_f);
                int f = l.f(this.mActivity, d.e.ds16);
                textView.setPadding(f, f, f, f);
                textView.setText(str2);
                textView.setTextSize(0, l.f(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.eCj.setText(str);
                        PbSearchEmotionActivity.this.eCj.setSelection(str.length());
                        PbSearchEmotionActivity.this.pe(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.eCm.addView(textView);
            }
        }
    }

    private void aVy() {
        this.eVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pe(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.hh()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.eCr = str;
            this.eCo.a(str, this.mCurrentPage + 1, 40, this.cmz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aON() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.eCo.a(this.eCr, this.mCurrentPage + 1, 40, this.cmz);
        }
    }

    private void aOM() {
        this.eCm.setVisibility(0);
        this.eCk.setText(getResources().getString(d.j.hot_emotion));
        this.eCk.setVisibility(0);
        this.eBd.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOL() {
        this.eBd.setVisibility(0);
        this.eCk.setText(getResources().getString(d.j.click_send_emotion));
        this.eCk.setVisibility(0);
        this.eCm.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOO() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eVz, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.mActivity, d.e.ds320)), NoDataViewFactory.d.dp(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eCm.setVisibility(8);
        this.eBd.setVisibility(8);
        this.eCk.setVisibility(8);
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
        getLayoutMode().t(this.eBj);
        aj.j(this.eBj, d.C0080d.cp_bg_line_d);
        aj.k(this.euw, d.C0080d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eCo != null) {
            this.eCo.cancelLoadData();
        }
        if (this.eBd != null) {
            this.eBd.removeAllViewsInLayout();
            this.eBd = null;
        }
        if (this.eVA != null) {
            this.eVA.removeListener();
            this.eVA.aOQ();
            this.eVA = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kk(String str) {
        pe(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kl(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.eVA != null) {
                this.eVA.notifyDataSetChanged();
            }
            aOM();
        }
    }
}
