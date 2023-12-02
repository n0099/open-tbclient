package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.inputtool.callback.uistate.ViewState;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.RecentlyBotSkillInfoDto;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class uo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final InputToolFragment a;
    public GroupChatRobotFloorView b;
    public e c;
    public f d;
    public List<BotsDTO.BotListDTO> e;
    public List<Object> f;
    public List<Object> g;
    @Nullable
    public go8 h;
    @Nullable
    public do8 i;
    public boolean j;
    public int k;
    public int l;

    /* loaded from: classes8.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z);

        void b(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter, boolean z);
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(BotsDTO.BotListDTO.UserDTO userDTO, BotsDTO.BotListDTO.SkillDTO skillDTO);
    }

    /* loaded from: classes8.dex */
    public class a implements GroupChatRobotFloorView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo8 a;

        public a(uo8 uo8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uo8Var;
        }

        @Override // com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotFloorView.f
        public void a(String str, int i, int i2) {
            long j;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, str, i, i2) == null) {
                BotsDTO.BotListDTO.UserDTO i3 = this.a.i(str);
                BotsDTO.BotListDTO.SkillDTO k = this.a.k(str, i);
                if (i3 != null && k != null && this.a.d != null) {
                    this.a.d.a(i3, k);
                    long j2 = 0;
                    if (this.a.h != null) {
                        j = this.a.h.d();
                    } else {
                        j = 0;
                    }
                    if (this.a.i != null) {
                        j2 = this.a.i.a();
                    }
                    if (this.a.i != null) {
                        str2 = this.a.i.b();
                    } else {
                        str2 = "";
                    }
                    TiebaStatic.log(new StatisticItem("c15132").param("obj_type", 2).param("obj_name", k.getName()).param("obj_source", i2).param("fid", j2).param("room_id", j).param("fname", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ uo8 b;

        public b(uo8 uo8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uo8Var;
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if (this.b.b != null) {
                    this.b.b.F();
                }
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ uo8 b;

        public c(uo8 uo8Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo8Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uo8Var;
            this.a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.b.y(false, 0);
                if (this.b.b != null) {
                    this.b.b.r();
                }
                if (this.b.a.Y2() != null && this.b.a.Y2().I() != null) {
                    this.b.a.Y2().I().d(true);
                    if (this.b.a.b3() != null && (this.b.a.b3().A() || this.b.j)) {
                        this.b.a.Y2().I().a(ViewState.GONE);
                    }
                }
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
    }

    public uo8(@NonNull InputToolFragment inputToolFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputToolFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.a = inputToolFragment;
        this.k = BdUtilHelper.getEquipmentHeight(inputToolFragment.getContext());
    }

    public final BotsDTO.BotListDTO.UserDTO i(String str) {
        InterceptResult invokeL;
        BotsDTO.BotListDTO botListDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.e)) {
                for (BotsDTO.BotListDTO botListDTO2 : this.e) {
                    if ((botListDTO2 instanceof BotsDTO.BotListDTO) && (botListDTO = botListDTO2) != null && botListDTO.getUser() != null && str.equals(botListDTO.getUser().getUk())) {
                        return botListDTO.getUser();
                    }
                }
            }
            return null;
        }
        return (BotsDTO.BotListDTO.UserDTO) invokeL.objValue;
    }

    public final BotsDTO.BotListDTO j(String str) {
        InterceptResult invokeL;
        BotsDTO.BotListDTO botListDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.e)) {
                for (BotsDTO.BotListDTO botListDTO2 : this.e) {
                    if ((botListDTO2 instanceof BotsDTO.BotListDTO) && (botListDTO = botListDTO2) != null && botListDTO.getUser() != null && str.equals(botListDTO.getUser().getUk())) {
                        return botListDTO;
                    }
                }
            }
            return null;
        }
        return (BotsDTO.BotListDTO) invokeL.objValue;
    }

    public final void s(Boolean bool) {
        GroupChatRobotFloorView groupChatRobotFloorView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, bool) != null) || (groupChatRobotFloorView = this.b) == null) {
            return;
        }
        if (groupChatRobotFloorView.w() && !this.b.x()) {
            this.b.p();
        }
        if (!this.b.w() && this.b.x()) {
            this.b.E();
        }
        this.b.G();
        if (p()) {
            this.b.setTabLayoutVisible(false);
        } else {
            this.b.setTabLayoutVisible(!bool.booleanValue());
        }
    }

    public void A(go8 go8Var, do8 do8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, go8Var, do8Var) == null) {
            this.h = go8Var;
            this.i = do8Var;
        }
    }

    @NonNull
    public final List<RecentlyBotSkillInfoDto> l(@NonNull List<BotsDTO.BotListDTO> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            return jp8.f().e(list);
        }
        return (List) invokeL.objValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j = z;
            if (z && this.a.getContext() != null) {
                this.l = vg5.d(this.a.getContext());
            }
        }
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.c = eVar;
        }
    }

    public void v(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) {
            this.d = fVar;
        }
    }

    public void w(@Nullable d dVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) && n() && (eVar = this.c) != null) {
            eVar.b(m(), 0, 200L, new c(this, dVar), false);
        }
    }

    public void x(GroupChatRobotFloorView groupChatRobotFloorView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, groupChatRobotFloorView) == null) {
            this.b = groupChatRobotFloorView;
            o();
        }
    }

    public final BotsDTO.BotListDTO.SkillDTO k(@Nullable String str, int i) {
        InterceptResult invokeLI;
        BotsDTO.BotListDTO botListDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.e)) {
                for (BotsDTO.BotListDTO botListDTO2 : this.e) {
                    if ((botListDTO2 instanceof BotsDTO.BotListDTO) && (botListDTO = botListDTO2) != null && botListDTO.getUser() != null && str.equals(botListDTO.getUser().getUk()) && !ListUtils.isEmpty(botListDTO.getSkill())) {
                        for (BotsDTO.BotListDTO.SkillDTO skillDTO : botListDTO.getSkill()) {
                            if (i == skillDTO.getType()) {
                                return skillDTO;
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (BotsDTO.BotListDTO.SkillDTO) invokeLI.objValue;
    }

    public void y(boolean z, int i) {
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (z) {
                this.b.setVisibility(0);
                this.b.setCallFrom(i);
                go8 go8Var = this.h;
                long j2 = 0;
                if (go8Var != null) {
                    j = go8Var.d();
                } else {
                    j = 0;
                }
                do8 do8Var = this.i;
                if (do8Var != null) {
                    j2 = do8Var.a();
                }
                do8 do8Var2 = this.i;
                if (do8Var2 != null) {
                    str = do8Var2.b();
                } else {
                    str = "";
                }
                TiebaStatic.log(new StatisticItem("c15132").param("obj_type", 1).param("obj_source", i).param("fid", j2).param("room_id", j).param("fname", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            GroupChatRobotFloorView groupChatRobotFloorView = this.b;
            if (groupChatRobotFloorView != null) {
                int i = ((this.k * 4) / 5) - this.l;
                int robotFloorHeight = groupChatRobotFloorView.getRobotFloorHeight();
                if (robotFloorHeight > i) {
                    return i;
                }
                return robotFloorHeight;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.b.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        GroupChatRobotFloorView groupChatRobotFloorView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (groupChatRobotFloorView = this.b) == null) {
            return;
        }
        groupChatRobotFloorView.setOnItemClickListener(new a(this));
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.e.size() <= 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q(Boolean bool) {
        InterceptResult invokeL;
        BotsDTO.BotListDTO j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bool)) == null) {
            this.b.D();
            if (bool.booleanValue() && this.a.b3() != null && this.a.b3().q().E0() != null && this.a.b3().q().E0().s() != null) {
                List<String> atUidList = this.a.b3().q().E0().s().getAtUidList();
                if (ListUtils.getCount(atUidList) != 1 || (j = j(BIMManager.getBdUKFromBdUid(atUidList.get(0)))) == null) {
                    return false;
                }
                this.g.clear();
                this.g.add(j);
                return this.b.z(this.g, bool.booleanValue());
            }
            this.f.clear();
            this.f.addAll(l(this.e));
            this.f.addAll(this.e);
            return this.b.z(this.f, bool.booleanValue());
        }
        return invokeL.booleanValue;
    }

    public void u(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, botsDTO) == null) && botsDTO != null && !ListUtils.isEmpty(botsDTO.getBotList())) {
            this.e = botsDTO.getBotList();
            this.f.clear();
            this.f.addAll(l(this.e));
            this.f.addAll(this.e);
            this.b.setData(this.f, p());
        }
    }

    public void z(@Nullable d dVar, int i, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048594, this, dVar, i, bool) != null) || n() || this.c == null || this.b == null || this.a.b3() == null || this.a.b3().q().X0() == null || this.a.b3().q().X0().e() || !q(bool)) {
            return;
        }
        s(bool);
        y(true, i);
        if (this.a.Y2() != null && this.a.Y2().I() != null) {
            this.a.Y2().I().d(true);
        }
        this.c.a(0, m(), 200L, new b(this, dVar), true);
    }
}
