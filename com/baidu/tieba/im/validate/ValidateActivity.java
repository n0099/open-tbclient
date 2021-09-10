package com.baidu.tieba.im.validate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.q0.d1.o;
import c.a.q0.s.s.b;
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
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class ValidateActivity extends BaseActivity<ValidateActivity> implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.q0.s.s.b deleteItemDialog;
    public o<LinkedList<GroupNewsPojo>> getDataCallBack;
    public o<Integer> getDataCountCallBack;
    public boolean isLoading;
    public boolean isWaitNetResponse;
    public CustomMessageListener mCustomListener;
    public c.a.e.c.g.c mListener;
    public int offset;
    public ValidateItemData pendingToDel;
    public int perCount;
    public int totalCount;
    public o<Boolean> updateDataCallBack;
    public c.a.r0.k1.x.c valiateView;

    /* loaded from: classes7.dex */
    public class a implements o<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f53258a;

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
            this.f53258a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.o
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || this.f53258a.isWaitNetResponse) {
                return;
            }
            this.f53258a.valiateView.h(false);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements o<LinkedList<GroupNewsPojo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f53259a;

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
            this.f53259a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.o
        /* renamed from: a */
        public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, linkedList) == null) {
                this.f53259a.valiateView.g(ValidateModel.convertToValidateItemDataList(linkedList));
                if (linkedList != null) {
                    this.f53259a.offset += linkedList.size();
                }
                if (!this.f53259a.isWaitNetResponse) {
                    this.f53259a.valiateView.h(false);
                }
                this.f53259a.isLoading = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements o<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f53260a;

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
            this.f53260a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.o
        /* renamed from: a */
        public void onReturnDataInUI(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.f53260a.totalCount = num.intValue();
                if (this.f53260a.totalCount > 0) {
                    this.f53260a.isLoading = true;
                    ValidateModel.requestValidateDataFromDB(this.f53260a.perCount, this.f53260a.offset, this.f53260a.getDataCallBack);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f53261a;

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
            this.f53261a = validateActivity;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                bVar.e();
                if (i2 != 0) {
                    return;
                }
                this.f53261a.valiateView.h(true);
                ValidateActivity validateActivity = this.f53261a;
                validateActivity.processDel(validateActivity.pendingToDel);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f53262a;

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
            this.f53262a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f53262a.valiateView.h(false);
                this.f53262a.isWaitNetResponse = false;
                if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
                    int cmd = socketResponsedMessage.getCmd();
                    if (cmd == 103111) {
                        RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                        if (socketResponsedMessage.getError() == 0) {
                            ValidateItemData byNoticeId = this.f53262a.getByNoticeId(requestAddGroupUserMessage.getNotice_id());
                            if (byNoticeId != null) {
                                byNoticeId.setPass(true);
                                byNoticeId.setShown(true);
                                ValidateModel.updateValidateData(this.f53262a.updateDataCallBack, byNoticeId);
                                if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                                    this.f53262a.showToast(R.string.validate_succ);
                                } else {
                                    this.f53262a.showToast(socketResponsedMessage.getErrorString());
                                }
                                this.f53262a.valiateView.e().notifyDataSetChanged();
                            }
                        } else if (requestAddGroupUserMessage != null) {
                            socketResponsedMessage.getError();
                            String errorString = socketResponsedMessage.getErrorString();
                            if (TextUtils.isEmpty(errorString)) {
                                this.f53262a.showToast(R.string.validate_fail);
                            } else {
                                this.f53262a.showToast(errorString);
                            }
                            ValidateItemData byNoticeId2 = this.f53262a.getByNoticeId(requestAddGroupUserMessage.getNotice_id());
                            if (byNoticeId2 != null) {
                                byNoticeId2.setPass(false);
                                byNoticeId2.setShown(true);
                                ValidateModel.updateValidateData(this.f53262a.updateDataCallBack, byNoticeId2);
                                this.f53262a.valiateView.e().notifyDataSetChanged();
                            }
                        }
                    } else if (202004 == cmd) {
                        ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                        RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                        if (responseDelSystemMessage.getError() != 0) {
                            return;
                        }
                        ValidateModel.deleteValidateData(this.f53262a.pendingToDel, this.f53262a.updateDataCallBack);
                        this.f53262a.offset--;
                        this.f53262a.totalCount--;
                        c.a.r0.k1.x.a e2 = this.f53262a.valiateView.e();
                        e2.b().remove(this.f53262a.pendingToDel);
                        ImMessageCenterPojo imMessageCenterPojo = null;
                        if (e2.b().size() > 0) {
                            imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setLast_content(e2.b().get(0).getUserName() + TbadkApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + e2.b().get(0).getGroupName());
                            imMessageCenterPojo.setLast_content_time(e2.b().get(0).getApplyTime());
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001211, imMessageCenterPojo));
                        e2.notifyDataSetChanged();
                        if (e2 == null || e2.b() == null || e2.b().size() != 0) {
                            return;
                        }
                        this.f53262a.finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ValidateActivity f53263a;

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
            this.f53263a = validateActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof PushMessage)) {
                GroupNewsPojo p = ((PushMessage) customResponsedMessage).getP();
                this.f53263a.offset++;
                this.f53263a.totalCount++;
                this.f53263a.valiateView.e().b().add(0, ValidateModel.convertToValidateItemData(p));
                this.f53263a.valiateView.e().notifyDataSetChanged();
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
            if (str != null && (b2 = this.valiateView.e().b()) != null) {
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
            this.valiateView.h(true);
            ValidateModel.requestValidateDataCountFromDB(this.getDataCountCallBack);
        }
    }

    private void initDeleteDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            String string = getPageContext().getString(R.string.delete_user_chat);
            d dVar = new d(this);
            c.a.q0.s.s.b bVar = new c.a.q0.s.s.b(getPageContext().getPageActivity());
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
                    this.valiateView.h(true);
                    RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                    requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                    requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                    requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                    requestAddGroupUserMessage.setGroupId(c.a.e.e.m.b.g(validateItemData.getGroupId(), 0L));
                    requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                    String notice_id = validateItemData.getNotice_id();
                    String c2 = c.a.r0.k1.p.b.b().c();
                    if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(c2) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(c2)) {
                        requestAddGroupUserMessage.setSysGroupId(c.a.e.e.m.b.e(c2, 0));
                        requestAddGroupUserMessage.setSysMsgId(String.valueOf(c.a.e.e.m.b.g(notice_id, 0L) / 100));
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
                long g2 = c.a.e.e.m.b.g(c.a.r0.k1.p.b.b().c(), 0L);
                if (g2 == 0) {
                    return;
                }
                this.valiateView.h(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(g2);
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
            c.a.r0.k1.x.c cVar = this.valiateView;
            if (cVar != null) {
                cVar.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.k1.x.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null || (cVar = this.valiateView) == null || !view.equals(cVar.d())) {
            return;
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.valiateView = new c.a.r0.k1.x.c(this);
            initDataCallBack();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            c.a.r0.k1.x.c cVar = this.valiateView;
            if (cVar != null) {
                cVar.destroy();
            }
            this.pendingToDel = null;
        }
    }

    public void onItemViewClick(View view, int i2, int i3, long j2, ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), validateItemData}) == null) || validateItemData == null) {
            return;
        }
        if (100 == i2) {
            onValidateBtnClick(validateItemData);
        } else if (101 == i2) {
            onHeadClick(validateItemData);
        }
    }

    public void onItemViewLongClick(View view, int i2, int i3, long j2, ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), validateItemData}) == null) || view == null || validateItemData == null || 200 != i2) {
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
            c.a.q0.t.d.b.g0().f(1);
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
        c.a.r0.k1.x.a e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onStop();
            ChatStatusManager.getInst().setIsOpen(7, false);
            c.a.r0.k1.x.c cVar = this.valiateView;
            if (cVar == null || (e2 = cVar.e()) == null) {
                return;
            }
            ValidateModel.markShown(e2.b());
        }
    }
}
