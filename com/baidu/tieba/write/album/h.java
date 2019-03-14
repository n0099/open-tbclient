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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private AlbumActivity jmX;
    private com.baidu.tieba.write.album.c jnr;
    private View.OnClickListener jnt;
    private f jnu;
    private g jnv;
    private TbCameraView.c jnw;
    private TbCameraView.a jnx;
    private a jny;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean heo = false;
    private boolean jns = true;

    public TbCameraView cpf() {
        if (this.jny != null) {
            return this.jny.jnA;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jmX = albumActivity;
        this.jnr = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jmX.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jns) {
            this.mDataList.add(cpg());
        }
        if (!v.T(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cpg() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.S(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bi */
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
            if (this.jny == null || this.jny.jnA == null) {
                this.jny = new a();
                View inflate = this.mLayoutInflater.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.jny.rootView = inflate;
                this.jny.jnA = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.jny.jnz = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.jny.jnz.setDefaultResource(0);
                this.jny.jnz.setDefaultErrorResource(0);
                this.jny.jnz.setGifIconSupport(false);
                this.jny.jnz.setLongIconSupport(false);
                inflate.setTag(this.jny);
                this.jmX.showTip(this.jny.jnz);
            }
            this.jny.jnA.setOnRequestPermissionListener(this.jnw);
            this.jny.jnA.setOnOpenCameraFailedListener(this.jnx);
            this.jny.jnz.setOnClickListener(this.jnt);
            this.jny.jnA.setOnClickListener(this.jnt);
            this.jny.rootView.setOnClickListener(this.jnt);
            al.c(this.jny.jnz, d.f.icon_album_camera);
            al.l(this.jny.rootView, d.C0277d.black_alpha90);
            return this.jny.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.mLayoutInflater.inflate(d.h.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.eIn = (TbImageView) view.findViewById(d.g.pic);
                dVar2.eIn.setDefaultResource(0);
                dVar2.eIn.setDefaultErrorResource(0);
                dVar2.eIn.setTagPaddingDis(8, 8);
                dVar2.eIn.setGifIconSupport(true);
                dVar2.eIn.setLongIconSupport(true);
                dVar2.eIo = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.iNg = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.eIn.setIsLongPic(imageFileInfo.isLong());
            dVar.eIn.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.eIo, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.eIn.setOnClickListener(bVar);
            dVar.iNg.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.mLayoutInflater.inflate(d.h.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.jnD = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.jnD.setDefaultResource(0);
                cVar2.jnD.setDefaultErrorResource(0);
                cVar2.jnD.setTagPaddingDis(8, 8);
                cVar2.jnD.setGifIconSupport(false);
                cVar2.jnD.setLongIconSupport(false);
                cVar2.eIo = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.jnE = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.jnF = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jnD.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jnF.setText(ap.hz(videoFileInfo.videoDuration));
            a(cVar.eIo, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jnD.setOnClickListener(bVar);
            cVar.jnE.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jnr != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jnr.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jnr != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jnr.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jmX.getResources().getString(d.j.check_box_checked));
                al.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jmX.getResources().getString(d.j.check_box_not_checked));
            al.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jnC;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jnC = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (h.this.jnu != null && this.jnC != null) {
                    h.this.jnu.a(this.position, this.jnC);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.jnC != null && h.this.jnv != null) {
                    h.this.jnv.b(this.position, this.jnC);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (h.this.jnu != null && this.jnC != null) {
                    h.this.jnu.a(this.position, this.jnC);
                }
            } else if (view.getId() == d.g.video_select && this.jnC != null && h.this.jnv != null) {
                h.this.jnv.b(this.position, this.jnC);
            }
        }
    }

    public boolean isScroll() {
        return this.heo;
    }

    public void mL(boolean z) {
        this.heo = z;
    }

    public void a(f fVar) {
        this.jnu = fVar;
    }

    public void a(g gVar) {
        this.jnv = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbCameraView jnA;
        TbImageView jnz;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView eIn;
        ImageView eIo;
        RelativeLayout iNg;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView eIo;
        TbImageView jnD;
        RelativeLayout jnE;
        TextView jnF;
        View rootView;

        private c() {
        }
    }

    public int h(ImageFileInfo imageFileInfo) {
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
        this.jnt = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jnw = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jnx = aVar;
    }

    public void rc(boolean z) {
        if (this.jns != z) {
            this.jns = z;
            notifyDataSetChanged();
        }
    }
}
