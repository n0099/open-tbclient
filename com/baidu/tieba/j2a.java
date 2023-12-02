package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.TagsInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes6.dex */
public final class j2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(mwa postData, PbCommenFloorItemViewHolder holder, z2a z2aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, postData, holder, z2aVar, i) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (holder.H != null && postData.u() != null) {
                holder.H.setTag(R.id.tag_user_id, postData.u().getUserId());
                if (z2aVar != null) {
                    holder.H.setOnClickListener(z2aVar.c);
                }
                ArrayList<IconData> iconInfo = postData.u().getIconInfo();
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                holder.H.g(iconInfo, i, dimens, dimens, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            Boolean h0 = postData.h0();
            Intrinsics.checkNotNullExpressionValue(h0, "postData.showIdentify");
            if (h0.booleanValue() && !postData.T()) {
                holder.i.setVisibility(0);
            } else {
                holder.i.setVisibility(8);
            }
        }
    }

    public static final boolean b(ThreadData threadData, mwa mwaVar) {
        InterceptResult invokeLL;
        MetaData author;
        String userId;
        String str;
        MetaData u;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, threadData, mwaVar)) == null) {
            if (threadData != null && (author = threadData.getAuthor()) != null && (userId = author.getUserId()) != null) {
                if (mwaVar != null && (u = mwaVar.u()) != null) {
                    str = u.getUserId();
                } else {
                    str = null;
                }
                return userId.equals(str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final void v(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, pbCommenFloorItemViewHolder, mwaVar) == null) {
            boolean z = true;
            z = (mwaVar == null || !mwaVar.z0()) ? false : false;
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

    public static final void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, zv9 zv9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, pbCommenFloorItemViewHolder, mwaVar, zv9Var) == null) && mwaVar != null && zv9Var != null) {
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

    public static final void w(TextView textView, zv9 zv9Var, String str) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, textView, zv9Var, str) == null) {
            if (textView != null) {
                obj = textView.getTag();
            } else {
                obj = null;
            }
            if (!(obj instanceof mwa)) {
                return;
            }
            y(textView, (mwa) obj, str, u(zv9Var));
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, int i, boolean z) {
        boolean z2;
        String str;
        boolean z3;
        cd5 a0;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{pbCommenFloorItemViewHolder, mwaVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            boolean z4 = true;
            if (mwaVar.L() > 0 && !z) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b5e);
                Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.is_floor)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(mwaVar.L())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z2 = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z2 = false;
            }
            String str2 = null;
            if (mwaVar.u() != null) {
                str = mwaVar.u().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z3 = true;
                    a0 = mwaVar.a0();
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
                    if (!Intrinsics.areEqual(StringUtils.SimpleDateFormat(new Date(), "yyyy"), StringUtils.SimpleDateFormat(new Date(mwaVar.r0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(mwaVar.r0()));
                    } else {
                        pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(mwaVar.r0()));
                    }
                    if (!z3) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setText(str);
                    } else if (z4) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setPadding(i, 0, 0, 0);
                        if (mwaVar.f0) {
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
            a0 = mwaVar.a0();
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
            if (!Intrinsics.areEqual(StringUtils.SimpleDateFormat(new Date(), "yyyy"), StringUtils.SimpleDateFormat(new Date(mwaVar.r0()), "yyyy"))) {
            }
            if (!z3) {
            }
            pbCommenFloorItemViewHolder.g0.setText(((Object) pbCommenFloorItemViewHolder.l.getText()) + "  • ");
        }
    }

    public static final void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, zv9 zv9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, pbCommenFloorItemViewHolder, mwaVar, zv9Var, i) == null) {
            d(pbCommenFloorItemViewHolder, mwaVar, i, u(zv9Var));
        }
    }

    public static final void x(TextView textView, mwa mwaVar, zv9 zv9Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65559, null, textView, mwaVar, zv9Var, str) == null) {
            y(textView, mwaVar, str, u(zv9Var));
        }
    }

    public static final void y(TextView textView, mwa mwaVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{textView, mwaVar, str, Boolean.valueOf(z)}) == null) {
            z(textView, mwaVar, str, z, null);
        }
    }

    public static final void f(by9 identityImageView, ThemeColorInfo imgInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, identityImageView, imgInfo) == null) {
            Intrinsics.checkNotNullParameter(identityImageView, "identityImageView");
            Intrinsics.checkNotNullParameter(imgInfo, "imgInfo");
            String g = y5b.g(imgInfo);
            if (g.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                identityImageView.setVisibility(8);
                return;
            }
            int h = y5b.h(imgInfo);
            int i = y5b.i(imgInfo);
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

    public static final StatisticItem g(zv9 zv9Var, mwa postData) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, zv9Var, postData)) == null) {
            Intrinsics.checkNotNullParameter(postData, "postData");
            if (postData.g0) {
                i = 2;
            } else {
                i = 8;
            }
            return b6a.k(zv9Var, postData, postData.h0, i, 2);
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static final String h(ThreadData threadData) {
        InterceptResult invokeL;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, threadData)) == null) {
            if (threadData == null || (l = Long.valueOf(threadData.getFid()).toString()) == null) {
                return "";
            }
            return l;
        }
        return (String) invokeL.objValue;
    }

    public static final String i(zv9 zv9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, zv9Var)) == null) {
            if (zv9Var != null) {
                str = zv9Var.o();
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

    public static final String j(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) {
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

    public static final String k(zv9 zv9Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, zv9Var)) == null) {
            if (zv9Var != null) {
                str = zv9Var.p();
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

    public static final z2a l(ly9<?> ly9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, ly9Var)) == null) {
            if (ly9Var != null) {
                return ly9Var.o1();
            }
            return null;
        }
        return (z2a) invokeL.objValue;
    }

    public static final z2a m(h6a h6aVar) {
        InterceptResult invokeL;
        AbsPbActivity u0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, h6aVar)) == null) {
            if (h6aVar != null && (u0 = h6aVar.u0()) != null) {
                return u0.c;
            }
            return null;
        }
        return (z2a) invokeL.objValue;
    }

    public static final int n(zv9 zv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, zv9Var)) == null) {
            if (zv9Var != null) {
                return zv9Var.Z();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final int o(ly9<?> ly9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, ly9Var)) == null) {
            if (ly9Var != null) {
                return ly9Var.z0();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final boolean p(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, threadData)) == null) {
            if (threadData != null) {
                return threadData.isBlocked();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean q(zv9 zv9Var) {
        InterceptResult invokeL;
        ThreadData R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, zv9Var)) == null) {
            if (zv9Var != null && (R = zv9Var.R()) != null) {
                return R.isBlocked();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean r(ly9<?> ly9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, ly9Var)) == null) {
            if (ly9Var != null) {
                return ly9Var.e1();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean s(h6a h6aVar) {
        InterceptResult invokeL;
        AbsPbActivity u0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, h6aVar)) == null) {
            if (h6aVar != null && (u0 = h6aVar.u0()) != null) {
                return u0.e1();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean t(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, threadData)) == null) {
            if (threadData != null) {
                return threadData.isUgcThreadType();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean u(zv9 zv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, zv9Var)) == null) {
            if (zv9Var != null) {
                return zv9Var.a();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final void z(TextView textView, mwa mwaVar, String str, boolean z, by9 by9Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{textView, mwaVar, str, Boolean.valueOf(z), by9Var}) == null) && textView != null && mwaVar != null) {
            if (by9Var != null) {
                by9Var.setVisibility(8);
            }
            textView.setTag(mwaVar);
            if (z) {
                mwaVar.s1(Boolean.FALSE);
                mwaVar.g1(0);
                textView.setTag(null);
            } else if (mwaVar.u() != null) {
                MetaData u = mwaVar.u();
                Intrinsics.checkNotNullExpressionValue(u, "postData.author");
                if (str != null && !Intrinsics.areEqual(str, "0") && Intrinsics.areEqual(str, u.getUserId())) {
                    mwaVar.s1(Boolean.TRUE);
                    mwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    EMManager.from(textView).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setTextColor(R.color.CAM_X0302).setBorderColor(R.color.CAM_X0302);
                    return;
                }
                boolean z3 = true;
                if (u.getIs_bawu() == 1 && mwaVar.F0()) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    mwaVar.s1(Boolean.TRUE);
                    mwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (u.getIs_bawu() == 1 && Intrinsics.areEqual("manager", u.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    mwaVar.s1(Boolean.TRUE);
                    mwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (u.getIs_bawu() == 1 && Intrinsics.areEqual(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST, u.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    mwaVar.s1(Boolean.TRUE);
                    mwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (u.getIs_bawu() == 1 && Intrinsics.areEqual("pri_content_assist", u.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    mwaVar.s1(Boolean.TRUE);
                    mwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (u.getIs_bawu() == 1 && Intrinsics.areEqual("pri_manage_assist", u.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    mwaVar.s1(Boolean.TRUE);
                    mwaVar.g1(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    ArrayList<TagsInfo> tags = u.getTags();
                    if (tags != null && !tags.isEmpty()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        mwaVar.s1(Boolean.FALSE);
                        ThemeColorInfo info = u.getTags().get(0).img_info;
                        Intrinsics.checkNotNullExpressionValue(info, "info");
                        if (y5b.g(info).length() != 0) {
                            z3 = false;
                        }
                        if (z3) {
                            mwaVar.g1(0);
                            if (by9Var != null) {
                                by9Var.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        mwaVar.g1(y5b.i(info));
                        if (by9Var != null) {
                            f(by9Var, info);
                            return;
                        }
                        return;
                    }
                    mwaVar.s1(Boolean.FALSE);
                    mwaVar.g1(0);
                }
            } else {
                mwaVar.s1(Boolean.FALSE);
                mwaVar.g1(0);
            }
        }
    }
}
