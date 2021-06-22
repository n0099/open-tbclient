package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import d.a.c.e.p.l;
import d.a.o0.r3.l.i;
import d.a.o0.r3.l.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, VideoEffectButtonLayout.a, d.a.o0.r3.i.b {

    /* renamed from: e  reason: collision with root package name */
    public ImageView f21522e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f21523f;

    /* renamed from: g  reason: collision with root package name */
    public VideoRecordButton f21524g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21525h;

    /* renamed from: i  reason: collision with root package name */
    public i f21526i;
    public long j;
    public boolean k;
    public AnimatorSet l;
    public AnimatorSet m;
    public List<ObjectAnimator> n;
    public f o;
    public boolean p;
    public List<d.a.o0.r3.l.e> q;
    public List<d.a.o0.r3.l.e> r;
    public List<StickerItem> s;
    public List<d.a.o0.r3.l.e> t;
    public VideoEffectLayout u;
    public Handler v;
    public int w;

    /* loaded from: classes5.dex */
    public class a extends m {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f21527f;

        public a(boolean z) {
            this.f21527f = z;
        }

        @Override // d.a.o0.r3.l.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (VideoControllerLayout.this.f21526i.f() == 6 || VideoControllerLayout.this.f21526i.j()) {
                VideoControllerLayout.this.z(this.f21527f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends m {
        public b() {
        }

        @Override // d.a.o0.r3.l.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f64135e) {
                return;
            }
            VideoControllerLayout.this.f21522e.setVisibility(8);
            VideoControllerLayout.this.f21525h.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f21530e;

        public c(long j) {
            this.f21530e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoControllerLayout.this.k && VideoControllerLayout.this.j == this.f21530e) {
                TiebaStatic.log("c12297");
                VideoControllerLayout.this.y(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends m {
        public d() {
        }

        @Override // d.a.o0.r3.l.m, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (VideoControllerLayout.this.o != null) {
                VideoControllerLayout.this.o.onShowEffectLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends m {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f21533f;

        public e(m mVar) {
            this.f21533f = mVar;
        }

        @Override // d.a.o0.r3.l.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f64135e) {
                return;
            }
            VideoControllerLayout.this.u.setVisibility(8);
            if (VideoControllerLayout.this.o != null) {
                VideoControllerLayout.this.o.onHideEffectLayout();
            }
            m mVar = this.f21533f;
            if (mVar != null) {
                mVar.onAnimationEnd(animator);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void hideMinVideoTips();

        void onCancelCountDowning();

        void onHideEffectLayout();

        void onRecordDone();

        void onRecordShort();

        void onShowEffectLayout();

        void onStartRecord();

        void onStatusChange();

        void onStopRecord();

        void onTakePhoto();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.j = 0L;
        this.k = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.v = new Handler();
        n();
    }

    public void A() {
        B();
        int f2 = this.f21526i.f();
        i iVar = this.f21526i;
        if (iVar != null) {
            if (!iVar.h() && this.f21526i.j()) {
                this.f21526i.o();
            }
            F();
        }
        f fVar = this.o;
        if (fVar != null) {
            fVar.onStopRecord();
            if (f2 == 6) {
                this.o.onCancelCountDowning();
            }
        }
    }

    public void B() {
        i iVar = this.f21526i;
        if (iVar == null || iVar.j() || this.f21526i.f() == 6) {
            AnimatorSet animatorSet = this.l;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.l.cancel();
            }
            if (this.m == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.m = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.f21522e, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f21525h, "alpha", 0.0f, 1.0f));
                this.m.setDuration(300L);
            }
            this.f21522e.setVisibility(0);
            this.f21525h.setVisibility(0);
            this.m.start();
            if (this.f21526i.f() != 7 && this.f21526i.f() != 6) {
                this.f21524g.d();
                return;
            }
            this.f21524g.getTvTip().setVisibility(8);
            if (this.w == 2) {
                this.f21524g.getLayer1().setVisibility(0);
            }
        }
    }

    public void F() {
        i iVar = this.f21526i;
        if (iVar == null) {
            return;
        }
        if (iVar.g() >= 3000.0f) {
            j(4);
        } else if (this.f21526i.g() > 0) {
            j(3);
        } else {
            j(1);
        }
    }

    public List<d.a.o0.r3.l.e> getChoosedBeautyList() {
        return this.q;
    }

    public List<d.a.o0.r3.l.e> getChoosedFilterList() {
        return this.r;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.s;
    }

    public void j(int i2) {
        this.f21526i.m(i2);
        f fVar = this.o;
        if (fVar != null) {
            fVar.onStatusChange();
        }
        if (i2 == 1) {
            this.f21522e.setVisibility(8);
            this.f21525h.setVisibility(8);
        } else if (i2 == 3) {
            this.f21522e.setImageResource(R.drawable.video_back_selector);
            this.f21525h.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i2 == 4) {
            this.f21522e.setImageResource(R.drawable.video_back_selector);
            this.f21525h.setImageResource(R.drawable.video_confirm_selector);
        } else if (i2 == 5) {
            this.f21522e.setImageResource(R.drawable.video_delete_selector);
            i iVar = this.f21526i;
            if (iVar != null && iVar.g() >= 3000.0f) {
                this.f21525h.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.f21525h.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    public final void k(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                return;
            }
            this.f21524g.e();
        } else if (this.f21526i.f() == 6) {
            this.f21526i.m(1);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onCancelCountDowning();
                this.o.onStopRecord();
            }
            this.f21524g.getTvTip().setText("");
            this.f21524g.getTvTip().setVisibility(8);
        } else if (this.u.getVisibility() == 0) {
            m(null);
        } else {
            f fVar2 = this.o;
            if (fVar2 != null) {
                fVar2.onTakePhoto();
                this.f21524g.c();
            }
        }
    }

    public final void l(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (this.p) {
                    this.p = false;
                    return;
                }
                this.k = false;
                if (!this.f21526i.j() && this.f21526i.f() != 6) {
                    if (this.f21526i.f() != 8) {
                        y(false);
                        return;
                    }
                    return;
                }
                TiebaStatic.log("c12298");
                A();
                return;
            }
            return;
        }
        f fVar = this.o;
        if (fVar != null) {
            fVar.hideMinVideoTips();
        }
        if (this.f21526i.f() == 7 || this.f21526i.f() == 6) {
            return;
        }
        i iVar = this.f21526i;
        if (iVar != null && iVar.i()) {
            this.p = true;
            CustomToast.newInstance().showToast(R.string.music_is_downloading);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.j = currentTimeMillis;
        this.k = true;
        this.v.postDelayed(new c(currentTimeMillis), 200L);
    }

    public void m(m mVar) {
        if (this.u.getVisibility() == 8) {
            return;
        }
        o();
        this.f21525h.setEnabled(true);
        this.f21522e.setEnabled(true);
        if (this.f21526i.f() != 6 && !this.f21526i.j()) {
            j(this.f21526i.f());
        } else {
            this.f21522e.setVisibility(8);
            this.f21525h.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            ObjectAnimator objectAnimator = this.n.get(i2);
            if (objectAnimator != null) {
                objectAnimator.setDuration(500L);
                objectAnimator.cancel();
                objectAnimator.removeAllListeners();
                if (i2 == this.n.size() - 1) {
                    objectAnimator.addListener(new e(mVar));
                }
                objectAnimator.reverse();
            }
        }
    }

    public final void n() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.u = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.f21523f = (RelativeLayout) findViewById(R.id.layout_record);
        ImageView imageView = (ImageView) findViewById(R.id.delete_video);
        this.f21522e = imageView;
        imageView.setOnClickListener(this);
        VideoRecordButton videoRecordButton = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.f21524g = videoRecordButton;
        videoRecordButton.setOnTouchListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.confirm_video);
        this.f21525h = imageView2;
        imageView2.setOnClickListener(this);
        this.t.add(0, new d.a.o0.r3.l.e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.t.add(1, new d.a.o0.r3.l.e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public final void o() {
        if (ListUtils.isEmpty(this.n)) {
            ArrayList arrayList = new ArrayList();
            this.n = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.u, "translationY", 1000.0f, 0.0f));
            this.n.add(ObjectAnimator.ofFloat(this.f21523f, "translationY", 0.0f, l.g(getContext(), R.dimen.ds100)));
            this.n.add(ObjectAnimator.ofFloat(this.f21524g.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.n.add(ObjectAnimator.ofFloat(this.f21524g.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.n.add(ObjectAnimator.ofFloat(this.f21524g.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.n.add(ObjectAnimator.ofFloat(this.f21524g.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.n.add(ObjectAnimator.ofFloat(this.f21525h, "scaleX", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f21525h, "scaleY", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f21522e, "scaleX", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f21522e, "scaleY", 1.0f, 0.7f));
            this.n.add(ObjectAnimator.ofFloat(this.f21525h, "alpha", 1.0f, 0.0f));
            this.n.add(ObjectAnimator.ofFloat(this.f21522e, "alpha", 1.0f, 0.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f21522e) {
            f fVar = this.o;
            if (fVar != null) {
                fVar.hideMinVideoTips();
            }
            int f2 = this.f21526i.f();
            i iVar = this.f21526i;
            if (iVar == null || iVar.g() <= 0 || f2 <= 2) {
                return;
            }
            if (f2 == 5) {
                TiebaStatic.log("c12299");
                this.f21526i.d();
                t(this.q);
                t(this.r);
                t(this.s);
                if (this.f21526i.g() >= 3000.0f) {
                    j(4);
                    return;
                } else {
                    j(this.f21526i.g() > 0 ? 3 : 1);
                    return;
                }
            }
            this.f21526i.l();
            j(5);
        } else if (view == this.f21525h) {
            TiebaStatic.log("c12300");
            i iVar2 = this.f21526i;
            if (iVar2 == null || iVar2.f() <= 2 || this.o == null) {
                return;
            }
            if (this.f21526i.g() >= 3000.0f) {
                this.o.onRecordDone();
            } else {
                this.o.onRecordShort();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickBeauty() {
        if (p() && this.u.getCurrentEffectLayout() == 1) {
            m(null);
            return;
        }
        if (!p()) {
            x();
        }
        this.u.onClickBeauty();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        if (p() && this.u.getCurrentEffectLayout() == 2) {
            m(null);
            return;
        }
        if (!p()) {
            x();
        }
        this.u.onClickFilter();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        if (p() && this.u.getCurrentEffectLayout() == 3) {
            m(null);
            return;
        }
        if (!p()) {
            x();
        }
        this.u.onClickMusic();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        if (p() && this.u.getCurrentEffectLayout() == 0) {
            m(null);
            return;
        }
        if (!p()) {
            x();
        }
        this.u.onClickSticker();
    }

    @Override // d.a.o0.r3.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i2 = this.w;
        if (i2 == 1) {
            k(view, motionEvent);
        } else if (i2 == 2) {
            l(view, motionEvent);
        }
        return true;
    }

    public boolean p() {
        return this.u.getVisibility() == 0;
    }

    public boolean q() {
        VideoEffectLayout videoEffectLayout = this.u;
        if (videoEffectLayout != null) {
            return videoEffectLayout.t();
        }
        return false;
    }

    public void r() {
        if (this.u.getVisibility() == 0) {
            m(null);
        }
        z(false);
        this.f21524g.getLayer1().setVisibility(8);
        this.f21524g.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.f21524g.getTvTip().setVisibility(0);
        f fVar = this.o;
        if (fVar != null) {
            fVar.onStartRecord();
        }
    }

    public void s() {
        if (this.f21526i.f() == 6) {
            if (this.w == 2) {
                j(7);
                this.f21524g.setAlpha(1.0f);
                this.f21522e.setVisibility(8);
                this.f21525h.setVisibility(8);
                this.f21524g.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                i iVar = this.f21526i;
                if (iVar != null) {
                    iVar.n();
                    return;
                }
                return;
            }
            this.f21524g.getTvTip().setVisibility(8);
            f fVar = this.o;
            if (fVar != null) {
                fVar.onTakePhoto();
            }
        }
    }

    public void setCurrentTab(int i2) {
        this.w = i2;
        if (i2 == 1) {
            this.f21522e.setVisibility(4);
            this.f21525h.setVisibility(4);
            this.f21524g.getLayer1().setVisibility(8);
        } else if (i2 != 2) {
        } else {
            if (this.f21526i.f() != 1) {
                this.f21522e.setVisibility(0);
                this.f21525h.setVisibility(0);
            }
            this.f21524g.getLayer1().setVisibility(0);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout = this.u;
        if (videoEffectLayout != null) {
            videoEffectLayout.setDownLoadStrick(stickerItem);
        }
    }

    public void setEffectChoosedListener(VideoEffectLayout.h hVar) {
        VideoEffectLayout videoEffectLayout = this.u;
        if (videoEffectLayout != null) {
            videoEffectLayout.setListener(hVar);
        }
    }

    public void setHasLocalVideo(boolean z) {
    }

    @Override // d.a.o0.r3.i.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.t.add(new d.a.o0.r3.l.e(3, musicData.name, musicData, -1));
            }
        }
        VideoEffectLayout videoEffectLayout = this.u;
        if (videoEffectLayout != null) {
            videoEffectLayout.setMusicList(this.t);
        }
    }

    public void setRecordControlListener(f fVar) {
        this.o = fVar;
    }

    public void setRecordController(i iVar) {
        this.f21526i = iVar;
        j(1);
    }

    public void setStickerItems(List<StickerItem> list) {
        VideoEffectLayout videoEffectLayout = this.u;
        if (videoEffectLayout != null) {
            videoEffectLayout.setStickerItems(list);
        }
    }

    public final void t(List list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public void u() {
        VideoEffectLayout videoEffectLayout = this.u;
        if (videoEffectLayout != null) {
            videoEffectLayout.u();
        }
    }

    public void v() {
        VideoEffectLayout videoEffectLayout = this.u;
        if (videoEffectLayout != null) {
            videoEffectLayout.v();
        }
    }

    public void w(StickerItem stickerItem) {
        VideoEffectLayout videoEffectLayout = this.u;
        if (videoEffectLayout != null) {
            videoEffectLayout.w(stickerItem);
        }
    }

    public final void x() {
        if (this.u.getVisibility() == 0) {
            return;
        }
        this.u.setVisibility(0);
        o();
        this.f21525h.setEnabled(false);
        this.f21522e.setEnabled(false);
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            ObjectAnimator objectAnimator = this.n.get(i2);
            if (objectAnimator != null) {
                objectAnimator.cancel();
                objectAnimator.setDuration(500L);
                objectAnimator.removeAllListeners();
                if (i2 == this.n.size() - 1) {
                    objectAnimator.addListener(new d());
                }
                objectAnimator.start();
            }
        }
    }

    public final void y(boolean z) {
        if (this.f21526i.e() >= 100) {
            f fVar = this.o;
            if (fVar != null) {
                fVar.onRecordDone();
                return;
            }
            return;
        }
        if (this.u.getCurrentBeautyItem() != null) {
            this.q.add(this.u.getCurrentBeautyItem());
        }
        if (this.u.getCurrentFilterItem() != null) {
            this.r.add(this.u.getCurrentFilterItem());
        }
        if (this.u.getCurrentStickItem() != null) {
            this.s.add(this.u.getCurrentStickItem());
        }
        j(2);
        if (this.u.getVisibility() == 0) {
            m(new a(z));
        } else {
            z(z);
        }
        i iVar = this.f21526i;
        if (iVar != null) {
            iVar.n();
        }
        f fVar2 = this.o;
        if (fVar2 != null) {
            fVar2.onStartRecord();
        }
    }

    public final void z(boolean z) {
        AnimatorSet animatorSet = this.m;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.m.cancel();
        }
        if (this.l == null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.l = animatorSet2;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.f21522e, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f21525h, "alpha", 1.0f, 0.0f));
            this.l.addListener(new b());
            this.l.setDuration(300L);
        }
        this.l.start();
        if (this.f21526i.f() != 6) {
            this.f21524g.b(z);
        }
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 0L;
        this.k = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.v = new Handler();
        n();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = 0L;
        this.k = false;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.v = new Handler();
        n();
    }
}
