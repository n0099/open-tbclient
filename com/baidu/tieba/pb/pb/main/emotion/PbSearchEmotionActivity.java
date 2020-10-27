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
    private int aYv;
    private View kOo;
    private BdListView kYf;
    private LinearLayout kYl;
    private SearchEditView kZk;
    private TextView kZl;
    private AutoLineWrapLayout kZn;
    private SearchEmotionModel kZp;
    private List<String> kZr;
    private String kZs;
    private String lwR;
    private TextView lzb;
    private FrameLayout lzc;
    private d lzd;
    private List<String> lze;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a inC = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.crz() == null || aVar.crz().isEmpty()) {
                if (PbSearchEmotionActivity.this.aYv == 0) {
                    PbSearchEmotionActivity.this.ddF();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aYv = aVar.getPage();
            if (PbSearchEmotionActivity.this.aYv == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.cry() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.crz());
            if (PbSearchEmotionActivity.this.lzd == null) {
                PbSearchEmotionActivity.this.lzd = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.lzd.eX(PbSearchEmotionActivity.this.lze);
                PbSearchEmotionActivity.this.lzd.a(PbSearchEmotionActivity.this.lzf);
                PbSearchEmotionActivity.this.kYf.setAdapter((ListAdapter) PbSearchEmotionActivity.this.lzd);
            } else {
                PbSearchEmotionActivity.this.lzd.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.ddC();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.kZk);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aYv == 1) {
                PbSearchEmotionActivity.this.ddF();
            }
        }
    };
    private final BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.ddE();
        }
    };
    private final a lzf = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.lwR);
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
            this.kZr = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.lwR = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.kZs = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.lze = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.kZp = new SearchEmotionModel();
        this.aYv = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.kZs)) {
            this.kZk.setText(this.kZs);
            OK(this.kZs);
        }
    }

    private void initView() {
        this.kYl = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.lzc = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.kOo = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.kZk = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.kZk.setCallback(this);
        this.lzb = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.kZl = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.kYf = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.kYf.setOnSrollToBottomListener(this.VR);
        this.kZk.setText("");
        this.kZk.crG();
        ShowSoftKeyPadDelay(this.kZk, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dmr();
        ddB();
    }

    private void ddB() {
        this.kZn = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.kZr == null || this.kZr.isEmpty()) {
            this.kZn.setVisibility(8);
            return;
        }
        this.kZl.setVisibility(0);
        this.kZl.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.kZr.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.kZr.get(i);
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
                        PbSearchEmotionActivity.this.kZk.setText(str);
                        PbSearchEmotionActivity.this.kZk.setSelection(str.length());
                        PbSearchEmotionActivity.this.OK(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.kZn.addView(textView);
            }
        }
    }

    private void dmr() {
        this.lzb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OK(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aYv = 0;
            this.kZs = str;
            this.kZp.a(str, this.aYv + 1, 40, this.inC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddE() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.kZp.a(this.kZs, this.aYv + 1, 40, this.inC);
        }
    }

    private void ddD() {
        this.kZn.setVisibility(0);
        this.kZl.setText(getResources().getString(R.string.hot_emotion));
        this.kZl.setVisibility(0);
        this.kYf.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddC() {
        this.kYf.setVisibility(0);
        this.kZl.setText(getResources().getString(R.string.click_send_emotion));
        this.kZl.setVisibility(0);
        this.kZn.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddF() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lzc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.pG(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.kZn.setVisibility(8);
        this.kYf.setVisibility(8);
        this.kZl.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.kYl);
        ap.setBackgroundResource(this.kYl, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.kOo, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kZp != null) {
            this.kZp.cancelLoadData();
        }
        if (this.kYf != null) {
            this.kYf.removeAllViewsInLayout();
            this.kYf = null;
        }
        if (this.lzd != null) {
            this.lzd.removeListener();
            this.lzd.ddH();
            this.lzd = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Jo(String str) {
        OK(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Jp(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lzd != null) {
                this.lzd.notifyDataSetChanged();
            }
            ddD();
        }
    }
}
