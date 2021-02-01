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
/* loaded from: classes11.dex */
public class a extends BaseAdapter implements b.a {
    private LayoutInflater mInflater;
    private ArrayList<ChatMsg> mMsgList;
    private ActivityChat oXg;
    private b oXi;
    private c oXj;
    private InterfaceC0964a oXk;
    private ActivityChat.c oXl;
    private d oXm;
    private e oXo;
    private ClipboardManager oXp;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b oXq;
    private String oXs;
    private com.baidu.yuyinala.privatemessage.implugin.util.audio.a oXt;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.c oXu;
    private List<String> oXh = new ArrayList();
    private Set<ChatMsg> oXn = new HashSet();
    private final int nXK = 120;
    private long oXr = 0;

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0964a {
        void NB(int i);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void g(View view, int i, boolean z);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void b(ChatMsg chatMsg);

        void c(ChatMsg chatMsg);
    }

    /* loaded from: classes11.dex */
    public interface d {
        void NC(int i);
    }

    /* loaded from: classes11.dex */
    public interface f {
        void ejD();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.b.a
    public void a(View view, int i, final ChatMsg chatMsg) {
        this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.1
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

    public a(ActivityChat activityChat, ArrayList<ChatMsg> arrayList, b bVar, c cVar, InterfaceC0964a interfaceC0964a, d dVar, ActivityChat.c cVar2, String str) {
        this.oXg = activityChat;
        this.mMsgList = arrayList;
        this.oXi = bVar;
        this.oXj = cVar;
        this.oXk = interfaceC0964a;
        this.oXm = dVar;
        this.oXs = str;
        this.oXo = new e(activityChat);
        this.mInflater = (LayoutInflater) this.oXg.getSystemService("layout_inflater");
        this.oXp = (ClipboardManager) this.oXg.getSystemService("clipboard");
        this.oXt = new com.baidu.yuyinala.privatemessage.implugin.util.audio.a(activityChat);
        this.oXl = cVar2;
    }

    public void a(com.baidu.yuyinala.privatemessage.implugin.ui.activity.c cVar) {
        this.oXu = cVar;
    }

    /* loaded from: classes11.dex */
    private class e {
        private GestureDetector mGestureDetector;
        private GestureDetector.OnGestureListener oXP = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.e.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (a.this.oXi != null) {
                    a.this.oXi.g(e.this.view, e.this.position, true);
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
            this.mGestureDetector = new GestureDetector(context, this.oXP);
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
            f a2 = b.hu(this.oXg.getApplicationContext()).a(this.oXg, this.mInflater, view, chatMsg.getMsgType());
            if (a2 != null) {
                a(i, a2.oXT);
                view = a2.getConvertView();
                a2.b(this.oXg, chatMsg);
            }
            a(chatMsg, a2, i == getCount() + (-1));
        } else {
            int msgType = chatMsg.getMsgType();
            if (8 == msgType && (chatMsg instanceof SignleGraphicTextMsg)) {
                i2 = ((SignleGraphicTextMsg) chatMsg).getSubType();
            }
            if (9 == msgType || 12 == msgType || ((8 == msgType && i2 == 0) || 21 == msgType)) {
                c a3 = b.hu(this.oXg.getApplicationContext()).a(this.oXg, this.mInflater, i, chatMsg, view, this);
                a(i, a3.oXT);
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
            } else if (fromUser == ChatInfo.oZs) {
                e a4 = b.hu(this.oXg.getApplicationContext()).a(this.oXg, this.mInflater, chatMsg, view);
                if (a4 != null) {
                    view2 = a4.getContentView();
                    a(i, a4.oXT);
                    ImageView imageView2 = a4.oXW;
                    if (a4.oXY != null) {
                        a4.oXY.setVisibility(ChatInfo.vip == 1 ? 0 : 4);
                    }
                    view = a4.getConvertView();
                    imageView = a4.oXZ;
                    if (imageView2 != null) {
                        b(ChatInfo.oZt, imageView2);
                        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.12
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                int loginType = BIMManager.getLoginType(a.this.oXg);
                                if (loginType == 6 && ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) {
                                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", "loginType = " + loginType + ", and headView clicked");
                                    return;
                                }
                                new JSONObject();
                                if (!ChatInfo.oZB) {
                                    a.this.he(com.baidu.yuyinala.privatemessage.implugin.d.a.ejL(), "ugc");
                                } else {
                                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().a(true, "", "", "", "", "", "", "");
                                }
                            }
                        });
                    }
                    a(i, view2, imageView, msgType);
                }
                imageView = null;
                a(i, view2, imageView, msgType);
            } else {
                final d b2 = b.hu(this.oXg.getApplicationContext()).b(this.oXg, this.mInflater, chatMsg, view);
                if (b2 != null) {
                    a(i, b2.oXT);
                    View contentView = b2.getContentView();
                    view = b2.getConvertView();
                    final ImageView imageView3 = b2.oXW;
                    if (imageView3 != null) {
                        switch (ChatInfo.oZq) {
                            case DUZHAN:
                                com.baidu.yuyinala.privatemessage.implugin.util.b.hF(this.oXg);
                                ImageLoader.getInstance().displayImage(ChatInfo.mPainfo.getAvatar(), imageView3, com.baidu.yuyinala.privatemessage.implugin.util.b.emp());
                                break;
                            case B2C:
                                com.baidu.yuyinala.privatemessage.implugin.util.b.hF(this.oXg);
                                ImageLoader.getInstance().displayImage(ChatInfo.oZu, imageView3, com.baidu.yuyinala.privatemessage.implugin.util.b.emp());
                                break;
                            case C2C:
                                b(ChatInfo.oZu, imageView3);
                                break;
                            case GROUP:
                                if (b2.joJ != null && !TextUtils.isEmpty(chatMsg.getSenderUid())) {
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    arrayList.add(chatMsg.getSenderUid());
                                    b2.joJ.setVisibility(0);
                                    if (ChatInfo.oZv == 2) {
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
                                                    b2.joJ.setText(optString);
                                                } else if (chatMsg.getSenderUid().length() > 4) {
                                                    b2.joJ.setText(chatMsg.getSenderUid().substring(0, 4));
                                                } else {
                                                    b2.joJ.setText(chatMsg.getSenderUid());
                                                }
                                                String optString2 = jSONObject.optString("portrait");
                                                if (!TextUtils.isEmpty(optString2)) {
                                                    optString2 = optString2.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
                                                }
                                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", " star member portrait is " + optString2);
                                                b(optString2, imageView3);
                                                int optInt = jSONObject.optInt("sex", 1);
                                                int optInt2 = jSONObject.optInt("isVip", 0);
                                                b2.mxR.setVisibility(8);
                                                b2.mxR.setText("");
                                                b2.oXX.setText("");
                                                b2.oXX.setVisibility(8);
                                                JSONArray jSONArray = jSONObject.getJSONArray(CommandMessage.TYPE_TAGS);
                                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                                    if (i3 == 0) {
                                                        b2.mxR.setVisibility(0);
                                                        b2.mxR.setText(jSONArray.getString(i3));
                                                    }
                                                    if (i3 == 1) {
                                                        b2.oXX.setVisibility(0);
                                                        b2.oXX.setText(jSONArray.getString(i3));
                                                    }
                                                    if (optInt == 1) {
                                                        b2.oXX.setBackgroundResource(ThemeManager.U(this.oXg, a.e.bd_im_star_boy));
                                                        b2.mxR.setBackgroundResource(ThemeManager.U(this.oXg, a.e.bd_im_star_boy));
                                                    } else {
                                                        b2.mxR.setBackgroundResource(ThemeManager.U(this.oXg, a.e.bd_im_star_girl));
                                                        b2.oXX.setBackgroundResource(ThemeManager.U(this.oXg, a.e.bd_im_star_girl));
                                                    }
                                                    b2.mxR.setTextColor(ThemeManager.U(this.oXg, a.c.bd_im_white));
                                                    b2.oXX.setTextColor(ThemeManager.U(this.oXg, a.c.bd_im_white));
                                                }
                                                if (b2.oXY != null) {
                                                    b2.oXY.setVisibility(optInt2 == 1 ? 0 : 4);
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
                                                    b2.joJ.setText(optString3);
                                                } else if (chatMsg.getSenderUid().length() > 4) {
                                                    b2.joJ.setText(chatMsg.getSenderUid().substring(0, 4));
                                                } else {
                                                    b2.joJ.setText(chatMsg.getSenderUid());
                                                }
                                                String optString4 = jSONObject2.optString("portrait");
                                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatAdapter", " group member portrait is " + optString4);
                                                b(optString4, imageView3);
                                                b2.mxR.setVisibility(8);
                                                b2.mxR.setText("");
                                                b2.oXX.setText("");
                                                b2.oXX.setVisibility(8);
                                            }
                                        } catch (JSONException e3) {
                                            z = false;
                                        }
                                        if (!z) {
                                            com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().a(this.oXg.getApplicationContext(), String.valueOf(ChatInfo.mContacter), arrayList, new b.a<ArrayList<GroupMember>>() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.16
                                                /* JADX DEBUG: Method merged with bridge method */
                                                @Override // com.baidu.android.imsdk.group.BIMValueCallBack
                                                public void onResult(int i4, String str, final ArrayList<GroupMember> arrayList2) {
                                                    if (i4 == 0 && arrayList2 != null && arrayList2.size() == 1) {
                                                        a.this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.16.1
                                                            @Override // java.lang.Runnable
                                                            public void run() {
                                                                String name = ((GroupMember) arrayList2.get(0)).getName();
                                                                if (name != null) {
                                                                    if (name.length() > 10 && name.getBytes().length > name.length()) {
                                                                        name = name.substring(0, 10);
                                                                    } else if (name.length() > 16) {
                                                                        name = name.substring(0, 15);
                                                                    }
                                                                    b2.joJ.setText(name);
                                                                } else if (chatMsg.getSenderUid().length() > 4) {
                                                                    b2.joJ.setText(chatMsg.getSenderUid().substring(0, 4));
                                                                } else {
                                                                    b2.joJ.setText(chatMsg.getSenderUid());
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
                                int i4 = AnonymousClass15.oXF[ChatInfo.oZq.ordinal()];
                                a.this.he(String.valueOf(ChatInfo.mUid), ChatInfo.oZD);
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
            h hW = k.hC(this.oXg).hW(contacter);
            if (hW != null && hW.getId() == contacter) {
                this.mMsgList.get(i).setNotifyCmd(hW.ejP());
                this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.18
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.K(view, i);
                    }
                });
                return;
            }
            com.baidu.yuyinala.privatemessage.implugin.b.b.hw(this.oXg).x(new com.baidu.yuyinala.privatemessage.implugin.f.d(this.oXg, contacter, new g() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.19
                @Override // com.baidu.yuyinala.privatemessage.implugin.f.g
                public void d(int i2, String str, long j) {
                    h hVar = new h();
                    hVar.setPaid(j);
                    hVar.Ye(str);
                    if (hVar.isDataValid()) {
                        k.hC(a.this.oXg).a(j, hVar);
                        ((ChatMsg) a.this.mMsgList.get(i)).setNotifyCmd(hVar.ejP());
                        a.this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.19.1
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
            if (new com.baidu.yuyinala.privatemessage.model.message.b((TextMsg) chatMsg).emE()) {
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
        if (TextUtils.isEmpty(com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().getUserId(this.oXg.getApplicationContext()))) {
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
                            subViewLongClickListener.ejD();
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
            if (new com.baidu.yuyinala.privatemessage.model.message.b((TextMsg) chatMsg).emE()) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().a(this.oXg.getApplicationContext(), String.valueOf(ChatInfo.mContacter), arrayList, new b.a<ArrayList<GroupMember>>() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i, String str2, final ArrayList<GroupMember> arrayList2) {
                if (i == 0 && arrayList2 != null) {
                    a.this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.22.1
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
        final ImageView imageView = nVar.jPv;
        String thumbUrl = ((ImageMsg) chatMsg).getThumbUrl();
        String remoteUrl = ((ImageMsg) chatMsg).getRemoteUrl();
        if (TextUtils.isEmpty(thumbUrl)) {
            thumbUrl = remoteUrl;
        }
        com.baidu.yuyinala.privatemessage.implugin.util.b.hF(this.oXg);
        ImageLoader.getInstance().displayImage(thumbUrl, imageView, com.baidu.yuyinala.privatemessage.implugin.util.b.emr(), new ImageLoadingListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.2
            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                if (!a.this.oXh.contains(str)) {
                    nVar.ejH();
                    nVar.ejF();
                }
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                nVar.ejI();
                nVar.ejG();
                a.this.oXh.add(str);
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                if (bitmap != null && bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
                    int[] d2 = com.baidu.yuyinala.privatemessage.implugin.util.a.b.d(a.this.oXg.getBaseContext(), bitmap.getWidth(), bitmap.getHeight());
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = d2[0];
                    layoutParams.height = d2[1];
                    imageView.setLayoutParams(layoutParams);
                }
                nVar.ejI();
                nVar.ejG();
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingCancelled(String str, View view) {
                nVar.ejI();
                nVar.ejG();
            }
        }, new ImageLoadingProgressListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.3
            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingProgressListener
            public void onProgressUpdate(String str, View view, int i, int i2) {
                nVar.ejH();
                nVar.ejF();
            }
        });
    }

    private void a(int i, TextView textView) {
        if (textView != null) {
            if (i < 0 || i >= this.mMsgList.size()) {
                textView.setVisibility(8);
            } else if (NA(i)) {
                long msgTime = this.mMsgList.get(i).getMsgTime();
                if (msgTime == 0) {
                    msgTime = System.currentTimeMillis();
                }
                String h = com.baidu.yuyinala.privatemessage.implugin.util.f.h(this.oXg, msgTime);
                textView.setVisibility(0);
                textView.setText(h);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    private boolean NA(int i) {
        if (this.oXr != 0 && this.mMsgList.get(i).getMsgId() == this.oXr) {
            this.oXr = 0L;
            return true;
        } else if (this.oXr == 0 && i == 0) {
            this.oXr = this.mMsgList.get(i).getMsgId();
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
        this.oXt.requestFocus();
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
        this.oXt.emu();
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
            com.baidu.yuyinala.privatemessage.implugin.util.b.hF(this.oXg.getApplicationContext());
            ImageLoader.getInstance().displayImage(str, imageView, com.baidu.yuyinala.privatemessage.implugin.util.b.emq());
        }
    }

    private void a(final int i, final View view, ImageView imageView, final int i2) {
        if (view != null) {
            if ((i2 == 0 || i2 == 18 || i2 == 10000 || i2 == 16 || i2 == 8) && (view instanceof EventDispatchRelativeLayout)) {
                ((EventDispatchRelativeLayout) view).setSubviewLongClickListener(new f() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.4
                    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
                    public void ejD() {
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
                        a.this.oXo.view = view2;
                        a.this.oXo.position = i;
                        if (i2 == 16) {
                            if (motionEvent.getAction() == 0) {
                                view2.getBackground().setAlpha(120);
                            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 10 || motionEvent.getAction() == 3) {
                                view2.getBackground().setAlpha(255);
                            }
                        }
                        a.this.oXo.onTouchEvent(motionEvent);
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
                        a.this.oXj.b((ChatMsg) a.this.mMsgList.get(i));
                    }
                }
            });
        }
        if (this.oXq != null) {
            this.oXq.elm();
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
                    if (new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).emD() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE) {
                        a(view, chatMsg, i);
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(1, "复制"));
                if (ChatInfo.oZv == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oXs)) {
                    arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
                }
                arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                this.oXq = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                this.oXq.a(this.oXg, view, arrayList, 1);
                this.oXq.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.7
                    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                    @SuppressLint({"NewApi"})
                    public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                        if (i3 == 1) {
                            if (chatMsg instanceof SignleGraphicTextMsg) {
                                a.this.oXp.setText(((SignleGraphicTextMsg) chatMsg).getCovers());
                            } else if (chatMsg instanceof RedPackMsg) {
                                a.this.oXp.setText(a.this.oXg.getString(a.h.bd_im_red_packet_default_text));
                            } else if (chatMsg instanceof TextMsg) {
                                a.this.oXp.setText(((TextMsg) chatMsg).getText());
                            }
                        } else if (i3 == 4) {
                            a.this.oXj.c((ChatMsg) a.this.mMsgList.get(i));
                        } else if (i3 == 2) {
                            a.this.oXk.NB(i);
                        } else if (i3 == 5) {
                            a.this.oXm.NC(i);
                        }
                        a.this.oXq = null;
                    }
                });
            } else if (13 != chatMsg.getMsgType()) {
                if (1 == chatMsg.getMsgType() || ((8 == chatMsg.getMsgType() && ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) || 3 == chatMsg.getMsgType())) {
                    ArrayList arrayList2 = new ArrayList();
                    if (ChatInfo.oZv == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oXs)) {
                        arrayList2.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
                    }
                    arrayList2.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                    this.oXq = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                    this.oXq.a(this.oXg, view, arrayList2, 1);
                    this.oXq.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.8
                        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                        public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                            if (i3 == 4) {
                                a.this.oXj.c(chatMsg);
                            } else if (i3 == 2) {
                                a.this.oXk.NB(i);
                            } else if (i3 == 5) {
                                a.this.oXm.NC(i);
                            }
                            a.this.oXq = null;
                        }
                    });
                } else if (10000 == chatMsg.getMsgType() || 18 == chatMsg.getMsgType()) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                    this.oXq = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                    this.oXq.a(this.oXg, view, arrayList3, 1);
                    this.oXq.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.9
                        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                        public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                            if (i3 == 2) {
                                a.this.oXk.NB(i);
                            }
                            a.this.oXq = null;
                        }
                    });
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    if (ChatInfo.oZv == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oXs)) {
                        arrayList4.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
                    }
                    arrayList4.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
                    this.oXq = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
                    this.oXq.a(this.oXg, view, arrayList4, 1);
                    this.oXq.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.10
                        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
                        public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                            if (i3 == 2) {
                                a.this.oXk.NB(i);
                            } else if (i3 == 5) {
                                a.this.oXm.NC(i);
                            }
                            a.this.oXq = null;
                        }
                    });
                }
            }
        }
    }

    private void a(View view, final ChatMsg chatMsg, final int i) {
        ArrayList arrayList = new ArrayList();
        if (ChatInfo.oZv == 2 && !String.valueOf(chatMsg.getSenderUid()).equals(this.oXs)) {
            arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(5, "举报"));
        }
        arrayList.add(new com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.a.a(2, "删除"));
        this.oXq = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b();
        this.oXq.a(this.oXg, view, arrayList, 1);
        this.oXq.a(new b.a() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.11
            @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b.a
            public void a(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.b bVar, int i2, int i3) {
                if (i3 == 4) {
                    a.this.oXj.c(chatMsg);
                } else if (i3 == 2) {
                    a.this.oXk.NB(i);
                } else if (i3 == 5) {
                    a.this.oXm.NC(i);
                }
                a.this.oXq = null;
            }
        });
    }

    public void K(View view, int i) {
        getView(i, view, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(String str, String str2) {
        String str3 = "";
        String str4 = "";
        if (this.oXg instanceof ActivityChat) {
            str3 = this.oXg.getLiveId();
            str4 = this.oXg.getGroupId();
        }
        ExtraParamsManager.getEncryptionUserId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oXg.getActivity(), str, null, null, null, 0, 0, null, null, 0L, 0L, 0L, 0, str4, str3, false, null, null, null, null, null)));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501070, ""));
    }

    private void a(final String str, final TextView textView, final String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str3 = "";
        String str4 = "";
        if (str2 == "invite_link") {
            str3 = "恭喜你已创建粉丝群，";
            str4 = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ekw();
        } else if (str2 == "greet_link") {
            str3 = "您已加入群聊，";
            str4 = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.eks();
        } else if (str2 == "welcom_link") {
            this.oXg.a(str, new com.baidu.yuyinala.privatemessage.implugin.ui.activity.b() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.13
                @Override // com.baidu.yuyinala.privatemessage.implugin.ui.activity.b
                public void XZ(String str5) {
                    if (TextUtils.isEmpty(str5)) {
                        str5 = str;
                    }
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    String str6 = str5 + "已加入群聊，";
                    String ekt = com.baidu.yuyinala.privatemessage.implugin.ui.common.b.ekt();
                    spannableStringBuilder2.append((CharSequence) str6);
                    spannableStringBuilder2.append((CharSequence) ekt);
                    spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.13.1
                        @Override // android.text.style.ClickableSpan
                        public void onClick(@NonNull View view) {
                            a.this.he(str, ChatInfo.oZD);
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
                            if (a.this.oXu != null) {
                                a.this.oXu.Yh(str2);
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(@NonNull TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setColor(Color.parseColor("#3C9AF8"));
                            textPaint.setUnderlineText(false);
                            textPaint.clearShadowLayer();
                        }
                    }, str6.length(), str6.length() + ekt.length(), 33);
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
