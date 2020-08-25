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
    private BaseFragmentActivity hwQ;
    private com.baidu.tieba.c.e kKu;
    private LayoutInflater mLayoutInflater;
    private View.OnClickListener mNA;
    private g mNB;
    private h mNC;
    private TbCameraView.c mND;
    private TbCameraView.a mNE;
    private a mNF;
    private com.baidu.tieba.write.album.c mNy;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bpl = false;
    private boolean mNz = true;

    public TbCameraView dGc() {
        if (this.mNF != null) {
            return this.mNF.mNI;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.hwQ = baseFragmentActivity;
        this.mNy = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hwQ.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.mNz) {
            this.mDataList.add(dGd());
        }
        if (!y.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dGd() {
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
            if (this.mNF == null || this.mNF.mNI == null) {
                this.mNF = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.mNF.rootView = inflate;
                this.mNF.mNI = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.mNF.mNJ = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.mNF.mNH = inflate.findViewById(R.id.icon_placer_holder);
                this.mNF.mNJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mNF.mNJ.setFrame(0);
                this.mNF.mNJ.useHardwareAcceleration(true);
                ap.a(this.mNF.mNJ, R.raw.lottie_photo);
                inflate.setTag(this.mNF);
                if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("write_camera_animaton_key", true);
                    this.mNF.mNJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.mNF.mNJ.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.mNF.mNH);
            }
            ap.setBackgroundColor(this.mNF.rootView, R.color.black_alpha90);
            this.mNF.mNI.setOnRequestPermissionListener(this.mND);
            this.mNF.mNI.setOnOpenCameraFailedListener(this.mNE);
            this.mNF.mNJ.setOnClickListener(this.mNA);
            this.mNF.mNI.setOnClickListener(this.mNA);
            this.mNF.rootView.setOnClickListener(this.mNA);
            this.mNF.mNJ.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.mNF.mNJ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.mNF.mNJ.cancelAnimation();
                    i.this.mNF.mNJ.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.mNF.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.kKu == null && view != null) {
            this.kKu = new com.baidu.tieba.c.e(this.hwQ.getPageContext(), view);
            this.kKu.eL(R.drawable.bg_tip_blue_up_left);
            this.kKu.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.kKu.NG();
                }
            });
            this.kKu.eK(16);
            this.kKu.eM(5000);
        }
        if (this.kKu != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.kKu.aG(this.hwQ.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.hFE = (TbImageView) view.findViewById(R.id.pic);
                dVar2.hFE.setDefaultResource(0);
                dVar2.hFE.setDefaultErrorResource(0);
                dVar2.hFE.setTagPaddingDis(8, 8);
                dVar2.hFE.setGifIconSupport(true);
                dVar2.hFE.setLongIconSupport(true);
                dVar2.bpr = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bps = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.mNy != null && this.mNy.getWriteImagesInfo() != null && this.mNy.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bps.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.hFE.setIsLongPic(imageFileInfo.isLong());
            dVar.hFE.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bpr, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.hFE.setOnClickListener(bVar);
            dVar.bps.setOnClickListener(bVar);
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
                cVar2.mNL = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.mNL.setDefaultResource(0);
                cVar2.mNL.setDefaultErrorResource(0);
                cVar2.mNL.setTagPaddingDis(8, 8);
                cVar2.mNL.setGifIconSupport(false);
                cVar2.mNL.setLongIconSupport(false);
                cVar2.mNM = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.mNL.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.mNM.setText(at.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.mNL.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.mNy != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.mNy.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.mNy != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.mNy.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hwQ.getResources().getString(R.string.check_box_checked));
                SvgManager.bjq().a(imageView, R.drawable.icon_mask_stroke1_blue_h_svg, (SvgManager.SvgResourceStateType) null);
                return;
            }
            imageView.setContentDescription(this.hwQ.getResources().getString(R.string.check_box_not_checked));
            SvgManager.bjq().a(imageView, R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_g, (SvgManager.SvgResourceStateType) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo mNK;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.mNK = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.mNB != null && this.mNK != null) {
                    i.this.mNB.a(this.position, this.mNK);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.mNK != null && i.this.mNC != null) {
                    i.this.mNC.b(this.position, this.mNK);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.mNC != null && this.mNK != null) {
                i.this.mNC.b(this.position, this.mNK);
            }
        }
    }

    public boolean isScroll() {
        return this.bpl;
    }

    public void cB(boolean z) {
        this.bpl = z;
    }

    public void a(g gVar) {
        this.mNB = gVar;
    }

    public void a(h hVar) {
        this.mNC = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        View mNH;
        TbCameraView mNI;
        TBLottieAnimationView mNJ;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView bpr;
        RelativeLayout bps;
        TbImageView hFE;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TbImageView mNL;
        TextView mNM;
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
        this.mNA = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.mND = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.mNE = aVar;
    }

    public void xe(boolean z) {
        if (this.mNz != z) {
            this.mNz = z;
            notifyDataSetChanged();
        }
    }
}
