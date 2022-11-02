package com.baidu.tieba;

import android.app.Activity;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.k36;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes5.dex */
public class ry7 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public static double b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948138041, "Lcom/baidu/tieba/ry7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948138041, "Lcom/baidu/tieba/ry7;");
                return;
            }
        }
        new SparseArray();
        a = new SparseIntArray();
        b = 3.88d;
        l(R.dimen.tbds16);
    }

    public static void a(TbAlphaVideo tbAlphaVideo, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbAlphaVideo, view2) == null) && tbAlphaVideo != null && view2 != null) {
            int g = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds150);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (g * b), g);
            layoutParams.addRule(11);
            tbAlphaVideo.setLayoutParams(layoutParams);
        }
    }

    public static void b(TbRichTextView tbRichTextView, View view2, boolean z, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) && tbRichTextView != null && view2 != null) {
            int l = ((((xi.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                l = (l - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i2 = l(R.dimen.tbds90);
            } else {
                i2 = 0;
            }
            int i3 = l - i2;
            tbRichTextView.getLayoutStrategy().q(i3);
            tbRichTextView.getLayoutStrategy().H = i3 - l(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().p((int) (l * 1.618f));
        }
    }

    public static void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, pbCommenFloorItemViewHolder, postData, view2, onTouchListener) == null) {
            d(pbCommenFloorItemViewHolder, postData, view2, !TextUtils.isEmpty(postData.v()), onTouchListener);
        }
    }

    public static void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, boolean z, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbCommenFloorItemViewHolder, postData, view2, Boolean.valueOf(z), onTouchListener}) == null) {
            if (!TextUtils.isEmpty(postData.v()) && z) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
                layoutParams.topMargin = l(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = l(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(postData.z())) {
                    pbCommenFloorItemViewHolder.s.setVisibility(0);
                    pbCommenFloorItemViewHolder.s.k(ro4.a(postData.z()));
                    a(pbCommenFloorItemViewHolder.s, view2);
                } else {
                    pbCommenFloorItemViewHolder.s.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.q.k0(postData.v());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.q.k0(null);
                pbCommenFloorItemViewHolder.s.setVisibility(8);
            }
            if (onTouchListener != null) {
                pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(onTouchListener);
            }
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
        }
    }

    public static void e(qy7 qy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, qy7Var, pbCommenFloorItemViewHolder, postData, threadData) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            boolean z2 = true;
            if (postData.D() > 0 && threadData != null && !threadData.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09ad), Integer.valueOf(postData.D()));
                pbCommenFloorItemViewHolder.J.setVisibility(0);
                pbCommenFloorItemViewHolder.J.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(8);
                z = false;
            }
            i55 T = postData.T();
            z2 = (T == null || StringUtils.isNull(T.b()) || threadData == null || threadData.isBjh()) ? false : false;
            if (z) {
                pbCommenFloorItemViewHolder.l.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.l.setVisibility(8);
            }
            if (z2) {
                pbCommenFloorItemViewHolder.m.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.m.setVisibility(8);
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.h0()), "yyyy"))) {
                pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(postData.h0()));
            } else {
                pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(postData.h0()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.n.setVisibility(0);
                pbCommenFloorItemViewHolder.n.setText(T.b());
                return;
            }
            pbCommenFloorItemViewHolder.n.setVisibility(8);
        }
    }

    public static void f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{pbCommenFloorItemViewHolder, postData, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && postData != null && postData.q() != null) {
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
            if (z) {
                pbCommenFloorItemViewHolder.o.B(true);
            } else {
                pbCommenFloorItemViewHolder.o.B(false);
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setData(postData.q());
        }
    }

    public static void g(qy7 qy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{qy7Var, pbCommenFloorItemViewHolder, postData, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), sVar}) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            Activity pageActivity = qy7Var.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = xi.g(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = xi.g(pageActivity, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                pbCommenFloorItemViewHolder.q.k0(null);
                pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08126e);
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.icon_click);
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().x(R.drawable.pic_video);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().l(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().j(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            b(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(postData.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.q.setText(postData.X(), true, sVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092087, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a0, Boolean.valueOf(z3));
            pbCommenFloorItemViewHolder.c.setTag(R.id.obfuscated_res_0x7f09209a, sparseArray);
        }
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
    public static void h(qy7 qy7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, ThreadData threadData, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{qy7Var, pbCommenFloorItemViewHolder, postData, view2, threadData, Boolean.valueOf(z)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f092087, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a4, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a6, view2);
            sparseArray.put(R.id.obfuscated_res_0x7f092097, postData.M());
            sparseArray.put(R.id.obfuscated_res_0x7f091822, pbCommenFloorItemViewHolder.o);
            sparseArray.put(R.id.obfuscated_res_0x7f091820, pbCommenFloorItemViewHolder.y);
            sparseArray.put(R.id.obfuscated_res_0x7f091821, pbCommenFloorItemViewHolder.z);
            boolean z9 = true;
            if (postData.s() != null && !StringUtils.isNull(postData.s().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (qy7Var.T() != 0 && !n(threadData)) {
                if (qy7Var.T() != 1002 && qy7Var.T() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (qy7Var.T() != 3 && !threadData.isUgcThreadType()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (postData.s() != null) {
                    String userId = postData.s().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z3 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z3 = false;
                    }
                }
            } else {
                z3 = false;
                z4 = false;
                z5 = false;
            }
            if (threadData != null && threadData.getAuthor() != null && postData.s() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z4 = true;
                        z6 = false;
                        z7 = true;
                    } else {
                        z4 = true;
                        z6 = true;
                        z7 = false;
                    }
                    z8 = true;
                    if (postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                        z4 = true;
                        z7 = true;
                    }
                    if (z2) {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (postData.D() != 1) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (!z3) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920d0, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a7, Integer.valueOf(qy7Var.T()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f092095, postData.s().getName_show());
                            sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.s().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920d0, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920e4, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f09209e, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f0920e0, postData.s().getUserId());
                            sparseArray.put(R.id.obfuscated_res_0x7f0920e1, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f0920df, postData.s().getName_show());
                        }
                        if (threadData != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f0920e3, threadData.getId());
                        }
                        sparseArray.put(R.id.obfuscated_res_0x7f0920e2, postData.M());
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920e4, Boolean.FALSE);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ce, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f09209b, Boolean.valueOf(postData.q0()));
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a7, Integer.valueOf(qy7Var.T()));
                        sparseArray.put(R.id.obfuscated_res_0x7f09208a, Boolean.valueOf(z7));
                        sparseArray.put(R.id.obfuscated_res_0x7f09208b, Integer.valueOf(i));
                        sparseArray.put(R.id.obfuscated_res_0x7f092089, postData.M());
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ce, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a8, Boolean.valueOf(z5));
                    sparseArray.put(R.id.obfuscated_res_0x7f09209f, Boolean.valueOf(z8));
                    if (pbCommenFloorItemViewHolder.e0 == 0) {
                        z9 = false;
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a0, Boolean.valueOf(z9));
                    pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray);
                    if (!z) {
                        pbCommenFloorItemViewHolder.s0.setTag(sparseArray);
                        return;
                    } else {
                        pbCommenFloorItemViewHolder.s0.setTag(null);
                        return;
                    }
                }
            }
            z6 = false;
            z7 = false;
            z8 = false;
            if (postData.s() != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (postData.D() != 1) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.obfuscated_res_0x7f0920a8, Boolean.valueOf(z5));
            sparseArray.put(R.id.obfuscated_res_0x7f09209f, Boolean.valueOf(z8));
            if (pbCommenFloorItemViewHolder.e0 == 0) {
            }
            sparseArray.put(R.id.obfuscated_res_0x7f0920a0, Boolean.valueOf(z9));
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            if (!z) {
            }
        }
    }

    public static void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2, PostData postData, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{pbCommenFloorItemViewHolder, view2, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.o0.setVisibility(0);
                pbCommenFloorItemViewHolder.r0.setVisibility(0);
                pbCommenFloorItemViewHolder.h0.setVisibility(4);
                if (!z2 && !postData.g0) {
                    pbCommenFloorItemViewHolder.u.setVisibility(8);
                }
                if (postData.g0) {
                    pbCommenFloorItemViewHolder.n0.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.n0.bringToFront();
                    pbCommenFloorItemViewHolder.n0.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.o0.setVisibility(8);
                pbCommenFloorItemViewHolder.n0.setVisibility(8);
                pbCommenFloorItemViewHolder.r0.setVisibility(8);
                if (z2) {
                    pbCommenFloorItemViewHolder.h0.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.u.setVisibility(0);
                }
                postData.S0(false);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f0920a4, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a6, view2);
            pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.r0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.r0.setAlpha(0.5f);
            if (postData.g0) {
                pbCommenFloorItemViewHolder.r0.setOnClickListener(null);
            }
            if (postData != null) {
                View view3 = pbCommenFloorItemViewHolder.r0;
                if (!postData.s0() && !postData.g0) {
                    i = R.color.transparent;
                } else {
                    i = R.color.CAM_X0201;
                }
                SkinManager.setBackgroundColor(view3, i);
                EMTextView eMTextView = pbCommenFloorItemViewHolder.p0;
                boolean s0 = postData.s0();
                int i4 = R.color.CAM_X0304;
                if (s0) {
                    i2 = R.color.CAM_X0304;
                } else {
                    i2 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i2);
                ImageView imageView = pbCommenFloorItemViewHolder.q0;
                if (postData.s0()) {
                    i3 = R.drawable.obfuscated_res_0x7f08099c;
                } else {
                    i3 = R.drawable.obfuscated_res_0x7f08099b;
                }
                if (!postData.s0()) {
                    i4 = R.color.CAM_X0107;
                }
                WebPManager.setPureDrawable(imageView, i3, i4, null);
            }
        }
    }

    public static void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.s() != null && postData.d0() != null) {
                TbRichText X = postData.X();
                if (X != null && StringUtils.isNull(X.toString()) && StringUtils.isNull(postData.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (postData.s().getSmallTailThemeData() != null) {
                    str = postData.s().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.Q.setTag(R.id.obfuscated_res_0x7f0920b7, str);
                pbCommenFloorItemViewHolder.R.setTag(R.id.obfuscated_res_0x7f0920b7, str);
                l58.c(postData.d0(), pbCommenFloorItemViewHolder.Q, pbCommenFloorItemViewHolder.R, pbCommenFloorItemViewHolder.S, false, false, z, postData.s().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
            pbCommenFloorItemViewHolder.R.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0561  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i, qy7 qy7Var, ThreadData threadData, boolean z) {
        String str;
        int i2;
        String str2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{pbCommenFloorItemViewHolder, postData, view2, Integer.valueOf(i), qy7Var, threadData, Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && postData != null) {
            if (postData.s() != null) {
                postData.s().isBaijiahaoUser();
            }
            boolean z9 = false;
            if (postData.Q) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            if (threadData != null && threadData.getAuthor() != null) {
                str = threadData.getAuthor().getUserId();
            } else {
                str = null;
            }
            pbCommenFloorItemViewHolder.p.setTag(null);
            pbCommenFloorItemViewHolder.p.setUserId(null);
            pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.L.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.q.setIsHost(false);
            if (postData.s() != null) {
                if (str != null && !str.equals("0") && str.equals(postData.s().getUserId())) {
                    pbCommenFloorItemViewHolder.q.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = postData.s().getIconInfo();
                ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.N;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.obfuscated_res_0x7f0920dd, postData.s().getUserId());
                    pbCommenFloorItemViewHolder.N.setOnClickListener(qy7Var.y0().c);
                    int g = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.N;
                    i4 = R.id.obfuscated_res_0x7f0920dd;
                    userIconBox2.g(iconInfo, 2, g, g, g2);
                } else {
                    i4 = R.id.obfuscated_res_0x7f0920dd;
                }
                if (pbCommenFloorItemViewHolder.M != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.M.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    pbCommenFloorItemViewHolder.M.setOnClickListener(qy7Var.y0().e);
                    int g3 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.M.h(tShowInfoNew, 3, g3, g3, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                    if (UbsABTestHelper.isPBPlanA()) {
                        if (DeviceInfoUtil.isMate30()) {
                            f18.F(pbCommenFloorItemViewHolder.g);
                        } else {
                            kw4.d(pbCommenFloorItemViewHolder.g).A(R.string.F_X02);
                        }
                        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                    } else {
                        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0106, 1);
                    }
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = postData.s().getAvater();
                pbCommenFloorItemViewHolder.g.setTag(i4, postData.s().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920e5, postData.s().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920e7, postData.s().getVirtualUserUrl());
                String name_show = postData.s().getName_show();
                String userName = postData.s().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(dw7.b(qy7Var.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f0920b1, dw7.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.L.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.L.j(postData.s(), 4);
                    pbCommenFloorItemViewHolder.p.setVisibility(8);
                    pbCommenFloorItemViewHolder.L.setVisibility(0);
                    pbCommenFloorItemViewHolder.L.getHeadView().K(avater, 28, false);
                    pbCommenFloorItemViewHolder.L.getHeadView().setUserId(postData.s().getUserId());
                    pbCommenFloorItemViewHolder.L.getHeadView().setUserName(postData.s().getUserName());
                    pbCommenFloorItemViewHolder.L.m(postData.s().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, postData.s(), 4);
                    pbCommenFloorItemViewHolder.p.setUserId(postData.s().getUserId());
                    pbCommenFloorItemViewHolder.p.setUserName(postData.s().getUserName(), postData.j0());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f0920e7, postData.s().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.p.K(avater, 28, false);
                    pbCommenFloorItemViewHolder.p.setVisibility(0);
                    pbCommenFloorItemViewHolder.L.setVisibility(8);
                }
                p(pbCommenFloorItemViewHolder.i, postData, str, threadData);
            }
            if (qy7Var.t0() && postData.s() != null) {
                i2 = postData.s().getLevel_id();
            } else {
                i2 = 0;
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                i2 = 0;
            }
            if (i2 > 0) {
                pbCommenFloorItemViewHolder.K.setVisibility(0);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.K, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                pbCommenFloorItemViewHolder.K.setVisibility(8);
            }
            if (pbCommenFloorItemViewHolder.N.getChildCount() != 1) {
                pbCommenFloorItemViewHolder.N.getChildCount();
            }
            pbCommenFloorItemViewHolder.i.getVisibility();
            pbCommenFloorItemViewHolder.M.getChildCount();
            int m = f18.m();
            if (postData.s() != null) {
                str2 = postData.s().getName_show();
            } else {
                str2 = "";
            }
            int d = mj5.d(str2);
            if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
                int i5 = m - 2;
                if (d > i5) {
                    str2 = mj5.l(str2, i5) + StringHelper.STRING_MORE;
                }
            } else if (d > m) {
                str2 = mj5.l(str2, m) + StringHelper.STRING_MORE;
            }
            if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
                pbCommenFloorItemViewHolder.g.setText(m(qy7Var, postData.s().getSealPrefix(), str2));
            } else {
                pbCommenFloorItemViewHolder.g.setText(str2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f092087, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a4, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a6, view2);
            sparseArray.put(R.id.obfuscated_res_0x7f0920b5, Integer.valueOf(i));
            sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(postData.D()));
            sparseArray.put(R.id.obfuscated_res_0x7f092097, postData.M());
            if (postData.s() != null && !StringUtils.isNull(postData.s().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (threadData != null && qy7Var.T() != 0 && !n(threadData)) {
                if (qy7Var.T() != 1002 && qy7Var.T() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (qy7Var.T() != 3 && !threadData.isBjh()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (postData != null && postData.s() != null) {
                    String userId = postData.s().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z3 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z3 = false;
                    }
                }
            } else {
                z3 = false;
                z4 = false;
                z5 = false;
            }
            if (threadData != null && threadData.getAuthor() != null && postData.s() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    if (UtilHelper.isCurrentAccount(userId3)) {
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
                    if (z2) {
                        z3 = false;
                        z6 = false;
                        z4 = false;
                    }
                    if (postData.D() != 1) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (threadData != null && threadData.isUgcThreadType()) {
                        z3 = false;
                        z6 = false;
                    }
                    if (!z3) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920d0, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a7, Integer.valueOf(qy7Var.T()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f092095, postData.s().getName_show());
                            sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.s().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920d0, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920e4, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f09209e, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.obfuscated_res_0x7f0920e0, postData.s().getUserId());
                            sparseArray.put(R.id.obfuscated_res_0x7f0920e1, postData.s().getUserName());
                            sparseArray.put(R.id.obfuscated_res_0x7f0920df, postData.s().getName_show());
                        }
                        sparseArray.put(R.id.obfuscated_res_0x7f0920e3, threadData.getId());
                        sparseArray.put(R.id.obfuscated_res_0x7f0920e2, postData.M());
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920e4, Boolean.FALSE);
                    }
                    if (!z4 && threadData != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ce, Boolean.TRUE);
                        sparseArray.put(R.id.obfuscated_res_0x7f0920a7, Integer.valueOf(qy7Var.T()));
                        sparseArray.put(R.id.obfuscated_res_0x7f09208a, Boolean.valueOf(z7));
                        sparseArray.put(R.id.obfuscated_res_0x7f09208b, Integer.valueOf(i3));
                        sparseArray.put(R.id.obfuscated_res_0x7f092089, postData.M());
                        sparseArray.put(R.id.obfuscated_res_0x7f09209b, Boolean.valueOf((z || postData.q0()) ? true : true));
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f0920ce, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a8, Boolean.valueOf(z5));
                    sparseArray.put(R.id.obfuscated_res_0x7f09209f, Boolean.valueOf(z8));
                    pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray);
                }
            }
            z6 = false;
            z7 = false;
            z8 = false;
            if (postData != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (postData.D() != 1) {
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
            sparseArray.put(R.id.obfuscated_res_0x7f0920ce, Boolean.FALSE);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a8, Boolean.valueOf(z5));
            sparseArray.put(R.id.obfuscated_res_0x7f09209f, Boolean.valueOf(z8));
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
        }
    }

    public static int l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
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

    public static boolean n(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            return threadData.isBlocked();
        }
        return invokeL.booleanValue;
    }

    public static SpannableStringBuilder m(qy7 qy7Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, qy7Var, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new k36.a(str, R.drawable.pic_smalldot_title));
                return k36.h(qy7Var.getPageContext().getPageActivity(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static void o(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65551, null, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.a != TbadkCoreApplication.getInst().getSkinType()) {
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    f18.F(pbCommenFloorItemViewHolder.g);
                } else {
                    kw4.d(pbCommenFloorItemViewHolder.g).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0106, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.t.b();
            if (pbCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s.g(TbadkCoreApplication.getInst().getSkinType());
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f0809c2, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f0809c3, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.setVisibility(8);
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            pbCommenFloorItemViewHolder.T.setVisibility(8);
            pbCommenFloorItemViewHolder.a0.setVisibility(8);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void p(TextView textView, PostData postData, String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, textView, postData, str, threadData) == null) {
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
                    textView.setText(R.string.obfuscated_res_0x7f0f0893);
                    textView.setBackgroundColor(0);
                    kw4 d = kw4.d(textView);
                    d.n(R.string.J_X04);
                    d.l(R.dimen.L_X01);
                    d.v(R.color.CAM_X0302);
                    d.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.r0()) {
                    kw4 d2 = kw4.d(textView);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0347);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    kw4 d3 = kw4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    kw4 d4 = kw4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f0301);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    kw4 d5 = kw4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    kw4 d6 = kw4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02fe);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
