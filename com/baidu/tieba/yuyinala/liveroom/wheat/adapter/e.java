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
    private static boolean oDo = true;
    private Context mContext;
    private ArrayList<AlaWheatInfoData> ajo = new ArrayList<>();
    private ArrayList<AlaWheatInfoData> oDn = new ArrayList<>();
    private a oDp = null;

    /* loaded from: classes11.dex */
    public interface a {
        void I(View view, int i);

        void notifyDataSetChanged();
    }

    public e(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.oDp = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.ajo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Mo */
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
                    boolean unused = e.oDo = e.oDo ? false : true;
                    e.this.zZ(e.oDo);
                } else {
                    AlaWheatInfoData item = e.this.getItem(i);
                    if (item != null) {
                        item.clearSelectFlag = item.clearSelectFlag ? false : true;
                        bVar.a(i, item);
                        e.this.ecu();
                    }
                }
                e.this.notifyDataSetChanged();
                if (e.this.oDp != null) {
                    e.this.oDp.I(view2, i);
                }
            }
        });
        bVar.a(i, getItem(i));
        return view;
    }

    public void ecr() {
        this.oDn.clear();
        for (int i = 0; i < this.ajo.size(); i++) {
            if (this.ajo.get(i) != null) {
                this.oDn.add((AlaWheatInfoData) this.ajo.get(i).clone());
            } else {
                this.oDn.add(null);
            }
        }
        this.ajo.clear();
        this.ajo.add(new AlaWheatInfoData());
        List<AlaWheatInfoData> arrayList = new ArrayList<>();
        if (q.edE().Yn() == null || q.edE().Yn().size() == 0) {
            arrayList.add(null);
        } else {
            arrayList = q.edE().Yn();
        }
        this.ajo.addAll(arrayList);
        this.ajo.addAll(q.edE().edH());
        for (int i2 = 0; i2 < this.ajo.size(); i2++) {
            AlaWheatInfoData alaWheatInfoData = this.ajo.get(i2);
            if (alaWheatInfoData != null) {
                if (oDo) {
                    alaWheatInfoData.clearSelectFlag = oDo;
                } else {
                    for (int i3 = 0; i3 < this.oDn.size(); i3++) {
                        AlaWheatInfoData alaWheatInfoData2 = this.oDn.get(i3);
                        if (alaWheatInfoData2 != null && TextUtils.equals(alaWheatInfoData.uk, alaWheatInfoData2.uk)) {
                            alaWheatInfoData.clearSelectFlag = alaWheatInfoData2.clearSelectFlag;
                        }
                    }
                }
            }
        }
        notifyDataSetChanged();
        if (this.oDp != null) {
            this.oDp.notifyDataSetChanged();
        }
    }

    public String ecs() {
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

    public boolean ect() {
        return oDo;
    }

    public void ecu() {
        if (this.ajo.size() > 1) {
            boolean z = true;
            for (int i = 1; i < this.ajo.size(); i++) {
                if (this.ajo.get(i) != null && !this.ajo.get(i).clearSelectFlag) {
                    z = false;
                }
            }
            oDo = z;
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
        public TextView hxZ;
        public boolean mSelected = false;
        public FrameLayout oDs;
        public ImageView oDt;
        public LinearLayout oDu;
        public TextView oDv;
        public TextView oDw;
        public LinearLayout oDx;
        public ImageView oDy;
        public AlaWheatInfoData oDz;

        public b(View view) {
            this.oDs = (FrameLayout) view.findViewById(a.f.user_avatar_container);
            this.bhm = (HeadImageView) view.findViewById(a.f.user_avatar);
            this.oDt = (ImageView) view.findViewById(a.f.user_avatar_circle);
            this.oDu = (LinearLayout) view.findViewById(a.f.user_label);
            this.oDv = (TextView) view.findViewById(a.f.tv_host_label);
            this.oDw = (TextView) view.findViewById(a.f.tv_anchor_label);
            this.oDx = (LinearLayout) view.findViewById(a.f.charm_container_ll);
            this.oDy = (ImageView) view.findViewById(a.f.iv_charm_icon);
            this.hxZ = (TextView) view.findViewById(a.f.tv_charm_value);
        }

        public void a(int i, AlaWheatInfoData alaWheatInfoData) {
            this.oDz = alaWheatInfoData;
            this.oDt.setVisibility(8);
            if (alaWheatInfoData != null) {
                this.oDu.setVisibility(0);
                if (i == 0) {
                    this.bhm.setIsRound(false);
                    this.bhm.setDrawBorder(false);
                    this.bhm.setAutoChangeStyle(false);
                    this.bhm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    this.bhm.setImageResource(e.oDo ? a.e.wheat_clear_all_selected : a.e.wheat_clear_all_unselect);
                    this.oDy.setVisibility(8);
                    this.hxZ.setText("全麦");
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
                    this.oDv.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oDw.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oDt.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.oDv.setVisibility(0);
                    this.oDw.setVisibility(8);
                    this.oDx.setVisibility(0);
                    this.oDy.setVisibility(0);
                    this.oDy.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.hxZ.setText(alaWheatInfoData.charmCount);
                    this.hxZ.setVisibility(0);
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
                    this.oDv.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oDw.setSelected(alaWheatInfoData.clearSelectFlag);
                    this.oDt.setVisibility(alaWheatInfoData.clearSelectFlag ? 0 : 8);
                    this.oDv.setVisibility(8);
                    this.oDw.setVisibility(0);
                    this.oDw.setText(Integer.toString(i - 1));
                    this.oDx.setVisibility(0);
                    this.oDy.setVisibility(0);
                    this.oDy.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
                    this.hxZ.setText(alaWheatInfoData.charmCount);
                    this.hxZ.setVisibility(0);
                    return;
                }
            }
            this.bhm.setIsRound(false);
            this.bhm.setDrawBorder(false);
            this.bhm.setAutoChangeStyle(false);
            this.bhm.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.bhm.setImageResource(a.e.wheat_clear_empty_icon);
            this.oDu.setVisibility(0);
            this.oDv.setVisibility(i == 1 ? 0 : 8);
            this.oDv.setSelected(false);
            this.oDw.setVisibility(i != 1 ? 0 : 8);
            this.oDw.setText(Integer.toString(i - 1));
            this.oDw.setSelected(false);
            this.oDx.setVisibility(4);
        }
    }
}
