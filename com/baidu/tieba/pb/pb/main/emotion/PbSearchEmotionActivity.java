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
    private int aZN;
    private View kUk;
    private String lCO;
    private TextView lEX;
    private FrameLayout lEY;
    private d lEZ;
    private List<String> lFa;
    private BdListView lec;
    private LinearLayout lei;
    private SearchEditView lfi;
    private TextView lfj;
    private AutoLineWrapLayout lfl;
    private SearchEmotionModel lfn;
    private List<String> lfp;
    private String lfq;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a itz = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.cua() == null || aVar.cua().isEmpty()) {
                if (PbSearchEmotionActivity.this.aZN == 0) {
                    PbSearchEmotionActivity.this.dgh();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aZN = aVar.getPage();
            if (PbSearchEmotionActivity.this.aZN == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.ctZ() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.cua());
            if (PbSearchEmotionActivity.this.lEZ == null) {
                PbSearchEmotionActivity.this.lEZ = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.lEZ.ff(PbSearchEmotionActivity.this.lFa);
                PbSearchEmotionActivity.this.lEZ.a(PbSearchEmotionActivity.this.lFb);
                PbSearchEmotionActivity.this.lec.setAdapter((ListAdapter) PbSearchEmotionActivity.this.lEZ);
            } else {
                PbSearchEmotionActivity.this.lEZ.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.dge();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.lfi);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aZN == 1) {
                PbSearchEmotionActivity.this.dgh();
            }
        }
    };
    private final BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.dgg();
        }
    };
    private final a lFb = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.lCO);
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
            this.lfp = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.lCO = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.lfq = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.lFa = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.lfn = new SearchEmotionModel();
        this.aZN = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.lfq)) {
            this.lfi.setText(this.lfq);
            Pb(this.lfq);
        }
    }

    private void initView() {
        this.lei = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.lEY = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.kUk = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.lfi = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.lfi.setCallback(this);
        this.lEX = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.lfj = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.lec = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.lec.setOnSrollToBottomListener(this.VR);
        this.lfi.setText("");
        this.lfi.cuh();
        ShowSoftKeyPadDelay(this.lfi, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        doU();
        dgd();
    }

    private void dgd() {
        this.lfl = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.lfp == null || this.lfp.isEmpty()) {
            this.lfl.setVisibility(8);
            return;
        }
        this.lfj.setVisibility(0);
        this.lfj.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.lfp.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lfp.get(i);
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
                        PbSearchEmotionActivity.this.lfi.setText(str);
                        PbSearchEmotionActivity.this.lfi.setSelection(str.length());
                        PbSearchEmotionActivity.this.Pb(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.lfl.addView(textView);
            }
        }
    }

    private void doU() {
        this.lEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pb(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aZN = 0;
            this.lfq = str;
            this.lfn.a(str, this.aZN + 1, 40, this.itz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgg() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.lfn.a(this.lfq, this.aZN + 1, 40, this.itz);
        }
    }

    private void dgf() {
        this.lfl.setVisibility(0);
        this.lfj.setText(getResources().getString(R.string.hot_emotion));
        this.lfj.setVisibility(0);
        this.lec.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dge() {
        this.lec.setVisibility(0);
        this.lfj.setText(getResources().getString(R.string.click_send_emotion));
        this.lfj.setVisibility(0);
        this.lfl.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgh() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lEY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.pQ(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lfl.setVisibility(8);
        this.lec.setVisibility(8);
        this.lfj.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.lei);
        ap.setBackgroundResource(this.lei, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.kUk, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lfn != null) {
            this.lfn.cancelLoadData();
        }
        if (this.lec != null) {
            this.lec.removeAllViewsInLayout();
            this.lec = null;
        }
        if (this.lEZ != null) {
            this.lEZ.removeListener();
            this.lEZ.dgj();
            this.lEZ = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JF(String str) {
        Pb(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JG(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lEZ != null) {
                this.lEZ.notifyDataSetChanged();
            }
            dgf();
        }
    }
}
