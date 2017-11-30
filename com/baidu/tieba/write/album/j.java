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
    private LayoutInflater hcE;
    private e hcP;
    private View.OnClickListener hcR;
    private h hcS;
    private i hcT;
    private TbCameraView.c hcU;
    private TbCameraView.a hcV;
    private a hcW;
    private AlbumActivity hcu;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean eIP = false;
    private boolean hcQ = true;

    public TbCameraView bFL() {
        if (this.hcW != null) {
            return this.hcW.hcY;
        }
        return null;
    }

    public j(AlbumActivity albumActivity, e eVar) {
        this.hcu = albumActivity;
        this.hcP = eVar;
        this.hcE = LayoutInflater.from(this.hcu.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hcQ) {
            this.mDataList.add(bFM());
        }
        if (!v.w(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bFM() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vI */
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
            if (this.hcW == null || this.hcW.hcY == null) {
                this.hcW = new a();
                View inflate = this.hcE.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.hcW.rootView = inflate;
                this.hcW.hcY = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hcW.hcX = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hcW.hcX.setDefaultResource(0);
                this.hcW.hcX.setDefaultErrorResource(0);
                this.hcW.hcX.setGifIconSupport(false);
                this.hcW.hcX.setLongIconSupport(false);
                inflate.setTag(this.hcW);
                this.hcu.showTip(this.hcW.hcX);
            }
            this.hcW.hcY.setOnRequestPermissionListener(this.hcU);
            this.hcW.hcY.setOnOpenCameraFailedListener(this.hcV);
            this.hcW.hcX.setOnClickListener(this.hcR);
            this.hcW.hcY.setOnClickListener(this.hcR);
            this.hcW.rootView.setOnClickListener(this.hcR);
            aj.c(this.hcW.hcX, d.f.icon_album_camera);
            aj.k(this.hcW.rootView, d.C0082d.black_alpha90);
            return this.hcW.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.hcE.inflate(d.h.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.cvR = (TbImageView) view.findViewById(d.g.pic);
                dVar2.cvR.setDefaultResource(0);
                dVar2.cvR.setDefaultErrorResource(0);
                dVar2.cvR.setTagPaddingDis(8, 8);
                dVar2.cvR.setGifIconSupport(true);
                dVar2.cvR.setLongIconSupport(true);
                dVar2.cvS = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.gEz = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.cvR.setIsLongPic(imageFileInfo.isLong());
            dVar.cvR.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cvS, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cvR.setOnClickListener(bVar);
            dVar.gEz.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.hcE.inflate(d.h.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.hdb = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hdb.setDefaultResource(0);
                cVar2.hdb.setDefaultErrorResource(0);
                cVar2.hdb.setTagPaddingDis(8, 8);
                cVar2.hdb.setGifIconSupport(false);
                cVar2.hdb.setLongIconSupport(false);
                cVar2.cvS = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hdc = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hdd = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hdb.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hdd.setText(am.cY(videoFileInfo.videoDuration));
            a(cVar.cvS, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hdb.setOnClickListener(bVar);
            cVar.hdc.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hcP != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hcP.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hcP != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hcP.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hcu.getResources().getString(d.j.check_box_checked));
                aj.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hcu.getResources().getString(d.j.check_box_not_checked));
            aj.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hda;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hda = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (j.this.hcS != null && this.hda != null) {
                    j.this.hcS.a(this.position, this.hda);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hda != null && j.this.hcT != null) {
                    j.this.hcT.b(this.position, this.hda);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (j.this.hcS != null && this.hda != null) {
                    j.this.hcS.a(this.position, this.hda);
                }
            } else if (view.getId() == d.g.video_select && this.hda != null && j.this.hcT != null) {
                j.this.hcT.b(this.position, this.hda);
            }
        }
    }

    public boolean isScroll() {
        return this.eIP;
    }

    public void iJ(boolean z) {
        this.eIP = z;
    }

    public void a(h hVar) {
        this.hcS = hVar;
    }

    public void a(i iVar) {
        this.hcT = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView hcX;
        TbCameraView hcY;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        TbImageView cvR;
        ImageView cvS;
        RelativeLayout gEz;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView cvS;
        TbImageView hdb;
        RelativeLayout hdc;
        TextView hdd;
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
        this.hcR = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hcU = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hcV = aVar;
    }

    public void nZ(boolean z) {
        if (this.hcQ != z) {
            this.hcQ = z;
            notifyDataSetChanged();
        }
    }
}
