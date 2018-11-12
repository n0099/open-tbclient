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
    private AlbumActivity hKI;
    private com.baidu.tieba.write.album.c hLc;
    private View.OnClickListener hLe;
    private f hLf;
    private g hLg;
    private TbCameraView.c hLh;
    private TbCameraView.a hLi;
    private a hLj;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fDA = false;
    private boolean hLd = true;

    public TbCameraView bLH() {
        if (this.hLj != null) {
            return this.hLj.hLl;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hKI = albumActivity;
        this.hLc = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hKI.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hLd) {
            this.mDataList.add(bLI());
        }
        if (!v.I(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bLI() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wH */
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
            if (this.hLj == null || this.hLj.hLl == null) {
                this.hLj = new a();
                View inflate = this.mLayoutInflater.inflate(e.h.album_make_picture_view, viewGroup, false);
                this.hLj.rootView = inflate;
                this.hLj.hLl = (TbCameraView) inflate.findViewById(e.g.camera_surfaceview);
                this.hLj.hLk = (TbImageView) inflate.findViewById(e.g.icon_make_photo);
                this.hLj.hLk.setDefaultResource(0);
                this.hLj.hLk.setDefaultErrorResource(0);
                this.hLj.hLk.setGifIconSupport(false);
                this.hLj.hLk.setLongIconSupport(false);
                inflate.setTag(this.hLj);
                this.hKI.showTip(this.hLj.hLk);
            }
            this.hLj.hLl.setOnRequestPermissionListener(this.hLh);
            this.hLj.hLl.setOnOpenCameraFailedListener(this.hLi);
            this.hLj.hLk.setOnClickListener(this.hLe);
            this.hLj.hLl.setOnClickListener(this.hLe);
            this.hLj.rootView.setOnClickListener(this.hLe);
            al.c(this.hLj.hLk, e.f.icon_album_camera);
            al.j(this.hLj.rootView, e.d.black_alpha90);
            return this.hLj.rootView;
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
                dVar2.dla = (TbImageView) view.findViewById(e.g.pic);
                dVar2.dla.setDefaultResource(0);
                dVar2.dla.setDefaultErrorResource(0);
                dVar2.dla.setTagPaddingDis(8, 8);
                dVar2.dla.setGifIconSupport(true);
                dVar2.dla.setLongIconSupport(true);
                dVar2.dlb = (ImageView) view.findViewById(e.g.select_icon);
                dVar2.hkR = (RelativeLayout) view.findViewById(e.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.dla.setIsLongPic(imageFileInfo.isLong());
            dVar.dla.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dlb, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.dla.setOnClickListener(bVar);
            dVar.hkR.setOnClickListener(bVar);
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
                cVar2.hLo = (TbImageView) view.findViewById(e.g.video_thumb);
                cVar2.hLo.setDefaultResource(0);
                cVar2.hLo.setDefaultErrorResource(0);
                cVar2.hLo.setTagPaddingDis(8, 8);
                cVar2.hLo.setGifIconSupport(false);
                cVar2.hLo.setLongIconSupport(false);
                cVar2.dlb = (ImageView) view.findViewById(e.g.select_icon);
                cVar2.hLp = (RelativeLayout) view.findViewById(e.g.video_select);
                cVar2.hLq = (TextView) view.findViewById(e.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hLo.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hLq.setText(ao.dH(videoFileInfo.videoDuration));
            a(cVar.dlb, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hLo.setOnClickListener(bVar);
            cVar.hLp.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hLc != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hLc.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hLc != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hLc.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hKI.getResources().getString(e.j.check_box_checked));
                al.c(imageView, e.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hKI.getResources().getString(e.j.check_box_not_checked));
            al.c(imageView, e.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hLn;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hLn = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.g.pic) {
                if (h.this.hLf != null && this.hLn != null) {
                    h.this.hLf.a(this.position, this.hLn);
                }
            } else if (view.getId() == e.g.lay_select) {
                if (this.hLn != null && h.this.hLg != null) {
                    h.this.hLg.b(this.position, this.hLn);
                }
            } else if (view.getId() == e.g.video_thumb) {
                if (h.this.hLf != null && this.hLn != null) {
                    h.this.hLf.a(this.position, this.hLn);
                }
            } else if (view.getId() == e.g.video_select && this.hLn != null && h.this.hLg != null) {
                h.this.hLg.b(this.position, this.hLn);
            }
        }
    }

    public boolean isScroll() {
        return this.fDA;
    }

    public void kd(boolean z) {
        this.fDA = z;
    }

    public void a(f fVar) {
        this.hLf = fVar;
    }

    public void a(g gVar) {
        this.hLg = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hLk;
        TbCameraView hLl;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView dla;
        ImageView dlb;
        RelativeLayout hkR;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView dlb;
        TbImageView hLo;
        RelativeLayout hLp;
        TextView hLq;
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
        this.hLe = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hLh = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hLi = aVar;
    }

    public void ow(boolean z) {
        if (this.hLd != z) {
            this.hLd = z;
            notifyDataSetChanged();
        }
    }
}
