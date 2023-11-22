package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.lib.socket.msg.TbAtUserInfo;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbReMsgInfo;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTaskInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class sr8<TbMsg extends TbBaseMsg, SdkMsg extends ChatMsg> implements js8<TbMsg, SdkMsg> {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, Class<? extends TbBaseMsg>> a;
    public final qr8 b;
    public final ur8 c;
    public final wr8 d;

    public abstract SdkMsg g(TbMsg tbmsg);

    public abstract TbMsg h(int i, SdkMsg sdkmsg, Map<String, ? extends Object> map);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948161136, "Lcom/baidu/tieba/sr8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948161136, "Lcom/baidu/tieba/sr8;");
                return;
            }
        }
        e = new int[]{102, 109, 110};
    }

    public sr8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedHashMap();
        this.b = new qr8();
        this.c = new ur8();
        this.d = new wr8();
    }

    public final void j(int i, Class<? extends TbBaseMsg> tbMsgClazz) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, tbMsgClazz) == null) {
            Intrinsics.checkNotNullParameter(tbMsgClazz, "tbMsgClazz");
            this.a.put(Integer.valueOf(i), tbMsgClazz);
        }
    }

    public final void k(List<Integer> tbMsgTypeList, Class<? extends TbBaseMsg> tbMsgClazz) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, tbMsgTypeList, tbMsgClazz) == null) {
            Intrinsics.checkNotNullParameter(tbMsgTypeList, "tbMsgTypeList");
            Intrinsics.checkNotNullParameter(tbMsgClazz, "tbMsgClazz");
            for (Number number : tbMsgTypeList) {
                j(number.intValue(), tbMsgClazz);
            }
        }
    }

    public final TbMsg c(ks8<SdkMsg> ks8Var, SdkMsg sdkmsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ks8Var, sdkmsg)) == null) {
            String c = ks8Var.c(sdkmsg);
            Map<String, ? extends Object> b = is8.b(DataExt.toMap(c));
            Object obj = b.get("type");
            if (obj != null) {
                int longValue = (int) ((Long) obj).longValue();
                if (b.containsKey("level")) {
                    b.put(TbBaseMsg.FIELD_FORUM_EXT, DataExt.toMap(DataExt.toEntity(c, TbBaseMsg.c.class)));
                }
                TbMsg h = h(longValue, sdkmsg, b);
                h.setMsgId(sdkmsg.getMsgId());
                h.setMsgKey(m(sdkmsg));
                String senderUid = sdkmsg.getSenderUid();
                Intrinsics.checkNotNullExpressionValue(senderUid, "sdkMsg.senderUid");
                h.setUserId(Long.parseLong(senderUid));
                String nickName = sdkmsg.getNickName();
                if (nickName == null) {
                    nickName = h.getUserName();
                }
                h.setUserName(nickName);
                String portrait = sdkmsg.getPortrait();
                if (portrait == null) {
                    portrait = h.getPortrait();
                }
                h.setPortrait(portrait);
                h.setSessionId(sdkmsg.getContacter());
                return h;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        return (TbMsg) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.js8
    /* renamed from: d */
    public SdkMsg b(ks8<SdkMsg> strategy, TbMsg tbMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, strategy, tbMsg)) == null) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            boolean z = false;
            Map map = null;
            Map d = is8.d(tbMsg, false, 1, null);
            SdkMsg g = g(tbMsg);
            g.setContacter(tbMsg.getSessionId());
            g.setFromUser(AccountManager.getUK(or8.a.e()));
            g.setMsgTime(tbMsg.getMsgTime());
            g.setSendMsgTime(tbMsg.getMsgTime());
            g.setMsgId(tbMsg.getMsgId());
            g.setMsgKey(tbMsg.getMsgKey());
            g.setSenderUid(String.valueOf(tbMsg.getUserId()));
            g.setNickName(tbMsg.getUserName());
            g.setPortrait(tbMsg.getPortrait());
            List<TbAtUserInfo> atUserInfoList = tbMsg.getAtUserInfoList();
            if (!((atUserInfoList == null || atUserInfoList.isEmpty()) ? true : true)) {
                List<TbAtUserInfo> atUserInfoList2 = tbMsg.getAtUserInfoList();
                Intrinsics.checkNotNull(atUserInfoList2);
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(atUserInfoList2, 10));
                for (TbAtUserInfo tbAtUserInfo : atUserInfoList2) {
                    arrayList.add(this.b.a(tbAtUserInfo));
                }
                g.setAtUserList(arrayList);
            }
            TbReMsgInfo reMsgInfo = tbMsg.getReMsgInfo();
            if (reMsgInfo != null) {
                g.setReMsgInfo(this.c.a(reMsgInfo));
            }
            TbTaskInfo taskInfo = tbMsg.getTaskInfo();
            if (taskInfo != null) {
                g.setTaskInfo(this.d.a(taskInfo));
            }
            Object remove = d.remove(TbBaseMsg.FIELD_FORUM_EXT);
            if (remove instanceof Map) {
                map = (Map) remove;
            }
            if (map != null) {
                d.putAll(map);
            }
            strategy.a(g, tbMsg, DataExt.toJson(d));
            return g;
        }
        return (SdkMsg) invokeLL.objValue;
    }

    public final TbMsg e(ks8<SdkMsg> ks8Var, SdkMsg sdkmsg) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, ks8Var, sdkmsg)) == null) {
            String msgContent = sdkmsg.getMsgContent();
            boolean z2 = false;
            if (msgContent != null && msgContent.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                sdkmsg.setMsgContent("{}");
            }
            if (sdkmsg.getNotifyCmd() == 102) {
                String msgContent2 = sdkmsg.getMsgContent();
                Intrinsics.checkNotNullExpressionValue(msgContent2, "sdkMsg.msgContent");
                Map mutableMap = MapsKt__MapsKt.toMutableMap(DataExt.toMap(msgContent2));
                mutableMap.put(TableDefine.MessageColumns.COLUME_SERVICE_TYPE, -7010);
                sdkmsg.setMsgContent(DataExt.toJson(mutableMap));
            }
            String msgContent3 = sdkmsg.getMsgContent();
            Intrinsics.checkNotNullExpressionValue(msgContent3, "sdkMsg.msgContent");
            Map mutableMap2 = MapsKt__MapsKt.toMutableMap(DataExt.toMap(msgContent3));
            Object obj = mutableMap2.get("service_info");
            if (obj == null) {
                obj = new LinkedHashMap();
                mutableMap2.put("service_info", obj);
            }
            Map asMutableMap = TypeIntrinsics.asMutableMap(obj);
            if (sdkmsg.getNotifyCmd() == 110) {
                String contacterId = sdkmsg.getContacterId();
                Intrinsics.checkNotNullExpressionValue(contacterId, "sdkMsg.contacterId");
                long parseLong = Long.parseLong(contacterId);
                Object obj2 = asMutableMap.get("msg_from_baidu_uk");
                if (obj2 != null) {
                    String str = (String) obj2;
                    Object remove = asMutableMap.remove("msg_id");
                    if (remove != null) {
                        long longValue = ((Long) remove).longValue();
                        Object remove2 = asMutableMap.remove("msg_key");
                        if (remove2 != null) {
                            asMutableMap.put("chatroom_id", Long.valueOf(parseLong));
                            asMutableMap.put(TbSysMsg.FIELD_USER_FROM, MapsKt__MapsKt.mutableMapOf(TuplesKt.to("uk", str), TuplesKt.to("username", ""), TuplesKt.to("avatar", "")));
                            asMutableMap.put("ori_emoji_replied_msg_id", Long.valueOf(longValue));
                            asMutableMap.put("ori_emoji_replied_msg_key", (String) remove2);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            String c = ks8Var.c(sdkmsg);
            if (c.length() > 0) {
                z2 = true;
            }
            if (z2) {
                asMutableMap.putAll(DataExt.toMap(c));
            }
            sdkmsg.setMsgContent(DataExt.toJson(mutableMap2));
            if (ArraysKt___ArraysKt.contains(e, sdkmsg.getNotifyCmd())) {
                JSONObject jSONObject = new JSONObject(sdkmsg.getMsgContent());
                int optInt = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
                String serviceInfo = jSONObject.optString("service_info", "{}");
                Intrinsics.checkNotNullExpressionValue(serviceInfo, "serviceInfo");
                TbSysMsg tbSysMsg = (TbSysMsg) h(optInt, sdkmsg, MapsKt__MapsKt.toMutableMap(DataExt.toMap(serviceInfo)));
                tbSysMsg.setSessionId(tbSysMsg.getSysSessionId());
                tbSysMsg.setMsgId(sdkmsg.getMsgId());
                tbSysMsg.setMsgKey(m(sdkmsg));
                TbSysMsg.User userFrom = tbSysMsg.getUserFrom();
                if (userFrom != null) {
                    tbSysMsg.setUserId(userFrom.getUserId());
                    String username = userFrom.getUsername();
                    Intrinsics.checkNotNullExpressionValue(username, "it.username");
                    tbSysMsg.setUserName(username);
                    String portrait = userFrom.getPortrait();
                    if (portrait == null) {
                        portrait = tbSysMsg.getPortrait();
                    } else {
                        Intrinsics.checkNotNullExpressionValue(portrait, "it.portrait ?: tbMsg.portrait");
                    }
                    tbSysMsg.setPortrait(portrait);
                    tbSysMsg.setRole(userFrom.getRole());
                    TbBaseMsg.c forumExt = tbSysMsg.getForumExt();
                    if (forumExt != null) {
                        forumExt.c(userFrom.getForumLevel());
                    }
                }
                return tbSysMsg;
            }
            throw new IllegalStateException("非法状态");
        }
        return (TbMsg) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.js8
    /* renamed from: f */
    public TbMsg a(ks8<SdkMsg> strategy, SdkMsg sdkMsg) {
        InterceptResult invokeLL;
        TbMsg c;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, strategy, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            if (sdkMsg.getMsgType() == 10000) {
                c = e(strategy, sdkMsg);
            } else {
                c = c(strategy, sdkMsg);
            }
            List<IChatRoomEnterListener.AtUserInfo> atUserList = sdkMsg.getAtUserList();
            if (atUserList != null && !atUserList.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                List<IChatRoomEnterListener.AtUserInfo> atUserList2 = sdkMsg.getAtUserList();
                Intrinsics.checkNotNullExpressionValue(atUserList2, "sdkMsg.atUserList");
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(atUserList2, 10));
                for (IChatRoomEnterListener.AtUserInfo it : atUserList2) {
                    qr8 qr8Var = this.b;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(qr8Var.b(it));
                }
                c.addAtUserInfo(arrayList);
            }
            IChatRoomEnterListener.ReMsgInfo reMsgInfo = sdkMsg.getReMsgInfo();
            if (reMsgInfo != null) {
                c.setReMsgInfo(this.c.b(reMsgInfo));
            }
            IChatRoomEnterListener.TaskInfo taskInfo = sdkMsg.getTaskInfo();
            if (taskInfo != null) {
                c.setTaskInfo(this.d.b(taskInfo));
            }
            c.setSdkMsgStatus(strategy.b(sdkMsg));
            c.setOriginSdkMsg(sdkMsg);
            return c;
        }
        return (TbMsg) invokeLL.objValue;
    }

    public final Class<Object> i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return this.a.get(Integer.valueOf(i));
        }
        return (Class) invokeI.objValue;
    }

    public final Class<Object> l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            Class<Object> i2 = i(i);
            if (i2 != null) {
                return i2;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return (Class) invokeI.objValue;
    }

    public final String m(SdkMsg sdkmsg) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, sdkmsg)) == null) {
            String msgKey = sdkmsg.getMsgKey();
            if (msgKey != null && msgKey.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return BIMManager.getBdUKFromBdUid(sdkmsg.getSenderUid()) + sdkmsg.getMsgId();
            }
            String msgKey2 = sdkmsg.getMsgKey();
            Intrinsics.checkNotNullExpressionValue(msgKey2, "{\n            this.msgKey\n        }");
            return msgKey2;
        }
        return (String) invokeL.objValue;
    }
}
