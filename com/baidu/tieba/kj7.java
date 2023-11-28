package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.forum.view.FrsCopyLinkGuideDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class kj7 extends j15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kj7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final void b(c05 dialog, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, dialog, view2) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            dialog.dismiss();
        }
    }

    public static final void c(Context context, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(context, "$context");
            ((f25) context).i1().s0();
            YunDialogManager.unMarkShowingDialogName("frsCopyLinkGuide");
        }
    }

    @Override // com.baidu.tieba.j15
    public void a(final Context context, x05 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if ((context instanceof f25) && (context instanceof Activity)) {
                f25 f25Var = (f25) context;
                Activity activity = (Activity) context;
                if (f25Var.i1().g0(activity)) {
                    final c05 c05Var = new c05(activity);
                    c05Var.setContentViewSize(2);
                    c05Var.setCanceledOnTouchOutside(false);
                    FrsCopyLinkGuideDialogView frsCopyLinkGuideDialogView = new FrsCopyLinkGuideDialogView(context, null, 0, 6, null);
                    frsCopyLinkGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.jj7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                kj7.b(c05.this, view2);
                            }
                        }
                    });
                    c05Var.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ij7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                kj7.c(context, dialogInterface);
                            }
                        }
                    });
                    c05Var.setContentView(frsCopyLinkGuideDialogView);
                    if (context instanceof qr6) {
                        c05Var.create(((qr6) context).getPageContext()).show();
                    } else if (context instanceof TbPageContextSupport) {
                        c05Var.create(((TbPageContextSupport) context).getPageContext()).show();
                    }
                    f25Var.i1().q1(activity);
                    YunDialogManager.markShowingDialogName("frsCopyLinkGuide");
                    return;
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示FRS复制链接引导弹窗失败");
            YunDialogManager.unMarkShowingDialogName("frsCopyLinkGuide");
        }
    }
}
