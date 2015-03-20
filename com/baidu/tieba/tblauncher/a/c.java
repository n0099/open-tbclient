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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private TextView bEM;
    private HeadImageView bTo;
    private ImageView crS;
    private TbImageView crT;
    private ImageView crU;
    private TbImageView crV;
    private ListView crW;
    private TextView crX;
    private TextView crY;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.hH().a(getContext(), w.main_tab_left_navigation, this, true);
        setOrientation(1);
        this.bTo = (HeadImageView) findViewById(v.user_head);
        this.crS = (ImageView) findViewById(v.user_head_red_tip);
        this.crT = (TbImageView) findViewById(v.user_vip_icon);
        this.crU = (ImageView) findViewById(v.left_navi_setting_red_tip);
        this.bEM = (TextView) findViewById(v.user_name);
        this.crV = (TbImageView) findViewById(v.user_sex);
        this.crW = (ListView) findViewById(v.left_navi_listview);
        this.crX = (TextView) findViewById(v.left_navi_setting);
        this.crY = (TextView) findViewById(v.left_navi_daynight);
        com.baidu.adp.lib.util.n.a(getContext(), this.crY, 15, 10, 10, 10);
        adV();
        aou();
        if (this.crY != null) {
            if (!Kv()) {
                TbadkCoreApplication.m411getInst().setSkinType(0);
                this.crY.setVisibility(8);
                return;
            }
            this.crY.setVisibility(0);
        }
    }

    public boolean Kv() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.crX != null) {
            this.crX.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.crY != null) {
            this.crY.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(com.baidu.tbadk.widget.n nVar) {
        if (this.crT != null) {
            this.crT.setEvent(nVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.bTo != null) {
            this.bTo.setOnClickListener(onClickListener);
        }
        if (this.bEM != null) {
            this.bEM.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.crW != null) {
            this.crW.setOnItemClickListener(onItemClickListener);
        }
    }

    private void adV() {
        if (this.bTo != null) {
            this.bTo.setIsRound(true);
            this.bTo.setDefaultBgResource(0);
            this.bTo.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bTo.setDefaultResource(u.pic_mycenter_avatar_def);
        }
    }

    public TbImageView getUserHeadView() {
        return this.bTo;
    }

    public void eZ(boolean z) {
        if (this.crT != null) {
            if (z) {
                this.crT.setVisibility(0);
            } else {
                this.crT.setVisibility(8);
            }
        }
    }

    private void aou() {
        this.crT.setGifIconSupport(false);
        this.crT.setVisibility(8);
    }

    public void fa(boolean z) {
        if (this.crS != null) {
            if (z) {
                ba.c(this.crS, u.icon_news_down_bar_one);
                this.crS.setVisibility(0);
                return;
            }
            this.crS.setImageDrawable(null);
            this.crS.setVisibility(8);
        }
    }

    public void fb(boolean z) {
        if (this.crU != null) {
            if (z) {
                ba.c(this.crU, u.icon_news_down_bar_one);
                this.crU.setVisibility(0);
                return;
            }
            this.crU.setImageDrawable(null);
            this.crU.setVisibility(8);
        }
    }

    public void iQ(String str) {
        if (this.bTo != null && !StringUtils.isNull(str)) {
            this.bTo.setVisibility(0);
            this.bTo.c(str, 25, false);
        }
    }

    public void iR(String str) {
        if (this.crT != null) {
            if (!StringUtils.isNull(str)) {
                this.crT.c(str, 21, false);
            } else {
                this.crT.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.crV != null) {
            if (i == 1) {
                this.crV.setVisibility(0);
                this.crV.setImageResource(u.icon_pop_boy);
            } else if (i == 2) {
                this.crV.setVisibility(0);
                this.crV.setImageResource(u.icon_pop_girl);
            } else {
                this.crV.setVisibility(8);
            }
        }
    }

    public void setUserName(String str) {
        if (this.bEM != null) {
            this.bEM.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.crW != null) {
            this.crW.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.crX;
    }

    public TextView getDayNightView() {
        return this.crY;
    }

    public void setDayNightViewText(String str) {
        if (this.crY != null) {
            this.crY.setText(str);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        this.bTo.setIsNight(z);
        if (this.crS.getVisibility() == 0) {
            ba.c(this.crS, u.icon_news_down_bar_one);
        }
        if (this.crT.getVisibility() == 0) {
            this.crT.setIsNight(z);
        }
        if (this.crV.getVisibility() == 0) {
            this.crV.setIsNight(z);
        }
        if (this.crU.getVisibility() == 0) {
            ba.c(this.crU, u.icon_news_down_bar_one);
        }
    }
}
