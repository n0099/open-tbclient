package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class o9a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final View b;
    public final TextView c;
    public final TextView d;
    public ShareGridLayout e;
    public final List<View> f;
    public View.OnClickListener g;
    public DialogInterface.OnDismissListener h;
    public AlertDialog i;
    public final SparseArray<ShareItem> j;
    public boolean k;
    public SparseArray<String> l;
    public SparseArray<xd5> m;

    @SuppressLint({"ResourceAsColor"})
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final boolean n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) ? (i & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? (i & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) ? (i & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) ? (i & 16) > 0 : invokeI.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o9a a;

        public a(o9a o9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o9aVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.i != null && this.a.i.isShowing()) {
                    this.a.f();
                    return null;
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o9a a;

        public b(o9a o9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o9aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h != null) {
                    this.a.h.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;
        public final /* synthetic */ o9a b;

        public c(o9a o9aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o9aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o9aVar;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.f();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947988466, "Lcom/baidu/tieba/o9a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947988466, "Lcom/baidu/tieba/o9a;");
                return;
            }
        }
        n = (int) ((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()) - (BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) * 0.2d);
        o = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
        p = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        q = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
        r = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        s = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    }

    public o9a(Context context, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new SparseArray<>(8);
        this.k = false;
        this.a = context;
        this.f = new ArrayList();
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0117, (ViewGroup) null);
        this.b = inflate;
        this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092200);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.d.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.b.findViewById(R.id.obfuscated_res_0x7f092204);
        this.e = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i4 = ShareGridLayout.f;
            marginLayoutParams.leftMargin = i4;
            marginLayoutParams.rightMargin = i4;
            this.e.setLayoutParams(marginLayoutParams);
        }
        this.e.setItemParams(n, o);
        TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0904ad);
        this.c = textView;
        textView.setOnClickListener(this);
        if (!o(i)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
        }
        if (!p(i)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
        }
        if (!n(i)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
        }
        if (!q(i)) {
            m(new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
        }
        if (!wf5.l()) {
            this.e.setVisibility(8);
        }
    }

    public final ShareItem j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            ShareItem shareItem = this.j.get(i);
            if (shareItem == null) {
                return this.j.get(1);
            }
            return shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void k(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, onDismissListener) == null) && onDismissListener != null) {
            this.h = onDismissListener;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) && onClickListener != null) {
            this.g = onClickListener;
        }
    }

    public final void A(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 9);
            int i = shareItem.objParam1;
            if (i != 0) {
                param.param("obj_param1", i);
                int i2 = shareItem.objParam1;
                if (i2 == 2) {
                    param.param("fid", shareItem.fid);
                } else if (i2 == 3) {
                    int i3 = shareItem.obj_type;
                    if (i3 != 0) {
                        param.param("obj_type", i3);
                    }
                    param.param("tid", shareItem.tid).param("fid", shareItem.fid);
                }
            }
            param.param("obj_locate", 7);
            TiebaStatic.log(param);
        }
    }

    public final void y(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048600, this, i) == null) && i <= 8 && i > 0) {
            this.k = true;
            SparseArray<xd5> sparseArray = this.m;
            if (sparseArray != null) {
                xd5 xd5Var = sparseArray.get(i);
                if (!StringUtils.isNull(xd5Var.b()) && xd5Var.a() != null && xd5Var.a().size() > 0) {
                    x(xd5Var.b(), xd5Var.a());
                    return;
                }
            }
            SparseArray<String> sparseArray2 = this.l;
            if (sparseArray2 != null) {
                String str = sparseArray2.get(i);
                if (!ei.isEmpty(str)) {
                    x(str, new Object[0]);
                }
            }
        }
    }

    public final void B(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public void t(ShareItem shareItem, boolean z) {
        Location i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, shareItem, z) == null) {
            if (z && (i = i()) != null) {
                shareItem.location = i;
            }
            this.j.put(1, shareItem);
        }
    }

    public final void x(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    public final void C(ShareItem shareItem, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, shareItem, i) == null) && shareItem != null && shareItem.extData != null) {
            if (shareItem.isFromShareFrs) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.extData).param("obj_type", i));
            } else if (!shareItem.isFromSharePb && !shareItem.isFromFeed) {
                if (shareItem.isFromPhotoLive) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.extData).param("obj_type", i));
                } else if (shareItem.isFromChosenPb) {
                    B(i, shareItem.ftid);
                } else if (shareItem.isFromAcrossForum) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i).param("fid", shareItem.extData));
                } else if (shareItem.isFromWebActivity) {
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i);
                    if (!ei.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    TiebaStatic.log(param);
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.extData).param("obj_type", i).param("obj_source", shareItem.objSource).param("obj_param1", shareItem.objParam1).param("fid", shareItem.fid));
            }
        }
    }

    public void c(View view2, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, view2, i, onClickListener) == null) && i <= this.f.size() && i >= 0) {
            this.f.add(i, view2);
            if (onClickListener != null) {
                view2.setOnClickListener(new c(this, onClickListener));
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (int i = 0; i < this.f.size(); i++) {
                this.e.addView(this.f.get(i), new ViewGroup.LayoutParams(n, o));
            }
        }
    }

    public void f() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (alertDialog = this.i) != null) {
            this.k = false;
            Context context = this.a;
            if (context instanceof Activity) {
                kg.a(alertDialog, (Activity) context);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<View> list = this.f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final Location i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return TransmitShareController.getForeverNullLocation();
        }
        return (Location) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final String h(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shareItem)) == null) {
            String str = "【" + shareItem.title + "】 " + shareItem.content;
            shareItem.content = str;
            return str;
        }
        return (String) invokeL.objValue;
    }

    public LinearLayout l(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i, i2)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.a);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
            int i3 = p;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            layoutParams.topMargin = q;
            layoutParams.bottomMargin = r;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.a);
            textView.setTextSize(0, s);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageResource(i2);
            textView.setTextColor(this.a.getResources().getColorStateList(R.color.obfuscated_res_0x7f060a9f));
            return linearLayout;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final void m(AbsSvgType absSvgType, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048589, this, absSvgType, i, i2) != null) || absSvgType == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(imageView);
        }
        int i3 = p;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.topMargin = q;
        layoutParams.bottomMargin = r;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.a);
        textView.setTextSize(0, s);
        textView.setText(i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        imageView.setImageDrawable(absSvgType.getDrawable());
        textView.setTextColor(this.a.getResources().getColorStateList(R.color.obfuscated_res_0x7f060a9f));
        linearLayout.setOnClickListener(this);
        this.f.add(linearLayout);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            int id = view2.getId();
            if (view2.getTag() != null) {
                i = ((Integer) view2.getTag()).intValue();
            } else {
                i = -1;
            }
            if (this.j.size() == 0) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0904ad && this.k) {
                return;
            }
            this.k = true;
            wf5 wf5Var = new wf5(this.a, null);
            ShareItem j = j(1);
            if (id == R.id.obfuscated_res_0x7f0904ad) {
                x("share_cancel", new Object[0]);
                f();
                return;
            }
            if (j.voiceRoomId > 0) {
                z(i, j);
            }
            if (i == 4) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                x("share_to_weixin", new Object[0]);
                y(3);
                ShareItem j2 = j(3);
                C(j2, 4);
                if (j2 != null) {
                    wf5Var.r(j2);
                }
            } else if (i == 3) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                x("share_to_pyq", new Object[0]);
                y(2);
                ShareItem j3 = j(2);
                C(j3, 3);
                if (j3 != null) {
                    if (j3.isFromShareFrs) {
                        j3.content = "【" + j3.title + "】 " + j3.content;
                    }
                    wf5Var.s(j3);
                }
            } else if (i == 5) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                } else if (xga.b(this.a, "com.tencent.mobileqq")) {
                    x("share_to_qzone", new Object[0]);
                    y(4);
                    ShareItem j4 = j(4);
                    C(j4, 5);
                    if (j4 != null) {
                        wf5Var.n(j4);
                    }
                } else {
                    Context context = this.a;
                    BdToast.makeText(context, context.getText(R.string.share_qq_not_install)).show();
                }
            } else if (i == 6) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                x("share_to_qweibo", new Object[0]);
                y(5);
                ShareItem j5 = j(5);
                C(j5, 6);
                if (j5 != null) {
                    if (!j5.isFromChosenPb) {
                        j5.content = h(j5);
                    }
                    wf5Var.q(j5);
                }
            } else if (i == 7) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                x("share_to_sweibo", new Object[0]);
                y(6);
                ShareItem j6 = j(6);
                C(j6, 7);
                if (j6 != null) {
                    if (!j6.isFromChosenPb) {
                        j6.content = h(j6);
                    }
                    wf5Var.p(j6);
                }
            } else if (i == 8) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                }
                x("share_to_renren", new Object[0]);
                y(7);
                ShareItem j7 = j(7);
                C(j7, 8);
                if (j7 != null) {
                    if (!j7.isFromChosenPb) {
                        j7.content = h(j7);
                    }
                    wf5Var.o(j7);
                }
            } else if (i == 9) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                    return;
                } else if (xga.b(this.a, "com.tencent.mobileqq")) {
                    x("share_to_qq_friend", new Object[0]);
                    y(8);
                    ShareItem j8 = j(8);
                    C(j8, 9);
                    if (j8 != null) {
                        wf5Var.m(j8);
                    }
                } else {
                    Context context2 = this.a;
                    BdToast.makeText(context2, context2.getText(R.string.share_qq_not_install)).show();
                }
            } else if (i == 10) {
                C(j, 10);
                View.OnClickListener onClickListener = this.g;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                } else {
                    AndroidUtils.copyToClipboard(j.linkUrl);
                    BdUtilHelper.showToast(this.a.getApplicationContext(), this.a.getResources().getString(R.string.copy_pb_url_success));
                }
                A(j);
                if (j != null && j.isFromChosenPb) {
                    B(8, j.ftid);
                }
            }
            f();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                Context context = this.a;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            } else if (!wf5.l()) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.plugin_share_install_failure);
            } else {
                d();
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f10010d).create();
                this.i = create;
                GreyUtil.grey(create);
                this.i.setCanceledOnTouchOutside(true);
                this.i.setOnDismissListener(new b(this));
                Context context2 = this.a;
                if (context2 instanceof Activity) {
                    kg.i(this.i, (Activity) context2);
                }
                this.b.setBackgroundResource(R.drawable.transmit_share_dialog_background);
                Window window = this.i.getWindow();
                window.addFlags(512);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f100424);
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setContentView(this.b);
                e();
                r();
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void z(int i, ShareItem shareItem) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048601, this, i, shareItem) == null) && i >= 0 && shareItem != null) {
            if (i == 4) {
                str = ThirdPartyUtil.TYPE_WEIXIN;
            } else if (i == 3) {
                str = "pyq";
            } else if (i == 9) {
                str = LoginConstants.QQ_LOGIN;
            } else if (i == 7) {
                str = "weibo";
            } else {
                str = "";
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
            statisticItem.addParam("obj_type", shareItem.voiceRoomShareType);
            statisticItem.addParam(TiebaStatic.Params.TIEBA_PARAMS, str);
            statisticItem.addParam("room_id", shareItem.voiceRoomId);
            statisticItem.eventStat();
        }
    }
}
