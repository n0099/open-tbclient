package com.baidu.tieba.immessagecenter.chatgroup.chatbox.chatdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.bz8;
import com.baidu.tieba.ez8;
import com.baidu.tieba.fy8;
import com.baidu.tieba.immessagecenter.arch.utils.IMLog;
import com.baidu.tieba.ky8;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.py8;
import com.baidu.tieba.qy8;
import com.baidu.tieba.qza;
import com.baidu.tieba.ry8;
import com.baidu.tieba.sz8;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.xy8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class GroupChatDialogFragment extends BottomSheetDialogFragment implements qza {
    public static /* synthetic */ Interceptable $ic;
    public static BaManagerState w;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbPageContext b;
    public py8 c;
    @Nullable
    public bz8 d;
    public BottomSheetDialog e;
    public fy8 f;
    public ry8 g;
    public long h;
    public String i;
    public long j;
    public boolean k;
    public BdUniqueId l;
    public ArrayList<Long> m;
    public boolean n;
    public ez8 o;
    public String p;
    public boolean q;
    public boolean r;
    public CustomMessageListener s;
    public final CustomMessageListener t;
    public final CustomMessageListener u;
    @NonNull
    public fy8.c v;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class BaManagerState {
        public static final /* synthetic */ BaManagerState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BaManagerState NONE;
        public static final BaManagerState REQUESTING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1892256669, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/chatdialog/GroupChatDialogFragment$BaManagerState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1892256669, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/chatdialog/GroupChatDialogFragment$BaManagerState;");
                    return;
                }
            }
            REQUESTING = new BaManagerState("REQUESTING", 0);
            BaManagerState baManagerState = new BaManagerState(HlsPlaylistParser.METHOD_NONE, 1);
            NONE = baManagerState;
            $VALUES = new BaManagerState[]{REQUESTING, baManagerState};
        }

        public BaManagerState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BaManagerState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (BaManagerState) Enum.valueOf(BaManagerState.class, str);
            }
            return (BaManagerState) invokeL.objValue;
        }

        public static BaManagerState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (BaManagerState[]) $VALUES.clone();
            }
            return (BaManagerState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatDialogFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GroupChatDialogFragment groupChatDialogFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatDialogFragment, Integer.valueOf(i)};
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
            this.a = groupChatDialogFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.K2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatDialogFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GroupChatDialogFragment groupChatDialogFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatDialogFragment, Integer.valueOf(i)};
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
            this.a = groupChatDialogFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001266 && (customResponsedMessage.getData() instanceof LikeReturnData)) {
                GroupChatDialogFragment groupChatDialogFragment = this.a;
                boolean z = true;
                if (((LikeReturnData) customResponsedMessage.getData()).isLike() != 1) {
                    z = false;
                }
                groupChatDialogFragment.k = z;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatDialogFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GroupChatDialogFragment groupChatDialogFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatDialogFragment, Integer.valueOf(i)};
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
            this.a = groupChatDialogFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.n = true;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends BottomSheetDialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatDialogFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GroupChatDialogFragment groupChatDialogFragment, Context context, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatDialogFragment, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatDialogFragment;
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onAttachedToWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onAttachedToWindow();
            }
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onDetachedFromWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onDetachedFromWindow();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatDialogFragment a;

        public e(GroupChatDialogFragment groupChatDialogFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatDialogFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatDialogFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.r();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements fy8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatDialogFragment a;

        public f(GroupChatDialogFragment groupChatDialogFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatDialogFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatDialogFragment;
        }

        @Override // com.baidu.tieba.fy8.c
        public void a(List list, int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i == 0) {
                    this.a.g.u();
                    if (list != null && !ListUtils.isEmpty(list)) {
                        this.a.g.f().g();
                        if (this.a.g.h().n() != null) {
                            this.a.g.h().n().setVisibility(0);
                        }
                        if (list.get(0) != null && (list.get(0) instanceof sz8)) {
                            sz8 sz8Var = (sz8) list.remove(0);
                            this.a.g.l(sz8Var);
                            if (!StringUtils.isNull(sz8Var.e())) {
                                this.a.g.h().f().setText(sz8Var.e());
                                if (ky8.a.c(list)) {
                                    ky8.a.a(list, sz8Var.e());
                                }
                            }
                            GroupChatDialogFragment groupChatDialogFragment = this.a;
                            if (sz8Var.b() != null && StringUtils.isNotNull(sz8Var.b())) {
                                z = true;
                            } else {
                                z = false;
                            }
                            groupChatDialogFragment.r = z;
                            GroupChatDialogFragment groupChatDialogFragment2 = this.a;
                            groupChatDialogFragment2.E2(groupChatDialogFragment2.r, sz8Var.b());
                            if (sz8Var.f() != null && sz8Var.f().equals("1")) {
                                this.a.k = true;
                            }
                            if (!StringUtils.isNull(sz8Var.c())) {
                                this.a.g.q(sz8Var.c());
                            }
                            this.a.g.n(sz8Var);
                        }
                        if (!ky8.a.b(list)) {
                            this.a.g.f().k();
                        } else if (this.a.g.i() != null) {
                            if (!this.a.n) {
                                this.a.g.i().j(list, this.a.k, this.a.p);
                            } else {
                                this.a.n = false;
                                this.a.g.i().k(list, this.a.k, this.a.p);
                            }
                            if (this.a.p.equals("frs")) {
                                this.a.g.g().s();
                            }
                        }
                    } else {
                        this.a.g.f().k();
                    }
                    BaManagerState unused = GroupChatDialogFragment.w = BaManagerState.NONE;
                    return;
                }
                BaManagerState unused2 = GroupChatDialogFragment.w = BaManagerState.NONE;
                this.a.g.o();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-923953966, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/chatdialog/GroupChatDialogFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-923953966, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/chatdialog/GroupChatDialogFragment;");
                return;
            }
        }
        w = BaManagerState.NONE;
    }

    public String G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qy8.d(this.h, this.i, this.p, String.valueOf(this.j));
        }
    }

    @Override // com.baidu.tieba.qza
    @NonNull
    public String Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if ("frs".equals(this.p)) {
                return "chatroom_frsList_landing_page";
            }
            return "msg_center_channel_tab_landing_page";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qza
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return Integer.toString(this.l.getId());
        }
        return (String) invokeV.objValue;
    }

    public void m2() {
        fy8 fy8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (fy8Var = this.f) != null && w != BaManagerState.REQUESTING) {
            fy8Var.F(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.h), this.p);
            w = BaManagerState.REQUESTING;
        }
    }

    @Override // com.baidu.tieba.qza
    @NonNull
    public String n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if ("frs".equals(this.p)) {
                return "chatroom_frsList";
            }
            return "msg_tab";
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            fy8 fy8Var = this.f;
            if (fy8Var != null) {
                fy8Var.h();
            }
        }
    }

    public GroupChatDialogFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = 0L;
        this.l = BdUniqueId.gen();
        this.m = new ArrayList<>();
        this.n = false;
        this.q = false;
        this.s = new a(this, 2001304);
        this.t = new b(this, 2001266);
        this.u = new c(this, 2921778);
        this.v = new f(this);
    }

    public final void initData() {
        Bundle arguments;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (arguments = getArguments()) == null) {
            return;
        }
        this.h = arguments.getLong("key_group_chat_forum_id", 0L);
        this.i = arguments.getString("key_group_chat_forum_name", "");
        this.j = arguments.getLong("key_group_chat_room_id", 0L);
        this.p = arguments.getString("key_group_chat_souce", "frs");
        this.k = arguments.getBoolean("key_group_chat_followed", false);
        this.q = arguments.getBoolean("key_is_dialog", false);
        Serializable serializable = arguments.getSerializable("key_group_chat_hot_list");
        if (serializable != null && (serializable instanceof ArrayList)) {
            this.m = (ArrayList) serializable;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            IMLog.getInstance().i("GroupChatDialogFragment", MissionEvent.MESSAGE_DESTROY);
            fy8 fy8Var = this.f;
            if (fy8Var != null) {
                fy8Var.p();
            }
            w = BaManagerState.NONE;
            this.n = false;
            if (this.p.equals("frs")) {
                this.g.g().r();
            }
            dismissAllowingStateLoss();
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
            if (this.q) {
                MessageManager.getInstance().unRegisterListener(this.s);
            }
        }
    }

    public void F2(int i) {
        bz8 bz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (bz8Var = this.d) == null) {
            return;
        }
        if (i == 0) {
            SkinManager.setBackgroundResource(bz8Var.x(), R.drawable.obfuscated_res_0x7f080fff);
        } else {
            SkinManager.setBackgroundResource(bz8Var.x(), R.drawable.obfuscated_res_0x7f081000);
        }
    }

    public void N2(ez8 ez8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ez8Var) == null) {
            this.o = ez8Var;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            ry8 ry8Var = this.g;
            if (ry8Var != null) {
                ry8Var.i().l();
                this.g.p();
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bundle)) == null) {
            d dVar = new d(this, getContext(), R.style.obfuscated_res_0x7f1000fe);
            this.e = dVar;
            return dVar;
        }
        return (Dialog) invokeL.objValue;
    }

    public final void E2(boolean z, String str) {
        bz8 bz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048576, this, z, str) != null) || (bz8Var = this.d) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bz8Var.u().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.w().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.p().getLayoutParams();
        if (z) {
            this.d.f.setVisibility(0);
            this.d.x().l(str);
            layoutParams.removeRule(15);
            layoutParams.addRule(12);
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X015);
            layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
        } else {
            this.d.f.setVisibility(8);
            F2(TbadkCoreApplication.getInst().getSkinType());
            layoutParams.removeRule(12);
            layoutParams.addRule(15);
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X009);
            layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.utbds10);
        }
        this.d.p().setLayoutParams(layoutParams3);
        this.d.u().setLayoutParams(layoutParams);
        this.d.w().setLayoutParams(layoutParams2);
    }

    public void I2(xy8 xy8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xy8Var) == null) {
            this.f = new fy8(this.a, this.v);
            ry8 ry8Var = new ry8(this, this.b, this.f, xy8Var, this.i, this.h, this.k, this.j, this.p);
            this.g = ry8Var;
            ry8Var.t();
            this.g.r();
            this.g.m();
            this.g.p();
            this.g.h().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.q) {
                this.g.s(J2());
            }
            this.g.k();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onActivityCreated(bundle);
            IMLog.getInstance().i("GroupChatDialogFragment", "onActivityCreated start");
            this.a = getContext();
            FragmentActivity activity = getActivity();
            if (activity instanceof BaseFragmentActivity) {
                this.b = ((BaseFragmentActivity) activity).getPageContext();
            } else if (activity instanceof BaseActivity) {
                this.b = ((BaseActivity) activity).getPageContext();
            }
            MessageManager.getInstance().registerListener(this.t);
            MessageManager.getInstance().registerListener(this.u);
            if (this.q) {
                MessageManager.getInstance().registerListener(this.s);
            }
            if (this.p.equals("frs")) {
                I2(this.c);
            } else if (this.p.equals("message_tab")) {
                I2(this.d);
            }
            K2();
            L2();
            IMLog.getInstance().i("GroupChatDialogFragment", "onActivityCreated end");
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003023, "show_ok"));
            SafeHandler.getInst().post(new e(this));
            ry8 ry8Var = this.g;
            if (ry8Var != null) {
                if (ry8Var.i() != null) {
                    this.g.i().o();
                }
                if (this.g.j() != null) {
                    this.g.j().getRecycledViewPool().clear();
                    this.g.j().removeAllViews();
                }
            }
            if (this.p.equals("frs")) {
                this.o.a(true);
                ry8 ry8Var2 = this.g;
                if (ry8Var2 != null && ry8Var2.g() != null) {
                    this.g.g().m();
                }
            }
        }
    }

    public int J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int height = ((WindowManager) this.a.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getHeight();
            int i = (height * 9) / 10;
            if (UtilHelper.isFoldScreen()) {
                i = (height * 10) / 8;
            }
            this.e.getBehavior().setPeekHeight(i);
            return i;
        }
        return invokeV.intValue;
    }

    public void K2() {
        ry8 ry8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (ry8Var = this.g) == null) {
            return;
        }
        ry8Var.h().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.g.f().h(TbadkCoreApplication.getInst().getSkinType());
        if (!this.r) {
            F2(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void L2() {
        ry8 ry8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (ry8Var = this.g) == null) {
            return;
        }
        if (this.f != null) {
            ry8Var.f().i();
            this.g.f().g();
            m2();
        } else {
            ry8Var.f().k();
        }
        H2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            IMLog.getInstance().i("GroupChatDialogFragment", "onResume start");
            fy8 fy8Var = this.f;
            if (fy8Var != null) {
                fy8Var.q();
            }
            if ("message_tab".equals(this.p) || this.n) {
                m2();
            }
            K2();
            IMLog.getInstance().i("GroupChatDialogFragment", "onResume end");
        }
    }

    public void M2(long j, String str, long j2, List<Long> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), str, Long.valueOf(j2), list, Boolean.valueOf(z)}) == null) {
            this.j = j2;
            this.h = j;
            this.i = str;
            this.k = z;
            if (!ListUtils.isEmpty(list)) {
                this.m.clear();
                this.m.addAll(list);
            }
            H2();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            IMLog.getInstance().i("GroupChatDialogFragment", "onCreate");
            initData();
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("FROM");
            }
            if (this.q) {
                setShowsDialog(true);
            } else {
                setShowsDialog(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            TbLog iMLog = IMLog.getInstance();
            iMLog.i("GroupChatDialogFragment", "onCreateView start, source = " + this.p);
            View view2 = null;
            if (this.p.equals("frs")) {
                view2 = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03f5, (ViewGroup) null);
            } else if ("message_tab".equals(this.p)) {
                BottomSheetDialog bottomSheetDialog = this.e;
                if (bottomSheetDialog != null && bottomSheetDialog.getWindow() != null) {
                    this.e.getWindow().setDimAmount(0.0f);
                }
                view2 = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d065e, (ViewGroup) null);
            }
            TbLog iMLog2 = IMLog.getInstance();
            iMLog2.i("GroupChatDialogFragment", "onCreateView end, source = " + this.p);
            return view2;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            TbLog iMLog = IMLog.getInstance();
            iMLog.i("GroupChatDialogFragment", "onViewCreated start, source = " + this.p);
            if (this.p.equals("frs")) {
                this.c = py8.v(view2);
            } else if (this.p.equals("message_tab")) {
                this.d = bz8.v(view2);
            }
            TbLog iMLog2 = IMLog.getInstance();
            iMLog2.i("GroupChatDialogFragment", "onViewCreated end, source = " + this.p);
        }
    }
}
