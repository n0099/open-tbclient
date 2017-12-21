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
    private e hfK;
    private View.OnClickListener hfM;
    private h hfN;
    private i hfO;
    private TbCameraView.c hfP;
    private TbCameraView.a hfQ;
    private a hfR;
    private AlbumActivity hfp;
    private LayoutInflater hfz;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean eJX = false;
    private boolean hfL = true;

    public TbCameraView bGx() {
        if (this.hfR != null) {
            return this.hfR.hfT;
        }
        return null;
    }

    public j(AlbumActivity albumActivity, e eVar) {
        this.hfp = albumActivity;
        this.hfK = eVar;
        this.hfz = LayoutInflater.from(this.hfp.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hfL) {
            this.mDataList.add(bGy());
        }
        if (!v.w(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo bGy() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vU */
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
            if (this.hfR == null || this.hfR.hfT == null) {
                this.hfR = new a();
                View inflate = this.hfz.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.hfR.rootView = inflate;
                this.hfR.hfT = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hfR.hfS = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hfR.hfS.setDefaultResource(0);
                this.hfR.hfS.setDefaultErrorResource(0);
                this.hfR.hfS.setGifIconSupport(false);
                this.hfR.hfS.setLongIconSupport(false);
                inflate.setTag(this.hfR);
                this.hfp.showTip(this.hfR.hfS);
            }
            this.hfR.hfT.setOnRequestPermissionListener(this.hfP);
            this.hfR.hfT.setOnOpenCameraFailedListener(this.hfQ);
            this.hfR.hfS.setOnClickListener(this.hfM);
            this.hfR.hfT.setOnClickListener(this.hfM);
            this.hfR.rootView.setOnClickListener(this.hfM);
            aj.c(this.hfR.hfS, d.f.icon_album_camera);
            aj.k(this.hfR.rootView, d.C0095d.black_alpha90);
            return this.hfR.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.hfz.inflate(d.h.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.cwe = (TbImageView) view.findViewById(d.g.pic);
                dVar2.cwe.setDefaultResource(0);
                dVar2.cwe.setDefaultErrorResource(0);
                dVar2.cwe.setTagPaddingDis(8, 8);
                dVar2.cwe.setGifIconSupport(true);
                dVar2.cwe.setLongIconSupport(true);
                dVar2.cwf = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.gHn = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.cwe.setIsLongPic(imageFileInfo.isLong());
            dVar.cwe.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cwf, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cwe.setOnClickListener(bVar);
            dVar.gHn.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.hfz.inflate(d.h.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.hfW = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hfW.setDefaultResource(0);
                cVar2.hfW.setDefaultErrorResource(0);
                cVar2.hfW.setTagPaddingDis(8, 8);
                cVar2.hfW.setGifIconSupport(false);
                cVar2.hfW.setLongIconSupport(false);
                cVar2.cwf = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hfX = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hfY = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hfW.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hfY.setText(am.cY(videoFileInfo.videoDuration));
            a(cVar.cwf, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hfW.setOnClickListener(bVar);
            cVar.hfX.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hfK != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hfK.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hfK != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hfK.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hfp.getResources().getString(d.j.check_box_checked));
                aj.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hfp.getResources().getString(d.j.check_box_not_checked));
            aj.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hfV;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hfV = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (j.this.hfN != null && this.hfV != null) {
                    j.this.hfN.a(this.position, this.hfV);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hfV != null && j.this.hfO != null) {
                    j.this.hfO.b(this.position, this.hfV);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (j.this.hfN != null && this.hfV != null) {
                    j.this.hfN.a(this.position, this.hfV);
                }
            } else if (view.getId() == d.g.video_select && this.hfV != null && j.this.hfO != null) {
                j.this.hfO.b(this.position, this.hfV);
            }
        }
    }

    public boolean isScroll() {
        return this.eJX;
    }

    public void iK(boolean z) {
        this.eJX = z;
    }

    public void a(h hVar) {
        this.hfN = hVar;
    }

    public void a(i iVar) {
        this.hfO = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView hfS;
        TbCameraView hfT;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        TbImageView cwe;
        ImageView cwf;
        RelativeLayout gHn;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView cwf;
        TbImageView hfW;
        RelativeLayout hfX;
        TextView hfY;
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
        this.hfM = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hfP = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hfQ = aVar;
    }

    public void oa(boolean z) {
        if (this.hfL != z) {
            this.hfL = z;
            notifyDataSetChanged();
        }
    }
}
