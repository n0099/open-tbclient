package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.u1.a.c.c;
import c.a.t0.u1.a.c.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.imMessageCenter.im.chat.PersonalChatDisplayResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_INVITED_COUNT = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.s0.t.f.a> friendList;
    public CustomMessageListener friendListResponsedMessageListener;
    public boolean isFromInviteChat;
    public boolean isFromSearch;
    public boolean isLoaded;
    public final AtomicBoolean isLoading;
    public final c.a.d.c.g.c mListener;
    public e mModel;
    public c.a.t0.u1.a.c.d mView;
    public LinkedList<c.a.s0.t.f.a> searchedList;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InviteFriendListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InviteFriendListActivity inviteFriendListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inviteFriendListActivity, Integer.valueOf(i2)};
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
            this.a = inviteFriendListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof PersonalChatDisplayResponse)) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InviteFriendListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InviteFriendListActivity inviteFriendListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inviteFriendListActivity, Integer.valueOf(i2)};
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
            this.a = inviteFriendListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof GetContactListResponsedMessage)) {
                this.a.isLoaded = true;
                this.a.isLoading.set(false);
                InviteFriendListActivity inviteFriendListActivity = this.a;
                inviteFriendListActivity.hideLoadingView(inviteFriendListActivity.mView.u());
                List<c.a.s0.t.f.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                InviteFriendListActivity inviteFriendListActivity2 = this.a;
                inviteFriendListActivity2.friendList = contacts;
                if (inviteFriendListActivity2.mView == null) {
                    return;
                }
                this.a.refreshWithCurrentData();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InviteFriendListActivity f45254e;

        public c(InviteFriendListActivity inviteFriendListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inviteFriendListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45254e = inviteFriendListActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f45254e.mModel == null) {
                return;
            }
            this.f45254e.mModel.cancelLoadData();
        }
    }

    /* loaded from: classes12.dex */
    public class d extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InviteFriendListActivity a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45255e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45255e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45255e.a.isFinishing()) {
                    return;
                }
                this.f45255e.a.finish();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InviteFriendListActivity inviteFriendListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inviteFriendListActivity, Integer.valueOf(i2)};
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
            this.a = inviteFriendListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.closeLoadingDialog();
                if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205002 && (socketResponsedMessage instanceof ResponseCommitInviteMessage)) {
                    ResponseCommitInviteMessage responseCommitInviteMessage = (ResponseCommitInviteMessage) socketResponsedMessage;
                    if (responseCommitInviteMessage.getError() != 0) {
                        this.a.showToast(StringUtils.isNull(responseCommitInviteMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : responseCommitInviteMessage.getErrorString());
                        return;
                    }
                    InviteFriendListActivity inviteFriendListActivity = this.a;
                    inviteFriendListActivity.showToast(inviteFriendListActivity.getPageContext().getString(R.string.send_success), false);
                    new Handler().postDelayed(new a(this), 400L);
                }
            }
        }
    }

    public InviteFriendListActivity() {
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
        this.isLoaded = false;
        this.friendList = null;
        this.searchedList = new LinkedList<>();
        this.isLoading = new AtomicBoolean(false);
        this.friendListResponsedMessageListener = new b(this, 2001184);
        this.mListener = new d(this, 205002);
    }

    private void initModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mModel = new e(this);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            c.a.t0.u1.a.c.d dVar = new c.a.t0.u1.a.c.d(this, this.isFromInviteChat);
            this.mView = dVar;
            dVar.G(100);
        }
    }

    private void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            refreshWithCurrentData();
        }
    }

    private void registerFinishListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            registerListener(new a(this, 2001309));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.mView.q();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.t0.u1.a.c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (dVar = this.mView) == null) {
            return;
        }
        dVar.x();
        if (view.getId() == this.mView.t()) {
            showLoadingDialog();
            this.mModel.y(this.mView.r());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.mListener);
            registerListener(this.friendListResponsedMessageListener);
            Intent intent = getIntent();
            initModel();
            boolean z = false;
            if (intent != null) {
                this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
                z = intent.getBooleanExtra(InviteFriendListActivityConfig.KEY_FINISH_ACTIVITY, false);
                this.mModel.initWithIntent(intent);
            } else {
                this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
                this.mModel.initWithBundle(bundle);
            }
            initView();
            loadData();
            if (z) {
                registerFinishListener();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.mModel.cancelLoadData();
            c.a.t0.u1.a.c.d dVar = this.mView;
            if (dVar != null) {
                dVar.C();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Object tag;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.onItemClick(adapterView, view, i2, j2);
            if (this.isFromInviteChat) {
                c.a.s0.t.f.a aVar = null;
                if (this.isFromSearch) {
                    LinkedList<c.a.s0.t.f.a> linkedList = this.searchedList;
                    if (linkedList != null && i2 < linkedList.size()) {
                        aVar = this.searchedList.get(i2);
                    }
                } else {
                    List<c.a.s0.t.f.a> list = this.friendList;
                    if (list != null && i2 < list.size()) {
                        aVar = this.friendList.get(i2);
                    }
                }
                if (aVar == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), aVar.e(), aVar.f(), aVar.g(), aVar.h(), 0)));
            } else if (view == null || (tag = view.getTag()) == null || !(tag instanceof c.a)) {
            } else {
                TbCheckBox tbCheckBox = ((c.a) tag).f23910d;
                tbCheckBox.setChecked(!tbCheckBox.isChecked());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (i2 == 4 && this.mView.B()) {
                this.mView.y();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.mModel.x(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onStart();
            this.mView.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onStop();
            this.mView.d();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || this.isLoaded) {
                return;
            }
            showLoadingView(this.mView.u(), true);
        }
    }

    public void refreshWithCurrentData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || isFinishing()) {
            return;
        }
        if (this.friendList == null) {
            if (this.isLoading.get()) {
                return;
            }
            this.isLoading.set(true);
            super.sendMessage(new GetContactListRequestMessage());
            return;
        }
        String v = this.mView.v();
        String trim = v == null ? "" : v.trim();
        if (this.friendList.isEmpty() && trim.length() > 0) {
            showToast(getPageContext().getString(R.string.invite_friend_no_data_now));
        }
        if (trim.length() == 0) {
            this.isFromSearch = false;
            this.mView.D(this.friendList, false);
            return;
        }
        this.searchedList.clear();
        for (c.a.s0.t.f.a aVar : this.friendList) {
            String c2 = aVar.c();
            if (c2 != null && c2.contains(trim)) {
                this.searchedList.add(aVar);
            }
        }
        this.isFromSearch = true;
        this.mView.D(this.searchedList, true);
    }

    public void showLoadingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            showLoadingDialog((String) null, new c(this));
        }
    }
}
