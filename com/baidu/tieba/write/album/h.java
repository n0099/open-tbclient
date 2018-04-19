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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private AlbumActivity hbA;
    private com.baidu.tieba.write.album.c hbU;
    private View.OnClickListener hbW;
    private f hbX;
    private g hbY;
    private TbCameraView.c hbZ;
    private TbCameraView.a hca;
    private a hcb;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean eWC = false;
    private boolean hbV = true;

    public TbCameraView bBM() {
        if (this.hcb != null) {
            return this.hcb.hcd;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hbA = albumActivity;
        this.hbU = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hbA.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hbV) {
            this.mDataList.add(bBN());
        }
        if (!v.w(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bBN() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uS */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) v.c(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.c(this.mDataList, i);
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        MediaFileInfo item = getItem(i);
        if (item != null) {
            if (item.getType() == 2) {
                return a(i, view2, viewGroup, item);
            }
            if (item.getType() == 1) {
                return c(i, view2, viewGroup, item);
            }
            if (item.getType() == 0) {
                return b(i, view2, viewGroup, item);
            }
            return view2;
        }
        return view2;
    }

    private View a(int i, View view2, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        if (mediaFileInfo != null && mediaFileInfo.getType() == 2) {
            if (this.hcb == null || this.hcb.hcd == null) {
                this.hcb = new a();
                View inflate = this.mLayoutInflater.inflate(d.i.album_make_picture_view, viewGroup, false);
                this.hcb.rootView = inflate;
                this.hcb.hcd = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hcb.hcc = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hcb.hcc.setDefaultResource(0);
                this.hcb.hcc.setDefaultErrorResource(0);
                this.hcb.hcc.setGifIconSupport(false);
                this.hcb.hcc.setLongIconSupport(false);
                inflate.setTag(this.hcb);
                this.hbA.showTip(this.hcb.hcc);
            }
            this.hcb.hcd.setOnRequestPermissionListener(this.hbZ);
            this.hcb.hcd.setOnOpenCameraFailedListener(this.hca);
            this.hcb.hcc.setOnClickListener(this.hbW);
            this.hcb.hcd.setOnClickListener(this.hbW);
            this.hcb.rootView.setOnClickListener(this.hbW);
            ak.c(this.hcb.hcc, d.f.icon_album_camera);
            ak.j(this.hcb.rootView, d.C0126d.black_alpha90);
            return this.hcb.rootView;
        }
        return view2;
    }

    private View b(int i, View view2, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view2 == null || !(view2.getTag() instanceof d)) {
                d dVar2 = new d();
                view2 = this.mLayoutInflater.inflate(d.i.album_image_item_view, viewGroup, false);
                dVar2.rootView = view2;
                dVar2.cKX = (TbImageView) view2.findViewById(d.g.pic);
                dVar2.cKX.setDefaultResource(0);
                dVar2.cKX.setDefaultErrorResource(0);
                dVar2.cKX.setTagPaddingDis(8, 8);
                dVar2.cKX.setGifIconSupport(true);
                dVar2.cKX.setLongIconSupport(true);
                dVar2.cKY = (ImageView) view2.findViewById(d.g.select_icon);
                dVar2.gBZ = (RelativeLayout) view2.findViewById(d.g.lay_select);
                view2.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view2.getTag();
            }
            dVar.cKX.setIsLongPic(imageFileInfo.isLong());
            dVar.cKX.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cKY, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cKX.setOnClickListener(bVar);
            dVar.gBZ.setOnClickListener(bVar);
        }
        return view2;
    }

    private View c(int i, View view2, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view2 == null || !(view2.getTag() instanceof d)) {
                c cVar2 = new c();
                view2 = this.mLayoutInflater.inflate(d.i.album_video_item_view, viewGroup, false);
                cVar2.rootView = view2;
                cVar2.hcg = (TbImageView) view2.findViewById(d.g.video_thumb);
                cVar2.hcg.setDefaultResource(0);
                cVar2.hcg.setDefaultErrorResource(0);
                cVar2.hcg.setTagPaddingDis(8, 8);
                cVar2.hcg.setGifIconSupport(false);
                cVar2.hcg.setLongIconSupport(false);
                cVar2.cKY = (ImageView) view2.findViewById(d.g.select_icon);
                cVar2.hch = (RelativeLayout) view2.findViewById(d.g.video_select);
                cVar2.hci = (TextView) view2.findViewById(d.g.video_play_time);
                view2.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view2.getTag();
            }
            cVar.hcg.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hci.setText(an.cU(videoFileInfo.videoDuration));
            a(cVar.cKY, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hcg.setOnClickListener(bVar);
            cVar.hch.setOnClickListener(bVar);
        }
        return view2;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hbU != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hbU.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hbU != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hbU.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hbA.getResources().getString(d.k.check_box_checked));
                ak.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hbA.getResources().getString(d.k.check_box_not_checked));
            ak.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hcf;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hcf = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getId() == d.g.pic) {
                if (h.this.hbX != null && this.hcf != null) {
                    h.this.hbX.a(this.position, this.hcf);
                }
            } else if (view2.getId() == d.g.lay_select) {
                if (this.hcf != null && h.this.hbY != null) {
                    h.this.hbY.b(this.position, this.hcf);
                }
            } else if (view2.getId() == d.g.video_thumb) {
                if (h.this.hbX != null && this.hcf != null) {
                    h.this.hbX.a(this.position, this.hcf);
                }
            } else if (view2.getId() == d.g.video_select && this.hcf != null && h.this.hbY != null) {
                h.this.hbY.b(this.position, this.hcf);
            }
        }
    }

    public boolean isScroll() {
        return this.eWC;
    }

    public void jc(boolean z) {
        this.eWC = z;
    }

    public void a(f fVar) {
        this.hbX = fVar;
    }

    public void a(g gVar) {
        this.hbY = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hcc;
        TbCameraView hcd;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView cKX;
        ImageView cKY;
        RelativeLayout gBZ;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView cKY;
        TbImageView hcg;
        RelativeLayout hch;
        TextView hci;
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
        this.hbW = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hbZ = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hca = aVar;
    }

    public void nq(boolean z) {
        if (this.hbV != z) {
            this.hbV = z;
            notifyDataSetChanged();
        }
    }
}
