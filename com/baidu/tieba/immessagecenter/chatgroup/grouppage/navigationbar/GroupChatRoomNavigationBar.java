package com.baidu.tieba.immessagecenter.chatgroup.grouppage.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.hi;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatNameChangeNotifyData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.l95;
import com.baidu.tieba.m35;
import com.baidu.tieba.n15;
import com.baidu.tieba.nx7;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.z1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonSyntaxException;
/* loaded from: classes4.dex */
public class GroupChatRoomNavigationBar implements LifecycleObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<BaseFragmentActivity> a;
    public GroupChatFragment b;
    public boolean c;
    public boolean d;
    public FastRequest e;
    public i f;
    public long g;
    public long h;
    @Nullable
    public j i;
    @Nullable
    public TBAlertBuilder j;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(GroupChatRoomNavigationBar groupChatRoomNavigationBar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRoomNavigationBar, context};
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
                l95.h((Activity) this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(GroupChatRoomNavigationBar groupChatRoomNavigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRoomNavigationBar};
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

    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRoomNavigationBar a;

        public c(GroupChatRoomNavigationBar groupChatRoomNavigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRoomNavigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRoomNavigationBar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.i = null;
            this.a.j = null;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public d(GroupChatRoomNavigationBar groupChatRoomNavigationBar, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRoomNavigationBar, alertDialog, onClickListener};
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

    /* loaded from: classes4.dex */
    public class e extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRoomNavigationBar b;

        public e(GroupChatRoomNavigationBar groupChatRoomNavigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRoomNavigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = groupChatRoomNavigationBar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, r5) != null) {
                return;
            }
            this.b.H();
            this.b.L();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                BdLog.d("error: " + i + " " + str);
                GroupChatFragment groupChatFragment = this.b.b;
                if (groupChatFragment != null && groupChatFragment.getActivity() != null) {
                    BdTopToast bdTopToast = new BdTopToast(this.b.b.getActivity());
                    bdTopToast.h(false);
                    bdTopToast.g(str);
                    bdTopToast.i((ViewGroup) this.b.b.getActivity().findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRoomNavigationBar a;

        public f(GroupChatRoomNavigationBar groupChatRoomNavigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRoomNavigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRoomNavigationBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b.Y1() && this.a.b.getActivity() != null) {
                this.a.b.getActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRoomNavigationBar a;

        public g(GroupChatRoomNavigationBar groupChatRoomNavigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRoomNavigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRoomNavigationBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.C();
            GroupChatRoomNavigationBar groupChatRoomNavigationBar = this.a;
            groupChatRoomNavigationBar.A(groupChatRoomNavigationBar.c);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRoomNavigationBar a;

        public h(GroupChatRoomNavigationBar groupChatRoomNavigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRoomNavigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRoomNavigationBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{z1a.a(z1a.a(TbConfig.URL_CHAT_ROOM, "roomId", String.valueOf(this.a.g)), "forumId", String.valueOf(this.a.h))});
                nx7.b("c15094", TbadkCoreApplication.getCurrentAccount(), this.a.h, this.a.g);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0917ae);
                iVar.b = navigationBar;
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
                iVar.e = addSystemImageButton;
                iVar.f = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
                View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d03ab, (ViewGroup) null);
                iVar.g = inflate;
                iVar.h = (RoundTbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e1c);
                iVar.i = (TextView) iVar.g.findViewById(R.id.obfuscated_res_0x7f090e2e);
                iVar.j = (ImageView) iVar.g.findViewById(R.id.obfuscated_res_0x7f090fb7);
                iVar.k = (TextView) iVar.g.findViewById(R.id.obfuscated_res_0x7f090e31);
                iVar.l = (ImageView) iVar.g.findViewById(R.id.obfuscated_res_0x7f090e21);
                iVar.b.setTitleView(iVar.g, null, NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER);
                View addCustomView = iVar.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d078c, (View.OnClickListener) null);
                iVar.c = addCustomView;
                iVar.d = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090e44);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(iVar.d, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return iVar;
            }
            return (i) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                jVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090881);
                jVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09086d);
                jVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090860);
                jVar.e = (ImageView) view2.findViewById(R.id.dialog_image);
                return jVar;
            }
            return (j) invokeL.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n15 d = n15.d(this.a);
                d.o(R.string.J_X07);
                d.f(R.color.CAM_X0201);
                n15 d2 = n15.d(this.b);
                d2.B(R.string.F_X02);
                d2.w(R.color.CAM_X0105);
                d2.A(R.dimen.T_X05);
                n15 d3 = n15.d(this.c);
                d3.B(R.string.F_X01);
                d3.w(R.color.CAM_X0108);
                d3.A(R.dimen.T_X07);
                SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0108);
                n15 d4 = n15.d(this.d);
                d4.m(R.dimen.L_X02);
                d4.l(R.color.CAM_X0302);
                d4.o(R.string.J_X07);
                d4.B(R.string.F_X01);
                d4.w(R.color.CAM_X0304);
                d4.A(R.dimen.T_X07);
                SkinManager.setImageResource(this.e, this.f);
            }
        }
    }

    public GroupChatRoomNavigationBar(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, GroupChatFragment groupChatFragment) {
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
        this.c = false;
        this.d = false;
        this.a = tbPageContext;
        this.b = groupChatFragment;
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f.g.setVisibility(i2);
            this.f.c.setVisibility(i2);
        }
    }

    public void G(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, context) != null) || context == null) {
            return;
        }
        F(context, R.string.im_group_chat_add_success_title, R.string.im_group_chat_add_success_desc, R.drawable.im_group_chat_subscribe_dialog, R.string.im_group_chat_add_success_btn, new a(this, context));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.f = i.a(this.b.requireView());
            q();
            o();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.e.onDestroy();
        }
    }

    public final void L() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean z = !this.c;
            this.c = z;
            this.d = !z;
            ImageView imageView = this.f.l;
            if (z) {
                i2 = R.drawable.pic_mask_chat_group_subscribe_select;
            } else {
                i2 = R.drawable.pic_mask_chat_group_subscribe;
            }
            SkinManager.setImageResource(imageView, i2);
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e = new FastRequest(this.a, CmdConfigHttp.CMD_HTTP_GROUP_MESSAGE, "c/c/chatroom/opSubscribeChatroom");
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return m35.m().i("key_group_chat_subscribe_click", false);
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final void A(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            StatisticItem statisticItem = new StatisticItem("c15088");
            if (z) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.h).param("room_id", this.g));
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ChatNameChangeNotifyData chatNameChangeNotifyData = (ChatNameChangeNotifyData) DataExt.toEntity(str, ChatNameChangeNotifyData.class);
            if (this.g == chatNameChangeNotifyData.getRoomId()) {
                this.f.i.setText(chatNameChangeNotifyData.getName());
            }
        } catch (JsonSyntaxException e2) {
            if (!TbadkCoreApplication.getInst().isDebugMode()) {
                e2.printStackTrace();
                return;
            }
            throw e2;
        }
    }

    public void B(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            ImageView imageView = this.f.l;
            if (this.c) {
                i3 = R.drawable.pic_mask_chat_group_subscribe_select;
            } else {
                i3 = R.drawable.pic_mask_chat_group_subscribe;
            }
            SkinManager.setImageResource(imageView, i3);
            SkinManager.setViewTextColor(this.f.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f.k, (int) R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.f.d, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            j jVar = this.i;
            if (jVar != null) {
                jVar.b();
            }
            TBAlertBuilder tBAlertBuilder = this.j;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.g();
            }
            this.f.h.setDrawBorder(true);
            this.f.h.setBorderWidth(hi.g(this.b.getContext(), R.dimen.L_X04));
            this.f.h.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
        }
    }

    public boolean J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (this.g <= 0 || this.c || i2 < TbSingleton.getInstance().getSendMsgNumToRemindSubscribe()) {
                return false;
            }
            m35 m = m35.m();
            String q = m35.q("SHOW_SUBSCRIBE_REMIND_DIALOG_" + this.g);
            long o = m.o(q, 0L);
            if (o > 0 && TimeHelper.isSameDay(o, System.currentTimeMillis())) {
                return false;
            }
            m.A(q, System.currentTimeMillis());
            F(this.b.requireContext(), R.string.im_group_chat_add_remind_title, R.string.im_group_chat_add_remind_desc, R.drawable.im_group_chat_subscribe_dialog, R.string.im_group_chat_add_success_btn, new b(this));
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void C() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FastRequest fastRequest = this.e;
            fastRequest.S("uid", TbadkCoreApplication.getCurrentAccount());
            fastRequest.S("chatroom_id", String.valueOf(this.g));
            if (this.c) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            fastRequest.S("op_type", Integer.valueOf(i2));
            fastRequest.U(new e(this));
            fastRequest.T();
        }
    }

    public void D(ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chatRoomDetail) == null) && chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null && this.b.getActivity() != null) {
            String avatar = chatRoomDetail.getBasicInfo().getAvatar();
            if (avatar != null) {
                this.f.h.M(avatar, 10, false);
            } else {
                this.f.h.setImageResource(R.drawable.chat_room_subscribe_icon);
            }
            this.f.i.setText(chatRoomDetail.getBasicInfo().getName());
            long discussNum = chatRoomDetail.getBasicInfo().getDiscussNum();
            String string = this.b.getActivity().getString(R.string.im_group_chat_online_num);
            int i2 = (discussNum > 0L ? 1 : (discussNum == 0L ? 0 : -1));
            if (i2 <= 0) {
                this.f.k.setText(R.string.im_group_chat_hot);
            } else if (i2 > 0 && discussNum <= 10000) {
                TextView textView = this.f.k;
                textView.setText(string + discussNum);
            } else if (discussNum >= 10000) {
                String numFormatOverWan = StringHelper.numFormatOverWan(discussNum);
                TextView textView2 = this.f.k;
                textView2.setText(string + numFormatOverWan);
            }
            if (chatRoomDetail.getUserInfo() != null && chatRoomDetail.getUserInfo().getIsSubscription() == 1) {
                L();
            }
            this.g = chatRoomDetail.getBasicInfo().getId();
            this.h = chatRoomDetail.getBasicInfo().getForumId();
        }
    }

    public final void F(@NonNull Context context, @StringRes int i2, @StringRes int i3, @DrawableRes int i4, @StringRes int i5, @Nullable DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), onClickListener}) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d023c, (ViewGroup) null);
            relativeLayout.addView(inflate);
            j a2 = j.a(inflate);
            this.i = a2;
            a2.b.setText(i2);
            this.i.c.setText(i3);
            this.i.d.setText(i5);
            j jVar = this.i;
            jVar.f = i4;
            jVar.b();
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder((Activity) context);
            tBAlertBuilder.v(false);
            tBAlertBuilder.k(relativeLayout);
            tBAlertBuilder.j(false);
            tBAlertBuilder.s(new c(this));
            this.j = tBAlertBuilder;
            this.i.d.setOnClickListener(new d(this, tBAlertBuilder.z(), onClickListener));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.c) {
                if (!u()) {
                    G(this.b.getActivity());
                    m35.m().w("key_group_chat_subscribe_click", true);
                } else {
                    l95.h(this.b.getActivity());
                }
            } else {
                l95.i(this.b.getActivity());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921770));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f.j.setImageDrawable(WebPManager.getPureDrawable(R.drawable.im_group_chat, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL_PRESS));
            n15 d2 = n15.d(this.f.i);
            d2.B(R.string.F_X02);
            d2.w(R.color.CAM_X0105);
            d2.A(R.dimen.T_X05);
            n15 d3 = n15.d(this.f.k);
            d3.w(R.string.F_X01);
            d3.w(R.color.CAM_X0109);
            d3.A(R.dimen.T_X09);
            this.f.f.setOnClickListener(new f(this));
            this.f.l.setOnClickListener(new g(this));
            this.f.d.setOnClickListener(new h(this));
            this.f.j.setEnabled(false);
        }
    }
}
