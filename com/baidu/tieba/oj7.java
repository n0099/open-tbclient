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
public final class oj7 extends m15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public oj7() {
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

    public static final void b(f05 dialog, View view2) {
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
            ((i25) context).i1().s0();
            YunDialogManager.unMarkShowingDialogName("frsCopyLinkGuide");
        }
    }

    @Override // com.baidu.tieba.m15
    public void a(final Context context, a15 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if ((context instanceof i25) && (context instanceof Activity)) {
                i25 i25Var = (i25) context;
                Activity activity = (Activity) context;
                if (i25Var.i1().g0(activity)) {
                    final f05 f05Var = new f05(activity);
                    f05Var.setContentViewSize(2);
                    f05Var.setCanceledOnTouchOutside(false);
                    FrsCopyLinkGuideDialogView frsCopyLinkGuideDialogView = new FrsCopyLinkGuideDialogView(context, null, 0, 6, null);
                    frsCopyLinkGuideDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.nj7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                oj7.b(f05.this, view2);
                            }
                        }
                    });
                    f05Var.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.mj7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                                oj7.c(context, dialogInterface);
                            }
                        }
                    });
                    f05Var.setContentView(frsCopyLinkGuideDialogView);
                    if (context instanceof ur6) {
                        f05Var.create(((ur6) context).getPageContext()).show();
                    } else if (context instanceof TbPageContextSupport) {
                        f05Var.create(((TbPageContextSupport) context).getPageContext()).show();
                    }
                    i25Var.i1().q1(activity);
                    YunDialogManager.markShowingDialogName("frsCopyLinkGuide");
                    return;
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示FRS复制链接引导弹窗失败");
            YunDialogManager.unMarkShowingDialogName("frsCopyLinkGuide");
        }
    }
}
