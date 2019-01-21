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
    private com.baidu.tieba.write.album.c hWG;
    private View.OnClickListener hWI;
    private f hWJ;
    private g hWK;
    private TbCameraView.c hWL;
    private TbCameraView.a hWM;
    private a hWN;
    private AlbumActivity hWm;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fOd = false;
    private boolean hWH = true;

    public TbCameraView bPl() {
        if (this.hWN != null) {
            return this.hWN.hWP;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hWm = albumActivity;
        this.hWG = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hWm.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hWH) {
            this.mDataList.add(bPm());
        }
        if (!v.I(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bPm() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xt */
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
            if (this.hWN == null || this.hWN.hWP == null) {
                this.hWN = new a();
                View inflate = this.mLayoutInflater.inflate(e.h.album_make_picture_view, viewGroup, false);
                this.hWN.rootView = inflate;
                this.hWN.hWP = (TbCameraView) inflate.findViewById(e.g.camera_surfaceview);
                this.hWN.hWO = (TbImageView) inflate.findViewById(e.g.icon_make_photo);
                this.hWN.hWO.setDefaultResource(0);
                this.hWN.hWO.setDefaultErrorResource(0);
                this.hWN.hWO.setGifIconSupport(false);
                this.hWN.hWO.setLongIconSupport(false);
                inflate.setTag(this.hWN);
                this.hWm.showTip(this.hWN.hWO);
            }
            this.hWN.hWP.setOnRequestPermissionListener(this.hWL);
            this.hWN.hWP.setOnOpenCameraFailedListener(this.hWM);
            this.hWN.hWO.setOnClickListener(this.hWI);
            this.hWN.hWP.setOnClickListener(this.hWI);
            this.hWN.rootView.setOnClickListener(this.hWI);
            al.c(this.hWN.hWO, e.f.icon_album_camera);
            al.j(this.hWN.rootView, e.d.black_alpha90);
            return this.hWN.rootView;
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
                dVar2.dva = (TbImageView) view.findViewById(e.g.pic);
                dVar2.dva.setDefaultResource(0);
                dVar2.dva.setDefaultErrorResource(0);
                dVar2.dva.setTagPaddingDis(8, 8);
                dVar2.dva.setGifIconSupport(true);
                dVar2.dva.setLongIconSupport(true);
                dVar2.dvb = (ImageView) view.findViewById(e.g.select_icon);
                dVar2.hwx = (RelativeLayout) view.findViewById(e.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.dva.setIsLongPic(imageFileInfo.isLong());
            dVar.dva.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dvb, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.dva.setOnClickListener(bVar);
            dVar.hwx.setOnClickListener(bVar);
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
                cVar2.hWS = (TbImageView) view.findViewById(e.g.video_thumb);
                cVar2.hWS.setDefaultResource(0);
                cVar2.hWS.setDefaultErrorResource(0);
                cVar2.hWS.setTagPaddingDis(8, 8);
                cVar2.hWS.setGifIconSupport(false);
                cVar2.hWS.setLongIconSupport(false);
                cVar2.dvb = (ImageView) view.findViewById(e.g.select_icon);
                cVar2.hWT = (RelativeLayout) view.findViewById(e.g.video_select);
                cVar2.hWU = (TextView) view.findViewById(e.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hWS.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hWU.setText(ao.dV(videoFileInfo.videoDuration));
            a(cVar.dvb, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hWS.setOnClickListener(bVar);
            cVar.hWT.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hWG != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hWG.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hWG != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hWG.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hWm.getResources().getString(e.j.check_box_checked));
                al.c(imageView, e.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hWm.getResources().getString(e.j.check_box_not_checked));
            al.c(imageView, e.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hWR;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hWR = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.g.pic) {
                if (h.this.hWJ != null && this.hWR != null) {
                    h.this.hWJ.a(this.position, this.hWR);
                }
            } else if (view.getId() == e.g.lay_select) {
                if (this.hWR != null && h.this.hWK != null) {
                    h.this.hWK.b(this.position, this.hWR);
                }
            } else if (view.getId() == e.g.video_thumb) {
                if (h.this.hWJ != null && this.hWR != null) {
                    h.this.hWJ.a(this.position, this.hWR);
                }
            } else if (view.getId() == e.g.video_select && this.hWR != null && h.this.hWK != null) {
                h.this.hWK.b(this.position, this.hWR);
            }
        }
    }

    public boolean isScroll() {
        return this.fOd;
    }

    public void kj(boolean z) {
        this.fOd = z;
    }

    public void a(f fVar) {
        this.hWJ = fVar;
    }

    public void a(g gVar) {
        this.hWK = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hWO;
        TbCameraView hWP;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView dva;
        ImageView dvb;
        RelativeLayout hwx;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView dvb;
        TbImageView hWS;
        RelativeLayout hWT;
        TextView hWU;
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
        this.hWI = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hWL = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hWM = aVar;
    }

    public void oC(boolean z) {
        if (this.hWH != z) {
            this.hWH = z;
            notifyDataSetChanged();
        }
    }
}
