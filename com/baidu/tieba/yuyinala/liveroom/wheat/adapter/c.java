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
    private a ocH;
    private List<String> ocI = new ArrayList();

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
        this.ocI.clear();
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
            bVar2.ocp = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.ocq = view.findViewById(a.f.margin_top_height);
            bVar2.ocs = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.ocu = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.oct = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.ocw = (TextView) view.findViewById(a.f.tv_level);
            bVar2.ocv = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.ocy = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.ocx = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.ocz = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.ocL = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.ocA = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.ocB = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        m mVar = (m) ListUtils.getItem(this.mList, i);
        if (mVar != null) {
            bVar.ocp.setText(Integer.toString(i + 1));
            bVar.ocs.setIsRound(true);
            bVar.ocs.setAutoChangeStyle(false);
            bVar.ocs.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (mVar != null && !TextUtils.isEmpty(mVar.portrait)) {
                bVar.ocs.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.ocs.setUrl(mVar.portrait);
                bVar.ocs.startLoad(mVar.portrait, 12, false);
            }
            bVar.ocu.setText(mVar.userName);
            bVar.oct.setText(mVar.userName);
            if (mVar.sex == 0) {
                bVar.ocv.setVisibility(8);
            } else {
                bVar.ocv.setVisibility(0);
                bVar.ocv.setImageResource(mVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = mVar.sex == 0 ? 3 : 2;
            bVar.ocx.setVisibility(8);
            bVar.ocz.setVisibility(8);
            int c = e.c(14.0f, view.getContext()) + (e.c(4.0f, view.getContext()) * 2);
            if (mVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < mVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (mVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.ocx.setVisibility(0);
                            bVar.ocy.startLoad(mVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.ocw.setText(Integer.toString(mVar.level));
                            i2 += e.c(13.0f, view.getContext()) + e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.ocz.setVisibility(0);
                            bVar.ocz.startLoad(mVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += e.c(42.0f, bVar.ocz.getContext()) + e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.ocs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.ocH != null && view2.getTag() != null && (view2.getTag() instanceof m)) {
                        c.this.ocH.a((m) view2.getTag());
                    }
                }
            });
            bVar.oct.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.ocH != null && view2.getTag() != null && (view2.getTag() instanceof m)) {
                        c.this.ocH.a((m) view2.getTag());
                    }
                }
            });
            bVar.ocs.setTag(mVar);
            bVar.oct.setTag(mVar);
            bVar.ocL.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.ocL.setTag(mVar);
            bVar.ocL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2.getTag() != null && (view2.getTag() instanceof m)) {
                        m mVar2 = (m) view2.getTag();
                        if (c.this.ocH != null && mVar2.aGL == 0 && c.this.ocI != null && !c.this.ocI.contains(mVar2.uk)) {
                            if (!mVar2.aGN && c.this.context != null) {
                                BdToast.makeText(c.this.context, c.this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                                return;
                            }
                            c.this.Vg(mVar2.uk);
                            c.this.ocH.b((m) view2.getTag());
                        }
                    }
                }
            });
            bVar.ocL.setVisibility(0);
            if (!Vf(mVar.uk)) {
                if (mVar.DA()) {
                    bVar.ocL.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.ocL.setBtnEnabled(false);
                } else if (mVar.aGL == 0) {
                    if (this.ocI != null && this.ocI.contains(mVar.uk)) {
                        bVar.ocL.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.ocL.setBtnEnabled(false);
                    } else {
                        bVar.ocL.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        bVar.ocL.setBtnEnabled(true);
                        bVar.ocL.setBtnEnabled(mVar.aGN);
                    }
                } else if (mVar.aGL == 1) {
                    bVar.ocL.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.ocL.setBtnEnabled(true);
                }
            } else {
                bVar.ocL.setVisibility(8);
            }
            bVar.oct.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.ocu.getMeasuredWidth() + i2 > bVar.ocA.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.oct.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.oct.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.oct.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.oct.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    private boolean Vf(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes4.dex */
    private class b {
        private LinearLayout ocA;
        private LinearLayout ocB;
        private AlaAcceptAndInviteBtn ocL;
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

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.ocH = aVar;
    }

    public void Vg(String str) {
        if (str != null && this.ocI != null && !this.ocI.contains(str)) {
            this.ocI.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.ocI != null) {
            this.ocI.clear();
        }
    }
}
