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
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.jg6;
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
import java.util.Date;
/* loaded from: classes5.dex */
public class ou8 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public static double b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sl9 a;
        public final /* synthetic */ TbPageContext b;

        public a(sl9 sl9Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sl9Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sl9Var;
            this.b = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q() != null && this.a.q().getPortrait() != null && !TextUtils.isEmpty(this.a.q().getPortrait())) {
                String str2 = null;
                if (this.a.p0() != null) {
                    str2 = this.a.p0().getFigureUrl();
                    str = this.a.p0().getBackgroundValue();
                } else {
                    str = null;
                }
                lw5.a(this.b, this.a.q().getPortrait(), str2, str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948044855, "Lcom/baidu/tieba/ou8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948044855, "Lcom/baidu/tieba/ou8;");
                return;
            }
        }
        a = new SparseIntArray();
        b = 3.88d;
    }

    public static void a(TbAlphaVideo tbAlphaVideo, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, tbAlphaVideo, view2) == null) && tbAlphaVideo != null && view2 != null) {
            int g = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds150);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (g * b), g);
            layoutParams.addRule(11);
            tbAlphaVideo.setLayoutParams(layoutParams);
        }
    }

    public static void b(TbRichTextView tbRichTextView, View view2, boolean z, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) && tbRichTextView != null && view2 != null) {
            int l = ((((ii.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i;
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
            tbRichTextView.getLayoutStrategy().r(i3);
            tbRichTextView.getLayoutStrategy().J = i3 - l(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().q((int) (l * 1.618f));
        }
    }

    public static void c(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, View view2, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, pbCommenFloorItemViewHolder, sl9Var, view2, onTouchListener) == null) {
            d(pbCommenFloorItemViewHolder, sl9Var, view2, !TextUtils.isEmpty(sl9Var.s()), onTouchListener);
        }
    }

    public static void d(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, View view2, boolean z, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbCommenFloorItemViewHolder, sl9Var, view2, Boolean.valueOf(z), onTouchListener}) == null) {
            if (!TextUtils.isEmpty(sl9Var.s()) && z) {
                nz9.c(sl9Var, pbCommenFloorItemViewHolder.q);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
                layoutParams.topMargin = l(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = l(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(sl9Var.x())) {
                    pbCommenFloorItemViewHolder.s.setVisibility(0);
                    pbCommenFloorItemViewHolder.s.k(hs4.a(sl9Var.x()));
                    a(pbCommenFloorItemViewHolder.s, view2);
                } else {
                    pbCommenFloorItemViewHolder.s.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.q.p0(sl9Var.s());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.q.p0(null);
                pbCommenFloorItemViewHolder.s.setVisibility(8);
            }
            if (onTouchListener != null) {
                pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(onTouchListener);
            }
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
        }
    }

    public static void e(nu8 nu8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, nu8Var, pbCommenFloorItemViewHolder, sl9Var, threadData) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null) {
            boolean z2 = true;
            if (sl9Var.E() > 0 && threadData != null && !threadData.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a3e), Integer.valueOf(sl9Var.E()));
                pbCommenFloorItemViewHolder.C.setVisibility(0);
                pbCommenFloorItemViewHolder.C.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.C.setVisibility(8);
                z = false;
            }
            sb5 V = sl9Var.V();
            z2 = (V == null || StringUtils.isNull(V.b()) || threadData == null || threadData.isBjh()) ? false : false;
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
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(sl9Var.l0()), "yyyy"))) {
                pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(sl9Var.l0()));
            } else {
                pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(sl9Var.l0()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.n.setVisibility(0);
                pbCommenFloorItemViewHolder.n.setText(V.b());
                return;
            }
            pbCommenFloorItemViewHolder.n.setVisibility(8);
        }
    }

    public static void f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{pbCommenFloorItemViewHolder, sl9Var, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null && sl9Var.n() != null) {
            if (threadData != null) {
                sl9Var.n().threadId = threadData.getTid();
                sl9Var.n().forumId = String.valueOf(threadData.getFid());
            }
            if (i == 0) {
                sl9Var.n().objType = 1;
            } else {
                sl9Var.n().objType = 2;
            }
            sl9Var.n().isInPost = true;
            pbCommenFloorItemViewHolder.o.E(z);
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setData(sl9Var.n());
        }
    }

    public static void g(nu8 nu8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.u uVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{nu8Var, pbCommenFloorItemViewHolder, sl9Var, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), uVar}) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null) {
            Activity pageActivity = nu8Var.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = ii.g(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = ii.g(pageActivity, R.dimen.tbds148);
            boolean z4 = false;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                pbCommenFloorItemViewHolder.q.p0(null);
                pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.transparent_bg);
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.icon_click);
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().z(R.drawable.pic_video);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
            if (!TextUtils.isEmpty(sl9Var.s()) && z) {
                z4 = true;
            }
            nz9.b(sl9Var, pbCommenFloorItemViewHolder.q, z4);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().k(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            b(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(sl9Var.s()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.q.setText(sl9Var.a0(), true, uVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, sl9Var);
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z3));
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
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
    public static void h(nu8 nu8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, View view2, ThreadData threadData, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{nu8Var, pbCommenFloorItemViewHolder, sl9Var, view2, threadData, Boolean.valueOf(z)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, sl9Var);
            sparseArray.put(R.id.tag_load_sub_data, sl9Var);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_forbid_user_post_id, sl9Var.O());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
            boolean z9 = true;
            if (sl9Var.q() != null && !StringUtils.isNull(sl9Var.q().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (nu8Var.d0() != 0 && !n(threadData)) {
                if (nu8Var.d0() != 1002 && nu8Var.d0() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (nu8Var.d0() != 3 && !threadData.isUgcThreadType()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (sl9Var.q() != null) {
                    String userId = sl9Var.q().getUserId();
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
            if (threadData != null && threadData.getAuthor() != null && sl9Var.q() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = sl9Var.q().getUserId();
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
                    if (sl9Var.q() != null && UtilHelper.isCurrentAccount(sl9Var.q().getUserId())) {
                        z4 = true;
                        z7 = true;
                    }
                    if (z2) {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (sl9Var.E() != 1) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(nu8Var.d0()));
                        if (sl9Var.q() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, sl9Var.q().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, sl9Var.q().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, sl9Var.q().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (sl9Var.q() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, sl9Var.q().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, sl9Var.q().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, sl9Var.q().getName_show());
                        }
                        if (threadData != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, sl9Var.O());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(sl9Var.u0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(nu8Var.d0()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_id, sl9Var.O());
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
                    if (pbCommenFloorItemViewHolder.Y == 0) {
                        z9 = false;
                    }
                    sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z9));
                    pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray);
                    if (!z) {
                        pbCommenFloorItemViewHolder.m0.setTag(sparseArray);
                        return;
                    } else {
                        pbCommenFloorItemViewHolder.m0.setTag(null);
                        return;
                    }
                }
            }
            z6 = false;
            z7 = false;
            z8 = false;
            if (sl9Var.q() != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (sl9Var.E() != 1) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
            if (pbCommenFloorItemViewHolder.Y == 0) {
            }
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z9));
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            if (!z) {
            }
        }
    }

    public static void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2, sl9 sl9Var, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{pbCommenFloorItemViewHolder, view2, sl9Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.i0.setVisibility(0);
                pbCommenFloorItemViewHolder.l0.setVisibility(0);
                pbCommenFloorItemViewHolder.b0.setVisibility(4);
                if (!z2 && !sl9Var.h0) {
                    pbCommenFloorItemViewHolder.u.setVisibility(8);
                }
                if (sl9Var.h0) {
                    pbCommenFloorItemViewHolder.h0.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.h0.bringToFront();
                    pbCommenFloorItemViewHolder.h0.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.i0.setVisibility(8);
                pbCommenFloorItemViewHolder.h0.setVisibility(8);
                pbCommenFloorItemViewHolder.l0.setVisibility(8);
                if (z2) {
                    pbCommenFloorItemViewHolder.b0.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.u.setVisibility(0);
                }
                sl9Var.X0(false);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_load_sub_data, sl9Var);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            pbCommenFloorItemViewHolder.h0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.l0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.l0.setAlpha(0.5f);
            if (sl9Var.h0) {
                pbCommenFloorItemViewHolder.l0.setOnClickListener(null);
            }
            if (sl9Var != null) {
                View view3 = pbCommenFloorItemViewHolder.l0;
                if (!sl9Var.w0() && !sl9Var.h0) {
                    i = R.color.transparent;
                } else {
                    i = R.color.CAM_X0201;
                }
                SkinManager.setBackgroundColor(view3, i);
                EMTextView eMTextView = pbCommenFloorItemViewHolder.j0;
                boolean w0 = sl9Var.w0();
                int i4 = R.color.CAM_X0304;
                if (w0) {
                    i2 = R.color.CAM_X0304;
                } else {
                    i2 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i2);
                ImageView imageView = pbCommenFloorItemViewHolder.k0;
                if (sl9Var.w0()) {
                    i3 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i3 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!sl9Var.w0()) {
                    i4 = R.color.CAM_X0107;
                }
                WebPManager.setPureDrawable(imageView, i3, i4, null);
            }
        }
    }

    public static void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, pbCommenFloorItemViewHolder, sl9Var) == null) {
            if (sl9Var != null && sl9Var.q() != null && sl9Var.h0() != null) {
                TbRichText a0 = sl9Var.a0();
                if (a0 != null && StringUtils.isNull(a0.toString()) && StringUtils.isNull(sl9Var.s())) {
                    z = true;
                } else {
                    z = false;
                }
                if (sl9Var.q().getSmallTailThemeData() != null) {
                    str = sl9Var.q().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.J.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                j09.c(sl9Var.h0(), pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, false, false, z, sl9Var.q().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.J.setVisibility(8);
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x054b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, View view2, int i, nu8 nu8Var, ThreadData threadData, boolean z) {
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
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{pbCommenFloorItemViewHolder, sl9Var, view2, Integer.valueOf(i), nu8Var, threadData, Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null) {
            boolean z9 = false;
            if (sl9Var.R) {
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
            pbCommenFloorItemViewHolder.E.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.q.setIsHost(false);
            if (sl9Var.q() != null) {
                if (str != null && !str.equals("0") && str.equals(sl9Var.q().getUserId())) {
                    pbCommenFloorItemViewHolder.q.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = sl9Var.q().getIconInfo();
                ArrayList<IconData> tShowInfoNew = sl9Var.q().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.G;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, sl9Var.q().getUserId());
                    pbCommenFloorItemViewHolder.G.setOnClickListener(nu8Var.I0().c);
                    int g = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int g2 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.G;
                    i4 = R.id.tag_user_id;
                    userIconBox2.g(iconInfo, 2, g, g, g2);
                } else {
                    i4 = R.id.tag_user_id;
                }
                if (pbCommenFloorItemViewHolder.F != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.F.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    pbCommenFloorItemViewHolder.F.setOnClickListener(nu8Var.I0().e);
                    int g3 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.F.h(tShowInfoNew, 3, g3, g3, ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !sl9Var.q().isBigV()) {
                    if (UbsABTestHelper.isPBPlanA()) {
                        if (DeviceInfoUtil.isMate30()) {
                            ww8.D(pbCommenFloorItemViewHolder.g);
                        } else {
                            q25.d(pbCommenFloorItemViewHolder.g).C(R.string.F_X02);
                        }
                        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                    } else {
                        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0106, 1);
                    }
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = sl9Var.q().getAvater();
                pbCommenFloorItemViewHolder.g.setTag(i4, sl9Var.q().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, sl9Var.q().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, sl9Var.q().getVirtualUserUrl());
                String name_show = sl9Var.q().getName_show();
                String userName = sl9Var.q().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(bs8.b(nu8Var.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, bs8.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (sl9Var.q().getPendantData() != null && !StringUtils.isNull(sl9Var.q().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.E.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.E.i(sl9Var.q());
                    pbCommenFloorItemViewHolder.p.setVisibility(8);
                    pbCommenFloorItemViewHolder.E.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.getHeadView().N(avater, 28, false);
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserId(sl9Var.q().getUserId());
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserName(sl9Var.q().getUserName());
                    pbCommenFloorItemViewHolder.E.i(sl9Var.q());
                } else {
                    pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, sl9Var.q(), 4);
                    pbCommenFloorItemViewHolder.p.setUserId(sl9Var.q().getUserId());
                    pbCommenFloorItemViewHolder.p.setUserName(sl9Var.q().getUserName(), sl9Var.n0());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, sl9Var.q().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.p.N(avater, 28, false);
                    pbCommenFloorItemViewHolder.p.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.setVisibility(8);
                }
                p(pbCommenFloorItemViewHolder.i, sl9Var, str, threadData);
            }
            if (nu8Var.y0() && sl9Var.q() != null) {
                i2 = sl9Var.q().getLevel_id();
            } else {
                i2 = 0;
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                i2 = 0;
            }
            if (i2 > 0) {
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                SkinManager.setImageResource(pbCommenFloorItemViewHolder.D, BitmapHelper.getGradeResourceIdInEnterForum(i2));
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
            }
            if (pbCommenFloorItemViewHolder.G.getChildCount() != 1) {
                pbCommenFloorItemViewHolder.G.getChildCount();
            }
            pbCommenFloorItemViewHolder.i.getVisibility();
            pbCommenFloorItemViewHolder.F.getChildCount();
            int l = ww8.l();
            if (sl9Var.q() != null) {
                str2 = sl9Var.q().getName_show();
            } else {
                str2 = "";
            }
            int e = jr5.e(str2);
            if (sl9Var.q() != null && !StringUtils.isNull(sl9Var.q().getSealPrefix())) {
                int i5 = l - 2;
                if (e > i5) {
                    str2 = jr5.m(str2, i5) + StringHelper.STRING_MORE;
                }
            } else if (e > l) {
                str2 = jr5.m(str2, l) + StringHelper.STRING_MORE;
            }
            if (sl9Var.q() != null && !StringUtils.isNull(sl9Var.q().getSealPrefix())) {
                pbCommenFloorItemViewHolder.g.setText(m(nu8Var, sl9Var.q().getSealPrefix(), str2));
            } else {
                pbCommenFloorItemViewHolder.g.setText(str2);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, sl9Var);
            sparseArray.put(R.id.tag_load_sub_data, sl9Var);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(sl9Var.E()));
            sparseArray.put(R.id.tag_forbid_user_post_id, sl9Var.O());
            if (sl9Var.q() != null && !StringUtils.isNull(sl9Var.q().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (threadData != null && nu8Var.d0() != 0 && !n(threadData)) {
                if (nu8Var.d0() != 1002 && nu8Var.d0() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (nu8Var.d0() != 3 && !threadData.isBjh()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (sl9Var != null && sl9Var.q() != null) {
                    String userId = sl9Var.q().getUserId();
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
            if (threadData != null && threadData.getAuthor() != null && sl9Var.q() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = sl9Var.q().getUserId();
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
                    if (sl9Var != null && sl9Var.q() != null && UtilHelper.isCurrentAccount(sl9Var.q().getUserId())) {
                        z4 = true;
                        z7 = true;
                    }
                    if (z2) {
                        z3 = false;
                        z6 = false;
                        z4 = false;
                    }
                    if (sl9Var.E() != 1) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (threadData != null && threadData.isUgcThreadType()) {
                        z3 = false;
                        z6 = false;
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(nu8Var.d0()));
                        if (sl9Var.q() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, sl9Var.q().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, sl9Var.q().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, sl9Var.q().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (sl9Var.q() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, sl9Var.q().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, sl9Var.q().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, sl9Var.q().getName_show());
                        }
                        sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                        sparseArray.put(R.id.tag_user_mute_post_id, sl9Var.O());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4 && threadData != null) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(nu8Var.d0()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, sl9Var.O());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf((z || sl9Var.u0()) ? true : true));
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
                    pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray);
                }
            }
            z6 = false;
            z7 = false;
            z8 = false;
            if (sl9Var != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (sl9Var.E() != 1) {
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
            sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
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

    public static SpannableStringBuilder m(nu8 nu8Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, nu8Var, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new jg6.a(str, R.drawable.pic_smalldot_title));
                return jg6.h(nu8Var.getPageContext().getPageActivity(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static void q(TbPageContext<?> tbPageContext, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65553, null, tbPageContext, pbCommenFloorItemViewHolder, sl9Var) == null) && sl9Var != null && WorldCupEnableSwitch.isOn()) {
            pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.A0.setVisibility(0);
            pbCommenFloorItemViewHolder.A0.setImageResource(R.drawable.obfuscated_res_0x7f080885);
            pbCommenFloorItemViewHolder.A0.setOnClickListener(new a(sl9Var, tbPageContext));
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbCommenFloorItemViewHolder.B0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(sl9Var.q());
            }
        }
    }

    public static void o(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65551, null, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.a != TbadkCoreApplication.getInst().getSkinType()) {
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    ww8.D(pbCommenFloorItemViewHolder.g);
                } else {
                    q25.d(pbCommenFloorItemViewHolder.g).C(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0106, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.C, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.t.b();
            if (pbCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s.g(TbadkCoreApplication.getInst().getSkinType());
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080a07, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080a08, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.setVisibility(8);
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            pbCommenFloorItemViewHolder.M.setVisibility(8);
            pbCommenFloorItemViewHolder.T.setVisibility(8);
            pbCommenFloorItemViewHolder.q.setFestivalTipViewSkin();
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void p(TextView textView, sl9 sl9Var, String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, textView, sl9Var, str, threadData) == null) {
            if (textView == null && sl9Var == null) {
                return;
            }
            textView.setTag(sl9Var);
            if (threadData != null && threadData.isUgcThreadType()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (sl9Var.q() != null) {
                MetaData q = sl9Var.q();
                if (str != null && !str.equals("0") && str.equals(q.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    q25 d = q25.d(textView);
                    d.o(R.string.J_X04);
                    d.m(R.dimen.L_X01);
                    d.w(R.color.CAM_X0302);
                    d.l(R.color.CAM_X0302);
                } else if (q.getIs_bawu() == 1 && sl9Var.v0()) {
                    q25 d2 = q25.d(textView);
                    d2.w(R.color.CAM_X0101);
                    d2.o(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (q.getIs_bawu() == 1 && "manager".equals(q.getBawu_type())) {
                    q25 d3 = q25.d(textView);
                    d3.w(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (q.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(q.getBawu_type())) {
                    q25 d4 = q25.d(textView);
                    d4.w(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (q.getIs_bawu() == 1 && "pri_content_assist".equals(q.getBawu_type())) {
                    q25 d5 = q25.d(textView);
                    d5.w(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (q.getIs_bawu() == 1 && "pri_manage_assist".equals(q.getBawu_type())) {
                    q25 d6 = q25.d(textView);
                    d6.w(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
