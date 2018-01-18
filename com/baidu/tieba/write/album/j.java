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
    private AlbumActivity hCT;
    private e hDn;
    private View.OnClickListener hDp;
    private h hDq;
    private i hDr;
    private TbCameraView.c hDs;
    private TbCameraView.a hDt;
    private a hDu;
    private LayoutInflater kh;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fxT = false;
    private boolean hDo = true;

    public TbCameraView bFF() {
        if (this.hDu != null) {
            return this.hDu.hDw;
        }
        return null;
    }

    public j(AlbumActivity albumActivity, e eVar) {
        this.hCT = albumActivity;
        this.hDn = eVar;
        this.kh = LayoutInflater.from(this.hCT.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hDo) {
            this.mDataList.add(bFG());
        }
        if (!v.E(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bFG() {
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
            if (this.hDu == null || this.hDu.hDw == null) {
                this.hDu = new a();
                View inflate = this.kh.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.hDu.rootView = inflate;
                this.hDu.hDw = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hDu.hDv = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hDu.hDv.setDefaultResource(0);
                this.hDu.hDv.setDefaultErrorResource(0);
                this.hDu.hDv.setGifIconSupport(false);
                this.hDu.hDv.setLongIconSupport(false);
                inflate.setTag(this.hDu);
                this.hCT.showTip(this.hDu.hDv);
            }
            this.hDu.hDw.setOnRequestPermissionListener(this.hDs);
            this.hDu.hDw.setOnOpenCameraFailedListener(this.hDt);
            this.hDu.hDv.setOnClickListener(this.hDp);
            this.hDu.hDw.setOnClickListener(this.hDp);
            this.hDu.rootView.setOnClickListener(this.hDp);
            aj.c(this.hDu.hDv, d.f.icon_album_camera);
            aj.t(this.hDu.rootView, d.C0107d.black_alpha90);
            return this.hDu.rootView;
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
                dVar2.dpb = (TbImageView) view.findViewById(d.g.pic);
                dVar2.dpb.setDefaultResource(0);
                dVar2.dpb.setDefaultErrorResource(0);
                dVar2.dpb.setTagPaddingDis(8, 8);
                dVar2.dpb.setGifIconSupport(true);
                dVar2.dpb.setLongIconSupport(true);
                dVar2.dpc = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.hdC = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.dpb.setIsLongPic(imageFileInfo.isLong());
            dVar.dpb.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dpc, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.dpb.setOnClickListener(bVar);
            dVar.hdC.setOnClickListener(bVar);
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
                cVar2.hDz = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hDz.setDefaultResource(0);
                cVar2.hDz.setDefaultErrorResource(0);
                cVar2.hDz.setTagPaddingDis(8, 8);
                cVar2.hDz.setGifIconSupport(false);
                cVar2.hDz.setLongIconSupport(false);
                cVar2.dpc = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hDA = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hDB = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hDz.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hDB.setText(am.fV(videoFileInfo.videoDuration));
            a(cVar.dpc, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hDz.setOnClickListener(bVar);
            cVar.hDA.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hDn != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hDn.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hDn != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hDn.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hCT.getResources().getString(d.j.check_box_checked));
                aj.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hCT.getResources().getString(d.j.check_box_not_checked));
            aj.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hDy;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hDy = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (j.this.hDq != null && this.hDy != null) {
                    j.this.hDq.a(this.position, this.hDy);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hDy != null && j.this.hDr != null) {
                    j.this.hDr.b(this.position, this.hDy);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (j.this.hDq != null && this.hDy != null) {
                    j.this.hDq.a(this.position, this.hDy);
                }
            } else if (view.getId() == d.g.video_select && this.hDy != null && j.this.hDr != null) {
                j.this.hDr.b(this.position, this.hDy);
            }
        }
    }

    public boolean isScroll() {
        return this.fxT;
    }

    public void jp(boolean z) {
        this.fxT = z;
    }

    public void a(h hVar) {
        this.hDq = hVar;
    }

    public void a(i iVar) {
        this.hDr = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView hDv;
        TbCameraView hDw;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        TbImageView dpb;
        ImageView dpc;
        RelativeLayout hdC;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView dpc;
        RelativeLayout hDA;
        TextView hDB;
        TbImageView hDz;
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
        this.hDp = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hDs = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hDt = aVar;
    }

    public void nx(boolean z) {
        if (this.hDo != z) {
            this.hDo = z;
            notifyDataSetChanged();
        }
    }
}
