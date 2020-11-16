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
    private static int oCi = 200;
    private View kGn;
    private RelativeLayout mEl;
    private String mKey;
    private LinearLayout mRootLayout;
    private int oBS;
    private int oBT;
    private View oBU;
    private View oBV;
    private EmojiconEditText oBW;
    private ImageButton oBX;
    private ImageButtonText oBY;
    private RelativeLayout oBZ;
    private c oBc;
    private FrameLayout oCa;
    private RelativeLayout oCb;
    private LinearLayout oCc;
    private EmojiconsFragment oCj;
    private boolean oCk;
    private ActivityChat.c oCl;
    private ActivityChat owg;
    private boolean oCd = false;
    private int oCe = 55;
    private boolean oCf = false;
    private int oCg = 0;
    private int cCB = 0;
    private boolean oCh = false;
    @SuppressLint({"HandlerLeak"})
    private a oCm = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.oCl = cVar;
        this.mKey = str;
        d.egL().a(this);
        this.owg = activityChat;
        this.oBS = (int) this.owg.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.kGn = view;
        o(this.kGn, egE());
        al(this.kGn);
        this.oBW.addTextChangedListener(this);
        egH();
    }

    private void al(View view) {
        this.oCa = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.oBZ = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.oCb = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.oBX = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.oBY = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.h(this.owg.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGH, false) && ((ChatInfo.oyr != ChatInfo.ChatCategory.GROUP || ChatInfo.kbE != 2) && ChatInfo.oyr != ChatInfo.ChatCategory.DUZHAN)) {
            this.oBY.setTipOn(true);
        }
        this.oBW = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.oBW.clearFocus();
        this.oBW.setOnTouchListener(this);
        this.oBW.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.mEl = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.oBU = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.oBV = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.oCc = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.oyr) {
            this.oCc.setVisibility(8);
        } else {
            this.oCc.setVisibility(0);
        }
        try {
            this.oCj = EmojiconsFragment.d(this.owg, this.oCa);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.eft().c(this.owg.getActivity(), e);
        }
        egC();
    }

    private void egC() {
        this.oBZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.eft().isCuidLogin(b.this.owg.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.eft().efu()) {
                    b.this.login();
                    return;
                }
                f.egK();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.egH();
            }
        });
        this.oBY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.h((Context) b.this.owg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGH, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.i((Context) b.this.owg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGH, true);
                    b.this.oBY.setTipOn(false);
                }
                f.egK();
                String obj = b.this.oBW.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.oBW.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.oyt);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.eft().getUserId(b.this.owg.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().getUserId(b.this.owg.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.oyr == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oyr == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.eij().c(b.this.owg.getActivity(), textMsg);
                    b.this.oBc = d.egL().Xp(b.this.mKey);
                    if (b.this.oBc != null) {
                        b.this.oBc.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.egH();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.oCd);
        this.oBW.addTextChangedListener(this);
        egH();
    }

    public void onPause() {
        this.oBW.removeTextChangedListener(this);
        egD();
    }

    public void onStop() {
        egD();
    }

    public void onStart() {
        egD();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.ehc();
    }

    public void egD() {
        try {
            if (this.oBW != null) {
                this.oBW.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            egH();
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
                int cN = f.cN(b.this.owg.getActivity());
                if (height == cN || height - b.this.oCg == cN) {
                    b.this.oCf = true;
                } else if (height == 0 || height - b.this.oCg == (-cN)) {
                    b.this.oCf = false;
                }
                if (b.this.oCf) {
                    height -= cN;
                }
                int i = z ? height - (b.this.oCe * 2) : height;
                if (i > 100) {
                    if (b.this.oCg != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.h((Context) b.this.owg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGF, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.oCg > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.egF();
                        }
                    } else {
                        return;
                    }
                }
                b.this.oCg = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cCB = com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(b.this.owg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGF, 0);
                    b.this.oCk = i <= 100;
                    e.egZ().Ol((i > 100 ? i : b.this.cCB) + b.this.oBS);
                    if (b.this.oCk && b.this.oCh && b.mMode == 0) {
                        if (!b.this.oCm.hasMessages(1)) {
                            b.this.oCm.sendEmptyMessageDelayed(1, b.oCi);
                            return;
                        }
                        int unused = b.oCi = 30;
                        b.this.oCm.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean egE() {
        if (this.kGn != null) {
            Rect rect = new Rect();
            this.kGn.getWindowVisibleDisplayFrame(rect);
            if (this.kGn.getRootView().getHeight() - rect.bottom == this.oCe * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egF() {
        this.oCj.egB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(boolean z) {
        if (this.owg != null) {
            int i = this.owg.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.oBV != null) {
                    ViewGroup.LayoutParams layoutParams = this.oBV.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cCB;
                    this.oBV.setLayoutParams(layoutParams);
                    this.oBV.setVisibility(0);
                }
                this.oCh = true;
                return;
            }
            if (this.oBV != null) {
                this.oBV.setVisibility(8);
            }
            this.oCh = false;
        }
    }

    private void aD(boolean z, boolean z2) {
        if (z && this.oBU != null) {
            ViewGroup.LayoutParams layoutParams = this.oBU.getLayoutParams();
            layoutParams.width = -1;
            this.cCB = com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(this.owg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGF, 0);
            int dimension = (int) this.owg.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cCB > 100) {
                layoutParams.height = Math.max(this.cCB, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.oBT = layoutParams.height;
            this.oBU.setLayoutParams(layoutParams);
            this.oBU.setVisibility(0);
        } else if (this.oBU != null) {
            this.oBU.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void egG() {
        egD();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.eft().isCuidLogin(this.owg) || com.baidu.yuyinala.privatemessage.implugin.d.b.eft().efu()) {
                login();
                return true;
            }
            f.egK();
            mMode = 0;
            egH();
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
        x(editable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egH() {
        switch (mMode) {
            case 0:
                zW(true);
                this.oBc = d.egL().Xp(this.mKey);
                if (this.oBc != null) {
                    this.oBc.egm();
                    break;
                }
                break;
            case 1:
            case 2:
            default:
                zW(true);
                break;
            case 3:
                zW(false);
                break;
            case 4:
                egI();
                this.oBc = d.egL().Xp(this.mKey);
                if (this.oBc != null) {
                    this.oBc.egm();
                    break;
                }
                break;
        }
        x(this.oBW.getText().toString());
    }

    private void zW(boolean z) {
        if (this.oBX != null) {
            this.oBX.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.f(this.owg.getActivity(), this.oBW);
            zV(true);
        } else {
            f.e(this.owg.getActivity(), this.oBW);
            zV(false);
        }
        aD(false, false);
        if (this.mEl != null) {
            this.mEl.setVisibility(0);
        }
        this.oCk = z;
    }

    private void egI() {
        f.e(this.owg.getActivity(), this.oBW);
        zV(false);
        aD(true, false);
        this.mEl.setVisibility(0);
        this.oBX.setImageResource(ThemeManager.L(this.owg.getActivity(), a.e.bd_im_input_icon_status));
        e.egZ().Ol(this.oBT + this.oBS);
    }

    private void x(CharSequence charSequence) {
        if (this.oBY != null) {
            this.oBY.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.oBY.setTipOn(false);
                this.oBY.setClickable(false);
                this.oBY.setImageDrawable(null);
                this.oBY.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.oBY.setTextSize(this.owg.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.oBY.setColor(Color.parseColor("#77FF1E66"));
                this.oBY.setText(this.owg.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.oBY.setClickable(true);
            this.oBY.setTipOn(false);
            this.oBY.setImageDrawable(null);
            this.oBY.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.oBY.setTextSize(this.owg.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.oBY.setColor(Color.parseColor("#FF1E66"));
            this.oBY.setText(this.owg.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends Handler {
        private final SoftReference<b> oCq;

        private a(b bVar) {
            this.oCq = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oCq.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            this.oCq.get().zV(false);
                            break;
                        case 3:
                            String str = (String) message.obj;
                            if (!TextUtils.isEmpty(str)) {
                                e.egZ().bn(this.oCq.get().owg, str);
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

    public void egw() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsFragment.a(this.oBW, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void ea(View view) {
        EmojiconsFragment.n(this.oBW);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.eft().efu()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.eft().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.4
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.eft().isCuidLogin(this.owg)) {
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
