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
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    private String authorUk;
    private Context context;
    private List<r> mList;
    private a oDB;
    private List<String> oDC = new ArrayList();

    /* loaded from: classes11.dex */
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
        this.oDC.clear();
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
            bVar2.oDi = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oDk = view.findViewById(a.f.margin_top_height);
            bVar2.oDl = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oDo = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oDm = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oDq = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oDp = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oDs = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oDr = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oDt = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oDF = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.oDG = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat_blue);
            bVar2.oDu = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oDv = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        r rVar = (r) ListUtils.getItem(this.mList, i);
        if (rVar != null) {
            bVar.oDi.setText(Integer.toString(i + 1));
            bVar.oDl.setIsRound(true);
            bVar.oDl.setAutoChangeStyle(false);
            bVar.oDl.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (rVar != null && !TextUtils.isEmpty(rVar.portrait)) {
                bVar.oDl.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oDl.setUrl(rVar.portrait);
                bVar.oDl.startLoad(rVar.portrait, 12, false);
            }
            bVar.oDo.setText(rVar.userName);
            bVar.oDm.setText(rVar.userName);
            if (rVar.sex == 0) {
                bVar.oDp.setVisibility(8);
            } else {
                bVar.oDp.setVisibility(0);
                bVar.oDp.setImageResource(rVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = rVar.sex == 0 ? 3 : 2;
            bVar.oDr.setVisibility(8);
            bVar.oDt.setVisibility(8);
            final int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (rVar.mLiveMarkInfo != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < rVar.mLiveMarkInfo.size() && i4 < i2) {
                        switch (rVar.mLiveMarkInfo.get(i4).type) {
                            case 1:
                                bVar.oDr.setVisibility(0);
                                bVar.oDs.startLoad(rVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                bVar.oDq.setText(Integer.toString(rVar.level));
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                            case 105:
                                bVar.oDt.setVisibility(0);
                                bVar.oDt.startLoad(rVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oDt.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            bVar.oDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oDB != null && view2.getTag() != null && (view2.getTag() instanceof r)) {
                        c.this.oDB.a((r) view2.getTag());
                    }
                }
            });
            bVar.oDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oDB != null && view2.getTag() != null && (view2.getTag() instanceof r)) {
                        c.this.oDB.a((r) view2.getTag());
                    }
                }
            });
            bVar.oDl.setTag(rVar);
            bVar.oDm.setTag(rVar);
            bVar.oDF.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oDF.setTag(rVar);
            bVar.oDF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, true);
                }
            });
            bVar.oDG.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oDG.setTag(rVar);
            bVar.oDG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, false);
                }
            });
            bVar.oDG.setVisibility(8);
            bVar.oDG.setSelectedState(0);
            bVar.oDF.setVisibility(0);
            if (!Wf(rVar.uk)) {
                if (rVar.BT()) {
                    bVar.oDF.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.oDF.setSelectedState(0);
                } else if (rVar.aHD == 0) {
                    if (this.oDC == null || !this.oDC.contains(rVar.uk)) {
                        if (!q.edM().edZ()) {
                            bVar.oDF.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        } else {
                            bVar.oDG.setVisibility(0);
                            bVar.oDG.setSelectedState(2);
                            bVar.oDF.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_apply_red_team_text));
                        }
                        bVar.oDF.setSelectedState(rVar.aHF ? 1 : 0);
                    } else {
                        bVar.oDG.setVisibility(8);
                        bVar.oDF.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.oDF.setSelectedState(0);
                    }
                } else if (rVar.aHD == 1) {
                    bVar.oDF.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.oDF.setSelectedState(1);
                }
            } else {
                bVar.oDF.setVisibility(8);
            }
            bVar.oDm.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oDo.getMeasuredWidth() + d > bVar.oDu.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oDm.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oDm.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oDm.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oDm.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, boolean z) {
        if (view.getTag() != null && (view.getTag() instanceof r)) {
            r rVar = (r) view.getTag();
            if (this.oDB != null && rVar.aHD == 0 && this.oDC != null && !this.oDC.contains(rVar.uk)) {
                if (!rVar.aHF && this.context != null) {
                    BdToast.makeText(this.context, this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                    return;
                }
                Wg(rVar.uk);
                this.oDB.a((r) view.getTag(), z);
            }
        }
    }

    private boolean Wf(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes11.dex */
    private class b {
        private AlaAcceptAndInviteBtn oDF;
        private AlaAcceptAndInviteBtn oDG;
        private TextView oDi;
        private View oDk;
        private HeadImageView oDl;
        private TextView oDm;
        private TextView oDo;
        private ImageView oDp;
        private TextView oDq;
        private FrameLayout oDr;
        private TbImageView oDs;
        private TbImageView oDt;
        private LinearLayout oDu;
        private LinearLayout oDv;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oDB = aVar;
    }

    public void Wg(String str) {
        if (str != null && this.oDC != null && !this.oDC.contains(str)) {
            this.oDC.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.oDC != null) {
            this.oDC.clear();
        }
    }
}
