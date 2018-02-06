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
    private AlbumActivity hEK;
    private e hFe;
    private View.OnClickListener hFg;
    private h hFh;
    private i hFi;
    private TbCameraView.c hFj;
    private TbCameraView.a hFk;
    private a hFl;
    private LayoutInflater kh;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean fBO = false;
    private boolean hFf = true;

    public TbCameraView bGv() {
        if (this.hFl != null) {
            return this.hFl.hFn;
        }
        return null;
    }

    public j(AlbumActivity albumActivity, e eVar) {
        this.hEK = albumActivity;
        this.hFe = eVar;
        this.kh = LayoutInflater.from(this.hEK.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hFf) {
            this.mDataList.add(bGw());
        }
        if (!v.E(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bGw() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.D(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xn */
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
            if (this.hFl == null || this.hFl.hFn == null) {
                this.hFl = new a();
                View inflate = this.kh.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.hFl.rootView = inflate;
                this.hFl.hFn = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hFl.hFm = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hFl.hFm.setDefaultResource(0);
                this.hFl.hFm.setDefaultErrorResource(0);
                this.hFl.hFm.setGifIconSupport(false);
                this.hFl.hFm.setLongIconSupport(false);
                inflate.setTag(this.hFl);
                this.hEK.showTip(this.hFl.hFm);
            }
            this.hFl.hFn.setOnRequestPermissionListener(this.hFj);
            this.hFl.hFn.setOnOpenCameraFailedListener(this.hFk);
            this.hFl.hFm.setOnClickListener(this.hFg);
            this.hFl.hFn.setOnClickListener(this.hFg);
            this.hFl.rootView.setOnClickListener(this.hFg);
            aj.c(this.hFl.hFm, d.f.icon_album_camera);
            aj.t(this.hFl.rootView, d.C0140d.black_alpha90);
            return this.hFl.rootView;
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
                dVar2.dsp = (TbImageView) view.findViewById(d.g.pic);
                dVar2.dsp.setDefaultResource(0);
                dVar2.dsp.setDefaultErrorResource(0);
                dVar2.dsp.setTagPaddingDis(8, 8);
                dVar2.dsp.setGifIconSupport(true);
                dVar2.dsp.setLongIconSupport(true);
                dVar2.dsq = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.hgl = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.dsp.setIsLongPic(imageFileInfo.isLong());
            dVar.dsp.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.dsq, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.dsp.setOnClickListener(bVar);
            dVar.hgl.setOnClickListener(bVar);
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
                cVar2.hFq = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hFq.setDefaultResource(0);
                cVar2.hFq.setDefaultErrorResource(0);
                cVar2.hFq.setTagPaddingDis(8, 8);
                cVar2.hFq.setGifIconSupport(false);
                cVar2.hFq.setLongIconSupport(false);
                cVar2.dsq = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hFr = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hFs = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hFq.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hFs.setText(am.fV(videoFileInfo.videoDuration));
            a(cVar.dsq, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hFq.setOnClickListener(bVar);
            cVar.hFr.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hFe != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hFe.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hFe != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hFe.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hEK.getResources().getString(d.j.check_box_checked));
                aj.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hEK.getResources().getString(d.j.check_box_not_checked));
            aj.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hFp;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hFp = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (j.this.hFh != null && this.hFp != null) {
                    j.this.hFh.a(this.position, this.hFp);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hFp != null && j.this.hFi != null) {
                    j.this.hFi.b(this.position, this.hFp);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (j.this.hFh != null && this.hFp != null) {
                    j.this.hFh.a(this.position, this.hFp);
                }
            } else if (view.getId() == d.g.video_select && this.hFp != null && j.this.hFi != null) {
                j.this.hFi.b(this.position, this.hFp);
            }
        }
    }

    public boolean isScroll() {
        return this.fBO;
    }

    public void jB(boolean z) {
        this.fBO = z;
    }

    public void a(h hVar) {
        this.hFh = hVar;
    }

    public void a(i iVar) {
        this.hFi = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView hFm;
        TbCameraView hFn;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        TbImageView dsp;
        ImageView dsq;
        RelativeLayout hgl;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView dsq;
        TbImageView hFq;
        RelativeLayout hFr;
        TextView hFs;
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
        this.hFg = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hFj = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hFk = aVar;
    }

    public void nH(boolean z) {
        if (this.hFf != z) {
            this.hFf = z;
            notifyDataSetChanged();
        }
    }
}
