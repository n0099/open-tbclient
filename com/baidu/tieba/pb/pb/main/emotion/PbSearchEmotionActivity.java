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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes2.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aYr;
    private String lRH;
    private TextView lTQ;
    private FrameLayout lTR;
    private d lTS;
    private List<String> lTT;
    private View liR;
    private LinearLayout lsD;
    private BdListView lsx;
    private SearchEditView ltD;
    private TextView ltE;
    private AutoLineWrapLayout ltG;
    private SearchEmotionModel ltI;
    private List<String> ltK;
    private String ltL;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iMM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.cwV() == null || aVar.cwV().isEmpty()) {
                if (PbSearchEmotionActivity.this.aYr == 0) {
                    PbSearchEmotionActivity.this.dgK();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aYr = aVar.getPage();
            if (PbSearchEmotionActivity.this.aYr == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.cwU() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.cwV());
            if (PbSearchEmotionActivity.this.lTS == null) {
                PbSearchEmotionActivity.this.lTS = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.lTS.fq(PbSearchEmotionActivity.this.lTT);
                PbSearchEmotionActivity.this.lTS.a(PbSearchEmotionActivity.this.lTU);
                PbSearchEmotionActivity.this.lsx.setAdapter((ListAdapter) PbSearchEmotionActivity.this.lTS);
            } else {
                PbSearchEmotionActivity.this.lTS.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.dgH();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.ltD);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aYr == 1) {
                PbSearchEmotionActivity.this.dgK();
            }
        }
    };
    private final BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.dgJ();
        }
    };
    private final a lTU = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.lRH);
                com.baidu.adp.lib.e.d.mx().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.ltK = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.lRH = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.ltL = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.lTT = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.ltI = new SearchEmotionModel();
        this.aYr = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.ltL)) {
            this.ltD.setText(this.ltL);
            Oc(this.ltL);
        }
    }

    private void initView() {
        this.lsD = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.lTR = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.liR = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.ltD = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.ltD.setCallback(this);
        this.lTQ = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.ltE = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.lsx = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.lsx.setOnSrollToBottomListener(this.WL);
        this.ltD.setText("");
        this.ltD.cxc();
        ShowSoftKeyPadDelay(this.ltD, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dpJ();
        dgG();
    }

    private void dgG() {
        this.ltG = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.ltK == null || this.ltK.isEmpty()) {
            this.ltG.setVisibility(8);
            return;
        }
        this.ltE.setVisibility(0);
        this.ltE.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.ltK.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.ltK.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                ao.setBackgroundColor(textView, R.color.CAM_X0205);
                ao.setViewTextColor(textView, R.color.CAM_X0106);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.ltD.setText(str);
                        PbSearchEmotionActivity.this.ltD.setSelection(str.length());
                        PbSearchEmotionActivity.this.Oc(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.ltG.addView(textView);
            }
        }
    }

    private void dpJ() {
        this.lTQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aYr = 0;
            this.ltL = str;
            this.ltI.a(str, this.aYr + 1, 40, this.iMM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgJ() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.ltI.a(this.ltL, this.aYr + 1, 40, this.iMM);
        }
    }

    private void dgI() {
        this.ltG.setVisibility(0);
        this.ltE.setText(getResources().getString(R.string.hot_emotion));
        this.ltE.setVisibility(0);
        this.lsx.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgH() {
        this.lsx.setVisibility(0);
        this.ltE.setText(getResources().getString(R.string.click_send_emotion));
        this.ltE.setVisibility(0);
        this.ltG.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgK() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lTR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.pu(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ltG.setVisibility(8);
        this.lsx.setVisibility(8);
        this.ltE.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.lsD);
        ao.setBackgroundResource(this.lsD, R.color.CAM_X0201);
        ao.setBackgroundColor(this.liR, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ltI != null) {
            this.ltI.cancelLoadData();
        }
        if (this.lsx != null) {
            this.lsx.removeAllViewsInLayout();
            this.lsx = null;
        }
        if (this.lTS != null) {
            this.lTS.removeListener();
            this.lTS.dgM();
            this.lTS = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void II(String str) {
        Oc(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void IJ(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lTS != null) {
                this.lTS.notifyDataSetChanged();
            }
            dgI();
        }
    }
}
