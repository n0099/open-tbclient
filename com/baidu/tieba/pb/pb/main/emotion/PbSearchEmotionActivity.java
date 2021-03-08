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
    private int bcY;
    private BdListView lCS;
    private LinearLayout lCY;
    private SearchEditView lDX;
    private TextView lDY;
    private AutoLineWrapLayout lEa;
    private SearchEmotionModel lEc;
    private List<String> lEe;
    private String lEf;
    private View lto;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private String mcX;
    private TextView mfm;
    private FrameLayout mfn;
    private d mfo;
    private List<String> mfp;
    private final SearchEmotionModel.a iUq = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.cyt() == null || aVar.cyt().isEmpty()) {
                if (PbSearchEmotionActivity.this.bcY == 0) {
                    PbSearchEmotionActivity.this.djb();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.bcY = aVar.getPage();
            if (PbSearchEmotionActivity.this.bcY == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.cys() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.cyt());
            if (PbSearchEmotionActivity.this.mfo == null) {
                PbSearchEmotionActivity.this.mfo = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.mfo.fo(PbSearchEmotionActivity.this.mfp);
                PbSearchEmotionActivity.this.mfo.a(PbSearchEmotionActivity.this.mfq);
                PbSearchEmotionActivity.this.lCS.setAdapter((ListAdapter) PbSearchEmotionActivity.this.mfo);
            } else {
                PbSearchEmotionActivity.this.mfo.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.diY();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.lDX);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.bcY == 1) {
                PbSearchEmotionActivity.this.djb();
            }
        }
    };
    private final BdListView.e Yb = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.dja();
        }
    };
    private final a mfq = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bh.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.mcX);
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
            this.lEe = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.mcX = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.lEf = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.mfp = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.lEc = new SearchEmotionModel();
        this.bcY = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.lEf)) {
            this.lDX.setText(this.lEf);
            OZ(this.lEf);
        }
    }

    private void initView() {
        this.lCY = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.mfn = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.lto = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.lDX = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.lDX.setCallback(this);
        this.mfm = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.lDY = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.lCS = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.lCS.setOnSrollToBottomListener(this.Yb);
        this.lDX.setText("");
        this.lDX.cyA();
        ShowSoftKeyPadDelay(this.lDX, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dsn();
        diX();
    }

    private void diX() {
        this.lEa = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.lEe == null || this.lEe.isEmpty()) {
            this.lEa.setVisibility(8);
            return;
        }
        this.lDY.setVisibility(0);
        this.lDY.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.lEe.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lEe.get(i);
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
                        PbSearchEmotionActivity.this.lDX.setText(str);
                        PbSearchEmotionActivity.this.lDX.setSelection(str.length());
                        PbSearchEmotionActivity.this.OZ(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.lEa.addView(textView);
            }
        }
    }

    private void dsn() {
        this.mfm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.bcY = 0;
            this.lEf = str;
            this.lEc.a(str, this.bcY + 1, 40, this.iUq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dja() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.lEc.a(this.lEf, this.bcY + 1, 40, this.iUq);
        }
    }

    private void diZ() {
        this.lEa.setVisibility(0);
        this.lDY.setText(getResources().getString(R.string.hot_emotion));
        this.lDY.setVisibility(0);
        this.lCS.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diY() {
        this.lCS.setVisibility(0);
        this.lDY.setText(getResources().getString(R.string.click_send_emotion));
        this.lDY.setVisibility(0);
        this.lEa.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djb() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.mfn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.pA(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lEa.setVisibility(8);
        this.lCS.setVisibility(8);
        this.lDY.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.lCY);
        ap.setBackgroundResource(this.lCY, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lto, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lEc != null) {
            this.lEc.cancelLoadData();
        }
        if (this.lCS != null) {
            this.lCS.removeAllViewsInLayout();
            this.lCS = null;
        }
        if (this.mfo != null) {
            this.mfo.removeListener();
            this.mfo.djd();
            this.mfo = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JD(String str) {
        OZ(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JE(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.mfo != null) {
                this.mfo.notifyDataSetChanged();
            }
            diZ();
        }
    }
}
