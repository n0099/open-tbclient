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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private com.baidu.tieba.write.album.c hoQ;
    private View.OnClickListener hoS;
    private f hoT;
    private g hoU;
    private TbCameraView.c hoV;
    private TbCameraView.a hoW;
    private a hoX;
    private AlbumActivity how;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fjb = false;
    private boolean hoR = true;

    public TbCameraView bGQ() {
        if (this.hoX != null) {
            return this.hoX.hoZ;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.how = albumActivity;
        this.hoQ = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.how.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hoR) {
            this.mDataList.add(bGR());
        }
        if (!w.z(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bGR() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vj */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) w.c(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) w.c(this.mDataList, i);
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
            if (this.hoX == null || this.hoX.hoZ == null) {
                this.hoX = new a();
                View inflate = this.mLayoutInflater.inflate(d.i.album_make_picture_view, viewGroup, false);
                this.hoX.rootView = inflate;
                this.hoX.hoZ = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hoX.hoY = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hoX.hoY.setDefaultResource(0);
                this.hoX.hoY.setDefaultErrorResource(0);
                this.hoX.hoY.setGifIconSupport(false);
                this.hoX.hoY.setLongIconSupport(false);
                inflate.setTag(this.hoX);
                this.how.showTip(this.hoX.hoY);
            }
            this.hoX.hoZ.setOnRequestPermissionListener(this.hoV);
            this.hoX.hoZ.setOnOpenCameraFailedListener(this.hoW);
            this.hoX.hoY.setOnClickListener(this.hoS);
            this.hoX.hoZ.setOnClickListener(this.hoS);
            this.hoX.rootView.setOnClickListener(this.hoS);
            al.c(this.hoX.hoY, d.f.icon_album_camera);
            al.j(this.hoX.rootView, d.C0141d.black_alpha90);
            return this.hoX.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.mLayoutInflater.inflate(d.i.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.cVh = (TbImageView) view.findViewById(d.g.pic);
                dVar2.cVh.setDefaultResource(0);
                dVar2.cVh.setDefaultErrorResource(0);
                dVar2.cVh.setTagPaddingDis(8, 8);
                dVar2.cVh.setGifIconSupport(true);
                dVar2.cVh.setLongIconSupport(true);
                dVar2.cVi = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.gOB = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.cVh.setIsLongPic(imageFileInfo.isLong());
            dVar.cVh.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cVi, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cVh.setOnClickListener(bVar);
            dVar.gOB.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.mLayoutInflater.inflate(d.i.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.hpc = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hpc.setDefaultResource(0);
                cVar2.hpc.setDefaultErrorResource(0);
                cVar2.hpc.setTagPaddingDis(8, 8);
                cVar2.hpc.setGifIconSupport(false);
                cVar2.hpc.setLongIconSupport(false);
                cVar2.cVi = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hpd = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hpe = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hpc.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hpe.setText(ao.cX(videoFileInfo.videoDuration));
            a(cVar.cVi, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hpc.setOnClickListener(bVar);
            cVar.hpd.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hoQ != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hoQ.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hoQ != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hoQ.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.how.getResources().getString(d.k.check_box_checked));
                al.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.how.getResources().getString(d.k.check_box_not_checked));
            al.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hpb;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hpb = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (h.this.hoT != null && this.hpb != null) {
                    h.this.hoT.a(this.position, this.hpb);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hpb != null && h.this.hoU != null) {
                    h.this.hoU.b(this.position, this.hpb);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (h.this.hoT != null && this.hpb != null) {
                    h.this.hoT.a(this.position, this.hpb);
                }
            } else if (view.getId() == d.g.video_select && this.hpb != null && h.this.hoU != null) {
                h.this.hoU.b(this.position, this.hpb);
            }
        }
    }

    public boolean isScroll() {
        return this.fjb;
    }

    public void jj(boolean z) {
        this.fjb = z;
    }

    public void a(f fVar) {
        this.hoT = fVar;
    }

    public void a(g gVar) {
        this.hoU = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hoY;
        TbCameraView hoZ;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView cVh;
        ImageView cVi;
        RelativeLayout gOB;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView cVi;
        TbImageView hpc;
        RelativeLayout hpd;
        TextView hpe;
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

    public void V(View.OnClickListener onClickListener) {
        this.hoS = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hoV = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hoW = aVar;
    }

    public void nz(boolean z) {
        if (this.hoR != z) {
            this.hoR = z;
            notifyDataSetChanged();
        }
    }
}
