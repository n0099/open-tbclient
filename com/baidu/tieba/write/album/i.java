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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
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
    private BaseFragmentActivity hEa;
    private com.baidu.tieba.c.e kTb;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c mXN;
    private View.OnClickListener mXP;
    private g mXQ;
    private h mXR;
    private TbCameraView.c mXS;
    private TbCameraView.a mXT;
    private a mXU;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bsx = false;
    private boolean mXO = true;

    public TbCameraView dKf() {
        if (this.mXU != null) {
            return this.mXU.mXX;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.hEa = baseFragmentActivity;
        this.mXN = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hEa.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.mXO) {
            this.mDataList.add(dKg());
        }
        if (!y.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dKg() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kd */
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
            if (this.mXU == null || this.mXU.mXX == null) {
                this.mXU = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.mXU.rootView = inflate;
                this.mXU.mXX = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.mXU.mXY = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.mXU.mXW = inflate.findViewById(R.id.icon_placer_holder);
                this.mXU.mXY.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mXU.mXY.setFrame(0);
                this.mXU.mXY.useHardwareAcceleration(true);
                ap.a(this.mXU.mXY, R.raw.lottie_photo);
                inflate.setTag(this.mXU);
                if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("write_camera_animaton_key", true);
                    this.mXU.mXY.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.mXU.mXY.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.mXU.mXW);
            }
            ap.setBackgroundColor(this.mXU.rootView, R.color.black_alpha90);
            this.mXU.mXX.setOnRequestPermissionListener(this.mXS);
            this.mXU.mXX.setOnOpenCameraFailedListener(this.mXT);
            this.mXU.mXY.setOnClickListener(this.mXP);
            this.mXU.mXX.setOnClickListener(this.mXP);
            this.mXU.rootView.setOnClickListener(this.mXP);
            this.mXU.mXY.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.mXU.mXY.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.mXU.mXY.cancelAnimation();
                    i.this.mXU.mXY.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.mXU.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.kTb == null && view != null) {
            this.kTb = new com.baidu.tieba.c.e(this.hEa.getPageContext(), view);
            this.kTb.eW(R.drawable.bg_tip_blue_up_left);
            this.kTb.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.kTb.Oj();
                }
            });
            this.kTb.eV(16);
            this.kTb.eX(5000);
        }
        if (this.kTb != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.kTb.aG(this.hEa.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.hML = (TbImageView) view.findViewById(R.id.pic);
                dVar2.hML.setDefaultResource(0);
                dVar2.hML.setDefaultErrorResource(0);
                dVar2.hML.setTagPaddingDis(8, 8);
                dVar2.hML.setGifIconSupport(true);
                dVar2.hML.setLongIconSupport(true);
                dVar2.bsD = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bsE = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.mXN != null && this.mXN.getWriteImagesInfo() != null && this.mXN.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bsE.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.hML.setIsLongPic(imageFileInfo.isLong());
            dVar.hML.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bsD, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.hML.setOnClickListener(bVar);
            dVar.bsE.setOnClickListener(bVar);
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
                cVar2.mYa = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.mYa.setDefaultResource(0);
                cVar2.mYa.setDefaultErrorResource(0);
                cVar2.mYa.setTagPaddingDis(8, 8);
                cVar2.mYa.setGifIconSupport(false);
                cVar2.mYa.setLongIconSupport(false);
                cVar2.mYb = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.mYa.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.mYb.setText(at.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.mYa.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.mXN != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.mXN.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.mXN != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.mXN.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hEa.getResources().getString(R.string.check_box_checked));
                SvgManager.bkl().a(imageView, R.drawable.icon_mask_stroke1_blue_h_svg, (SvgManager.SvgResourceStateType) null);
                return;
            }
            imageView.setContentDescription(this.hEa.getResources().getString(R.string.check_box_not_checked));
            SvgManager.bkl().a(imageView, R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_g, (SvgManager.SvgResourceStateType) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo mXZ;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.mXZ = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.mXQ != null && this.mXZ != null) {
                    i.this.mXQ.a(this.position, this.mXZ);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.mXZ != null && i.this.mXR != null) {
                    i.this.mXR.b(this.position, this.mXZ);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.mXR != null && this.mXZ != null) {
                i.this.mXR.b(this.position, this.mXZ);
            }
        }
    }

    public boolean isScroll() {
        return this.bsx;
    }

    public void cD(boolean z) {
        this.bsx = z;
    }

    public void a(g gVar) {
        this.mXQ = gVar;
    }

    public void a(h hVar) {
        this.mXR = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        View mXW;
        TbCameraView mXX;
        TBLottieAnimationView mXY;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView bsD;
        RelativeLayout bsE;
        TbImageView hML;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TbImageView mYa;
        TextView mYb;
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

    public void al(View.OnClickListener onClickListener) {
        this.mXP = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.mXS = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.mXT = aVar;
    }

    public void xp(boolean z) {
        if (this.mXO != z) {
            this.mXO = z;
            notifyDataSetChanged();
        }
    }
}
