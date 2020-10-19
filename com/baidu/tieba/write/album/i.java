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
    private BaseFragmentActivity hSW;
    private com.baidu.tieba.c.e lio;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c nnl;
    private View.OnClickListener nnn;
    private g nno;
    private h nnp;
    private TbCameraView.c nnq;
    private TbCameraView.a nnr;
    private a nns;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bwl = false;
    private boolean nnm = true;

    public TbCameraView dNR() {
        if (this.nns != null) {
            return this.nns.nnv;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.hSW = baseFragmentActivity;
        this.nnl = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hSW.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.nnm) {
            this.mDataList.add(dNS());
        }
        if (!y.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dNS() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KJ */
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
            if (this.nns == null || this.nns.nnv == null) {
                this.nns = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.nns.rootView = inflate;
                this.nns.nnv = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.nns.nnw = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.nns.nnu = inflate.findViewById(R.id.icon_placer_holder);
                this.nns.nnw.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.nns.nnw.setFrame(0);
                this.nns.nnw.useHardwareAcceleration(true);
                ap.a(this.nns.nnw, R.raw.lottie_photo);
                inflate.setTag(this.nns);
                if (!com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("write_camera_animaton_key", true);
                    this.nns.nnw.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.nns.nnw.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.nns.nnu);
            }
            ap.setBackgroundColor(this.nns.rootView, R.color.black_alpha90);
            this.nns.nnv.setOnRequestPermissionListener(this.nnq);
            this.nns.nnv.setOnOpenCameraFailedListener(this.nnr);
            this.nns.nnw.setOnClickListener(this.nnn);
            this.nns.nnv.setOnClickListener(this.nnn);
            this.nns.rootView.setOnClickListener(this.nnn);
            this.nns.nnw.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.nns.nnw.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.nns.nnw.cancelAnimation();
                    i.this.nns.nnw.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.nns.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.lio == null && view != null) {
            this.lio = new com.baidu.tieba.c.e(this.hSW.getPageContext(), view);
            this.lio.ff(R.drawable.bg_tip_blue_up_left);
            this.lio.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.lio.Po();
                }
            });
            this.lio.fe(16);
            this.lio.fg(5000);
        }
        if (this.lio != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.lio.aJ(this.hSW.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.ibG = (TbImageView) view.findViewById(R.id.pic);
                dVar2.ibG.setDefaultResource(0);
                dVar2.ibG.setDefaultErrorResource(0);
                dVar2.ibG.setTagPaddingDis(8, 8);
                dVar2.ibG.setGifIconSupport(true);
                dVar2.ibG.setLongIconSupport(true);
                dVar2.bwr = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bws = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.nnl != null && this.nnl.getWriteImagesInfo() != null && this.nnl.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bws.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.ibG.setIsLongPic(imageFileInfo.isLong());
            dVar.ibG.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bwr, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.ibG.setOnClickListener(bVar);
            dVar.bws.setOnClickListener(bVar);
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
                cVar2.nny = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.nny.setDefaultResource(0);
                cVar2.nny.setDefaultErrorResource(0);
                cVar2.nny.setTagPaddingDis(8, 8);
                cVar2.nny.setGifIconSupport(false);
                cVar2.nny.setLongIconSupport(false);
                cVar2.nnz = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.nny.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.nnz.setText(at.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.nny.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.nnl != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.nnl.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.nnl != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.nnl.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hSW.getResources().getString(R.string.check_box_checked));
                SvgManager.bmU().a(imageView, R.drawable.icon_mask_stroke1_blue_h_svg, (SvgManager.SvgResourceStateType) null);
                return;
            }
            imageView.setContentDescription(this.hSW.getResources().getString(R.string.check_box_not_checked));
            SvgManager.bmU().a(imageView, R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_g, (SvgManager.SvgResourceStateType) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo nnx;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.nnx = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.nno != null && this.nnx != null) {
                    i.this.nno.a(this.position, this.nnx);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.nnx != null && i.this.nnp != null) {
                    i.this.nnp.b(this.position, this.nnx);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.nnp != null && this.nnx != null) {
                i.this.nnp.b(this.position, this.nnx);
            }
        }
    }

    public boolean isScroll() {
        return this.bwl;
    }

    public void cG(boolean z) {
        this.bwl = z;
    }

    public void a(g gVar) {
        this.nno = gVar;
    }

    public void a(h hVar) {
        this.nnp = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        View nnu;
        TbCameraView nnv;
        TBLottieAnimationView nnw;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView bwr;
        RelativeLayout bws;
        TbImageView ibG;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TbImageView nny;
        TextView nnz;
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
        this.nnn = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.nnq = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.nnr = aVar;
    }

    public void xW(boolean z) {
        if (this.nnm != z) {
            this.nnm = z;
            notifyDataSetChanged();
        }
    }
}
