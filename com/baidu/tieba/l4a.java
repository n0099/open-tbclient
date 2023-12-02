package com.baidu.tieba;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* loaded from: classes7.dex */
public final class l4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(eh5 pbEditor, EditorTools mET) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, pbEditor, mET) == null) {
            Intrinsics.checkNotNullParameter(pbEditor, "pbEditor");
            Intrinsics.checkNotNullParameter(mET, "mET");
            zg5.a().c(0);
            pbEditor.Q();
            pbEditor.O();
            pbEditor.y();
            WriteImagesInfo y = pbEditor.y();
            if (pbEditor.t) {
                i = 1;
            } else {
                i = 9;
            }
            y.setMaxImagesAllowed(i);
            pbEditor.h0(SendView.h);
            pbEditor.j(SendView.h);
            qe5 t = mET.t(23);
            qe5 t2 = mET.t(2);
            qe5 t3 = mET.t(5);
            if (t2 != null) {
                t2.display();
            }
            if (t3 != null) {
                t3.display();
            }
            if (t != null) {
                t.hide();
            }
            mET.invalidate();
        }
    }

    public static final SparseArray<Object> b(zv9 pbData, int i) {
        InterceptResult invokeLI;
        boolean z;
        nx4 nx4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, pbData, i)) == null) {
            Intrinsics.checkNotNullParameter(pbData, "pbData");
            mwa a0 = pbData.a0();
            StringBuilder sb = null;
            if (a0 == null) {
                return null;
            }
            String userId = a0.u().getUserId();
            if (userId != null && Intrinsics.areEqual(userId, TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            } else {
                z = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i != 0) {
                if (i == 1) {
                    if (a0.u() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, a0.u().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, a0.u().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, a0.u().getPortrait());
                        sparseArray.put(R.id.tag_forbid_user_post_id, a0.U());
                    }
                    sparseArray.put(R.id.tag_del_post_id, a0.U());
                    sparseArray.put(R.id.tag_del_post_type, 0);
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(pbData.Z()));
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                }
            } else {
                sparseArray.put(R.id.tag_del_post_id, a0.U());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(pbData.Z()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            }
            if (!z) {
                List<iz4> r = pbData.r();
                if (ListUtils.getCount(r) > 0) {
                    sb = new StringBuilder();
                    for (iz4 iz4Var : r) {
                        if (iz4Var != null && !StringUtils.isNull(iz4Var.d()) && (nx4Var = iz4Var.h) != null && nx4Var.a && !nx4Var.c && ((i2 = nx4Var.b) == 1 || i2 == 2)) {
                            sb.append(rd.cutString(iz4Var.d(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f078f));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0553);
                    Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.st…_multi_forum_default_txt)");
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
                    String substring = sb2.substring(0, sb.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{substring}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    sparseArray.put(R.id.tag_del_multi_forum, format);
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeLI.objValue;
    }

    public static final mwa c(View v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, v)) == null) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (!(v.getTag() instanceof SparseArray)) {
                return null;
            }
            Object tag = v.getTag();
            if (tag != null) {
                Object obj = ((SparseArray) tag).get(R.id.tag_clip_board);
                if (!(obj instanceof mwa)) {
                    return null;
                }
                return (mwa) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.util.SparseArray<*>");
        }
        return (mwa) invokeL.objValue;
    }

    public static final int d(zv9 zv9Var) {
        InterceptResult invokeL;
        ThreadData R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zv9Var)) == null) {
            if (zv9Var != null && (R = zv9Var.R()) != null) {
                int i = R.threadType;
                if (i != 0) {
                    if (i != 40) {
                        if (i != 54) {
                            return 4;
                        }
                        return 2;
                    }
                    return 3;
                }
                return 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static final int e(AgreeData mData, lw4 statisticData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mData, statisticData)) == null) {
            Intrinsics.checkNotNullParameter(mData, "mData");
            Intrinsics.checkNotNullParameter(statisticData, "statisticData");
            if (mData.hasAgree) {
                if (mData.agreeType == 5) {
                    mData.agreeType = 5;
                    mData.hasAgree = false;
                    statisticData.i = 0;
                    return 1;
                }
                mData.agreeType = 5;
                mData.hasAgree = true;
                mData.agreeNum--;
                statisticData.i = 1;
                return 0;
            }
            mData.agreeType = 5;
            mData.hasAgree = true;
            statisticData.i = 1;
            return 0;
        }
        return invokeLL.intValue;
    }

    public static final void f(zv9 pbData, u6a u6aVar, View view2, ImageView mBottomShare) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, null, pbData, u6aVar, view2, mBottomShare) == null) {
            Intrinsics.checkNotNullParameter(pbData, "pbData");
            Intrinsics.checkNotNullParameter(mBottomShare, "mBottomShare");
            if (AntiHelper.o(pbData.R())) {
                if (u6aVar != null) {
                    u6aVar.k(false);
                    u6aVar.j();
                }
                ViewGroup.LayoutParams layoutParams = mBottomShare.getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams, "mBottomShare.getLayoutParams()");
                layoutParams.height = -2;
                layoutParams.width = -2;
                mBottomShare.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(mBottomShare, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (pbData.R() != null && pbData.R().isDisableShare()) {
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = mBottomShare.getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams2, "mBottomShare.getLayoutParams()");
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                mBottomShare.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(mBottomShare, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                MaskView.e(mBottomShare, pbData.R().isDisableShare(), pbData.R().getDisableShareToast());
            } else if (u6aVar != null && u6aVar.g()) {
            } else {
                ViewGroup.LayoutParams layoutParams3 = mBottomShare.getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams3, "mBottomShare.getLayoutParams()");
                layoutParams3.height = -2;
                layoutParams3.width = -2;
                mBottomShare.setLayoutParams(layoutParams3);
                WebPManager.setPureDrawable(mBottomShare, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }
}
