package com.baidu.tieba.pb.pb.main.emotion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.model.SearchEmotionModel;
import com.baidu.tieba.pb.pb.main.emotion.view.AutoLineWrapLayout;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PbSearchEmotionActivity extends BaseActivity {
    private EditText dLj;
    private View dZU;
    private ImageView eEE;
    private ImageView eEF;
    private TextView eEG;
    private TextView eEH;
    private LinearLayout eEI;
    private FrameLayout eEJ;
    private LinearLayout eEK;
    private AutoLineWrapLayout eEL;
    private BdListView eEM;
    private l eEN;
    private SearchEmotionModel eEO;
    private List<String> eEP;
    private String eEQ;
    private List<EmotionImageData> eER;
    private Activity mActivity;
    private int mCurrentPage;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private y mNoDataView;
    private final SearchEmotionModel.a eES = new b(this);
    private final BdListView.e mOnScrollToBottomListener = new d(this);
    private final a evB = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.eEP = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
        }
        initView();
        this.eEO = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.eER = new ArrayList();
    }

    private void initView() {
        this.eEI = (LinearLayout) this.mActivity.findViewById(w.h.layout_root);
        this.eEJ = (FrameLayout) this.mActivity.findViewById(w.h.layout_content);
        this.dZU = this.mActivity.findViewById(w.h.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(w.h.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.dLj = (EditText) addCustomView.findViewById(w.h.edit_search);
        this.eEE = (ImageView) addCustomView.findViewById(w.h.iv_search);
        this.eEF = (ImageView) addCustomView.findViewById(w.h.iv_del_all);
        this.eEK = (LinearLayout) addCustomView.findViewById(w.h.iv_del_all_layout);
        this.eEG = (TextView) addCustomView.findViewById(w.h.tv_cancel);
        this.eEH = (TextView) this.mActivity.findViewById(w.h.tv_tips);
        this.eEM = (BdListView) this.mActivity.findViewById(w.h.listview_emotion);
        this.eEM.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.dLj.setText("");
        this.dLj.requestFocus();
        ShowSoftKeyPadDelay(this.dLj, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aRg();
        aRf();
    }

    private void aRf() {
        this.eEL = (AutoLineWrapLayout) this.mActivity.findViewById(w.h.layout_hot_words);
        if (this.eEP == null || this.eEP.isEmpty()) {
            this.eEL.setVisibility(8);
            return;
        }
        this.eEH.setVisibility(0);
        this.eEH.setText(getResources().getString(w.l.hot_emotion));
        int min = Math.min(this.eEP.size(), 10);
        for (int i = 0; i < min; i++) {
            String str = this.eEP.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? String.valueOf(str.substring(0, 20)) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                as.k(textView, w.e.cp_bg_line_e);
                as.i(textView, w.e.cp_cont_f);
                int g = com.baidu.adp.lib.util.k.g(this.mActivity, w.f.ds16);
                textView.setPadding(g, g, g, g);
                textView.setText(str2);
                textView.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mActivity, w.f.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new f(this, str));
                this.eEL.addView(textView);
            }
        }
    }

    private void aRg() {
        this.dLj.addTextChangedListener(new g(this));
        this.dLj.setOnEditorActionListener(new h(this));
        this.eEK.setOnClickListener(new i(this));
        this.eEG.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!com.baidu.adp.lib.util.i.hj()) {
                showToast(w.l.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.eEQ = str;
            this.eEO.a(str, this.mCurrentPage + 1, 40, this.eES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRh() {
        if (!com.baidu.adp.lib.util.i.hj()) {
            showToast(w.l.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.eEO.a(this.eEQ, this.mCurrentPage + 1, 40, this.eES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRi() {
        this.eEL.setVisibility(0);
        this.eEH.setText(getResources().getString(w.l.hot_emotion));
        this.eEH.setVisibility(0);
        this.eEM.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRj() {
        this.eEM.setVisibility(0);
        this.eEH.setText(getResources().getString(w.l.click_send_emotion));
        this.eEH.setVisibility(0);
        this.eEL.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRk() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eEJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(this.mActivity, w.f.ds320)), NoDataViewFactory.d.dg(w.l.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eEL.setVisibility(8);
        this.eEM.setVisibility(8);
        this.eEH.setVisibility(8);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(EmotionImageData emotionImageData) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity);
        aVar.cI(getResources().getString(w.l.confirm_send_emotion));
        aVar.a(w.l.confirm, new k(this, emotionImageData));
        aVar.b(w.l.cancel, new c(this));
        aVar.b(getPageContext()).ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EmotionImageData emotionImageData) {
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
        getLayoutMode().t(this.eEI);
        as.j(this.eEI, w.e.cp_bg_line_d);
        as.c(this.eEE, w.g.icon_pb_search);
        as.c(this.eEF, w.g.del_search_btn);
        as.k(this.dZU, w.e.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eEO != null) {
            this.eEO.cancelLoadData();
        }
        if (this.eEM != null) {
            this.eEM.removeAllViewsInLayout();
            this.eEM = null;
        }
        if (this.eEN != null) {
            this.eEN.removeListener();
            this.eEN.aRl();
            this.eEN = null;
        }
    }
}
