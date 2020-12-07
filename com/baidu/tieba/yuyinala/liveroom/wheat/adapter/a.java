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
    private InterfaceC0939a orm;

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
            bVar2.orq = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.orr = view.findViewById(a.f.margin_top_height);
            bVar2.ors = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.ort = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oru = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.orv = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.ory = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.orw = (TextView) view.findViewById(a.f.tv_level);
            bVar2.orx = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.orz = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.orA = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.orB = (LinearLayout) view.findViewById(a.f.icon_container);
            bVar2.orA = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.orB = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        e eVar = (e) ListUtils.getItem(this.mList, i);
        if (eVar != null) {
            bVar.orq.setText(Integer.toString(eVar.mPos));
            bVar.ors.setIsRound(true);
            bVar.ors.setAutoChangeStyle(false);
            bVar.ors.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                bVar.ors.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.ors.setUrl(eVar.mPortrait);
                bVar.ors.startLoad(eVar.mPortrait, 12, false);
            }
            bVar.ort.setText(eVar.mUserName);
            bVar.oru.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                bVar.orv.setVisibility(8);
            } else {
                bVar.orv.setVisibility(0);
                bVar.orv.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            bVar.orx.setVisibility(8);
            bVar.orz.setVisibility(8);
            int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
            if (eVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.orx.setVisibility(0);
                            bVar.ory.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.orw.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.orz.setVisibility(0);
                            bVar.orz.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, bVar.orz.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.ors.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.orm != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                        a.this.orm.a((e) view2.getTag());
                    }
                }
            });
            bVar.ort.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.orm != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                        a.this.orm.a((e) view2.getTag());
                    }
                }
            });
            bVar.ors.setTag(eVar);
            bVar.ort.setTag(eVar);
            bVar.ort.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oru.getMeasuredWidth() + i2 > bVar.orA.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ort.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.ort.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ort.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.ort.setLayoutParams(layoutParams2);
                }
            });
            bVar.orr.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class b {
        private LinearLayout orA;
        private LinearLayout orB;
        private TextView orq;
        private View orr;
        private HeadImageView ors;
        private TextView ort;
        private TextView oru;
        private ImageView orv;
        private TextView orw;
        private FrameLayout orx;
        private TbImageView ory;
        private TbImageView orz;

        private b() {
        }
    }

    public void a(InterfaceC0939a interfaceC0939a) {
        this.orm = interfaceC0939a;
    }
}
