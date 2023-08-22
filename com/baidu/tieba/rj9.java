package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
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
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.view.PbPostFriendReplyView;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.vn6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tbclient.BotReplyContent;
import tbclient.RobotSkill;
import tbclient.RobotSkillInfo;
/* loaded from: classes7.dex */
public class rj9 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public static double b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zfa a;
        public final /* synthetic */ TbPageContext b;

        public a(zfa zfaVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zfaVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zfaVar;
            this.b = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.r() != null && this.a.r().getPortrait() != null && !TextUtils.isEmpty(this.a.r().getPortrait())) {
                String str2 = null;
                if (this.a.u0() != null) {
                    str2 = this.a.u0().getFigureUrl();
                    str = this.a.u0().getBackgroundValue();
                } else {
                    str = null;
                }
                p26.a(this.b, this.a.r().getPortrait(), str2, str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948123688, "Lcom/baidu/tieba/rj9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948123688, "Lcom/baidu/tieba/rj9;");
                return;
            }
        }
        a = new SparseIntArray();
        b = 3.88d;
    }

    public static void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yh9 yh9Var, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, pbCommenFloorItemViewHolder, yh9Var, context) == null) && pbCommenFloorItemViewHolder.D0 != null) {
            List<RobotSkillInfo> list = yh9Var.K().robot_skill_info;
            List<RobotSkill> list2 = yh9Var.K().bottom_bar_robot_skill;
            if (list != null && list2 != null) {
                b(BotEntranceManager.h().c(list, list2).style_conf.android_extra.bot_reply_content_list, pbCommenFloorItemViewHolder, context);
            }
        }
    }

    public static SpannableStringBuilder s(qj9 qj9Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, qj9Var, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new vn6.a(str, R.drawable.pic_smalldot_title));
                return vn6.h(qj9Var.getPageContext().getPageActivity(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public static void x(TbPageContext<?> tbPageContext, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65560, null, tbPageContext, pbCommenFloorItemViewHolder, zfaVar) == null) && zfaVar != null && WorldCupEnableSwitch.isOn()) {
            pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            pbCommenFloorItemViewHolder.B0.setVisibility(0);
            pbCommenFloorItemViewHolder.B0.setImageResource(R.drawable.obfuscated_res_0x7f080a16);
            pbCommenFloorItemViewHolder.B0.setOnClickListener(new a(zfaVar, tbPageContext));
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbCommenFloorItemViewHolder.C0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(zfaVar.r());
            }
        }
    }

    public static void b(List<BotReplyContent> list, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, pbCommenFloorItemViewHolder, context) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        pbCommenFloorItemViewHolder.D0.removeAllViews();
        if (!ListUtils.isEmpty(list)) {
            pbCommenFloorItemViewHolder.D0.setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                PbPostFriendReplyView pbPostFriendReplyView = new PbPostFriendReplyView(context);
                pbPostFriendReplyView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                pbCommenFloorItemViewHolder.D0.addView(pbPostFriendReplyView);
                pbPostFriendReplyView.c(list.get(i));
            }
            return;
        }
        pbCommenFloorItemViewHolder.D0.setVisibility(8);
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
                i2 = r(R.dimen.tbds90);
            } else {
                i2 = 0;
            }
            int i3 = equipmentWidth - i2;
            tbRichTextView.getLayoutStrategy().r(i3);
            tbRichTextView.getLayoutStrategy().J = i3 - r(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().q((int) (equipmentWidth * 1.618f));
        }
    }

    public static void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yh9 yh9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, pbCommenFloorItemViewHolder, yh9Var, context) == null) {
            View view2 = pbCommenFloorItemViewHolder.m0;
            if (view2 != null) {
                view2.setVisibility(0);
                pbCommenFloorItemViewHolder.m0.setOnClickListener(null);
            }
            pbCommenFloorItemViewHolder.b0.setVisibility(8);
            if (yh9Var == null) {
                return;
            }
            a(pbCommenFloorItemViewHolder, yh9Var, context);
        }
    }

    public static void f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yh9 yh9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, pbCommenFloorItemViewHolder, yh9Var, context) == null) {
            g(pbCommenFloorItemViewHolder);
            if (yh9Var == null) {
                return;
            }
            a(pbCommenFloorItemViewHolder, yh9Var, context);
        }
    }

    public static void u(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, pbCommenFloorItemViewHolder, zfaVar, context) == null) {
            g(pbCommenFloorItemViewHolder);
            if (zfaVar != null && pbCommenFloorItemViewHolder.D0 != null) {
                b(zfaVar.v(), pbCommenFloorItemViewHolder, context);
            }
        }
    }

    public static void g(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, pbCommenFloorItemViewHolder) == null) {
            View view2 = pbCommenFloorItemViewHolder.m0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.b0.setVisibility(0);
        }
    }

    public static int r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) {
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

    public static boolean t(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, threadData)) == null) {
            if (threadData == null) {
                return false;
            }
            return threadData.isBlocked();
        }
        return invokeL.booleanValue;
    }

    public static void h(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, yh9 yh9Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, pbCommenFloorItemViewHolder, zfaVar, yh9Var, context) == null) {
            if (zfaVar.l() == 0) {
                u(pbCommenFloorItemViewHolder, zfaVar, context);
            } else if (zfaVar.l() == 3) {
                f(pbCommenFloorItemViewHolder, yh9Var, context);
            } else {
                e(pbCommenFloorItemViewHolder, yh9Var, context);
            }
        }
    }

    public static void i(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, View view2, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, pbCommenFloorItemViewHolder, zfaVar, view2, onTouchListener) == null) {
            j(pbCommenFloorItemViewHolder, zfaVar, view2, !TextUtils.isEmpty(zfaVar.u()), onTouchListener);
        }
    }

    public static void j(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, View view2, boolean z, View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{pbCommenFloorItemViewHolder, zfaVar, view2, Boolean.valueOf(z), onTouchListener}) == null) {
            if (!TextUtils.isEmpty(zfaVar.u()) && z) {
                uua.c(zfaVar, pbCommenFloorItemViewHolder.q);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
                layoutParams.topMargin = r(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = r(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(zfaVar.C())) {
                    pbCommenFloorItemViewHolder.s.setVisibility(0);
                    pbCommenFloorItemViewHolder.s.k(mv4.a(zfaVar.C()));
                    c(pbCommenFloorItemViewHolder.s, view2);
                } else {
                    pbCommenFloorItemViewHolder.s.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.q.p0(zfaVar.u());
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

    public static void k(qj9 qj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65547, null, qj9Var, pbCommenFloorItemViewHolder, zfaVar, threadData) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            boolean z2 = true;
            if (zfaVar.I() > 0 && threadData != null && !threadData.isBjh()) {
                String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b22), Integer.valueOf(zfaVar.I()));
                pbCommenFloorItemViewHolder.C.setVisibility(0);
                pbCommenFloorItemViewHolder.C.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.C.setVisibility(8);
                z = false;
            }
            vg5 Z = zfaVar.Z();
            z2 = (Z == null || StringUtils.isNull(Z.b()) || threadData == null || threadData.isBjh()) ? false : false;
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
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(zfaVar.p0()), "yyyy"))) {
                pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(zfaVar.p0()));
            } else {
                pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(zfaVar.p0()));
            }
            if (z2) {
                pbCommenFloorItemViewHolder.n.setVisibility(0);
                pbCommenFloorItemViewHolder.n.setText(Z.b());
                return;
            }
            pbCommenFloorItemViewHolder.n.setVisibility(8);
        }
    }

    public static void l(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, ThreadData threadData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{pbCommenFloorItemViewHolder, zfaVar, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null && zfaVar.o() != null) {
            if (threadData != null) {
                zfaVar.o().threadId = threadData.getTid();
                zfaVar.o().forumId = String.valueOf(threadData.getFid());
            }
            if (i == 0) {
                zfaVar.o().objType = 1;
            } else {
                zfaVar.o().objType = 2;
            }
            zfaVar.o().isInPost = true;
            pbCommenFloorItemViewHolder.o.F(z);
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setData(zfaVar.o());
        }
    }

    public static void m(qj9 qj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, View view2, boolean z, boolean z2, boolean z3, TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{qj9Var, pbCommenFloorItemViewHolder, zfaVar, view2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), tVar}) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            Activity pageActivity = qj9Var.getPageContext().getPageActivity();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = BdUtilHelper.getDimens(pageActivity, R.dimen.M_W_X007);
            layoutParams.leftMargin = BdUtilHelper.getDimens(pageActivity, R.dimen.tbds148);
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
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
            if (!TextUtils.isEmpty(zfaVar.u()) && z) {
                z4 = true;
            }
            uua.b(zfaVar, pbCommenFloorItemViewHolder.q, z4);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            d(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(zfaVar.u()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(z2);
            pbCommenFloorItemViewHolder.q.setText(zfaVar.e0(), true, tVar);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, zfaVar);
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
    public static void n(qj9 qj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, View view2, ThreadData threadData, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{qj9Var, pbCommenFloorItemViewHolder, zfaVar, view2, threadData, Boolean.valueOf(z)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, zfaVar);
            sparseArray.put(R.id.tag_load_sub_data, zfaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_forbid_user_post_id, zfaVar.S());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
            boolean z9 = true;
            if (zfaVar.r() != null && !StringUtils.isNull(zfaVar.r().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (qj9Var.i0() != 0 && !t(threadData)) {
                if (qj9Var.i0() != 1002 && qj9Var.i0() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (qj9Var.i0() != 3 && !threadData.isUgcThreadType()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (zfaVar.r() != null) {
                    String userId = zfaVar.r().getUserId();
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
            if (threadData != null && threadData.getAuthor() != null && zfaVar.r() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = zfaVar.r().getUserId();
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
                    if (zfaVar.r() != null && UtilHelper.isCurrentAccount(zfaVar.r().getUserId())) {
                        z4 = true;
                        z7 = true;
                    }
                    if (z2) {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (zfaVar.I() != 1) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(qj9Var.i0()));
                        if (zfaVar.r() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, zfaVar.r().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, zfaVar.r().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, zfaVar.r().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (zfaVar.r() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, zfaVar.r().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, zfaVar.r().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, zfaVar.r().getName_show());
                        }
                        if (threadData != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, zfaVar.S());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(zfaVar.z0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(qj9Var.i0()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_id, zfaVar.S());
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
                        pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
                        return;
                    } else {
                        pbCommenFloorItemViewHolder.n0.setTag(null);
                        return;
                    }
                }
            }
            z6 = false;
            z7 = false;
            z8 = false;
            if (zfaVar.r() != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (zfaVar.I() != 1) {
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

    public static void o(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2, zfa zfaVar, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{pbCommenFloorItemViewHolder, view2, zfaVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.i0.setVisibility(0);
                pbCommenFloorItemViewHolder.l0.setVisibility(0);
                pbCommenFloorItemViewHolder.b0.setVisibility(4);
                if (!z2 && !zfaVar.i0) {
                    pbCommenFloorItemViewHolder.u.setVisibility(8);
                }
                if (zfaVar.i0) {
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
                zfaVar.f1(false);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_load_sub_data, zfaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            pbCommenFloorItemViewHolder.h0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.l0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.l0.setAlpha(0.5f);
            if (zfaVar.i0) {
                pbCommenFloorItemViewHolder.l0.setOnClickListener(null);
            }
            if (zfaVar != null) {
                View view3 = pbCommenFloorItemViewHolder.l0;
                if (!zfaVar.C0() && !zfaVar.i0) {
                    i = R.color.transparent;
                } else {
                    i = R.color.CAM_X0201;
                }
                SkinManager.setBackgroundColor(view3, i);
                EMTextView eMTextView = pbCommenFloorItemViewHolder.j0;
                boolean C0 = zfaVar.C0();
                int i4 = R.color.CAM_X0304;
                if (C0) {
                    i2 = R.color.CAM_X0304;
                } else {
                    i2 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(eMTextView, i2);
                ImageView imageView = pbCommenFloorItemViewHolder.k0;
                if (zfaVar.C0()) {
                    i3 = R.drawable.icon_pure_pb_del_select;
                } else {
                    i3 = R.drawable.icon_pure_pb_del_normal;
                }
                if (!zfaVar.C0()) {
                    i4 = R.color.CAM_X0107;
                }
                WebPManager.setPureDrawable(imageView, i3, i4, null);
            }
        }
    }

    public static void p(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, pbCommenFloorItemViewHolder, zfaVar) == null) {
            if (zfaVar != null && zfaVar.r() != null && zfaVar.l0() != null) {
                TbRichText e0 = zfaVar.e0();
                if (e0 != null && StringUtils.isNull(e0.toString()) && StringUtils.isNull(zfaVar.u())) {
                    z = true;
                } else {
                    z = false;
                }
                if (zfaVar.r().getSmallTailThemeData() != null) {
                    str = zfaVar.r().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.J.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                lq9.c(zfaVar.l0(), pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, false, false, z, zfaVar.r().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.J.setVisibility(8);
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0528  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, zfa zfaVar, View view2, int i, qj9 qj9Var, ThreadData threadData, boolean z) {
        String str;
        String str2;
        int i2;
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
        if ((interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{pbCommenFloorItemViewHolder, zfaVar, view2, Integer.valueOf(i), qj9Var, threadData, Boolean.valueOf(z)}) == null) && pbCommenFloorItemViewHolder != null && zfaVar != null) {
            boolean z9 = false;
            if (zfaVar.R) {
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
            if (zfaVar.r() != null) {
                if (str != null && !str.equals("0") && str.equals(zfaVar.r().getUserId())) {
                    pbCommenFloorItemViewHolder.q.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = zfaVar.r().getIconInfo();
                ArrayList<IconData> tShowInfoNew = zfaVar.r().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.G;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, zfaVar.r().getUserId());
                    pbCommenFloorItemViewHolder.G.setOnClickListener(qj9Var.R0().c);
                    int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.G;
                    i4 = R.id.tag_user_id;
                    userIconBox2.g(iconInfo, 2, dimens, dimens, dimens2);
                } else {
                    i4 = R.id.tag_user_id;
                }
                if (pbCommenFloorItemViewHolder.F != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.F.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    pbCommenFloorItemViewHolder.F.setOnClickListener(qj9Var.R0().e);
                    int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.F.h(tShowInfoNew, 3, dimens3, dimens3, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !zfaVar.r().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0106, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = zfaVar.r().getAvater();
                pbCommenFloorItemViewHolder.g.setTag(i4, zfaVar.r().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, zfaVar.r().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, zfaVar.r().getVirtualUserUrl());
                String name_show = zfaVar.r().getName_show();
                String userName = zfaVar.r().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(cg9.b(qj9Var.getPageContext().getPageActivity(), pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, cg9.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (zfaVar.r().getPendantData() != null && !StringUtils.isNull(zfaVar.r().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.E.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.E.i(zfaVar.r());
                    pbCommenFloorItemViewHolder.p.setVisibility(8);
                    pbCommenFloorItemViewHolder.E.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserId(zfaVar.r().getUserId());
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserName(zfaVar.r().getUserName());
                    pbCommenFloorItemViewHolder.E.i(zfaVar.r());
                } else {
                    pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, zfaVar.r(), 4);
                    pbCommenFloorItemViewHolder.p.setUserId(zfaVar.r().getUserId());
                    pbCommenFloorItemViewHolder.p.setUserName(zfaVar.r().getUserName(), zfaVar.s0());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, zfaVar.r().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.p.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.p.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.setVisibility(8);
                }
                w(pbCommenFloorItemViewHolder.i, zfaVar, str, threadData);
            }
            String str3 = "";
            if (!qj9Var.H0() || zfaVar.r() == null) {
                str2 = "";
                i2 = 0;
            } else {
                i2 = zfaVar.r().getLevel_id();
                str2 = zfaVar.r().getLevelName();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                i2 = 0;
            }
            if (i2 > 0) {
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setLevel(i2, str2);
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
            }
            if (pbCommenFloorItemViewHolder.G.getChildCount() != 1) {
                pbCommenFloorItemViewHolder.G.getChildCount();
            }
            pbCommenFloorItemViewHolder.i.getVisibility();
            pbCommenFloorItemViewHolder.F.getChildCount();
            int l = gm9.l();
            if (zfaVar.r() != null) {
                str3 = zfaVar.r().getName_show();
            }
            int e = ix5.e(str3);
            if (zfaVar.r() != null && !StringUtils.isNull(zfaVar.r().getSealPrefix())) {
                int i5 = l - 2;
                if (e > i5) {
                    str3 = ix5.m(str3, i5) + "...";
                }
            } else if (e > l) {
                str3 = ix5.m(str3, l) + "...";
            }
            if (zfaVar.r() != null && !StringUtils.isNull(zfaVar.r().getSealPrefix())) {
                pbCommenFloorItemViewHolder.g.setText(s(qj9Var, zfaVar.r().getSealPrefix(), str3));
            } else {
                pbCommenFloorItemViewHolder.g.setText(str3);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, zfaVar);
            sparseArray.put(R.id.tag_load_sub_data, zfaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(zfaVar.I()));
            sparseArray.put(R.id.tag_forbid_user_post_id, zfaVar.S());
            if (zfaVar.r() != null && !StringUtils.isNull(zfaVar.r().getVirtualUserUrl())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (threadData != null && qj9Var.i0() != 0 && !t(threadData)) {
                if (qj9Var.i0() != 1002 && qj9Var.i0() != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (qj9Var.i0() != 3 && !threadData.isBjh()) {
                    z4 = true;
                    z5 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
                if (zfaVar != null && zfaVar.r() != null) {
                    String userId = zfaVar.r().getUserId();
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
            if (threadData != null && threadData.getAuthor() != null && zfaVar.r() != null) {
                String userId2 = threadData.getAuthor().getUserId();
                String userId3 = zfaVar.r().getUserId();
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
                    if (zfaVar != null && zfaVar.r() != null && UtilHelper.isCurrentAccount(zfaVar.r().getUserId())) {
                        z4 = true;
                        z7 = true;
                    }
                    if (z2) {
                        z3 = false;
                        z6 = false;
                        z4 = false;
                    }
                    if (zfaVar.I() != 1) {
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
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(qj9Var.i0()));
                        if (zfaVar.r() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, zfaVar.r().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, zfaVar.r().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, zfaVar.r().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z6) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (zfaVar.r() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, zfaVar.r().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, zfaVar.r().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, zfaVar.r().getName_show());
                        }
                        sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                        sparseArray.put(R.id.tag_user_mute_post_id, zfaVar.S());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4 && threadData != null) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(qj9Var.i0()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray.put(R.id.tag_del_post_id, zfaVar.S());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf((z || zfaVar.z0()) ? true : true));
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
            if (zfaVar != null) {
                z4 = true;
                z7 = true;
            }
            if (z2) {
            }
            if (zfaVar.I() != 1) {
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

    public static void v(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65558, null, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        if (pbCommenFloorItemViewHolder.a != TbadkCoreApplication.getInst().getSkinType()) {
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0106, 1);
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
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080bab, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080bac, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.setVisibility(8);
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            pbCommenFloorItemViewHolder.M.setVisibility(8);
            pbCommenFloorItemViewHolder.f1151T.setVisibility(8);
            pbCommenFloorItemViewHolder.q.setFestivalTipViewSkin();
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0203);
        }
        pbCommenFloorItemViewHolder.a = TbadkCoreApplication.getInst().getSkinType();
    }

    public static void w(TextView textView, zfa zfaVar, String str, ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65559, null, textView, zfaVar, str, threadData) == null) {
            if (textView == null && zfaVar == null) {
                return;
            }
            textView.setTag(zfaVar);
            if (threadData != null && threadData.isUgcThreadType()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (zfaVar.r() != null) {
                MetaData r = zfaVar.r();
                if (str != null && !str.equals("0") && str.equals(r.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    EMManager.from(textView).setCorner(R.string.J_X04).setBorderWidth(R.dimen.L_X01).setTextColor(R.color.CAM_X0302).setBorderColor(R.color.CAM_X0302);
                } else if (r.getIs_bawu() == 1 && zfaVar.B0()) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (r.getIs_bawu() == 1 && "pri_content_assist".equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (r.getIs_bawu() == 1 && "pri_manage_assist".equals(r.getBawu_type())) {
                    EMManager.from(textView).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
