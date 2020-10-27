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
public class b extends BaseAdapter {
    private Context context;
    private List<e> mList;
    private a nTK;

    /* loaded from: classes4.dex */
    public interface a {
        void LV(int i);

        void a(e eVar);

        void b(e eVar);
    }

    public b(Context context) {
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

    /* JADX WARN: Removed duplicated region for block: B:41:0x0257  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0904b c0904b;
        final int i2;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.h.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0904b c0904b2 = new C0904b();
            c0904b2.nTy = (TextView) view.findViewById(a.g.tv_rank_num);
            c0904b2.nTz = view.findViewById(a.g.margin_top_height);
            c0904b2.nTA = (HeadImageView) view.findViewById(a.g.user_avatar);
            c0904b2.nTB = (TextView) view.findViewById(a.g.tv_nickname);
            c0904b2.nTC = (TextView) view.findViewById(a.g.tv_temp_nickname);
            c0904b2.nTD = (ImageView) view.findViewById(a.g.iv_sex);
            c0904b2.nTE = (TextView) view.findViewById(a.g.tv_level);
            c0904b2.nTG = (TbImageView) view.findViewById(a.g.iv_level);
            c0904b2.nTF = (FrameLayout) view.findViewById(a.g.level_container);
            c0904b2.nTH = (TbImageView) view.findViewById(a.g.iv_badge);
            c0904b2.nTN = (TextView) view.findViewById(a.g.tv_accept_invite);
            c0904b2.nTI = (LinearLayout) view.findViewById(a.g.content_container);
            c0904b2.nTJ = (LinearLayout) view.findViewById(a.g.icon_container);
            view.setTag(c0904b2);
            c0904b = c0904b2;
        } else {
            c0904b = (C0904b) view.getTag();
        }
        e eVar = (e) ListUtils.getItem(this.mList, i);
        int c = com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            c0904b.nTy.setText(Integer.toString(eVar.mPos));
            c0904b.nTA.setIsRound(true);
            c0904b.nTA.setAutoChangeStyle(false);
            c0904b.nTA.setDefaultResource(a.f.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0904b.nTA.setScaleType(ImageView.ScaleType.FIT_XY);
                c0904b.nTA.setUrl(eVar.mPortrait);
                c0904b.nTA.startLoad(eVar.mPortrait, 12, false);
            }
            c0904b.nTB.setText(eVar.mUserName);
            c0904b.nTC.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0904b.nTD.setVisibility(8);
            } else {
                c0904b.nTD.setVisibility(0);
                c0904b.nTD.setImageResource(eVar.mSex == 1 ? a.f.yuyin_sdk_icon_mine_boy : a.f.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            c0904b.nTF.setVisibility(8);
            c0904b.nTH.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            c0904b.nTF.setVisibility(0);
                            c0904b.nTG.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            c0904b.nTE.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            c0904b.nTH.setVisibility(0);
                            c0904b.nTH.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(42.0f, c0904b.nTH.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.d.e.c(4.0f, view.getContext());
                            break;
                    }
                }
                c0904b.nTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.nTK != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                            b.this.nTK.a((e) view2.getTag());
                        }
                    }
                });
                c0904b.nTB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.nTK != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                            b.this.nTK.a((e) view2.getTag());
                        }
                    }
                });
                c0904b.nTA.setTag(eVar);
                c0904b.nTB.setTag(eVar);
                c0904b.nTN.setTag(eVar);
                c0904b.nTN.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
                c0904b.nTN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.nTK != null) {
                            if (view2.getTag() == null || !(view2.getTag() instanceof e)) {
                                b.this.nTK.b(null);
                            } else {
                                b.this.nTK.b((e) view2.getTag());
                            }
                        }
                    }
                });
                c0904b.nTB.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c0904b.nTC.getMeasuredWidth() + i2 > c0904b.nTI.getMeasuredWidth()) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0904b.nTB.getLayoutParams();
                            layoutParams.weight = 1.0f;
                            c0904b.nTB.setLayoutParams(layoutParams);
                            return;
                        }
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0904b.nTB.getLayoutParams();
                        layoutParams2.weight = 0.0f;
                        layoutParams2.width = -2;
                        c0904b.nTB.setLayoutParams(layoutParams2);
                    }
                });
                c0904b.nTz.setVisibility(i != 0 ? 8 : 0);
                return view;
            }
        }
        i2 = c;
        c0904b.nTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.nTK != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                    b.this.nTK.a((e) view2.getTag());
                }
            }
        });
        c0904b.nTB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.nTK != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                    b.this.nTK.a((e) view2.getTag());
                }
            }
        });
        c0904b.nTA.setTag(eVar);
        c0904b.nTB.setTag(eVar);
        c0904b.nTN.setTag(eVar);
        c0904b.nTN.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0904b.nTN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.nTK != null) {
                    if (view2.getTag() == null || !(view2.getTag() instanceof e)) {
                        b.this.nTK.b(null);
                    } else {
                        b.this.nTK.b((e) view2.getTag());
                    }
                }
            }
        });
        c0904b.nTB.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0904b.nTC.getMeasuredWidth() + i2 > c0904b.nTI.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0904b.nTB.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0904b.nTB.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0904b.nTB.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0904b.nTB.setLayoutParams(layoutParams2);
            }
        });
        c0904b.nTz.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0904b {
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
        private TextView nTN;
        private TextView nTy;
        private View nTz;

        private C0904b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.nTK = aVar;
    }

    public void Vc(String str) {
        if (!ListUtils.isEmpty(this.mList)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mList.size()) {
                    break;
                } else if (!TextUtils.equals(str, this.mList.get(i2).uk)) {
                    i = i2 + 1;
                } else {
                    this.mList.remove(i2);
                    break;
                }
            }
            notifyDataSetChanged();
        }
    }
}
