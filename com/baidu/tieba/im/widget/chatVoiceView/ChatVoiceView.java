package com.baidu.tieba.im.widget.chatVoiceView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.h.h;
import com.baidu.browser.core.util.BdLog;
import com.baidu.tieba.aq;
import com.baidu.tieba.im.d.c;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.voice.ad;
import com.baidu.tieba.voice.af;
import com.google.gson.Gson;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, ad {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f1807a;
    private ImageView b;
    private TextView c;
    private ImageView d;
    private ProgressBar e;
    private VoiceManager.VoiceModel f;
    private ChatMessage g;
    private RelativeLayout h;

    public ChatVoiceView(Context context) {
        super(context);
        this.f1807a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        c();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1807a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aq.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null ? obtainStyledAttributes.getBoolean(0, true) : true) {
            LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.widget_right_voice_view, (ViewGroup) this, true);
        }
        c();
    }

    private void c() {
        this.h = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.f1807a = (ImageView) findViewById(R.id.img_voice_status);
        this.b = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.c = (TextView) findViewById(R.id.tex_voice_duration);
        this.d = (ImageView) findViewById(R.id.img_voice_readed);
        this.e = (ProgressBar) findViewById(R.id.progress);
    }

    private void d() {
        this.f1807a.setVisibility(8);
        this.b.setVisibility(0);
        ((AnimationDrawable) this.b.getBackground()).start();
    }

    private void e() {
        ((AnimationDrawable) this.b.getBackground()).stop();
        this.b.clearAnimation();
        this.f1807a.setVisibility(0);
        this.b.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            e();
        } catch (Exception e) {
        }
    }

    public void a(int i) {
    }

    public void b(int i) {
        if (i == 3) {
            if (this.f1807a != null) {
                this.f1807a.setVisibility(0);
            }
            this.e.setVisibility(4);
            d();
            VoiceMsgData e = c.e(this.g);
            if (e != null && e.getHas_read() != 1) {
                e.setHas_read(1);
                this.g.setContent("[" + new Gson().toJson(e) + "]");
                LinkedList<GroupMsgPojo> linkedList = new LinkedList<>();
                linkedList.add(new GroupMsgPojo(this.g));
                com.baidu.tieba.im.db.a.a().a(this.g.getGroupId(), linkedList, false, new a(this));
                return;
            }
            return;
        }
        e();
        if (i == 1) {
            if (this.f1807a != null) {
                this.f1807a.setVisibility(0);
            }
            this.e.setVisibility(4);
        } else if (i == 2) {
            if (this.f1807a != null) {
                this.f1807a.setVisibility(4);
            }
            this.e.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.f == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.b(this);
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof af) {
            return ((af) context).g();
        }
        return null;
    }

    private void a(ChatMessage chatMessage) {
        boolean z = true;
        if (c.c(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData e = c.e(chatMessage);
            if (e != null && e.getHas_read() == 1) {
                z = false;
            }
        }
        if (z) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }

    public void setData(ChatMessage chatMessage) {
        if (chatMessage != null && chatMessage.getCacheData() != null) {
            this.f = chatMessage.getCacheData().getVoice_model();
            if (this.f == null) {
                this.f = new VoiceManager.VoiceModel();
            }
            this.g = chatMessage;
            this.c.setText(VoiceManager.c(this.f.duration));
            setBubbleLength(this.f.duration);
            setTag(this.f);
            a(chatMessage);
            b(this.f.voice_status.intValue());
        }
    }

    public void a() {
        this.f = null;
        b(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int a2 = UtilHelper.a(getContext());
        if (i <= 10) {
            int i3 = (int) (a2 * 0.1875d);
            i2 = (((((int) (a2 * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (a2 * 0.4125d);
            i2 = (((((int) (a2 * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (a2 * 0.5375d);
        }
        try {
            if (this.h.getParent() != null && (this.h.getParent() instanceof RelativeLayout)) {
                this.h.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.h.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
            BdLog.i("----" + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public void b() {
    }

    @Override // com.baidu.tieba.voice.ad
    public void a(VoiceManager.VoiceModel voiceModel) {
        if (voiceModel != null) {
            b(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public void c(int i) {
        a(i);
        if (this.f != null) {
            this.f.elapse = i;
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public void b(int i, String str) {
        if (!h.a(str)) {
            Toast.makeText(getContext(), str, 1).show();
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public VoiceManager.VoiceModel getVoiceModel() {
        return this.f;
    }

    @Override // com.baidu.tieba.voice.ad
    public ad getRealView() {
        Context context = getContext();
        ad a2 = context instanceof af ? ((af) context).a(this.f) : this;
        return a2 == null ? this : a2;
    }
}
