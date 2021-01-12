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
    private a otp;
    private List<String> otq = new ArrayList();

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
        this.otq.clear();
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
            bVar2.osW = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.osY = view.findViewById(a.f.margin_top_height);
            bVar2.osZ = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.otc = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.ota = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.ote = (TextView) view.findViewById(a.f.tv_level);
            bVar2.otd = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.otg = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.otf = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oth = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.ott = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.otu = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat_blue);
            bVar2.oti = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.otj = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        n nVar = (n) ListUtils.getItem(this.mList, i);
        if (nVar != null) {
            bVar.osW.setText(Integer.toString(i + 1));
            bVar.osZ.setIsRound(true);
            bVar.osZ.setAutoChangeStyle(false);
            bVar.osZ.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (nVar != null && !TextUtils.isEmpty(nVar.portrait)) {
                bVar.osZ.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.osZ.setUrl(nVar.portrait);
                bVar.osZ.startLoad(nVar.portrait, 12, false);
            }
            bVar.otc.setText(nVar.userName);
            bVar.ota.setText(nVar.userName);
            if (nVar.sex == 0) {
                bVar.otd.setVisibility(8);
            } else {
                bVar.otd.setVisibility(0);
                bVar.otd.setImageResource(nVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = nVar.sex == 0 ? 3 : 2;
            bVar.otf.setVisibility(8);
            bVar.oth.setVisibility(8);
            final int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (nVar.mLiveMarkInfo != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < nVar.mLiveMarkInfo.size() && i4 < i2) {
                        switch (nVar.mLiveMarkInfo.get(i4).type) {
                            case 1:
                                bVar.otf.setVisibility(0);
                                bVar.otg.startLoad(nVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                bVar.ote.setText(Integer.toString(nVar.level));
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                            case 105:
                                bVar.oth.setVisibility(0);
                                bVar.oth.startLoad(nVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oth.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            bVar.osZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.otp != null && view2.getTag() != null && (view2.getTag() instanceof n)) {
                        c.this.otp.a((n) view2.getTag());
                    }
                }
            });
            bVar.ota.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.otp != null && view2.getTag() != null && (view2.getTag() instanceof n)) {
                        c.this.otp.a((n) view2.getTag());
                    }
                }
            });
            bVar.osZ.setTag(nVar);
            bVar.ota.setTag(nVar);
            bVar.ott.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.ott.setTag(nVar);
            bVar.ott.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, true);
                }
            });
            bVar.otu.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.otu.setTag(nVar);
            bVar.otu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, false);
                }
            });
            bVar.otu.setVisibility(8);
            bVar.otu.setSelectedState(0);
            bVar.ott.setVisibility(0);
            if (!UU(nVar.uk)) {
                if (nVar.AG()) {
                    bVar.ott.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.ott.setSelectedState(0);
                } else if (nVar.aFh == 0) {
                    if (this.otq == null || !this.otq.contains(nVar.uk)) {
                        if (!o.ebo().ebE()) {
                            bVar.ott.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        } else {
                            bVar.otu.setVisibility(0);
                            bVar.otu.setSelectedState(2);
                            bVar.ott.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_apply_red_team_text));
                        }
                        bVar.ott.setSelectedState(nVar.aFj ? 1 : 0);
                    } else {
                        bVar.otu.setVisibility(8);
                        bVar.ott.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.ott.setSelectedState(0);
                    }
                } else if (nVar.aFh == 1) {
                    bVar.ott.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.ott.setSelectedState(1);
                }
            } else {
                bVar.ott.setVisibility(8);
            }
            bVar.ota.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.otc.getMeasuredWidth() + d > bVar.oti.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.ota.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.ota.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.ota.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.ota.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, boolean z) {
        if (view.getTag() != null && (view.getTag() instanceof n)) {
            n nVar = (n) view.getTag();
            if (this.otp != null && nVar.aFh == 0 && this.otq != null && !this.otq.contains(nVar.uk)) {
                if (!nVar.aFj && this.context != null) {
                    BdToast.makeText(this.context, this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                    return;
                }
                UV(nVar.uk);
                this.otp.a((n) view.getTag(), z);
            }
        }
    }

    private boolean UU(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes10.dex */
    private class b {
        private TextView osW;
        private View osY;
        private HeadImageView osZ;
        private TextView ota;
        private TextView otc;
        private ImageView otd;
        private TextView ote;
        private FrameLayout otf;
        private TbImageView otg;
        private TbImageView oth;
        private LinearLayout oti;
        private LinearLayout otj;
        private AlaAcceptAndInviteBtn ott;
        private AlaAcceptAndInviteBtn otu;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.otp = aVar;
    }

    public void UV(String str) {
        if (str != null && this.otq != null && !this.otq.contains(str)) {
            this.otq.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.otq != null) {
            this.otq.clear();
        }
    }
}
