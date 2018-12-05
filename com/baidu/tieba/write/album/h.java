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
    private AlbumActivity hRT;
    private com.baidu.tieba.write.album.c hSn;
    private View.OnClickListener hSp;
    private f hSq;
    private g hSr;
    private TbCameraView.c hSs;
    private TbCameraView.a hSt;
    private a hSu;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fKq = false;
    private boolean hSo = true;

    public TbCameraView bNN() {
        if (this.hSu != null) {
            return this.hSu.hSw;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hRT = albumActivity;
        this.hSn = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hRT.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hSo) {
            this.mDataList.add(bNO());
        }
        if (!v.I(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bNO() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xe */
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
            if (this.hSu == null || this.hSu.hSw == null) {
                this.hSu = new a();
                View inflate = this.mLayoutInflater.inflate(e.h.album_make_picture_view, viewGroup, false);
                this.hSu.rootView = inflate;
                this.hSu.hSw = (TbCameraView) inflate.findViewById(e.g.camera_surfaceview);
                this.hSu.hSv = (TbImageView) inflate.findViewById(e.g.icon_make_photo);
                this.hSu.hSv.setDefaultResource(0);
                this.hSu.hSv.setDefaultErrorResource(0);
                this.hSu.hSv.setGifIconSupport(false);
                this.hSu.hSv.setLongIconSupport(false);
                inflate.setTag(this.hSu);
                this.hRT.showTip(this.hSu.hSv);
            }
            this.hSu.hSw.setOnRequestPermissionListener(this.hSs);
            this.hSu.hSw.setOnOpenCameraFailedListener(this.hSt);
            this.hSu.hSv.setOnClickListener(this.hSp);
            this.hSu.hSw.setOnClickListener(this.hSp);
            this.hSu.rootView.setOnClickListener(this.hSp);
            al.c(this.hSu.hSv, e.f.icon_album_camera);
            al.j(this.hSu.rootView, e.d.black_alpha90);
            return this.hSu.rootView;
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
                dVar2.drC = (TbImageView) view.findViewById(e.g.pic);
                dVar2.drC.setDefaultResource(0);
                dVar2.drC.setDefaultErrorResource(0);
                dVar2.drC.setTagPaddingDis(8, 8);
                dVar2.drC.setGifIconSupport(true);
                dVar2.drC.setLongIconSupport(true);
                dVar2.drD = (ImageView) view.findViewById(e.g.select_icon);
                dVar2.hsd = (RelativeLayout) view.findViewById(e.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.drC.setIsLongPic(imageFileInfo.isLong());
            dVar.drC.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.drD, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.drC.setOnClickListener(bVar);
            dVar.hsd.setOnClickListener(bVar);
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
                cVar2.hSz = (TbImageView) view.findViewById(e.g.video_thumb);
                cVar2.hSz.setDefaultResource(0);
                cVar2.hSz.setDefaultErrorResource(0);
                cVar2.hSz.setTagPaddingDis(8, 8);
                cVar2.hSz.setGifIconSupport(false);
                cVar2.hSz.setLongIconSupport(false);
                cVar2.drD = (ImageView) view.findViewById(e.g.select_icon);
                cVar2.hSA = (RelativeLayout) view.findViewById(e.g.video_select);
                cVar2.hSB = (TextView) view.findViewById(e.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hSz.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hSB.setText(ao.dV(videoFileInfo.videoDuration));
            a(cVar.drD, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hSz.setOnClickListener(bVar);
            cVar.hSA.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hSn != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hSn.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hSn != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hSn.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hRT.getResources().getString(e.j.check_box_checked));
                al.c(imageView, e.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hRT.getResources().getString(e.j.check_box_not_checked));
            al.c(imageView, e.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hSy;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hSy = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.g.pic) {
                if (h.this.hSq != null && this.hSy != null) {
                    h.this.hSq.a(this.position, this.hSy);
                }
            } else if (view.getId() == e.g.lay_select) {
                if (this.hSy != null && h.this.hSr != null) {
                    h.this.hSr.b(this.position, this.hSy);
                }
            } else if (view.getId() == e.g.video_thumb) {
                if (h.this.hSq != null && this.hSy != null) {
                    h.this.hSq.a(this.position, this.hSy);
                }
            } else if (view.getId() == e.g.video_select && this.hSy != null && h.this.hSr != null) {
                h.this.hSr.b(this.position, this.hSy);
            }
        }
    }

    public boolean isScroll() {
        return this.fKq;
    }

    public void kg(boolean z) {
        this.fKq = z;
    }

    public void a(f fVar) {
        this.hSq = fVar;
    }

    public void a(g gVar) {
        this.hSr = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hSv;
        TbCameraView hSw;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView drC;
        ImageView drD;
        RelativeLayout hsd;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView drD;
        RelativeLayout hSA;
        TextView hSB;
        TbImageView hSz;
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
        this.hSp = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hSs = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hSt = aVar;
    }

    public void oy(boolean z) {
        if (this.hSo != z) {
            this.hSo = z;
            notifyDataSetChanged();
        }
    }
}
