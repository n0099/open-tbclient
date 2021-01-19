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
/* loaded from: classes7.dex */
public class i extends BaseAdapter {
    private com.baidu.tieba.c.e eTK;
    private BaseFragmentActivity iEK;
    private LayoutInflater mLayoutInflater;
    private com.baidu.tieba.write.album.c nUf;
    private View.OnClickListener nUh;
    private g nUi;
    private h nUj;
    private TbCameraView.c nUk;
    private TbCameraView.a nUl;
    private a nUm;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bIk = false;
    private boolean nUg = true;

    public TbCameraView dUF() {
        if (this.nUm != null) {
            return this.nUm.nUp;
        }
        return null;
    }

    public i(BaseFragmentActivity baseFragmentActivity, com.baidu.tieba.write.album.c cVar) {
        this.iEK = baseFragmentActivity;
        this.nUf = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.iEK.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.nUg) {
            this.mDataList.add(dUG());
        }
        if (!x.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dUG() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return x.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KP */
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
            if (this.nUm == null || this.nUm.nUp == null) {
                this.nUm = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.nUm.rootView = inflate;
                this.nUm.nUp = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.nUm.nUq = (TBLottieAnimationView) inflate.findViewById(R.id.anim_make_photo);
                this.nUm.nUo = inflate.findViewById(R.id.icon_placer_holder);
                this.nUm.nUq.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.nUm.nUq.setFrame(0);
                this.nUm.nUq.useHardwareAcceleration(true);
                ao.a(this.nUm.nUq, R.raw.lottie_photo);
                inflate.setTag(this.nUm);
                if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("write_camera_animaton_key", false)) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("write_camera_animaton_key", true);
                    this.nUm.nUq.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.album.i.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.this.nUm.nUq.playAnimation();
                        }
                    }, 2000L);
                }
                showTip(this.nUm.nUo);
            }
            ao.setBackgroundColor(this.nUm.rootView, R.color.black_alpha90);
            this.nUm.nUp.setOnRequestPermissionListener(this.nUk);
            this.nUm.nUp.setOnOpenCameraFailedListener(this.nUl);
            this.nUm.nUq.setOnClickListener(this.nUh);
            this.nUm.nUp.setOnClickListener(this.nUh);
            this.nUm.rootView.setOnClickListener(this.nUh);
            this.nUm.nUq.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.album.i.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                }
            });
            this.nUm.nUq.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.album.i.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    i.this.nUm.nUq.cancelAnimation();
                    i.this.nUm.nUq.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            return this.nUm.rootView;
        }
        return view;
    }

    public void showTip(View view) {
        if (this.eTK == null && view != null) {
            this.eTK = new com.baidu.tieba.c.e(this.iEK.getPageContext(), view);
            this.eTK.ej(R.drawable.bg_tip_blue_up_left);
            this.eTK.e(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    i.this.eTK.RS();
                }
            });
            this.eTK.ei(16);
            this.eTK.ek(5000);
        }
        if (this.eTK != null) {
            String sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_SHOW_TAKE_PHOTO_TIP);
            this.eTK.aJ(this.iEK.getString(R.string.album_take_photo_tip), sharedPrefKeyWithAccount);
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
                dVar2.iNs = (TbImageView) view.findViewById(R.id.pic);
                dVar2.iNs.setDefaultResource(0);
                dVar2.iNs.setTagPaddingDis(8, 8);
                dVar2.iNs.setGifIconSupport(true);
                dVar2.iNs.setLongIconSupport(true);
                dVar2.bIq = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.bIr = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.nUf != null && this.nUf.getWriteImagesInfo() != null && this.nUf.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.bIr.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.iNs.setIsLongPic(imageFileInfo.isLong());
            dVar.iNs.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bIq, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.iNs.setOnClickListener(bVar);
            dVar.bIr.setOnClickListener(bVar);
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
                cVar2.nUs = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.nUs.setDefaultResource(0);
                cVar2.nUs.setTagPaddingDis(8, 8);
                cVar2.nUs.setGifIconSupport(false);
                cVar2.nUs.setLongIconSupport(false);
                cVar2.nUt = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.nUs.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.nUt.setText(at.stringForVideoTime(videoFileInfo.videoDuration));
            cVar.nUs.setOnClickListener(new b(mediaFileInfo, i));
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.nUf != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.nUf.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.nUf != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.nUf.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.iEK.getResources().getString(R.string.check_box_checked));
                imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok_selection26, WebPManager.ResourceStateType.NORMAL));
                return;
            }
            imageView.setContentDescription(this.iEK.getResources().getString(R.string.check_box_not_checked));
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_mask_set_list_ok26, WebPManager.ResourceStateType.NORMAL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo nUr;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.nUr = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (i.this.nUi != null && this.nUr != null) {
                    i.this.nUi.a(this.position, this.nUr);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.nUr != null && i.this.nUj != null) {
                    i.this.nUj.b(this.position, this.nUr);
                }
            } else if (view.getId() == R.id.video_thumb && i.this.nUj != null && this.nUr != null) {
                i.this.nUj.b(this.position, this.nUr);
            }
        }
    }

    public boolean isScroll() {
        return this.bIk;
    }

    public void di(boolean z) {
        this.bIk = z;
    }

    public void a(g gVar) {
        this.nUi = gVar;
    }

    public void a(h hVar) {
        this.nUj = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
        View nUo;
        TbCameraView nUp;
        TBLottieAnimationView nUq;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class d {
        ImageView bIq;
        RelativeLayout bIr;
        TbImageView iNs;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c {
        TbImageView nUs;
        TextView nUt;
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
        this.nUh = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.nUk = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.nUl = aVar;
    }

    public void zf(boolean z) {
        if (this.nUg != z) {
            this.nUg = z;
            notifyDataSetChanged();
        }
    }
}
