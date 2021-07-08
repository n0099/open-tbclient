package com.baidu.tieba.im.validate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.RequestAddGroupUserMessage;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.ValidateModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.o0.r.s.b;
import d.a.o0.z0.n;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ValidateActivity extends BaseActivity<ValidateActivity> implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.o0.r.s.b deleteItemDialog;
    public n<LinkedList<GroupNewsPojo>> getDataCallBack;
    public n<Integer> getDataCountCallBack;
    public boolean isLoading;
    public boolean isWaitNetResponse;
    public CustomMessageListener mCustomListener;
    public d.a.c.c.g.c mListener;
    public int offset;
    public ValidateItemData pendingToDel;
    public int perCount;
    public int totalCount;
    public n<Boolean> updateDataCallBack;
    public d.a.p0.i1.x.c valiateView;

    /* loaded from: classes4.dex */
    public class a implements n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f17671a;

        public a(ValidateActivity validateActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validateActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17671a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || this.f17671a.isWaitNetResponse) {
                return;
            }
            this.f17671a.valiateView.j(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<LinkedList<GroupNewsPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f17672a;

        public b(ValidateActivity validateActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validateActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17672a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedList) == null) {
                this.f17672a.valiateView.h(ValidateModel.convertToValidateItemDataList(linkedList));
                if (linkedList != null) {
                    this.f17672a.offset += linkedList.size();
                }
                if (!this.f17672a.isWaitNetResponse) {
                    this.f17672a.valiateView.j(false);
                }
                this.f17672a.isLoading = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements n<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f17673a;

        public c(ValidateActivity validateActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validateActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17673a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.f17673a.totalCount = num.intValue();
                if (this.f17673a.totalCount > 0) {
                    this.f17673a.isLoading = true;
                    ValidateModel.requestValidateDataFromDB(this.f17673a.perCount, this.f17673a.offset, this.f17673a.getDataCallBack);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f17674a;

        public d(ValidateActivity validateActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validateActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17674a = validateActivity;
        }

        @Override // d.a.o0.r.s.b.c
        public void a(d.a.o0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                bVar.e();
                if (i2 != 0) {
                    return;
                }
                this.f17674a.valiateView.j(true);
                ValidateActivity validateActivity = this.f17674a;
                validateActivity.processDel(validateActivity.pendingToDel);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f17675a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ValidateActivity validateActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validateActivity, Integer.valueOf(i2)};
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
            this.f17675a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f17675a.valiateView.j(false);
                this.f17675a.isWaitNetResponse = false;
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
                    int cmd = socketResponsedMessage.getCmd();
                    if (cmd == 103111) {
                        RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                        if (socketResponsedMessage.getError() == 0) {
                            ValidateItemData byNoticeId = this.f17675a.getByNoticeId(requestAddGroupUserMessage.getNotice_id());
                            if (byNoticeId != null) {
                                byNoticeId.setPass(true);
                                byNoticeId.setShown(true);
                                ValidateModel.updateValidateData(this.f17675a.updateDataCallBack, byNoticeId);
                                if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                                    this.f17675a.showToast(R.string.validate_succ);
                                } else {
                                    this.f17675a.showToast(socketResponsedMessage.getErrorString());
                                }
                                this.f17675a.valiateView.f().notifyDataSetChanged();
                            }
                        } else if (requestAddGroupUserMessage != null) {
                            socketResponsedMessage.getError();
                            String errorString = socketResponsedMessage.getErrorString();
                            if (TextUtils.isEmpty(errorString)) {
                                this.f17675a.showToast(R.string.validate_fail);
                            } else {
                                this.f17675a.showToast(errorString);
                            }
                            ValidateItemData byNoticeId2 = this.f17675a.getByNoticeId(requestAddGroupUserMessage.getNotice_id());
                            if (byNoticeId2 != null) {
                                byNoticeId2.setPass(false);
                                byNoticeId2.setShown(true);
                                ValidateModel.updateValidateData(this.f17675a.updateDataCallBack, byNoticeId2);
                                this.f17675a.valiateView.f().notifyDataSetChanged();
                            }
                        }
                    } else if (202004 == cmd) {
                        ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                        RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                        if (responseDelSystemMessage.getError() != 0) {
                            return;
                        }
                        ValidateModel.deleteValidateData(this.f17675a.pendingToDel, this.f17675a.updateDataCallBack);
                        this.f17675a.offset--;
                        this.f17675a.totalCount--;
                        d.a.p0.i1.x.a f2 = this.f17675a.valiateView.f();
                        f2.b().remove(this.f17675a.pendingToDel);
                        ImMessageCenterPojo imMessageCenterPojo = null;
                        if (f2.b().size() > 0) {
                            imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setLast_content(f2.b().get(0).getUserName() + TbadkApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + f2.b().get(0).getGroupName());
                            imMessageCenterPojo.setLast_content_time(f2.b().get(0).getApplyTime());
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001211, imMessageCenterPojo));
                        f2.notifyDataSetChanged();
                        if (f2 == null || f2.b() == null || f2.b().size() != 0) {
                            return;
                        }
                        this.f17675a.finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f17676a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ValidateActivity validateActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {validateActivity, Integer.valueOf(i2)};
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
            this.f17676a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof PushMessage)) {
                GroupNewsPojo p = ((PushMessage) customResponsedMessage).getP();
                this.f17676a.offset++;
                this.f17676a.totalCount++;
                this.f17676a.valiateView.f().b().add(0, ValidateModel.convertToValidateItemData(p));
                this.f17676a.valiateView.f().notifyDataSetChanged();
            }
        }
    }

    public ValidateActivity() {
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
        this.isWaitNetResponse = false;
        this.perCount = 20;
        this.mListener = new e(this, 0);
        this.mCustomListener = new f(this, 2001125);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData getByNoticeId(String str) {
        InterceptResult invokeL;
        List<ValidateItemData> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            if (str != null && (b2 = this.valiateView.f().b()) != null) {
                for (ValidateItemData validateItemData : b2) {
                    if (str.equals(validateItemData.getNotice_id())) {
                        return validateItemData;
                    }
                }
            }
            return null;
        }
        return (ValidateItemData) invokeL.objValue;
    }

    private void initDataCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.updateDataCallBack = new a(this);
            this.getDataCallBack = new b(this);
            this.getDataCountCallBack = new c(this);
            registerListener(103111, this.mListener);
            registerListener(202004, this.mListener);
            registerListener(this.mCustomListener);
            this.valiateView.j(true);
            ValidateModel.requestValidateDataCountFromDB(this.getDataCountCallBack);
        }
    }

    private void initDeleteDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            String string = getPageContext().getString(R.string.delete_user_chat);
            d dVar = new d(this);
            d.a.o0.r.s.b bVar = new d.a.o0.r.s.b(getPageContext().getPageActivity());
            this.deleteItemDialog = bVar;
            bVar.k(R.string.operation);
            this.deleteItemDialog.j(new String[]{string}, dVar);
            this.deleteItemDialog.c(getPageContext());
        }
    }

    private void onHeadClick(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, validateItemData) == null) || validateItemData == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
    }

    private void onValidateBtnClick(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, validateItemData) == null) {
            if (!j.z()) {
                showToast(R.string.neterror);
            } else if (validateItemData == null || validateItemData.isPass() || this.isWaitNetResponse) {
            } else {
                try {
                    validateItemData.setShown(true);
                    this.valiateView.j(true);
                    RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                    requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                    requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                    requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                    requestAddGroupUserMessage.setGroupId(d.a.c.e.m.b.f(validateItemData.getGroupId(), 0L));
                    requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                    String notice_id = validateItemData.getNotice_id();
                    String c2 = d.a.p0.i1.p.b.b().c();
                    if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(c2) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(c2)) {
                        requestAddGroupUserMessage.setSysGroupId(d.a.c.e.m.b.d(c2, 0));
                        requestAddGroupUserMessage.setSysMsgId(String.valueOf(d.a.c.e.m.b.f(notice_id, 0L) / 100));
                        requestAddGroupUserMessage.setDecision(1);
                        this.isWaitNetResponse = true;
                        MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDel(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, validateItemData) == null) {
            if (!j.z()) {
                showToast(R.string.neterror);
            } else if (validateItemData == null) {
            } else {
                long f2 = d.a.c.e.m.b.f(d.a.p0.i1.p.b.b().c(), 0L);
                if (f2 == 0) {
                    return;
                }
                this.valiateView.j(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(f2);
                long parseLong = Long.parseLong(validateItemData.getNotice_id());
                requestDelSystemMessage.setMsgIds("" + (parseLong / 100));
                this.isWaitNetResponse = true;
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    public static void startActivity(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, context) == null) || context == null) {
            return;
        }
        context.startActivity(new Intent(context, ValidateActivity.class));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.p0.i1.x.c cVar = this.valiateView;
            if (cVar != null) {
                cVar.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.p0.i1.x.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || (cVar = this.valiateView) == null || !view.equals(cVar.e())) {
            return;
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.valiateView = new d.a.p0.i1.x.c(this);
            initDataCallBack();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            d.a.p0.i1.x.c cVar = this.valiateView;
            if (cVar != null) {
                cVar.destroy();
            }
            this.pendingToDel = null;
        }
    }

    public void onItemViewClick(View view, int i2, int i3, long j, ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), validateItemData}) == null) || validateItemData == null) {
            return;
        }
        if (100 == i2) {
            onValidateBtnClick(validateItemData);
        } else if (101 == i2) {
            onHeadClick(validateItemData);
        }
    }

    public void onItemViewLongClick(View view, int i2, int i3, long j, ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), validateItemData}) == null) || view == null || validateItemData == null || 200 != i2) {
            return;
        }
        this.pendingToDel = validateItemData;
        if (this.deleteItemDialog == null) {
            initDeleteDialog();
        }
        this.deleteItemDialog.m();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onRestart();
            ChatStatusManager.getInst().setIsOpen(7, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            d.a.o0.s.d.b.g0().f(1);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.GROUP_VALIDATION, -4)));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.isLoading || (i2 = this.offset) >= this.totalCount) {
            return;
        }
        this.isLoading = true;
        ValidateModel.requestValidateDataFromDB(this.perCount, i2, this.getDataCallBack);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onStart();
            ChatStatusManager.getInst().setIsOpen(7, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        d.a.p0.i1.x.a f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
            ChatStatusManager.getInst().setIsOpen(7, false);
            d.a.p0.i1.x.c cVar = this.valiateView;
            if (cVar == null || (f2 = cVar.f()) == null) {
                return;
            }
            ValidateModel.markShown(f2.b());
        }
    }
}
