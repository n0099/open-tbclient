package com.baidu.tieba.im.validate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
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
import d.b.b.e.p.j;
import d.b.h0.r.s.b;
import d.b.h0.z0.n;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ValidateActivity extends BaseActivity<ValidateActivity> implements BdListView.p {
    public d.b.h0.r.s.b deleteItemDialog;
    public n<LinkedList<GroupNewsPojo>> getDataCallBack;
    public n<Integer> getDataCountCallBack;
    public boolean isLoading;
    public int offset;
    public ValidateItemData pendingToDel;
    public int totalCount;
    public n<Boolean> updateDataCallBack;
    public d.b.i0.d1.x.c valiateView;
    public boolean isWaitNetResponse = false;
    public int perCount = 20;
    public d.b.b.c.g.c mListener = new e(0);
    public CustomMessageListener mCustomListener = new f(2001125);

    /* loaded from: classes4.dex */
    public class a implements n<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (ValidateActivity.this.isWaitNetResponse) {
                return;
            }
            ValidateActivity.this.valiateView.k(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<LinkedList<GroupNewsPojo>> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
            ValidateActivity.this.valiateView.i(ValidateModel.convertToValidateItemDataList(linkedList));
            if (linkedList != null) {
                ValidateActivity.this.offset += linkedList.size();
            }
            if (!ValidateActivity.this.isWaitNetResponse) {
                ValidateActivity.this.valiateView.k(false);
            }
            ValidateActivity.this.isLoading = false;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements n<Integer> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Integer num) {
            ValidateActivity.this.totalCount = num.intValue();
            if (ValidateActivity.this.totalCount > 0) {
                ValidateActivity.this.isLoading = true;
                ValidateModel.requestValidateDataFromDB(ValidateActivity.this.perCount, ValidateActivity.this.offset, ValidateActivity.this.getDataCallBack);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.c {
        public d() {
        }

        @Override // d.b.h0.r.s.b.c
        public void a(d.b.h0.r.s.b bVar, int i, View view) {
            bVar.e();
            if (i != 0) {
                return;
            }
            ValidateActivity.this.valiateView.k(true);
            ValidateActivity validateActivity = ValidateActivity.this;
            validateActivity.processDel(validateActivity.pendingToDel);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.b.b.c.g.c {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ValidateActivity.this.valiateView.k(false);
            ValidateActivity.this.isWaitNetResponse = false;
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage)) {
                int cmd = socketResponsedMessage.getCmd();
                if (cmd == 103111) {
                    RequestAddGroupUserMessage requestAddGroupUserMessage = (RequestAddGroupUserMessage) socketResponsedMessage.getOrginalMessage();
                    if (socketResponsedMessage.getError() == 0) {
                        ValidateItemData byNoticeId = ValidateActivity.this.getByNoticeId(requestAddGroupUserMessage.getNotice_id());
                        if (byNoticeId != null) {
                            byNoticeId.setPass(true);
                            byNoticeId.setShown(true);
                            ValidateModel.updateValidateData(ValidateActivity.this.updateDataCallBack, byNoticeId);
                            if (TextUtils.isEmpty(socketResponsedMessage.getErrorString())) {
                                ValidateActivity.this.showToast(R.string.validate_succ);
                            } else {
                                ValidateActivity.this.showToast(socketResponsedMessage.getErrorString());
                            }
                            ValidateActivity.this.valiateView.f().notifyDataSetChanged();
                        }
                    } else if (requestAddGroupUserMessage != null) {
                        socketResponsedMessage.getError();
                        String errorString = socketResponsedMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            ValidateActivity.this.showToast(R.string.validate_fail);
                        } else {
                            ValidateActivity.this.showToast(errorString);
                        }
                        ValidateItemData byNoticeId2 = ValidateActivity.this.getByNoticeId(requestAddGroupUserMessage.getNotice_id());
                        if (byNoticeId2 != null) {
                            byNoticeId2.setPass(false);
                            byNoticeId2.setShown(true);
                            ValidateModel.updateValidateData(ValidateActivity.this.updateDataCallBack, byNoticeId2);
                            ValidateActivity.this.valiateView.f().notifyDataSetChanged();
                        }
                    }
                } else if (202004 == cmd) {
                    ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                    RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                    if (responseDelSystemMessage.getError() != 0) {
                        return;
                    }
                    ValidateModel.deleteValidateData(ValidateActivity.this.pendingToDel, ValidateActivity.this.updateDataCallBack);
                    ValidateActivity.this.offset--;
                    ValidateActivity.this.totalCount--;
                    d.b.i0.d1.x.a f2 = ValidateActivity.this.valiateView.f();
                    f2.b().remove(ValidateActivity.this.pendingToDel);
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
                    ValidateActivity.this.finish();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof PushMessage) {
                GroupNewsPojo p = ((PushMessage) customResponsedMessage).getP();
                ValidateActivity.this.offset++;
                ValidateActivity.this.totalCount++;
                ValidateActivity.this.valiateView.f().b().add(0, ValidateModel.convertToValidateItemData(p));
                ValidateActivity.this.valiateView.f().notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValidateItemData getByNoticeId(String str) {
        List<ValidateItemData> b2;
        if (str != null && (b2 = this.valiateView.f().b()) != null) {
            for (ValidateItemData validateItemData : b2) {
                if (str.equals(validateItemData.getNotice_id())) {
                    return validateItemData;
                }
            }
        }
        return null;
    }

    private void initDataCallBack() {
        this.updateDataCallBack = new a();
        this.getDataCallBack = new b();
        this.getDataCountCallBack = new c();
        registerListener(103111, this.mListener);
        registerListener(202004, this.mListener);
        registerListener(this.mCustomListener);
        this.valiateView.k(true);
        ValidateModel.requestValidateDataCountFromDB(this.getDataCountCallBack);
    }

    private void initDeleteDialog() {
        String string = getPageContext().getString(R.string.delete_user_chat);
        d dVar = new d();
        d.b.h0.r.s.b bVar = new d.b.h0.r.s.b(getPageContext().getPageActivity());
        this.deleteItemDialog = bVar;
        bVar.k(R.string.operation);
        this.deleteItemDialog.j(new String[]{string}, dVar);
        this.deleteItemDialog.c(getPageContext());
    }

    private void onHeadClick(ValidateItemData validateItemData) {
        if (validateItemData == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), validateItemData.getUserId(), validateItemData.getUserName())));
    }

    private void onValidateBtnClick(ValidateItemData validateItemData) {
        if (!j.z()) {
            showToast(R.string.neterror);
        } else if (validateItemData == null || validateItemData.isPass() || this.isWaitNetResponse) {
        } else {
            try {
                validateItemData.setShown(true);
                this.valiateView.k(true);
                RequestAddGroupUserMessage requestAddGroupUserMessage = new RequestAddGroupUserMessage();
                requestAddGroupUserMessage.setInviterUserId(validateItemData.getInviterUserId());
                requestAddGroupUserMessage.setJoinType(validateItemData.getJoinType());
                requestAddGroupUserMessage.setUserIds(validateItemData.getUserId());
                requestAddGroupUserMessage.setGroupId(d.b.b.e.m.b.f(validateItemData.getGroupId(), 0L));
                requestAddGroupUserMessage.setNotice_id(validateItemData.getNotice_id());
                String notice_id = validateItemData.getNotice_id();
                String c2 = d.b.i0.d1.p.b.b().c();
                if (!TextUtils.isEmpty(notice_id) && !TextUtils.isEmpty(c2) && TextUtils.isDigitsOnly(notice_id) && TextUtils.isDigitsOnly(c2)) {
                    requestAddGroupUserMessage.setSysGroupId(d.b.b.e.m.b.d(c2, 0));
                    requestAddGroupUserMessage.setSysMsgId(String.valueOf(d.b.b.e.m.b.f(notice_id, 0L) / 100));
                    requestAddGroupUserMessage.setDecision(1);
                    this.isWaitNetResponse = true;
                    MessageManager.getInstance().sendMessage(requestAddGroupUserMessage);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDel(ValidateItemData validateItemData) {
        if (!j.z()) {
            showToast(R.string.neterror);
        } else if (validateItemData == null) {
        } else {
            long f2 = d.b.b.e.m.b.f(d.b.i0.d1.p.b.b().c(), 0L);
            if (f2 == 0) {
                return;
            }
            this.valiateView.k(true);
            RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
            requestDelSystemMessage.setGroupId(f2);
            long parseLong = Long.parseLong(validateItemData.getNotice_id());
            requestDelSystemMessage.setMsgIds("" + (parseLong / 100));
            this.isWaitNetResponse = true;
            MessageManager.getInstance().sendMessage(requestDelSystemMessage);
        }
    }

    public static void startActivity(Context context) {
        if (context == null) {
            return;
        }
        context.startActivity(new Intent(context, ValidateActivity.class));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.d1.x.c cVar = this.valiateView;
        if (cVar != null) {
            cVar.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.i0.d1.x.c cVar;
        if (view == null || (cVar = this.valiateView) == null || !view.equals(cVar.e())) {
            return;
        }
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.valiateView = new d.b.i0.d1.x.c(this);
        initDataCallBack();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.d1.x.c cVar = this.valiateView;
        if (cVar != null) {
            cVar.destroy();
        }
        this.pendingToDel = null;
    }

    public void onItemViewClick(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (validateItemData == null) {
            return;
        }
        if (100 == i) {
            onValidateBtnClick(validateItemData);
        } else if (101 == i) {
            onHeadClick(validateItemData);
        }
    }

    public void onItemViewLongClick(View view, int i, int i2, long j, ValidateItemData validateItemData) {
        if (view == null || validateItemData == null || 200 != i) {
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
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(7, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        d.b.h0.s.d.b.g0().f(1);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.GROUP_VALIDATION, -4)));
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        int i;
        if (!this.isLoading && (i = this.offset) < this.totalCount) {
            this.isLoading = true;
            ValidateModel.requestValidateDataFromDB(this.perCount, i, this.getDataCallBack);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(7, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        d.b.i0.d1.x.a f2;
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(7, false);
        d.b.i0.d1.x.c cVar = this.valiateView;
        if (cVar == null || (f2 = cVar.f()) == null) {
            return;
        }
        ValidateModel.markShown(f2.b());
    }
}
