package com.baidu.tieba.live.tbean.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.live.tbean.data.IconInfoData;
import com.baidu.tieba.live.tbean.data.IconInfoWrapperData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BuyTBeanGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<IconInfoData> mIconInfoDatas = new ArrayList();
    private TbPageContext<?> mPageContext;

    public void setIconInfoDatas(List<IAdapterData> list) {
        if (list == null || list.isEmpty()) {
            this.mIconInfoDatas.clear();
            notifyDataSetChanged();
            return;
        }
        this.mIconInfoDatas.clear();
        for (IAdapterData iAdapterData : list) {
            if ((iAdapterData instanceof IconInfoWrapperData) && ((IconInfoWrapperData) iAdapterData).info != null) {
                this.mIconInfoDatas.add(((IconInfoWrapperData) iAdapterData).info);
            }
        }
        notifyDataSetChanged();
    }

    public BuyTBeanGridAdapter(TbPageContext tbPageContext, Context context) {
        this.mPageContext = tbPageContext;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mIconInfoDatas == null || this.mIconInfoDatas.isEmpty()) {
            return 0;
        }
        return this.mIconInfoDatas.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mIconInfoDatas == null || this.mIconInfoDatas.size() <= i) {
            return null;
        }
        return this.mIconInfoDatas.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        BeanHolder beanHolder;
        if (TbadkCoreApplication.getInst().isHaokan() && (Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20)) {
            BdUtilHelper.clearFocus(this.mContext);
        }
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.sdk_tbn_buy_tbean_item_grid, viewGroup, false);
            beanHolder = new BeanHolder();
            beanHolder.ivIcon = (TbImageView) view.findViewById(a.g.img_bean_icon);
            beanHolder.tvBeanNum = (TextView) view.findViewById(a.g.tv_bean_num);
            beanHolder.tvBeanName = (TextView) view.findViewById(a.g.tv_bean_name);
            beanHolder.tvBeanUnit = (TextView) view.findViewById(a.g.tv_bean_unit);
            beanHolder.tvBeanPrice = (TextView) view.findViewById(a.g.tv_bean_price);
            view.setTag(beanHolder);
        } else {
            beanHolder = (BeanHolder) view.getTag();
        }
        IconInfoData iconInfoData = this.mIconInfoDatas.get(i);
        if (iconInfoData.non_member_t < 0) {
            beanHolder.tvBeanNum.setText(StringHelper.formatTosepara(0));
            beanHolder.tvBeanUnit.setText("");
        } else if (iconInfoData.non_member_t < 10000) {
            beanHolder.tvBeanNum.setText(StringHelper.formatTosepara(iconInfoData.non_member_t));
            beanHolder.tvBeanUnit.setText("");
        } else {
            beanHolder.tvBeanNum.setText(StringHelper.formatTosepara(iconInfoData.non_member_t / 10000));
            beanHolder.tvBeanUnit.setText("万");
        }
        beanHolder.tvBeanPrice.setText(String.format("%s.00", buildPriceCommonText(getYuanFromFen(iconInfoData.dubi))));
        beanHolder.tvBeanName.setText(this.mPageContext.getPageActivity().getString(a.i.sdk_tbn_icon_name_valid_day, new Object[]{iconInfoData.name, Integer.valueOf(iconInfoData.duration)}));
        beanHolder.ivIcon.startLoad(iconInfoData.picUrl, 10, false);
        return view;
    }

    /* loaded from: classes2.dex */
    private class BeanHolder {
        TbImageView ivIcon;
        TextView tvBeanName;
        TextView tvBeanNum;
        TextView tvBeanPrice;
        TextView tvBeanUnit;

        private BeanHolder() {
        }
    }

    private String buildPriceCommonText(int i) {
        if (this.mPageContext == null) {
            return null;
        }
        return this.mPageContext.getPageActivity().getString(a.i.sdk_tbn_pay_money, new Object[]{String.valueOf(i)});
    }

    private int getYuanFromFen(int i) {
        return (int) (i / 100.0f);
    }
}
