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
import com.baidu.live.data.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private Context context;
    private List<e> mList;
    private InterfaceC0903a nTu;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0903a {
        void a(e eVar);
    }

    public a(Context context) {
        this.context = context;
    }

    public void setData(List<e> list) {
        this.mList = list;
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
            view = LayoutInflater.from(this.context).inflate(a.h.yuyin_item_connection_wheat_apply_2, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.nTy = (TextView) view.findViewById(a.g.tv_rank_num);
            bVar2.nTz = view.findViewById(a.g.margin_top_height);
            bVar2.nTA = (HeadImageView) view.findViewById(a.g.user_avatar);
            bVar2.nTB = (TextView) view.findViewById(a.g.tv_nickname);
            bVar2.nTC = (TextView) view.findViewById(a.g.tv_temp_nickname);
            bVar2.nTD = (ImageView) view.findViewById(a.g.iv_sex);
            bVar2.nTG = (TbImageView) view.findViewById(a.g.iv_level);
            bVar2.nTE = (TextView) view.findViewById(a.g.tv_level);
            bVar2.nTF = (FrameLayout) view.findViewById(a.g.level_container);
            bVar2.nTH = (TbImageView) view.findViewById(a.g.iv_badge);
            bVar2.nTI = (LinearLayout) view.findViewById(a.g.content_container);
            bVar2.nTJ = (LinearLayout) view.findViewById(a.g.icon_container);
            bVar2.nTI = (LinearLayout) view.findViewById(a.g.content_container);
            bVar2.nTJ = (LinearLayout) view.findViewById(a.g.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        e eVar = (e) ListUtils.getItem(this.mList, i);
        if (eVar != null) {
            bVar.nTy.setText(Integer.toString(eVar.mPos));
            bVar.nTA.setIsRound(true);
            bVar.nTA.setAutoChangeStyle(false);
            bVar.nTA.setDefaultResource(a.f.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                bVar.nTA.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.nTA.setUrl(eVar.mPortrait);
                bVar.nTA.startLoad(eVar.mPortrait, 12, false);
            }
            bVar.nTB.setText(eVar.mUserName);
            bVar.nTC.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                bVar.nTD.setVisibility(8);
            } else {
                bVar.nTD.setVisibility(0);
                bVar.nTD.setImageResource(eVar.mSex == 1 ? a.f.yuyin_sdk_icon_mine_boy : a.f.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            bVar.nTF.setVisibility(8);
            bVar.nTH.setVisibility(8);
            int c = com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(4.0f, view.getContext()) * 2);
            if (eVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.nTF.setVisibility(0);
                            bVar.nTG.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.nTE.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.nTH.setVisibility(0);
                            bVar.nTH.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(42.0f, bVar.nTH.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.nTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nTu != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                        a.this.nTu.a((e) view2.getTag());
                    }
                }
            });
            bVar.nTB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nTu != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                        a.this.nTu.a((e) view2.getTag());
                    }
                }
            });
            bVar.nTA.setTag(eVar);
            bVar.nTB.setTag(eVar);
            bVar.nTB.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.nTC.getMeasuredWidth() + i2 > bVar.nTI.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.nTB.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.nTB.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.nTB.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.nTB.setLayoutParams(layoutParams2);
                }
            });
            bVar.nTz.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class b {
        private HeadImageView nTA;
        private TextView nTB;
        private TextView nTC;
        private ImageView nTD;
        private TextView nTE;
        private FrameLayout nTF;
        private TbImageView nTG;
        private TbImageView nTH;
        private LinearLayout nTI;
        private LinearLayout nTJ;
        private TextView nTy;
        private View nTz;

        private b() {
        }
    }

    public void a(InterfaceC0903a interfaceC0903a) {
        this.nTu = interfaceC0903a;
    }
}
