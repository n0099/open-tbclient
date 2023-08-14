package com.baidu.tieba.immessagecenter.chatgroup.grouppage.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.cn8;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatNameChangeNotifyData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.w3b;
import com.baidu.tieba.zm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonSyntaxException;
/* loaded from: classes6.dex */
public class NavigationBarSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> j;
    @NonNull
    public GroupChatFragment k;
    public boolean l;
    public boolean m;
    @Nullable
    public j n;
    @Nullable
    public TBAlertBuilder o;
    public i p;
    public FastRequest q;
    public long r;
    public long s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public String y;

    /* loaded from: classes6.dex */
    public class a extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBarSlice b;

        public a(NavigationBarSlice navigationBarSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = navigationBarSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, r5) != null) {
                return;
            }
            this.b.C0();
            this.b.F0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                BdLog.d("error: " + i + " " + str);
                GroupChatFragment groupChatFragment = this.b.k;
                if (groupChatFragment != null && groupChatFragment.getActivity() != null) {
                    new BdTopToast(this.b.k.getActivity()).setIcon(false).setContent(str).show((ViewGroup) this.b.k.getActivity().findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBarSlice a;

        public b(NavigationBarSlice navigationBarSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBarSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k.b2() && this.a.k.getActivity() != null) {
                this.a.k.getActivity().finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBarSlice a;

        public c(NavigationBarSlice navigationBarSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBarSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.w0();
                NavigationBarSlice navigationBarSlice = this.a;
                navigationBarSlice.u0(navigationBarSlice.l);
                this.a.l0();
                this.a.x = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBarSlice a;

        public d(NavigationBarSlice navigationBarSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBarSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.a.j, new String[]{w3b.a(w3b.a(TbConfig.URL_CHAT_ROOM, "roomId", String.valueOf(this.a.r)), "forumId", String.valueOf(this.a.s))});
                zm8.e("c15094", TbadkCoreApplication.getCurrentAccount(), this.a.s, this.a.r);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(NavigationBarSlice navigationBarSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public f(NavigationBarSlice navigationBarSlice, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarSlice, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                dialogInterface.dismiss();
                cn8.b((Activity) this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBarSlice a;

        public g(NavigationBarSlice navigationBarSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBarSlice;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.n = null;
            this.a.o = null;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public h(NavigationBarSlice navigationBarSlice, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBarSlice, alertDialog, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            DialogInterface.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null && (onClickListener = this.b) != null) {
                onClickListener.onClick(alertDialog, view2.getId());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public NavigationBar b;
        public View c;
        public ImageView d;
        public View e;
        public ImageView f;
        public View g;
        public RoundTbImageView h;
        public TextView i;
        public ImageView j;
        public TextView k;
        public ImageView l;

        public i() {
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

        public static i a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                i iVar = new i();
                iVar.a = view2;
                NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0918a0);
                iVar.b = navigationBar;
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
                iVar.e = addSystemImageButton;
                iVar.f = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
                View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d03e2, (ViewGroup) null);
                iVar.g = inflate;
                iVar.h = (RoundTbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e8d);
                iVar.i = (TextView) iVar.g.findViewById(R.id.obfuscated_res_0x7f090ea2);
                iVar.j = (ImageView) iVar.g.findViewById(R.id.obfuscated_res_0x7f091045);
                iVar.k = (TextView) iVar.g.findViewById(R.id.obfuscated_res_0x7f090ea5);
                iVar.l = (ImageView) iVar.g.findViewById(R.id.obfuscated_res_0x7f090e92);
                iVar.b.setTitleView(iVar.g, null, NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER);
                View addCustomView = iVar.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d07fb, (View.OnClickListener) null);
                iVar.c = addCustomView;
                iVar.d = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090ebb);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(iVar.d, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return iVar;
            }
            return (i) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ConstraintLayout a;
        public TextView b;
        public TextView c;
        public TextView d;
        public ImageView e;
        @DrawableRes
        public int f;

        public j() {
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

        @NonNull
        public static j a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                j jVar = new j();
                jVar.a = (ConstraintLayout) view2.findViewById(R.id.dialog_content);
                jVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908c4);
                jVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908b0);
                jVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908a3);
                jVar.e = (ImageView) view2.findViewById(R.id.dialog_image);
                return jVar;
            }
            return (j) invokeL.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                EMManager.from(this.a).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0201);
                EMManager.from(this.b).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05);
                EMManager.from(this.c).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X07);
                SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
                EMManager.from(this.d).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0302).setCorner(R.string.J_X07).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0304).setTextSize(R.dimen.T_X07);
                SkinManager.setImageResource(this.e, this.f);
            }
        }
    }

    public NavigationBarSlice(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, groupChatFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = false;
        this.j = tbPageContext;
        this.k = groupChatFragment;
    }

    public void B0(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) != null) || context == null) {
            return;
        }
        A0(context, R.string.im_group_chat_add_success_title, R.string.im_group_chat_add_success_desc, R.drawable.im_group_chat_subscribe_dialog, R.string.im_group_chat_add_success_btn, new f(this, context));
    }

    public void y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.p.g.setVisibility(i2);
            this.p.c.setVisibility(i2);
        }
    }

    public void z0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.y = str;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void U(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, bundle) == null) {
            super.U(view2, bundle);
            if (view2 != null) {
                this.p = i.a(view2);
            }
            n0();
            m0();
        }
    }

    public final void A0(@NonNull Context context, @StringRes int i2, @StringRes int i3, @DrawableRes int i4, @StringRes int i5, @Nullable DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener}) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d0260, (ViewGroup) null);
            linearLayout.addView(inflate);
            j a2 = j.a(inflate);
            this.n = a2;
            a2.b.setText(i2);
            this.n.c.setText(i3);
            this.n.d.setText(i5);
            j jVar = this.n;
            jVar.f = i4;
            jVar.b();
            TBAlertBuilder onDismissListener = new TBAlertBuilder((Activity) context).setShowBottomCloseBtn(false).setCustomContentView(linearLayout).setCancelable(false).setOnDismissListener(new g(this));
            this.o = onDismissListener;
            AlertDialog show = onDismissListener.show();
            if (show.getWindow() != null && show.getWindow().getAttributes() != null) {
                WindowManager.LayoutParams attributes = show.getWindow().getAttributes();
                attributes.width = UtilHelper.getDimenPixelSize(R.dimen.tbds838);
                show.getWindow().setAttributes(attributes);
            }
            this.n.d.setOnClickListener(new h(this, show, onClickListener));
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.l) {
                if (p0()) {
                    if (!o0()) {
                        B0(this.k.getActivity());
                        SharedPrefHelper.getInstance().putBoolean("key_group_chat_subscribe_click", true);
                    } else {
                        cn8.b(this.k.getActivity());
                    }
                }
            } else {
                cn8.c(this.k.getActivity());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921770));
        }
    }

    public boolean D0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.r <= 0 || this.l || i2 < TbSingleton.getInstance().getSendMsgNumToRemindSubscribe()) {
                return false;
            }
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("SHOW_SUBSCRIBE_REMIND_DIALOG_" + this.r);
            long j2 = sharedPrefHelper.getLong(sharedPrefKeyWithAccount, 0L);
            if (j2 > 0 && TimeHelper.isSameDay(j2, System.currentTimeMillis())) {
                return false;
            }
            sharedPrefHelper.putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
            this.u = true;
            if (!this.k.v2().e0()) {
                A0(this.k.requireContext(), R.string.im_group_chat_add_remind_title, R.string.im_group_chat_add_remind_desc, R.drawable.im_group_chat_subscribe_dialog, R.string.im_group_chat_add_success_btn, new e(this));
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void onChangeSkinType(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onChangeSkinType(i2);
            ImageView imageView = this.p.l;
            if (this.l) {
                i3 = R.drawable.pic_mask_chat_group_subscribe_select;
            } else {
                i3 = R.drawable.pic_mask_chat_group_subscribe;
            }
            SkinManager.setImageResource(imageView, i3);
            SkinManager.setViewTextColor(this.p.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p.k, (int) R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.p.d, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.p.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            j jVar = this.n;
            if (jVar != null) {
                jVar.b();
            }
            TBAlertBuilder tBAlertBuilder = this.o;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.onChangeSkinType();
            }
            this.p.h.setDrawBorder(true);
            this.p.h.setBorderWidth(BdUtilHelper.getDimens(this.k.getContext(), R.dimen.L_X04));
            this.p.h.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
        }
    }

    public final void F0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = !this.l;
            this.l = z;
            this.m = !z;
            ImageView imageView = this.p.l;
            if (z) {
                i2 = R.drawable.pic_mask_chat_group_subscribe_select;
            } else {
                i2 = R.drawable.pic_mask_chat_group_subscribe;
            }
            SkinManager.setImageResource(imageView, i2);
        }
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public final void l0() {
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (groupChatFragment = this.k) != null && groupChatFragment.v2() != null) {
            this.k.v2().d0();
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.q = new FastRequest(this.j, CmdConfigHttp.CMD_HTTP_GROUP_MESSAGE, "c/c/chatroom/opSubscribeChatroom");
        }
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return SharedPrefHelper.getInstance().getBoolean("key_group_chat_subscribe_click", false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            this.q.onDestroy();
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.v;
        }
        return invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.t != 0) {
                return false;
            }
            this.v = false;
            this.w = true;
            m0();
            w0();
            TiebaStatic.log(new StatisticItem("c15257"));
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && !s0()) {
            w0();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View O(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d06e6, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ChatNameChangeNotifyData chatNameChangeNotifyData = (ChatNameChangeNotifyData) DataExt.toEntity(str, ChatNameChangeNotifyData.class);
            if (this.r == chatNameChangeNotifyData.getRoomId()) {
                this.p.i.setText(chatNameChangeNotifyData.getName());
            }
        } catch (JsonSyntaxException e2) {
            if (!TbadkCoreApplication.getInst().isDebugMode()) {
                e2.printStackTrace();
                return;
            }
            throw e2;
        }
    }

    public final void u0(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            StatisticItem statisticItem = new StatisticItem("c15088");
            if (z) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.s).param("room_id", this.r));
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.p.j.setImageDrawable(WebPManager.getPureDrawable(R.drawable.im_group_chat, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL_PRESS));
            EMManager.from(this.p.i).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05);
            EMManager.from(this.p.k).setTextColor(R.string.F_X01).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X09);
            this.p.f.setOnClickListener(new b(this));
            this.p.l.setOnClickListener(new c(this));
            this.p.d.setOnClickListener(new d(this));
            this.p.j.setEnabled(false);
        }
    }

    public void w0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            FastRequest fastRequest = this.q;
            fastRequest.O("uid", TbadkCoreApplication.getCurrentAccount());
            fastRequest.O("chatroom_id", String.valueOf(this.r));
            if (this.l) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            fastRequest.O("op_type", Integer.valueOf(i2));
            fastRequest.Q(new a(this));
            fastRequest.P();
        }
    }

    public void x0(ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, chatRoomDetail) == null) && chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null && this.k.getActivity() != null) {
            String avatar = chatRoomDetail.getBasicInfo().getAvatar();
            if (avatar != null) {
                this.p.h.startLoad(avatar, 10, false);
            } else {
                this.p.h.setImageResource(R.drawable.chat_room_subscribe_icon);
            }
            this.p.i.setText(chatRoomDetail.getBasicInfo().getName());
            long discussNum = chatRoomDetail.getBasicInfo().getDiscussNum();
            String string = this.k.getActivity().getString(R.string.im_group_chat_online_num);
            int i2 = (discussNum > 0L ? 1 : (discussNum == 0L ? 0 : -1));
            if (i2 <= 0) {
                this.p.k.setText(R.string.im_group_chat_hot);
            } else if (!StringUtils.isNull(this.y)) {
                this.p.k.setText(this.y);
            } else if (i2 > 0 && discussNum <= 10000) {
                TextView textView = this.p.k;
                textView.setText(string + discussNum);
            } else {
                String numFormatOverWan = StringHelper.numFormatOverWan(discussNum);
                TextView textView2 = this.p.k;
                textView2.setText(string + numFormatOverWan);
            }
            this.r = chatRoomDetail.getBasicInfo().getId();
            this.s = chatRoomDetail.getBasicInfo().getForumId();
            int isSubscription = chatRoomDetail.getUserInfo().getIsSubscription();
            this.t = isSubscription;
            if (isSubscription == 1) {
                F0();
            }
        }
    }
}
