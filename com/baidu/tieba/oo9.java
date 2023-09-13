package com.baidu.tieba;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class oo9 {
    public static /* synthetic */ Interceptable $ic;
    public static final oo9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948039120, "Lcom/baidu/tieba/oo9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948039120, "Lcom/baidu/tieba/oo9;");
                return;
            }
        }
        a = new oo9();
    }

    public oo9() {
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

    @JvmStatic
    public static final boolean a(aj9 aj9Var, tha thaVar) {
        InterceptResult invokeLL;
        ThreadData O;
        MetaData author;
        String userId;
        String str;
        MetaData t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, aj9Var, thaVar)) == null) {
            if (aj9Var != null && (O = aj9Var.O()) != null && (author = O.getAuthor()) != null && (userId = author.getUserId()) != null) {
                if (thaVar != null && (t = thaVar.t()) != null) {
                    str = t.getUserId();
                } else {
                    str = null;
                }
                return userId.equals(str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @JvmStatic
    public static final void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, aj9 aj9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, pbCommenFloorItemViewHolder, thaVar, aj9Var) == null) && thaVar != null && aj9Var != null) {
            if (pbCommenFloorItemViewHolder != null) {
                imageView = pbCommenFloorItemViewHolder.H;
            } else {
                imageView = null;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    @JvmStatic
    public static final void d(TextView textView, aj9 aj9Var, String str) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, textView, aj9Var, str) == null) {
            if (textView != null) {
                obj = textView.getTag();
            } else {
                obj = null;
            }
            if (!(obj instanceof tha)) {
                return;
            }
            e(textView, (tha) obj, aj9Var, str);
        }
    }

    @JvmStatic
    public static final boolean c(aj9 aj9Var) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aj9Var)) == null) {
            if (aj9Var != null && (O = aj9Var.O()) != null) {
                return O.isBlocked();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final void e(TextView textView, tha thaVar, aj9 aj9Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65542, null, textView, thaVar, aj9Var, str) == null) && textView != null && thaVar != null) {
            textView.setTag(thaVar);
            if (aj9Var != null && aj9Var.j0()) {
                thaVar.p1(Boolean.FALSE);
                thaVar.d1(0);
                textView.setTag(null);
            } else if (thaVar.t() != null) {
                MetaData t = thaVar.t();
                Intrinsics.checkNotNullExpressionValue(t, "postData.author");
                if (str != null && !Intrinsics.areEqual(str, "0") && Intrinsics.areEqual(str, t.getUserId())) {
                    thaVar.p1(Boolean.TRUE);
                    thaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    EMManager.from(textView).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setTextColor(R.color.CAM_X0302).setBorderColor(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && thaVar.C0()) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    thaVar.p1(Boolean.TRUE);
                    thaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual("manager", t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    thaVar.p1(Boolean.TRUE);
                    thaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST, t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    thaVar.p1(Boolean.TRUE);
                    thaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual("pri_content_assist", t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    thaVar.p1(Boolean.TRUE);
                    thaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual("pri_manage_assist", t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    thaVar.p1(Boolean.TRUE);
                    thaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    thaVar.p1(Boolean.FALSE);
                    thaVar.d1(0);
                }
            } else {
                thaVar.p1(Boolean.FALSE);
                thaVar.d1(0);
            }
        }
    }
}
