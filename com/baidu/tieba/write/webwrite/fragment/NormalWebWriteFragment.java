package com.baidu.tieba.write.webwrite.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.ct6;
import com.baidu.tieba.dt6;
import com.baidu.tieba.ft6;
import com.baidu.tieba.gt6;
import com.baidu.tieba.hi5;
import com.baidu.tieba.qza;
import com.baidu.tieba.uza;
import com.baidu.tieba.vza;
import com.baidu.tieba.w3b;
import com.baidu.tieba.write.webwrite.data.WriteDataManager;
import com.baidu.tieba.write.webwrite.fragment.NormalWebWriteFragment;
import com.baidu.tieba.xxa;
import com.baidu.tieba.yxa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/write/webwrite/fragment/NormalWebWriteFragment;", "Lcom/baidu/tieba/write/webwrite/fragment/BaseWebWriteFragment;", "()V", "configEditor", "", "editorTools", "Lcom/baidu/tbadk/editortools/EditorTools;", "delayMillis", "", "getTypeStr", "", "getWriteDataManager", "Lcom/baidu/tieba/write/webwrite/data/WriteDataManager;", "notifyNext", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NormalWebWriteFragment extends BaseWebWriteFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(370685184, "Lcom/baidu/tieba/write/webwrite/fragment/NormalWebWriteFragment;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(370685184, "Lcom/baidu/tieba/write/webwrite/fragment/NormalWebWriteFragment;");
        }
    }

    @Override // com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment
    public String A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "normal" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a extends gt6<vza> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NormalWebWriteFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NormalWebWriteFragment normalWebWriteFragment, Class<vza> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {normalWebWriteFragment, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = normalWebWriteFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gt6
        public void onEvent(vza event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.b.I2();
            }
        }
    }

    public NormalWebWriteFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment
    public WriteDataManager B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new qza();
        }
        return (WriteDataManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment
    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            dt6.b().b(new uza());
        }
    }

    public static final void Q2(NormalWebWriteFragment this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getPageContext().showToast(this$0.x2().b().getDisableAudioMessage());
        }
    }

    @Override // com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            ft6 b = dt6.b();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            b.a(new ct6(pageContext, vza.class), new a(this, vza.class));
            return super.onCreateView(inflater, viewGroup, bundle);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment
    public void q2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, editorTools) == null) {
            Intrinsics.checkNotNullParameter(editorTools, "editorTools");
            new yxa().b();
            editorTools.setBarMaxLauCount(5);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setBarLauncherType(1);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            if (!Intrinsics.areEqual(WriteActivityConfig.FROM_FORUM_SHARE, x2().b().getFrom())) {
                w3b.h(getPageContext(), editorTools, this);
                w3b.j(getPageContext(), editorTools, this);
                w3b.k(getPageContext(), editorTools, this);
                w3b.b(getPageContext(), editorTools, this);
                w3b.i(getPageContext(), editorTools);
                final xxa m = w3b.m(getPageContext(), editorTools, x2().b().getCallFrom(), this);
                m.o(false);
                t2().add(new Function0<Unit>(m) { // from class: com.baidu.tieba.write.webwrite.fragment.NormalWebWriteFragment$configEditor$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ xxa $writeTool;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {m};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$writeTool = m;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.$writeTool.g();
                        }
                    }
                });
            }
            w3b.d(editorTools, this);
            w3b.a(getPageContext(), editorTools, this);
            if (StringHelper.equals("2", x2().b().getCallFrom())) {
                w3b.g(getPageContext(), editorTools, this);
                w3b.l(getPageContext(), editorTools, this);
            }
            if (!Intrinsics.areEqual("main_tab", x2().b().getFrom())) {
                w3b.c(getPageContext(), editorTools, this);
            }
            editorTools.f();
            editorTools.setActionListener(74, this);
            hi5 o = editorTools.o(6);
            if (o != null && !TextUtils.isEmpty(x2().b().getDisableAudioMessage())) {
                ((View) o).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.b0b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            NormalWebWriteFragment.Q2(NormalWebWriteFragment.this, view2);
                        }
                    }
                });
            }
        }
    }
}
