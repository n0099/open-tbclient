package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.q;
import d.a.q0.a4.u.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class AtListActivity extends SuspendedActivity implements d.a.p0.v0.a, AdapterView.OnItemClickListener, a.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_AT = "0";
    public static final String FROM_BJH = "2";
    public static final String FROM_CHAT = "1";
    public static final int NOFRIEND_MODE_ATSUGGEST = 1;
    public static final int NOFRIEND_MODE_FRIENDLIST = 2;
    public static final int NOFRIEND_MODE_NO = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int MAX_SELECT_COUNTS;
    public boolean isForBjh;
    public boolean isForChat;
    public boolean isNeedMultiple;
    public d.a.q0.a4.u.a mAdapter;
    public Button mButtonPost;
    public LinearLayout mCandidateContainer;
    public AtSelectFriendList mCandidateList;
    public RelativeLayout mContainer;
    public LinearLayout mContentView;
    public TextView mDelete;
    public View mDivLine;
    public EditText mEditText;
    public ArrayList<MetaData> mFriendList;
    public l mFriendListTask;
    public final Handler mHandler;
    public View mListFooter;
    public BdListView mListView;
    public d.a.q0.a4.n.a mModel;
    public View mNaviSearchEditView;
    public View mNaviSearchFindView;
    public TextView mNaviTitleTV;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public RelativeLayout mParent;
    public String mPreEditString;
    public Intent mResultIntent;
    public ImageView mSearchImageView;
    public final Runnable mSuggestRunnable;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22871e;

        public a(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22871e = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22871e.mEditText.getText().clear();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22872e;

        public b(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22872e = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22872e.mListView.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22873e;

        public c(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22873e = atListActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AtListActivity atListActivity = this.f22873e;
                atListActivity.requestSuggestData(d.a.d.e.p.k.charSequence2String(atListActivity.mEditText.getText(), ""));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22874e;

        public d(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22874e = atListActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    d.a.d.e.p.l.x(this.f22874e.getPageContext().getPageActivity(), this.f22874e.mEditText);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22875a;

        public e(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22875a = atListActivity;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) && (obj instanceof MetaData)) {
                if (z) {
                    if (5 > this.f22875a.mCandidateList.getItemLength()) {
                        this.f22875a.addCandidate((MetaData) obj);
                        return;
                    }
                    AtListActivity atListActivity = this.f22875a;
                    atListActivity.showToastWithIcon(String.format(atListActivity.getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.f22875a.removeCandidate((MetaData) obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22876e;

        public f(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22876e = atListActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    d.a.d.e.p.l.x(this.f22876e.getPageContext().getPageActivity(), this.f22876e.mEditText);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22877e;

        public g(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22877e = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22877e.mResultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("name_show", this.f22877e.mCandidateList.getDataList());
                this.f22877e.mResultIntent.putExtras(bundle);
                d.a.d.e.p.l.x(this.f22877e.getPageContext().getPageActivity(), this.f22877e.mEditText);
                this.f22877e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements AtSelectFriendList.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22878a;

        public h(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22878a = atListActivity;
        }

        @Override // com.baidu.tieba.write.write.AtSelectFriendList.b
        public void a(View view, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, obj) == null) || obj == null) {
                return;
            }
            if (obj instanceof TbCheckBox.c) {
                ((TbCheckBox.c) obj).setChecked(false);
            }
            View findViewWithTag = this.f22878a.mListView.findViewWithTag(obj);
            if (findViewWithTag instanceof TbCheckBox) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof MetaData) {
                this.f22878a.removeCandidate((MetaData) obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22879e;

        public i(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22879e = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22879e.mNaviTitleTV.setVisibility(8);
                this.f22879e.mNaviSearchFindView.setVisibility(8);
                this.f22879e.mNaviSearchEditView.setVisibility(0);
                this.f22879e.mEditText.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22880e;

        public j(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22880e = atListActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (charSequence2String = d.a.d.e.p.k.charSequence2String(editable, null)) == null) {
                return;
            }
            if (!charSequence2String.equals(this.f22880e.mPreEditString)) {
                this.f22880e.mHandler.removeCallbacks(this.f22880e.mSuggestRunnable);
                this.f22880e.mHandler.postDelayed(this.f22880e.mSuggestRunnable, 300L);
            }
            if (charSequence2String.length() > 0) {
                this.f22880e.mDelete.setVisibility(0);
            } else {
                this.f22880e.mDelete.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                this.f22880e.mPreEditString = d.a.d.e.p.k.charSequence2String(charSequence, null);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22881e;

        public k(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22881e = atListActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (!z) {
                    d.a.d.e.p.l.x(this.f22881e.getPageContext().getPageActivity(), view);
                } else {
                    d.a.d.e.p.l.K(this.f22881e.getPageContext().getPageActivity(), view);
                }
            }
        }
    }

    public AtListActivity() {
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
        this.mFriendList = new ArrayList<>();
        this.mListView = null;
        this.mFriendListTask = null;
        this.mModel = null;
        this.mAdapter = null;
        this.mPreEditString = null;
        this.mParent = null;
        this.mDivLine = null;
        this.MAX_SELECT_COUNTS = 5;
        this.isNeedMultiple = true;
        this.isForChat = false;
        this.isForBjh = false;
        this.mHandler = new Handler();
        this.mSuggestRunnable = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCandidate(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65563, this, metaData) == null) || metaData == null) {
            return;
        }
        this.mCandidateList.e(metaData);
        setCandidateCount(this.mCandidateList.getItemLength());
        setPostButtonState();
    }

    private void addListViewFooter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds80) + getResources().getDimensionPixelSize(R.dimen.ds16) + getResources().getDimensionPixelSize(R.dimen.ds16);
            View view = new View(getPageContext().getContext());
            this.mListFooter = view;
            view.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            this.mListFooter.setFocusable(false);
            this.mListFooter.setFocusableInTouchMode(false);
            this.mListFooter.setContentDescription("");
            this.mListFooter.setVisibility(4);
            this.mListFooter.setBackgroundColor(0);
            this.mListFooter.setOnClickListener(new b(this));
            this.mListView.addFooterView(this.mListFooter);
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, bundle) == null) {
            this.mModel = new d.a.q0.a4.n.a();
            if (bundle != null) {
                this.isNeedMultiple = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
                this.isForChat = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
                this.isForBjh = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
                return;
            }
            this.isNeedMultiple = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
            this.isForChat = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
            this.isForBjh = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            this.mNaviTitleTV = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new i(this));
            this.mNaviSearchFindView = addCustomView;
            this.mSearchImageView = (ImageView) addCustomView.findViewById(R.id.new_friend_search);
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
            this.mNaviSearchEditView = addCustomView2;
            addCustomView2.setVisibility(8);
            EditText editText = (EditText) this.mNaviSearchEditView.findViewById(R.id.search_bar_edit);
            this.mEditText = editText;
            editText.addTextChangedListener(new j(this));
            this.mEditText.setOnFocusChangeListener(new k(this));
            TextView textView = (TextView) findViewById(R.id.search_bar_delete_button);
            this.mDelete = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.mParent = (RelativeLayout) findViewById(R.id.parent);
            this.mNoDataView = NoDataViewFactory.b(getPageContext().getContext(), this.mParent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, d.a.d.e.p.l.g(getActivity(), R.dimen.ds320)), NoDataViewFactory.e.d(null, getResources().getString(R.string.no_chat_friends)), null, true);
            this.mDivLine = findViewById(R.id.at_candidate_border);
            this.mNoDataView.setOnTouchListener(new d(this));
            initNavigationBar();
            this.mContainer = (RelativeLayout) findViewById(R.id.container);
            this.mListView = (BdListView) findViewById(R.id.list);
            d.a.q0.a4.u.a aVar = new d.a.q0.a4.u.a(this, this.isNeedMultiple);
            this.mAdapter = aVar;
            aVar.f(this);
            this.mAdapter.d(new e(this));
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            this.mListView.setOnItemClickListener(this);
            this.mListView.setOnTouchListener(new f(this));
            if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
                ((View) this.mEditText.getParent()).setFocusable(true);
                ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
            }
            this.mCandidateContainer = (LinearLayout) this.mParent.findViewById(R.id.invite_candidate);
            Button button = (Button) this.mParent.findViewById(R.id.button_send);
            this.mButtonPost = button;
            button.setOnClickListener(new g(this));
            setCandidateCount(0);
            AtSelectFriendList atSelectFriendList = (AtSelectFriendList) this.mParent.findViewById(R.id.candidate_list);
            this.mCandidateList = atSelectFriendList;
            atSelectFriendList.setMaxCount(5);
            this.mCandidateList.setItemOPerationHandler(new h(this));
            addListViewFooter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCandidate(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, this, metaData) == null) || metaData == null) {
            return;
        }
        this.mCandidateList.k(metaData);
        setCandidateCount(this.mCandidateList.getItemLength());
        setPostButtonState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSuggestData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65569, this, str) == null) || isFinishing()) {
            return;
        }
        showLoadingView(this.mContainer);
        ArrayList<MetaData> arrayList = null;
        this.mAdapter.e(null);
        if (!ListUtils.isEmpty(this.mFriendList)) {
            if (str != null && str.length() != 0) {
                arrayList = new ArrayList<>();
                Iterator<MetaData> it = this.mFriendList.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getName_show() != null && next.getName_show().contains(str)) {
                        arrayList.add(next);
                    }
                }
            } else {
                arrayList = this.mFriendList;
            }
        }
        hideLoadingView(this.mContainer);
        if (!ListUtils.isEmpty(arrayList)) {
            setNoFriends(0);
        } else {
            setNoFriends(1);
        }
        this.mAdapter.e(arrayList);
        this.mAdapter.notifyDataSetInvalidated();
        this.mListView.setSelection(0);
    }

    private void setCandidateCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, this, i2) == null) {
            this.mButtonPost.setText(String.format(getPageContext().getString(R.string.at_friend_candidate_send), Integer.valueOf(i2), 5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoFriends(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65571, this, i2) == null) {
            if (i2 == 2) {
                this.mListView.setVisibility(8);
                hideNetRefreshView(this.mContainer);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.no_chat_friends)));
                this.mCandidateContainer.setVisibility(8);
            } else if (i2 == 1) {
                this.mListView.setVisibility(8);
                hideNetRefreshView(this.mContainer);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.no_search_friends)));
                this.mCandidateContainer.setVisibility(8);
            } else if (i2 == 0) {
                this.mListView.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                if (this.isNeedMultiple) {
                    this.mCandidateContainer.setVisibility(0);
                }
            }
        }
    }

    private void setPostButtonState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            if (this.mCandidateList.getItemLength() > 0) {
                this.mButtonPost.setEnabled(true);
            } else {
                this.mButtonPost.setEnabled(false);
            }
        }
    }

    @Override // d.a.p0.v0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mResultIntent : (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public d.a.p0.v0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, navigationBar)) == null) {
            this.mContentView = linearLayout;
            this.mNavigationBar = navigationBar;
            LayoutInflater.from(this).inflate(R.layout.at_list_activity, (ViewGroup) this.mContentView, true);
            return this;
        }
        return (d.a.p0.v0.a) invokeLL.objValue;
    }

    @Override // d.a.q0.a4.u.a.c
    public void handlerItem(View view, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, metaData) == null) || metaData == null) {
            return;
        }
        this.mCandidateList.g(metaData);
    }

    @Override // d.a.p0.v0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.d.e.p.l.x(getPageContext().getPageActivity(), this.mEditText);
            View view = this.mNaviSearchEditView;
            if (view == null || view.getVisibility() != 0) {
                return true;
            }
            this.mNaviSearchEditView.setVisibility(8);
            this.mNaviTitleTV.setVisibility(0);
            this.mNaviSearchFindView.setVisibility(0);
            this.mEditText.getText().clear();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.v0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BdListView bdListView = this.mListView;
            return bdListView != null && bdListView.getFirstVisiblePosition() == 0 && (childAt = this.mListView.getChildAt(0)) != null && childAt.getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mParent);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            this.mAdapter.notifyDataSetChanged();
            SkinManager.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
            SkinManager.setBackgroundResource(this.mButtonPost, R.drawable.post_button_bg);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.mButtonPost);
            d2.n(R.string.J_X03);
            d2.f(R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.mButtonPost, R.color.CAM_X0101, 3);
            this.mSearchImageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            SkinManager.setViewTextColor(this.mContainer, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            initData(bundle);
            initUI();
            requestData();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            l lVar = this.mFriendListTask;
            if (lVar != null) {
                lVar.cancel();
            }
            this.mHandler.removeCallbacks(this.mSuggestRunnable);
            hideLoadingView(this.mContainer);
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdListView bdListView = this.mListView;
            if (bdListView == null) {
                return null;
            }
            return bdListView.getPreLoadHandle();
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.onItemClick(adapterView, view, i2, j2);
            MetaData item = this.mAdapter.getItem(i2);
            if (item == null) {
                return;
            }
            if (this.isNeedMultiple) {
                if (this.mFriendListTask != null) {
                    return;
                }
                if (item.isChecked()) {
                    removeCandidate(item);
                } else if (5 <= this.mCandidateList.getItemLength()) {
                    showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                    return;
                } else {
                    addCandidate(item);
                }
                item.setChecked(!item.isChecked());
                this.mAdapter.notifyDataSetChanged();
                return;
            }
            d.a.d.e.p.l.x(getPageContext().getPageActivity(), this.mEditText);
            if (this.isForChat) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new StatisticItem("c12930").param("obj_id", item.getUserIdLong()));
            }
            if (this.isForBjh) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921427, new d.a.p0.u.b(item.getUk(), item.getName_show())));
            }
            this.mResultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.mResultIntent.putExtras(bundle);
            finish();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onNetRefreshButtonClicked();
            if (d.a.d.e.p.l.D()) {
                requestData();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStart();
            this.mNoDataView.d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStop();
            this.mNoDataView.e();
        }
    }

    @Override // d.a.p0.v0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || isFinishing()) {
            return;
        }
        this.mAdapter.e(null);
        if (this.mModel.a() != null) {
            ArrayList<MetaData> a2 = this.mModel.a().a();
            Iterator<MetaData> it = a2.iterator();
            while (it.hasNext()) {
                it.next().setChecked(false);
            }
            if (!ListUtils.isEmpty(a2)) {
                setNoFriends(0);
            } else {
                setNoFriends(1);
            }
            this.mAdapter.e(a2);
        } else {
            this.mAdapter.e(null);
            if (this.mFriendListTask == null) {
                l lVar = new l(this, null);
                this.mFriendListTask = lVar;
                lVar.setPriority(3);
                this.mFriendListTask.execute("");
            }
        }
        this.mAdapter.notifyDataSetInvalidated();
        this.mListView.setSelection(0);
    }

    /* loaded from: classes4.dex */
    public class l extends BdAsyncTask<String, Integer, d.a.q0.a4.l.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f22882a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtListActivity f22883b;

        public l(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22883b = atListActivity;
            this.f22882a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.a.q0.a4.l.b doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                NetWork netWork = new NetWork();
                this.f22882a = netWork;
                netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                if (!this.f22883b.isForChat) {
                    if (this.f22883b.isForBjh) {
                        this.f22882a.addPostData("from", "2");
                    } else {
                        this.f22882a.addPostData("from", "0");
                    }
                } else {
                    this.f22882a.addPostData("from", "1");
                }
                String postNetData = this.f22882a.postNetData();
                if (this.f22882a.getNetContext().getResponse().isRequestSuccess()) {
                    d.a.q0.a4.l.b bVar = new d.a.q0.a4.l.b();
                    bVar.b(postNetData);
                    return bVar;
                }
                return null;
            }
            return (d.a.q0.a4.l.b) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.a.q0.a4.l.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                this.f22883b.mFriendListTask = null;
                AtListActivity atListActivity = this.f22883b;
                atListActivity.hideLoadingView(atListActivity.mContainer);
                AtListActivity atListActivity2 = this.f22883b;
                atListActivity2.hideNetRefreshView(atListActivity2.mContainer);
                if (this.f22883b.mCandidateContainer != null && this.f22883b.mCandidateContainer.getVisibility() == 0) {
                    this.f22883b.mDivLine.setVisibility(0);
                }
                if (this.f22882a.getNetContext().getResponse().isRequestSuccess()) {
                    this.f22883b.mModel.b(bVar);
                    if (this.f22883b.mAdapter == null) {
                        return;
                    }
                    if (bVar == null || bVar.a() == null || !bVar.a().isEmpty()) {
                        this.f22883b.setNoFriends(0);
                    } else {
                        this.f22883b.setNoFriends(2);
                    }
                    if (bVar != null) {
                        this.f22883b.mFriendList = bVar.a();
                    }
                    this.f22883b.mAdapter.e(this.f22883b.mFriendList);
                    this.f22883b.mAdapter.notifyDataSetInvalidated();
                    this.f22883b.mListView.setSelection(0);
                } else {
                    this.f22883b.showToast(this.f22882a.getErrorString());
                    AtListActivity atListActivity3 = this.f22883b;
                    atListActivity3.showNetRefreshView(atListActivity3.mContainer, this.f22883b.getString(R.string.refresh_view_title_text), null, this.f22883b.getString(R.string.refresh_view_button_text), true, this.f22883b.getNetRefreshListener());
                }
                super.onPostExecute(bVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.f22882a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f22883b.mFriendListTask = null;
                AtListActivity atListActivity = this.f22883b;
                atListActivity.hideLoadingView(atListActivity.mContainer);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                AtListActivity atListActivity = this.f22883b;
                atListActivity.showLoadingView(atListActivity.mContainer);
                super.onPreExecute();
            }
        }

        public /* synthetic */ l(AtListActivity atListActivity, c cVar) {
            this(atListActivity);
        }
    }
}
