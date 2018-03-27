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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ay;
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
    private BdListView fAt;
    private LinearLayout fAz;
    private SearchEditView fBA;
    private TextView fBB;
    private AutoLineWrapLayout fBD;
    private SearchEmotionModel fBF;
    private List<String> fBH;
    private String fBI;
    private String fWl;
    private TextView fXd;
    private FrameLayout fXe;
    private d fXf;
    private List<String> fXg;
    private View fsU;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private final SearchEmotionModel.a drC = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.ark() == null || aVar.ark().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aYQ();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.arj() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.ark());
            if (PbSearchEmotionActivity.this.fXf == null) {
                PbSearchEmotionActivity.this.fXf = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.fXf.cX(PbSearchEmotionActivity.this.fXg);
                PbSearchEmotionActivity.this.fXf.a(PbSearchEmotionActivity.this.fLX);
                PbSearchEmotionActivity.this.fAt.setAdapter((ListAdapter) PbSearchEmotionActivity.this.fXf);
            } else {
                PbSearchEmotionActivity.this.fXf.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aYN();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.fBA);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aYQ();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aYP();
        }
    };
    private final a fLX = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ay.ba(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.fWl);
                com.baidu.adp.lib.f.c.nm().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
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
        setContentView(d.h.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.fBH = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.fWl = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.fBI = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.fXg = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.fBF = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.fBI)) {
            this.fBA.setText(this.fBI);
            pV(this.fBI);
        }
    }

    private void initView() {
        this.fAz = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.fXe = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.fsU = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.fBA = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.fBA.setCallback(this);
        this.fXd = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.fBB = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.fAt = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.fAt.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fBA.setText("");
        this.fBA.arr();
        ShowSoftKeyPadDelay(this.fBA, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bfY();
        aYM();
    }

    private void aYM() {
        this.fBD = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.fBH == null || this.fBH.isEmpty()) {
            this.fBD.setVisibility(8);
            return;
        }
        this.fBB.setVisibility(0);
        this.fBB.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.fBH.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.fBH.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.t(textView, d.C0141d.cp_bg_line_e);
                aj.r(textView, d.C0141d.cp_cont_f);
                int t = l.t(this.mActivity, d.e.ds16);
                textView.setPadding(t, t, t, t);
                textView.setText(str2);
                textView.setTextSize(0, l.t(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.fBA.setText(str);
                        PbSearchEmotionActivity.this.fBA.setSelection(str.length());
                        PbSearchEmotionActivity.this.pV(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.fBD.addView(textView);
            }
        }
    }

    private void bfY() {
        this.fXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.oJ()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.fBI = str;
            this.fBF.a(str, this.mCurrentPage + 1, 40, this.drC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYP() {
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.fBF.a(this.fBI, this.mCurrentPage + 1, 40, this.drC);
        }
    }

    private void aYO() {
        this.fBD.setVisibility(0);
        this.fBB.setText(getResources().getString(d.j.hot_emotion));
        this.fBB.setVisibility(0);
        this.fAt.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYN() {
        this.fAt.setVisibility(0);
        this.fBB.setText(getResources().getString(d.j.click_send_emotion));
        this.fBB.setVisibility(0);
        this.fBD.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYQ() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.fXe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.mActivity, d.e.ds320)), NoDataViewFactory.d.gp(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.fBD.setVisibility(8);
        this.fAt.setVisibility(8);
        this.fBB.setVisibility(8);
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
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.fAz);
        aj.s(this.fAz, d.C0141d.cp_bg_line_d);
        aj.t(this.fsU, d.C0141d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fBF != null) {
            this.fBF.cancelLoadData();
        }
        if (this.fAt != null) {
            this.fAt.removeAllViewsInLayout();
            this.fAt = null;
        }
        if (this.fXf != null) {
            this.fXf.removeListener();
            this.fXf.aYS();
            this.fXf = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kU(String str) {
        pV(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kV(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.fXf != null) {
                this.fXf.notifyDataSetChanged();
            }
            aYO();
        }
    }
}
