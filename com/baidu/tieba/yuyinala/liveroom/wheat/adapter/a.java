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
    private InterfaceC0936a osR;
    private int osS = -1;

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
        this.osS = i;
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
            bVar2.osW = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.osX = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            bVar2.osY = view.findViewById(a.f.margin_top_height);
            bVar2.osZ = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.ota = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.otb = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.otc = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.otd = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.otg = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.ote = (TextView) view.findViewById(a.f.tv_level);
            bVar2.otf = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oth = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oti = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.otj = (LinearLayout) view.findViewById(a.f.icon_container);
            bVar2.oti = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.otj = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        if (eVar != null) {
            if (!o.ebo().ebE()) {
                bVar.osW.setTextColor(bVar.osW.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.otb.setVisibility(8);
                bVar.osW.setTextSize(18.0f);
            } else {
                bVar.otb.setVisibility(0);
                bVar.osW.setTextColor(bVar.osW.getResources().getColor(a.c.sdk_white_alpha100));
                bVar.osW.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    bVar.otb.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    bVar.otb.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            bVar.osX.setBackgroundColor(this.osS == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            bVar.osW.setText(Integer.toString(eVar.mPos));
            bVar.osZ.setIsRound(true);
            bVar.osZ.setAutoChangeStyle(false);
            bVar.osZ.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                bVar.osZ.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.osZ.setUrl(eVar.mPortrait);
                bVar.osZ.startLoad(eVar.mPortrait, 12, false);
            }
            bVar.ota.setText(eVar.mUserName);
            bVar.otc.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                bVar.otd.setVisibility(8);
            } else {
                bVar.otd.setVisibility(0);
                bVar.otd.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            bVar.otf.setVisibility(8);
            bVar.oth.setVisibility(8);
            int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (eVar.mLiveMarkInfo != null) {
                i2 = d;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.otf.setVisibility(0);
                            bVar.otg.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.ote.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oth.setVisibility(0);
                            bVar.oth.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oth.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = d;
            }
            bVar.osZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.osR != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.osR.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.ota.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.osR != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.osR.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.osZ.setTag(eVar);
            bVar.ota.setTag(eVar);
            bVar.ota.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.otc.getMeasuredWidth() + i2 > bVar.oti.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ota.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.ota.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ota.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.ota.setLayoutParams(layoutParams2);
                }
            });
            bVar.osY.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes10.dex */
    private class b {
        private TextView osW;
        private LinearLayout osX;
        private View osY;
        private HeadImageView osZ;
        private TextView ota;
        private ImageView otb;
        private TextView otc;
        private ImageView otd;
        private TextView ote;
        private FrameLayout otf;
        private TbImageView otg;
        private TbImageView oth;
        private LinearLayout oti;
        private LinearLayout otj;

        private b() {
        }
    }

    public void a(InterfaceC0936a interfaceC0936a) {
        this.osR = interfaceC0936a;
    }
}
