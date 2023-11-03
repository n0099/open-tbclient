package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.tieba.transmitShare.ShareScrollableLayout;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes8.dex */
public class sja implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int K;
    public static final int L;
    public static h M;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public SparseArray<String> B;
    public SparseArray<d95> C;
    public boolean D;
    public int E;
    public boolean F;
    public boolean G;
    public aja H;
    public CustomMessageListener I;
    public int J;
    public final Context a;
    public final View b;
    public final View c;
    public final TextView d;
    public ShareScrollableLayout e;
    public ShareGridLayout f;
    public final EMTextView g;
    public final List<View> h;
    public View.OnClickListener i;
    public DialogInterface.OnDismissListener j;
    public DialogInterface.OnCancelListener k;
    public AlertDialog l;
    public float m;
    public PermissionJudgePolicy n;
    public RelativeLayout o;
    public ImageView p;
    public TextView q;
    public MessageRedDotView r;
    public ImageView s;
    public boolean t;
    public String u;
    public List<MetaData> v;
    public final cw8 w;
    public InsertGalleryAsyncTask x;
    public ShareItem y;
    public final SparseArray<ShareItem> z;

    public final boolean M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? (i2 & 4) > 0 : invokeI.booleanValue;
    }

    public final boolean O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean P(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean Q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final boolean S(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? (i2 & 32) > 0 : invokeI.booleanValue;
    }

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
        }
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public static class h extends CustomMessageTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<sja> a;

        /* loaded from: classes8.dex */
        public class a implements CustomMessageTask.CustomRunnable<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                InterceptResult invokeL;
                sja sjaVar;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    WeakReference<sja> weakReference = this.a.a;
                    if (weakReference != null && (sjaVar = weakReference.get()) != null && sjaVar.l != null && sjaVar.l.isShowing()) {
                        sjaVar.A();
                        return null;
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h() {
            super(2001277, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), (CustomMessageTask.CustomRunnable) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRunnable = new a(this);
            setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        }

        public void a(sja sjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sjaVar) == null) {
                WeakReference<sja> weakReference = this.a;
                if (weakReference != null) {
                    weakReference.clear();
                    this.a = null;
                }
                if (sjaVar == null) {
                    return;
                }
                this.a = new WeakReference<>(sjaVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sja a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sja sjaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sjaVar, Integer.valueOf(i)};
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
            this.a = sjaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.y();
            if (this.a.e != null) {
                this.a.e.removeAllViews();
            } else {
                this.a.f.removeAllViews();
            }
            if (this.a.e != null) {
                this.a.x();
            } else {
                this.a.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sja a;

        public b(sja sjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sjaVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.j != null) {
                    this.a.j.onDismiss(dialogInterface);
                }
                if (this.a.x != null) {
                    this.a.x.cancel();
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                if (this.a.G(1).isFromDuXiaoMan && !this.a.G) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
                }
                if (this.a.H != null) {
                    this.a.H.c();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sja a;

        public c(sja sjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sjaVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.k != null) {
                this.a.k.onCancel(dialogInterface);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ sja b;

        public d(sja sjaVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sjaVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sjaVar;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.l != null) {
                    this.b.l.dismiss();
                }
                this.a.onClick(view2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends InsertGalleryAsyncTask.InsertGalleryListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sja a;

        public e(sja sjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sjaVar;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                BdUtilHelper.showToast(this.a.a, "保存成功！");
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                BdUtilHelper.showToast(this.a.a, "保存失败！");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ sja b;

        public f(sja sjaVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sjaVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sjaVar;
            this.a = shareItem;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                AndroidUtils.copyToClipboard(this.a.content);
                BdUtilHelper.showToast(this.b.a.getApplicationContext(), (int) R.string.copy_success);
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(sja sjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;
        public final /* synthetic */ sja b;

        public i(sja sjaVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sjaVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sjaVar;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.A();
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948154719, "Lcom/baidu/tieba/sja;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948154719, "Lcom/baidu/tieba/sja;");
                return;
            }
        }
        K = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        L = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    public void A() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (alertDialog = this.l) != null) {
            this.A = false;
            if (this.a instanceof Activity) {
                DialogInterface.OnDismissListener onDismissListener = this.j;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(alertDialog);
                }
                xb.a(this.l, (Activity) this.a);
                MessageManager.getInstance().unRegisterListener(this.I);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.t) {
                this.d.setVisibility(8);
                if (R()) {
                    this.o.setVisibility(0);
                    return;
                }
                return;
            }
            this.d.setVisibility(0);
            if (R()) {
                this.o.setVisibility(8);
            }
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (!(this.a instanceof Activity)) {
                return false;
            }
            if (this.n == null) {
                this.n = new PermissionJudgePolicy();
            }
            this.n.clearRequestPermissionList();
            this.n.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
            return this.n.startRequestPermission((Activity) this.a);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sja(Context context) {
        this(context, false, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void y0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048641, this, i2) == null) && i2 <= 8 && i2 > 0) {
            this.A = true;
            SparseArray<d95> sparseArray = this.C;
            if (sparseArray != null) {
                d95 d95Var = sparseArray.get(i2);
                if (!StringUtils.isNull(d95Var.b()) && d95Var.a() != null && d95Var.a().size() > 0) {
                    x0(d95Var.b(), d95Var.a());
                    return;
                }
            }
            SparseArray<String> sparseArray2 = this.B;
            if (sparseArray2 != null) {
                String str = sparseArray2.get(i2);
                if (!qd.isEmpty(str)) {
                    x0(str, new Object[0]);
                }
            }
        }
    }

    public final void z0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i2 = shareItem.objParam1;
            if (i2 != 0) {
                param.param("obj_param1", i2);
                int i3 = shareItem.objParam1;
                if (i3 == 2) {
                    param.param("fid", shareItem.fid);
                } else if (i3 == 3) {
                    int i4 = shareItem.obj_type;
                    if (i4 != 0) {
                        param.param("obj_type", i4);
                    }
                    param.param("tid", shareItem.tid).param("fid", shareItem.fid);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    @SuppressLint({"ResourceType"})
    public sja(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = 0.33f;
        this.v = new ArrayList();
        this.w = new cw8();
        this.z = new SparseArray<>(8);
        this.A = false;
        this.D = true;
        this.E = 1;
        this.F = true;
        this.I = new a(this, 2001304);
        this.J = 0;
        this.J = i2;
        this.a = context;
        this.h = new ArrayList();
        View F = F();
        this.b = F;
        this.c = F.findViewById(R.id.obfuscated_res_0x7f09221b);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09221c);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.d.setText(sharePanelText);
        }
        ShareScrollableLayout shareScrollableLayout = (ShareScrollableLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09223d);
        this.e = shareScrollableLayout;
        if (shareScrollableLayout == null) {
            ShareGridLayout shareGridLayout = (ShareGridLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092220);
            this.f = shareGridLayout;
            ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i5 = ShareGridLayout.f;
                marginLayoutParams.leftMargin = i5;
                marginLayoutParams.rightMargin = i5;
                this.f.setLayoutParams(marginLayoutParams);
            }
            this.f.setItemParams(K, L);
        } else {
            shareScrollableLayout.setItemParams(K, L);
        }
        EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0904c3);
        this.g = eMTextView;
        eMTextView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090d89);
        this.o = relativeLayout;
        if (relativeLayout != null) {
            this.p = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091cc2);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091cc1);
            this.q = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f10de);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.b.findViewById(R.id.obfuscated_res_0x7f091cc4);
            this.r = messageRedDotView;
            messageRedDotView.setExtendSize(BdUtilHelper.getDimens(context, R.dimen.tbds5));
            this.r.setTextSize(R.dimen.T_X09);
            this.r.setTextBold(true);
            this.s = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091cc3);
        }
        aja ajaVar = new aja();
        this.H = ajaVar;
        ajaVar.b(this.a);
    }

    public ShareItem G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ShareItem shareItem = this.z.get(i2);
            if (shareItem == null) {
                return this.z.get(1);
            }
            return shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public ShareItem I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            ShareItem shareItem = this.z.get(i2);
            if (shareItem == null) {
                return this.z.get(1);
            }
            return shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void J(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, onDismissListener) == null) && onDismissListener != null) {
            this.j = onDismissListener;
        }
    }

    public final boolean L(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, shareItem)) == null) {
            if (!TextUtils.isEmpty(shareItem.cmdKey) && !TextUtils.isEmpty(shareItem.cmdContent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void Z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) && onClickListener != null) {
            this.i = onClickListener;
        }
    }

    public void b0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.u = str;
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.D = z;
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.t = z;
        }
    }

    public void e0(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, sparseArray) == null) {
            this.B = sparseArray;
        }
    }

    public void f0(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onCancelListener) == null) {
            this.k = onCancelListener;
        }
    }

    public void g0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, onClickListener) != null) || !R()) {
            return;
        }
        this.o.setOnClickListener(new d(this, onClickListener));
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.E = i2;
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.F = z;
        }
    }

    public void m0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, window) == null) {
            window.setLayout(-1, -2);
        }
    }

    public final void A0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public LinearLayout K(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.a();
            return shareDialogItemView;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048615, this, i2, i3) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            List<View> list = this.h;
            shareDialogItemView.a();
            list.add(shareDialogItemView);
        }
    }

    public void o(int i2, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048621, this, i2, absSvgType) != null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.h;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public final void x0(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    public final void B0(ShareItem shareItem, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, shareItem, i2) != null) || shareItem == null) {
            return;
        }
        if (GroupInfoData.isValidGroup(shareItem.groupData)) {
            shareItem.shareMediaType = i2;
            bw8.a(shareItem.groupData, null, i2);
        } else if (shareItem.extData == null) {
            if (shareItem.isFromImageViewer) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2).param("obj_source", shareItem.objSource));
            }
        } else if (shareItem.isFromShareFrs) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.extData).param("obj_type", i2).param("obj_source", shareItem.objSource).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2));
        } else if (!shareItem.isFromSharePb && !shareItem.isFromFeed) {
            if (shareItem.isFromPhotoLive) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.extData).param("obj_type", i2));
            } else if (shareItem.isFromChosenPb) {
                A0(i2, shareItem.ftid);
            } else if (shareItem.isFromAcrossForum) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.extData).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2));
            } else if (shareItem.isFromWebActivity) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.objSource);
                if (!qd.isEmpty(shareItem.linkUrl)) {
                    if (shareItem.linkUrl.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    param.param(TiebaStatic.Params.OBJ_URL, shareItem.linkUrl);
                }
                TiebaStatic.log(param);
            } else if (shareItem.isFromTopicDetail) {
                if (i2 == 3) {
                    str = "1";
                } else if (i2 == 4) {
                    str = "2";
                } else if (i2 == 9) {
                    str = "4";
                } else if (i2 == 5) {
                    str = "3";
                } else if (i2 == 7) {
                    str = "5";
                } else {
                    str = "6";
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_TOPIC_DETAIL).param("obj_locate", str).param("topic_id", shareItem.extData));
            } else if (shareItem.isFromCommentShare) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("tid", shareItem.extData);
                statisticItem.param("post_id", shareItem.pid);
                statisticItem.param("obj_source", 18);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2);
                TiebaStatic.log(statisticItem);
            } else if (shareItem.isFromGameDetial) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_GAME_DETIAL);
                statisticItem2.param("obj_type", i2);
                statisticItem2.param("obj_name", shareItem.title);
                TiebaStatic.log(statisticItem2);
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem3.param("obj_source", 19);
                TiebaStatic.log(statisticItem3);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.extData).param("obj_type", i2).param("obj_source", shareItem.objSource).param("obj_param1", shareItem.objParam1).param("fid", shareItem.fid).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.objParam2));
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<View> list = this.h;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ShareItem shareItem = this.y;
            if (!shareItem.isFromWebActivity || shareItem.isDirectFromWeb) {
                ShareItem shareItem2 = this.y;
                if (!shareItem2.isFromTopicDetail && !shareItem2.isFromDuXiaoMan && !shareItem2.isAiApps && !shareItem2.isFromEmotionPackage) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0251, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final Location H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return TransmitShareController.getForeverNullLocation();
        }
        return (Location) invokeV.objValue;
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.o != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (M == null) {
                M = new h();
            }
            M.a(this);
            MessageManager.getInstance().registerTask(M);
        }
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.E == 2 && z()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String D(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, shareItem)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(shareItem.title)) {
                sb.append("【");
                sb.append(shareItem.title);
                sb.append("】 ");
            }
            if (!TextUtils.isEmpty(shareItem.title)) {
                sb.append(shareItem.content);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void W(ShareDialogConfig.From from) {
        c95 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.c(from) && sharePanelConfData.b() && !qd.isEmpty(sharePanelConfData.a())) {
            this.d.setText(sharePanelConfData.a());
        }
    }

    public final void T() {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (GroupInfoData.isValidGroup(this.y.groupData)) {
                obj = this.y.groupData;
            } else {
                obj = this.y.forumData;
            }
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921694, obj);
            MessageManager.getInstance().registerStickyMode(2921694);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this.a);
            shareFriendActivityConfig.setIsForShare(true);
            shareFriendActivityConfig.setFilterGroup(this.y.isFilterRooms());
            shareFriendActivityConfig.setFilterPerson(this.y.isFilterPerson());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_FRIEND_BTN);
            int i2 = this.y.objSource;
            int i3 = 2;
            if (i2 != 4 && i2 != 3 && i2 != 20 && i2 != 30) {
                if (i2 != 5 && i2 != 10 && i2 != 33) {
                    i3 = (i2 == 6 || i2 == 2) ? 3 : i2 == 8 ? 4 : (i2 == 25 || i2 == 29 || i2 == 11 || i2 == 12) ? 5 : 0;
                }
            } else {
                i3 = 1;
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i3);
            TiebaStatic.log(statisticItem);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            EMManager.from(this.c).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColorSelector(this.g, R.color.CAM_X0107);
            if (R()) {
                EMManager.from(this.o).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0201);
                this.p.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
                EMManager.from(this.q).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            }
        }
    }

    public final void V(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, metaData) != null) || metaData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_NEARLY_PERSON);
        int i2 = 0;
        int i3 = this.y.objSource;
        if (i3 != 4 && i3 != 3 && i3 != 20 && i3 != 30) {
            if (i3 != 5 && i3 != 10 && i3 != 33) {
                if (i3 != 6 && i3 != 2) {
                    if (i3 == 8) {
                        i2 = 4;
                    } else if (i3 == 25 || i3 == 29 || i3 == 11 || i3 == 12) {
                        i2 = 5;
                    }
                } else {
                    i2 = 3;
                }
            } else {
                i2 = 2;
            }
        } else {
            i2 = 1;
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_source", i2);
        if (GroupInfoData.isValidGroup(metaData.groupData)) {
            statisticItem.addParam("room_id", metaData.groupData.getGroupId());
            statisticItem.addParam("fid", metaData.groupData.getForumId());
            statisticItem.addParam("fname", metaData.groupData.getForumName());
        } else {
            statisticItem.addParam(TiebaStatic.Params.FRIEND_UID, metaData.getUserId());
        }
        TiebaStatic.log(statisticItem);
    }

    public void X(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || !R()) {
            return;
        }
        if (z) {
            if (i2 <= 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                this.r.refresh(i2);
            }
            this.r.setVisibility(0);
            return;
        }
        this.r.setVisibility(8);
    }

    public void h0(ShareItem shareItem, boolean z) {
        Location H;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048611, this, shareItem, z) == null) {
            this.y = shareItem;
            if (z && (H = H()) != null) {
                shareItem.location = H;
            }
            this.z.put(1, shareItem);
            if (!StringUtils.isNull(shareItem.experienceTip)) {
                this.d.setText(shareItem.experienceTip);
            }
            aja ajaVar = this.H;
            if (ajaVar != null) {
                ajaVar.d(shareItem);
            }
        }
    }

    public final void n0(@NonNull MetaData metaData, @NonNull ForumData forumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048620, this, metaData, forumData) != null) || qs8.a(this.a)) {
            return;
        }
        Context context = this.a;
        zt8 zt8Var = new zt8(context, new cu8(context));
        V(metaData);
        zt8Var.j(forumData, metaData);
        fw8.a("分享弹窗触发分享：分享成功");
        zt8Var.k();
    }

    public final void o0(@NonNull MetaData metaData, @NonNull GroupInfoData groupInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048622, this, metaData, groupInfoData) != null) || qs8.a(this.a)) {
            return;
        }
        Context context = this.a;
        zt8 zt8Var = new zt8(context, new du8(context));
        bw8.a(groupInfoData, metaData, 1);
        zt8Var.j(groupInfoData, metaData);
        fw8.a("分享弹窗触发分享：分享成功");
        zt8Var.k();
    }

    public void i0(int i2, ShareItem shareItem, boolean z) {
        Location H;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), shareItem, Boolean.valueOf(z)}) == null) {
            if (z && (H = H()) != null) {
                shareItem.location = H;
            }
            this.z.put(i2, shareItem);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.v = this.w.b();
            boolean E = E();
            List<MetaData> list = this.v;
            if (list != null && list.size() != 0 && !Q(this.J) && TbadkCoreApplication.getCurrentAccount() != null && !E) {
                t0(0, 1, 2);
            } else if (E) {
                this.e.setItemParams(BdUtilHelper.getEquipmentWidth(this.a) / 5, L);
                u0(0, 1, E);
            } else {
                s0(0, 1);
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048632, this) != null) || w0()) {
            return;
        }
        r0();
        if (!bb5.l()) {
            this.f.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.f.addView(this.h.get(i2), new ViewGroup.LayoutParams(K, L));
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048634, this) != null) || w0()) {
            return;
        }
        r0();
        if (!bb5.l()) {
            this.f.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.f.addView(this.h.get(i2), new ViewGroup.LayoutParams(K, L));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048638, this) != null) || w0()) {
            return;
        }
        k0();
        if (!bb5.l()) {
            this.e.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.e.addView(this.h.get(i2), new ViewGroup.LayoutParams(K, L));
        }
    }

    public final void m(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048617, this, i2, i3, i4, i5) == null) {
            s(i2, i3, SkinManager.getColor(R.color.CAM_X0107), i4, i5);
        }
    }

    public final void n(int i2, int i3, int i4, boolean z, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, 0, i4);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.a();
            MaskView.d(shareDialogItemView, z);
            this.e.b(i5, shareDialogItemView);
        }
    }

    public final void s(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, i4, i5);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            ShareScrollableLayout shareScrollableLayout = this.e;
            shareDialogItemView.a();
            shareScrollableLayout.b(i6, shareDialogItemView);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            this.G = true;
            int id = view2.getId();
            if (view2.getTag() != null) {
                i2 = ((Integer) view2.getTag()).intValue();
            } else {
                i2 = -1;
            }
            if (id != R.id.obfuscated_res_0x7f0904c3 && i2 != R.drawable.icon_pure_share_copy40 && p0()) {
                this.A = false;
                return;
            }
            if (i2 != R.drawable.icon_pure_share_download40) {
                A();
            }
            if (this.z.size() == 0) {
                return;
            }
            if (id != R.id.obfuscated_res_0x7f0904c3 && this.A) {
                return;
            }
            this.A = true;
            ShareItem I = I(1);
            bb5 bb5Var = new bb5(this.a, null);
            if (I != null && I.isAiApps) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", I.aiAppId).param("obj_type", I.aiAppType).param("obj_source", I.aiAppSource));
                Bundle bundle = new Bundle();
                bundle.putInt("source", 16);
                I.setStats(bundle);
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("obj_source", 25);
                TiebaStatic.log(statisticItem);
            }
            if (id == R.id.obfuscated_res_0x7f0904c3) {
                x0("share_cancel", new Object[0]);
                if (I != null && I.isFromWebActivity) {
                    B0(I, 16);
                }
                DialogInterface.OnCancelListener onCancelListener = this.k;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(this.l);
                }
                if (I.isFromDuXiaoMan) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921798, 3));
                return;
            }
            if (I != null && I.isStampShare) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem2.param("obj_source", 31);
                TiebaStatic.log(statisticItem2);
            }
            StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
            statisticItem3.param("obj_param1", this.u);
            if (i2 == R.drawable.icon_mask_share_wechat40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                ShareItem shareItem2 = this.y;
                if (shareItem2 != null && nja.a("wechat", shareItem2)) {
                    return;
                }
                x0("share_to_weixin", new Object[0]);
                y0(3);
                I = I(3);
                B0(I, 4);
                if (I != null) {
                    if (L(I) && I.getCommandChannelArray() != null && I.getCommandChannelArray().contains(3)) {
                        va5.f(I, this.a, 3, this.k);
                    } else if (I.weixinDisable == 1) {
                        v0(I);
                    } else {
                        bb5Var.r(I);
                    }
                }
                statisticItem3.param("obj_type", 2);
            } else if (i2 == R.drawable.icon_mask_share_circle40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                ShareItem shareItem3 = this.y;
                if (shareItem3 != null && nja.a("circle", shareItem3)) {
                    return;
                }
                x0("share_to_pyq", new Object[0]);
                y0(2);
                I = I(2);
                B0(I, 3);
                if (I != null) {
                    if (L(I) && I.getCommandChannelArray() != null && I.getCommandChannelArray().contains(2)) {
                        va5.f(I, this.a, 2, this.k);
                    } else if (I.weixinDisable == 1) {
                        v0(I);
                    } else {
                        if (I.isFromShareFrs) {
                            I.content = "【" + I.title + "】 " + I.content;
                        }
                        bb5Var.s(I);
                    }
                }
                statisticItem3.param("obj_type", 3);
            } else if (i2 == R.drawable.icon_mask_share_qqzone40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                ShareItem shareItem4 = this.y;
                if (shareItem4 != null && nja.a(ShareItem.OUTSIDE_SHARE_QQZONE, shareItem4)) {
                    return;
                }
                if (yqa.b(this.a, "com.tencent.mobileqq")) {
                    x0("share_to_qzone", new Object[0]);
                    y0(4);
                    I = I(4);
                    B0(I, 5);
                    if (I != null) {
                        if (L(I) && I.getCommandChannelArray() != null && I.getCommandChannelArray().contains(4)) {
                            va5.f(I, this.a, 4, this.k);
                        } else {
                            bb5Var.n(I);
                        }
                    }
                } else {
                    Context context = this.a;
                    BdToast.makeText(context, context.getText(R.string.share_qq_not_install)).show();
                }
                statisticItem3.param("obj_type", 5);
            } else if (i2 == R.drawable.icon_qq_weibo) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                x0("share_to_qweibo", new Object[0]);
                y0(5);
                I = I(5);
                if (I != null) {
                    if (!I.isFromChosenPb) {
                        I.content = D(I);
                    }
                    bb5Var.q(I);
                }
            } else if (i2 == R.drawable.icon_mask_share_weibo40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                ShareItem shareItem5 = this.y;
                if (shareItem5 != null && nja.a(ShareItem.OUTSIDE_SHARE_WEIBO, shareItem5)) {
                    return;
                }
                x0("share_to_sweibo", new Object[0]);
                y0(6);
                I = I(6);
                B0(I, 7);
                if (I != null) {
                    if (!I.isFromChosenPb) {
                        I.content = D(I);
                    }
                    if (L(I) && I.getCommandChannelArray() != null && I.getCommandChannelArray().contains(4)) {
                        va5.f(I, this.a, 6, this.k);
                    } else {
                        bb5Var.p(I);
                    }
                }
                statisticItem3.param("obj_type", 6);
            } else if (i2 == R.drawable.icon_renren) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                x0("share_to_renren", new Object[0]);
                y0(7);
                I = I(7);
                if (I != null) {
                    if (!I.isFromChosenPb) {
                        I.content = D(I);
                    }
                    bb5Var.o(I);
                }
            } else if (i2 == R.drawable.icon_mask_share_qq40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                ShareItem shareItem6 = this.y;
                if (shareItem6 != null && nja.a("qq", shareItem6)) {
                    return;
                }
                if (yqa.b(this.a, "com.tencent.mobileqq")) {
                    x0("share_to_qq_friend", new Object[0]);
                    y0(8);
                    I = I(8);
                    B0(I, 9);
                    if (I != null) {
                        if (L(I) && I.getCommandChannelArray() != null && I.getCommandChannelArray().contains(4)) {
                            va5.f(I, this.a, 8, this.k);
                        } else {
                            bb5Var.m(I);
                        }
                    }
                } else {
                    Context context2 = this.a;
                    BdToast.makeText(context2, context2.getText(R.string.share_qq_not_install)).show();
                }
                statisticItem3.param("obj_type", 4);
            } else if (i2 == R.drawable.icon_pure_share_download40) {
                if (this.n == null) {
                    this.n = new PermissionJudgePolicy();
                }
                this.n.clearRequestPermissionList();
                this.n.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.n.startRequestPermission((Activity) this.a)) {
                    this.A = false;
                    return;
                }
                A();
                B0(I, 17);
                if (FileHelper.isLocalFile(I.imageUri)) {
                    if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.a, I.imageUri), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.a) == 0) {
                        BdUtilHelper.showToast(this.a, "保存成功！");
                    } else {
                        BdUtilHelper.showToast(this.a, "保存失败！");
                    }
                } else {
                    Uri uri = I.imageUri;
                    if (uri == null) {
                        return;
                    }
                    String uri2 = uri.toString();
                    Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity == null) {
                        return;
                    }
                    InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(currentActivity, uri2, new e(this));
                    this.x = insertGalleryAsyncTask;
                    insertGalleryAsyncTask.execute(new String[0]);
                }
                statisticItem3.param("obj_type", 1);
            } else if (i2 != R.drawable.icon_pure_share_copy40 && i2 != 27) {
                if (i2 == 25) {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090af3);
                    if (this.a != null && (shareItem = this.y) != null && (tag instanceof MetaData)) {
                        ForumData forumData = shareItem.forumData;
                        if (forumData != null) {
                            n0((MetaData) tag, forumData);
                        } else if (GroupInfoData.isValidGroup(shareItem.groupData)) {
                            ShareItem shareItem7 = this.y;
                            shareItem7.shareMediaType = 24;
                            o0((MetaData) tag, shareItem7.groupData);
                        }
                    }
                } else if (i2 == 24) {
                    T();
                    U();
                    if (I != null) {
                        I.shareMediaType = 24;
                        bw8.a(I.groupData, null, 24);
                    }
                } else if (i2 == 28) {
                    T();
                    if (I != null) {
                        I.shareMediaType = 28;
                        bw8.a(I.groupData, null, 28);
                    }
                }
            } else {
                B0(I, 10);
                View.OnClickListener onClickListener = this.i;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                } else {
                    AndroidUtils.copyToClipboard(I.linkUrl);
                    BdUtilHelper.showToast(this.a.getApplicationContext(), this.a.getResources().getString(R.string.copy_pb_url_success));
                }
                z0(I);
                if (I != null && I.isFromChosenPb) {
                    A0(8, I.ftid);
                }
                statisticItem3.param("obj_type", 8);
            }
            statisticItem3.param("obj_source", 6);
            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (I != null) {
                statisticItem3.param("fid", I.extData);
                statisticItem3.param("fname", I.fName);
            }
            TiebaStatic.log(statisticItem3);
        }
    }

    public void p(View view2, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048624, this, view2, i2, onClickListener) == null) && i2 <= this.h.size() && i2 >= 0) {
            this.h.add(i2, view2);
            if (onClickListener != null) {
                view2.setOnClickListener(new i(this, onClickListener));
            }
        }
    }

    public final void r(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048628, this, absSvgType, i2, i3) != null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareScrollableLayout shareScrollableLayout = this.e;
        shareDialogItemView.a();
        shareScrollableLayout.b(i3, shareDialogItemView);
    }

    public final void q(@NonNull MetaData metaData, int i2, boolean z, int i3) {
        String avater;
        String name_show;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{metaData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            if (GroupInfoData.isValidGroup(metaData.groupData)) {
                avater = metaData.groupData.getPortrait();
                name_show = metaData.groupData.getName();
            } else {
                avater = metaData.getAvater();
                name_show = metaData.getName_show();
            }
            if (hu5.e(name_show) > 8) {
                name_show = hu5.m(name_show, 8) + "...";
            }
            shareDialogItemView.setItemIcon(avater, i2, metaData);
            shareDialogItemView.setItemName(name_show);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.setTag(R.id.obfuscated_res_0x7f090af3, metaData);
            shareDialogItemView.a();
            MaskView.d(shareDialogItemView, z);
            this.e.b(i3, shareDialogItemView);
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.G = false;
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
            } else if (!bb5.l()) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
            } else {
                if (this.e != null) {
                    x();
                } else {
                    t();
                }
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f10010d).create();
                this.l = create;
                create.setCanceledOnTouchOutside(true);
                this.l.setOnDismissListener(new b(this));
                this.l.setOnCancelListener(new c(this));
                Context context = this.a;
                if (context instanceof Activity) {
                    xb.i(this.l, (Activity) context);
                }
                EMManager.from(this.c).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
                Window window = this.l.getWindow();
                if (window == null) {
                    return;
                }
                if (this.F) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f100421);
                } else {
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f6);
                }
                window.setGravity(80);
                m0(window);
                window.setContentView(this.b);
                window.setDimAmount(this.m);
                y();
                B();
                Y();
                a5.a(this.a).registerListener(this.I);
                GreyUtil.grey(window);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (!O(this.J)) {
                o(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
            }
            if (!P(this.J)) {
                o(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
            }
            if (!M(this.J)) {
                o(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
            }
            if (!N(this.J)) {
                o(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
            }
            if (!Q(this.J)) {
                o(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
            }
            if (S(this.J)) {
                l(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
            }
            if (arrayList.size() > 0) {
                this.h.addAll(arrayList);
            }
            if (this.D) {
                l(R.string.share_copy, R.drawable.icon_pure_share_copy40);
            }
        }
    }

    public final void s0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048631, this, i2, i3) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !Q(this.J)) {
                n(R.string.share_friend, R.drawable.icon_more_share2, 24, false, i2);
            }
            if (!O(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, i2);
            }
            if (!P(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, i2);
            }
            if (!M(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, i2);
            }
            if (!N(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, i2);
            }
            if (!Q(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, i2);
            }
            if (S(this.J)) {
                m(R.string.share_save_pic, R.drawable.icon_pure_share_download40, 17, i3);
            }
            if (arrayList.size() > 0 && arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.D) {
                m(R.string.share_copy, R.drawable.icon_pure_share_copy40, 27, i3);
            }
        }
    }

    public final void t0(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048633, this, i2, i3, i4) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            int size = this.v.size();
            if (size < 10) {
                for (int i5 = 0; i5 < size; i5++) {
                    q(this.v.get(i5), 25, false, i2);
                }
            } else {
                for (int i6 = 0; i6 < 10; i6++) {
                    q(this.v.get(i6), 25, false, i2);
                }
            }
            this.e.a(i2);
            if (size >= 10) {
                m(R.string.more_friend, R.drawable.icon_share_morefriends, 28, i2);
            }
            n(R.string.share_friend, R.drawable.icon_more_share2, 24, false, i3);
            if (!O(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, i3);
            }
            if (!P(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, i3);
            }
            if (!M(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, i3);
            }
            if (!N(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, i3);
            }
            if (!Q(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, i3);
            }
            if (S(this.J)) {
                m(R.string.share_save_pic, R.drawable.icon_pure_share_download40, 26, i4);
            }
            if (arrayList.size() > 0) {
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    this.e.b(i4, (View) arrayList.get(i7));
                }
            }
            if (this.D) {
                m(R.string.share_copy, R.drawable.icon_pure_share_copy40, 27, i4);
            }
        }
    }

    public final void u0(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !z) {
                n(R.string.share_friend, R.drawable.icon_more_share2, 24, false, i2);
            }
            if (!O(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, i2);
            }
            if (!P(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, i2);
            }
            if (!M(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, i2);
            }
            if (!N(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, i2);
            }
            if (!Q(this.J)) {
                r(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, i2);
            }
            if (S(this.J)) {
                m(R.string.share_save_pic, R.drawable.icon_pure_share_download40, 17, i3);
            }
            if (arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.D) {
                l(R.string.share_copy, R.drawable.icon_pure_share_copy40);
            }
        }
    }

    public final void v0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, shareItem) == null) && shareItem != null && !TextUtils.isEmpty(shareItem.content) && !TextUtils.isEmpty(shareItem.title)) {
            Context context = this.a;
            if (!(context instanceof Activity)) {
                return;
            }
            Activity activity = (Activity) context;
            zz4 zz4Var = new zz4(activity);
            zz4Var.setTitle(shareItem.title);
            zz4Var.setMessage(shareItem.content);
            zz4Var.setAutoNight(false);
            zz4Var.setCancelable(true);
            zz4Var.setTitleShowCenter(true);
            zz4Var.setPositiveButton(R.string.share_copy, new f(this, shareItem));
            zz4Var.setNegativeButton(R.string.share_cancel, new g(this)).create(a5.a(activity));
            zz4Var.show();
        }
    }
}
