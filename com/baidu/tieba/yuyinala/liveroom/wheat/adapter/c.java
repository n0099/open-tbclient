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
import com.baidu.live.data.n;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaAcceptAndInviteBtn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends BaseAdapter {
    private String authorUk;
    private Context context;
    private List<n> mList;
    private a otq;
    private List<String> otr = new ArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(n nVar);

        void a(n nVar, boolean z);
    }

    public c(Context context) {
        this.context = context;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        this.authorUk = currentAccountInfo != null ? ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()) : null;
    }

    public void setData(List<n> list) {
        this.otr.clear();
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
            bVar2.osX = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.osZ = view.findViewById(a.f.margin_top_height);
            bVar2.ota = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.otd = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.otb = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.otf = (TextView) view.findViewById(a.f.tv_level);
            bVar2.ote = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oth = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.otg = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oti = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.otu = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.otv = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat_blue);
            bVar2.otj = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.otk = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        n nVar = (n) ListUtils.getItem(this.mList, i);
        if (nVar != null) {
            bVar.osX.setText(Integer.toString(i + 1));
            bVar.ota.setIsRound(true);
            bVar.ota.setAutoChangeStyle(false);
            bVar.ota.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (nVar != null && !TextUtils.isEmpty(nVar.portrait)) {
                bVar.ota.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.ota.setUrl(nVar.portrait);
                bVar.ota.startLoad(nVar.portrait, 12, false);
            }
            bVar.otd.setText(nVar.userName);
            bVar.otb.setText(nVar.userName);
            if (nVar.sex == 0) {
                bVar.ote.setVisibility(8);
            } else {
                bVar.ote.setVisibility(0);
                bVar.ote.setImageResource(nVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = nVar.sex == 0 ? 3 : 2;
            bVar.otg.setVisibility(8);
            bVar.oti.setVisibility(8);
            final int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (nVar.mLiveMarkInfo != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < nVar.mLiveMarkInfo.size() && i4 < i2) {
                        switch (nVar.mLiveMarkInfo.get(i4).type) {
                            case 1:
                                bVar.otg.setVisibility(0);
                                bVar.oth.startLoad(nVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                bVar.otf.setText(Integer.toString(nVar.level));
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                            case 105:
                                bVar.oti.setVisibility(0);
                                bVar.oti.startLoad(nVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oti.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            bVar.ota.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.otq != null && view2.getTag() != null && (view2.getTag() instanceof n)) {
                        c.this.otq.a((n) view2.getTag());
                    }
                }
            });
            bVar.otb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.otq != null && view2.getTag() != null && (view2.getTag() instanceof n)) {
                        c.this.otq.a((n) view2.getTag());
                    }
                }
            });
            bVar.ota.setTag(nVar);
            bVar.otb.setTag(nVar);
            bVar.otu.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.otu.setTag(nVar);
            bVar.otu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, true);
                }
            });
            bVar.otv.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.otv.setTag(nVar);
            bVar.otv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, false);
                }
            });
            bVar.otv.setVisibility(8);
            bVar.otv.setSelectedState(0);
            bVar.otu.setVisibility(0);
            if (!UV(nVar.uk)) {
                if (nVar.AG()) {
                    bVar.otu.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.otu.setSelectedState(0);
                } else if (nVar.aFh == 0) {
                    if (this.otr == null || !this.otr.contains(nVar.uk)) {
                        if (!o.ebo().ebE()) {
                            bVar.otu.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        } else {
                            bVar.otv.setVisibility(0);
                            bVar.otv.setSelectedState(2);
                            bVar.otu.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_apply_red_team_text));
                        }
                        bVar.otu.setSelectedState(nVar.aFj ? 1 : 0);
                    } else {
                        bVar.otv.setVisibility(8);
                        bVar.otu.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.otu.setSelectedState(0);
                    }
                } else if (nVar.aFh == 1) {
                    bVar.otu.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.otu.setSelectedState(1);
                }
            } else {
                bVar.otu.setVisibility(8);
            }
            bVar.otb.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.otd.getMeasuredWidth() + d > bVar.otj.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.otb.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.otb.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.otb.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.otb.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, boolean z) {
        if (view.getTag() != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.otq != null && nVar.aFh == 0 && this.otr != null && !this.otr.contains(nVar.uk)) {
                if (!nVar.aFj && this.context != null) {
                    BdToast.makeText(this.context, this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                    return;
                }
                UW(nVar.uk);
                this.otq.a((n) view.getTag(), z);
            }
        }
    }

    private boolean UV(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes10.dex */
    private class b {
        private TextView osX;
        private View osZ;
        private HeadImageView ota;
        private TextView otb;
        private TextView otd;
        private ImageView ote;
        private TextView otf;
        private FrameLayout otg;
        private TbImageView oth;
        private TbImageView oti;
        private LinearLayout otj;
        private LinearLayout otk;
        private AlaAcceptAndInviteBtn otu;
        private AlaAcceptAndInviteBtn otv;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.otq = aVar;
    }

    public void UW(String str) {
        if (str != null && this.otr != null && !this.otr.contains(str)) {
            this.otr.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.otr != null) {
            this.otr.clear();
        }
    }
}
