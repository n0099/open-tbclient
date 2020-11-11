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
    private static int oAE = 200;
    private View kFY;
    private RelativeLayout mDO;
    private String mKey;
    private LinearLayout mRootLayout;
    private EmojiconsFragment oAF;
    private boolean oAG;
    private ActivityChat.c oAH;
    private int oAo;
    private int oAp;
    private View oAq;
    private View oAr;
    private EmojiconEditText oAs;
    private ImageButton oAt;
    private ImageButtonText oAu;
    private RelativeLayout oAv;
    private FrameLayout oAw;
    private RelativeLayout oAx;
    private LinearLayout oAy;
    private ActivityChat ouC;
    private c ozy;
    private boolean oAz = false;
    private int oAA = 55;
    private boolean oAB = false;
    private int oAC = 0;
    private int cEl = 0;
    private boolean oAD = false;
    @SuppressLint({"HandlerLeak"})
    private a oAI = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.oAH = cVar;
        this.mKey = str;
        d.egN().a(this);
        this.ouC = activityChat;
        this.oAo = (int) this.ouC.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.kFY = view;
        n(this.kFY, egG());
        al(this.kFY);
        this.oAs.addTextChangedListener(this);
        egJ();
    }

    private void al(View view) {
        this.oAw = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.oAv = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.oAx = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.oAt = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.oAu = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.h(this.ouC.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFd, false) && ((ChatInfo.owN != ChatInfo.ChatCategory.GROUP || ChatInfo.kaU != 2) && ChatInfo.owN != ChatInfo.ChatCategory.DUZHAN)) {
            this.oAu.setTipOn(true);
        }
        this.oAs = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.oAs.clearFocus();
        this.oAs.setOnTouchListener(this);
        this.oAs.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.mDO = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.oAq = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.oAr = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.oAy = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.owN) {
            this.oAy.setVisibility(8);
        } else {
            this.oAy.setVisibility(0);
        }
        try {
            this.oAF = EmojiconsFragment.d(this.ouC, this.oAw);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.efv().c(this.ouC.getActivity(), e);
        }
        egE();
    }

    private void egE() {
        this.oAv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.efv().isCuidLogin(b.this.ouC.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.efv().efw()) {
                    b.this.login();
                    return;
                }
                f.egM();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.egJ();
            }
        });
        this.oAu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.h((Context) b.this.ouC.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFd, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.i((Context) b.this.ouC.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFd, true);
                    b.this.oAu.setTipOn(false);
                }
                f.egM();
                String obj = b.this.oAs.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.oAs.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.owP);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.efv().getUserId(b.this.ouC.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().getUserId(b.this.ouC.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.owN == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.owN == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.owN == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.eil().c(b.this.ouC.getActivity(), textMsg);
                    b.this.ozy = d.egN().XE(b.this.mKey);
                    if (b.this.ozy != null) {
                        b.this.ozy.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.egJ();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.oAz);
        this.oAs.addTextChangedListener(this);
        egJ();
    }

    public void onPause() {
        this.oAs.removeTextChangedListener(this);
        egF();
    }

    public void onStop() {
        egF();
    }

    public void onStart() {
        egF();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.ehe();
    }

    public void egF() {
        try {
            if (this.oAs != null) {
                this.oAs.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            egJ();
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
        }
    }

    private void n(final View view, final boolean z) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int height = view.getRootView().getHeight() - rect.bottom;
                int cN = f.cN(b.this.ouC.getActivity());
                if (height == cN || height - b.this.oAC == cN) {
                    b.this.oAB = true;
                } else if (height == 0 || height - b.this.oAC == (-cN)) {
                    b.this.oAB = false;
                }
                if (b.this.oAB) {
                    height -= cN;
                }
                int i = z ? height - (b.this.oAA * 2) : height;
                if (i > 100) {
                    if (b.this.oAC != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.h((Context) b.this.ouC.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFb, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.oAC > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.egH();
                        }
                    } else {
                        return;
                    }
                }
                b.this.oAC = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cEl = com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(b.this.ouC.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFb, 0);
                    b.this.oAG = i <= 100;
                    e.ehb().NI((i > 100 ? i : b.this.cEl) + b.this.oAo);
                    if (b.this.oAG && b.this.oAD && b.mMode == 0) {
                        if (!b.this.oAI.hasMessages(1)) {
                            b.this.oAI.sendEmptyMessageDelayed(1, b.oAE);
                            return;
                        }
                        int unused = b.oAE = 30;
                        b.this.oAI.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean egG() {
        if (this.kFY != null) {
            Rect rect = new Rect();
            this.kFY.getWindowVisibleDisplayFrame(rect);
            if (this.kFY.getRootView().getHeight() - rect.bottom == this.oAA * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egH() {
        this.oAF.egD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zO(boolean z) {
        if (this.ouC != null) {
            int i = this.ouC.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.oAr != null) {
                    ViewGroup.LayoutParams layoutParams = this.oAr.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cEl;
                    this.oAr.setLayoutParams(layoutParams);
                    this.oAr.setVisibility(0);
                }
                this.oAD = true;
                return;
            }
            if (this.oAr != null) {
                this.oAr.setVisibility(8);
            }
            this.oAD = false;
        }
    }

    private void aF(boolean z, boolean z2) {
        if (z && this.oAq != null) {
            ViewGroup.LayoutParams layoutParams = this.oAq.getLayoutParams();
            layoutParams.width = -1;
            this.cEl = com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(this.ouC.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFb, 0);
            int dimension = (int) this.ouC.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cEl > 100) {
                layoutParams.height = Math.max(this.cEl, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.oAp = layoutParams.height;
            this.oAq.setLayoutParams(layoutParams);
            this.oAq.setVisibility(0);
        } else if (this.oAq != null) {
            this.oAq.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void egI() {
        egF();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.efv().isCuidLogin(this.ouC) || com.baidu.yuyinala.privatemessage.implugin.d.b.efv().efw()) {
                login();
                return true;
            }
            f.egM();
            mMode = 0;
            egJ();
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
        w(editable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egJ() {
        switch (mMode) {
            case 0:
                zP(true);
                this.ozy = d.egN().XE(this.mKey);
                if (this.ozy != null) {
                    this.ozy.ego();
                    break;
                }
                break;
            case 1:
            case 2:
            default:
                zP(true);
                break;
            case 3:
                zP(false);
                break;
            case 4:
                egK();
                this.ozy = d.egN().XE(this.mKey);
                if (this.ozy != null) {
                    this.ozy.ego();
                    break;
                }
                break;
        }
        w(this.oAs.getText().toString());
    }

    private void zP(boolean z) {
        if (this.oAt != null) {
            this.oAt.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.f(this.ouC.getActivity(), this.oAs);
            zO(true);
        } else {
            f.e(this.ouC.getActivity(), this.oAs);
            zO(false);
        }
        aF(false, false);
        if (this.mDO != null) {
            this.mDO.setVisibility(0);
        }
        this.oAG = z;
    }

    private void egK() {
        f.e(this.ouC.getActivity(), this.oAs);
        zO(false);
        aF(true, false);
        this.mDO.setVisibility(0);
        this.oAt.setImageResource(ThemeManager.L(this.ouC.getActivity(), a.e.bd_im_input_icon_status));
        e.ehb().NI(this.oAp + this.oAo);
    }

    private void w(CharSequence charSequence) {
        if (this.oAu != null) {
            this.oAu.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.oAu.setTipOn(false);
                this.oAu.setClickable(false);
                this.oAu.setImageDrawable(null);
                this.oAu.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.oAu.setTextSize(this.ouC.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.oAu.setColor(Color.parseColor("#77FF1E66"));
                this.oAu.setText(this.ouC.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.oAu.setClickable(true);
            this.oAu.setTipOn(false);
            this.oAu.setImageDrawable(null);
            this.oAu.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.oAu.setTextSize(this.ouC.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.oAu.setColor(Color.parseColor("#FF1E66"));
            this.oAu.setText(this.ouC.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends Handler {
        private final SoftReference<b> oAM;

        private a(b bVar) {
            this.oAM = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oAM.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            this.oAM.get().zO(false);
                            break;
                        case 3:
                            String str = (String) message.obj;
                            if (!TextUtils.isEmpty(str)) {
                                e.ehb().bq(this.oAM.get().ouC, str);
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

    public void egy() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsFragment.a(this.oAs, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void dT(View view) {
        EmojiconsFragment.n(this.oAs);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.efv().efw()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.efv().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.4
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.efv().isCuidLogin(this.ouC)) {
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
