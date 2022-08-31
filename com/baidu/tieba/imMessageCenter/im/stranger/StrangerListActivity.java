package com.baidu.tieba.imMessageCenter.im.stranger;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.es4;
import com.baidu.tieba.gs4;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.pg;
import com.baidu.tieba.s67;
import com.baidu.tieba.t67;
import com.baidu.tieba.v77;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wb7;
import com.baidu.tieba.yr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wb7 a;
    public StrangerListModel b;
    public StrangerListActivity c;
    public yr4 d;
    public AlertDialog e;
    public boolean f;
    public final CustomMessageListener g;
    public s67 h;
    public final t67 i;
    public HttpMessageListener j;

    /* loaded from: classes4.dex */
    public class a implements gs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ImMessageCenterShowItemData c;
        public final /* synthetic */ StrangerListActivity d;

        public a(StrangerListActivity strangerListActivity, es4 es4Var, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity, es4Var, Integer.valueOf(i), imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = strangerListActivity;
            this.a = es4Var;
            this.b = i;
            this.c = imMessageCenterShowItemData;
        }

        @Override // com.baidu.tieba.gs4.e
        public void i0(gs4 gs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, gs4Var, i, view2) == null) {
                es4 es4Var = this.a;
                if (es4Var != null && es4Var.isShowing()) {
                    this.a.dismiss();
                }
                if (this.b == 1) {
                    this.d.b.z(this.d.i);
                } else {
                    this.d.b.asyncDeleteItem(this.c, this.d.i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(StrangerListActivity strangerListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity, Integer.valueOf(i)};
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
            this.a = strangerListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.W1(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.V1(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.X1(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.b.setData(null, this.a.h);
            } else if (customResponsedMessage.getCmd() != 2016011 || this.a.a == null || this.a.a.o() == null) {
            } else {
                this.a.a.o().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements s67 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;

        public c(StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = strangerListActivity;
        }

        @Override // com.baidu.tieba.s67
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.U1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements t67 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;

        public d(StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = strangerListActivity;
        }

        @Override // com.baidu.tieba.t67
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.P1();
                this.a.U1();
            }
        }

        @Override // com.baidu.tieba.t67
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.P1();
                this.a.showToast(R.string.obfuscated_res_0x7f0f04ba, false);
                this.a.U1();
            }
        }

        @Override // com.baidu.tieba.t67
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.b2();
            }
        }

        @Override // com.baidu.tieba.t67
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                if (this.a.d != null) {
                    this.a.d.b(i);
                }
                this.a.T1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;

        public e(StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = strangerListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_BATCH_DELETE_MESSAGE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (this.a.e != null) {
                    this.a.e.dismiss();
                }
                if (this.a.f) {
                    this.a.N1();
                }
                this.a.a.A(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;

        public f(StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = strangerListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e != null) {
                    this.a.e.dismiss();
                }
                this.a.a.C(false);
                this.a.a.A(false);
                this.a.a.t().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f063f));
                this.a.a.q().setVisibility(0);
                this.a.a.v().setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(StrangerListActivity strangerListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity, Integer.valueOf(i)};
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
            this.a = strangerListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            HashMap<String, ImMessageCenterPojo> hashMap;
            ImMessageCenterPojo imMessageCenterPojo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof IMUserListHttpResponseMsg)) {
                IMUserListHttpResponseMsg iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) httpResponsedMessage;
                if (this.a.b == null || ListUtils.isEmpty(this.a.b.getData()) || (hashMap = iMUserListHttpResponseMsg.changedList) == null || hashMap.isEmpty()) {
                    return;
                }
                for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.a.b.getData()) {
                    if (imMessageCenterShowItemData != null && iMUserListHttpResponseMsg.changedList.containsKey(imMessageCenterShowItemData.getFriendId()) && (imMessageCenterPojo = iMUserListHttpResponseMsg.changedList.get(imMessageCenterShowItemData.getFriendId())) != null) {
                        imMessageCenterShowItemData.setFriendNameShow(imMessageCenterPojo.getNameShow());
                        imMessageCenterShowItemData.setRelation(imMessageCenterPojo.getIsFriend());
                        imMessageCenterShowItemData.setUserExtraData(imMessageCenterPojo.getImUserExtraData());
                    }
                }
                this.a.U1();
            }
        }
    }

    public StrangerListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new b(this, 0);
        this.h = new c(this);
        this.i = new d(this);
        this.j = new g(this, CmdConfigHttp.CMD_GET_USER_LIST);
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.deleteSelectedDatas(this.i);
        }
    }

    public void O1() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (alertDialog = this.e) != null && alertDialog.isShowing()) {
            this.e.dismiss();
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            yr4 yr4Var = this.d;
            if (yr4Var != null && yr4Var.isShowing()) {
                this.d.dismiss();
                this.d = null;
            }
            closeLoadingDialog();
            dismissAllDialog();
        }
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ImMessageCenterShowItemData> data = this.b.getData();
            for (int i = 0; i != data.size(); i++) {
                if (data.get(i).getUnReadCount() != 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<ImMessageCenterShowItemData> data = this.b.getData();
            for (int i = 0; i != data.size(); i++) {
                if (data.get(i).isSelected()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void S1(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, strangerListActivity) == null) {
            this.a = new wb7(strangerListActivity);
        }
    }

    public final void T1() {
        wb7 wb7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (wb7Var = this.a) == null || wb7Var.o() == null) {
            return;
        }
        this.a.o().notifyDataSetChanged();
    }

    public final void U1() {
        wb7 wb7Var;
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (wb7Var = this.a) == null || wb7Var.o() == null || (strangerListModel = this.b) == null) {
            return;
        }
        if (strangerListModel != null && strangerListModel.isEmpty()) {
            showNoDataView();
        }
        this.a.t().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f063f));
        this.a.t().getCenterImgBox().setVisibility(4);
        if (!this.b.isEmpty()) {
            this.a.q().setVisibility(0);
            this.a.v().setVisibility(0);
        }
        this.a.o().r(this.b.getData());
    }

    public final void V1(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                StrangerListModel strangerListModel2 = this.b;
                if (strangerListModel2 != null) {
                    strangerListModel2.insertOrUpdate(data, this.h);
                }
            } else if (memoryChangedMessage.getType() != 2 || (strangerListModel = this.b) == null) {
            } else {
                strangerListModel.remove(data, this.h);
            }
        }
    }

    public final void W1(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    public final void X1(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 3 || (strangerListModel = this.b) == null) {
                return;
            }
            strangerListModel.setData(data, this.h);
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            registerListener(2016004, this.g);
            registerListener(2016007, this.g);
            registerListener(2016001, this.g);
            registerListener(2016011, this.g);
            registerListener(2016002, this.g);
            registerListener(this.j);
        }
    }

    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            List<ImMessageCenterShowItemData> data = this.b.getData();
            for (int i = 0; i != data.size(); i++) {
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 2)));
                data.get(i).setUnReadCount(0);
            }
            this.a.z(this.b.getData());
        }
    }

    public void a2(boolean z) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            O1();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            this.f = z;
            if (z) {
                i = R.string.obfuscated_res_0x7f0f1424;
                i2 = R.string.obfuscated_res_0x7f0f1228;
                i3 = R.string.obfuscated_res_0x7f0f14a6;
            } else {
                i = R.string.obfuscated_res_0x7f0f1425;
                i2 = R.string.obfuscated_res_0x7f0f122a;
                i3 = R.string.obfuscated_res_0x7f0f14a4;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i3, z ? TBAlertConfig.OperateBtnStyle.ALERT : TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f14a5, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
            tBAlertBuilder.t(i);
            tBAlertBuilder.k(i2);
            tBAlertBuilder.m(true);
            tBAlertBuilder.r(aVar2, aVar);
            tBAlertBuilder.h(false);
            this.e = tBAlertBuilder.w();
            aVar.a(new e(this));
            aVar2.a(new f(this));
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            P1();
            if (this.d == null) {
                this.d = v77.m().p(getPageContext().getPageActivity());
            }
            this.d.show();
            this.d.b(0);
        }
    }

    public void c2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.b.updateEditStatus(z);
            this.a.z(this.b.getData());
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b = new StrangerListModel(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        wb7 wb7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (wb7Var = this.a) == null) {
            return;
        }
        wb7Var.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.a.q()) {
                this.a.A(true);
                this.a.q().setVisibility(4);
                this.a.v().setVisibility(4);
                this.a.t().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f063e));
                this.a.t().getCenterImgBox().setVisibility(4);
            } else if (view2 == this.a.v()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ONE_KEY_READ).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (Q1()) {
                    Z1();
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.c);
                bdTopToast.h(false);
                bdTopToast.g(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1423));
                bdTopToast.i((ViewGroup) findViewById(16908290));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onCreate(bundle);
            this.c = this;
            S1(this);
            initData();
            Y1();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            P1();
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        wb7 wb7Var;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (wb7Var = this.a) == null || wb7Var.o() == null || (item = this.a.o().getItem(i)) == null) {
            return;
        }
        if (this.a.o().c()) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e00);
            if (item.isSelected()) {
                item.setSelected(false);
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080353, R.color.CAM_X0111, null);
                if (R1()) {
                    return;
                }
                this.a.C(false);
                return;
            }
            item.setSelected(true);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080355, R.color.CAM_X0302, null);
            this.a.B(true);
            return;
        }
        PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.c.getPageContext().getContext(), pg.g(item.getFriendId(), 0L), item.getFriendName(), item.getFriendNameShow(), item.getFriendPortrait(), 0, 0);
        personalChatActivityConfig.setFrom(4);
        personalChatActivityConfig.setFollowStatus(0);
        sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.FRIEND_UID, item.getFriendId()).param("obj_param1", item.getUnReadCount()).param("obj_type", item.getRelation() != 3 ? 2 : 1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        wb7 wb7Var;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a.r() || (wb7Var = this.a) == null || wb7Var.o() == null || (item = this.a.o().getItem(i)) == null) {
                return false;
            }
            int size = this.b.getData().size();
            es4 es4Var = new es4(getPageContext());
            es4Var.i(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04c5)}, new a(this, es4Var, size, item));
            es4Var.k();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onRestart();
            ChatStatusManager.getInst().setIsOpen(5, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            wb7 wb7Var = this.a;
            if (wb7Var != null && wb7Var.o() != null) {
                this.a.o().notifyDataSetChanged();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.STRANGE_MERGE, -7)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStart();
            ChatStatusManager.getInst().setIsOpen(5, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onStop();
            ChatStatusManager.getInst().setIsOpen(5, false);
        }
    }

    public final void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.a.u().setVisibility(0);
            this.a.p().setVisibility(8);
            this.a.s().setVisibility(8);
            this.a.q().setVisibility(4);
        }
    }
}
