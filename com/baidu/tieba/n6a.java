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
import com.baidu.tieba.hz4;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.tieba.transmitShare.ShareScrollableLayout;
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
/* loaded from: classes7.dex */
public class n6a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int K;
    public static final int L;
    public static h M;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public SparseArray<String> B;
    public SparseArray<j85> C;
    public boolean D;
    public int E;
    public boolean F;
    public boolean G;
    public v5a H;
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
    public final ej8 w;
    public InsertGalleryAsyncTask x;
    public ShareItem y;
    public final SparseArray<ShareItem> z;

    public final boolean L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? (i2 & 4) > 0 : invokeI.booleanValue;
    }

    public final boolean N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean P(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final boolean R(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? (i2 & 32) > 0 : invokeI.booleanValue;
    }

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
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

    /* loaded from: classes7.dex */
    public static class h extends CustomMessageTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<n6a> a;

        /* loaded from: classes7.dex */
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
                n6a n6aVar;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    WeakReference<n6a> weakReference = this.a.a;
                    if (weakReference != null && (n6aVar = weakReference.get()) != null && n6aVar.l != null && n6aVar.l.isShowing()) {
                        n6aVar.z();
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

        public void a(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, n6aVar) == null) {
                WeakReference<n6a> weakReference = this.a;
                if (weakReference != null) {
                    weakReference.clear();
                    this.a = null;
                }
                if (n6aVar == null) {
                    return;
                }
                this.a = new WeakReference<>(n6aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n6a n6aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, Integer.valueOf(i)};
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
            this.a = n6aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            this.a.x();
            if (this.a.e != null) {
                this.a.e.removeAllViews();
            } else {
                this.a.f.removeAllViews();
            }
            if (this.a.e != null) {
                this.a.u();
            } else {
                this.a.t();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public b(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
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
                if (this.a.F(1).isFromDuXiaoMan && !this.a.G) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
                }
                if (this.a.H != null) {
                    this.a.H.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public c(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.k != null) {
                this.a.k.onCancel(dialogInterface);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ n6a b;

        public d(n6a n6aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n6aVar;
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

    /* loaded from: classes7.dex */
    public class e extends InsertGalleryAsyncTask.InsertGalleryListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n6a a;

        public e(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n6aVar;
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

    /* loaded from: classes7.dex */
    public class f implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ n6a b;

        public f(n6a n6aVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n6aVar;
            this.a = shareItem;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                AndroidUtils.copyToClipboard(this.a.content);
                BdUtilHelper.showToast(this.b.a.getApplicationContext(), (int) R.string.copy_success);
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(n6a n6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;
        public final /* synthetic */ n6a b;

        public i(n6a n6aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n6aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n6aVar;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.z();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955792, "Lcom/baidu/tieba/n6a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955792, "Lcom/baidu/tieba/n6a;");
                return;
            }
        }
        K = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        L = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.t) {
                this.d.setVisibility(8);
                if (Q()) {
                    this.o.setVisibility(0);
                    return;
                }
                return;
            }
            this.d.setVisibility(0);
            if (Q()) {
                this.o.setVisibility(8);
            }
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
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

    public void z() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (alertDialog = this.l) != null) {
            this.A = false;
            if (this.a instanceof Activity) {
                DialogInterface.OnDismissListener onDismissListener = this.j;
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(alertDialog);
                }
                hb.a(this.l, (Activity) this.a);
                MessageManager.getInstance().unRegisterListener(this.I);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n6a(Context context) {
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
            SparseArray<j85> sparseArray = this.C;
            if (sparseArray != null) {
                j85 j85Var = sparseArray.get(i2);
                if (!StringUtils.isNull(j85Var.b()) && j85Var.a() != null && j85Var.a().size() > 0) {
                    x0(j85Var.b(), j85Var.a());
                    return;
                }
            }
            SparseArray<String> sparseArray2 = this.B;
            if (sparseArray2 != null) {
                String str = sparseArray2.get(i2);
                if (!ad.isEmpty(str)) {
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
    public n6a(Context context, boolean z, int i2) {
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
        this.w = new ej8();
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
        View E = E();
        this.b = E;
        this.c = E.findViewById(R.id.obfuscated_res_0x7f0921d2);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0921d3);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.d.setText(sharePanelText);
        }
        ShareScrollableLayout shareScrollableLayout = (ShareScrollableLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0921f4);
        this.e = shareScrollableLayout;
        if (shareScrollableLayout == null) {
            ShareGridLayout shareGridLayout = (ShareGridLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0921d7);
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
        EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0904a7);
        this.g = eMTextView;
        eMTextView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090d55);
        this.o = relativeLayout;
        if (relativeLayout != null) {
            this.p = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091c7b);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091c7a);
            this.q = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f10cc);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.b.findViewById(R.id.obfuscated_res_0x7f091c7d);
            this.r = messageRedDotView;
            messageRedDotView.setExtendSize(BdUtilHelper.getDimens(context, R.dimen.tbds5));
            this.r.setTextSize(R.dimen.T_X09);
            this.r.setTextBold(true);
            this.s = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091c7c);
        }
        v5a v5aVar = new v5a();
        this.H = v5aVar;
        v5aVar.b(this.a);
    }

    public ShareItem F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ShareItem shareItem = this.z.get(i2);
            if (shareItem == null) {
                return this.z.get(1);
            }
            return shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public ShareItem H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            ShareItem shareItem = this.z.get(i2);
            if (shareItem == null) {
                return this.z.get(1);
            }
            return shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void I(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, onDismissListener) == null) && onDismissListener != null) {
            this.j = onDismissListener;
        }
    }

    public final boolean K(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, shareItem)) == null) {
            if (!TextUtils.isEmpty(shareItem.cmdKey) && !TextUtils.isEmpty(shareItem.cmdContent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void Z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) && onClickListener != null) {
            this.i = onClickListener;
        }
    }

    public void b0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.u = str;
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.D = z;
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.t = z;
        }
    }

    public void e0(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, sparseArray) == null) {
            this.B = sparseArray;
        }
    }

    public void f0(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onCancelListener) == null) {
            this.k = onCancelListener;
        }
    }

    public void g0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, onClickListener) != null) || !Q()) {
            return;
        }
        this.o.setOnClickListener(new d(this, onClickListener));
    }

    public void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
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

    public LinearLayout J(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.a();
            return shareDialogItemView;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public void k(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048613, this, i2, i3) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            List<View> list = this.h;
            shareDialogItemView.a();
            list.add(shareDialogItemView);
        }
    }

    public void n(int i2, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048619, this, i2, absSvgType) != null) || absSvgType == null) {
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

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<View> list = this.h;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d024c, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final Location G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return TransmitShareController.getForeverNullLocation();
        }
        return (Location) invokeV.objValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.o != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
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
            if (this.E == 2 && y()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B0(ShareItem shareItem, int i2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, shareItem, i2) != null) || shareItem == null) {
            return;
        }
        if (GroupInfoData.isValidGroup(shareItem.groupData)) {
            shareItem.shareMediaType = i2;
            dj8.a(shareItem.groupData, null, i2);
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
                if (!ad.isEmpty(shareItem.linkUrl)) {
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

    public final String C(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, shareItem)) == null) {
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

    public void V(ShareDialogConfig.From from) {
        i85 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.c(from) && sharePanelConfData.b() && !ad.isEmpty(sharePanelConfData.a())) {
            this.d.setText(sharePanelConfData.a());
        }
    }

    public final void S() {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
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
    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            EMManager.from(this.c).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColorSelector(this.g, R.color.CAM_X0107);
            if (Q()) {
                EMManager.from(this.o).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0201);
                this.p.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
                EMManager.from(this.q).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            }
        }
    }

    public final void U(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, metaData) != null) || metaData == null) {
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

    public void W(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || !Q()) {
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
        Location G;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048610, this, shareItem, z) == null) {
            this.y = shareItem;
            if (z && (G = G()) != null) {
                shareItem.location = G;
            }
            this.z.put(1, shareItem);
            if (!StringUtils.isNull(shareItem.experienceTip)) {
                this.d.setText(shareItem.experienceTip);
            }
            v5a v5aVar = this.H;
            if (v5aVar != null) {
                v5aVar.d(shareItem);
            }
        }
    }

    public final void n0(@NonNull MetaData metaData, @NonNull ForumData forumData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048620, this, metaData, forumData) != null) || sf8.a(this.a)) {
            return;
        }
        Context context = this.a;
        bh8 bh8Var = new bh8(context, new eh8(context));
        U(metaData);
        bh8Var.j(forumData, metaData);
        hj8.a("分享弹窗触发分享：分享成功");
        bh8Var.k();
    }

    public final void o0(@NonNull MetaData metaData, @NonNull GroupInfoData groupInfoData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048622, this, metaData, groupInfoData) != null) || sf8.a(this.a)) {
            return;
        }
        Context context = this.a;
        bh8 bh8Var = new bh8(context, new fh8(context));
        dj8.a(groupInfoData, metaData, 1);
        bh8Var.j(groupInfoData, metaData);
        hj8.a("分享弹窗触发分享：分享成功");
        bh8Var.k();
    }

    public void i0(int i2, ShareItem shareItem, boolean z) {
        Location G;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), shareItem, Boolean.valueOf(z)}) == null) {
            if (z && (G = G()) != null) {
                shareItem.location = G;
            }
            this.z.put(i2, shareItem);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.v = this.w.b();
            boolean D = D();
            List<MetaData> list = this.v;
            if (list != null && list.size() != 0 && !P(this.J) && TbadkCoreApplication.getCurrentAccount() != null && !D) {
                t0(0, 1, 2);
            } else if (D) {
                this.e.setItemParams(BdUtilHelper.getEquipmentWidth(this.a) / 5, L);
                u0(0, 1, D);
            } else {
                s0(0, 1);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048630, this) != null) || w0()) {
            return;
        }
        r0();
        if (!ha5.l()) {
            this.f.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.f.addView(this.h.get(i2), new ViewGroup.LayoutParams(K, L));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048632, this) != null) || w0()) {
            return;
        }
        r0();
        if (!ha5.l()) {
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
        k0();
        if (!ha5.l()) {
            this.e.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.e.addView(this.h.get(i2), new ViewGroup.LayoutParams(K, L));
        }
    }

    public final void l(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048615, this, i2, i3, i4, i5) == null) {
            r(i2, i3, SkinManager.getColor(R.color.CAM_X0107), i4, i5);
        }
    }

    public final void m(int i2, int i3, int i4, boolean z, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, 0, i4);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.a();
            MaskView.d(shareDialogItemView, z);
            this.e.b(i5, shareDialogItemView);
        }
    }

    public final void r(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, i4, i5);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            ShareScrollableLayout shareScrollableLayout = this.e;
            shareDialogItemView.a();
            shareScrollableLayout.b(i6, shareDialogItemView);
        }
    }

    public void o(View view2, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048621, this, view2, i2, onClickListener) == null) && i2 <= this.h.size() && i2 >= 0) {
            this.h.add(i2, view2);
            if (onClickListener != null) {
                view2.setOnClickListener(new i(this, onClickListener));
            }
        }
    }

    public final void q(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048626, this, absSvgType, i2, i3) != null) || absSvgType == null) {
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
            if (id != R.id.obfuscated_res_0x7f0904a7 && i2 != R.drawable.icon_pure_share_copy40 && p0()) {
                this.A = false;
                return;
            }
            if (i2 != R.drawable.icon_pure_share_download40) {
                z();
            }
            if (this.z.size() == 0) {
                return;
            }
            if (id != R.id.obfuscated_res_0x7f0904a7 && this.A) {
                return;
            }
            this.A = true;
            ShareItem H = H(1);
            ha5 ha5Var = new ha5(this.a, null);
            if (H != null && H.isAiApps) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", H.aiAppId).param("obj_type", H.aiAppType).param("obj_source", H.aiAppSource));
                Bundle bundle = new Bundle();
                bundle.putInt("source", 16);
                H.setStats(bundle);
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("obj_source", 25);
                TiebaStatic.log(statisticItem);
            }
            if (id == R.id.obfuscated_res_0x7f0904a7) {
                x0("share_cancel", new Object[0]);
                if (H != null && H.isFromWebActivity) {
                    B0(H, 16);
                }
                DialogInterface.OnCancelListener onCancelListener = this.k;
                if (onCancelListener != null) {
                    onCancelListener.onCancel(this.l);
                }
                if (H.isFromDuXiaoMan) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921798, 3));
                return;
            }
            if (H != null && H.isStampShare) {
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
                if (shareItem2 != null && i6a.a("wechat", shareItem2)) {
                    return;
                }
                x0("share_to_weixin", new Object[0]);
                y0(3);
                H = H(3);
                B0(H, 4);
                if (H != null) {
                    if (K(H) && H.getCommandChannelArray() != null && H.getCommandChannelArray().contains(3)) {
                        ba5.f(H, this.a, 3, this.k);
                    } else if (H.weixinDisable == 1) {
                        v0(H);
                    } else {
                        ha5Var.r(H);
                    }
                }
                statisticItem3.param("obj_type", 2);
            } else if (i2 == R.drawable.icon_mask_share_circle40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                ShareItem shareItem3 = this.y;
                if (shareItem3 != null && i6a.a("circle", shareItem3)) {
                    return;
                }
                x0("share_to_pyq", new Object[0]);
                y0(2);
                H = H(2);
                B0(H, 3);
                if (H != null) {
                    if (K(H) && H.getCommandChannelArray() != null && H.getCommandChannelArray().contains(2)) {
                        ba5.f(H, this.a, 2, this.k);
                    } else if (H.weixinDisable == 1) {
                        v0(H);
                    } else {
                        if (H.isFromShareFrs) {
                            H.content = "【" + H.title + "】 " + H.content;
                        }
                        ha5Var.s(H);
                    }
                }
                statisticItem3.param("obj_type", 3);
            } else if (i2 == R.drawable.icon_mask_share_qqzone40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                ShareItem shareItem4 = this.y;
                if (shareItem4 != null && i6a.a(ShareItem.OUTSIDE_SHARE_QQZONE, shareItem4)) {
                    return;
                }
                if (tda.b(this.a, "com.tencent.mobileqq")) {
                    x0("share_to_qzone", new Object[0]);
                    y0(4);
                    H = H(4);
                    B0(H, 5);
                    if (H != null) {
                        if (K(H) && H.getCommandChannelArray() != null && H.getCommandChannelArray().contains(4)) {
                            ba5.f(H, this.a, 4, this.k);
                        } else {
                            ha5Var.n(H);
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
                H = H(5);
                if (H != null) {
                    if (!H.isFromChosenPb) {
                        H.content = C(H);
                    }
                    ha5Var.q(H);
                }
            } else if (i2 == R.drawable.icon_mask_share_weibo40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                ShareItem shareItem5 = this.y;
                if (shareItem5 != null && i6a.a(ShareItem.OUTSIDE_SHARE_WEIBO, shareItem5)) {
                    return;
                }
                x0("share_to_sweibo", new Object[0]);
                y0(6);
                H = H(6);
                B0(H, 7);
                if (H != null) {
                    if (!H.isFromChosenPb) {
                        H.content = C(H);
                    }
                    if (K(H) && H.getCommandChannelArray() != null && H.getCommandChannelArray().contains(4)) {
                        ba5.f(H, this.a, 6, this.k);
                    } else {
                        ha5Var.p(H);
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
                H = H(7);
                if (H != null) {
                    if (!H.isFromChosenPb) {
                        H.content = C(H);
                    }
                    ha5Var.o(H);
                }
            } else if (i2 == R.drawable.icon_mask_share_qq40_svg) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                ShareItem shareItem6 = this.y;
                if (shareItem6 != null && i6a.a("qq", shareItem6)) {
                    return;
                }
                if (tda.b(this.a, "com.tencent.mobileqq")) {
                    x0("share_to_qq_friend", new Object[0]);
                    y0(8);
                    H = H(8);
                    B0(H, 9);
                    if (H != null) {
                        if (K(H) && H.getCommandChannelArray() != null && H.getCommandChannelArray().contains(4)) {
                            ba5.f(H, this.a, 8, this.k);
                        } else {
                            ha5Var.m(H);
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
                z();
                B0(H, 17);
                if (FileHelper.isLocalFile(H.imageUri)) {
                    if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.a, H.imageUri), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.a) == 0) {
                        BdUtilHelper.showToast(this.a, "保存成功！");
                    } else {
                        BdUtilHelper.showToast(this.a, "保存失败！");
                    }
                } else {
                    Uri uri = H.imageUri;
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
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090ad2);
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
                    S();
                    T();
                    if (H != null) {
                        H.shareMediaType = 24;
                        dj8.a(H.groupData, null, 24);
                    }
                } else if (i2 == 28) {
                    S();
                    if (H != null) {
                        H.shareMediaType = 28;
                        dj8.a(H.groupData, null, 28);
                    }
                }
            } else {
                B0(H, 10);
                View.OnClickListener onClickListener = this.i;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                } else {
                    AndroidUtils.copyToClipboard(H.linkUrl);
                    BdUtilHelper.showToast(this.a.getApplicationContext(), this.a.getResources().getString(R.string.copy_pb_url_success));
                }
                z0(H);
                if (H != null && H.isFromChosenPb) {
                    A0(8, H.ftid);
                }
                statisticItem3.param("obj_type", 8);
            }
            statisticItem3.param("obj_source", 6);
            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (H != null) {
                statisticItem3.param("fid", H.extData);
                statisticItem3.param("fname", H.fName);
            }
            TiebaStatic.log(statisticItem3);
        }
    }

    public final void p(@NonNull MetaData metaData, int i2, boolean z, int i3) {
        String avater;
        String name_show;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{metaData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            if (GroupInfoData.isValidGroup(metaData.groupData)) {
                avater = metaData.groupData.getPortrait();
                name_show = metaData.groupData.getName();
            } else {
                avater = metaData.getAvater();
                name_show = metaData.getName_show();
            }
            if (ns5.e(name_show) > 8) {
                name_show = ns5.m(name_show, 8) + "...";
            }
            shareDialogItemView.setItemIcon(avater, i2, metaData);
            shareDialogItemView.setItemName(name_show);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.setTag(R.id.obfuscated_res_0x7f090ad2, metaData);
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
            } else if (!ha5.l()) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
            } else {
                if (this.e != null) {
                    u();
                } else {
                    s();
                }
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f10010d).create();
                this.l = create;
                create.setCanceledOnTouchOutside(true);
                this.l.setOnDismissListener(new b(this));
                this.l.setOnCancelListener(new c(this));
                Context context = this.a;
                if (context instanceof Activity) {
                    hb.i(this.l, (Activity) context);
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
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f100420);
                } else {
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f5);
                }
                window.setGravity(80);
                m0(window);
                window.setContentView(this.b);
                window.setDimAmount(this.m);
                x();
                A();
                Y();
                k4.a(this.a).registerListener(this.I);
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
            if (!N(this.J)) {
                n(R.string.share_weixin, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
            }
            if (!O(this.J)) {
                n(R.string.share_weixin_timeline, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
            }
            if (!L(this.J)) {
                n(R.string.share_qq_friends, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
            }
            if (!M(this.J)) {
                n(R.string.share_qzone, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
            }
            if (!P(this.J)) {
                n(R.string.share_sina_weibo, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
            }
            if (R(this.J)) {
                k(R.string.share_save_pic, R.drawable.icon_pure_share_download40);
            }
            if (arrayList.size() > 0) {
                this.h.addAll(arrayList);
            }
            if (this.D) {
                k(R.string.share_copy, R.drawable.icon_pure_share_copy40);
            }
        }
    }

    public final void s0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048631, this, i2, i3) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !P(this.J)) {
                m(R.string.share_friend, R.drawable.icon_more_share2, 24, false, i2);
            }
            if (!N(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, i2);
            }
            if (!O(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, i2);
            }
            if (!L(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, i2);
            }
            if (!M(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, i2);
            }
            if (!P(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, i2);
            }
            if (R(this.J)) {
                l(R.string.share_save_pic, R.drawable.icon_pure_share_download40, 17, i3);
            }
            if (arrayList.size() > 0 && arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.D) {
                l(R.string.share_copy, R.drawable.icon_pure_share_copy40, 27, i3);
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
                    p(this.v.get(i5), 25, false, i2);
                }
            } else {
                for (int i6 = 0; i6 < 10; i6++) {
                    p(this.v.get(i6), 25, false, i2);
                }
            }
            this.e.a(i2);
            if (size >= 10) {
                l(R.string.more_friend, R.drawable.icon_share_morefriends, 28, i2);
            }
            m(R.string.share_friend, R.drawable.icon_more_share2, 24, false, i3);
            if (!N(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, i3);
            }
            if (!O(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, i3);
            }
            if (!L(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, i3);
            }
            if (!M(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, i3);
            }
            if (!P(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, i3);
            }
            if (R(this.J)) {
                l(R.string.share_save_pic, R.drawable.icon_pure_share_download40, 26, i4);
            }
            if (arrayList.size() > 0) {
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    this.e.b(i4, (View) arrayList.get(i7));
                }
            }
            if (this.D) {
                l(R.string.share_copy, R.drawable.icon_pure_share_copy40, 27, i4);
            }
        }
    }

    public final void u0(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !z) {
                m(R.string.share_friend, R.drawable.icon_more_share2, 24, false, i2);
            }
            if (!N(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, i2);
            }
            if (!O(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, i2);
            }
            if (!L(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, i2);
            }
            if (!M(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, i2);
            }
            if (!P(this.J)) {
                q(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, i2);
            }
            if (R(this.J)) {
                l(R.string.share_save_pic, R.drawable.icon_pure_share_download40, 17, i3);
            }
            if (arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.D) {
                k(R.string.share_copy, R.drawable.icon_pure_share_copy40);
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
            hz4 hz4Var = new hz4(activity);
            hz4Var.setTitle(shareItem.title);
            hz4Var.setMessage(shareItem.content);
            hz4Var.setAutoNight(false);
            hz4Var.setCancelable(true);
            hz4Var.setTitleShowCenter(true);
            hz4Var.setPositiveButton(R.string.share_copy, new f(this, shareItem));
            hz4Var.setNegativeButton(R.string.share_cancel, new g(this)).create(k4.a(activity));
            hz4Var.show();
        }
    }
}
