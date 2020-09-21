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
/* loaded from: classes21.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aTP;
    private String kVb;
    private TextView kXk;
    private FrameLayout kXl;
    private d kXm;
    private List<String> kXn;
    private View kmF;
    private LinearLayout kwC;
    private BdListView kww;
    private SearchEditView kxB;
    private TextView kxC;
    private AutoLineWrapLayout kxE;
    private SearchEmotionModel kxG;
    private List<String> kxI;
    private String kxJ;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a hMf = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.ckU() == null || aVar.ckU().isEmpty()) {
                if (PbSearchEmotionActivity.this.aTP == 0) {
                    PbSearchEmotionActivity.this.cWO();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aTP = aVar.getPage();
            if (PbSearchEmotionActivity.this.aTP == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.ckT() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.ckU());
            if (PbSearchEmotionActivity.this.kXm == null) {
                PbSearchEmotionActivity.this.kXm = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.kXm.eL(PbSearchEmotionActivity.this.kXn);
                PbSearchEmotionActivity.this.kXm.a(PbSearchEmotionActivity.this.kXo);
                PbSearchEmotionActivity.this.kww.setAdapter((ListAdapter) PbSearchEmotionActivity.this.kXm);
            } else {
                PbSearchEmotionActivity.this.kXm.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.cWL();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.kxB);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aTP == 1) {
                PbSearchEmotionActivity.this.cWO();
            }
        }
    };
    private final BdListView.e Vz = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cWN();
        }
    };
    private final a kXo = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.kVb);
                com.baidu.adp.lib.e.c.mR().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.kxI = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.kVb = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.kxJ = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.kXn = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.kxG = new SearchEmotionModel();
        this.aTP = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.kxJ)) {
            this.kxB.setText(this.kxJ);
            Nx(this.kxJ);
        }
    }

    private void initView() {
        this.kwC = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.kXl = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.kmF = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.kxB = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.kxB.setCallback(this);
        this.kXk = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.kxC = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.kww = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.kww.setOnSrollToBottomListener(this.Vz);
        this.kxB.setText("");
        this.kxB.clb();
        ShowSoftKeyPadDelay(this.kxB, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dfB();
        cWK();
    }

    private void cWK() {
        this.kxE = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.kxI == null || this.kxI.isEmpty()) {
            this.kxE.setVisibility(8);
            return;
        }
        this.kxC.setVisibility(0);
        this.kxC.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.kxI.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.kxI.get(i);
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
                        PbSearchEmotionActivity.this.kxB.setText(str);
                        PbSearchEmotionActivity.this.kxB.setSelection(str.length());
                        PbSearchEmotionActivity.this.Nx(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.kxE.addView(textView);
            }
        }
    }

    private void dfB() {
        this.kXk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nx(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aTP = 0;
            this.kxJ = str;
            this.kxG.a(str, this.aTP + 1, 40, this.hMf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWN() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.kxG.a(this.kxJ, this.aTP + 1, 40, this.hMf);
        }
    }

    private void cWM() {
        this.kxE.setVisibility(0);
        this.kxC.setText(getResources().getString(R.string.hot_emotion));
        this.kxC.setVisibility(0);
        this.kww.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWL() {
        this.kww.setVisibility(0);
        this.kxC.setText(getResources().getString(R.string.click_send_emotion));
        this.kxC.setVisibility(0);
        this.kxE.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWO() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.kXl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.oW(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.kxE.setVisibility(8);
        this.kww.setVisibility(8);
        this.kxC.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.kwC);
        ap.setBackgroundResource(this.kwC, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.kmF, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kxG != null) {
            this.kxG.cancelLoadData();
        }
        if (this.kww != null) {
            this.kww.removeAllViewsInLayout();
            this.kww = null;
        }
        if (this.kXm != null) {
            this.kXm.removeListener();
            this.kXm.cWQ();
            this.kXm = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Ic(String str) {
        Nx(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Id(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.kXm != null) {
                this.kXm.notifyDataSetChanged();
            }
            cWM();
        }
    }
}
