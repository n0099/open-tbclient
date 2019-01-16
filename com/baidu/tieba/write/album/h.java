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
    private com.baidu.tieba.write.album.c hWF;
    private View.OnClickListener hWH;
    private f hWI;
    private g hWJ;
    private TbCameraView.c hWK;
    private TbCameraView.a hWL;
    private a hWM;
    private AlbumActivity hWl;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fOc = false;
    private boolean hWG = true;

    public TbCameraView bPl() {
        if (this.hWM != null) {
            return this.hWM.hWO;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.hWl = albumActivity;
        this.hWF = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.hWl.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hWG) {
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
            if (this.hWM == null || this.hWM.hWO == null) {
                this.hWM = new a();
                View inflate = this.mLayoutInflater.inflate(e.h.album_make_picture_view, viewGroup, false);
                this.hWM.rootView = inflate;
                this.hWM.hWO = (TbCameraView) inflate.findViewById(e.g.camera_surfaceview);
                this.hWM.hWN = (TbImageView) inflate.findViewById(e.g.icon_make_photo);
                this.hWM.hWN.setDefaultResource(0);
                this.hWM.hWN.setDefaultErrorResource(0);
                this.hWM.hWN.setGifIconSupport(false);
                this.hWM.hWN.setLongIconSupport(false);
                inflate.setTag(this.hWM);
                this.hWl.showTip(this.hWM.hWN);
            }
            this.hWM.hWO.setOnRequestPermissionListener(this.hWK);
            this.hWM.hWO.setOnOpenCameraFailedListener(this.hWL);
            this.hWM.hWN.setOnClickListener(this.hWH);
            this.hWM.hWO.setOnClickListener(this.hWH);
            this.hWM.rootView.setOnClickListener(this.hWH);
            al.c(this.hWM.hWN, e.f.icon_album_camera);
            al.j(this.hWM.rootView, e.d.black_alpha90);
            return this.hWM.rootView;
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
                dVar2.duZ = (TbImageView) view.findViewById(e.g.pic);
                dVar2.duZ.setDefaultResource(0);
                dVar2.duZ.setDefaultErrorResource(0);
                dVar2.duZ.setTagPaddingDis(8, 8);
                dVar2.duZ.setGifIconSupport(true);
                dVar2.duZ.setLongIconSupport(true);
                dVar2.dva = (ImageView) view.findViewById(e.g.select_icon);
                dVar2.hww = (RelativeLayout) view.findViewById(e.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.duZ.setIsLongPic(imageFileInfo.isLong());
            dVar.duZ.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dva, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.duZ.setOnClickListener(bVar);
            dVar.hww.setOnClickListener(bVar);
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
                cVar2.hWR = (TbImageView) view.findViewById(e.g.video_thumb);
                cVar2.hWR.setDefaultResource(0);
                cVar2.hWR.setDefaultErrorResource(0);
                cVar2.hWR.setTagPaddingDis(8, 8);
                cVar2.hWR.setGifIconSupport(false);
                cVar2.hWR.setLongIconSupport(false);
                cVar2.dva = (ImageView) view.findViewById(e.g.select_icon);
                cVar2.hWS = (RelativeLayout) view.findViewById(e.g.video_select);
                cVar2.hWT = (TextView) view.findViewById(e.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hWR.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hWT.setText(ao.dV(videoFileInfo.videoDuration));
            a(cVar.dva, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hWR.setOnClickListener(bVar);
            cVar.hWS.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hWF != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hWF.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hWF != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hWF.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hWl.getResources().getString(e.j.check_box_checked));
                al.c(imageView, e.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hWl.getResources().getString(e.j.check_box_not_checked));
            al.c(imageView, e.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hWQ;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hWQ = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == e.g.pic) {
                if (h.this.hWI != null && this.hWQ != null) {
                    h.this.hWI.a(this.position, this.hWQ);
                }
            } else if (view.getId() == e.g.lay_select) {
                if (this.hWQ != null && h.this.hWJ != null) {
                    h.this.hWJ.b(this.position, this.hWQ);
                }
            } else if (view.getId() == e.g.video_thumb) {
                if (h.this.hWI != null && this.hWQ != null) {
                    h.this.hWI.a(this.position, this.hWQ);
                }
            } else if (view.getId() == e.g.video_select && this.hWQ != null && h.this.hWJ != null) {
                h.this.hWJ.b(this.position, this.hWQ);
            }
        }
    }

    public boolean isScroll() {
        return this.fOc;
    }

    public void kj(boolean z) {
        this.fOc = z;
    }

    public void a(f fVar) {
        this.hWI = fVar;
    }

    public void a(g gVar) {
        this.hWJ = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView hWN;
        TbCameraView hWO;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView duZ;
        ImageView dva;
        RelativeLayout hww;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView dva;
        TbImageView hWR;
        RelativeLayout hWS;
        TextView hWT;
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
        this.hWH = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hWK = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hWL = aVar;
    }

    public void oC(boolean z) {
        if (this.hWG != z) {
            this.hWG = z;
            notifyDataSetChanged();
        }
    }
}
