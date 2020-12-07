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
    private BaseFragmentActivity ixc;
    private com.baidu.tieba.d.e lOT;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c nVn;
    private View.OnClickListener nVp;
    private g nVq;
    private h nVr;
    private TbCameraView.c nVs;
    private TbCameraView.a nVt;
    private a nVu;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bIh = false;
    private boolean nVo = true;

    public TbCameraView dYS() {
        if (this.nVu != null) {
            return this.nVu.nVx;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.ixc = baseFragmentActivity;
        this.nVn = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.ixc.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.nVo) {
            this.mDataList.add(dYT());
        }
        if (!y.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dYT() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: MJ */
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
            if (this.nVu == null || this.nVu.nVx == null) {
                this.nVu = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.nVu.rootView = inflate;
                this.nVu.nVx = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.nVu.nVy = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.nVu.nVw = inflate.findViewById(R.id.icon_placer_holder);
                this.nVu.nVy.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.nVu.nVy.setFrame(0);
                this.nVu.nVy.useHardwareAcceleration(true);
                ap.a(this.nVu.nVy, R.raw.lottie_photo);
                inflate.setTag(this.nVu);
                if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("write_camera_animaton_key", true);
                    this.nVu.nVy.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.nVu.nVy.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.nVu.nVw);
            }
            ap.setBackgroundColor(this.nVu.rootView, R.color.black_alpha90);
            this.nVu.nVx.setOnRequestPermissionListener(this.nVs);
            this.nVu.nVx.setOnOpenCameraFailedListener(this.nVt);
            this.nVu.nVy.setOnClickListener(this.nVp);
            this.nVu.nVx.setOnClickListener(this.nVp);
            this.nVu.rootView.setOnClickListener(this.nVp);
            this.nVu.nVy.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.nVu.nVy.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.nVu.nVy.cancelAnimation();
                    i.this.nVu.nVy.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.nVu.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.lOT == null && view != null) {
            this.lOT = new com.baidu.tieba.d.e(this.ixc.getPageContext(), view);
            this.lOT.fO(R.drawable.bg_tip_blue_up_left);
            this.lOT.d(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.lOT.UG();
                }
            });
            this.lOT.fN(16);
            this.lOT.fP(5000);
        }
        if (this.lOT != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.lOT.aP(this.ixc.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.iFL = (TbImageView) view.findViewById(R.id.pic);
                dVar2.iFL.setDefaultResource(0);
                dVar2.iFL.setDefaultErrorResource(0);
                dVar2.iFL.setTagPaddingDis(8, 8);
                dVar2.iFL.setGifIconSupport(true);
                dVar2.iFL.setLongIconSupport(true);
                dVar2.bIn = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bIo = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.nVn != null && this.nVn.getWriteImagesInfo() != null && this.nVn.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bIo.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.iFL.setIsLongPic(imageFileInfo.isLong());
            dVar.iFL.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bIn, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.iFL.setOnClickListener(bVar);
            dVar.bIo.setOnClickListener(bVar);
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
                cVar2.nVA = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.nVA.setDefaultResource(0);
                cVar2.nVA.setDefaultErrorResource(0);
                cVar2.nVA.setTagPaddingDis(8, 8);
                cVar2.nVA.setGifIconSupport(false);
                cVar2.nVA.setLongIconSupport(false);
                cVar2.nVB = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.nVA.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.nVB.setText(au.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.nVA.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.nVn != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.nVn.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.nVn != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.nVn.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.ixc.getResources().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(this.ixc.getResources().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo nVz;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.nVz = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.nVq != null && this.nVz != null) {
                    i.this.nVq.a(this.position, this.nVz);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.nVz != null && i.this.nVr != null) {
                    i.this.nVr.b(this.position, this.nVz);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.nVr != null && this.nVz != null) {
                i.this.nVr.b(this.position, this.nVz);
            }
        }
    }

    public boolean isScroll() {
        return this.bIh;
    }

    public void dj(boolean z) {
        this.bIh = z;
    }

    public void a(g gVar) {
        this.nVq = gVar;
    }

    public void a(h hVar) {
        this.nVr = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        View nVw;
        TbCameraView nVx;
        TBLottieAnimationView nVy;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView bIn;
        RelativeLayout bIo;
        TbImageView iFL;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TbImageView nVA;
        TextView nVB;
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
        this.nVp = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.nVs = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.nVt = aVar;
    }

    public void zi(boolean z) {
        if (this.nVo != z) {
            this.nVo = z;
            notifyDataSetChanged();
        }
    }
}
