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
import com.baidu.tbadk.core.util.aq;
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
    private EditText dCP;
    private View dRx;
    private String evA;
    private List<EmotionImageData> evB;
    private ImageView evp;
    private ImageView evq;
    private TextView evr;
    private TextView evs;
    private LinearLayout evt;
    private FrameLayout evu;
    private AutoLineWrapLayout evv;
    private BdListView evw;
    private l evx;
    private SearchEmotionModel evy;
    private List<String> evz;
    private Activity mActivity;
    private int mCurrentPage;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private y mNoDataView;
    private final SearchEmotionModel.a evC = new b(this);
    private final BdListView.e mOnScrollToBottomListener = new d(this);
    private final a emx = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.j.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.evz = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
        }
        initView();
        this.evy = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.evB = new ArrayList();
    }

    private void initView() {
        this.evt = (LinearLayout) this.mActivity.findViewById(w.h.layout_root);
        this.evu = (FrameLayout) this.mActivity.findViewById(w.h.layout_content);
        this.dRx = this.mActivity.findViewById(w.h.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(w.h.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, w.j.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.dCP = (EditText) addCustomView.findViewById(w.h.edit_search);
        this.evp = (ImageView) addCustomView.findViewById(w.h.iv_search);
        this.evq = (ImageView) addCustomView.findViewById(w.h.iv_del_all);
        this.evr = (TextView) addCustomView.findViewById(w.h.tv_cancel);
        this.evs = (TextView) this.mActivity.findViewById(w.h.tv_tips);
        this.evw = (BdListView) this.mActivity.findViewById(w.h.listview_emotion);
        this.evw.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.dCP.setText("");
        this.dCP.requestFocus();
        ShowSoftKeyPadDelay(this.dCP, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aNh();
        aNg();
    }

    private void aNg() {
        this.evv = (AutoLineWrapLayout) this.mActivity.findViewById(w.h.layout_hot_words);
        if (this.evz == null || this.evz.isEmpty()) {
            this.evv.setVisibility(8);
            return;
        }
        this.evs.setVisibility(0);
        this.evs.setText(getResources().getString(w.l.hot_emotion));
        int min = Math.min(this.evz.size(), 10);
        for (int i = 0; i < min; i++) {
            String str = this.evz.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? String.valueOf(str.substring(0, 20)) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aq.k(textView, w.e.cp_bg_line_e);
                aq.i(textView, w.e.cp_cont_f);
                int g = com.baidu.adp.lib.util.k.g(this.mActivity, w.f.ds16);
                textView.setPadding(g, g, g, g);
                textView.setText(str2);
                textView.setTextSize(0, com.baidu.adp.lib.util.k.g(this.mActivity, w.f.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new f(this, str));
                this.evv.addView(textView);
            }
        }
    }

    private void aNh() {
        this.dCP.addTextChangedListener(new g(this));
        this.dCP.setOnEditorActionListener(new h(this));
        this.evq.setOnClickListener(new i(this));
        this.evr.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void og(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!com.baidu.adp.lib.util.i.hk()) {
                showToast(w.l.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.evA = str;
            this.evy.a(str, this.mCurrentPage + 1, 40, this.evC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNi() {
        if (!com.baidu.adp.lib.util.i.hk()) {
            showToast(w.l.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.evy.a(this.evA, this.mCurrentPage + 1, 40, this.evC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNj() {
        this.evv.setVisibility(0);
        this.evs.setText(getResources().getString(w.l.hot_emotion));
        this.evs.setVisibility(0);
        this.evw.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNk() {
        this.evw.setVisibility(0);
        this.evs.setText(getResources().getString(w.l.click_send_emotion));
        this.evs.setVisibility(0);
        this.evv.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNl() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.evu, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.adp.lib.util.k.g(this.mActivity, w.f.ds320)), NoDataViewFactory.d.de(w.l.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.evv.setVisibility(8);
        this.evw.setVisibility(8);
        this.evs.setVisibility(8);
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
        aVar.cB(getResources().getString(w.l.confirm_send_emotion));
        aVar.a(w.l.confirm, new k(this, emotionImageData));
        aVar.b(w.l.cancel, new c(this));
        aVar.b(getPageContext()).tc();
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
        getLayoutMode().t(this.evt);
        aq.j(this.evt, w.e.cp_bg_line_d);
        aq.c(this.evp, w.g.icon_pb_search);
        aq.c(this.evq, w.g.del_search_btn);
        aq.k(this.dRx, w.e.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.evy != null) {
            this.evy.cancelLoadData();
        }
        if (this.evw != null) {
            this.evw.removeAllViewsInLayout();
            this.evw = null;
        }
        if (this.evx != null) {
            this.evx.removeListener();
            this.evx.aNm();
            this.evx = null;
        }
    }
}
