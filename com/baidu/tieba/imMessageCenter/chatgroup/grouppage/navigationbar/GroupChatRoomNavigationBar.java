package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.o45;
import com.baidu.tieba.rw4;
import com.baidu.tieba.ry4;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.yi;
import com.baidu.tieba.zg9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public f f;
    public long g;
    public long h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ Context b;

        public a(GroupChatRoomNavigationBar groupChatRoomNavigationBar, AlertDialog alertDialog, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRoomNavigationBar, alertDialog, context};
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
            this.b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
                o45.h((Activity) this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRoomNavigationBar b;

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
            this.b.z();
            this.b.A();
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
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b.getActivity() != null) {
                this.a.b.getActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRoomNavigationBar a;

        public d(GroupChatRoomNavigationBar groupChatRoomNavigationBar) {
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
            this.a.u();
            GroupChatRoomNavigationBar groupChatRoomNavigationBar = this.a;
            groupChatRoomNavigationBar.q(groupChatRoomNavigationBar.c);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRoomNavigationBar a;

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
            this.a = groupChatRoomNavigationBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{zg9.a(zg9.a(TbConfig.URL_CHAT_ROOM, "roomId", String.valueOf(this.a.g)), "forumId", String.valueOf(this.a.h))});
                TiebaStatic.log(new StatisticItem("c15094").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.h).param("room_id", this.a.g));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
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

        public f() {
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

        public static f a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                f fVar = new f();
                fVar.a = view2;
                NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0916c6);
                fVar.b = navigationBar;
                View addSystemImageButton = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
                fVar.e = addSystemImageButton;
                fVar.f = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
                View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d0391, (ViewGroup) null);
                fVar.g = inflate;
                fVar.h = (RoundTbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090d52);
                fVar.i = (TextView) fVar.g.findViewById(R.id.obfuscated_res_0x7f090d62);
                fVar.j = (ImageView) fVar.g.findViewById(R.id.obfuscated_res_0x7f090ee4);
                fVar.k = (TextView) fVar.g.findViewById(R.id.obfuscated_res_0x7f090d65);
                fVar.l = (ImageView) fVar.g.findViewById(R.id.obfuscated_res_0x7f090d54);
                fVar.b.setTitleView(fVar.g, null, NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER);
                View addCustomView = fVar.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d075d, (View.OnClickListener) null);
                fVar.c = addCustomView;
                fVar.d = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090d77);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(fVar.d, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                return fVar;
            }
            return (f) invokeL.objValue;
        }
    }

    public GroupChatRoomNavigationBar(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, groupChatFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f.g.setVisibility(i);
            this.f.c.setVisibility(i);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f = f.a(this.b.requireView());
            l();
            k();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.e.onDestroy();
        }
    }

    public final void A() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = !this.c;
            this.c = z;
            this.d = !z;
            ImageView imageView = this.f.l;
            if (z) {
                i = R.drawable.pic_mask_chat_group_subscribe_select;
            } else {
                i = R.drawable.pic_mask_chat_group_subscribe;
            }
            imageView.setImageResource(i);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e = new FastRequest(this.a, CmdConfigHttp.CMD_HTTP_GROUP_MESSAGE, "c/c/chatroom/opSubscribeChatroom");
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ry4.l().i("key_group_chat_subscribe_click", false);
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f.h.setDrawBorder(true);
            this.f.h.setBorderWidth(yi.g(this.b.getContext(), R.dimen.L_X04));
            this.f.h.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
            this.f.j.setImageDrawable(WebPManager.getPureDrawable(R.drawable.im_group_chat, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL_PRESS));
            rw4 d2 = rw4.d(this.f.i);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            rw4 d3 = rw4.d(this.f.k);
            d3.v(R.string.F_X01);
            d3.v(R.color.CAM_X0109);
            d3.z(R.dimen.T_X09);
            this.f.f.setOnClickListener(new c(this));
            this.f.l.setOnClickListener(new d(this));
            this.f.d.setOnClickListener(new e(this));
            this.f.j.setEnabled(false);
        }
    }

    public final void q(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            StatisticItem statisticItem = new StatisticItem("c15088");
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.h).param("room_id", this.g));
        }
    }

    public void t(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            ImageView imageView = this.f.l;
            if (this.c) {
                i2 = R.drawable.pic_mask_chat_group_subscribe_select;
            } else {
                i2 = R.drawable.pic_mask_chat_group_subscribe;
            }
            SkinManager.setImageResource(imageView, i2);
            SkinManager.setViewTextColor(this.f.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f.k, (int) R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.f.d, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f.f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void u() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FastRequest fastRequest = this.e;
            fastRequest.H("uid", TbadkCoreApplication.getCurrentAccount());
            fastRequest.H("chatroom_id", String.valueOf(this.g));
            if (this.c) {
                i = 2;
            } else {
                i = 1;
            }
            fastRequest.H("op_type", Integer.valueOf(i));
            fastRequest.J(new b(this));
            fastRequest.I();
        }
    }

    public void w(ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, chatRoomDetail) == null) && chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null && this.b.getActivity() != null) {
            String avatar = chatRoomDetail.getBasicInfo().getAvatar();
            if (avatar != null) {
                this.f.h.K(avatar, 10, false);
            } else {
                this.f.h.setImageResource(R.drawable.chat_room_subscribe_icon);
            }
            this.f.i.setText(chatRoomDetail.getBasicInfo().getName());
            long discussNum = chatRoomDetail.getBasicInfo().getDiscussNum();
            String string = this.b.getActivity().getString(R.string.im_group_chat_online_num);
            int i = (discussNum > 0L ? 1 : (discussNum == 0L ? 0 : -1));
            if (i <= 0) {
                this.f.k.setText(R.string.im_group_chat_hot);
            } else if (i > 0 && discussNum <= 10000) {
                TextView textView = this.f.k;
                textView.setText(string + discussNum);
            } else if (discussNum >= 10000) {
                String numFormatOverWan = StringHelper.numFormatOverWan(discussNum);
                TextView textView2 = this.f.k;
                textView2.setText(string + numFormatOverWan);
            }
            if (chatRoomDetail.getUserInfo() != null && chatRoomDetail.getUserInfo().getIsSubscription() == 1) {
                A();
            }
            this.g = chatRoomDetail.getBasicInfo().getId();
            this.h = chatRoomDetail.getBasicInfo().getForumId();
        }
    }

    public void y(@Nullable Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d022e, (ViewGroup) null);
            relativeLayout.addView(inflate);
            rw4 d2 = rw4.d((ConstraintLayout) inflate.findViewById(R.id.dialog_content));
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0201);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090806);
            textView.setText(R.string.im_group_chat_add_success_title);
            rw4 d3 = rw4.d(textView);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X05);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907f3);
            textView2.setText(R.string.im_group_chat_add_success_desc);
            rw4 d4 = rw4.d(textView2);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0108);
            d4.z(R.dimen.T_X07);
            TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907e6);
            textView3.setText(R.string.im_group_chat_add_success_btn);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0108);
            SkinManager.setImageResource((ImageView) inflate.findViewById(R.id.dialog_image), R.drawable.im_group_chat_subscribe_dialog);
            rw4 d5 = rw4.d(textView3);
            d5.l(R.dimen.L_X02);
            d5.k(R.color.CAM_X0302);
            d5.n(R.string.J_X07);
            d5.A(R.string.F_X01);
            d5.v(R.color.CAM_X0304);
            d5.z(R.dimen.T_X07);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder((Activity) context);
            tBAlertBuilder.u(false);
            tBAlertBuilder.k(relativeLayout);
            tBAlertBuilder.j(false);
            textView3.setOnClickListener(new a(this, tBAlertBuilder.y(), context));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!this.c) {
                if (!m()) {
                    y(this.b.getActivity());
                    ry4.l().v("key_group_chat_subscribe_click", true);
                } else {
                    o45.h(this.b.getActivity());
                }
            } else {
                o45.i(this.b.getActivity());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921770));
        }
    }
}
