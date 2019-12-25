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
/* loaded from: classes10.dex */
public class h extends BaseAdapter {
    private com.baidu.tieba.write.album.c kIJ;
    private View.OnClickListener kIL;
    private f kIM;
    private g kIN;
    private TbCameraView.c kIO;
    private TbCameraView.a kIP;
    private a kIQ;
    private AlbumActivity kIz;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean axH = false;
    private boolean kIK = true;

    public TbCameraView cSj() {
        if (this.kIQ != null) {
            return this.kIQ.kIS;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.kIz = albumActivity;
        this.kIJ = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.kIz.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.kIK) {
            this.mDataList.add(cSk());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo cSk() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DU */
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
            if (this.kIQ == null || this.kIQ.kIS == null) {
                this.kIQ = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.kIQ.rootView = inflate;
                this.kIQ.kIS = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.kIQ.kIR = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.kIQ.kIR.setDefaultResource(0);
                this.kIQ.kIR.setDefaultErrorResource(0);
                this.kIQ.kIR.setGifIconSupport(false);
                this.kIQ.kIR.setLongIconSupport(false);
                inflate.setTag(this.kIQ);
                this.kIz.showTip(this.kIQ.kIR);
            }
            this.kIQ.kIS.setOnRequestPermissionListener(this.kIO);
            this.kIQ.kIS.setOnOpenCameraFailedListener(this.kIP);
            this.kIQ.kIR.setOnClickListener(this.kIL);
            this.kIQ.kIS.setOnClickListener(this.kIL);
            this.kIQ.rootView.setOnClickListener(this.kIL);
            am.setImageResource(this.kIQ.kIR, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.kIQ.rootView, R.color.black_alpha90);
            return this.kIQ.rootView;
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
                dVar2.fVW = (TbImageView) view.findViewById(R.id.pic);
                dVar2.fVW.setDefaultResource(0);
                dVar2.fVW.setDefaultErrorResource(0);
                dVar2.fVW.setTagPaddingDis(8, 8);
                dVar2.fVW.setGifIconSupport(true);
                dVar2.fVW.setLongIconSupport(true);
                dVar2.axN = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.axO = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.kIJ != null && this.kIJ.getWriteImagesInfo() != null && this.kIJ.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.axO.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.fVW.setIsLongPic(imageFileInfo.isLong());
            dVar.fVW.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.axN, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.fVW.setOnClickListener(bVar);
            dVar.axO.setOnClickListener(bVar);
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
                cVar2.kIV = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.kIV.setDefaultResource(0);
                cVar2.kIV.setDefaultErrorResource(0);
                cVar2.kIV.setTagPaddingDis(8, 8);
                cVar2.kIV.setGifIconSupport(false);
                cVar2.kIV.setLongIconSupport(false);
                cVar2.axN = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.kIW = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.kIX = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.kIV.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.kIX.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.axN, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.kIV.setOnClickListener(bVar);
            cVar.kIW.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.kIJ != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.kIJ.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.kIJ != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.kIJ.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.kIz.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.kIz.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo kIU;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.kIU = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.kIM != null && this.kIU != null) {
                    h.this.kIM.a(this.position, this.kIU);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.kIU != null && h.this.kIN != null) {
                    h.this.kIN.b(this.position, this.kIU);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.kIM != null && this.kIU != null) {
                    h.this.kIM.a(this.position, this.kIU);
                }
            } else if (view.getId() == R.id.video_select && this.kIU != null && h.this.kIN != null) {
                h.this.kIN.b(this.position, this.kIU);
            }
        }
    }

    public boolean isScroll() {
        return this.axH;
    }

    public void bk(boolean z) {
        this.axH = z;
    }

    public void a(f fVar) {
        this.kIM = fVar;
    }

    public void a(g gVar) {
        this.kIN = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a {
        TbImageView kIR;
        TbCameraView kIS;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class d {
        ImageView axN;
        RelativeLayout axO;
        TbImageView fVW;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c {
        ImageView axN;
        TbImageView kIV;
        RelativeLayout kIW;
        TextView kIX;
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

    public void ag(View.OnClickListener onClickListener) {
        this.kIL = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.kIO = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.kIP = aVar;
    }

    public void tw(boolean z) {
        if (this.kIK != z) {
            this.kIK = z;
            notifyDataSetChanged();
        }
    }
}
