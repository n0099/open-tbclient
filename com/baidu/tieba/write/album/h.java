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
    private AlbumActivity hIY;
    private com.baidu.tieba.write.album.c hJs;
    private View.OnClickListener hJu;
    private f hJv;
    private g hJw;
    private TbCameraView.c hJx;
    private TbCameraView.a hJy;
    private a hJz;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fCd = false;
    private boolean hJt = true;

    public TbCameraView bMi() {
        if (this.hJz != null) {
            return this.hJz.hJB;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hIY = albumActivity;
        this.hJs = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hIY.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hJt) {
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
            if (this.hJz == null || this.hJz.hJB == null) {
                this.hJz = new a();
                View inflate = this.mLayoutInflater.inflate(e.h.album_make_picture_view, viewGroup, false);
                this.hJz.rootView = inflate;
                this.hJz.hJB = (TbCameraView) inflate.findViewById(e.g.camera_surfaceview);
                this.hJz.hJA = (TbImageView) inflate.findViewById(e.g.icon_make_photo);
                this.hJz.hJA.setDefaultResource(0);
                this.hJz.hJA.setDefaultErrorResource(0);
                this.hJz.hJA.setGifIconSupport(false);
                this.hJz.hJA.setLongIconSupport(false);
                inflate.setTag(this.hJz);
                this.hIY.showTip(this.hJz.hJA);
            }
            this.hJz.hJB.setOnRequestPermissionListener(this.hJx);
            this.hJz.hJB.setOnOpenCameraFailedListener(this.hJy);
            this.hJz.hJA.setOnClickListener(this.hJu);
            this.hJz.hJB.setOnClickListener(this.hJu);
            this.hJz.rootView.setOnClickListener(this.hJu);
            al.c(this.hJz.hJA, e.f.icon_album_camera);
            al.j(this.hJz.rootView, e.d.black_alpha90);
            return this.hJz.rootView;
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
                dVar2.hjh = (RelativeLayout) view.findViewById(e.g.lay_select);
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
            dVar.hjh.setOnClickListener(bVar);
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
                cVar2.hJE = (TbImageView) view.findViewById(e.g.video_thumb);
                cVar2.hJE.setDefaultResource(0);
                cVar2.hJE.setDefaultErrorResource(0);
                cVar2.hJE.setTagPaddingDis(8, 8);
                cVar2.hJE.setGifIconSupport(false);
                cVar2.hJE.setLongIconSupport(false);
                cVar2.djW = (ImageView) view.findViewById(e.g.select_icon);
                cVar2.hJF = (RelativeLayout) view.findViewById(e.g.video_select);
                cVar2.hJG = (TextView) view.findViewById(e.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hJE.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hJG.setText(ao.dt(videoFileInfo.videoDuration));
            a(cVar.djW, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hJE.setOnClickListener(bVar);
            cVar.hJF.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hJs != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hJs.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hJs != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hJs.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hIY.getResources().getString(e.j.check_box_checked));
                al.c(imageView, e.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hIY.getResources().getString(e.j.check_box_not_checked));
            al.c(imageView, e.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hJD;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hJD = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.g.pic) {
                if (h.this.hJv != null && this.hJD != null) {
                    h.this.hJv.a(this.position, this.hJD);
                }
            } else if (view.getId() == e.g.lay_select) {
                if (this.hJD != null && h.this.hJw != null) {
                    h.this.hJw.b(this.position, this.hJD);
                }
            } else if (view.getId() == e.g.video_thumb) {
                if (h.this.hJv != null && this.hJD != null) {
                    h.this.hJv.a(this.position, this.hJD);
                }
            } else if (view.getId() == e.g.video_select && this.hJD != null && h.this.hJw != null) {
                h.this.hJw.b(this.position, this.hJD);
            }
        }
    }

    public boolean isScroll() {
        return this.fCd;
    }

    public void jT(boolean z) {
        this.fCd = z;
    }

    public void a(f fVar) {
        this.hJv = fVar;
    }

    public void a(g gVar) {
        this.hJw = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hJA;
        TbCameraView hJB;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView djV;
        ImageView djW;
        RelativeLayout hjh;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView djW;
        TbImageView hJE;
        RelativeLayout hJF;
        TextView hJG;
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
        this.hJu = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hJx = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hJy = aVar;
    }

    public void oi(boolean z) {
        if (this.hJt != z) {
            this.hJt = z;
            notifyDataSetChanged();
        }
    }
}
