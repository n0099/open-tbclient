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
    private e hER;
    private View.OnClickListener hET;
    private h hEU;
    private i hEV;
    private TbCameraView.c hEW;
    private TbCameraView.a hEX;
    private a hEY;
    private AlbumActivity hEx;
    private LayoutInflater kh;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fBC = false;
    private boolean hES = true;

    public TbCameraView bGu() {
        if (this.hEY != null) {
            return this.hEY.hFa;
        }
        return null;
    }

    public j(AlbumActivity albumActivity, e eVar) {
        this.hEx = albumActivity;
        this.hER = eVar;
        this.kh = LayoutInflater.from(this.hEx.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hES) {
            this.mDataList.add(bGv());
        }
        if (!v.E(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bGv() {
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
            if (this.hEY == null || this.hEY.hFa == null) {
                this.hEY = new a();
                View inflate = this.kh.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.hEY.rootView = inflate;
                this.hEY.hFa = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hEY.hEZ = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hEY.hEZ.setDefaultResource(0);
                this.hEY.hEZ.setDefaultErrorResource(0);
                this.hEY.hEZ.setGifIconSupport(false);
                this.hEY.hEZ.setLongIconSupport(false);
                inflate.setTag(this.hEY);
                this.hEx.showTip(this.hEY.hEZ);
            }
            this.hEY.hFa.setOnRequestPermissionListener(this.hEW);
            this.hEY.hFa.setOnOpenCameraFailedListener(this.hEX);
            this.hEY.hEZ.setOnClickListener(this.hET);
            this.hEY.hFa.setOnClickListener(this.hET);
            this.hEY.rootView.setOnClickListener(this.hET);
            aj.c(this.hEY.hEZ, d.f.icon_album_camera);
            aj.t(this.hEY.rootView, d.C0141d.black_alpha90);
            return this.hEY.rootView;
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
                dVar2.dsd = (TbImageView) view.findViewById(d.g.pic);
                dVar2.dsd.setDefaultResource(0);
                dVar2.dsd.setDefaultErrorResource(0);
                dVar2.dsd.setTagPaddingDis(8, 8);
                dVar2.dsd.setGifIconSupport(true);
                dVar2.dsd.setLongIconSupport(true);
                dVar2.dse = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.hfW = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.dsd.setIsLongPic(imageFileInfo.isLong());
            dVar.dsd.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dse, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.dsd.setOnClickListener(bVar);
            dVar.hfW.setOnClickListener(bVar);
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
                cVar2.hFd = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hFd.setDefaultResource(0);
                cVar2.hFd.setDefaultErrorResource(0);
                cVar2.hFd.setTagPaddingDis(8, 8);
                cVar2.hFd.setGifIconSupport(false);
                cVar2.hFd.setLongIconSupport(false);
                cVar2.dse = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hFe = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hFf = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hFd.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hFf.setText(am.fV(videoFileInfo.videoDuration));
            a(cVar.dse, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hFd.setOnClickListener(bVar);
            cVar.hFe.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hER != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hER.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hER != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hER.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hEx.getResources().getString(d.j.check_box_checked));
                aj.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hEx.getResources().getString(d.j.check_box_not_checked));
            aj.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hFc;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hFc = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (j.this.hEU != null && this.hFc != null) {
                    j.this.hEU.a(this.position, this.hFc);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hFc != null && j.this.hEV != null) {
                    j.this.hEV.b(this.position, this.hFc);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (j.this.hEU != null && this.hFc != null) {
                    j.this.hEU.a(this.position, this.hFc);
                }
            } else if (view.getId() == d.g.video_select && this.hFc != null && j.this.hEV != null) {
                j.this.hEV.b(this.position, this.hFc);
            }
        }
    }

    public boolean isScroll() {
        return this.fBC;
    }

    public void jB(boolean z) {
        this.fBC = z;
    }

    public void a(h hVar) {
        this.hEU = hVar;
    }

    public void a(i iVar) {
        this.hEV = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView hEZ;
        TbCameraView hFa;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        TbImageView dsd;
        ImageView dse;
        RelativeLayout hfW;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView dse;
        TbImageView hFd;
        RelativeLayout hFe;
        TextView hFf;
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
        this.hET = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hEW = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hEX = aVar;
    }

    public void nH(boolean z) {
        if (this.hES != z) {
            this.hES = z;
            notifyDataSetChanged();
        }
    }
}
