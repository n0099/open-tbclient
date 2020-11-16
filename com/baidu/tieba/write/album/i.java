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
/* loaded from: classes3.dex */
public class i extends BaseAdapter {
    private BaseFragmentActivity imj;
    private com.baidu.tieba.d.e lBg;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c nHh;
    private View.OnClickListener nHj;
    private g nHk;
    private h nHl;
    private TbCameraView.c nHm;
    private TbCameraView.a nHn;
    private a nHo;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bCZ = false;
    private boolean nHi = true;

    public TbCameraView dTy() {
        if (this.nHo != null) {
            return this.nHo.nHr;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.imj = baseFragmentActivity;
        this.nHh = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.imj.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.nHi) {
            this.mDataList.add(dTz());
        }
        if (!y.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dTz() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LR */
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
            if (this.nHo == null || this.nHo.nHr == null) {
                this.nHo = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.nHo.rootView = inflate;
                this.nHo.nHr = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.nHo.nHs = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.nHo.nHq = inflate.findViewById(R.id.icon_placer_holder);
                this.nHo.nHs.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.nHo.nHs.setFrame(0);
                this.nHo.nHs.useHardwareAcceleration(true);
                ap.a(this.nHo.nHs, R.raw.lottie_photo);
                inflate.setTag(this.nHo);
                if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("write_camera_animaton_key", true);
                    this.nHo.nHs.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.nHo.nHs.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.nHo.nHq);
            }
            ap.setBackgroundColor(this.nHo.rootView, R.color.black_alpha90);
            this.nHo.nHr.setOnRequestPermissionListener(this.nHm);
            this.nHo.nHr.setOnOpenCameraFailedListener(this.nHn);
            this.nHo.nHs.setOnClickListener(this.nHj);
            this.nHo.nHr.setOnClickListener(this.nHj);
            this.nHo.rootView.setOnClickListener(this.nHj);
            this.nHo.nHs.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.nHo.nHs.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.nHo.nHs.cancelAnimation();
                    i.this.nHo.nHs.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.nHo.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.lBg == null && view != null) {
            this.lBg = new com.baidu.tieba.d.e(this.imj.getPageContext(), view);
            this.lBg.fq(R.drawable.bg_tip_blue_up_left);
            this.lBg.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.lBg.Si();
                }
            });
            this.lBg.fp(16);
            this.lBg.fr(5000);
        }
        if (this.lBg != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.lBg.aL(this.imj.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.iuT = (TbImageView) view.findViewById(R.id.pic);
                dVar2.iuT.setDefaultResource(0);
                dVar2.iuT.setDefaultErrorResource(0);
                dVar2.iuT.setTagPaddingDis(8, 8);
                dVar2.iuT.setGifIconSupport(true);
                dVar2.iuT.setLongIconSupport(true);
                dVar2.bDf = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bDg = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.nHh != null && this.nHh.getWriteImagesInfo() != null && this.nHh.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bDg.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.iuT.setIsLongPic(imageFileInfo.isLong());
            dVar.iuT.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bDf, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.iuT.setOnClickListener(bVar);
            dVar.bDg.setOnClickListener(bVar);
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
                cVar2.nHu = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.nHu.setDefaultResource(0);
                cVar2.nHu.setDefaultErrorResource(0);
                cVar2.nHu.setTagPaddingDis(8, 8);
                cVar2.nHu.setGifIconSupport(false);
                cVar2.nHu.setLongIconSupport(false);
                cVar2.nHv = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.nHu.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.nHv.setText(au.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.nHu.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.nHh != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.nHh.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.nHh != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.nHh.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.imj.getResources().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(this.imj.getResources().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo nHt;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.nHt = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.nHk != null && this.nHt != null) {
                    i.this.nHk.a(this.position, this.nHt);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.nHt != null && i.this.nHl != null) {
                    i.this.nHl.b(this.position, this.nHt);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.nHl != null && this.nHt != null) {
                i.this.nHl.b(this.position, this.nHt);
            }
        }
    }

    public boolean isScroll() {
        return this.bCZ;
    }

    public void cV(boolean z) {
        this.bCZ = z;
    }

    public void a(g gVar) {
        this.nHk = gVar;
    }

    public void a(h hVar) {
        this.nHl = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        View nHq;
        TbCameraView nHr;
        TBLottieAnimationView nHs;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView bDf;
        RelativeLayout bDg;
        TbImageView iuT;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TbImageView nHu;
        TextView nHv;
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

    public void am(View.OnClickListener onClickListener) {
        this.nHj = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.nHm = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.nHn = aVar;
    }

    public void yD(boolean z) {
        if (this.nHi != z) {
            this.nHi = z;
            notifyDataSetChanged();
        }
    }
}
