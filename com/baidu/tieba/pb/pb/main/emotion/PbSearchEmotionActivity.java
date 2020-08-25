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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bg;
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
/* loaded from: classes16.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aRK;
    private String kMu;
    private TextView kOB;
    private FrameLayout kOC;
    private d kOD;
    private List<String> kOE;
    private View kdX;
    private BdListView knQ;
    private LinearLayout knW;
    private SearchEditView koV;
    private TextView koW;
    private AutoLineWrapLayout koY;
    private SearchEmotionModel kpa;
    private List<String> kpc;
    private String kpd;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a hEY = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.chG() == null || aVar.chG().isEmpty()) {
                if (PbSearchEmotionActivity.this.aRK == 0) {
                    PbSearchEmotionActivity.this.cTi();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aRK = aVar.getPage();
            if (PbSearchEmotionActivity.this.aRK == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.chF() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.chG());
            if (PbSearchEmotionActivity.this.kOD == null) {
                PbSearchEmotionActivity.this.kOD = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.kOD.eD(PbSearchEmotionActivity.this.kOE);
                PbSearchEmotionActivity.this.kOD.a(PbSearchEmotionActivity.this.kOF);
                PbSearchEmotionActivity.this.knQ.setAdapter((ListAdapter) PbSearchEmotionActivity.this.kOD);
            } else {
                PbSearchEmotionActivity.this.kOD.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.cTf();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.koV);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aRK == 1) {
                PbSearchEmotionActivity.this.cTi();
            }
        }
    };
    private final BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cTh();
        }
    };
    private final a kOF = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.kMu);
                com.baidu.adp.lib.e.c.mM().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.kpc = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.kMu = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.kpd = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.kOE = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.kpa = new SearchEmotionModel();
        this.aRK = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.kpd)) {
            this.koV.setText(this.kpd);
            MU(this.kpd);
        }
    }

    private void initView() {
        this.knW = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.kOC = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.kdX = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.koV = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.koV.setCallback(this);
        this.kOB = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.koW = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.knQ = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.knQ.setOnSrollToBottomListener(this.Vh);
        this.koV.setText("");
        this.koV.chN();
        ShowSoftKeyPadDelay(this.koV, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dbW();
        cTe();
    }

    private void cTe() {
        this.koY = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.kpc == null || this.kpc.isEmpty()) {
            this.koY.setVisibility(8);
            return;
        }
        this.koW.setVisibility(0);
        this.koW.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.kpc.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.kpc.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                ap.setBackgroundColor(textView, R.color.cp_bg_line_e);
                ap.setViewTextColor(textView, R.color.cp_cont_f);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.koV.setText(str);
                        PbSearchEmotionActivity.this.koV.setSelection(str.length());
                        PbSearchEmotionActivity.this.MU(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.koY.addView(textView);
            }
        }
    }

    private void dbW() {
        this.kOB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aRK = 0;
            this.kpd = str;
            this.kpa.a(str, this.aRK + 1, 40, this.hEY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTh() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.kpa.a(this.kpd, this.aRK + 1, 40, this.hEY);
        }
    }

    private void cTg() {
        this.koY.setVisibility(0);
        this.koW.setText(getResources().getString(R.string.hot_emotion));
        this.koW.setVisibility(0);
        this.knQ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTf() {
        this.knQ.setVisibility(0);
        this.koW.setText(getResources().getString(R.string.click_send_emotion));
        this.koW.setVisibility(0);
        this.koY.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTi() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.kOC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.oK(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.koY.setVisibility(8);
        this.knQ.setVisibility(8);
        this.koW.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.knW);
        ap.setBackgroundResource(this.knW, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.kdX, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kpa != null) {
            this.kpa.cancelLoadData();
        }
        if (this.knQ != null) {
            this.knQ.removeAllViewsInLayout();
            this.knQ = null;
        }
        if (this.kOD != null) {
            this.kOD.removeListener();
            this.kOD.cTk();
            this.kOD = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void HE(String str) {
        MU(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void HF(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.kOD != null) {
                this.kOD.notifyDataSetChanged();
            }
            cTg();
        }
    }
}
