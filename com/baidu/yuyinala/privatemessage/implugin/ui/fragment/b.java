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
    private static int oSU = 200;
    private View bRa;
    private String mKey;
    private LinearLayout mRootLayout;
    private RelativeLayout mTb;
    private ActivityChat oMW;
    private c oRT;
    private int oSE;
    private int oSF;
    private View oSG;
    private View oSH;
    private EmojiconEditText oSI;
    private ImageButton oSJ;
    private ImageButtonText oSK;
    private RelativeLayout oSL;
    private FrameLayout oSM;
    private RelativeLayout oSN;
    private LinearLayout oSO;
    private EmojiconsFragment oSV;
    private boolean oSW;
    private ActivityChat.c oSX;
    private boolean oSP = false;
    private int oSQ = 55;
    private boolean oSR = false;
    private int oSS = 0;
    private int cJF = 0;
    private boolean oST = false;
    @SuppressLint({"HandlerLeak"})
    private a oSY = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.oSX = cVar;
        this.mKey = str;
        d.eiJ().a(this);
        this.oMW = activityChat;
        this.oSE = (int) this.oMW.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.bRa = view.getRootView();
        o(this.bRa, eiC());
        ap(this.bRa);
        this.oSI.addTextChangedListener(this);
        eiF();
        ew(this.bRa);
    }

    private void ew(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new com.baidu.yuyinala.privatemessage.implugin.util.b.b(view, new com.baidu.yuyinala.privatemessage.implugin.util.b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // com.baidu.yuyinala.privatemessage.implugin.util.b.c
            public void a(boolean z, int i, int i2, int i3) {
                if (b.this.oMW != null) {
                    int i4 = b.this.oMW.getActivity().getWindow().getAttributes().softInputMode;
                    if (!z || i4 == 16) {
                        if (b.this.oSH != null) {
                            b.this.oSH.setVisibility(8);
                        }
                        b.this.oST = false;
                        return;
                    }
                    if (b.this.oSH != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.oSH.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = b.this.cJF;
                        b.this.oSH.setLayoutParams(layoutParams);
                        b.this.oSH.setVisibility(0);
                    }
                    b.this.oST = true;
                }
            }
        }));
    }

    private void ap(View view) {
        this.oSM = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.oSL = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.oSN = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.oSJ = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.oSK = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(this.oMW.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXw, false) && ((ChatInfo.oPg != ChatInfo.ChatCategory.GROUP || ChatInfo.oPl != 2) && ChatInfo.oPg != ChatInfo.ChatCategory.DUZHAN)) {
            this.oSK.setTipOn(true);
        }
        this.oSI = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.oSI.clearFocus();
        this.oSI.setOnTouchListener(this);
        this.oSI.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.mTb = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.oSG = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.oSH = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.oSO = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.oPg) {
            this.oSO.setVisibility(8);
        } else {
            this.oSO.setVisibility(0);
        }
        try {
            this.oSV = EmojiconsFragment.f(this.oMW, this.oSM);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().c(this.oMW.getActivity(), e);
        }
        eiA();
    }

    private void eiA() {
        this.oSL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(b.this.oMW.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().eht()) {
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
        this.oSK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(b.this.oMW.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXw, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.j((Context) b.this.oMW.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXw, true);
                    b.this.oSK.setTipOn(false);
                }
                f.eiI();
                String obj = b.this.oSI.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.oSI.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.oPi);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getUserId(b.this.oMW.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().getUserId(b.this.oMW.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.oPg == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oPg == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.ekk().c(b.this.oMW.getActivity(), textMsg);
                    b.this.oRT = d.eiJ().Xm(b.this.mKey);
                    if (b.this.oRT != null) {
                        b.this.oRT.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.eiF();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.oSP);
        this.oSI.addTextChangedListener(this);
        eiF();
    }

    public void onPause() {
        this.oSI.removeTextChangedListener(this);
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
            if (this.oSI != null) {
                this.oSI.clearFocus();
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
                int dL = f.dL(b.this.oMW.getActivity());
                if (height == dL || height - b.this.oSS == dL) {
                    b.this.oSR = true;
                } else if (height == 0 || height - b.this.oSS == (-dL)) {
                    b.this.oSR = false;
                }
                if (b.this.oSR) {
                    height -= dL;
                }
                int i = z ? height - (b.this.oSQ * 2) : height;
                if (i > 100) {
                    if (b.this.oSS != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.j(b.this.oMW.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXu, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.oSS > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.eiD();
                        }
                    } else {
                        return;
                    }
                }
                b.this.oSS = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cJF = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(b.this.oMW.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXu, 0);
                    b.this.oSW = i <= 100;
                    e.eiX().Nq((i > 100 ? i : b.this.cJF) + b.this.oSE);
                    if (b.this.oSW && b.this.oST && b.mMode == 0) {
                        if (!b.this.oSY.hasMessages(1)) {
                            b.this.oSY.sendEmptyMessageDelayed(1, b.oSU);
                            return;
                        }
                        int unused = b.oSU = 30;
                        b.this.oSY.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean eiC() {
        if (this.bRa != null) {
            Rect rect = new Rect();
            this.bRa.getWindowVisibleDisplayFrame(rect);
            if (this.bRa.getRootView().getHeight() - rect.bottom == this.oSQ * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eiD() {
        this.oSV.XQ();
    }

    private void Av(boolean z) {
        if (this.oMW != null) {
            int i = this.oMW.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.oSH != null) {
                    ViewGroup.LayoutParams layoutParams = this.oSH.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cJF;
                    this.oSH.setLayoutParams(layoutParams);
                    this.oSH.setVisibility(0);
                }
                this.oST = true;
                return;
            }
            if (this.oSH != null) {
                this.oSH.setVisibility(8);
            }
            this.oST = false;
        }
    }

    private void aH(boolean z, boolean z2) {
        if (z && this.oSG != null) {
            ViewGroup.LayoutParams layoutParams = this.oSG.getLayoutParams();
            layoutParams.width = -1;
            this.cJF = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(this.oMW.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXu, 0);
            int dimension = (int) this.oMW.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cJF > 100) {
                layoutParams.height = Math.max(this.cJF, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.oSF = layoutParams.height;
            this.oSG.setLayoutParams(layoutParams);
            this.oSG.setVisibility(0);
        } else if (this.oSG != null) {
            this.oSG.setVisibility(8);
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
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(this.oMW) || com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().eht()) {
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
                this.oRT = d.eiJ().Xm(this.mKey);
                if (this.oRT != null) {
                    this.oRT.eil();
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
                this.oRT = d.eiJ().Xm(this.mKey);
                if (this.oRT != null) {
                    this.oRT.eil();
                    break;
                }
                break;
        }
        y(this.oSI.getText().toString());
    }

    private void Aw(boolean z) {
        if (this.oSJ != null) {
            this.oSJ.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.h(this.oMW.getActivity(), this.oSI);
            Av(true);
        } else {
            f.g(this.oMW.getActivity(), this.oSI);
            Av(false);
        }
        aH(false, false);
        if (this.mTb != null) {
            this.mTb.setVisibility(0);
        }
        this.oSW = z;
    }

    private void eiG() {
        f.g(this.oMW.getActivity(), this.oSI);
        Av(false);
        aH(true, false);
        this.mTb.setVisibility(0);
        this.oSJ.setImageResource(ThemeManager.U(this.oMW.getActivity(), a.e.bd_im_input_icon_status));
        e.eiX().Nq(this.oSF + this.oSE);
    }

    private void y(CharSequence charSequence) {
        if (this.oSK != null) {
            this.oSK.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.oSK.setTipOn(false);
                this.oSK.setClickable(false);
                this.oSK.setImageDrawable(null);
                this.oSK.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.oSK.setTextSize(this.oMW.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.oSK.setColor(Color.parseColor("#77FF1E66"));
                this.oSK.setText(this.oMW.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.oSK.setClickable(true);
            this.oSK.setTipOn(false);
            this.oSK.setImageDrawable(null);
            this.oSK.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.oSK.setTextSize(this.oMW.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.oSK.setColor(Color.parseColor("#FF1E66"));
            this.oSK.setText(this.oMW.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends Handler {
        private final SoftReference<b> oTc;

        private a(b bVar) {
            this.oTc = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oTc.get() == null) {
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
                            e.eiX().bw(this.oTc.get().oMW, str);
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
        EmojiconsFragment.a(this.oSI, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void al(View view) {
        EmojiconsFragment.o(this.oSI);
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
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().isCuidLogin(this.oMW)) {
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
