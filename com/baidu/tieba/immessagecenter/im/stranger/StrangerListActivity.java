package com.baidu.tieba.immessagecenter.im.stranger;

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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tieba.a55;
import com.baidu.tieba.ft8;
import com.baidu.tieba.g55;
import com.baidu.tieba.i55;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.model.IMUserListHttpResponseMsg;
import com.baidu.tieba.ke8;
import com.baidu.tieba.le8;
import com.baidu.tieba.nf8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ft8 a;
    public StrangerListModel b;
    public StrangerListActivity c;
    public a55 d;
    public AlertDialog e;
    public boolean f;
    public final CustomMessageListener g;
    public ke8 h;
    public final le8 i;
    public HttpMessageListener j;

    /* loaded from: classes6.dex */
    public class a implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ImMessageCenterShowItemData c;
        public final /* synthetic */ StrangerListActivity d;

        public a(StrangerListActivity strangerListActivity, g55 g55Var, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity, g55Var, Integer.valueOf(i), imMessageCenterShowItemData};
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
            this.a = g55Var;
            this.b = i;
            this.c = imMessageCenterShowItemData;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                g55 g55Var = this.a;
                if (g55Var != null && g55Var.isShowing()) {
                    this.a.dismiss();
                }
                if (this.b == 1) {
                    this.d.b.M(this.d.i);
                } else {
                    this.d.b.asyncDeleteItem(this.c, this.d.i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() != 2016002) {
                if (customResponsedMessage.getCmd() != 2016004) {
                    if (customResponsedMessage.getCmd() != 2016007) {
                        if (customResponsedMessage.getCmd() == 2016001) {
                            this.a.b.setData(null, this.a.h);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011 && this.a.a != null && this.a.a.C() != null) {
                            this.a.a.C().notifyDataSetChanged();
                            return;
                        } else {
                            return;
                        }
                    }
                    this.a.O1(customResponsedMessage);
                    return;
                }
                this.a.M1(customResponsedMessage);
                return;
            }
            this.a.N1(customResponsedMessage);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ke8 {
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

        @Override // com.baidu.tieba.ke8
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.L1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements le8 {
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

        @Override // com.baidu.tieba.le8
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.H1();
                this.a.L1();
            }
        }

        @Override // com.baidu.tieba.le8
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.H1();
                this.a.showToast(R.string.delete_success, false);
                this.a.L1();
            }
        }

        @Override // com.baidu.tieba.le8
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.T1();
            }
        }

        @Override // com.baidu.tieba.le8
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                if (this.a.d != null) {
                    this.a.d.b(i);
                }
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.E1();
                }
                this.a.a.O(false);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.a.Q(false);
                this.a.a.O(false);
                this.a.a.H().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0762));
                this.a.a.E().setVisibility(0);
                this.a.a.J().setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof IMUserListHttpResponseMsg)) {
                return;
            }
            IMUserListHttpResponseMsg iMUserListHttpResponseMsg = (IMUserListHttpResponseMsg) httpResponsedMessage;
            if (this.a.b != null && !ListUtils.isEmpty(this.a.b.getData()) && (hashMap = iMUserListHttpResponseMsg.changedList) != null && !hashMap.isEmpty()) {
                for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.a.b.getData()) {
                    if (imMessageCenterShowItemData != null && iMUserListHttpResponseMsg.changedList.containsKey(imMessageCenterShowItemData.getFriendId()) && (imMessageCenterPojo = iMUserListHttpResponseMsg.changedList.get(imMessageCenterShowItemData.getFriendId())) != null) {
                        imMessageCenterShowItemData.setFriendNameShow(imMessageCenterPojo.getNameShow());
                        imMessageCenterShowItemData.setRelation(imMessageCenterPojo.getIsFriend());
                        imMessageCenterShowItemData.setUserExtraData(imMessageCenterPojo.getImUserExtraData());
                    }
                }
                this.a.L1();
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

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            registerListener(2016004, this.g);
            registerListener(2016007, this.g);
            registerListener(2016001, this.g);
            registerListener(2016011, this.g);
            registerListener(2016002, this.g);
            registerListener(this.j);
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            H1();
            if (this.d == null) {
                this.d = nf8.l().o(getPageContext().getPageActivity());
            }
            this.d.show();
            this.d.b(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            ft8 ft8Var = this.a;
            if (ft8Var != null && ft8Var.C() != null) {
                this.a.C().notifyDataSetChanged();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.STRANGE_MERGE, -7)));
        }
    }

    public final void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.a.I().setVisibility(0);
            this.a.D().setVisibility(8);
            this.a.G().setVisibility(8);
            this.a.E().setVisibility(4);
        }
    }

    public final void K1(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, strangerListActivity) == null) {
            this.a = new ft8(strangerListActivity);
        }
    }

    public final void N1(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    public final void O1(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            return;
        }
        ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
        List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
        if (responsedMemoryListMessage.getType() == 3 && (strangerListModel = this.b) != null) {
            strangerListModel.setData(data, this.h);
        }
    }

    public void U1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.b.updateEditStatus(z);
            this.a.N(this.b.getData());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        ft8 ft8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && (ft8Var = this.a) != null) {
            ft8Var.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onCreate(bundle);
            this.c = this;
            K1(this);
            initData();
            P1();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.deleteSelectedDatas(this.i);
        }
    }

    public void G1() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (alertDialog = this.e) != null && alertDialog.isShowing()) {
            this.e.dismiss();
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a55 a55Var = this.d;
            if (a55Var != null && a55Var.isShowing()) {
                this.d.dismiss();
                this.d = null;
            }
            closeLoadingDialog();
            dismissAllDialog();
        }
    }

    public boolean I1() {
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

    public boolean J1() {
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

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b = new StrangerListModel(getPageContext());
        }
    }

    public final void notifyDataSetChanged() {
        ft8 ft8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (ft8Var = this.a) != null && ft8Var.C() != null) {
            this.a.C().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            H1();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onRestart();
            ChatStatusManager.getInst().setIsOpen(5, true);
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

    public final void L1() {
        ft8 ft8Var;
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ft8Var = this.a) != null && ft8Var.C() != null && (strangerListModel = this.b) != null) {
            if (strangerListModel != null && strangerListModel.isEmpty()) {
                showNoDataView();
            }
            this.a.H().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0762));
            this.a.H().getCenterImgBox().setVisibility(4);
            if (!this.b.isEmpty()) {
                this.a.E().setVisibility(0);
                this.a.J().setVisibility(0);
            }
            this.a.C().u(this.b.getData());
        }
    }

    public final void M1(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof MemoryChangedMessage)) {
            return;
        }
        MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
        ImMessageCenterPojo data = memoryChangedMessage.getData();
        if (memoryChangedMessage.getType() == 1) {
            StrangerListModel strangerListModel2 = this.b;
            if (strangerListModel2 != null) {
                strangerListModel2.insertOrUpdate(data, this.h);
            }
        } else if (memoryChangedMessage.getType() == 2 && (strangerListModel = this.b) != null) {
            strangerListModel.remove(data, this.h);
        }
    }

    public void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            List<ImMessageCenterShowItemData> data = this.b.getData();
            for (int i = 0; i != data.size(); i++) {
                try {
                    MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 2)));
                    data.get(i).setUnReadCount(0);
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            this.a.N(this.b.getData());
        }
    }

    public void S1(boolean z) {
        int i;
        int i2;
        int i3;
        TBAlertConfig.OperateBtnStyle operateBtnStyle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            G1();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            this.f = z;
            if (z) {
                i = R.string.obfuscated_res_0x7f0f16cd;
                i2 = R.string.obfuscated_res_0x7f0f14b3;
                i3 = R.string.unfriend_del;
            } else {
                i = R.string.obfuscated_res_0x7f0f16ce;
                i2 = R.string.obfuscated_res_0x7f0f14b6;
                i3 = R.string.unfriend_all_read;
            }
            if (z) {
                operateBtnStyle = TBAlertConfig.OperateBtnStyle.ALERT;
            } else {
                operateBtnStyle = TBAlertConfig.OperateBtnStyle.MAIN;
            }
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig(i3, operateBtnStyle);
            TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.unfriend_cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            this.e = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity()).setTitle(i).setDesc(i2).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
            operateBtnConfig.setListener(new e(this));
            operateBtnConfig2.setListener(new f(this));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.a.E()) {
                this.a.O(true);
                this.a.E().setVisibility(4);
                this.a.J().setVisibility(4);
                this.a.H().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0761));
                this.a.H().getCenterImgBox().setVisibility(4);
            } else if (view2 == this.a.J()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ONE_KEY_READ).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (I1()) {
                    R1();
                } else {
                    new BdTopToast(this.c).setIcon(false).setContent(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f16cc)).show((ViewGroup) findViewById(16908290));
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        ft8 ft8Var;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048597, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || (ft8Var = this.a) == null || ft8Var.C() == null || (item = this.a.C().getItem(i)) == null) {
            return;
        }
        int i2 = 1;
        if (this.a.C().c()) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.select_status);
            if (item.isSelected()) {
                item.setSelected(false);
                WebPManager.setPureDrawable(imageView, R.drawable.btn_bgb_choice_n_new, R.color.CAM_X0111, null);
                if (!J1()) {
                    this.a.Q(false);
                    return;
                }
                return;
            }
            item.setSelected(true);
            WebPManager.setPureDrawable(imageView, R.drawable.btn_bgb_choice_s_new, R.color.CAM_X0302, null);
            this.a.P(true);
            return;
        }
        PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.c.getPageContext().getContext(), JavaTypesHelper.toLong(item.getFriendId(), 0L), item.getFriendName(), item.getFriendNameShow(), item.getFriendPortrait(), 0, 0);
        personalChatActivityConfig.setFrom(4);
        personalChatActivityConfig.setFollowStatus(0);
        sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        if (item.getRelation() != 3) {
            i2 = 2;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.FRIEND_UID, item.getFriendId()).param("obj_param1", item.getUnReadCount()).param("obj_type", i2));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        ft8 ft8Var;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.a.F() || (ft8Var = this.a) == null || ft8Var.C() == null || (item = this.a.C().getItem(i)) == null) {
                return false;
            }
            int size = this.b.getData().size();
            g55 g55Var = new g55(getPageContext());
            g55Var.i(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_user_chat)}, new a(this, g55Var, size, item));
            g55Var.l();
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
