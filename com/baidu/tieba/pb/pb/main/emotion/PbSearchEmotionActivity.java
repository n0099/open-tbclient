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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.q0.r.t.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionEditActivityConfig;
import com.baidu.tbadk.core.atomData.PbSearchEmotionActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMOTION_BACK_DATA = "emotion_data";
    public static final int EMOTION_NUMS_PER_PAGE = 40;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public String mAuthorShowName;
    public int mCurrentPage;
    public SearchEditView mEditSearchView;
    public c.a.r0.u2.k.f.d1.d mEmotionAdapter;
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
    public final c.a.r0.u2.k.f.d1.a mOnEmotionChooseListener;
    public final BdListView.p mOnScrollToBottomListener;
    public final SearchEmotionModel.b mSearchCallback;
    public SearchEmotionModel mSearchModel;
    public String mSearchString;
    public TextView mTvCancel;
    public TextView mTvTips;
    public View mViewLine;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45221e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbSearchEmotionActivity f45222f;

        public a(PbSearchEmotionActivity pbSearchEmotionActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45222f = pbSearchEmotionActivity;
            this.f45221e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45222f.mEditSearchView.setText(this.f45221e);
                this.f45222f.mEditSearchView.setSelection(this.f45221e.length());
                this.f45222f.searchEmotion(this.f45221e);
                TiebaStatic.log("c12178");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbSearchEmotionActivity f45223e;

        public b(PbSearchEmotionActivity pbSearchEmotionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45223e = pbSearchEmotionActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45223e.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements SearchEmotionModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbSearchEmotionActivity a;

        public c(PbSearchEmotionActivity pbSearchEmotionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbSearchEmotionActivity;
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, c.a.r0.x0.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
                this.a.hideProgressBar();
                if (aVar == null || aVar.a() == null || aVar.a().isEmpty()) {
                    if (this.a.mCurrentPage == 0) {
                        this.a.showNoResult();
                        return;
                    }
                    return;
                }
                this.a.mCurrentPage = aVar.c();
                if (this.a.mCurrentPage == 1) {
                    this.a.mEmotionList.clear();
                }
                this.a.mHasMore = aVar.b() != 0;
                this.a.mEmotionList.addAll(aVar.a());
                if (this.a.mEmotionAdapter == null) {
                    this.a.mEmotionAdapter = new c.a.r0.u2.k.f.d1.d(this.a.mEmotionList);
                    this.a.mEmotionAdapter.h(this.a.mKeepImgCacheList);
                    this.a.mEmotionAdapter.j(this.a.mOnEmotionChooseListener);
                    this.a.mEmotionListView.setAdapter((ListAdapter) this.a.mEmotionAdapter);
                } else {
                    this.a.mEmotionAdapter.notifyDataSetChanged();
                }
                this.a.showSearchData();
                n.w(this.a.mActivity, this.a.mEditSearchView);
            }
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.a.hideProgressBar();
                if (this.a.mCurrentPage == 1) {
                    this.a.showNoResult();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbSearchEmotionActivity f45224e;

        public d(PbSearchEmotionActivity pbSearchEmotionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45224e = pbSearchEmotionActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45224e.loadMoreEmotion();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements c.a.r0.u2.k.f.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbSearchEmotionActivity a;

        /* loaded from: classes6.dex */
        public class a extends c.a.d.f.l.c<c.a.d.o.d.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmotionImageData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f45225b;

            public a(e eVar, EmotionImageData emotionImageData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, emotionImageData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45225b = eVar;
                this.a = emotionImageData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.d.f.l.c
            public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null) {
                    return;
                }
                this.f45225b.a.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(this.f45225b.a.getPageContext().getPageActivity(), 25023, this.a, aVar.t(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
            }
        }

        public e(PbSearchEmotionActivity pbSearchEmotionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbSearchEmotionActivity;
        }

        @Override // c.a.r0.u2.k.f.d1.a
        public void a(EmotionImageData emotionImageData, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, emotionImageData, z) == null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity());
                } else if (!z) {
                    emotionImageData.setAuthorNameShow(this.a.mAuthorShowName);
                    c.a.d.f.l.d.h().m(emotionImageData.getPicUrl(), 10, new a(this, emotionImageData), this.a.getUniqueId());
                } else {
                    this.a.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(this.a.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_SEARCH)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionImageData f45226e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbSearchEmotionActivity f45227f;

        public f(PbSearchEmotionActivity pbSearchEmotionActivity, EmotionImageData emotionImageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity, emotionImageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45227f = pbSearchEmotionActivity;
            this.f45226e = emotionImageData;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f45227f.sendEmotion(this.f45226e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbSearchEmotionActivity f45228e;

        public g(PbSearchEmotionActivity pbSearchEmotionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45228e = pbSearchEmotionActivity;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public PbSearchEmotionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSearchCallback = new c(this);
        this.mOnScrollToBottomListener = new d(this);
        this.mOnEmotionChooseListener = new e(this);
    }

    private void initHotWords() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.mLayoutHotWords = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.layout_hot_words);
            List<String> list = this.mHotWords;
            if (list != null && !list.isEmpty()) {
                this.mTvTips.setVisibility(0);
                this.mTvTips.setText(getResources().getString(R.string.hot_emotion));
                int min = Math.min(this.mHotWords.size(), 10);
                for (int i2 = 0; i2 < min; i2++) {
                    String str = this.mHotWords.get(i2);
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = str.length() > 20 ? str.substring(0, 20) + "..." : str;
                        TextView textView = new TextView(this.mActivity);
                        SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
                        int f2 = n.f(this.mActivity, R.dimen.ds16);
                        textView.setPadding(f2, f2, f2, f2);
                        textView.setText(str2);
                        textView.setTextSize(0, n.f(this.mActivity, R.dimen.fontsize24));
                        textView.setSingleLine();
                        textView.setOnClickListener(new a(this, str));
                        this.mLayoutHotWords.addView(textView);
                    }
                }
                return;
            }
            this.mLayoutHotWords.setVisibility(8);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
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
            this.mEditSearchView.requestEditFocus();
            ShowSoftKeyPadDelay(this.mEditSearchView, 200);
            this.mActivity.getWindow().setSoftInputMode(1);
            initViewListener();
            initHotWords();
        }
    }

    private void initViewListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.mTvCancel.setOnClickListener(new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMoreEmotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (!l.z()) {
                showToast(R.string.neterror);
            } else if (this.mHasMore) {
                showProgressBar();
                this.mSearchModel.x(this.mSearchString, this.mCurrentPage + 1, 40, this.mSearchCallback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchEmotion(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!l.z()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, emotionImageData) == null) {
            Intent intent = new Intent();
            intent.putExtra(EMOTION_BACK_DATA, emotionImageData);
            setResult(-1, intent);
            finish();
        }
    }

    private void sendEmotionWithDialog(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, emotionImageData) == null) {
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(this.mActivity);
            aVar.setMessage(getResources().getString(R.string.confirm_send_emotion));
            aVar.setPositiveButton(R.string.confirm, new f(this, emotionImageData));
            aVar.setNegativeButton(R.string.cancel, new g(this));
            aVar.create(getPageContext()).show();
        }
    }

    private void showHotWords() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.mLayoutHotWords.setVisibility(0);
            this.mTvTips.setText(getResources().getString(R.string.hot_emotion));
            this.mTvTips.setVisibility(0);
            this.mEmotionListView.setVisibility(8);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoResult() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            if (this.mNoDataView == null) {
                NoDataView a2 = NoDataViewFactory.a(this.mActivity, this.mLayoutContent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(this.mActivity, R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_search_emotion), null);
                this.mNoDataView = a2;
                a2.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            this.mNoDataView.setVisibility(0);
            this.mLayoutHotWords.setVisibility(8);
            this.mEmotionListView.setVisibility(8);
            this.mTvTips.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSearchData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            this.mEmotionListView.setVisibility(0);
            this.mTvTips.setText(getResources().getString(R.string.click_send_emotion));
            this.mTvTips.setVisibility(0);
            this.mLayoutHotWords.setVisibility(8);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Serializable serializableExtra;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 25023 && (serializableExtra = intent.getSerializableExtra(EMOTION_BACK_DATA)) != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                sendEmotion(emotionImageData);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mLayoutRoot);
            SkinManager.setBackgroundResource(this.mLayoutRoot, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.mViewLine, R.color.CAM_X0204);
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onClickSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            searchEmotion(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
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
    }

    public void onDeleteAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
            c.a.r0.u2.k.f.d1.d dVar = this.mEmotionAdapter;
            if (dVar != null) {
                dVar.g();
                this.mEmotionAdapter.f();
                this.mEmotionAdapter = null;
            }
        }
    }

    @Override // com.baidu.tieba.face.view.SearchEditView.d
    public void onTextChanged(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && this.mEmotionList != null && str.length() == 0) {
            this.mEmotionList.clear();
            c.a.r0.u2.k.f.d1.d dVar = this.mEmotionAdapter;
            if (dVar != null) {
                dVar.notifyDataSetChanged();
            }
            showHotWords();
        }
    }
}
