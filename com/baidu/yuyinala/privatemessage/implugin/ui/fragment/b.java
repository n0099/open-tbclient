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
    private static int oXv = 200;
    private View bVM;
    private String mKey;
    private LinearLayout mRootLayout;
    private RelativeLayout mXM;
    private ActivityChat oRx;
    private c oWu;
    private int oXf;
    private int oXg;
    private View oXh;
    private View oXi;
    private EmojiconEditText oXj;
    private ImageButton oXk;
    private ImageButtonText oXl;
    private RelativeLayout oXm;
    private FrameLayout oXn;
    private RelativeLayout oXo;
    private LinearLayout oXp;
    private EmojiconsFragment oXw;
    private boolean oXx;
    private ActivityChat.c oXy;
    private boolean oXq = false;
    private int oXr = 55;
    private boolean oXs = false;
    private int oXt = 0;
    private int cOr = 0;
    private boolean oXu = false;
    @SuppressLint({"HandlerLeak"})
    private a oXz = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.oXy = cVar;
        this.mKey = str;
        d.emC().a(this);
        this.oRx = activityChat;
        this.oXf = (int) this.oRx.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.bVM = view.getRootView();
        o(this.bVM, emv());
        ap(this.bVM);
        this.oXj.addTextChangedListener(this);
        emy();
        ew(this.bVM);
    }

    private void ew(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new com.baidu.yuyinala.privatemessage.implugin.util.b.b(view, new com.baidu.yuyinala.privatemessage.implugin.util.b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // com.baidu.yuyinala.privatemessage.implugin.util.b.c
            public void a(boolean z, int i, int i2, int i3) {
                if (b.this.oRx != null) {
                    int i4 = b.this.oRx.getActivity().getWindow().getAttributes().softInputMode;
                    if (!z || i4 == 16) {
                        if (b.this.oXi != null) {
                            b.this.oXi.setVisibility(8);
                        }
                        b.this.oXu = false;
                        return;
                    }
                    if (b.this.oXi != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.oXi.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = b.this.cOr;
                        b.this.oXi.setLayoutParams(layoutParams);
                        b.this.oXi.setVisibility(0);
                    }
                    b.this.oXu = true;
                }
            }
        }));
    }

    private void ap(View view) {
        this.oXn = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.oXm = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.oXo = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.oXk = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.oXl = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(this.oRx.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pbZ, false) && ((ChatInfo.oTH != ChatInfo.ChatCategory.GROUP || ChatInfo.oTM != 2) && ChatInfo.oTH != ChatInfo.ChatCategory.DUZHAN)) {
            this.oXl.setTipOn(true);
        }
        this.oXj = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.oXj.clearFocus();
        this.oXj.setOnTouchListener(this);
        this.oXj.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.mXM = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.oXh = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.oXi = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.oXp = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.oTH) {
            this.oXp.setVisibility(8);
        } else {
            this.oXp.setVisibility(0);
        }
        try {
            this.oXw = EmojiconsFragment.f(this.oRx, this.oXn);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ell().c(this.oRx.getActivity(), e);
        }
        emt();
    }

    private void emt() {
        this.oXm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.ell().isCuidLogin(b.this.oRx.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.ell().elm()) {
                    b.this.login();
                    return;
                }
                f.emB();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.emy();
            }
        });
        this.oXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(b.this.oRx.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pbZ, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.j((Context) b.this.oRx.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pbZ, true);
                    b.this.oXl.setTipOn(false);
                }
                f.emB();
                String obj = b.this.oXj.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.oXj.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.oTJ);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getUserId(b.this.oRx.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.ell().getUserId(b.this.oRx.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oTH == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.eoe().c(b.this.oRx.getActivity(), textMsg);
                    b.this.oWu = d.emC().Yu(b.this.mKey);
                    if (b.this.oWu != null) {
                        b.this.oWu.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.emy();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.oXq);
        this.oXj.addTextChangedListener(this);
        emy();
    }

    public void onPause() {
        this.oXj.removeTextChangedListener(this);
        emu();
    }

    public void onStop() {
        emu();
    }

    public void onStart() {
        emu();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.emT();
    }

    public void emu() {
        try {
            if (this.oXj != null) {
                this.oXj.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            emy();
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
                int dM = f.dM(b.this.oRx.getActivity());
                if (height == dM || height - b.this.oXt == dM) {
                    b.this.oXs = true;
                } else if (height == 0 || height - b.this.oXt == (-dM)) {
                    b.this.oXs = false;
                }
                if (b.this.oXs) {
                    height -= dM;
                }
                int i = z ? height - (b.this.oXr * 2) : height;
                if (i > 100) {
                    if (b.this.oXt != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.j(b.this.oRx.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pbX, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.oXt > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.emw();
                        }
                    } else {
                        return;
                    }
                }
                b.this.oXt = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cOr = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(b.this.oRx.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pbX, 0);
                    b.this.oXx = i <= 100;
                    e.emQ().OX((i > 100 ? i : b.this.cOr) + b.this.oXf);
                    if (b.this.oXx && b.this.oXu && b.mMode == 0) {
                        if (!b.this.oXz.hasMessages(1)) {
                            b.this.oXz.sendEmptyMessageDelayed(1, b.oXv);
                            return;
                        }
                        int unused = b.oXv = 30;
                        b.this.oXz.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean emv() {
        if (this.bVM != null) {
            Rect rect = new Rect();
            this.bVM.getWindowVisibleDisplayFrame(rect);
            if (this.bVM.getRootView().getHeight() - rect.bottom == this.oXr * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emw() {
        this.oXw.abI();
    }

    private void Az(boolean z) {
        if (this.oRx != null) {
            int i = this.oRx.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.oXi != null) {
                    ViewGroup.LayoutParams layoutParams = this.oXi.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cOr;
                    this.oXi.setLayoutParams(layoutParams);
                    this.oXi.setVisibility(0);
                }
                this.oXu = true;
                return;
            }
            if (this.oXi != null) {
                this.oXi.setVisibility(8);
            }
            this.oXu = false;
        }
    }

    private void aH(boolean z, boolean z2) {
        if (z && this.oXh != null) {
            ViewGroup.LayoutParams layoutParams = this.oXh.getLayoutParams();
            layoutParams.width = -1;
            this.cOr = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(this.oRx.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.pbX, 0);
            int dimension = (int) this.oRx.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cOr > 100) {
                layoutParams.height = Math.max(this.cOr, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.oXg = layoutParams.height;
            this.oXh.setLayoutParams(layoutParams);
            this.oXh.setVisibility(0);
        } else if (this.oXh != null) {
            this.oXh.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void emx() {
        emu();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ell().isCuidLogin(this.oRx) || com.baidu.yuyinala.privatemessage.implugin.d.b.ell().elm()) {
                login();
                return true;
            }
            f.emB();
            mMode = 0;
            emy();
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
        y(editable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emy() {
        switch (mMode) {
            case 0:
                AA(true);
                this.oWu = d.emC().Yu(this.mKey);
                if (this.oWu != null) {
                    this.oWu.eme();
                    break;
                }
                break;
            case 1:
            case 2:
            default:
                AA(true);
                break;
            case 3:
                AA(false);
                break;
            case 4:
                emz();
                this.oWu = d.emC().Yu(this.mKey);
                if (this.oWu != null) {
                    this.oWu.eme();
                    break;
                }
                break;
        }
        y(this.oXj.getText().toString());
    }

    private void AA(boolean z) {
        if (this.oXk != null) {
            this.oXk.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.h(this.oRx.getActivity(), this.oXj);
            Az(true);
        } else {
            f.g(this.oRx.getActivity(), this.oXj);
            Az(false);
        }
        aH(false, false);
        if (this.mXM != null) {
            this.mXM.setVisibility(0);
        }
        this.oXx = z;
    }

    private void emz() {
        f.g(this.oRx.getActivity(), this.oXj);
        Az(false);
        aH(true, false);
        this.mXM.setVisibility(0);
        this.oXk.setImageResource(ThemeManager.U(this.oRx.getActivity(), a.e.bd_im_input_icon_status));
        e.emQ().OX(this.oXg + this.oXf);
    }

    private void y(CharSequence charSequence) {
        if (this.oXl != null) {
            this.oXl.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.oXl.setTipOn(false);
                this.oXl.setClickable(false);
                this.oXl.setImageDrawable(null);
                this.oXl.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.oXl.setTextSize(this.oRx.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.oXl.setColor(Color.parseColor("#77FF1E66"));
                this.oXl.setText(this.oRx.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.oXl.setClickable(true);
            this.oXl.setTipOn(false);
            this.oXl.setImageDrawable(null);
            this.oXl.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.oXl.setTextSize(this.oRx.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.oXl.setColor(Color.parseColor("#FF1E66"));
            this.oXl.setText(this.oRx.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes11.dex */
    private static class a extends Handler {
        private final SoftReference<b> oXD;

        private a(b bVar) {
            this.oXD = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oXD.get() == null) {
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
                            e.emQ().bw(this.oXD.get().oRx, str);
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

    public void emo() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsFragment.a(this.oXj, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void al(View view) {
        EmojiconsFragment.o(this.oXj);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ell().elm()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.ell().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.5
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.ell().isCuidLogin(this.oRx)) {
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
