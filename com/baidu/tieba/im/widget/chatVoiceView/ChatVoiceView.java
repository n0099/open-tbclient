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
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.i0.z0.n;
import d.b.j0.e1.h.l;
import d.b.j0.e1.h.m;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class ChatVoiceView extends LinearLayout implements VoiceManager.i, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f17825e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f17826f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17827g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f17828h;
    public ProgressBar i;
    public VoiceData$VoiceModel j;
    public ChatMessage k;
    public RelativeLayout l;

    /* loaded from: classes4.dex */
    public class a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f17829a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17830b;

        public a(CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            this.f17829a = commonGroupChatMessage;
            this.f17830b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.b.j0.e1.h.c.h().l(this.f17829a.getGroupId(), this.f17830b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            ChatVoiceView.this.f17828h.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f17833a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17834b;

        public c(CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            this.f17833a = commonGroupChatMessage;
            this.f17834b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(m.t().m(d.b.j0.e1.w.c.m(this.f17833a), this.f17834b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements n<Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            ChatVoiceView.this.f17828h.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f17837a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17838b;

        public e(PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            this.f17837a = personalChatMessage;
            this.f17838b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(m.t().m(d.b.j0.e1.w.c.m(this.f17837a), this.f17838b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements n<Boolean> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            ChatVoiceView.this.f17828h.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f17841a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17842b;

        public g(OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            this.f17841a = officialChatMessage;
            this.f17842b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(l.t().m(d.b.j0.e1.w.c.m(this.f17841a), this.f17842b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements n<Boolean> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            ChatVoiceView.this.f17828h.setVisibility(8);
        }
    }

    public ChatVoiceView(Context context) {
        super(context);
        this.f17825e = null;
        this.f17827g = null;
        this.f17828h = null;
        this.i = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        b();
    }

    private void setBubbleLength(int i) {
        int i2;
        int i3;
        int i4;
        int k = d.b.c.e.p.l.k(getContext());
        try {
            if (i <= 10) {
                double d2 = k;
                i3 = (int) (0.1875d * d2);
                i4 = ((i - 1) * (((int) (d2 * 0.4125d)) - i3)) / 10;
            } else if (i <= 30) {
                double d3 = k;
                i3 = (int) (0.4125d * d3);
                i4 = ((i - 10) * (((int) (d3 * 0.5375d)) - i3)) / 20;
            } else {
                i2 = (int) (k * 0.5375d);
                if (this.l.getParent() == null && (this.l.getParent() instanceof RelativeLayout)) {
                    this.l.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                    return;
                }
                this.l.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
                return;
            }
            if (this.l.getParent() == null) {
            }
            this.l.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
            return;
        } catch (Exception unused) {
            return;
        }
        i2 = i3 + i4;
    }

    public final void b() {
        this.l = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.f17825e = (ImageView) findViewById(R.id.img_voice_status);
        this.f17826f = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.f17827g = (TextView) findViewById(R.id.tex_voice_duration);
        this.f17828h = (ImageView) findViewById(R.id.img_voice_readed);
        this.i = (ProgressBar) findViewById(R.id.progress);
    }

    public void c(int i) {
    }

    public void d(int i) {
        if (i == 3) {
            ImageView imageView = this.f17825e;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            this.i.setVisibility(4);
            h();
            VoiceMsgData n = d.b.j0.e1.w.c.n(this.k);
            if (n == null || n.getHas_read() == 1) {
                return;
            }
            n.setHas_read(1);
            String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
            this.k.setContent("[" + jsonStrWithObject + "]");
            ChatMessage chatMessage = this.k;
            if (chatMessage instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                LinkedList linkedList = new LinkedList();
                linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(d.b.j0.e1.s.a.i))) {
                    h0.c(new a(commonGroupChatMessage, linkedList), new b());
                    return;
                } else {
                    h0.c(new c(commonGroupChatMessage, linkedList), new d());
                    return;
                }
            } else if (chatMessage instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(new CommonMsgPojo(personalChatMessage));
                h0.c(new e(personalChatMessage, linkedList2), new f());
                return;
            } else if (chatMessage instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(new CommonMsgPojo(officialChatMessage));
                h0.c(new g(officialChatMessage, linkedList3), new h());
                return;
            } else {
                return;
            }
        }
        i();
        if (i == 1) {
            ImageView imageView2 = this.f17825e;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            this.i.setVisibility(4);
        } else if (i == 2) {
            ImageView imageView3 = this.f17825e;
            if (imageView3 != null) {
                imageView3.setVisibility(4);
            }
            this.i.setVisibility(0);
        }
    }

    public void e() {
        this.j = null;
        d(1);
    }

    public final void f(ChatMessage chatMessage) {
        VoiceMsgData n;
        boolean z = true;
        if (d.b.j0.e1.w.c.p(chatMessage) || ((n = d.b.j0.e1.w.c.n(chatMessage)) != null && n.getHas_read() == 1)) {
            z = false;
        }
        if (z) {
            this.f17828h.setVisibility(0);
        } else {
            this.f17828h.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        Context context = getContext();
        VoiceManager.i realView = context instanceof VoiceManager.j ? ((VoiceManager.j) context).getRealView(this.j) : this;
        return realView == null ? this : realView;
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData$VoiceModel getVoiceModel() {
        return this.j;
    }

    public final void h() {
        this.f17825e.setVisibility(8);
        this.f17826f.setVisibility(0);
        ((AnimationDrawable) this.f17826f.getBackground()).start();
    }

    public final void i() {
        ((AnimationDrawable) this.f17826f.getBackground()).stop();
        this.f17826f.clearAnimation();
        this.f17825e.setVisibility(0);
        this.f17826f.setVisibility(8);
    }

    public boolean isPlaying() {
        VoiceData$VoiceModel voiceData$VoiceModel = this.j;
        return voiceData$VoiceModel != null && voiceData$VoiceModel.voice_status.intValue() == 3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        if (this.j == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.startPlay(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            i();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayElapse(int i) {
        c(i);
        VoiceData$VoiceModel voiceData$VoiceModel = this.j;
        if (voiceData$VoiceModel != null) {
            voiceData$VoiceModel.elapse = i;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayPrepared() {
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onRefreshByPlayStatus(VoiceData$VoiceModel voiceData$VoiceModel) {
        if (voiceData$VoiceModel == null) {
            return;
        }
        d(voiceData$VoiceModel.voice_status.intValue());
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i, String str) {
        d.b.c.e.p.l.I(getContext(), str);
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        if (chatMessage == null || chatMessage.getCacheData() == null) {
            return;
        }
        VoiceData$VoiceModel voice_model = chatMessage.getCacheData().getVoice_model();
        this.j = voice_model;
        if (voice_model == null) {
            this.j = new VoiceData$VoiceModel();
        }
        this.k = chatMessage;
        this.f17827g.setText(VoiceManager.formatVoiceTime(this.j.duration));
        this.f17827g.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.j.duration)));
        setBubbleLength(this.j.duration);
        setTag(this.j);
        f(chatMessage);
        if (this.j.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
            voiceManager.resetPlayView(this);
        }
        d(this.j.voice_status.intValue());
    }

    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        this.f17825e = null;
        this.f17827g = null;
        this.f17828h = null;
        this.i = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(R$styleable.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.widget_right_voice_view, (ViewGroup) this, true);
        }
        b();
    }
}
