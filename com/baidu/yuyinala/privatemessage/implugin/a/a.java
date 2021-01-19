package com.baidu.yuyinala.privatemessage.implugin.a;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import androidx.annotation.NonNull;
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
/* loaded from: classes10.dex */
public class a extends BaseAdapter implements b.a {
    private LayoutInflater mInflater;
    private ArrayList<ChatMsg> mMsgList;
    private ActivityChat oMW;
    private b oMY;
    private c oMZ;
    private InterfaceC0960a oNa;
    private ActivityChat.c oNb;
    private d oNc;
    private e oNe;
    private ClipboardManager oNf;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b oNg;
    private String oNi;
    private com.baidu.yuyinala.privatemessage.implugin.util.audio.a oNj;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.c oNk;
    private List<String> oMX = new ArrayList();
    private Set<ChatMsg> oNd = new HashSet();
    private final int nNG = 120;
    private long oNh = 0;

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0960a {
        void Nf(int i);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void g(View view, int i, boolean z);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void b(ChatMsg chatMsg);

        void c(ChatMsg chatMsg);
    }

    /* loaded from: classes10.dex */
    public interface d {
        void Ng(int i);
    }

    /* loaded from: classes10.dex */
    public interface f {
        void ehj();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.b.a
    public void a(View view, int i, final ChatMsg chatMsg) {
        this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.1
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

    public a(ActivityChat activityChat, ArrayList<ChatMsg> arrayList, b bVar, c cVar, InterfaceC0960a interfaceC0960a, d dVar, ActivityChat.c cVar2, String str) {
        this.oMW = activityChat;
        this.mMsgList = arrayList;
        this.oMY = bVar;
        this.oMZ = cVar;
        this.oNa = interfaceC0960a;
        this.oNc = dVar;
        this.oNi = str;
        this.oNe = new e(activityChat);
        this.mInflater = (LayoutInflater) this.oMW.getSystemService("layout_inflater");
        this.oNf = (ClipboardManager) this.oMW.getSystemService("clipboard");
        this.oNj = new com.baidu.yuyinala.privatemessage.implugin.util.audio.a(activityChat);
        this.oNb = cVar2;
    }

    public void a(com.baidu.yuyinala.privatemessage.implugin.ui.activity.c cVar) {
        this.oNk = cVar;
    }

    /* loaded from: classes10.dex */
    private class e {
        private GestureDetector mGestureDetector;
        private GestureDetector.OnGestureListener oNF = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.e.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.oMY != null) {
                    a.this.oMY.g(e.this.view, e.this.position, true);
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
            this.mGestureDetector = new GestureDetector(context, this.oNF);
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
            f a2 = b.hr(this.oMW.getApplicationContext()).a(this.oMW, this.mInflater, view, chatMsg.getMsgType());
            if (a2 != null) {
                a(i, a2.oNJ);
                view = a2.getConvertView();
                a2.b(this.oMW, chatMsg);
            }
            a(chatMsg, a2, i == getCount() + (-1));
        } else {
            int msgType = chatMsg.getMsgType();
            if (8 == msgType && (chatMsg instanceof SignleGraphicTextMsg)) {
                i2 = ((SignleGraphicTextMsg) chatMsg).getSubType();
            }
            if (9 == msgType || 12 == msgType || ((8 == msgType && i2 == 0) || 21 == msgType)) {
                c a3 = b.hr(this.oMW.getApplicationContext()).a(this.oMW, this.mInflater, i, chatMsg, view, this);
                a(i, a3.oNJ);
                view2 = a3.getContentView();
                view = a3.getConvertView();
                a(i, view2, null, msgType);
                if (21 == msgType) {
                    J(view, i);
                    imageView = null;
                    a(i, view2, imageView, msgType);
                }
                imageView = null;
                a(i, view2, imageView, msgType);
            } else if (fromUser == ChatInfo.oPi) {
                e a4 = b.hr(this.oMW.getApplicationContext()).a(this.oMW, this.mInflater, chatMsg, view);
                if (a4 != null) {
                    view2 = a4.getContentView();
                    a(i, a4.oNJ);
                    ImageView imageView2 = a4.oNM;
                    if (a4.oNO != null) {
                        a4.oNO.setVisibility(ChatInfo.vip == 1 ? 0 : 4);
                    }
                    view = a4.getConvertView();
                    imageView = a4.oNP;
                    if (imageView2 != null) {
                        c(ChatInfo.oPj, imageView2);
                        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.12
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                int loginType = BIMManager.getLoginType(a.this.oMW);
                                if (loginType == 6 && ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) {
                                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", "loginType = " + loginType + ", and headView clicked");
                                    return;
                                }
                                new JSONObject();
                                if (!ChatInfo.oPr) {
                                    a.this.gX(com.baidu.yuyinala.privatemessage.implugin.d.a.ehr(), "ugc");
                                } else {
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(true, "", "", "", "", "", "", "");
                                }
                            }
                        });
                    }
                    a(i, view2, imageView, msgType);
                }
                imageView = null;
                a(i, view2, imageView, msgType);
            } else {
                final d b2 = b.hr(this.oMW.getApplicationContext()).b(this.oMW, this.mInflater, chatMsg, view);
                if (b2 != null) {
                    a(i, b2.oNJ);
                    View contentView = b2.getContentView();
                    view = b2.getConvertView();
                    final ImageView imageView3 = b2.oNM;
                    if (imageView3 != null) {
                        switch (ChatInfo.oPg) {
                            case DUZHAN:
                                com.baidu.yuyinala.privatemessage.implugin.util.b.hC(this.oMW);
                                ImageLoader.getInstance().displayImage(ChatInfo.mPainfo.getAvatar(), imageView3, com.baidu.yuyinala.privatemessage.implugin.util.b.ejX());
                                break;
                            case B2C:
                                com.baidu.yuyinala.privatemessage.implugin.util.b.hC(this.oMW);
                                ImageLoader.getInstance().displayImage(ChatInfo.oPk, imageView3, com.baidu.yuyinala.privatemessage.implugin.util.b.ejX());
                                break;
                            case C2C:
                                c(ChatInfo.oPk, imageView3);
                                break;
                            case GROUP:
                                if (b2.jjc != null && !TextUtils.isEmpty(chatMsg.getSenderUid())) {
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    arrayList.add(chatMsg.getSenderUid());
                                    b2.jjc.setVisibility(0);
                                    if (ChatInfo.oPl == 2) {
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
                                                    b2.jjc.setText(optString);
                                                } else if (chatMsg.getSenderUid().length() > 4) {
                                                    b2.jjc.setText(chatMsg.getSenderUid().substring(0, 4));
                                                } else {
                                                    b2.jjc.setText(chatMsg.getSenderUid());
                                                }
                                                String optString2 = jSONObject.optString("portrait");
                                                if (!TextUtils.isEmpty(optString2)) {
                                                    optString2 = optString2.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
                                                }
                                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", " star member portrait is " + optString2);
                                                c(optString2, imageView3);
                                                int optInt = jSONObject.optInt("sex", 1);
                                                int optInt2 = jSONObject.optInt("isVip", 0);
                                                b2.moR.setVisibility(8);
                                                b2.moR.setText("");
                                                b2.oNN.setText("");
                                                b2.oNN.setVisibility(8);
                                                JSONArray jSONArray = jSONObject.getJSONArray(CommandMessage.TYPE_TAGS);
                                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                                    if (i3 == 0) {
                                                        b2.moR.setVisibility(0);
                                                        b2.moR.setText(jSONArray.getString(i3));
                                                    }
                                                    if (i3 == 1) {
                                                        b2.oNN.setVisibility(0);
                                                        b2.oNN.setText(jSONArray.getString(i3));
                                                    }
                                                    if (optInt == 1) {
                                                        b2.oNN.setBackgroundResource(ThemeManager.U(this.oMW, a.e.bd_im_star_boy));
                                                        b2.moR.setBackgroundResource(ThemeManager.U(this.oMW, a.e.bd_im_star_boy));
                                                    } else {
                                                        b2.moR.setBackgroundResource(ThemeManager.U(this.oMW, a.e.bd_im_star_girl));
                                                        b2.oNN.setBackgroundResource(ThemeManager.U(this.oMW, a.e.bd_im_star_girl));
                                                    }
                                                    b2.moR.setTextColor(ThemeManager.U(this.oMW, a.c.bd_im_white));
                                                    b2.oNN.setTextColor(ThemeManager.U(this.oMW, a.c.bd_im_white));
                                                }
                                                if (b2.oNO != null) {
                                                    b2.oNO.setVisibility(optInt2 == 1 ? 0 : 4);
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
                                                    b2.jjc.setText(optString3);
                                                } else if (chatMsg.getSenderUid().length() > 4) {
                                                    b2.jjc.setText(chatMsg.getSenderUid().substring(0, 4));
                                                } else {
                                                    b2.jjc.setText(chatMsg.getSenderUid());
                                                }
                                                String optString4 = jSONObject2.optString("portrait");
                                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", " group member portrait is " + optString4);
                                                c(optString4, imageView3);
                                                b2.moR.setVisibility(8);
                                                b2.moR.setText("");
                                                b2.oNN.setText("");
                                                b2.oNN.setVisibility(8);
                                            }
                                        } catch (JSONException e3) {
                                            z = false;
                                        }
                                        if (!z) {
                                            com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(this.oMW.getApplicationContext(), String.valueOf(ChatInfo.mContacter), arrayList, new b.a<ArrayList<GroupMember>>() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.16
                                                /* JADX DEBUG: Method merged with bridge method */
                                                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                                public void onResult(int i4, String str, final ArrayList<GroupMember> arrayList2) {
                                                    if (i4 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                                                        a.this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.16.1
                                                            @Override // java.lang.Runnable
                                                            public void run() {
                                                                String name = ((GroupMember) arrayList2.get(0)).getName();
                                                                if (name != null) {
                                                                    if (name.length() > 10 && name.getBytes().length > name.length()) {
                                                                        name = name.substring(0, 10);
                                                                    } else if (name.length() > 16) {
                                                                        name = name.substring(0, 15);
                                                                    }
                                                                    b2.jjc.setText(name);
                                                                } else if (chatMsg.getSenderUid().length() > 4) {
                                                                    b2.jjc.setText(chatMsg.getSenderUid().substring(0, 4));
                                                                } else {
                                                                    b2.jjc.setText(chatMsg.getSenderUid());
                                                                }
                                                                a.this.c(((GroupMember) arrayList2.get(0)).getPortrait(), imageView3);
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
                                int i4 = AnonymousClass15.oNv[ChatInfo.oPg.ordinal()];
                                a.this.gX(String.valueOf(ChatInfo.mUid), ChatInfo.oPt);
                            }
                        });
                    }
                    if (msgType == 1) {
                        a(chatMsg, (n) b2);
                    }
                    imageView = null;
                    view2 = contentView;
                    a(i, view2, imageView, msgType);
                }
                imageView = null;
                a(i, view2, imageView, msgType);
            }
        }
        return view;
    }

    private void J(final View view, final int i) {
        ChatMsg chatMsg = this.mMsgList.get(i);
        if (chatMsg.getMsgType() == 21 && chatMsg.getNotifyCmd() <= -1) {
            long contacter = chatMsg.getContacter();
            h hT = k.hz(this.oMW).hT(contacter);
            if (hT != null && hT.getId() == contacter) {
                this.mMsgList.get(i).setNotifyCmd(hT.ehv());
                this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.18
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.K(view, i);
                    }
                });
                return;
            }
            com.baidu.yuyinala.privatemessage.implugin.b.b.ht(this.oMW).z(new com.baidu.yuyinala.privatemessage.implugin.f.d(this.oMW, contacter, new g() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.19
                @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
                public void d(int i2, String str, long j) {
                    h hVar = new h();
                    hVar.setPaid(j);
                    hVar.Xd(str);
                    if (hVar.isDataValid()) {
                        k.hz(a.this.oMW).a(j, hVar);
                        ((ChatMsg) a.this.mMsgList.get(i)).setNotifyCmd(hVar.ehv());
                        a.this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.K(view, i);
                            }
                        });
                    }
                }
            }));
        }
    }

    private boolean isNotice(ChatMsg chatMsg) {
        if (chatMsg.getMsgType() == 0) {
            if (new com.baidu.yuyinala.privatemessage.model.message.b((TextMsg) chatMsg).ekm()) {
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
        if (TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getUserId(this.oMW.getApplicationContext()))) {
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
                            subViewLongClickListener.ehj();
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
            if (new com.baidu.yuyinala.privatemessage.model.message.b((TextMsg) chatMsg).ekm()) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(this.oMW.getApplicationContext(), String.valueOf(ChatInfo.mContacter), arrayList, new b.a<ArrayList<GroupMember>>() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i, String str2, final ArrayList<GroupMember> arrayList2) {
                if (i == 0 && arrayList2 != null) {
                    a.this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.22.1
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
        final ImageView imageView = nVar.jIy;
        String thumbUrl = ((ImageMsg) chatMsg).getThumbUrl();
        String remoteUrl = ((ImageMsg) chatMsg).getRemoteUrl();
        if (TextUtils.isEmpty(thumbUrl)) {
            thumbUrl = remoteUrl;
        }
        com.baidu.yuyinala.privatemessage.implugin.util.b.hC(this.oMW);
        ImageLoader.getInstance().displayImage(thumbUrl, imageView, com.baidu.yuyinala.privatemessage.implugin.util.b.ejZ(), new ImageLoadingListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.2
            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                if (!a.this.oMX.contains(str)) {
                    nVar.ehn();
                    nVar.ehl();
                }
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                nVar.eho();
                nVar.ehm();
                a.this.oMX.add(str);
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                if (bitmap != null && bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
                    int[] d2 = com.baidu.yuyinala.privatemessage.implugin.util.a.b.d(a.this.oMW.getBaseContext(), bitmap.getWidth(), bitmap.getHeight());
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = d2[0];
                    layoutParams.height = d2[1];
                    imageView.setLayoutParams(layoutParams);
                }
                nVar.eho();
                nVar.ehm();
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingCancelled(String str, View view) {
                nVar.eho();
                nVar.ehm();
            }
        }, new ImageLoadingProgressListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.3
            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingProgressListener
            public void onProgressUpdate(String str, View view, int i, int i2) {
                nVar.ehn();
                nVar.ehl();
            }
        });
    }

    private void a(int i, TextView textView) {
        if (textView != null) {
            if (i < 0 || i >= this.mMsgList.size()) {
                textView.setVisibility(8);
            } else if (Ne(i)) {
                long msgTime = this.mMsgList.get(i).getMsgTime();
                if (msgTime == 0) {
                    msgTime = System.currentTimeMillis();
                }
                String h = com.baidu.yuyinala.privatemessage.implugin.util.f.h(this.oMW, msgTime);
                textView.setVisibility(0);
                textView.setText(h);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    private boolean Ne(int i) {
        if (this.oNh != 0 && this.mMsgList.get(i).getMsgId() == this.oNh) {
            this.oNh = 0L;
            return true;
        } else if (this.oNh == 0 && i == 0) {
            this.oNh = this.mMsgList.get(i).getMsgId();
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
        this.oNj.requestFocus();
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
        this.oNj.ekc();
        Object tag = ((View) obj).getTag();
        if (tag != null) {
            if (tag instanceof m) {
                ((m) tag).stopAnim();
            } else if (tag instanceof s) {
                ((s) tag).stopAnim();
            }
        }
    }

    public void c(String str, ImageView imageView) {
        if (str != null && imageView != null) {
            com.baidu.yuyinala.privatemessage.implugin.util.b.hC(this.oMW.getApplicationContext());
            ImageLoader.getInstance().displayImage(str, imageView, com.baidu.yuyinala.privatemessage.implugin.util.b.ejY());
        }
    }

    private void a(final int i, final View view, ImageView imageView, final int i2) {
        if (view != null) {
            if ((i2 == 0 || i2 == 18 || i2 == 10000 || i2 == 16 || i2 == 8) && (view instanceof EventDispatchRelativeLayout)) {
                ((EventDispatchRelativeLayout) view).setSubviewLongClickListener(new f() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.4
                    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
                    public void ehj() {
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
                        a.this.oNe.view = view2;
                        a.this.oNe.position = i;
                        if (i2 == 16) {
                            if (motionEvent.getAction() == 0) {
                                view2.getBackground().setAlpha(120);
                            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 10 || motionEvent.getAction() == 3) {
                                view2.getBackground().setAlpha(255);
                            }
                        }
                        a.this.oNe.onTouchEvent(motionEvent);
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
                        a.this.oMZ.b((ChatMsg) a.this.mMsgList.get(i));
                    }
                }
            });
        }
        if (this.oNg != null) {
            this.oNg.eiS();
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
                    if (new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).ekl() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE) {
                        a(view, chatMsg, i);
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(1, "复制"));
                if (ChatInfo.oPl == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oNi)) {
                    arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
                }
                arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                this.oNg = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                this.oNg.a(this.oMW, view, arrayList, 1);
                this.oNg.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.7
                    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                    @SuppressLint({"NewApi"})
                    public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                        if (i3 == 1) {
                            if (chatMsg instanceof SignleGraphicTextMsg) {
                                a.this.oNf.setText(((SignleGraphicTextMsg) chatMsg).getCovers());
                            } else if (chatMsg instanceof RedPackMsg) {
                                a.this.oNf.setText(a.this.oMW.getString(a.h.bd_im_red_packet_default_text));
                            } else if (chatMsg instanceof TextMsg) {
                                a.this.oNf.setText(((TextMsg) chatMsg).getText());
                            }
                        } else if (i3 == 4) {
                            a.this.oMZ.c((ChatMsg) a.this.mMsgList.get(i));
                        } else if (i3 == 2) {
                            a.this.oNa.Nf(i);
                        } else if (i3 == 5) {
                            a.this.oNc.Ng(i);
                        }
                        a.this.oNg = null;
                    }
                });
            } else if (13 != chatMsg.getMsgType()) {
                if (1 == chatMsg.getMsgType() || ((8 == chatMsg.getMsgType() && ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) || 3 == chatMsg.getMsgType())) {
                    ArrayList arrayList2 = new ArrayList();
                    if (ChatInfo.oPl == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oNi)) {
                        arrayList2.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
                    }
                    arrayList2.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                    this.oNg = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                    this.oNg.a(this.oMW, view, arrayList2, 1);
                    this.oNg.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.8
                        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                        public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                            if (i3 == 4) {
                                a.this.oMZ.c(chatMsg);
                            } else if (i3 == 2) {
                                a.this.oNa.Nf(i);
                            } else if (i3 == 5) {
                                a.this.oNc.Ng(i);
                            }
                            a.this.oNg = null;
                        }
                    });
                } else if (10000 == chatMsg.getMsgType() || 18 == chatMsg.getMsgType()) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                    this.oNg = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                    this.oNg.a(this.oMW, view, arrayList3, 1);
                    this.oNg.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.9
                        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                        public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                            if (i3 == 2) {
                                a.this.oNa.Nf(i);
                            }
                            a.this.oNg = null;
                        }
                    });
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    if (ChatInfo.oPl == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oNi)) {
                        arrayList4.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
                    }
                    arrayList4.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                    this.oNg = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                    this.oNg.a(this.oMW, view, arrayList4, 1);
                    this.oNg.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.10
                        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                        public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                            if (i3 == 2) {
                                a.this.oNa.Nf(i);
                            } else if (i3 == 5) {
                                a.this.oNc.Ng(i);
                            }
                            a.this.oNg = null;
                        }
                    });
                }
            }
        }
    }

    private void a(View view, final ChatMsg chatMsg, final int i) {
        ArrayList arrayList = new ArrayList();
        if (ChatInfo.oPl == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oNi)) {
            arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
        }
        arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
        this.oNg = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
        this.oNg.a(this.oMW, view, arrayList, 1);
        this.oNg.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.11
            @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
            public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                if (i3 == 4) {
                    a.this.oMZ.c(chatMsg);
                } else if (i3 == 2) {
                    a.this.oNa.Nf(i);
                } else if (i3 == 5) {
                    a.this.oNc.Ng(i);
                }
                a.this.oNg = null;
            }
        });
    }

    public void K(View view, int i) {
        getView(i, view, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(String str, String str2) {
        String str3 = "";
        String str4 = "";
        if (this.oMW instanceof ActivityChat) {
            str3 = this.oMW.getLiveId();
            str4 = this.oMW.getGroupId();
        }
        ExtraParamsManager.getEncryptionUserId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oMW.getActivity(), str, null, null, null, 0, 0, null, null, 0L, 0L, 0L, 0, str4, str3, false, null, null, null, null, null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    private void a(final String str, final TextView textView, final String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str3 = "";
        String str4 = "";
        if (str2 == "invite_link") {
            str3 = "恭喜你已创建粉丝群，";
            str4 = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.eic();
        } else if (str2 == "greet_link") {
            str3 = "您已加入群聊，";
            str4 = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ehY();
        } else if (str2 == "welcom_link") {
            this.oMW.a(str, new com.baidu.yuyinala.privatemessage.implugin.ui.activity.b() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.13
                @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.b
                public void WY(String str5) {
                    if (TextUtils.isEmpty(str5)) {
                        str5 = str;
                    }
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    String str6 = str5 + "已加入群聊，";
                    String ehZ = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ehZ();
                    spannableStringBuilder2.append((CharSequence) str6);
                    spannableStringBuilder2.append((CharSequence) ehZ);
                    spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.13.1
                        @Override // android.text.style.ClickableSpan
                        public void onClick(@NonNull View view) {
                            a.this.gX(str, ChatInfo.oPt);
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(@NonNull TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(Color.parseColor("#3C9AF8"));
                            textPaint.setUnderlineText(false);
                            textPaint.clearShadowLayer();
                        }
                    }, 0, str5.length(), 33);
                    spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.13.2
                        @Override // android.text.style.ClickableSpan
                        public void onClick(@NonNull View view) {
                            if (a.this.oNk != null) {
                                a.this.oNk.Xg(str2);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(@NonNull TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(Color.parseColor("#3C9AF8"));
                            textPaint.setUnderlineText(false);
                            textPaint.clearShadowLayer();
                        }
                    }, str6.length(), str6.length() + ehZ.length(), 33);
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
            spannableStringBuilder.append((CharSequence) str3);
            spannableStringBuilder.append((CharSequence) str4);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.14
                @Override // android.text.style.ClickableSpan
                public void onClick(@NonNull View view) {
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(Color.parseColor("#3C9AF8"));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            }, str3.length(), spannableStringBuilder.length(), 33);
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
