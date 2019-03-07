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
    private AlbumActivity jmM;
    private com.baidu.tieba.write.album.c jng;
    private View.OnClickListener jni;
    private f jnj;
    private g jnk;
    private TbCameraView.c jnl;
    private TbCameraView.a jnm;
    private a jnn;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean heo = false;
    private boolean jnh = true;

    public TbCameraView coS() {
        if (this.jnn != null) {
            return this.jnn.jnp;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jmM = albumActivity;
        this.jng = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jmM.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jnh) {
            this.mDataList.add(coT());
        }
        if (!v.T(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo coT() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.S(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Bh */
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
            if (this.jnn == null || this.jnn.jnp == null) {
                this.jnn = new a();
                View inflate = this.mLayoutInflater.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.jnn.rootView = inflate;
                this.jnn.jnp = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.jnn.jno = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.jnn.jno.setDefaultResource(0);
                this.jnn.jno.setDefaultErrorResource(0);
                this.jnn.jno.setGifIconSupport(false);
                this.jnn.jno.setLongIconSupport(false);
                inflate.setTag(this.jnn);
                this.jmM.showTip(this.jnn.jno);
            }
            this.jnn.jnp.setOnRequestPermissionListener(this.jnl);
            this.jnn.jnp.setOnOpenCameraFailedListener(this.jnm);
            this.jnn.jno.setOnClickListener(this.jni);
            this.jnn.jnp.setOnClickListener(this.jni);
            this.jnn.rootView.setOnClickListener(this.jni);
            al.c(this.jnn.jno, d.f.icon_album_camera);
            al.l(this.jnn.rootView, d.C0236d.black_alpha90);
            return this.jnn.rootView;
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
                dVar2.eIr = (TbImageView) view.findViewById(d.g.pic);
                dVar2.eIr.setDefaultResource(0);
                dVar2.eIr.setDefaultErrorResource(0);
                dVar2.eIr.setTagPaddingDis(8, 8);
                dVar2.eIr.setGifIconSupport(true);
                dVar2.eIr.setLongIconSupport(true);
                dVar2.eIs = (ImageView) view.findViewById(d.g.select_icon);
                dVar2.iMU = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.eIr.setIsLongPic(imageFileInfo.isLong());
            dVar.eIr.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.eIs, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.eIr.setOnClickListener(bVar);
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
                cVar2.jns = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.jns.setDefaultResource(0);
                cVar2.jns.setDefaultErrorResource(0);
                cVar2.jns.setTagPaddingDis(8, 8);
                cVar2.jns.setGifIconSupport(false);
                cVar2.jns.setLongIconSupport(false);
                cVar2.eIs = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.jnt = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.jnu = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jns.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jnu.setText(ap.hz(videoFileInfo.videoDuration));
            a(cVar.eIs, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jns.setOnClickListener(bVar);
            cVar.jnt.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jng != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jng.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jng != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jng.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jmM.getResources().getString(d.j.check_box_checked));
                al.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jmM.getResources().getString(d.j.check_box_not_checked));
            al.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jnr;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jnr = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (h.this.jnj != null && this.jnr != null) {
                    h.this.jnj.a(this.position, this.jnr);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.jnr != null && h.this.jnk != null) {
                    h.this.jnk.b(this.position, this.jnr);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (h.this.jnj != null && this.jnr != null) {
                    h.this.jnj.a(this.position, this.jnr);
                }
            } else if (view.getId() == d.g.video_select && this.jnr != null && h.this.jnk != null) {
                h.this.jnk.b(this.position, this.jnr);
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
        this.jnj = fVar;
    }

    public void a(g gVar) {
        this.jnk = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jno;
        TbCameraView jnp;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView eIr;
        ImageView eIs;
        RelativeLayout iMU;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView eIs;
        TbImageView jns;
        RelativeLayout jnt;
        TextView jnu;
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
        this.jni = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jnl = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jnm = aVar;
    }

    public void rc(boolean z) {
        if (this.jnh != z) {
            this.jnh = z;
            notifyDataSetChanged();
        }
    }
}
