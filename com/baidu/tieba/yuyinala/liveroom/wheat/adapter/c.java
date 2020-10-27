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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.wheat.d.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private String authorUk;
    private Context context;
    private List<m> mList;
    private a nTO;
    private List<String> nTP = new ArrayList();

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
        this.nTP.clear();
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
            view = LayoutInflater.from(this.context).inflate(a.h.yuyin_item_connection_wheat_invite, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.nTy = (TextView) view.findViewById(a.g.tv_rank_num);
            bVar2.nTz = view.findViewById(a.g.margin_top_height);
            bVar2.nTA = (HeadImageView) view.findViewById(a.g.user_avatar);
            bVar2.nTC = (TextView) view.findViewById(a.g.tv_temp_nickname);
            bVar2.nTB = (TextView) view.findViewById(a.g.tv_nickname);
            bVar2.nTE = (TextView) view.findViewById(a.g.tv_level);
            bVar2.nTD = (ImageView) view.findViewById(a.g.iv_sex);
            bVar2.nTG = (TbImageView) view.findViewById(a.g.iv_level);
            bVar2.nTF = (FrameLayout) view.findViewById(a.g.level_container);
            bVar2.nTH = (TbImageView) view.findViewById(a.g.iv_badge);
            bVar2.nTS = (TextView) view.findViewById(a.g.tv_invite_connection_wheat);
            bVar2.nTI = (LinearLayout) view.findViewById(a.g.content_container);
            bVar2.nTJ = (LinearLayout) view.findViewById(a.g.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        m mVar = (m) ListUtils.getItem(this.mList, i);
        if (mVar != null) {
            bVar.nTy.setText(Integer.toString(i + 1));
            bVar.nTA.setIsRound(true);
            bVar.nTA.setAutoChangeStyle(false);
            bVar.nTA.setDefaultResource(a.f.yuyin_sdk_default_avatar);
            if (mVar != null && !TextUtils.isEmpty(mVar.portrait)) {
                bVar.nTA.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.nTA.setUrl(mVar.portrait);
                bVar.nTA.startLoad(mVar.portrait, 12, false);
            }
            bVar.nTC.setText(mVar.userName);
            bVar.nTB.setText(mVar.userName);
            if (mVar.sex == 0) {
                bVar.nTD.setVisibility(8);
            } else {
                bVar.nTD.setVisibility(0);
                bVar.nTD.setImageResource(mVar.sex == 1 ? a.f.yuyin_sdk_icon_mine_boy : a.f.yuyin_sdk_icon_mine_girl);
            }
            int i3 = mVar.sex == 0 ? 3 : 2;
            bVar.nTF.setVisibility(8);
            bVar.nTH.setVisibility(8);
            int c = e.c(14.0f, view.getContext()) + (e.c(4.0f, view.getContext()) * 2);
            if (mVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < mVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (mVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.nTF.setVisibility(0);
                            bVar.nTG.startLoad(mVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.nTE.setText(Integer.toString(mVar.level));
                            i2 += e.c(13.0f, view.getContext()) + e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.nTH.setVisibility(0);
                            bVar.nTH.startLoad(mVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += e.c(42.0f, bVar.nTH.getContext()) + e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.nTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.nTO != null && view2.getTag() != null && (view2.getTag() instanceof m)) {
                        c.this.nTO.a((m) view2.getTag());
                    }
                }
            });
            bVar.nTB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.nTO != null && view2.getTag() != null && (view2.getTag() instanceof m)) {
                        c.this.nTO.a((m) view2.getTag());
                    }
                }
            });
            bVar.nTA.setTag(mVar);
            bVar.nTB.setTag(mVar);
            bVar.nTS.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.nTS.setTag(mVar);
            bVar.nTS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2.getTag() != null && (view2.getTag() instanceof m)) {
                        m mVar2 = (m) view2.getTag();
                        if (c.this.nTO != null && mVar2.aHF == 0 && c.this.nTP != null && !c.this.nTP.contains(mVar2.uk)) {
                            c.this.Ve(mVar2.uk);
                            c.this.nTO.b((m) view2.getTag());
                        }
                    }
                }
            });
            bVar.nTS.setVisibility(0);
            if (!Vd(mVar.uk)) {
                if (mVar.DQ()) {
                    bVar.nTS.setText(TbadkCoreApplication.getInst().getString(a.i.yuyin_living));
                    bVar.nTS.setBackgroundResource(0);
                    bVar.nTS.setTextColor(this.context.getResources().getColor(a.d.sdk_color_858585));
                } else if (mVar.aHF == 0) {
                    if (this.nTP != null && this.nTP.contains(mVar.uk)) {
                        bVar.nTS.setText(TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.nTS.setBackgroundResource(0);
                        bVar.nTS.setTextColor(this.context.getResources().getColor(a.d.sdk_color_858585));
                    } else {
                        bVar.nTS.setText(TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_invite_1_text));
                        bVar.nTS.setBackgroundResource(a.f.yuyin_sdk_wheat_connection_accept_btn_bg);
                        bVar.nTS.setTextColor(this.context.getResources().getColor(a.d.sdk_color_ff1e66));
                    }
                } else if (mVar.aHF == 1) {
                    bVar.nTS.setText(TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connecting_wheat_text_2));
                    bVar.nTS.setBackgroundResource(0);
                    bVar.nTS.setTextColor(this.context.getResources().getColor(a.d.sdk_color_ff1e66));
                }
            } else {
                bVar.nTS.setVisibility(8);
            }
            bVar.nTB.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.nTC.getMeasuredWidth() + i2 > bVar.nTI.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.nTB.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.nTB.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.nTB.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.nTB.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    private boolean Vd(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes4.dex */
    private class b {
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
        private TextView nTS;
        private TextView nTy;
        private View nTz;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.nTO = aVar;
    }

    public void Ve(String str) {
        if (str != null && this.nTP != null && !this.nTP.contains(str)) {
            this.nTP.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.nTP != null) {
            this.nTP.clear();
        }
    }
}
