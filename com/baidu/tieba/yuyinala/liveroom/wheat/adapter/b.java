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
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaAcceptAndInviteBtn;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private Context context;
    private List<e> mList;
    private a ocC;

    /* loaded from: classes4.dex */
    public interface a {
        void MP(int i);

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

    /* JADX WARN: Removed duplicated region for block: B:41:0x0260  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        final C0923b c0923b;
        final int i2;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_apply, (ViewGroup) null);
            C0923b c0923b2 = new C0923b();
            c0923b2.ocp = (TextView) view.findViewById(a.f.tv_rank_num);
            c0923b2.ocq = view.findViewById(a.f.margin_top_height);
            c0923b2.ocs = (HeadImageView) view.findViewById(a.f.user_avatar);
            c0923b2.oct = (TextView) view.findViewById(a.f.tv_nickname);
            c0923b2.ocu = (TextView) view.findViewById(a.f.tv_temp_nickname);
            c0923b2.ocv = (ImageView) view.findViewById(a.f.iv_sex);
            c0923b2.ocw = (TextView) view.findViewById(a.f.tv_level);
            c0923b2.ocy = (TbImageView) view.findViewById(a.f.iv_level);
            c0923b2.ocx = (FrameLayout) view.findViewById(a.f.level_container);
            c0923b2.ocz = (TbImageView) view.findViewById(a.f.iv_badge);
            c0923b2.ocG = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_accept_invite);
            c0923b2.ocA = (LinearLayout) view.findViewById(a.f.content_container);
            c0923b2.ocB = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(c0923b2);
            c0923b = c0923b2;
        } else {
            c0923b = (C0923b) view.getTag();
        }
        final e eVar = (e) ListUtils.getItem(this.mList, i);
        int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
        if (eVar != null) {
            c0923b.ocG.setBtnEnabled(eVar.aGe);
            c0923b.ocp.setText(Integer.toString(eVar.mPos));
            c0923b.ocs.setIsRound(true);
            c0923b.ocs.setAutoChangeStyle(false);
            c0923b.ocs.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (eVar != null && !TextUtils.isEmpty(eVar.mPortrait)) {
                c0923b.ocs.setScaleType(ImageView.ScaleType.FIT_XY);
                c0923b.ocs.setUrl(eVar.mPortrait);
                c0923b.ocs.startLoad(eVar.mPortrait, 12, false);
            }
            c0923b.oct.setText(eVar.mUserName);
            c0923b.ocu.setText(eVar.mUserName);
            if (eVar.mSex == 0) {
                c0923b.ocv.setVisibility(8);
            } else {
                c0923b.ocv.setVisibility(0);
                c0923b.ocv.setImageResource(eVar.mSex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = eVar.mSex == 0 ? 3 : 2;
            c0923b.ocx.setVisibility(8);
            c0923b.ocz.setVisibility(8);
            if (eVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < eVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (eVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            c0923b.ocx.setVisibility(0);
                            c0923b.ocy.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            c0923b.ocw.setText(Integer.toString(eVar.level));
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            c0923b.ocz.setVisibility(0);
                            c0923b.ocz.startLoad(eVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, c0923b.ocz.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                            break;
                    }
                }
                c0923b.ocs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.ocC != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                            b.this.ocC.a((e) view2.getTag());
                        }
                    }
                });
                c0923b.oct.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (b.this.ocC != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                            b.this.ocC.a((e) view2.getTag());
                        }
                    }
                });
                c0923b.ocs.setTag(eVar);
                c0923b.oct.setTag(eVar);
                c0923b.ocG.setTag(eVar);
                c0923b.ocG.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
                c0923b.ocG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (eVar.aGe || b.this.context == null) {
                            if (b.this.ocC != null) {
                                if (view2.getTag() == null || !(view2.getTag() instanceof e)) {
                                    b.this.ocC.b(null);
                                    return;
                                } else {
                                    b.this.ocC.b((e) view2.getTag());
                                    return;
                                }
                            }
                            return;
                        }
                        BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
                    }
                });
                c0923b.oct.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c0923b.ocu.getMeasuredWidth() + i2 > c0923b.ocA.getMeasuredWidth()) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0923b.oct.getLayoutParams();
                            layoutParams.weight = 1.0f;
                            c0923b.oct.setLayoutParams(layoutParams);
                            return;
                        }
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0923b.oct.getLayoutParams();
                        layoutParams2.weight = 0.0f;
                        layoutParams2.width = -2;
                        c0923b.oct.setLayoutParams(layoutParams2);
                    }
                });
                c0923b.ocq.setVisibility(i != 0 ? 8 : 0);
                return view;
            }
        }
        i2 = c;
        c0923b.ocs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.ocC != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                    b.this.ocC.a((e) view2.getTag());
                }
            }
        });
        c0923b.oct.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.ocC != null && view2.getTag() != null && (view2.getTag() instanceof e)) {
                    b.this.ocC.a((e) view2.getTag());
                }
            }
        });
        c0923b.ocs.setTag(eVar);
        c0923b.oct.setTag(eVar);
        c0923b.ocG.setTag(eVar);
        c0923b.ocG.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        c0923b.ocG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (eVar.aGe || b.this.context == null) {
                    if (b.this.ocC != null) {
                        if (view2.getTag() == null || !(view2.getTag() instanceof e)) {
                            b.this.ocC.b(null);
                            return;
                        } else {
                            b.this.ocC.b((e) view2.getTag());
                            return;
                        }
                    }
                    return;
                }
                BdToast.makeText(b.this.context, b.this.context.getText(a.h.yuyin_ala_apply_unable_text)).show();
            }
        });
        c0923b.oct.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (c0923b.ocu.getMeasuredWidth() + i2 > c0923b.ocA.getMeasuredWidth()) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0923b.oct.getLayoutParams();
                    layoutParams.weight = 1.0f;
                    c0923b.oct.setLayoutParams(layoutParams);
                    return;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0923b.oct.getLayoutParams();
                layoutParams2.weight = 0.0f;
                layoutParams2.width = -2;
                c0923b.oct.setLayoutParams(layoutParams2);
            }
        });
        c0923b.ocq.setVisibility(i != 0 ? 8 : 0);
        return view;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0923b {
        private LinearLayout ocA;
        private LinearLayout ocB;
        private AlaAcceptAndInviteBtn ocG;
        private TextView ocp;
        private View ocq;
        private HeadImageView ocs;
        private TextView oct;
        private TextView ocu;
        private ImageView ocv;
        private TextView ocw;
        private FrameLayout ocx;
        private TbImageView ocy;
        private TbImageView ocz;

        private C0923b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.ocC = aVar;
    }

    public void Ve(String str) {
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
