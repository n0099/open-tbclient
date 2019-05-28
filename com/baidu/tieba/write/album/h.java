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
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private AlbumActivity jFP;
    private com.baidu.tieba.write.album.c jGj;
    private View.OnClickListener jGl;
    private f jGm;
    private g jGn;
    private TbCameraView.c jGo;
    private TbCameraView.a jGp;
    private a jGq;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean hvx = false;
    private boolean jGk = true;

    public TbCameraView cxl() {
        if (this.jGq != null) {
            return this.jGq.jGs;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jFP = albumActivity;
        this.jGj = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jFP.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jGk) {
            this.mDataList.add(cxm());
        }
        if (!v.aa(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cxm() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Cn */
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
            if (this.jGq == null || this.jGq.jGs == null) {
                this.jGq = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.jGq.rootView = inflate;
                this.jGq.jGs = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.jGq.jGr = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.jGq.jGr.setDefaultResource(0);
                this.jGq.jGr.setDefaultErrorResource(0);
                this.jGq.jGr.setGifIconSupport(false);
                this.jGq.jGr.setLongIconSupport(false);
                inflate.setTag(this.jGq);
                this.jFP.showTip(this.jGq.jGr);
            }
            this.jGq.jGs.setOnRequestPermissionListener(this.jGo);
            this.jGq.jGs.setOnOpenCameraFailedListener(this.jGp);
            this.jGq.jGr.setOnClickListener(this.jGl);
            this.jGq.jGs.setOnClickListener(this.jGl);
            this.jGq.rootView.setOnClickListener(this.jGl);
            al.c(this.jGq.jGr, (int) R.drawable.icon_album_camera);
            al.l(this.jGq.rootView, R.color.black_alpha90);
            return this.jGq.rootView;
        }
        return view;
    }

    private View b(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        d dVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 0 && (mediaFileInfo instanceof ImageFileInfo)) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                d dVar2 = new d();
                view = this.mLayoutInflater.inflate(R.layout.album_image_item_view, viewGroup, false);
                dVar2.rootView = view;
                dVar2.eYk = (TbImageView) view.findViewById(R.id.pic);
                dVar2.eYk.setDefaultResource(0);
                dVar2.eYk.setDefaultErrorResource(0);
                dVar2.eYk.setTagPaddingDis(8, 8);
                dVar2.eYk.setGifIconSupport(true);
                dVar2.eYk.setLongIconSupport(true);
                dVar2.eYl = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.jfP = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.jGj != null && this.jGj.getWriteImagesInfo() != null && this.jGj.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.jfP.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.eYk.setIsLongPic(imageFileInfo.isLong());
            dVar.eYk.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.eYl, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.eYk.setOnClickListener(bVar);
            dVar.jfP.setOnClickListener(bVar);
        }
        return view;
    }

    private View c(int i, View view, ViewGroup viewGroup, MediaFileInfo mediaFileInfo) {
        c cVar;
        if (mediaFileInfo != null && mediaFileInfo.getType() == 1 && (mediaFileInfo instanceof VideoFileInfo)) {
            VideoFileInfo videoFileInfo = (VideoFileInfo) mediaFileInfo;
            if (view == null || !(view.getTag() instanceof d)) {
                c cVar2 = new c();
                view = this.mLayoutInflater.inflate(R.layout.album_video_item_view, viewGroup, false);
                cVar2.rootView = view;
                cVar2.jGv = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.jGv.setDefaultResource(0);
                cVar2.jGv.setDefaultErrorResource(0);
                cVar2.jGv.setTagPaddingDis(8, 8);
                cVar2.jGv.setGifIconSupport(false);
                cVar2.jGv.setLongIconSupport(false);
                cVar2.eYl = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.jGw = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.jGx = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jGv.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jGx.setText(ap.im(videoFileInfo.videoDuration));
            a(cVar.eYl, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jGv.setOnClickListener(bVar);
            cVar.jGw.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jGj != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jGj.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jGj != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jGj.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jFP.getResources().getString(R.string.check_box_checked));
                al.c(imageView, (int) R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jFP.getResources().getString(R.string.check_box_not_checked));
            al.c(imageView, (int) R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jGu;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jGu = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.jGm != null && this.jGu != null) {
                    h.this.jGm.a(this.position, this.jGu);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.jGu != null && h.this.jGn != null) {
                    h.this.jGn.b(this.position, this.jGu);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.jGm != null && this.jGu != null) {
                    h.this.jGm.a(this.position, this.jGu);
                }
            } else if (view.getId() == R.id.video_select && this.jGu != null && h.this.jGn != null) {
                h.this.jGn.b(this.position, this.jGu);
            }
        }
    }

    public boolean isScroll() {
        return this.hvx;
    }

    public void nA(boolean z) {
        this.hvx = z;
    }

    public void a(f fVar) {
        this.jGm = fVar;
    }

    public void a(g gVar) {
        this.jGn = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jGr;
        TbCameraView jGs;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView eYk;
        ImageView eYl;
        RelativeLayout jfP;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView eYl;
        TbImageView jGv;
        RelativeLayout jGw;
        TextView jGx;
        View rootView;

        private c() {
        }
    }

    public int i(ImageFileInfo imageFileInfo) {
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

    public void ab(View.OnClickListener onClickListener) {
        this.jGl = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jGo = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jGp = aVar;
    }

    public void rR(boolean z) {
        if (this.jGk != z) {
            this.jGk = z;
            notifyDataSetChanged();
        }
    }
}
