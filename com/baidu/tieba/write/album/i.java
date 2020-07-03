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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends BaseAdapter {
    private BaseFragmentActivity hep;
    private com.baidu.tieba.c.e klQ;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c mnf;
    private View.OnClickListener mnh;
    private g mni;
    private h mnj;
    private TbCameraView.c mnk;
    private TbCameraView.a mnl;
    private a mnm;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bjm = false;
    private boolean mng = true;

    public TbCameraView drp() {
        if (this.mnm != null) {
            return this.mnm.mnp;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.hep = baseFragmentActivity;
        this.mnf = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hep.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.mng) {
            this.mDataList.add(drq());
        }
        if (!w.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo drq() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: GG */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) w.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) w.getItem(this.mDataList, i);
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
            if (this.mnm == null || this.mnm.mnp == null) {
                this.mnm = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.mnm.rootView = inflate;
                this.mnm.mnp = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.mnm.mnq = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.mnm.mno = inflate.findViewById(R.id.icon_placer_holder);
                this.mnm.mnq.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mnm.mnq.setFrame(0);
                this.mnm.mnq.useHardwareAcceleration(true);
                an.a(this.mnm.mnq, (int) R.raw.lottie_photo);
                inflate.setTag(this.mnm);
                if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("write_camera_animaton_key", true);
                    this.mnm.mnq.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.mnm.mnq.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.mnm.mno);
            }
            an.setBackgroundColor(this.mnm.rootView, R.color.black_alpha90);
            this.mnm.mnp.setOnRequestPermissionListener(this.mnk);
            this.mnm.mnp.setOnOpenCameraFailedListener(this.mnl);
            this.mnm.mnq.setOnClickListener(this.mnh);
            this.mnm.mnp.setOnClickListener(this.mnh);
            this.mnm.rootView.setOnClickListener(this.mnh);
            this.mnm.mnq.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.mnm.mnq.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.mnm.mnq.cancelAnimation();
                    i.this.mnm.mnq.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.mnm.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.klQ == null && view != null) {
            this.klQ = new com.baidu.tieba.c.e(this.hep.getPageContext(), view);
            this.klQ.cS(R.drawable.bg_tip_blue_up_left);
            this.klQ.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.klQ.HH();
                }
            });
            this.klQ.cR(16);
            this.klQ.cT(5000);
        }
        if (this.klQ != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.klQ.aC(this.hep.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.hmC = (TbImageView) view.findViewById(R.id.pic);
                dVar2.hmC.setDefaultResource(0);
                dVar2.hmC.setDefaultErrorResource(0);
                dVar2.hmC.setTagPaddingDis(8, 8);
                dVar2.hmC.setGifIconSupport(true);
                dVar2.hmC.setLongIconSupport(true);
                dVar2.bjs = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bjt = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.mnf != null && this.mnf.getWriteImagesInfo() != null && this.mnf.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bjt.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.hmC.setIsLongPic(imageFileInfo.isLong());
            dVar.hmC.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bjs, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.hmC.setOnClickListener(bVar);
            dVar.bjt.setOnClickListener(bVar);
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
                cVar2.mns = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.mns.setDefaultResource(0);
                cVar2.mns.setDefaultErrorResource(0);
                cVar2.mns.setTagPaddingDis(8, 8);
                cVar2.mns.setGifIconSupport(false);
                cVar2.mns.setLongIconSupport(false);
                cVar2.bjs = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.mnt = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.mnu = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.mns.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.mnu.setText(ar.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.bjs, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.mns.setOnClickListener(bVar);
            cVar.mnt.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.mnf != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.mnf.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.mnf != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.mnf.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hep.getResources().getString(R.string.check_box_checked));
                SvgManager.aWQ().a(imageView, R.drawable.icon_mask_stroke1_blue_h_svg, (SvgManager.SvgResourceStateType) null);
                return;
            }
            imageView.setContentDescription(this.hep.getResources().getString(R.string.check_box_not_checked));
            SvgManager.aWQ().a(imageView, R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_g, (SvgManager.SvgResourceStateType) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo mnr;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.mnr = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.mni != null && this.mnr != null) {
                    i.this.mni.a(this.position, this.mnr);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.mnr != null && i.this.mnj != null) {
                    i.this.mnj.b(this.position, this.mnr);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (i.this.mni != null && this.mnr != null) {
                    i.this.mni.a(this.position, this.mnr);
                }
            } else if (view.getId() == R.id.video_select && this.mnr != null && i.this.mnj != null) {
                i.this.mnj.b(this.position, this.mnr);
            }
        }
    }

    public boolean isScroll() {
        return this.bjm;
    }

    public void cq(boolean z) {
        this.bjm = z;
    }

    public void a(g gVar) {
        this.mni = gVar;
    }

    public void a(h hVar) {
        this.mnj = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        View mno;
        TbCameraView mnp;
        TBLottieAnimationView mnq;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        ImageView bjs;
        RelativeLayout bjt;
        TbImageView hmC;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView bjs;
        TbImageView mns;
        RelativeLayout mnt;
        TextView mnu;
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

    public void aj(View.OnClickListener onClickListener) {
        this.mnh = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.mnk = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.mnl = aVar;
    }

    public void vL(boolean z) {
        if (this.mng != z) {
            this.mng = z;
            notifyDataSetChanged();
        }
    }
}
