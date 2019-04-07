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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.a {
    private View gUO;
    private BdListView hcG;
    private LinearLayout hcM;
    private SearchEditView hdJ;
    private TextView hdK;
    private AutoLineWrapLayout hdM;
    private SearchEmotionModel hdO;
    private List<String> hdQ;
    private String hdR;
    private String hxR;
    private TextView hyP;
    private FrameLayout hyQ;
    private d hyR;
    private List<String> hyS;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a eHv = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.aXH() == null || aVar.aXH().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.bGg();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.aXG() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.aXH());
            if (PbSearchEmotionActivity.this.hyR == null) {
                PbSearchEmotionActivity.this.hyR = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hyR.dB(PbSearchEmotionActivity.this.hyS);
                PbSearchEmotionActivity.this.hyR.a(PbSearchEmotionActivity.this.hnA);
                PbSearchEmotionActivity.this.hcG.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hyR);
            } else {
                PbSearchEmotionActivity.this.hyR.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bGd();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hdJ);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bGg();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bGf();
        }
    };
    private final a hnA = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.cZ(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hxR);
                com.baidu.adp.lib.f.c.jB().a(emotionImageData.getPicUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        if (aVar != null) {
                            PbSearchEmotionActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, aVar.isGif(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                        }
                    }
                }, PbSearchEmotionActivity.this.getUniqueId());
            } else {
                PbSearchEmotionActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_SEARCH)));
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
            this.hdQ = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hxR = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hdR = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hyS = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.hdO = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hdR)) {
            this.hdJ.setText(this.hdR);
            zr(this.hdR);
        }
    }

    private void initView() {
        this.hcM = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.hyQ = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.gUO = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hdJ = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.hdJ.setCallback(this);
        this.hyP = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.hdK = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.hcG = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.hcG.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hdJ.setText("");
        this.hdJ.aXO();
        ShowSoftKeyPadDelay(this.hdJ, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bNF();
        bGc();
    }

    private void bGc() {
        this.hdM = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.hdQ == null || this.hdQ.isEmpty()) {
            this.hdM.setVisibility(8);
            return;
        }
        this.hdK.setVisibility(0);
        this.hdK.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.hdQ.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hdQ.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                al.l(textView, d.C0277d.cp_bg_line_e);
                al.j(textView, d.C0277d.cp_cont_f);
                int h = l.h(this.mActivity, d.e.ds16);
                textView.setPadding(h, h, h, h);
                textView.setText(str2);
                textView.setTextSize(0, l.h(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.hdJ.setText(str);
                        PbSearchEmotionActivity.this.hdJ.setSelection(str.length());
                        PbSearchEmotionActivity.this.zr(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hdM.addView(textView);
            }
        }
    }

    private void bNF() {
        this.hyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.kY()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.hdR = str;
            this.hdO.a(str, this.mCurrentPage + 1, 40, this.eHv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGf() {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.hdO.a(this.hdR, this.mCurrentPage + 1, 40, this.eHv);
        }
    }

    private void bGe() {
        this.hdM.setVisibility(0);
        this.hdK.setText(getResources().getString(d.j.hot_emotion));
        this.hdK.setVisibility(0);
        this.hcG.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGd() {
        this.hcG.setVisibility(0);
        this.hdK.setText(getResources().getString(d.j.click_send_emotion));
        this.hdK.setVisibility(0);
        this.hdM.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGg() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hyQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.mActivity, d.e.ds320)), NoDataViewFactory.d.hT(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hdM.setVisibility(8);
        this.hcG.setVisibility(8);
        this.hdK.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.hcM);
        al.k(this.hcM, d.C0277d.cp_bg_line_d);
        al.l(this.gUO, d.C0277d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hdO != null) {
            this.hdO.cancelLoadData();
        }
        if (this.hcG != null) {
            this.hcG.removeAllViewsInLayout();
            this.hcG = null;
        }
        if (this.hyR != null) {
            this.hyR.removeListener();
            this.hyR.bGi();
            this.hyR = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void ue(String str) {
        zr(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void uf(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.hyR != null) {
                this.hyR.notifyDataSetChanged();
            }
            bGe();
        }
    }
}
