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
/* loaded from: classes7.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aic;
    private String iOa;
    private TextView iQe;
    private FrameLayout iQf;
    private d iQg;
    private List<String> iQh;
    private View ikQ;
    private BdListView isB;
    private LinearLayout isH;
    private SearchEditView itE;
    private TextView itF;
    private AutoLineWrapLayout itH;
    private SearchEmotionModel itJ;
    private List<String> itL;
    private String itM;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a fYB = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bym() == null || aVar.bym().isEmpty()) {
                if (PbSearchEmotionActivity.this.aic == 0) {
                    PbSearchEmotionActivity.this.cgT();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aic = aVar.getPage();
            if (PbSearchEmotionActivity.this.aic == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.byl() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bym());
            if (PbSearchEmotionActivity.this.iQg == null) {
                PbSearchEmotionActivity.this.iQg = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.iQg.dM(PbSearchEmotionActivity.this.iQh);
                PbSearchEmotionActivity.this.iQg.a(PbSearchEmotionActivity.this.iQi);
                PbSearchEmotionActivity.this.isB.setAdapter((ListAdapter) PbSearchEmotionActivity.this.iQg);
            } else {
                PbSearchEmotionActivity.this.iQg.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.cgQ();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.itE);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aic == 1) {
                PbSearchEmotionActivity.this.cgT();
            }
        }
    };
    private final BdListView.e Ah = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cgS();
        }
    };
    private final a iQi = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.iOa);
                com.baidu.adp.lib.e.c.gr().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.itL = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.iOa = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.itM = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.iQh = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.itJ = new SearchEmotionModel();
        this.aic = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.itM)) {
            this.itE.setText(this.itM);
            Fe(this.itM);
        }
    }

    private void initView() {
        this.isH = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.iQf = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.ikQ = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.itE = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.itE.setCallback(this);
        this.iQe = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.itF = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.isB = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.isB.setOnSrollToBottomListener(this.Ah);
        this.itE.setText("");
        this.itE.byt();
        ShowSoftKeyPadDelay(this.itE, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        cpt();
        cgP();
    }

    private void cgP() {
        this.itH = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.itL == null || this.itL.isEmpty()) {
            this.itH.setVisibility(8);
            return;
        }
        this.itF.setVisibility(0);
        this.itF.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.itL.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.itL.get(i);
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
                        PbSearchEmotionActivity.this.itE.setText(str);
                        PbSearchEmotionActivity.this.itE.setSelection(str.length());
                        PbSearchEmotionActivity.this.Fe(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.itH.addView(textView);
            }
        }
    }

    private void cpt() {
        this.iQe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fe(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aic = 0;
            this.itM = str;
            this.itJ.a(str, this.aic + 1, 40, this.fYB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgS() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.itJ.a(this.itM, this.aic + 1, 40, this.fYB);
        }
    }

    private void cgR() {
        this.itH.setVisibility(0);
        this.itF.setText(getResources().getString(R.string.hot_emotion));
        this.itF.setVisibility(0);
        this.isB.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgQ() {
        this.isB.setVisibility(0);
        this.itF.setText(getResources().getString(R.string.click_send_emotion));
        this.itF.setVisibility(0);
        this.itH.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgT() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.iQf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.itH.setVisibility(8);
        this.isB.setVisibility(8);
        this.itF.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.isH);
        am.setBackgroundResource(this.isH, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.ikQ, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.itJ != null) {
            this.itJ.cancelLoadData();
        }
        if (this.isB != null) {
            this.isB.removeAllViewsInLayout();
            this.isB = null;
        }
        if (this.iQg != null) {
            this.iQg.removeListener();
            this.iQg.cgV();
            this.iQg = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Ac(String str) {
        Fe(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Ad(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.iQg != null) {
                this.iQg.notifyDataSetChanged();
            }
            cgR();
        }
    }
}
