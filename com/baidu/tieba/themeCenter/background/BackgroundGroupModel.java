package com.baidu.tieba.themeCenter.background;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.cja;
import com.baidu.tieba.da5;
import com.baidu.tieba.gca;
import com.baidu.tieba.kb;
import com.baidu.tieba.l9;
import com.baidu.tieba.via;
import com.baidu.tieba.wia;
import com.baidu.tieba.zja;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class BackgroundGroupModel extends BdBaseModel<BackgroundGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundGroupActivity a;
    public zja b;
    public List<cja> c;
    public c d;
    public boolean e;
    public kb f;
    public kb g;

    /* loaded from: classes8.dex */
    public interface c {
        void a(int i, String str, zja zjaVar, List<cja> list);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class a extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundGroupModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BackgroundGroupModel backgroundGroupModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundGroupModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundGroupModel;
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BackgroundGroupHttpResponseMessage;
            if (!z && !(responsedMessage instanceof BackgroundGroupSocketResponseMessage)) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                if (this.a.d != null) {
                    this.a.d.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b, this.a.c);
                    return;
                }
                return;
            }
            if (z) {
                BackgroundGroupHttpResponseMessage backgroundGroupHttpResponseMessage = (BackgroundGroupHttpResponseMessage) responsedMessage;
                this.a.b = backgroundGroupHttpResponseMessage.getRecommand();
                this.a.c = backgroundGroupHttpResponseMessage.getGroupList();
            } else if (responsedMessage instanceof BackgroundGroupSocketResponseMessage) {
                BackgroundGroupSocketResponseMessage backgroundGroupSocketResponseMessage = (BackgroundGroupSocketResponseMessage) responsedMessage;
                this.a.b = backgroundGroupSocketResponseMessage.getRecommand();
                this.a.c = backgroundGroupSocketResponseMessage.getGroupList();
            }
            if (this.a.d != null) {
                this.a.d.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b, this.a.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundGroupModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BackgroundGroupModel backgroundGroupModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundGroupModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundGroupModel;
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DressItemData d0;
            DressItemData d02;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (!(responsedMessage instanceof BackgroundSetHttpResponseMessage) && !(responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                return;
            }
            BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
            int propId = backgroundSetRequestMessage.getPropId();
            if (responsedMessage.getError() != 0) {
                if (responsedMessage.getError() == 2270014) {
                    return;
                }
                int i = wia.b;
                if (responsedMessage.getError() == wia.c) {
                    i = wia.a;
                }
                boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                if (fromDetail) {
                    return;
                }
                if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == this.a.getUniqueId()) && propId == this.a.a.w1() && (d02 = this.a.d0(propId)) != null) {
                    this.a.i0(i, responsedMessage.getErrorString(), d02, fromDetail);
                    return;
                }
                return;
            }
            if (propId == this.a.a.w1() && (d0 = this.a.d0(propId)) != null) {
                TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", d0.getFreeUserLevel()));
            }
            da5 p = da5.p();
            p.F("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
            this.a.j0(propId);
            this.a.d.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b, this.a.c);
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, 309020);
        this.g = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.a = backgroundGroupActivity;
        this.e = backgroundGroupActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        f0();
        registerListener(this.f);
        g0();
        registerListener(this.g);
    }

    public void h0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
        }
    }

    public final DressItemData d0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<cja> list = this.c;
            if (list != null && list.size() > 0) {
                for (cja cjaVar : this.c) {
                    if (cjaVar != null && cjaVar.a() != null) {
                        for (DressItemData dressItemData : cjaVar.a()) {
                            if (dressItemData != null && dressItemData.getPropsId() == i) {
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

    public final void j0(int i) {
        List<cja> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (list = this.c) != null && list.size() > 0) {
            for (cja cjaVar : this.c) {
                if (cjaVar != null && cjaVar.a() != null) {
                    for (DressItemData dressItemData : cjaVar.a()) {
                        if (dressItemData != null) {
                            if (dressItemData.getPropsId() == i) {
                                dressItemData.setInUse(true);
                            } else {
                                dressItemData.setInUse(false);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            gca.h(309020, BackgroundGroupSocketResponseMessage.class, false, false);
            gca.c(309020, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_GROUP, TbConfig.PERSONAL_BACKGROUND_GROUP_PAGE, BackgroundGroupHttpResponseMessage.class, false, false, false, false);
        }
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            gca.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            gca.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            sendMessage(new BackgroundGroupRequestMessage());
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i0(int i, String str, DressItemData dressItemData, boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, dressItemData, Boolean.valueOf(z)}) == null) {
            if (dressItemData != null && dressItemData.getFreeUserLevel() == 101) {
                i2 = 9;
            } else {
                i2 = 0;
            }
            if (!StringUtils.isNull(str)) {
                int i4 = 4;
                if (i == wia.a) {
                    TbPageContext<BackgroundGroupActivity> pageContext = this.a.getPageContext();
                    if (z) {
                        i3 = 4;
                    } else {
                        i3 = 2;
                    }
                    via.d(pageContext, i3, str, i2, MemberPayStatistic.REFER_PAGE_PERSONALITY_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
                } else if (i == wia.b) {
                    TbPageContext<BackgroundGroupActivity> pageContext2 = this.a.getPageContext();
                    if (!z) {
                        i4 = 2;
                    }
                    via.c(pageContext2, i4, str, i2);
                }
            }
        }
    }
}
