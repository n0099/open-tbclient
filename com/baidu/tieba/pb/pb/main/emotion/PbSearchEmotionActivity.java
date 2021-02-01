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
    private BdListView lAC;
    private LinearLayout lAI;
    private SearchEditView lBH;
    private TextView lBI;
    private AutoLineWrapLayout lBK;
    private SearchEmotionModel lBM;
    private List<String> lBO;
    private String lBP;
    private View lqY;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String maG;
    private TextView mcU;
    private FrameLayout mcV;
    private d mcW;
    private List<String> mcX;
    private final SearchEmotionModel.a iSt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.cyg() == null || aVar.cyg().isEmpty()) {
                if (PbSearchEmotionActivity.this.bby == 0) {
                    PbSearchEmotionActivity.this.diL();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.bby = aVar.getPage();
            if (PbSearchEmotionActivity.this.bby == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.cyf() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.cyg());
            if (PbSearchEmotionActivity.this.mcW == null) {
                PbSearchEmotionActivity.this.mcW = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.mcW.fo(PbSearchEmotionActivity.this.mcX);
                PbSearchEmotionActivity.this.mcW.a(PbSearchEmotionActivity.this.mcY);
                PbSearchEmotionActivity.this.lAC.setAdapter((ListAdapter) PbSearchEmotionActivity.this.mcW);
            } else {
                PbSearchEmotionActivity.this.mcW.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.diI();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.lBH);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.bby == 1) {
                PbSearchEmotionActivity.this.diL();
            }
        }
    };
    private final BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.diK();
        }
    };
    private final a mcY = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bh.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.maG);
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
            this.lBO = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.maG = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.lBP = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.mcX = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.lBM = new SearchEmotionModel();
        this.bby = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.lBP)) {
            this.lBH.setText(this.lBP);
            OS(this.lBP);
        }
    }

    private void initView() {
        this.lAI = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.mcV = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.lqY = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.lBH = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.lBH.setCallback(this);
        this.mcU = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.lBI = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.lAC = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.lAC.setOnSrollToBottomListener(this.WH);
        this.lBH.setText("");
        this.lBH.cyn();
        ShowSoftKeyPadDelay(this.lBH, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        drX();
        diH();
    }

    private void diH() {
        this.lBK = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.lBO == null || this.lBO.isEmpty()) {
            this.lBK.setVisibility(8);
            return;
        }
        this.lBI.setVisibility(0);
        this.lBI.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.lBO.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lBO.get(i);
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
                        PbSearchEmotionActivity.this.lBH.setText(str);
                        PbSearchEmotionActivity.this.lBH.setSelection(str.length());
                        PbSearchEmotionActivity.this.OS(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.lBK.addView(textView);
            }
        }
    }

    private void drX() {
        this.mcU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OS(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.bby = 0;
            this.lBP = str;
            this.lBM.a(str, this.bby + 1, 40, this.iSt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diK() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.lBM.a(this.lBP, this.bby + 1, 40, this.iSt);
        }
    }

    private void diJ() {
        this.lBK.setVisibility(0);
        this.lBI.setText(getResources().getString(R.string.hot_emotion));
        this.lBI.setVisibility(0);
        this.lAC.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diI() {
        this.lAC.setVisibility(0);
        this.lBI.setText(getResources().getString(R.string.click_send_emotion));
        this.lBI.setVisibility(0);
        this.lBK.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diL() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.mcV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.pz(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lBK.setVisibility(8);
        this.lAC.setVisibility(8);
        this.lBI.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.lAI);
        ap.setBackgroundResource(this.lAI, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lqY, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lBM != null) {
            this.lBM.cancelLoadData();
        }
        if (this.lAC != null) {
            this.lAC.removeAllViewsInLayout();
            this.lAC = null;
        }
        if (this.mcW != null) {
            this.mcW.removeListener();
            this.mcW.diN();
            this.mcW = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Jt(String str) {
        OS(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Ju(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.mcW != null) {
                this.mcW.notifyDataSetChanged();
            }
            diJ();
        }
    }
}
