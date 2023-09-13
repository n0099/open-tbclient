package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor;
import com.baidu.tieba.mg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class ActivitySysMsg extends BaseSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int MSG_TYPE = 7022;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("activity_info")
    public ActivityInfo activityInfo;

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 7022;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg
    public boolean isNoUISysMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Action.a<ActivitySysMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ActivitySysMsg a;

        /* renamed from: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ActivitySysMsg$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0336a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TopBubbleData a;

            public RunnableC0336a(a aVar, TopBubbleData topBubbleData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, topBubbleData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = topBubbleData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921796, this.a));
                }
            }
        }

        public a(ActivitySysMsg activitySysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activitySysMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activitySysMsg;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action.a
        /* renamed from: b */
        public void a(@NonNull Action.Op op, @Nullable ActivitySysMsg activitySysMsg, @NonNull ChatMsgProcessor.j jVar) {
            ActivityInfo activityInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, op, activitySysMsg, jVar) == null) && jVar.d && activitySysMsg != null && (activityInfo = activitySysMsg.getActivityInfo()) != null) {
                TopBubbleData topBubbleData = new TopBubbleData();
                topBubbleData.setPinnedType("activity");
                topBubbleData.setActivityID(activityInfo.id);
                topBubbleData.setActivityStatus(activityInfo.status);
                mg.g(new RunnableC0336a(this, topBubbleData));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class ActivityInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("guest_uk")
        public String guestUk;
        @SerializedName("id")
        public long id;
        @SerializedName("name")
        public String name;
        @SerializedName("status")
        public int status;

        public ActivityInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1792278048, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/ActivitySysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1792278048, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/ActivitySysMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
    }

    public ActivitySysMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public ActivityInfo getActivityInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.activityInfo;
        }
        return (ActivityInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.cn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @Nullable
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            CommonMsgField commonMsgField = getCommonMsgField();
            return Action.a(commonMsgField.getMsgId(), commonMsgField.getMsgKey(), Action.Op.EXEC, new a(this));
        }
        return (Action) invokeV.objValue;
    }
}
