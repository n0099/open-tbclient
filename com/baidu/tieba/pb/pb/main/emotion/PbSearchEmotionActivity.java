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
    private int aIx;
    private String jST;
    private TextView jVa;
    private FrameLayout jVb;
    private d jVc;
    private List<String> jVd;
    private View jnN;
    private LinearLayout jvC;
    private BdListView jvw;
    private SearchEditView jwA;
    private TextView jwB;
    private AutoLineWrapLayout jwD;
    private SearchEmotionModel jwF;
    private List<String> jwH;
    private String jwI;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a gZz = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bQS() == null || aVar.bQS().isEmpty()) {
                if (PbSearchEmotionActivity.this.aIx == 0) {
                    PbSearchEmotionActivity.this.cAc();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aIx = aVar.getPage();
            if (PbSearchEmotionActivity.this.aIx == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bQR() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bQS());
            if (PbSearchEmotionActivity.this.jVc == null) {
                PbSearchEmotionActivity.this.jVc = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.jVc.dZ(PbSearchEmotionActivity.this.jVd);
                PbSearchEmotionActivity.this.jVc.a(PbSearchEmotionActivity.this.jVe);
                PbSearchEmotionActivity.this.jvw.setAdapter((ListAdapter) PbSearchEmotionActivity.this.jVc);
            } else {
                PbSearchEmotionActivity.this.jVc.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.czZ();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.jwA);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aIx == 1) {
                PbSearchEmotionActivity.this.cAc();
            }
        }
    };
    private final BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cAb();
        }
    };
    private final a jVe = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.jST);
                com.baidu.adp.lib.e.c.kX().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.jwH = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.jST = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.jwI = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.jVd = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.jwF = new SearchEmotionModel();
        this.aIx = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.jwI)) {
            this.jwA.setText(this.jwI);
            IN(this.jwI);
        }
    }

    private void initView() {
        this.jvC = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.jVb = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.jnN = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.jwA = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.jwA.setCallback(this);
        this.jVa = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.jwB = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.jvw = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.jvw.setOnSrollToBottomListener(this.Uf);
        this.jwA.setText("");
        this.jwA.bQZ();
        ShowSoftKeyPadDelay(this.jwA, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        cIL();
        czY();
    }

    private void czY() {
        this.jwD = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.jwH == null || this.jwH.isEmpty()) {
            this.jwD.setVisibility(8);
            return;
        }
        this.jwB.setVisibility(0);
        this.jwB.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.jwH.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.jwH.get(i);
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
                        PbSearchEmotionActivity.this.jwA.setText(str);
                        PbSearchEmotionActivity.this.jwA.setSelection(str.length());
                        PbSearchEmotionActivity.this.IN(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.jwD.addView(textView);
            }
        }
    }

    private void cIL() {
        this.jVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aIx = 0;
            this.jwI = str;
            this.jwF.a(str, this.aIx + 1, 40, this.gZz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAb() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.jwF.a(this.jwI, this.aIx + 1, 40, this.gZz);
        }
    }

    private void cAa() {
        this.jwD.setVisibility(0);
        this.jwB.setText(getResources().getString(R.string.hot_emotion));
        this.jwB.setVisibility(0);
        this.jvw.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czZ() {
        this.jvw.setVisibility(0);
        this.jwB.setText(getResources().getString(R.string.click_send_emotion));
        this.jwB.setVisibility(0);
        this.jwD.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAc() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.jVb, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.lT(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.jwD.setVisibility(8);
        this.jvw.setVisibility(8);
        this.jwB.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.jvC);
        am.setBackgroundResource(this.jvC, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.jnN, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jwF != null) {
            this.jwF.cancelLoadData();
        }
        if (this.jvw != null) {
            this.jvw.removeAllViewsInLayout();
            this.jvw = null;
        }
        if (this.jVc != null) {
            this.jVc.removeListener();
            this.jVc.cAe();
            this.jVc = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void DR(String str) {
        IN(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void DS(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.jVc != null) {
                this.jVc.notifyDataSetChanged();
            }
            cAa();
        }
    }
}
