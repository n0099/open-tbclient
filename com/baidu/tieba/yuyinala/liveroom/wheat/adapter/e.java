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
/* loaded from: classes10.dex */
public class e extends BaseAdapter {
    private static boolean oFT = true;
    private Context mContext;
    private ArrayList<AlaWheatInfoData> akG = new ArrayList<>();
    private ArrayList<AlaWheatInfoData> oFS = new ArrayList<>();
    private a oFU = null;

    /* loaded from: classes10.dex */
    public interface a {
        void I(View view, int i);

        void notifyDataSetChanged();
    }

    public e(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.oFU = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.akG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Mt */
    public AlaWheatInfoData getItem(int i) {
        return (AlaWheatInfoData) ListUtils.getItem(this.akG, i);
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
                    boolean unused = e.oFT = e.oFT ? false : true;
                    e.this.zY(e.oFT);
                } else {
                    AlaWheatInfoData item = e.this.getItem(i);
                    if (item != null) {
                        item.clearSelectFlag = item.clearSelectFlag ? false : true;
                        bVar.a(i, item);
                        e.this.ecK();
                    }
                }
                e.this.notifyDataSetChanged();
                if (e.this.oFU != null) {
                    e.this.oFU.I(view2, i);
                }
            }
        });
        bVar.a(i, getItem(i));
        return view;
    }

    public void ecH() {
        this.oFS.clear();
        for (int i = 0; i < this.akG.size(); i++) {
            if (this.akG.get(i) != null) {
                this.oFS.add((AlaWheatInfoData) this.akG.get(i).clone());
            } else {
                this.oFS.add(null);
            }
        }
        this.akG.clear();
        this.akG.add(new AlaWheatInfoData());
        List<AlaWheatInfoData> arrayList = new ArrayList<>();
        if (q.edU().Yq() == null || q.edU().Yq().size() == 0) {
            arrayList.add(null);
        } else {
            arrayList = q.edU().Yq();
        }
        this.akG.addAll(arrayList);
        this.akG.addAll(q.edU().edX());
        for (int i2 = 0; i2 < this.akG.size(); i2++) {
            AlaWheatInfoData alaWheatInfoData = this.akG.get(i2);
            if (alaWheatInfoData != null) {
                if (oFT) {
                    alaWheatInfoData.clearSelectFlag = oFT;
                } else {
                    for (int i3 = 0; i3 < this.oFS.size(); i3++) {
                        AlaWheatInfoData alaWheatInfoData2 = this.oFS.get(i3);
                        if (alaWheatInfoData2 != null && TextUtils.equals(alaWheatInfoData.uk, alaWheatInfoData2.uk)) {
                            alaWheatInfoData.clearSelectFlag = alaWheatInfoData2.clearSelectFlag;
                        }
                    }
                }
            }
        }
        notifyDataSetChanged();
        if (this.oFU != null) {
            this.oFU.notifyDataSetChanged();
        }
    }

    public String ecI() {
        int i = 1;
        ArrayList arrayList = new ArrayList();
        if (this.akG.size() > 1) {
            while (true) {
                int i2 = i;
                if (i2 >= this.akG.size()) {
                    break;
                }
                if (this.akG.get(i2) != null && this.akG.get(i2).clearSelectFlag) {
                    arrayList.add(this.akG.get(i2).uk);
                }
                i = i2 + 1;
            }
        }
        return !ListUtils.isEmpty(arrayList) ? Arrays.toString(arrayList.toArray()) : "";
    }

    public boolean ecJ() {
        return oFT;
    }

    public void ecK() {
        if (this.akG.size() > 1) {
            boolean z = true;
            for (int i = 1; i < this.akG.size(); i++) {
                if (this.akG.get(i) != null && !this.akG.get(i).clearSelectFlag) {
                    z = false;
                }
            }
            oFT = z;
        }
    }

    public void zY(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.akG.size()) {
                if (this.akG.get(i2) != null) {
                    this.akG.get(i2).clearSelectFlag = z;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public HeadImageView biO;
        public TextView hzW;
        public boolean mSelected = false;
        public FrameLayout oFX;
        public ImageView oFY;
        public LinearLayout oFZ;
        public TextView oGa;
        public TextView oGb;
        public LinearLayout oGc;
        public ImageView oGd;
        public AlaWheatInfoData oGe;

        public b(View view) {
            this.oFX = (FrameLayout) view.findViewById(a.f.user_avatar_container);
            this.biO = (HeadImageView) view.findViewById(a.f.user_avatar);
            this.oFY = (ImageView) view.findViewById(a.f.user_avatar_circle);
            this.oFZ = (LinearLayout) view.findViewById(a.f.user_label);
            this.oGa = (TextView) view.findViewById(a.f.tv_host_label);
            this.oGb = (TextView) view.findViewById(a.f.tv_anchor_label);
            this.oGc = (LinearLayout) view.findViewById(a.f.charm_container_ll);
            this.oGd = (ImageView) view.findViewById(a.f.iv_charm_icon);
            this.hzW = (TextView) view.findViewById(a.f.tv_charm_value);
        }

        public void a(int i, AlaWheatInfoData alaWheatInfoData) {
            this.oGe = alaWheatInfoData;
            this.oFY.setVisibility(8);
            if (alaWheatInfoData != null) {
                this.oFZ.setVisibility(0);
                if (i == 0) {
                    this.biO.setIsRound(false);
                    this.biO.setDrawBorder(false);
                    this.biO.setAutoChangeStyle(false);
                    this.biO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    this.biO.setImageResource(e.oFT ? a.e.wheat_clear_all_selected : a.e.wheat_clear_all_unselect);
                    this.oGd.setVisibility(8);
                    this.hzW.setText("全麦");
                    return;
                } else if (i == 1) {
                    this.biO.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.biO.setBackgroundResource(0);
                    this.biO.setIsRound(true);
                    this.biO.setDrawBorder(false);
                    this.biO.setAutoChangeStyle(false);
                    this.biO.setDefaultResource(a.e.wheat_clear_empty_icon);
                    this.biO.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
                    this.biO.setImageResource(0);
                    this.biO.setUrl(alaWheatInfoData.portrait);
                    this.biO.startLoad(alaWheatInfoData.portrait, 12, false, false);
                    this.oGa.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oGb.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oFY.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.oGa.setVisibility(0);
                    this.oGb.setVisibility(8);
                    this.oGc.setVisibility(0);
                    this.oGd.setVisibility(0);
                    this.oGd.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.hzW.setText(alaWheatInfoData.charmCount);
                    this.hzW.setVisibility(0);
                    return;
                } else {
                    this.biO.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.biO.setBackgroundResource(0);
                    this.biO.setIsRound(true);
                    this.biO.setDrawBorder(false);
                    this.biO.setAutoChangeStyle(false);
                    this.biO.setDefaultResource(a.e.wheat_clear_empty_icon);
                    this.biO.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
                    this.biO.setImageResource(0);
                    this.biO.setUrl(alaWheatInfoData.portrait);
                    this.biO.startLoad(alaWheatInfoData.portrait, 12, false, false);
                    this.oGa.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oGb.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oFY.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.oGa.setVisibility(8);
                    this.oGb.setVisibility(0);
                    this.oGb.setText(Integer.toString(i - 1));
                    this.oGc.setVisibility(0);
                    this.oGd.setVisibility(0);
                    this.oGd.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.hzW.setText(alaWheatInfoData.charmCount);
                    this.hzW.setVisibility(0);
                    return;
                }
            }
            this.biO.setIsRound(false);
            this.biO.setDrawBorder(false);
            this.biO.setAutoChangeStyle(false);
            this.biO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.biO.setImageResource(a.e.wheat_clear_empty_icon);
            this.oFZ.setVisibility(0);
            this.oGa.setVisibility(i == 1 ? 0 : 8);
            this.oGa.setSelected(false);
            this.oGb.setVisibility(i != 1 ? 0 : 8);
            this.oGb.setText(Integer.toString(i - 1));
            this.oGb.setSelected(false);
            this.oGc.setVisibility(4);
        }
    }
}
