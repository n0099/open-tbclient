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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends BaseAdapter {
    private AlbumActivity hEV;
    private e hFp;
    private View.OnClickListener hFr;
    private h hFs;
    private i hFt;
    private TbCameraView.c hFu;
    private TbCameraView.a hFv;
    private a hFw;
    private LayoutInflater kh;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fBS = false;
    private boolean hFq = true;

    public TbCameraView bGz() {
        if (this.hFw != null) {
            return this.hFw.hFy;
        }
        return null;
    }

    public j(AlbumActivity albumActivity, e eVar) {
        this.hEV = albumActivity;
        this.hFp = eVar;
        this.kh = LayoutInflater.from(this.hEV.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hFq) {
            this.mDataList.add(bGA());
        }
        if (!v.E(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bGA() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.D(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xo */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) v.f(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.f(this.mDataList, i);
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
            if (this.hFw == null || this.hFw.hFy == null) {
                this.hFw = new a();
                View inflate = this.kh.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.hFw.rootView = inflate;
                this.hFw.hFy = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hFw.hFx = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hFw.hFx.setDefaultResource(0);
                this.hFw.hFx.setDefaultErrorResource(0);
                this.hFw.hFx.setGifIconSupport(false);
                this.hFw.hFx.setLongIconSupport(false);
                inflate.setTag(this.hFw);
                this.hEV.showTip(this.hFw.hFx);
            }
            this.hFw.hFy.setOnRequestPermissionListener(this.hFu);
            this.hFw.hFy.setOnOpenCameraFailedListener(this.hFv);
            this.hFw.hFx.setOnClickListener(this.hFr);
            this.hFw.hFy.setOnClickListener(this.hFr);
            this.hFw.rootView.setOnClickListener(this.hFr);
            aj.c(this.hFw.hFx, d.f.icon_album_camera);
            aj.t(this.hFw.rootView, d.C0141d.black_alpha90);
            return this.hFw.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.kh.inflate(d.h.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.dsg = (TbImageView) view.findViewById(d.g.pic);
                dVar2.dsg.setDefaultResource(0);
                dVar2.dsg.setDefaultErrorResource(0);
                dVar2.dsg.setTagPaddingDis(8, 8);
                dVar2.dsg.setGifIconSupport(true);
                dVar2.dsg.setLongIconSupport(true);
                dVar2.dsh = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.hgu = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.dsg.setIsLongPic(imageFileInfo.isLong());
            dVar.dsg.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dsh, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.dsg.setOnClickListener(bVar);
            dVar.hgu.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.kh.inflate(d.h.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.hFB = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hFB.setDefaultResource(0);
                cVar2.hFB.setDefaultErrorResource(0);
                cVar2.hFB.setTagPaddingDis(8, 8);
                cVar2.hFB.setGifIconSupport(false);
                cVar2.hFB.setLongIconSupport(false);
                cVar2.dsh = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hFC = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hFD = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hFB.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hFD.setText(am.fV(videoFileInfo.videoDuration));
            a(cVar.dsh, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hFB.setOnClickListener(bVar);
            cVar.hFC.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hFp != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hFp.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hFp != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hFp.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hEV.getResources().getString(d.j.check_box_checked));
                aj.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hEV.getResources().getString(d.j.check_box_not_checked));
            aj.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hFA;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hFA = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (j.this.hFs != null && this.hFA != null) {
                    j.this.hFs.a(this.position, this.hFA);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hFA != null && j.this.hFt != null) {
                    j.this.hFt.b(this.position, this.hFA);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (j.this.hFs != null && this.hFA != null) {
                    j.this.hFs.a(this.position, this.hFA);
                }
            } else if (view.getId() == d.g.video_select && this.hFA != null && j.this.hFt != null) {
                j.this.hFt.b(this.position, this.hFA);
            }
        }
    }

    public boolean isScroll() {
        return this.fBS;
    }

    public void jG(boolean z) {
        this.fBS = z;
    }

    public void a(h hVar) {
        this.hFs = hVar;
    }

    public void a(i iVar) {
        this.hFt = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView hFx;
        TbCameraView hFy;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        TbImageView dsg;
        ImageView dsh;
        RelativeLayout hgu;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView dsh;
        TbImageView hFB;
        RelativeLayout hFC;
        TextView hFD;
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

    public void T(View.OnClickListener onClickListener) {
        this.hFr = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hFu = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hFv = aVar;
    }

    public void nM(boolean z) {
        if (this.hFq != z) {
            this.hFq = z;
            notifyDataSetChanged();
        }
    }
}
