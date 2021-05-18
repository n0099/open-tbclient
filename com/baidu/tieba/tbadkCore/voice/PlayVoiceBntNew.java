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
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.j0.r.u.c;
/* loaded from: classes5.dex */
public class PlayVoiceBntNew extends RelativeLayout implements VoiceManager.i, View.OnClickListener {
    public static final int p = ((l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;

    /* renamed from: e  reason: collision with root package name */
    public VoiceData$VoiceModel f20951e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f20952f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20953g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f20954h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f20955i;
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
        e(context);
    }

    private int getAudioVoiceColumnCount() {
        VoiceData$VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return 0;
        }
        return d(voiceModel) / 10;
    }

    public final void a() {
        this.j.e(TbadkCoreApplication.getInst().getSkinType());
    }

    public void b() {
        a();
        SkinManager.setViewTextColor(this.f20954h, R.color.CAM_X0302);
        c d2 = c.d(this.f20952f);
        d2.k(R.string.J_X05);
        d2.i(R.dimen.L_X03);
        d2.h(R.color.CAM_X0302);
        d2.f(R.color.CAM_X0201);
    }

    public final void c(boolean z) {
        ImageView imageView = this.f20953g;
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_common_voice_pause16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_common_voice_play16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        }
    }

    public final int d(VoiceData$VoiceModel voiceData$VoiceModel) {
        double d2;
        int i2;
        int i3 = voiceData$VoiceModel.duration;
        if (i3 < 10) {
            d2 = p * 0.6d;
        } else {
            if (i3 < 30) {
                i2 = p;
            } else if (i3 < 60) {
                i2 = p;
            } else {
                d2 = p * 2;
            }
            d2 = i2 * 0.6d * 2.0d;
        }
        if (d2 < l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double g2 = (d2 - this.n) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (g2 > 0.0d) {
            return (int) g2;
        }
        return 0;
    }

    public void e(Context context) {
        f(context);
        setOnClickListener(this);
    }

    public void f(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.f20952f = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.f20953g = (ImageView) findViewById(R.id.playingImg);
        this.f20954h = (TextView) findViewById(R.id.playTime);
        this.j = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        this.f20955i = progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
        this.k = context;
        b();
    }

    public final boolean g() {
        if (this.f20951e == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.f20951e);
    }

    public ImageView getImgStatus() {
        return this.f20953g;
    }

    public TextView getPlayTime() {
        return this.f20954h;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getRealView(this.f20951e);
        }
        return ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) ? ((VoiceManager.j) tbPageContext.getOrignalPage()).getRealView(this.f20951e) : this;
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
        return this.f20951e;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.f20952f;
    }

    public void h(View.OnClickListener onClickListener) {
        RelativeLayout relativeLayout = this.f20952f;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(onClickListener);
        }
    }

    public void i(int i2) {
        String formatVoiceTime;
        int i3;
        VoiceData$VoiceModel voiceData$VoiceModel = this.f20951e;
        if (voiceData$VoiceModel == null || this.f20954h == null) {
            return;
        }
        int i4 = i2 / 1000;
        if (i4 > 0 && i4 < (i3 = voiceData$VoiceModel.duration)) {
            formatVoiceTime = VoiceManager.formatVoiceTime(i3 - i4);
        } else {
            formatVoiceTime = VoiceManager.formatVoiceTime(this.f20951e.duration);
        }
        String charSequence2String = k.charSequence2String(this.f20954h.getText(), null);
        if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
            this.f20954h.setText(formatVoiceTime);
        }
    }

    public void j(int i2) {
        if (i2 == 3) {
            this.f20955i.setVisibility(4);
            c(true);
            this.j.setVisibility(0);
            this.j.g();
            return;
        }
        this.j.setCertainColumnCount(getAudioVoiceColumnCount());
        this.j.f();
        this.j.setVisibility(4);
        c(false);
        if (i2 == 1) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.f20951e;
            if (voiceData$VoiceModel != null) {
                this.f20954h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
            }
            this.f20955i.setVisibility(4);
        } else if (i2 == 2) {
            VoiceData$VoiceModel voiceData$VoiceModel2 = this.f20951e;
            if (voiceData$VoiceModel2 != null) {
                this.f20954h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel2.duration));
            }
            this.f20955i.setVisibility(0);
        }
    }

    public void k() {
        this.f20951e = null;
        setTag(null);
        j(1);
    }

    public void l() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.width = -2;
        this.j.setLayoutParams(layoutParams);
    }

    public void m() {
        VoiceManager voiceManager;
        if (this.f20951e == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f20951e == null || view != this.f20952f) {
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
        TiebaStatic.log(this.f20951e.from);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayElapse(int i2) {
        if (!g()) {
            j(1);
            return;
        }
        i(i2);
        VoiceData$VoiceModel voiceData$VoiceModel = this.f20951e;
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
        if (this.f20951e != voiceData$VoiceModel) {
            j(1);
        } else {
            j(voiceData$VoiceModel.voice_status.intValue());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i2, String str) {
        l.J(getContext(), str);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void setPlayTimeTextView(int i2) {
        TextView textView = this.f20954h;
        if (textView != null) {
            textView.setTextSize(0, l.g(getContext(), i2));
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
            a();
            obj = voiceData$VoiceModel;
        }
        super.setTag(obj);
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.o = voiceManager;
    }

    public void setVoiceModel(VoiceData$VoiceModel voiceData$VoiceModel) {
        requestLayout();
        this.f20951e = voiceData$VoiceModel;
        if (voiceData$VoiceModel == null) {
            return;
        }
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null && voiceManager.isPlayDoing(voiceData$VoiceModel)) {
            voiceManager.resetPlayView(this);
            i(this.f20951e.elapse);
            return;
        }
        j(this.f20951e.voice_status.intValue());
        String formatVoiceTime = VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration);
        int measureText = (int) this.f20954h.getPaint().measureText(formatVoiceTime);
        this.l = measureText;
        this.n = measureText + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);
        this.j.setCertainColumnCount(getAudioVoiceColumnCount());
        this.j.f();
        this.f20952f.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.n, getPaddingBottom());
        this.f20954h.setText(formatVoiceTime);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Voice_play_type);
        obtainStyledAttributes.getInteger(R$styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        e(context);
    }
}
