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
    private e hDH;
    private View.OnClickListener hDJ;
    private h hDK;
    private i hDL;
    private TbCameraView.c hDM;
    private TbCameraView.a hDN;
    private a hDO;
    private AlbumActivity hDn;
    private LayoutInflater kh;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fyo = false;
    private boolean hDI = true;

    public TbCameraView bFH() {
        if (this.hDO != null) {
            return this.hDO.hDQ;
        }
        return null;
    }

    public j(AlbumActivity albumActivity, e eVar) {
        this.hDn = albumActivity;
        this.hDH = eVar;
        this.kh = LayoutInflater.from(this.hDn.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hDI) {
            this.mDataList.add(bFI());
        }
        if (!v.E(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bFI() {
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
            if (this.hDO == null || this.hDO.hDQ == null) {
                this.hDO = new a();
                View inflate = this.kh.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.hDO.rootView = inflate;
                this.hDO.hDQ = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hDO.hDP = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hDO.hDP.setDefaultResource(0);
                this.hDO.hDP.setDefaultErrorResource(0);
                this.hDO.hDP.setGifIconSupport(false);
                this.hDO.hDP.setLongIconSupport(false);
                inflate.setTag(this.hDO);
                this.hDn.showTip(this.hDO.hDP);
            }
            this.hDO.hDQ.setOnRequestPermissionListener(this.hDM);
            this.hDO.hDQ.setOnOpenCameraFailedListener(this.hDN);
            this.hDO.hDP.setOnClickListener(this.hDJ);
            this.hDO.hDQ.setOnClickListener(this.hDJ);
            this.hDO.rootView.setOnClickListener(this.hDJ);
            aj.c(this.hDO.hDP, d.f.icon_album_camera);
            aj.t(this.hDO.rootView, d.C0108d.black_alpha90);
            return this.hDO.rootView;
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
                dVar2.dpw = (TbImageView) view.findViewById(d.g.pic);
                dVar2.dpw.setDefaultResource(0);
                dVar2.dpw.setDefaultErrorResource(0);
                dVar2.dpw.setTagPaddingDis(8, 8);
                dVar2.dpw.setGifIconSupport(true);
                dVar2.dpw.setLongIconSupport(true);
                dVar2.dpx = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.hdW = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.dpw.setIsLongPic(imageFileInfo.isLong());
            dVar.dpw.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dpx, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.dpw.setOnClickListener(bVar);
            dVar.hdW.setOnClickListener(bVar);
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
                cVar2.hDT = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hDT.setDefaultResource(0);
                cVar2.hDT.setDefaultErrorResource(0);
                cVar2.hDT.setTagPaddingDis(8, 8);
                cVar2.hDT.setGifIconSupport(false);
                cVar2.hDT.setLongIconSupport(false);
                cVar2.dpx = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hDU = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hDV = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hDT.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hDV.setText(am.fV(videoFileInfo.videoDuration));
            a(cVar.dpx, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hDT.setOnClickListener(bVar);
            cVar.hDU.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hDH != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hDH.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hDH != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hDH.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hDn.getResources().getString(d.j.check_box_checked));
                aj.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hDn.getResources().getString(d.j.check_box_not_checked));
            aj.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hDS;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hDS = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (j.this.hDK != null && this.hDS != null) {
                    j.this.hDK.a(this.position, this.hDS);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hDS != null && j.this.hDL != null) {
                    j.this.hDL.b(this.position, this.hDS);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (j.this.hDK != null && this.hDS != null) {
                    j.this.hDK.a(this.position, this.hDS);
                }
            } else if (view.getId() == d.g.video_select && this.hDS != null && j.this.hDL != null) {
                j.this.hDL.b(this.position, this.hDS);
            }
        }
    }

    public boolean isScroll() {
        return this.fyo;
    }

    public void jr(boolean z) {
        this.fyo = z;
    }

    public void a(h hVar) {
        this.hDK = hVar;
    }

    public void a(i iVar) {
        this.hDL = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView hDP;
        TbCameraView hDQ;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        TbImageView dpw;
        ImageView dpx;
        RelativeLayout hdW;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView dpx;
        TbImageView hDT;
        RelativeLayout hDU;
        TextView hDV;
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
        this.hDJ = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hDM = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hDN = aVar;
    }

    public void nz(boolean z) {
        if (this.hDI != z) {
            this.hDI = z;
            notifyDataSetChanged();
        }
    }
}
