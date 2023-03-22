package com.baidu.tieba.impersonal.template;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.g08;
import com.baidu.tieba.hi;
import com.baidu.tieba.impersonal.typewriter.TextTypeWriter;
import com.baidu.tieba.kh6;
import com.baidu.tieba.l08;
import com.baidu.tieba.n08;
import com.baidu.tieba.n15;
import com.baidu.tieba.r18;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/impersonal/template/PersonalTextMsgTemplate;", "Lcom/baidu/tieba/impersonal/template/BasePersonalMsgTemplate;", "Lcom/baidu/tieba/impersonal/data/TextMsgContent;", "Landroid/widget/TextView;", "Lcom/baidu/tieba/impersonal/components/uistate/PersonalTextMsgUiState;", "name", "", "(Ljava/lang/String;)V", "textTypeWriter", "Lcom/baidu/tieba/impersonal/typewriter/TextTypeWriter;", "getTextTypeWriter", "()Lcom/baidu/tieba/impersonal/typewriter/TextTypeWriter;", "textTypeWriter$delegate", "Lkotlin/Lazy;", "bindChild", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "data", "createChild", "parent", "Landroid/view/ViewGroup;", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PersonalTextMsgTemplate extends r18<l08, TextView, g08> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy b;

    /* loaded from: classes4.dex */
    public static final class a implements Function1<Integer, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                kh6.b().b(new n08(i));
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            a(num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalTextMsgTemplate(String name) {
        super(name);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {name};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(name, "name");
        this.b = LazyKt__LazyJVMKt.lazy(PersonalTextMsgTemplate$textTypeWriter$2.INSTANCE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.r18
    /* renamed from: h */
    public void d(TextView textView, final g08 data) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.h()) {
                TextTypeWriter j = j();
                l08 f = data.c().f();
                j.n(textView, (f == null || (r1 = f.a()) == null) ? "" : "", new a(), new Function0<Unit>(data) { // from class: com.baidu.tieba.impersonal.template.PersonalTextMsgTemplate$bindChild$2
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ g08 $data;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {data};
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
                        this.$data = data;
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
                            this.$data.i(false);
                        }
                    }
                });
            } else if (textView != null) {
                l08 f2 = data.c().f();
                if (f2 != null) {
                    str = f2.a();
                } else {
                    str = null;
                }
                textView.setText(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.r18
    /* renamed from: i */
    public TextView f(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            EMTextView eMTextView = new EMTextView(parent.getContext());
            eMTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            eMTextView.setTextIsSelectable(true);
            eMTextView.setTextColor(parent.getContext().getResources().getColor(R.color.CAM_X0105));
            eMTextView.setPadding(0, hi.g(parent.getContext(), R.dimen.M_H_X003), 0, hi.g(parent.getContext(), R.dimen.M_H_X003));
            n15 d = n15.d(eMTextView);
            d.A(R.dimen.T_X05);
            d.x(R.dimen.M_T_X002);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextTypeWriter j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (TextTypeWriter) this.b.getValue();
        }
        return (TextTypeWriter) invokeV.objValue;
    }
}
