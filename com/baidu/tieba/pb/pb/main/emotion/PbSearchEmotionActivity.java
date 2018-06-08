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
    private LinearLayout dGT;
    private String fCN;
    private TextView fDE;
    private FrameLayout fDF;
    private d fDG;
    private List<String> fDH;
    private View faa;
    private BdListView fhB;
    private SearchEditView fiJ;
    private TextView fiK;
    private AutoLineWrapLayout fiM;
    private SearchEmotionModel fiO;
    private List<String> fiQ;
    private String fiR;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a cUD = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.apG() == null || aVar.apG().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aYH();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.apF() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.apG());
            if (PbSearchEmotionActivity.this.fDG == null) {
                PbSearchEmotionActivity.this.fDG = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fDG.cX(PbSearchEmotionActivity.this.fDH);
                PbSearchEmotionActivity.this.fDG.a(PbSearchEmotionActivity.this.fsg);
                PbSearchEmotionActivity.this.fhB.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fDG);
            } else {
                PbSearchEmotionActivity.this.fDG.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aYE();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fiJ);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aYH();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aYG();
        }
    };
    private final a fsg = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ba.aU(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fCN);
                com.baidu.adp.lib.f.c.ig().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
        setContentView(d.i.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.fiQ = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fCN = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fiR = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fDH = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fiO = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fiR)) {
            this.fiJ.setText(this.fiR);
            qS(this.fiR);
        }
    }

    private void initView() {
        this.dGT = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.fDF = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.faa = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fiJ = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.fiJ.setCallback(this);
        this.fDE = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.fiK = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.fhB = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.fhB.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fiJ.setText("");
        this.fiJ.apN();
        ShowSoftKeyPadDelay(this.fiJ, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bfU();
        aYD();
    }

    private void aYD() {
        this.fiM = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.fiQ == null || this.fiQ.isEmpty()) {
            this.fiM.setVisibility(8);
            return;
        }
        this.fiK.setVisibility(0);
        this.fiK.setText(getResources().getString(d.k.hot_emotion));
        int min = Math.min(this.fiQ.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fiQ.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                al.j(textView, d.C0141d.cp_bg_line_e);
                al.h(textView, d.C0141d.cp_cont_f);
                int e = l.e(this.mActivity, d.e.ds16);
                textView.setPadding(e, e, e, e);
                textView.setText(str2);
                textView.setTextSize(0, l.e(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fiJ.setText(str);
                        PbSearchEmotionActivity.this.fiJ.setSelection(str.length());
                        PbSearchEmotionActivity.this.qS(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fiM.addView(textView);
            }
        }
    }

    private void bfU() {
        this.fDE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qS(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.jD()) {
                showToast(d.k.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fiR = str;
            this.fiO.a(str, this.mCurrentPage + 1, 40, this.cUD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYG() {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fiO.a(this.fiR, this.mCurrentPage + 1, 40, this.cUD);
        }
    }

    private void aYF() {
        this.fiM.setVisibility(0);
        this.fiK.setText(getResources().getString(d.k.hot_emotion));
        this.fiK.setVisibility(0);
        this.fhB.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYE() {
        this.fhB.setVisibility(0);
        this.fiK.setText(getResources().getString(d.k.click_send_emotion));
        this.fiK.setVisibility(0);
        this.fiM.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYH() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fDF, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.mActivity, d.e.ds320)), NoDataViewFactory.d.dr(d.k.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fiM.setVisibility(8);
        this.fhB.setVisibility(8);
        this.fiK.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.dGT);
        al.i(this.dGT, d.C0141d.cp_bg_line_d);
        al.j(this.faa, d.C0141d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fiO != null) {
            this.fiO.cancelLoadData();
        }
        if (this.fhB != null) {
            this.fhB.removeAllViewsInLayout();
            this.fhB = null;
        }
        if (this.fDG != null) {
            this.fDG.removeListener();
            this.fDG.aYJ();
            this.fDG = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void lG(String str) {
        qS(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void lH(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fDG != null) {
                this.fDG.notifyDataSetChanged();
            }
            aYF();
        }
    }
}
