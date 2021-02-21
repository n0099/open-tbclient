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
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes2.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int bby;
    private BdListView lAQ;
    private LinearLayout lAW;
    private SearchEditView lBV;
    private TextView lBW;
    private AutoLineWrapLayout lBY;
    private SearchEmotionModel lCa;
    private List<String> lCc;
    private String lCd;
    private View lrm;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String maV;
    private TextView mdj;
    private FrameLayout mdk;
    private d mdl;
    private List<String> mdm;
    private final SearchEmotionModel.a iSH = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.cyn() == null || aVar.cyn().isEmpty()) {
                if (PbSearchEmotionActivity.this.bby == 0) {
                    PbSearchEmotionActivity.this.diS();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.bby = aVar.getPage();
            if (PbSearchEmotionActivity.this.bby == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.cym() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.cyn());
            if (PbSearchEmotionActivity.this.mdl == null) {
                PbSearchEmotionActivity.this.mdl = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.mdl.fo(PbSearchEmotionActivity.this.mdm);
                PbSearchEmotionActivity.this.mdl.a(PbSearchEmotionActivity.this.mdn);
                PbSearchEmotionActivity.this.lAQ.setAdapter((ListAdapter) PbSearchEmotionActivity.this.mdl);
            } else {
                PbSearchEmotionActivity.this.mdl.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.diP();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.lBV);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.bby == 1) {
                PbSearchEmotionActivity.this.diS();
            }
        }
    };
    private final BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.diR();
        }
    };
    private final a mdn = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bh.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.maV);
                com.baidu.adp.lib.e.d.mw().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.c
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
            this.lCc = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.maV = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.lCd = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.mdm = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.lCa = new SearchEmotionModel();
        this.bby = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.lCd)) {
            this.lBV.setText(this.lCd);
            OT(this.lCd);
        }
    }

    private void initView() {
        this.lAW = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.mdk = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.lrm = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.lBV = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.lBV.setCallback(this);
        this.mdj = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.lBW = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.lAQ = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.lAQ.setOnSrollToBottomListener(this.WH);
        this.lBV.setText("");
        this.lBV.cyu();
        ShowSoftKeyPadDelay(this.lBV, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dse();
        diO();
    }

    private void diO() {
        this.lBY = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.lCc == null || this.lCc.isEmpty()) {
            this.lBY.setVisibility(8);
            return;
        }
        this.lBW.setVisibility(0);
        this.lBW.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.lCc.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lCc.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                ap.setBackgroundColor(textView, R.color.CAM_X0205);
                ap.setViewTextColor(textView, R.color.CAM_X0106);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.lBV.setText(str);
                        PbSearchEmotionActivity.this.lBV.setSelection(str.length());
                        PbSearchEmotionActivity.this.OT(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.lBY.addView(textView);
            }
        }
    }

    private void dse() {
        this.mdj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OT(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.bby = 0;
            this.lCd = str;
            this.lCa.a(str, this.bby + 1, 40, this.iSH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diR() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.lCa.a(this.lCd, this.bby + 1, 40, this.iSH);
        }
    }

    private void diQ() {
        this.lBY.setVisibility(0);
        this.lBW.setText(getResources().getString(R.string.hot_emotion));
        this.lBW.setVisibility(0);
        this.lAQ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diP() {
        this.lAQ.setVisibility(0);
        this.lBW.setText(getResources().getString(R.string.click_send_emotion));
        this.lBW.setVisibility(0);
        this.lBY.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diS() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.mdk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.pz(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lBY.setVisibility(8);
        this.lAQ.setVisibility(8);
        this.lBW.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.lAW);
        ap.setBackgroundResource(this.lAW, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lrm, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lCa != null) {
            this.lCa.cancelLoadData();
        }
        if (this.lAQ != null) {
            this.lAQ.removeAllViewsInLayout();
            this.lAQ = null;
        }
        if (this.mdl != null) {
            this.mdl.removeListener();
            this.mdl.diU();
            this.mdl = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Ju(String str) {
        OT(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Jv(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.mdl != null) {
                this.mdl.notifyDataSetChanged();
            }
            diQ();
        }
    }
}
