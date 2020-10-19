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
/* loaded from: classes23.dex */
public class c extends BaseAdapter {
    private e eul;
    private List<MusicData> mList;
    public int mVp;
    public String mVq;

    public c(e eVar) {
        this.eul = eVar;
    }

    public void setData(List<MusicData> list) {
        if (list != null) {
            this.mList = list;
            SU(this.mVq);
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
            view = LayoutInflater.from(this.eul.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
            aVar = new a();
            aVar.mUw = (TbImageView) view.findViewById(R.id.music_image);
            aVar.mUz = (TextView) view.findViewById(R.id.music_title);
            aVar.mUy = view.findViewById(R.id.music_loading);
            aVar.mUw.setDrawerType(1);
            aVar.mUw.setIsRound(true);
            aVar.mUw.setDefaultBgResource(R.color.transparent);
            aVar.mUw.setDefaultErrorResource(R.drawable.bg_video_cloudmusic);
            aVar.mUw.setDefaultResource(R.drawable.bg_video_cloudmusic);
            aVar.mUw.setBorderWidth(l.getDimens(this.eul.getPageActivity(), R.dimen.ds4));
            aVar.mUw.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            aVar.mUw.setConrers(15);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MusicData musicData = this.mList.get(i);
        if (musicData != null) {
            switch (musicData.editMusicType) {
                case 1:
                    aVar.mUw.startLoad(String.valueOf(R.drawable.icon_video_mute), 24, false);
                    break;
                case 2:
                    aVar.mUw.startLoad(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
                    break;
                default:
                    aVar.mUw.startLoad(musicData.img, 10, false);
                    break;
            }
            aVar.mUy.setVisibility(4);
            aVar.mUz.setTextColor(ap.getColor(R.color.cp_cont_j));
            aVar.mUz.setText(musicData.name);
            b(aVar.mUz, l.getDimens(this.eul.getPageActivity(), R.dimen.ds120), musicData.name);
            if (i == this.mVp) {
                aVar.mUw.setDrawBorder(true);
            } else {
                aVar.mUw.setDrawBorder(false);
            }
            if (i == 0) {
                view.setPadding(l.getDimens(this.eul.getPageActivity(), R.dimen.ds34), l.getDimens(this.eul.getPageActivity(), R.dimen.ds44), 0, 0);
            } else if (i == this.mList.size() - 1) {
                view.setPadding(l.getDimens(this.eul.getPageActivity(), R.dimen.ds34), l.getDimens(this.eul.getPageActivity(), R.dimen.ds44), l.getDimens(this.eul.getPageActivity(), R.dimen.ds34), 0);
            } else {
                view.setPadding(l.getDimens(this.eul.getPageActivity(), R.dimen.ds28), l.getDimens(this.eul.getPageActivity(), R.dimen.ds44), 0, 0);
            }
            if (this.eul.getPageActivity() instanceof BaseActivity) {
                ((BaseActivity) this.eul.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseActivity) this.eul.getPageActivity()).getLayoutMode().onModeChanged(view);
            } else if (this.eul.getPageActivity() instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) this.eul.getPageActivity()).getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
                ((BaseFragmentActivity) this.eul.getPageActivity()).getLayoutMode().onModeChanged(view);
            }
        }
        return view;
    }

    public void Kb(int i) {
        this.mVp = i;
        notifyDataSetChanged();
    }

    public void SU(String str) {
        this.mVq = str;
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
            this.mVp = i;
        }
    }

    public int dJk() {
        return this.mVp;
    }

    public void b(TextView textView, int i, String str) {
        if (i > 0) {
            float dimens = l.getDimens(this.eul.getPageActivity(), R.dimen.fontsize24);
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(dimens);
            while (textPaint.measureText(str) > i) {
                dimens -= 1.0f;
                textPaint.setTextSize(dimens);
            }
            textView.setTextSize(0, dimens);
        }
    }

    /* loaded from: classes23.dex */
    public class a {
        public TbImageView mUw;
        public View mUy;
        public TextView mUz;

        public a() {
        }
    }
}
