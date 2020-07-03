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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.be;
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
/* loaded from: classes9.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aLb;
    private View jFZ;
    private BdListView jPU;
    private SearchEditView jQZ;
    private LinearLayout jQa;
    private TextView jRa;
    private AutoLineWrapLayout jRc;
    private SearchEmotionModel jRe;
    private List<String> jRg;
    private String jRh;
    private String knP;
    private TextView kpW;
    private FrameLayout kpX;
    private d kpY;
    private List<String> kpZ;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a hlW = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bTQ() == null || aVar.bTQ().isEmpty()) {
                if (PbSearchEmotionActivity.this.aLb == 0) {
                    PbSearchEmotionActivity.this.cEJ();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aLb = aVar.getPage();
            if (PbSearchEmotionActivity.this.aLb == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bTP() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bTQ());
            if (PbSearchEmotionActivity.this.kpY == null) {
                PbSearchEmotionActivity.this.kpY = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.kpY.ep(PbSearchEmotionActivity.this.kpZ);
                PbSearchEmotionActivity.this.kpY.a(PbSearchEmotionActivity.this.kqa);
                PbSearchEmotionActivity.this.jPU.setAdapter((ListAdapter) PbSearchEmotionActivity.this.kpY);
            } else {
                PbSearchEmotionActivity.this.kpY.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.cEG();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.jQZ);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aLb == 1) {
                PbSearchEmotionActivity.this.cEJ();
            }
        }
    };
    private final BdListView.e UJ = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cEI();
        }
    };
    private final a kqa = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                be.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.knP);
                com.baidu.adp.lib.e.c.ln().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
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
            this.jRg = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.knP = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.jRh = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.kpZ = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.jRe = new SearchEmotionModel();
        this.aLb = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.jRh)) {
            this.jQZ.setText(this.jRh);
            Jq(this.jRh);
        }
    }

    private void initView() {
        this.jQa = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.kpX = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.jFZ = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.jQZ = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.jQZ.setCallback(this);
        this.kpW = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.jRa = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.jPU = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.jPU.setOnSrollToBottomListener(this.UJ);
        this.jQZ.setText("");
        this.jQZ.bTX();
        ShowSoftKeyPadDelay(this.jQZ, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        cNs();
        cEF();
    }

    private void cEF() {
        this.jRc = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.jRg == null || this.jRg.isEmpty()) {
            this.jRc.setVisibility(8);
            return;
        }
        this.jRa.setVisibility(0);
        this.jRa.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.jRg.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.jRg.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                an.setBackgroundColor(textView, R.color.cp_bg_line_e);
                an.setViewTextColor(textView, (int) R.color.cp_cont_f);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.jQZ.setText(str);
                        PbSearchEmotionActivity.this.jQZ.setSelection(str.length());
                        PbSearchEmotionActivity.this.Jq(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.jRc.addView(textView);
            }
        }
    }

    private void cNs() {
        this.kpW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jq(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aLb = 0;
            this.jRh = str;
            this.jRe.a(str, this.aLb + 1, 40, this.hlW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEI() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.jRe.a(this.jRh, this.aLb + 1, 40, this.hlW);
        }
    }

    private void cEH() {
        this.jRc.setVisibility(0);
        this.jRa.setText(getResources().getString(R.string.hot_emotion));
        this.jRa.setVisibility(0);
        this.jPU.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEG() {
        this.jPU.setVisibility(0);
        this.jRa.setText(getResources().getString(R.string.click_send_emotion));
        this.jRa.setVisibility(0);
        this.jRc.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEJ() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.kpX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.mm(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.jRc.setVisibility(8);
        this.jPU.setVisibility(8);
        this.jRa.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.jQa);
        an.setBackgroundResource(this.jQa, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.jFZ, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jRe != null) {
            this.jRe.cancelLoadData();
        }
        if (this.jPU != null) {
            this.jPU.removeAllViewsInLayout();
            this.jPU = null;
        }
        if (this.kpY != null) {
            this.kpY.removeListener();
            this.kpY.cEL();
            this.kpY = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Es(String str) {
        Jq(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Et(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.kpY != null) {
                this.kpY.notifyDataSetChanged();
            }
            cEH();
        }
    }
}
