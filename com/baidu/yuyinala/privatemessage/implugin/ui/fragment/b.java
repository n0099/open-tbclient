package com.baidu.yuyinala.privatemessage.implugin.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.d.b;
import com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.ImageButtonText;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.EmojiconEditText;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.emoji.Emojicon;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
import java.lang.ref.SoftReference;
/* loaded from: classes10.dex */
public class b implements TextWatcher, View.OnTouchListener, com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b, a.b {
    private static int mMode = 3;
    private static int pfM = 200;
    private View bWp;
    private String mKey;
    private LinearLayout mRootLayout;
    private RelativeLayout nfb;
    private ActivityChat oZL;
    private c peL;
    private EmojiconEditText pfA;
    private ImageButton pfB;
    private ImageButtonText pfC;
    private RelativeLayout pfD;
    private FrameLayout pfE;
    private RelativeLayout pfF;
    private LinearLayout pfG;
    private EmojiconsView pfN;
    private boolean pfO;
    private ActivityChat.c pfP;
    private int pfw;
    private int pfx;
    private View pfy;
    private View pfz;
    private boolean pfH = false;
    private int pfI = 55;
    private boolean pfJ = false;
    private int pfK = 0;
    private int cNt = 0;
    private boolean pfL = false;
    @SuppressLint({"HandlerLeak"})
    private a pfQ = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.pfP = cVar;
        this.mKey = str;
        d.elv().a(this);
        this.oZL = activityChat;
        this.pfw = (int) this.oZL.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.bWp = view.getRootView();
        o(this.bWp, elo());
        am(this.bWp);
        this.pfA.addTextChangedListener(this);
        elr();
        eu(this.bWp);
    }

    private void eu(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new com.baidu.yuyinala.privatemessage.implugin.util.b.b(view, new com.baidu.yuyinala.privatemessage.implugin.util.b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // com.baidu.yuyinala.privatemessage.implugin.util.b.c
            public void a(boolean z, int i, int i2, int i3) {
                if (b.this.oZL != null) {
                    int i4 = b.this.oZL.getActivity().getWindow().getAttributes().softInputMode;
                    if (!z || i4 == 16) {
                        if (b.this.pfz != null) {
                            b.this.pfz.setVisibility(8);
                        }
                        b.this.pfL = false;
                        return;
                    }
                    if (b.this.pfz != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.pfz.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = b.this.cNt;
                        b.this.pfz.setLayoutParams(layoutParams);
                        b.this.pfz.setVisibility(0);
                    }
                    b.this.pfL = true;
                }
            }
        }));
    }

    private void am(View view) {
        this.pfE = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.pfD = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.pfF = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.pfB = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.pfC = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(this.oZL.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pks, false) && ((ChatInfo.pbX != ChatInfo.ChatCategory.GROUP || ChatInfo.pcc != 2) && ChatInfo.pbX != ChatInfo.ChatCategory.DUZHAN)) {
            this.pfC.setTipOn(true);
        }
        this.pfA = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.pfA.clearFocus();
        this.pfA.setOnTouchListener(this);
        this.pfA.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.nfb = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.pfy = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.pfz = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.pfG = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.pbX) {
            this.pfG.setVisibility(8);
        } else {
            this.pfG.setVisibility(0);
        }
        try {
            this.pfN = EmojiconsView.e(this.oZL, this.pfE);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.eke().c(this.oZL.getActivity(), e);
        }
        elm();
    }

    private void elm() {
        this.pfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.eke().isCuidLogin(b.this.oZL.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.eke().ekf()) {
                    b.this.login();
                    return;
                }
                f.elu();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.elr();
            }
        });
        this.pfC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i((Context) b.this.oZL.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pks, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.j((Context) b.this.oZL.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pks, true);
                    b.this.pfC.setTipOn(false);
                }
                f.elu();
                String obj = b.this.pfA.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.pfA.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.pbZ);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.eke().getUserId(b.this.oZL.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().getUserId(b.this.oZL.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.pbX == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.pbX == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.emU().c(b.this.oZL.getActivity(), textMsg);
                    b.this.peL = d.elv().YG(b.this.mKey);
                    if (b.this.peL != null) {
                        b.this.peL.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.elr();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.pfH);
        this.pfA.addTextChangedListener(this);
        elr();
    }

    public void onPause() {
        this.pfA.removeTextChangedListener(this);
        eln();
    }

    public void onStop() {
        eln();
    }

    public void onStart() {
        eln();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.elM();
    }

    public void eln() {
        try {
            if (this.pfA != null) {
                this.pfA.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            elr();
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
        }
    }

    private void o(final View view, final boolean z) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int height = view.getRootView().getHeight() - rect.bottom;
                int dJ = f.dJ(b.this.oZL.getActivity());
                if (height == dJ || height - b.this.pfK == dJ) {
                    b.this.pfJ = true;
                } else if (height == 0 || height - b.this.pfK == (-dJ)) {
                    b.this.pfJ = false;
                }
                if (b.this.pfJ) {
                    height -= dJ;
                }
                int i = z ? height - (b.this.pfI * 2) : height;
                if (i > 100) {
                    if (b.this.pfK != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(b.this.oZL.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pkq, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.pfK > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.elp();
                        }
                    } else {
                        return;
                    }
                }
                b.this.pfK = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cNt = com.baidu.yuyinala.privatemessage.implugin.util.c.b.j(b.this.oZL.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pkq, 0);
                    b.this.pfO = i <= 100;
                    e.elJ().NQ((i > 100 ? i : b.this.cNt) + b.this.pfw);
                    if (b.this.pfO && b.this.pfL && b.mMode == 0) {
                        if (!b.this.pfQ.hasMessages(1)) {
                            b.this.pfQ.sendEmptyMessageDelayed(1, b.pfM);
                            return;
                        }
                        int unused = b.pfM = 30;
                        b.this.pfQ.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean elo() {
        if (this.bWp != null) {
            Rect rect = new Rect();
            this.bWp.getWindowVisibleDisplayFrame(rect);
            if (this.bWp.getRootView().getHeight() - rect.bottom == this.pfI * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elp() {
        this.pfN.ZK();
    }

    private void AN(boolean z) {
        if (this.oZL != null) {
            int i = this.oZL.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.pfz != null) {
                    ViewGroup.LayoutParams layoutParams = this.pfz.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cNt;
                    this.pfz.setLayoutParams(layoutParams);
                    this.pfz.setVisibility(0);
                }
                this.pfL = true;
                return;
            }
            if (this.pfz != null) {
                this.pfz.setVisibility(8);
            }
            this.pfL = false;
        }
    }

    private void aH(boolean z, boolean z2) {
        if (z && this.pfy != null) {
            ViewGroup.LayoutParams layoutParams = this.pfy.getLayoutParams();
            layoutParams.width = -1;
            this.cNt = com.baidu.yuyinala.privatemessage.implugin.util.c.b.j(this.oZL.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pkq, 0);
            int dimension = (int) this.oZL.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cNt > 100) {
                layoutParams.height = Math.max(this.cNt, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.pfx = layoutParams.height;
            this.pfy.setLayoutParams(layoutParams);
            this.pfy.setVisibility(0);
        } else if (this.pfy != null) {
            this.pfy.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void elq() {
        eln();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.eke().isCuidLogin(this.oZL) || com.baidu.yuyinala.privatemessage.implugin.d.b.eke().ekf()) {
                login();
                return true;
            }
            f.elu();
            mMode = 0;
            elr();
        }
        return false;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        z(editable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elr() {
        switch (mMode) {
            case 0:
                AO(true);
                this.peL = d.elv().YG(this.mKey);
                if (this.peL != null) {
                    this.peL.ekX();
                    break;
                }
                break;
            case 1:
            case 2:
            default:
                AO(true);
                break;
            case 3:
                AO(false);
                break;
            case 4:
                els();
                this.peL = d.elv().YG(this.mKey);
                if (this.peL != null) {
                    this.peL.ekX();
                    break;
                }
                break;
        }
        z(this.pfA.getText().toString());
    }

    private void AO(boolean z) {
        if (this.pfB != null) {
            this.pfB.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.g(this.oZL.getActivity(), this.pfA);
            AN(true);
        } else {
            f.f(this.oZL.getActivity(), this.pfA);
            AN(false);
        }
        aH(false, false);
        if (this.nfb != null) {
            this.nfb.setVisibility(0);
        }
        this.pfO = z;
    }

    private void els() {
        f.f(this.oZL.getActivity(), this.pfA);
        AN(false);
        aH(true, false);
        this.nfb.setVisibility(0);
        this.pfB.setImageResource(ThemeManager.U(this.oZL.getActivity(), a.e.bd_im_input_icon_status));
        e.elJ().NQ(this.pfx + this.pfw);
    }

    private void z(CharSequence charSequence) {
        if (this.pfC != null) {
            this.pfC.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.pfC.setTipOn(false);
                this.pfC.setClickable(false);
                this.pfC.setImageDrawable(null);
                this.pfC.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.pfC.setTextSize(this.oZL.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.pfC.setColor(Color.parseColor("#77FF1E66"));
                this.pfC.setText(this.oZL.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.pfC.setClickable(true);
            this.pfC.setTipOn(false);
            this.pfC.setImageDrawable(null);
            this.pfC.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.pfC.setTextSize(this.oZL.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.pfC.setColor(Color.parseColor("#FF1E66"));
            this.pfC.setText(this.oZL.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends Handler {
        private final SoftReference<b> pfU;

        private a(b bVar) {
            this.pfU = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.pfU.get() == null) {
                return;
            }
            try {
                switch (message.what) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                        return;
                    case 3:
                        String str = (String) message.obj;
                        if (!TextUtils.isEmpty(str)) {
                            e.elJ().bu(this.pfU.get().oZL, str);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                LogUtils.e("InputFragment", "fragment had destroyed");
            }
        }
    }

    public void elh() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsView.a(this.pfA, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void aj(View view) {
        EmojiconsView.o(this.pfA);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.eke().ekf()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.eke().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.5
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.eke().isCuidLogin(this.oZL)) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            f.b(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.6
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "cuidToUidLogin result code = " + i);
                }
            });
        }
    }
}
