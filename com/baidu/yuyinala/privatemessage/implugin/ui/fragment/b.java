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
/* loaded from: classes4.dex */
public class b implements TextWatcher, View.OnTouchListener, com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b, a.b {
    private static int mMode = 3;
    private static int oRo = 200;
    private View kTF;
    private String mKey;
    private LinearLayout mRootLayout;
    private RelativeLayout mSk;
    private ActivityChat oLm;
    private int oQY;
    private int oQZ;
    private c oQi;
    private View oRa;
    private View oRb;
    private EmojiconEditText oRc;
    private ImageButton oRd;
    private ImageButtonText oRe;
    private RelativeLayout oRf;
    private FrameLayout oRg;
    private RelativeLayout oRh;
    private LinearLayout oRi;
    private EmojiconsFragment oRp;
    private boolean oRq;
    private ActivityChat.c oRr;
    private boolean oRj = false;
    private int oRk = 55;
    private boolean oRl = false;
    private int oRm = 0;
    private int cJw = 0;
    private boolean oRn = false;
    @SuppressLint({"HandlerLeak"})
    private a oRs = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.oRr = cVar;
        this.mKey = str;
        d.emz().a(this);
        this.oLm = activityChat;
        this.oQY = (int) this.oLm.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.kTF = view;
        o(this.kTF, ems());
        an(this.kTF);
        this.oRc.addTextChangedListener(this);
        emv();
    }

    private void an(View view) {
        this.oRg = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.oRf = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.oRh = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.oRd = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.oRe = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(this.oLm.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVN, false) && ((ChatInfo.oNx != ChatInfo.ChatCategory.GROUP || ChatInfo.kpi != 2) && ChatInfo.oNx != ChatInfo.ChatCategory.DUZHAN)) {
            this.oRe.setTipOn(true);
        }
        this.oRc = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.oRc.clearFocus();
        this.oRc.setOnTouchListener(this);
        this.oRc.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.mSk = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.oRa = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.oRb = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.oRi = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.oNx) {
            this.oRi.setVisibility(8);
        } else {
            this.oRi.setVisibility(0);
        }
        try {
            this.oRp = EmojiconsFragment.d(this.oLm, this.oRg);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.elg().c(this.oLm.getActivity(), e);
        }
        emq();
    }

    private void emq() {
        this.oRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.elg().isCuidLogin(b.this.oLm.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.elg().elh()) {
                    b.this.login();
                    return;
                }
                f.emy();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.emv();
            }
        });
        this.oRe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.i((Context) b.this.oLm.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVN, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.j((Context) b.this.oLm.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVN, true);
                    b.this.oRe.setTipOn(false);
                }
                f.emy();
                String obj = b.this.oRc.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.oRc.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.oNz);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.elg().getUserId(b.this.oLm.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().getUserId(b.this.oLm.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.oNx == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oNx == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.enY().c(b.this.oLm.getActivity(), textMsg);
                    b.this.oQi = d.emz().YK(b.this.mKey);
                    if (b.this.oQi != null) {
                        b.this.oQi.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.emv();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.oRj);
        this.oRc.addTextChangedListener(this);
        emv();
    }

    public void onPause() {
        this.oRc.removeTextChangedListener(this);
        emr();
    }

    public void onStop() {
        emr();
    }

    public void onStart() {
        emr();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.emQ();
    }

    public void emr() {
        try {
            if (this.oRc != null) {
                this.oRc.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            emv();
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
        }
    }

    private void o(final View view, final boolean z) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int height = view.getRootView().getHeight() - rect.bottom;
                int dt = f.dt(b.this.oLm.getActivity());
                if (height == dt || height - b.this.oRm == dt) {
                    b.this.oRl = true;
                } else if (height == 0 || height - b.this.oRm == (-dt)) {
                    b.this.oRl = false;
                }
                if (b.this.oRl) {
                    height -= dt;
                }
                int i = z ? height - (b.this.oRk * 2) : height;
                if (i > 100) {
                    if (b.this.oRm != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(b.this.oLm.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVL, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.oRm > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.emt();
                        }
                    } else {
                        return;
                    }
                }
                b.this.oRm = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cJw = com.baidu.yuyinala.privatemessage.implugin.util.b.b.j(b.this.oLm.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVL, 0);
                    b.this.oRq = i <= 100;
                    e.emN().Pj((i > 100 ? i : b.this.cJw) + b.this.oQY);
                    if (b.this.oRq && b.this.oRn && b.mMode == 0) {
                        if (!b.this.oRs.hasMessages(1)) {
                            b.this.oRs.sendEmptyMessageDelayed(1, b.oRo);
                            return;
                        }
                        int unused = b.oRo = 30;
                        b.this.oRs.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean ems() {
        if (this.kTF != null) {
            Rect rect = new Rect();
            this.kTF.getWindowVisibleDisplayFrame(rect);
            if (this.kTF.getRootView().getHeight() - rect.bottom == this.oRk * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emt() {
        this.oRp.emp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Az(boolean z) {
        if (this.oLm != null) {
            int i = this.oLm.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.oRb != null) {
                    ViewGroup.LayoutParams layoutParams = this.oRb.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cJw;
                    this.oRb.setLayoutParams(layoutParams);
                    this.oRb.setVisibility(0);
                }
                this.oRn = true;
                return;
            }
            if (this.oRb != null) {
                this.oRb.setVisibility(8);
            }
            this.oRn = false;
        }
    }

    private void aE(boolean z, boolean z2) {
        if (z && this.oRa != null) {
            ViewGroup.LayoutParams layoutParams = this.oRa.getLayoutParams();
            layoutParams.width = -1;
            this.cJw = com.baidu.yuyinala.privatemessage.implugin.util.b.b.j(this.oLm.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVL, 0);
            int dimension = (int) this.oLm.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cJw > 100) {
                layoutParams.height = Math.max(this.cJw, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.oQZ = layoutParams.height;
            this.oRa.setLayoutParams(layoutParams);
            this.oRa.setVisibility(0);
        } else if (this.oRa != null) {
            this.oRa.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void emu() {
        emr();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.elg().isCuidLogin(this.oLm) || com.baidu.yuyinala.privatemessage.implugin.d.b.elg().elh()) {
                login();
                return true;
            }
            f.emy();
            mMode = 0;
            emv();
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
    public void emv() {
        switch (mMode) {
            case 0:
                AA(true);
                this.oQi = d.emz().YK(this.mKey);
                if (this.oQi != null) {
                    this.oQi.ema();
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
                emw();
                this.oQi = d.emz().YK(this.mKey);
                if (this.oQi != null) {
                    this.oQi.ema();
                    break;
                }
                break;
        }
        y(this.oRc.getText().toString());
    }

    private void AA(boolean z) {
        if (this.oRd != null) {
            this.oRd.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.f(this.oLm.getActivity(), this.oRc);
            Az(true);
        } else {
            f.e(this.oLm.getActivity(), this.oRc);
            Az(false);
        }
        aE(false, false);
        if (this.mSk != null) {
            this.mSk.setVisibility(0);
        }
        this.oRq = z;
    }

    private void emw() {
        f.e(this.oLm.getActivity(), this.oRc);
        Az(false);
        aE(true, false);
        this.mSk.setVisibility(0);
        this.oRd.setImageResource(ThemeManager.U(this.oLm.getActivity(), a.e.bd_im_input_icon_status));
        e.emN().Pj(this.oQZ + this.oQY);
    }

    private void y(CharSequence charSequence) {
        if (this.oRe != null) {
            this.oRe.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.oRe.setTipOn(false);
                this.oRe.setClickable(false);
                this.oRe.setImageDrawable(null);
                this.oRe.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.oRe.setTextSize(this.oLm.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.oRe.setColor(Color.parseColor("#77FF1E66"));
                this.oRe.setText(this.oLm.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.oRe.setClickable(true);
            this.oRe.setTipOn(false);
            this.oRe.setImageDrawable(null);
            this.oRe.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.oRe.setTextSize(this.oLm.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.oRe.setColor(Color.parseColor("#FF1E66"));
            this.oRe.setText(this.oLm.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends Handler {
        private final SoftReference<b> oRw;

        private a(b bVar) {
            this.oRw = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oRw.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            this.oRw.get().Az(false);
                            break;
                        case 3:
                            String str = (String) message.obj;
                            if (!TextUtils.isEmpty(str)) {
                                e.emN().br(this.oRw.get().oLm, str);
                                break;
                            }
                            break;
                    }
                } catch (Exception e) {
                    LogUtils.e("InputFragment", "fragment had destroyed");
                }
            }
        }
    }

    public void emk() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsFragment.a(this.oRc, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void el(View view) {
        EmojiconsFragment.n(this.oRc);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.elg().elh()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.elg().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.4
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.elg().isCuidLogin(this.oLm)) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            f.b(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.5
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "cuidToUidLogin result code = " + i);
                }
            });
        }
    }
}
