package com.baidu.tieba.yuyinala.liveroom.wheat.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends BaseAdapter {
    private static boolean oyi = true;
    private Context mContext;
    private ArrayList<AlaWheatInfoData> akq = new ArrayList<>();
    private ArrayList<AlaWheatInfoData> oyh = new ArrayList<>();
    private a oyj = null;

    /* loaded from: classes11.dex */
    public interface a {
        void I(View view, int i);

        void notifyDataSetChanged();
    }

    public e(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.oyj = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.akq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: NA */
    public AlaWheatInfoData getItem(int i) {
        return (AlaWheatInfoData) ListUtils.getItem(this.akq, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.yuyinala_wheat_clear_item_layout, (ViewGroup) null);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (i == 0) {
                    boolean unused = e.oyi = e.oyi ? false : true;
                    e.this.zH(e.oyi);
                } else {
                    AlaWheatInfoData item = e.this.getItem(i);
                    if (item != null) {
                        item.clearSelectFlag = item.clearSelectFlag ? false : true;
                        bVar.a(i, item);
                        e.this.edZ();
                    }
                }
                e.this.notifyDataSetChanged();
                if (e.this.oyj != null) {
                    e.this.oyj.I(view2, i);
                }
            }
        });
        bVar.a(i, getItem(i));
        return view;
    }

    public void edW() {
        this.oyh.clear();
        for (int i = 0; i < this.akq.size(); i++) {
            if (this.akq.get(i) != null) {
                this.oyh.add((AlaWheatInfoData) this.akq.get(i).clone());
            } else {
                this.oyh.add(null);
            }
        }
        this.akq.clear();
        this.akq.add(new AlaWheatInfoData());
        List<AlaWheatInfoData> arrayList = new ArrayList<>();
        if (o.efg().aaq() == null || o.efg().aaq().size() == 0) {
            arrayList.add(null);
        } else {
            arrayList = o.efg().aaq();
        }
        this.akq.addAll(arrayList);
        this.akq.addAll(o.efg().efj());
        for (int i2 = 0; i2 < this.akq.size(); i2++) {
            AlaWheatInfoData alaWheatInfoData = this.akq.get(i2);
            if (alaWheatInfoData != null) {
                if (oyi) {
                    alaWheatInfoData.clearSelectFlag = oyi;
                } else {
                    for (int i3 = 0; i3 < this.oyh.size(); i3++) {
                        AlaWheatInfoData alaWheatInfoData2 = this.oyh.get(i3);
                        if (alaWheatInfoData2 != null && TextUtils.equals(alaWheatInfoData.uk, alaWheatInfoData2.uk)) {
                            alaWheatInfoData.clearSelectFlag = alaWheatInfoData2.clearSelectFlag;
                        }
                    }
                }
            }
        }
        notifyDataSetChanged();
        if (this.oyj != null) {
            this.oyj.notifyDataSetChanged();
        }
    }

    public String edX() {
        int i = 1;
        StringBuilder sb = new StringBuilder();
        if (this.akq.size() > 1) {
            while (true) {
                int i2 = i;
                if (i2 >= this.akq.size()) {
                    break;
                }
                if (this.akq.get(i2) != null && this.akq.get(i2).clearSelectFlag) {
                    if (!sb.toString().isEmpty()) {
                        sb.append(",");
                    }
                    sb.append(this.akq.get(i2).uk);
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    public boolean edY() {
        return oyi;
    }

    public void edZ() {
        if (this.akq.size() > 1) {
            boolean z = true;
            for (int i = 1; i < this.akq.size(); i++) {
                if (this.akq.get(i) != null && !this.akq.get(i).clearSelectFlag) {
                    z = false;
                }
            }
            oyi = z;
        }
    }

    public void zH(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.akq.size()) {
                if (this.akq.get(i2) != null) {
                    this.akq.get(i2).clearSelectFlag = z;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public HeadImageView biV;
        public TextView hyv;
        public boolean mSelected = false;
        public FrameLayout oym;
        public ImageView oyn;
        public LinearLayout oyo;
        public TextView oyp;
        public TextView oyq;
        public LinearLayout oyr;
        public ImageView oys;
        public AlaWheatInfoData oyt;

        public b(View view) {
            this.oym = (FrameLayout) view.findViewById(a.f.user_avatar_container);
            this.biV = (HeadImageView) view.findViewById(a.f.user_avatar);
            this.oyn = (ImageView) view.findViewById(a.f.user_avatar_circle);
            this.oyo = (LinearLayout) view.findViewById(a.f.user_label);
            this.oyp = (TextView) view.findViewById(a.f.tv_host_label);
            this.oyq = (TextView) view.findViewById(a.f.tv_anchor_label);
            this.oyr = (LinearLayout) view.findViewById(a.f.charm_container_ll);
            this.oys = (ImageView) view.findViewById(a.f.iv_charm_icon);
            this.hyv = (TextView) view.findViewById(a.f.tv_charm_value);
        }

        public void a(int i, AlaWheatInfoData alaWheatInfoData) {
            this.oyt = alaWheatInfoData;
            this.oyn.setVisibility(8);
            if (alaWheatInfoData != null) {
                this.oyo.setVisibility(0);
                if (i == 0) {
                    this.biV.setIsRound(false);
                    this.biV.setDrawBorder(false);
                    this.biV.setAutoChangeStyle(false);
                    this.biV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    this.biV.setImageResource(e.oyi ? a.e.wheat_clear_all_selected : a.e.wheat_clear_all_unselect);
                    this.oys.setVisibility(8);
                    this.hyv.setText("全麦");
                    return;
                } else if (i == 1) {
                    this.biV.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.biV.setBackgroundResource(0);
                    this.biV.setIsRound(true);
                    this.biV.setDrawBorder(false);
                    this.biV.setAutoChangeStyle(false);
                    this.biV.setDefaultResource(a.e.wheat_clear_empty_icon);
                    this.biV.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
                    this.biV.setImageResource(0);
                    this.biV.setUrl(alaWheatInfoData.portrait);
                    this.biV.startLoad(alaWheatInfoData.portrait, 12, false, false);
                    this.oyp.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oyq.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oyn.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.oyp.setVisibility(0);
                    this.oyq.setVisibility(8);
                    this.oyr.setVisibility(0);
                    this.oys.setVisibility(0);
                    this.oys.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.hyv.setText(alaWheatInfoData.charmCount);
                    this.hyv.setVisibility(0);
                    return;
                } else {
                    this.biV.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.biV.setBackgroundResource(0);
                    this.biV.setIsRound(true);
                    this.biV.setDrawBorder(false);
                    this.biV.setAutoChangeStyle(false);
                    this.biV.setDefaultResource(a.e.wheat_clear_empty_icon);
                    this.biV.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
                    this.biV.setImageResource(0);
                    this.biV.setUrl(alaWheatInfoData.portrait);
                    this.biV.startLoad(alaWheatInfoData.portrait, 12, false, false);
                    this.oyp.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oyq.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oyn.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.oyp.setVisibility(8);
                    this.oyq.setVisibility(0);
                    this.oyq.setText(Integer.toString(i - 1));
                    this.oyr.setVisibility(0);
                    this.oys.setVisibility(0);
                    this.oys.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.hyv.setText(alaWheatInfoData.charmCount);
                    this.hyv.setVisibility(0);
                    return;
                }
            }
            this.biV.setIsRound(false);
            this.biV.setDrawBorder(false);
            this.biV.setAutoChangeStyle(false);
            this.biV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.biV.setImageResource(a.e.wheat_clear_empty_icon);
            this.oyo.setVisibility(0);
            this.oyp.setVisibility(i == 1 ? 0 : 8);
            this.oyp.setSelected(false);
            this.oyq.setVisibility(i != 1 ? 0 : 8);
            this.oyq.setText(Integer.toString(i - 1));
            this.oyq.setSelected(false);
            this.oyr.setVisibility(4);
        }
    }
}
