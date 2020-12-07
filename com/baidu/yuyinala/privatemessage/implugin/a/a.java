package com.baidu.yuyinala.privatemessage.implugin.a;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.chatmessage.messages.NotifyCustomerMsg;
import com.baidu.android.imsdk.chatmessage.messages.RedPackMsg;
import com.baidu.android.imsdk.chatmessage.messages.SchemaMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.sumeru.universalimageloader.core.assist.FailReason;
import com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener;
import com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingProgressListener;
import com.baidu.yuyinala.privatemessage.implugin.a.a.b;
import com.baidu.yuyinala.privatemessage.implugin.a.a.c;
import com.baidu.yuyinala.privatemessage.implugin.a.a.d;
import com.baidu.yuyinala.privatemessage.implugin.a.a.e;
import com.baidu.yuyinala.privatemessage.implugin.a.a.f;
import com.baidu.yuyinala.privatemessage.implugin.a.a.m;
import com.baidu.yuyinala.privatemessage.implugin.a.a.n;
import com.baidu.yuyinala.privatemessage.implugin.a.a.s;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.d.b;
import com.baidu.yuyinala.privatemessage.implugin.f.g;
import com.baidu.yuyinala.privatemessage.implugin.f.h;
import com.baidu.yuyinala.privatemessage.implugin.f.k;
import com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat;
import com.baidu.yuyinala.privatemessage.implugin.ui.common.EventDispatchRelativeLayout;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
import com.baidu.yuyinala.privatemessage.model.message.SingleGraphicTextMsgExt;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BaseAdapter implements b.a {
    private LayoutInflater mInflater;
    private ArrayList<ChatMsg> mMsgList;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.c oLA;
    private ActivityChat oLm;
    private b oLo;
    private c oLp;
    private InterfaceC0963a oLq;
    private ActivityChat.c oLr;
    private d oLs;
    private e oLu;
    private ClipboardManager oLv;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b oLw;
    private String oLy;
    private com.baidu.yuyinala.privatemessage.implugin.util.audio.a oLz;
    private List<String> oLn = new ArrayList();
    private Set<ChatMsg> oLt = new HashSet();
    private final int nON = 120;
    private long oLx = 0;

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0963a {
        void OX(int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void f(View view, int i, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void b(ChatMsg chatMsg);

        void c(ChatMsg chatMsg);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void OY(int i);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void ekX();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.b.a
    public void a(View view, int i, final ChatMsg chatMsg) {
        this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                long contacter = chatMsg.getContacter();
                if (a.this.mMsgList != null && !a.this.mMsgList.isEmpty()) {
                    Iterator it = a.this.mMsgList.iterator();
                    while (it.hasNext()) {
                        ChatMsg chatMsg2 = (ChatMsg) it.next();
                        if (chatMsg2.getContacter() == contacter && chatMsg2.getNotifyCmd() != chatMsg.getNotifyCmd()) {
                            chatMsg2.setNotifyCmd(chatMsg.getNotifyCmd());
                        }
                    }
                    a.this.notifyDataSetChanged();
                }
            }
        });
    }

    public a(ActivityChat activityChat, ArrayList<ChatMsg> arrayList, b bVar, c cVar, InterfaceC0963a interfaceC0963a, d dVar, ActivityChat.c cVar2, String str) {
        this.oLm = activityChat;
        this.mMsgList = arrayList;
        this.oLo = bVar;
        this.oLp = cVar;
        this.oLq = interfaceC0963a;
        this.oLs = dVar;
        this.oLy = str;
        this.oLu = new e(activityChat);
        this.mInflater = (LayoutInflater) this.oLm.getSystemService("layout_inflater");
        this.oLv = (ClipboardManager) this.oLm.getSystemService("clipboard");
        this.oLz = new com.baidu.yuyinala.privatemessage.implugin.util.audio.a(activityChat);
        this.oLr = cVar2;
    }

    public void a(com.baidu.yuyinala.privatemessage.implugin.ui.activity.c cVar) {
        this.oLA = cVar;
    }

    /* loaded from: classes4.dex */
    private class e {
        private GestureDetector mGestureDetector;
        private GestureDetector.OnGestureListener oLW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.e.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.oLo != null) {
                    a.this.oLo.f(e.this.view, e.this.position, true);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                a.this.l(e.this.position, e.this.view);
            }
        };
        private int position;
        private View view;

        public e(Context context) {
            this.mGestureDetector = new GestureDetector(context, this.oLW);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mGestureDetector.onTouchEvent(motionEvent);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mMsgList == null) {
            return 0;
        }
        return this.mMsgList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mMsgList == null) {
            return null;
        }
        return this.mMsgList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        final ChatMsg chatMsg = this.mMsgList.get(i);
        long fromUser = chatMsg.getFromUser();
        int i2 = -1;
        View view2 = null;
        if (isNotice(chatMsg)) {
            f a2 = b.he(this.oLm.getApplicationContext()).a(this.oLm, this.mInflater, view, chatMsg.getMsgType());
            if (a2 != null) {
                a(i, a2.oMa);
                view = a2.getConvertView();
                a2.b(this.oLm, chatMsg);
            }
            a(chatMsg, a2, i == getCount() + (-1));
        } else {
            int msgType = chatMsg.getMsgType();
            if (8 == msgType && (chatMsg instanceof SignleGraphicTextMsg)) {
                i2 = ((SignleGraphicTextMsg) chatMsg).getSubType();
            }
            if (9 == msgType || 12 == msgType || ((8 == msgType && i2 == 0) || 21 == msgType)) {
                c a3 = b.he(this.oLm.getApplicationContext()).a(this.oLm, this.mInflater, i, chatMsg, view, this);
                a(i, a3.oMa);
                View contentView = a3.getContentView();
                view = a3.getConvertView();
                a(i, contentView, null, msgType);
                if (21 != msgType) {
                    view2 = contentView;
                    imageView = null;
                } else {
                    E(view, i);
                    view2 = contentView;
                    imageView = null;
                }
            } else if (fromUser == ChatInfo.oNz) {
                e a4 = b.he(this.oLm.getApplicationContext()).a(this.oLm, this.mInflater, chatMsg, view);
                if (a4 != null) {
                    view2 = a4.getContentView();
                    a(i, a4.oMa);
                    ImageView imageView2 = a4.oMd;
                    if (a4.oMf != null) {
                        a4.oMf.setVisibility(ChatInfo.vip == 1 ? 0 : 4);
                    }
                    view = a4.getConvertView();
                    imageView = a4.oMg;
                    if (imageView2 != null) {
                        b(ChatInfo.oNA, imageView2);
                        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.12
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                int loginType = BIMManager.getLoginType(a.this.oLm);
                                if (loginType == 6 && ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) {
                                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", "loginType = " + loginType + ", and headView clicked");
                                    return;
                                }
                                new JSONObject();
                                if (!ChatInfo.oNH) {
                                    a.this.ha(com.baidu.yuyinala.privatemessage.implugin.d.a.elf(), "ugc");
                                } else {
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(true, "", "", "", "", "", "", "");
                                }
                            }
                        });
                    }
                }
                imageView = null;
            } else {
                final d b2 = b.he(this.oLm.getApplicationContext()).b(this.oLm, this.mInflater, chatMsg, view);
                if (b2 != null) {
                    a(i, b2.oMa);
                    View contentView2 = b2.getContentView();
                    view = b2.getConvertView();
                    final ImageView imageView3 = b2.oMd;
                    if (imageView3 != null) {
                        switch (ChatInfo.oNx) {
                            case DUZHAN:
                                com.baidu.yuyinala.privatemessage.implugin.util.b.hr(this.oLm);
                                ImageLoader.getInstance().displayImage(ChatInfo.mPainfo.getAvatar(), imageView3, com.baidu.yuyinala.privatemessage.implugin.util.b.enO());
                                break;
                            case B2C:
                                com.baidu.yuyinala.privatemessage.implugin.util.b.hr(this.oLm);
                                ImageLoader.getInstance().displayImage(ChatInfo.oNB, imageView3, com.baidu.yuyinala.privatemessage.implugin.util.b.enO());
                                break;
                            case C2C:
                                b(ChatInfo.oNB, imageView3);
                                break;
                            case GROUP:
                                if (b2.jbt != null && !TextUtils.isEmpty(chatMsg.getSenderUid())) {
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    arrayList.add(chatMsg.getSenderUid());
                                    b2.jbt.setVisibility(0);
                                    if (ChatInfo.kpi == 2) {
                                        String starContentExtra = chatMsg.getStarContentExtra();
                                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", "STAR ext is " + starContentExtra);
                                        if (!TextUtils.isEmpty(starContentExtra)) {
                                            try {
                                                JSONObject jSONObject = new JSONObject(starContentExtra);
                                                String optString = jSONObject.optString("name");
                                                if (!TextUtils.isEmpty(optString)) {
                                                    if (optString.length() > 10 && optString.getBytes().length > optString.length()) {
                                                        optString = optString.substring(0, 10);
                                                    } else if (optString.length() > 16) {
                                                        optString = optString.substring(0, 15);
                                                    }
                                                    b2.jbt.setText(optString);
                                                } else if (chatMsg.getSenderUid().length() > 4) {
                                                    b2.jbt.setText(chatMsg.getSenderUid().substring(0, 4));
                                                } else {
                                                    b2.jbt.setText(chatMsg.getSenderUid());
                                                }
                                                String optString2 = jSONObject.optString("portrait");
                                                if (!TextUtils.isEmpty(optString2)) {
                                                    optString2 = optString2.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
                                                }
                                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", " star member portrait is " + optString2);
                                                b(optString2, imageView3);
                                                int optInt = jSONObject.optInt("sex", 1);
                                                int optInt2 = jSONObject.optInt("isVip", 0);
                                                b2.moi.setVisibility(8);
                                                b2.moi.setText("");
                                                b2.oMe.setText("");
                                                b2.oMe.setVisibility(8);
                                                JSONArray jSONArray = jSONObject.getJSONArray(CommandMessage.TYPE_TAGS);
                                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                                    if (i3 == 0) {
                                                        b2.moi.setVisibility(0);
                                                        b2.moi.setText(jSONArray.getString(i3));
                                                    }
                                                    if (i3 == 1) {
                                                        b2.oMe.setVisibility(0);
                                                        b2.oMe.setText(jSONArray.getString(i3));
                                                    }
                                                    if (optInt == 1) {
                                                        b2.oMe.setBackgroundResource(ThemeManager.U(this.oLm, a.e.bd_im_star_boy));
                                                        b2.moi.setBackgroundResource(ThemeManager.U(this.oLm, a.e.bd_im_star_boy));
                                                    } else {
                                                        b2.moi.setBackgroundResource(ThemeManager.U(this.oLm, a.e.bd_im_star_girl));
                                                        b2.oMe.setBackgroundResource(ThemeManager.U(this.oLm, a.e.bd_im_star_girl));
                                                    }
                                                    b2.moi.setTextColor(ThemeManager.U(this.oLm, a.c.bd_im_white));
                                                    b2.oMe.setTextColor(ThemeManager.U(this.oLm, a.c.bd_im_white));
                                                }
                                                if (b2.oMf != null) {
                                                    b2.oMf.setVisibility(optInt2 == 1 ? 0 : 4);
                                                    break;
                                                }
                                            } catch (JSONException e2) {
                                                e2.printStackTrace();
                                                break;
                                            }
                                        }
                                    } else {
                                        String jsonContent = chatMsg.getJsonContent();
                                        boolean z = false;
                                        try {
                                            if (!TextUtils.isEmpty(jsonContent)) {
                                                z = true;
                                                JSONObject jSONObject2 = new JSONObject(new JSONObject(jsonContent).getString("mvgroupext"));
                                                String optString3 = jSONObject2.optString("name");
                                                if (!TextUtils.isEmpty(optString3)) {
                                                    if (optString3.length() > 10 && optString3.getBytes().length > optString3.length()) {
                                                        optString3 = optString3.substring(0, 10);
                                                    } else if (optString3.length() > 16) {
                                                        optString3 = optString3.substring(0, 15);
                                                    }
                                                    b2.jbt.setText(optString3);
                                                } else if (chatMsg.getSenderUid().length() > 4) {
                                                    b2.jbt.setText(chatMsg.getSenderUid().substring(0, 4));
                                                } else {
                                                    b2.jbt.setText(chatMsg.getSenderUid());
                                                }
                                                String optString4 = jSONObject2.optString("portrait");
                                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", " group member portrait is " + optString4);
                                                b(optString4, imageView3);
                                                b2.moi.setVisibility(8);
                                                b2.moi.setText("");
                                                b2.oMe.setText("");
                                                b2.oMe.setVisibility(8);
                                            }
                                        } catch (JSONException e3) {
                                            z = false;
                                        }
                                        if (!z) {
                                            com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(this.oLm.getApplicationContext(), String.valueOf(ChatInfo.mContacter), arrayList, new b.a<ArrayList<GroupMember>>() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.16
                                                /* JADX DEBUG: Method merged with bridge method */
                                                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                                public void onResult(int i4, String str, final ArrayList<GroupMember> arrayList2) {
                                                    if (i4 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                                                        a.this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.16.1
                                                            @Override // java.lang.Runnable
                                                            public void run() {
                                                                String name = ((GroupMember) arrayList2.get(0)).getName();
                                                                if (name != null) {
                                                                    if (name.length() > 10 && name.getBytes().length > name.length()) {
                                                                        name = name.substring(0, 10);
                                                                    } else if (name.length() > 16) {
                                                                        name = name.substring(0, 15);
                                                                    }
                                                                    b2.jbt.setText(name);
                                                                } else if (chatMsg.getSenderUid().length() > 4) {
                                                                    b2.jbt.setText(chatMsg.getSenderUid().substring(0, 4));
                                                                } else {
                                                                    b2.jbt.setText(chatMsg.getSenderUid());
                                                                }
                                                                a.this.b(((GroupMember) arrayList2.get(0)).getPortrait(), imageView3);
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                            break;
                                        }
                                    }
                                }
                                break;
                        }
                        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.17
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                int i4 = AnonymousClass15.oLM[ChatInfo.oNx.ordinal()];
                                a.this.ha(String.valueOf(ChatInfo.mUid), ChatInfo.oNJ);
                            }
                        });
                    }
                    if (msgType == 1) {
                        a(chatMsg, (n) b2);
                    }
                    imageView = null;
                    view2 = contentView2;
                }
                imageView = null;
            }
            a(i, view2, imageView, msgType);
        }
        return view;
    }

    private void E(final View view, final int i) {
        ChatMsg chatMsg = this.mMsgList.get(i);
        if (chatMsg.getMsgType() == 21 && chatMsg.getNotifyCmd() <= -1) {
            long contacter = chatMsg.getContacter();
            h hZ = k.hm(this.oLm).hZ(contacter);
            if (hZ != null && hZ.getId() == contacter) {
                this.mMsgList.get(i).setNotifyCmd(hZ.elj());
                this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.18
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.F(view, i);
                    }
                });
                return;
            }
            com.baidu.yuyinala.privatemessage.implugin.b.b.hg(this.oLm).C(new com.baidu.yuyinala.privatemessage.implugin.f.d(this.oLm, contacter, new g() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.19
                @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
                public void d(int i2, String str, long j) {
                    h hVar = new h();
                    hVar.setPaid(j);
                    hVar.YB(str);
                    if (hVar.isDataValid()) {
                        k.hm(a.this.oLm).a(j, hVar);
                        ((ChatMsg) a.this.mMsgList.get(i)).setNotifyCmd(hVar.elj());
                        a.this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.F(view, i);
                            }
                        });
                    }
                }
            }));
        }
    }

    private boolean isNotice(ChatMsg chatMsg) {
        if (chatMsg.getMsgType() == 0) {
            if (new com.baidu.yuyinala.privatemessage.model.message.b((TextMsg) chatMsg).eoa()) {
                return true;
            }
        } else if (2 == chatMsg.getCategory() || chatMsg.getMsgType() == -1) {
            return true;
        } else {
            if ((chatMsg.getMsgType() > 1000 && chatMsg.getMsgType() < 1013) || chatMsg.getMsgType() == 2001 || chatMsg.getMsgType() == 2010 || chatMsg.getMsgType() == 22) {
                return true;
            }
        }
        return false;
    }

    private void a(ChatMsg chatMsg, final f fVar, boolean z) {
        String str;
        URLSpan[] uRLSpanArr;
        Spanned spanned = null;
        fVar.getContentView().setVisibility(0);
        if (TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.d.b.elg().getUserId(this.oLm.getApplicationContext()))) {
        }
        TextView textView = fVar.getTextView();
        if (chatMsg.getMsgType() == 22) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("NotifyTxtItem", "Schema: " + ((SchemaMsg) chatMsg).getText());
            try {
                spanned = Html.fromHtml(((SchemaMsg) chatMsg).getText());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (spanned != null && !TextUtils.isEmpty(spanned.toString())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("NotifyTxtItem", "strBuilder: " + ((Object) spannableStringBuilder));
                for (final URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class)) {
                    int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
                    int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
                    spannableStringBuilder.removeSpan(uRLSpan);
                    spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.20
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("NotifyTxtItem", "schema: " + uRLSpan.getURL());
                        }
                    }, spanStart, spanEnd, 33);
                }
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setText(spannableStringBuilder);
                textView.setFocusableInTouchMode(true);
                textView.setFocusable(true);
                textView.setClickable(true);
                textView.setLongClickable(true);
                textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.21
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        f subViewLongClickListener;
                        View contentView = fVar.getContentView();
                        if ((contentView instanceof EventDispatchRelativeLayout) && (subViewLongClickListener = ((EventDispatchRelativeLayout) contentView).getSubViewLongClickListener()) != null) {
                            subViewLongClickListener.ekX();
                            return true;
                        }
                        return true;
                    }
                });
                return;
            }
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (chatMsg.getMsgType() == 2001) {
            a("", textView, "invite_link");
        } else if (chatMsg.getMsgType() == 0) {
            if (new com.baidu.yuyinala.privatemessage.model.message.b((TextMsg) chatMsg).eoa()) {
                if (chatMsg instanceof TextMsg) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("NotifyTxtItem", "Schema: " + ((TextMsg) chatMsg).getText());
                    try {
                        str = ((TextMsg) chatMsg).getText();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    if (str == null && !TextUtils.isEmpty(str.toString())) {
                        a(str.toString(), textView, "invite_link");
                        return;
                    }
                }
                str = null;
                if (str == null) {
                }
            }
        } else {
            if (2 == chatMsg.getCategory() || -1 == chatMsg.getMsgType()) {
                textView.setText(((NotifyCustomerMsg) chatMsg).getText());
            }
            if (!TextUtils.isEmpty(null) && arrayList.size() > 0) {
                a(arrayList, (String) null, textView);
            } else {
                textView.setText((CharSequence) null);
            }
        }
    }

    private void a(ArrayList<String> arrayList, final String str, final TextView textView) {
        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(this.oLm.getApplicationContext(), String.valueOf(ChatInfo.mContacter), arrayList, new b.a<ArrayList<GroupMember>>() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i, String str2, final ArrayList<GroupMember> arrayList2) {
                if (i == 0 && arrayList2 != null) {
                    a.this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.22.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatAdapter", arrayList2.toString());
                            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatAdapter", str);
                            String str3 = str;
                            Iterator it = arrayList2.iterator();
                            while (true) {
                                String str4 = str3;
                                if (it.hasNext()) {
                                    GroupMember groupMember = (GroupMember) it.next();
                                    if (groupMember.getBduid() > 0 && groupMember.getName() != null) {
                                        str4 = str4.replace(String.valueOf(groupMember.getBduid()), groupMember.getName());
                                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", groupMember.getBduid() + "-->" + groupMember.getName());
                                    }
                                    str3 = str4;
                                } else {
                                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatAdapter", str4);
                                    textView.setText(str4);
                                    return;
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    private void a(ChatMsg chatMsg, final n nVar) {
        final ImageView imageView = nVar.jAD;
        String thumbUrl = ((ImageMsg) chatMsg).getThumbUrl();
        String remoteUrl = ((ImageMsg) chatMsg).getRemoteUrl();
        if (TextUtils.isEmpty(thumbUrl)) {
            thumbUrl = remoteUrl;
        }
        com.baidu.yuyinala.privatemessage.implugin.util.b.hr(this.oLm);
        ImageLoader.getInstance().displayImage(thumbUrl, imageView, com.baidu.yuyinala.privatemessage.implugin.util.b.enQ(), new ImageLoadingListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.2
            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                if (!a.this.oLn.contains(str)) {
                    nVar.elb();
                    nVar.ekZ();
                }
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                nVar.elc();
                nVar.ela();
                a.this.oLn.add(str);
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                if (bitmap != null && bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
                    int[] d2 = com.baidu.yuyinala.privatemessage.implugin.util.a.b.d(a.this.oLm.getBaseContext(), bitmap.getWidth(), bitmap.getHeight());
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = d2[0];
                    layoutParams.height = d2[1];
                    imageView.setLayoutParams(layoutParams);
                }
                nVar.elc();
                nVar.ela();
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingCancelled(String str, View view) {
                nVar.elc();
                nVar.ela();
            }
        }, new ImageLoadingProgressListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.3
            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingProgressListener
            public void onProgressUpdate(String str, View view, int i, int i2) {
                nVar.elb();
                nVar.ekZ();
            }
        });
    }

    private void a(int i, TextView textView) {
        if (textView != null) {
            if (i < 0 || i >= this.mMsgList.size()) {
                textView.setVisibility(8);
            } else if (OW(i)) {
                long msgTime = this.mMsgList.get(i).getMsgTime();
                if (msgTime == 0) {
                    msgTime = System.currentTimeMillis();
                }
                String g = com.baidu.yuyinala.privatemessage.implugin.util.f.g(this.oLm, msgTime);
                textView.setVisibility(0);
                textView.setText(g);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    private boolean OW(int i) {
        if (this.oLx != 0 && this.mMsgList.get(i).getMsgId() == this.oLx) {
            this.oLx = 0L;
            return true;
        } else if (this.oLx == 0 && i == 0) {
            this.oLx = this.mMsgList.get(i).getMsgId();
            return true;
        } else if (i > 0) {
            long msgTime = this.mMsgList.get(i).getMsgTime();
            long msgTime2 = this.mMsgList.get(i - 1).getMsgTime();
            return (Long.valueOf(msgTime).toString().length() == 13 ? msgTime / 1000 : msgTime) - (Long.valueOf(msgTime2).toString().length() == 13 ? msgTime2 / 1000 : msgTime2) >= 120;
        } else {
            return true;
        }
    }

    public void aU(Object obj) {
        this.oLz.requestFocus();
        Object tag = ((View) obj).getTag();
        if (tag != null) {
            if (tag instanceof m) {
                ((m) tag).startAnim();
            } else if (tag instanceof s) {
                ((s) tag).startAnim();
            }
        }
    }

    public void aV(Object obj) {
        this.oLz.enT();
        Object tag = ((View) obj).getTag();
        if (tag != null) {
            if (tag instanceof m) {
                ((m) tag).stopAnim();
            } else if (tag instanceof s) {
                ((s) tag).stopAnim();
            }
        }
    }

    public void b(String str, ImageView imageView) {
        if (str != null && imageView != null) {
            com.baidu.yuyinala.privatemessage.implugin.util.b.hr(this.oLm.getApplicationContext());
            ImageLoader.getInstance().displayImage(str, imageView, com.baidu.yuyinala.privatemessage.implugin.util.b.enP());
        }
    }

    private void a(final int i, final View view, ImageView imageView, final int i2) {
        if (view != null) {
            if ((i2 == 0 || i2 == 18 || i2 == 10000 || i2 == 16 || i2 == 8) && (view instanceof EventDispatchRelativeLayout)) {
                ((EventDispatchRelativeLayout) view).setSubviewLongClickListener(new f() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.4
                    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
                    public void ekX() {
                        a.this.l(i, view);
                    }
                });
            } else if (i2 == 9) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("Adapter", "do nothing");
            } else if (i2 == 12) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("Adapter", "do nothing");
            } else {
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.5
                    @Override // android.view.View.OnTouchListener
                    @SuppressLint({"ClickableViewAccessibility"})
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        a.this.oLu.view = view2;
                        a.this.oLu.position = i;
                        if (i2 == 16) {
                            if (motionEvent.getAction() == 0) {
                                view2.getBackground().setAlpha(120);
                            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 10 || motionEvent.getAction() == 3) {
                                view2.getBackground().setAlpha(255);
                            }
                        }
                        a.this.oLu.onTouchEvent(motionEvent);
                        return false;
                    }
                });
            }
        }
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mMsgList != null && i < a.this.mMsgList.size() && i < a.this.mMsgList.size()) {
                        a.this.oLp.b((ChatMsg) a.this.mMsgList.get(i));
                    }
                }
            });
        }
        if (this.oLw != null) {
            this.oLw.emI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final int i, View view) {
        if (i >= this.mMsgList.size()) {
            LogUtils.e("ChatAdapter", "position error");
            return;
        }
        final ChatMsg chatMsg = this.mMsgList.get(i);
        if (chatMsg.getMsgType() != 100 && chatMsg.getMsgType() != 21) {
            if (chatMsg.getMsgType() == 0 || 8 == chatMsg.getMsgType() || 16 == chatMsg.getMsgType()) {
                if (chatMsg instanceof SignleGraphicTextMsg) {
                    if (new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).enZ() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE) {
                        a(view, chatMsg, i);
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(1, "复制"));
                if (ChatInfo.kpi == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oLy)) {
                    arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
                }
                arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                this.oLw = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                this.oLw.a(this.oLm, view, arrayList, 1);
                this.oLw.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.7
                    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                    @SuppressLint({"NewApi"})
                    public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                        if (i3 == 1) {
                            if (chatMsg instanceof SignleGraphicTextMsg) {
                                a.this.oLv.setText(((SignleGraphicTextMsg) chatMsg).getCovers());
                            } else if (chatMsg instanceof RedPackMsg) {
                                a.this.oLv.setText(a.this.oLm.getString(a.h.bd_im_red_packet_default_text));
                            } else if (chatMsg instanceof TextMsg) {
                                a.this.oLv.setText(((TextMsg) chatMsg).getText());
                            }
                        } else if (i3 == 4) {
                            a.this.oLp.c((ChatMsg) a.this.mMsgList.get(i));
                        } else if (i3 == 2) {
                            a.this.oLq.OX(i);
                        } else if (i3 == 5) {
                            a.this.oLs.OY(i);
                        }
                        a.this.oLw = null;
                    }
                });
            } else if (13 != chatMsg.getMsgType()) {
                if (1 == chatMsg.getMsgType() || ((8 == chatMsg.getMsgType() && ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) || 3 == chatMsg.getMsgType())) {
                    ArrayList arrayList2 = new ArrayList();
                    if (ChatInfo.kpi == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oLy)) {
                        arrayList2.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
                    }
                    arrayList2.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                    this.oLw = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                    this.oLw.a(this.oLm, view, arrayList2, 1);
                    this.oLw.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.8
                        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                        public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                            if (i3 == 4) {
                                a.this.oLp.c(chatMsg);
                            } else if (i3 == 2) {
                                a.this.oLq.OX(i);
                            } else if (i3 == 5) {
                                a.this.oLs.OY(i);
                            }
                            a.this.oLw = null;
                        }
                    });
                } else if (10000 == chatMsg.getMsgType() || 18 == chatMsg.getMsgType()) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                    this.oLw = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                    this.oLw.a(this.oLm, view, arrayList3, 1);
                    this.oLw.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.9
                        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                        public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                            if (i3 == 2) {
                                a.this.oLq.OX(i);
                            }
                            a.this.oLw = null;
                        }
                    });
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    if (ChatInfo.kpi == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oLy)) {
                        arrayList4.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
                    }
                    arrayList4.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                    this.oLw = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                    this.oLw.a(this.oLm, view, arrayList4, 1);
                    this.oLw.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.10
                        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                        public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                            if (i3 == 2) {
                                a.this.oLq.OX(i);
                            } else if (i3 == 5) {
                                a.this.oLs.OY(i);
                            }
                            a.this.oLw = null;
                        }
                    });
                }
            }
        }
    }

    private void a(View view, final ChatMsg chatMsg, final int i) {
        ArrayList arrayList = new ArrayList();
        if (ChatInfo.kpi == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oLy)) {
            arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
        }
        arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
        this.oLw = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
        this.oLw.a(this.oLm, view, arrayList, 1);
        this.oLw.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.11
            @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
            public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                if (i3 == 4) {
                    a.this.oLp.c(chatMsg);
                } else if (i3 == 2) {
                    a.this.oLq.OX(i);
                } else if (i3 == 5) {
                    a.this.oLs.OY(i);
                }
                a.this.oLw = null;
            }
        });
    }

    public void F(View view, int i) {
        getView(i, view, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(String str, String str2) {
        String str3 = "";
        String str4 = "";
        if (this.oLm instanceof ActivityChat) {
            str3 = this.oLm.getLiveId();
            str4 = this.oLm.getGroupId();
        }
        ExtraParamsManager.getEncryptionUserId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig((Context) this.oLm.getActivity(), str, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, 0L, 0L, 0L, 0, str4, str3, false, (String) null, (String) null, (String) null, (String) null, (String) null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    private void a(final String str, final TextView textView, final String str2) {
        String str3;
        String str4;
        final String str5;
        final String str6 = "";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 == "invite_link") {
            str3 = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.elQ();
            str4 = "恭喜你已创建粉丝群，";
            str5 = "fsq_invite_prompt";
        } else if (str2 == "greet_link") {
            str6 = "new";
            str3 = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.elM();
            str4 = "您已加入群聊，";
            str5 = "fsq_join_prompt";
        } else if (str2 != "welcom_link") {
            str3 = "";
            str4 = "";
            str5 = "";
        } else {
            this.oLm.a(str, new com.baidu.yuyinala.privatemessage.implugin.ui.activity.b() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.13
                @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.b
                public void Yw(String str7) {
                    if (TextUtils.isEmpty(str7)) {
                        str7 = str;
                    }
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    String str8 = str7 + "已加入群聊，";
                    String elN = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.elN();
                    spannableStringBuilder2.append((CharSequence) str8);
                    spannableStringBuilder2.append((CharSequence) elN);
                    spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.13.1
                        @Override // android.text.style.ClickableSpan
                        public void onClick(@NonNull View view) {
                            a.this.ha(str, ChatInfo.oNJ);
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(@NonNull TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(Color.parseColor("#3C9AF8"));
                            textPaint.setUnderlineText(false);
                            textPaint.clearShadowLayer();
                        }
                    }, 0, str7.length(), 33);
                    spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.13.2
                        @Override // android.text.style.ClickableSpan
                        public void onClick(@NonNull View view) {
                            if (a.this.oLA != null) {
                                a.this.oLA.YE(str2);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(@NonNull TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(Color.parseColor("#3C9AF8"));
                            textPaint.setUnderlineText(false);
                            textPaint.clearShadowLayer();
                        }
                    }, str8.length(), str8.length() + elN.length(), 33);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setText(spannableStringBuilder2);
                    textView.setFocusableInTouchMode(true);
                    textView.setFocusable(true);
                    textView.setClickable(true);
                    textView.setLongClickable(true);
                    textView.setHighlightColor(Color.parseColor("#00000000"));
                }
            });
            return;
        }
        if (str2 != "welcom_link") {
            com.baidu.yuyinala.privatemessage.implugin.a.j(com.baidu.yuyinala.privatemessage.implugin.a.b("display", str5, com.baidu.yuyinala.privatemessage.implugin.a.ekV().bip(), com.baidu.yuyinala.privatemessage.implugin.a.ekV().getTag(), null, null, com.baidu.yuyinala.privatemessage.implugin.a.ekV().ekT(), com.baidu.yuyinala.privatemessage.implugin.a.ekV().ekU(), str6, null, null, null), false);
            spannableStringBuilder.append((CharSequence) str4);
            spannableStringBuilder.append((CharSequence) str3);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.14
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                    com.baidu.yuyinala.privatemessage.implugin.a.j(com.baidu.yuyinala.privatemessage.implugin.a.b("click", str5, com.baidu.yuyinala.privatemessage.implugin.a.ekV().bip(), com.baidu.yuyinala.privatemessage.implugin.a.ekV().getTag(), null, null, com.baidu.yuyinala.privatemessage.implugin.a.ekV().ekT(), com.baidu.yuyinala.privatemessage.implugin.a.ekV().ekU(), str6, null, null, null), false);
                    if (a.this.oLA != null) {
                        a.this.oLA.YE(str2);
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(Color.parseColor("#3C9AF8"));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            }, str4.length(), spannableStringBuilder.length(), 33);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(spannableStringBuilder);
            textView.setFocusableInTouchMode(true);
            textView.setFocusable(true);
            textView.setClickable(true);
            textView.setLongClickable(true);
            textView.setHighlightColor(Color.parseColor("#00000000"));
        }
    }
}
