package com.baidu.tieba.square;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.cm8;
import com.baidu.tieba.dm8;
import com.baidu.tieba.em8;
import com.baidu.tieba.jm8;
import com.baidu.tieba.square.model.ForumSquareModel;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ForumSquareDelegate implements em8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public String mCurrentClassName;
    public ForumSquareModel mForumSquareModel;
    public cm8 mForumSquareView;
    public dm8 mSquareViewController;
    public final TbPageContext mTbPageContext;
    public CustomMessageListener refreshForumSquareListener;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumSquareDelegate a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumSquareDelegate forumSquareDelegate, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareDelegate, Integer.valueOf(i)};
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
            this.a = forumSquareDelegate;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                ForumSquareDelegate forumSquareDelegate = this.a;
                if (forumSquareDelegate.mForumSquareView == null || forumSquareDelegate.mForumSquareModel == null) {
                    return;
                }
                this.a.mCurrentClassName = "";
                this.a.mForumSquareModel.clearData();
                this.a.startLoadData();
            }
        }
    }

    public ForumSquareDelegate(Context context, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentClassName = "";
        this.refreshForumSquareListener = new a(this, 2921589);
        this.mTbPageContext = tbPageContext;
        this.mContext = context;
        this.mForumSquareModel = new ForumSquareModel(context, this);
        this.mForumSquareView = new cm8(context, this.mTbPageContext);
        this.mTbPageContext.registerListener(this.refreshForumSquareListener);
    }

    @Override // com.baidu.tieba.em8
    public void onError(String str, ErrorData errorData) {
        cm8 cm8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, errorData) == null) && (cm8Var = this.mForumSquareView) != null && this.mForumSquareModel != null) {
            cm8Var.J();
            jm8 L = this.mForumSquareModel.L(str);
            if (L != null && (!L.d || !ListUtils.isEmpty(L.a()))) {
                this.mForumSquareView.s(L.a());
                checkLoadMoreStateUI(str, L.a());
                return;
            }
            this.mForumSquareView.f();
            this.mForumSquareView.u();
        }
    }

    @Override // com.baidu.tieba.em8
    public void onNoData(ErrorData errorData) {
        cm8 cm8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, errorData) == null) && (cm8Var = this.mForumSquareView) != null) {
            cm8Var.I();
        }
    }

    public void selectForumCategory(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.mForumSquareView.B(str);
            onSelected(str);
        }
    }

    private void checkLoadMoreStateUI(String str, List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, this, str, list) == null) && this.mForumSquareView != null && this.mForumSquareModel != null) {
            if (ListUtils.isEmpty(list)) {
                this.mForumSquareView.f();
            } else if (ListUtils.getCount(list) < 10) {
                this.mForumSquareView.n();
            } else {
                this.mForumSquareView.E(this.mForumSquareModel.M(str));
            }
        }
    }

    private void startLoadNetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mForumSquareView.F();
            this.mForumSquareModel.O(this.mCurrentClassName);
        }
    }

    public void configHideHeadStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mForumSquareView.b();
        }
    }

    public String getClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCurrentClassName;
        }
        return (String) invokeV.objValue;
    }

    public void onLoadRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            cm8 cm8Var = this.mForumSquareView;
            if (cm8Var != null) {
                cm8Var.F();
            }
            ForumSquareModel forumSquareModel = this.mForumSquareModel;
            if (forumSquareModel != null) {
                forumSquareModel.O(getClassName());
            }
        }
    }

    public void startLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            dm8 dm8Var = new dm8(this.mContext, this, this.mForumSquareView);
            this.mSquareViewController = dm8Var;
            dm8Var.e();
            startLoadNetData();
        }
    }

    public void onLoadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String className = getClassName();
            ForumSquareModel forumSquareModel = this.mForumSquareModel;
            if (forumSquareModel != null && this.mForumSquareView != null) {
                boolean N = forumSquareModel.N();
                boolean E = this.mForumSquareView.E(this.mForumSquareModel.M(className));
                if (!N && E) {
                    this.mForumSquareModel.O(className);
                }
            }
        }
    }

    public void onSelected(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            saveScrollPosition(this.mCurrentClassName);
            this.mCurrentClassName = str;
            ForumSquareModel forumSquareModel = this.mForumSquareModel;
            if (forumSquareModel != null && this.mForumSquareView != null) {
                jm8 L = forumSquareModel.L(str);
                if (L != null && (!L.d || !ListUtils.isEmpty(L.a()))) {
                    this.mForumSquareView.J();
                    checkLoadMoreStateUI(str, L.a());
                    this.mForumSquareView.s(L.a());
                    this.mForumSquareView.q(L.f, L.g);
                    return;
                }
                this.mForumSquareView.D();
                checkLoadMoreStateUI(str, null);
                this.mForumSquareModel.O(str);
                this.mForumSquareView.q(0, 0);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.equals(r1) == false) goto L11;
     */
    @Override // com.baidu.tieba.em8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSucc(String str, List<String> list, List<xn> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, list, list2) == null) && this.mForumSquareModel != null && this.mForumSquareView != null) {
            boolean z = false;
            if (TextUtils.isEmpty(str) || str.equals(this.mCurrentClassName)) {
                String e = this.mForumSquareView.e();
                if (!TextUtils.isEmpty(str)) {
                }
                this.mCurrentClassName = str;
                this.mForumSquareView.J();
                this.mForumSquareView.r(str, list, z);
                this.mForumSquareView.t(list2, this.mForumSquareModel.R(list2, 300));
                checkLoadMoreStateUI(str, list2);
            }
            z = true;
            this.mCurrentClassName = str;
            this.mForumSquareView.J();
            this.mForumSquareView.r(str, list, z);
            this.mForumSquareView.t(list2, this.mForumSquareModel.R(list2, 300));
            checkLoadMoreStateUI(str, list2);
        }
    }

    public void parserIntent(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) && intent != null) {
            String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
            this.mCurrentClassName = stringExtra;
            if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
                this.mCurrentClassName = uri.getQueryParameter("tab_name");
            }
            boolean z = false;
            int intExtra = intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0);
            cm8 cm8Var = this.mForumSquareView;
            if (intExtra == 0) {
                z = true;
            }
            cm8Var.C(z);
        }
    }

    public void saveScrollPosition(String str) {
        jm8 L;
        Pair<Integer, Integer> c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || this.mForumSquareView == null || this.mForumSquareModel == null || TextUtils.isEmpty(str) || (L = this.mForumSquareModel.L(str)) == null || (c = this.mForumSquareView.c()) == null) {
            return;
        }
        L.f = ((Integer) c.first).intValue();
        L.g = ((Integer) c.second).intValue();
    }
}
