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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.e;
import com.baidu.gson.Gson;
import com.baidu.tieba.am;
import com.baidu.tieba.im.chat.q;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.message.g;
import com.baidu.tieba.im.util.l;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.voice.ad;
import com.baidu.tieba.voice.af;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, ad {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private ImageView d;
    private ProgressBar e;
    private VoiceManager.VoiceModel f;
    private com.baidu.tieba.im.message.b g;
    private RelativeLayout h;

    public ChatVoiceView(Context context) {
        super(context);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        b();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, am.ChatVoiceView, 0, 0);
        boolean z = obtainStyledAttributes != null ? obtainStyledAttributes.getBoolean(0, true) : true;
        obtainStyledAttributes.recycle();
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.widget_right_voice_view, (ViewGroup) this, true);
        }
        b();
    }

    private void b() {
        this.h = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.a = (ImageView) findViewById(R.id.img_voice_status);
        this.b = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.c = (TextView) findViewById(R.id.tex_voice_duration);
        this.d = (ImageView) findViewById(R.id.img_voice_readed);
        this.e = (ProgressBar) findViewById(R.id.progress);
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
            VoiceMsgData f = l.f(this.g);
            if (f != null && f.getHas_read() != 1) {
                f.setHas_read(1);
                this.g.a("[" + new Gson().toJson(f) + "]");
                if (this.g instanceof g) {
                    g gVar = (g) this.g;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(gVar));
                    if (!gVar.u().equals(String.valueOf(q.a))) {
                        i.a(new a(this, gVar, linkedList), new b(this));
                        return;
                    } else {
                        i.a(new c(this, gVar, linkedList), new d(this));
                        return;
                    }
                }
                return;
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
        if (context instanceof af) {
            return ((af) context).c_();
        }
        return null;
    }

    public void setData(com.baidu.tieba.im.message.b bVar) {
        boolean z = true;
        if (bVar != null && bVar.o() != null) {
            this.f = bVar.o().getVoice_model();
            if (this.f == null) {
                this.f = new VoiceManager.VoiceModel();
            }
            this.g = bVar;
            this.c.setText(VoiceManager.b(this.f.duration));
            setBubbleLength(this.f.duration);
            setTag(this.f);
            if (l.d(bVar)) {
                z = false;
            } else {
                VoiceMsgData f = l.f(bVar);
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
        int b = BdUtilHelper.b(getContext());
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
            e.d("----" + e.getMessage());
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public final void a(VoiceManager.VoiceModel voiceModel) {
        if (voiceModel != null) {
            b(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public final void a(int i) {
        if (this.f != null) {
            this.f.elapse = i;
        }
    }

    @Override // com.baidu.tieba.voice.ad
    public final void a(int i, String str) {
        BdUtilHelper.b(getContext(), str);
    }

    @Override // com.baidu.tieba.voice.ad
    public VoiceManager.VoiceModel getVoiceModel() {
        return this.f;
    }

    @Override // com.baidu.tieba.voice.ad
    public ad getRealView() {
        Context context = getContext();
        ad a = context instanceof af ? ((af) context).a(this.f) : this;
        return a == null ? this : a;
    }
}
