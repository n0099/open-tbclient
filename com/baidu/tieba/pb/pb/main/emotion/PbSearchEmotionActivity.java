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
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes16.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private int aMx;
    private View jOF;
    private LinearLayout jYA;
    private BdListView jYu;
    private TextView jZA;
    private AutoLineWrapLayout jZC;
    private SearchEmotionModel jZE;
    private List<String> jZG;
    private String jZH;
    private SearchEditView jZz;
    private String kwP;
    private TextView kyW;
    private FrameLayout kyX;
    private d kyY;
    private List<String> kyZ;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a hrI = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.bXk() == null || aVar.bXk().isEmpty()) {
                if (PbSearchEmotionActivity.this.aMx == 0) {
                    PbSearchEmotionActivity.this.cIt();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.aMx = aVar.getPage();
            if (PbSearchEmotionActivity.this.aMx == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.bXj() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.bXk());
            if (PbSearchEmotionActivity.this.kyY == null) {
                PbSearchEmotionActivity.this.kyY = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.kyY.ev(PbSearchEmotionActivity.this.kyZ);
                PbSearchEmotionActivity.this.kyY.a(PbSearchEmotionActivity.this.kza);
                PbSearchEmotionActivity.this.jYu.setAdapter((ListAdapter) PbSearchEmotionActivity.this.kyY);
            } else {
                PbSearchEmotionActivity.this.kyY.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.cIq();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.jZz);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.aMx == 1) {
                PbSearchEmotionActivity.this.cIt();
            }
        }
    };
    private final BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.cIs();
        }
    };
    private final a kza = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bf.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.kwP);
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
            this.jZG = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.kwP = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.jZH = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.kyZ = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.jZE = new SearchEmotionModel();
        this.aMx = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.jZH)) {
            this.jZz.setText(this.jZH);
            Kc(this.jZH);
        }
    }

    private void initView() {
        this.jYA = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.kyX = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.jOF = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.jZz = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.jZz.setCallback(this);
        this.kyW = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.jZA = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.jYu = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.jYu.setOnSrollToBottomListener(this.UC);
        this.jZz.setText("");
        this.jZz.bXr();
        ShowSoftKeyPadDelay(this.jZz, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        cRg();
        cIp();
    }

    private void cIp() {
        this.jZC = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.jZG == null || this.jZG.isEmpty()) {
            this.jZC.setVisibility(8);
            return;
        }
        this.jZA.setVisibility(0);
        this.jZA.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.jZG.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.jZG.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                TextView textView = new TextView(this.mActivity);
                ao.setBackgroundColor(textView, R.color.cp_bg_line_e);
                ao.setViewTextColor(textView, R.color.cp_cont_f);
                int dimens = l.getDimens(this.mActivity, R.dimen.ds16);
                textView.setPadding(dimens, dimens, dimens, dimens);
                textView.setText(str2);
                textView.setTextSize(0, l.getDimens(this.mActivity, R.dimen.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.jZz.setText(str);
                        PbSearchEmotionActivity.this.jZz.setSelection(str.length());
                        PbSearchEmotionActivity.this.Kc(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.jZC.addView(textView);
            }
        }
    }

    private void cRg() {
        this.kyW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kc(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.aMx = 0;
            this.jZH = str;
            this.jZE.a(str, this.aMx + 1, 40, this.hrI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIs() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.jZE.a(this.jZH, this.aMx + 1, 40, this.hrI);
        }
    }

    private void cIr() {
        this.jZC.setVisibility(0);
        this.jZA.setText(getResources().getString(R.string.hot_emotion));
        this.jZA.setVisibility(0);
        this.jYu.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIq() {
        this.jYu.setVisibility(0);
        this.jZA.setText(getResources().getString(R.string.click_send_emotion));
        this.jZA.setVisibility(0);
        this.jZC.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIt() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.kyX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.mF(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.jZC.setVisibility(8);
        this.jYu.setVisibility(8);
        this.jZA.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.jYA);
        ao.setBackgroundResource(this.jYA, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.jOF, R.color.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jZE != null) {
            this.jZE.cancelLoadData();
        }
        if (this.jYu != null) {
            this.jYu.removeAllViewsInLayout();
            this.jYu = null;
        }
        if (this.kyY != null) {
            this.kyY.removeListener();
            this.kyY.cIv();
            this.kyY = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Fd(String str) {
        Kc(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void Fe(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.kyY != null) {
                this.kyY.notifyDataSetChanged();
            }
            cIr();
        }
    }
}
