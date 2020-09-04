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
    private BaseFragmentActivity hwW;
    private com.baidu.tieba.c.e kKB;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c mNQ;
    private View.OnClickListener mNS;
    private g mNT;
    private h mNU;
    private TbCameraView.c mNV;
    private TbCameraView.a mNW;
    private a mNX;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bpo = false;
    private boolean mNR = true;

    public TbCameraView dGl() {
        if (this.mNX != null) {
            return this.mNX.mOa;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.hwW = baseFragmentActivity;
        this.mNQ = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hwW.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.mNR) {
            this.mDataList.add(dGm());
        }
        if (!y.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dGm() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Jz */
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
            if (this.mNX == null || this.mNX.mOa == null) {
                this.mNX = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.mNX.rootView = inflate;
                this.mNX.mOa = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.mNX.mOb = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.mNX.mNZ = inflate.findViewById(R.id.icon_placer_holder);
                this.mNX.mOb.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mNX.mOb.setFrame(0);
                this.mNX.mOb.useHardwareAcceleration(true);
                ap.a(this.mNX.mOb, R.raw.lottie_photo);
                inflate.setTag(this.mNX);
                if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("write_camera_animaton_key", true);
                    this.mNX.mOb.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.mNX.mOb.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.mNX.mNZ);
            }
            ap.setBackgroundColor(this.mNX.rootView, R.color.black_alpha90);
            this.mNX.mOa.setOnRequestPermissionListener(this.mNV);
            this.mNX.mOa.setOnOpenCameraFailedListener(this.mNW);
            this.mNX.mOb.setOnClickListener(this.mNS);
            this.mNX.mOa.setOnClickListener(this.mNS);
            this.mNX.rootView.setOnClickListener(this.mNS);
            this.mNX.mOb.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.mNX.mOb.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.mNX.mOb.cancelAnimation();
                    i.this.mNX.mOb.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.mNX.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.kKB == null && view != null) {
            this.kKB = new com.baidu.tieba.c.e(this.hwW.getPageContext(), view);
            this.kKB.eL(R.drawable.bg_tip_blue_up_left);
            this.kKB.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.kKB.NG();
                }
            });
            this.kKB.eK(16);
            this.kKB.eM(5000);
        }
        if (this.kKB != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.kKB.aG(this.hwW.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.hFK = (TbImageView) view.findViewById(R.id.pic);
                dVar2.hFK.setDefaultResource(0);
                dVar2.hFK.setDefaultErrorResource(0);
                dVar2.hFK.setTagPaddingDis(8, 8);
                dVar2.hFK.setGifIconSupport(true);
                dVar2.hFK.setLongIconSupport(true);
                dVar2.bpu = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bpv = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.mNQ != null && this.mNQ.getWriteImagesInfo() != null && this.mNQ.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bpv.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.hFK.setIsLongPic(imageFileInfo.isLong());
            dVar.hFK.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bpu, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.hFK.setOnClickListener(bVar);
            dVar.bpv.setOnClickListener(bVar);
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
                cVar2.mOd = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.mOd.setDefaultResource(0);
                cVar2.mOd.setDefaultErrorResource(0);
                cVar2.mOd.setTagPaddingDis(8, 8);
                cVar2.mOd.setGifIconSupport(false);
                cVar2.mOd.setLongIconSupport(false);
                cVar2.mOe = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.mOd.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.mOe.setText(at.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.mOd.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.mNQ != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.mNQ.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.mNQ != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.mNQ.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hwW.getResources().getString(R.string.check_box_checked));
                SvgManager.bjq().a(imageView, R.drawable.icon_mask_stroke1_blue_h_svg, (SvgManager.SvgResourceStateType) null);
                return;
            }
            imageView.setContentDescription(this.hwW.getResources().getString(R.string.check_box_not_checked));
            SvgManager.bjq().a(imageView, R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_g, (SvgManager.SvgResourceStateType) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo mOc;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.mOc = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.mNT != null && this.mOc != null) {
                    i.this.mNT.a(this.position, this.mOc);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.mOc != null && i.this.mNU != null) {
                    i.this.mNU.b(this.position, this.mOc);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.mNU != null && this.mOc != null) {
                i.this.mNU.b(this.position, this.mOc);
            }
        }
    }

    public boolean isScroll() {
        return this.bpo;
    }

    public void cC(boolean z) {
        this.bpo = z;
    }

    public void a(g gVar) {
        this.mNT = gVar;
    }

    public void a(h hVar) {
        this.mNU = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        View mNZ;
        TbCameraView mOa;
        TBLottieAnimationView mOb;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView bpu;
        RelativeLayout bpv;
        TbImageView hFK;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TbImageView mOd;
        TextView mOe;
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
        this.mNS = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.mNV = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.mNW = aVar;
    }

    public void xg(boolean z) {
        if (this.mNR != z) {
            this.mNR = z;
            notifyDataSetChanged();
        }
    }
}
