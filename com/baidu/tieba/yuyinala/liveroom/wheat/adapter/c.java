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
import com.baidu.live.data.m;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaAcceptAndInviteBtn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private String authorUk;
    private Context context;
    private List<m> mList;
    private a obc;
    private List<String> obd = new ArrayList();

    /* loaded from: classes4.dex */
    public interface a {
        void a(m mVar);

        void b(m mVar);
    }

    public c(Context context) {
        this.context = context;
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        this.authorUk = currentAccountInfo != null ? ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID()) : null;
    }

    public void setData(List<m> list) {
        this.obd.clear();
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
            view = LayoutInflater.from(this.context).inflate(a.g.yuyin_item_connection_wheat_invite, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.oaL = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oaM = view.findViewById(a.f.margin_top_height);
            bVar2.oaN = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oaP = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oaO = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oaR = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oaQ = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oaT = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oaS = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oaU = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.obg = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.oaV = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oaW = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        m mVar = (m) ListUtils.getItem(this.mList, i);
        if (mVar != null) {
            bVar.oaL.setText(Integer.toString(i + 1));
            bVar.oaN.setIsRound(true);
            bVar.oaN.setAutoChangeStyle(false);
            bVar.oaN.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (mVar != null && !TextUtils.isEmpty(mVar.portrait)) {
                bVar.oaN.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oaN.setUrl(mVar.portrait);
                bVar.oaN.startLoad(mVar.portrait, 12, false);
            }
            bVar.oaP.setText(mVar.userName);
            bVar.oaO.setText(mVar.userName);
            if (mVar.sex == 0) {
                bVar.oaQ.setVisibility(8);
            } else {
                bVar.oaQ.setVisibility(0);
                bVar.oaQ.setImageResource(mVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = mVar.sex == 0 ? 3 : 2;
            bVar.oaS.setVisibility(8);
            bVar.oaU.setVisibility(8);
            int c = e.c(14.0f, view.getContext()) + (e.c(4.0f, view.getContext()) * 2);
            if (mVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < mVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (mVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.oaS.setVisibility(0);
                            bVar.oaT.startLoad(mVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.oaR.setText(Integer.toString(mVar.level));
                            i2 += e.c(13.0f, view.getContext()) + e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.oaU.setVisibility(0);
                            bVar.oaU.startLoad(mVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += e.c(42.0f, bVar.oaU.getContext()) + e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.oaN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.obc != null && view2.getTag() != null && (view2.getTag() instanceof m)) {
                        c.this.obc.a((m) view2.getTag());
                    }
                }
            });
            bVar.oaO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.obc != null && view2.getTag() != null && (view2.getTag() instanceof m)) {
                        c.this.obc.a((m) view2.getTag());
                    }
                }
            });
            bVar.oaN.setTag(mVar);
            bVar.oaO.setTag(mVar);
            bVar.obg.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.obg.setTag(mVar);
            bVar.obg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2.getTag() != null && (view2.getTag() instanceof m)) {
                        m mVar2 = (m) view2.getTag();
                        if (c.this.obc != null && mVar2.aIw == 0 && c.this.obd != null && !c.this.obd.contains(mVar2.uk)) {
                            if (!mVar2.aIy && c.this.context != null) {
                                BdToast.makeText(c.this.context, c.this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                                return;
                            }
                            c.this.Vv(mVar2.uk);
                            c.this.obc.b((m) view2.getTag());
                        }
                    }
                }
            });
            bVar.obg.setVisibility(0);
            if (!Vu(mVar.uk)) {
                if (mVar.Ej()) {
                    bVar.obg.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.obg.setBtnEnabled(false);
                } else if (mVar.aIw == 0) {
                    if (this.obd != null && this.obd.contains(mVar.uk)) {
                        bVar.obg.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.obg.setBtnEnabled(false);
                    } else {
                        bVar.obg.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        bVar.obg.setBtnEnabled(true);
                        bVar.obg.setBtnEnabled(mVar.aIy);
                    }
                } else if (mVar.aIw == 1) {
                    bVar.obg.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.obg.setBtnEnabled(true);
                }
            } else {
                bVar.obg.setVisibility(8);
            }
            bVar.oaO.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
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
        }
        return view;
    }

    private boolean Vu(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
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
        private AlaAcceptAndInviteBtn obg;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.obc = aVar;
    }

    public void Vv(String str) {
        if (str != null && this.obd != null && !this.obd.contains(str)) {
            this.obd.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.obd != null) {
            this.obd.clear();
        }
    }
}
