package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.data.RecentlyBotSkillInfoDto;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotSkillItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotSkillRecentlyItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class m88 implements n58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    @NonNull
    public TbPageContext e;
    public l88 f;
    public long g;
    public long h;
    public ArrayList<RobotItem> i;
    public List<l58> j;
    public p58 k;

    @Override // com.baidu.tieba.n58
    public void detach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.n58
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public m88(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.i = new ArrayList<>();
        this.j = new ArrayList();
        this.e = tbPageContext;
    }

    @Override // com.baidu.tieba.n58
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j.size();
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.b + 1;
            this.b = i;
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.n58
    @NonNull
    public List<l58> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (List) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.c + 1;
            this.c = i;
            return i;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.d + 1;
            this.d = i;
            return i;
        }
        return invokeV.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.a = 0;
            this.i.clear();
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return ii.d(this.e.getPageActivity(), 42.0f);
        }
        return invokeV.intValue;
    }

    @NonNull
    public ArrayList<RobotItem> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public void u() {
        p58 p58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (p58Var = this.k) != null) {
            p58Var.b(0, e().size());
        }
    }

    public void b(List<l58> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && !ListUtils.isEmpty(list) && this.k != null) {
            this.j.clear();
            this.j.addAll(list);
            this.k.g(0, e());
        }
    }

    @Override // com.baidu.tieba.n58
    public void d(@NonNull p58 p58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p58Var) == null) {
            this.k = p58Var;
        }
    }

    @Nullable
    public l58 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (!ListUtils.isEmpty(this.j) && i >= 0 && i < this.j.size()) {
                return this.j.get(i);
            }
            return null;
        }
        return (l58) invokeI.objValue;
    }

    public void v(l88 l88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, l88Var) == null) {
            this.f = l88Var;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (this.b != 0) {
                this.a += ii.d(this.e.getPageActivity(), 42.0f) * this.b;
            }
            if (this.c != 0) {
                this.a += ii.d(this.e.getPageActivity(), 35.0f) * this.c;
            }
            if (this.d != 0) {
                int d = this.a + (ii.d(this.e.getPageActivity(), 55.0f) * this.d);
                this.a = d;
                this.a = d + ii.d(this.e.getPageActivity(), 42.0f);
            }
            if (!z) {
                this.a += ii.d(this.e.getPageActivity(), 52.0f);
            }
            this.a += ii.d(this.e.getPageActivity(), 18.0f);
        }
    }

    public void q(List<Object> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048593, this, list, z) == null) && !ListUtils.isEmpty(list) && this.k != null) {
            j();
            List<l58> s = s(list);
            if (ListUtils.isEmpty(s)) {
                return;
            }
            i(z);
            this.j.clear();
            this.j.addAll(s);
            this.k.g(0, e());
        }
    }

    public void r(List<Object> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048594, this, list, z) == null) && !ListUtils.isEmpty(list) && this.k != null) {
            j();
            List<l58> s = s(list);
            if (ListUtils.isEmpty(s)) {
                return;
            }
            i(z);
            this.j.clear();
            this.j.addAll(s);
            this.k.c(0, e());
        }
    }

    @Nullable
    public final List<l58> s(@Nullable List<?> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof BotsDTO.BotListDTO) {
                    BotsDTO.BotListDTO botListDTO = (BotsDTO.BotListDTO) obj;
                    if (botListDTO.getUser() != null) {
                        String nameShow = botListDTO.getUser().getNameShow();
                        String portrait = botListDTO.getUser().getPortrait();
                        String uk = botListDTO.getUser().getUk();
                        List<l58> t = t(botListDTO.getSkill(), botListDTO.getUser().getUk());
                        if (!TextUtils.isEmpty(nameShow) && !TextUtils.isEmpty(portrait) && !TextUtils.isEmpty(uk) && !ListUtils.isEmpty(t)) {
                            c();
                            TbPageContext tbPageContext = this.e;
                            l88 l88Var = this.f;
                            if (m() == 1 && (this.b != 1 || p() == 0)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            RobotItem robotItem = new RobotItem(t, portrait, nameShow, uk, tbPageContext, l88Var, z);
                            arrayList.add(robotItem);
                            this.i.add(robotItem);
                        }
                    }
                } else if (obj instanceof RecentlyBotSkillInfoDto) {
                    RecentlyBotSkillInfoDto recentlyBotSkillInfoDto = (RecentlyBotSkillInfoDto) obj;
                    RobotSkillRecentlyItem robotSkillRecentlyItem = new RobotSkillRecentlyItem(recentlyBotSkillInfoDto.getSkillName(), recentlyBotSkillInfoDto.getDesc(), recentlyBotSkillInfoDto.getBotName(), recentlyBotSkillInfoDto.getAvatar(), recentlyBotSkillInfoDto.getBotUk(), recentlyBotSkillInfoDto.getSkillId(), recentlyBotSkillInfoDto.getFuncType());
                    robotSkillRecentlyItem.setRoomDetailInfo(this.g, this.h);
                    arrayList.add(robotSkillRecentlyItem);
                    h();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public final List<l58> t(@Nullable List<?> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, list, str)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof BotsDTO.BotListDTO.SkillDTO) {
                    BotsDTO.BotListDTO.SkillDTO skillDTO = (BotsDTO.BotListDTO.SkillDTO) obj;
                    String name = skillDTO.getName();
                    String desc = skillDTO.getDesc();
                    int type = skillDTO.getType();
                    boolean isShow = skillDTO.isShow();
                    AbilityItem abilityItem = skillDTO.getAbilityItem();
                    boolean isFuncJump = skillDTO.isFuncJump();
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(desc) && !TextUtils.isEmpty(str) && isShow) {
                        g();
                        arrayList.add(new RobotSkillItem(name, desc, type, str, abilityItem, isFuncJump));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void w(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.g = j;
            this.h = j2;
        }
    }
}
