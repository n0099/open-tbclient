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
/* loaded from: classes10.dex */
public class e extends BaseAdapter {
    private static boolean otD = true;
    private Context mContext;
    private ArrayList<AlaWheatInfoData> ajz = new ArrayList<>();
    private ArrayList<AlaWheatInfoData> otC = new ArrayList<>();
    private a otE = null;

    /* loaded from: classes10.dex */
    public interface a {
        void I(View view, int i);

        void notifyDataSetChanged();
    }

    public e(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.otE = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.ajz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: LT */
    public AlaWheatInfoData getItem(int i) {
        return (AlaWheatInfoData) ListUtils.getItem(this.ajz, i);
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
                    boolean unused = e.otD = e.otD ? false : true;
                    e.this.zD(e.otD);
                } else {
                    AlaWheatInfoData item = e.this.getItem(i);
                    if (item != null) {
                        item.clearSelectFlag = item.clearSelectFlag ? false : true;
                        bVar.a(i, item);
                        e.this.eah();
                    }
                }
                e.this.notifyDataSetChanged();
                if (e.this.otE != null) {
                    e.this.otE.I(view2, i);
                }
            }
        });
        bVar.a(i, getItem(i));
        return view;
    }

    public void eae() {
        this.otC.clear();
        for (int i = 0; i < this.ajz.size(); i++) {
            if (this.ajz.get(i) != null) {
                this.otC.add((AlaWheatInfoData) this.ajz.get(i).clone());
            } else {
                this.otC.add(null);
            }
        }
        this.ajz.clear();
        this.ajz.add(new AlaWheatInfoData());
        List<AlaWheatInfoData> arrayList = new ArrayList<>();
        if (o.ebo().Wx() == null || o.ebo().Wx().size() == 0) {
            arrayList.add(null);
        } else {
            arrayList = o.ebo().Wx();
        }
        this.ajz.addAll(arrayList);
        this.ajz.addAll(o.ebo().ebr());
        for (int i2 = 0; i2 < this.ajz.size(); i2++) {
            AlaWheatInfoData alaWheatInfoData = this.ajz.get(i2);
            if (alaWheatInfoData != null) {
                if (otD) {
                    alaWheatInfoData.clearSelectFlag = otD;
                } else {
                    for (int i3 = 0; i3 < this.otC.size(); i3++) {
                        AlaWheatInfoData alaWheatInfoData2 = this.otC.get(i3);
                        if (alaWheatInfoData2 != null && TextUtils.equals(alaWheatInfoData.uk, alaWheatInfoData2.uk)) {
                            alaWheatInfoData.clearSelectFlag = alaWheatInfoData2.clearSelectFlag;
                        }
                    }
                }
            }
        }
        notifyDataSetChanged();
        if (this.otE != null) {
            this.otE.notifyDataSetChanged();
        }
    }

    public String eaf() {
        int i = 1;
        StringBuilder sb = new StringBuilder();
        if (this.ajz.size() > 1) {
            while (true) {
                int i2 = i;
                if (i2 >= this.ajz.size()) {
                    break;
                }
                if (this.ajz.get(i2) != null && this.ajz.get(i2).clearSelectFlag) {
                    if (!sb.toString().isEmpty()) {
                        sb.append(",");
                    }
                    sb.append(this.ajz.get(i2).uk);
                }
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    public boolean eag() {
        return otD;
    }

    public void eah() {
        if (this.ajz.size() > 1) {
            boolean z = true;
            for (int i = 1; i < this.ajz.size(); i++) {
                if (this.ajz.get(i) != null && !this.ajz.get(i).clearSelectFlag) {
                    z = false;
                }
            }
            otD = z;
        }
    }

    public void zD(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ajz.size()) {
                if (this.ajz.get(i2) != null) {
                    this.ajz.get(i2).clearSelectFlag = z;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public HeadImageView bec;
        public TextView htP;
        public boolean mSelected = false;
        public FrameLayout otH;
        public ImageView otI;
        public LinearLayout otJ;
        public TextView otK;
        public TextView otL;
        public LinearLayout otM;
        public ImageView otN;
        public AlaWheatInfoData otO;

        public b(View view) {
            this.otH = (FrameLayout) view.findViewById(a.f.user_avatar_container);
            this.bec = (HeadImageView) view.findViewById(a.f.user_avatar);
            this.otI = (ImageView) view.findViewById(a.f.user_avatar_circle);
            this.otJ = (LinearLayout) view.findViewById(a.f.user_label);
            this.otK = (TextView) view.findViewById(a.f.tv_host_label);
            this.otL = (TextView) view.findViewById(a.f.tv_anchor_label);
            this.otM = (LinearLayout) view.findViewById(a.f.charm_container_ll);
            this.otN = (ImageView) view.findViewById(a.f.iv_charm_icon);
            this.htP = (TextView) view.findViewById(a.f.tv_charm_value);
        }

        public void a(int i, AlaWheatInfoData alaWheatInfoData) {
            this.otO = alaWheatInfoData;
            this.otI.setVisibility(8);
            if (alaWheatInfoData != null) {
                this.otJ.setVisibility(0);
                if (i == 0) {
                    this.bec.setIsRound(false);
                    this.bec.setDrawBorder(false);
                    this.bec.setAutoChangeStyle(false);
                    this.bec.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    this.bec.setImageResource(e.otD ? a.e.wheat_clear_all_selected : a.e.wheat_clear_all_unselect);
                    this.otN.setVisibility(8);
                    this.htP.setText("全麦");
                    return;
                } else if (i == 1) {
                    this.bec.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.bec.setBackgroundResource(0);
                    this.bec.setIsRound(true);
                    this.bec.setDrawBorder(false);
                    this.bec.setAutoChangeStyle(false);
                    this.bec.setDefaultResource(a.e.wheat_clear_empty_icon);
                    this.bec.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
                    this.bec.setImageResource(0);
                    this.bec.setUrl(alaWheatInfoData.portrait);
                    this.bec.startLoad(alaWheatInfoData.portrait, 12, false, false);
                    this.otK.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.otL.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.otI.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.otK.setVisibility(0);
                    this.otL.setVisibility(8);
                    this.otM.setVisibility(0);
                    this.otN.setVisibility(0);
                    this.otN.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.htP.setText(alaWheatInfoData.charmCount);
                    this.htP.setVisibility(0);
                    return;
                } else {
                    this.bec.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.bec.setBackgroundResource(0);
                    this.bec.setIsRound(true);
                    this.bec.setDrawBorder(false);
                    this.bec.setAutoChangeStyle(false);
                    this.bec.setDefaultResource(a.e.wheat_clear_empty_icon);
                    this.bec.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
                    this.bec.setImageResource(0);
                    this.bec.setUrl(alaWheatInfoData.portrait);
                    this.bec.startLoad(alaWheatInfoData.portrait, 12, false, false);
                    this.otK.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.otL.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.otI.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.otK.setVisibility(8);
                    this.otL.setVisibility(0);
                    this.otL.setText(Integer.toString(i - 1));
                    this.otM.setVisibility(0);
                    this.otN.setVisibility(0);
                    this.otN.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.htP.setText(alaWheatInfoData.charmCount);
                    this.htP.setVisibility(0);
                    return;
                }
            }
            this.bec.setIsRound(false);
            this.bec.setDrawBorder(false);
            this.bec.setAutoChangeStyle(false);
            this.bec.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.bec.setImageResource(a.e.wheat_clear_empty_icon);
            this.otJ.setVisibility(0);
            this.otK.setVisibility(i == 1 ? 0 : 8);
            this.otK.setSelected(false);
            this.otL.setVisibility(i != 1 ? 0 : 8);
            this.otL.setText(Integer.toString(i - 1));
            this.otL.setSelected(false);
            this.otM.setVisibility(4);
        }
    }
}
