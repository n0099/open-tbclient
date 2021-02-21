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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes11.dex */
public class e extends BaseAdapter {
    private static boolean oDO = true;
    private Context mContext;
    private ArrayList<AlaWheatInfoData> ajo = new ArrayList<>();
    private ArrayList<AlaWheatInfoData> oDN = new ArrayList<>();
    private a oDP = null;

    /* loaded from: classes11.dex */
    public interface a {
        void I(View view, int i);

        void notifyDataSetChanged();
    }

    public e(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.oDP = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.ajo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Mp */
    public AlaWheatInfoData getItem(int i) {
        return (AlaWheatInfoData) ListUtils.getItem(this.ajo, i);
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
                    boolean unused = e.oDO = e.oDO ? false : true;
                    e.this.zZ(e.oDO);
                } else {
                    AlaWheatInfoData item = e.this.getItem(i);
                    if (item != null) {
                        item.clearSelectFlag = item.clearSelectFlag ? false : true;
                        bVar.a(i, item);
                        e.this.ecC();
                    }
                }
                e.this.notifyDataSetChanged();
                if (e.this.oDP != null) {
                    e.this.oDP.I(view2, i);
                }
            }
        });
        bVar.a(i, getItem(i));
        return view;
    }

    public void ecz() {
        this.oDN.clear();
        for (int i = 0; i < this.ajo.size(); i++) {
            if (this.ajo.get(i) != null) {
                this.oDN.add((AlaWheatInfoData) this.ajo.get(i).clone());
            } else {
                this.oDN.add(null);
            }
        }
        this.ajo.clear();
        this.ajo.add(new AlaWheatInfoData());
        List<AlaWheatInfoData> arrayList = new ArrayList<>();
        if (q.edM().Yn() == null || q.edM().Yn().size() == 0) {
            arrayList.add(null);
        } else {
            arrayList = q.edM().Yn();
        }
        this.ajo.addAll(arrayList);
        this.ajo.addAll(q.edM().edP());
        for (int i2 = 0; i2 < this.ajo.size(); i2++) {
            AlaWheatInfoData alaWheatInfoData = this.ajo.get(i2);
            if (alaWheatInfoData != null) {
                if (oDO) {
                    alaWheatInfoData.clearSelectFlag = oDO;
                } else {
                    for (int i3 = 0; i3 < this.oDN.size(); i3++) {
                        AlaWheatInfoData alaWheatInfoData2 = this.oDN.get(i3);
                        if (alaWheatInfoData2 != null && TextUtils.equals(alaWheatInfoData.uk, alaWheatInfoData2.uk)) {
                            alaWheatInfoData.clearSelectFlag = alaWheatInfoData2.clearSelectFlag;
                        }
                    }
                }
            }
        }
        notifyDataSetChanged();
        if (this.oDP != null) {
            this.oDP.notifyDataSetChanged();
        }
    }

    public String ecA() {
        int i = 1;
        ArrayList arrayList = new ArrayList();
        if (this.ajo.size() > 1) {
            while (true) {
                int i2 = i;
                if (i2 >= this.ajo.size()) {
                    break;
                }
                if (this.ajo.get(i2) != null && this.ajo.get(i2).clearSelectFlag) {
                    arrayList.add(this.ajo.get(i2).uk);
                }
                i = i2 + 1;
            }
        }
        return !ListUtils.isEmpty(arrayList) ? Arrays.toString(arrayList.toArray()) : "";
    }

    public boolean ecB() {
        return oDO;
    }

    public void ecC() {
        if (this.ajo.size() > 1) {
            boolean z = true;
            for (int i = 1; i < this.ajo.size(); i++) {
                if (this.ajo.get(i) != null && !this.ajo.get(i).clearSelectFlag) {
                    z = false;
                }
            }
            oDO = z;
        }
    }

    public void zZ(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ajo.size()) {
                if (this.ajo.get(i2) != null) {
                    this.ajo.get(i2).clearSelectFlag = z;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public HeadImageView bhm;
        public TextView hyn;
        public boolean mSelected = false;
        public FrameLayout oDS;
        public ImageView oDT;
        public LinearLayout oDU;
        public TextView oDV;
        public TextView oDW;
        public LinearLayout oDX;
        public ImageView oDY;
        public AlaWheatInfoData oDZ;

        public b(View view) {
            this.oDS = (FrameLayout) view.findViewById(a.f.user_avatar_container);
            this.bhm = (HeadImageView) view.findViewById(a.f.user_avatar);
            this.oDT = (ImageView) view.findViewById(a.f.user_avatar_circle);
            this.oDU = (LinearLayout) view.findViewById(a.f.user_label);
            this.oDV = (TextView) view.findViewById(a.f.tv_host_label);
            this.oDW = (TextView) view.findViewById(a.f.tv_anchor_label);
            this.oDX = (LinearLayout) view.findViewById(a.f.charm_container_ll);
            this.oDY = (ImageView) view.findViewById(a.f.iv_charm_icon);
            this.hyn = (TextView) view.findViewById(a.f.tv_charm_value);
        }

        public void a(int i, AlaWheatInfoData alaWheatInfoData) {
            this.oDZ = alaWheatInfoData;
            this.oDT.setVisibility(8);
            if (alaWheatInfoData != null) {
                this.oDU.setVisibility(0);
                if (i == 0) {
                    this.bhm.setIsRound(false);
                    this.bhm.setDrawBorder(false);
                    this.bhm.setAutoChangeStyle(false);
                    this.bhm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    this.bhm.setImageResource(e.oDO ? a.e.wheat_clear_all_selected : a.e.wheat_clear_all_unselect);
                    this.oDY.setVisibility(8);
                    this.hyn.setText("全麦");
                    return;
                } else if (i == 1) {
                    this.bhm.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.bhm.setBackgroundResource(0);
                    this.bhm.setIsRound(true);
                    this.bhm.setDrawBorder(false);
                    this.bhm.setAutoChangeStyle(false);
                    this.bhm.setDefaultResource(a.e.wheat_clear_empty_icon);
                    this.bhm.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
                    this.bhm.setImageResource(0);
                    this.bhm.setUrl(alaWheatInfoData.portrait);
                    this.bhm.startLoad(alaWheatInfoData.portrait, 12, false, false);
                    this.oDV.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oDW.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oDT.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.oDV.setVisibility(0);
                    this.oDW.setVisibility(8);
                    this.oDX.setVisibility(0);
                    this.oDY.setVisibility(0);
                    this.oDY.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.hyn.setText(alaWheatInfoData.charmCount);
                    this.hyn.setVisibility(0);
                    return;
                } else {
                    this.bhm.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.bhm.setBackgroundResource(0);
                    this.bhm.setIsRound(true);
                    this.bhm.setDrawBorder(false);
                    this.bhm.setAutoChangeStyle(false);
                    this.bhm.setDefaultResource(a.e.wheat_clear_empty_icon);
                    this.bhm.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
                    this.bhm.setImageResource(0);
                    this.bhm.setUrl(alaWheatInfoData.portrait);
                    this.bhm.startLoad(alaWheatInfoData.portrait, 12, false, false);
                    this.oDV.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oDW.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oDT.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.oDV.setVisibility(8);
                    this.oDW.setVisibility(0);
                    this.oDW.setText(Integer.toString(i - 1));
                    this.oDX.setVisibility(0);
                    this.oDY.setVisibility(0);
                    this.oDY.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.hyn.setText(alaWheatInfoData.charmCount);
                    this.hyn.setVisibility(0);
                    return;
                }
            }
            this.bhm.setIsRound(false);
            this.bhm.setDrawBorder(false);
            this.bhm.setAutoChangeStyle(false);
            this.bhm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.bhm.setImageResource(a.e.wheat_clear_empty_icon);
            this.oDU.setVisibility(0);
            this.oDV.setVisibility(i == 1 ? 0 : 8);
            this.oDV.setSelected(false);
            this.oDW.setVisibility(i != 1 ? 0 : 8);
            this.oDW.setText(Integer.toString(i - 1));
            this.oDW.setSelected(false);
            this.oDX.setVisibility(4);
        }
    }
}
