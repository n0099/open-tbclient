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
    private InterfaceC0919a oaH;

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0919a {
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
            bVar2.oaL = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oaM = view.findViewById(a.f.margin_top_height);
            bVar2.oaN = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oaO = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oaP = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oaQ = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oaT = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oaR = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oaS = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oaU = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oaV = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oaW = (LinearLayout) view.findViewById(a.f.icon_container);
            bVar2.oaV = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oaW = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        e eVar = (e) ListUtils.getItem(this.mList, i);
        if (eVar != null) {
            bVar.oaL.setText(Integer.toString(eVar.mPos));
            bVar.oaN.setIsRound(true);
            bVar.oaN.setAutoChangeStyle(false);
            bVar.oaN.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                bVar.oaN.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oaN.setUrl(eVar.mPortrait);
                bVar.oaN.startLoad(eVar.mPortrait, 12, false);
            }
            bVar.oaO.setText(eVar.mUserName);
            bVar.oaP.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                bVar.oaQ.setVisibility(8);
            } else {
                bVar.oaQ.setVisibility(0);
                bVar.oaQ.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            bVar.oaS.setVisibility(8);
            bVar.oaU.setVisibility(8);
            int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
            if (eVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oaS.setVisibility(0);
                            bVar.oaT.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oaR.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oaU.setVisibility(0);
                            bVar.oaU.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, bVar.oaU.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.oaN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oaH != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                        a.this.oaH.a((e) view2.getTag());
                    }
                }
            });
            bVar.oaO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.oaH != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                        a.this.oaH.a((e) view2.getTag());
                    }
                }
            });
            bVar.oaN.setTag(eVar);
            bVar.oaO.setTag(eVar);
            bVar.oaO.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oaP.getMeasuredWidth() + i2 > bVar.oaV.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oaO.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oaO.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oaO.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oaO.setLayoutParams(layoutParams2);
                }
            });
            bVar.oaM.setVisibility(i != 0 ? 8 : 0);
        }
        return view;
    }

    /* loaded from: classes4.dex */
    private class b {
        private TextView oaL;
        private View oaM;
        private HeadImageView oaN;
        private TextView oaO;
        private TextView oaP;
        private ImageView oaQ;
        private TextView oaR;
        private FrameLayout oaS;
        private TbImageView oaT;
        private TbImageView oaU;
        private LinearLayout oaV;
        private LinearLayout oaW;

        private b() {
        }
    }

    public void a(InterfaceC0919a interfaceC0919a) {
        this.oaH = interfaceC0919a;
    }
}
