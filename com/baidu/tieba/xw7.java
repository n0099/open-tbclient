package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.t16;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes6.dex */
public class xw7 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public static double b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.e.getMeasuredWidth();
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                lz7.a(measuredWidth, str, pbCommenFloorItemViewHolder.f, pbCommenFloorItemViewHolder.h, pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.M, pbCommenFloorItemViewHolder.L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314865, "Lcom/baidu/tieba/xw7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314865, "Lcom/baidu/tieba/xw7;");
                return;
            }
        }
        new SparseArray();
        a = new SparseIntArray();
        b = 3.88d;
        m(R.dimen.tbds16);
    }

    public static void a(TbAlphaVideo tbAlphaVideo, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbAlphaVideo, view2) == null) || tbAlphaVideo == null || view2 == null) {
            return;
        }
        int f = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds150);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (f * b), f);
        layoutParams.addRule(11);
        tbAlphaVideo.setLayoutParams(layoutParams);
    }

    public static void b(TbRichTextView tbRichTextView, View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k = ((((ej.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i;
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int m = k - (z ? m(R.dimen.tbds90) : 0);
        tbRichTextView.getLayoutStrategy().q(m);
        tbRichTextView.getLayoutStrategy().H = m - m(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f));
    }

    public static void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, pbCommenFloorItemViewHolder, postData, view2, onTouchListener) == null) {
            d(pbCommenFloorItemViewHolder, postData, view2, !TextUtils.isEmpty(postData.t()), onTouchListener);
        }
    }

    public static void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, boolean z, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbCommenFloorItemViewHolder, postData, view2, Boolean.valueOf(z), onTouchListener}) == null) {
            if (!TextUtils.isEmpty(postData.t()) && z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
                layoutParams.topMargin = m(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = m(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(postData.y())) {
                    pbCommenFloorItemViewHolder.r.setVisibility(0);
                    pbCommenFloorItemViewHolder.r.k(yn4.a(postData.y()));
                    a(pbCommenFloorItemViewHolder.r, view2);
                } else {
                    pbCommenFloorItemViewHolder.r.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.p.k0(postData.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.p.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.p.k0(null);
                pbCommenFloorItemViewHolder.r.setVisibility(8);
            }
            if (onTouchListener != null) {
                pbCommenFloorItemViewHolder.p.setTextViewOnTouchListener(onTouchListener);
            }
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
        }
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, boolean z, boolean z2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbCommenFloorItemViewHolder, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (imageView = pbCommenFloorItemViewHolder.y) == null || postData == null) {
            return;
        }
        if (z2) {
            imageView.setVisibility(8);
            if (z) {
                pbCommenFloorItemViewHolder.G.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ffe));
                return;
            }
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public static void f(ww7 ww7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65542, null, ww7Var, pbCommenFloorItemViewHolder, postData, threadData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.C() > 0 && threadData != null && !threadData.isBjh()) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0994), Integer.valueOf(postData.C()));
            pbCommenFloorItemViewHolder.I.setVisibility(0);
            pbCommenFloorItemViewHolder.I.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.I.setVisibility(8);
            z = false;
        }
        j45 S = postData.S();
        z2 = (S == null || StringUtils.isNull(S.b()) || threadData == null || threadData.isBjh()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.k.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.k.setVisibility(8);
        }
        if (z2) {
            pbCommenFloorItemViewHolder.l.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.l.setVisibility(8);
        }
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
            pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTimeShort(postData.f0()));
        } else {
            pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTime(postData.f0()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            pbCommenFloorItemViewHolder.m.setText(S.b());
            return;
        }
        pbCommenFloorItemViewHolder.m.setVisibility(8);
    }

    public static void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{pbCommenFloorItemViewHolder, postData, threadData, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        if (threadData != null) {
            postData.q().threadId = threadData.getTid();
            postData.q().forumId = String.valueOf(threadData.getFid());
        }
        if (i == 0) {
            postData.q().objType = 1;
        } else {
            postData.q().objType = 2;
        }
        postData.q().isInPost = true;
        if (z2) {
            pbCommenFloorItemViewHolder.n.A(true);
        } else {
            pbCommenFloorItemViewHolder.n.A(false);
        }
        if (z) {
            pbCommenFloorItemViewHolder.H.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.H.setData(postData.q());
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.n.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.n.setData(postData.q());
    }

    public static void h(ww7 ww7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{ww7Var, pbCommenFloorItemViewHolder, postData, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), sVar}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        Activity pageActivity = ww7Var.getPageContext().getPageActivity();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = ej.f(pageActivity, R.dimen.M_W_X007);
        layoutParams.leftMargin = ej.f(pageActivity, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        if (z) {
            pbCommenFloorItemViewHolder.p.k0(null);
            pbCommenFloorItemViewHolder.p.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081241);
        } else {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().x(R.drawable.pic_video);
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().j(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
        b(pbCommenFloorItemViewHolder.p, view2, !StringUtils.isNull(postData.t()), layoutParams.leftMargin + layoutParams.rightMargin);
        pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.p.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.p.setIsFromCDN(z2);
        pbCommenFloorItemViewHolder.p.setText(postData.W(), true, sVar);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.p.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09203d, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092056, Boolean.valueOf(z3));
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f092050, sparseArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(ww7 ww7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, ThreadData threadData, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65545, null, new Object[]{ww7Var, pbCommenFloorItemViewHolder, postData, view2, threadData, Boolean.valueOf(z)}) != null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203d, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205a, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205c, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f09204d, postData.L());
        sparseArray.put(R.id.obfuscated_res_0x7f0917ef, pbCommenFloorItemViewHolder.n);
        sparseArray.put(R.id.obfuscated_res_0x7f0917ed, pbCommenFloorItemViewHolder.x);
        sparseArray.put(R.id.obfuscated_res_0x7f0917ee, pbCommenFloorItemViewHolder.y);
        boolean z8 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        if (ww7Var.T() == 0 || o(threadData)) {
            z2 = false;
            z3 = false;
            z4 = false;
        } else {
            z2 = (ww7Var.T() == 1002 || ww7Var.T() == 3) ? false : true;
            if (ww7Var.T() == 3 || threadData.isUgcThreadType()) {
                z3 = false;
                z4 = false;
            } else {
                z3 = true;
                z4 = true;
            }
            if (postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z2 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z2 = false;
                }
            }
        }
        if (threadData != null && threadData.getAuthor() != null && postData.s() != null) {
            String userId2 = threadData.getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z3 = true;
                    z5 = false;
                    z6 = true;
                } else {
                    z3 = true;
                    z5 = true;
                    z6 = false;
                }
                z7 = true;
                if (postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z3 = true;
                    z6 = true;
                }
                if (z8) {
                    z2 = false;
                    z3 = false;
                    z5 = false;
                }
                int i = postData.C() != 1 ? 0 : 1;
                if (!z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(ww7Var.T()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09204a, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204b, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204c, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092054, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092095, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.s().getName_show());
                    }
                    if (threadData != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092098, threadData.getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092097, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092051, Boolean.valueOf(postData.o0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(ww7Var.T()));
                    sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f092041, Integer.valueOf(i));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203f, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.valueOf(z4));
                sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.valueOf(z7));
                sparseArray.put(R.id.obfuscated_res_0x7f092056, Boolean.valueOf(pbCommenFloorItemViewHolder.d0 != 0));
                pbCommenFloorItemViewHolder.p.setTag(sparseArray);
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                if (!z) {
                    pbCommenFloorItemViewHolder.r0.setTag(sparseArray);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.r0.setTag(null);
                    return;
                }
            }
        }
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData.s() != null) {
            z3 = true;
            z6 = true;
        }
        if (z8) {
        }
        if (postData.C() != 1) {
        }
        if (!z2) {
        }
        if (!z5) {
        }
        if (!z3) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.valueOf(z4));
        sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.valueOf(z7));
        sparseArray.put(R.id.obfuscated_res_0x7f092056, Boolean.valueOf(pbCommenFloorItemViewHolder.d0 != 0));
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
        if (!z) {
        }
    }

    public static void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{pbCommenFloorItemViewHolder, view2, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.n0.setVisibility(0);
                pbCommenFloorItemViewHolder.q0.setVisibility(0);
                pbCommenFloorItemViewHolder.g0.setVisibility(4);
                if (!z2 && !postData.g0) {
                    pbCommenFloorItemViewHolder.t.setVisibility(8);
                }
                if (postData.g0) {
                    pbCommenFloorItemViewHolder.m0.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.m0.bringToFront();
                    pbCommenFloorItemViewHolder.m0.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.n0.setVisibility(8);
                pbCommenFloorItemViewHolder.m0.setVisibility(8);
                pbCommenFloorItemViewHolder.q0.setVisibility(8);
                if (z2) {
                    pbCommenFloorItemViewHolder.g0.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.t.setVisibility(0);
                }
                postData.Q0(false);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f09205a, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f09205c, view2);
            pbCommenFloorItemViewHolder.m0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.q0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.q0.setAlpha(0.5f);
            if (postData.g0) {
                pbCommenFloorItemViewHolder.q0.setOnClickListener(null);
            }
            if (postData != null) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.q0, (postData.q0() || postData.g0) ? R.color.CAM_X0201 : R.color.transparent);
                EMTextView eMTextView = pbCommenFloorItemViewHolder.o0;
                boolean q0 = postData.q0();
                int i = R.color.CAM_X0304;
                SkinManager.setViewTextColor(eMTextView, q0 ? R.color.CAM_X0304 : R.color.CAM_X0107);
                ImageView imageView = pbCommenFloorItemViewHolder.p0;
                int i2 = postData.q0() ? R.drawable.obfuscated_res_0x7f080984 : R.drawable.obfuscated_res_0x7f080983;
                if (!postData.q0()) {
                    i = R.color.CAM_X0107;
                }
                WebPManager.setPureDrawable(imageView, i2, i, null);
            }
        }
    }

    public static void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.c0() != null) {
                TbRichText W = postData.W();
                q38.c(postData.c0(), pbCommenFloorItemViewHolder.P, pbCommenFloorItemViewHolder.Q, pbCommenFloorItemViewHolder.R, false, false, W != null && StringUtils.isNull(W.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbCommenFloorItemViewHolder.P.setVisibility(8);
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i, ww7 ww7Var, ThreadData threadData, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{pbCommenFloorItemViewHolder, postData, view2, Integer.valueOf(i), ww7Var, threadData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        boolean z9 = false;
        if (postData.Q) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.d.setVisibility(8);
        }
        String userId = (threadData == null || threadData.getAuthor() == null) ? null : threadData.getAuthor().getUserId();
        pbCommenFloorItemViewHolder.o.setTag(null);
        pbCommenFloorItemViewHolder.o.setUserId(null);
        pbCommenFloorItemViewHolder.f.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.K.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.p.setIsHost(false);
        if (postData.s() != null) {
            if (userId != null && !userId.equals("0") && userId.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.p.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.M;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.obfuscated_res_0x7f092092, postData.s().getUserId());
                pbCommenFloorItemViewHolder.M.setOnClickListener(ww7Var.z0().c);
                int f = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.M;
                i2 = R.id.obfuscated_res_0x7f092092;
                userIconBox2.g(iconInfo, 2, f, f, f2);
            } else {
                i2 = R.id.obfuscated_res_0x7f092092;
            }
            if (pbCommenFloorItemViewHolder.L != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.L.setTag(tShowInfoNew.get(0).getUrl());
                }
                pbCommenFloorItemViewHolder.L.setOnClickListener(ww7Var.z0().e);
                int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.L.h(tShowInfoNew, 3, f3, f3, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        lz7.m(pbCommenFloorItemViewHolder.f);
                    } else {
                        hv4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0106, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            pbCommenFloorItemViewHolder.f.setTag(i2, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f09209a, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f09209c, postData.s().getVirtualUserUrl());
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f.setText(ju7.b(ww7Var.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092067, ju7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.K.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.K.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setVisibility(8);
                pbCommenFloorItemViewHolder.K.setVisibility(0);
                pbCommenFloorItemViewHolder.K.getHeadView().K(avater, 28, false);
                pbCommenFloorItemViewHolder.K.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.K.getHeadView().setUserName(postData.s().getUserName());
                pbCommenFloorItemViewHolder.K.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.o.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.o, postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.o.setUserName(postData.s().getUserName(), postData.h0());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f09209c, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.o.setImageDrawable(null);
                pbCommenFloorItemViewHolder.o.K(avater, 28, false);
                pbCommenFloorItemViewHolder.o.setVisibility(0);
                pbCommenFloorItemViewHolder.K.setVisibility(8);
            }
            q(pbCommenFloorItemViewHolder.h, postData, userId, threadData);
        }
        int level_id = (!ww7Var.u0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        if (threadData != null && threadData.isUgcThreadType()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.J.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.J, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.J.setVisibility(8);
        }
        if (pbCommenFloorItemViewHolder.M.getChildCount() != 1) {
            pbCommenFloorItemViewHolder.M.getChildCount();
        }
        pbCommenFloorItemViewHolder.h.getVisibility();
        pbCommenFloorItemViewHolder.L.getChildCount();
        int e = lz7.e();
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d = ji5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i3 = e - 2;
            if (d > i3) {
                name_show2 = ji5.n(name_show2, i3) + StringHelper.STRING_MORE;
            }
        } else if (d > e) {
            name_show2 = ji5.n(name_show2, e) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f.setText(n(ww7Var, postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f.setText(name_show2);
            pbCommenFloorItemViewHolder.e.post(new a(pbCommenFloorItemViewHolder, name_show2));
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203d, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205a, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205c, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f09206b, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f09206a, Integer.valueOf(postData.C()));
        sparseArray.put(R.id.obfuscated_res_0x7f09204d, postData.L());
        boolean z10 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        if (threadData == null || ww7Var.T() == 0 || o(threadData)) {
            z3 = false;
            z4 = false;
            z5 = false;
        } else {
            z3 = (ww7Var.T() == 1002 || ww7Var.T() == 3) ? false : true;
            if (ww7Var.T() == 3 || threadData.isBjh()) {
                z4 = false;
                z5 = false;
            } else {
                z4 = true;
                z5 = true;
            }
            if (postData != null && postData.s() != null) {
                String userId2 = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    z3 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z3 = false;
                }
            }
        }
        if (threadData != null && threadData.getAuthor() != null && postData.s() != null) {
            String userId3 = threadData.getAuthor().getUserId();
            String userId4 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId3)) {
                if (UtilHelper.isCurrentAccount(userId4)) {
                    z6 = false;
                    z4 = true;
                    z7 = true;
                } else {
                    z6 = true;
                    z4 = true;
                    z7 = false;
                }
                z8 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z4 = true;
                    z7 = true;
                }
                if (z10) {
                    z3 = false;
                    z6 = false;
                    z4 = false;
                }
                int i4 = postData.C() != 1 ? 0 : 1;
                if (threadData != null && threadData.isUgcThreadType()) {
                    z3 = false;
                    z6 = false;
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(ww7Var.T()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09204a, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204b, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204c, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
                }
                if (!z6) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092054, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092095, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.s().getName_show());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092098, threadData.getId());
                    sparseArray.put(R.id.obfuscated_res_0x7f092097, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                }
                if (!z4 && threadData != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(ww7Var.T()));
                    sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z7));
                    sparseArray.put(R.id.obfuscated_res_0x7f092041, Integer.valueOf(i4));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203f, postData.L());
                    sparseArray.put(R.id.obfuscated_res_0x7f092051, Boolean.valueOf((z2 || postData.o0()) ? true : true));
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.valueOf(z5));
                sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.valueOf(z8));
                pbCommenFloorItemViewHolder.p.setTag(sparseArray);
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                if (z) {
                    return;
                }
                pbCommenFloorItemViewHolder.N.setTag(sparseArray);
                return;
            }
        }
        z6 = false;
        z7 = false;
        z8 = false;
        if (postData != null) {
            z4 = true;
            z7 = true;
        }
        if (z10) {
        }
        if (postData.C() != 1) {
        }
        if (threadData != null) {
            z3 = false;
            z6 = false;
        }
        if (!z3) {
        }
        if (!z6) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
        sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.valueOf(z5));
        sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.valueOf(z8));
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
        if (z) {
        }
    }

    public static int m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            int i2 = a.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
            a.put(i, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public static SpannableStringBuilder n(ww7 ww7Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, ww7Var, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new t16.a(str, R.drawable.pic_smalldot_title));
            return t16.h(ww7Var.getPageContext().getPageActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static boolean o(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            return threadData.isBlocked();
        }
        return invokeL.booleanValue;
    }

    public static void p(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jv7 jv7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65552, null, pbCommenFloorItemViewHolder, jv7Var, z) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.a != TbadkCoreApplication.getInst().getSkinType()) {
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    lz7.m(pbCommenFloorItemViewHolder.f);
                } else {
                    hv4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0106, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.s.b();
            if (pbCommenFloorItemViewHolder.r.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.r.g(TbadkCoreApplication.getInst().getSkinType());
            }
            if (z) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(pbCommenFloorItemViewHolder.N, R.drawable.obfuscated_res_0x7f080603, R.color.CAM_X0111, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.F, R.drawable.obfuscated_res_0x7f0809aa, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.D, R.drawable.obfuscated_res_0x7f0809ab, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.E, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.G, (int) R.color.CAM_X0109);
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.x, R.drawable.obfuscated_res_0x7f0809aa, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f0809ab, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (jv7Var != null) {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.v, (int) R.color.CAM_X0108);
                pbCommenFloorItemViewHolder.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0108), null), (Drawable) null);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0108);
                SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.u, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
                pbCommenFloorItemViewHolder.u.d();
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.V, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.T, R.color.CAM_X0106, 1);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.S, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.U, R.color.CAM_X0109);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.W, R.drawable.icon_arrow_more_gray);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.Z, (int) R.color.CAM_X0107);
                if (pbCommenFloorItemViewHolder.X.getVisibility() == 8) {
                    pbCommenFloorItemViewHolder.v.setVisibility(8);
                    pbCommenFloorItemViewHolder.w.setVisibility(8);
                    pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f03fb);
                } else if (StringUtils.isNull(jv7Var.k())) {
                    pbCommenFloorItemViewHolder.Z.setText(jv7Var.k());
                } else {
                    pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f05e6);
                }
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
                pbCommenFloorItemViewHolder.w.setVisibility(8);
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.Z.setVisibility(8);
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void q(TextView textView, PostData postData, String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, null, textView, postData, str, threadData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            if (threadData != null && threadData.isUgcThreadType()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                if (str != null && !str.equals("0") && str.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f087d);
                    textView.setBackgroundColor(0);
                    hv4 d = hv4.d(textView);
                    d.n(R.string.J_X04);
                    d.l(R.dimen.L_X01);
                    d.v(R.color.CAM_X0302);
                    d.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.p0()) {
                    hv4 d2 = hv4.d(textView);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0346);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    hv4 d3 = hv4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02ff);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    hv4 d4 = hv4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    hv4 d5 = hv4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fc);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    hv4 d6 = hv4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
