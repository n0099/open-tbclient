package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.tieba.view.AudioAnimationView;
import d.b.b.a.f;
import d.b.b.a.j;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
/* loaded from: classes5.dex */
public class PlayVoiceBntNew extends RelativeLayout implements VoiceManager.i, View.OnClickListener {
    public static final int p = ((l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;

    /* renamed from: e  reason: collision with root package name */
    public VoiceData$VoiceModel f21423e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f21424f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21425g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21426h;
    public ProgressBar i;
    public AudioAnimationView j;
    public Context k;
    public int l;
    public View.OnClickListener m;
    public float n;
    public VoiceManager o;

    /* loaded from: classes5.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.l = 0;
        play_type.ordinal();
        h(context);
    }

    private int getAudioVoiceColumnCount() {
        VoiceData$VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return 0;
        }
        return g(voiceModel) / 10;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void a(int i) {
        if (!j()) {
            m(1);
            return;
        }
        l(i);
        VoiceData$VoiceModel voiceData$VoiceModel = this.f21423e;
        if (voiceData$VoiceModel != null) {
            voiceData$VoiceModel.elapse = i;
        }
    }

    public final void b() {
        this.j.e(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void c(VoiceData$VoiceModel voiceData$VoiceModel) {
        if (voiceData$VoiceModel == null) {
            return;
        }
        if (this.f21423e != voiceData$VoiceModel) {
            m(1);
        } else {
            m(voiceData$VoiceModel.voice_status.intValue());
        }
    }

    public void d() {
        b();
        SkinManager.setViewTextColor(this.f21426h, R.color.CAM_X0302);
        c a2 = c.a(this.f21424f);
        a2.h(R.string.J_X05);
        a2.f(R.dimen.L_X03);
        a2.e(R.color.CAM_X0302);
        a2.c(R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void e() {
    }

    public final void f(boolean z) {
        ImageView imageView = this.f21425g;
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_common_voice_pause16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_common_voice_play16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public final int g(VoiceData$VoiceModel voiceData$VoiceModel) {
        double d2;
        double d3;
        int i = voiceData$VoiceModel.duration;
        if (i < 10) {
            double d4 = p;
            Double.isNaN(d4);
            d2 = d4 * 0.6d;
        } else {
            if (i < 30) {
                d3 = p;
                Double.isNaN(d3);
            } else if (i < 60) {
                d3 = p;
                Double.isNaN(d3);
            } else {
                d2 = p * 2;
            }
            d2 = d3 * 0.6d * 2.0d;
        }
        if (d2 < l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double d5 = this.n;
        Double.isNaN(d5);
        double d6 = d2 - d5;
        double g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        Double.isNaN(g2);
        double d7 = d6 - g2;
        if (d7 > 0.0d) {
            return (int) d7;
        }
        return 0;
    }

    public ImageView getImgStatus() {
        return this.f21425g;
    }

    public TextView getPlayTime() {
        return this.f21426h;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getRealView(this.f21423e);
        }
        return ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) ? ((VoiceManager.j) tbPageContext.getOrignalPage()).getRealView(this.f21423e) : this;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getVoiceManager();
        }
        if ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
            return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.o;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData$VoiceModel getVoiceModel() {
        return this.f21423e;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.f21424f;
    }

    public void h(Context context) {
        i(context);
        setOnClickListener(this);
    }

    public void i(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.f21424f = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f21425g = (ImageView) findViewById(R.id.playingImg);
        this.f21426h = (TextView) findViewById(R.id.playTime);
        this.j = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        this.i = progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
        this.k = context;
        d();
    }

    public final boolean j() {
        if (this.f21423e == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.f21423e);
    }

    public void k(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout = this.f21424f;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(onClickListener);
        }
    }

    public void l(int i) {
        String formatVoiceTime;
        int i2;
        VoiceData$VoiceModel voiceData$VoiceModel = this.f21423e;
        if (voiceData$VoiceModel == null || this.f21426h == null) {
            return;
        }
        int i3 = i / 1000;
        if (i3 > 0 && i3 < (i2 = voiceData$VoiceModel.duration)) {
            formatVoiceTime = VoiceManager.formatVoiceTime(i2 - i3);
        } else {
            formatVoiceTime = VoiceManager.formatVoiceTime(this.f21423e.duration);
        }
        String charSequence2String = k.charSequence2String(this.f21426h.getText(), null);
        if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
            this.f21426h.setText(formatVoiceTime);
        }
    }

    public void m(int i) {
        if (i == 3) {
            this.i.setVisibility(4);
            f(true);
            this.j.setVisibility(0);
            this.j.g();
            return;
        }
        this.j.setCertainColumnCount(getAudioVoiceColumnCount());
        this.j.f();
        this.j.setVisibility(4);
        f(false);
        if (i == 1) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.f21423e;
            if (voiceData$VoiceModel != null) {
                this.f21426h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
            }
            this.i.setVisibility(4);
        } else if (i == 2) {
            VoiceData$VoiceModel voiceData$VoiceModel2 = this.f21423e;
            if (voiceData$VoiceModel2 != null) {
                this.f21426h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel2.duration));
            }
            this.i.setVisibility(0);
        }
    }

    public void n() {
        this.f21423e = null;
        setTag(null);
        m(1);
    }

    public void o() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.width = -2;
        this.j.setLayoutParams(layoutParams);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f21423e == null || view != this.f21424f) {
            return;
        }
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null) {
            voiceManager.setAllowChangeVoiceMode(true);
            voiceManager.startPlay(this);
        }
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
        TiebaStatic.log(this.f21423e.from);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i, String str) {
        l.I(getContext(), str);
    }

    public void p() {
        VoiceManager voiceManager;
        if (this.f21423e == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void setPlayTimeTextView(int i) {
        TextView textView = this.f21426h;
        if (textView != null) {
            textView.setTextSize(0, l.g(getContext(), i));
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData$VoiceModel voiceData$VoiceModel = (VoiceData$VoiceModel) tbRichTextVoiceInfo.u();
            if (voiceData$VoiceModel == null) {
                voiceData$VoiceModel = new VoiceData$VoiceModel();
                if (tbRichTextVoiceInfo.s() == 0) {
                    voiceData$VoiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceData$VoiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceData$VoiceModel.voiceId = tbRichTextVoiceInfo.t();
                voiceData$VoiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.v(voiceData$VoiceModel);
            }
            tbRichTextVoiceInfo.s();
            setVoiceModel(voiceData$VoiceModel);
            b();
            obj = voiceData$VoiceModel;
        }
        super.setTag(obj);
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.o = voiceManager;
    }

    public void setVoiceModel(VoiceData$VoiceModel voiceData$VoiceModel) {
        requestLayout();
        this.f21423e = voiceData$VoiceModel;
        if (voiceData$VoiceModel == null) {
            return;
        }
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null && voiceManager.isPlayDoing(voiceData$VoiceModel)) {
            voiceManager.resetPlayView(this);
            l(this.f21423e.elapse);
            return;
        }
        m(this.f21423e.voice_status.intValue());
        String formatVoiceTime = VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration);
        int measureText = (int) this.f21426h.getPaint().measureText(formatVoiceTime);
        this.l = measureText;
        this.n = measureText + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);
        this.j.setCertainColumnCount(getAudioVoiceColumnCount());
        this.j.f();
        this.f21424f.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.n, getPaddingBottom());
        this.f21426h.setText(formatVoiceTime);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Voice_play_type);
        obtainStyledAttributes.getInteger(R$styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        h(context);
    }
}
