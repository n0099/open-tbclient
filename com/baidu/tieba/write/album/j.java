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
    private e hNF;
    private View.OnClickListener hNH;
    private h hNI;
    private i hNJ;
    private TbCameraView.c hNK;
    private TbCameraView.a hNL;
    private a hNM;
    private AlbumActivity hNl;
    private LayoutInflater kh;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fwt = false;
    private boolean hNG = true;

    public TbCameraView bMf() {
        if (this.hNM != null) {
            return this.hNM.hNO;
        }
        return null;
    }

    public j(AlbumActivity albumActivity, e eVar) {
        this.hNl = albumActivity;
        this.hNF = eVar;
        this.kh = LayoutInflater.from(this.hNl.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hNG) {
            this.mDataList.add(bMg());
        }
        if (!v.G(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bMg() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.F(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yL */
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
            if (this.hNM == null || this.hNM.hNO == null) {
                this.hNM = new a();
                View inflate = this.kh.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.hNM.rootView = inflate;
                this.hNM.hNO = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hNM.hNN = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hNM.hNN.setDefaultResource(0);
                this.hNM.hNN.setDefaultErrorResource(0);
                this.hNM.hNN.setGifIconSupport(false);
                this.hNM.hNN.setLongIconSupport(false);
                inflate.setTag(this.hNM);
                this.hNl.showTip(this.hNM.hNN);
            }
            this.hNM.hNO.setOnRequestPermissionListener(this.hNK);
            this.hNM.hNO.setOnOpenCameraFailedListener(this.hNL);
            this.hNM.hNN.setOnClickListener(this.hNH);
            this.hNM.hNO.setOnClickListener(this.hNH);
            this.hNM.rootView.setOnClickListener(this.hNH);
            aj.c(this.hNM.hNN, d.f.icon_album_camera);
            aj.t(this.hNM.rootView, d.C0108d.black_alpha90);
            return this.hNM.rootView;
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
                dVar2.dkA = (TbImageView) view.findViewById(d.g.pic);
                dVar2.dkA.setDefaultResource(0);
                dVar2.dkA.setDefaultErrorResource(0);
                dVar2.dkA.setTagPaddingDis(8, 8);
                dVar2.dkA.setGifIconSupport(true);
                dVar2.dkA.setLongIconSupport(true);
                dVar2.dkB = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.hoa = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.dkA.setIsLongPic(imageFileInfo.isLong());
            dVar.dkA.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dkB, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.dkA.setOnClickListener(bVar);
            dVar.hoa.setOnClickListener(bVar);
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
                cVar2.hNR = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hNR.setDefaultResource(0);
                cVar2.hNR.setDefaultErrorResource(0);
                cVar2.hNR.setTagPaddingDis(8, 8);
                cVar2.hNR.setGifIconSupport(false);
                cVar2.hNR.setLongIconSupport(false);
                cVar2.dkB = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hNS = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hNT = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hNR.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hNT.setText(am.fX(videoFileInfo.videoDuration));
            a(cVar.dkB, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hNR.setOnClickListener(bVar);
            cVar.hNS.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hNF != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hNF.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hNF != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hNF.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hNl.getResources().getString(d.j.check_box_checked));
                aj.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hNl.getResources().getString(d.j.check_box_not_checked));
            aj.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hNQ;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hNQ = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (j.this.hNI != null && this.hNQ != null) {
                    j.this.hNI.a(this.position, this.hNQ);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hNQ != null && j.this.hNJ != null) {
                    j.this.hNJ.b(this.position, this.hNQ);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (j.this.hNI != null && this.hNQ != null) {
                    j.this.hNI.a(this.position, this.hNQ);
                }
            } else if (view.getId() == d.g.video_select && this.hNQ != null && j.this.hNJ != null) {
                j.this.hNJ.b(this.position, this.hNQ);
            }
        }
    }

    public boolean isScroll() {
        return this.fwt;
    }

    public void jm(boolean z) {
        this.fwt = z;
    }

    public void a(h hVar) {
        this.hNI = hVar;
    }

    public void a(i iVar) {
        this.hNJ = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView hNN;
        TbCameraView hNO;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        TbImageView dkA;
        ImageView dkB;
        RelativeLayout hoa;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView dkB;
        TbImageView hNR;
        RelativeLayout hNS;
        TextView hNT;
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
        this.hNH = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hNK = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hNL = aVar;
    }

    public void ou(boolean z) {
        if (this.hNG != z) {
            this.hNG = z;
            notifyDataSetChanged();
        }
    }
}
