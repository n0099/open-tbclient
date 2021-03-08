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
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaAcceptAndInviteBtn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends BaseAdapter {
    private String authorUk;
    private Context context;
    private List<r> mList;
    private a oFG;
    private List<String> oFH = new ArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(r rVar);

        void a(r rVar, boolean z);
    }

    public c(Context context) {
        this.context = context;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        this.authorUk = currentAccountInfo != null ? ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()) : null;
    }

    public void setData(List<r> list) {
        this.oFH.clear();
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
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_invite, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.oFn = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oFp = view.findViewById(a.f.margin_top_height);
            bVar2.oFq = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oFt = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oFr = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oFv = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oFu = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oFx = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oFw = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oFy = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oFK = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.oFL = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat_blue);
            bVar2.oFz = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oFA = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        r rVar = (r) ListUtils.getItem(this.mList, i);
        if (rVar != null) {
            bVar.oFn.setText(Integer.toString(i + 1));
            bVar.oFq.setIsRound(true);
            bVar.oFq.setAutoChangeStyle(false);
            bVar.oFq.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (rVar != null && !TextUtils.isEmpty(rVar.portrait)) {
                bVar.oFq.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oFq.setUrl(rVar.portrait);
                bVar.oFq.startLoad(rVar.portrait, 12, false);
            }
            bVar.oFt.setText(rVar.userName);
            bVar.oFr.setText(rVar.userName);
            if (rVar.sex == 0) {
                bVar.oFu.setVisibility(8);
            } else {
                bVar.oFu.setVisibility(0);
                bVar.oFu.setImageResource(rVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = rVar.sex == 0 ? 3 : 2;
            bVar.oFw.setVisibility(8);
            bVar.oFy.setVisibility(8);
            final int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (rVar.mLiveMarkInfo != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < rVar.mLiveMarkInfo.size() && i4 < i2) {
                        switch (rVar.mLiveMarkInfo.get(i4).type) {
                            case 1:
                                bVar.oFw.setVisibility(0);
                                bVar.oFx.startLoad(rVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                bVar.oFv.setText(Integer.toString(rVar.level));
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                            case 105:
                                bVar.oFy.setVisibility(0);
                                bVar.oFy.startLoad(rVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oFy.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            bVar.oFq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oFG != null && view2.getTag() != null && (view2.getTag() instanceof r)) {
                        c.this.oFG.a((r) view2.getTag());
                    }
                }
            });
            bVar.oFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oFG != null && view2.getTag() != null && (view2.getTag() instanceof r)) {
                        c.this.oFG.a((r) view2.getTag());
                    }
                }
            });
            bVar.oFq.setTag(rVar);
            bVar.oFr.setTag(rVar);
            bVar.oFK.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oFK.setTag(rVar);
            bVar.oFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, true);
                }
            });
            bVar.oFL.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oFL.setTag(rVar);
            bVar.oFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, false);
                }
            });
            bVar.oFL.setVisibility(8);
            bVar.oFL.setSelectedState(0);
            bVar.oFK.setVisibility(0);
            if (!Wm(rVar.uk)) {
                if (rVar.BW()) {
                    bVar.oFK.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.oFK.setSelectedState(0);
                } else if (rVar.aJd == 0) {
                    if (this.oFH == null || !this.oFH.contains(rVar.uk)) {
                        if (!q.edU().eeh()) {
                            bVar.oFK.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        } else {
                            bVar.oFL.setVisibility(0);
                            bVar.oFL.setSelectedState(2);
                            bVar.oFK.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_apply_red_team_text));
                        }
                        bVar.oFK.setSelectedState(rVar.aJf ? 1 : 0);
                    } else {
                        bVar.oFL.setVisibility(8);
                        bVar.oFK.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.oFK.setSelectedState(0);
                    }
                } else if (rVar.aJd == 1) {
                    bVar.oFK.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.oFK.setSelectedState(1);
                }
            } else {
                bVar.oFK.setVisibility(8);
            }
            bVar.oFr.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oFt.getMeasuredWidth() + d > bVar.oFz.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oFr.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oFr.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oFr.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oFr.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, boolean z) {
        if (view.getTag() != null && (view.getTag() instanceof r)) {
            r rVar = (r) view.getTag();
            if (this.oFG != null && rVar.aJd == 0 && this.oFH != null && !this.oFH.contains(rVar.uk)) {
                if (!rVar.aJf && this.context != null) {
                    BdToast.makeText(this.context, this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                    return;
                }
                Wn(rVar.uk);
                this.oFG.a((r) view.getTag(), z);
            }
        }
    }

    private boolean Wm(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes10.dex */
    private class b {
        private LinearLayout oFA;
        private AlaAcceptAndInviteBtn oFK;
        private AlaAcceptAndInviteBtn oFL;
        private TextView oFn;
        private View oFp;
        private HeadImageView oFq;
        private TextView oFr;
        private TextView oFt;
        private ImageView oFu;
        private TextView oFv;
        private FrameLayout oFw;
        private TbImageView oFx;
        private TbImageView oFy;
        private LinearLayout oFz;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oFG = aVar;
    }

    public void Wn(String str) {
        if (str != null && this.oFH != null && !this.oFH.contains(str)) {
            this.oFH.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.oFH != null) {
            this.oFH.clear();
        }
    }
}
