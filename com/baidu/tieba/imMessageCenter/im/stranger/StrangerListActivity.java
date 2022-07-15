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
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fr4;
import com.repackage.lr4;
import com.repackage.ng;
import com.repackage.nr4;
import com.repackage.t47;
import com.repackage.u47;
import com.repackage.w57;
import com.repackage.w97;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w97 a;
    public StrangerListModel b;
    public StrangerListActivity c;
    public fr4 d;
    public AlertDialog e;
    public boolean f;
    public final CustomMessageListener g;
    public t47 h;
    public final u47 i;
    public HttpMessageListener j;

    /* loaded from: classes3.dex */
    public class a implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ImMessageCenterShowItemData c;
        public final /* synthetic */ StrangerListActivity d;

        public a(StrangerListActivity strangerListActivity, lr4 lr4Var, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity, lr4Var, Integer.valueOf(i), imMessageCenterShowItemData};
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
            this.a = lr4Var;
            this.b = i;
            this.c = imMessageCenterShowItemData;
        }

        @Override // com.repackage.nr4.e
        public void N(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                lr4 lr4Var = this.a;
                if (lr4Var != null && lr4Var.isShowing()) {
                    this.a.dismiss();
                }
                if (this.b == 1) {
                    this.d.b.A(this.d.i);
                } else {
                    this.d.b.asyncDeleteItem(this.c, this.d.i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.X1(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.W1(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.Y1(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.b.setData(null, this.a.h);
            } else if (customResponsedMessage.getCmd() != 2016011 || this.a.a == null || this.a.a.m() == null) {
            } else {
                this.a.a.m().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements t47 {
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

        @Override // com.repackage.t47
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.V1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements u47 {
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

        @Override // com.repackage.u47
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Q1();
                this.a.V1();
            }
        }

        @Override // com.repackage.u47
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.Q1();
                this.a.showToast(R.string.obfuscated_res_0x7f0f04ad, false);
                this.a.V1();
            }
        }

        @Override // com.repackage.u47
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.c2();
            }
        }

        @Override // com.repackage.u47
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                if (this.a.d != null) {
                    this.a.d.b(i);
                }
                this.a.U1();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.O1();
                }
                this.a.a.y(false);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.a.A(false);
                this.a.a.y(false);
                this.a.a.r().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0634));
                this.a.a.o().setVisibility(0);
                this.a.a.t().setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.V1();
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

    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.deleteSelectedDatas(this.i);
        }
    }

    public void P1() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (alertDialog = this.e) != null && alertDialog.isShowing()) {
            this.e.dismiss();
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fr4 fr4Var = this.d;
            if (fr4Var != null && fr4Var.isShowing()) {
                this.d.dismiss();
                this.d = null;
            }
            closeLoadingDialog();
            dismissAllDialog();
        }
    }

    public boolean R1() {
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

    public boolean S1() {
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

    public final void T1(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, strangerListActivity) == null) {
            this.a = new w97(strangerListActivity);
        }
    }

    public final void U1() {
        w97 w97Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (w97Var = this.a) == null || w97Var.m() == null) {
            return;
        }
        this.a.m().notifyDataSetChanged();
    }

    public final void V1() {
        w97 w97Var;
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (w97Var = this.a) == null || w97Var.m() == null || (strangerListModel = this.b) == null) {
            return;
        }
        if (strangerListModel != null && strangerListModel.isEmpty()) {
            showNoDataView();
        }
        this.a.r().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0634));
        this.a.r().getCenterImgBox().setVisibility(4);
        if (!this.b.isEmpty()) {
            this.a.o().setVisibility(0);
            this.a.t().setVisibility(0);
        }
        this.a.m().r(this.b.getData());
    }

    public final void W1(CustomResponsedMessage<?> customResponsedMessage) {
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

    public final void X1(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    public final void Y1(CustomResponsedMessage<?> customResponsedMessage) {
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

    public final void Z1() {
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

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            List<ImMessageCenterShowItemData> data = this.b.getData();
            for (int i = 0; i != data.size(); i++) {
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 2)));
                data.get(i).setUnReadCount(0);
            }
            this.a.x(this.b.getData());
        }
    }

    public void b2(boolean z) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            P1();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            this.f = z;
            if (z) {
                i = R.string.obfuscated_res_0x7f0f1432;
                i2 = R.string.obfuscated_res_0x7f0f1238;
                i3 = R.string.obfuscated_res_0x7f0f14b4;
            } else {
                i = R.string.obfuscated_res_0x7f0f1433;
                i2 = R.string.obfuscated_res_0x7f0f123a;
                i3 = R.string.obfuscated_res_0x7f0f14b2;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i3, z ? TBAlertConfig.OperateBtnStyle.ALERT : TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f14b3, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
            tBAlertBuilder.t(i);
            tBAlertBuilder.l(i2);
            tBAlertBuilder.n(true);
            tBAlertBuilder.r(aVar2, aVar);
            tBAlertBuilder.i(false);
            this.e = tBAlertBuilder.w();
            aVar.a(new e(this));
            aVar2.a(new f(this));
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Q1();
            if (this.d == null) {
                this.d = w57.m().p(getPageContext().getPageActivity());
            }
            this.d.show();
            this.d.b(0);
        }
    }

    public void d2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.b.updateEditStatus(z);
            this.a.x(this.b.getData());
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
        w97 w97Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (w97Var = this.a) == null) {
            return;
        }
        w97Var.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.a.o()) {
                this.a.y(true);
                this.a.o().setVisibility(4);
                this.a.t().setVisibility(4);
                this.a.r().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0633));
                this.a.r().getCenterImgBox().setVisibility(4);
            } else if (view2 == this.a.t()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ONE_KEY_READ).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (R1()) {
                    a2();
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.c);
                bdTopToast.i(false);
                bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1431));
                bdTopToast.j((ViewGroup) findViewById(16908290));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onCreate(bundle);
            this.c = this;
            T1(this);
            initData();
            Z1();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Q1();
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        w97 w97Var;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (w97Var = this.a) == null || w97Var.m() == null || (item = this.a.m().getItem(i)) == null) {
            return;
        }
        if (this.a.m().c()) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d0b);
            if (item.isSelected()) {
                item.setSelected(false);
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080351, R.color.CAM_X0111, null);
                if (S1()) {
                    return;
                }
                this.a.A(false);
                return;
            }
            item.setSelected(true);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080353, R.color.CAM_X0302, null);
            this.a.z(true);
            return;
        }
        PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.c.getPageContext().getContext(), ng.g(item.getFriendId(), 0L), item.getFriendName(), item.getFriendNameShow(), item.getFriendPortrait(), 0, 0);
        personalChatActivityConfig.setFrom(4);
        personalChatActivityConfig.setFollowStatus(0);
        sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.FRIEND_UID, item.getFriendId()).param("obj_param1", item.getUnReadCount()).param("obj_type", item.getRelation() != 3 ? 2 : 1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        w97 w97Var;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a.p() || (w97Var = this.a) == null || w97Var.m() == null || (item = this.a.m().getItem(i)) == null) {
                return false;
            }
            int size = this.b.getData().size();
            lr4 lr4Var = new lr4(getPageContext());
            lr4Var.j(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b8)}, new a(this, lr4Var, size, item));
            lr4Var.m();
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
            w97 w97Var = this.a;
            if (w97Var != null && w97Var.m() != null) {
                this.a.m().notifyDataSetChanged();
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
            this.a.s().setVisibility(0);
            this.a.n().setVisibility(8);
            this.a.q().setVisibility(8);
            this.a.o().setVisibility(4);
        }
    }
}
