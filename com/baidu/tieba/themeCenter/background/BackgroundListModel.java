package com.baidu.tieba.themeCenter.background;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
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
import com.baidu.tieba.R;
import com.baidu.tieba.cu8;
import com.baidu.tieba.qb;
import com.baidu.tieba.ux4;
import com.baidu.tieba.ys8;
import com.baidu.tieba.zm8;
import com.baidu.tieba.zs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class BackgroundListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundListActivity a;
    public cu8 b;
    public List c;
    public List d;
    public DressItemData e;
    public c f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public qb k;
    public qb l;

    /* loaded from: classes6.dex */
    public interface c {
        void a(int i, String str, cu8 cu8Var, List list);
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

    /* loaded from: classes6.dex */
    public class a extends qb {
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

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BackgroundListHttpResponseMessage;
            if (!z && !(responsedMessage instanceof BackgroundListSocketResponseMessage)) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                BackgroundListModel.B(this.a);
            } else {
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
            }
            if (this.a.f != null) {
                this.a.R();
                this.a.f.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b, this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends qb {
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

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
            DressItemData Q;
            DressItemData Q2;
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
                int i = zs8.b;
                if (responsedMessage.getError() == zs8.c) {
                    i = zs8.a;
                }
                boolean fromDetail = backgroundSetRequestMessage.getFromDetail();
                if (fromDetail) {
                    return;
                }
                if ((backgroundSetRequestMessage.getRequestUniqueId() == null || backgroundSetRequestMessage.getRequestUniqueId() == this.a.getUniqueId()) && propId == this.a.a.A1() && (Q2 = this.a.Q(propId)) != null) {
                    this.a.V(i, responsedMessage.getErrorString(), Q2, fromDetail);
                    return;
                }
                return;
            }
            if (propId == this.a.a.A1() && (Q = this.a.Q(propId)) != null) {
                TiebaStatic.log(new StatisticItem("c10286").param("obj_id", propId).param("obj_type", Q.getFreeUserLevel()));
            }
            ux4 k = ux4.k();
            k.w("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), propId);
            this.a.W(propId);
            this.a.f.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.a.b, this.a.d);
        }
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
        this.e.setTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049e));
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(this.e);
        this.j = backgroundListActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        registerTask();
        registerListener(this.k);
        T();
        registerListener(this.l);
    }

    public static /* synthetic */ int B(BackgroundListModel backgroundListModel) {
        int i = backgroundListModel.g;
        backgroundListModel.g = i - 1;
        return i;
    }

    public void U(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f = cVar;
        }
    }

    public final DressItemData Q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List list = this.d;
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

    public final void W(int i) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (list = this.d) != null && list.size() > 0) {
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
    }

    public final void R() {
        DressItemData Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.i && (Q = Q(0)) != null) {
            Q.setInUse(true);
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            zm8.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            zm8.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            zm8.h(309021, BackgroundListSocketResponseMessage.class, false, false);
            zm8.c(309021, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_LIST, TbConfig.PERSONAL_BACKGROUND_LIST_PAGE, BackgroundListHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || !this.h) {
            return;
        }
        this.g++;
        BackgroundListRequestMessage backgroundListRequestMessage = new BackgroundListRequestMessage();
        backgroundListRequestMessage.setPn(this.g);
        backgroundListRequestMessage.setRn(9);
        sendMessage(backgroundListRequestMessage);
    }

    public void V(int i, String str, DressItemData dressItemData, boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), str, dressItemData, Boolean.valueOf(z)}) == null) {
            if (dressItemData != null && dressItemData.getFreeUserLevel() == 101) {
                i2 = 9;
            } else {
                i2 = 0;
            }
            if (!StringUtils.isNull(str)) {
                int i4 = 4;
                if (i == zs8.a) {
                    TbPageContext pageContext = this.a.getPageContext();
                    if (z) {
                        i3 = 4;
                    } else {
                        i3 = 2;
                    }
                    ys8.d(pageContext, i3, str, i2, MemberPayStatistic.REFER_PAGE_ALL_BACKGROUND, MemberPayStatistic.CLICK_ZONE_OPENDE_BUTTON);
                } else if (i == zs8.b) {
                    TbPageContext pageContext2 = this.a.getPageContext();
                    if (!z) {
                        i4 = 2;
                    }
                    ys8.c(pageContext2, i4, str, i2);
                }
            }
        }
    }
}
