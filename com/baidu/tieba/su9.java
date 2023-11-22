package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.view.PbPostFriendReplyView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
import java.util.List;
import tbclient.BotReplyContent;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
/* loaded from: classes8.dex */
public class su9 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public static double b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948164050, "Lcom/baidu/tieba/su9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948164050, "Lcom/baidu/tieba/su9;");
                return;
            }
        }
        a = new SparseIntArray();
        b = 3.88d;
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, es9 es9Var, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, pbCommenFloorItemViewHolder, es9Var, context) == null) && pbCommenFloorItemViewHolder.B0 != null) {
            List<RobotSkillInfo> list = es9Var.K().robot_skill_info;
            List<RobotSkill> list2 = es9Var.K().bottom_bar_robot_skill;
            if (list != null && list2 != null) {
                b(BotEntranceManager.h().c(list, list2).style_conf.android_extra.bot_reply_content_list, pbCommenFloorItemViewHolder, context);
            }
        }
    }

    public static void b(List<BotReplyContent> list, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, pbCommenFloorItemViewHolder, context) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        pbCommenFloorItemViewHolder.B0.removeAllViews();
        if (!ListUtils.isEmpty(list)) {
            pbCommenFloorItemViewHolder.B0.setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                PbPostFriendReplyView pbPostFriendReplyView = new PbPostFriendReplyView(context);
                pbPostFriendReplyView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                pbCommenFloorItemViewHolder.B0.addView(pbPostFriendReplyView);
                pbPostFriendReplyView.c(list.get(i));
            }
            return;
        }
        pbCommenFloorItemViewHolder.B0.setVisibility(8);
    }

    public static void c(TbAlphaVideo tbAlphaVideo, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, tbAlphaVideo, view2) == null) && tbAlphaVideo != null && view2 != null) {
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds150);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (dimens * b), dimens);
            layoutParams.addRule(11);
            tbAlphaVideo.setLayoutParams(layoutParams);
        }
    }

    public static void d(TbRichTextView tbRichTextView, View view2, boolean z, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) && tbRichTextView != null && view2 != null) {
            int equipmentWidth = ((((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i2 = q(R.dimen.tbds90);
            } else {
                i2 = 0;
            }
            int i3 = equipmentWidth - i2;
            tbRichTextView.getLayoutStrategy().r(i3);
            tbRichTextView.getLayoutStrategy().J = i3 - q(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().q((int) (equipmentWidth * 1.618f));
        }
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, es9 es9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, pbCommenFloorItemViewHolder, es9Var, context) == null) {
            View view2 = pbCommenFloorItemViewHolder.n0;
            if (view2 != null) {
                view2.setVisibility(0);
                pbCommenFloorItemViewHolder.n0.setOnClickListener(null);
            }
            pbCommenFloorItemViewHolder.c0.setVisibility(8);
            if (es9Var == null) {
                return;
            }
            a(pbCommenFloorItemViewHolder, es9Var, context);
        }
    }

    public static void f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, es9 es9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, pbCommenFloorItemViewHolder, es9Var, context) == null) {
            g(pbCommenFloorItemViewHolder);
            if (es9Var == null) {
                return;
            }
            a(pbCommenFloorItemViewHolder, es9Var, context);
        }
    }

    public static void s(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vra vraVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, null, pbCommenFloorItemViewHolder, vraVar, context) == null) {
            g(pbCommenFloorItemViewHolder);
            if (vraVar != null && pbCommenFloorItemViewHolder.B0 != null) {
                b(vraVar.w(), pbCommenFloorItemViewHolder, context);
            }
        }
    }

    public static void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, pbCommenFloorItemViewHolder) == null) {
            View view2 = pbCommenFloorItemViewHolder.n0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.c0.setVisibility(0);
        }
    }

    public static int q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) {
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

    public static boolean r(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            return threadData.isBlocked();
        }
        return invokeL.booleanValue;
    }

    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vra vraVar, es9 es9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, pbCommenFloorItemViewHolder, vraVar, es9Var, context) == null) {
            if (vraVar.l() == 0) {
                s(pbCommenFloorItemViewHolder, vraVar, context);
            } else if (vraVar.l() == 3) {
                f(pbCommenFloorItemViewHolder, es9Var, context);
            } else {
                e(pbCommenFloorItemViewHolder, es9Var, context);
            }
        }
    }

    public static void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vra vraVar, View view2, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, pbCommenFloorItemViewHolder, vraVar, view2, onTouchListener) == null) {
            j(pbCommenFloorItemViewHolder, vraVar, view2, !TextUtils.isEmpty(vraVar.v()), onTouchListener);
        }
    }

    public static void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vra vraVar, View view2, boolean z, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{pbCommenFloorItemViewHolder, vraVar, view2, Boolean.valueOf(z), onTouchListener}) == null) {
            if (!TextUtils.isEmpty(vraVar.v()) && z) {
                e6b.c(vraVar, pbCommenFloorItemViewHolder.r);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams.topMargin = q(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = q(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(vraVar.C())) {
                    pbCommenFloorItemViewHolder.t.setVisibility(0);
                    pbCommenFloorItemViewHolder.t.k(oq4.a(vraVar.C()));
                    c(pbCommenFloorItemViewHolder.t, view2);
                } else {
                    pbCommenFloorItemViewHolder.t.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.r.p0(vraVar.v());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.r.p0(null);
                pbCommenFloorItemViewHolder.t.setVisibility(8);
            }
            if (onTouchListener != null) {
                pbCommenFloorItemViewHolder.r.setTextViewOnTouchListener(onTouchListener);
            }
            pbCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
        }
    }

    public static void k(ru9 ru9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vra vraVar, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65547, null, ru9Var, pbCommenFloorItemViewHolder, vraVar, threadData) == null) && pbCommenFloorItemViewHolder != null && vraVar != null) {
            boolean z2 = true;
            if (vraVar.J() > 0 && threadData != null && !threadData.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b51), Integer.valueOf(vraVar.J()));
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z = false;
            }
            tc5 Z = vraVar.Z();
            z2 = (Z == null || StringUtils.isNull(Z.b()) || threadData == null || threadData.isBjh()) ? false : false;
            if (z) {
                pbCommenFloorItemViewHolder.m.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.m.setVisibility(8);
            }
            if (z2) {
                pbCommenFloorItemViewHolder.n.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.n.setVisibility(8);
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(vraVar.q0()), "yyyy"))) {
                pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(vraVar.q0()));
            } else {
                pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(vraVar.q0()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.o.setVisibility(0);
                pbCommenFloorItemViewHolder.o.setText(Z.b());
                return;
            }
            pbCommenFloorItemViewHolder.o.setVisibility(8);
        }
    }

    public static void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vra vraVar, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{pbCommenFloorItemViewHolder, vraVar, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && vraVar != null && vraVar.p() != null) {
            if (threadData != null) {
                vraVar.p().threadId = threadData.getTid();
                vraVar.p().forumId = String.valueOf(threadData.getFid());
            }
            if (i == 0) {
                vraVar.p().objType = 1;
            } else {
                vraVar.p().objType = 2;
            }
            vraVar.p().isInPost = true;
            pbCommenFloorItemViewHolder.p.E(z);
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.p.setData(vraVar.p());
        }
    }

    public static void m(ru9 ru9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vra vraVar, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{ru9Var, pbCommenFloorItemViewHolder, vraVar, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), tVar}) == null) && pbCommenFloorItemViewHolder != null && vraVar != null) {
            Activity pageActivity = ru9Var.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = BdUtilHelper.getDimens(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = BdUtilHelper.getDimens(pageActivity, R.dimen.tbds148);
            boolean z4 = false;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            if (z) {
                pbCommenFloorItemViewHolder.r.p0(null);
                pbCommenFloorItemViewHolder.r.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.transparent_bg);
            } else {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.icon_click);
            }
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().z(R.drawable.pic_video);
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
            if (!TextUtils.isEmpty(vraVar.v()) && z) {
                z4 = true;
            }
            e6b.b(vraVar, pbCommenFloorItemViewHolder.r, z4);
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            d(pbCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(vraVar.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.r.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.r.setText(vraVar.e0(), true, tVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, vraVar);
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
    public static void n(ru9 ru9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vra vraVar, View view2, ThreadData threadData, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{ru9Var, pbCommenFloorItemViewHolder, vraVar, view2, threadData, Boolean.valueOf(z)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, vraVar);
            sparseArray.put(R.id.tag_load_sub_data, vraVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_forbid_user_post_id, vraVar.T());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.p);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.z);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.A);
            boolean z9 = true;
            if (vraVar.t() != null && !StringUtils.isNull(vraVar.t().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (ru9Var.v0() != 0 && !r(threadData)) {
                if (ru9Var.v0() != 1002 && ru9Var.v0() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (ru9Var.v0() != 3 && !threadData.isUgcThreadType()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (vraVar.t() != null) {
                    String userId = vraVar.t().getUserId();
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
            if (threadData != null && threadData.getAuthor() != null && vraVar.t() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = vraVar.t().getUserId();
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
                    if (vraVar.t() != null && UtilHelper.isCurrentAccount(vraVar.t().getUserId())) {
                        z4 = true;
                        z7 = true;
                    }
                    if (z2) {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (vraVar.J() != 1) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ru9Var.v0()));
                        if (vraVar.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, vraVar.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, vraVar.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, vraVar.t().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (vraVar.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, vraVar.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, vraVar.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, vraVar.t().getName_show());
                        }
                        if (threadData != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, vraVar.T());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(vraVar.A0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ru9Var.v0()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_id, vraVar.T());
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
                    if (pbCommenFloorItemViewHolder.Z == 0) {
                        z9 = false;
                    }
                    sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z9));
                    pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.t.setTag(sparseArray);
                    if (!z) {
                        pbCommenFloorItemViewHolder.o0.setTag(sparseArray);
                        return;
                    } else {
                        pbCommenFloorItemViewHolder.o0.setTag(null);
                        return;
                    }
                }
            }
            z6 = false;
            z7 = false;
            z8 = false;
            if (vraVar.t() != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (vraVar.J() != 1) {
            }
            if (!z3) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z8));
            if (pbCommenFloorItemViewHolder.Z == 0) {
            }
            sparseArray.put(R.id.tag_is_subpb, Boolean.valueOf(z9));
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            if (!z) {
            }
        }
    }

    public static void o(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2, vra vraVar, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{pbCommenFloorItemViewHolder, view2, vraVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.j0.setVisibility(0);
                pbCommenFloorItemViewHolder.m0.setVisibility(0);
                pbCommenFloorItemViewHolder.c0.setVisibility(4);
                if (!z2 && !vraVar.r0) {
                    pbCommenFloorItemViewHolder.v.setVisibility(8);
                }
                if (vraVar.r0) {
                    pbCommenFloorItemViewHolder.i0.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.i0.bringToFront();
                    pbCommenFloorItemViewHolder.i0.setVisibility(0);
                }
            } else {
                pbCommenFloorItemViewHolder.j0.setVisibility(8);
                pbCommenFloorItemViewHolder.i0.setVisibility(8);
                pbCommenFloorItemViewHolder.m0.setVisibility(8);
                if (z2) {
                    pbCommenFloorItemViewHolder.c0.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.v.setVisibility(0);
                }
                vraVar.k1(false);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_load_sub_data, vraVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            pbCommenFloorItemViewHolder.i0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.m0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.m0.setAlpha(0.5f);
            if (vraVar.r0) {
                pbCommenFloorItemViewHolder.m0.setOnClickListener(null);
            }
            if (vraVar != null) {
                View view3 = pbCommenFloorItemViewHolder.m0;
                if (!vraVar.D0() && !vraVar.r0) {
                    i = R.color.transparent;
                } else {
                    i = R.color.CAM_X0201;
                }
                SkinManager.setBackgroundColor(view3, i);
                EMTextView eMTextView = pbCommenFloorItemViewHolder.k0;
                boolean D0 = vraVar.D0();
                int i4 = R.color.CAM_X0304;
                if (D0) {
                    i2 = R.color.CAM_X0304;
                } else {
                    i2 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i2);
                ImageView imageView = pbCommenFloorItemViewHolder.l0;
                if (vraVar.D0()) {
                    i3 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i3 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!vraVar.D0()) {
                    i4 = R.color.CAM_X0107;
                }
                WebPManager.setPureDrawable(imageView, i3, i4, null);
            }
        }
    }

    public static void p(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, vra vraVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, pbCommenFloorItemViewHolder, vraVar) == null) {
            if (vraVar != null && vraVar.t() != null && vraVar.m0() != null) {
                TbRichText e0 = vraVar.e0();
                if (e0 != null && StringUtils.isNull(e0.toString()) && StringUtils.isNull(vraVar.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (vraVar.t().getSmallTailThemeData() != null) {
                    str = vraVar.t().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.L.setTag(R.id.tag_pb_small_tail_theme_id, str);
                s1a.c(vraVar.m0(), pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, pbCommenFloorItemViewHolder.M, false, false, z, vraVar.t().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    public static void t(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65556, null, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.a != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            pbCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbCommenFloorItemViewHolder.u.b();
            if (pbCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t.g(TbadkCoreApplication.getInst().getSkinType());
            }
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080bcc, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.obfuscated_res_0x7f080bcd, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.N.setVisibility(8);
            pbCommenFloorItemViewHolder.U.setVisibility(8);
            pbCommenFloorItemViewHolder.r.setFestivalTipViewSkin();
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }
}
