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
    private static int orl = 200;
    private View kAe;
    private String mKey;
    private LinearLayout mRootLayout;
    private RelativeLayout mxN;
    private ActivityChat ole;
    private int oqU;
    private int oqV;
    private View oqW;
    private View oqX;
    private EmojiconEditText oqY;
    private ImageButton oqZ;
    private c oqe;
    private ImageButtonText ora;
    private RelativeLayout orb;
    private FrameLayout orc;
    private RelativeLayout ord;
    private LinearLayout ore;
    private EmojiconsFragment orm;
    private boolean orn;
    private ActivityChat.c oro;
    private boolean orf = false;
    private int orh = 55;
    private boolean ori = false;
    private int orj = 0;
    private int cys = 0;
    private boolean ork = false;
    @SuppressLint({"HandlerLeak"})
    private a orp = new a();

    public static b a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar) {
        return new b(activityChat, cVar, str, view);
    }

    public b(ActivityChat activityChat, ActivityChat.c cVar, String str, View view) {
        this.mKey = "";
        this.oro = cVar;
        this.mKey = str;
        d.ecY().a(this);
        this.ole = activityChat;
        this.oqU = (int) this.ole.getResources().getDimension(a.e.bd_im_chat_bottom_bar);
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.a(this);
        this.kAe = view;
        m(this.kAe, ecR());
        ah(this.kAe);
        this.oqY.addTextChangedListener(this);
        ecU();
    }

    private void ah(View view) {
        this.orc = (FrameLayout) view.findViewById(a.g.bd_im_showemoji);
        this.orb = (RelativeLayout) view.findViewById(a.g.bd_im_chat_emoji_layout);
        this.ord = (RelativeLayout) view.findViewById(a.g.bd_im_chat_bottom_layout);
        this.oqZ = (ImageButton) view.findViewById(a.g.bd_im_chat_emoji_btn);
        this.mRootLayout = (LinearLayout) view.findViewById(a.g.bd_im_input_root_layout);
        this.ora = (ImageButtonText) view.findViewById(a.g.bd_im_chat_input_right_btn);
        if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.h(this.ole.getApplicationContext(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovL, false) && ((ChatInfo.ons != ChatInfo.ChatCategory.GROUP || ChatInfo.jUX != 2) && ChatInfo.ons != ChatInfo.ChatCategory.DUZHAN)) {
            this.ora.setTipOn(true);
        }
        this.oqY = (EmojiconEditText) view.findViewById(a.g.bd_im_chat_input_txt);
        this.oqY.clearFocus();
        this.oqY.setOnTouchListener(this);
        this.oqY.setBackgroundResource(a.f.bd_im_input_edit_bg);
        this.mxN = (RelativeLayout) view.findViewById(a.g.bd_im_chat_input_background);
        this.oqW = view.findViewById(a.g.bd_im_chat_showemoji_layout);
        this.oqX = view.findViewById(a.g.bd_im_chat_keyborad_layout);
        this.ore = (LinearLayout) view.findViewById(a.g.bd_im_chat_input_layout);
        if (ChatInfo.ChatCategory.SMART == ChatInfo.ons) {
            this.ore.setVisibility(8);
        } else {
            this.ore.setVisibility(0);
        }
        try {
            this.orm = EmojiconsFragment.d(this.ole, this.orc);
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
            com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().c(this.ole.getActivity(), e);
        }
        ecP();
    }

    private void ecP() {
        this.orb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().isCuidLogin(b.this.ole.getActivity()) || com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().ebH()) {
                    b.this.login();
                    return;
                }
                f.ecX();
                if (b.mMode != 4) {
                    int unused = b.mMode = 4;
                } else {
                    int unused2 = b.mMode = 0;
                }
                b.this.ecU();
            }
        });
        this.ora.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (!com.baidu.yuyinala.privatemessage.implugin.util.b.b.h((Context) b.this.ole.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovL, false)) {
                    com.baidu.yuyinala.privatemessage.implugin.util.b.b.i((Context) b.this.ole.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovL, true);
                    b.this.ora.setTipOn(false);
                }
                f.ecX();
                String obj = b.this.oqY.getEditableText().toString();
                if (!TextUtils.isEmpty(obj.trim())) {
                    b.this.oqY.setText("");
                    TextMsg textMsg = new TextMsg();
                    textMsg.setContacter(ChatInfo.mContacter);
                    textMsg.setFromUser(ChatInfo.onu);
                    textMsg.setText(obj);
                    textMsg.setStatus(1);
                    if (com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().getUserId(b.this.ole.getActivity()) != null) {
                        str = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().getUserId(b.this.ole.getActivity());
                    } else {
                        str = "0";
                    }
                    textMsg.setSenderUid(str);
                    if (ChatInfo.ons == ChatInfo.ChatCategory.C2C) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(0);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.ons == ChatInfo.ChatCategory.GROUP) {
                        textMsg.setCategory(1);
                        textMsg.setChatType(3);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    } else if (ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN) {
                        textMsg.setCategory(0);
                        textMsg.setChatType(7);
                        textMsg.setContacterBduid(ChatInfo.mUid + "");
                    }
                    textMsg.setMsgTime(System.currentTimeMillis() / 1000);
                    com.baidu.yuyinala.privatemessage.model.message.a.eew().c(b.this.ole.getActivity(), textMsg);
                    b.this.oqe = d.ecY().Xa(b.this.mKey);
                    if (b.this.oqe != null) {
                        b.this.oqe.h(textMsg);
                        return;
                    }
                    return;
                }
                b.this.ecU();
            }
        });
    }

    public void onResume() {
        LogUtils.d("InputFragment", "onResume " + this.orf);
        this.oqY.addTextChangedListener(this);
        ecU();
    }

    public void onPause() {
        this.oqY.removeTextChangedListener(this);
        ecQ();
    }

    public void onStop() {
        ecQ();
    }

    public void onStart() {
        ecQ();
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.edp();
    }

    public void ecQ() {
        try {
            if (this.oqY != null) {
                this.oqY.clearFocus();
            }
            mMode = 3;
            LogUtils.e("InputFragment", "mMode : " + mMode);
            ecU();
        } catch (Exception e) {
            LogUtils.e("InputFragment", e.getMessage());
        }
    }

    private void m(final View view, final boolean z) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int height = view.getRootView().getHeight() - rect.bottom;
                int cN = f.cN(b.this.ole.getActivity());
                if (height == cN || height - b.this.orj == cN) {
                    b.this.ori = true;
                } else if (height == 0 || height - b.this.orj == (-cN)) {
                    b.this.ori = false;
                }
                if (b.this.ori) {
                    height -= cN;
                }
                int i = z ? height - (b.this.orh * 2) : height;
                if (i > 100) {
                    if (b.this.orj != i) {
                        com.baidu.yuyinala.privatemessage.implugin.util.b.b.h((Context) b.this.ole.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovJ, i);
                        LogUtils.d("InputFragment", "difference write to xml:" + i);
                        if (b.this.orj > 100) {
                            LogUtils.d("InputFragment", "resize of Keyboard");
                            b.this.ecS();
                        }
                    } else {
                        return;
                    }
                }
                b.this.orj = i;
                if (b.mMode == 0 || b.mMode == 3) {
                    b.this.cys = com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(b.this.ole.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovJ, 0);
                    b.this.orn = i <= 100;
                    e.edm().Nn((i > 100 ? i : b.this.cys) + b.this.oqU);
                    if (b.this.orn && b.this.ork && b.mMode == 0) {
                        if (!b.this.orp.hasMessages(1)) {
                            b.this.orp.sendEmptyMessageDelayed(1, b.orl);
                            return;
                        }
                        int unused = b.orl = 30;
                        b.this.orp.removeMessages(1);
                    }
                }
            }
        });
    }

    private boolean ecR() {
        if (this.kAe != null) {
            Rect rect = new Rect();
            this.kAe.getWindowVisibleDisplayFrame(rect);
            if (this.kAe.getRootView().getHeight() - rect.bottom == this.orh * 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecS() {
        this.orm.ecO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zD(boolean z) {
        if (this.ole != null) {
            int i = this.ole.getActivity().getWindow().getAttributes().softInputMode;
            if (z && i != 16) {
                if (this.oqX != null) {
                    ViewGroup.LayoutParams layoutParams = this.oqX.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = this.cys;
                    this.oqX.setLayoutParams(layoutParams);
                    this.oqX.setVisibility(0);
                }
                this.ork = true;
                return;
            }
            if (this.oqX != null) {
                this.oqX.setVisibility(8);
            }
            this.ork = false;
        }
    }

    private void aF(boolean z, boolean z2) {
        if (z && this.oqW != null) {
            ViewGroup.LayoutParams layoutParams = this.oqW.getLayoutParams();
            layoutParams.width = -1;
            this.cys = com.baidu.yuyinala.privatemessage.implugin.util.b.b.i(this.ole.getActivity(), com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovJ, 0);
            int dimension = (int) this.ole.getActivity().getResources().getDimension(a.e.bd_im_more_width);
            if (this.cys > 100) {
                layoutParams.height = Math.max(this.cys, dimension);
            } else {
                layoutParams.height = dimension;
            }
            this.oqV = layoutParams.height;
            this.oqW.setLayoutParams(layoutParams);
            this.oqW.setVisibility(0);
        } else if (this.oqW != null) {
            this.oqW.setVisibility(8);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b
    public void ecT() {
        ecQ();
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view.getId() == a.g.bd_im_chat_input_txt && motionEvent.getAction() == 1) {
            if (com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().isCuidLogin(this.ole) || com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().ebH()) {
                login();
                return true;
            }
            f.ecX();
            mMode = 0;
            ecU();
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
    public void ecU() {
        switch (mMode) {
            case 0:
                zE(true);
                this.oqe = d.ecY().Xa(this.mKey);
                if (this.oqe != null) {
                    this.oqe.ecz();
                    break;
                }
                break;
            case 1:
            case 2:
            default:
                zE(true);
                break;
            case 3:
                zE(false);
                break;
            case 4:
                ecV();
                this.oqe = d.ecY().Xa(this.mKey);
                if (this.oqe != null) {
                    this.oqe.ecz();
                    break;
                }
                break;
        }
        w(this.oqY.getText().toString());
    }

    private void zE(boolean z) {
        if (this.oqZ != null) {
            this.oqZ.setImageResource(a.f.bd_im_emoji_status);
        }
        if (z) {
            f.f(this.ole.getActivity(), this.oqY);
            zD(true);
        } else {
            f.e(this.ole.getActivity(), this.oqY);
            zD(false);
        }
        aF(false, false);
        if (this.mxN != null) {
            this.mxN.setVisibility(0);
        }
        this.orn = z;
    }

    private void ecV() {
        f.e(this.ole.getActivity(), this.oqY);
        zD(false);
        aF(true, false);
        this.mxN.setVisibility(0);
        this.oqZ.setImageResource(ThemeManager.K(this.ole.getActivity(), a.f.bd_im_input_icon_status));
        e.edm().Nn(this.oqV + this.oqU);
    }

    private void w(CharSequence charSequence) {
        if (this.ora != null) {
            this.ora.setBackgroundResource(0);
            if (TextUtils.isEmpty(charSequence.toString().trim())) {
                this.ora.setTipOn(false);
                this.ora.setClickable(false);
                this.ora.setImageDrawable(null);
                this.ora.setBackgroundResource(a.f.bd_im_subscribe_button_disable);
                this.ora.setTextSize(this.ole.getActivity().getResources().getDimension(a.e.bd_im_right_btn_text_size));
                this.ora.setColor(Color.parseColor("#77FF1E66"));
                this.ora.setText(this.ole.getActivity().getString(a.i.bd_im_conversation_send));
                return;
            }
            this.ora.setClickable(true);
            this.ora.setTipOn(false);
            this.ora.setImageDrawable(null);
            this.ora.setBackgroundResource(a.f.bd_im_subscribe_button_pressed);
            this.ora.setTextSize(this.ole.getActivity().getResources().getDimension(a.e.bd_im_right_btn_text_size));
            this.ora.setColor(Color.parseColor("#FF1E66"));
            this.ora.setText(this.ole.getActivity().getString(a.i.bd_im_conversation_send));
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends Handler {
        private final SoftReference<b> ort;

        private a(b bVar) {
            this.ort = new SoftReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.ort.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            this.ort.get().zD(false);
                            break;
                        case 3:
                            String str = (String) message.obj;
                            if (!TextUtils.isEmpty(str)) {
                                e.edm().bq(this.ort.get().ole, str);
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

    public void ecJ() {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void a(Emojicon emojicon) {
        EmojiconsFragment.a(this.oqY, emojicon);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.emojicon.a.b
    public void dL(View view) {
        EmojiconsFragment.n(this.oqY);
    }

    public void login() {
        if (com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().ebH()) {
            LogUtils.d("InputFragment", "will do bindPhone ");
            com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().a(new b.d() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.b.4
                @Override // com.baidu.yuyinala.privatemessage.implugin.ma.a
                public void onResult(int i) {
                    LogUtils.d("InputFragment", "bindPhone result code = " + i);
                }
            });
        } else if (com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().isCuidLogin(this.ole)) {
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
