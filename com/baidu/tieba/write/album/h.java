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
/* loaded from: classes2.dex */
public class h extends BaseAdapter {
    private com.baidu.tieba.write.album.c lRE;
    private View.OnClickListener lRG;
    private f lRH;
    private g lRI;
    private TbCameraView.c lRJ;
    private TbCameraView.a lRK;
    private a lRL;
    private AlbumActivity lRt;
    private LayoutInflater mLayoutInflater;
    private final List<MediaFileInfo> mDataList = new ArrayList();
    private boolean bdZ = false;
    private boolean lRF = true;

    public TbCameraView dmK() {
        if (this.lRL != null) {
            return this.lRL.lRN;
        }
        return null;
    }

    public h(AlbumActivity albumActivity, com.baidu.tieba.write.album.c cVar) {
        this.lRt = albumActivity;
        this.lRE = cVar;
        this.mLayoutInflater = LayoutInflater.from(this.lRt.getPageContext().getPageActivity());
    }

    public void setData(List<MediaFileInfo> list) {
        this.mDataList.clear();
        if (this.lRF) {
            this.mDataList.add(dmL());
        }
        if (!v.isEmpty(list)) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    private MediaFileInfo dmL() {
        return new AddMediaInfo();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: FA */
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
            if (this.lRL == null || this.lRL.lRN == null) {
                this.lRL = new a();
                View inflate = this.mLayoutInflater.inflate(R.layout.album_make_picture_view, viewGroup, false);
                this.lRL.rootView = inflate;
                this.lRL.lRN = (TbCameraView) inflate.findViewById(R.id.camera_surfaceview);
                this.lRL.lRM = (TbImageView) inflate.findViewById(R.id.icon_make_photo);
                this.lRL.lRM.setDefaultResource(0);
                this.lRL.lRM.setDefaultErrorResource(0);
                this.lRL.lRM.setGifIconSupport(false);
                this.lRL.lRM.setLongIconSupport(false);
                inflate.setTag(this.lRL);
                this.lRt.showTip(this.lRL.lRM);
            }
            this.lRL.lRN.setOnRequestPermissionListener(this.lRJ);
            this.lRL.lRN.setOnOpenCameraFailedListener(this.lRK);
            this.lRL.lRM.setOnClickListener(this.lRG);
            this.lRL.lRN.setOnClickListener(this.lRG);
            this.lRL.rootView.setOnClickListener(this.lRG);
            am.setImageResource(this.lRL.lRM, R.drawable.icon_album_camera);
            am.setBackgroundColor(this.lRL.rootView, R.color.black_alpha90);
            return this.lRL.rootView;
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
                dVar2.haf = (TbImageView) view.findViewById(R.id.pic);
                dVar2.haf.setDefaultResource(0);
                dVar2.haf.setDefaultErrorResource(0);
                dVar2.haf.setTagPaddingDis(8, 8);
                dVar2.haf.setGifIconSupport(true);
                dVar2.haf.setLongIconSupport(true);
                dVar2.bef = (ImageView) view.findViewById(R.id.select_icon);
                dVar2.beh = (RelativeLayout) view.findViewById(R.id.lay_select);
                if (this.lRE != null && this.lRE.getWriteImagesInfo() != null && this.lRE.getWriteImagesInfo().isFromQRCode()) {
                    dVar2.beh.setVisibility(8);
                }
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.haf.setIsLongPic(imageFileInfo.isLong());
            dVar.haf.startLoad(imageFileInfo.getFilePath(), 35, false);
            a(dVar.bef, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            dVar.haf.setOnClickListener(bVar);
            dVar.beh.setOnClickListener(bVar);
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
                cVar2.lRQ = (TbImageView) view.findViewById(R.id.video_thumb);
                cVar2.lRQ.setDefaultResource(0);
                cVar2.lRQ.setDefaultErrorResource(0);
                cVar2.lRQ.setTagPaddingDis(8, 8);
                cVar2.lRQ.setGifIconSupport(false);
                cVar2.lRQ.setLongIconSupport(false);
                cVar2.bef = (ImageView) view.findViewById(R.id.select_icon);
                cVar2.lRR = (RelativeLayout) view.findViewById(R.id.video_select);
                cVar2.lRS = (TextView) view.findViewById(R.id.video_play_time);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.lRQ.startLoad(videoFileInfo.videoPath, 37, false);
            cVar.lRS.setText(aq.stringForVideoTime(videoFileInfo.videoDuration));
            a(cVar.bef, mediaFileInfo);
            b bVar = new b(mediaFileInfo, i);
            cVar.lRQ.setOnClickListener(bVar);
            cVar.lRR.setOnClickListener(bVar);
        }
        return view;
    }

    private void a(ImageView imageView, MediaFileInfo mediaFileInfo) {
        boolean z = false;
        if (this.lRE != null && (mediaFileInfo instanceof ImageFileInfo)) {
            z = this.lRE.isAdded((ImageFileInfo) mediaFileInfo);
        } else if (this.lRE != null && (mediaFileInfo instanceof VideoFileInfo)) {
            z = this.lRE.b((VideoFileInfo) mediaFileInfo);
        }
        b(imageView, z);
    }

    public void b(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setContentDescription(this.lRt.getResources().getString(R.string.check_box_checked));
                am.setImageResource(imageView, R.drawable.icon_list_select_ok_n);
                return;
            }
            imageView.setContentDescription(this.lRt.getResources().getString(R.string.check_box_not_checked));
            am.setImageResource(imageView, R.drawable.icon_list_select_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private MediaFileInfo lRP;
        private int position;

        public b(MediaFileInfo mediaFileInfo, int i) {
            this.lRP = mediaFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.pic) {
                if (h.this.lRH != null && this.lRP != null) {
                    h.this.lRH.a(this.position, this.lRP);
                }
            } else if (view.getId() == R.id.lay_select) {
                if (this.lRP != null && h.this.lRI != null) {
                    h.this.lRI.b(this.position, this.lRP);
                }
            } else if (view.getId() == R.id.video_thumb) {
                if (h.this.lRH != null && this.lRP != null) {
                    h.this.lRH.a(this.position, this.lRP);
                }
            } else if (view.getId() == R.id.video_select && this.lRP != null && h.this.lRI != null) {
                h.this.lRI.b(this.position, this.lRP);
            }
        }
    }

    public boolean isScroll() {
        return this.bdZ;
    }

    public void cl(boolean z) {
        this.bdZ = z;
    }

    public void a(f fVar) {
        this.lRH = fVar;
    }

    public void a(g gVar) {
        this.lRI = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TbImageView lRM;
        TbCameraView lRN;
        View rootView;

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        ImageView bef;
        RelativeLayout beh;
        TbImageView haf;
        View rootView;

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        ImageView bef;
        TbImageView lRQ;
        RelativeLayout lRR;
        TextView lRS;
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

    public void ai(View.OnClickListener onClickListener) {
        this.lRG = onClickListener;
    }

    public void setOnRequestPermissionListener(TbCameraView.c cVar) {
        this.lRJ = cVar;
    }

    public void setOnOpenCameraFailedListener(TbCameraView.a aVar) {
        this.lRK = aVar;
    }

    public void vr(boolean z) {
        if (this.lRF != z) {
            this.lRF = z;
            notifyDataSetChanged();
        }
    }
}
