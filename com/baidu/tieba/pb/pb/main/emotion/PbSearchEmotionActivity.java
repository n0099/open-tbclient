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
/* loaded from: classes22.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int bbx;
    private String lQX;
    private TextView lTh;
    private FrameLayout lTi;
    private d lTj;
    private List<String> lTk;
    private View lhQ;
    private BdListView lrT;
    private LinearLayout lrZ;
    private SearchEditView lsY;
    private TextView lsZ;
    private AutoLineWrapLayout ltb;
    private SearchEmotionModel ltd;
    private List<String> ltf;
    private String ltg;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iFf = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.cxS() == null || aVar.cxS().isEmpty()) {
                if (PbSearchEmotionActivity.this.bbx == 0) {
                    PbSearchEmotionActivity.this.dkQ();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.bbx = aVar.getPage();
            if (PbSearchEmotionActivity.this.bbx == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.cxR() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.cxS());
            if (PbSearchEmotionActivity.this.lTj == null) {
                PbSearchEmotionActivity.this.lTj = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.lTj.fq(PbSearchEmotionActivity.this.lTk);
                PbSearchEmotionActivity.this.lTj.a(PbSearchEmotionActivity.this.lTl);
                PbSearchEmotionActivity.this.lrT.setAdapter((ListAdapter) PbSearchEmotionActivity.this.lTj);
            } else {
                PbSearchEmotionActivity.this.lTj.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.dkN();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.lsY);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.bbx == 1) {
                PbSearchEmotionActivity.this.dkQ();
            }
        }
    };
    private final BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.dkP();
        }
    };
    private final a lTl = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bh.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.lQX);
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
            this.ltf = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.lQX = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.ltg = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.lTk = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.ltd = new SearchEmotionModel();
        this.bbx = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.ltg)) {
            this.lsY.setText(this.ltg);
            PF(this.ltg);
        }
    }

    private void initView() {
        this.lrZ = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.lTi = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.lhQ = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.lsY = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.lsY.setCallback(this);
        this.lTh = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.lsZ = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.lrT = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.lrT.setOnSrollToBottomListener(this.WQ);
        this.lsY.setText("");
        this.lsY.cxZ();
        ShowSoftKeyPadDelay(this.lsY, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dtK();
        dkM();
    }

    private void dkM() {
        this.ltb = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.ltf == null || this.ltf.isEmpty()) {
            this.ltb.setVisibility(8);
            return;
        }
        this.lsZ.setVisibility(0);
        this.lsZ.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.ltf.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.ltf.get(i);
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
                        PbSearchEmotionActivity.this.lsY.setText(str);
                        PbSearchEmotionActivity.this.lsY.setSelection(str.length());
                        PbSearchEmotionActivity.this.PF(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.ltb.addView(textView);
            }
        }
    }

    private void dtK() {
        this.lTh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.bbx = 0;
            this.ltg = str;
            this.ltd.a(str, this.bbx + 1, 40, this.iFf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkP() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.ltd.a(this.ltg, this.bbx + 1, 40, this.iFf);
        }
    }

    private void dkO() {
        this.ltb.setVisibility(0);
        this.lsZ.setText(getResources().getString(R.string.hot_emotion));
        this.lsZ.setVisibility(0);
        this.lrT.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkN() {
        this.lrT.setVisibility(0);
        this.lsZ.setText(getResources().getString(R.string.click_send_emotion));
        this.lsZ.setVisibility(0);
        this.ltb.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkQ() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lTi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.qP(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.ltb.setVisibility(8);
        this.lrT.setVisibility(8);
        this.lsZ.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.lrZ);
        ap.setBackgroundResource(this.lrZ, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lhQ, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ltd != null) {
            this.ltd.cancelLoadData();
        }
        if (this.lrT != null) {
            this.lrT.removeAllViewsInLayout();
            this.lrT = null;
        }
        if (this.lTj != null) {
            this.lTj.removeListener();
            this.lTj.dkS();
            this.lTj = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JW(String str) {
        PF(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JX(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lTj != null) {
                this.lTj.notifyDataSetChanged();
            }
            dkO();
        }
    }
}
