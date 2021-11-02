package com.baidu.tieba.themeCenter.background;

import androidx.core.view.InputDeviceCompat;
import b.a.r0.r3.h.e;
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
/* loaded from: classes9.dex */
public class BackgroundListModel extends BdBaseModel<BackgroundListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BackgroundListActivity f54539e;

    /* renamed from: f  reason: collision with root package name */
    public e f54540f;

    /* renamed from: g  reason: collision with root package name */
    public List<DressItemData> f54541g;

    /* renamed from: h  reason: collision with root package name */
    public List<DressItemData> f54542h;

    /* renamed from: i  reason: collision with root package name */
    public DressItemData f54543i;
    public c j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public b.a.e.c.g.a o;
    public b.a.e.c.g.a p;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackgroundListModel f54544a;

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
            this.f54544a = backgroundListModel;
        }

        @Override // b.a.e.c.g.a
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
                        this.f54544a.f54540f = backgroundListHttpResponseMessage.getRecommand();
                        this.f54544a.f54541g = backgroundListHttpResponseMessage.getBackgroundList();
                        this.f54544a.l = backgroundListHttpResponseMessage.hasMore();
                        this.f54544a.m = backgroundListHttpResponseMessage.getIsDefault();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        this.f54544a.f54540f = backgroundListSocketResponseMessage.getRecommand();
                        this.f54544a.f54541g = backgroundListSocketResponseMessage.getBackgroundList();
                        this.f54544a.l = backgroundListSocketResponseMessage.hasMore();
                        this.f54544a.m = backgroundListSocketResponseMessage.getIsDefault();
                    }
                    if (this.f54544a.f54542h == null) {
                        this.f54544a.f54542h = new ArrayList();
                        this.f54544a.f54542h.add(this.f54544a.f54543i);
                    }
                    if (this.f54544a.k == 1) {
                        this.f54544a.f54542h.clear();
                        this.f54544a.f54542h.add(this.f54544a.f54543i);
                    }
                    if (this.f54544a.f54541g != null) {
                        this.f54544a.f54542h.addAll(this.f54544a.f54541g);
                    }
                } else {
                    BackgroundListModel.y(this.f54544a);
                }
                if (this.f54544a.j != null) {
                    this.f54544a.O();
                    this.f54544a.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f54544a.f54540f, this.f54544a.f54542h);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackgroundListModel f54545a;

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
            this.f54545a = backgroundListModel;
        }

        @Override // b.a.e.c.g.a
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
                    if (propId == this.f54545a.f54539e.getPropId() && (N = this.f54545a.N(propId)) != null) {
                        TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", N.getFreeUserLevel()));
                    }
                    b.a.q0.s.e0.b j = b.a.q0.s.e0.b.j();
                    j.v("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                    this.f54545a.T(propId);
                    this.f54545a.j.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f54545a.f54540f, this.f54545a.f54542h);
                } else if (responsedMessage.getError() == 2270014) {
                } else {
                    int i2 = b.a.r0.r3.c.f23080b;
                    if (responsedMessage.getError() == b.a.r0.r3.c.f23081c) {
                        i2 = b.a.r0.r3.c.f23079a;
                    }
                    boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                    if (fromDetail) {
                        return;
                    }
                    if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == this.f54545a.getUniqueId()) && propId == this.f54545a.f54539e.getPropId() && (N2 = this.f54545a.N(propId)) != null) {
                        this.f54545a.S(i2, responsedMessage.getErrorString(), N2, fromDetail);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.k = 0;
        this.l = true;
        this.m = false;
        this.o = new a(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, 309021);
        this.p = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.f54539e = backgroundListActivity;
        DressItemData dressItemData = new DressItemData();
        this.f54543i = dressItemData;
        dressItemData.setPropsId(0);
        this.f54543i.setTitle(TbadkCoreApplication.getInst().getString(R.string.default_background));
        ArrayList arrayList = new ArrayList();
        this.f54542h = arrayList;
        arrayList.add(this.f54543i);
        this.n = backgroundListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.o);
        Q();
        registerListener(this.p);
    }

    public static /* synthetic */ int y(BackgroundListModel backgroundListModel) {
        int i2 = backgroundListModel.k;
        backgroundListModel.k = i2 - 1;
        return i2;
    }

    public final DressItemData N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<DressItemData> list = this.f54542h;
            if (list != null && list.size() > 0) {
                for (DressItemData dressItemData : this.f54542h) {
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
            b.a.r0.l3.f0.a.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            b.a.r0.l3.f0.a.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void R(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void S(int i2, String str, DressItemData dressItemData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, dressItemData, Boolean.valueOf(z)}) == null) {
            int i3 = (dressItemData == null || dressItemData.getFreeUserLevel() != 101) ? 0 : 9;
            if (StringUtils.isNull(str)) {
                return;
            }
            if (i2 == b.a.r0.r3.c.f23079a) {
                b.a.r0.r3.b.d(this.f54539e.getPageContext(), z ? 4 : 2, str, i3, MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
            } else if (i2 == b.a.r0.r3.c.f23080b) {
                b.a.r0.r3.b.c(this.f54539e.getPageContext(), z ? 4 : 2, str, i3);
            }
        }
    }

    public final void T(int i2) {
        List<DressItemData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (list = this.f54542h) == null || list.size() <= 0) {
            return;
        }
        for (DressItemData dressItemData : this.f54542h) {
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
            this.k = 1;
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
            b.a.r0.l3.f0.a.h(309021, BackgroundListSocketResponseMessage.class, false, false);
            b.a.r0.l3.f0.a.c(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.l) {
            this.k++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.k);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }
}
