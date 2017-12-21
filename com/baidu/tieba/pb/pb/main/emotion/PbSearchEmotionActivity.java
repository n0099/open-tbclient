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
    private View eBu;
    private LinearLayout eIE;
    private BdListView eIy;
    private SearchEditView eJF;
    private TextView eJG;
    private AutoLineWrapLayout eJI;
    private SearchEmotionModel eJK;
    private List<String> eJM;
    private String eJN;
    private TextView feY;
    private FrameLayout feZ;
    private String feg;
    private d ffa;
    private List<String> ffb;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private final SearchEmotionModel.a cvA = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.ahM() == null || aVar.ahM().isEmpty()) {
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
            PbSearchEmotionActivity.this.mHasMore = aVar.ahL() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.ahM());
            if (PbSearchEmotionActivity.this.ffa == null) {
                PbSearchEmotionActivity.this.ffa = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.ffa.cM(PbSearchEmotionActivity.this.ffb);
                PbSearchEmotionActivity.this.ffa.a(PbSearchEmotionActivity.this.eUl);
                PbSearchEmotionActivity.this.eIy.setAdapter((ListAdapter) PbSearchEmotionActivity.this.ffa);
            } else {
                PbSearchEmotionActivity.this.ffa.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aPK();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.eJF);
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
    private final a eUl = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aS(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.feg);
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
            this.eJM = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.feg = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.eJN = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.ffb = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.eJK = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.eJN)) {
            this.eJF.setText(this.eJN);
            ps(this.eJN);
        }
    }

    private void initView() {
        this.eIE = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.feZ = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.eBu = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.eJF = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.eJF.setCallback(this);
        this.feY = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.eJG = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.eIy = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.eIy.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.eJF.setText("");
        this.eJF.ahT();
        ShowSoftKeyPadDelay(this.eJF, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aXb();
        aPJ();
    }

    private void aPJ() {
        this.eJI = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.eJM == null || this.eJM.isEmpty()) {
            this.eJI.setVisibility(8);
            return;
        }
        this.eJG.setVisibility(0);
        this.eJG.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.eJM.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.eJM.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.k(textView, d.C0095d.cp_bg_line_e);
                aj.i(textView, d.C0095d.cp_cont_f);
                int f = l.f(this.mActivity, d.e.ds16);
                textView.setPadding(f, f, f, f);
                textView.setText(str2);
                textView.setTextSize(0, l.f(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.eJF.setText(str);
                        PbSearchEmotionActivity.this.eJF.setSelection(str.length());
                        PbSearchEmotionActivity.this.ps(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.eJI.addView(textView);
            }
        }
    }

    private void aXb() {
        this.feY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
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
            this.eJN = str;
            this.eJK.a(str, this.mCurrentPage + 1, 40, this.cvA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPM() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.eJK.a(this.eJN, this.mCurrentPage + 1, 40, this.cvA);
        }
    }

    private void aPL() {
        this.eJI.setVisibility(0);
        this.eJG.setText(getResources().getString(d.j.hot_emotion));
        this.eJG.setVisibility(0);
        this.eIy.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPK() {
        this.eIy.setVisibility(0);
        this.eJG.setText(getResources().getString(d.j.click_send_emotion));
        this.eJG.setVisibility(0);
        this.eJI.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPN() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.feZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.mActivity, d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eJI.setVisibility(8);
        this.eIy.setVisibility(8);
        this.eJG.setVisibility(8);
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
        getLayoutMode().t(this.eIE);
        aj.j(this.eIE, d.C0095d.cp_bg_line_d);
        aj.k(this.eBu, d.C0095d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eJK != null) {
            this.eJK.cancelLoadData();
        }
        if (this.eIy != null) {
            this.eIy.removeAllViewsInLayout();
            this.eIy = null;
        }
        if (this.ffa != null) {
            this.ffa.removeListener();
            this.ffa.aPP();
            this.ffa = null;
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
            if (this.ffa != null) {
                this.ffa.notifyDataSetChanged();
            }
            aPL();
        }
    }
}
