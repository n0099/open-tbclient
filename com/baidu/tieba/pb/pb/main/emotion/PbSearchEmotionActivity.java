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
    private View gUP;
    private BdListView hcH;
    private LinearLayout hcN;
    private SearchEditView hdK;
    private TextView hdL;
    private AutoLineWrapLayout hdN;
    private SearchEmotionModel hdP;
    private List<String> hdR;
    private String hdS;
    private String hxS;
    private TextView hyQ;
    private FrameLayout hyR;
    private d hyS;
    private List<String> hyT;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a eHw = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
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
            if (PbSearchEmotionActivity.this.hyS == null) {
                PbSearchEmotionActivity.this.hyS = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hyS.dB(PbSearchEmotionActivity.this.hyT);
                PbSearchEmotionActivity.this.hyS.a(PbSearchEmotionActivity.this.hnB);
                PbSearchEmotionActivity.this.hcH.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hyS);
            } else {
                PbSearchEmotionActivity.this.hyS.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bGd();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hdK);
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
    private final a hnB = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.cZ(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hxS);
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
            this.hdR = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hxS = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hdS = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hyT = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.hdP = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hdS)) {
            this.hdK.setText(this.hdS);
            zr(this.hdS);
        }
    }

    private void initView() {
        this.hcN = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.hyR = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.gUP = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hdK = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.hdK.setCallback(this);
        this.hyQ = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.hdL = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.hcH = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.hcH.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hdK.setText("");
        this.hdK.aXO();
        ShowSoftKeyPadDelay(this.hdK, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bNF();
        bGc();
    }

    private void bGc() {
        this.hdN = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.hdR == null || this.hdR.isEmpty()) {
            this.hdN.setVisibility(8);
            return;
        }
        this.hdL.setVisibility(0);
        this.hdL.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.hdR.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hdR.get(i);
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
                        PbSearchEmotionActivity.this.hdK.setText(str);
                        PbSearchEmotionActivity.this.hdK.setSelection(str.length());
                        PbSearchEmotionActivity.this.zr(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hdN.addView(textView);
            }
        }
    }

    private void bNF() {
        this.hyQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
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
            this.hdS = str;
            this.hdP.a(str, this.mCurrentPage + 1, 40, this.eHw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGf() {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.hdP.a(this.hdS, this.mCurrentPage + 1, 40, this.eHw);
        }
    }

    private void bGe() {
        this.hdN.setVisibility(0);
        this.hdL.setText(getResources().getString(d.j.hot_emotion));
        this.hdL.setVisibility(0);
        this.hcH.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGd() {
        this.hcH.setVisibility(0);
        this.hdL.setText(getResources().getString(d.j.click_send_emotion));
        this.hdL.setVisibility(0);
        this.hdN.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGg() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hyR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.mActivity, d.e.ds320)), NoDataViewFactory.d.hT(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hdN.setVisibility(8);
        this.hcH.setVisibility(8);
        this.hdL.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.hcN);
        al.k(this.hcN, d.C0277d.cp_bg_line_d);
        al.l(this.gUP, d.C0277d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hdP != null) {
            this.hdP.cancelLoadData();
        }
        if (this.hcH != null) {
            this.hcH.removeAllViewsInLayout();
            this.hcH = null;
        }
        if (this.hyS != null) {
            this.hyS.removeListener();
            this.hyS.bGi();
            this.hyS = null;
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
            if (this.hyS != null) {
                this.hyS.notifyDataSetChanged();
            }
            bGe();
        }
    }
}
