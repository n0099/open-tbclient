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
    private com.baidu.tieba.write.album.c hbR;
    private View.OnClickListener hbT;
    private f hbU;
    private g hbV;
    private TbCameraView.c hbW;
    private TbCameraView.a hbX;
    private a hbY;
    private AlbumActivity hbx;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean eWz = false;
    private boolean hbS = true;

    public TbCameraView bBM() {
        if (this.hbY != null) {
            return this.hbY.hca;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hbx = albumActivity;
        this.hbR = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hbx.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hbS) {
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
            if (this.hbY == null || this.hbY.hca == null) {
                this.hbY = new a();
                View inflate = this.mLayoutInflater.inflate(d.i.album_make_picture_view, viewGroup, false);
                this.hbY.rootView = inflate;
                this.hbY.hca = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hbY.hbZ = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hbY.hbZ.setDefaultResource(0);
                this.hbY.hbZ.setDefaultErrorResource(0);
                this.hbY.hbZ.setGifIconSupport(false);
                this.hbY.hbZ.setLongIconSupport(false);
                inflate.setTag(this.hbY);
                this.hbx.showTip(this.hbY.hbZ);
            }
            this.hbY.hca.setOnRequestPermissionListener(this.hbW);
            this.hbY.hca.setOnOpenCameraFailedListener(this.hbX);
            this.hbY.hbZ.setOnClickListener(this.hbT);
            this.hbY.hca.setOnClickListener(this.hbT);
            this.hbY.rootView.setOnClickListener(this.hbT);
            ak.c(this.hbY.hbZ, d.f.icon_album_camera);
            ak.j(this.hbY.rootView, d.C0126d.black_alpha90);
            return this.hbY.rootView;
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
                dVar2.cKU = (TbImageView) view2.findViewById(d.g.pic);
                dVar2.cKU.setDefaultResource(0);
                dVar2.cKU.setDefaultErrorResource(0);
                dVar2.cKU.setTagPaddingDis(8, 8);
                dVar2.cKU.setGifIconSupport(true);
                dVar2.cKU.setLongIconSupport(true);
                dVar2.cKV = (ImageView) view2.findViewById(d.g.select_icon);
                dVar2.gBW = (RelativeLayout) view2.findViewById(d.g.lay_select);
                view2.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view2.getTag();
            }
            dVar.cKU.setIsLongPic(imageFileInfo.isLong());
            dVar.cKU.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cKV, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cKU.setOnClickListener(bVar);
            dVar.gBW.setOnClickListener(bVar);
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
                cVar2.hcd = (TbImageView) view2.findViewById(d.g.video_thumb);
                cVar2.hcd.setDefaultResource(0);
                cVar2.hcd.setDefaultErrorResource(0);
                cVar2.hcd.setTagPaddingDis(8, 8);
                cVar2.hcd.setGifIconSupport(false);
                cVar2.hcd.setLongIconSupport(false);
                cVar2.cKV = (ImageView) view2.findViewById(d.g.select_icon);
                cVar2.hce = (RelativeLayout) view2.findViewById(d.g.video_select);
                cVar2.hcf = (TextView) view2.findViewById(d.g.video_play_time);
                view2.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view2.getTag();
            }
            cVar.hcd.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hcf.setText(an.cU(videoFileInfo.videoDuration));
            a(cVar.cKV, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hcd.setOnClickListener(bVar);
            cVar.hce.setOnClickListener(bVar);
        }
        return view2;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hbR != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hbR.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hbR != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hbR.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hbx.getResources().getString(d.k.check_box_checked));
                ak.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hbx.getResources().getString(d.k.check_box_not_checked));
            ak.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hcc;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hcc = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getId() == d.g.pic) {
                if (h.this.hbU != null && this.hcc != null) {
                    h.this.hbU.a(this.position, this.hcc);
                }
            } else if (view2.getId() == d.g.lay_select) {
                if (this.hcc != null && h.this.hbV != null) {
                    h.this.hbV.b(this.position, this.hcc);
                }
            } else if (view2.getId() == d.g.video_thumb) {
                if (h.this.hbU != null && this.hcc != null) {
                    h.this.hbU.a(this.position, this.hcc);
                }
            } else if (view2.getId() == d.g.video_select && this.hcc != null && h.this.hbV != null) {
                h.this.hbV.b(this.position, this.hcc);
            }
        }
    }

    public boolean isScroll() {
        return this.eWz;
    }

    public void jc(boolean z) {
        this.eWz = z;
    }

    public void a(f fVar) {
        this.hbU = fVar;
    }

    public void a(g gVar) {
        this.hbV = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hbZ;
        TbCameraView hca;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView cKU;
        ImageView cKV;
        RelativeLayout gBW;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView cKV;
        TbImageView hcd;
        RelativeLayout hce;
        TextView hcf;
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
        this.hbT = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hbW = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hbX = aVar;
    }

    public void nq(boolean z) {
        if (this.hbS != z) {
            this.hbS = z;
            notifyDataSetChanged();
        }
    }
}
