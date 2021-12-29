package com.baidu.tieba.themeCenter.background;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.c4.h.e;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class BackgroundListModel extends BdBaseModel<BackgroundListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BackgroundListActivity f50327e;

    /* renamed from: f  reason: collision with root package name */
    public e f50328f;

    /* renamed from: g  reason: collision with root package name */
    public List<DressItemData> f50329g;

    /* renamed from: h  reason: collision with root package name */
    public List<DressItemData> f50330h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f50331i;

    /* renamed from: j  reason: collision with root package name */
    public c f50332j;

    /* renamed from: k  reason: collision with root package name */
    public int f50333k;
    public boolean l;
    public boolean m;
    public boolean n;
    public c.a.d.c.g.a o;
    public c.a.d.c.g.a p;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BackgroundListModel backgroundListModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundListModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = backgroundListModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BackgroundListHttpResponseMessage;
            if (z || (responsedMessage instanceof BackgroundListSocketResponseMessage)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        BackgroundListHttpResponseMessage backgroundListHttpResponseMessage = (BackgroundListHttpResponseMessage) responsedMessage;
                        this.a.f50328f = backgroundListHttpResponseMessage.getRecommand();
                        this.a.f50329g = backgroundListHttpResponseMessage.getBackgroundList();
                        this.a.l = backgroundListHttpResponseMessage.hasMore();
                        this.a.m = backgroundListHttpResponseMessage.getIsDefault();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        this.a.f50328f = backgroundListSocketResponseMessage.getRecommand();
                        this.a.f50329g = backgroundListSocketResponseMessage.getBackgroundList();
                        this.a.l = backgroundListSocketResponseMessage.hasMore();
                        this.a.m = backgroundListSocketResponseMessage.getIsDefault();
                    }
                    if (this.a.f50330h == null) {
                        this.a.f50330h = new ArrayList();
                        this.a.f50330h.add(this.a.f50331i);
                    }
                    if (this.a.f50333k == 1) {
                        this.a.f50330h.clear();
                        this.a.f50330h.add(this.a.f50331i);
                    }
                    if (this.a.f50329g != null) {
                        this.a.f50330h.addAll(this.a.f50329g);
                    }
                } else {
                    BackgroundListModel.y(this.a);
                }
                if (this.a.f50332j != null) {
                    this.a.O();
                    this.a.f50332j.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.f50328f, this.a.f50330h);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BackgroundListModel backgroundListModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundListModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = backgroundListModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DressItemData N;
            DressItemData N2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                int propId = backgroundSetRequestMessage.getPropId();
                if (responsedMessage.getError() == 0) {
                    if (propId == this.a.f50327e.getPropId() && (N = this.a.N(propId)) != null) {
                        TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", N.getFreeUserLevel()));
                    }
                    c.a.s0.s.g0.b j2 = c.a.s0.s.g0.b.j();
                    j2.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                    this.a.T(propId);
                    this.a.f50332j.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.f50328f, this.a.f50330h);
                } else if (responsedMessage.getError() == 2270014) {
                } else {
                    int i2 = c.a.t0.c4.c.f15890b;
                    if (responsedMessage.getError() == c.a.t0.c4.c.f15891c) {
                        i2 = c.a.t0.c4.c.a;
                    }
                    boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                    if (fromDetail) {
                        return;
                    }
                    if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == this.a.getUniqueId()) && propId == this.a.f50327e.getPropId() && (N2 = this.a.N(propId)) != null) {
                        this.a.S(i2, responsedMessage.getErrorString(), N2, fromDetail);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
        void a(int i2, String str, e eVar, List<DressItemData> list);
    }

    public BackgroundListModel(BackgroundListActivity backgroundListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50333k = 0;
        this.l = true;
        this.m = false;
        this.o = new a(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, 309021);
        this.p = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.f50327e = backgroundListActivity;
        DressItemData dressItemData = new DressItemData();
        this.f50331i = dressItemData;
        dressItemData.setPropsId(0);
        this.f50331i.setTitle(TbadkCoreApplication.getInst().getString(R.string.default_background));
        ArrayList arrayList = new ArrayList();
        this.f50330h = arrayList;
        arrayList.add(this.f50331i);
        this.n = backgroundListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.o);
        Q();
        registerListener(this.p);
    }

    public static /* synthetic */ int y(BackgroundListModel backgroundListModel) {
        int i2 = backgroundListModel.f50333k;
        backgroundListModel.f50333k = i2 - 1;
        return i2;
    }

    public final DressItemData N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<DressItemData> list = this.f50330h;
            if (list != null && list.size() > 0) {
                for (DressItemData dressItemData : this.f50330h) {
                    if (dressItemData != null && dressItemData.getPropsId() == i2) {
                        return dressItemData;
                    }
                }
            }
            return null;
        }
        return (DressItemData) invokeI.objValue;
    }

    public final void O() {
        DressItemData N;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m && (N = N(0)) != null) {
            N.setInUse(true);
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.t0.w3.f0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            c.a.t0.w3.f0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void R(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f50332j = cVar;
        }
    }

    public void S(int i2, String str, DressItemData dressItemData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, dressItemData, Boolean.valueOf(z)}) == null) {
            int i3 = (dressItemData == null || dressItemData.getFreeUserLevel() != 101) ? 0 : 9;
            if (StringUtils.isNull(str)) {
                return;
            }
            if (i2 == c.a.t0.c4.c.a) {
                c.a.t0.c4.b.d(this.f50327e.getPageContext(), z ? 4 : 2, str, i3, MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
            } else if (i2 == c.a.t0.c4.c.f15890b) {
                c.a.t0.c4.b.c(this.f50327e.getPageContext(), z ? 4 : 2, str, i3);
            }
        }
    }

    public final void T(int i2) {
        List<DressItemData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (list = this.f50330h) == null || list.size() <= 0) {
            return;
        }
        for (DressItemData dressItemData : this.f50330h) {
            if (dressItemData != null) {
                if (dressItemData.getPropsId() == i2) {
                    dressItemData.setInUse(true);
                } else {
                    dressItemData.setInUse(false);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            this.f50333k = 1;
            backgroundListRequestMessage.setPn(1);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.t0.w3.f0.a.h(309021, BackgroundListSocketResponseMessage.class, false, false);
            c.a.t0.w3.f0.a.c(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.l) {
            this.f50333k++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.f50333k);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }
}
