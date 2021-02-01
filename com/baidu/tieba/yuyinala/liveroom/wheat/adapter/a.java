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
    private InterfaceC0940a oCD;
    private int oCE = -1;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0940a {
        void a(com.baidu.live.data.e eVar);
    }

    public a(Context context) {
        this.context = context;
    }

    public void setData(List<com.baidu.live.data.e> list, int i) {
        this.mList = list;
        this.oCE = i;
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
            bVar2.oCI = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oCJ = (LinearLayout) view.findViewById(a.f.item_selected_bg);
            bVar2.oCK = view.findViewById(a.f.margin_top_height);
            bVar2.oCL = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oCM = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oCN = (ImageView) view.findViewById(a.f.team_fright_flag);
            bVar2.oCO = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oCP = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oCS = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oCQ = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oCR = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oCT = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oCU = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oCV = (LinearLayout) view.findViewById(a.f.icon_container);
            bVar2.oCU = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oCV = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.live.data.e eVar = (com.baidu.live.data.e) ListUtils.getItem(this.mList, i);
        if (eVar != null) {
            if (!q.edE().edR()) {
                bVar.oCI.setTextColor(bVar.oCI.getResources().getColor(a.c.sdk_color_B8B8B8));
                bVar.oCN.setVisibility(8);
                bVar.oCI.setTextSize(18.0f);
            } else {
                bVar.oCN.setVisibility(0);
                bVar.oCI.setTextColor(bVar.oCI.getResources().getColor(a.c.sdk_white_alpha100));
                bVar.oCI.setTextSize(13.0f);
                if (eVar.isApplyRedTeam()) {
                    bVar.oCN.setImageResource(a.e.yuyin_audio_wheat_red_flag);
                } else {
                    bVar.oCN.setImageResource(a.e.yuyin_audio_wheat_blue_flag);
                }
            }
            bVar.oCJ.setBackgroundColor(this.oCE == i ? Color.parseColor("#F5F5F5") : Color.parseColor("#FFFFFF"));
            bVar.oCI.setText(Integer.toString(eVar.mPos));
            bVar.oCL.setIsRound(true);
            bVar.oCL.setAutoChangeStyle(false);
            bVar.oCL.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                bVar.oCL.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oCL.setUrl(eVar.mPortrait);
                bVar.oCL.startLoad(eVar.mPortrait, 12, false);
            }
            bVar.oCM.setText(eVar.mUserName);
            bVar.oCO.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                bVar.oCP.setVisibility(8);
            } else {
                bVar.oCP.setVisibility(0);
                bVar.oCP.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            bVar.oCR.setVisibility(8);
            bVar.oCT.setVisibility(8);
            int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (eVar.mLiveMarkInfo != null) {
                i2 = d;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oCR.setVisibility(0);
                            bVar.oCS.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oCQ.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oCT.setVisibility(0);
                            bVar.oCT.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oCT.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = d;
            }
            bVar.oCL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oCD != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.oCD.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.oCM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oCD != null && view2.getTag() != null && (view2.getTag() instanceof com.baidu.live.data.e)) {
                        a.this.oCD.a((com.baidu.live.data.e) view2.getTag());
                    }
                }
            });
            bVar.oCL.setTag(eVar);
            bVar.oCM.setTag(eVar);
            bVar.oCM.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oCO.getMeasuredWidth() + i2 > bVar.oCU.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oCM.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oCM.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oCM.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oCM.setLayoutParams(layoutParams2);
                }
            });
            bVar.oCK.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    private class b {
        private TextView oCI;
        private LinearLayout oCJ;
        private View oCK;
        private HeadImageView oCL;
        private TextView oCM;
        private ImageView oCN;
        private TextView oCO;
        private ImageView oCP;
        private TextView oCQ;
        private FrameLayout oCR;
        private TbImageView oCS;
        private TbImageView oCT;
        private LinearLayout oCU;
        private LinearLayout oCV;

        private b() {
        }
    }

    public void a(InterfaceC0940a interfaceC0940a) {
        this.oCD = interfaceC0940a;
    }
}
