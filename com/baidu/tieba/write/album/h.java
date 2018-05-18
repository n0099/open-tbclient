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
    private AlbumActivity hcB;
    private com.baidu.tieba.write.album.c hcV;
    private View.OnClickListener hcX;
    private f hcY;
    private g hcZ;
    private TbCameraView.c hda;
    private TbCameraView.a hdb;
    private a hdc;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean eXG = false;
    private boolean hcW = true;

    public TbCameraView bBK() {
        if (this.hdc != null) {
            return this.hdc.hde;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hcB = albumActivity;
        this.hcV = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hcB.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hcW) {
            this.mDataList.add(bBL());
        }
        if (!v.w(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bBL() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uR */
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
            if (this.hdc == null || this.hdc.hde == null) {
                this.hdc = new a();
                View inflate = this.mLayoutInflater.inflate(d.i.album_make_picture_view, viewGroup, false);
                this.hdc.rootView = inflate;
                this.hdc.hde = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hdc.hdd = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hdc.hdd.setDefaultResource(0);
                this.hdc.hdd.setDefaultErrorResource(0);
                this.hdc.hdd.setGifIconSupport(false);
                this.hdc.hdd.setLongIconSupport(false);
                inflate.setTag(this.hdc);
                this.hcB.showTip(this.hdc.hdd);
            }
            this.hdc.hde.setOnRequestPermissionListener(this.hda);
            this.hdc.hde.setOnOpenCameraFailedListener(this.hdb);
            this.hdc.hdd.setOnClickListener(this.hcX);
            this.hdc.hde.setOnClickListener(this.hcX);
            this.hdc.rootView.setOnClickListener(this.hcX);
            ak.c(this.hdc.hdd, d.f.icon_album_camera);
            ak.j(this.hdc.rootView, d.C0126d.black_alpha90);
            return this.hdc.rootView;
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
                dVar2.cMb = (TbImageView) view2.findViewById(d.g.pic);
                dVar2.cMb.setDefaultResource(0);
                dVar2.cMb.setDefaultErrorResource(0);
                dVar2.cMb.setTagPaddingDis(8, 8);
                dVar2.cMb.setGifIconSupport(true);
                dVar2.cMb.setLongIconSupport(true);
                dVar2.cMc = (ImageView) view2.findViewById(d.g.select_icon);
                dVar2.gCZ = (RelativeLayout) view2.findViewById(d.g.lay_select);
                view2.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view2.getTag();
            }
            dVar.cMb.setIsLongPic(imageFileInfo.isLong());
            dVar.cMb.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cMc, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cMb.setOnClickListener(bVar);
            dVar.gCZ.setOnClickListener(bVar);
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
                cVar2.hdh = (TbImageView) view2.findViewById(d.g.video_thumb);
                cVar2.hdh.setDefaultResource(0);
                cVar2.hdh.setDefaultErrorResource(0);
                cVar2.hdh.setTagPaddingDis(8, 8);
                cVar2.hdh.setGifIconSupport(false);
                cVar2.hdh.setLongIconSupport(false);
                cVar2.cMc = (ImageView) view2.findViewById(d.g.select_icon);
                cVar2.hdi = (RelativeLayout) view2.findViewById(d.g.video_select);
                cVar2.hdj = (TextView) view2.findViewById(d.g.video_play_time);
                view2.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view2.getTag();
            }
            cVar.hdh.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hdj.setText(an.cV(videoFileInfo.videoDuration));
            a(cVar.cMc, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hdh.setOnClickListener(bVar);
            cVar.hdi.setOnClickListener(bVar);
        }
        return view2;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hcV != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hcV.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hcV != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hcV.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hcB.getResources().getString(d.k.check_box_checked));
                ak.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hcB.getResources().getString(d.k.check_box_not_checked));
            ak.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hdg;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hdg = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getId() == d.g.pic) {
                if (h.this.hcY != null && this.hdg != null) {
                    h.this.hcY.a(this.position, this.hdg);
                }
            } else if (view2.getId() == d.g.lay_select) {
                if (this.hdg != null && h.this.hcZ != null) {
                    h.this.hcZ.b(this.position, this.hdg);
                }
            } else if (view2.getId() == d.g.video_thumb) {
                if (h.this.hcY != null && this.hdg != null) {
                    h.this.hcY.a(this.position, this.hdg);
                }
            } else if (view2.getId() == d.g.video_select && this.hdg != null && h.this.hcZ != null) {
                h.this.hcZ.b(this.position, this.hdg);
            }
        }
    }

    public boolean isScroll() {
        return this.eXG;
    }

    public void jd(boolean z) {
        this.eXG = z;
    }

    public void a(f fVar) {
        this.hcY = fVar;
    }

    public void a(g gVar) {
        this.hcZ = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hdd;
        TbCameraView hde;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView cMb;
        ImageView cMc;
        RelativeLayout gCZ;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView cMc;
        TbImageView hdh;
        RelativeLayout hdi;
        TextView hdj;
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
        this.hcX = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hda = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hdb = aVar;
    }

    public void nr(boolean z) {
        if (this.hcW != z) {
            this.hcW = z;
            notifyDataSetChanged();
        }
    }
}
