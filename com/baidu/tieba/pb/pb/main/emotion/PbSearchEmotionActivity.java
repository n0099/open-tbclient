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
    private String jTZ;
    private TextView jWg;
    private FrameLayout jWh;
    private d jWi;
    private List<String> jWj;
    private View joT;
    private BdListView jwC;
    private LinearLayout jwI;
    private SearchEditView jxG;
    private TextView jxH;
    private AutoLineWrapLayout jxJ;
    private SearchEmotionModel jxL;
    private List<String> jxN;
    private String jxO;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a gZK = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bQU() == null || aVar.bQU().isEmpty()) {
                if (PbSearchEmotionActivity.this.aIx == 0) {
                    PbSearchEmotionActivity.this.cAt();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aIx = aVar.getPage();
            if (PbSearchEmotionActivity.this.aIx == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bQT() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bQU());
            if (PbSearchEmotionActivity.this.jWi == null) {
                PbSearchEmotionActivity.this.jWi = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.jWi.eb(PbSearchEmotionActivity.this.jWj);
                PbSearchEmotionActivity.this.jWi.a(PbSearchEmotionActivity.this.jWk);
                PbSearchEmotionActivity.this.jwC.setAdapter((ListAdapter) PbSearchEmotionActivity.this.jWi);
            } else {
                PbSearchEmotionActivity.this.jWi.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.cAq();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.jxG);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aIx == 1) {
                PbSearchEmotionActivity.this.cAt();
            }
        }
    };
    private final BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cAs();
        }
    };
    private final a jWk = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.jTZ);
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
            this.jxN = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.jTZ = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.jxO = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.jWj = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.jxL = new SearchEmotionModel();
        this.aIx = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.jxO)) {
            this.jxG.setText(this.jxO);
            IO(this.jxO);
        }
    }

    private void initView() {
        this.jwI = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.jWh = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.joT = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.jxG = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.jxG.setCallback(this);
        this.jWg = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.jxH = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.jwC = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.jwC.setOnSrollToBottomListener(this.Uf);
        this.jxG.setText("");
        this.jxG.bRb();
        ShowSoftKeyPadDelay(this.jxG, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        cJb();
        cAp();
    }

    private void cAp() {
        this.jxJ = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.jxN == null || this.jxN.isEmpty()) {
            this.jxJ.setVisibility(8);
            return;
        }
        this.jxH.setVisibility(0);
        this.jxH.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.jxN.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.jxN.get(i);
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
                        PbSearchEmotionActivity.this.jxG.setText(str);
                        PbSearchEmotionActivity.this.jxG.setSelection(str.length());
                        PbSearchEmotionActivity.this.IO(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.jxJ.addView(textView);
            }
        }
    }

    private void cJb() {
        this.jWg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IO(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aIx = 0;
            this.jxO = str;
            this.jxL.a(str, this.aIx + 1, 40, this.gZK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAs() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.jxL.a(this.jxO, this.aIx + 1, 40, this.gZK);
        }
    }

    private void cAr() {
        this.jxJ.setVisibility(0);
        this.jxH.setText(getResources().getString(R.string.hot_emotion));
        this.jxH.setVisibility(0);
        this.jwC.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAq() {
        this.jwC.setVisibility(0);
        this.jxH.setText(getResources().getString(R.string.click_send_emotion));
        this.jxH.setVisibility(0);
        this.jxJ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAt() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.jWh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.lV(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.jxJ.setVisibility(8);
        this.jwC.setVisibility(8);
        this.jxH.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.jwI);
        am.setBackgroundResource(this.jwI, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.joT, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jxL != null) {
            this.jxL.cancelLoadData();
        }
        if (this.jwC != null) {
            this.jwC.removeAllViewsInLayout();
            this.jwC = null;
        }
        if (this.jWi != null) {
            this.jWi.removeListener();
            this.jWi.cAv();
            this.jWi = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void DR(String str) {
        IO(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void DS(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.jWi != null) {
                this.jWi.notifyDataSetChanged();
            }
            cAr();
        }
    }
}
