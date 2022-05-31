package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a68;
import com.repackage.v58;
import com.repackage.x58;
/* loaded from: classes3.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FORUM_SEARCH_CLICK = "c12842";
    public static final int TAB_ID_ONLY_THREAD = 3;
    public static final int TAB_ID_RELATIVE = 2;
    public static final int TAB_ID_TIME = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String mForumId;
    public String mForumName;
    public x58 mModel;
    public ViewPager.OnPageChangeListener mOnPageChangeListener;
    public String mSearchKey;
    public a68 mView;

    /* loaded from: classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostSearchActivity a;

        public a(PostSearchActivity postSearchActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postSearchActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postSearchActivity;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.stateTabClick(i);
            }
        }
    }

    public PostSearchActivity() {
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
        this.mOnPageChangeListener = new a(this);
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.mForumName = intent.getStringExtra("forum_name");
                this.mForumId = intent.getStringExtra("forum_id");
            }
            this.mModel.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stateTabClick(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            int i2 = 2;
            if (i == 0) {
                i2 = 1;
            } else if (i != 1) {
                i2 = i != 2 ? 0 : 3;
            }
            StatisticItem param = new StatisticItem("c12404").param("fid", this.mForumId).param("fname", this.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (i2 != 0) {
                param.param("tab_id", i2);
            }
            TiebaStatic.log(param);
        }
    }

    public x58 getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mModel : (x58) invokeV.objValue;
    }

    public a68 getPostSearchView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mView : (a68) invokeV.objValue;
    }

    public void hideSoftKeyPad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mView.d();
        }
    }

    public boolean isHistoryVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mView.f() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mView.g(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            a68 a68Var = new a68(this);
            this.mView = a68Var;
            a68Var.e();
            this.mView.l(this.mOnPageChangeListener);
            addGlobalLayoutListener();
            this.mModel = new x58(this);
            initData();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a68 a68Var = this.mView;
            if (a68Var != null) {
                a68Var.h();
            }
            super.onDestroy();
        }
    }

    public void refreshHistoryList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mView.i(this.mModel.j);
        }
    }

    public void refreshResultListByTab(int i, v58 v58Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), v58Var, Boolean.valueOf(z)}) == null) {
            if (i == 1 && (v58Var == null || !v58Var.a())) {
                this.mView.c();
                this.mView.n();
                return;
            }
            this.mView.c();
            this.mView.b();
            this.mView.j(i, v58Var, z);
        }
    }

    public void setEditSearchText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mView.k(str);
        }
    }

    public void startSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mSearchKey = str;
            this.mView.o(1);
            this.mModel.q();
            this.mView.m();
        }
    }
}
