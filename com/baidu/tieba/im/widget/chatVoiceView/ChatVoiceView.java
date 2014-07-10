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
import com.baidu.adp.lib.util.j;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.y;
import com.baidu.tieba.aa;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.e.r;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ChatVoiceView extends LinearLayout implements View.OnClickListener, y {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private ImageView d;
    private ProgressBar e;
    private VoiceData.VoiceModel f;
    private ChatMessage g;
    private RelativeLayout h;

    public ChatVoiceView(Context context) {
        super(context);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        LayoutInflater.from(context).inflate(w.widget_left_voice_view, (ViewGroup) this, true);
        c();
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.ChatVoiceView, 0, 0);
        boolean z = obtainStyledAttributes != null ? obtainStyledAttributes.getBoolean(0, true) : true;
        obtainStyledAttributes.recycle();
        if (z) {
            LayoutInflater.from(context).inflate(w.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(w.widget_right_voice_view, (ViewGroup) this, true);
        }
        c();
    }

    private void c() {
        this.h = (RelativeLayout) findViewById(v.lay_bubble);
        this.a = (ImageView) findViewById(v.img_voice_status);
        this.b = (ImageView) findViewById(v.img_voice_status_anim);
        this.c = (TextView) findViewById(v.tex_voice_duration);
        this.d = (ImageView) findViewById(v.img_voice_readed);
        this.e = (ProgressBar) findViewById(v.progress);
    }

    private void d() {
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        ((AnimationDrawable) this.b.getBackground()).start();
    }

    private void e() {
        ((AnimationDrawable) this.b.getBackground()).stop();
        this.b.clearAnimation();
        this.a.setVisibility(0);
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

    public void b(int i) {
    }

    public void c(int i) {
        if (i == 3) {
            if (this.a != null) {
                this.a.setVisibility(0);
            }
            this.e.setVisibility(4);
            d();
            VoiceMsgData g = r.g(this.g);
            if (g != null && g.getHas_read() != 1) {
                g.setHas_read(1);
                this.g.setContent("[" + new Gson().toJson(g) + "]");
                if (this.g instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) this.g;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(com.baidu.tieba.im.chat.w.a))) {
                        i.a(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        i.a(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (this.g instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) this.g;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    i.a(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (this.g instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) this.g;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    i.a(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        e();
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
        voiceManager.startPlay(this);
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof com.baidu.tbadk.core.voice.aa) {
            return ((com.baidu.tbadk.core.voice.aa) context).d();
        }
        return null;
    }

    private void a(ChatMessage chatMessage) {
        boolean z = true;
        if (r.d(chatMessage)) {
            z = false;
        } else {
            VoiceMsgData g = r.g(chatMessage);
            if (g != null && g.getHas_read() == 1) {
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
                this.f = new VoiceData.VoiceModel();
            }
            this.g = chatMessage;
            this.c.setText(VoiceManager.formatVoiceTime(this.f.duration));
            setBubbleLength(this.f.duration);
            setTag(this.f);
            a(chatMessage);
            c(this.f.voice_status.intValue());
        }
    }

    public void b() {
        this.f = null;
        c(1);
    }

    private void setBubbleLength(int i) {
        int i2;
        int b = j.b(getContext());
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
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a() {
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            c(voiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(int i) {
        b(i);
        if (this.f != null) {
            this.f.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.y
    public void a(int i, String str) {
        j.b(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.y
    public VoiceData.VoiceModel getVoiceModel() {
        return this.f;
    }

    @Override // com.baidu.tbadk.core.voice.y
    public y getRealView() {
        Context context = getContext();
        y a = context instanceof com.baidu.tbadk.core.voice.aa ? ((com.baidu.tbadk.core.voice.aa) context).a(this.f) : this;
        return a == null ? this : a;
    }
}
