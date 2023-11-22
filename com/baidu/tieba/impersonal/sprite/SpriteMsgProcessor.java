package com.baidu.tieba.impersonal.sprite;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.AudioMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.CustomMsg;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.chatmessage.response.SendMsgResponse;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.a89;
import com.baidu.tieba.c89;
import com.baidu.tieba.ca9;
import com.baidu.tieba.ck5;
import com.baidu.tieba.da9;
import com.baidu.tieba.f89;
import com.baidu.tieba.fa9;
import com.baidu.tieba.ga9;
import com.baidu.tieba.ha9;
import com.baidu.tieba.ik5;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.tieba.kk5;
import com.baidu.tieba.lk5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.na9;
import com.baidu.tieba.nk5;
import com.baidu.tieba.o99;
import com.baidu.tieba.ok5;
import com.baidu.tieba.qd;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0013\u0018\u0000 v2\u00020\u0001:\u0004vwxyB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u001cJ>\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u00152\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u000209H\u0003J>\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020\u00152\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u000209H\u0002J\"\u0010<\u001a\u0004\u0018\u00010\r2\u0006\u0010;\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020?H\u0002J\u000e\u0010@\u001a\u00020.2\u0006\u00101\u001a\u00020\u0015J\u0015\u0010A\u001a\u0004\u0018\u0001052\u0006\u0010B\u001a\u00020\u0010¢\u0006\u0002\u0010CJ\u0006\u0010D\u001a\u00020\u0015J\u0006\u0010E\u001a\u00020\u0010J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\u0006\u00101\u001a\u00020\u0015H\u0002J\u0010\u0010G\u001a\u0004\u0018\u00010\u00072\u0006\u0010H\u001a\u00020\u0010J\u0018\u0010I\u001a\u0004\u0018\u00010\u00072\u0006\u0010=\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u0010J\u0010\u0010K\u001a\u0004\u0018\u00010\r2\u0006\u00101\u001a\u00020\u0015J\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\u0006\u00101\u001a\u00020\u0015H\u0002J\u0016\u0010M\u001a\u00020N2\u0006\u00101\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0010J\u001c\u0010O\u001a\u00020N2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u0010B\u001a\u00020\u0010J\u0016\u0010Q\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\u0006\u00101\u001a\u00020\u0015H\u0002J\u001e\u0010R\u001a\u00020.2\u0006\u00108\u001a\u00020N2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\r0\u0016H\u0002J\u000e\u0010T\u001a\u0002052\u0006\u00101\u001a\u00020\u0015J\u0016\u0010U\u001a\u0002052\u0006\u00101\u001a\u00020\u00152\u0006\u0010V\u001a\u00020\u0015J\u0016\u0010W\u001a\u00020.2\u0006\u00101\u001a\u00020\u00152\u0006\u0010>\u001a\u00020?J(\u0010X\u001a\u00020.2\u0006\u0010Y\u001a\u00020N2\u0006\u0010Z\u001a\u00020N2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\\H\u0016J$\u0010]\u001a\u00020.2\u0006\u0010;\u001a\u00020\u00152\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00108\u001a\u000209J\u001a\u0010^\u001a\u0004\u0018\u00010\r2\u0006\u0010;\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0007H\u0002J\"\u0010_\u001a\u00020.2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\n\u0010a\u001a\u0006\u0012\u0002\b\u00030bH\u0002J \u0010c\u001a\u00020.2\u0006\u0010d\u001a\u00020N2\u0010\u0010e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0019J(\u0010c\u001a\u00020.2\u000e\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0g2\u0010\u0010e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0019J\u000e\u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\u0007J\u0010\u0010j\u001a\u00020.2\u0006\u0010i\u001a\u00020\u0007H\u0002J\u000e\u0010k\u001a\u00020.2\u0006\u0010V\u001a\u00020\u0015J\u0006\u0010l\u001a\u00020.J\u000e\u0010m\u001a\u00020.2\u0006\u00101\u001a\u00020\u0015J\u0016\u0010m\u001a\u00020.2\u0006\u00101\u001a\u00020\u00152\u0006\u0010n\u001a\u000205J\u0016\u0010o\u001a\u00020.2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u0010J\u0012\u0010p\u001a\u00020.2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030bJ\u0010\u0010q\u001a\u00020.2\b\u0010r\u001a\u0004\u0018\u00010)J\u0010\u0010s\u001a\u00020.2\u0006\u0010t\u001a\u00020\u0007H\u0002J\u0014\u0010u\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u0010t\u001a\u00020\u0007R\"\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor;", "Lcom/baidu/tbadk/module/alalivesdk/imSdkPersonService/interfaces/PersonMessageReceiveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CHAT_MSG_COMPARATOR", "Ljava/util/Comparator;", "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;", "getCHAT_MSG_COMPARATOR", "()Ljava/util/Comparator;", "setCHAT_MSG_COMPARATOR", "(Ljava/util/Comparator;)V", "CHAT_PERSON_MSG_COMPARATOR", "Lcom/baidu/tieba/impersonal/data/BasePersonalMsgData;", "getCHAT_PERSON_MSG_COMPARATOR", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatMsgSetMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/SizedSyncTreeSet;", "classMap", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "fetchMsgCallbackList", "Ljava/util/HashSet;", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo$FetchMsgCallback;", "Lkotlin/collections/HashSet;", "imSdkServicePerson", "Lcom/baidu/tbadk/module/alalivesdk/imSdkPersonService/interfaces/IMSdkServicePerson;", "kotlin.jvm.PlatformType", "latestTmpSetMap", "loadingHelper", "Lcom/baidu/tieba/impersonal/util/LoadingMsgHelper;", "getLoadingHelper", "()Lcom/baidu/tieba/impersonal/util/LoadingMsgHelper;", "loadingHelper$delegate", "Lkotlin/Lazy;", "msgCallback", "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$MsgCallback;", "msgTransfer", "Lcom/baidu/tieba/impersonal/transfer/MsgTransfer;", "tmpSetMap", "addFetchMsgCallback", "", "fetchMsgCallback", "doParse", "roomId", "msgSet", "Ljava/util/TreeSet;", "isByLocal", "", "isByHttp", "isBySocket", "loadType", "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$MsgLoadType;", "doParseOnBgThread", "uid", "doParseOneMsg", "msg", "source", "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$Source;", "faultChatMsgSet", "findShowMsgByMsgKey", "msgKey", "(Ljava/lang/String;)Ljava/lang/Boolean;", "generateMsgId", "generateMsgKey", "getChatMsgSet", "getFakeLoadingSdkMsg", "newMsgKey", "getFakeTextSdkMsg", "curMsgKey", "getFarthestMsg", "getLatestTmpSet", "getPositionByMsgKey", "", "getPositionByMsgKeyWithTargetSet", "targetSet", "getTmpSet", "handlefirstLoading", "tmpSet", "isChatMsgSetFaulted", "isMsgPositionAtCurrentRange", "msgId", "manualUpdateData", "onReceiveMessage", "var1", "var2", "chatMsgArrayList", "Ljava/util/ArrayList;", "onReceiveMessageByLocal", "parseNormalMsg", "processLoadingData", "chatMsgSet", "curMsgData", "Lcom/baidu/tieba/impersonal/data/PersonalChatMsgData;", "putParseClass", "msgType", Bundle.EXTRA_KEY_CLAZZ, "msgTypeList", "", "reSendMessage", "msgData", "realSendMsg", "removeMsgByMsgId", "resetData", "resumeFaultChatMsgSet", "clearBefore", "sendFakeSpriteMsg", "sendMsg", "setMsgCallback", WebChromeClient.KEY_ARG_CALLBACK, "setSelfMsgTime", "chatMsg", "singletonSet", "Companion", "MsgCallback", "MsgLoadType", "Source", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SpriteMsgProcessor implements nk5 {
    public static /* synthetic */ Interceptable $ic;
    public static final c m;
    public static final long n;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final Lazy b;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<a89>> c;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<a89>> d;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<a89>> e;
    public final lk5 f;
    public final fa9 g;
    public final String h;
    public d i;
    public final HashSet<o99.b> j;
    public Comparator<ChatMsg> k;
    public final Comparator<a89> l;

    /* loaded from: classes6.dex */
    public interface d {
        @MainThread
        void a(long j, List<? extends a89> list, f fVar, e eVar);
    }

    /* loaded from: classes6.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public static final a b;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1741893590, "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1741893590, "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$f;");
                    return;
                }
            }
            b = new a(null);
        }

        public /* synthetic */ f(boolean z, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, z2, z3);
        }

        /* loaded from: classes6.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public a() {
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

            public final f a(boolean z, boolean z2, boolean z3) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
                    return new f(z, z2, z3, null);
                }
                return (f) invokeCommon.objValue;
            }
        }

        public f(boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = z3;
        }

        public final boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements Comparator<ChatMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ChatMsg chatMsg, ChatMsg chatMsg2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, chatMsg, chatMsg2)) == null) {
                if (chatMsg == null || chatMsg2 == null || TextUtils.equals(chatMsg.getMsgKey(), chatMsg2.getMsgKey())) {
                    return 0;
                }
                if (chatMsg.getMsgId() - chatMsg2.getMsgId() > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Comparator<a89> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a89 a89Var, a89 a89Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, a89Var, a89Var2)) == null) {
                if (a89Var == null || a89Var2 == null || TextUtils.equals(a89Var.b(), a89Var2.b())) {
                    return 0;
                }
                if (a89Var.a() == 0 || a89Var.a() - a89Var2.a() > 0) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public c() {
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

        public final long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.longValue;
            }
            return SpriteMsgProcessor.n;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1741893559, "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$e;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1741893559, "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$e;");
            }
        }

        public e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements ok5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpriteMsgProcessor a;
        public final /* synthetic */ ChatMsg b;

        public g(SpriteMsgProcessor spriteMsgProcessor, ChatMsg chatMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteMsgProcessor, chatMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spriteMsgProcessor;
            this.b = chatMsg;
        }

        @Override // com.baidu.tieba.ok5
        public void a(ChatMsg msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                TreeSet<ChatMsg> G = this.a.G(msg);
                this.a.A(Long.MAX_VALUE);
                SpriteMsgProcessor spriteMsgProcessor = this.a;
                String msgKey = msg.getMsgKey();
                Intrinsics.checkNotNullExpressionValue(msgKey, "msg.msgKey");
                ChatMsg o = spriteMsgProcessor.o(msgKey);
                if (o != null) {
                    SpriteMsgProcessor spriteMsgProcessor2 = this.a;
                    G.add(o);
                    na9 q = spriteMsgProcessor2.q();
                    String msgKey2 = msg.getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey2, "msg.msgKey");
                    q.c(msgKey2);
                }
                this.a.v(SpriteMsgProcessor.m.a(), G, new e(4));
                HashSet<o99.b> hashSet = this.a.j;
                ChatMsg chatMsg = this.b;
                for (o99.b bVar : hashSet) {
                    String msgKey3 = chatMsg.getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey3, "msgData.msgKey");
                    bVar.d(msgKey3);
                }
            }
        }

        @Override // com.baidu.tieba.ok5
        public void b(int i, String errorMsg, SendMsgResponse sendMsgResponse) {
            String str;
            String msgKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, errorMsg, sendMsgResponse) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                Intrinsics.checkNotNullParameter(sendMsgResponse, "sendMsgResponse");
                ChatMsg chatMsg = sendMsgResponse.msg;
                if (chatMsg != null) {
                    SpriteMsgProcessor spriteMsgProcessor = this.a;
                    String msgKey2 = chatMsg.getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey2, "sendMsgResponse.msg.msgKey");
                    spriteMsgProcessor.k(msgKey2);
                }
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this.a.l());
                treeSet.add(sendMsgResponse.msg);
                if (i != 0) {
                    TbLog imSpriteSysLog = ImSpriteSysLog.getInstance();
                    String r = this.a.r();
                    StringBuilder sb = new StringBuilder();
                    sb.append("sendMessage responseCode : ");
                    sb.append(i);
                    sb.append("errorMsg : ");
                    sb.append(errorMsg);
                    sb.append("sendMsgResponse : ");
                    ChatMsg chatMsg2 = sendMsgResponse.msg;
                    if (chatMsg2 != null && (msgKey = chatMsg2.getMsgKey()) != null) {
                        str = msgKey.toString();
                    } else {
                        str = null;
                    }
                    sb.append(str);
                    imSpriteSysLog.i(r, sb.toString());
                    try {
                        String msgContent = sendMsgResponse.msg.getMsgContent();
                        if (msgContent == null) {
                            msgContent = "";
                        }
                        JSONObject jSONObject = new JSONObject(msgContent);
                        jSONObject.put("origin_msg_key", sendMsgResponse.msg.getMsgKey());
                        sendMsgResponse.msg.setMsgContent(jSONObject.toString());
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    this.a.v(SpriteMsgProcessor.m.a(), treeSet, new e(4));
                } else {
                    this.a.v(SpriteMsgProcessor.m.a(), treeSet, new e(8));
                }
                fa9 fa9Var = this.a.g;
                ChatMsg chatMsg3 = sendMsgResponse.msg;
                Intrinsics.checkNotNullExpressionValue(chatMsg3, "sendMsgResponse.msg");
                f89<?> d = fa9Var.d(chatMsg3);
                if (d != null) {
                    for (o99.b bVar : this.a.j) {
                        bVar.b(i, errorMsg, d);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1494548376, "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1494548376, "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor;");
                return;
            }
        }
        m = new c(null);
        n = JavaTypesHelper.toLong(BIMManager.getBdUidFromBdUK(SharedPrefHelper.getInstance().getString("key_funny_sprite_uk", "")), 17592328994873L);
    }

    public SpriteMsgProcessor(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        new SparseArray();
        this.b = LazyKt__LazyJVMKt.lazy(SpriteMsgProcessor$loadingHelper$2.INSTANCE);
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = new ConcurrentHashMap<>();
        this.f = kk5.a();
        fa9 fa9Var = new fa9();
        this.g = fa9Var;
        this.h = "IMSprite";
        fa9Var.b(TextMsg.class, 1);
        this.g.b(CustomMsg.class, Integer.MAX_VALUE);
        this.g.b(AudioMsg.class, 3);
        this.g.b(ImageMsg.class, 2);
        this.g.a(1, new ga9());
        this.g.a(Integer.MAX_VALUE, new da9());
        this.g.a(3, new ha9());
        this.g.a(2, new ca9());
        this.j = new HashSet<>();
        this.k = new a();
        this.l = new b();
    }

    public static final void B(final SpriteMsgProcessor this$0, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65538, null, this$0, j) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Iterator<a89> it = this$0.m(n).iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().a() == j) {
                    z = true;
                    it.remove();
                }
            }
            if (!z) {
                return;
            }
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.i99
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.C(SpriteMsgProcessor.this);
                    }
                }
            });
        }
    }

    public static final void C(SpriteMsgProcessor this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SizedSyncTreeSet<a89> m2 = this$0.m(n);
            d dVar = this$0.i;
            if (dVar != null) {
                dVar.a(n, new ArrayList(m2), f.b.a(true, false, false), new e(7));
            }
        }
    }

    public final Boolean k(String msgKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, msgKey)) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            Iterator<a89> it = m(n).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "set.iterator()");
            while (it.hasNext()) {
                if (qd.isEquals(it.next().b(), msgKey)) {
                    it.remove();
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }

    public final SizedSyncTreeSet<a89> m(final long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            SizedSyncTreeSet<a89> sizedSyncTreeSet = this.c.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<a89> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(600, new TreeSet(this.l));
                sizedSyncTreeSet2.setCallback(new SizedSyncTreeSet.a() { // from class: com.baidu.tieba.e99
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet.a
                    public final void a(boolean z, Collection collection) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, collection) == null) {
                            SpriteMsgProcessor.n(SpriteMsgProcessor.this, j, z, collection);
                        }
                    }
                });
                this.c.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public final SizedSyncTreeSet<a89> p(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) {
            SizedSyncTreeSet<a89> sizedSyncTreeSet = this.e.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<a89> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(200, new TreeSet(this.l));
                this.e.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public final SizedSyncTreeSet<a89> s(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
            SizedSyncTreeSet<a89> sizedSyncTreeSet = this.d.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<a89> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(new TreeSet(this.l));
                this.d.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public final void A(final long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.x89
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.B(SpriteMsgProcessor.this, j);
                    }
                }
            });
        }
    }

    public final void F(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.i = dVar;
        }
    }

    public final TreeSet<ChatMsg> G(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, chatMsg)) == null) {
            Intrinsics.checkNotNullParameter(chatMsg, "chatMsg");
            TreeSet<ChatMsg> treeSet = new TreeSet<>(ik5.b);
            treeSet.add(chatMsg);
            return treeSet;
        }
        return (TreeSet) invokeL.objValue;
    }

    public final void e(o99.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) && bVar != null) {
            this.j.add(bVar);
        }
    }

    public final void y(ChatMsg msgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, msgData) == null) {
            Intrinsics.checkNotNullParameter(msgData, "msgData");
            z(msgData);
        }
    }

    public final void z(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, chatMsg) == null) {
            this.f.d(this.a, chatMsg, n, new g(this, chatMsg));
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q().n(false);
        }
    }

    public final Comparator<ChatMsg> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return (Comparator) invokeV.objValue;
    }

    public final na9 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (na9) this.b.getValue();
        }
        return (na9) invokeV.objValue;
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public static final void g(SpriteMsgProcessor this$0, long j, List list, boolean z, boolean z2, boolean z3, e loadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{this$0, Long.valueOf(j), list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), loadType}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "$list");
            Intrinsics.checkNotNullParameter(loadType, "$loadType");
            d dVar = this$0.i;
            if (dVar != null) {
                dVar.a(j, list, f.b.a(z, z2, z3), loadType);
            }
        }
    }

    public static final void i(SpriteMsgProcessor this$0, long j, TreeSet msgSet, boolean z, boolean z2, boolean z3, e loadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{this$0, Long.valueOf(j), msgSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), loadType}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgSet, "$msgSet");
            Intrinsics.checkNotNullParameter(loadType, "$loadType");
            this$0.f(j, msgSet, z, z2, z3, loadType);
        }
    }

    public static final void n(SpriteMsgProcessor this$0, long j, boolean z, Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{this$0, Long.valueOf(j), Boolean.valueOf(z), collection}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!z) {
                SizedSyncTreeSet<a89> p = this$0.p(j);
                if (p.isEmpty() && (collection instanceof Collection)) {
                    p.addAll(collection);
                }
            }
        }
    }

    public static final void u(ArrayList arrayList, SpriteMsgProcessor this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, arrayList, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f89<?> d2 = this$0.g.d((ChatMsg) it.next());
                if (d2 != null) {
                    arrayList2.add(d2);
                }
            }
            for (o99.b bVar : this$0.j) {
                bVar.a(arrayList2);
            }
            TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.k);
            treeSet.addAll(arrayList);
            this$0.h(n, treeSet, false, false, true, new e(3));
        }
    }

    public final void E(f89<?> msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            ChatMsg c2 = this.g.c(msg);
            if (c2 != null) {
                c2.setContacter(n);
                c2.setFromUser(AccountManager.getUK(this.a));
                c2.setStatus(1);
                c2.setSenderUid(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                c2.setCategory(0);
                c2.setChatType(7);
                c2.setSendMsgTime(System.currentTimeMillis());
                c2.createMsgKey(this.a);
                c2.setContacterBduid(String.valueOf(n));
                z(c2);
            }
        }
    }

    public final ChatMsg o(String newMsgKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, newMsgKey)) == null) {
            Intrinsics.checkNotNullParameter(newMsgKey, "newMsgKey");
            f89<?> f89Var = new f89<>();
            f89Var.e().k(Integer.MAX_VALUE);
            f89Var.i(new c89());
            f89Var.g().b(newMsgKey);
            ChatMsg c2 = this.g.c(f89Var);
            if (c2 != null) {
                c2.setSendMsgTime(System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("origin_msg_key", newMsgKey);
                c2.setMsgContent(jSONObject.toString());
                return c2;
            }
            return null;
        }
        return (ChatMsg) invokeL.objValue;
    }

    @WorkerThread
    public final void f(final long j, TreeSet<ChatMsg> treeSet, final boolean z, final boolean z2, final boolean z3, final e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), eVar}) == null) {
            SizedSyncTreeSet<a89> m2 = m(j);
            SizedSyncTreeSet<a89> s = s(j);
            SizedSyncTreeSet<a89> p = p(j);
            s.clear();
            f a2 = f.b.a(z, z2, z3);
            Iterator<ChatMsg> it = treeSet.iterator();
            while (it.hasNext()) {
                ChatMsg msg = it.next();
                try {
                    Intrinsics.checkNotNullExpressionValue(msg, "msg");
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    a89 j2 = j(j, msg, a2);
                    if (j2 != null) {
                        f89<?> f89Var = (f89) j2;
                        if (eVar.a() == 3 || eVar.a() == 6 || (eVar.a() == 4 && f89Var.e().c() == 2)) {
                            x(m2, f89Var);
                        }
                        s.add(j2);
                    }
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e);
                }
            }
            t(eVar.a(), s);
            if (!s.isEmpty() || eVar.a() == 0) {
                if (!p.isEmpty() && z3) {
                    p.addAll(s);
                } else {
                    m2.addAll(s);
                }
                if (eVar.a() != 8) {
                    final ArrayList arrayList = new ArrayList(m2);
                    UiUtils.post(new Runnable() { // from class: com.baidu.tieba.a99
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                SpriteMsgProcessor.g(SpriteMsgProcessor.this, j, arrayList, z, z2, z3, eVar);
                            }
                        }
                    });
                }
            }
        }
    }

    public final void h(final long j, final TreeSet<ChatMsg> treeSet, final boolean z, final boolean z2, final boolean z3, final e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), eVar}) == null) {
            UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.g99
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.i(SpriteMsgProcessor.this, j, treeSet, z, z2, z3, eVar);
                    }
                }
            });
        }
    }

    public final a89 j(long j, ChatMsg chatMsg, f fVar) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), chatMsg, fVar})) == null) {
            return w(j, chatMsg);
        }
        return (a89) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.nk5
    public void onReceiveMessage(int i, int i2, final ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, arrayList) == null) && arrayList != null) {
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.z89
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.u(arrayList, this);
                    }
                }
            });
        }
    }

    public final void t(int i, SizedSyncTreeSet<a89> sizedSyncTreeSet) {
        f89<?> d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048594, this, i, sizedSyncTreeSet) == null) && i == 0 && !q().m(sizedSyncTreeSet)) {
            long g2 = q().g();
            String j = q().j();
            if (g2 > 0) {
                ChatMsg o = o(j);
                if (o != null && (d2 = this.g.d(o)) != null) {
                    sizedSyncTreeSet.add(d2);
                    q().k(g2);
                    return;
                }
                return;
            }
            ck5.k(q().h(), j);
            q().n(true);
        }
    }

    public final void x(SizedSyncTreeSet<a89> sizedSyncTreeSet, f89<?> f89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, sizedSyncTreeSet, f89Var) == null) {
            a89 last = sizedSyncTreeSet.last();
            if (last != null) {
                f89 f89Var2 = (f89) last;
                if ((f89Var2.f() instanceof c89) && !f89Var2.e().e()) {
                    if (!qd.isEmpty(f89Var.g().a())) {
                        q().l(f89Var.g().a(), true);
                    }
                    if (q().i()) {
                        sizedSyncTreeSet.remove(f89Var2);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.impersonal.data.PersonalChatMsgData<*>");
        }
    }

    public final void v(long j, TreeSet<ChatMsg> msgSet, e loadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), msgSet, loadType}) == null) {
            Intrinsics.checkNotNullParameter(msgSet, "msgSet");
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            h(j, msgSet, true, false, false, loadType);
        }
    }

    public final a89 w(long j, ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048596, this, j, chatMsg)) == null) {
            return this.g.d(chatMsg);
        }
        return (a89) invokeJL.objValue;
    }
}
