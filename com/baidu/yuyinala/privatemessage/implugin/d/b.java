package com.baidu.yuyinala.privatemessage.implugin.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.account.ILoginStateChangedListener;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserStatusListener;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.BIMGroupManager;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static volatile b oPT;

    /* loaded from: classes10.dex */
    public interface a<T> extends BIMValueCallBack<T> {
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0962b extends IGetUserStatusListener {
    }

    /* loaded from: classes10.dex */
    public interface c extends ILoginListener {
    }

    /* loaded from: classes10.dex */
    public interface d extends com.baidu.yuyinala.privatemessage.implugin.ma.a {
    }

    /* loaded from: classes10.dex */
    public interface e extends ILoginStateChangedListener {
    }

    /* loaded from: classes10.dex */
    public interface f extends ISendMessageListener {
    }

    /* loaded from: classes10.dex */
    public interface g extends IGetUsersProfileBatchListener {
    }

    public static synchronized b ehs() {
        b bVar;
        synchronized (b.class) {
            if (oPT == null) {
                oPT = new b();
            }
            bVar = oPT;
        }
        return bVar;
    }

    public String getBduss(Context context) {
        return SapiAccountManager.getInstance().getSession().bduss;
    }

    public String getUserId(Context context) {
        try {
            return SapiAccountManager.getInstance().getSession().uid;
        } catch (Exception e2) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("PluginHostFactory", "not login");
            return null;
        }
    }

    public Long hu(Context context) {
        return Long.valueOf(AccountManager.getUK(context));
    }

    public void a(Context context, ChatMsg chatMsg, f fVar) {
        ChatMsgManager.sendMessage(context, chatMsg, fVar);
    }

    public void saveMessage(Context context, ChatMsg chatMsg) {
        ChatMsgManager.saveMessage(context, chatMsg);
    }

    public int deleteMsg(Context context, ChatMsg chatMsg) {
        return ChatMsgManager.deleteMsg(context, chatMsg);
    }

    public int markMsgClicked(Context context, ChatMsg chatMsg) {
        return ChatMsgManager.markMsgClicked(context, chatMsg);
    }

    public boolean setAllMsgRead(Context context, int i, long j, boolean z) {
        return IMBoxManager.setAllMsgRead(context, i, j, z);
    }

    public Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i, long j, int i2, ChatMsg chatMsg) {
        return ChatMsgManager.fetchMessageSyncWithState(context, i, j, i2, chatMsg);
    }

    public void a(Context context, ArrayList<Long> arrayList, boolean z, g gVar) {
        BIMManager.getUsersProfiles(context, arrayList, z, gVar);
    }

    public void a(Context context, String str, ArrayList<String> arrayList, a<ArrayList<GroupMember>> aVar) {
        BIMGroupManager.getGroupMember(context, str, arrayList, aVar);
    }

    public String d(Context context, String str, long j) {
        return BIMGroupManager.getNickName(context, str, j);
    }

    public String getCuid(Context context) {
        return BIMManager.getCuid(context);
    }

    public int hv(Context context) {
        return Utility.readIntData(context, Constants.KEY_ENV, 0);
    }

    public void g(Context context, Uri uri) {
    }

    public void c(Context context, Throwable th) {
    }

    public void B(Context context, String str, String str2) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("PluginHostFactory", "sendAPSBroadcast: action=" + str + ", data=" + str2);
    }

    public String hw(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("displayName", com.baidu.yuyinala.privatemessage.implugin.d.a.getDisplayName());
            jSONObject.put(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, "head url");
            jSONObject.put("gender", 1);
            jSONObject.put("agelevel", "");
            jSONObject.put("horoscope", "");
            jSONObject.put("loginbuid", AccountManager.getUid(context));
            jSONObject.put("isVip", 0);
            jSONObject.put("nickname", com.baidu.yuyinala.privatemessage.implugin.d.a.getDisplayName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void a(Context context, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(Long.parseLong(session.uid)));
            BIMManager.getUsersProfiles(context, arrayList, false, iGetUsersProfileBatchListener);
        }
    }

    public void h(Context context, String str, boolean z) {
        try {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("PluginHostFactory", "appid = 405384");
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(Context context, ArrayList<Long> arrayList, InterfaceC0962b interfaceC0962b) {
        ChatUserManagerImpl.getInstance(context).getUsersStatus(arrayList, interfaceC0962b);
    }

    public void a(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
    }

    public void hx(Context context) {
    }

    public int getLoginState(Context context) {
        return AccountManager.getLoginState(context);
    }

    public void a(Context context, e eVar) {
        AccountManager.setLogStateChangedListener(context, eVar);
    }

    public boolean isCuidLogin(Context context) {
        return AccountManager.isCuidLogin(context);
    }

    public boolean eht() {
        return false;
    }

    public void a(Context context, c cVar) {
        AccountManager.retryLogin(context, cVar);
    }

    public void Aq(boolean z) {
    }

    public void ci(String str, int i) {
    }

    public void onEvent(String str, String str2) {
    }

    public void a(String str, d dVar) {
        dVar.onResult(-1);
    }

    public void a(d dVar) {
        dVar.onResult(-1);
    }
}
