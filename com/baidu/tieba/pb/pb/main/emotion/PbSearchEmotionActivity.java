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
    private View gVb;
    private BdListView hcT;
    private LinearLayout hcZ;
    private SearchEditView hdW;
    private TextView hdX;
    private AutoLineWrapLayout hdZ;
    private SearchEmotionModel heb;
    private List<String> hed;
    private String hee;
    private String hyk;
    private TextView hzi;
    private FrameLayout hzj;
    private d hzk;
    private List<String> hzl;
    private Activity mActivity;
    private int mCurrentPage;
    private List<EmotionImageData> mEmotionList;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private final SearchEmotionModel.a eHN = new SearchEmotionModel.a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.3
        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void a(String str, com.baidu.tieba.face.data.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.aXK() == null || aVar.aXK().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.bGj();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.getPage();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.aXJ() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.aXK());
            if (PbSearchEmotionActivity.this.hzk == null) {
                PbSearchEmotionActivity.this.hzk = new d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.hzk.dE(PbSearchEmotionActivity.this.hzl);
                PbSearchEmotionActivity.this.hzk.a(PbSearchEmotionActivity.this.hnT);
                PbSearchEmotionActivity.this.hcT.setAdapter((ListAdapter) PbSearchEmotionActivity.this.hzk);
            } else {
                PbSearchEmotionActivity.this.hzk.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.bGg();
            l.b(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.hdW);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.a
        public void onFail(int i, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.bGj();
            }
        }
    };
    private final BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.bGi();
        }
    };
    private final a hnT = new a() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.5
        @Override // com.baidu.tieba.pb.pb.main.emotion.a
        public void a(final EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                bc.cZ(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.hyk);
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
            this.hed = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.hyk = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.hee = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.hzl = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.heb = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (!TextUtils.isEmpty(this.hee)) {
            this.hdW.setText(this.hee);
            zt(this.hee);
        }
    }

    private void initView() {
        this.hcZ = (LinearLayout) this.mActivity.findViewById(d.g.layout_root);
        this.hzj = (FrameLayout) this.mActivity.findViewById(d.g.layout_content);
        this.gVb = this.mActivity.findViewById(d.g.view_line);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(d.g.view_navigation_bar);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        this.hdW = (SearchEditView) addCustomView.findViewById(d.g.edit_search_view);
        this.hdW.setCallback(this);
        this.hzi = (TextView) addCustomView.findViewById(d.g.tv_cancel);
        this.hdX = (TextView) this.mActivity.findViewById(d.g.tv_tips);
        this.hcT = (BdListView) this.mActivity.findViewById(d.g.listview_emotion);
        this.hcT.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hdW.setText("");
        this.hdW.aXR();
        ShowSoftKeyPadDelay(this.hdW, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        bNH();
        bGf();
    }

    private void bGf() {
        this.hdZ = (AutoLineWrapLayout) this.mActivity.findViewById(d.g.layout_hot_words);
        if (this.hed == null || this.hed.isEmpty()) {
            this.hdZ.setVisibility(8);
            return;
        }
        this.hdX.setVisibility(0);
        this.hdX.setText(getResources().getString(d.j.hot_emotion));
        int min = Math.min(this.hed.size(), 10);
        for (int i = 0; i < min; i++) {
            final String str = this.hed.get(i);
            if (!TextUtils.isEmpty(str)) {
                String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                TextView textView = new TextView(this.mActivity);
                al.l(textView, d.C0236d.cp_bg_line_e);
                al.j(textView, d.C0236d.cp_cont_f);
                int h = l.h(this.mActivity, d.e.ds16);
                textView.setPadding(h, h, h, h);
                textView.setText(str2);
                textView.setTextSize(0, l.h(this.mActivity, d.e.fontsize24));
                textView.setSingleLine();
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PbSearchEmotionActivity.this.hdW.setText(str);
                        PbSearchEmotionActivity.this.hdW.setSelection(str.length());
                        PbSearchEmotionActivity.this.zt(str);
                        TiebaStatic.log("c12178");
                    }
                });
                this.hdZ.addView(textView);
            }
        }
    }

    private void bNH() {
        this.hzi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbSearchEmotionActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!j.kY()) {
                showToast(d.j.neterror);
                return;
            }
            showProgressBar();
            this.mCurrentPage = 0;
            this.hee = str;
            this.heb.a(str, this.mCurrentPage + 1, 40, this.eHN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGi() {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.heb.a(this.hee, this.mCurrentPage + 1, 40, this.eHN);
        }
    }

    private void bGh() {
        this.hdZ.setVisibility(0);
        this.hdX.setText(getResources().getString(d.j.hot_emotion));
        this.hdX.setVisibility(0);
        this.hcT.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGg() {
        this.hcT.setVisibility(0);
        this.hdX.setText(getResources().getString(d.j.click_send_emotion));
        this.hdX.setVisibility(0);
        this.hdZ.setVisibility(8);
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGj() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mActivity, this.hzj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.mActivity, d.e.ds320)), NoDataViewFactory.d.hU(d.j.no_search_emotion), null);
            this.mNoDataView.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.hdZ.setVisibility(8);
        this.hcT.setVisibility(8);
        this.hdX.setVisibility(8);
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
        getLayoutMode().onModeChanged(this.hcZ);
        al.k(this.hcZ, d.C0236d.cp_bg_line_d);
        al.l(this.gVb, d.C0236d.cp_bg_line_c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.heb != null) {
            this.heb.cancelLoadData();
        }
        if (this.hcT != null) {
            this.hcT.removeAllViewsInLayout();
            this.hcT = null;
        }
        if (this.hzk != null) {
            this.hzk.removeListener();
            this.hzk.bGl();
            this.hzk = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void ug(String str) {
        zt(str);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.a
    public void uh(String str) {
        if (this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            if (this.hzk != null) {
                this.hzk.notifyDataSetChanged();
            }
            bGh();
        }
    }
}
