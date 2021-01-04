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
    private int bdf;
    private String lWm;
    private TextView lYv;
    private FrameLayout lYw;
    private d lYx;
    private List<String> lYy;
    private View lnx;
    private BdListView lxd;
    private LinearLayout lxj;
    private SearchEditView lyi;
    private TextView lyj;
    private AutoLineWrapLayout lyl;
    private SearchEmotionModel lyn;
    private List<String> lyq;
    private String lyr;
    private Activity mActivity;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a iRt = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.cAM() == null || aVar.cAM().isEmpty()) {
                if (PbSearchEmotionActivity.this.bdf == 0) {
                    PbSearchEmotionActivity.this.dkB();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.bdf = aVar.getPage();
            if (PbSearchEmotionActivity.this.bdf == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.cAL() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.cAM());
            if (PbSearchEmotionActivity.this.lYx == null) {
                PbSearchEmotionActivity.this.lYx = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.lYx.fq(PbSearchEmotionActivity.this.lYy);
                PbSearchEmotionActivity.this.lYx.a(PbSearchEmotionActivity.this.lYz);
                PbSearchEmotionActivity.this.lxd.setAdapter((ListAdapter) PbSearchEmotionActivity.this.lYx);
            } else {
                PbSearchEmotionActivity.this.lYx.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.dky();
            l.hideSoftKeyPad(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.lyi);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.bdf == 1) {
                PbSearchEmotionActivity.this.dkB();
            }
        }
    };
    private final BdListView.e WN = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.dkA();
        }
    };
    private final a lYz = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bg.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.lWm);
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
            this.lyq = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.lWm = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.lyr = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.lYy = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.lyn = new SearchEmotionModel();
        this.bdf = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.lyr)) {
            this.lyi.setText(this.lyr);
            Pl(this.lyr);
        }
    }

    private void initView() {
        this.lxj = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.lYw = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.lnx = this.mActivity.findViewById(R.id.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.lyi = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.lyi.setCallback(this);
        this.lYv = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.lyj = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        this.lxd = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.lxd.setOnSrollToBottomListener(this.WN);
        this.lyi.setText("");
        this.lyi.cAT();
        ShowSoftKeyPadDelay(this.lyi, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        dtA();
        dkx();
    }

    private void dkx() {
        this.lyl = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        if (this.lyq == null || this.lyq.isEmpty()) {
            this.lyl.setVisibility(8);
            return;
        }
        this.lyj.setVisibility(0);
        this.lyj.setText(getResources().getString(R.string.hot_emotion));
        int min = Math.min(this.lyq.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.lyq.get(i);
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
                        PbSearchEmotionActivity.this.lyi.setText(str);
                        PbSearchEmotionActivity.this.lyi.setSelection(str.length());
                        PbSearchEmotionActivity.this.Pl(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.lyl.addView(textView);
            }
        }
    }

    private void dtA() {
        this.lYv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            showProgressBar();
            this.bdf = 0;
            this.lyr = str;
            this.lyn.a(str, this.bdf + 1, 40, this.iRt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkA() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.lyn.a(this.lyr, this.bdf + 1, 40, this.iRt);
        }
    }

    private void dkz() {
        this.lyl.setVisibility(0);
        this.lyj.setText(getResources().getString(R.string.hot_emotion));
        this.lyj.setVisibility(0);
        this.lxd.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dky() {
        this.lxd.setVisibility(0);
        this.lyj.setText(getResources().getString(R.string.click_send_emotion));
        this.lyj.setVisibility(0);
        this.lyl.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkB() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.lYw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mActivity, R.dimen.ds320)), NoDataViewFactory.d.ra(R.string.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.lyl.setVisibility(8);
        this.lxd.setVisibility(8);
        this.lyj.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.lxj);
        ao.setBackgroundResource(this.lxj, R.color.CAM_X0201);
        ao.setBackgroundColor(this.lnx, R.color.CAM_X0204);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lyn != null) {
            this.lyn.cancelLoadData();
        }
        if (this.lxd != null) {
            this.lxd.removeAllViewsInLayout();
            this.lxd = null;
        }
        if (this.lYx != null) {
            this.lYx.removeListener();
            this.lYx.dkD();
            this.lYx = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JU(String str) {
        Pl(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void JV(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.lYx != null) {
                this.lYx.notifyDataSetChanged();
            }
            dkz();
        }
    }
}
