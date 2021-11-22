package com.baidu.tieba.memberCenter.memberprivilege;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import b.a.r0.y1.g.a;
import b.a.r0.y1.g.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes9.dex */
public class MemberPrivilegeActivity extends BaseActivity<MemberPrivilegeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String SCENE_ID;
    public final CustomMessageListener mBuyTdouListener;
    public final CustomMessageListener mMemListener;
    public d mMemberPrivilegeView;
    public HttpMessageListener mRequestMemberPrivilegelistener;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPrivilegeActivity f52499a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MemberPrivilegeActivity memberPrivilegeActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPrivilegeActivity, Integer.valueOf(i2)};
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
            this.f52499a = memberPrivilegeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                MemberPrivilegeActivity memberPrivilegeActivity = this.f52499a;
                memberPrivilegeActivity.hideLoadingView(memberPrivilegeActivity.mMemberPrivilegeView.e());
                if ((httpResponsedMessage instanceof ResponseMemberPrivilegeMessage) && httpResponsedMessage.getCmd() == 1001531) {
                    int error = httpResponsedMessage.getError();
                    ResponseMemberPrivilegeMessage responseMemberPrivilegeMessage = (ResponseMemberPrivilegeMessage) httpResponsedMessage;
                    if (error != 0) {
                        this.f52499a.showToast(StringUtils.isNull(responseMemberPrivilegeMessage.getErrorString()) ? this.f52499a.getResources().getString(R.string.neterror) : responseMemberPrivilegeMessage.getErrorString());
                        return;
                    }
                    b.a.r0.y1.g.a aVar = responseMemberPrivilegeMessage.mData;
                    if (aVar != null) {
                        this.f52499a.mMemberPrivilegeView.d().h(aVar);
                    } else {
                        this.f52499a.showToast(R.string.neterror);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPrivilegeActivity f52500a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MemberPrivilegeActivity memberPrivilegeActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPrivilegeActivity, Integer.valueOf(i2)};
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
            this.f52500a = memberPrivilegeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || ((Integer) customResponsedMessage.getData()) == null) {
                return;
            }
            this.f52500a.requestMemberPrivilegeData();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberPrivilegeActivity f52501a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MemberPrivilegeActivity memberPrivilegeActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberPrivilegeActivity, Integer.valueOf(i2)};
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
            this.f52501a = memberPrivilegeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f52501a.requestMemberPrivilegeData();
        }
    }

    public MemberPrivilegeActivity() {
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
        this.SCENE_ID = "4001001000";
        this.mRequestMemberPrivilegelistener = new a(this, CmdConfigHttp.MEMBER_PRIVILEGE_CMD);
        this.mMemListener = new b(this, 2001194);
        this.mBuyTdouListener = new c(this, 2001227);
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mMemberPrivilegeView = new d(getPageContext().getOrignalPage());
        }
    }

    private boolean isBubbleLink(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null || !"1".equals(paramPair.get("type"))) ? false : true : invokeL.booleanValue;
    }

    private void registerGetMemberPrivilegeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MEMBER_PRIVILEGE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.MEMBER_PRIVILEGE);
            tbHttpMessageTask.setResponsedClass(ResponseMemberPrivilegeMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mMemberPrivilegeView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            if (R.id.left_button == view.getId()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "consume_33", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(getPageContext().getPageActivity(), 0, "pay", 3, 1, this.SCENE_ID)));
            } else if (R.id.right_button == view.getId()) {
                CurrencyJumpHelper.memberCenterBuyTBean(getPageContext().getPageActivity(), this.SCENE_ID);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            registerGetMemberPrivilegeTask();
            registerListener(this.mMemListener);
            registerListener(this.mBuyTdouListener);
            registerListener(this.mRequestMemberPrivilegelistener);
            initUI();
            requestMemberPrivilegeData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 == 0 || 1 == this.mMemberPrivilegeView.d().getItemViewType(i2)) {
            return;
        }
        String str = ((a.C1417a) this.mMemberPrivilegeView.d().getItem(i2)).f29111d;
        String str2 = ((a.C1417a) this.mMemberPrivilegeView.d().getItem(i2)).f29109b;
        if (k.isEmpty(str)) {
            return;
        }
        if (isBubbleLink(str)) {
            sendMessage(new CustomMessage(2002001, new BubbleChooseActivityConfig(getPageContext().getPageActivity())));
        } else {
            b.a.q0.m.a.q(getPageContext().getPageActivity(), str2, str, true, true, true);
        }
    }

    public void requestMemberPrivilegeData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            showLoadingView(this.mMemberPrivilegeView.e(), true);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.MEMBER_PRIVILEGE_CMD);
            httpMessage.addParam("st_type", "shop");
            sendMessage(httpMessage);
        }
    }
}
