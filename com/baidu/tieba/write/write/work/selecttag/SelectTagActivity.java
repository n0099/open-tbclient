package com.baidu.tieba.write.write.work.selecttag;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectTagActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.hv4;
import com.baidu.tieba.ie5;
import com.baidu.tieba.l79;
import com.baidu.tieba.ol8;
import com.baidu.tieba.pb;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassHttpResMessage;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class SelectTagActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout k;
    public SelectTagListView l;
    public l79 m;
    public List<String> n;
    public int o;
    public VideoCategoryClassData p;
    public boolean q;
    public pb r;

    /* loaded from: classes6.dex */
    public class a extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagActivity a;

        /* renamed from: com.baidu.tieba.write.write.work.selecttag.SelectTagActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0461a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0461a(a aVar) {
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
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.m == null) {
                    return;
                }
                this.a.a.m.f();
                SelectTagActivity selectTagActivity = this.a.a;
                selectTagActivity.hideNetRefreshView(selectTagActivity.k);
                SelectTagActivity selectTagActivity2 = this.a.a;
                selectTagActivity2.showLoadingView(selectTagActivity2.k);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectTagActivity selectTagActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagActivity;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                SelectTagActivity selectTagActivity = this.a;
                selectTagActivity.showNetRefreshView(selectTagActivity.k, null, this.a.getString(R.string.obfuscated_res_0x7f0f048d), null, false, new View$OnClickListenerC0461a(this));
                return;
            }
            if (responsedMessage instanceof GetSelectClassHttpResMessage) {
                this.a.m.i(((GetSelectClassHttpResMessage) responsedMessage).getTags().get(0));
            } else if (responsedMessage instanceof GetSelectClassSocketResMessage) {
                this.a.m.i(((GetSelectClassSocketResMessage) responsedMessage).getTags().get(0));
            }
            this.a.j1();
            SelectTagActivity selectTagActivity2 = this.a;
            selectTagActivity2.hideLoadingView(selectTagActivity2.k);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagActivity a;

        public b(SelectTagActivity selectTagActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.l.w()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921604, this.a.l.getHadSelectTagList()));
                this.a.M0();
            }
        }
    }

    public SelectTagActivity() {
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
        this.o = 6;
        this.p = new VideoCategoryClassData();
        this.r = new a(this, CmdConfigHttp.CMD_GET_SELECT_CLASS, 309713);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public ie5 N0(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, linearLayout, navigationBar)) == null) {
            this.k = linearLayout;
            if (this.l == null) {
                this.l = new SelectTagListView(getPageContext(), linearLayout, navigationBar);
            }
            this.l.c.setOnClickListener(new b(this));
            return this.l;
        }
        return (ie5) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public int O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getDimenPixelSize(R.dimen.tbds153) : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.m.d() == null) {
            return;
        }
        this.l.setRecommendTagList(this.m.d());
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.l.w()) {
                hv4.d(this.l.c).x(R.color.CAM_X0302);
            } else {
                this.l.c.setTextColor(ol8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.m = new l79(getUniqueId());
            this.l.d = findViewById(R.id.obfuscated_res_0x7f091fb9);
            this.l.l();
            this.r.getHttpMessageListener().setSelfListener(true);
            this.r.getSocketMessageListener().setSelfListener(true);
            registerListener(this.r);
            this.n = getIntent().getStringArrayListExtra(SelectTagActivityConfig.SELECT_INIT_TAG);
            this.p.setFirstClass(getIntent().getStringExtra(SelectTagActivityConfig.SELECT_INIT_FIRST_CLASS));
            this.p.setSecondClass(getIntent().getStringExtra(SelectTagActivityConfig.SELECT_INIT_SECOND_CLASS));
            this.m.i(this.p);
            this.m.f();
            List<String> list = this.n;
            if (list == null) {
                return;
            }
            int size = list.size();
            int i = this.o;
            if (size > i) {
                this.n = this.n.subList(0, i);
            }
            this.l.setHadSelectTagList(this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            this.q = z;
        }
    }
}
