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
    private static int oRq = 200;
    private View kTH;
    private String mKey;
    private LinearLayout mRootLayout;
    private RelativeLayout mSm;
    private ActivityChat oLo;
    private c oQk;
    private int oRa;
    private int oRb;
    private View oRc;
    private View oRd;
    private EmojiconEditText oRe;
    private ImageButton oRf;
    private ImageButtonText oRg;
    private RelativeLayout oRh;
    private FrameLayout oRi;
    private RelativeLayout oRj;
    private LinearLayout oRk;
    private EmojiconsFragment oRr;
    private boolean oRs;
    private ActivityChat.c oRt;
    private boolean oRl = false;
    private int oRm = 55;
    private boolean oRn = false;
    private int oRo = 0;
    private int cJw = 0;
    private boolean oRp = false;
    @SuppressLint({"HandlerLeak"})
    private a oRu = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.oRt = cVar;
        this.mKey = str;
        d.emA().a(this);
        this.oLo = activityChat;
        this.oRa = (int) this.oLo.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.kTH = view;
        o(this.kTH, emt());
        an(this.kTH);
        this.oRe.addTextChangedListener(this);
        emw();
    }

    private void an(View view) {
        this.oRi = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.oRh = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.oRj = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.oRf = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.oRg = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(this.oLo.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVP, false) && ((ChatInfo.oNz != ChatInfo.ChatCategory.GROUP || ChatInfo.kpk != 2) && ChatInfo.oNz != ChatInfo.ChatCategory.DUZHAN)) {
            this.oRg.setTipOn(true);
        }
        this.oRe = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.oRe.clearFocus();
        this.oRe.setOnTouchListener(this);
        this.oRe.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.mSm = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.oRc = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.oRd = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.oRk = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.oNz) {
            this.oRk.setVisibility(8);
        } else {
            this.oRk.setVisibility(0);
        }
        try {
            this.oRr = EmojiconsFragment.d(this.oLo, this.oRi);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.elh().c(this.oLo.getActivity(), e);
        }
        emr();
    }

    private void emr() {
        this.oRh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.elh().isCuidLogin(b.this.oLo.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.elh().eli()) {
                    b.this.login();
                    return;
                }
                f.emz();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.emw();
            }
        });
        this.oRg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.i((Context) b.this.oLo.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVP, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.j((Context) b.this.oLo.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVP, true);
                    b.this.oRg.setTipOn(false);
                }
                f.emz();
                String obj = b.this.oRe.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.oRe.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.oNB);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.elh().getUserId(b.this.oLo.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().getUserId(b.this.oLo.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.oNz == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oNz == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oNz == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.enZ().c(b.this.oLo.getActivity(), textMsg);
                    b.this.oQk = d.emA().YK(b.this.mKey);
                    if (b.this.oQk != null) {
                        b.this.oQk.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.emw();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.oRl);
        this.oRe.addTextChangedListener(this);
        emw();
    }

    public void onPause() {
        this.oRe.removeTextChangedListener(this);
        ems();
    }

    public void onStop() {
        ems();
    }

    public void onStart() {
        ems();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.emR();
    }

    public void ems() {
        try {
            if (this.oRe != null) {
                this.oRe.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            emw();
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
                int dt = f.dt(b.this.oLo.getActivity());
                if (height == dt || height - b.this.oRo == dt) {
                    b.this.oRn = true;
                } else if (height == 0 || height - b.this.oRo == (-dt)) {
                    b.this.oRn = false;
                }
                if (b.this.oRn) {
                    height -= dt;
                }
                int i = z ? height - (b.this.oRm * 2) : height;
                if (i > 100) {
                    if (b.this.oRo != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(b.this.oLo.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVN, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.oRo > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.emu();
                        }
                    } else {
                        return;
                    }
                }
                b.this.oRo = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cJw = com.baidu.yuyinala.privatemessage.implugin.util.b.b.j(b.this.oLo.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVN, 0);
                    b.this.oRs = i <= 100;
                    e.emO().Pj((i > 100 ? i : b.this.cJw) + b.this.oRa);
                    if (b.this.oRs && b.this.oRp && b.mMode == 0) {
                        if (!b.this.oRu.hasMessages(1)) {
                            b.this.oRu.sendEmptyMessageDelayed(1, b.oRq);
                            return;
                        }
                        int unused = b.oRq = 30;
                        b.this.oRu.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean emt() {
        if (this.kTH != null) {
            Rect rect = new Rect();
            this.kTH.getWindowVisibleDisplayFrame(rect);
            if (this.kTH.getRootView().getHeight() - rect.bottom == this.oRm * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emu() {
        this.oRr.emq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Az(boolean z) {
        if (this.oLo != null) {
            int i = this.oLo.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.oRd != null) {
                    ViewGroup.LayoutParams layoutParams = this.oRd.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cJw;
                    this.oRd.setLayoutParams(layoutParams);
                    this.oRd.setVisibility(0);
                }
                this.oRp = true;
                return;
            }
            if (this.oRd != null) {
                this.oRd.setVisibility(8);
            }
            this.oRp = false;
        }
    }

    private void aE(boolean z, boolean z2) {
        if (z && this.oRc != null) {
            ViewGroup.LayoutParams layoutParams = this.oRc.getLayoutParams();
            layoutParams.width = -1;
            this.cJw = com.baidu.yuyinala.privatemessage.implugin.util.b.b.j(this.oLo.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVN, 0);
            int dimension = (int) this.oLo.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cJw > 100) {
                layoutParams.height = Math.max(this.cJw, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.oRb = layoutParams.height;
            this.oRc.setLayoutParams(layoutParams);
            this.oRc.setVisibility(0);
        } else if (this.oRc != null) {
            this.oRc.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void emv() {
        ems();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.elh().isCuidLogin(this.oLo) || com.baidu.yuyinala.privatemessage.implugin.d.b.elh().eli()) {
                login();
                return true;
            }
            f.emz();
            mMode = 0;
            emw();
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
    public void emw() {
        switch (mMode) {
            case 0:
                AA(true);
                this.oQk = d.emA().YK(this.mKey);
                if (this.oQk != null) {
                    this.oQk.emb();
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
                emx();
                this.oQk = d.emA().YK(this.mKey);
                if (this.oQk != null) {
                    this.oQk.emb();
                    break;
                }
                break;
        }
        y(this.oRe.getText().toString());
    }

    private void AA(boolean z) {
        if (this.oRf != null) {
            this.oRf.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.f(this.oLo.getActivity(), this.oRe);
            Az(true);
        } else {
            f.e(this.oLo.getActivity(), this.oRe);
            Az(false);
        }
        aE(false, false);
        if (this.mSm != null) {
            this.mSm.setVisibility(0);
        }
        this.oRs = z;
    }

    private void emx() {
        f.e(this.oLo.getActivity(), this.oRe);
        Az(false);
        aE(true, false);
        this.mSm.setVisibility(0);
        this.oRf.setImageResource(ThemeManager.U(this.oLo.getActivity(), a.e.bd_im_input_icon_status));
        e.emO().Pj(this.oRb + this.oRa);
    }

    private void y(CharSequence charSequence) {
        if (this.oRg != null) {
            this.oRg.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.oRg.setTipOn(false);
                this.oRg.setClickable(false);
                this.oRg.setImageDrawable(null);
                this.oRg.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.oRg.setTextSize(this.oLo.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.oRg.setColor(Color.parseColor("#77FF1E66"));
                this.oRg.setText(this.oLo.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.oRg.setClickable(true);
            this.oRg.setTipOn(false);
            this.oRg.setImageDrawable(null);
            this.oRg.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.oRg.setTextSize(this.oLo.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.oRg.setColor(Color.parseColor("#FF1E66"));
            this.oRg.setText(this.oLo.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends Handler {
        private final SoftReference<b> oRy;

        private a(b bVar) {
            this.oRy = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oRy.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            this.oRy.get().Az(false);
                            break;
                        case 3:
                            String str = (String) message.obj;
                            if (!TextUtils.isEmpty(str)) {
                                e.emO().br(this.oRy.get().oLo, str);
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

    public void eml() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsFragment.a(this.oRe, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void el(View view) {
        EmojiconsFragment.n(this.oRe);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.elh().eli()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.elh().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.4
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.elh().isCuidLogin(this.oLo)) {
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
