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
import com.baidu.tieba.fd9;
import com.baidu.tieba.ge9;
import com.baidu.tieba.hb9;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.tieba.lk5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pb9;
import com.baidu.tieba.rb9;
import com.baidu.tieba.rd;
import com.baidu.tieba.sk5;
import com.baidu.tieba.ub9;
import com.baidu.tieba.ud9;
import com.baidu.tieba.uk5;
import com.baidu.tieba.vd9;
import com.baidu.tieba.vk5;
import com.baidu.tieba.xd9;
import com.baidu.tieba.xk5;
import com.baidu.tieba.yd9;
import com.baidu.tieba.yk5;
import com.baidu.tieba.zd9;
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
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0015\u0018\u0000 {2\u00020\u0001:\u0004{|}~B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u00010\u001eJ>\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u00152\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0007062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020<H\u0003J>\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020\u00152\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0007062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020<H\u0002J\"\u0010?\u001a\u0004\u0018\u00010\r2\u0006\u0010>\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020BH\u0002J\u000e\u0010C\u001a\u0002002\u0006\u00104\u001a\u00020\u0015J\u0015\u0010D\u001a\u0004\u0018\u0001082\u0006\u0010E\u001a\u00020\u0010¢\u0006\u0002\u0010FJ\u0006\u0010G\u001a\u00020\u0015J\u0006\u0010H\u001a\u00020\u0010J\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\u0006\u00104\u001a\u00020\u0015H\u0002J\u0010\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u0010K\u001a\u00020\u0010J\u0018\u0010L\u001a\u0004\u0018\u00010\u00072\u0006\u0010@\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u0010J\u0010\u0010N\u001a\u0004\u0018\u00010\r2\u0006\u00104\u001a\u00020\u0015J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\u0006\u00104\u001a\u00020\u0015H\u0002J\u0016\u0010P\u001a\u00020Q2\u0006\u00104\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u0010J\u001c\u0010R\u001a\u00020Q2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u0007062\u0006\u0010E\u001a\u00020\u0010J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\u0006\u00104\u001a\u00020\u0015H\u0002J\u001e\u0010U\u001a\u0002002\u0006\u0010;\u001a\u00020Q2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\r0\u0016H\u0002J\u000e\u0010W\u001a\u0002082\u0006\u00104\u001a\u00020\u0015J\u0016\u0010X\u001a\u0002082\u0006\u00104\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020\u0015J\u0016\u0010Z\u001a\u0002002\u0006\u00104\u001a\u00020\u00152\u0006\u0010A\u001a\u00020BJ(\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u00020Q2\u0006\u0010]\u001a\u00020Q2\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010_H\u0016J$\u0010`\u001a\u0002002\u0006\u0010>\u001a\u00020\u00152\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u0007062\u0006\u0010;\u001a\u00020<J\u001a\u0010a\u001a\u0004\u0018\u00010\r2\u0006\u0010>\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0007H\u0002J\"\u0010b\u001a\u0002002\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\n\u0010d\u001a\u0006\u0012\u0002\b\u00030eH\u0002J \u0010f\u001a\u0002002\u0006\u0010g\u001a\u00020Q2\u0010\u0010h\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0019J(\u0010f\u001a\u0002002\u000e\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0j2\u0010\u0010h\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0019J\u000e\u0010k\u001a\u0002002\u0006\u0010l\u001a\u00020\u0007J\u0010\u0010m\u001a\u0002002\u0006\u0010l\u001a\u00020\u0007H\u0002J\u000e\u0010n\u001a\u0002002\u0006\u0010Y\u001a\u00020\u0015J\u0006\u0010o\u001a\u000200J\u000e\u0010p\u001a\u0002002\u0006\u00104\u001a\u00020\u0015J\u0016\u0010p\u001a\u0002002\u0006\u00104\u001a\u00020\u00152\u0006\u0010q\u001a\u000208J\u0016\u0010r\u001a\u0002002\u0006\u0010@\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u0010J\u0012\u0010s\u001a\u0002002\n\u0010@\u001a\u0006\u0012\u0002\b\u00030eJ\u0010\u0010t\u001a\u0002002\b\u0010u\u001a\u0004\u0018\u00010+J\u0010\u0010v\u001a\u0002002\u0006\u0010w\u001a\u00020\u0007H\u0002J\u000e\u0010x\u001a\u0002002\u0006\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010y\u001a\b\u0012\u0004\u0012\u00020\u0007062\u0006\u0010w\u001a\u00020\u0007J\u0010\u0010z\u001a\u0002002\u0006\u0010;\u001a\u00020QH\u0002R\"\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \"*\u0004\u0018\u00010!0!X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u007f"}, d2 = {"Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor;", "Lcom/baidu/tbadk/module/alalivesdk/imSdkPersonService/interfaces/PersonMessageReceiveListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CHAT_MSG_COMPARATOR", "Ljava/util/Comparator;", "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsg;", "getCHAT_MSG_COMPARATOR", "()Ljava/util/Comparator;", "setCHAT_MSG_COMPARATOR", "(Ljava/util/Comparator;)V", "CHAT_PERSON_MSG_COMPARATOR", "Lcom/baidu/tieba/impersonal/data/BasePersonalMsgData;", "getCHAT_PERSON_MSG_COMPARATOR", "TAG", "", "getTAG", "()Ljava/lang/String;", "chatMsgSetMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/SizedSyncTreeSet;", "classMap", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "detailCallback", "Lcom/baidu/tieba/impersonal/components/SpriteDetailCallback;", "fetchMsgCallbackList", "Ljava/util/HashSet;", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo$FetchMsgCallback;", "Lkotlin/collections/HashSet;", "imSdkServicePerson", "Lcom/baidu/tbadk/module/alalivesdk/imSdkPersonService/interfaces/IMSdkServicePerson;", "kotlin.jvm.PlatformType", "latestTmpSetMap", "loadingHelper", "Lcom/baidu/tieba/impersonal/util/LoadingMsgHelper;", "getLoadingHelper", "()Lcom/baidu/tieba/impersonal/util/LoadingMsgHelper;", "loadingHelper$delegate", "Lkotlin/Lazy;", "msgCallback", "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$MsgCallback;", "msgTransfer", "Lcom/baidu/tieba/impersonal/transfer/MsgTransfer;", "tmpSetMap", "activeFakeLoading", "", "addFetchMsgCallback", "fetchMsgCallback", "doParse", "roomId", "msgSet", "Ljava/util/TreeSet;", "isByLocal", "", "isByHttp", "isBySocket", "loadType", "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$MsgLoadType;", "doParseOnBgThread", "uid", "doParseOneMsg", "msg", "source", "Lcom/baidu/tieba/impersonal/sprite/SpriteMsgProcessor$Source;", "faultChatMsgSet", "findShowMsgByMsgKey", "msgKey", "(Ljava/lang/String;)Ljava/lang/Boolean;", "generateMsgId", "generateMsgKey", "getChatMsgSet", "getFakeLoadingSdkMsg", "newMsgKey", "getFakeTextSdkMsg", "curMsgKey", "getFarthestMsg", "getLatestTmpSet", "getPositionByMsgKey", "", "getPositionByMsgKeyWithTargetSet", "targetSet", "getTmpSet", "handlefirstLoading", "tmpSet", "isChatMsgSetFaulted", "isMsgPositionAtCurrentRange", "msgId", "manualUpdateData", "onReceiveMessage", "var1", "var2", "chatMsgArrayList", "Ljava/util/ArrayList;", "onReceiveMessageByLocal", "parseNormalMsg", "processLoadingData", "chatMsgSet", "curMsgData", "Lcom/baidu/tieba/impersonal/data/PersonalChatMsgData;", "putParseClass", "msgType", Bundle.EXTRA_KEY_CLAZZ, "msgTypeList", "", "reSendMessage", "msgData", "realSendMsg", "removeMsgByMsgId", "resetData", "resumeFaultChatMsgSet", "clearBefore", "sendFakeSpriteMsg", "sendMsg", "setMsgCallback", WebChromeClient.KEY_ARG_CALLBACK, "setSelfMsgTime", "chatMsg", "setSpriteDetailCallback", "singletonSet", "tryActiveLoading", "Companion", "MsgCallback", "MsgLoadType", "Source", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SpriteMsgProcessor implements xk5 {
    public static /* synthetic */ Interceptable $ic;
    public static final c n;
    public static final long o;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final Lazy b;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<pb9>> c;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<pb9>> d;
    public final ConcurrentHashMap<Long, SizedSyncTreeSet<pb9>> e;
    public final vk5 f;
    public final xd9 g;
    public final String h;
    public d i;
    public hb9 j;
    public final HashSet<fd9.b> k;
    public Comparator<ChatMsg> l;
    public final Comparator<pb9> m;

    /* loaded from: classes6.dex */
    public interface d {
        @MainThread
        void a(long j, List<? extends pb9> list, f fVar, e eVar);
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
    public static final class b implements Comparator<pb9> {
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
        public int compare(pb9 pb9Var, pb9 pb9Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pb9Var, pb9Var2)) == null) {
                if (pb9Var == null || pb9Var2 == null || TextUtils.equals(pb9Var.b(), pb9Var2.b())) {
                    return 0;
                }
                if (pb9Var.a() == 0 || pb9Var.a() - pb9Var2.a() > 0) {
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
            return SpriteMsgProcessor.o;
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
    public static final class g implements yk5 {
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

        @Override // com.baidu.tieba.yk5
        public void a(ChatMsg msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                TreeSet<ChatMsg> K = this.a.K(msg);
                this.a.D(Long.MAX_VALUE);
                SpriteMsgProcessor spriteMsgProcessor = this.a;
                String msgKey = msg.getMsgKey();
                Intrinsics.checkNotNullExpressionValue(msgKey, "msg.msgKey");
                ChatMsg p = spriteMsgProcessor.p(msgKey);
                if (p != null) {
                    SpriteMsgProcessor spriteMsgProcessor2 = this.a;
                    K.add(p);
                    ge9 r = spriteMsgProcessor2.r();
                    String msgKey2 = msg.getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey2, "msg.msgKey");
                    r.c(msgKey2);
                }
                this.a.y(SpriteMsgProcessor.n.a(), K, new e(4));
                HashSet<fd9.b> hashSet = this.a.k;
                ChatMsg chatMsg = this.b;
                for (fd9.b bVar : hashSet) {
                    String msgKey3 = chatMsg.getMsgKey();
                    Intrinsics.checkNotNullExpressionValue(msgKey3, "msgData.msgKey");
                    bVar.d(msgKey3);
                }
            }
        }

        @Override // com.baidu.tieba.yk5
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
                    spriteMsgProcessor.l(msgKey2);
                }
                TreeSet<ChatMsg> treeSet = new TreeSet<>(this.a.m());
                treeSet.add(sendMsgResponse.msg);
                if (i != 0) {
                    TbLog imSpriteSysLog = ImSpriteSysLog.getInstance();
                    String s = this.a.s();
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
                    imSpriteSysLog.i(s, sb.toString());
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
                    this.a.y(SpriteMsgProcessor.n.a(), treeSet, new e(4));
                } else {
                    this.a.y(SpriteMsgProcessor.n.a(), treeSet, new e(8));
                }
                xd9 xd9Var = this.a.g;
                ChatMsg chatMsg3 = sendMsgResponse.msg;
                Intrinsics.checkNotNullExpressionValue(chatMsg3, "sendMsgResponse.msg");
                ub9<?> d = xd9Var.d(chatMsg3);
                if (d != null) {
                    for (fd9.b bVar : this.a.k) {
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
        n = new c(null);
        o = JavaTypesHelper.toLong(BIMManager.getBdUidFromBdUK(SharedPrefHelper.getInstance().getString("key_funny_sprite_uk", "")), 17592328994873L);
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
        this.f = uk5.a();
        xd9 xd9Var = new xd9();
        this.g = xd9Var;
        this.h = "IMSprite";
        xd9Var.b(TextMsg.class, 1);
        this.g.b(CustomMsg.class, Integer.MAX_VALUE);
        this.g.b(AudioMsg.class, 3);
        this.g.b(ImageMsg.class, 2);
        this.g.a(1, new yd9());
        this.g.a(Integer.MAX_VALUE, new vd9());
        this.g.a(3, new zd9());
        this.g.a(2, new ud9());
        this.k = new HashSet<>();
        this.l = new a();
        this.m = new b();
    }

    public static final void E(final SpriteMsgProcessor this$0, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65538, null, this$0, j) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Iterator<pb9> it = this$0.n(o).iterator();
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
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.xc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.F(SpriteMsgProcessor.this);
                    }
                }
            });
        }
    }

    public static final void F(SpriteMsgProcessor this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SizedSyncTreeSet<pb9> n2 = this$0.n(o);
            d dVar = this$0.i;
            if (dVar != null) {
                dVar.a(o, new ArrayList(n2), f.b.a(true, false, false), new e(7));
            }
        }
    }

    public final Boolean l(String msgKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, msgKey)) == null) {
            Intrinsics.checkNotNullParameter(msgKey, "msgKey");
            Iterator<pb9> it = n(o).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "set.iterator()");
            while (it.hasNext()) {
                if (rd.isEquals(it.next().b(), msgKey)) {
                    it.remove();
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }

    public final SizedSyncTreeSet<pb9> n(final long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
            SizedSyncTreeSet<pb9> sizedSyncTreeSet = this.c.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<pb9> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(600, new TreeSet(this.m));
                sizedSyncTreeSet2.setCallback(new SizedSyncTreeSet.a() { // from class: com.baidu.tieba.tc9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.SizedSyncTreeSet.a
                    public final void a(boolean z, Collection collection) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, collection) == null) {
                            SpriteMsgProcessor.o(SpriteMsgProcessor.this, j, z, collection);
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

    public final SizedSyncTreeSet<pb9> q(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048596, this, j)) == null) {
            SizedSyncTreeSet<pb9> sizedSyncTreeSet = this.e.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<pb9> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(200, new TreeSet(this.m));
                this.e.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public final SizedSyncTreeSet<pb9> t(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048599, this, j)) == null) {
            SizedSyncTreeSet<pb9> sizedSyncTreeSet = this.d.get(Long.valueOf(j));
            if (sizedSyncTreeSet == null) {
                SizedSyncTreeSet<pb9> sizedSyncTreeSet2 = new SizedSyncTreeSet<>(new TreeSet(this.m));
                this.d.put(Long.valueOf(j), sizedSyncTreeSet2);
                return sizedSyncTreeSet2;
            }
            return sizedSyncTreeSet;
        }
        return (SizedSyncTreeSet) invokeJ.objValue;
    }

    public static final void M(int i, SpriteMsgProcessor this$0) {
        hb9 hb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i == 0 && (hb9Var = this$0.j) != null) {
                hb9Var.a();
            }
        }
    }

    public final void v(final long j, final f source) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048601, this, j, source) == null) {
            Intrinsics.checkNotNullParameter(source, "source");
            final ArrayList arrayList = new ArrayList(n(j));
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.zc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.w(SpriteMsgProcessor.this, j, arrayList, source);
                    }
                }
            });
        }
    }

    public final pb9 z(long j, ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048603, this, j, chatMsg)) == null) {
            return this.g.d(chatMsg);
        }
        return (pb9) invokeJL.objValue;
    }

    public final void B(ChatMsg msgData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msgData) == null) {
            Intrinsics.checkNotNullParameter(msgData, "msgData");
            C(msgData);
        }
    }

    public final void C(ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, chatMsg) == null) {
            this.f.d(this.a, chatMsg, o, new g(this, chatMsg));
        }
    }

    public final void D(final long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.mc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.E(SpriteMsgProcessor.this, j);
                    }
                }
            });
        }
    }

    public final void I(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.i = dVar;
        }
    }

    public final void J(hb9 detailCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, detailCallback) == null) {
            Intrinsics.checkNotNullParameter(detailCallback, "detailCallback");
            this.j = detailCallback;
        }
    }

    public final TreeSet<ChatMsg> K(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatMsg)) == null) {
            Intrinsics.checkNotNullParameter(chatMsg, "chatMsg");
            TreeSet<ChatMsg> treeSet = new TreeSet<>(sk5.b);
            treeSet.add(chatMsg);
            return treeSet;
        }
        return (TreeSet) invokeL.objValue;
    }

    public final void L(final int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            UiUtils.post(new Runnable() { // from class: com.baidu.tieba.yc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.M(i, this);
                    }
                }
            });
        }
    }

    public final void f(fd9.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) && bVar != null) {
            this.k.add(bVar);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            r().o(false);
        }
    }

    public final Comparator<ChatMsg> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.l;
        }
        return (Comparator) invokeV.objValue;
    }

    public final ge9 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return (ge9) this.b.getValue();
        }
        return (ge9) invokeV.objValue;
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public static final void h(SpriteMsgProcessor this$0, long j, List list, boolean z, boolean z2, boolean z3, e loadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{this$0, Long.valueOf(j), list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), loadType}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "$list");
            Intrinsics.checkNotNullParameter(loadType, "$loadType");
            d dVar = this$0.i;
            if (dVar != null) {
                dVar.a(j, list, f.b.a(z, z2, z3), loadType);
            }
        }
    }

    public static final void j(SpriteMsgProcessor this$0, long j, TreeSet msgSet, boolean z, boolean z2, boolean z3, e loadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{this$0, Long.valueOf(j), msgSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), loadType}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(msgSet, "$msgSet");
            Intrinsics.checkNotNullParameter(loadType, "$loadType");
            this$0.g(j, msgSet, z, z2, z3, loadType);
        }
    }

    public static final void o(SpriteMsgProcessor this$0, long j, boolean z, Collection collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{this$0, Long.valueOf(j), Boolean.valueOf(z), collection}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!z) {
                SizedSyncTreeSet<pb9> q = this$0.q(j);
                if (q.isEmpty() && (collection instanceof Collection)) {
                    q.addAll(collection);
                }
            }
        }
    }

    public static final void w(SpriteMsgProcessor this$0, long j, List list, f source) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{this$0, Long.valueOf(j), list, source}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(list, "$list");
            Intrinsics.checkNotNullParameter(source, "$source");
            d dVar = this$0.i;
            if (dVar != null) {
                Intrinsics.checkNotNull(dVar);
                dVar.a(j, list, source, new e(5));
            }
        }
    }

    public static final void x(ArrayList arrayList, SpriteMsgProcessor this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, arrayList, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ub9<?> d2 = this$0.g.d((ChatMsg) it.next());
                if (d2 != null) {
                    arrayList2.add(d2);
                }
            }
            for (fd9.b bVar : this$0.k) {
                bVar.a(arrayList2);
            }
            TreeSet<ChatMsg> treeSet = new TreeSet<>(this$0.l);
            treeSet.addAll(arrayList);
            this$0.i(o, treeSet, false, false, true, new e(3));
        }
    }

    public final void A(SizedSyncTreeSet<pb9> sizedSyncTreeSet, ub9<?> ub9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sizedSyncTreeSet, ub9Var) == null) {
            pb9 last = sizedSyncTreeSet.last();
            if (last != null) {
                ub9 ub9Var2 = (ub9) last;
                if ((ub9Var2.f() instanceof rb9) && !ub9Var2.e().e()) {
                    if (!rd.isEmpty(ub9Var.g().b())) {
                        r().m(ub9Var.g().b(), true);
                    }
                    if (r().j()) {
                        sizedSyncTreeSet.remove(ub9Var2);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.impersonal.data.PersonalChatMsgData<*>");
        }
    }

    public final void u(int i, SizedSyncTreeSet<pb9> sizedSyncTreeSet) {
        ub9<?> d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048600, this, i, sizedSyncTreeSet) == null) && i == 0 && !r().n(sizedSyncTreeSet)) {
            long g2 = r().g();
            String k = r().k();
            if (g2 > 0) {
                ChatMsg p = p(k);
                if (p != null && (d2 = this.g.d(p)) != null) {
                    sizedSyncTreeSet.add(d2);
                    r().l(g2);
                    return;
                }
                return;
            }
            lk5.k(r().i(), k);
            r().o(true);
        }
    }

    public final void H(ub9<?> msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            ChatMsg c2 = this.g.c(msg);
            if (c2 != null) {
                c2.setContacter(o);
                c2.setFromUser(AccountManager.getUK(this.a));
                c2.setStatus(1);
                c2.setSenderUid(String.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                c2.setCategory(0);
                c2.setChatType(7);
                c2.setSendMsgTime(System.currentTimeMillis());
                c2.createMsgKey(this.a);
                c2.setContacterBduid(String.valueOf(o));
                C(c2);
            }
        }
    }

    public final ChatMsg p(String newMsgKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, newMsgKey)) == null) {
            Intrinsics.checkNotNullParameter(newMsgKey, "newMsgKey");
            ub9<?> ub9Var = new ub9<>();
            ub9Var.e().k(Integer.MAX_VALUE);
            ub9Var.i(new rb9());
            ub9Var.g().d(newMsgKey);
            ChatMsg c2 = this.g.c(ub9Var);
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

    public final void e() {
        TreeSet<ChatMsg> treeSet;
        ub9<?> d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SizedSyncTreeSet<pb9> t = t(o);
            ChatMsg p = p("");
            if (p != null && (d2 = this.g.d(p)) != null) {
                t.add(d2);
                r().l(r().h());
            }
            if (p != null) {
                treeSet = K(p);
            } else {
                treeSet = null;
            }
            if (treeSet != null) {
                y(o, treeSet, new e(6));
            }
            v(o, f.b.a(true, false, false));
        }
    }

    @WorkerThread
    public final void g(final long j, TreeSet<ChatMsg> treeSet, final boolean z, final boolean z2, final boolean z3, final e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), eVar}) == null) {
            SizedSyncTreeSet<pb9> n2 = n(j);
            SizedSyncTreeSet<pb9> t = t(j);
            SizedSyncTreeSet<pb9> q = q(j);
            t.clear();
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
                    pb9 k = k(j, msg, a2);
                    if (k != null) {
                        ub9<?> ub9Var = (ub9) k;
                        if (eVar.a() == 3 || eVar.a() == 6 || (eVar.a() == 4 && ub9Var.e().c() == 2)) {
                            A(n2, ub9Var);
                        }
                        t.add(k);
                    }
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e);
                }
            }
            u(eVar.a(), t);
            L(eVar.a());
            if (!t.isEmpty() || eVar.a() == 0) {
                if (!q.isEmpty() && z3) {
                    q.addAll(t);
                } else {
                    n2.addAll(t);
                }
                if (eVar.a() != 8) {
                    final ArrayList arrayList = new ArrayList(n2);
                    UiUtils.post(new Runnable() { // from class: com.baidu.tieba.pc9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                SpriteMsgProcessor.h(SpriteMsgProcessor.this, j, arrayList, z, z2, z3, eVar);
                            }
                        }
                    });
                }
            }
        }
    }

    public final void i(final long j, final TreeSet<ChatMsg> treeSet, final boolean z, final boolean z2, final boolean z3, final e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), treeSet, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), eVar}) == null) {
            UiUtils.runOnBgThread(new Runnable() { // from class: com.baidu.tieba.vc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.j(SpriteMsgProcessor.this, j, treeSet, z, z2, z3, eVar);
                    }
                }
            });
        }
    }

    public final pb9 k(long j, ChatMsg chatMsg, f fVar) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), chatMsg, fVar})) == null) {
            return z(j, chatMsg);
        }
        return (pb9) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.xk5
    public void onReceiveMessage(int i, int i2, final ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048594, this, i, i2, arrayList) == null) && arrayList != null) {
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.oc9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMsgProcessor.x(arrayList, this);
                    }
                }
            });
        }
    }

    public final void y(long j, TreeSet<ChatMsg> msgSet, e loadType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Long.valueOf(j), msgSet, loadType}) == null) {
            Intrinsics.checkNotNullParameter(msgSet, "msgSet");
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            i(j, msgSet, true, false, false, loadType);
        }
    }
}
