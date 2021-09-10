package com.baidu.tieba.imMessageCenter.im.stranger;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.a;
import c.a.q0.s.s.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.BdProgressDialog1080;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class StrangerListActivity extends BaseActivity<StrangerListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.k1.f.i.b IProcessImpl;
    public StrangerListActivity mActivity;
    public a.e mCancelClickListener;
    public c.a.r0.k1.f.i.a mCompleteProcess;
    public a.e mDelAllClickListener;
    public c.a.q0.s.s.a mDelAllDialog;
    public final CustomMessageListener mMemoryListener;
    public StrangerListModel mModel;
    public BdProgressDialog1080 mProgressDialog;
    public c.a.r0.l1.a.e.b mView;

    /* loaded from: classes7.dex */
    public class a implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f53481e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f53482f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f53483g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ StrangerListActivity f53484h;

        public a(StrangerListActivity strangerListActivity, PopupDialog popupDialog, int i2, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity, popupDialog, Integer.valueOf(i2), imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53484h = strangerListActivity;
            this.f53481e = popupDialog;
            this.f53482f = i2;
            this.f53483g = imMessageCenterShowItemData;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                PopupDialog popupDialog = this.f53481e;
                if (popupDialog != null && popupDialog.isShowing()) {
                    this.f53481e.dismiss();
                }
                if (this.f53482f == 1) {
                    this.f53484h.mModel.w(this.f53484h.IProcessImpl);
                } else {
                    this.f53484h.mModel.asyncDeleteItem(this.f53483g, this.f53484h.IProcessImpl);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StrangerListActivity f53485e;

        public b(StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53485e = strangerListActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f53485e.mDelAllDialog.dismiss();
                this.f53485e.mModel.w(this.f53485e.IProcessImpl);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ StrangerListActivity f53486e;

        public c(StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53486e = strangerListActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f53486e.mDelAllDialog.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StrangerListActivity f53487a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(StrangerListActivity strangerListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53487a = strangerListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.f53487a.processMemoryInitComplete(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.f53487a.processMemoryChanged(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.f53487a.processResponsedMemoryList(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.f53487a.mModel.setData(null, this.f53487a.mCompleteProcess);
            } else if (customResponsedMessage.getCmd() != 2016011 || this.f53487a.mView == null || this.f53487a.mView.c() == null) {
            } else {
                this.f53487a.mView.c().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements c.a.r0.k1.f.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StrangerListActivity f53488a;

        public e(StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53488a = strangerListActivity;
        }

        @Override // c.a.r0.k1.f.i.a
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53488a.onCompleteProcess();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements c.a.r0.k1.f.i.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ StrangerListActivity f53489a;

        public f(StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53489a = strangerListActivity;
        }

        @Override // c.a.r0.k1.f.i.b
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53489a.dismissDialog();
                this.f53489a.onCompleteProcess();
            }
        }

        @Override // c.a.r0.k1.f.i.b
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f53489a.dismissDialog();
                this.f53489a.showToast(R.string.delete_success, false);
                this.f53489a.onCompleteProcess();
            }
        }

        @Override // c.a.r0.k1.f.i.b
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f53489a.showProgressDialog();
            }
        }

        @Override // c.a.r0.k1.f.i.b
        public void onProgressUpdate(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                if (this.f53489a.mProgressDialog != null) {
                    this.f53489a.mProgressDialog.setPercent(i2);
                }
                this.f53489a.notifyDataSetChanged();
            }
        }
    }

    public StrangerListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDelAllClickListener = new b(this);
        this.mCancelClickListener = new c(this);
        this.mMemoryListener = new d(this, 0);
        this.mCompleteProcess = new e(this);
        this.IProcessImpl = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            BdProgressDialog1080 bdProgressDialog1080 = this.mProgressDialog;
            if (bdProgressDialog1080 != null && bdProgressDialog1080.isShowing()) {
                this.mProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
            closeLoadingDialog();
            dismissAllDialog();
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.mModel = new StrangerListModel(getPageContext());
        }
    }

    private void initUI(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, strangerListActivity) == null) {
            this.mView = new c.a.r0.l1.a.e.b(strangerListActivity);
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(strangerListActivity.getPageContext().getPageActivity());
            this.mDelAllDialog = aVar;
            aVar.setMessageId(R.string.sure_to_delete_all_stranger_msg);
            this.mDelAllDialog.setPositiveButton(R.string.confirm, this.mDelAllClickListener);
            this.mDelAllDialog.setNegativeButton(R.string.cancel, this.mCancelClickListener);
            this.mDelAllDialog.create(strangerListActivity.getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        c.a.r0.l1.a.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || (bVar = this.mView) == null || bVar.c() == null) {
            return;
        }
        this.mView.c().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteProcess() {
        c.a.r0.l1.a.e.b bVar;
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (bVar = this.mView) == null || bVar.c() == null || (strangerListModel = this.mModel) == null) {
            return;
        }
        if (strangerListModel != null && strangerListModel.isEmpty()) {
            finish();
        }
        this.mView.c().n(this.mModel.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMemoryChanged(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
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
        if ((interceptable == null || interceptable.invokeL(65556, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResponsedMemoryList(CustomResponsedMessage<?> customResponsedMessage) {
        StrangerListModel strangerListModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65557, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
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
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            registerListener(2016004, this.mMemoryListener);
            registerListener(2016007, this.mMemoryListener);
            registerListener(2016001, this.mMemoryListener);
            registerListener(2016011, this.mMemoryListener);
            registerListener(2016002, this.mMemoryListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            dismissDialog();
            if (this.mProgressDialog == null) {
                this.mProgressDialog = c.a.r0.k1.h.e.m().p(getPageContext().getPageActivity());
            }
            this.mProgressDialog.show();
            this.mProgressDialog.setPercent(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        c.a.r0.l1.a.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (bVar = this.mView) == null) {
            return;
        }
        bVar.onChangeSkinType(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.q0.s.s.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.onClick(view);
            if (view != this.mView.d() || (aVar = this.mDelAllDialog) == null) {
                return;
            }
            aVar.show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.mActivity = this;
            initUI(this);
            initData();
            registerListener();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            dismissDialog();
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        c.a.r0.l1.a.e.b bVar;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (bVar = this.mView) == null || bVar.c() == null || (item = this.mView.c().getItem(i2)) == null) {
            return;
        }
        PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mActivity.getPageContext().getContext(), c.a.e.e.m.b.g(item.getFriendId(), 0L), item.getFriendName(), item.getFriendNameShow(), item.getFriendPortrait(), 0, 0);
        personalChatActivityConfig.setFollowStatus(0);
        sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        InterceptResult invokeCommon;
        ImMessageCenterShowItemData item;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            c.a.r0.l1.a.e.b bVar = this.mView;
            if (bVar == null || bVar.c() == null || (item = this.mView.c().getItem(i2)) == null) {
                return false;
            }
            int size = this.mModel.getData().size();
            PopupDialog popupDialog = new PopupDialog(getPageContext());
            popupDialog.setDefaultContentView(null, new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_user_chat)}, new a(this, popupDialog, size, item));
            popupDialog.showDialog();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onRestart();
            ChatStatusManager.getInst().setIsOpen(5, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            c.a.r0.l1.a.e.b bVar = this.mView;
            if (bVar != null && bVar.c() != null) {
                this.mView.c().notifyDataSetChanged();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.STRANGE_MERGE, -7)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStart();
            ChatStatusManager.getInst().setIsOpen(5, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onStop();
            ChatStatusManager.getInst().setIsOpen(5, false);
        }
    }
}
