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
    private static int pdh = 200;
    private View bUP;
    private String mKey;
    private LinearLayout mRootLayout;
    private RelativeLayout ncw;
    private ActivityChat oXg;
    private int pcR;
    private int pcS;
    private View pcT;
    private View pcU;
    private EmojiconEditText pcV;
    private ImageButton pcW;
    private ImageButtonText pcX;
    private RelativeLayout pcY;
    private FrameLayout pcZ;
    private c pcf;
    private RelativeLayout pda;
    private LinearLayout pdb;
    private EmojiconsView pdi;
    private boolean pdj;
    private ActivityChat.c pdk;
    private boolean pdc = false;
    private int pdd = 55;
    private boolean pde = false;
    private int pdf = 0;
    private int cLT = 0;
    private boolean pdg = false;
    @SuppressLint({"HandlerLeak"})
    private a pdl = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.pdk = cVar;
        this.mKey = str;
        d.eld().a(this);
        this.oXg = activityChat;
        this.pcR = (int) this.oXg.getResources().getDimension(a.d.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.bUP = view.getRootView();
        o(this.bUP, ekW());
        am(this.bUP);
        this.pcV.addTextChangedListener(this);
        ekZ();
        eu(this.bUP);
    }

    private void eu(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new com.baidu.yuyinala.privatemessage.implugin.util.b.b(view, new com.baidu.yuyinala.privatemessage.implugin.util.b.c() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // com.baidu.yuyinala.privatemessage.implugin.util.b.c
            public void a(boolean z, int i, int i2, int i3) {
                if (b.this.oXg != null) {
                    int i4 = b.this.oXg.getActivity().getWindow().getAttributes().softInputMode;
                    if (!z || i4 == 16) {
                        if (b.this.pcU != null) {
                            b.this.pcU.setVisibility(8);
                        }
                        b.this.pdg = false;
                        return;
                    }
                    if (b.this.pcU != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.pcU.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = b.this.cLT;
                        b.this.pcU.setLayoutParams(layoutParams);
                        b.this.pcU.setVisibility(0);
                    }
                    b.this.pdg = true;
                }
            }
        }));
    }

    private void am(View view) {
        this.pcZ = (FrameLayout) view.findViewById(a.f.bd_im_showemoji);
        this.pcY = (RelativeLayout) view.findViewById(a.f.bd_im_chat_emoji_layout);
        this.pda = (RelativeLayout) view.findViewById(a.f.bd_im_chat_bottom_layout);
        this.pcW = (ImageButton) view.findViewById(a.f.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.f.bd_im_input_root_layout);
        this.pcX = (ImageButtonText) view.findViewById(a.f.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(this.oXg.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.phJ, false) && ((ChatInfo.oZq != ChatInfo.ChatCategory.GROUP || ChatInfo.oZv != 2) && ChatInfo.oZq != ChatInfo.ChatCategory.DUZHAN)) {
            this.pcX.setTipOn(true);
        }
        this.pcV = (EmojiconEditText) view.findViewById(a.f.bd_im_chat_input_txt);
        this.pcV.clearFocus();
        this.pcV.setOnTouchListener(this);
        this.pcV.setBackgroundResource(a.e.bd_im_input_edit_bg);
        this.ncw = (RelativeLayout) view.findViewById(a.f.bd_im_chat_input_background);
        this.pcT = view.findViewById(a.f.bd_im_chat_showemoji_layout);
        this.pcU = view.findViewById(a.f.bd_im_chat_keyborad_layout);
        this.pdb = (LinearLayout) view.findViewById(a.f.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.oZq) {
            this.pdb.setVisibility(8);
        } else {
            this.pdb.setVisibility(0);
        }
        try {
            this.pdi = EmojiconsView.f(this.oXg, this.pcZ);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().c(this.oXg.getActivity(), e);
        }
        ekU();
    }

    private void ekU() {
        this.pcY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().isCuidLogin(b.this.oXg.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().ejN()) {
                    b.this.login();
                    return;
                }
                f.elc();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.ekZ();
            }
        });
        this.pcX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.c.b.i(b.this.oXg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.phJ, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.b.j((Context) b.this.oXg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.phJ, true);
                    b.this.pcX.setTipOn(false);
                }
                f.elc();
                String obj = b.this.pcV.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.pcV.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.oZs);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().getUserId(b.this.oXg.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().getUserId(b.this.oXg.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.oZq == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oZq == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.emC().c(b.this.oXg.getActivity(), textMsg);
                    b.this.pcf = d.eld().Yn(b.this.mKey);
                    if (b.this.pcf != null) {
                        b.this.pcf.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.ekZ();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.pdc);
        this.pcV.addTextChangedListener(this);
        ekZ();
    }

    public void onPause() {
        this.pcV.removeTextChangedListener(this);
        ekV();
    }

    public void onStop() {
        ekV();
    }

    public void onStart() {
        ekV();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.elu();
    }

    public void ekV() {
        try {
            if (this.pcV != null) {
                this.pcV.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            ekZ();
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
                int dK = f.dK(b.this.oXg.getActivity());
                if (height == dK || height - b.this.pdf == dK) {
                    b.this.pde = true;
                } else if (height == 0 || height - b.this.pdf == (-dK)) {
                    b.this.pde = false;
                }
                if (b.this.pde) {
                    height -= dK;
                }
                int i = z ? height - (b.this.pdd * 2) : height;
                if (i > 100) {
                    if (b.this.pdf != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.b.j(b.this.oXg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.phH, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.pdf > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.ekX();
                        }
                    } else {
                        return;
                    }
                }
                b.this.pdf = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cLT = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(b.this.oXg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.phH, 0);
                    b.this.pdj = i <= 100;
                    e.elr().NL((i > 100 ? i : b.this.cLT) + b.this.pcR);
                    if (b.this.pdj && b.this.pdg && b.mMode == 0) {
                        if (!b.this.pdl.hasMessages(1)) {
                            b.this.pdl.sendEmptyMessageDelayed(1, b.pdh);
                            return;
                        }
                        int unused = b.pdh = 30;
                        b.this.pdl.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean ekW() {
        if (this.bUP != null) {
            Rect rect = new Rect();
            this.bUP.getWindowVisibleDisplayFrame(rect);
            if (this.bUP.getRootView().getHeight() - rect.bottom == this.pdd * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekX() {
        this.pdi.ZH();
    }

    private void AO(boolean z) {
        if (this.oXg != null) {
            int i = this.oXg.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.pcU != null) {
                    ViewGroup.LayoutParams layoutParams = this.pcU.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cLT;
                    this.pcU.setLayoutParams(layoutParams);
                    this.pcU.setVisibility(0);
                }
                this.pdg = true;
                return;
            }
            if (this.pcU != null) {
                this.pcU.setVisibility(8);
            }
            this.pdg = false;
        }
    }

    private void aH(boolean z, boolean z2) {
        if (z && this.pcT != null) {
            ViewGroup.LayoutParams layoutParams = this.pcT.getLayoutParams();
            layoutParams.width = -1;
            this.cLT = com.baidu.yuyinala.privatemessage.implugin.util.c.b.k(this.oXg.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.c.a.phH, 0);
            int dimension = (int) this.oXg.getActivity().getResources().getDimension(a.d.bd_im_more_width);
            if (this.cLT > 100) {
                layoutParams.height = Math.max(this.cLT, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.pcS = layoutParams.height;
            this.pcT.setLayoutParams(layoutParams);
            this.pcT.setVisibility(0);
        } else if (this.pcT != null) {
            this.pcT.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void ekY() {
        ekV();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.f.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().isCuidLogin(this.oXg) || com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().ejN()) {
                login();
                return true;
            }
            f.elc();
            mMode = 0;
            ekZ();
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
    public void ekZ() {
        switch (mMode) {
            case 0:
                AP(true);
                this.pcf = d.eld().Yn(this.mKey);
                if (this.pcf != null) {
                    this.pcf.ekF();
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
                ela();
                this.pcf = d.eld().Yn(this.mKey);
                if (this.pcf != null) {
                    this.pcf.ekF();
                    break;
                }
                break;
        }
        z(this.pcV.getText().toString());
    }

    private void AP(boolean z) {
        if (this.pcW != null) {
            this.pcW.setImageResource(a.e.bd_im_emoji_status);
        }
        if (z) {
            f.h(this.oXg.getActivity(), this.pcV);
            AO(true);
        } else {
            f.g(this.oXg.getActivity(), this.pcV);
            AO(false);
        }
        aH(false, false);
        if (this.ncw != null) {
            this.ncw.setVisibility(0);
        }
        this.pdj = z;
    }

    private void ela() {
        f.g(this.oXg.getActivity(), this.pcV);
        AO(false);
        aH(true, false);
        this.ncw.setVisibility(0);
        this.pcW.setImageResource(ThemeManager.U(this.oXg.getActivity(), a.e.bd_im_input_icon_status));
        e.elr().NL(this.pcS + this.pcR);
    }

    private void z(CharSequence charSequence) {
        if (this.pcX != null) {
            this.pcX.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.pcX.setTipOn(false);
                this.pcX.setClickable(false);
                this.pcX.setImageDrawable(null);
                this.pcX.setBackgroundResource(a.e.bd_im_subscribe_button_disable);
                this.pcX.setTextSize(this.oXg.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
                this.pcX.setColor(Color.parseColor("#77FF1E66"));
                this.pcX.setText(this.oXg.getActivity().getString(a.h.bd_im_conversation_send));
                return;
            }
            this.pcX.setClickable(true);
            this.pcX.setTipOn(false);
            this.pcX.setImageDrawable(null);
            this.pcX.setBackgroundResource(a.e.bd_im_subscribe_button_pressed);
            this.pcX.setTextSize(this.oXg.getActivity().getResources().getDimension(a.d.bd_im_right_btn_text_size));
            this.pcX.setColor(Color.parseColor("#FF1E66"));
            this.pcX.setText(this.oXg.getActivity().getString(a.h.bd_im_conversation_send));
        }
    }

    /* loaded from: classes11.dex */
    private static class a extends Handler {
        private final SoftReference<b> pdp;

        private a(b bVar) {
            this.pdp = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.pdp.get() == null) {
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
                            e.elr().bv(this.pdp.get().oXg, str);
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

    public void ekP() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsView.a(this.pcV, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void aj(View view) {
        EmojiconsView.o(this.pcV);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().ejN()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.5
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().isCuidLogin(this.oXg)) {
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
