package com.baidu.tieba.yuyinala.liveroom.wheat.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private Context context;
    private List<com.baidu.live.data.e> mList;
    private InterfaceC0936a osS;
    private int osT = -1;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0936a {
        void a(com.baidu.live.data.e eVar);
    }

    public a(Context context) {
        this.context = context;
    }

    public void setData(List<com.baidu.live.data.e> list, int i) {
        this.mList = list;
        this.osT = i;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList != null) {
            return this.mList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        final b bVar;
        final int i2;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply_2, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.osX = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.osY = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            bVar2.osZ = view.findViewById(a.f.margin_top_height);
            bVar2.ota = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.otb = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.otc = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.otd = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.ote = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oth = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.otf = (TextView) view.findViewById(a.f.tv_level);
            bVar2.otg = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oti = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.otj = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.otk = (LinearLayout) view.findViewById(a.f.icon_container);
            bVar2.otj = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.otk = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        if (eVar != null) {
            if (!o.ebo().ebE()) {
                bVar.osX.setTextColor(bVar.osX.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.otc.setVisibility(8);
                bVar.osX.setTextSize(18.0f);
            } else {
                bVar.otc.setVisibility(0);
                bVar.osX.setTextColor(bVar.osX.getResources().getColor(a.c.sdk_white_alpha100));
                bVar.osX.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    bVar.otc.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    bVar.otc.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            bVar.osY.setBackgroundColor(this.osT == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            bVar.osX.setText(Integer.toString(eVar.mPos));
            bVar.ota.setIsRound(true);
            bVar.ota.setAutoChangeStyle(false);
            bVar.ota.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                bVar.ota.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.ota.setUrl(eVar.mPortrait);
                bVar.ota.startLoad(eVar.mPortrait, 12, false);
            }
            bVar.otb.setText(eVar.mUserName);
            bVar.otd.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                bVar.ote.setVisibility(8);
            } else {
                bVar.ote.setVisibility(0);
                bVar.ote.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            bVar.otg.setVisibility(8);
            bVar.oti.setVisibility(8);
            int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (eVar.mLiveMarkInfo != null) {
                i2 = d;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.otg.setVisibility(0);
                            bVar.oth.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.otf.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oti.setVisibility(0);
                            bVar.oti.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oti.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = d;
            }
            bVar.ota.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.osS != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.osS.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.otb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.osS != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.osS.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.ota.setTag(eVar);
            bVar.otb.setTag(eVar);
            bVar.otb.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.otd.getMeasuredWidth() + i2 > bVar.otj.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.otb.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.otb.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.otb.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.otb.setLayoutParams(layoutParams2);
                }
            });
            bVar.osZ.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes10.dex */
    private class b {
        private TextView osX;
        private LinearLayout osY;
        private View osZ;
        private HeadImageView ota;
        private TextView otb;
        private ImageView otc;
        private TextView otd;
        private ImageView ote;
        private TextView otf;
        private FrameLayout otg;
        private TbImageView oth;
        private TbImageView oti;
        private LinearLayout otj;
        private LinearLayout otk;

        private b() {
        }
    }

    public void a(InterfaceC0936a interfaceC0936a) {
        this.osS = interfaceC0936a;
    }
}
