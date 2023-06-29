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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ae8;
import com.baidu.tieba.bf8;
import com.baidu.tieba.ew8;
import com.baidu.tieba.immessagecenter.arch.utils.IMLog;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.tieba.me8;
import com.baidu.tieba.mf8;
import com.baidu.tieba.n3a;
import com.baidu.tieba.ne8;
import com.baidu.tieba.oe8;
import com.baidu.tieba.ue8;
import com.baidu.tieba.ye8;
import com.baidu.tieba.yg;
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
public class GroupChatDialogFragment extends BottomSheetDialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public static BaManagerState v;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbPageContext b;
    public me8 c;
    public ye8 d;
    public BottomSheetDialog e;
    public ae8 f;
    public oe8 g;
    public long h;
    public String i;
    public long j;
    public boolean k;
    public ArrayList<Long> l;
    public boolean m;
    public bf8 n;
    public String o;
    public String p;
    public String q;
    public CustomMessageListener r;
    public final CustomMessageListener s;
    public final CustomMessageListener t;
    @NonNull
    public ae8.c u;

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
                this.a.S1();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001266 && (customResponsedMessage.getData() instanceof n3a)) {
                GroupChatDialogFragment groupChatDialogFragment = this.a;
                boolean z = true;
                if (((n3a) customResponsedMessage.getData()).n() != 1) {
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
            this.a.m = true;
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
    public class f implements ae8.c {
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

        @Override // com.baidu.tieba.ae8.c
        public void a(List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i == 0) {
                    this.a.g.t();
                    if (list != null && !ListUtils.isEmpty(list)) {
                        this.a.g.e().g();
                        if (this.a.g.g().n() != null) {
                            this.a.g.g().n().setVisibility(0);
                        }
                        if (list.get(0) != null && (list.get(0) instanceof mf8)) {
                            mf8 mf8Var = (mf8) list.remove(0);
                            this.a.g.k(mf8Var);
                            if (mf8Var.d() != null) {
                                this.a.g.g().f().setText(mf8Var.d());
                            }
                            if (mf8Var.e() != null && mf8Var.e().equals("1")) {
                                this.a.k = true;
                            }
                            if (!StringUtils.isNull(mf8Var.b())) {
                                this.a.g.p(mf8Var.b());
                            }
                            this.a.g.m(mf8Var);
                        }
                        if (!this.a.Q1(list)) {
                            this.a.g.e().k();
                        } else if (this.a.g.h() != null) {
                            if (!this.a.m) {
                                this.a.g.h().j(list, this.a.k, this.a.o);
                            } else {
                                this.a.m = false;
                                this.a.g.h().k(list, this.a.k, this.a.o);
                            }
                            if (this.a.o.equals("dialog")) {
                                this.a.g.f().s();
                            }
                        }
                    } else {
                        this.a.g.e().k();
                    }
                    BaManagerState unused = GroupChatDialogFragment.v = BaManagerState.NONE;
                    return;
                }
                BaManagerState unused2 = GroupChatDialogFragment.v = BaManagerState.NONE;
                this.a.g.n();
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
        v = BaManagerState.NONE;
    }

    public void B1() {
        ae8 ae8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ae8Var = this.f) != null && v != BaManagerState.REQUESTING) {
            ae8Var.E(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.h));
            v = BaManagerState.REQUESTING;
        }
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            W1();
            ne8.a(this.h, this.i, this.q, this.p);
        }
    }

    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g.g().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.g.e().h(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.o.equals("dialog")) {
                this.p = ne8.d;
            } else if (this.o.equals("msgTabFragment")) {
                this.p = ne8.e;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            ae8 ae8Var = this.f;
            if (ae8Var != null) {
                ae8Var.h();
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
        this.l = new ArrayList<>();
        this.m = false;
        this.r = new a(this, 2001304);
        this.s = new b(this, 2001266);
        this.t = new c(this, 2921778);
        this.u = new f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            IMLog.getInstance().c("GroupChatDialogFragment", MissionEvent.MESSAGE_DESTROY);
            ae8 ae8Var = this.f;
            if (ae8Var != null) {
                ae8Var.o();
            }
            v = BaManagerState.NONE;
            this.m = false;
            if (this.o.equals("dialog")) {
                this.g.f().r();
            }
            dismissAllowingStateLoss();
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.r);
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
        this.l = new ArrayList<>();
        this.m = false;
        this.r = new a(this, 2001304);
        this.s = new b(this, 2001266);
        this.t = new c(this, 2921778);
        this.u = new f(this);
        this.h = j;
        this.i = str;
        this.j = j2;
        this.q = str2;
        this.o = str3;
        if (list != null) {
            this.l.addAll(list);
        }
        this.k = z;
    }

    public boolean Q1(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof ChatGroupInfo) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void V1(bf8 bf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bf8Var) == null) {
            this.n = bf8Var;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.g.h().l();
            this.g.o();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bundle)) == null) {
            d dVar = new d(this, getContext(), R.style.obfuscated_res_0x7f1000fe);
            this.e = dVar;
            return dVar;
        }
        return (Dialog) invokeL.objValue;
    }

    public void P1(ue8 ue8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ue8Var) == null) {
            this.f = new ae8(this.a, this.u);
            oe8 oe8Var = new oe8(this, this.b, this.f, ue8Var, this.i, this.h, this.k, this.j, this.o);
            this.g = oe8Var;
            oe8Var.s();
            this.g.q();
            this.g.l();
            this.g.o();
            this.g.g().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (this.o.equals("dialog")) {
                this.g.r(R1());
            }
            this.g.j();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onActivityCreated(bundle);
            IMLog.getInstance().c("GroupChatDialogFragment", "onActivityCreated start");
            this.a = getContext();
            FragmentActivity activity = getActivity();
            if (activity instanceof BaseFragmentActivity) {
                this.b = ((BaseFragmentActivity) activity).getPageContext();
            } else if (activity instanceof BaseActivity) {
                this.b = ((BaseActivity) activity).getPageContext();
            }
            MessageManager.getInstance().registerListener(this.s);
            MessageManager.getInstance().registerListener(this.t);
            MessageManager.getInstance().registerListener(this.r);
            if (this.o.equals("dialog")) {
                P1(this.c);
            } else if (this.o.equals("msgTabFragment")) {
                P1(this.d);
            }
            S1();
            T1();
            IMLog.getInstance().c("GroupChatDialogFragment", "onActivityCreated end");
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dialogInterface) == null) {
            super.onDismiss(dialogInterface);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003023, "show_ok"));
            yg.a().post(new e(this));
            if (this.g.h() != null) {
                this.g.h().o();
            }
            if (this.g.i() != null) {
                this.g.i().getRecycledViewPool().clear();
                this.g.i().removeAllViews();
            }
            if (this.o.equals("dialog")) {
                this.n.a(true);
                this.g.f().m();
            }
        }
    }

    public int R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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

    public final void T1() {
        oe8 oe8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (oe8Var = this.g) == null) {
            return;
        }
        if (this.f != null) {
            oe8Var.e().i();
            this.g.e().g();
            B1();
        } else {
            oe8Var.e().k();
        }
        O1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            IMLog.getInstance().c("GroupChatDialogFragment", "onResume start");
            ae8 ae8Var = this.f;
            if (ae8Var != null) {
                ae8Var.p();
            }
            B1();
            S1();
            IMLog.getInstance().c("GroupChatDialogFragment", "onResume end");
        }
    }

    public void U1(long j, String str, long j2, List<Long> list, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), str, Long.valueOf(j2), list, Boolean.valueOf(z), str2}) == null) {
            this.j = j2;
            this.h = j;
            this.i = str;
            this.k = z;
            this.q = str2;
            if (!ListUtils.isEmpty(list)) {
                this.l.clear();
                this.l.addAll(list);
            }
            O1();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            IMLog.getInstance().c("GroupChatDialogFragment", "onCreate");
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
                if (TextUtils.isEmpty(this.q)) {
                    this.q = bundle.getString("key_group_chat_resource_from");
                }
                if (TextUtils.isEmpty(this.o)) {
                    this.o = bundle.getString("key_group_chat_souce");
                }
                if (!this.k) {
                    this.k = bundle.getBoolean("key_group_chat_followed");
                }
                if (this.l.isEmpty()) {
                    this.l = (ArrayList) bundle.getSerializable("key_group_chat_hot_list");
                }
            }
            if ("msgTabFragment".equals(this.o)) {
                setShowsDialog(false);
            } else {
                setShowsDialog(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            ew8 iMLog = IMLog.getInstance();
            iMLog.c("GroupChatDialogFragment", "onCreateView start, source = " + this.o);
            View view2 = null;
            if (this.o.equals("dialog")) {
                setShowsDialog(true);
                view2 = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d03cd, (ViewGroup) null);
            } else if ("msgTabFragment".equals(this.o)) {
                BottomSheetDialog bottomSheetDialog = this.e;
                if (bottomSheetDialog != null && bottomSheetDialog.getWindow() != null) {
                    this.e.getWindow().setDimAmount(0.0f);
                }
                setShowsDialog(false);
                view2 = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d062f, (ViewGroup) null);
            }
            ew8 iMLog2 = IMLog.getInstance();
            iMLog2.c("GroupChatDialogFragment", "onCreateView end, source = " + this.o);
            return view2;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putLong("key_group_chat_forum_id", this.h);
            bundle.putString("key_group_chat_forum_name", this.i);
            bundle.putLong("key_group_chat_room_id", this.j);
            bundle.putString("key_group_chat_resource_from", this.q);
            bundle.putString("key_group_chat_souce", this.o);
            bundle.putBoolean("key_group_chat_followed", this.k);
            if (!ListUtils.isEmpty(this.l)) {
                bundle.putSerializable("key_group_chat_hot_list", this.l);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            ew8 iMLog = IMLog.getInstance();
            iMLog.c("GroupChatDialogFragment", "onViewCreated start, source = " + this.o);
            if (this.o.equals("dialog")) {
                this.c = me8.v(view2);
            } else if (this.o.equals("msgTabFragment")) {
                this.d = ye8.v(view2);
            }
            ew8 iMLog2 = IMLog.getInstance();
            iMLog2.c("GroupChatDialogFragment", "onViewCreated end, source = " + this.o);
        }
    }
}
