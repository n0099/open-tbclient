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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private Context context;
    private List<com.baidu.live.data.e> mList;
    private InterfaceC0942a oDd;
    private int oDe = -1;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0942a {
        void a(com.baidu.live.data.e eVar);
    }

    public a(Context context) {
        this.context = context;
    }

    public void setData(List<com.baidu.live.data.e> list, int i) {
        this.mList = list;
        this.oDe = i;
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
            bVar2.oDi = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oDj = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            bVar2.oDk = view.findViewById(a.f.margin_top_height);
            bVar2.oDl = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oDm = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oDn = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.oDo = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oDp = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oDs = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oDq = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oDr = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oDt = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oDu = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oDv = (LinearLayout) view.findViewById(a.f.icon_container);
            bVar2.oDu = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oDv = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        if (eVar != null) {
            if (!q.edM().edZ()) {
                bVar.oDi.setTextColor(bVar.oDi.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.oDn.setVisibility(8);
                bVar.oDi.setTextSize(18.0f);
            } else {
                bVar.oDn.setVisibility(0);
                bVar.oDi.setTextColor(bVar.oDi.getResources().getColor(a.c.sdk_white_alpha100));
                bVar.oDi.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    bVar.oDn.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    bVar.oDn.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            bVar.oDj.setBackgroundColor(this.oDe == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            bVar.oDi.setText(Integer.toString(eVar.mPos));
            bVar.oDl.setIsRound(true);
            bVar.oDl.setAutoChangeStyle(false);
            bVar.oDl.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                bVar.oDl.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oDl.setUrl(eVar.mPortrait);
                bVar.oDl.startLoad(eVar.mPortrait, 12, false);
            }
            bVar.oDm.setText(eVar.mUserName);
            bVar.oDo.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                bVar.oDp.setVisibility(8);
            } else {
                bVar.oDp.setVisibility(0);
                bVar.oDp.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            bVar.oDr.setVisibility(8);
            bVar.oDt.setVisibility(8);
            int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (eVar.mLiveMarkInfo != null) {
                i2 = d;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oDr.setVisibility(0);
                            bVar.oDs.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oDq.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oDt.setVisibility(0);
                            bVar.oDt.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oDt.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = d;
            }
            bVar.oDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oDd != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.oDd.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.oDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oDd != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.oDd.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.oDl.setTag(eVar);
            bVar.oDm.setTag(eVar);
            bVar.oDm.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oDo.getMeasuredWidth() + i2 > bVar.oDu.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oDm.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oDm.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oDm.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oDm.setLayoutParams(layoutParams2);
                }
            });
            bVar.oDk.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    private class b {
        private TextView oDi;
        private LinearLayout oDj;
        private View oDk;
        private HeadImageView oDl;
        private TextView oDm;
        private ImageView oDn;
        private TextView oDo;
        private ImageView oDp;
        private TextView oDq;
        private FrameLayout oDr;
        private TbImageView oDs;
        private TbImageView oDt;
        private LinearLayout oDu;
        private LinearLayout oDv;

        private b() {
        }
    }

    public void a(InterfaceC0942a interfaceC0942a) {
        this.oDd = interfaceC0942a;
    }
}
