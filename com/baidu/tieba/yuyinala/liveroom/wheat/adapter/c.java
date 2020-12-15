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
    private a orJ;
    private List<String> orK = new ArrayList();

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
        this.orK.clear();
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
            bVar2.ors = (TextView) view.findViewById(a.f.tv_rank_num);
            bVar2.ort = view.findViewById(a.f.margin_top_height);
            bVar2.oru = (HeadImageView) view.findViewById(a.f.user_avatar);
            bVar2.orw = (TextView) view.findViewById(a.f.tv_temp_nickname);
            bVar2.orv = (TextView) view.findViewById(a.f.tv_nickname);
            bVar2.ory = (TextView) view.findViewById(a.f.tv_level);
            bVar2.orx = (ImageView) view.findViewById(a.f.iv_sex);
            bVar2.orA = (TbImageView) view.findViewById(a.f.iv_level);
            bVar2.orz = (FrameLayout) view.findViewById(a.f.level_container);
            bVar2.orB = (TbImageView) view.findViewById(a.f.iv_badge);
            bVar2.orN = (AlaAcceptAndInviteBtn) view.findViewById(a.f.tv_invite_connection_wheat);
            bVar2.orC = (LinearLayout) view.findViewById(a.f.content_container);
            bVar2.orD = (LinearLayout) view.findViewById(a.f.icon_container);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        m mVar = (m) ListUtils.getItem(this.mList, i);
        if (mVar != null) {
            bVar.ors.setText(Integer.toString(i + 1));
            bVar.oru.setIsRound(true);
            bVar.oru.setAutoChangeStyle(false);
            bVar.oru.setDefaultResource(a.e.yuyin_sdk_default_avatar);
            if (mVar != null && !TextUtils.isEmpty(mVar.portrait)) {
                bVar.oru.setScaleType(ImageView.ScaleType.FIT_XY);
                bVar.oru.setUrl(mVar.portrait);
                bVar.oru.startLoad(mVar.portrait, 12, false);
            }
            bVar.orw.setText(mVar.userName);
            bVar.orv.setText(mVar.userName);
            if (mVar.sex == 0) {
                bVar.orx.setVisibility(8);
            } else {
                bVar.orx.setVisibility(0);
                bVar.orx.setImageResource(mVar.sex == 1 ? a.e.yuyin_sdk_icon_mine_boy : a.e.yuyin_sdk_icon_mine_girl);
            }
            int i3 = mVar.sex == 0 ? 3 : 2;
            bVar.orz.setVisibility(8);
            bVar.orB.setVisibility(8);
            int c = e.c(14.0f, view.getContext()) + (e.c(4.0f, view.getContext()) * 2);
            if (mVar.mLiveMarkInfo != null) {
                i2 = c;
                for (int i4 = 0; i4 < mVar.mLiveMarkInfo.size() && i4 < i3; i4++) {
                    switch (mVar.mLiveMarkInfo.get(i4).type) {
                        case 1:
                            bVar.orz.setVisibility(0);
                            bVar.orA.startLoad(mVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            bVar.ory.setText(Integer.toString(mVar.level));
                            i2 += e.c(13.0f, view.getContext()) + e.c(4.0f, view.getContext());
                            break;
                        case 105:
                            bVar.orB.setVisibility(0);
                            bVar.orB.startLoad(mVar.mLiveMarkInfo.get(i4).mark_pic, 10, false);
                            i2 += e.c(42.0f, bVar.orB.getContext()) + e.c(4.0f, view.getContext());
                            break;
                    }
                }
            } else {
                i2 = c;
            }
            bVar.oru.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.orJ != null && view2.getTag() != null && (view2.getTag() instanceof m)) {
                        c.this.orJ.a((m) view2.getTag());
                    }
                }
            });
            bVar.orv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.orJ != null && view2.getTag() != null && (view2.getTag() instanceof m)) {
                        c.this.orJ.a((m) view2.getTag());
                    }
                }
            });
            bVar.oru.setTag(mVar);
            bVar.orv.setTag(mVar);
            bVar.orN.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
            bVar.orN.setTag(mVar);
            bVar.orN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2.getTag() != null && (view2.getTag() instanceof m)) {
                        m mVar2 = (m) view2.getTag();
                        if (c.this.orJ != null && mVar2.aJv == 0 && c.this.orK != null && !c.this.orK.contains(mVar2.uk)) {
                            if (!mVar2.aJx && c.this.context != null) {
                                BdToast.makeText(c.this.context, c.this.context.getText(a.h.yuyin_ala_wheat_unable_newuser_text)).show();
                                return;
                            }
                            c.this.Wv(mVar2.uk);
                            c.this.orJ.b((m) view2.getTag());
                        }
                    }
                }
            });
            bVar.orN.setVisibility(0);
            if (!Wu(mVar.uk)) {
                if (mVar.Fl()) {
                    bVar.orN.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_living));
                    bVar.orN.setBtnEnabled(false);
                } else if (mVar.aJv == 0) {
                    if (this.orK != null && this.orK.contains(mVar.uk)) {
                        bVar.orN.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_have_invited_text));
                        bVar.orN.setBtnEnabled(false);
                    } else {
                        bVar.orN.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_invite_1_text));
                        bVar.orN.setBtnEnabled(true);
                        bVar.orN.setBtnEnabled(mVar.aJx);
                    }
                } else if (mVar.aJv == 1) {
                    bVar.orN.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connecting_wheat_text_2));
                    bVar.orN.setBtnEnabled(true);
                }
            } else {
                bVar.orN.setVisibility(8);
            }
            bVar.orv.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c.4
                @Override // java.lang.Runnable
                public void run() {
                    if (bVar.orw.getMeasuredWidth() + i2 > bVar.orC.getMeasuredWidth()) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.orv.getLayoutParams();
                        layoutParams.weight = 1.0f;
                        bVar.orv.setLayoutParams(layoutParams);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.orv.getLayoutParams();
                    layoutParams2.weight = 0.0f;
                    layoutParams2.width = -2;
                    bVar.orv.setLayoutParams(layoutParams2);
                }
            });
        }
        return view;
    }

    private boolean Wu(String str) {
        return str != null && TextUtils.equals(str, this.authorUk);
    }

    /* loaded from: classes4.dex */
    private class b {
        private TbImageView orA;
        private TbImageView orB;
        private LinearLayout orC;
        private LinearLayout orD;
        private AlaAcceptAndInviteBtn orN;
        private TextView ors;
        private View ort;
        private HeadImageView oru;
        private TextView orv;
        private TextView orw;
        private ImageView orx;
        private TextView ory;
        private FrameLayout orz;

        private b() {
        }
    }

    public void setOnItemClickLister(a aVar) {
        this.orJ = aVar;
    }

    public void Wv(String str) {
        if (str != null && this.orK != null && !this.orK.contains(str)) {
            this.orK.add(str);
            notifyDataSetChanged();
        }
    }

    public void clear() {
        if (this.orK != null) {
            this.orK.clear();
        }
    }
}
