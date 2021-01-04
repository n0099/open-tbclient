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
    private a oxW;
    private List<String> oxX = new ArrayList();

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
        this.oxX.clear();
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
            bVar2.oxD = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oxF = view.findViewById(a.f.margin_top_height);
            bVar2.oxG = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oxJ = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oxH = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oxL = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oxK = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oxN = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oxM = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oxO = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oya = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.oyb = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat_blue);
            bVar2.oxP = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oxQ = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        n nVar = (n) ListUtils.getItem(this.mList, i);
        if (nVar != null) {
            bVar.oxD.setText(Integer.toString(i + 1));
            bVar.oxG.setIsRound(true);
            bVar.oxG.setAutoChangeStyle(false);
            bVar.oxG.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (nVar != null && !TextUtils.isEmpty(nVar.portrait)) {
                bVar.oxG.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oxG.setUrl(nVar.portrait);
                bVar.oxG.startLoad(nVar.portrait, 12, false);
            }
            bVar.oxJ.setText(nVar.userName);
            bVar.oxH.setText(nVar.userName);
            if (nVar.sex == 0) {
                bVar.oxK.setVisibility(8);
            } else {
                bVar.oxK.setVisibility(0);
                bVar.oxK.setImageResource(nVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = nVar.sex == 0 ? 3 : 2;
            bVar.oxM.setVisibility(8);
            bVar.oxO.setVisibility(8);
            final int c = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext()) * 2);
            if (nVar.mLiveMarkInfo != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < nVar.mLiveMarkInfo.size() && i4 < i2) {
                        switch (nVar.mLiveMarkInfo.get(i4).type) {
                            case 1:
                                bVar.oxM.setVisibility(0);
                                bVar.oxN.startLoad(nVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                bVar.oxL.setText(Integer.toString(nVar.level));
                                c += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                                break;
                            case 105:
                                bVar.oxO.setVisibility(0);
                                bVar.oxO.startLoad(nVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                c += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(42.0f, bVar.oxO.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(4.0f, view.getContext());
                                break;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            bVar.oxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oxW != null && view2.getTag() != null && (view2.getTag() instanceof n)) {
                        c.this.oxW.a((n) view2.getTag());
                    }
                }
            });
            bVar.oxH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oxW != null && view2.getTag() != null && (view2.getTag() instanceof n)) {
                        c.this.oxW.a((n) view2.getTag());
                    }
                }
            });
            bVar.oxG.setTag(nVar);
            bVar.oxH.setTag(nVar);
            bVar.oya.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oya.setTag(nVar);
            bVar.oya.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, true);
                }
            });
            bVar.oyb.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oyb.setTag(nVar);
            bVar.oyb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, false);
                }
            });
            bVar.oyb.setVisibility(8);
            bVar.oyb.setSelectedState(0);
            bVar.oya.setVisibility(0);
            if (!Wd(nVar.uk)) {
                if (nVar.EB()) {
                    bVar.oya.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.oya.setSelectedState(0);
                } else if (nVar.aJU == 0) {
                    if (this.oxX == null || !this.oxX.contains(nVar.uk)) {
                        if (!o.eff().efv()) {
                            bVar.oya.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        } else {
                            bVar.oyb.setVisibility(0);
                            bVar.oyb.setSelectedState(2);
                            bVar.oya.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_apply_red_team_text));
                        }
                        bVar.oya.setSelectedState(nVar.aJW ? 1 : 0);
                    } else {
                        bVar.oyb.setVisibility(8);
                        bVar.oya.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.oya.setSelectedState(0);
                    }
                } else if (nVar.aJU == 1) {
                    bVar.oya.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.oya.setSelectedState(1);
                }
            } else {
                bVar.oya.setVisibility(8);
            }
            bVar.oxH.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oxJ.getMeasuredWidth() + c > bVar.oxP.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oxH.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oxH.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oxH.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oxH.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, boolean z) {
        if (view.getTag() != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.oxW != null && nVar.aJU == 0 && this.oxX != null && !this.oxX.contains(nVar.uk)) {
                if (!nVar.aJW && this.context != null) {
                    BdToast.makeText(this.context, this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                    return;
                }
                We(nVar.uk);
                this.oxW.a((n) view.getTag(), z);
            }
        }
    }

    private boolean Wd(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes11.dex */
    private class b {
        private TextView oxD;
        private View oxF;
        private HeadImageView oxG;
        private TextView oxH;
        private TextView oxJ;
        private ImageView oxK;
        private TextView oxL;
        private FrameLayout oxM;
        private TbImageView oxN;
        private TbImageView oxO;
        private LinearLayout oxP;
        private LinearLayout oxQ;
        private AlaAcceptAndInviteBtn oya;
        private AlaAcceptAndInviteBtn oyb;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oxW = aVar;
    }

    public void We(String str) {
        if (str != null && this.oxX != null && !this.oxX.contains(str)) {
            this.oxX.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.oxX != null) {
            this.oxX.clear();
        }
    }
}
