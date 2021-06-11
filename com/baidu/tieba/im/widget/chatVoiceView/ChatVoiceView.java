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
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import d.a.n0.f1.h.l;
import d.a.n0.f1.h.m;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class ChatVoiceView extends LinearLayout implements VoiceManager.i, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f17458e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f17459f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17460g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f17461h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f17462i;
    public VoiceData$VoiceModel j;
    public ChatMessage k;
    public RelativeLayout l;

    /* loaded from: classes4.dex */
    public class a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f17463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17464b;

        public a(CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            this.f17463a = commonGroupChatMessage;
            this.f17464b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.n0.f1.h.c.h().l(this.f17463a.getGroupId(), this.f17464b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            ChatVoiceView.this.f17461h.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f17467a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17468b;

        public c(CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            this.f17467a = commonGroupChatMessage;
            this.f17468b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(m.t().m(d.a.n0.f1.w.c.m(this.f17467a), this.f17468b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements n<Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            ChatVoiceView.this.f17461h.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f17471a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17472b;

        public e(PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            this.f17471a = personalChatMessage;
            this.f17472b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(m.t().m(d.a.n0.f1.w.c.m(this.f17471a), this.f17472b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements n<Boolean> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            ChatVoiceView.this.f17461h.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f17475a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17476b;

        public g(OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            this.f17475a = officialChatMessage;
            this.f17476b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(l.t().m(d.a.n0.f1.w.c.m(this.f17475a), this.f17476b, false));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements n<Boolean> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            ChatVoiceView.this.f17461h.setVisibility(8);
        }
    }

    public ChatVoiceView(Context context) {
        super(context);
        this.f17458e = null;
        this.f17460g = null;
        this.f17461h = null;
        this.f17462i = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        b();
    }

    private void setBubbleLength(int i2) {
        int i3;
        int i4;
        int i5;
        int k = d.a.c.e.p.l.k(getContext());
        try {
            if (i2 <= 10) {
                double d2 = k;
                i4 = (int) (0.1875d * d2);
                i5 = ((i2 - 1) * (((int) (d2 * 0.4125d)) - i4)) / 10;
            } else if (i2 <= 30) {
                double d3 = k;
                i4 = (int) (0.4125d * d3);
                i5 = ((i2 - 10) * (((int) (d3 * 0.5375d)) - i4)) / 20;
            } else {
                i3 = (int) (k * 0.5375d);
                if (this.l.getParent() == null && (this.l.getParent() instanceof RelativeLayout)) {
                    this.l.setLayoutParams(new RelativeLayout.LayoutParams(i3, -2));
                    return;
                }
                this.l.setLayoutParams(new LinearLayout.LayoutParams(i3, -2));
                return;
            }
            if (this.l.getParent() == null) {
            }
            this.l.setLayoutParams(new LinearLayout.LayoutParams(i3, -2));
            return;
        } catch (Exception unused) {
            return;
        }
        i3 = i4 + i5;
    }

    public final void b() {
        this.l = (RelativeLayout) findViewById(R.id.lay_bubble);
        this.f17458e = (ImageView) findViewById(R.id.img_voice_status);
        this.f17459f = (ImageView) findViewById(R.id.img_voice_status_anim);
        this.f17460g = (TextView) findViewById(R.id.tex_voice_duration);
        this.f17461h = (ImageView) findViewById(R.id.img_voice_readed);
        this.f17462i = (ProgressBar) findViewById(R.id.progress);
    }

    public void c(int i2) {
    }

    public void d(int i2) {
        if (i2 == 3) {
            ImageView imageView = this.f17458e;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            this.f17462i.setVisibility(4);
            h();
            VoiceMsgData n = d.a.n0.f1.w.c.n(this.k);
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
                if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(d.a.n0.f1.s.a.f58385i))) {
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
        if (i2 == 1) {
            ImageView imageView2 = this.f17458e;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            this.f17462i.setVisibility(4);
        } else if (i2 == 2) {
            ImageView imageView3 = this.f17458e;
            if (imageView3 != null) {
                imageView3.setVisibility(4);
            }
            this.f17462i.setVisibility(0);
        }
    }

    public void e() {
        this.j = null;
        d(1);
    }

    public final void f(ChatMessage chatMessage) {
        VoiceMsgData n;
        boolean z = true;
        if (d.a.n0.f1.w.c.p(chatMessage) || ((n = d.a.n0.f1.w.c.n(chatMessage)) != null && n.getHas_read() == 1)) {
            z = false;
        }
        if (z) {
            this.f17461h.setVisibility(0);
        } else {
            this.f17461h.setVisibility(8);
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
        this.f17458e.setVisibility(8);
        this.f17459f.setVisibility(0);
        ((AnimationDrawable) this.f17459f.getBackground()).start();
    }

    public final void i() {
        ((AnimationDrawable) this.f17459f.getBackground()).stop();
        this.f17459f.clearAnimation();
        this.f17458e.setVisibility(0);
        this.f17459f.setVisibility(8);
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
    public void onPlayElapse(int i2) {
        c(i2);
        VoiceData$VoiceModel voiceData$VoiceModel = this.j;
        if (voiceData$VoiceModel != null) {
            voiceData$VoiceModel.elapse = i2;
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
    public void onShowErr(int i2, String str) {
        d.a.c.e.p.l.J(getContext(), str);
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
        this.f17460g.setText(VoiceManager.formatVoiceTime(this.j.duration));
        this.f17460g.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.j.duration)));
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
        this.f17458e = null;
        this.f17460g = null;
        this.f17461h = null;
        this.f17462i = null;
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
