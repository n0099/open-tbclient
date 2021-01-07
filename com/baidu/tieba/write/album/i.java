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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i extends BaseAdapter {
    private com.baidu.tieba.c.e eYv;
    private BaseFragmentActivity iJr;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c nYJ;
    private View.OnClickListener nYL;
    private g nYM;
    private h nYN;
    private TbCameraView.c nYO;
    private TbCameraView.a nYP;
    private a nYQ;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bMW = false;
    private boolean nYK = true;

    public TbCameraView dYx() {
        if (this.nYQ != null) {
            return this.nYQ.nYT;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.iJr = baseFragmentActivity;
        this.nYJ = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.iJr.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.nYK) {
            this.mDataList.add(dYy());
        }
        if (!x.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dYy() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return x.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Mw */
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
            if (this.nYQ == null || this.nYQ.nYT == null) {
                this.nYQ = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.nYQ.rootView = inflate;
                this.nYQ.nYT = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.nYQ.nYU = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.nYQ.nYS = inflate.findViewById(R.id.icon_placer_holder);
                this.nYQ.nYU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.nYQ.nYU.setFrame(0);
                this.nYQ.nYU.useHardwareAcceleration(true);
                ao.a(this.nYQ.nYU, R.raw.lottie_photo);
                inflate.setTag(this.nYQ);
                if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("write_camera_animaton_key", true);
                    this.nYQ.nYU.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.nYQ.nYU.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.nYQ.nYS);
            }
            ao.setBackgroundColor(this.nYQ.rootView, R.color.black_alpha90);
            this.nYQ.nYT.setOnRequestPermissionListener(this.nYO);
            this.nYQ.nYT.setOnOpenCameraFailedListener(this.nYP);
            this.nYQ.nYU.setOnClickListener(this.nYL);
            this.nYQ.nYT.setOnClickListener(this.nYL);
            this.nYQ.rootView.setOnClickListener(this.nYL);
            this.nYQ.nYU.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.nYQ.nYU.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.nYQ.nYU.cancelAnimation();
                    i.this.nYQ.nYU.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.nYQ.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.eYv == null && view != null) {
            this.eYv = new com.baidu.tieba.c.e(this.iJr.getPageContext(), view);
            this.eYv.fP(R.drawable.bg_tip_blue_up_left);
            this.eYv.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.eYv.VL();
                }
            });
            this.eYv.fO(16);
            this.eYv.fQ(5000);
        }
        if (this.eYv != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.eYv.aK(this.iJr.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.iRZ = (TbImageView) view.findViewById(R.id.pic);
                dVar2.iRZ.setDefaultResource(0);
                dVar2.iRZ.setTagPaddingDis(8, 8);
                dVar2.iRZ.setGifIconSupport(true);
                dVar2.iRZ.setLongIconSupport(true);
                dVar2.bNc = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bNd = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.nYJ != null && this.nYJ.getWriteImagesInfo() != null && this.nYJ.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bNd.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.iRZ.setIsLongPic(imageFileInfo.isLong());
            dVar.iRZ.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bNc, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.iRZ.setOnClickListener(bVar);
            dVar.bNd.setOnClickListener(bVar);
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
                cVar2.nYW = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.nYW.setDefaultResource(0);
                cVar2.nYW.setTagPaddingDis(8, 8);
                cVar2.nYW.setGifIconSupport(false);
                cVar2.nYW.setLongIconSupport(false);
                cVar2.nYX = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.nYW.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.nYX.setText(at.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.nYW.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.nYJ != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.nYJ.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.nYJ != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.nYJ.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.iJr.getResources().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(this.iJr.getResources().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo nYV;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.nYV = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.nYM != null && this.nYV != null) {
                    i.this.nYM.a(this.position, this.nYV);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.nYV != null && i.this.nYN != null) {
                    i.this.nYN.b(this.position, this.nYV);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.nYN != null && this.nYV != null) {
                i.this.nYN.b(this.position, this.nYV);
            }
        }
    }

    public boolean isScroll() {
        return this.bMW;
    }

    public void dm(boolean z) {
        this.bMW = z;
    }

    public void a(g gVar) {
        this.nYM = gVar;
    }

    public void a(h hVar) {
        this.nYN = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        View nYS;
        TbCameraView nYT;
        TBLottieAnimationView nYU;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class d {
        ImageView bNc;
        RelativeLayout bNd;
        TbImageView iRZ;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c {
        TbImageView nYW;
        TextView nYX;
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
        this.nYL = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.nYO = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.nYP = aVar;
    }

    public void zj(boolean z) {
        if (this.nYK != z) {
            this.nYK = z;
            notifyDataSetChanged();
        }
    }
}
