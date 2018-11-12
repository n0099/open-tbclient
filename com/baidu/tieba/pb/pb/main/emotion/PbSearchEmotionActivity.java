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
    private LinearLayout edE;
    private BdListView fCe;
    private SearchEditView fDi;
    private TextView fDj;
    private AutoLineWrapLayout fDl;
    private SearchEmotionModel fDn;
    private List<String> fDp;
    private String fDq;
    private String fXv;
    private TextView fYt;
    private FrameLayout fYu;
    private d fYv;
    private List<String> fYw;
    private View fun;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a dkw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.auk() == null || aVar.auk().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.bcE();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.auj() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.auk());
            if (PbSearchEmotionActivity.this.fYv == null) {
                PbSearchEmotionActivity.this.fYv = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fYv.dk(PbSearchEmotionActivity.this.fYw);
                PbSearchEmotionActivity.this.fYv.a(PbSearchEmotionActivity.this.fMW);
                PbSearchEmotionActivity.this.fCe.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fYv);
            } else {
                PbSearchEmotionActivity.this.fYv.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bcB();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fDi);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bcE();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bcD();
        }
    };
    private final a fMW = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bG(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fXv);
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
            this.fDp = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fXv = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fDq = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fYw = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fDn = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fDq)) {
            this.fDi.setText(this.fDq);
            rU(this.fDq);
        }
    }

    private void initView() {
        this.edE = (LinearLayout) this.mActivity.findViewById(e.g.layout_root);
        this.fYu = (FrameLayout) this.mActivity.findViewById(e.g.layout_content);
        this.fun = this.mActivity.findViewById(e.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(e.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fDi = (SearchEditView) addCustomView.findViewById(e.g.edit_search_view);
        this.fDi.setCallback(this);
        this.fYt = (TextView) addCustomView.findViewById(e.g.tv_cancel);
        this.fDj = (TextView) this.mActivity.findViewById(e.g.tv_tips);
        this.fCe = (BdListView) this.mActivity.findViewById(e.g.listview_emotion);
        this.fCe.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fDi.setText("");
        this.fDi.aur();
        ShowSoftKeyPadDelay(this.fDi, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bkd();
        bcA();
    }

    private void bcA() {
        this.fDl = (AutoLineWrapLayout) this.mActivity.findViewById(e.g.layout_hot_words);
        if (this.fDp == null || this.fDp.isEmpty()) {
            this.fDl.setVisibility(8);
            return;
        }
        this.fDj.setVisibility(0);
        this.fDj.setText(getResources().getString(e.j.hot_emotion));
        int min = Math.min(this.fDp.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fDp.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                al.j(textView, e.d.cp_bg_line_e);
                al.h(textView, e.d.cp_cont_f);
                int h = l.h(this.mActivity, e.C0200e.ds16);
                textView.setPadding(h, h, h, h);
                textView.setText(str2);
                textView.setTextSize(0, l.h(this.mActivity, e.C0200e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fDi.setText(str);
                        PbSearchEmotionActivity.this.fDi.setSelection(str.length());
                        PbSearchEmotionActivity.this.rU(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fDl.addView(textView);
            }
        }
    }

    private void bkd() {
        this.fYt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.kV()) {
                showToast(e.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fDq = str;
            this.fDn.a(str, this.mCurrentPage + 1, 40, this.dkw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcD() {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fDn.a(this.fDq, this.mCurrentPage + 1, 40, this.dkw);
        }
    }

    private void bcC() {
        this.fDl.setVisibility(0);
        this.fDj.setText(getResources().getString(e.j.hot_emotion));
        this.fDj.setVisibility(0);
        this.fCe.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcB() {
        this.fCe.setVisibility(0);
        this.fDj.setText(getResources().getString(e.j.click_send_emotion));
        this.fDj.setVisibility(0);
        this.fDl.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcE() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fYu, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.mActivity, e.C0200e.ds320)), NoDataViewFactory.d.ec(e.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fDl.setVisibility(8);
        this.fCe.setVisibility(8);
        this.fDj.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.edE);
        al.i(this.edE, e.d.cp_bg_line_d);
        al.j(this.fun, e.d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fDn != null) {
            this.fDn.cancelLoadData();
        }
        if (this.fCe != null) {
            this.fCe.removeAllViewsInLayout();
            this.fCe = null;
        }
        if (this.fYv != null) {
            this.fYv.removeListener();
            this.fYv.bcG();
            this.fYv = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void mI(String str) {
        rU(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void mJ(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fYv != null) {
                this.fYv.notifyDataSetChanged();
            }
            bcC();
        }
    }
}
