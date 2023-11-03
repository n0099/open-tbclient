package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
/* loaded from: classes7.dex */
public final class mj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bdUniqueId) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921465);
            if (bdUniqueId != null) {
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2921465, bdUniqueId));
            }
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public static final void b(String forumId, String threadId, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, forumId, threadId, bdUniqueId) == null) {
            Intrinsics.checkNotNullParameter(forumId, "forumId");
            Intrinsics.checkNotNullParameter(threadId, "threadId");
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
            httpMessage.addParam("forum_id", forumId);
            httpMessage.addParam("thread_id", threadId);
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static final void c(ImageView imageView, boolean z) {
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, imageView, z) == null) {
            if (z) {
                maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
            } else {
                maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
            }
            imageView.setImageDrawable(maskDrawable);
        }
    }

    public static final void d(final TbPageContext<?> context, final String forumId, final String threadId, y47 bawuThrones, final Function3<? super String, ? super String, ? super BdUniqueId, Unit> onConfirm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, context, forumId, threadId, bawuThrones, onConfirm) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(forumId, "forumId");
            Intrinsics.checkNotNullParameter(threadId, "threadId");
            Intrinsics.checkNotNullParameter(bawuThrones, "bawuThrones");
            Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
            final zz4 zz4Var = new zz4(context.getPageActivity());
            zz4Var.setContentViewSize(1);
            zz4Var.setNegativeTextColor(R.color.CAM_X0105);
            View inflate = LayoutInflater.from(context.getPageActivity()).inflate(R.layout.call_fans_dialog_content, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context.pageActivit…ans_dialog_content, null)");
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0925fe);
            textView.setText(R.string.frs_recommend_thread_sure_title);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            TextView textView2 = (TextView) inflate.findViewById(R.id.call_fans_intro);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = context.getString(R.string.frs_recommend_thread_sure_content);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…mend_thread_sure_content)");
            String format = String.format(string, Arrays.copyOf(new Object[]{bawuThrones.a(), Integer.valueOf(bawuThrones.b()), Integer.valueOf(bawuThrones.b() - bawuThrones.c())}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView2.setText(format);
            final ImageView noTipAgainCheckBox = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090715);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.no_tip_again_text), (int) R.color.CAM_X0107);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Intrinsics.checkNotNullExpressionValue(noTipAgainCheckBox, "noTipAgainCheckBox");
            c(noTipAgainCheckBox, booleanRef.element);
            inflate.findViewById(R.id.no_tip_again_group).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.jj7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        mj7.e(Ref.BooleanRef.this, noTipAgainCheckBox, view2);
                    }
                }
            });
            zz4Var.setContentView(inflate);
            zz4Var.setPositiveButton(context.getString(R.string.frs_recommend_thread_confirm), new zz4.e() { // from class: com.baidu.tieba.gj7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.zz4.e
                public final void onClick(zz4 zz4Var2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, zz4Var2) == null) {
                        mj7.f(Ref.BooleanRef.this, onConfirm, forumId, threadId, context, zz4Var, zz4Var2);
                    }
                }
            });
            zz4Var.setNegativeButton(context.getString(R.string.next_time), new zz4.e() { // from class: com.baidu.tieba.hj7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.zz4.e
                public final void onClick(zz4 zz4Var2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, zz4Var2) == null) {
                        mj7.g(Ref.BooleanRef.this, zz4Var, zz4Var2);
                    }
                }
            });
            zz4Var.create(context).show();
        }
    }

    public static final void e(Ref.BooleanRef isChecked, ImageView noTipAgainCheckBox, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, isChecked, noTipAgainCheckBox, view2) == null) {
            Intrinsics.checkNotNullParameter(isChecked, "$isChecked");
            isChecked.element = !isChecked.element;
            Intrinsics.checkNotNullExpressionValue(noTipAgainCheckBox, "noTipAgainCheckBox");
            c(noTipAgainCheckBox, isChecked.element);
        }
    }

    public static final void g(Ref.BooleanRef isChecked, zz4 alertDialog, zz4 zz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, isChecked, alertDialog, zz4Var) == null) {
            Intrinsics.checkNotNullParameter(isChecked, "$isChecked");
            Intrinsics.checkNotNullParameter(alertDialog, "$alertDialog");
            isChecked.element = false;
            alertDialog.dismiss();
        }
    }

    public static final void f(Ref.BooleanRef isChecked, Function3 onConfirm, String forumId, String threadId, TbPageContext context, zz4 alertDialog, zz4 zz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{isChecked, onConfirm, forumId, threadId, context, alertDialog, zz4Var}) == null) {
            Intrinsics.checkNotNullParameter(isChecked, "$isChecked");
            Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
            Intrinsics.checkNotNullParameter(forumId, "$forumId");
            Intrinsics.checkNotNullParameter(threadId, "$threadId");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(alertDialog, "$alertDialog");
            SharedPrefHelper.getInstance().putBoolean("key_frs_recommend_tip", !isChecked.element);
            onConfirm.invoke(forumId, threadId, context.getUniqueId());
            alertDialog.dismiss();
        }
    }
}
