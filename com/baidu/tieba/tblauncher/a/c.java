package com.baidu.tieba.tblauncher.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private TextView bHV;
    private HeadImageView bWm;
    private ImageView cwt;
    private TbImageView cwu;
    private ImageView cwv;
    private TbImageView cww;
    private ListView cwx;
    private TextView cwy;
    private TextView cwz;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.hr().a(getContext(), r.main_tab_left_navigation, this, true);
        setOrientation(1);
        this.bWm = (HeadImageView) findViewById(q.user_head);
        this.cwt = (ImageView) findViewById(q.user_head_red_tip);
        this.cwu = (TbImageView) findViewById(q.user_vip_icon);
        this.cwv = (ImageView) findViewById(q.left_navi_setting_red_tip);
        this.bHV = (TextView) findViewById(q.user_name);
        this.cww = (TbImageView) findViewById(q.user_sex);
        this.cwx = (ListView) findViewById(q.left_navi_listview);
        this.cwy = (TextView) findViewById(q.left_navi_setting);
        this.cwz = (TextView) findViewById(q.left_navi_daynight);
        com.baidu.adp.lib.util.n.a(getContext(), this.cwz, 15, 10, 10, 10);
        afq();
        aqz();
        if (this.cwz != null) {
            if (!LL()) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                this.cwz.setVisibility(8);
                return;
            }
            this.cwz.setVisibility(0);
        }
    }

    public boolean LL() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.cwy != null) {
            this.cwy.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.cwz != null) {
            this.cwz.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(com.baidu.tbadk.widget.n nVar) {
        if (this.cwu != null) {
            this.cwu.setEvent(nVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.bWm != null) {
            this.bWm.setOnClickListener(onClickListener);
        }
        if (this.bHV != null) {
            this.bHV.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.cwx != null) {
            this.cwx.setOnItemClickListener(onItemClickListener);
        }
    }

    private void afq() {
        if (this.bWm != null) {
            this.bWm.setIsRound(true);
            this.bWm.setDefaultBgResource(0);
            this.bWm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bWm.setDefaultResource(com.baidu.tieba.p.pic_mycenter_avatar_def);
        }
    }

    public TbImageView getUserHeadView() {
        return this.bWm;
    }

    public void ft(boolean z) {
        if (this.cwu != null) {
            if (z) {
                this.cwu.setVisibility(0);
            } else {
                this.cwu.setVisibility(8);
            }
        }
    }

    private void aqz() {
        this.cwu.setGifIconSupport(false);
        this.cwu.setVisibility(8);
    }

    public void fu(boolean z) {
        if (this.cwt != null) {
            if (z) {
                ay.c(this.cwt, com.baidu.tieba.p.icon_news_down_bar_one);
                this.cwt.setVisibility(0);
                return;
            }
            this.cwt.setImageDrawable(null);
            this.cwt.setVisibility(8);
        }
    }

    public void fv(boolean z) {
        if (this.cwv != null) {
            if (z) {
                ay.c(this.cwv, com.baidu.tieba.p.icon_news_down_bar_one);
                this.cwv.setVisibility(0);
                return;
            }
            this.cwv.setImageDrawable(null);
            this.cwv.setVisibility(8);
        }
    }

    public void jN(String str) {
        if (this.bWm != null && !StringUtils.isNull(str)) {
            this.bWm.setVisibility(0);
            this.bWm.c(str, 25, false);
        }
    }

    public void jO(String str) {
        if (this.cwu != null) {
            if (!StringUtils.isNull(str)) {
                this.cwu.c(str, 21, false);
            } else {
                this.cwu.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.cww != null) {
            if (i == 1) {
                this.cww.setVisibility(0);
                this.cww.setImageResource(com.baidu.tieba.p.icon_pop_boy);
            } else if (i == 2) {
                this.cww.setVisibility(0);
                this.cww.setImageResource(com.baidu.tieba.p.icon_pop_girl);
            } else {
                this.cww.setVisibility(8);
            }
        }
    }

    public void setUserName(String str) {
        if (this.bHV != null) {
            this.bHV.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.cwx != null) {
            this.cwx.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.cwy;
    }

    public TextView getDayNightView() {
        return this.cwz;
    }

    public void setDayNightViewText(String str) {
        if (this.cwz != null) {
            this.cwz.setText(str);
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        this.bWm.setIsNight(z);
        if (this.cwt.getVisibility() == 0) {
            ay.c(this.cwt, com.baidu.tieba.p.icon_news_down_bar_one);
        }
        if (this.cwu.getVisibility() == 0) {
            this.cwu.setIsNight(z);
        }
        if (this.cww.getVisibility() == 0) {
            this.cww.setIsNight(z);
        }
        if (this.cwv.getVisibility() == 0) {
            ay.c(this.cwv, com.baidu.tieba.p.icon_news_down_bar_one);
        }
    }
}
