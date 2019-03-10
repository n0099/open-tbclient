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
    private View.OnClickListener jnB;
    private f jnC;
    private g jnD;
    private TbCameraView.c jnE;
    private TbCameraView.a jnF;
    private a jnG;
    private AlbumActivity jnf;
    private com.baidu.tieba.write.album.c jnz;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean hep = false;
    private boolean jnA = true;

    public TbCameraView cpc() {
        if (this.jnG != null) {
            return this.jnG.jnI;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jnf = albumActivity;
        this.jnz = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jnf.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jnA) {
            this.mDataList.add(cpd());
        }
        if (!v.T(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cpd() {
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
            if (this.jnG == null || this.jnG.jnI == null) {
                this.jnG = new a();
                View inflate = this.mLayoutInflater.inflate(d.h.album_make_picture_view, viewGroup, false);
                this.jnG.rootView = inflate;
                this.jnG.jnI = (TbCameraView) inflate.findViewById(d.g.camera_surfaceview);
                this.jnG.jnH = (TbImageView) inflate.findViewById(d.g.icon_make_photo);
                this.jnG.jnH.setDefaultResource(0);
                this.jnG.jnH.setDefaultErrorResource(0);
                this.jnG.jnH.setGifIconSupport(false);
                this.jnG.jnH.setLongIconSupport(false);
                inflate.setTag(this.jnG);
                this.jnf.showTip(this.jnG.jnH);
            }
            this.jnG.jnI.setOnRequestPermissionListener(this.jnE);
            this.jnG.jnI.setOnOpenCameraFailedListener(this.jnF);
            this.jnG.jnH.setOnClickListener(this.jnB);
            this.jnG.jnI.setOnClickListener(this.jnB);
            this.jnG.rootView.setOnClickListener(this.jnB);
            al.c(this.jnG.jnH, d.f.icon_album_camera);
            al.l(this.jnG.rootView, d.C0236d.black_alpha90);
            return this.jnG.rootView;
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
                dVar2.iNo = (RelativeLayout) view.findViewById(d.g.lay_select);
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
            dVar.iNo.setOnClickListener(bVar);
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
                cVar2.jnL = (TbImageView) view.findViewById(d.g.video_thumb);
                cVar2.jnL.setDefaultResource(0);
                cVar2.jnL.setDefaultErrorResource(0);
                cVar2.jnL.setTagPaddingDis(8, 8);
                cVar2.jnL.setGifIconSupport(false);
                cVar2.jnL.setLongIconSupport(false);
                cVar2.eIs = (ImageView) view.findViewById(d.g.select_icon);
                cVar2.jnM = (RelativeLayout) view.findViewById(d.g.video_select);
                cVar2.jnN = (TextView) view.findViewById(d.g.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jnL.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jnN.setText(ap.hz(videoFileInfo.videoDuration));
            a(cVar.eIs, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jnL.setOnClickListener(bVar);
            cVar.jnM.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jnz != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jnz.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jnz != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jnz.b((VideoFileInfo) mediaFileInfo);
        }
        d(imageView, z);
    }

    public void d(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jnf.getResources().getString(d.j.check_box_checked));
                al.c(imageView, d.f.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jnf.getResources().getString(d.j.check_box_not_checked));
            al.c(imageView, d.f.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jnK;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jnK = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == d.g.pic) {
                if (h.this.jnC != null && this.jnK != null) {
                    h.this.jnC.a(this.position, this.jnK);
                }
            } else if (view.getId() == d.g.lay_select) {
                if (this.jnK != null && h.this.jnD != null) {
                    h.this.jnD.b(this.position, this.jnK);
                }
            } else if (view.getId() == d.g.video_thumb) {
                if (h.this.jnC != null && this.jnK != null) {
                    h.this.jnC.a(this.position, this.jnK);
                }
            } else if (view.getId() == d.g.video_select && this.jnK != null && h.this.jnD != null) {
                h.this.jnD.b(this.position, this.jnK);
            }
        }
    }

    public boolean isScroll() {
        return this.hep;
    }

    public void mL(boolean z) {
        this.hep = z;
    }

    public void a(f fVar) {
        this.jnC = fVar;
    }

    public void a(g gVar) {
        this.jnD = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jnH;
        TbCameraView jnI;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        TbImageView eIr;
        ImageView eIs;
        RelativeLayout iNo;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView eIs;
        TbImageView jnL;
        RelativeLayout jnM;
        TextView jnN;
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
        this.jnB = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jnE = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jnF = aVar;
    }

    public void rc(boolean z) {
        if (this.jnA != z) {
            this.jnA = z;
            notifyDataSetChanged();
        }
    }
}
