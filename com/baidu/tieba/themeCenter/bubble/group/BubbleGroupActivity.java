package com.baidu.tieba.themeCenter.bubble.group;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tieba.dia;
import com.baidu.tieba.fia;
import com.baidu.tieba.gia;
import com.baidu.tieba.ria;
import com.baidu.tieba.themeCenter.bubble.group.BubbleGroupModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class BubbleGroupActivity extends BaseActivity<BubbleGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleGroupModel a;
    public gia b;
    public dia c;
    public BubbleGroupModel.c d;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "b010" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
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
        public void a(int i, String str, ria riaVar, List<fia> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, riaVar, list}) == null) {
                BubbleGroupActivity bubbleGroupActivity = this.a;
                bubbleGroupActivity.hideLoadingView(bubbleGroupActivity.b.d());
                this.a.b.i();
                if (i != 0) {
                    this.a.showToast(str);
                    this.a.b.j();
                    return;
                }
                this.a.b.k(riaVar, list, this.a.a.U());
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.isRouteStat = true;
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
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
        gia giaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a != null && (giaVar = this.b) != null) {
            showLoadingView(giaVar.d());
            this.a.loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            gia giaVar = this.b;
            if (giaVar != null) {
                giaVar.f();
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
            bubbleGroupModel.X(this.d);
            dia diaVar = new dia(getPageContext());
            this.c = diaVar;
            gia giaVar = new gia(this, diaVar);
            this.b = giaVar;
            giaVar.e();
            showLoadingView(this.b.d());
            this.a.loadData();
        }
    }
}
