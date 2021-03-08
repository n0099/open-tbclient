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
/* loaded from: classes7.dex */
public class i extends BaseAdapter {
    private com.baidu.tieba.c.e eXz;
    private BaseFragmentActivity iMq;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c ogR;
    private View.OnClickListener ogT;
    private g ogU;
    private h ogV;
    private TbCameraView.c ogW;
    private TbCameraView.a ogX;
    private a ogY;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bNu = false;
    private boolean ogS = true;

    public TbCameraView dXj() {
        if (this.ogY != null) {
            return this.ogY.ohb;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.iMq = baseFragmentActivity;
        this.ogR = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.iMq.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.ogS) {
            this.mDataList.add(dXk());
        }
        if (!y.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dXk() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Lp */
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
            if (this.ogY == null || this.ogY.ohb == null) {
                this.ogY = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.ogY.rootView = inflate;
                this.ogY.ohb = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.ogY.ohc = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.ogY.oha = inflate.findViewById(R.id.icon_placer_holder);
                this.ogY.ohc.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ogY.ohc.setFrame(0);
                this.ogY.ohc.useHardwareAcceleration(true);
                ap.a(this.ogY.ohc, R.raw.lottie_photo);
                inflate.setTag(this.ogY);
                if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("write_camera_animaton_key", true);
                    this.ogY.ohc.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.ogY.ohc.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.ogY.oha);
            }
            ap.setBackgroundColor(this.ogY.rootView, R.color.black_alpha90);
            this.ogY.ohb.setOnRequestPermissionListener(this.ogW);
            this.ogY.ohb.setOnOpenCameraFailedListener(this.ogX);
            this.ogY.ohc.setOnClickListener(this.ogT);
            this.ogY.ohb.setOnClickListener(this.ogT);
            this.ogY.rootView.setOnClickListener(this.ogT);
            this.ogY.ohc.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.ogY.ohc.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.ogY.ohc.cancelAnimation();
                    i.this.ogY.ohc.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.ogY.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.eXz == null && view != null) {
            this.eXz = new com.baidu.tieba.c.e(this.iMq.getPageContext(), view);
            this.eXz.eo(R.drawable.bg_tip_blue_up_left);
            this.eXz.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.eXz.TC();
                }
            });
            this.eXz.en(16);
            this.eXz.ep(5000);
        }
        if (this.eXz != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.eXz.aJ(this.iMq.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.iUW = (TbImageView) view.findViewById(R.id.pic);
                dVar2.iUW.setDefaultResource(0);
                dVar2.iUW.setTagPaddingDis(8, 8);
                dVar2.iUW.setGifIconSupport(true);
                dVar2.iUW.setLongIconSupport(true);
                dVar2.bNA = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bNB = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.ogR != null && this.ogR.getWriteImagesInfo() != null && this.ogR.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bNB.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.iUW.setIsLongPic(imageFileInfo.isLong());
            dVar.iUW.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bNA, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.iUW.setOnClickListener(bVar);
            dVar.bNB.setOnClickListener(bVar);
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
                cVar2.ohe = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.ohe.setDefaultResource(0);
                cVar2.ohe.setTagPaddingDis(8, 8);
                cVar2.ohe.setGifIconSupport(false);
                cVar2.ohe.setLongIconSupport(false);
                cVar2.ohf = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.ohe.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.ohf.setText(au.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.ohe.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.ogR != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.ogR.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.ogR != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.ogR.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.iMq.getResources().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(this.iMq.getResources().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo ohd;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.ohd = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.ogU != null && this.ohd != null) {
                    i.this.ogU.a(this.position, this.ohd);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.ohd != null && i.this.ogV != null) {
                    i.this.ogV.b(this.position, this.ohd);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.ogV != null && this.ohd != null) {
                i.this.ogV.b(this.position, this.ohd);
            }
        }
    }

    public boolean isScroll() {
        return this.bNu;
    }

    public void dq(boolean z) {
        this.bNu = z;
    }

    public void a(g gVar) {
        this.ogU = gVar;
    }

    public void a(h hVar) {
        this.ogV = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        View oha;
        TbCameraView ohb;
        TBLottieAnimationView ohc;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class d {
        ImageView bNA;
        RelativeLayout bNB;
        TbImageView iUW;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c {
        TbImageView ohe;
        TextView ohf;
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

    public void ap(View.OnClickListener onClickListener) {
        this.ogT = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.ogW = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.ogX = aVar;
    }

    public void zA(boolean z) {
        if (this.ogS != z) {
            this.ogS = z;
            notifyDataSetChanged();
        }
    }
}
