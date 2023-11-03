package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class qj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(Activity activity, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, activity, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                String string = activity.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "getString(defaultResId)");
                return string;
            }
            return str;
        }
        return (String) invokeLLI.objValue;
    }

    public static final void b(Object result, Activity activity) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, result, activity) == null) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(activity, "activity");
            View decorView = activity.getWindow().getDecorView();
            ForumManageModel.b bVar = null;
            if (decorView instanceof ViewGroup) {
                viewGroup = (ViewGroup) decorView;
            } else {
                viewGroup = null;
            }
            if (viewGroup == null) {
                return;
            }
            if (result instanceof ForumManageModel.b) {
                bVar = (ForumManageModel.b) result;
            }
            if (bVar == null) {
                return;
            }
            if (bVar.d != 0) {
                if (bVar.h) {
                    new BdTopToast(activity).setIcon(false).setContent(activity.getString(R.string.shield_fail)).show(viewGroup);
                } else {
                    new BdTopToast(activity).setIcon(false).setContent(activity.getString(R.string.delete_fail)).show(viewGroup);
                }
            } else if (bVar.a) {
                String str = bVar.i;
                if (str != null) {
                    mq6.b().c(new fi7(activity, CollectionsKt__CollectionsJVMKt.listOf(str), 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, str));
                }
                if (bVar.h) {
                    new BdTopToast(activity).setIcon(true).setContent(activity.getString(R.string.shield_success)).show(viewGroup);
                } else {
                    new BdTopToast(activity).setIcon(true).setContent(activity.getString(R.string.delete_success)).show(viewGroup);
                }
            } else {
                String str2 = bVar.b;
                Intrinsics.checkNotNullExpressionValue(str2, "data.mErrString");
                String a = a(activity, str2, R.string.delete_fail);
                if (bVar.c == 1211066) {
                    pj7.c(activity, a);
                } else {
                    new BdTopToast(activity).setIcon(false).setContent(a).show(viewGroup);
                }
            }
        }
    }

    public static final void c(Object result, Activity activity) {
        ForumManageModel.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, result, activity) == null) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (result instanceof ForumManageModel.d) {
                dVar = (ForumManageModel.d) result;
            } else {
                dVar = null;
            }
            int i = R.string.mute_fail;
            if (dVar == null) {
                BdUtilHelper.showToast(activity, activity.getString(R.string.mute_fail));
                return;
            }
            String str = dVar.b;
            Intrinsics.checkNotNullExpressionValue(str, "retData.mErrString");
            if (dVar.a) {
                i = R.string.mute_success;
            }
            BdUtilHelper.showToast(activity, a(activity, str, i));
        }
    }

    public static final void d(Object result, Activity activity, Function1<? super ArrayList<rx4>, Unit> successCallback) {
        ForumManageModel.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, result, activity, successCallback) == null) {
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(successCallback, "successCallback");
            if (result instanceof ForumManageModel.g) {
                gVar = (ForumManageModel.g) result;
            } else {
                gVar = null;
            }
            if (gVar != null && gVar.a) {
                successCallback.invoke(((ForumManageModel.g) result).c);
            } else {
                BdUtilHelper.showToast(activity, activity.getString(R.string.operation_failed));
            }
        }
    }
}
