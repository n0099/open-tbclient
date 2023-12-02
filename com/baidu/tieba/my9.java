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
/* loaded from: classes7.dex */
public class my9 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public static double b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947989148, "Lcom/baidu/tieba/my9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947989148, "Lcom/baidu/tieba/my9;");
                return;
            }
        }
        a = new SparseIntArray();
        b = 3.88d;
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zv9 zv9Var, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, pbCommenFloorItemViewHolder, zv9Var, context) == null) && pbCommenFloorItemViewHolder.C0 != null) {
            List<RobotSkillInfo> list = zv9Var.N().robot_skill_info;
            List<RobotSkill> list2 = zv9Var.N().bottom_bar_robot_skill;
            if (list != null && list2 != null) {
                b(BotEntranceManager.g().c(list, list2).style_conf.android_extra.bot_reply_content_list, pbCommenFloorItemViewHolder, context);
            }
        }
    }

    public static void b(List<BotReplyContent> list, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, pbCommenFloorItemViewHolder, context) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        pbCommenFloorItemViewHolder.C0.removeAllViews();
        if (!ListUtils.isEmpty(list)) {
            pbCommenFloorItemViewHolder.C0.setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                PbPostFriendReplyView pbPostFriendReplyView = new PbPostFriendReplyView(context);
                pbPostFriendReplyView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                pbCommenFloorItemViewHolder.C0.addView(pbPostFriendReplyView);
                pbPostFriendReplyView.c(list.get(i));
            }
            return;
        }
        pbCommenFloorItemViewHolder.C0.setVisibility(8);
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

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zv9 zv9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, pbCommenFloorItemViewHolder, zv9Var, context) == null) {
            View view2 = pbCommenFloorItemViewHolder.n0;
            if (view2 != null) {
                view2.setVisibility(0);
                pbCommenFloorItemViewHolder.n0.setOnClickListener(null);
            }
            pbCommenFloorItemViewHolder.c0.setVisibility(8);
            if (zv9Var == null) {
                return;
            }
            a(pbCommenFloorItemViewHolder, zv9Var, context);
        }
    }

    public static void f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zv9 zv9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, pbCommenFloorItemViewHolder, zv9Var, context) == null) {
            g(pbCommenFloorItemViewHolder);
            if (zv9Var == null) {
                return;
            }
            a(pbCommenFloorItemViewHolder, zv9Var, context);
        }
    }

    public static void s(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, null, pbCommenFloorItemViewHolder, mwaVar, context) == null) {
            g(pbCommenFloorItemViewHolder);
            if (mwaVar != null && pbCommenFloorItemViewHolder.C0 != null) {
                b(mwaVar.y(), pbCommenFloorItemViewHolder, context);
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

    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, zv9 zv9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, pbCommenFloorItemViewHolder, mwaVar, zv9Var, context) == null) {
            if (mwaVar.l() == 0) {
                s(pbCommenFloorItemViewHolder, mwaVar, context);
            } else if (mwaVar.l() == 3) {
                f(pbCommenFloorItemViewHolder, zv9Var, context);
            } else {
                e(pbCommenFloorItemViewHolder, zv9Var, context);
            }
        }
    }

    public static void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View view2, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, pbCommenFloorItemViewHolder, mwaVar, view2, onTouchListener) == null) {
            j(pbCommenFloorItemViewHolder, mwaVar, view2, !TextUtils.isEmpty(mwaVar.x()), onTouchListener);
        }
    }

    public static void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View view2, boolean z, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{pbCommenFloorItemViewHolder, mwaVar, view2, Boolean.valueOf(z), onTouchListener}) == null) {
            if (!TextUtils.isEmpty(mwaVar.x()) && z) {
                zab.c(mwaVar, pbCommenFloorItemViewHolder.r);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams.topMargin = q(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = q(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(mwaVar.D())) {
                    pbCommenFloorItemViewHolder.t.setVisibility(0);
                    pbCommenFloorItemViewHolder.t.k(sq4.a(mwaVar.D()));
                    c(pbCommenFloorItemViewHolder.t, view2);
                } else {
                    pbCommenFloorItemViewHolder.t.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.r.p0(mwaVar.x());
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

    public static void k(ly9 ly9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65547, null, ly9Var, pbCommenFloorItemViewHolder, mwaVar, threadData) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            boolean z2 = true;
            if (mwaVar.L() > 0 && threadData != null && !threadData.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b5e), Integer.valueOf(mwaVar.L()));
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z = false;
            }
            cd5 a0 = mwaVar.a0();
            z2 = (a0 == null || StringUtils.isNull(a0.b()) || threadData == null || threadData.isBjh()) ? false : false;
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
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(mwaVar.r0()), "yyyy"))) {
                pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(mwaVar.r0()));
            } else {
                pbCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(mwaVar.r0()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.o.setVisibility(0);
                pbCommenFloorItemViewHolder.o.setText(a0.b());
                return;
            }
            pbCommenFloorItemViewHolder.o.setVisibility(8);
        }
    }

    public static void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{pbCommenFloorItemViewHolder, mwaVar, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null && mwaVar.p() != null) {
            if (threadData != null) {
                mwaVar.p().threadId = threadData.getTid();
                mwaVar.p().forumId = String.valueOf(threadData.getFid());
            }
            if (i == 0) {
                mwaVar.p().objType = 1;
            } else {
                mwaVar.p().objType = 2;
            }
            mwaVar.p().isInPost = true;
            pbCommenFloorItemViewHolder.p.E(z);
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.p.setData(mwaVar.p());
        }
    }

    public static void m(ly9 ly9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{ly9Var, pbCommenFloorItemViewHolder, mwaVar, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), tVar}) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            Activity pageActivity = ly9Var.getPageContext().getPageActivity();
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
            if (!TextUtils.isEmpty(mwaVar.x()) && z) {
                z4 = true;
            }
            zab.b(mwaVar, pbCommenFloorItemViewHolder.r, z4);
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            d(pbCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(mwaVar.x()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.r.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.r.setText(mwaVar.f0(), true, tVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, mwaVar);
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
    public static void n(ly9 ly9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View view2, ThreadData threadData, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{ly9Var, pbCommenFloorItemViewHolder, mwaVar, view2, threadData, Boolean.valueOf(z)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, mwaVar);
            sparseArray.put(R.id.tag_load_sub_data, mwaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_forbid_user_post_id, mwaVar.U());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.p);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.z);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.A);
            boolean z9 = true;
            if (mwaVar.u() != null && !StringUtils.isNull(mwaVar.u().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (ly9Var.z0() != 0 && !r(threadData)) {
                if (ly9Var.z0() != 1002 && ly9Var.z0() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (ly9Var.z0() != 3 && !threadData.isUgcThreadType()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (mwaVar.u() != null) {
                    String userId = mwaVar.u().getUserId();
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
            if (threadData != null && threadData.getAuthor() != null && mwaVar.u() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = mwaVar.u().getUserId();
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
                    if (mwaVar.u() != null && UtilHelper.isCurrentAccount(mwaVar.u().getUserId())) {
                        z4 = true;
                        z7 = true;
                    }
                    if (z2) {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (mwaVar.L() != 1) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ly9Var.z0()));
                        if (mwaVar.u() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, mwaVar.u().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, mwaVar.u().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, mwaVar.u().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (mwaVar.u() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, mwaVar.u().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, mwaVar.u().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, mwaVar.u().getName_show());
                        }
                        if (threadData != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, mwaVar.U());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(mwaVar.B0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ly9Var.z0()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_id, mwaVar.U());
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
            if (mwaVar.u() != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (mwaVar.L() != 1) {
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

    public static void o(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2, mwa mwaVar, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{pbCommenFloorItemViewHolder, view2, mwaVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.j0.setVisibility(0);
                pbCommenFloorItemViewHolder.m0.setVisibility(0);
                pbCommenFloorItemViewHolder.c0.setVisibility(4);
                if (!z2 && !mwaVar.C0()) {
                    pbCommenFloorItemViewHolder.v.setVisibility(8);
                }
                if (mwaVar.C0()) {
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
                mwaVar.m1(false);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_load_sub_data, mwaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            pbCommenFloorItemViewHolder.i0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.m0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.m0.setAlpha(0.5f);
            if (mwaVar.C0()) {
                pbCommenFloorItemViewHolder.m0.setOnClickListener(null);
            }
            if (mwaVar != null) {
                View view3 = pbCommenFloorItemViewHolder.m0;
                if (!mwaVar.G0() && !mwaVar.C0()) {
                    i = R.color.transparent;
                } else {
                    i = R.color.CAM_X0201;
                }
                SkinManager.setBackgroundColor(view3, i);
                EMTextView eMTextView = pbCommenFloorItemViewHolder.k0;
                boolean G0 = mwaVar.G0();
                int i4 = R.color.CAM_X0304;
                if (G0) {
                    i2 = R.color.CAM_X0304;
                } else {
                    i2 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i2);
                ImageView imageView = pbCommenFloorItemViewHolder.l0;
                if (mwaVar.G0()) {
                    i3 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i3 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!mwaVar.G0()) {
                    i4 = R.color.CAM_X0107;
                }
                WebPManager.setPureDrawable(imageView, i3, i4, null);
            }
        }
    }

    public static void p(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, pbCommenFloorItemViewHolder, mwaVar) == null) {
            if (mwaVar != null && mwaVar.u() != null && mwaVar.n0() != null) {
                TbRichText f0 = mwaVar.f0();
                if (f0 != null && StringUtils.isNull(f0.toString()) && StringUtils.isNull(mwaVar.x())) {
                    z = true;
                } else {
                    z = false;
                }
                if (mwaVar.u().getSmallTailThemeData() != null) {
                    str = mwaVar.u().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.L.setTag(R.id.tag_pb_small_tail_theme_id, str);
                s6a.c(mwaVar.n0(), pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, pbCommenFloorItemViewHolder.M, false, false, z, mwaVar.u().getSmallTailThemeData());
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
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080bd4, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.obfuscated_res_0x7f080bd5, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
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
