package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.widgets.WrapperLinearLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class uza implements View.OnClickListener, rza {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public LinearLayout b;
    public EMTextView c;
    public tza d;
    public EMTextView e;
    public View f;
    public AlertDialog g;
    public DialogInterface.OnDismissListener h;
    public boolean i;
    public ShareDialogConfig j;
    public float k;
    public boolean l;
    public ShareItem m;
    public CustomMessageListener n;
    public aja o;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uza a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(uza uzaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uzaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uzaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.h();
            if (this.a.j.getFrom().equals(ShareDialogConfig.From.PersonPolymeric)) {
                this.a.l = false;
            } else {
                this.a.l = true;
            }
            uza uzaVar = this.a;
            uzaVar.n(uzaVar.j, this.a.l);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uza a;

        public b(uza uzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uzaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uzaVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h != null) {
                    this.a.h.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001450);
                if (this.a.d != null) {
                    this.a.d.A();
                }
                if (this.a.o != null) {
                    this.a.o.c();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<uza> a;

        public c(uza uzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uzaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(uzaVar);
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                uza uzaVar = this.a.get();
                if (uzaVar != null && uzaVar.g != null) {
                    AlertDialog alertDialog = uzaVar.g;
                    if (alertDialog.isShowing()) {
                        alertDialog.dismiss();
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948229677, "Lcom/baidu/tieba/uza;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948229677, "Lcom/baidu/tieba/uza;");
                return;
            }
        }
        BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds130);
        p = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
        q = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X007);
        r = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        s = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        t = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X08);
        u = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X06);
        v = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    }

    public uza(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0.33f;
        this.n = new a(this, 2001304);
        this.a = context;
        WrapperLinearLayout wrapperLinearLayout = new WrapperLinearLayout(context);
        this.b = wrapperLinearLayout;
        wrapperLinearLayout.setOrientation(1);
        EMTextView eMTextView = new EMTextView(context);
        this.c = eMTextView;
        eMTextView.setTextSize(0, t);
        EMTextView eMTextView2 = this.c;
        int i3 = p;
        eMTextView2.setPadding(i3, q, i3, r);
        this.c.setGravity(1);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.b.addView(this.c);
        this.d = new tza(context);
        this.b.addView(this.d.o(z), new LinearLayout.LayoutParams(-1, -2));
        EMTextView eMTextView3 = new EMTextView(context);
        this.e = eMTextView3;
        eMTextView3.setGravity(1);
        this.e.setTextSize(0, u);
        this.e.setText(R.string.obfuscated_res_0x7f0f03d3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = v;
        this.e.setLayoutParams(layoutParams);
        EMTextView eMTextView4 = this.e;
        int i4 = s;
        eMTextView4.setPadding(0, i4, 0, i4);
        this.e.setOnClickListener(this);
        this.b.addView(this.e);
        this.f = new View(context);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.bottom_enter_anim_place_holder_height)));
        this.b.addView(this.f);
        this.d.B(this);
        aja ajaVar = new aja();
        this.o = ajaVar;
        ajaVar.b(this.a);
    }

    public void m(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onDismissListener) == null) {
            this.h = onDismissListener;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    @Override // com.baidu.tieba.rza
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            if (view2 == null) {
                i();
            } else if (!(view2.getTag() instanceof Integer)) {
                i();
            } else if (((Integer) view2.getTag()).intValue() == 25) {
            } else {
                i();
            }
        }
    }

    public void k(ShareDialogConfig.From from) {
        c95 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.c(from) && sharePanelConfData.b() && !qd.isEmpty(sharePanelConfData.a())) {
            this.c.setText(sharePanelConfData.a());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && view2 == this.e) {
            q("share_cancel", new Object[0]);
            i();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921798, 3));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager.from(this.b).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColorSelector(this.e, R.color.CAM_X0107);
        }
    }

    public void i() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (alertDialog = this.g) != null) {
            Context context = this.a;
            if (context instanceof Activity) {
                xb.a(alertDialog, (Activity) context);
                MessageManager.getInstance().unRegisterListener(this.n);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001450, new c(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void r() {
        aja ajaVar;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (ajaVar = this.o) != null && (shareItem = this.m) != null) {
            ajaVar.d(shareItem);
        }
    }

    public void n(@NonNull ShareDialogConfig shareDialogConfig, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, shareDialogConfig, z) == null) {
            if (!TextUtils.isEmpty(shareDialogConfig.shareItem.shareAbstract)) {
                ShareItem shareItem = shareDialogConfig.shareItem;
                shareItem.content = shareItem.shareAbstract;
            }
            ShareItem shareItem2 = shareDialogConfig.shareItem;
            if (!shareItem2.isShowShareOuerItem) {
                if (shareItem2.isVideoAdShare) {
                    this.c.setText(R.string.obfuscated_res_0x7f0f1731);
                } else {
                    this.c.setText(R.string.obfuscated_res_0x7f0f1732);
                }
            } else {
                String sharePanelText = TbSingleton.getInstance().getSharePanelText();
                if (!TextUtils.isEmpty(sharePanelText)) {
                    this.c.setText(sharePanelText);
                } else {
                    this.c.setText(R.string.obfuscated_res_0x7f0f1733);
                }
                k(shareDialogConfig.getFrom());
            }
            if (!TextUtils.isEmpty(shareDialogConfig.shareItem.getSharePanelTitle()) && (shareDialogConfig.shareItem.isShareTopic() || shareDialogConfig.shareItem.isShareAlbum() || shareDialogConfig.shareItem.isShareGroup())) {
                this.c.setText(shareDialogConfig.shareItem.getSharePanelTitle());
            }
            if (shareDialogConfig.isShowMask()) {
                this.c.setVisibility(4);
            }
            this.d.C(shareDialogConfig, this.i, z);
            this.j = shareDialogConfig;
            this.m = shareDialogConfig.shareItem;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f10010d).create();
            this.g = create;
            create.setCanceledOnTouchOutside(true);
            this.g.setOnDismissListener(new b(this));
            Context context = this.a;
            if (context instanceof Activity) {
                xb.i(this.g, (Activity) context);
            }
            EMManager.from(this.b).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0212);
            Window window = this.g.getWindow();
            if (window == null) {
                return;
            }
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100421);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.b);
            window.setDimAmount(this.k);
            l();
            a5.a(this.a).registerListener(this.n);
            GreyUtil.grey(window);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        }
    }

    public final void q(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }
}
