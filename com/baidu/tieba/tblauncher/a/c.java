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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.p;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private HeadImageView bLd;
    private TextView bzz;
    private ImageView cdB;
    private TbImageView cdC;
    private ImageView cdD;
    private TbImageView cdE;
    private ListView cdF;
    private TextView cdG;
    private TextView cdH;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }

    private void initUI() {
        com.baidu.adp.lib.g.b.ei().a(getContext(), x.main_tab_left_navigation, this, true);
        setOrientation(1);
        this.bLd = (HeadImageView) findViewById(w.user_head);
        this.cdB = (ImageView) findViewById(w.user_head_red_tip);
        this.cdC = (TbImageView) findViewById(w.user_vip_icon);
        this.cdD = (ImageView) findViewById(w.left_navi_setting_red_tip);
        this.bzz = (TextView) findViewById(w.user_name);
        this.cdE = (TbImageView) findViewById(w.user_sex);
        this.cdF = (ListView) findViewById(w.left_navi_listview);
        this.cdG = (TextView) findViewById(w.left_navi_setting);
        this.cdH = (TextView) findViewById(w.left_navi_daynight);
        abH();
        ajB();
    }

    public void setOnSettingViewClicked(View.OnClickListener onClickListener) {
        if (this.cdG != null) {
            this.cdG.setOnClickListener(onClickListener);
        }
    }

    public void setOnDayNightModeViewClicked(View.OnClickListener onClickListener) {
        if (this.cdH != null) {
            this.cdH.setOnClickListener(onClickListener);
        }
    }

    public void setOnVipIconLoadListener(p pVar) {
        if (this.cdC != null) {
            this.cdC.setEvent(pVar);
        }
    }

    public void setOnPersonInfoViewClicked(View.OnClickListener onClickListener) {
        if (this.bLd != null) {
            this.bLd.setOnClickListener(onClickListener);
        }
        if (this.bzz != null) {
            this.bzz.setOnClickListener(onClickListener);
        }
    }

    public void setOnListItemClicked(AdapterView.OnItemClickListener onItemClickListener) {
        if (this.cdF != null) {
            this.cdF.setOnItemClickListener(onItemClickListener);
        }
    }

    private void abH() {
        if (this.bLd != null) {
            this.bLd.setIsRound(true);
            this.bLd.setDefaultBgResource(0);
            this.bLd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bLd.setDefaultResource(v.pic_mycenter_avatar_def);
        }
    }

    public TbImageView getUserHeadView() {
        return this.bLd;
    }

    public void eL(boolean z) {
        if (this.cdC != null) {
            if (z) {
                this.cdC.setVisibility(0);
            } else {
                this.cdC.setVisibility(8);
            }
        }
    }

    private void ajB() {
        this.cdC.setGifIconSupport(false);
        this.cdC.setSupportNoImage(false);
        this.cdC.setVisibility(8);
    }

    public void eM(boolean z) {
        if (this.cdB != null) {
            if (z) {
                bc.c(this.cdB, v.icon_news_down_bar_one);
                this.cdB.setVisibility(0);
                return;
            }
            this.cdB.setImageDrawable(null);
            this.cdB.setVisibility(8);
        }
    }

    public void eN(boolean z) {
        if (this.cdD != null) {
            if (z) {
                bc.c(this.cdD, v.icon_news_down_bar_one);
                this.cdD.setVisibility(0);
                return;
            }
            this.cdD.setImageDrawable(null);
            this.cdD.setVisibility(8);
        }
    }

    public void iy(String str) {
        if (this.bLd != null) {
            if (!StringUtils.isNull(str)) {
                this.bLd.setVisibility(0);
                this.bLd.d(str, 25, false);
                return;
            }
            this.bLd.setVisibility(8);
        }
    }

    public void iz(String str) {
        if (this.cdC != null) {
            if (!StringUtils.isNull(str)) {
                this.cdC.d(str, 21, false);
            } else {
                this.cdC.setVisibility(8);
            }
        }
    }

    public void setUserSexIcon(int i) {
        if (this.cdE != null) {
            if (i == 1) {
                this.cdE.setVisibility(0);
                this.cdE.setImageResource(v.icon_pop_boy);
            } else if (i == 2) {
                this.cdE.setVisibility(0);
                this.cdE.setImageResource(v.icon_pop_girl);
            } else {
                this.cdE.setVisibility(8);
            }
        }
    }

    public void setUserName(String str) {
        if (this.bzz != null) {
            this.bzz.setText(str);
        }
    }

    public void setListAdapter(BaseAdapter baseAdapter) {
        if (this.cdF != null) {
            this.cdF.setAdapter((ListAdapter) baseAdapter);
        }
    }

    public TextView getSettingView() {
        return this.cdG;
    }

    public TextView getDayNightView() {
        return this.cdH;
    }

    public void setDayNightViewText(String str) {
        if (this.cdH != null) {
            this.cdH.setText(str);
        }
    }

    public void c(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.g.a.a(tbPageContext, this);
        boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        this.bLd.setIsNight(z);
        if (this.cdB.getVisibility() == 0) {
            bc.c(this.cdB, v.icon_news_down_bar_one);
        }
        if (this.cdC.getVisibility() == 0) {
            this.cdC.setIsNight(z);
        }
        if (this.cdE.getVisibility() == 0) {
            this.cdE.setIsNight(z);
        }
        if (this.cdD.getVisibility() == 0) {
            bc.c(this.cdD, v.icon_news_down_bar_one);
        }
    }
}
