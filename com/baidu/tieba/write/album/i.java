package com.baidu.tieba.write.album;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.album.AddMediaInfo;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i extends BaseAdapter {
    private com.baidu.tieba.c.e eWa;
    private BaseFragmentActivity iKt;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c oel;
    private View.OnClickListener oen;
    private g oeo;
    private h oep;
    private TbCameraView.c oeq;
    private TbCameraView.a oer;
    private a oes;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bLU = false;
    private boolean oem = true;

    public TbCameraView dWT() {
        if (this.oes != null) {
            return this.oes.oev;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.iKt = baseFragmentActivity;
        this.oel = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.iKt.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.oem) {
            this.mDataList.add(dWU());
        }
        if (!y.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dWU() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Lk */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) y.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) y.getItem(this.mDataList, i);
        if (mediaFileInfo != null) {
            return mediaFileInfo.getType();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MediaFileInfo item = getItem(i);
        if (item != null) {
            if (item.getType() == 2) {
                return a(i, view, viewGroup, item);
            }
            if (item.getType() == 1) {
                return c(i, view, viewGroup, item);
            }
            if (item.getType() == 0) {
                return b(i, view, viewGroup, item);
            }
            return view;
        }
        return view;
    }

    private View a(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        if (mediaFileInfo != null && mediaFileInfo.getType() == 2) {
            if (this.oes == null || this.oes.oev == null) {
                this.oes = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.oes.rootView = inflate;
                this.oes.oev = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.oes.oew = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.oes.oeu = inflate.findViewById(R.id.icon_placer_holder);
                this.oes.oew.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.oes.oew.setFrame(0);
                this.oes.oew.useHardwareAcceleration(true);
                ap.a(this.oes.oew, R.raw.lottie_photo);
                inflate.setTag(this.oes);
                if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("write_camera_animaton_key", true);
                    this.oes.oew.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.oes.oew.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.oes.oeu);
            }
            ap.setBackgroundColor(this.oes.rootView, R.color.black_alpha90);
            this.oes.oev.setOnRequestPermissionListener(this.oeq);
            this.oes.oev.setOnOpenCameraFailedListener(this.oer);
            this.oes.oew.setOnClickListener(this.oen);
            this.oes.oev.setOnClickListener(this.oen);
            this.oes.rootView.setOnClickListener(this.oen);
            this.oes.oew.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.oes.oew.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.oes.oew.cancelAnimation();
                    i.this.oes.oew.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.oes.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.eWa == null && view != null) {
            this.eWa = new com.baidu.tieba.c.e(this.iKt.getPageContext(), view);
            this.eWa.en(R.drawable.bg_tip_blue_up_left);
            this.eWa.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.eWa.Tz();
                }
            });
            this.eWa.em(16);
            this.eWa.eo(5000);
        }
        if (this.eWa != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.eWa.aJ(this.iKt.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
        }
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.mLayoutInflater.inflate(R.layout.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.iSZ = (TbImageView) view.findViewById(R.id.pic);
                dVar2.iSZ.setDefaultResource(0);
                dVar2.iSZ.setTagPaddingDis(8, 8);
                dVar2.iSZ.setGifIconSupport(true);
                dVar2.iSZ.setLongIconSupport(true);
                dVar2.bMa = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bMb = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.oel != null && this.oel.getWriteImagesInfo() != null && this.oel.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bMb.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.iSZ.setIsLongPic(imageFileInfo.isLong());
            dVar.iSZ.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bMa, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.iSZ.setOnClickListener(bVar);
            dVar.bMb.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.mLayoutInflater.inflate(R.layout.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.oey = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.oey.setDefaultResource(0);
                cVar2.oey.setTagPaddingDis(8, 8);
                cVar2.oey.setGifIconSupport(false);
                cVar2.oey.setLongIconSupport(false);
                cVar2.oez = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.oey.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.oez.setText(au.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.oey.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.oel != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.oel.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.oel != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.oel.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.iKt.getResources().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(this.iKt.getResources().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo oex;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.oex = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.oeo != null && this.oex != null) {
                    i.this.oeo.a(this.position, this.oex);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.oex != null && i.this.oep != null) {
                    i.this.oep.b(this.position, this.oex);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.oep != null && this.oex != null) {
                i.this.oep.b(this.position, this.oex);
            }
        }
    }

    public boolean isScroll() {
        return this.bLU;
    }

    public void dq(boolean z) {
        this.bLU = z;
    }

    public void a(g gVar) {
        this.oeo = gVar;
    }

    public void a(h hVar) {
        this.oep = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        View oeu;
        TbCameraView oev;
        TBLottieAnimationView oew;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class d {
        ImageView bMa;
        RelativeLayout bMb;
        TbImageView iSZ;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        TbImageView oey;
        TextView oez;
        View rootView;

        private c() {
        }
    }

    public int i(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        String filePath = imageFileInfo.getFilePath();
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            MediaFileInfo mediaFileInfo = this.mDataList.get(i);
            if (mediaFileInfo instanceof ImageFileInfo) {
                ImageFileInfo imageFileInfo2 = (ImageFileInfo) mediaFileInfo;
                if (imageFileInfo2.getFilePath() != null && imageFileInfo2.getFilePath().equals(filePath)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void ao(View.OnClickListener onClickListener) {
        this.oen = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.oeq = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.oer = aVar;
    }

    public void zB(boolean z) {
        if (this.oem != z) {
            this.oem = z;
            notifyDataSetChanged();
        }
    }
}
