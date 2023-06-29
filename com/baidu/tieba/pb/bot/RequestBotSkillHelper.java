package com.baidu.tieba.pb.bot;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/pb/bot/RequestBotSkillHelper;", "", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "(Lcom/baidu/tbadk/TbPageContext;)V", "request", "Lcom/baidu/tbadk/net/FastRequest;", "getRequest", "()Lcom/baidu/tbadk/net/FastRequest;", "request$delegate", "Lkotlin/Lazy;", "doRequest", "", "botRequest", "Lcom/baidu/tieba/pb/bot/RequestBotSkillHelper$BotRequest;", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tbadk/net/FastRequest$Callback;", "Ljava/lang/Void;", "BotRequest", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class RequestBotSkillHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final Lazy b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/pb/bot/RequestBotSkillHelper$BotRequest;", "Ljava/io/Serializable;", "botUk", "", "skillId", "", "tid", "pid", "token", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBotUk", "()Ljava/lang/String;", "getPid", "getSkillId", "()J", "getTid", "getToken", "component1", "component2", "component3", "component4", "component5", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class BotRequest implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String botUk;
        public final String pid;
        public final long skillId;
        public final String tid;
        public final String token;

        public static /* synthetic */ BotRequest copy$default(BotRequest botRequest, String str, long j, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = botRequest.botUk;
            }
            if ((i & 2) != 0) {
                j = botRequest.skillId;
            }
            long j2 = j;
            if ((i & 4) != 0) {
                str2 = botRequest.tid;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = botRequest.pid;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                str4 = botRequest.token;
            }
            return botRequest.copy(str, j2, str5, str6, str4);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.botUk : (String) invokeV.objValue;
        }

        public final long component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.skillId : invokeV.longValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.tid : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.pid : (String) invokeV.objValue;
        }

        public final String component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.token : (String) invokeV.objValue;
        }

        public final BotRequest copy(String botUk, long j, String tid, String pid, String token) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{botUk, Long.valueOf(j), tid, pid, token})) == null) {
                Intrinsics.checkNotNullParameter(botUk, "botUk");
                Intrinsics.checkNotNullParameter(tid, "tid");
                Intrinsics.checkNotNullParameter(pid, "pid");
                Intrinsics.checkNotNullParameter(token, "token");
                return new BotRequest(botUk, j, tid, pid, token);
            }
            return (BotRequest) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BotRequest) {
                    BotRequest botRequest = (BotRequest) obj;
                    return Intrinsics.areEqual(this.botUk, botRequest.botUk) && this.skillId == botRequest.skillId && Intrinsics.areEqual(this.tid, botRequest.tid) && Intrinsics.areEqual(this.pid, botRequest.pid) && Intrinsics.areEqual(this.token, botRequest.token);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (((((((this.botUk.hashCode() * 31) + b.a(this.skillId)) * 31) + this.tid.hashCode()) * 31) + this.pid.hashCode()) * 31) + this.token.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return "BotRequest(botUk=" + this.botUk + ", skillId=" + this.skillId + ", tid=" + this.tid + ", pid=" + this.pid + ", token=" + this.token + ')';
            }
            return (String) invokeV.objValue;
        }

        public BotRequest(String botUk, long j, String tid, String pid, String token) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {botUk, Long.valueOf(j), tid, pid, token};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(botUk, "botUk");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(pid, "pid");
            Intrinsics.checkNotNullParameter(token, "token");
            this.botUk = botUk;
            this.skillId = j;
            this.tid = tid;
            this.pid = pid;
            this.token = token;
        }

        public final String getBotUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.botUk;
            }
            return (String) invokeV.objValue;
        }

        public final String getPid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.pid;
            }
            return (String) invokeV.objValue;
        }

        public final long getSkillId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.skillId;
            }
            return invokeV.longValue;
        }

        public final String getTid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.tid;
            }
            return (String) invokeV.objValue;
        }

        public final String getToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.token;
            }
            return (String) invokeV.objValue;
        }
    }

    public RequestBotSkillHelper(TbPageContext<BaseFragmentActivity> pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.a = pageContext;
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<FastRequest>(this) { // from class: com.baidu.tieba.pb.bot.RequestBotSkillHelper$request$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RequestBotSkillHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FastRequest invoke() {
                InterceptResult invokeV;
                TbPageContext tbPageContext;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (FastRequest) invokeV.objValue;
                }
                tbPageContext = this.this$0.a;
                return new FastRequest(tbPageContext, CmdConfigHttp.CMD_POST_CALL_ROBOT_ROUTER, TbConfig.URL_CALL_ROBOT_ROUTER);
            }
        });
    }

    public final void b(BotRequest botRequest, FastRequest.b<Void> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, botRequest, callback) == null) {
            Intrinsics.checkNotNullParameter(botRequest, "botRequest");
            Intrinsics.checkNotNullParameter(callback, "callback");
            FastRequest c = c();
            c.a0(HttpMessageTask.HTTP_METHOD.POST);
            c.V("scene", "thread");
            c.V("bot_uk", botRequest.getBotUk());
            c.V("skill_id", Long.valueOf(botRequest.getSkillId()));
            c.V("thread_id", botRequest.getTid());
            c.V("post_id", botRequest.getPid());
            c.V("loading_post_token", botRequest.getToken());
            c.X(callback);
            c.W();
        }
    }

    public final FastRequest c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (FastRequest) this.b.getValue();
        }
        return (FastRequest) invokeV.objValue;
    }
}
