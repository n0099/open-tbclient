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
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private String eLt;
    private List<String> eMA;
    private TextView eMx;
    private FrameLayout eMy;
    private d eMz;
    private View emV;
    private BdListView esN;
    private LinearLayout esT;
    private SearchEditView etU;
    private TextView etV;
    private AutoLineWrapLayout etX;
    private SearchEmotionModel etZ;
    private List<String> eub;
    private String euc;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private final SearchEmotionModel.a ceY = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.adD() == null || aVar.adD().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aLT();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.adC() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.adD());
            if (PbSearchEmotionActivity.this.eMz == null) {
                PbSearchEmotionActivity.this.eMz = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.eMz.cw(PbSearchEmotionActivity.this.eMA);
                PbSearchEmotionActivity.this.eMz.a(PbSearchEmotionActivity.this.eCz);
                PbSearchEmotionActivity.this.esN.setAdapter((ListAdapter) PbSearchEmotionActivity.this.eMz);
            } else {
                PbSearchEmotionActivity.this.eMz.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aLQ();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.etU);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aLT();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aLS();
        }
    };
    private final a eCz = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aU(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.eLt);
                com.baidu.adp.lib.f.c.fJ().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbSearchEmotionActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbSearchEmotionActivity.this.getUniqueId());
            } else {
                PbSearchEmotionActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_SEARCH)));
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.eub = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.eLt = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.euc = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.eMA = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.etZ = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.euc)) {
            this.etU.setText(this.euc);
            ou(this.euc);
        }
    }

    private void initView() {
        this.esT = (LinearLayout) this.mActivity.findViewById(d.h.layout_root);
        this.eMy = (FrameLayout) this.mActivity.findViewById(d.h.layout_content);
        this.emV = this.mActivity.findViewById(d.h.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.h.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.etU = (SearchEditView) addCustomView.findViewById(d.h.edit_search_view);
        this.etU.setCallback(this);
        this.eMx = (TextView) addCustomView.findViewById(d.h.tv_cancel);
        this.etV = (TextView) this.mActivity.findViewById(d.h.tv_tips);
        this.esN = (BdListView) this.mActivity.findViewById(d.h.listview_emotion);
        this.esN.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.etU.setText("");
        this.etU.adL();
        ShowSoftKeyPadDelay(this.etU, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aSh();
        aLP();
    }

    private void aLP() {
        this.etX = (AutoLineWrapLayout) this.mActivity.findViewById(d.h.layout_hot_words);
        if (this.eub == null || this.eub.isEmpty()) {
            this.etX.setVisibility(8);
            return;
        }
        this.etV.setVisibility(0);
        this.etV.setText(getResources().getString(d.l.hot_emotion));
        int min = Math.min(this.eub.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.eub.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.k(textView, d.e.cp_bg_line_e);
                aj.i(textView, d.e.cp_cont_f);
                int f = l.f(this.mActivity, d.f.ds16);
                textView.setPadding(f, f, f, f);
                textView.setText(str2);
                textView.setTextSize(0, l.f(this.mActivity, d.f.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.etU.setText(str);
                        PbSearchEmotionActivity.this.etU.setSelection(str.length());
                        PbSearchEmotionActivity.this.ou(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.etX.addView(textView);
            }
        }
    }

    private void aSh() {
        this.eMx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ou(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.hh()) {
                showToast(d.l.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.euc = str;
            this.etZ.a(str, this.mCurrentPage + 1, 40, this.ceY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLS() {
        if (!j.hh()) {
            showToast(d.l.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.etZ.a(this.euc, this.mCurrentPage + 1, 40, this.ceY);
        }
    }

    private void aLR() {
        this.etX.setVisibility(0);
        this.etV.setText(getResources().getString(d.l.hot_emotion));
        this.etV.setVisibility(0);
        this.esN.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLQ() {
        this.esN.setVisibility(0);
        this.etV.setText(getResources().getString(d.l.click_send_emotion));
        this.etV.setVisibility(0);
        this.etX.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLT() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eMy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.mActivity, d.f.ds320)), NoDataViewFactory.d.dq(d.l.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.etX.setVisibility(8);
        this.esN.setVisibility(8);
        this.etV.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
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
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.esT);
        aj.j(this.esT, d.e.cp_bg_line_d);
        aj.k(this.emV, d.e.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.etZ != null) {
            this.etZ.cancelLoadData();
        }
        if (this.esN != null) {
            this.esN.removeAllViewsInLayout();
            this.esN = null;
        }
        if (this.eMz != null) {
            this.eMz.removeListener();
            this.eMz.aLV();
            this.eMz = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jN(String str) {
        ou(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jO(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.eMz != null) {
                this.eMz.notifyDataSetChanged();
            }
            aLR();
        }
    }
}
