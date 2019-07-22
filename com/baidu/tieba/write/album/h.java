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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.album.TbCameraView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private AlbumActivity jMV;
    private com.baidu.tieba.write.album.c jNp;
    private View.OnClickListener jNr;
    private f jNs;
    private g jNt;
    private TbCameraView.c jNu;
    private TbCameraView.a jNv;
    private a jNw;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean hBK = false;
    private boolean jNq = true;

    public TbCameraView cAl() {
        if (this.jNw != null) {
            return this.jNw.jNy;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jMV = albumActivity;
        this.jNp = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jMV.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jNq) {
            this.mDataList.add(cAm());
        }
        if (!v.aa(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cAm() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: CU */
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
            if (this.jNw == null || this.jNw.jNy == null) {
                this.jNw = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.jNw.rootView = inflate;
                this.jNw.jNy = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.jNw.jNx = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.jNw.jNx.setDefaultResource(0);
                this.jNw.jNx.setDefaultErrorResource(0);
                this.jNw.jNx.setGifIconSupport(false);
                this.jNw.jNx.setLongIconSupport(false);
                inflate.setTag(this.jNw);
                this.jMV.showTip(this.jNw.jNx);
            }
            this.jNw.jNy.setOnRequestPermissionListener(this.jNu);
            this.jNw.jNy.setOnOpenCameraFailedListener(this.jNv);
            this.jNw.jNx.setOnClickListener(this.jNr);
            this.jNw.jNy.setOnClickListener(this.jNr);
            this.jNw.rootView.setOnClickListener(this.jNr);
            am.c(this.jNw.jNx, (int) R.drawable.icon_album_camera);
            am.l(this.jNw.rootView, R.color.black_alpha90);
            return this.jNw.rootView;
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
                dVar2.fdl = (TbImageView) view.findViewById(R.id.pic);
                dVar2.fdl.setDefaultResource(0);
                dVar2.fdl.setDefaultErrorResource(0);
                dVar2.fdl.setTagPaddingDis(8, 8);
                dVar2.fdl.setGifIconSupport(true);
                dVar2.fdl.setLongIconSupport(true);
                dVar2.fdm = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.jmc = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.jNp != null && this.jNp.getWriteImagesInfo() != null && this.jNp.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.jmc.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.fdl.setIsLongPic(imageFileInfo.isLong());
            dVar.fdl.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.fdm, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.fdl.setOnClickListener(bVar);
            dVar.jmc.setOnClickListener(bVar);
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
                cVar2.jNB = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.jNB.setDefaultResource(0);
                cVar2.jNB.setDefaultErrorResource(0);
                cVar2.jNB.setTagPaddingDis(8, 8);
                cVar2.jNB.setGifIconSupport(false);
                cVar2.jNB.setLongIconSupport(false);
                cVar2.fdm = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.jNC = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.jND = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jNB.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jND.setText(aq.is(videoFileInfo.videoDuration));
            a(cVar.fdm, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jNB.setOnClickListener(bVar);
            cVar.jNC.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jNp != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jNp.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jNp != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jNp.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jMV.getResources().getString(R.string.check_box_checked));
                am.c(imageView, (int) R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jMV.getResources().getString(R.string.check_box_not_checked));
            am.c(imageView, (int) R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jNA;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jNA = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.jNs != null && this.jNA != null) {
                    h.this.jNs.a(this.position, this.jNA);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.jNA != null && h.this.jNt != null) {
                    h.this.jNt.b(this.position, this.jNA);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.jNs != null && this.jNA != null) {
                    h.this.jNs.a(this.position, this.jNA);
                }
            } else if (view.getId() == R.id.video_select && this.jNA != null && h.this.jNt != null) {
                h.this.jNt.b(this.position, this.jNA);
            }
        }
    }

    public boolean isScroll() {
        return this.hBK;
    }

    public void nP(boolean z) {
        this.hBK = z;
    }

    public void a(f fVar) {
        this.jNs = fVar;
    }

    public void a(g gVar) {
        this.jNt = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jNx;
        TbCameraView jNy;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView fdl;
        ImageView fdm;
        RelativeLayout jmc;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView fdm;
        TbImageView jNB;
        RelativeLayout jNC;
        TextView jND;
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

    public void ad(View.OnClickListener onClickListener) {
        this.jNr = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jNu = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jNv = aVar;
    }

    public void sh(boolean z) {
        if (this.jNq != z) {
            this.jNq = z;
            notifyDataSetChanged();
        }
    }
}
