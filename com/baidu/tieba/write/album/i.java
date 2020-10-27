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
    private BaseFragmentActivity ifx;
    private com.baidu.tieba.c.e luR;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c nzM;
    private View.OnClickListener nzO;
    private g nzP;
    private h nzQ;
    private TbCameraView.c nzR;
    private TbCameraView.a nzS;
    private a nzT;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean byz = false;
    private boolean nzN = true;

    public TbCameraView dQZ() {
        if (this.nzT != null) {
            return this.nzT.nzW;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.ifx = baseFragmentActivity;
        this.nzM = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.ifx.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.nzN) {
            this.mDataList.add(dRa());
        }
        if (!y.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dRa() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Lb */
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
            if (this.nzT == null || this.nzT.nzW == null) {
                this.nzT = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.nzT.rootView = inflate;
                this.nzT.nzW = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.nzT.nzX = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.nzT.nzV = inflate.findViewById(R.id.icon_placer_holder);
                this.nzT.nzX.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.nzT.nzX.setFrame(0);
                this.nzT.nzX.useHardwareAcceleration(true);
                ap.a(this.nzT.nzX, R.raw.lottie_photo);
                inflate.setTag(this.nzT);
                if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("write_camera_animaton_key", true);
                    this.nzT.nzX.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.nzT.nzX.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.nzT.nzV);
            }
            ap.setBackgroundColor(this.nzT.rootView, R.color.black_alpha90);
            this.nzT.nzW.setOnRequestPermissionListener(this.nzR);
            this.nzT.nzW.setOnOpenCameraFailedListener(this.nzS);
            this.nzT.nzX.setOnClickListener(this.nzO);
            this.nzT.nzW.setOnClickListener(this.nzO);
            this.nzT.rootView.setOnClickListener(this.nzO);
            this.nzT.nzX.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.nzT.nzX.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.nzT.nzX.cancelAnimation();
                    i.this.nzT.nzX.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.nzT.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.luR == null && view != null) {
            this.luR = new com.baidu.tieba.c.e(this.ifx.getPageContext(), view);
            this.luR.fh(R.drawable.bg_tip_blue_up_left);
            this.luR.c(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.luR.Qh();
                }
            });
            this.luR.fg(16);
            this.luR.fi(5000);
        }
        if (this.luR != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.luR.aL(this.ifx.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.ioi = (TbImageView) view.findViewById(R.id.pic);
                dVar2.ioi.setDefaultResource(0);
                dVar2.ioi.setDefaultErrorResource(0);
                dVar2.ioi.setTagPaddingDis(8, 8);
                dVar2.ioi.setGifIconSupport(true);
                dVar2.ioi.setLongIconSupport(true);
                dVar2.byF = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.byG = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.nzM != null && this.nzM.getWriteImagesInfo() != null && this.nzM.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.byG.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.ioi.setIsLongPic(imageFileInfo.isLong());
            dVar.ioi.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.byF, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.ioi.setOnClickListener(bVar);
            dVar.byG.setOnClickListener(bVar);
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
                cVar2.nzZ = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.nzZ.setDefaultResource(0);
                cVar2.nzZ.setDefaultErrorResource(0);
                cVar2.nzZ.setTagPaddingDis(8, 8);
                cVar2.nzZ.setGifIconSupport(false);
                cVar2.nzZ.setLongIconSupport(false);
                cVar2.nAa = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.nzZ.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.nAa.setText(at.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.nzZ.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.nzM != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.nzM.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.nzM != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.nzM.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.ifx.getResources().getString(R.string.check_box_checked));
                SvgManager.boN().a(imageView, R.drawable.icon_mask_stroke1_blue_h_svg, (SvgManager.SvgResourceStateType) null);
                return;
            }
            imageView.setContentDescription(this.ifx.getResources().getString(R.string.check_box_not_checked));
            SvgManager.boN().a(imageView, R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_g, (SvgManager.SvgResourceStateType) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo nzY;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.nzY = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.nzP != null && this.nzY != null) {
                    i.this.nzP.a(this.position, this.nzY);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.nzY != null && i.this.nzQ != null) {
                    i.this.nzQ.b(this.position, this.nzY);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.nzQ != null && this.nzY != null) {
                i.this.nzQ.b(this.position, this.nzY);
            }
        }
    }

    public boolean isScroll() {
        return this.byz;
    }

    public void cM(boolean z) {
        this.byz = z;
    }

    public void a(g gVar) {
        this.nzP = gVar;
    }

    public void a(h hVar) {
        this.nzQ = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        View nzV;
        TbCameraView nzW;
        TBLottieAnimationView nzX;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView byF;
        RelativeLayout byG;
        TbImageView ioi;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        TextView nAa;
        TbImageView nzZ;
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
        this.nzO = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.nzR = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.nzS = aVar;
    }

    public void yn(boolean z) {
        if (this.nzN != z) {
            this.nzN = z;
            notifyDataSetChanged();
        }
    }
}
