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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends BaseAdapter {
    private BaseFragmentActivity hjZ;
    private com.baidu.tieba.c.e kuP;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c mvk;
    private View.OnClickListener mvm;
    private g mvn;
    private h mvo;
    private TbCameraView.c mvp;
    private TbCameraView.a mvq;
    private a mvr;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bjG = false;
    private boolean mvl = true;

    public TbCameraView duG() {
        if (this.mvr != null) {
            return this.mvr.mvu;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.hjZ = baseFragmentActivity;
        this.mvk = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hjZ.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.mvl) {
            this.mDataList.add(duH());
        }
        if (!x.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo duH() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return x.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Hc */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) x.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) x.getItem(this.mDataList, i);
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
            if (this.mvr == null || this.mvr.mvu == null) {
                this.mvr = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.mvr.rootView = inflate;
                this.mvr.mvu = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.mvr.mvv = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.mvr.mvt = inflate.findViewById(R.id.icon_placer_holder);
                this.mvr.mvv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mvr.mvv.setFrame(0);
                this.mvr.mvv.useHardwareAcceleration(true);
                ao.a(this.mvr.mvv, R.raw.lottie_photo);
                inflate.setTag(this.mvr);
                if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("write_camera_animaton_key", true);
                    this.mvr.mvv.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.mvr.mvv.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.mvr.mvt);
            }
            ao.setBackgroundColor(this.mvr.rootView, R.color.black_alpha90);
            this.mvr.mvu.setOnRequestPermissionListener(this.mvp);
            this.mvr.mvu.setOnOpenCameraFailedListener(this.mvq);
            this.mvr.mvv.setOnClickListener(this.mvm);
            this.mvr.mvu.setOnClickListener(this.mvm);
            this.mvr.rootView.setOnClickListener(this.mvm);
            this.mvr.mvv.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.mvr.mvv.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.mvr.mvv.cancelAnimation();
                    i.this.mvr.mvv.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.mvr.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.kuP == null && view != null) {
            this.kuP = new com.baidu.tieba.c.e(this.hjZ.getPageContext(), view);
            this.kuP.cS(R.drawable.bg_tip_blue_up_left);
            this.kuP.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.kuP.HN();
                }
            });
            this.kuP.cR(16);
            this.kuP.cT(5000);
        }
        if (this.kuP != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.kuP.aC(this.hjZ.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.hso = (TbImageView) view.findViewById(R.id.pic);
                dVar2.hso.setDefaultResource(0);
                dVar2.hso.setDefaultErrorResource(0);
                dVar2.hso.setTagPaddingDis(8, 8);
                dVar2.hso.setGifIconSupport(true);
                dVar2.hso.setLongIconSupport(true);
                dVar2.bjM = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bjN = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.mvk != null && this.mvk.getWriteImagesInfo() != null && this.mvk.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bjN.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.hso.setIsLongPic(imageFileInfo.isLong());
            dVar.hso.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bjM, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.hso.setOnClickListener(bVar);
            dVar.bjN.setOnClickListener(bVar);
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
                cVar2.mvx = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.mvx.setDefaultResource(0);
                cVar2.mvx.setDefaultErrorResource(0);
                cVar2.mvx.setTagPaddingDis(8, 8);
                cVar2.mvx.setGifIconSupport(false);
                cVar2.mvx.setLongIconSupport(false);
                cVar2.bjM = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.mvy = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.mvz = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.mvx.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.mvz.setText(as.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.bjM, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.mvx.setOnClickListener(bVar);
            cVar.mvy.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.mvk != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.mvk.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.mvk != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.mvk.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hjZ.getResources().getString(R.string.check_box_checked));
                SvgManager.baR().a(imageView, R.drawable.icon_mask_stroke1_blue_h_svg, (SvgManager.SvgResourceStateType) null);
                return;
            }
            imageView.setContentDescription(this.hjZ.getResources().getString(R.string.check_box_not_checked));
            SvgManager.baR().a(imageView, R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_g, (SvgManager.SvgResourceStateType) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo mvw;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.mvw = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.mvn != null && this.mvw != null) {
                    i.this.mvn.a(this.position, this.mvw);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.mvw != null && i.this.mvo != null) {
                    i.this.mvo.b(this.position, this.mvw);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (i.this.mvn != null && this.mvw != null) {
                    i.this.mvn.a(this.position, this.mvw);
                }
            } else if (view.getId() == R.id.video_select && this.mvw != null && i.this.mvo != null) {
                i.this.mvo.b(this.position, this.mvw);
            }
        }
    }

    public boolean isScroll() {
        return this.bjG;
    }

    public void cs(boolean z) {
        this.bjG = z;
    }

    public void a(g gVar) {
        this.mvn = gVar;
    }

    public void a(h hVar) {
        this.mvo = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        View mvt;
        TbCameraView mvu;
        TBLottieAnimationView mvv;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView bjM;
        RelativeLayout bjN;
        TbImageView hso;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView bjM;
        TbImageView mvx;
        RelativeLayout mvy;
        TextView mvz;
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

    public void ak(View.OnClickListener onClickListener) {
        this.mvm = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.mvp = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.mvq = aVar;
    }

    public void wp(boolean z) {
        if (this.mvl != z) {
            this.mvl = z;
            notifyDataSetChanged();
        }
    }
}
