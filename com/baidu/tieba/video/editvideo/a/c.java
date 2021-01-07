package com.baidu.tieba.video.editvideo.a;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private f eXW;
    private List<MusicData> mList;
    public int nHb;
    public String nHc;

    public c(f fVar) {
        this.eXW = fVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            Uq(this.nHc);
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
            view = LayoutInflater.from(this.eXW.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.nGk = (TbImageView) view.findViewById(R.id.music_image);
            aVar.nGn = (TextView) view.findViewById(R.id.music_title);
            aVar.nGm = view.findViewById(R.id.music_loading);
            aVar.nGk.setDrawerType(1);
            aVar.nGk.setIsRound(true);
            aVar.nGk.setDefaultBgResource(R.color.transparent);
            aVar.nGk.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.nGk.setBorderWidth(l.getDimens(this.eXW.getPageActivity(), R.dimen.ds4));
            aVar.nGk.setBorderColor(ao.getColor(R.color.CAM_X0302));
            aVar.nGk.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.nGk.startLoad(String.valueOf(R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.nGk.startLoad(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.nGk.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.nGm.setVisibility(4);
            aVar.nGn.setTextColor(ao.getColor(R.color.CAM_X0107));
            aVar.nGn.setText(musicData.name);
            a(aVar.nGn, l.getDimens(this.eXW.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.nHb) {
                aVar.nGk.setDrawBorder(true);
            } else {
                aVar.nGk.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.eXW.getPageActivity(), R.dimen.ds34), l.getDimens(this.eXW.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.eXW.getPageActivity(), R.dimen.ds34), l.getDimens(this.eXW.getPageActivity(), R.dimen.ds44), l.getDimens(this.eXW.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.eXW.getPageActivity(), R.dimen.ds28), l.getDimens(this.eXW.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.eXW.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.eXW.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.eXW.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.eXW.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.eXW.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.eXW.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void LP(int i) {
        this.nHb = i;
        notifyDataSetChanged();
    }

    public void Uq(String str) {
        this.nHc = str;
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
            this.nHb = i;
        }
    }

    public int dUe() {
        return this.nHb;
    }

    public void a(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.eXW.getPageActivity(), R.dimen.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(dimens);
            while (textPaint.measureText(str) > i) {
                dimens -= 1.0f;
                textPaint.setTextSize(dimens);
            }
            textView.setTextSize(0, dimens);
        }
    }

    /* loaded from: classes8.dex */
    public class a {
        public TbImageView nGk;
        public View nGm;
        public TextView nGn;

        public a() {
        }
    }
}
