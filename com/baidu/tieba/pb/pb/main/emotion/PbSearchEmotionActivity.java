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
    private LinearLayout enF;
    private View fEQ;
    private BdListView fMH;
    private SearchEditView fNL;
    private TextView fNM;
    private AutoLineWrapLayout fNO;
    private SearchEmotionModel fNQ;
    private List<String> fNS;
    private String fNT;
    private String gij;
    private TextView gjh;
    private FrameLayout gji;
    private d gjj;
    private List<String> gjk;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a duw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
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
            if (PbSearchEmotionActivity.this.gjj == null) {
                PbSearchEmotionActivity.this.gjj = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.gjj.dq(PbSearchEmotionActivity.this.gjk);
                PbSearchEmotionActivity.this.gjj.a(PbSearchEmotionActivity.this.fXC);
                PbSearchEmotionActivity.this.fMH.setAdapter((ListAdapter) PbSearchEmotionActivity.this.gjj);
            } else {
                PbSearchEmotionActivity.this.gjj.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bfD();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fNL);
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
    private final a fXC = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.bJ(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.gij);
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
            this.fNS = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.gij = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fNT = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.gjk = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fNQ = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fNT)) {
            this.fNL.setText(this.fNT);
            sQ(this.fNT);
        }
    }

    private void initView() {
        this.enF = (LinearLayout) this.mActivity.findViewById(e.g.layout_root);
        this.gji = (FrameLayout) this.mActivity.findViewById(e.g.layout_content);
        this.fEQ = this.mActivity.findViewById(e.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(e.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fNL = (SearchEditView) addCustomView.findViewById(e.g.edit_search_view);
        this.fNL.setCallback(this);
        this.gjh = (TextView) addCustomView.findViewById(e.g.tv_cancel);
        this.fNM = (TextView) this.mActivity.findViewById(e.g.tv_tips);
        this.fMH = (BdListView) this.mActivity.findViewById(e.g.listview_emotion);
        this.fMH.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fNL.setText("");
        this.fNL.axo();
        ShowSoftKeyPadDelay(this.fNL, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bnp();
        bfC();
    }

    private void bfC() {
        this.fNO = (AutoLineWrapLayout) this.mActivity.findViewById(e.g.layout_hot_words);
        if (this.fNS == null || this.fNS.isEmpty()) {
            this.fNO.setVisibility(8);
            return;
        }
        this.fNM.setVisibility(0);
        this.fNM.setText(getResources().getString(e.j.hot_emotion));
        int min = Math.min(this.fNS.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fNS.get(i);
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
                        PbSearchEmotionActivity.this.fNL.setText(str);
                        PbSearchEmotionActivity.this.fNL.setSelection(str.length());
                        PbSearchEmotionActivity.this.sQ(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fNO.addView(textView);
            }
        }
    }

    private void bnp() {
        this.gjh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
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
            this.fNT = str;
            this.fNQ.a(str, this.mCurrentPage + 1, 40, this.duw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfF() {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fNQ.a(this.fNT, this.mCurrentPage + 1, 40, this.duw);
        }
    }

    private void bfE() {
        this.fNO.setVisibility(0);
        this.fNM.setText(getResources().getString(e.j.hot_emotion));
        this.fNM.setVisibility(0);
        this.fMH.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfD() {
        this.fMH.setVisibility(0);
        this.fNM.setText(getResources().getString(e.j.click_send_emotion));
        this.fNM.setVisibility(0);
        this.fNO.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfG() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.gji, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.mActivity, e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fNO.setVisibility(8);
        this.fMH.setVisibility(8);
        this.fNM.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.enF);
        al.i(this.enF, e.d.cp_bg_line_d);
        al.j(this.fEQ, e.d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fNQ != null) {
            this.fNQ.cancelLoadData();
        }
        if (this.fMH != null) {
            this.fMH.removeAllViewsInLayout();
            this.fMH = null;
        }
        if (this.gjj != null) {
            this.gjj.removeListener();
            this.gjj.bfI();
            this.gjj = null;
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
            if (this.gjj != null) {
                this.gjj.notifyDataSetChanged();
            }
            bfE();
        }
    }
}
