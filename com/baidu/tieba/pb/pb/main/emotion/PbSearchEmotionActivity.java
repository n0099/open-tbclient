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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private LinearLayout enE;
    private View fEP;
    private BdListView fMG;
    private SearchEditView fNK;
    private TextView fNL;
    private AutoLineWrapLayout fNN;
    private SearchEmotionModel fNP;
    private List<String> fNR;
    private String fNS;
    private String gii;
    private TextView gjg;
    private FrameLayout gjh;
    private d gji;
    private List<String> gjj;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a duv = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.axh() == null || aVar.axh().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.bfG();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.axg() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.axh());
            if (PbSearchEmotionActivity.this.gji == null) {
                PbSearchEmotionActivity.this.gji = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.gji.dq(PbSearchEmotionActivity.this.gjj);
                PbSearchEmotionActivity.this.gji.a(PbSearchEmotionActivity.this.fXB);
                PbSearchEmotionActivity.this.fMG.setAdapter((ListAdapter) PbSearchEmotionActivity.this.gji);
            } else {
                PbSearchEmotionActivity.this.gji.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bfD();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fNK);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bfG();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bfF();
        }
    };
    private final a fXB = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bJ(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.gii);
                com.baidu.adp.lib.f.c.jA().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
        setContentView(e.h.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.fNR = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.gii = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fNS = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.gjj = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fNP = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fNS)) {
            this.fNK.setText(this.fNS);
            sQ(this.fNS);
        }
    }

    private void initView() {
        this.enE = (LinearLayout) this.mActivity.findViewById(e.g.layout_root);
        this.gjh = (FrameLayout) this.mActivity.findViewById(e.g.layout_content);
        this.fEP = this.mActivity.findViewById(e.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(e.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fNK = (SearchEditView) addCustomView.findViewById(e.g.edit_search_view);
        this.fNK.setCallback(this);
        this.gjg = (TextView) addCustomView.findViewById(e.g.tv_cancel);
        this.fNL = (TextView) this.mActivity.findViewById(e.g.tv_tips);
        this.fMG = (BdListView) this.mActivity.findViewById(e.g.listview_emotion);
        this.fMG.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fNK.setText("");
        this.fNK.axo();
        ShowSoftKeyPadDelay(this.fNK, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bnp();
        bfC();
    }

    private void bfC() {
        this.fNN = (AutoLineWrapLayout) this.mActivity.findViewById(e.g.layout_hot_words);
        if (this.fNR == null || this.fNR.isEmpty()) {
            this.fNN.setVisibility(8);
            return;
        }
        this.fNL.setVisibility(0);
        this.fNL.setText(getResources().getString(e.j.hot_emotion));
        int min = Math.min(this.fNR.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fNR.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                al.j(textView, e.d.cp_bg_line_e);
                al.h(textView, e.d.cp_cont_f);
                int h = l.h(this.mActivity, e.C0210e.ds16);
                textView.setPadding(h, h, h, h);
                textView.setText(str2);
                textView.setTextSize(0, l.h(this.mActivity, e.C0210e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fNK.setText(str);
                        PbSearchEmotionActivity.this.fNK.setSelection(str.length());
                        PbSearchEmotionActivity.this.sQ(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fNN.addView(textView);
            }
        }
    }

    private void bnp() {
        this.gjg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.kV()) {
                showToast(e.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fNS = str;
            this.fNP.a(str, this.mCurrentPage + 1, 40, this.duv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfF() {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fNP.a(this.fNS, this.mCurrentPage + 1, 40, this.duv);
        }
    }

    private void bfE() {
        this.fNN.setVisibility(0);
        this.fNL.setText(getResources().getString(e.j.hot_emotion));
        this.fNL.setVisibility(0);
        this.fMG.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfD() {
        this.fMG.setVisibility(0);
        this.fNL.setText(getResources().getString(e.j.click_send_emotion));
        this.fNL.setVisibility(0);
        this.fNN.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfG() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.gjh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.mActivity, e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fNN.setVisibility(8);
        this.fMG.setVisibility(8);
        this.fNL.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.enE);
        al.i(this.enE, e.d.cp_bg_line_d);
        al.j(this.fEP, e.d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fNP != null) {
            this.fNP.cancelLoadData();
        }
        if (this.fMG != null) {
            this.fMG.removeAllViewsInLayout();
            this.fMG = null;
        }
        if (this.gji != null) {
            this.gji.removeListener();
            this.gji.bfI();
            this.gji = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void nA(String str) {
        sQ(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void nB(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.gji != null) {
                this.gji.notifyDataSetChanged();
            }
            bfE();
        }
    }
}
