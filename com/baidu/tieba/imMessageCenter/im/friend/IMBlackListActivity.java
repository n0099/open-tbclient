package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import c.a.d.f.p.k;
import c.a.r0.s.t.a;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class IMBlackListActivity extends BaseActivity<IMBlackListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.s.t.a mDialog;
    public c.a.d.c.g.c mListener;
    public BlackListModel mModel;
    public BlackListItemData mNeedRemovedData;
    public c.a.s0.t1.a.c.b mView;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IMBlackListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(IMBlackListActivity iMBlackListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMBlackListActivity, Integer.valueOf(i2)};
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
            this.a = iMBlackListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage;
            Message<?> orginalMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.mView.d();
                this.a.closeLoadingDialog();
                if (socketResponsedMessage == null) {
                    return;
                }
                if (socketResponsedMessage.getCmd() == 104103 && (socketResponsedMessage instanceof ResponseGetMaskInfoMessage)) {
                    ResponseGetMaskInfoMessage responseGetMaskInfoMessage = (ResponseGetMaskInfoMessage) socketResponsedMessage;
                    if (responseGetMaskInfoMessage.getError() == 0) {
                        if (this.a.mDialog != null) {
                            this.a.mDialog.dismiss();
                        }
                        this.a.mView.h(responseGetMaskInfoMessage.getBlackList());
                        return;
                    }
                    this.a.showToast(StringUtils.isNull(responseGetMaskInfoMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : responseGetMaskInfoMessage.getErrorString());
                    if (k.z()) {
                        this.a.mView.g();
                    }
                } else if (socketResponsedMessage.getCmd() == 104102 && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (orginalMessage = (responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage).getOrginalMessage()) != null && (orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 10) {
                    if (responseUpdateMaskInfoMessage.getError() == 0) {
                        if (this.a.mDialog != null) {
                            this.a.mDialog.dismiss();
                        }
                        IMBlackListActivity iMBlackListActivity = this.a;
                        iMBlackListActivity.showToast(iMBlackListActivity.getPageContext().getString(R.string.black_list_remove_success));
                        if (this.a.mNeedRemovedData != null) {
                            this.a.mView.i(this.a.mNeedRemovedData);
                            this.a.mNeedRemovedData = null;
                            return;
                        }
                        return;
                    }
                    this.a.showToast(responseUpdateMaskInfoMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMBlackListActivity f46735e;

        public b(IMBlackListActivity iMBlackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMBlackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46735e = iMBlackListActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f46735e.mModel == null) {
                return;
            }
            this.f46735e.mModel.cancelLoadData();
            this.f46735e.mNeedRemovedData = null;
        }
    }

    /* loaded from: classes12.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMBlackListActivity f46736e;

        public c(IMBlackListActivity iMBlackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMBlackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46736e = iMBlackListActivity;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.show();
                if (this.f46736e.mNeedRemovedData != null) {
                    this.f46736e.showLoadingDialog();
                    this.f46736e.mModel.removeFromBlackList(this.f46736e.mNeedRemovedData.getUserId());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IMBlackListActivity f46737e;

        public d(IMBlackListActivity iMBlackListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iMBlackListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46737e = iMBlackListActivity;
        }

        @Override // c.a.r0.s.t.a.e
        public void onClick(c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public IMBlackListActivity() {
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
        this.mListener = new a(this, 0);
    }

    private void createDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(getPageContext().getPageActivity());
            this.mDialog = aVar;
            aVar.setMessage(str);
            this.mDialog.setPositiveButton(R.string.confirm, new c(this));
            this.mDialog.setNegativeButton(R.string.cancel, new d(this));
            this.mDialog.create(getPageContext());
        }
    }

    private void initModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            BlackListModel blackListModel = new BlackListModel(getPageContext());
            this.mModel = blackListModel;
            blackListModel.setUniqueId(getUniqueId());
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mView = new c.a.s0.t1.a.c.b(this);
        }
    }

    private void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mModel.loadBlackList();
            this.mView.f();
        }
    }

    private void showDialog(BlackListItemData blackListItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, blackListItemData) == null) {
            createDialog(String.format(getPageContext().getString(R.string.black_list_ensure_toremove_text), blackListItemData.x()));
            this.mDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            showLoadingDialog((String) null, new b(this));
        }
    }

    public void handler(View view, BlackListItemData blackListItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, blackListItemData) == null) || blackListItemData == null || blackListItemData.getUserId() <= 0) {
            return;
        }
        this.mNeedRemovedData = blackListItemData;
        showDialog(blackListItemData);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(104103, this.mListener);
            registerListener(104102, this.mListener);
            initView();
            initModel();
            loadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onStop();
            BlackListModel blackListModel = this.mModel;
            if (blackListModel != null) {
                blackListModel.cancelLoadData();
            }
        }
    }
}
