package com.baidu.tieba.write.transmit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ShareFriendTitleData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a87;
import com.repackage.b87;
import com.repackage.gs4;
import com.repackage.gz8;
import com.repackage.li;
import com.repackage.mi;
import com.repackage.u87;
import com.repackage.vy8;
import com.repackage.yy8;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class ShareFriendActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_CHAT_LIST = "1";
    public static final String FROM_SHARE_FRIEND = "0";
    public static final String FROM_SHARE_LIST = "4";
    public static final int NOFRIEND_MODE_CHAT = 2;
    public static final int NOFRIEND_MODE_NO = 0;
    public static final int NOFRIEND_MODE_SHARE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> filterUid;
    public ForumData forumData;
    public boolean isForChat;
    public boolean isForShareFriend;
    public int listDivider;
    public int listFocus;
    public int listNearly;
    public int listTitle;
    public gz8 mAdapter;
    public ImageView mButtonDel;
    public View mCancel;
    public ArrayList<MetaData> mDataList;
    public TextView mDelete;
    public EditText mEditText;
    public ArrayList<MetaData> mFilterList;
    public j mFriendListTask;
    public ArrayList<MetaData> mJointList;
    public FrameLayout mListContainer;
    public BdListView mListView;
    public yy8 mModel;
    public View mNaviSearchEditView;
    public View mNaviSearchFindView;
    public TextView mNaviTitleTV;
    public NavigationBar mNavigationBar;
    public ArrayList<MetaData> mNearlyPersonList;
    public NoDataView mNoDataView;
    public String mPreEditString;
    public View mRootView;
    public LinearLayout mSearchBox;
    public ImageView mSearchIcon;
    public ImageView mSearchImageView;
    public CustomMessageListener mShareDataListener;
    public final Runnable mSuggestRunnable;
    public int maxNearlyPerson;
    public ThreadData threadData;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public a(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ShareFriendActivity shareFriendActivity = this.a;
                shareFriendActivity.requestSuggestData(li.charSequence2String(shareFriendActivity.mEditText.getText(), ""));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ShareFriendActivity shareFriendActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if ((customResponsedMessage.getData() instanceof ThreadData) || (customResponsedMessage.getData() instanceof ForumData)) {
                if (customResponsedMessage.getData() instanceof ThreadData) {
                    this.a.threadData = (ThreadData) customResponsedMessage.getData();
                } else if (customResponsedMessage.getData() instanceof ForumData) {
                    this.a.forumData = (ForumData) customResponsedMessage.getData();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        /* loaded from: classes4.dex */
        public class a implements a87.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.repackage.a87.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.finish();
                }
            }

            @Override // com.repackage.a87.b
            public /* synthetic */ void onCancel() {
                b87.a(this);
            }
        }

        public c(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            MetaData item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.mAdapter.getItem(i)) == null) {
                return;
            }
            mi.w(this.a.getPageContext().getPageActivity(), this.a.mEditText);
            if (!this.a.isForChat) {
                if (this.a.isForShareFriend) {
                    a87 a87Var = new a87(this.a.getActivity());
                    if (this.a.threadData != null) {
                        a87Var.o(this.a.threadData, item);
                    } else if (this.a.forumData != null) {
                        a87Var.n(this.a.forumData, item);
                    }
                    a87Var.m(new a(this));
                    a87Var.p();
                    return;
                }
                return;
            }
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.a, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
            TiebaStatic.log(new StatisticItem("c12930").param("obj_id", item.getUserIdLong()));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public d(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 1) {
                ShareFriendActivity shareFriendActivity = this.a;
                mi.w(shareFriendActivity, shareFriendActivity.mEditText);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public e(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mNaviTitleTV.setVisibility(8);
                this.a.mNaviSearchFindView.setVisibility(8);
                this.a.mNaviSearchEditView.setVisibility(0);
                this.a.mEditText.requestFocus();
                this.a.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
                this.a.mCancel = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public f(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (charSequence2String = li.charSequence2String(editable, null)) == null) {
                return;
            }
            if (charSequence2String.length() == 0) {
                this.a.mButtonDel.setVisibility(8);
            } else {
                this.a.mButtonDel.setVisibility(0);
            }
            if (!charSequence2String.equals(this.a.mPreEditString)) {
                ShareFriendActivity shareFriendActivity = this.a;
                shareFriendActivity.mHandler.removeCallbacks(shareFriendActivity.mSuggestRunnable);
                ShareFriendActivity shareFriendActivity2 = this.a;
                shareFriendActivity2.mHandler.postDelayed(shareFriendActivity2.mSuggestRunnable, 300L);
            }
            this.a.mDelete.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.mPreEditString = li.charSequence2String(charSequence, null);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public g(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (!z) {
                    mi.w(this.a.getPageContext().getPageActivity(), view2);
                } else {
                    mi.L(this.a.getPageContext().getPageActivity(), view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public h(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mEditText.getText().clear();
                this.a.mNaviTitleTV.setVisibility(0);
                this.a.mNaviSearchFindView.setVisibility(0);
                this.a.mNaviSearchEditView.setVisibility(8);
                if (this.a.mCancel == null) {
                    ShareFriendActivity shareFriendActivity = this.a;
                    shareFriendActivity.mCancel = shareFriendActivity.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public i(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mEditText.setText("");
            }
        }
    }

    public ShareFriendActivity() {
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
        this.mNavigationBar = null;
        this.mJointList = new ArrayList<>();
        this.mFilterList = new ArrayList<>();
        this.mNearlyPersonList = new ArrayList<>();
        this.mDataList = new ArrayList<>();
        this.filterUid = new ArrayList<>();
        this.mModel = null;
        this.mAdapter = null;
        this.mListView = null;
        this.mFriendListTask = null;
        this.isForShareFriend = false;
        this.isForChat = false;
        this.listTitle = 0;
        this.listDivider = 2;
        this.listNearly = 1;
        this.listFocus = 3;
        this.maxNearlyPerson = 10;
        this.mSuggestRunnable = new a(this);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, bundle) == null) {
            this.mModel = new yy8();
            if (bundle != null) {
                this.isForChat = bundle.getBoolean(ShareFriendActivityConfig.FROM_MESSAGE_TAB, false);
                this.isForShareFriend = bundle.getBoolean(ShareFriendActivityConfig.FROM_SHARE_FRIEND, false);
                return;
            }
            this.isForChat = getIntent().getBooleanExtra(ShareFriendActivityConfig.FROM_MESSAGE_TAB, false);
            this.isForShareFriend = getIntent().getBooleanExtra(ShareFriendActivityConfig.FROM_SHARE_FRIEND, false);
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.mNavigationBar = navigationBar;
            if (this.isForChat) {
                this.mNaviTitleTV = navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f03a9));
            } else if (this.isForShareFriend) {
                this.mNaviTitleTV = navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f10ed));
            }
            this.mNaviSearchFindView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d007b, new e(this));
            this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
            this.mCancel = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mSearchImageView = (ImageView) this.mNaviSearchFindView.findViewById(R.id.obfuscated_res_0x7f091562);
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d05db, (View.OnClickListener) null);
            this.mNaviSearchEditView = addCustomView;
            addCustomView.setVisibility(8);
            ImageView imageView = (ImageView) this.mNaviSearchEditView.findViewById(R.id.obfuscated_res_0x7f0903fc);
            this.mButtonDel = imageView;
            imageView.setVisibility(8);
            this.mEditText = (EditText) this.mNaviSearchEditView.findViewById(R.id.obfuscated_res_0x7f090912);
            this.mSearchIcon = (ImageView) this.mNaviSearchEditView.findViewById(R.id.obfuscated_res_0x7f09090e);
            this.mEditText.addTextChangedListener(new f(this));
            this.mEditText.setOnFocusChangeListener(new g(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090913);
            this.mDelete = textView;
            textView.setOnClickListener(new h(this));
            this.mButtonDel.setOnClickListener(new i(this));
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f091d12);
            this.mNoDataView = NoDataViewFactory.b(getPageContext().getContext(), this.mRootView, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, mi.f(getActivity(), R.dimen.obfuscated_res_0x7f0702a1)), NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c6d)), null, true);
            initNavigationBar();
            this.mSearchBox = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d20);
            this.mListContainer = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091cff);
            this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09127a);
            gz8 gz8Var = new gz8(this);
            this.mAdapter = gz8Var;
            this.mListView.setAdapter((ListAdapter) gz8Var);
            this.mAdapter.b(this.mDataList);
            this.mListView.setOnItemClickListener(new c(this));
            this.mListView.setOnScrollListener(new d(this));
            if (getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) || this.mEditText.getParent() == null) {
                return;
            }
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSuggestData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, this, str) == null) || isFinishing()) {
            return;
        }
        if (this.isForChat || this.isForShareFriend) {
            ArrayList<MetaData> arrayList = null;
            this.mAdapter.d(null);
            if (!ListUtils.isEmpty(this.mJointList)) {
                if (TextUtils.isEmpty(str)) {
                    arrayList = this.mJointList;
                } else {
                    arrayList = new ArrayList<>();
                    Iterator<MetaData> it = this.mFilterList.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getName_show() != null && next.getName_show().contains(str)) {
                            arrayList.add(next);
                        }
                    }
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                setNoFriends(0);
            } else {
                setNoFriends(1);
            }
            this.mAdapter.d(arrayList);
            this.mAdapter.notifyDataSetInvalidated();
            this.mListView.setSelection(0);
        }
    }

    private void setFilterList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            for (int i2 = 0; i2 < this.mJointList.size(); i2++) {
                if (this.mJointList.get(i2).getUserId() == null) {
                    this.mFilterList.add(this.mJointList.get(i2));
                } else if (!this.filterUid.contains(this.mJointList.get(i2).getUserId())) {
                    this.filterUid.add(this.mJointList.get(i2).getUserId());
                    this.mFilterList.add(this.mJointList.get(i2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoFriends(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65569, this, i2) == null) {
            if (i2 == 2) {
                this.mListView.setVisibility(8);
                hideNetRefreshView(this.mListContainer);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c6d)));
                this.mNaviSearchFindView.setVisibility(8);
            } else if (i2 != 1) {
                if (i2 == 0) {
                    this.mListView.setVisibility(0);
                    this.mNoDataView.setVisibility(8);
                }
            } else {
                this.mListView.setVisibility(8);
                hideNetRefreshView(this.mListContainer);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c6c)));
                this.mNoDataView.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.FINDBAR));
                this.mNaviSearchFindView.setVisibility(8);
            }
        }
    }

    public void addListDivider(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            ShareFriendTitleData shareFriendTitleData = new ShareFriendTitleData();
            shareFriendTitleData.setItemType(this.listDivider);
            arrayList.add(shareFriendTitleData);
        }
    }

    public void addListTitle(String str, ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, arrayList) == null) {
            ShareFriendTitleData shareFriendTitleData = new ShareFriendTitleData();
            shareFriendTitleData.setItemType(this.listTitle);
            shareFriendTitleData.setTitle(str);
            arrayList.add(shareFriendTitleData);
        }
    }

    public void handlerItem(View view2, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, metaData) != null) || metaData == null) {
        }
    }

    public void jointList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.isForChat) {
                addListTitle(getString(R.string.obfuscated_res_0x7f0f0b38), this.mJointList);
                this.mJointList.addAll(this.mDataList);
            } else if (this.isForShareFriend) {
                ArrayList<MetaData> a2 = u87.a();
                this.mNearlyPersonList = a2;
                int size = a2.size();
                if (size == 0) {
                    addListTitle(getString(R.string.obfuscated_res_0x7f0f0b38), this.mJointList);
                    this.mJointList.addAll(this.mDataList);
                } else {
                    addListTitle(getString(R.string.obfuscated_res_0x7f0f0c26), this.mJointList);
                    if (size <= this.maxNearlyPerson) {
                        for (int i2 = 0; i2 < size; i2++) {
                            this.mNearlyPersonList.get(i2).setItemType(this.listNearly);
                            this.mJointList.add(this.mNearlyPersonList.get(i2));
                        }
                    } else {
                        for (int i3 = 0; i3 < this.maxNearlyPerson; i3++) {
                            this.mNearlyPersonList.get(i3).setItemType(this.listNearly);
                            this.mJointList.add(this.mNearlyPersonList.get(i3));
                        }
                    }
                    ArrayList<MetaData> arrayList = this.mDataList;
                    if (arrayList != null && arrayList.size() != 0) {
                        addListDivider(this.mJointList);
                        addListTitle(getString(R.string.obfuscated_res_0x7f0f0b38), this.mJointList);
                        for (int i4 = 0; i4 < this.mDataList.size(); i4++) {
                            this.mJointList.add(this.mDataList.get(i4));
                        }
                    }
                }
            }
            setFilterList();
            this.mAdapter.d(this.mJointList);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mSearchImageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e3, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            WebPManager.setPureDrawable(this.mSearchIcon, R.drawable.obfuscated_res_0x7f080a29, R.color.CAM_X0109, null);
            SkinManager.setImageResource(this.mButtonDel, R.drawable.icon_input_close_s);
            this.mAdapter.c(i2);
            gs4 d2 = gs4.d(this.mSearchBox);
            d2.n(R.string.J_X07);
            d2.k(R.color.CAM_X0615);
            d2.f(R.color.CAM_X0209);
            gs4.d(this.mEditText).v(R.color.CAM_X0109);
            gs4 d3 = gs4.d(this.mDelete);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0107);
            gs4.d(this.mCancel).v(R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d075e);
            initData(bundle);
            initView();
            requestData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            j jVar = this.mFriendListTask;
            if (jVar != null) {
                jVar.cancel();
            }
            this.mHandler.removeCallbacks(this.mSuggestRunnable);
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.mShareDataListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onNetRefreshButtonClicked();
            if (mi.C()) {
                requestData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (this.mShareDataListener == null) {
                this.mShareDataListener = new b(this, 2921694);
            }
            MessageManager.getInstance().registerListener(this.mShareDataListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStart();
            this.mNoDataView.d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStop();
            this.mNoDataView.e();
        }
    }

    public void requestData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || isFinishing()) {
            return;
        }
        this.mAdapter.d(null);
        if (this.mModel.a() != null) {
            ArrayList<MetaData> a2 = this.mModel.a().a();
            if (!ListUtils.isEmpty(a2)) {
                setNoFriends(0);
            } else if (ListUtils.isEmpty(a2) && ListUtils.isEmpty(u87.a())) {
                setNoFriends(1);
            }
            this.mAdapter.d(a2);
        } else {
            this.mAdapter.d(null);
            if (this.mFriendListTask == null) {
                j jVar = new j(this, null);
                this.mFriendListTask = jVar;
                jVar.setPriority(3);
                this.mFriendListTask.execute("");
            }
        }
        this.mAdapter.notifyDataSetInvalidated();
        this.mListView.setSelection(0);
    }

    /* loaded from: classes4.dex */
    public class j extends BdAsyncTask<String, Integer, vy8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ ShareFriendActivity b;

        public j(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = shareFriendActivity;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public vy8 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                String str = strArr[0];
                this.a = new NetWork();
                if (this.b.isForChat) {
                    NetWork netWork = this.a;
                    netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.a.addPostData("from", "1");
                } else {
                    NetWork netWork2 = this.a;
                    netWork2.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.a.addPostData("from", "4");
                }
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    vy8 vy8Var = new vy8();
                    vy8Var.b(postNetData);
                    return vy8Var;
                }
                return null;
            }
            return (vy8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(vy8 vy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vy8Var) == null) {
                this.b.mFriendListTask = null;
                ShareFriendActivity shareFriendActivity = this.b;
                shareFriendActivity.hideNetRefreshView(shareFriendActivity.mListContainer);
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    this.b.mListView.setVisibility(0);
                    this.b.mModel.b(vy8Var);
                    if (this.b.mAdapter == null) {
                        return;
                    }
                    if (!this.b.isForChat || vy8Var == null || vy8Var.a() == null || !vy8Var.a().isEmpty()) {
                        if (!this.b.isForShareFriend || vy8Var == null || vy8Var.a() == null || !vy8Var.a().isEmpty() || u87.a() == null || !u87.a().isEmpty()) {
                            this.b.setNoFriends(0);
                        } else {
                            this.b.setNoFriends(2);
                        }
                    } else {
                        this.b.setNoFriends(2);
                    }
                    if (vy8Var != null) {
                        ArrayList<MetaData> a = vy8Var.a();
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            a.get(i).setItemType(this.b.listFocus);
                            this.b.mDataList.add(a.get(i));
                        }
                    }
                    this.b.jointList();
                    this.b.mAdapter.notifyDataSetInvalidated();
                    this.b.mListView.setSelection(0);
                } else {
                    this.b.mListView.setVisibility(8);
                    ShareFriendActivity shareFriendActivity2 = this.b;
                    shareFriendActivity2.showNetRefreshView(shareFriendActivity2.mListContainer, this.b.getString(R.string.obfuscated_res_0x7f0f0f84), null, this.b.getString(R.string.obfuscated_res_0x7f0f0f83), true, this.b.getNetRefreshListener());
                }
                super.onPostExecute(vy8Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.b.mFriendListTask = null;
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
            }
        }

        public /* synthetic */ j(ShareFriendActivity shareFriendActivity, a aVar) {
            this(shareFriendActivity);
        }
    }
}
