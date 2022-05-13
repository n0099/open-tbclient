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
import com.repackage.bs4;
import com.repackage.ea7;
import com.repackage.kg;
import com.repackage.qr4;
import com.repackage.r47;
import com.repackage.s47;
import com.repackage.u57;
import com.repackage.wr4;
import com.repackage.yr4;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s47 IProcessImpl;
    public boolean isDelDialog;
    public StrangerListActivity mActivity;
    public AlertDialog mBlockThreadDialog;
    public r47 mCompleteProcess;
    public final CustomMessageListener mMemoryListener;
    public StrangerListModel mModel;
    public qr4 mProgressDialog;
    public ea7 mView;
    public HttpMessageListener userListMessageListener;

    /* loaded from: classes3.dex */
    public class a implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ImMessageCenterShowItemData c;
        public final /* synthetic */ StrangerListActivity d;

        public a(StrangerListActivity strangerListActivity, wr4 wr4Var, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity, wr4Var, Integer.valueOf(i), imMessageCenterShowItemData};
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
            this.a = wr4Var;
            this.b = i;
            this.c = imMessageCenterShowItemData;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                wr4 wr4Var = this.a;
                if (wr4Var != null && wr4Var.isShowing()) {
                    this.a.dismiss();
                }
                if (this.b == 1) {
                    this.d.mModel.y(this.d.IProcessImpl);
                } else {
                    this.d.mModel.asyncDeleteItem(this.c, this.d.IProcessImpl);
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
                this.a.processMemoryInitComplete(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.processMemoryChanged(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.processResponsedMemoryList(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.mModel.setData(null, this.a.mCompleteProcess);
            } else if (customResponsedMessage.getCmd() != 2016011 || this.a.mView == null || this.a.mView.k() == null) {
            } else {
                this.a.mView.k().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements r47 {
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

        @Override // com.repackage.r47
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onCompleteProcess();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements s47 {
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

        @Override // com.repackage.s47
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.dismissDialog();
                this.a.onCompleteProcess();
            }
        }

        @Override // com.repackage.s47
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.dismissDialog();
                this.a.showToast(R.string.obfuscated_res_0x7f0f04ab, false);
                this.a.onCompleteProcess();
            }
        }

        @Override // com.repackage.s47
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.showProgressDialog();
            }
        }

        @Override // com.repackage.s47
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                if (this.a.mProgressDialog != null) {
                    this.a.mProgressDialog.b(i);
                }
                this.a.notifyDataSetChanged();
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
                if (this.a.mBlockThreadDialog != null) {
                    this.a.mBlockThreadDialog.dismiss();
                }
                if (this.a.isDelDialog) {
                    this.a.deleteSelectedDatas();
                }
                this.a.mView.x(false);
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
                if (this.a.mBlockThreadDialog != null) {
                    this.a.mBlockThreadDialog.dismiss();
                }
                this.a.mView.z(false);
                this.a.mView.x(false);
                this.a.mView.q().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f062f));
                this.a.mView.m().setVisibility(0);
                this.a.mView.s().setVisibility(0);
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
                if (this.a.mModel == null || ListUtils.isEmpty(this.a.mModel.getData()) || (hashMap = iMUserListHttpResponseMsg.changedList) == null || hashMap.isEmpty()) {
                    return;
                }
                for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.a.mModel.getData()) {
                    if (imMessageCenterShowItemData != null && iMUserListHttpResponseMsg.changedList.containsKey(imMessageCenterShowItemData.getFriendId()) && (imMessageCenterPojo = iMUserListHttpResponseMsg.changedList.get(imMessageCenterShowItemData.getFriendId())) != null) {
                        imMessageCenterShowItemData.setFriendNameShow(imMessageCenterPojo.getNameShow());
                        imMessageCenterShowItemData.setRelation(imMessageCenterPojo.getIsFriend());
                        imMessageCenterShowItemData.setUserExtraData(imMessageCenterPojo.getImUserExtraData());
                    }
                }
                this.a.onCompleteProcess();
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
        this.mMemoryListener = new b(this, 0);
        this.mCompleteProcess = new c(this);
        this.IProcessImpl = new d(this);
        this.userListMessageListener = new g(this, CmdConfigHttp.CMD_GET_USER_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            qr4 qr4Var = this.mProgressDialog;
            if (qr4Var != null && qr4Var.isShowing()) {
                this.mProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
            closeLoadingDialog();
            dismissAllDialog();
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.mModel = new StrangerListModel(getPageContext());
        }
    }

    private void initUI(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, strangerListActivity) == null) {
            this.mView = new ea7(strangerListActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        ea7 ea7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (ea7Var = this.mView) == null || ea7Var.k() == null) {
            return;
        }
        this.mView.k().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteProcess() {
        ea7 ea7Var;
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (ea7Var = this.mView) == null || ea7Var.k() == null || (strangerListModel = this.mModel) == null) {
            return;
        }
        if (strangerListModel != null && strangerListModel.isEmpty()) {
            showNoDataView();
        }
        this.mView.q().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f062f));
        this.mView.q().getCenterImgBox().setVisibility(4);
        if (!this.mModel.isEmpty()) {
            this.mView.m().setVisibility(0);
            this.mView.s().setVisibility(0);
        }
        this.mView.k().r(this.mModel.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMemoryChanged(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65556, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                StrangerListModel strangerListModel2 = this.mModel;
                if (strangerListModel2 != null) {
                    strangerListModel2.insertOrUpdate(data, this.mCompleteProcess);
                }
            } else if (memoryChangedMessage.getType() != 2 || (strangerListModel = this.mModel) == null) {
            } else {
                strangerListModel.remove(data, this.mCompleteProcess);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMemoryInitComplete(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResponsedMemoryList(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 3 || (strangerListModel = this.mModel) == null) {
                return;
            }
            strangerListModel.setData(data, this.mCompleteProcess);
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            registerListener(2016004, this.mMemoryListener);
            registerListener(2016007, this.mMemoryListener);
            registerListener(2016001, this.mMemoryListener);
            registerListener(2016011, this.mMemoryListener);
            registerListener(2016002, this.mMemoryListener);
            registerListener(this.userListMessageListener);
        }
    }

    private void showNoDataView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.mView.r().setVisibility(0);
            this.mView.l().setVisibility(8);
            this.mView.o().setVisibility(8);
            this.mView.m().setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            dismissDialog();
            if (this.mProgressDialog == null) {
                this.mProgressDialog = u57.m().p(getPageContext().getPageActivity());
            }
            this.mProgressDialog.show();
            this.mProgressDialog.b(0);
        }
    }

    public void deleteSelectedDatas() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mModel.deleteSelectedDatas(this.IProcessImpl);
        }
    }

    public void dismissBlockDialog() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (alertDialog = this.mBlockThreadDialog) != null && alertDialog.isShowing()) {
            this.mBlockThreadDialog.dismiss();
        }
    }

    public boolean hasNoRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ImMessageCenterShowItemData> data = this.mModel.getData();
            for (int i = 0; i != data.size(); i++) {
                if (data.get(i).getUnReadCount() != 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasSelectedData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ImMessageCenterShowItemData> data = this.mModel.getData();
            for (int i = 0; i != data.size(); i++) {
                if (data.get(i).isSelected()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        ea7 ea7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (ea7Var = this.mView) == null) {
            return;
        }
        ea7Var.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.mView.m()) {
                this.mView.x(true);
                this.mView.m().setVisibility(4);
                this.mView.s().setVisibility(4);
                this.mView.q().setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f062e));
                this.mView.q().getCenterImgBox().setVisibility(4);
            } else if (view2 == this.mView.s()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ONE_KEY_READ).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (hasNoRead()) {
                    setAllRead();
                    return;
                }
                BdTopToast bdTopToast = new BdTopToast(this.mActivity);
                bdTopToast.i(false);
                bdTopToast.h(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1419));
                bdTopToast.j((ViewGroup) findViewById(16908290));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.mActivity = this;
            initUI(this);
            initData();
            registerListener();
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            dismissDialog();
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        ea7 ea7Var;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (ea7Var = this.mView) == null || ea7Var.k() == null || (item = this.mView.k().getItem(i)) == null) {
            return;
        }
        if (this.mView.k().c()) {
            ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cc4);
            if (item.isSelected()) {
                item.setSelected(false);
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080352, R.color.CAM_X0111, null);
                if (hasSelectedData()) {
                    return;
                }
                this.mView.z(false);
                return;
            }
            item.setSelected(true);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080354, R.color.CAM_X0302, null);
            this.mView.y(true);
            return;
        }
        PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mActivity.getPageContext().getContext(), kg.g(item.getFriendId(), 0L), item.getFriendName(), item.getFriendNameShow(), item.getFriendPortrait(), 0, 0);
        personalChatActivityConfig.setFollowStatus(0);
        sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_STRANGE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.FRIEND_UID, item.getFriendId()).param("obj_param1", item.getUnReadCount()).param("obj_type", item.getRelation() != 3 ? 2 : 1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
        InterceptResult invokeCommon;
        ea7 ea7Var;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (this.mView.n() || (ea7Var = this.mView) == null || ea7Var.k() == null || (item = this.mView.k().getItem(i)) == null) {
                return false;
            }
            int size = this.mModel.getData().size();
            wr4 wr4Var = new wr4(getPageContext());
            wr4Var.j(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b6)}, new a(this, wr4Var, size, item));
            wr4Var.m();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onRestart();
            ChatStatusManager.getInst().setIsOpen(5, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            ea7 ea7Var = this.mView;
            if (ea7Var != null && ea7Var.k() != null) {
                this.mView.k().notifyDataSetChanged();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.STRANGE_MERGE, -7)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStart();
            ChatStatusManager.getInst().setIsOpen(5, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            ChatStatusManager.getInst().setIsOpen(5, false);
        }
    }

    public void setAllRead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            List<ImMessageCenterShowItemData> data = this.mModel.getData();
            for (int i = 0; i != data.size(); i++) {
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 2)));
                data.get(i).setUnReadCount(0);
            }
            this.mView.w(this.mModel.getData());
        }
    }

    public void showBlockDialog(boolean z) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            dismissBlockDialog();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            this.isDelDialog = z;
            if (z) {
                i = R.string.obfuscated_res_0x7f0f141a;
                i2 = R.string.obfuscated_res_0x7f0f1220;
                i3 = R.string.obfuscated_res_0x7f0f1499;
            } else {
                i = R.string.obfuscated_res_0x7f0f141b;
                i2 = R.string.obfuscated_res_0x7f0f1222;
                i3 = R.string.obfuscated_res_0x7f0f1497;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i3, z ? TBAlertConfig.OperateBtnStyle.ALERT : TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1498, TBAlertConfig.OperateBtnStyle.SECONDARY);
            bs4 bs4Var = new bs4(TbadkCoreApplication.getInst().getCurrentActivity());
            bs4Var.v(i);
            bs4Var.l(i2);
            bs4Var.n(true);
            bs4Var.r(aVar2, aVar);
            bs4Var.i(false);
            this.mBlockThreadDialog = bs4Var.y();
            aVar.a(new e(this));
            aVar2.a(new f(this));
        }
    }

    public void updateEditStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mModel.updateEditStatus(z);
            this.mView.w(this.mModel.getData());
        }
    }
}
