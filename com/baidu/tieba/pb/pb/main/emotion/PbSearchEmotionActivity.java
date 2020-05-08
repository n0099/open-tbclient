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
    private int aCY;
    private View iYK;
    private String jBx;
    private TextView jDB;
    private FrameLayout jDC;
    private d jDD;
    private List<String> jDE;
    private BdListView jgt;
    private LinearLayout jgz;
    private AutoLineWrapLayout jhA;
    private SearchEmotionModel jhC;
    private List<String> jhE;
    private String jhF;
    private SearchEditView jhx;
    private TextView jhy;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a gKN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bKw() == null || aVar.bKw().isEmpty()) {
                if (PbSearchEmotionActivity.this.aCY == 0) {
                    PbSearchEmotionActivity.this.ctz();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aCY = aVar.getPage();
            if (PbSearchEmotionActivity.this.aCY == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bKv() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bKw());
            if (PbSearchEmotionActivity.this.jDD == null) {
                PbSearchEmotionActivity.this.jDD = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.jDD.dT(PbSearchEmotionActivity.this.jDE);
                PbSearchEmotionActivity.this.jDD.a(PbSearchEmotionActivity.this.jDF);
                PbSearchEmotionActivity.this.jgt.setAdapter((ListAdapter) PbSearchEmotionActivity.this.jDD);
            } else {
                PbSearchEmotionActivity.this.jDD.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.ctw();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.jhx);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aCY == 1) {
                PbSearchEmotionActivity.this.ctz();
            }
        }
    };
    private final BdListView.e TT = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cty();
        }
    };
    private final a jDF = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.jBx);
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
            this.jhE = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.jBx = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.jhF = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.jDE = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.jhC = new SearchEmotionModel();
        this.aCY = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.jhF)) {
            this.jhx.setText(this.jhF);
            He(this.jhF);
        }
    }

    private void initView() {
        this.jgz = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.jDC = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.iYK = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.jhx = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.jhx.setCallback(this);
        this.jDB = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.jhy = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.jgt = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.jgt.setOnSrollToBottomListener(this.TT);
        this.jhx.setText("");
        this.jhx.bKD();
        ShowSoftKeyPadDelay(this.jhx, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        cBN();
        ctv();
    }

    private void ctv() {
        this.jhA = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.jhE == null || this.jhE.isEmpty()) {
            this.jhA.setVisibility(8);
            return;
        }
        this.jhy.setVisibility(0);
        this.jhy.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.jhE.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.jhE.get(i);
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
                        PbSearchEmotionActivity.this.jhx.setText(str);
                        PbSearchEmotionActivity.this.jhx.setSelection(str.length());
                        PbSearchEmotionActivity.this.He(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.jhA.addView(textView);
            }
        }
    }

    private void cBN() {
        this.jDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aCY = 0;
            this.jhF = str;
            this.jhC.a(str, this.aCY + 1, 40, this.gKN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cty() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.jhC.a(this.jhF, this.aCY + 1, 40, this.gKN);
        }
    }

    private void ctx() {
        this.jhA.setVisibility(0);
        this.jhy.setText(getResources().getString(R.string.hot_emotion));
        this.jhy.setVisibility(0);
        this.jgt.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctw() {
        this.jgt.setVisibility(0);
        this.jhy.setText(getResources().getString(R.string.click_send_emotion));
        this.jhy.setVisibility(0);
        this.jhA.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctz() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.jDC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.jhA.setVisibility(8);
        this.jgt.setVisibility(8);
        this.jhy.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.jgz);
        am.setBackgroundResource(this.jgz, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.iYK, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jhC != null) {
            this.jhC.cancelLoadData();
        }
        if (this.jgt != null) {
            this.jgt.removeAllViewsInLayout();
            this.jgt = null;
        }
        if (this.jDD != null) {
            this.jDD.removeListener();
            this.jDD.ctB();
            this.jDD = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Ci(String str) {
        He(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Cj(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.jDD != null) {
                this.jDD.notifyDataSetChanged();
            }
            ctx();
        }
    }
}
