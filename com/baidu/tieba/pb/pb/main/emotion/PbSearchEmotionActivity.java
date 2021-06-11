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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.face.SearchEmotionModel;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.AutoLineWrapLayout;
import com.baidu.tieba.face.view.SearchEditView;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.d {
    public static final String EMOTION_BACK_DATA = "emotion_data";
    public static final int EMOTION_NUMS_PER_PAGE = 40;
    public Activity mActivity;
    public String mAuthorShowName;
    public int mCurrentPage;
    public SearchEditView mEditSearchView;
    public d.a.n0.e2.k.e.b1.d mEmotionAdapter;
    public List<EmotionImageData> mEmotionList;
    public BdListView mEmotionListView;
    public boolean mHasMore;
    public List<String> mHotWords;
    public List<String> mKeepImgCacheList;
    public FrameLayout mLayoutContent;
    public AutoLineWrapLayout mLayoutHotWords;
    public LinearLayout mLayoutRoot;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public SearchEmotionModel mSearchModel;
    public String mSearchString;
    public TextView mTvCancel;
    public TextView mTvTips;
    public View mViewLine;
    public final SearchEmotionModel.b mSearchCallback = new c();
    public final BdListView.p mOnScrollToBottomListener = new d();
    public final d.a.n0.e2.k.e.b1.a mOnEmotionChooseListener = new e();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19237e;

        public a(String str) {
            this.f19237e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbSearchEmotionActivity.this.mEditSearchView.setText(this.f19237e);
            PbSearchEmotionActivity.this.mEditSearchView.setSelection(this.f19237e.length());
            PbSearchEmotionActivity.this.searchEmotion(this.f19237e);
            TiebaStatic.log("c12178");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbSearchEmotionActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements SearchEmotionModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, d.a.n0.l0.c.a aVar) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (aVar == null || aVar.a() == null || aVar.a().isEmpty()) {
                if (PbSearchEmotionActivity.this.mCurrentPage == 0) {
                    PbSearchEmotionActivity.this.showNoResult();
                    return;
                }
                return;
            }
            PbSearchEmotionActivity.this.mCurrentPage = aVar.c();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.mEmotionList.clear();
            }
            PbSearchEmotionActivity.this.mHasMore = aVar.b() != 0;
            PbSearchEmotionActivity.this.mEmotionList.addAll(aVar.a());
            if (PbSearchEmotionActivity.this.mEmotionAdapter == null) {
                PbSearchEmotionActivity.this.mEmotionAdapter = new d.a.n0.e2.k.e.b1.d(PbSearchEmotionActivity.this.mEmotionList);
                PbSearchEmotionActivity.this.mEmotionAdapter.h(PbSearchEmotionActivity.this.mKeepImgCacheList);
                PbSearchEmotionActivity.this.mEmotionAdapter.j(PbSearchEmotionActivity.this.mOnEmotionChooseListener);
                PbSearchEmotionActivity.this.mEmotionListView.setAdapter((ListAdapter) PbSearchEmotionActivity.this.mEmotionAdapter);
            } else {
                PbSearchEmotionActivity.this.mEmotionAdapter.notifyDataSetChanged();
            }
            PbSearchEmotionActivity.this.showSearchData();
            l.x(PbSearchEmotionActivity.this.mActivity, PbSearchEmotionActivity.this.mEditSearchView);
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i2, String str) {
            PbSearchEmotionActivity.this.hideProgressBar();
            if (PbSearchEmotionActivity.this.mCurrentPage == 1) {
                PbSearchEmotionActivity.this.showNoResult();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements BdListView.p {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            PbSearchEmotionActivity.this.loadMoreEmotion();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements d.a.n0.e2.k.e.b1.a {

        /* loaded from: classes5.dex */
        public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EmotionImageData f19243a;

            public a(EmotionImageData emotionImageData) {
                this.f19243a = emotionImageData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.l.c
            public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
                if (aVar != null) {
                    PbSearchEmotionActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, this.f19243a, aVar.t(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
                }
            }
        }

        public e() {
        }

        @Override // d.a.n0.e2.k.e.b1.a
        public void a(EmotionImageData emotionImageData, boolean z) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(PbSearchEmotionActivity.this.getPageContext().getPageActivity());
            } else if (!z) {
                emotionImageData.setAuthorNameShow(PbSearchEmotionActivity.this.mAuthorShowName);
                d.a.c.e.l.d.h().m(emotionImageData.getPicUrl(), 10, new a(emotionImageData), PbSearchEmotionActivity.this.getUniqueId());
            } else {
                PbSearchEmotionActivity.this.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(PbSearchEmotionActivity.this.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_SEARCH)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f19245e;

        public f(EmotionImageData emotionImageData) {
            this.f19245e = emotionImageData;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
            PbSearchEmotionActivity.this.sendEmotion(this.f19245e);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    private void initHotWords() {
        this.mLayoutHotWords = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
        List<String> list = this.mHotWords;
        if (list != null && !list.isEmpty()) {
            this.mTvTips.setVisibility(0);
            this.mTvTips.setText(getResources().getString(R.string.hot_emotion));
            int min = Math.min(this.mHotWords.size(), 10);
            for (int i2 = 0; i2 < min; i2++) {
                String str = this.mHotWords.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                    TextView textView = new TextView(this.mActivity);
                    SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
                    int g2 = l.g(this.mActivity, R.dimen.ds16);
                    textView.setPadding(g2, g2, g2, g2);
                    textView.setText(str2);
                    textView.setTextSize(0, l.g(this.mActivity, R.dimen.fontsize24));
                    textView.setSingleLine();
                    textView.setOnClickListener(new a(str));
                    this.mLayoutHotWords.addView(textView);
                }
            }
            return;
        }
        this.mLayoutHotWords.setVisibility(8);
    }

    private void initView() {
        this.mLayoutRoot = (LinearLayout) this.mActivity.findViewById(R.id.layout_root);
        this.mLayoutContent = (FrameLayout) this.mActivity.findViewById(R.id.layout_content);
        this.mViewLine = this.mActivity.findViewById(R.id.view_line);
        NavigationBar navigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.pb_emotion_search_navigation_view, (View.OnClickListener) null);
        SearchEditView searchEditView = (SearchEditView) addCustomView.findViewById(R.id.edit_search_view);
        this.mEditSearchView = searchEditView;
        searchEditView.setCallback(this);
        this.mTvCancel = (TextView) addCustomView.findViewById(R.id.tv_cancel);
        this.mTvTips = (TextView) this.mActivity.findViewById(R.id.tv_tips);
        BdListView bdListView = (BdListView) this.mActivity.findViewById(R.id.listview_emotion);
        this.mEmotionListView = bdListView;
        bdListView.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.mEditSearchView.setText("");
        this.mEditSearchView.f();
        ShowSoftKeyPadDelay(this.mEditSearchView, 200);
        this.mActivity.getWindow().setSoftInputMode(1);
        initViewListener();
        initHotWords();
    }

    private void initViewListener() {
        this.mTvCancel.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMoreEmotion() {
        if (!j.z()) {
            showToast(R.string.neterror);
        } else if (this.mHasMore) {
            showProgressBar();
            this.mSearchModel.x(this.mSearchString, this.mCurrentPage + 1, 40, this.mSearchCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchEmotion(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!j.z()) {
            showToast(R.string.neterror);
            return;
        }
        showProgressBar();
        this.mCurrentPage = 0;
        this.mSearchString = str;
        this.mSearchModel.x(str, 0 + 1, 40, this.mSearchCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEmotion(EmotionImageData emotionImageData) {
        Intent intent = new Intent();
        intent.putExtra(EMOTION_BACK_DATA, emotionImageData);
        setResult(-1, intent);
        finish();
    }

    private void sendEmotionWithDialog(EmotionImageData emotionImageData) {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.mActivity);
        aVar.setMessage(getResources().getString(R.string.confirm_send_emotion));
        aVar.setPositiveButton(R.string.confirm, new f(emotionImageData));
        aVar.setNegativeButton(R.string.cancel, new g());
        aVar.create(getPageContext()).show();
    }

    private void showHotWords() {
        this.mLayoutHotWords.setVisibility(0);
        this.mTvTips.setText(getResources().getString(R.string.hot_emotion));
        this.mTvTips.setVisibility(0);
        this.mEmotionListView.setVisibility(8);
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoResult() {
        if (this.mNoDataView == null) {
            NoDataView a2 = NoDataViewFactory.a(this.mActivity, this.mLayoutContent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.mActivity, R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_search_emotion), null);
            this.mNoDataView = a2;
            a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        this.mNoDataView.setVisibility(0);
        this.mLayoutHotWords.setVisibility(8);
        this.mEmotionListView.setVisibility(8);
        this.mTvTips.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSearchData() {
        this.mEmotionListView.setVisibility(0);
        this.mTvTips.setText(getResources().getString(R.string.click_send_emotion));
        this.mTvTips.setVisibility(0);
        this.mLayoutHotWords.setVisibility(8);
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Serializable serializableExtra;
        EmotionImageData emotionImageData;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 25023 && (serializableExtra = intent.getSerializableExtra(EMOTION_BACK_DATA)) != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
            sendEmotion(emotionImageData);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.mLayoutRoot);
        SkinManager.setBackgroundResource(this.mLayoutRoot, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.mViewLine, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onClickSearch(String str) {
        searchEmotion(str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_search_emotion_layout);
        this.mActivity = getPageContext().getPageActivity();
        setSwipeBackEnabled(false);
        Intent intent = getIntent();
        if (intent != null) {
            this.mHotWords = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.TOP_WORDS);
            this.mAuthorShowName = intent.getStringExtra(PbSearchEmotionActivityConfig.AUTHOR_SHOW_NAME);
            this.mSearchString = intent.getStringExtra(PbSearchEmotionActivityConfig.CURRENT_QUERY_WORD);
            this.mKeepImgCacheList = intent.getStringArrayListExtra(PbSearchEmotionActivityConfig.KEEP_IMG_CACHE_LIST);
        }
        initView();
        this.mSearchModel = new SearchEmotionModel();
        this.mCurrentPage = 1;
        this.mEmotionList = new ArrayList();
        if (TextUtils.isEmpty(this.mSearchString)) {
            return;
        }
        this.mEditSearchView.setText(this.mSearchString);
        searchEmotion(this.mSearchString);
    }

    public void onDeleteAll() {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SearchEmotionModel searchEmotionModel = this.mSearchModel;
        if (searchEmotionModel != null) {
            searchEmotionModel.cancelLoadData();
        }
        BdListView bdListView = this.mEmotionListView;
        if (bdListView != null) {
            bdListView.removeAllViewsInLayout();
            this.mEmotionListView = null;
        }
        d.a.n0.e2.k.e.b1.d dVar = this.mEmotionAdapter;
        if (dVar != null) {
            dVar.g();
            this.mEmotionAdapter.f();
            this.mEmotionAdapter = null;
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onTextChanged(String str) {
        if (this.mEmotionList == null || str.length() != 0) {
            return;
        }
        this.mEmotionList.clear();
        d.a.n0.e2.k.e.b1.d dVar = this.mEmotionAdapter;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
        showHotWords();
    }
}
