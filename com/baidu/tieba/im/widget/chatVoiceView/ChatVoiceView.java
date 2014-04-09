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
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.x;
import com.baidu.tbadk.core.voice.z;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.f.q;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.l;
import com.baidu.tieba.im.r;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, x {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private ImageView d;
    private ProgressBar e;
    private VoiceData.VoiceModel f;
    private com.baidu.tieba.im.message.a.a g;
    private RelativeLayout h;

    public ChatVoiceView(Context context) {
        super(context);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        LayoutInflater.from(context).inflate(i.widget_left_voice_view, (ViewGroup) this, true);
        b();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ChatVoiceView, 0, 0);
        boolean z = obtainStyledAttributes != null ? obtainStyledAttributes.getBoolean(0, true) : true;
        obtainStyledAttributes.recycle();
        if (z) {
            LayoutInflater.from(context).inflate(i.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(i.widget_right_voice_view, (ViewGroup) this, true);
        }
        b();
    }

    private void b() {
        this.h = (RelativeLayout) findViewById(com.baidu.tieba.im.h.lay_bubble);
        this.a = (ImageView) findViewById(com.baidu.tieba.im.h.img_voice_status);
        this.b = (ImageView) findViewById(com.baidu.tieba.im.h.img_voice_status_anim);
        this.c = (TextView) findViewById(com.baidu.tieba.im.h.tex_voice_duration);
        this.d = (ImageView) findViewById(com.baidu.tieba.im.h.img_voice_readed);
        this.e = (ProgressBar) findViewById(com.baidu.tieba.im.h.progress);
    }

    private void c() {
        ((AnimationDrawable) this.b.getBackground()).stop();
        this.b.clearAnimation();
        this.a.setVisibility(0);
        this.b.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            c();
        } catch (Exception e) {
        }
    }

    private void b(int i) {
        if (i == 3) {
            if (this.a != null) {
                this.a.setVisibility(0);
            }
            this.e.setVisibility(4);
            this.a.setVisibility(8);
            this.b.setVisibility(0);
            ((AnimationDrawable) this.b.getBackground()).start();
            VoiceMsgData f = q.f(this.g);
            if (f != null && f.getHas_read() != 1) {
                f.setHas_read(1);
                this.g.d("[" + new Gson().toJson(f) + "]");
                if (this.g instanceof com.baidu.tieba.im.message.a.b) {
                    com.baidu.tieba.im.message.a.b bVar = (com.baidu.tieba.im.message.a.b) this.g;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(bVar));
                    if (!bVar.i().equals(String.valueOf(com.baidu.tieba.im.chat.x.a))) {
                        r.a(new a(this, bVar, linkedList), new b(this));
                        return;
                    } else {
                        r.a(new c(this, bVar, linkedList), new d(this));
                        return;
                    }
                } else if (this.g instanceof com.baidu.tieba.im.message.a.f) {
                    com.baidu.tieba.im.message.a.f fVar = (com.baidu.tieba.im.message.a.f) this.g;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(fVar));
                    r.a(new e(this, fVar, linkedList2), new f(this));
                    return;
                } else if (this.g instanceof com.baidu.tieba.im.message.a.e) {
                    com.baidu.tieba.im.message.a.e eVar = (com.baidu.tieba.im.message.a.e) this.g;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(eVar));
                    r.a(new g(this, eVar, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        c();
        if (i == 1) {
            if (this.a != null) {
                this.a.setVisibility(0);
            }
            this.e.setVisibility(4);
        } else if (i == 2) {
            if (this.a != null) {
                this.a.setVisibility(4);
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
        if (context instanceof z) {
            return ((z) context).d();
        }
        return null;
    }

    public void setData(com.baidu.tieba.im.message.a.a aVar) {
        boolean z = true;
        if (aVar != null && aVar.z() != null) {
            this.f = aVar.z().getVoice_model();
            if (this.f == null) {
                this.f = new VoiceData.VoiceModel();
            }
            this.g = aVar;
            this.c.setText(VoiceManager.b(this.f.duration));
            setBubbleLength(this.f.duration);
            setTag(this.f);
            if (q.d(aVar)) {
                z = false;
            } else {
                VoiceMsgData f = q.f(aVar);
                if (f != null && f.getHas_read() == 1) {
                    z = false;
                }
            }
            if (z) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            b(this.f.voice_status.intValue());
        }
    }

    public final void a() {
        this.f = null;
        b(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int b = com.baidu.adp.lib.util.i.b(getContext());
        if (i <= 10) {
            int i3 = (int) (b * 0.1875d);
            i2 = (((((int) (b * 0.4125d)) - i3) * (i - 1)) / 10) + i3;
        } else if (i <= 30) {
            int i4 = (int) (b * 0.4125d);
            i2 = (((((int) (b * 0.5375d)) - i4) * (i - 10)) / 20) + i4;
        } else {
            i2 = (int) (b * 0.5375d);
        }
        try {
            if (this.h.getParent() != null && (this.h.getParent() instanceof RelativeLayout)) {
                this.h.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                return;
            }
            this.h.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.d("----" + e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public final void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            b(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public final void a(int i) {
        if (this.f != null) {
            this.f.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.x
    public final void a(int i, String str) {
        com.baidu.adp.lib.util.i.b(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.x
    public VoiceData.VoiceModel getVoiceModel() {
        return this.f;
    }

    @Override // com.baidu.tbadk.core.voice.x
    public x getRealView() {
        Context context = getContext();
        x a = context instanceof z ? ((z) context).a(this.f) : this;
        return a == null ? this : a;
    }
}
