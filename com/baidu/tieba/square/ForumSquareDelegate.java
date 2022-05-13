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
import com.baidu.tieba.square.model.ForumSquareModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ag8;
import com.repackage.fg8;
import com.repackage.g55;
import com.repackage.ro;
import com.repackage.yf8;
import com.repackage.zf8;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumSquareDelegate implements ag8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public String mCurrentClassName;
    public ForumSquareModel mForumSquareModel;
    public yf8 mForumSquareView;
    public zf8 mSquareViewController;
    public final TbPageContext mTbPageContext;
    public CustomMessageListener refreshForumSquareListener;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements g55.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ForumSquareDelegate b;

        public b(ForumSquareDelegate forumSquareDelegate, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareDelegate, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumSquareDelegate;
            this.a = context;
        }

        @Override // com.repackage.g55.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new yf8(this.a, this.b.mTbPageContext) : invokeV.objValue;
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
        this.mForumSquareView = (yf8) g55.e().d(1025, new b(this, context));
        this.mTbPageContext.registerListener(this.refreshForumSquareListener);
    }

    private void checkLoadMoreStateUI(String str, List<ro> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, list) == null) || this.mForumSquareView == null || this.mForumSquareModel == null) {
            return;
        }
        if (ListUtils.isEmpty(list)) {
            this.mForumSquareView.f();
        } else if (ListUtils.getCount(list) < 10) {
            this.mForumSquareView.n();
        } else {
            this.mForumSquareView.E(this.mForumSquareModel.L(str));
        }
    }

    private void startLoadNetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mForumSquareView.F();
            this.mForumSquareModel.N(this.mCurrentClassName);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurrentClassName : (String) invokeV.objValue;
    }

    @Override // com.repackage.ag8
    public void onError(String str, ErrorData errorData) {
        yf8 yf8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, errorData) == null) || (yf8Var = this.mForumSquareView) == null || this.mForumSquareModel == null) {
            return;
        }
        yf8Var.J();
        fg8 K = this.mForumSquareModel.K(str);
        if (K != null && (!K.d || !ListUtils.isEmpty(K.a()))) {
            this.mForumSquareView.s(K.a());
            checkLoadMoreStateUI(str, K.a());
            return;
        }
        this.mForumSquareView.f();
        this.mForumSquareView.u();
    }

    public void onLoadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String className = getClassName();
            ForumSquareModel forumSquareModel = this.mForumSquareModel;
            if (forumSquareModel == null || this.mForumSquareView == null) {
                return;
            }
            boolean M = forumSquareModel.M();
            boolean E = this.mForumSquareView.E(this.mForumSquareModel.L(className));
            if (M || !E) {
                return;
            }
            this.mForumSquareModel.N(className);
        }
    }

    public void onLoadRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            yf8 yf8Var = this.mForumSquareView;
            if (yf8Var != null) {
                yf8Var.F();
            }
            ForumSquareModel forumSquareModel = this.mForumSquareModel;
            if (forumSquareModel != null) {
                forumSquareModel.N(getClassName());
            }
        }
    }

    @Override // com.repackage.ag8
    public void onNoData(ErrorData errorData) {
        yf8 yf8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, errorData) == null) || (yf8Var = this.mForumSquareView) == null) {
            return;
        }
        yf8Var.I();
    }

    public void onSelected(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            saveScrollPosition(this.mCurrentClassName);
            this.mCurrentClassName = str;
            ForumSquareModel forumSquareModel = this.mForumSquareModel;
            if (forumSquareModel == null || this.mForumSquareView == null) {
                return;
            }
            fg8 K = forumSquareModel.K(str);
            if (K != null && (!K.d || !ListUtils.isEmpty(K.a()))) {
                this.mForumSquareView.J();
                checkLoadMoreStateUI(str, K.a());
                this.mForumSquareView.s(K.a());
                this.mForumSquareView.q(K.f, K.g);
                return;
            }
            this.mForumSquareView.D();
            checkLoadMoreStateUI(str, null);
            this.mForumSquareModel.N(str);
            this.mForumSquareView.q(0, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r5.equals(r1) == false) goto L11;
     */
    @Override // com.repackage.ag8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSucc(String str, List<String> list, List<ro> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, list, list2) == null) || this.mForumSquareModel == null || this.mForumSquareView == null) {
            return;
        }
        boolean z = false;
        if (TextUtils.isEmpty(str) || str.equals(this.mCurrentClassName)) {
            String e = this.mForumSquareView.e();
            if (!TextUtils.isEmpty(str)) {
            }
            this.mCurrentClassName = str;
            this.mForumSquareView.J();
            this.mForumSquareView.r(str, list, z);
            this.mForumSquareView.t(list2, this.mForumSquareModel.Q(list2, 300));
            checkLoadMoreStateUI(str, list2);
        }
        z = true;
        this.mCurrentClassName = str;
        this.mForumSquareView.J();
        this.mForumSquareView.r(str, list, z);
        this.mForumSquareView.t(list2, this.mForumSquareModel.Q(list2, 300));
        checkLoadMoreStateUI(str, list2);
    }

    public void parserIntent(Intent intent) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        this.mCurrentClassName = stringExtra;
        if (TextUtils.isEmpty(stringExtra) && (uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            this.mCurrentClassName = uri.getQueryParameter("tab_name");
        }
        this.mForumSquareView.C(intent.getIntExtra(ForumSquareActivityConfig.SHOW_CREATE_BAR, 0) == 0);
    }

    public void saveScrollPosition(String str) {
        fg8 K;
        Pair<Integer, Integer> c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.mForumSquareView == null || this.mForumSquareModel == null || TextUtils.isEmpty(str) || (K = this.mForumSquareModel.K(str)) == null || (c = this.mForumSquareView.c()) == null) {
            return;
        }
        K.f = ((Integer) c.first).intValue();
        K.g = ((Integer) c.second).intValue();
    }

    public void selectForumCategory(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mForumSquareView.B(str);
        onSelected(str);
    }

    public void startLoadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            zf8 zf8Var = new zf8(this.mContext, this, this.mForumSquareView);
            this.mSquareViewController = zf8Var;
            zf8Var.e();
            startLoadNetData();
        }
    }
}
