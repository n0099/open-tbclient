package com.baidu.tieba.recapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.d15;
import com.baidu.tieba.j3a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.NadCustomAppInfoView;
import com.baidu.tieba.x31;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010&\u001a\u00020'H\u0002J\u0006\u0010(\u001a\u00020'J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001e\u0010\u0014R\u001b\u0010 \u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b!\u0010\u0014R\u001b\u0010#\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b$\u0010\u0014¨\u0006/"}, d2 = {"Lcom/baidu/tieba/recapp/view/NadCustomAppInfoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adAppInfo", "Lcom/baidu/tbadk/core/data/AdvertAppInfo;", "adAppInfoModel", "Lcom/baidu/tbadk/core/data/AdAppInfoModel;", "getAdAppInfoModel", "()Lcom/baidu/tbadk/core/data/AdAppInfoModel;", "setAdAppInfoModel", "(Lcom/baidu/tbadk/core/data/AdAppInfoModel;)V", "authorNameView", "Landroid/widget/TextView;", "getAuthorNameView", "()Landroid/widget/TextView;", "authorNameView$delegate", "Lkotlin/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "getListener", "()Landroid/view/View$OnClickListener;", "setListener", "(Landroid/view/View$OnClickListener;)V", "permissionTagView", "getPermissionTagView", "permissionTagView$delegate", "privacyTagView", "getPrivacyTagView", "privacyTagView$delegate", "versionView", "getVersionView", "versionView$delegate", "initAuthorNameClick", "", "onChangeSkinType", "reportAls", "daArea", "", "setAppInfo", "adCard", "Lcom/baidu/tieba/recapp/lego/model/AdCard;", "recApp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NadCustomAppInfoView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public AdvertAppInfo e;
    public d15 f;
    public View.OnClickListener g;
    public Map<Integer, View> h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadCustomAppInfoView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadCustomAppInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            Map<Integer, View> map = this.h;
            View view2 = map.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                if (findViewById != null) {
                    map.put(Integer.valueOf(i), findViewById);
                    return findViewById;
                }
                return null;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadCustomAppInfoView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = new LinkedHashMap();
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.recapp.view.NadCustomAppInfoView$authorNameView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadCustomAppInfoView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.ad_author_full_name);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.recapp.view.NadCustomAppInfoView$versionView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadCustomAppInfoView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.ad_version);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.recapp.view.NadCustomAppInfoView$privacyTagView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadCustomAppInfoView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.ad_privacy);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.recapp.view.NadCustomAppInfoView$permissionTagView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NadCustomAppInfoView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.ad_permission);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.g = new View.OnClickListener() { // from class: com.baidu.tieba.h5a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    NadCustomAppInfoView.b(NadCustomAppInfoView.this, context, view2);
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0696, this);
        getPrivacyTagView().setOnClickListener(this.g);
        getPermissionTagView().setOnClickListener(this.g);
    }

    public /* synthetic */ NadCustomAppInfoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void b(NadCustomAppInfoView this$0, Context context, View view2) {
        String str;
        String str2;
        String str3;
        String str4;
        d15.b bVar;
        d15.b bVar2;
        String str5;
        d15.c cVar;
        d15.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, context, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.f == null) {
                return;
            }
            int id = view2.getId();
            String str6 = null;
            String str7 = "";
            if (id == R.id.ad_privacy) {
                d15 d15Var = this$0.f;
                if (d15Var != null && (cVar2 = d15Var.g) != null) {
                    str3 = cVar2.b;
                } else {
                    str3 = null;
                }
                if (str3 == null) {
                    str3 = "";
                }
                d15 d15Var2 = this$0.f;
                if (d15Var2 != null && (cVar = d15Var2.g) != null) {
                    str5 = cVar.c;
                } else {
                    str5 = null;
                }
                if (str5 != null) {
                    str7 = str5;
                }
                str2 = "app_privacy";
            } else if (id == R.id.ad_permission) {
                d15 d15Var3 = this$0.f;
                if (d15Var3 != null && (bVar2 = d15Var3.h) != null) {
                    str3 = bVar2.b;
                } else {
                    str3 = null;
                }
                if (str3 == null) {
                    str3 = "";
                }
                d15 d15Var4 = this$0.f;
                if (d15Var4 != null && (bVar = d15Var4.h) != null) {
                    str4 = bVar.c;
                } else {
                    str4 = null;
                }
                if (str4 != null) {
                    str7 = str4;
                }
                str2 = "app_permission";
            } else if (id != R.id.ad_author_full_name) {
                str = "";
                str2 = str;
                j3a.a(context, str7, null, null, str);
                this$0.c(str2);
            } else {
                d15 d15Var5 = this$0.f;
                if (d15Var5 != null) {
                    str6 = d15Var5.d;
                }
                BdUtilHelper.showToast(context, str6);
                return;
            }
            String str8 = str7;
            str7 = str3;
            str = str8;
            j3a.a(context, str7, null, null, str);
            this$0.c(str2);
        }
    }

    public final void a() {
        final ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (viewTreeObserver = getAuthorNameView().getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(viewTreeObserver, this) { // from class: com.baidu.tieba.recapp.view.NadCustomAppInfoView$initAuthorNameClick$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ViewTreeObserver a;
            public final /* synthetic */ NadCustomAppInfoView b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {viewTreeObserver, this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = viewTreeObserver;
                this.b = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                int lineCount;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.isAlive()) {
                        this.a.removeOnGlobalLayoutListener(this);
                    }
                    Layout layout = this.b.getAuthorNameView().getLayout();
                    if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                        this.b.getAuthorNameView().setOnClickListener(this.b.getListener());
                    }
                }
            }
        });
    }

    public final d15 getAdAppInfoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (d15) invokeV.objValue;
    }

    public final TextView getAuthorNameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object value = this.a.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-authorNameView>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    public final View.OnClickListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final TextView getPermissionTagView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Object value = this.d.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-permissionTagView>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getPrivacyTagView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Object value = this.c.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-privacyTagView>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getVersionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Object value = this.b.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-versionView>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    public final void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SkinManager.setViewTextColor(getAuthorNameView(), (int) R.color.CAM_X0619);
            SkinManager.setViewTextColor(getVersionView(), (int) R.color.CAM_X0619);
            SkinManager.setViewTextColor(getPrivacyTagView(), (int) R.color.CAM_X0619);
            SkinManager.setViewTextColor(getPermissionTagView(), (int) R.color.CAM_X0619);
        }
    }

    public final void c(String str) {
        String str2;
        Integer num;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.e != null && !TextUtils.isEmpty(str)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            ClogBuilder y = clogBuilder.y(ClogBuilder.LogType.FREE_CLICK);
            AdvertAppInfo advertAppInfo = this.e;
            String str3 = null;
            if (advertAppInfo != null) {
                str2 = advertAppInfo.j;
            } else {
                str2 = null;
            }
            ClogBuilder v = y.v(str2);
            AdvertAppInfo advertAppInfo2 = this.e;
            if (advertAppInfo2 != null) {
                num = Integer.valueOf(advertAppInfo2.position + 1);
            } else {
                num = null;
            }
            ClogBuilder j = v.q(String.valueOf(num)).j(str);
            AdvertAppInfo advertAppInfo3 = this.e;
            if (advertAppInfo3 != null) {
                str3 = advertAppInfo3.g;
            }
            j.p(str3);
            x31.e(clogBuilder);
        }
    }

    public final void setAdAppInfoModel(d15 d15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, d15Var) == null) {
            this.f = d15Var;
        }
    }

    public final void setListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) {
            Intrinsics.checkNotNullParameter(onClickListener, "<set-?>");
            this.g = onClickListener;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setAppInfo(AdCard adCard) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        d15.b bVar;
        String str2;
        boolean z4;
        String str3;
        String str4;
        boolean z5;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adCard) == null) {
            Intrinsics.checkNotNullParameter(adCard, "adCard");
            d15 appInfoModel = adCard.getAppInfoModel();
            String str6 = null;
            if (appInfoModel != null && d15.c(appInfoModel)) {
                this.f = appInfoModel;
                this.e = adCard.getAdvertAppInfo();
                String str7 = appInfoModel.f;
                boolean z6 = true;
                if (str7 != null && !StringsKt__StringsJVMKt.isBlank(str7)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    getVersionView().setText(appInfoModel.f);
                    getVersionView().setVisibility(0);
                } else {
                    getVersionView().setVisibility(8);
                }
                String str8 = appInfoModel.d;
                if (str8 != null && !StringsKt__StringsJVMKt.isBlank(str8)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    getAuthorNameView().setText(getResources().getString(R.string.obfuscated_res_0x7f0f0d4f) + appInfoModel.d);
                    getAuthorNameView().setVisibility(0);
                    a();
                } else {
                    getAuthorNameView().setVisibility(8);
                }
                d15.c cVar = appInfoModel.g;
                if (cVar != null) {
                    str = cVar.b;
                } else {
                    str = null;
                }
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!z3) {
                    d15.c cVar2 = appInfoModel.g;
                    if (cVar2 != null) {
                        str4 = cVar2.a;
                    } else {
                        str4 = null;
                    }
                    if (str4 != null && !StringsKt__StringsJVMKt.isBlank(str4)) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (!z5) {
                        TextView privacyTagView = getPrivacyTagView();
                        StringBuilder sb = new StringBuilder();
                        sb.append(getResources().getString(R.string.obfuscated_res_0x7f0f0d4f));
                        d15.c cVar3 = appInfoModel.g;
                        if (cVar3 != null) {
                            str5 = cVar3.a;
                        } else {
                            str5 = null;
                        }
                        sb.append(str5);
                        privacyTagView.setText(sb.toString());
                        getPrivacyTagView().setVisibility(0);
                        bVar = appInfoModel.h;
                        if (bVar == null) {
                            str2 = bVar.b;
                        } else {
                            str2 = null;
                        }
                        if (str2 == null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        if (!z4) {
                            d15.b bVar2 = appInfoModel.h;
                            if (bVar2 != null) {
                                str3 = bVar2.a;
                            } else {
                                str3 = null;
                            }
                            if (str3 != null && !StringsKt__StringsJVMKt.isBlank(str3)) {
                                z6 = false;
                            }
                            if (!z6) {
                                TextView permissionTagView = getPermissionTagView();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(getResources().getString(R.string.obfuscated_res_0x7f0f0d4f));
                                d15.b bVar3 = appInfoModel.h;
                                if (bVar3 != null) {
                                    str6 = bVar3.a;
                                }
                                sb2.append(str6);
                                permissionTagView.setText(sb2.toString());
                                getPermissionTagView().setVisibility(0);
                                return;
                            }
                        }
                        getPermissionTagView().setVisibility(8);
                        return;
                    }
                }
                getPrivacyTagView().setVisibility(8);
                bVar = appInfoModel.h;
                if (bVar == null) {
                }
                if (str2 == null) {
                }
                z4 = true;
                if (!z4) {
                }
                getPermissionTagView().setVisibility(8);
                return;
            }
            this.f = null;
        }
    }
}
