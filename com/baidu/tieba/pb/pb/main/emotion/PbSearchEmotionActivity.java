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
/* loaded from: classes6.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aht;
    private String iKw;
    private TextView iMA;
    private FrameLayout iMB;
    private d iMC;
    private List<String> iMD;
    private View ihm;
    private BdListView ioX;
    private LinearLayout ipd;
    private SearchEditView iqa;
    private TextView iqb;
    private AutoLineWrapLayout iqd;
    private SearchEmotionModel iqf;
    private List<String> iqh;
    private String iqi;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a fVs = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bxk() == null || aVar.bxk().isEmpty()) {
                if (PbSearchEmotionActivity.this.aht == 0) {
                    PbSearchEmotionActivity.this.cfL();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aht = aVar.getPage();
            if (PbSearchEmotionActivity.this.aht == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bxj() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bxk());
            if (PbSearchEmotionActivity.this.iMC == null) {
                PbSearchEmotionActivity.this.iMC = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.iMC.dM(PbSearchEmotionActivity.this.iMD);
                PbSearchEmotionActivity.this.iMC.a(PbSearchEmotionActivity.this.iME);
                PbSearchEmotionActivity.this.ioX.setAdapter((ListAdapter) PbSearchEmotionActivity.this.iMC);
            } else {
                PbSearchEmotionActivity.this.iMC.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.cfI();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.iqa);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aht == 1) {
                PbSearchEmotionActivity.this.cfL();
            }
        }
    };
    private final BdListView.e Ac = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cfK();
        }
    };
    private final a iME = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.iKw);
                com.baidu.adp.lib.e.c.gs().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.iqh = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.iKw = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.iqi = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.iMD = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.iqf = new SearchEmotionModel();
        this.aht = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.iqi)) {
            this.iqa.setText(this.iqi);
            EU(this.iqi);
        }
    }

    private void initView() {
        this.ipd = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.iMB = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.ihm = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.iqa = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.iqa.setCallback(this);
        this.iMA = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.iqb = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.ioX = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.ioX.setOnSrollToBottomListener(this.Ac);
        this.iqa.setText("");
        this.iqa.bxr();
        ShowSoftKeyPadDelay(this.iqa, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        com();
        cfH();
    }

    private void cfH() {
        this.iqd = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.iqh == null || this.iqh.isEmpty()) {
            this.iqd.setVisibility(8);
            return;
        }
        this.iqb.setVisibility(0);
        this.iqb.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.iqh.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.iqh.get(i);
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
                        PbSearchEmotionActivity.this.iqa.setText(str);
                        PbSearchEmotionActivity.this.iqa.setSelection(str.length());
                        PbSearchEmotionActivity.this.EU(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.iqd.addView(textView);
            }
        }
    }

    private void com() {
        this.iMA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EU(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aht = 0;
            this.iqi = str;
            this.iqf.a(str, this.aht + 1, 40, this.fVs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfK() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.iqf.a(this.iqi, this.aht + 1, 40, this.fVs);
        }
    }

    private void cfJ() {
        this.iqd.setVisibility(0);
        this.iqb.setText(getResources().getString(R.string.hot_emotion));
        this.iqb.setVisibility(0);
        this.ioX.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfI() {
        this.ioX.setVisibility(0);
        this.iqb.setText(getResources().getString(R.string.click_send_emotion));
        this.iqb.setVisibility(0);
        this.iqd.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfL() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.iMB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.iqd.setVisibility(8);
        this.ioX.setVisibility(8);
        this.iqb.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.ipd);
        am.setBackgroundResource(this.ipd, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.ihm, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iqf != null) {
            this.iqf.cancelLoadData();
        }
        if (this.ioX != null) {
            this.ioX.removeAllViewsInLayout();
            this.ioX = null;
        }
        if (this.iMC != null) {
            this.iMC.removeListener();
            this.iMC.cfN();
            this.iMC = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void zS(String str) {
        EU(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void zT(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.iMC != null) {
                this.iMC.notifyDataSetChanged();
            }
            cfJ();
        }
    }
}
