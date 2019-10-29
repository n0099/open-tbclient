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
/* loaded from: classes4.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int ZN;
    private BdListView hBK;
    private LinearLayout hBQ;
    private SearchEditView hCO;
    private TextView hCP;
    private AutoLineWrapLayout hCR;
    private SearchEmotionModel hCT;
    private List<String> hCV;
    private String hCW;
    private String hXu;
    private TextView hYs;
    private FrameLayout hYt;
    private d hYu;
    private List<String> hYv;
    private View htZ;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a fhE = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bfR() == null || aVar.bfR().isEmpty()) {
                if (PbSearchEmotionActivity.this.ZN == 0) {
                    PbSearchEmotionActivity.this.bOD();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.ZN = aVar.getPage();
            if (PbSearchEmotionActivity.this.ZN == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bfQ() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bfR());
            if (PbSearchEmotionActivity.this.hYu == null) {
                PbSearchEmotionActivity.this.hYu = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hYu.dX(PbSearchEmotionActivity.this.hYv);
                PbSearchEmotionActivity.this.hYu.a(PbSearchEmotionActivity.this.hMN);
                PbSearchEmotionActivity.this.hBK.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hYu);
            } else {
                PbSearchEmotionActivity.this.hYu.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bOA();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hCO);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.ZN == 1) {
                PbSearchEmotionActivity.this.bOD();
            }
        }
    };
    private final BdListView.e ye = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bOC();
        }
    };
    private final a hMN = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hXu);
                com.baidu.adp.lib.f.c.fT().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
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
            this.hCV = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hXu = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hCW = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hYv = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.hCT = new SearchEmotionModel();
        this.ZN = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hCW)) {
            this.hCO.setText(this.hCW);
            An(this.hCW);
        }
    }

    private void initView() {
        this.hBQ = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.hYt = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.htZ = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hCO = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.hCO.setCallback(this);
        this.hYs = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.hCP = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.hBK = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.hBK.setOnSrollToBottomListener(this.ye);
        this.hCO.setText("");
        this.hCO.bfY();
        ShowSoftKeyPadDelay(this.hCO, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bWw();
        bOz();
    }

    private void bOz() {
        this.hCR = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.hCV == null || this.hCV.isEmpty()) {
            this.hCR.setVisibility(8);
            return;
        }
        this.hCP.setVisibility(0);
        this.hCP.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.hCV.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hCV.get(i);
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
                        PbSearchEmotionActivity.this.hCO.setText(str);
                        PbSearchEmotionActivity.this.hCO.setSelection(str.length());
                        PbSearchEmotionActivity.this.An(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hCR.addView(textView);
            }
        }
    }

    private void bWw() {
        this.hYs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.ZN = 0;
            this.hCW = str;
            this.hCT.a(str, this.ZN + 1, 40, this.fhE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOC() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.hCT.a(this.hCW, this.ZN + 1, 40, this.fhE);
        }
    }

    private void bOB() {
        this.hCR.setVisibility(0);
        this.hCP.setText(getResources().getString(R.string.hot_emotion));
        this.hCP.setVisibility(0);
        this.hBK.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOA() {
        this.hBK.setVisibility(0);
        this.hCP.setText(getResources().getString(R.string.click_send_emotion));
        this.hCP.setVisibility(0);
        this.hCR.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOD() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hYt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.iL(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hCR.setVisibility(8);
        this.hBK.setVisibility(8);
        this.hCP.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.hBQ);
        am.setBackgroundResource(this.hBQ, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.htZ, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hCT != null) {
            this.hCT.cancelLoadData();
        }
        if (this.hBK != null) {
            this.hBK.removeAllViewsInLayout();
            this.hBK = null;
        }
        if (this.hYu != null) {
            this.hYu.removeListener();
            this.hYu.bOF();
            this.hYu = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void va(String str) {
        An(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void vb(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.hYu != null) {
                this.hYu.notifyDataSetChanged();
            }
            bOB();
        }
    }
}
