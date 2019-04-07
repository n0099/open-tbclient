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
    private AlbumActivity jmL;
    private com.baidu.tieba.write.album.c jnf;
    private View.OnClickListener jnh;
    private f jni;
    private g jnj;
    private TbCameraView.c jnk;
    private TbCameraView.a jnl;
    private a jnm;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean heb = false;
    private boolean jng = true;

    public TbCameraView cpd() {
        if (this.jnm != null) {
            return this.jnm.jno;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jmL = albumActivity;
        this.jnf = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jmL.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jng) {
            this.mDataList.add(cpe());
        }
        if (!v.T(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cpe() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.S(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Be */
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
            if (this.jnm == null || this.jnm.jno == null) {
                this.jnm = new a();
                View inflate = this.mLayoutInflater.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.jnm.rootView = inflate;
                this.jnm.jno = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.jnm.jnn = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.jnm.jnn.setDefaultResource(0);
                this.jnm.jnn.setDefaultErrorResource(0);
                this.jnm.jnn.setGifIconSupport(false);
                this.jnm.jnn.setLongIconSupport(false);
                inflate.setTag(this.jnm);
                this.jmL.showTip(this.jnm.jnn);
            }
            this.jnm.jno.setOnRequestPermissionListener(this.jnk);
            this.jnm.jno.setOnOpenCameraFailedListener(this.jnl);
            this.jnm.jnn.setOnClickListener(this.jnh);
            this.jnm.jno.setOnClickListener(this.jnh);
            this.jnm.rootView.setOnClickListener(this.jnh);
            al.c(this.jnm.jnn, d.f.icon_album_camera);
            al.l(this.jnm.rootView, d.C0277d.black_alpha90);
            return this.jnm.rootView;
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
                dVar2.eHZ = (TbImageView) view.findViewById(d.g.pic);
                dVar2.eHZ.setDefaultResource(0);
                dVar2.eHZ.setDefaultErrorResource(0);
                dVar2.eHZ.setTagPaddingDis(8, 8);
                dVar2.eHZ.setGifIconSupport(true);
                dVar2.eHZ.setLongIconSupport(true);
                dVar2.eIa = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.iMU = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.eHZ.setIsLongPic(imageFileInfo.isLong());
            dVar.eHZ.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.eIa, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.eHZ.setOnClickListener(bVar);
            dVar.iMU.setOnClickListener(bVar);
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
                cVar2.jnr = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.jnr.setDefaultResource(0);
                cVar2.jnr.setDefaultErrorResource(0);
                cVar2.jnr.setTagPaddingDis(8, 8);
                cVar2.jnr.setGifIconSupport(false);
                cVar2.jnr.setLongIconSupport(false);
                cVar2.eIa = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.jns = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.jnt = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jnr.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jnt.setText(ap.hy(videoFileInfo.videoDuration));
            a(cVar.eIa, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jnr.setOnClickListener(bVar);
            cVar.jns.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jnf != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jnf.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jnf != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jnf.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jmL.getResources().getString(d.j.check_box_checked));
                al.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jmL.getResources().getString(d.j.check_box_not_checked));
            al.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jnq;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jnq = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (h.this.jni != null && this.jnq != null) {
                    h.this.jni.a(this.position, this.jnq);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.jnq != null && h.this.jnj != null) {
                    h.this.jnj.b(this.position, this.jnq);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (h.this.jni != null && this.jnq != null) {
                    h.this.jni.a(this.position, this.jnq);
                }
            } else if (view.getId() == d.g.video_select && this.jnq != null && h.this.jnj != null) {
                h.this.jnj.b(this.position, this.jnq);
            }
        }
    }

    public boolean isScroll() {
        return this.heb;
    }

    public void mL(boolean z) {
        this.heb = z;
    }

    public void a(f fVar) {
        this.jni = fVar;
    }

    public void a(g gVar) {
        this.jnj = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jnn;
        TbCameraView jno;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView eHZ;
        ImageView eIa;
        RelativeLayout iMU;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView eIa;
        TbImageView jnr;
        RelativeLayout jns;
        TextView jnt;
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
        this.jnh = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jnk = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jnl = aVar;
    }

    public void rc(boolean z) {
        if (this.jng != z) {
            this.jng = z;
            notifyDataSetChanged();
        }
    }
}
