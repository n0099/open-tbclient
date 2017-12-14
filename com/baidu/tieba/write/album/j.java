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
    private e hfF;
    private View.OnClickListener hfH;
    private h hfI;
    private i hfJ;
    private TbCameraView.c hfK;
    private TbCameraView.a hfL;
    private a hfM;
    private AlbumActivity hfk;
    private LayoutInflater hfu;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean eJT = false;
    private boolean hfG = true;

    public TbCameraView bGx() {
        if (this.hfM != null) {
            return this.hfM.hfO;
        }
        return null;
    }

    public j(AlbumActivity albumActivity, e eVar) {
        this.hfk = albumActivity;
        this.hfF = eVar;
        this.hfu = LayoutInflater.from(this.hfk.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.hfG) {
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
            if (this.hfM == null || this.hfM.hfO == null) {
                this.hfM = new a();
                View inflate = this.hfu.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.hfM.rootView = inflate;
                this.hfM.hfO = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.hfM.hfN = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.hfM.hfN.setDefaultResource(0);
                this.hfM.hfN.setDefaultErrorResource(0);
                this.hfM.hfN.setGifIconSupport(false);
                this.hfM.hfN.setLongIconSupport(false);
                inflate.setTag(this.hfM);
                this.hfk.showTip(this.hfM.hfN);
            }
            this.hfM.hfO.setOnRequestPermissionListener(this.hfK);
            this.hfM.hfO.setOnOpenCameraFailedListener(this.hfL);
            this.hfM.hfN.setOnClickListener(this.hfH);
            this.hfM.hfO.setOnClickListener(this.hfH);
            this.hfM.rootView.setOnClickListener(this.hfH);
            aj.c(this.hfM.hfN, d.f.icon_album_camera);
            aj.k(this.hfM.rootView, d.C0096d.black_alpha90);
            return this.hfM.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.hfu.inflate(d.h.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.cwa = (TbImageView) view.findViewById(d.g.pic);
                dVar2.cwa.setDefaultResource(0);
                dVar2.cwa.setDefaultErrorResource(0);
                dVar2.cwa.setTagPaddingDis(8, 8);
                dVar2.cwa.setGifIconSupport(true);
                dVar2.cwa.setLongIconSupport(true);
                dVar2.cwb = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.gHi = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.cwa.setIsLongPic(imageFileInfo.isLong());
            dVar.cwa.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.cwb, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.cwa.setOnClickListener(bVar);
            dVar.gHi.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.hfu.inflate(d.h.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.hfR = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.hfR.setDefaultResource(0);
                cVar2.hfR.setDefaultErrorResource(0);
                cVar2.hfR.setTagPaddingDis(8, 8);
                cVar2.hfR.setGifIconSupport(false);
                cVar2.hfR.setLongIconSupport(false);
                cVar2.cwb = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.hfS = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.hfT = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.hfR.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.hfT.setText(am.cY(videoFileInfo.videoDuration));
            a(cVar.cwb, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.hfR.setOnClickListener(bVar);
            cVar.hfS.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.hfF != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.hfF.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.hfF != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.hfF.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.hfk.getResources().getString(d.j.check_box_checked));
                aj.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.hfk.getResources().getString(d.j.check_box_not_checked));
            aj.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo hfQ;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.hfQ = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (j.this.hfI != null && this.hfQ != null) {
                    j.this.hfI.a(this.position, this.hfQ);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.hfQ != null && j.this.hfJ != null) {
                    j.this.hfJ.b(this.position, this.hfQ);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (j.this.hfI != null && this.hfQ != null) {
                    j.this.hfI.a(this.position, this.hfQ);
                }
            } else if (view.getId() == d.g.video_select && this.hfQ != null && j.this.hfJ != null) {
                j.this.hfJ.b(this.position, this.hfQ);
            }
        }
    }

    public boolean isScroll() {
        return this.eJT;
    }

    public void iK(boolean z) {
        this.eJT = z;
    }

    public void a(h hVar) {
        this.hfI = hVar;
    }

    public void a(i iVar) {
        this.hfJ = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView hfN;
        TbCameraView hfO;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        TbImageView cwa;
        ImageView cwb;
        RelativeLayout gHi;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView cwb;
        TbImageView hfR;
        RelativeLayout hfS;
        TextView hfT;
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
        this.hfH = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.hfK = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.hfL = aVar;
    }

    public void oa(boolean z) {
        if (this.hfG != z) {
            this.hfG = z;
            notifyDataSetChanged();
        }
    }
}
