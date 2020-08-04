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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import java.util.List;
/* loaded from: classes17.dex */
public class c extends BaseAdapter {
    private e dWk;
    private List<MusicData> mList;
    public int mdN;
    public String mdO;

    public c(e eVar) {
        this.dWk = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            OI(this.mdO);
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
            view = LayoutInflater.from(this.dWk.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.mcU = (TbImageView) view.findViewById(R.id.music_image);
            aVar.mcX = (TextView) view.findViewById(R.id.music_title);
            aVar.mcW = view.findViewById(R.id.music_loading);
            aVar.mcU.setDrawerType(1);
            aVar.mcU.setIsRound(true);
            aVar.mcU.setDefaultBgResource(R.color.transparent);
            aVar.mcU.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.mcU.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.mcU.setBorderWidth(l.getDimens(this.dWk.getPageActivity(), R.dimen.ds4));
            aVar.mcU.setBorderColor(ao.getColor(R.color.cp_link_tip_a));
            aVar.mcU.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.mcU.startLoad(String.valueOf(R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.mcU.startLoad(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.mcU.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.mcW.setVisibility(4);
            aVar.mcX.setTextColor(ao.getColor(R.color.cp_cont_j));
            aVar.mcX.setText(musicData.name);
            b(aVar.mcX, l.getDimens(this.dWk.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.mdN) {
                aVar.mcU.setDrawBorder(true);
            } else {
                aVar.mcU.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.dWk.getPageActivity(), R.dimen.ds34), l.getDimens(this.dWk.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.dWk.getPageActivity(), R.dimen.ds34), l.getDimens(this.dWk.getPageActivity(), R.dimen.ds44), l.getDimens(this.dWk.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.dWk.getPageActivity(), R.dimen.ds28), l.getDimens(this.dWk.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.dWk.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.dWk.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.dWk.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.dWk.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.dWk.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.dWk.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void Gv(int i) {
        this.mdN = i;
        notifyDataSetChanged();
    }

    public void OI(String str) {
        this.mdO = str;
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
            this.mdN = i;
        }
    }

    public int dqa() {
        return this.mdN;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.dWk.getPageActivity(), R.dimen.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(dimens);
            while (textPaint.measureText(str) > i) {
                dimens -= 1.0f;
                textPaint.setTextSize(dimens);
            }
            textView.setTextSize(0, dimens);
        }
    }

    /* loaded from: classes17.dex */
    public class a {
        public TbImageView mcU;
        public View mcW;
        public TextView mcX;

        public a() {
        }
    }
}
