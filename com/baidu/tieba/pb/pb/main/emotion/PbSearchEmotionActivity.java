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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.cx7;
import com.repackage.fo;
import com.repackage.fx7;
import com.repackage.hg;
import com.repackage.ig;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.v86;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PbSearchEmotionActivity extends BaseActivity implements SearchEditView.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMOTION_BACK_DATA = "emotion_data";
    public static final int EMOTION_NUMS_PER_PAGE = 40;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public String mAuthorShowName;
    public int mCurrentPage;
    public SearchEditView mEditSearchView;
    public fx7 mEmotionAdapter;
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
    public final cx7 mOnEmotionChooseListener;
    public final BdListView.p mOnScrollToBottomListener;
    public final SearchEmotionModel.b mSearchCallback;
    public SearchEmotionModel mSearchModel;
    public String mSearchString;
    public TextView mTvCancel;
    public TextView mTvTips;
    public View mViewLine;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PbSearchEmotionActivity b;

        public a(PbSearchEmotionActivity pbSearchEmotionActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbSearchEmotionActivity;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.mEditSearchView.setText(this.a);
                this.b.mEditSearchView.setSelection(this.a.length());
                this.b.searchEmotion(this.a);
                TiebaStatic.log("c12178");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbSearchEmotionActivity a;

        public b(PbSearchEmotionActivity pbSearchEmotionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbSearchEmotionActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbSearchEmotionActivity;
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void a(String str, v86 v86Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, v86Var) == null) {
                this.a.hideProgressBar();
                if (v86Var == null || v86Var.a() == null || v86Var.a().isEmpty()) {
                    if (this.a.mCurrentPage == 0) {
                        this.a.showNoResult();
                        return;
                    }
                    return;
                }
                this.a.mCurrentPage = v86Var.c();
                if (this.a.mCurrentPage == 1) {
                    this.a.mEmotionList.clear();
                }
                this.a.mHasMore = v86Var.b() != 0;
                this.a.mEmotionList.addAll(v86Var.a());
                if (this.a.mEmotionAdapter == null) {
                    this.a.mEmotionAdapter = new fx7(this.a.mEmotionList);
                    this.a.mEmotionAdapter.h(this.a.mKeepImgCacheList);
                    this.a.mEmotionAdapter.j(this.a.mOnEmotionChooseListener);
                    this.a.mEmotionListView.setAdapter((ListAdapter) this.a.mEmotionAdapter);
                } else {
                    this.a.mEmotionAdapter.notifyDataSetChanged();
                }
                this.a.showSearchData();
                oi.w(this.a.mActivity, this.a.mEditSearchView);
            }
        }

        @Override // com.baidu.tieba.face.SearchEmotionModel.b
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.hideProgressBar();
                if (this.a.mCurrentPage == 1) {
                    this.a.showNoResult();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbSearchEmotionActivity a;

        public d(PbSearchEmotionActivity pbSearchEmotionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbSearchEmotionActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.loadMoreEmotion();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements cx7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbSearchEmotionActivity a;

        /* loaded from: classes3.dex */
        public class a extends hg<fo> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmotionImageData a;
            public final /* synthetic */ e b;

            public a(e eVar, EmotionImageData emotionImageData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, emotionImageData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = emotionImageData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.hg
            public void onLoaded(fo foVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) || foVar == null) {
                    return;
                }
                this.b.a.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(this.b.a.getPageContext().getPageActivity(), 25023, this.a, foVar.t(), EmotionEditActivityConfig.FROM_PB_BOTTOM)));
            }
        }

        public e(PbSearchEmotionActivity pbSearchEmotionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbSearchEmotionActivity;
        }

        @Override // com.repackage.cx7
        public void a(EmotionImageData emotionImageData, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, emotionImageData, z) == null) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity());
                } else if (!z) {
                    emotionImageData.setAuthorNameShow(this.a.mAuthorShowName);
                    ig.h().m(emotionImageData.getPicUrl(), 10, new a(this, emotionImageData), this.a.getUniqueId());
                } else {
                    this.a.sendMessage(new CustomMessage(2002001, new EmotionEditActivityConfig(this.a.getPageContext().getPageActivity(), 25023, emotionImageData, z, EmotionEditActivityConfig.FROM_PB_SEARCH)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionImageData a;
        public final /* synthetic */ PbSearchEmotionActivity b;

        public f(PbSearchEmotionActivity pbSearchEmotionActivity, EmotionImageData emotionImageData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity, emotionImageData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbSearchEmotionActivity;
            this.a = emotionImageData;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                this.b.sendEmotion(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbSearchEmotionActivity a;

        public g(PbSearchEmotionActivity pbSearchEmotionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbSearchEmotionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbSearchEmotionActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    public PbSearchEmotionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.mLayoutHotWords = (AutoLineWrapLayout) this.mActivity.findViewById(R.id.obfuscated_res_0x7f0911d5);
            List<String> list = this.mHotWords;
            if (list != null && !list.isEmpty()) {
                this.mTvTips.setVisibility(0);
                this.mTvTips.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0858));
                int min = Math.min(this.mHotWords.size(), 10);
                for (int i = 0; i < min; i++) {
                    String str = this.mHotWords.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = str.length() > 20 ? str.substring(0, 20) + StringHelper.STRING_MORE : str;
                        TextView textView = new TextView(this.mActivity);
                        SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
                        int f2 = oi.f(this.mActivity, R.dimen.obfuscated_res_0x7f0701be);
                        textView.setPadding(f2, f2, f2, f2);
                        textView.setText(str2);
                        textView.setTextSize(0, oi.f(this.mActivity, R.dimen.obfuscated_res_0x7f0702b3));
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
            this.mLayoutRoot = (LinearLayout) this.mActivity.findViewById(R.id.obfuscated_res_0x7f0911eb);
            this.mLayoutContent = (FrameLayout) this.mActivity.findViewById(R.id.obfuscated_res_0x7f0911c8);
            this.mViewLine = this.mActivity.findViewById(R.id.obfuscated_res_0x7f0923a6);
            NavigationBar navigationBar = (NavigationBar) this.mActivity.findViewById(R.id.obfuscated_res_0x7f0923ac);
            this.mNavigationBar = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d0678, (View.OnClickListener) null);
            SearchEditView searchEditView = (SearchEditView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090869);
            this.mEditSearchView = searchEditView;
            searchEditView.setCallback(this);
            this.mTvCancel = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f092172);
            this.mTvTips = (TextView) this.mActivity.findViewById(R.id.obfuscated_res_0x7f092201);
            BdListView bdListView = (BdListView) this.mActivity.findViewById(R.id.obfuscated_res_0x7f09127d);
            this.mEmotionListView = bdListView;
            bdListView.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
            this.mEditSearchView.setText("");
            this.mEditSearchView.f();
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
            if (!mi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c17);
            } else if (this.mHasMore) {
                showProgressBar();
                this.mSearchModel.z(this.mSearchString, this.mCurrentPage + 1, 40, this.mSearchCallback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchEmotion(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!mi.z()) {
            showToast(R.string.obfuscated_res_0x7f0f0c17);
            return;
        }
        showProgressBar();
        this.mCurrentPage = 0;
        this.mSearchString = str;
        this.mSearchModel.z(str, 0 + 1, 40, this.mSearchCallback);
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
            cr4 cr4Var = new cr4(this.mActivity);
            cr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0428));
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0421, new f(this, emotionImageData));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new g(this));
            cr4Var.create(getPageContext()).show();
        }
    }

    private void showHotWords() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            this.mLayoutHotWords.setVisibility(0);
            this.mTvTips.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0858));
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
                NoDataView a2 = NoDataViewFactory.a(this.mActivity, this.mLayoutContent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, oi.f(this.mActivity, R.dimen.obfuscated_res_0x7f0702a1)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c5b), null);
                this.mNoDataView = a2;
                a2.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
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
            this.mTvTips.setText(getResources().getString(R.string.obfuscated_res_0x7f0f03e4));
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
    public void onActivityResult(int i, int i2, Intent intent) {
        Serializable serializableExtra;
        EmotionImageData emotionImageData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25023 && (serializableExtra = intent.getSerializableExtra(EMOTION_BACK_DATA)) != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                sendEmotion(emotionImageData);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            getLayoutMode().k(i == 1);
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
            setContentView(R.layout.obfuscated_res_0x7f0d069f);
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
            fx7 fx7Var = this.mEmotionAdapter;
            if (fx7Var != null) {
                fx7Var.g();
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
            fx7 fx7Var = this.mEmotionAdapter;
            if (fx7Var != null) {
                fx7Var.notifyDataSetChanged();
            }
            showHotWords();
        }
    }
}
