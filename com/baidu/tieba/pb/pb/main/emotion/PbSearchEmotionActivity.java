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
    private String eLf;
    private TextView eMj;
    private FrameLayout eMk;
    private d eMl;
    private List<String> eMm;
    private View emH;
    private LinearLayout esF;
    private BdListView esz;
    private SearchEditView etG;
    private TextView etH;
    private AutoLineWrapLayout etJ;
    private SearchEmotionModel etL;
    private List<String> etN;
    private String etO;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private final SearchEmotionModel.a ceM = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.adz() == null || aVar.adz().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aLO();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.ady() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.adz());
            if (PbSearchEmotionActivity.this.eMl == null) {
                PbSearchEmotionActivity.this.eMl = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.eMl.cw(PbSearchEmotionActivity.this.eMm);
                PbSearchEmotionActivity.this.eMl.a(PbSearchEmotionActivity.this.eCl);
                PbSearchEmotionActivity.this.esz.setAdapter((ListAdapter) PbSearchEmotionActivity.this.eMl);
            } else {
                PbSearchEmotionActivity.this.eMl.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aLL();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.etG);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aLO();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aLN();
        }
    };
    private final a eCl = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aT(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.eLf);
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
            this.etN = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.eLf = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.etO = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.eMm = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.etL = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.etO)) {
            this.etG.setText(this.etO);
            ot(this.etO);
        }
    }

    private void initView() {
        this.esF = (LinearLayout) this.mActivity.findViewById(d.h.layout_root);
        this.eMk = (FrameLayout) this.mActivity.findViewById(d.h.layout_content);
        this.emH = this.mActivity.findViewById(d.h.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.h.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.etG = (SearchEditView) addCustomView.findViewById(d.h.edit_search_view);
        this.etG.setCallback(this);
        this.eMj = (TextView) addCustomView.findViewById(d.h.tv_cancel);
        this.etH = (TextView) this.mActivity.findViewById(d.h.tv_tips);
        this.esz = (BdListView) this.mActivity.findViewById(d.h.listview_emotion);
        this.esz.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.etG.setText("");
        this.etG.adG();
        ShowSoftKeyPadDelay(this.etG, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aSc();
        aLK();
    }

    private void aLK() {
        this.etJ = (AutoLineWrapLayout) this.mActivity.findViewById(d.h.layout_hot_words);
        if (this.etN == null || this.etN.isEmpty()) {
            this.etJ.setVisibility(8);
            return;
        }
        this.etH.setVisibility(0);
        this.etH.setText(getResources().getString(d.l.hot_emotion));
        int min = Math.min(this.etN.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.etN.get(i);
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
                        PbSearchEmotionActivity.this.etG.setText(str);
                        PbSearchEmotionActivity.this.etG.setSelection(str.length());
                        PbSearchEmotionActivity.this.ot(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.etJ.addView(textView);
            }
        }
    }

    private void aSc() {
        this.eMj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.hh()) {
                showToast(d.l.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.etO = str;
            this.etL.a(str, this.mCurrentPage + 1, 40, this.ceM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLN() {
        if (!j.hh()) {
            showToast(d.l.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.etL.a(this.etO, this.mCurrentPage + 1, 40, this.ceM);
        }
    }

    private void aLM() {
        this.etJ.setVisibility(0);
        this.etH.setText(getResources().getString(d.l.hot_emotion));
        this.etH.setVisibility(0);
        this.esz.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLL() {
        this.esz.setVisibility(0);
        this.etH.setText(getResources().getString(d.l.click_send_emotion));
        this.etH.setVisibility(0);
        this.etJ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLO() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eMk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.mActivity, d.f.ds320)), NoDataViewFactory.d.dp(d.l.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.etJ.setVisibility(8);
        this.esz.setVisibility(8);
        this.etH.setVisibility(8);
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
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.esF);
        aj.j(this.esF, d.e.cp_bg_line_d);
        aj.k(this.emH, d.e.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.etL != null) {
            this.etL.cancelLoadData();
        }
        if (this.esz != null) {
            this.esz.removeAllViewsInLayout();
            this.esz = null;
        }
        if (this.eMl != null) {
            this.eMl.removeListener();
            this.eMl.aLQ();
            this.eMl = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jM(String str) {
        ot(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void jN(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.eMl != null) {
                this.eMl.notifyDataSetChanged();
            }
            aLM();
        }
    }
}
