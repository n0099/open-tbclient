package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b09;
import com.repackage.h95;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.vr4;
import com.repackage.xo;
import com.repackage.y09;
import com.repackage.yz8;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class AtListActivity extends SuspendedActivity implements h95, AdapterView.OnItemClickListener, y09.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_AT = "0";
    public static final String FROM_BJH = "2";
    public static final String FROM_CHAT = "1";
    public static final int NOFRIEND_MODE_ATSUGGEST = 1;
    public static final int NOFRIEND_MODE_FRIENDLIST = 2;
    public static final int NOFRIEND_MODE_NO = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final int MAX_SELECT_COUNTS;
    public String fromFid;
    public String fromTid;
    public boolean isForBjh;
    public boolean isForChat;
    public boolean isNeedMultiple;
    public y09 mAdapter;
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
    public ArrayList<AtSelectData> mLastPageAtSelectDataList;
    public View mListFooter;
    public BdListView mListView;
    public b09 mModel;
    public View mNaviSearchEditView;
    public View mNaviSearchFindView;
    public TextView mNaviTitleTV;
    public NavigationBar mNavigationBar;
    public NoDataView mNoDataView;
    public RelativeLayout mParent;
    public String mPreEditString;
    public Intent mResultIntent;
    public LinearLayout mSearchBox;
    public ImageView mSearchIcon;
    public ImageView mSearchImageView;
    public final Runnable mSuggestRunnable;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        /* renamed from: com.baidu.tieba.write.write.AtListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0239a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0239a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.close();
                }
            }
        }

        public a(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
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
                    AtListActivity atListActivity = this.a;
                    atListActivity.mCancel = atListActivity.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f04d8), new View$OnClickListenerC0239a(this));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public b(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mListView.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public c(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AtListActivity atListActivity = this.a;
                atListActivity.requestSuggestData(ni.charSequence2String(atListActivity.mEditText.getText(), ""));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public d(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditText);
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
        public final /* synthetic */ AtListActivity a;

        public e(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) && (obj instanceof MetaData)) {
                if (z) {
                    if (5 > this.a.mCandidateList.getItemLength()) {
                        this.a.addCandidate((MetaData) obj);
                        return;
                    }
                    AtListActivity atListActivity = this.a;
                    atListActivity.showToastWithIcon(String.format(atListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0937), 5), R.drawable.obfuscated_res_0x7f080a6a);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.a.removeCandidate((MetaData) obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public f(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditText);
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
        public final /* synthetic */ AtListActivity a;

        public g(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mResultIntent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(IntentConfig.AT_SELECT_LIST_DATA, this.a.mCandidateList.getDataList());
                this.a.mResultIntent.putExtras(bundle);
                oi.w(this.a.getPageContext().getPageActivity(), this.a.mEditText);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_COMMIT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", this.a.fromTid);
                statisticItem.param("fid", this.a.fromFid);
                StringBuilder sb = new StringBuilder();
                if (this.a.mCandidateList.getDataList() != null) {
                    Iterator<AtSelectData> it = this.a.mCandidateList.getDataList().iterator();
                    boolean z = true;
                    while (it.hasNext()) {
                        String uid = it.next().getUid();
                        if (!z) {
                            sb.append(",");
                        }
                        sb.append(uid);
                        z = false;
                    }
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, sb.toString());
                }
                TiebaStatic.log(statisticItem);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements AtSelectFriendList.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public h(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // com.baidu.tieba.write.write.AtSelectFriendList.b
        public void a(View view2, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, obj) == null) || obj == null) {
                return;
            }
            if (obj instanceof TbCheckBox.c) {
                ((TbCheckBox.c) obj).setChecked(false);
            }
            View findViewWithTag = this.a.mListView.findViewWithTag(obj);
            if (findViewWithTag instanceof TbCheckBox) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof MetaData) {
                this.a.removeCandidate((MetaData) obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public i(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
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
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public j(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (charSequence2String = ni.charSequence2String(editable, null)) == null) {
                return;
            }
            if (!charSequence2String.equals(this.a.mPreEditString)) {
                this.a.mHandler.removeCallbacks(this.a.mSuggestRunnable);
                this.a.mHandler.postDelayed(this.a.mSuggestRunnable, 300L);
            }
            if (charSequence2String.length() > 0) {
                this.a.mDelete.setVisibility(0);
            } else {
                this.a.mDelete.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.mPreEditString = ni.charSequence2String(charSequence, null);
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
    public class k implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public k(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (!z) {
                    oi.w(this.a.getPageContext().getPageActivity(), view2);
                } else {
                    oi.L(this.a.getPageContext().getPageActivity(), view2);
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
        if (!(interceptable == null || interceptable.invokeL(65570, this, metaData) == null) || metaData == null) {
            return;
        }
        this.mCandidateList.e(metaData);
        setCandidateCount(this.mCandidateList.getItemLength());
        setPostButtonState();
    }

    private void addListViewFooter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
            View view2 = new View(getPageContext().getContext());
            this.mListFooter = view2;
            view2.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
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
        if (interceptable == null || interceptable.invokeL(65572, this, bundle) == null) {
            this.mModel = new b09();
            if (bundle != null) {
                this.isNeedMultiple = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
                this.isForChat = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
                this.isForBjh = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
                this.mLastPageAtSelectDataList = bundle.getParcelableArrayList(IntentConfig.AT_SELECT_LIST_DATA);
                this.fromTid = bundle.getString("thread_id");
                this.fromFid = bundle.getString("forum_id");
                return;
            }
            this.isNeedMultiple = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
            this.isForChat = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
            this.isForBjh = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
            this.mLastPageAtSelectDataList = getIntent().getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
            this.fromTid = getIntent().getStringExtra("thread_id");
            this.fromFid = getIntent().getStringExtra("forum_id");
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            this.mNaviTitleTV = this.mNavigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f10cb));
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d007f, new i(this));
            this.mNaviSearchFindView = addCustomView;
            this.mSearchImageView = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091545);
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d05e7, (View.OnClickListener) null);
            this.mNaviSearchEditView = addCustomView2;
            addCustomView2.setVisibility(8);
            this.mEditText = (EditText) this.mNaviSearchEditView.findViewById(R.id.obfuscated_res_0x7f09091a);
            this.mSearchIcon = (ImageView) this.mNaviSearchEditView.findViewById(R.id.obfuscated_res_0x7f090916);
            this.mEditText.addTextChangedListener(new j(this));
            this.mEditText.setOnFocusChangeListener(new k(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09091b);
            this.mDelete = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.mParent = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091642);
            this.mNoDataView = NoDataViewFactory.b(getPageContext().getContext(), this.mParent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, oi.f(getActivity(), R.dimen.obfuscated_res_0x7f0702a1)), NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c2b)), null, true);
            this.mDivLine = findViewById(R.id.obfuscated_res_0x7f0902bb);
            this.mNoDataView.setOnTouchListener(new d(this));
            initNavigationBar();
            this.mSearchBox = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090401);
            this.mContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906d2);
            this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09126d);
            y09 y09Var = new y09(this, this.isNeedMultiple);
            this.mAdapter = y09Var;
            y09Var.g(this);
            this.mAdapter.e(new e(this));
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            this.mListView.setOnItemClickListener(this);
            this.mListView.setOnTouchListener(new f(this));
            if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.mEditText.getParent() != null) {
                ((View) this.mEditText.getParent()).setFocusable(true);
                ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
            }
            this.mCandidateContainer = (LinearLayout) this.mParent.findViewById(R.id.obfuscated_res_0x7f090f4e);
            Button button = (Button) this.mParent.findViewById(R.id.obfuscated_res_0x7f090467);
            this.mButtonPost = button;
            button.setOnClickListener(new g(this));
            setCandidateCount(0);
            AtSelectFriendList atSelectFriendList = (AtSelectFriendList) this.mParent.findViewById(R.id.obfuscated_res_0x7f0904a4);
            this.mCandidateList = atSelectFriendList;
            atSelectFriendList.setMaxCount(5);
            this.mCandidateList.setItemOPerationHandler(new h(this));
            addListViewFooter();
            ArrayList<AtSelectData> arrayList = this.mLastPageAtSelectDataList;
            if (arrayList != null) {
                Iterator<AtSelectData> it = arrayList.iterator();
                while (it.hasNext()) {
                    AtSelectData next = it.next();
                    MetaData metaData = new MetaData();
                    metaData.setPortrait(next.getPortrait());
                    metaData.setName_show(next.getNameShow());
                    addCandidate(metaData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCandidate(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65575, this, metaData) == null) || metaData == null) {
            return;
        }
        this.mCandidateList.k(metaData);
        setCandidateCount(this.mCandidateList.getItemLength());
        setPostButtonState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSuggestData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65576, this, str) == null) || isFinishing()) {
            return;
        }
        ArrayList<MetaData> arrayList = null;
        if (!this.isForChat && !this.isForBjh) {
            l lVar = this.mFriendListTask;
            if (lVar != null) {
                lVar.cancel();
            }
            l lVar2 = new l(this, null);
            this.mFriendListTask = lVar2;
            lVar2.setPriority(3);
            this.mFriendListTask.execute(str);
            return;
        }
        this.mAdapter.f(null);
        if (!ListUtils.isEmpty(this.mFriendList)) {
            if (TextUtils.isEmpty(str)) {
                arrayList = this.mFriendList;
            } else {
                arrayList = new ArrayList<>();
                Iterator<MetaData> it = this.mFriendList.iterator();
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
        this.mAdapter.f(arrayList);
        this.mAdapter.notifyDataSetInvalidated();
        this.mListView.setSelection(0);
    }

    private void setCandidateCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65577, this, i2) == null) {
            this.mButtonPost.setText(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0299), Integer.valueOf(i2), 5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNoFriends(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65578, this, i2) == null) {
            if (i2 == 2) {
                this.mListView.setVisibility(8);
                hideNetRefreshView(this.mContainer);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c2b)));
                this.mCandidateContainer.setVisibility(8);
            } else if (i2 == 1) {
                this.mListView.setVisibility(8);
                hideNetRefreshView(this.mContainer);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c5c)));
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
        ArrayList<AtSelectData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            if (this.mCandidateList.getItemLength() <= 0 && ((arrayList = this.mLastPageAtSelectDataList) == null || arrayList.size() <= 0)) {
                this.mButtonPost.setEnabled(false);
            } else {
                this.mButtonPost.setEnabled(true);
            }
        }
    }

    @Override // com.repackage.h95
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mResultIntent : (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public h95 getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout, navigationBar)) == null) {
            this.mContentView = linearLayout;
            this.mNavigationBar = navigationBar;
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0126, (ViewGroup) this.mContentView, true);
            return this;
        }
        return (h95) invokeLL.objValue;
    }

    @Override // com.repackage.y09.c
    public void handlerItem(View view2, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, metaData) == null) || metaData == null) {
            return;
        }
        this.mCandidateList.g(metaData);
    }

    @Override // com.repackage.h95
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            oi.w(getPageContext().getPageActivity(), this.mEditText);
            View view2 = this.mNaviSearchEditView;
            if (view2 == null || view2.getVisibility() != 0) {
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

    @Override // com.repackage.h95
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
            vr4 d2 = vr4.d(this.mButtonPost);
            d2.n(R.string.J_X03);
            d2.f(R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.mButtonPost, R.color.CAM_X0101, 3);
            this.mSearchImageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809cb, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            SkinManager.setViewTextColor(this.mContainer, (int) R.color.CAM_X0201);
            WebPManager.setPureDrawable(this.mSearchIcon, R.drawable.obfuscated_res_0x7f080a11, R.color.CAM_X0109, null);
            vr4 d3 = vr4.d(this.mSearchBox);
            d3.n(R.string.J_X07);
            d3.l(R.dimen.L_X01);
            d3.k(R.color.CAM_X0615);
            d3.f(R.color.CAM_X0209);
            vr4.d(this.mEditText).v(R.color.CAM_X0109);
            vr4.d(this.mDelete).A(R.string.F_X01);
            vr4.d(this.mCancel).v(R.color.CAM_X0109);
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
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public xo onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdListView bdListView = this.mListView;
            if (bdListView == null) {
                return null;
            }
            return bdListView.getPreLoadHandle();
        }
        return (xo) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{adapterView, view2, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.onItemClick(adapterView, view2, i2, j2);
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
                    showToastWithIcon(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0937), 5), R.drawable.obfuscated_res_0x7f080a6a);
                    return;
                } else {
                    addCandidate(item);
                }
                item.setChecked(!item.isChecked());
                this.mAdapter.notifyDataSetChanged();
                return;
            }
            oi.w(getPageContext().getPageActivity(), this.mEditText);
            if (this.isForChat) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new StatisticItem("c12930").param("obj_id", item.getUserIdLong()));
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
            if (oi.C()) {
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

    @Override // com.repackage.h95
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
        this.mAdapter.f(null);
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
            this.mAdapter.f(a2);
        } else {
            this.mAdapter.f(null);
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
    public class l extends BdAsyncTask<String, Integer, yz8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ AtListActivity b;

        public l(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = atListActivity;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public yz8 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                String str = strArr[0];
                this.a = new NetWork();
                if (!this.b.isForChat) {
                    if (this.b.isForBjh) {
                        NetWork netWork = this.a;
                        netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                        this.a.addPostData("from", "2");
                    } else {
                        NetWork netWork2 = this.a;
                        netWork2.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/atSearchUserList");
                        this.a.addPostData("rn", "100");
                        if (!ni.isEmpty(str)) {
                            this.a.addPostData("word", str);
                        }
                    }
                } else {
                    NetWork netWork3 = this.a;
                    netWork3.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.a.addPostData("from", "1");
                }
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    yz8 yz8Var = new yz8();
                    yz8Var.b(postNetData);
                    return yz8Var;
                }
                return null;
            }
            return (yz8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(yz8 yz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yz8Var) == null) {
                this.b.mFriendListTask = null;
                AtListActivity atListActivity = this.b;
                atListActivity.hideNetRefreshView(atListActivity.mContainer);
                if (this.b.mCandidateContainer != null && this.b.mCandidateContainer.getVisibility() == 0) {
                    this.b.mDivLine.setVisibility(0);
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    this.b.mModel.b(yz8Var);
                    if (this.b.mAdapter == null) {
                        return;
                    }
                    if (yz8Var == null || yz8Var.a() == null || !yz8Var.a().isEmpty()) {
                        this.b.setNoFriends(0);
                    } else {
                        this.b.setNoFriends(2);
                    }
                    if (yz8Var != null) {
                        this.b.mFriendList = yz8Var.a();
                    }
                    this.b.mAdapter.f(this.b.mFriendList);
                    this.b.mAdapter.notifyDataSetInvalidated();
                    this.b.mListView.setSelection(0);
                } else {
                    this.b.showToast(this.a.getErrorString());
                    AtListActivity atListActivity2 = this.b;
                    atListActivity2.showNetRefreshView(atListActivity2.mContainer, this.b.getString(R.string.obfuscated_res_0x7f0f0f69), null, this.b.getString(R.string.obfuscated_res_0x7f0f0f68), true, this.b.getNetRefreshListener());
                }
                super.onPostExecute(yz8Var);
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

        public /* synthetic */ l(AtListActivity atListActivity, c cVar) {
            this(atListActivity);
        }
    }
}
