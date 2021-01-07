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
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    private String authorUk;
    private Context context;
    private List<n> mList;
    private a oxV;
    private List<String> oxW = new ArrayList();

    /* loaded from: classes11.dex */
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
        this.oxW.clear();
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
            bVar2.oxC = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oxE = view.findViewById(a.f.margin_top_height);
            bVar2.oxF = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oxI = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oxG = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oxK = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oxJ = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oxM = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oxL = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oxN = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oxZ = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.oya = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat_blue);
            bVar2.oxO = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oxP = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        n nVar = (n) ListUtils.getItem(this.mList, i);
        if (nVar != null) {
            bVar.oxC.setText(Integer.toString(i + 1));
            bVar.oxF.setIsRound(true);
            bVar.oxF.setAutoChangeStyle(false);
            bVar.oxF.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (nVar != null && !TextUtils.isEmpty(nVar.portrait)) {
                bVar.oxF.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oxF.setUrl(nVar.portrait);
                bVar.oxF.startLoad(nVar.portrait, 12, false);
            }
            bVar.oxI.setText(nVar.userName);
            bVar.oxG.setText(nVar.userName);
            if (nVar.sex == 0) {
                bVar.oxJ.setVisibility(8);
            } else {
                bVar.oxJ.setVisibility(0);
                bVar.oxJ.setImageResource(nVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = nVar.sex == 0 ? 3 : 2;
            bVar.oxL.setVisibility(8);
            bVar.oxN.setVisibility(8);
            final int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
            if (nVar.mLiveMarkInfo != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < nVar.mLiveMarkInfo.size() && i4 < i2) {
                        switch (nVar.mLiveMarkInfo.get(i4).type) {
                            case 1:
                                bVar.oxL.setVisibility(0);
                                bVar.oxM.startLoad(nVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                bVar.oxK.setText(Integer.toString(nVar.level));
                                c += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                                break;
                            case 105:
                                bVar.oxN.setVisibility(0);
                                bVar.oxN.startLoad(nVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                c += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, bVar.oxN.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                                break;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            bVar.oxF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oxV != null && view2.getTag() != null && (view2.getTag() instanceof n)) {
                        c.this.oxV.a((n) view2.getTag());
                    }
                }
            });
            bVar.oxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oxV != null && view2.getTag() != null && (view2.getTag() instanceof n)) {
                        c.this.oxV.a((n) view2.getTag());
                    }
                }
            });
            bVar.oxF.setTag(nVar);
            bVar.oxG.setTag(nVar);
            bVar.oxZ.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oxZ.setTag(nVar);
            bVar.oxZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, true);
                }
            });
            bVar.oya.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oya.setTag(nVar);
            bVar.oya.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, false);
                }
            });
            bVar.oya.setVisibility(8);
            bVar.oya.setSelectedState(0);
            bVar.oxZ.setVisibility(0);
            if (!Wc(nVar.uk)) {
                if (nVar.EB()) {
                    bVar.oxZ.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.oxZ.setSelectedState(0);
                } else if (nVar.aJU == 0) {
                    if (this.oxW == null || !this.oxW.contains(nVar.uk)) {
                        if (!o.efg().efw()) {
                            bVar.oxZ.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        } else {
                            bVar.oya.setVisibility(0);
                            bVar.oya.setSelectedState(2);
                            bVar.oxZ.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_apply_red_team_text));
                        }
                        bVar.oxZ.setSelectedState(nVar.aJW ? 1 : 0);
                    } else {
                        bVar.oya.setVisibility(8);
                        bVar.oxZ.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.oxZ.setSelectedState(0);
                    }
                } else if (nVar.aJU == 1) {
                    bVar.oxZ.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.oxZ.setSelectedState(1);
                }
            } else {
                bVar.oxZ.setVisibility(8);
            }
            bVar.oxG.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oxI.getMeasuredWidth() + c > bVar.oxO.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oxG.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oxG.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oxG.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oxG.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, boolean z) {
        if (view.getTag() != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.oxV != null && nVar.aJU == 0 && this.oxW != null && !this.oxW.contains(nVar.uk)) {
                if (!nVar.aJW && this.context != null) {
                    BdToast.makeText(this.context, this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                    return;
                }
                Wd(nVar.uk);
                this.oxV.a((n) view.getTag(), z);
            }
        }
    }

    private boolean Wc(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes11.dex */
    private class b {
        private TextView oxC;
        private View oxE;
        private HeadImageView oxF;
        private TextView oxG;
        private TextView oxI;
        private ImageView oxJ;
        private TextView oxK;
        private FrameLayout oxL;
        private TbImageView oxM;
        private TbImageView oxN;
        private LinearLayout oxO;
        private LinearLayout oxP;
        private AlaAcceptAndInviteBtn oxZ;
        private AlaAcceptAndInviteBtn oya;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oxV = aVar;
    }

    public void Wd(String str) {
        if (str != null && this.oxW != null && !this.oxW.contains(str)) {
            this.oxW.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.oxW != null) {
            this.oxW.clear();
        }
    }
}
