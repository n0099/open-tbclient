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
    private AlbumActivity hBK;
    private com.baidu.tieba.write.album.c hCe;
    private View.OnClickListener hCg;
    private f hCh;
    private g hCi;
    private TbCameraView.c hCj;
    private TbCameraView.a hCk;
    private a hCl;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fuz = false;
    private boolean hCf = true;

    public TbCameraView bIW() {
        if (this.hCl != null) {
            return this.hCl.hCn;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hBK = albumActivity;
        this.hCe = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hBK.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hCf) {
            this.mDataList.add(bIX());
        }
        if (!v.z(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bIX() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.y(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vR */
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
            if (this.hCl == null || this.hCl.hCn == null) {
                this.hCl = new a();
                View inflate = this.mLayoutInflater.inflate(e.h.album_make_picture_view, viewGroup, false);
                this.hCl.rootView = inflate;
                this.hCl.hCn = (TbCameraView) inflate.findViewById(e.g.camera_surfaceview);
                this.hCl.hCm = (TbImageView) inflate.findViewById(e.g.icon_make_photo);
                this.hCl.hCm.setDefaultResource(0);
                this.hCl.hCm.setDefaultErrorResource(0);
                this.hCl.hCm.setGifIconSupport(false);
                this.hCl.hCm.setLongIconSupport(false);
                inflate.setTag(this.hCl);
                this.hBK.showTip(this.hCl.hCm);
            }
            this.hCl.hCn.setOnRequestPermissionListener(this.hCj);
            this.hCl.hCn.setOnOpenCameraFailedListener(this.hCk);
            this.hCl.hCm.setOnClickListener(this.hCg);
            this.hCl.hCn.setOnClickListener(this.hCg);
            this.hCl.rootView.setOnClickListener(this.hCg);
            al.c(this.hCl.hCm, e.f.icon_album_camera);
            al.j(this.hCl.rootView, e.d.black_alpha90);
            return this.hCl.rootView;
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
                dVar2.dbL = (TbImageView) view.findViewById(e.g.pic);
                dVar2.dbL.setDefaultResource(0);
                dVar2.dbL.setDefaultErrorResource(0);
                dVar2.dbL.setTagPaddingDis(8, 8);
                dVar2.dbL.setGifIconSupport(true);
                dVar2.dbL.setLongIconSupport(true);
                dVar2.dbM = (ImageView) view.findViewById(e.g.select_icon);
                dVar2.hbP = (RelativeLayout) view.findViewById(e.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.dbL.setIsLongPic(imageFileInfo.isLong());
            dVar.dbL.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dbM, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.dbL.setOnClickListener(bVar);
            dVar.hbP.setOnClickListener(bVar);
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
                cVar2.hCq = (TbImageView) view.findViewById(e.g.video_thumb);
                cVar2.hCq.setDefaultResource(0);
                cVar2.hCq.setDefaultErrorResource(0);
                cVar2.hCq.setTagPaddingDis(8, 8);
                cVar2.hCq.setGifIconSupport(false);
                cVar2.hCq.setLongIconSupport(false);
                cVar2.dbM = (ImageView) view.findViewById(e.g.select_icon);
                cVar2.hCr = (RelativeLayout) view.findViewById(e.g.video_select);
                cVar2.hCs = (TextView) view.findViewById(e.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hCq.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hCs.setText(ao.dj(videoFileInfo.videoDuration));
            a(cVar.dbM, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hCq.setOnClickListener(bVar);
            cVar.hCr.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hCe != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hCe.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hCe != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hCe.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hBK.getResources().getString(e.j.check_box_checked));
                al.c(imageView, e.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hBK.getResources().getString(e.j.check_box_not_checked));
            al.c(imageView, e.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hCp;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hCp = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.g.pic) {
                if (h.this.hCh != null && this.hCp != null) {
                    h.this.hCh.a(this.position, this.hCp);
                }
            } else if (view.getId() == e.g.lay_select) {
                if (this.hCp != null && h.this.hCi != null) {
                    h.this.hCi.b(this.position, this.hCp);
                }
            } else if (view.getId() == e.g.video_thumb) {
                if (h.this.hCh != null && this.hCp != null) {
                    h.this.hCh.a(this.position, this.hCp);
                }
            } else if (view.getId() == e.g.video_select && this.hCp != null && h.this.hCi != null) {
                h.this.hCi.b(this.position, this.hCp);
            }
        }
    }

    public boolean isScroll() {
        return this.fuz;
    }

    public void jC(boolean z) {
        this.fuz = z;
    }

    public void a(f fVar) {
        this.hCh = fVar;
    }

    public void a(g gVar) {
        this.hCi = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hCm;
        TbCameraView hCn;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView dbL;
        ImageView dbM;
        RelativeLayout hbP;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView dbM;
        TbImageView hCq;
        RelativeLayout hCr;
        TextView hCs;
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
        this.hCg = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hCj = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hCk = aVar;
    }

    public void nS(boolean z) {
        if (this.hCf != z) {
            this.hCf = z;
            notifyDataSetChanged();
        }
    }
}
