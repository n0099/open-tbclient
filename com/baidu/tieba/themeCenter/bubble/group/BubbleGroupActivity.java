package com.baidu.tieba.themeCenter.bubble.group;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.ay9;
import com.baidu.tieba.cy9;
import com.baidu.tieba.dy9;
import com.baidu.tieba.oy9;
import com.baidu.tieba.rn5;
import com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class BubbleGroupActivity extends BaseActivity<BubbleGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleGroupModel a;
    public dy9 b;
    public ay9 c;
    public BubbleGroupModel.c d;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.on5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b010" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements BubbleGroupModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleGroupActivity a;

        public a(BubbleGroupActivity bubbleGroupActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleGroupActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bubbleGroupActivity;
        }

        @Override // com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel.c
        public void a(int i, String str, oy9 oy9Var, List<cy9> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, oy9Var, list}) == null) {
                BubbleGroupActivity bubbleGroupActivity = this.a;
                bubbleGroupActivity.hideLoadingView(bubbleGroupActivity.b.d());
                this.a.b.i();
                if (i != 0) {
                    this.a.showToast(str);
                    this.a.b.j();
                    return;
                }
                this.a.b.k(oy9Var, list, this.a.a.b0());
            }
        }
    }

    public BubbleGroupActivity() {
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
        this.d = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public rn5 getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            rn5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.a = true;
            }
            return pageStayDurationItem;
        }
        return (rn5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        dy9 dy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a != null && (dy9Var = this.b) != null) {
            showLoadingView(dy9Var.d());
            this.a.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            dy9 dy9Var = this.b;
            if (dy9Var != null) {
                dy9Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            BubbleGroupModel bubbleGroupModel = new BubbleGroupModel(this);
            this.a = bubbleGroupModel;
            bubbleGroupModel.e0(this.d);
            ay9 ay9Var = new ay9(getPageContext());
            this.c = ay9Var;
            dy9 dy9Var = new dy9(this, ay9Var);
            this.b = dy9Var;
            dy9Var.e();
            showLoadingView(this.b.d());
            this.a.loadData();
        }
    }
}
