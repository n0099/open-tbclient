package com.baidu.tieba.immessagecenter.chatgroup.chatbox.chatdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.tieba.bm8;
import com.baidu.tieba.fl8;
import com.baidu.tieba.immessagecenter.arch.utils.IMLog;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.ml8;
import com.baidu.tieba.nl8;
import com.baidu.tieba.ol8;
import com.baidu.tieba.pm8;
import com.baidu.tieba.pma;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.ul8;
import com.baidu.tieba.yl8;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class GroupChatDialogFragment extends BottomSheetDialogFragment implements pma {
    public static /* synthetic */ Interceptable $ic;
    public static BaManagerState x;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbPageContext b;
    public ml8 c;
    @Nullable
    public yl8 d;
    public BottomSheetDialog e;
    public fl8 f;
    public ol8 g;
    public long h;
    public String i;
    public long j;
    public boolean k;
    public BdUniqueId l;
    public ArrayList<Long> m;
    public boolean n;
    public bm8 o;
    public String p;
    public String q;
    public String r;
    public boolean s;
    public CustomMessageListener t;
    public final CustomMessageListener u;
    public final CustomMessageListener v;
    @NonNull
    public fl8.c w;

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
                this.a.v2();
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
                this.a.f.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements fl8.c {
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

        @Override // com.baidu.tieba.fl8.c
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
                        if (list.get(0) != null && (list.get(0) instanceof pm8)) {
                            pm8 pm8Var = (pm8) list.remove(0);
                            this.a.g.l(pm8Var);
                            if (!StringUtils.isNull(pm8Var.e())) {
                                this.a.g.h().f().setText(pm8Var.e());
                                if (this.a.u2(list)) {
                                    this.a.r2(list, pm8Var.e());
                                }
                            }
                            GroupChatDialogFragment groupChatDialogFragment = this.a;
                            if (pm8Var.b() != null && StringUtils.isNotNull(pm8Var.b())) {
                                z = true;
                            } else {
                                z = false;
                            }
                            groupChatDialogFragment.s = z;
                            GroupChatDialogFragment groupChatDialogFragment2 = this.a;
                            groupChatDialogFragment2.m2(groupChatDialogFragment2.s, pm8Var.b());
                            if (pm8Var.f() != null && pm8Var.f().equals("1")) {
                                this.a.k = true;
                            }
                            if (!StringUtils.isNull(pm8Var.c())) {
                                this.a.g.q(pm8Var.c());
                            }
                            this.a.g.n(pm8Var);
                        }
                        if (!this.a.s2(list)) {
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
                    BaManagerState unused = GroupChatDialogFragment.x = BaManagerState.NONE;
                    return;
                }
                BaManagerState unused2 = GroupChatDialogFragment.x = BaManagerState.NONE;
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
        x = BaManagerState.NONE;
    }

    @Override // com.baidu.tieba.pma
    @NonNull
    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ("frs".equals(this.p)) {
                return "chatroom_frsList_landing_page";
            }
            return "msg_center_channel_tab_landing_page";
        }
        return (String) invokeV.objValue;
    }

    public void U1() {
        fl8 fl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (fl8Var = this.f) != null && x != BaManagerState.REQUESTING) {
            fl8Var.E(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.h), this.p);
            x = BaManagerState.REQUESTING;
        }
    }

    @Override // com.baidu.tieba.pma
    @NonNull
    public String V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if ("frs".equals(this.p)) {
                return "chatroom_frsList";
            }
            return "msg_tab";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pma
    @NonNull
    public String getTraceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return Integer.toString(this.l.getId());
        }
        return (String) invokeV.objValue;
    }

    public String o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            fl8 fl8Var = this.f;
            if (fl8Var != null) {
                fl8Var.h();
            }
        }
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            z2();
            nl8.a(this.h, this.i, this.r, this.q, String.valueOf(this.j));
        }
    }

    public void z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.p.equals("frs")) {
                this.q = nl8.d;
            } else if (this.p.equals("message_tab")) {
                this.q = nl8.e;
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
        this.t = new a(this, 2001304);
        this.u = new b(this, 2001266);
        this.v = new c(this, 2921778);
        this.w = new f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            IMLog.getInstance().i("GroupChatDialogFragment", MissionEvent.MESSAGE_DESTROY);
            fl8 fl8Var = this.f;
            if (fl8Var != null) {
                fl8Var.o();
            }
            x = BaManagerState.NONE;
            this.n = false;
            if (this.p.equals("frs")) {
                this.g.g().r();
            }
            dismissAllowingStateLoss();
            MessageManager.getInstance().unRegisterListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.v);
            MessageManager.getInstance().unRegisterListener(this.t);
        }
    }

    public GroupChatDialogFragment(long j, String str, long j2, List<Long> list, boolean z, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, Long.valueOf(j2), list, Boolean.valueOf(z), str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = 0L;
        this.l = BdUniqueId.gen();
        this.m = new ArrayList<>();
        this.n = false;
        this.t = new a(this, 2001304);
        this.u = new b(this, 2001266);
        this.v = new c(this, 2921778);
        this.w = new f(this);
        this.h = j;
        this.i = str;
        this.j = j2;
        this.r = str2;
        this.p = str3;
        if (list != null) {
            this.m.addAll(list);
        }
        this.k = z;
    }

    public void n2(int i) {
        yl8 yl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || (yl8Var = this.d) == null) {
            return;
        }
        if (i == 0) {
            SkinManager.setBackgroundResource(yl8Var.x(), R.drawable.obfuscated_res_0x7f080fe9);
        } else {
            SkinManager.setBackgroundResource(yl8Var.x(), R.drawable.obfuscated_res_0x7f080fea);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            ol8 ol8Var = this.g;
            if (ol8Var != null) {
                ol8Var.i().l();
                this.g.p();
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bundle)) == null) {
            d dVar = new d(this, getContext(), R.style.obfuscated_res_0x7f1000fe);
            this.e = dVar;
            return dVar;
        }
        return (Dialog) invokeL.objValue;
    }

    public boolean s2(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof ChatGroupInfo) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean u2(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, list)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if ((list.get(i2) instanceof ChatGroupInfo) && (i = i + 1) > 1) {
                    return false;
                }
            }
            if (i != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void y2(bm8 bm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bm8Var) == null) {
            this.o = bm8Var;
        }
    }

    public final void m2(boolean z, String str) {
        yl8 yl8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048580, this, z, str) != null) || (yl8Var = this.d) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) yl8Var.u().getLayoutParams();
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
            n2(TbadkCoreApplication.getInst().getSkinType());
            layoutParams.removeRule(12);
            layoutParams.addRule(15);
            layoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X009);
            layoutParams3.topMargin = UtilHelper.getDimenPixelSize(R.dimen.utbds10);
        }
        this.d.p().setLayoutParams(layoutParams3);
        this.d.u().setLayoutParams(layoutParams);
        this.d.w().setLayoutParams(layoutParams2);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onActivityCreated(bundle);
            IMLog.getInstance().i("GroupChatDialogFragment", "onActivityCreated start");
            this.a = getContext();
            FragmentActivity activity = getActivity();
            if (activity instanceof BaseFragmentActivity) {
                this.b = ((BaseFragmentActivity) activity).getPageContext();
            } else if (activity instanceof BaseActivity) {
                this.b = ((BaseActivity) activity).getPageContext();
            }
            MessageManager.getInstance().registerListener(this.u);
            MessageManager.getInstance().registerListener(this.v);
            MessageManager.getInstance().registerListener(this.t);
            if (this.p.equals("frs")) {
                q2(this.c);
            } else if (this.p.equals("message_tab")) {
                q2(this.d);
            }
            v2();
            w2();
            IMLog.getInstance().i("GroupChatDialogFragment", "onActivityCreated end");
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003023, "show_ok"));
            SafeHandler.getInst().post(new e(this));
            ol8 ol8Var = this.g;
            if (ol8Var != null) {
                if (ol8Var.i() != null) {
                    this.g.i().o();
                }
                if (this.g.j() != null) {
                    this.g.j().getRecycledViewPool().clear();
                    this.g.j().removeAllViews();
                }
            }
            if (this.p.equals("frs")) {
                this.o.a(true);
                ol8 ol8Var2 = this.g;
                if (ol8Var2 != null && ol8Var2.g() != null) {
                    this.g.g().m();
                }
            }
        }
    }

    public void q2(ul8 ul8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ul8Var) == null) {
            this.f = new fl8(this.a, this.w);
            ol8 ol8Var = new ol8(this, this.b, this.f, ul8Var, this.i, this.h, this.k, this.j, this.p);
            this.g = ol8Var;
            ol8Var.t();
            this.g.r();
            this.g.m();
            this.g.p();
            this.g.h().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.p.equals("frs")) {
                this.g.s(t2());
            }
            this.g.k();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            IMLog.getInstance().i("GroupChatDialogFragment", "onCreate");
            if (bundle != null) {
                if (this.h == 0) {
                    this.h = bundle.getLong("key_group_chat_forum_id");
                }
                if (TextUtils.isEmpty(this.i)) {
                    this.i = bundle.getString("key_group_chat_forum_name");
                }
                if (this.j == 0) {
                    this.j = bundle.getLong("key_group_chat_room_id");
                }
                if (TextUtils.isEmpty(this.r)) {
                    this.r = bundle.getString("key_group_chat_resource_from");
                }
                if (TextUtils.isEmpty(this.p)) {
                    this.p = bundle.getString("key_group_chat_souce");
                }
                if (!this.k) {
                    this.k = bundle.getBoolean("key_group_chat_followed");
                }
                if (this.m.isEmpty()) {
                    this.m = (ArrayList) bundle.getSerializable("key_group_chat_hot_list");
                }
            }
            if ("message_tab".equals(this.p)) {
                setShowsDialog(false);
            } else {
                setShowsDialog(true);
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.getString("FROM");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            TbLog iMLog = IMLog.getInstance();
            iMLog.i("GroupChatDialogFragment", "onCreateView start, source = " + this.p);
            View view2 = null;
            if (this.p.equals("frs")) {
                setShowsDialog(true);
                view2 = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d03e2, (ViewGroup) null);
            } else if ("message_tab".equals(this.p)) {
                BottomSheetDialog bottomSheetDialog = this.e;
                if (bottomSheetDialog != null && bottomSheetDialog.getWindow() != null) {
                    this.e.getWindow().setDimAmount(0.0f);
                }
                setShowsDialog(false);
                view2 = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0649, (ViewGroup) null);
            }
            TbLog iMLog2 = IMLog.getInstance();
            iMLog2.i("GroupChatDialogFragment", "onCreateView end, source = " + this.p);
            return view2;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            IMLog.getInstance().i("GroupChatDialogFragment", "onResume start");
            fl8 fl8Var = this.f;
            if (fl8Var != null) {
                fl8Var.p();
            }
            if ("message_tab".equals(this.p) || this.n) {
                U1();
            }
            v2();
            IMLog.getInstance().i("GroupChatDialogFragment", "onResume end");
        }
    }

    public int t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
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

    public void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.g.h().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.g.f().h(TbadkCoreApplication.getInst().getSkinType());
            if (!this.s) {
                n2(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void w2() {
        ol8 ol8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || (ol8Var = this.g) == null) {
            return;
        }
        if (this.f != null) {
            ol8Var.f().i();
            this.g.f().g();
            U1();
        } else {
            ol8Var.f().k();
        }
        p2();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("key_group_chat_forum_id", this.h);
            bundle.putString("key_group_chat_forum_name", this.i);
            bundle.putLong("key_group_chat_room_id", this.j);
            bundle.putString("key_group_chat_resource_from", this.r);
            bundle.putString("key_group_chat_souce", this.p);
            bundle.putBoolean("key_group_chat_followed", this.k);
            if (!ListUtils.isEmpty(this.m)) {
                bundle.putSerializable("key_group_chat_hot_list", this.m);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            TbLog iMLog = IMLog.getInstance();
            iMLog.i("GroupChatDialogFragment", "onViewCreated start, source = " + this.p);
            if (this.p.equals("frs")) {
                this.c = ml8.v(view2);
            } else if (this.p.equals("message_tab")) {
                this.d = yl8.v(view2);
            }
            TbLog iMLog2 = IMLog.getInstance();
            iMLog2.i("GroupChatDialogFragment", "onViewCreated end, source = " + this.p);
        }
    }

    public void r2(List list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, list, str) == null) && list.get(0) != null && (list.get(0) instanceof ChatGroupInfo)) {
            ChatGroupInfo chatGroupInfo = (ChatGroupInfo) list.get(0);
            if (chatGroupInfo.getRoomInfoList() != null && chatGroupInfo.getRoomInfoList().get(0) != null) {
                chatGroupInfo.getRoomInfoList().get(0).setSingleListHotText(str);
            }
        }
    }

    public void x2(long j, String str, long j2, List<Long> list, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), str, Long.valueOf(j2), list, Boolean.valueOf(z), str2}) == null) {
            this.j = j2;
            this.h = j;
            this.i = str;
            this.k = z;
            this.r = str2;
            if (!ListUtils.isEmpty(list)) {
                this.m.clear();
                this.m.addAll(list);
            }
            p2();
        }
    }
}
