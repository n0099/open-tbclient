package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.TagsInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public final class kq9 {
    public static /* synthetic */ Interceptable $ic;
    public static final kq9 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947921878, "Lcom/baidu/tieba/kq9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947921878, "Lcom/baidu/tieba/kq9;");
                return;
            }
        }
        a = new kq9();
    }

    public kq9() {
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
    public static final boolean A(lk9 lk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lk9Var)) == null) {
            if (lk9Var != null) {
                return lk9Var.j0();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final String n(ThreadData threadData) {
        InterceptResult invokeL;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, threadData)) == null) {
            if (threadData == null || (l = Long.valueOf(threadData.getFid()).toString()) == null) {
                return "";
            }
            return l;
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final String o(lk9 lk9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, lk9Var)) == null) {
            if (lk9Var != null) {
                str = lk9Var.l();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final String p(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, threadData)) == null) {
            if (threadData != null) {
                str = threadData.getForum_name();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final String q(lk9 lk9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, lk9Var)) == null) {
            if (lk9Var != null) {
                str = lk9Var.m();
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final ar9 r(ym9<?> ym9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, ym9Var)) == null) {
            if (ym9Var != null) {
                return ym9Var.Y0();
            }
            return null;
        }
        return (ar9) invokeL.objValue;
    }

    @JvmStatic
    public static final ar9 s(ot9 ot9Var) {
        InterceptResult invokeL;
        AbsPbActivity m0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, ot9Var)) == null) {
            if (ot9Var != null && (m0 = ot9Var.m0()) != null) {
                return m0.c;
            }
            return null;
        }
        return (ar9) invokeL.objValue;
    }

    @JvmStatic
    public static final int t(lk9 lk9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, lk9Var)) == null) {
            if (lk9Var != null) {
                return lk9Var.W();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @JvmStatic
    public static final int u(ym9<?> ym9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, ym9Var)) == null) {
            if (ym9Var != null) {
                return ym9Var.q0();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @JvmStatic
    public static final boolean v(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, threadData)) == null) {
            if (threadData != null) {
                return threadData.isBlocked();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean w(lk9 lk9Var) {
        InterceptResult invokeL;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, lk9Var)) == null) {
            if (lk9Var != null && (O = lk9Var.O()) != null) {
                return O.isBlocked();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean x(ym9<?> ym9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, ym9Var)) == null) {
            if (ym9Var != null) {
                return ym9Var.Q0();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean y(ot9 ot9Var) {
        InterceptResult invokeL;
        AbsPbActivity m0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, ot9Var)) == null) {
            if (ot9Var != null && (m0 = ot9Var.m0()) != null) {
                return m0.Q0();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final boolean z(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, threadData)) == null) {
            if (threadData != null) {
                return threadData.isUgcThreadType();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @JvmStatic
    public static final void B(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zja zjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, pbCommenFloorItemViewHolder, zjaVar) == null) {
            boolean z = true;
            z = (zjaVar == null || !zjaVar.y0()) ? false : false;
            AgreeView agreeView = null;
            if (!z) {
                if (pbCommenFloorItemViewHolder != null) {
                    agreeView = pbCommenFloorItemViewHolder.d0;
                }
                if (agreeView != null) {
                    agreeView.setVisibility(0);
                    return;
                }
                return;
            }
            if (pbCommenFloorItemViewHolder != null) {
                agreeView = pbCommenFloorItemViewHolder.d0;
            }
            if (agreeView != null) {
                agreeView.setVisibility(8);
            }
        }
    }

    @JvmStatic
    public static final boolean b(ThreadData threadData, zja zjaVar) {
        InterceptResult invokeLL;
        MetaData author;
        String userId;
        String str;
        MetaData t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, threadData, zjaVar)) == null) {
            if (threadData != null && (author = threadData.getAuthor()) != null && (userId = author.getUserId()) != null) {
                if (zjaVar != null && (t = zjaVar.t()) != null) {
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
    public static final void C(TextView textView, lk9 lk9Var, String str) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView, lk9Var, str) == null) {
            if (textView != null) {
                obj = textView.getTag();
            } else {
                obj = null;
            }
            if (!(obj instanceof zja)) {
                return;
            }
            E(textView, (zja) obj, str, A(lk9Var));
        }
    }

    @JvmStatic
    public static final void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zja zjaVar, lk9 lk9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, pbCommenFloorItemViewHolder, zjaVar, lk9Var) == null) && zjaVar != null && lk9Var != null) {
            if (pbCommenFloorItemViewHolder != null) {
                imageView = pbCommenFloorItemViewHolder.I;
            } else {
                imageView = null;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public static final void j(Context context, int i, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65553, null, context, i, view2) != null) || context == null) {
            return;
        }
        CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, i);
        BrowserHelper.startWebActivity(context, (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
    }

    @JvmStatic
    public static final void D(TextView textView, zja zjaVar, lk9 lk9Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, textView, zjaVar, lk9Var, str) == null) {
            E(textView, zjaVar, str, A(lk9Var));
        }
    }

    @JvmStatic
    public static final void E(TextView textView, zja zjaVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{textView, zjaVar, str, Boolean.valueOf(z)}) == null) {
            F(textView, zjaVar, str, z, null);
        }
    }

    @JvmStatic
    public static final void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zja zjaVar, lk9 lk9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65548, null, pbCommenFloorItemViewHolder, zjaVar, lk9Var, i) == null) {
            d(pbCommenFloorItemViewHolder, zjaVar, i, A(lk9Var));
        }
    }

    @JvmStatic
    public static final void F(TextView textView, zja zjaVar, String str, boolean z, om9 om9Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{textView, zjaVar, str, Boolean.valueOf(z), om9Var}) == null) && textView != null && zjaVar != null) {
            if (om9Var != null) {
                om9Var.setVisibility(8);
            }
            textView.setTag(zjaVar);
            if (z) {
                zjaVar.p1(Boolean.FALSE);
                zjaVar.d1(0);
                textView.setTag(null);
            } else if (zjaVar.t() != null) {
                MetaData t = zjaVar.t();
                Intrinsics.checkNotNullExpressionValue(t, "postData.author");
                if (str != null && !Intrinsics.areEqual(str, "0") && Intrinsics.areEqual(str, t.getUserId())) {
                    zjaVar.p1(Boolean.TRUE);
                    zjaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    EMManager.from(textView).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setTextColor(R.color.CAM_X0302).setBorderColor(R.color.CAM_X0302);
                    return;
                }
                boolean z3 = true;
                if (t.getIs_bawu() == 1 && zjaVar.C0()) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    zjaVar.p1(Boolean.TRUE);
                    zjaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual("manager", t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    zjaVar.p1(Boolean.TRUE);
                    zjaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST, t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    zjaVar.p1(Boolean.TRUE);
                    zjaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual("pri_content_assist", t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    zjaVar.p1(Boolean.TRUE);
                    zjaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && Intrinsics.areEqual("pri_manage_assist", t.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    zjaVar.p1(Boolean.TRUE);
                    zjaVar.d1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    ArrayList<TagsInfo> tags = t.getTags();
                    if (tags != null && !tags.isEmpty()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        zjaVar.p1(Boolean.FALSE);
                        ThemeColorInfo info = t.getTags().get(0).img_info;
                        Intrinsics.checkNotNullExpressionValue(info, "info");
                        if (jta.g(info).length() != 0) {
                            z3 = false;
                        }
                        if (z3) {
                            zjaVar.d1(0);
                            if (om9Var != null) {
                                om9Var.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        zjaVar.d1(jta.i(info));
                        if (om9Var != null) {
                            f(om9Var, info);
                            return;
                        }
                        return;
                    }
                    zjaVar.p1(Boolean.FALSE);
                    zjaVar.d1(0);
                }
            } else {
                zjaVar.p1(Boolean.FALSE);
                zjaVar.d1(0);
            }
        }
    }

    @JvmStatic
    public static final void a(zja zjaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, ar9 ar9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65544, null, zjaVar, pbCommenFloorItemViewHolder, ar9Var, i) == null) {
            if (pbCommenFloorItemViewHolder.H != null && zjaVar.t() != null) {
                pbCommenFloorItemViewHolder.H.setTag(R.id.tag_user_id, zjaVar.t().getUserId());
                if (ar9Var != null) {
                    pbCommenFloorItemViewHolder.H.setOnClickListener(ar9Var.c);
                }
                ArrayList<IconData> iconInfo = zjaVar.t().getIconInfo();
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.H.g(iconInfo, i, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            Boolean h0 = zjaVar.h0();
            Intrinsics.checkNotNullExpressionValue(h0, "postData.showIdentify");
            if (h0.booleanValue() && !zjaVar.T()) {
                pbCommenFloorItemViewHolder.i.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.i.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zja zjaVar, int i, boolean z) {
        boolean z2;
        String str;
        boolean z3;
        sh5 a0;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{pbCommenFloorItemViewHolder, zjaVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && zjaVar != null) {
            boolean z4 = true;
            if (zjaVar.L() > 0 && !z) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b35);
                Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.is_floor)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(zjaVar.L())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z2 = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z2 = false;
            }
            String str2 = null;
            if (zjaVar.t() != null) {
                str = zjaVar.t().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z3 = true;
                    a0 = zjaVar.a0();
                    if (a0 != null) {
                        str2 = a0.b();
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    z4 = (a0 != null || StringUtils.isNull(str2) || z) ? false : false;
                    if (!z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                        i2 = i;
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                        i2 = 0;
                    }
                    if (z4 && !z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                        i3 = 0;
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        i3 = i;
                    }
                    pbCommenFloorItemViewHolder.l.setPadding(i2, 0, i3, 0);
                    if (!Intrinsics.areEqual(StringUtils.SimpleDateFormat(new Date(), "yyyy"), StringUtils.SimpleDateFormat(new Date(zjaVar.q0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(zjaVar.q0()));
                    } else {
                        pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(zjaVar.q0()));
                    }
                    if (!z3) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setText(str);
                    } else if (z4) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setPadding(i, 0, 0, 0);
                        if (zjaVar.d0) {
                            pbCommenFloorItemViewHolder.o.setText(StringHelper.cutStringWithSuffix(str2, 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.o.setText(str2);
                        }
                    } else {
                        pbCommenFloorItemViewHolder.o.setVisibility(8);
                    }
                    pbCommenFloorItemViewHolder.g0.setText(((Object) pbCommenFloorItemViewHolder.l.getText()) + "  • ");
                }
            } else {
                str = null;
            }
            z3 = false;
            a0 = zjaVar.a0();
            if (a0 != null) {
            }
            if (str2 == null) {
            }
            if (a0 != null) {
            }
            if (!z2) {
            }
            if (z4) {
            }
            pbCommenFloorItemViewHolder.n.setVisibility(0);
            i3 = i;
            pbCommenFloorItemViewHolder.l.setPadding(i2, 0, i3, 0);
            if (!Intrinsics.areEqual(StringUtils.SimpleDateFormat(new Date(), "yyyy"), StringUtils.SimpleDateFormat(new Date(zjaVar.q0()), "yyyy"))) {
            }
            if (!z3) {
            }
            pbCommenFloorItemViewHolder.g0.setText(((Object) pbCommenFloorItemViewHolder.l.getText()) + "  • ");
        }
    }

    @JvmStatic
    public static final void f(om9 identityImageView, ThemeColorInfo imgInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, identityImageView, imgInfo) == null) {
            Intrinsics.checkNotNullParameter(identityImageView, "identityImageView");
            Intrinsics.checkNotNullParameter(imgInfo, "imgInfo");
            String g = jta.g(imgInfo);
            if (g.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                identityImageView.setVisibility(8);
                return;
            }
            int h = jta.h(imgInfo);
            int i = jta.i(imgInfo);
            identityImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ViewGroup.LayoutParams layoutParams = identityImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = h;
            }
            if (layoutParams != null) {
                layoutParams.width = i;
            }
            identityImageView.setVisibility(0);
            identityImageView.startLoad(g);
        }
    }

    @JvmStatic
    public static final void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zja zjaVar, View rootView, int i, ThreadData threadData, String str, ar9 ar9Var, int i2, StatisticItem statisticItem, Context context, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{pbCommenFloorItemViewHolder, zjaVar, rootView, Integer.valueOf(i), threadData, str, ar9Var, Integer.valueOf(i2), statisticItem, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            i(pbCommenFloorItemViewHolder, zjaVar, rootView, threadData, i, str, ar9Var, i2, statisticItem, context, n(threadData), p(threadData), z, z2, i3, z(threadData));
        }
    }

    @JvmStatic
    public static final void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zja zjaVar, View rootView, int i, lk9 lk9Var, String str, ar9 ar9Var, int i2, StatisticItem statisticItem, Context context, boolean z, boolean z2, int i3) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{pbCommenFloorItemViewHolder, zjaVar, rootView, Integer.valueOf(i), lk9Var, str, ar9Var, Integer.valueOf(i2), statisticItem, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            if (lk9Var != null) {
                threadData = lk9Var.O();
            } else {
                threadData = null;
            }
            ThreadData threadData2 = threadData;
            i(pbCommenFloorItemViewHolder, zjaVar, rootView, threadData2, i, str, ar9Var, i2, statisticItem, context, o(lk9Var), q(lk9Var), z, z2, i3, z(threadData2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x05d8, code lost:
        if (r9.length() != 0) goto L178;
     */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x062c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0725  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void i(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final zja zjaVar, View view2, ThreadData threadData, int i, String str, ar9 ar9Var, int i2, StatisticItem statisticItem, final Context context, String str2, String str3, boolean z, boolean z2, int i3, boolean z3) {
        String str4;
        Object obj;
        String str5;
        int i4;
        final String str6;
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        String userId;
        boolean z11;
        boolean z12;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{pbCommenFloorItemViewHolder, zjaVar, view2, threadData, Integer.valueOf(i), str, ar9Var, Integer.valueOf(i2), statisticItem, context, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) && pbCommenFloorItemViewHolder != null && zjaVar != null && threadData != null) {
            if (zjaVar.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.q.setTag(null);
            pbCommenFloorItemViewHolder.q.setUserId(null);
            pbCommenFloorItemViewHolder.q.setTargetScheme("");
            pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.F.getHeadView().setTargetScheme("");
            pbCommenFloorItemViewHolder.r.setIsHost(false);
            if (zjaVar.t() == null) {
                str4 = "";
                obj = "0";
            } else {
                if (str != null && !Intrinsics.areEqual("0", str) && Intrinsics.areEqual(str, zjaVar.t().getUserId())) {
                    pbCommenFloorItemViewHolder.r.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = zjaVar.t().getIconInfo();
                ArrayList<IconData> tShowInfoNew = zjaVar.t().getTShowInfoNew();
                str4 = "";
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                obj = "0";
                int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                if (iconInfo.size() < 2) {
                    int size = iconInfo.size();
                    if (size > 1) {
                        zjaVar.x1((dimens * size) + (dimens2 * size));
                    } else if (size == 1) {
                        zjaVar.x1(dimens + dimens2);
                    } else {
                        zjaVar.x1(0);
                    }
                } else {
                    zjaVar.x1((dimens * 2) + (dimens2 * 2));
                }
                if (pbCommenFloorItemViewHolder.G != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (ar9Var != null) {
                        pbCommenFloorItemViewHolder.G.setOnClickListener(ar9Var.e);
                    }
                    int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, dimens3, dimens3, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !zjaVar.t().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, i2, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = zjaVar.t().getAvater();
                String avatarUrl = zjaVar.t().getAvatarUrl();
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_id, zjaVar.t().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_target_scheme, zjaVar.t().getTargetScheme());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, zjaVar.t().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, zjaVar.t().getVirtualUserUrl());
                if (statisticItem != null) {
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, statisticItem);
                }
                String name_show = zjaVar.t().getName_show();
                String userName = zjaVar.t().getUserName();
                if (NickNameActivitySwitch.isOn() && !TextUtils.equals(name_show, userName)) {
                    pbCommenFloorItemViewHolder.h.setText(pi9.b(context, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, pi9.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (zjaVar.t().getPendantData() != null && !StringUtils.isNull(zjaVar.t().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.F.i(zjaVar.t());
                    pbCommenFloorItemViewHolder.q.setVisibility(8);
                    pbCommenFloorItemViewHolder.F.setVisibility(0);
                    qm9.a(pbCommenFloorItemViewHolder.F.getHeadView(), avatarUrl, avater, 28);
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserId(zjaVar.t().getUserId());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTargetScheme(zjaVar.t().getTargetScheme());
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserName(zjaVar.t().getUserName());
                    pbCommenFloorItemViewHolder.F.getHeadView().setFid(str2);
                    pbCommenFloorItemViewHolder.F.getHeadView().setFName(str3);
                    pbCommenFloorItemViewHolder.F.getHeadView().setFloor(zjaVar.L());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTid(zjaVar.U());
                    if (statisticItem != null) {
                        pbCommenFloorItemViewHolder.F.getHeadView().setTag(R.id.tag_statistic_item, statisticItem);
                    }
                    pbCommenFloorItemViewHolder.F.i(zjaVar.t());
                } else {
                    pbCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.q, zjaVar.t(), 4);
                    pbCommenFloorItemViewHolder.q.setUserId(zjaVar.t().getUserId());
                    pbCommenFloorItemViewHolder.q.setTargetScheme(zjaVar.t().getTargetScheme());
                    pbCommenFloorItemViewHolder.q.setFid(str2);
                    pbCommenFloorItemViewHolder.q.setFName(str3);
                    pbCommenFloorItemViewHolder.q.setFloor(zjaVar.L());
                    pbCommenFloorItemViewHolder.q.setTid(zjaVar.U());
                    pbCommenFloorItemViewHolder.q.setUserName(zjaVar.t().getUserName(), zjaVar.t0());
                    pbCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, zjaVar.t().getVirtualUserUrl());
                    if (statisticItem != null) {
                        pbCommenFloorItemViewHolder.q.setTag(R.id.tag_statistic_item, statisticItem);
                    }
                    pbCommenFloorItemViewHolder.q.setImageDrawable(null);
                    qm9.a(pbCommenFloorItemViewHolder.q, avatarUrl, avater, 28);
                    pbCommenFloorItemViewHolder.q.setVisibility(0);
                    pbCommenFloorItemViewHolder.F.setVisibility(8);
                }
                if (zjaVar.t() != null && zjaVar.t().getAlaInfo() != null && zjaVar.t().getAlaUserData() != null && zjaVar.t().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.d(true);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.q.setAlaInfo(zjaVar.t().getAlaInfo());
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(zjaVar.t().getAlaInfo());
                } else {
                    pbCommenFloorItemViewHolder.d(false);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(0);
                    pbCommenFloorItemViewHolder.q.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(null);
                }
                F(pbCommenFloorItemViewHolder.i, zjaVar, str, z3, pbCommenFloorItemViewHolder.j);
                if (z && TbSingleton.getInstance().isUserGrowthOpen() && zjaVar.t().getUserGrowthData() != null) {
                    final int a2 = zjaVar.t().getUserGrowthData().a();
                    if (a2 >= 0 && a2 < 11) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        pbCommenFloorItemViewHolder.k.setImageResource(dx.b(a2));
                        pbCommenFloorItemViewHolder.k.setVisibility(0);
                        pbCommenFloorItemViewHolder.k.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.iq9
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                                    kq9.j(context, a2, view3);
                                }
                            }
                        });
                        CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                    } else {
                        pbCommenFloorItemViewHolder.k.setVisibility(8);
                    }
                }
            }
            if (z2 && zjaVar.t() != null) {
                i4 = zjaVar.t().getLevel_id();
                str5 = zjaVar.t().getLevelName();
            } else {
                str5 = str4;
                i4 = 0;
            }
            if (z3) {
                i4 = 0;
            }
            if (i4 > 0) {
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setLevel(i4, str5);
            } else {
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (z) {
                if (zjaVar.W() == 1 && threadData.isQuestionThread() && !b(threadData, zjaVar)) {
                    zjaVar.b1(true);
                    pbCommenFloorItemViewHolder.y0.setVisibility(0);
                    Boolean V = zjaVar.V();
                    Intrinsics.checkNotNullExpressionValue(V, "postData.getIsShowAskView()");
                    if (V.booleanValue()) {
                        pbCommenFloorItemViewHolder.z0.setVisibility(0);
                        pbCommenFloorItemViewHolder.d0.setVisibility(8);
                        pbCommenFloorItemViewHolder.e0.setVisibility(8);
                        pbCommenFloorItemViewHolder.z0.postDelayed(new Runnable() { // from class: com.baidu.tieba.hq9
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    kq9.k(PbCommenFloorItemViewHolder.this, zjaVar);
                                }
                            }
                        }, 3000L);
                    } else {
                        pbCommenFloorItemViewHolder.z0.setVisibility(8);
                        B(pbCommenFloorItemViewHolder, zjaVar);
                        pbCommenFloorItemViewHolder.e0.setVisibility(0);
                    }
                } else {
                    zjaVar.b1(false);
                    pbCommenFloorItemViewHolder.y0.setVisibility(8);
                    pbCommenFloorItemViewHolder.z0.setVisibility(8);
                    B(pbCommenFloorItemViewHolder, zjaVar);
                    pbCommenFloorItemViewHolder.e0.setVisibility(0);
                }
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.y0, R.color.CAM_X0204);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x0, R.color.CAM_X0105, 1);
            }
            a(zjaVar, pbCommenFloorItemViewHolder, ar9Var, 2);
            if (zjaVar.t() != null && zjaVar.t().getName_show() != null) {
                str6 = zjaVar.t().getName_show();
            } else {
                str6 = str4;
            }
            pbCommenFloorItemViewHolder.f.post(new Runnable() { // from class: com.baidu.tieba.jq9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kq9.l(PbCommenFloorItemViewHolder.this, str6);
                    }
                }
            });
            if (!StringUtils.isNull(zjaVar.t().getDiplayIntro())) {
                pbCommenFloorItemViewHolder.A0.setVisibility(0);
                pbCommenFloorItemViewHolder.A0.setText(zjaVar.t().getDiplayIntro());
            } else {
                pbCommenFloorItemViewHolder.A0.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, zjaVar);
            sparseArray.put(R.id.tag_load_sub_data, zjaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(zjaVar.L()));
            sparseArray.put(R.id.tag_forbid_user_post_id, zjaVar.U());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.p);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.d0);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.z);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.A);
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.valueOf(z3));
            if (zjaVar.t() != null && !StringUtils.isNull(zjaVar.t().getVirtualUserUrl())) {
                i5 = i3;
                z4 = true;
            } else {
                i5 = i3;
                z4 = false;
            }
            if (i5 != 0 && !v(threadData)) {
                if (i5 != 1002 && i5 != 3) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (i5 != 3 && !z3) {
                    z5 = true;
                    z6 = true;
                } else {
                    z5 = false;
                    z6 = false;
                }
                if (zjaVar.t() != null) {
                    String userId2 = zjaVar.t().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z11 = false;
                    }
                    if (userId2 != null) {
                        if (!Intrinsics.areEqual(obj, userId2)) {
                        }
                    }
                }
                z7 = z11;
                if (threadData.getAuthor() != null && zjaVar.t() != null) {
                    userId = threadData.getAuthor().getUserId();
                    String userId3 = zjaVar.t().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        if (UtilHelper.isCurrentAccount(userId3)) {
                            z8 = false;
                            z5 = true;
                            z9 = true;
                        } else {
                            z8 = true;
                            z5 = true;
                            z9 = false;
                        }
                        z10 = true;
                        if (zjaVar.t() != null && UtilHelper.isCurrentAccount(zjaVar.t().getUserId())) {
                            z5 = true;
                            z9 = true;
                        }
                        if (z4) {
                            z8 = false;
                            z5 = false;
                            z7 = false;
                        }
                        int i6 = 1;
                        if (zjaVar.L() == 1) {
                            i6 = 0;
                        }
                        if (z3) {
                            z8 = false;
                            z7 = false;
                        }
                        if (z7) {
                            sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
                            if (zjaVar.t() != null) {
                                sparseArray.put(R.id.tag_forbid_user_name, zjaVar.t().getUserName());
                                sparseArray.put(R.id.tag_forbid_user_name_show, zjaVar.t().getName_show());
                                sparseArray.put(R.id.tag_forbid_user_portrait, zjaVar.t().getPortrait());
                            }
                        } else {
                            sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                        }
                        if (z8) {
                            sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (zjaVar.t() != null) {
                                sparseArray.put(R.id.tag_user_mute_mute_userid, zjaVar.t().getUserId());
                                sparseArray.put(R.id.tag_user_mute_mute_username, zjaVar.t().getUserName());
                                sparseArray.put(R.id.tag_user_mute_mute_nameshow, zjaVar.t().getName_show());
                            }
                            sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                            sparseArray.put(R.id.tag_user_mute_post_id, zjaVar.U());
                        } else {
                            sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(zjaVar.A0()));
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
                            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z9));
                            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                            sparseArray.put(R.id.tag_del_post_id, zjaVar.U());
                        } else {
                            sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z10));
                        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                        pbCommenFloorItemViewHolder.t.setTag(sparseArray);
                    }
                }
                z8 = false;
                z9 = false;
                z10 = false;
                if (zjaVar.t() != null) {
                    z5 = true;
                    z9 = true;
                }
                if (z4) {
                }
                int i62 = 1;
                if (zjaVar.L() == 1) {
                }
                if (z3) {
                }
                if (z7) {
                }
                if (z8) {
                }
                if (z5) {
                }
                sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z6));
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z10));
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (threadData.getAuthor() != null) {
                userId = threadData.getAuthor().getUserId();
                String userId32 = zjaVar.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z8 = false;
            z9 = false;
            z10 = false;
            if (zjaVar.t() != null) {
            }
            if (z4) {
            }
            int i622 = 1;
            if (zjaVar.L() == 1) {
            }
            if (z3) {
            }
            if (z7) {
            }
            if (z8) {
            }
            if (z5) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z6));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z10));
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
        }
    }

    public static final void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zja zjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, pbCommenFloorItemViewHolder, zjaVar) == null) {
            pbCommenFloorItemViewHolder.z0.setVisibility(8);
            B(pbCommenFloorItemViewHolder, zjaVar);
            pbCommenFloorItemViewHolder.e0.setVisibility(0);
        }
    }

    @JvmStatic
    public static final StatisticItem m(lk9 lk9Var, zja postData) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, lk9Var, postData)) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            if (postData.e0) {
                i = 2;
            } else {
                i = 8;
            }
            return kt9.k(lk9Var, postData, postData.f0, i, 2);
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static final void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, pbCommenFloorItemViewHolder, str) == null) {
            int measuredWidth = pbCommenFloorItemViewHolder.f.getMeasuredWidth();
            ArrayList arrayList = new ArrayList();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.G;
            Intrinsics.checkNotNullExpressionValue(userIconBox, "holder.mVipIconBox");
            arrayList.add(userIconBox);
            TextView textView = pbCommenFloorItemViewHolder.i;
            Intrinsics.checkNotNullExpressionValue(textView, "holder.mFloorAuthorView");
            arrayList.add(textView);
            TbImageView tbImageView = pbCommenFloorItemViewHolder.j;
            Intrinsics.checkNotNullExpressionValue(tbImageView, "holder.mFloorAuthorImageView");
            arrayList.add(tbImageView);
            TbImageView tbImageView2 = pbCommenFloorItemViewHolder.k;
            if (tbImageView2 != null) {
                Intrinsics.checkNotNullExpressionValue(tbImageView2, "holder.mPbCommonUserGrowthLevel");
                arrayList.add(tbImageView2);
            }
            RelativeLayout relativeLayout = pbCommenFloorItemViewHolder.y0;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "holder.rlAgreeShow");
            arrayList.add(relativeLayout);
            TbLevelView tbLevelView = pbCommenFloorItemViewHolder.E;
            Intrinsics.checkNotNullExpressionValue(tbLevelView, "holder.mForumLevelIcon");
            arrayList.add(tbLevelView);
            TextView textView2 = pbCommenFloorItemViewHolder.g;
            Intrinsics.checkNotNullExpressionValue(textView2, "holder.mUserNameView");
            TbLevelView tbLevelView2 = pbCommenFloorItemViewHolder.E;
            Intrinsics.checkNotNullExpressionValue(tbLevelView2, "holder.mForumLevelIcon");
            ky5.c(measuredWidth, str, textView2, tbLevelView2, arrayList, pbCommenFloorItemViewHolder.H);
            my5.a(pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.G, pbCommenFloorItemViewHolder.k, pbCommenFloorItemViewHolder.E, pbCommenFloorItemViewHolder.H, 1);
        }
    }
}
