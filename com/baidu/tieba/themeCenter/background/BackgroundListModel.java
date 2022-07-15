package com.baidu.tieba.themeCenter.background;

import androidx.core.view.InputDeviceCompat;
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
import com.repackage.ln8;
import com.repackage.mn8;
import com.repackage.po8;
import com.repackage.wh8;
import com.repackage.xt4;
import com.repackage.za;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BackgroundListModel extends BdBaseModel<BackgroundListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundListActivity a;
    public po8 b;
    public List<DressItemData> c;
    public List<DressItemData> d;
    public DressItemData e;
    public c f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public za k;
    public za l;

    /* loaded from: classes4.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BackgroundListModel backgroundListModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundListModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = backgroundListModel;
        }

        @Override // com.repackage.za
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
                        this.a.b = backgroundListHttpResponseMessage.getRecommand();
                        this.a.c = backgroundListHttpResponseMessage.getBackgroundList();
                        this.a.h = backgroundListHttpResponseMessage.hasMore();
                        this.a.i = backgroundListHttpResponseMessage.getIsDefault();
                    } else if (responsedMessage instanceof BackgroundListSocketResponseMessage) {
                        BackgroundListSocketResponseMessage backgroundListSocketResponseMessage = (BackgroundListSocketResponseMessage) responsedMessage;
                        this.a.b = backgroundListSocketResponseMessage.getRecommand();
                        this.a.c = backgroundListSocketResponseMessage.getBackgroundList();
                        this.a.h = backgroundListSocketResponseMessage.hasMore();
                        this.a.i = backgroundListSocketResponseMessage.getIsDefault();
                    }
                    if (this.a.d == null) {
                        this.a.d = new ArrayList();
                        this.a.d.add(this.a.e);
                    }
                    if (this.a.g == 1) {
                        this.a.d.clear();
                        this.a.d.add(this.a.e);
                    }
                    if (this.a.c != null) {
                        this.a.d.addAll(this.a.c);
                    }
                } else {
                    BackgroundListModel.C(this.a);
                }
                if (this.a.f != null) {
                    this.a.S();
                    this.a.f.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b, this.a.d);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BackgroundListModel backgroundListModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundListModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = backgroundListModel;
        }

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DressItemData R;
            DressItemData R2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if ((responsedMessage instanceof BackgroundSetHttpResponseMessage) || (responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                BackgroundSetRequestMessage backgroundSetRequestMessage = (BackgroundSetRequestMessage) responsedMessage.getmOrginalMessage().getExtra();
                int propId = backgroundSetRequestMessage.getPropId();
                if (responsedMessage.getError() == 0) {
                    if (propId == this.a.a.C1() && (R = this.a.R(propId)) != null) {
                        TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", R.getFreeUserLevel()));
                    }
                    xt4 k = xt4.k();
                    k.w("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
                    this.a.X(propId);
                    this.a.f.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b, this.a.d);
                } else if (responsedMessage.getError() == 2270014) {
                } else {
                    int i = mn8.b;
                    if (responsedMessage.getError() == mn8.c) {
                        i = mn8.a;
                    }
                    boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                    if (fromDetail) {
                        return;
                    }
                    if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == this.a.getUniqueId()) && propId == this.a.a.C1() && (R2 = this.a.R(propId)) != null) {
                        this.a.W(i, responsedMessage.getErrorString(), R2, fromDetail);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i, String str, po8 po8Var, List<DressItemData> list);
    }

    public BackgroundListModel(BackgroundListActivity backgroundListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0;
        this.h = true;
        this.i = false;
        this.k = new a(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, 309021);
        this.l = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.a = backgroundListActivity;
        DressItemData dressItemData = new DressItemData();
        this.e = dressItemData;
        dressItemData.setPropsId(0);
        this.e.setTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0485));
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(this.e);
        this.j = backgroundListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.k);
        U();
        registerListener(this.l);
    }

    public static /* synthetic */ int C(BackgroundListModel backgroundListModel) {
        int i = backgroundListModel.g;
        backgroundListModel.g = i - 1;
        return i;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.h) {
            this.g++;
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            backgroundListRequestMessage.setPn(this.g);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
        }
    }

    public final DressItemData R(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<DressItemData> list = this.d;
            if (list != null && list.size() > 0) {
                for (DressItemData dressItemData : this.d) {
                    if (dressItemData != null && dressItemData.getPropsId() == i) {
                        return dressItemData;
                    }
                }
            }
            return null;
        }
        return (DressItemData) invokeI.objValue;
    }

    public final void S() {
        DressItemData R;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.i && (R = R(0)) != null) {
            R.setInUse(true);
        }
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            wh8.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            wh8.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void V(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f = cVar;
        }
    }

    public void W(int i, String str, DressItemData dressItemData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), str, dressItemData, Boolean.valueOf(z)}) == null) {
            int i2 = (dressItemData == null || dressItemData.getFreeUserLevel() != 101) ? 0 : 9;
            if (StringUtils.isNull(str)) {
                return;
            }
            if (i == mn8.a) {
                ln8.d(this.a.getPageContext(), z ? 4 : 2, str, i2, MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
            } else if (i == mn8.b) {
                ln8.c(this.a.getPageContext(), z ? 4 : 2, str, i2);
            }
        }
    }

    public final void X(int i) {
        List<DressItemData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (list = this.d) == null || list.size() <= 0) {
            return;
        }
        for (DressItemData dressItemData : this.d) {
            if (dressItemData != null) {
                if (dressItemData.getPropsId() == i) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
            this.g = 1;
            backgroundListRequestMessage.setPn(1);
            backgroundListRequestMessage.setRn(9);
            sendMessage(backgroundListRequestMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            wh8.h(309021, BackgroundListSocketResponseMessage.class, false, false);
            wh8.c(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
        }
    }
}
