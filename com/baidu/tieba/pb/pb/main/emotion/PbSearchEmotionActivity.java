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
    private int Zv;
    private BdListView hAT;
    private LinearLayout hAZ;
    private SearchEditView hBX;
    private TextView hBY;
    private AutoLineWrapLayout hCa;
    private SearchEmotionModel hCc;
    private List<String> hCe;
    private String hCf;
    private String hWD;
    private TextView hXB;
    private FrameLayout hXC;
    private d hXD;
    private List<String> hXE;
    private View hti;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a fgN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bfP() == null || aVar.bfP().isEmpty()) {
                if (PbSearchEmotionActivity.this.Zv == 0) {
                    PbSearchEmotionActivity.this.bOB();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.Zv = aVar.getPage();
            if (PbSearchEmotionActivity.this.Zv == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bfO() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bfP());
            if (PbSearchEmotionActivity.this.hXD == null) {
                PbSearchEmotionActivity.this.hXD = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hXD.dX(PbSearchEmotionActivity.this.hXE);
                PbSearchEmotionActivity.this.hXD.a(PbSearchEmotionActivity.this.hLW);
                PbSearchEmotionActivity.this.hAT.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hXD);
            } else {
                PbSearchEmotionActivity.this.hXD.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bOy();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hBX);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.Zv == 1) {
                PbSearchEmotionActivity.this.bOB();
            }
        }
    };
    private final BdListView.e xE = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bOA();
        }
    };
    private final a hLW = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hWD);
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
            this.hCe = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hWD = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hCf = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hXE = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.hCc = new SearchEmotionModel();
        this.Zv = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hCf)) {
            this.hBX.setText(this.hCf);
            An(this.hCf);
        }
    }

    private void initView() {
        this.hAZ = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.hXC = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.hti = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hBX = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.hBX.setCallback(this);
        this.hXB = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.hBY = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.hAT = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.hAT.setOnSrollToBottomListener(this.xE);
        this.hBX.setText("");
        this.hBX.bfW();
        ShowSoftKeyPadDelay(this.hBX, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bWu();
        bOx();
    }

    private void bOx() {
        this.hCa = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.hCe == null || this.hCe.isEmpty()) {
            this.hCa.setVisibility(8);
            return;
        }
        this.hBY.setVisibility(0);
        this.hBY.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.hCe.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hCe.get(i);
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
                        PbSearchEmotionActivity.this.hBX.setText(str);
                        PbSearchEmotionActivity.this.hBX.setSelection(str.length());
                        PbSearchEmotionActivity.this.An(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hCa.addView(textView);
            }
        }
    }

    private void bWu() {
        this.hXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
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
            this.Zv = 0;
            this.hCf = str;
            this.hCc.a(str, this.Zv + 1, 40, this.fgN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOA() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.hCc.a(this.hCf, this.Zv + 1, 40, this.fgN);
        }
    }

    private void bOz() {
        this.hCa.setVisibility(0);
        this.hBY.setText(getResources().getString(R.string.hot_emotion));
        this.hBY.setVisibility(0);
        this.hAT.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOy() {
        this.hAT.setVisibility(0);
        this.hBY.setText(getResources().getString(R.string.click_send_emotion));
        this.hBY.setVisibility(0);
        this.hCa.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOB() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hXC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.iK(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hCa.setVisibility(8);
        this.hAT.setVisibility(8);
        this.hBY.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.hAZ);
        am.setBackgroundResource(this.hAZ, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hti, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hCc != null) {
            this.hCc.cancelLoadData();
        }
        if (this.hAT != null) {
            this.hAT.removeAllViewsInLayout();
            this.hAT = null;
        }
        if (this.hXD != null) {
            this.hXD.removeListener();
            this.hXD.bOD();
            this.hXD = null;
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
            if (this.hXD != null) {
                this.hXD.notifyDataSetChanged();
            }
            bOz();
        }
    }
}
