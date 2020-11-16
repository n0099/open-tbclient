package com.baidu.tieba.video.editvideo.a;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes22.dex */
public class c extends BaseAdapter {
    private e eGT;
    private List<MusicData> mList;
    public int noU;
    public String noV;

    public c(e eVar) {
        this.eGT = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            Tv(this.noV);
            notifyDataSetChanged();
        }
    }

    public List<MusicData> getData() {
        return this.mList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.eGT.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.nnZ = (TbImageView) view.findViewById(R.id.music_image);
            aVar.noc = (TextView) view.findViewById(R.id.music_title);
            aVar.nob = view.findViewById(R.id.music_loading);
            aVar.nnZ.setDrawerType(1);
            aVar.nnZ.setIsRound(true);
            aVar.nnZ.setDefaultBgResource(R.color.transparent);
            aVar.nnZ.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.nnZ.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.nnZ.setBorderWidth(l.getDimens(this.eGT.getPageActivity(), R.dimen.ds4));
            aVar.nnZ.setBorderColor(ap.getColor(R.color.CAM_X0302));
            aVar.nnZ.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.nnZ.startLoad(String.valueOf(R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.nnZ.startLoad(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.nnZ.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.nob.setVisibility(4);
            aVar.noc.setTextColor(ap.getColor(R.color.CAM_X0107));
            aVar.noc.setText(musicData.name);
            a(aVar.noc, l.getDimens(this.eGT.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.noU) {
                aVar.nnZ.setDrawBorder(true);
            } else {
                aVar.nnZ.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.eGT.getPageActivity(), R.dimen.ds34), l.getDimens(this.eGT.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.eGT.getPageActivity(), R.dimen.ds34), l.getDimens(this.eGT.getPageActivity(), R.dimen.ds44), l.getDimens(this.eGT.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.eGT.getPageActivity(), R.dimen.ds28), l.getDimens(this.eGT.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.eGT.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.eGT.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.eGT.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.eGT.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.eGT.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.eGT.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void Lj(int i) {
        this.noU = i;
        notifyDataSetChanged();
    }

    public void Tv(String str) {
        this.noV = str;
        if (!TextUtils.isEmpty(str) && this.mList != null) {
            int i = -1;
            for (int i2 = 0; i2 < this.mList.size(); i2++) {
                if (str.equals(this.mList.get(i2).id)) {
                    i = i2;
                }
            }
            if (i == -1) {
                i = 1;
            }
            this.noU = i;
        }
    }

    public int dOT() {
        return this.noU;
    }

    public void a(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.eGT.getPageActivity(), R.dimen.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(dimens);
            while (textPaint.measureText(str) > i) {
                dimens -= 1.0f;
                textPaint.setTextSize(dimens);
            }
            textView.setTextSize(0, dimens);
        }
    }

    /* loaded from: classes22.dex */
    public class a {
        public TbImageView nnZ;
        public View nob;
        public TextView noc;

        public a() {
        }
    }
}
