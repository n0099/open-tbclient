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
    private static int oST = 200;
    private View bRa;
    private String mKey;
    private LinearLayout mRootLayout;
    private RelativeLayout mTb;
    private ActivityChat oMV;
    private c oRS;
    private int oSD;
    private int oSE;
    private View oSF;
    private View oSG;
    private EmojiconEditText oSH;
    private ImageButton oSI;
    private ImageButtonText oSJ;
    private RelativeLayout oSK;
    private FrameLayout oSL;
    private RelativeLayout oSM;
    private LinearLayout oSN;
    private EmojiconsFragment oSU;
    private boolean oSV;
    private ActivityChat.c oSW;
    private boolean oSO = false;
    private int oSP = 55;
    private boolean oSQ = false;
    private int oSR = 0;
    private int cJF = 0;
    private boolean oSS = false;
    @SuppressLint({"HandlerLeak"})
    private a oSX = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.oSW = cVar;
        this.mKey = str;
        d.eiJ().a(this);
        this.oMV = activityChat;
        this.oSD = (int) this.oMV.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.bRa = view.getRootView();
        o(this.bRa, eiC());
        ap(this.bRa);
        this.oSH.addTextChangedListener(this);
        eiF();
        ew(this.bRa);
    }

    private void ew(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new com.baidu.yuyinala.privatemessage.implugin.util.b.b(view, new com.baidu.yuyinala.privatemessage.implugin.util.b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // com.baidu.yuyinala.privatemessage.implugin.util.b.c
            public void a(boolean z, int i, int i2, int i3) {
                if (b.this.oMV != null) {
                    int i4 = b.this.oMV.getActivity().getWindow().getAttributes().softInputMode;
                    if (!z || i4 == 16) {
                        if (b.this.oSG != null) {
                            b.this.oSG.setVisibility(8);
                        }
                        b.this.oSS = false;
                        return;
                    }
                    if (b.this.oSG != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.oSG.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = b.this.cJF;
                        b.this.oSG.setLayoutParams(layoutParams);
                        b.this.oSG.setVisibility(0);
                    }
                    b.this.oSS = true;
                }
            }
        }));
    }

    private void ap(View view) {
        this.oSL = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.oSK = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.oSM = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.oSI = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.oSJ = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(this.oMV.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXv, false) && ((ChatInfo.oPf != ChatInfo.ChatCategory.GROUP || ChatInfo.oPk != 2) && ChatInfo.oPf != ChatInfo.ChatCategory.DUZHAN)) {
            this.oSJ.setTipOn(true);
        }
        this.oSH = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.oSH.clearFocus();
        this.oSH.setOnTouchListener(this);
        this.oSH.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.mTb = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.oSF = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.oSG = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.oSN = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.oPf) {
            this.oSN.setVisibility(8);
        } else {
            this.oSN.setVisibility(0);
        }
        try {
            this.oSU = EmojiconsFragment.f(this.oMV, this.oSL);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().c(this.oMV.getActivity(), e);
        }
        eiA();
    }

    private void eiA() {
        this.oSK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(b.this.oMV.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().eht()) {
                    b.this.login();
                    return;
                }
                f.eiI();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.eiF();
            }
        });
        this.oSJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(b.this.oMV.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXv, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.j((Context) b.this.oMV.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXv, true);
                    b.this.oSJ.setTipOn(false);
                }
                f.eiI();
                String obj = b.this.oSH.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.oSH.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.oPh);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getUserId(b.this.oMV.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getUserId(b.this.oMV.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.oPf == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oPf == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oPf == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.ekk().c(b.this.oMV.getActivity(), textMsg);
                    b.this.oRS = d.eiJ().Xl(b.this.mKey);
                    if (b.this.oRS != null) {
                        b.this.oRS.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.eiF();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.oSO);
        this.oSH.addTextChangedListener(this);
        eiF();
    }

    public void onPause() {
        this.oSH.removeTextChangedListener(this);
        eiB();
    }

    public void onStop() {
        eiB();
    }

    public void onStart() {
        eiB();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.eja();
    }

    public void eiB() {
        try {
            if (this.oSH != null) {
                this.oSH.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            eiF();
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
                int dL = f.dL(b.this.oMV.getActivity());
                if (height == dL || height - b.this.oSR == dL) {
                    b.this.oSQ = true;
                } else if (height == 0 || height - b.this.oSR == (-dL)) {
                    b.this.oSQ = false;
                }
                if (b.this.oSQ) {
                    height -= dL;
                }
                int i = z ? height - (b.this.oSP * 2) : height;
                if (i > 100) {
                    if (b.this.oSR != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.j(b.this.oMV.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXt, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.oSR > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.eiD();
                        }
                    } else {
                        return;
                    }
                }
                b.this.oSR = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cJF = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(b.this.oMV.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXt, 0);
                    b.this.oSV = i <= 100;
                    e.eiX().Nq((i > 100 ? i : b.this.cJF) + b.this.oSD);
                    if (b.this.oSV && b.this.oSS && b.mMode == 0) {
                        if (!b.this.oSX.hasMessages(1)) {
                            b.this.oSX.sendEmptyMessageDelayed(1, b.oST);
                            return;
                        }
                        int unused = b.oST = 30;
                        b.this.oSX.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean eiC() {
        if (this.bRa != null) {
            Rect rect = new Rect();
            this.bRa.getWindowVisibleDisplayFrame(rect);
            if (this.bRa.getRootView().getHeight() - rect.bottom == this.oSP * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eiD() {
        this.oSU.XQ();
    }

    private void Av(boolean z) {
        if (this.oMV != null) {
            int i = this.oMV.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.oSG != null) {
                    ViewGroup.LayoutParams layoutParams = this.oSG.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cJF;
                    this.oSG.setLayoutParams(layoutParams);
                    this.oSG.setVisibility(0);
                }
                this.oSS = true;
                return;
            }
            if (this.oSG != null) {
                this.oSG.setVisibility(8);
            }
            this.oSS = false;
        }
    }

    private void aH(boolean z, boolean z2) {
        if (z && this.oSF != null) {
            ViewGroup.LayoutParams layoutParams = this.oSF.getLayoutParams();
            layoutParams.width = -1;
            this.cJF = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(this.oMV.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXt, 0);
            int dimension = (int) this.oMV.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cJF > 100) {
                layoutParams.height = Math.max(this.cJF, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.oSE = layoutParams.height;
            this.oSF.setLayoutParams(layoutParams);
            this.oSF.setVisibility(0);
        } else if (this.oSF != null) {
            this.oSF.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void eiE() {
        eiB();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(this.oMV) || com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().eht()) {
                login();
                return true;
            }
            f.eiI();
            mMode = 0;
            eiF();
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
    public void eiF() {
        switch (mMode) {
            case 0:
                Aw(true);
                this.oRS = d.eiJ().Xl(this.mKey);
                if (this.oRS != null) {
                    this.oRS.eil();
                    break;
                }
                break;
            case 1:
            case 2:
            default:
                Aw(true);
                break;
            case 3:
                Aw(false);
                break;
            case 4:
                eiG();
                this.oRS = d.eiJ().Xl(this.mKey);
                if (this.oRS != null) {
                    this.oRS.eil();
                    break;
                }
                break;
        }
        y(this.oSH.getText().toString());
    }

    private void Aw(boolean z) {
        if (this.oSI != null) {
            this.oSI.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.h(this.oMV.getActivity(), this.oSH);
            Av(true);
        } else {
            f.g(this.oMV.getActivity(), this.oSH);
            Av(false);
        }
        aH(false, false);
        if (this.mTb != null) {
            this.mTb.setVisibility(0);
        }
        this.oSV = z;
    }

    private void eiG() {
        f.g(this.oMV.getActivity(), this.oSH);
        Av(false);
        aH(true, false);
        this.mTb.setVisibility(0);
        this.oSI.setImageResource(ThemeManager.U(this.oMV.getActivity(), a.e.bd_im_input_icon_status));
        e.eiX().Nq(this.oSE + this.oSD);
    }

    private void y(CharSequence charSequence) {
        if (this.oSJ != null) {
            this.oSJ.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.oSJ.setTipOn(false);
                this.oSJ.setClickable(false);
                this.oSJ.setImageDrawable(null);
                this.oSJ.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.oSJ.setTextSize(this.oMV.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.oSJ.setColor(Color.parseColor("#77FF1E66"));
                this.oSJ.setText(this.oMV.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.oSJ.setClickable(true);
            this.oSJ.setTipOn(false);
            this.oSJ.setImageDrawable(null);
            this.oSJ.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.oSJ.setTextSize(this.oMV.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.oSJ.setColor(Color.parseColor("#FF1E66"));
            this.oSJ.setText(this.oMV.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends Handler {
        private final SoftReference<b> oTb;

        private a(b bVar) {
            this.oTb = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oTb.get() == null) {
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
                            e.eiX().bw(this.oTb.get().oMV, str);
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

    public void eiv() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsFragment.a(this.oSH, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void al(View view) {
        EmojiconsFragment.o(this.oSH);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().eht()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.5
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(this.oMV)) {
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
