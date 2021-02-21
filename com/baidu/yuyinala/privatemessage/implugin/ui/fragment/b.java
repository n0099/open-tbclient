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
/* loaded from: classes11.dex */
public class b implements TextWatcher, View.OnTouchListener, com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b, a.b {
    private static int mMode = 3;
    private static int pdH = 200;
    private View bUP;
    private String mKey;
    private LinearLayout mRootLayout;
    private RelativeLayout ncW;
    private ActivityChat oXG;
    private c pcG;
    private RelativeLayout pdA;
    private LinearLayout pdB;
    private EmojiconsView pdI;
    private boolean pdJ;
    private ActivityChat.c pdK;
    private int pdr;
    private int pds;
    private View pdt;
    private View pdu;
    private EmojiconEditText pdv;
    private ImageButton pdw;
    private ImageButtonText pdx;
    private RelativeLayout pdy;
    private FrameLayout pdz;
    private boolean pdC = false;
    private int pdD = 55;
    private boolean pdE = false;
    private int pdF = 0;
    private int cLT = 0;
    private boolean pdG = false;
    @SuppressLint({"HandlerLeak"})
    private a pdL = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.pdK = cVar;
        this.mKey = str;
        d.ell().a(this);
        this.oXG = activityChat;
        this.pdr = (int) this.oXG.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.bUP = view.getRootView();
        o(this.bUP, ele());
        am(this.bUP);
        this.pdv.addTextChangedListener(this);
        elh();
        eu(this.bUP);
    }

    private void eu(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new com.baidu.yuyinala.privatemessage.implugin.util.b.b(view, new com.baidu.yuyinala.privatemessage.implugin.util.b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // com.baidu.yuyinala.privatemessage.implugin.util.b.c
            public void a(boolean z, int i, int i2, int i3) {
                if (b.this.oXG != null) {
                    int i4 = b.this.oXG.getActivity().getWindow().getAttributes().softInputMode;
                    if (!z || i4 == 16) {
                        if (b.this.pdu != null) {
                            b.this.pdu.setVisibility(8);
                        }
                        b.this.pdG = false;
                        return;
                    }
                    if (b.this.pdu != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.pdu.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = b.this.cLT;
                        b.this.pdu.setLayoutParams(layoutParams);
                        b.this.pdu.setVisibility(0);
                    }
                    b.this.pdG = true;
                }
            }
        }));
    }

    private void am(View view) {
        this.pdz = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.pdy = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.pdA = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.pdw = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.pdx = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(this.oXG.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pil, false) && ((ChatInfo.oZQ != ChatInfo.ChatCategory.GROUP || ChatInfo.oZV != 2) && ChatInfo.oZQ != ChatInfo.ChatCategory.DUZHAN)) {
            this.pdx.setTipOn(true);
        }
        this.pdv = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.pdv.clearFocus();
        this.pdv.setOnTouchListener(this);
        this.pdv.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.ncW = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.pdt = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.pdu = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.pdB = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.oZQ) {
            this.pdB.setVisibility(8);
        } else {
            this.pdB.setVisibility(0);
        }
        try {
            this.pdI = EmojiconsView.f(this.oXG, this.pdz);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().c(this.oXG.getActivity(), e);
        }
        elc();
    }

    private void elc() {
        this.pdy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().isCuidLogin(b.this.oXG.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().ejV()) {
                    b.this.login();
                    return;
                }
                f.elk();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.elh();
            }
        });
        this.pdx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(b.this.oXG.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pil, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.j((Context) b.this.oXG.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pil, true);
                    b.this.pdx.setTipOn(false);
                }
                f.elk();
                String obj = b.this.pdv.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.pdv.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.oZS);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().getUserId(b.this.oXG.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().getUserId(b.this.oXG.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.oZQ == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.emK().c(b.this.oXG.getActivity(), textMsg);
                    b.this.pcG = d.ell().Yz(b.this.mKey);
                    if (b.this.pcG != null) {
                        b.this.pcG.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.elh();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.pdC);
        this.pdv.addTextChangedListener(this);
        elh();
    }

    public void onPause() {
        this.pdv.removeTextChangedListener(this);
        eld();
    }

    public void onStop() {
        eld();
    }

    public void onStart() {
        eld();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.elC();
    }

    public void eld() {
        try {
            if (this.pdv != null) {
                this.pdv.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            elh();
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
                int dK = f.dK(b.this.oXG.getActivity());
                if (height == dK || height - b.this.pdF == dK) {
                    b.this.pdE = true;
                } else if (height == 0 || height - b.this.pdF == (-dK)) {
                    b.this.pdE = false;
                }
                if (b.this.pdE) {
                    height -= dK;
                }
                int i = z ? height - (b.this.pdD * 2) : height;
                if (i > 100) {
                    if (b.this.pdF != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.j(b.this.oXG.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pij, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.pdF > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.elf();
                        }
                    } else {
                        return;
                    }
                }
                b.this.pdF = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cLT = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(b.this.oXG.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pij, 0);
                    b.this.pdJ = i <= 100;
                    e.elz().NM((i > 100 ? i : b.this.cLT) + b.this.pdr);
                    if (b.this.pdJ && b.this.pdG && b.mMode == 0) {
                        if (!b.this.pdL.hasMessages(1)) {
                            b.this.pdL.sendEmptyMessageDelayed(1, b.pdH);
                            return;
                        }
                        int unused = b.pdH = 30;
                        b.this.pdL.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean ele() {
        if (this.bUP != null) {
            Rect rect = new Rect();
            this.bUP.getWindowVisibleDisplayFrame(rect);
            if (this.bUP.getRootView().getHeight() - rect.bottom == this.pdD * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elf() {
        this.pdI.ZH();
    }

    private void AO(boolean z) {
        if (this.oXG != null) {
            int i = this.oXG.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.pdu != null) {
                    ViewGroup.LayoutParams layoutParams = this.pdu.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cLT;
                    this.pdu.setLayoutParams(layoutParams);
                    this.pdu.setVisibility(0);
                }
                this.pdG = true;
                return;
            }
            if (this.pdu != null) {
                this.pdu.setVisibility(8);
            }
            this.pdG = false;
        }
    }

    private void aH(boolean z, boolean z2) {
        if (z && this.pdt != null) {
            ViewGroup.LayoutParams layoutParams = this.pdt.getLayoutParams();
            layoutParams.width = -1;
            this.cLT = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(this.oXG.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pij, 0);
            int dimension = (int) this.oXG.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cLT > 100) {
                layoutParams.height = Math.max(this.cLT, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.pds = layoutParams.height;
            this.pdt.setLayoutParams(layoutParams);
            this.pdt.setVisibility(0);
        } else if (this.pdt != null) {
            this.pdt.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void elg() {
        eld();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().isCuidLogin(this.oXG) || com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().ejV()) {
                login();
                return true;
            }
            f.elk();
            mMode = 0;
            elh();
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
    public void elh() {
        switch (mMode) {
            case 0:
                AP(true);
                this.pcG = d.ell().Yz(this.mKey);
                if (this.pcG != null) {
                    this.pcG.ekN();
                    break;
                }
                break;
            case 1:
            case 2:
            default:
                AP(true);
                break;
            case 3:
                AP(false);
                break;
            case 4:
                eli();
                this.pcG = d.ell().Yz(this.mKey);
                if (this.pcG != null) {
                    this.pcG.ekN();
                    break;
                }
                break;
        }
        z(this.pdv.getText().toString());
    }

    private void AP(boolean z) {
        if (this.pdw != null) {
            this.pdw.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.h(this.oXG.getActivity(), this.pdv);
            AO(true);
        } else {
            f.g(this.oXG.getActivity(), this.pdv);
            AO(false);
        }
        aH(false, false);
        if (this.ncW != null) {
            this.ncW.setVisibility(0);
        }
        this.pdJ = z;
    }

    private void eli() {
        f.g(this.oXG.getActivity(), this.pdv);
        AO(false);
        aH(true, false);
        this.ncW.setVisibility(0);
        this.pdw.setImageResource(ThemeManager.U(this.oXG.getActivity(), a.e.bd_im_input_icon_status));
        e.elz().NM(this.pds + this.pdr);
    }

    private void z(CharSequence charSequence) {
        if (this.pdx != null) {
            this.pdx.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.pdx.setTipOn(false);
                this.pdx.setClickable(false);
                this.pdx.setImageDrawable(null);
                this.pdx.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.pdx.setTextSize(this.oXG.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.pdx.setColor(Color.parseColor("#77FF1E66"));
                this.pdx.setText(this.oXG.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.pdx.setClickable(true);
            this.pdx.setTipOn(false);
            this.pdx.setImageDrawable(null);
            this.pdx.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.pdx.setTextSize(this.oXG.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.pdx.setColor(Color.parseColor("#FF1E66"));
            this.pdx.setText(this.oXG.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes11.dex */
    private static class a extends Handler {
        private final SoftReference<b> pdP;

        private a(b bVar) {
            this.pdP = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.pdP.get() == null) {
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
                            e.elz().bu(this.pdP.get().oXG, str);
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

    public void ekX() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsView.a(this.pdv, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void aj(View view) {
        EmojiconsView.o(this.pdv);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().ejV()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.5
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().isCuidLogin(this.oXG)) {
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
