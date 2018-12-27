package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.album.AddMediaInfo;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private View.OnClickListener hVA;
    private f hVB;
    private g hVC;
    private TbCameraView.c hVD;
    private TbCameraView.a hVE;
    private a hVF;
    private AlbumActivity hVe;
    private com.baidu.tieba.write.album.c hVy;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fNi = false;
    private boolean hVz = true;

    public TbCameraView bOD() {
        if (this.hVF != null) {
            return this.hVF.hVH;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hVe = albumActivity;
        this.hVy = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hVe.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hVz) {
            this.mDataList.add(bOE());
        }
        if (!v.I(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bOE() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xr */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) v.d(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.d(this.mDataList, i);
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
            if (this.hVF == null || this.hVF.hVH == null) {
                this.hVF = new a();
                View inflate = this.mLayoutInflater.inflate(e.h.album_make_picture_view, viewGroup, false);
                this.hVF.rootView = inflate;
                this.hVF.hVH = (TbCameraView) inflate.findViewById(e.g.camera_surfaceview);
                this.hVF.hVG = (TbImageView) inflate.findViewById(e.g.icon_make_photo);
                this.hVF.hVG.setDefaultResource(0);
                this.hVF.hVG.setDefaultErrorResource(0);
                this.hVF.hVG.setGifIconSupport(false);
                this.hVF.hVG.setLongIconSupport(false);
                inflate.setTag(this.hVF);
                this.hVe.showTip(this.hVF.hVG);
            }
            this.hVF.hVH.setOnRequestPermissionListener(this.hVD);
            this.hVF.hVH.setOnOpenCameraFailedListener(this.hVE);
            this.hVF.hVG.setOnClickListener(this.hVA);
            this.hVF.hVH.setOnClickListener(this.hVA);
            this.hVF.rootView.setOnClickListener(this.hVA);
            al.c(this.hVF.hVG, e.f.icon_album_camera);
            al.j(this.hVF.rootView, e.d.black_alpha90);
            return this.hVF.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.mLayoutInflater.inflate(e.h.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.duq = (TbImageView) view.findViewById(e.g.pic);
                dVar2.duq.setDefaultResource(0);
                dVar2.duq.setDefaultErrorResource(0);
                dVar2.duq.setTagPaddingDis(8, 8);
                dVar2.duq.setGifIconSupport(true);
                dVar2.duq.setLongIconSupport(true);
                dVar2.dur = (ImageView) view.findViewById(e.g.select_icon);
                dVar2.hvp = (RelativeLayout) view.findViewById(e.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.duq.setIsLongPic(imageFileInfo.isLong());
            dVar.duq.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dur, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.duq.setOnClickListener(bVar);
            dVar.hvp.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.mLayoutInflater.inflate(e.h.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.hVK = (TbImageView) view.findViewById(e.g.video_thumb);
                cVar2.hVK.setDefaultResource(0);
                cVar2.hVK.setDefaultErrorResource(0);
                cVar2.hVK.setTagPaddingDis(8, 8);
                cVar2.hVK.setGifIconSupport(false);
                cVar2.hVK.setLongIconSupport(false);
                cVar2.dur = (ImageView) view.findViewById(e.g.select_icon);
                cVar2.hVL = (RelativeLayout) view.findViewById(e.g.video_select);
                cVar2.hVM = (TextView) view.findViewById(e.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hVK.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hVM.setText(ao.dV(videoFileInfo.videoDuration));
            a(cVar.dur, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hVK.setOnClickListener(bVar);
            cVar.hVL.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hVy != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hVy.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hVy != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hVy.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hVe.getResources().getString(e.j.check_box_checked));
                al.c(imageView, e.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hVe.getResources().getString(e.j.check_box_not_checked));
            al.c(imageView, e.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hVJ;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hVJ = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.g.pic) {
                if (h.this.hVB != null && this.hVJ != null) {
                    h.this.hVB.a(this.position, this.hVJ);
                }
            } else if (view.getId() == e.g.lay_select) {
                if (this.hVJ != null && h.this.hVC != null) {
                    h.this.hVC.b(this.position, this.hVJ);
                }
            } else if (view.getId() == e.g.video_thumb) {
                if (h.this.hVB != null && this.hVJ != null) {
                    h.this.hVB.a(this.position, this.hVJ);
                }
            } else if (view.getId() == e.g.video_select && this.hVJ != null && h.this.hVC != null) {
                h.this.hVC.b(this.position, this.hVJ);
            }
        }
    }

    public boolean isScroll() {
        return this.fNi;
    }

    public void kj(boolean z) {
        this.fNi = z;
    }

    public void a(f fVar) {
        this.hVB = fVar;
    }

    public void a(g gVar) {
        this.hVC = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hVG;
        TbCameraView hVH;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView duq;
        ImageView dur;
        RelativeLayout hvp;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView dur;
        TbImageView hVK;
        RelativeLayout hVL;
        TextView hVM;
        View rootView;

        private c() {
        }
    }

    public int g(ImageFileInfo imageFileInfo) {
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

    public void Y(View.OnClickListener onClickListener) {
        this.hVA = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hVD = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hVE = aVar;
    }

    public void oB(boolean z) {
        if (this.hVz != z) {
            this.hVz = z;
            notifyDataSetChanged();
        }
    }
}
