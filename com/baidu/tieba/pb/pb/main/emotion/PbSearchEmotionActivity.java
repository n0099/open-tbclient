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
    private int aRM;
    private String kMB;
    private TextView kOI;
    private FrameLayout kOJ;
    private d kOK;
    private List<String> kOL;
    private View kee;
    private BdListView knX;
    private LinearLayout kod;
    private SearchEditView kpc;
    private TextView kpd;
    private AutoLineWrapLayout kpf;
    private SearchEmotionModel kph;
    private List<String> kpj;
    private String kpk;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a hFe = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.chH() == null || aVar.chH().isEmpty()) {
                if (PbSearchEmotionActivity.this.aRM == 0) {
                    PbSearchEmotionActivity.this.cTj();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aRM = aVar.getPage();
            if (PbSearchEmotionActivity.this.aRM == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.chG() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.chH());
            if (PbSearchEmotionActivity.this.kOK == null) {
                PbSearchEmotionActivity.this.kOK = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.kOK.eD(PbSearchEmotionActivity.this.kOL);
                PbSearchEmotionActivity.this.kOK.a(PbSearchEmotionActivity.this.kOM);
                PbSearchEmotionActivity.this.knX.setAdapter((ListAdapter) PbSearchEmotionActivity.this.kOK);
            } else {
                PbSearchEmotionActivity.this.kOK.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.cTg();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.kpc);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aRM == 1) {
                PbSearchEmotionActivity.this.cTj();
            }
        }
    };
    private final BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cTi();
        }
    };
    private final a kOM = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.kMB);
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
            this.kpj = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.kMB = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.kpk = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.kOL = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.kph = new SearchEmotionModel();
        this.aRM = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.kpk)) {
            this.kpc.setText(this.kpk);
            MV(this.kpk);
        }
    }

    private void initView() {
        this.kod = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.kOJ = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.kee = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.kpc = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.kpc.setCallback(this);
        this.kOI = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.kpd = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.knX = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.knX.setOnSrollToBottomListener(this.Vh);
        this.kpc.setText("");
        this.kpc.chO();
        ShowSoftKeyPadDelay(this.kpc, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dbX();
        cTf();
    }

    private void cTf() {
        this.kpf = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.kpj == null || this.kpj.isEmpty()) {
            this.kpf.setVisibility(8);
            return;
        }
        this.kpd.setVisibility(0);
        this.kpd.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.kpj.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.kpj.get(i);
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
                        PbSearchEmotionActivity.this.kpc.setText(str);
                        PbSearchEmotionActivity.this.kpc.setSelection(str.length());
                        PbSearchEmotionActivity.this.MV(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.kpf.addView(textView);
            }
        }
    }

    private void dbX() {
        this.kOI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MV(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aRM = 0;
            this.kpk = str;
            this.kph.a(str, this.aRM + 1, 40, this.hFe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTi() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.kph.a(this.kpk, this.aRM + 1, 40, this.hFe);
        }
    }

    private void cTh() {
        this.kpf.setVisibility(0);
        this.kpd.setText(getResources().getString(R.string.hot_emotion));
        this.kpd.setVisibility(0);
        this.knX.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTg() {
        this.knX.setVisibility(0);
        this.kpd.setText(getResources().getString(R.string.click_send_emotion));
        this.kpd.setVisibility(0);
        this.kpf.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTj() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.kOJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.oK(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.kpf.setVisibility(8);
        this.knX.setVisibility(8);
        this.kpd.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.kod);
        ap.setBackgroundResource(this.kod, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.kee, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kph != null) {
            this.kph.cancelLoadData();
        }
        if (this.knX != null) {
            this.knX.removeAllViewsInLayout();
            this.knX = null;
        }
        if (this.kOK != null) {
            this.kOK.removeListener();
            this.kOK.cTl();
            this.kOK = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void HF(String str) {
        MV(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void HG(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.kOK != null) {
                this.kOK.notifyDataSetChanged();
            }
            cTh();
        }
    }
}
