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
    private a oDb;
    private List<String> oDc = new ArrayList();

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
        this.oDc.clear();
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
            bVar2.oCI = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.oCK = view.findViewById(a.f.margin_top_height);
            bVar2.oCL = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.oCO = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oCM = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.oCQ = (TextView) view.findViewById(a.f.tv_level);
            bVar2.oCP = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.oCS = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.oCR = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.oCT = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.oDf = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.oDg = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat_blue);
            bVar2.oCU = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.oCV = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        r rVar = (r) ListUtils.getItem(this.mList, i);
        if (rVar != null) {
            bVar.oCI.setText(Integer.toString(i + 1));
            bVar.oCL.setIsRound(true);
            bVar.oCL.setAutoChangeStyle(false);
            bVar.oCL.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (rVar != null && !TextUtils.isEmpty(rVar.portrait)) {
                bVar.oCL.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oCL.setUrl(rVar.portrait);
                bVar.oCL.startLoad(rVar.portrait, 12, false);
            }
            bVar.oCO.setText(rVar.userName);
            bVar.oCM.setText(rVar.userName);
            if (rVar.sex == 0) {
                bVar.oCP.setVisibility(8);
            } else {
                bVar.oCP.setVisibility(0);
                bVar.oCP.setImageResource(rVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i2 = rVar.sex == 0 ? 3 : 2;
            bVar.oCR.setVisibility(8);
            bVar.oCT.setVisibility(8);
            final int d = com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(14.0f, view.getContext()) + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext()) * 2);
            if (rVar.mLiveMarkInfo != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < rVar.mLiveMarkInfo.size() && i4 < i2) {
                        switch (rVar.mLiveMarkInfo.get(i4).type) {
                            case 1:
                                bVar.oCR.setVisibility(0);
                                bVar.oCS.startLoad(rVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                bVar.oCQ.setText(Integer.toString(rVar.level));
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(13.0f, view.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                            case 105:
                                bVar.oCT.setVisibility(0);
                                bVar.oCT.startLoad(rVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                                d += com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(42.0f, bVar.oCT.getContext()) + com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(4.0f, view.getContext());
                                break;
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            bVar.oCL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oDb != null && view2.getTag() != null && (view2.getTag() instanceof r)) {
                        c.this.oDb.a((r) view2.getTag());
                    }
                }
            });
            bVar.oCM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.oDb != null && view2.getTag() != null && (view2.getTag() instanceof r)) {
                        c.this.oDb.a((r) view2.getTag());
                    }
                }
            });
            bVar.oCL.setTag(rVar);
            bVar.oCM.setTag(rVar);
            bVar.oDf.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oDf.setTag(rVar);
            bVar.oDf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, true);
                }
            });
            bVar.oDg.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.oDg.setTag(rVar);
            bVar.oDg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c.this.n(view2, false);
                }
            });
            bVar.oDg.setVisibility(8);
            bVar.oDg.setSelectedState(0);
            bVar.oDf.setVisibility(0);
            if (!VT(rVar.uk)) {
                if (rVar.BT()) {
                    bVar.oDf.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.oDf.setSelectedState(0);
                } else if (rVar.aHD == 0) {
                    if (this.oDc == null || !this.oDc.contains(rVar.uk)) {
                        if (!q.edE().edR()) {
                            bVar.oDf.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        } else {
                            bVar.oDg.setVisibility(0);
                            bVar.oDg.setSelectedState(2);
                            bVar.oDf.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_apply_red_team_text));
                        }
                        bVar.oDf.setSelectedState(rVar.aHF ? 1 : 0);
                    } else {
                        bVar.oDg.setVisibility(8);
                        bVar.oDf.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.oDf.setSelectedState(0);
                    }
                } else if (rVar.aHD == 1) {
                    bVar.oDf.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.oDf.setSelectedState(1);
                }
            } else {
                bVar.oDf.setVisibility(8);
            }
            bVar.oCM.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.5
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.oCO.getMeasuredWidth() + d > bVar.oCU.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oCM.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oCM.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oCM.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oCM.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view, boolean z) {
        if (view.getTag() != null && (view.getTag() instanceof r)) {
            r rVar = (r) view.getTag();
            if (this.oDb != null && rVar.aHD == 0 && this.oDc != null && !this.oDc.contains(rVar.uk)) {
                if (!rVar.aHF && this.context != null) {
                    BdToast.makeText(this.context, this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                    return;
                }
                VU(rVar.uk);
                this.oDb.a((r) view.getTag(), z);
            }
        }
    }

    private boolean VT(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes11.dex */
    private class b {
        private TextView oCI;
        private View oCK;
        private HeadImageView oCL;
        private TextView oCM;
        private TextView oCO;
        private ImageView oCP;
        private TextView oCQ;
        private FrameLayout oCR;
        private TbImageView oCS;
        private TbImageView oCT;
        private LinearLayout oCU;
        private LinearLayout oCV;
        private AlaAcceptAndInviteBtn oDf;
        private AlaAcceptAndInviteBtn oDg;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.oDb = aVar;
    }

    public void VU(String str) {
        if (str != null && this.oDc != null && !this.oDc.contains(str)) {
            this.oDc.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.oDc != null) {
            this.oDc.clear();
        }
    }
}
