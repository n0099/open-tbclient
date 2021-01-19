package com.baidu.tieba.yuyinala.liveroom.chooselover;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes10.dex */
public class d extends BaseAdapter {
    private Context mContext;
    private List<AlaWheatInfoData> mList;

    public d(Context context) {
        this.mContext = context;
    }

    public void setData(List<AlaWheatInfoData> list) {
        this.mList = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.yuyin_ala_item_choose_love_person, (ViewGroup) null);
            a aVar2 = new a(view);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                aVar2.okf.setDefaultResource(a.e.sdk_icon_default_avatar100_hk);
            } else {
                aVar2.okf.setDefaultResource(a.e.sdk_icon_default_avatar100);
            }
            aVar2.okf.setIsRound(true);
            aVar2.okf.setDrawBorder(true);
            aVar2.okf.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
            aVar2.okf.setAutoChangeStyle(false);
            aVar2.okf.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        AlaWheatInfoData alaWheatInfoData = (AlaWheatInfoData) getItem(i);
        g(aVar.okh);
        aVar.okf.setDrawBorder(true);
        aVar.bAH.setText(alaWheatInfoData.userName);
        if (!TextUtils.isEmpty(alaWheatInfoData.portrait)) {
            aVar.okf.startLoad(alaWheatInfoData.portrait, 12, false, false);
        }
        if (alaWheatInfoData.sex == 2) {
            aVar.okg.setBackgroundResource(a.e.shape_yuin_choose_love_person_woman);
        } else {
            aVar.okg.setBackgroundResource(a.e.shape_yuin_choose_love_person_man);
        }
        aVar.okg.setText(alaWheatInfoData.realWheatPosition + "");
        if (alaWheatInfoData.isSelect) {
            aVar.okf.setBackgroundResource(a.e.shape_yuin_choose_love_person_select);
        } else {
            aVar.okf.setBackgroundResource(a.e.shape_yuin_choose_love_person_unselect);
        }
        return view;
    }

    public void eq(View view) {
        if (view != null && view.findViewById(a.f.iv_head) != null) {
            view.findViewById(a.f.iv_head).setBackgroundResource(a.e.shape_yuin_choose_love_person_unselect);
        }
    }

    public void er(View view) {
        if (view != null && view.findViewById(a.f.iv_head) != null) {
            view.findViewById(a.f.iv_head).setBackgroundResource(a.e.shape_yuin_choose_love_person_select);
        }
    }

    public void g(LinearLayout linearLayout) {
        ViewGroup.LayoutParams layoutParams;
        if (linearLayout != null && (layoutParams = linearLayout.getLayoutParams()) != null) {
            layoutParams.width = Math.max((BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels - BdUtilHelper.dip2px(this.mContext, 40.0f)) / 4, BdUtilHelper.dip2px(this.mContext, 62.0f));
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public TextView bAH;
        public HeadImageView okf;
        public TextView okg;
        public LinearLayout okh;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.okf = (HeadImageView) view.findViewById(a.f.iv_head);
            this.bAH = (TextView) view.findViewById(a.f.tv_name);
            this.okg = (TextView) view.findViewById(a.f.tv_sex);
            this.okh = (LinearLayout) view.findViewById(a.f.ll_bg);
        }
    }
}
