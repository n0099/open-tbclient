package com.baidu.tieba.themeCenter.background;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.q0.n3.h.e;
import java.util.List;
/* loaded from: classes4.dex */
public class BackgroundGroupModel extends BdBaseModel<BackgroundGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BackgroundGroupActivity f21541e;

    /* renamed from: f  reason: collision with root package name */
    public e f21542f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.q0.n3.e.b> f21543g;

    /* renamed from: h  reason: collision with root package name */
    public c f21544h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21545i;
    public d.a.d.c.g.a j;
    public d.a.d.c.g.a k;

    /* loaded from: classes4.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackgroundGroupModel f21546a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BackgroundGroupModel backgroundGroupModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundGroupModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21546a = backgroundGroupModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BackgroundGroupHttpResponseMessage;
            if (z || (responsedMessage instanceof BackgroundGroupSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    if (this.f21546a.f21544h != null) {
                        this.f21546a.f21544h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f21546a.f21542f, this.f21546a.f21543g);
                        return;
                    }
                    return;
                }
                if (z) {
                    BackgroundGroupHttpResponseMessage backgroundGroupHttpResponseMessage = (BackgroundGroupHttpResponseMessage) responsedMessage;
                    this.f21546a.f21542f = backgroundGroupHttpResponseMessage.getRecommand();
                    this.f21546a.f21543g = backgroundGroupHttpResponseMessage.getGroupList();
                } else if (responsedMessage instanceof BackgroundGroupSocketResponseMessage) {
                    BackgroundGroupSocketResponseMessage backgroundGroupSocketResponseMessage = (BackgroundGroupSocketResponseMessage) responsedMessage;
                    this.f21546a.f21542f = backgroundGroupSocketResponseMessage.getRecommand();
                    this.f21546a.f21543g = backgroundGroupSocketResponseMessage.getGroupList();
                }
                if (this.f21546a.f21544h != null) {
                    this.f21546a.f21544h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f21546a.f21542f, this.f21546a.f21543g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackgroundGroupModel f21547a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BackgroundGroupModel backgroundGroupModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundGroupModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21547a = backgroundGroupModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DressItemData E;
            DressItemData E2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                int propId = backgroundSetRequestMessage.getPropId();
                if (responsedMessage.getError() == 0) {
                    if (propId == this.f21547a.f21541e.getPropId() && (E = this.f21547a.E(propId)) != null) {
                        TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", E.getFreeUserLevel()));
                    }
                    d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                    this.f21547a.K(propId);
                    this.f21547a.f21544h.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f21547a.f21542f, this.f21547a.f21543g);
                } else if (responsedMessage.getError() == 2270014) {
                } else {
                    int i2 = d.a.q0.n3.c.f61483b;
                    if (responsedMessage.getError() == d.a.q0.n3.c.f61484c) {
                        i2 = d.a.q0.n3.c.f61482a;
                    }
                    boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                    if (fromDetail) {
                        return;
                    }
                    if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == this.f21547a.getUniqueId()) && propId == this.f21547a.f21541e.getPropId() && (E2 = this.f21547a.E(propId)) != null) {
                        this.f21547a.J(i2, responsedMessage.getErrorString(), E2, fromDetail);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, String str, e eVar, List<d.a.q0.n3.e.b> list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundGroupModel(BackgroundGroupActivity backgroundGroupActivity) {
        super(backgroundGroupActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundGroupActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, 309020);
        this.k = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.f21541e = backgroundGroupActivity;
        this.f21545i = backgroundGroupActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        G();
        registerListener(this.j);
        H();
        registerListener(this.k);
    }

    public final DressItemData E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<d.a.q0.n3.e.b> list = this.f21543g;
            if (list != null && list.size() > 0) {
                for (d.a.q0.n3.e.b bVar : this.f21543g) {
                    if (bVar != null && bVar.a() != null) {
                        for (DressItemData dressItemData : bVar.a()) {
                            if (dressItemData != null && dressItemData.getPropsId() == i2) {
                                return dressItemData;
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return (DressItemData) invokeI.objValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21545i : invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.q0.h3.d0.a.h(309020, BackgroundGroupSocketResponseMessage.class, false, false);
            d.a.q0.h3.d0.a.c(309020, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, TbConfig.PERSONAL_BACKGROUND_GROUP_PAGE, BackgroundGroupHttpResponseMessage.class, false, false, false, false);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.q0.h3.d0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            d.a.q0.h3.d0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void I(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f21544h = cVar;
        }
    }

    public void J(int i2, String str, DressItemData dressItemData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, dressItemData, Boolean.valueOf(z)}) == null) {
            int i3 = (dressItemData == null || dressItemData.getFreeUserLevel() != 101) ? 0 : 9;
            if (StringUtils.isNull(str)) {
                return;
            }
            if (i2 == d.a.q0.n3.c.f61482a) {
                d.a.q0.n3.b.d(this.f21541e.getPageContext(), z ? 4 : 2, str, i3, MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
            } else if (i2 == d.a.q0.n3.c.f61483b) {
                d.a.q0.n3.b.c(this.f21541e.getPageContext(), z ? 4 : 2, str, i3);
            }
        }
    }

    public final void K(int i2) {
        List<d.a.q0.n3.e.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (list = this.f21543g) == null || list.size() <= 0) {
            return;
        }
        for (d.a.q0.n3.e.b bVar : this.f21543g) {
            if (bVar != null && bVar.a() != null) {
                for (DressItemData dressItemData : bVar.a()) {
                    if (dressItemData != null) {
                        if (dressItemData.getPropsId() == i2) {
                            dressItemData.setInUse(true);
                        } else {
                            dressItemData.setInUse(false);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            sendMessage(new BackgroundGroupRequestMessage());
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
