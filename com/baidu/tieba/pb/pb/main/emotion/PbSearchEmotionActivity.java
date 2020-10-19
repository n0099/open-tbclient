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
/* loaded from: classes22.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aXa;
    private View kBR;
    private BdListView kLI;
    private LinearLayout kLO;
    private SearchEditView kMN;
    private TextView kMO;
    private AutoLineWrapLayout kMQ;
    private SearchEmotionModel kMS;
    private List<String> kMU;
    private String kMV;
    private String lko;
    private List<String> lmA;
    private TextView lmx;
    private FrameLayout lmy;
    private d lmz;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iba = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.cos() == null || aVar.cos().isEmpty()) {
                if (PbSearchEmotionActivity.this.aXa == 0) {
                    PbSearchEmotionActivity.this.dax();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aXa = aVar.getPage();
            if (PbSearchEmotionActivity.this.aXa == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.cor() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.cos());
            if (PbSearchEmotionActivity.this.lmz == null) {
                PbSearchEmotionActivity.this.lmz = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.lmz.eO(PbSearchEmotionActivity.this.lmA);
                PbSearchEmotionActivity.this.lmz.a(PbSearchEmotionActivity.this.lmB);
                PbSearchEmotionActivity.this.kLI.setAdapter((ListAdapter) PbSearchEmotionActivity.this.lmz);
            } else {
                PbSearchEmotionActivity.this.lmz.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.dau();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.kMN);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aXa == 1) {
                PbSearchEmotionActivity.this.dax();
            }
        }
    };
    private final BdListView.e VQ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.daw();
        }
    };
    private final a lmB = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.lko);
                com.baidu.adp.lib.e.c.mS().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.kMU = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.lko = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.kMV = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.lmA = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.kMS = new SearchEmotionModel();
        this.aXa = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.kMV)) {
            this.kMN.setText(this.kMV);
            Om(this.kMV);
        }
    }

    private void initView() {
        this.kLO = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.lmy = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.kBR = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.kMN = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.kMN.setCallback(this);
        this.lmx = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.kMO = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.kLI = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.kLI.setOnSrollToBottomListener(this.VQ);
        this.kMN.setText("");
        this.kMN.coz();
        ShowSoftKeyPadDelay(this.kMN, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        djk();
        dat();
    }

    private void dat() {
        this.kMQ = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.kMU == null || this.kMU.isEmpty()) {
            this.kMQ.setVisibility(8);
            return;
        }
        this.kMO.setVisibility(0);
        this.kMO.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.kMU.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.kMU.get(i);
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
                        PbSearchEmotionActivity.this.kMN.setText(str);
                        PbSearchEmotionActivity.this.kMN.setSelection(str.length());
                        PbSearchEmotionActivity.this.Om(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.kMQ.addView(textView);
            }
        }
    }

    private void djk() {
        this.lmx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Om(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aXa = 0;
            this.kMV = str;
            this.kMS.a(str, this.aXa + 1, 40, this.iba);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daw() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.kMS.a(this.kMV, this.aXa + 1, 40, this.iba);
        }
    }

    private void dav() {
        this.kMQ.setVisibility(0);
        this.kMO.setText(getResources().getString(R.string.hot_emotion));
        this.kMO.setVisibility(0);
        this.kLI.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dau() {
        this.kLI.setVisibility(0);
        this.kMO.setText(getResources().getString(R.string.click_send_emotion));
        this.kMO.setVisibility(0);
        this.kMQ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dax() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lmy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.pv(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.kMQ.setVisibility(8);
        this.kLI.setVisibility(8);
        this.kMO.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.kLO);
        ap.setBackgroundResource(this.kLO, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.kBR, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kMS != null) {
            this.kMS.cancelLoadData();
        }
        if (this.kLI != null) {
            this.kLI.removeAllViewsInLayout();
            this.kLI = null;
        }
        if (this.lmz != null) {
            this.lmz.removeListener();
            this.lmz.daz();
            this.lmz = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void IP(String str) {
        Om(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void IQ(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lmz != null) {
                this.lmz.notifyDataSetChanged();
            }
            dav();
        }
    }
}
