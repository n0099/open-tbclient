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
    private AlbumActivity jFO;
    private com.baidu.tieba.write.album.c jGi;
    private View.OnClickListener jGk;
    private f jGl;
    private g jGm;
    private TbCameraView.c jGn;
    private TbCameraView.a jGo;
    private a jGp;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean hvu = false;
    private boolean jGj = true;

    public TbCameraView cxj() {
        if (this.jGp != null) {
            return this.jGp.jGr;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jFO = albumActivity;
        this.jGi = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jFO.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jGj) {
            this.mDataList.add(cxk());
        }
        if (!v.aa(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cxk() {
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
            if (this.jGp == null || this.jGp.jGr == null) {
                this.jGp = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.jGp.rootView = inflate;
                this.jGp.jGr = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.jGp.jGq = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.jGp.jGq.setDefaultResource(0);
                this.jGp.jGq.setDefaultErrorResource(0);
                this.jGp.jGq.setGifIconSupport(false);
                this.jGp.jGq.setLongIconSupport(false);
                inflate.setTag(this.jGp);
                this.jFO.showTip(this.jGp.jGq);
            }
            this.jGp.jGr.setOnRequestPermissionListener(this.jGn);
            this.jGp.jGr.setOnOpenCameraFailedListener(this.jGo);
            this.jGp.jGq.setOnClickListener(this.jGk);
            this.jGp.jGr.setOnClickListener(this.jGk);
            this.jGp.rootView.setOnClickListener(this.jGk);
            al.c(this.jGp.jGq, (int) R.drawable.icon_album_camera);
            al.l(this.jGp.rootView, R.color.black_alpha90);
            return this.jGp.rootView;
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
                dVar2.eYj = (TbImageView) view.findViewById(R.id.pic);
                dVar2.eYj.setDefaultResource(0);
                dVar2.eYj.setDefaultErrorResource(0);
                dVar2.eYj.setTagPaddingDis(8, 8);
                dVar2.eYj.setGifIconSupport(true);
                dVar2.eYj.setLongIconSupport(true);
                dVar2.eYk = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.jfO = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.jGi != null && this.jGi.getWriteImagesInfo() != null && this.jGi.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.jfO.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.eYj.setIsLongPic(imageFileInfo.isLong());
            dVar.eYj.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.eYk, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.eYj.setOnClickListener(bVar);
            dVar.jfO.setOnClickListener(bVar);
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
                cVar2.jGu = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.jGu.setDefaultResource(0);
                cVar2.jGu.setDefaultErrorResource(0);
                cVar2.jGu.setTagPaddingDis(8, 8);
                cVar2.jGu.setGifIconSupport(false);
                cVar2.jGu.setLongIconSupport(false);
                cVar2.eYk = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.jGv = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.jGw = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jGu.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jGw.setText(ap.im(videoFileInfo.videoDuration));
            a(cVar.eYk, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jGu.setOnClickListener(bVar);
            cVar.jGv.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jGi != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jGi.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jGi != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jGi.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jFO.getResources().getString(R.string.check_box_checked));
                al.c(imageView, (int) R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jFO.getResources().getString(R.string.check_box_not_checked));
            al.c(imageView, (int) R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jGt;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jGt = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.jGl != null && this.jGt != null) {
                    h.this.jGl.a(this.position, this.jGt);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.jGt != null && h.this.jGm != null) {
                    h.this.jGm.b(this.position, this.jGt);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.jGl != null && this.jGt != null) {
                    h.this.jGl.a(this.position, this.jGt);
                }
            } else if (view.getId() == R.id.video_select && this.jGt != null && h.this.jGm != null) {
                h.this.jGm.b(this.position, this.jGt);
            }
        }
    }

    public boolean isScroll() {
        return this.hvu;
    }

    public void nA(boolean z) {
        this.hvu = z;
    }

    public void a(f fVar) {
        this.jGl = fVar;
    }

    public void a(g gVar) {
        this.jGm = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jGq;
        TbCameraView jGr;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView eYj;
        ImageView eYk;
        RelativeLayout jfO;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView eYk;
        TbImageView jGu;
        RelativeLayout jGv;
        TextView jGw;
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
        this.jGk = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jGn = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jGo = aVar;
    }

    public void rR(boolean z) {
        if (this.jGj != z) {
            this.jGj = z;
            notifyDataSetChanged();
        }
    }
}
