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
    private AlbumActivity hIX;
    private com.baidu.tieba.write.album.c hJr;
    private View.OnClickListener hJt;
    private f hJu;
    private g hJv;
    private TbCameraView.c hJw;
    private TbCameraView.a hJx;
    private a hJy;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fCc = false;
    private boolean hJs = true;

    public TbCameraView bMi() {
        if (this.hJy != null) {
            return this.hJy.hJA;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hIX = albumActivity;
        this.hJr = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hIX.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hJs) {
            this.mDataList.add(bMj());
        }
        if (!v.J(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bMj() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.I(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wo */
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
            if (this.hJy == null || this.hJy.hJA == null) {
                this.hJy = new a();
                View inflate = this.mLayoutInflater.inflate(e.h.album_make_picture_view, viewGroup, false);
                this.hJy.rootView = inflate;
                this.hJy.hJA = (TbCameraView) inflate.findViewById(e.g.camera_surfaceview);
                this.hJy.hJz = (TbImageView) inflate.findViewById(e.g.icon_make_photo);
                this.hJy.hJz.setDefaultResource(0);
                this.hJy.hJz.setDefaultErrorResource(0);
                this.hJy.hJz.setGifIconSupport(false);
                this.hJy.hJz.setLongIconSupport(false);
                inflate.setTag(this.hJy);
                this.hIX.showTip(this.hJy.hJz);
            }
            this.hJy.hJA.setOnRequestPermissionListener(this.hJw);
            this.hJy.hJA.setOnOpenCameraFailedListener(this.hJx);
            this.hJy.hJz.setOnClickListener(this.hJt);
            this.hJy.hJA.setOnClickListener(this.hJt);
            this.hJy.rootView.setOnClickListener(this.hJt);
            al.c(this.hJy.hJz, e.f.icon_album_camera);
            al.j(this.hJy.rootView, e.d.black_alpha90);
            return this.hJy.rootView;
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
                dVar2.djV = (TbImageView) view.findViewById(e.g.pic);
                dVar2.djV.setDefaultResource(0);
                dVar2.djV.setDefaultErrorResource(0);
                dVar2.djV.setTagPaddingDis(8, 8);
                dVar2.djV.setGifIconSupport(true);
                dVar2.djV.setLongIconSupport(true);
                dVar2.djW = (ImageView) view.findViewById(e.g.select_icon);
                dVar2.hjg = (RelativeLayout) view.findViewById(e.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.djV.setIsLongPic(imageFileInfo.isLong());
            dVar.djV.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.djW, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.djV.setOnClickListener(bVar);
            dVar.hjg.setOnClickListener(bVar);
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
                cVar2.hJD = (TbImageView) view.findViewById(e.g.video_thumb);
                cVar2.hJD.setDefaultResource(0);
                cVar2.hJD.setDefaultErrorResource(0);
                cVar2.hJD.setTagPaddingDis(8, 8);
                cVar2.hJD.setGifIconSupport(false);
                cVar2.hJD.setLongIconSupport(false);
                cVar2.djW = (ImageView) view.findViewById(e.g.select_icon);
                cVar2.hJE = (RelativeLayout) view.findViewById(e.g.video_select);
                cVar2.hJF = (TextView) view.findViewById(e.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hJD.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hJF.setText(ao.dt(videoFileInfo.videoDuration));
            a(cVar.djW, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hJD.setOnClickListener(bVar);
            cVar.hJE.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hJr != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hJr.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hJr != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hJr.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hIX.getResources().getString(e.j.check_box_checked));
                al.c(imageView, e.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hIX.getResources().getString(e.j.check_box_not_checked));
            al.c(imageView, e.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hJC;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hJC = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.g.pic) {
                if (h.this.hJu != null && this.hJC != null) {
                    h.this.hJu.a(this.position, this.hJC);
                }
            } else if (view.getId() == e.g.lay_select) {
                if (this.hJC != null && h.this.hJv != null) {
                    h.this.hJv.b(this.position, this.hJC);
                }
            } else if (view.getId() == e.g.video_thumb) {
                if (h.this.hJu != null && this.hJC != null) {
                    h.this.hJu.a(this.position, this.hJC);
                }
            } else if (view.getId() == e.g.video_select && this.hJC != null && h.this.hJv != null) {
                h.this.hJv.b(this.position, this.hJC);
            }
        }
    }

    public boolean isScroll() {
        return this.fCc;
    }

    public void jT(boolean z) {
        this.fCc = z;
    }

    public void a(f fVar) {
        this.hJu = fVar;
    }

    public void a(g gVar) {
        this.hJv = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbCameraView hJA;
        TbImageView hJz;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView djV;
        ImageView djW;
        RelativeLayout hjg;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView djW;
        TbImageView hJD;
        RelativeLayout hJE;
        TextView hJF;
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

    public void W(View.OnClickListener onClickListener) {
        this.hJt = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hJw = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hJx = aVar;
    }

    public void oi(boolean z) {
        if (this.hJs != z) {
            this.hJs = z;
            notifyDataSetChanged();
        }
    }
}
