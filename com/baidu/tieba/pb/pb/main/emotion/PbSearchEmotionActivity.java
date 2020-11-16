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
/* loaded from: classes21.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aYc;
    private View kUx;
    private String lDg;
    private TextView lFo;
    private FrameLayout lFp;
    private d lFq;
    private List<String> lFr;
    private LinearLayout leA;
    private BdListView leu;
    private TextView lfA;
    private AutoLineWrapLayout lfC;
    private SearchEmotionModel lfE;
    private List<String> lfG;
    private String lfH;
    private SearchEditView lfz;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iun = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.ctD() == null || aVar.ctD().isEmpty()) {
                if (PbSearchEmotionActivity.this.aYc == 0) {
                    PbSearchEmotionActivity.this.dfE();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aYc = aVar.getPage();
            if (PbSearchEmotionActivity.this.aYc == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.ctC() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.ctD());
            if (PbSearchEmotionActivity.this.lFq == null) {
                PbSearchEmotionActivity.this.lFq = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.lFq.ff(PbSearchEmotionActivity.this.lFr);
                PbSearchEmotionActivity.this.lFq.a(PbSearchEmotionActivity.this.lFs);
                PbSearchEmotionActivity.this.leu.setAdapter((ListAdapter) PbSearchEmotionActivity.this.lFq);
            } else {
                PbSearchEmotionActivity.this.lFq.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.dfB();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.lfz);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aYc == 1) {
                PbSearchEmotionActivity.this.dfE();
            }
        }
    };
    private final BdListView.e VT = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.dfD();
        }
    };
    private final a lFs = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bh.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.lDg);
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
            this.lfG = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.lDg = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.lfH = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.lFr = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.lfE = new SearchEmotionModel();
        this.aYc = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.lfH)) {
            this.lfz.setText(this.lfH);
            Ox(this.lfH);
        }
    }

    private void initView() {
        this.leA = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.lFp = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.kUx = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.lfz = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.lfz.setCallback(this);
        this.lFo = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.lfA = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.leu = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.leu.setOnSrollToBottomListener(this.VT);
        this.lfz.setText("");
        this.lfz.ctK();
        ShowSoftKeyPadDelay(this.lfz, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dot();
        dfA();
    }

    private void dfA() {
        this.lfC = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.lfG == null || this.lfG.isEmpty()) {
            this.lfC.setVisibility(8);
            return;
        }
        this.lfA.setVisibility(0);
        this.lfA.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.lfG.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lfG.get(i);
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
                        PbSearchEmotionActivity.this.lfz.setText(str);
                        PbSearchEmotionActivity.this.lfz.setSelection(str.length());
                        PbSearchEmotionActivity.this.Ox(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.lfC.addView(textView);
            }
        }
    }

    private void dot() {
        this.lFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ox(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aYc = 0;
            this.lfH = str;
            this.lfE.a(str, this.aYc + 1, 40, this.iun);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfD() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.lfE.a(this.lfH, this.aYc + 1, 40, this.iun);
        }
    }

    private void dfC() {
        this.lfC.setVisibility(0);
        this.lfA.setText(getResources().getString(R.string.hot_emotion));
        this.lfA.setVisibility(0);
        this.leu.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfB() {
        this.leu.setVisibility(0);
        this.lfA.setText(getResources().getString(R.string.click_send_emotion));
        this.lfA.setVisibility(0);
        this.lfC.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfE() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lFp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.qo(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lfC.setVisibility(8);
        this.leu.setVisibility(8);
        this.lfA.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.leA);
        ap.setBackgroundResource(this.leA, R.color.CAM_X0201);
        ap.setBackgroundColor(this.kUx, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lfE != null) {
            this.lfE.cancelLoadData();
        }
        if (this.leu != null) {
            this.leu.removeAllViewsInLayout();
            this.leu = null;
        }
        if (this.lFq != null) {
            this.lFq.removeListener();
            this.lFq.dfG();
            this.lFq = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Jg(String str) {
        Ox(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Jh(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lFq != null) {
                this.lFq.notifyDataSetChanged();
            }
            dfC();
        }
    }
}
