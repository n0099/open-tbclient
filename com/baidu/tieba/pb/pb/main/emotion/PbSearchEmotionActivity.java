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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aCS;
    private View iYG;
    private String jBt;
    private List<String> jDA;
    private TextView jDx;
    private FrameLayout jDy;
    private d jDz;
    private BdListView jgp;
    private LinearLayout jgv;
    private List<String> jhA;
    private String jhB;
    private SearchEditView jht;
    private TextView jhu;
    private AutoLineWrapLayout jhw;
    private SearchEmotionModel jhy;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a gKH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bKy() == null || aVar.bKy().isEmpty()) {
                if (PbSearchEmotionActivity.this.aCS == 0) {
                    PbSearchEmotionActivity.this.ctC();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aCS = aVar.getPage();
            if (PbSearchEmotionActivity.this.aCS == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bKx() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bKy());
            if (PbSearchEmotionActivity.this.jDz == null) {
                PbSearchEmotionActivity.this.jDz = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.jDz.dT(PbSearchEmotionActivity.this.jDA);
                PbSearchEmotionActivity.this.jDz.a(PbSearchEmotionActivity.this.jDB);
                PbSearchEmotionActivity.this.jgp.setAdapter((ListAdapter) PbSearchEmotionActivity.this.jDz);
            } else {
                PbSearchEmotionActivity.this.jDz.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.ctz();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.jht);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aCS == 1) {
                PbSearchEmotionActivity.this.ctC();
            }
        }
    };
    private final BdListView.e TQ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.ctB();
        }
    };
    private final a jDB = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.jBt);
                com.baidu.adp.lib.e.c.kV().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbSearchEmotionActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_EMOTION_EDIT, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbSearchEmotionActivity.this.getUniqueId());
            } else {
                PbSearchEmotionActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_EMOTION_EDIT, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_SEARCH)));
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.jhA = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.jBt = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.jhB = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.jDA = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.jhy = new SearchEmotionModel();
        this.aCS = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.jhB)) {
            this.jht.setText(this.jhB);
            Hb(this.jhB);
        }
    }

    private void initView() {
        this.jgv = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.jDy = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.iYG = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.jht = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.jht.setCallback(this);
        this.jDx = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.jhu = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.jgp = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.jgp.setOnSrollToBottomListener(this.TQ);
        this.jht.setText("");
        this.jht.bKF();
        ShowSoftKeyPadDelay(this.jht, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        cBQ();
        cty();
    }

    private void cty() {
        this.jhw = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.jhA == null || this.jhA.isEmpty()) {
            this.jhw.setVisibility(8);
            return;
        }
        this.jhu.setVisibility(0);
        this.jhu.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.jhA.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.jhA.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                am.setBackgroundColor(textView, R.color.cp_bg_line_e);
                am.setViewTextColor(textView, (int) R.color.cp_cont_f);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.jht.setText(str);
                        PbSearchEmotionActivity.this.jht.setSelection(str.length());
                        PbSearchEmotionActivity.this.Hb(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.jhw.addView(textView);
            }
        }
    }

    private void cBQ() {
        this.jDx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hb(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aCS = 0;
            this.jhB = str;
            this.jhy.a(str, this.aCS + 1, 40, this.gKH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctB() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.jhy.a(this.jhB, this.aCS + 1, 40, this.gKH);
        }
    }

    private void ctA() {
        this.jhw.setVisibility(0);
        this.jhu.setText(getResources().getString(R.string.hot_emotion));
        this.jhu.setVisibility(0);
        this.jgp.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctz() {
        this.jgp.setVisibility(0);
        this.jhu.setText(getResources().getString(R.string.click_send_emotion));
        this.jhu.setVisibility(0);
        this.jhw.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctC() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.jDy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.jhw.setVisibility(8);
        this.jgp.setVisibility(8);
        this.jhu.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.jgv);
        am.setBackgroundResource(this.jgv, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.iYG, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jhy != null) {
            this.jhy.cancelLoadData();
        }
        if (this.jgp != null) {
            this.jgp.removeAllViewsInLayout();
            this.jgp = null;
        }
        if (this.jDz != null) {
            this.jDz.removeListener();
            this.jDz.ctE();
            this.jDz = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Cf(String str) {
        Hb(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Cg(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.jDz != null) {
                this.jDz.notifyDataSetChanged();
            }
            ctA();
        }
    }
}
