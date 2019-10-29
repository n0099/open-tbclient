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
    private AlbumActivity jOC;
    private com.baidu.tieba.write.album.c jOM;
    private View.OnClickListener jOO;
    private f jOP;
    private g jOQ;
    private TbCameraView.c jOR;
    private TbCameraView.a jOS;
    private a jOT;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean aqj = false;
    private boolean jON = true;

    public TbCameraView cyj() {
        if (this.jOT != null) {
            return this.jOT.jOV;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.jOC = albumActivity;
        this.jOM = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.jOC.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.jON) {
            this.mDataList.add(cyk());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cyk() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: By */
    public MediaFileInfo getItem(int i) {
        return (MediaFileInfo) v.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.getItem(this.mDataList, i);
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
            if (this.jOT == null || this.jOT.jOV == null) {
                this.jOT = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.jOT.rootView = inflate;
                this.jOT.jOV = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.jOT.jOU = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.jOT.jOU.setDefaultResource(0);
                this.jOT.jOU.setDefaultErrorResource(0);
                this.jOT.jOU.setGifIconSupport(false);
                this.jOT.jOU.setLongIconSupport(false);
                inflate.setTag(this.jOT);
                this.jOC.showTip(this.jOT.jOU);
            }
            this.jOT.jOV.setOnRequestPermissionListener(this.jOR);
            this.jOT.jOV.setOnOpenCameraFailedListener(this.jOS);
            this.jOT.jOU.setOnClickListener(this.jOO);
            this.jOT.jOV.setOnClickListener(this.jOO);
            this.jOT.rootView.setOnClickListener(this.jOO);
            am.setImageResource(this.jOT.jOU, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.jOT.rootView, R.color.black_alpha90);
            return this.jOT.rootView;
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
                dVar2.fim = (TbImageView) view.findViewById(R.id.pic);
                dVar2.fim.setDefaultResource(0);
                dVar2.fim.setDefaultErrorResource(0);
                dVar2.fim.setTagPaddingDis(8, 8);
                dVar2.fim.setGifIconSupport(true);
                dVar2.fim.setLongIconSupport(true);
                dVar2.aqp = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.aqq = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.jOM != null && this.jOM.getWriteImagesInfo() != null && this.jOM.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.aqq.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.fim.setIsLongPic(imageFileInfo.isLong());
            dVar.fim.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.aqp, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.fim.setOnClickListener(bVar);
            dVar.aqq.setOnClickListener(bVar);
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
                cVar2.jOY = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.jOY.setDefaultResource(0);
                cVar2.jOY.setDefaultErrorResource(0);
                cVar2.jOY.setTagPaddingDis(8, 8);
                cVar2.jOY.setGifIconSupport(false);
                cVar2.jOY.setLongIconSupport(false);
                cVar2.aqp = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.jOZ = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.jPa = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.jOY.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.jPa.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.aqp, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.jOY.setOnClickListener(bVar);
            cVar.jOZ.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.jOM != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.jOM.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.jOM != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.jOM.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.jOC.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.jOC.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo jOX;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.jOX = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.jOP != null && this.jOX != null) {
                    h.this.jOP.a(this.position, this.jOX);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.jOX != null && h.this.jOQ != null) {
                    h.this.jOQ.b(this.position, this.jOX);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.jOP != null && this.jOX != null) {
                    h.this.jOP.a(this.position, this.jOX);
                }
            } else if (view.getId() == R.id.video_select && this.jOX != null && h.this.jOQ != null) {
                h.this.jOQ.b(this.position, this.jOX);
            }
        }
    }

    public boolean isScroll() {
        return this.aqj;
    }

    public void aT(boolean z) {
        this.aqj = z;
    }

    public void a(f fVar) {
        this.jOP = fVar;
    }

    public void a(g gVar) {
        this.jOQ = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView jOU;
        TbCameraView jOV;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d {
        ImageView aqp;
        RelativeLayout aqq;
        TbImageView fim;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        ImageView aqp;
        TbImageView jOY;
        RelativeLayout jOZ;
        TextView jPa;
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

    public void ae(View.OnClickListener onClickListener) {
        this.jOO = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.jOR = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.jOS = aVar;
    }

    public void rQ(boolean z) {
        if (this.jON != z) {
            this.jON = z;
            notifyDataSetChanged();
        }
    }
}
