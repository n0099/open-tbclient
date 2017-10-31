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
    private BdListView eAJ;
    private LinearLayout eAP;
    private SearchEditView eBP;
    private TextView eBQ;
    private AutoLineWrapLayout eBS;
    private SearchEmotionModel eBU;
    private List<String> eBW;
    private String eBX;
    private String eTU;
    private TextView eVd;
    private FrameLayout eVe;
    private d eVf;
    private List<String> eVg;
    private View eus;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private final SearchEmotionModel.a cmg = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.afG() == null || aVar.afG().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.aOG();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.afF() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.afG());
            if (PbSearchEmotionActivity.this.eVf == null) {
                PbSearchEmotionActivity.this.eVf = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.eVf.cx(PbSearchEmotionActivity.this.eVg);
                PbSearchEmotionActivity.this.eVf.a(PbSearchEmotionActivity.this.eLc);
                PbSearchEmotionActivity.this.eAJ.setAdapter((ListAdapter) PbSearchEmotionActivity.this.eVf);
            } else {
                PbSearchEmotionActivity.this.eVf.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.aOD();
            l.a(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.eBP);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.aOG();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.aOF();
        }
    };
    private final a eLc = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ax.aT(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.eTU);
                com.baidu.adp.lib.f.c.fJ().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
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
        setContentView(d.h.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.eBW = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.eTU = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.eBX = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.eVg = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.eBU = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.eBX)) {
            this.eBP.setText(this.eBX);
            pa(this.eBX);
        }
    }

    private void initView() {
        this.eAP = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.eVe = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.eus = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.eBP = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.eBP.setCallback(this);
        this.eVd = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.eBQ = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.eAJ = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.eAJ.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.eBP.setText("");
        this.eBP.afN();
        ShowSoftKeyPadDelay(this.eBP, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        aVq();
        aOC();
    }

    private void aOC() {
        this.eBS = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.eBW == null || this.eBW.isEmpty()) {
            this.eBS.setVisibility(8);
            return;
        }
        this.eBQ.setVisibility(0);
        this.eBQ.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.eBW.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.eBW.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                aj.k(textView, d.C0080d.cp_bg_line_e);
                aj.i(textView, d.C0080d.cp_cont_f);
                int f = l.f(this.mActivity, d.e.ds16);
                textView.setPadding(f, f, f, f);
                textView.setText(str2);
                textView.setTextSize(0, l.f(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.eBP.setText(str);
                        PbSearchEmotionActivity.this.eBP.setSelection(str.length());
                        PbSearchEmotionActivity.this.pa(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.eBS.addView(textView);
            }
        }
    }

    private void aVq() {
        this.eVd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.hh()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.eBX = str;
            this.eBU.a(str, this.mCurrentPage + 1, 40, this.cmg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOF() {
        if (!j.hh()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.eBU.a(this.eBX, this.mCurrentPage + 1, 40, this.cmg);
        }
    }

    private void aOE() {
        this.eBS.setVisibility(0);
        this.eBQ.setText(getResources().getString(d.j.hot_emotion));
        this.eBQ.setVisibility(0);
        this.eAJ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOD() {
        this.eAJ.setVisibility(0);
        this.eBQ.setText(getResources().getString(d.j.click_send_emotion));
        this.eBQ.setVisibility(0);
        this.eBS.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOG() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.eVe, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.mActivity, d.e.ds320)), NoDataViewFactory.d.dq(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.eBS.setVisibility(8);
        this.eAJ.setVisibility(8);
        this.eBQ.setVisibility(8);
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
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.eAP);
        aj.j(this.eAP, d.C0080d.cp_bg_line_d);
        aj.k(this.eus, d.C0080d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eBU != null) {
            this.eBU.cancelLoadData();
        }
        if (this.eAJ != null) {
            this.eAJ.removeAllViewsInLayout();
            this.eAJ = null;
        }
        if (this.eVf != null) {
            this.eVf.removeListener();
            this.eVf.aOI();
            this.eVf = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kj(String str) {
        pa(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void kk(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.eVf != null) {
                this.eVf.notifyDataSetChanged();
            }
            aOE();
        }
    }
}
