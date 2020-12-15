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
    private InterfaceC0939a oro;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0939a {
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
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply_2, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.ors = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.ort = view.findViewById(a.f.margin_top_height);
            bVar2.oru = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.orv = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.orw = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.orx = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.orA = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.ory = (TextView) view.findViewById(a.f.tv_level);
            bVar2.orz = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.orB = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.orC = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.orD = (LinearLayout) view.findViewById(a.f.icon_container);
            bVar2.orC = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.orD = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        e eVar = (e) ListUtils.getItem(this.mList, i);
        if (eVar != null) {
            bVar.ors.setText(Integer.toString(eVar.mPos));
            bVar.oru.setIsRound(true);
            bVar.oru.setAutoChangeStyle(false);
            bVar.oru.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                bVar.oru.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oru.setUrl(eVar.mPortrait);
                bVar.oru.startLoad(eVar.mPortrait, 12, false);
            }
            bVar.orv.setText(eVar.mUserName);
            bVar.orw.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                bVar.orx.setVisibility(8);
            } else {
                bVar.orx.setVisibility(0);
                bVar.orx.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            bVar.orz.setVisibility(8);
            bVar.orB.setVisibility(8);
            int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
            if (eVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.orz.setVisibility(0);
                            bVar.orA.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.ory.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.orB.setVisibility(0);
                            bVar.orB.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, bVar.orB.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.oru.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oro != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                        a.this.oro.a((e) view2.getTag());
                    }
                }
            });
            bVar.orv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oro != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                        a.this.oro.a((e) view2.getTag());
                    }
                }
            });
            bVar.oru.setTag(eVar);
            bVar.orv.setTag(eVar);
            bVar.orv.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.orw.getMeasuredWidth() + i2 > bVar.orC.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.orv.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.orv.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.orv.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.orv.setLayoutParams(layoutParams2);
                }
            });
            bVar.ort.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class b {
        private TbImageView orA;
        private TbImageView orB;
        private LinearLayout orC;
        private LinearLayout orD;
        private TextView ors;
        private View ort;
        private HeadImageView oru;
        private TextView orv;
        private TextView orw;
        private ImageView orx;
        private TextView ory;
        private FrameLayout orz;

        private b() {
        }
    }

    public void a(InterfaceC0939a interfaceC0939a) {
        this.oro = interfaceC0939a;
    }
}
