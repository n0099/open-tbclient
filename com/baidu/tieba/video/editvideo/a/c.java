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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private e cRA;
    public int kvG;
    public String kvH;
    private List<MusicData> mList;

    public c(e eVar) {
        this.cRA = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            JL(this.kvH);
            notifyDataSetChanged();
        }
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
            view = LayoutInflater.from(this.cRA.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.kuR = (TbImageView) view.findViewById(R.id.music_image);
            aVar.kuU = (TextView) view.findViewById(R.id.music_title);
            aVar.kuT = view.findViewById(R.id.music_loading);
            aVar.kuR.setDrawerType(1);
            aVar.kuR.setIsRound(true);
            aVar.kuR.setDefaultBgResource(R.color.transparent);
            aVar.kuR.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.kuR.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.kuR.setBorderWidth(l.getDimens(this.cRA.getPageActivity(), R.dimen.ds4));
            aVar.kuR.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            aVar.kuR.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.kuR.startLoad(String.valueOf((int) R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.kuR.startLoad(String.valueOf((int) R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.kuR.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.kuT.setVisibility(4);
            aVar.kuU.setTextColor(am.getColor(R.color.cp_cont_j));
            aVar.kuU.setText(musicData.name);
            b(aVar.kuU, l.getDimens(this.cRA.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.kvG) {
                aVar.kuR.setDrawBorder(true);
            } else {
                aVar.kuR.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.cRA.getPageActivity(), R.dimen.ds34), l.getDimens(this.cRA.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.cRA.getPageActivity(), R.dimen.ds34), l.getDimens(this.cRA.getPageActivity(), R.dimen.ds44), l.getDimens(this.cRA.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.cRA.getPageActivity(), R.dimen.ds28), l.getDimens(this.cRA.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.cRA.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.cRA.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.cRA.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.cRA.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.cRA.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.cRA.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void Ds(int i) {
        this.kvG = i;
        notifyDataSetChanged();
    }

    public void JL(String str) {
        this.kvH = str;
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
            this.kvG = i;
        }
    }

    public int cOm() {
        return this.kvG;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.cRA.getPageActivity(), R.dimen.fontsize24);
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
        public TbImageView kuR;
        public View kuT;
        public TextView kuU;

        public a() {
        }
    }
}
