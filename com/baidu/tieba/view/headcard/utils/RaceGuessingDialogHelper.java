package com.baidu.tieba.view.headcard.utils;

import android.app.Activity;
import android.app.Dialog;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.aqa;
import com.baidu.tieba.t6b;
import com.baidu.tieba.view.headcard.utils.RaceGuessingDialogHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J(\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper;", "", "()V", "verifyingNicknameTBAlertBuilder", "Lcom/baidu/tbadk/core/dialog/TBAlertBuilder;", "getContentTextColor", "", "contentBean", "Lcom/baidu/tieba/view/headcard/data/RaceGuessingDialogData$PopupDialogContent;", "getSpannableString", "Landroid/text/SpannableString;", "contentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "activity", "Landroid/app/Activity;", "onDetachedFromWindow", "", "showRaceGuessingDialog", "raceGuessingDialogData", "Lcom/baidu/tieba/view/headcard/data/RaceGuessingDialogData;", "dialogClickCallback", "Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper$IDialogClickCallback;", "Companion", "IDialogClickCallback", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class RaceGuessingDialogHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBAlertBuilder a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(630775976, "Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(630775976, "Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper;");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper$IDialogClickCallback;", "", "onClick", "", PushConstants.CLICK_TYPE, "Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper$IDialogClickCallback$ClickType;", "ClickType", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public interface IDialogClickCallback {
        void a(ClickType clickType);

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper$IDialogClickCallback$ClickType;", "", "(Ljava/lang/String;I)V", "CANCEL", "CONFIRM", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class ClickType {
            public static final /* synthetic */ ClickType[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final ClickType CANCEL;
            public static final ClickType CONFIRM;
            public transient /* synthetic */ FieldHolder $fh;

            public static final /* synthetic */ ClickType[] $values() {
                return new ClickType[]{CANCEL, CONFIRM};
            }

            public static ClickType valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ClickType) Enum.valueOf(ClickType.class, str) : (ClickType) invokeL.objValue;
            }

            public static ClickType[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ClickType[]) $VALUES.clone() : (ClickType[]) invokeV.objValue;
            }

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1204210736, "Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper$IDialogClickCallback$ClickType;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1204210736, "Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper$IDialogClickCallback$ClickType;");
                        return;
                    }
                }
                CANCEL = new ClickType("CANCEL", 0);
                CONFIRM = new ClickType("CONFIRM", 1);
                $VALUES = $values();
            }

            public ClickType(String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                    }
                }
            }
        }
    }

    public RaceGuessingDialogHelper() {
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

    public final void c() {
        TBAlertBuilder tBAlertBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (tBAlertBuilder = this.a) != null) {
            tBAlertBuilder.dismiss();
        }
    }

    public static final void e(Dialog dialog, IDialogClickCallback iDialogClickCallback, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, dialog, iDialogClickCallback, view2) == null) && dialog.isShowing()) {
            dialog.dismiss();
            if (iDialogClickCallback != null) {
                iDialogClickCallback.a(IDialogClickCallback.ClickType.CANCEL);
            }
        }
    }

    public static final void f(Dialog dialog, IDialogClickCallback iDialogClickCallback, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, dialog, iDialogClickCallback, view2) == null) && dialog.isShowing()) {
            dialog.dismiss();
            if (iDialogClickCallback != null) {
                iDialogClickCallback.a(IDialogClickCallback.ClickType.CONFIRM);
            }
        }
    }

    public final String a(t6b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                return aVar.d();
            }
            return aVar.c();
        }
        return (String) invokeL.objValue;
    }

    public final SpannableString b(ArrayList<t6b.a> arrayList, Activity activity) {
        InterceptResult invokeLL;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, activity)) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<t6b.a> it = arrayList.iterator();
            while (it.hasNext()) {
                t6b.a next = it.next();
                if (!StringUtils.isNull(next.b())) {
                    sb.append(next.b());
                }
            }
            if (StringsKt__StringsJVMKt.isBlank(sb)) {
                return new SpannableString(activity.getString(R.string.confirm_hint_content));
            }
            SpannableString spannableString = new SpannableString(sb);
            StringBuilder sb2 = new StringBuilder();
            Iterator<t6b.a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                t6b.a contentBean = it2.next();
                Intrinsics.checkNotNullExpressionValue(contentBean, "contentBean");
                String a = a(contentBean);
                boolean z2 = false;
                if (contentBean.a() == 1) {
                    if (a != null && !StringsKt__StringsJVMKt.isBlank(a)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aqa.f(a));
                        int length = sb2.length();
                        int length2 = sb2.length();
                        String b = contentBean.b();
                        if (b != null) {
                            i = b.length();
                        } else {
                            i = 0;
                        }
                        spannableString.setSpan(foregroundColorSpan, length, length2 + i, 33);
                    }
                }
                String b2 = contentBean.b();
                if (!((b2 == null || StringsKt__StringsJVMKt.isBlank(b2)) ? true : true)) {
                    sb2.append(contentBean.b());
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    @JvmOverloads
    public final void d(Activity activity, t6b raceGuessingDialogData, final IDialogClickCallback iDialogClickCallback) {
        boolean z;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, raceGuessingDialogData, iDialogClickCallback) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(raceGuessingDialogData, "raceGuessingDialogData");
            ArrayList<t6b.a> a = raceGuessingDialogData.a();
            if (ListUtils.isEmpty(a)) {
                return;
            }
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.think_more, TBAlertConfig.OperateBtnStyle.SECONDARY);
            final AlertDialog alertDialog = null;
            TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f04ca, TBAlertConfig.OperateBtnStyle.MAIN, (View.OnClickListener) null);
            String b = raceGuessingDialogData.b();
            if (b != null && !StringsKt__StringsJVMKt.isBlank(b)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                string = raceGuessingDialogData.b();
            } else {
                string = activity.getString(R.string.confirm_hint);
            }
            TBAlertBuilder cancelable = new TBAlertBuilder(activity).setTitleStr(string).setDescStr(b(a, activity)).setDescGravity(3).setOperateBtn(operateBtnConfig, operateBtnConfig2).setCancelable(true);
            this.a = cancelable;
            if (cancelable != null) {
                alertDialog = cancelable.show();
            }
            if (alertDialog != null) {
                operateBtnConfig.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.e7b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            RaceGuessingDialogHelper.e(alertDialog, iDialogClickCallback, view2);
                        }
                    }
                });
                operateBtnConfig2.setListener(new View.OnClickListener() { // from class: com.baidu.tieba.f7b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            RaceGuessingDialogHelper.f(alertDialog, iDialogClickCallback, view2);
                        }
                    }
                });
            }
        }
    }
}
